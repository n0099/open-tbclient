package com.baidu.m.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class e {
    private static e mOq;
    private volatile com.baidu.m.a.a.c mOn;
    private AtomicBoolean mOr = new AtomicBoolean(false);
    private AtomicBoolean mOs = new AtomicBoolean(false);
    private static String TAG = "UnionIDHelper";
    private static boolean DEBUG = com.baidu.m.a.a.dBa();
    private static final String mOo = d(new byte[]{81, 72, 116, 79, 75, 72, 69, 52, 76, 51, 103, 61}, new byte[]{82, 51, 104, 90, 83, 122, 65, 105, Constants.SHORT_PING_CMD_TYPE, 49, 107, 61});
    private static final String mOp = d(new byte[]{76, 67, 77, 53, 77, 70, 90, 73, 81, 107, 107, 61}, new byte[]{90, 105, 108, 121, 79, 68, 100, 81, 86, 121, 89, 61});
    private static final Object sLock = new Object();

    private e() {
    }

    public static e dBd() {
        if (mOq == null) {
            synchronized (e.class) {
                if (mOq == null) {
                    mOq = new e();
                }
            }
        }
        return mOq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBe() {
        this.mOn = this.mOn.dBh();
        if (DEBUG) {
            Log.d(TAG, "asyncRequest, requestFromManufacturer done :" + this.mOn.getOAID());
        }
    }

    public synchronized com.baidu.m.a.a.c fQ(Context context) {
        com.baidu.m.a.a.c cVar = null;
        synchronized (this) {
            if (DEBUG) {
                Log.d(TAG, "syncRequest, isClosedByCC():" + dBf());
            }
            if (!dBf()) {
                if (DEBUG) {
                    Log.d(TAG, "syncRequest,  (mIUnionId == null):" + (this.mOn == null));
                }
                if (this.mOn == null) {
                    this.mOn = new c(context).mOn;
                }
                if (!(this.mOn instanceof com.baidu.m.a.b.b) && !this.mOr.get()) {
                    b(context, new Object());
                }
                if (DEBUG) {
                    Log.d(TAG, "syncRequest, (mIUnionId instanceof UnSupportedUnionID):" + (this.mOn instanceof com.baidu.m.a.b.b));
                }
                if (DEBUG) {
                    Log.d(TAG, "syncRequest, mIUnionId.getOAID：" + this.mOn.getOAID());
                    Log.d(TAG, "syncRequest, mIUnionId.isTrackLimited：" + this.mOn.dAX());
                    Log.d(TAG, "syncRequest, mIUnionId.getStatusCode：" + this.mOn.getStatusCode());
                }
                if (this.mOn.getStatusCode() != -200) {
                    cVar = this.mOn;
                }
            }
        }
        return cVar;
    }

    public synchronized void a(final Context context, @NonNull Looper looper, @Nullable com.baidu.m.a.a.b bVar) {
        if (looper == null) {
            throw new NullPointerException("param looper not null");
        }
        final a aVar = new a(looper, bVar);
        if (dBf()) {
            aVar.obtainMessage(100, null).sendToTarget();
        } else if (this.mOn != null && this.mOs.get()) {
            if (DEBUG) {
                Log.d(TAG, "asyncRequest, mIUnionId.getOAID：" + this.mOn.getOAID());
                Log.d(TAG, "asyncRequest, mIUnionId.isTrackLimited：" + this.mOn.dAX());
                Log.d(TAG, "asyncRequest, mIUnionId.getStatusCode：" + this.mOn.getStatusCode());
            }
            aVar.obtainMessage(100, this.mOn).sendToTarget();
        } else {
            if (!this.mOs.get()) {
                this.mOn = new c(context).mOn;
            }
            new Thread(new Runnable() { // from class: com.baidu.m.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    if (e.DEBUG) {
                        Log.d(e.TAG, "asyncRequest, Thread runn！");
                    }
                    com.baidu.m.a.a.a fS = e.this.fS(context);
                    if (e.DEBUG) {
                        Log.d(e.TAG, "asyncRequest, cachedBean == null ？" + (fS == null));
                    }
                    if (fS == null || e.this.a(fS)) {
                        if (e.DEBUG) {
                            Log.d(e.TAG, "asyncRequest, requestFromManufacturer");
                        }
                        e.this.dBe();
                        if (e.DEBUG) {
                            Log.d(e.TAG, "asyncRequest, trySaveFiles！");
                        }
                        e.this.mOs.set(e.this.fR(context));
                        if (e.DEBUG) {
                            Log.d(e.TAG, "asyncRequest, trySaveFiles done");
                        }
                    }
                    if (e.DEBUG) {
                        Log.d(e.TAG, "asyncRequest, send  innerHandler message");
                    }
                    aVar.obtainMessage(100, e.this.mOn).sendToTarget();
                }
            }).start();
        }
    }

    private void b(final Context context, final Object obj) {
        new Thread(new Runnable() { // from class: com.baidu.m.a.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.DEBUG) {
                    Log.d(e.TAG, "syncReadFromCache, thread runn:");
                }
                e.this.mOr.set(e.this.fS(context) != null);
                if (e.DEBUG) {
                    Log.d(e.TAG, "syncReadFromCache, cachJsonObject done:");
                }
                synchronized (obj) {
                    if (e.DEBUG) {
                        Log.d(e.TAG, "syncReadFromCache, cachJsonObject notifyAll:");
                    }
                    obj.notifyAll();
                }
            }
        }).start();
        synchronized (obj) {
            if (!this.mOr.get()) {
                try {
                    if (DEBUG) {
                        Log.d(TAG, "syncReadFromCache, waiter:");
                    }
                    obj.wait(300L);
                    if (DEBUG) {
                        Log.d(TAG, "syncReadFromCache, waiter over:");
                    }
                } catch (InterruptedException e) {
                    if (DEBUG) {
                        Log.d(TAG, "syncReadFromCache, InterruptedException");
                    }
                }
            }
        }
    }

    private boolean a(com.baidu.m.a.a.a aVar, JSONObject jSONObject) {
        try {
            long optLong = jSONObject.optLong(new String(com.baidu.m.a.c.c.decode("dGltZQ==".getBytes())));
            aVar.time = optLong;
            if (DEBUG) {
                Log.d(TAG, "tryParseCacheJsonObject ，time：" + optLong);
                Log.d(TAG, "tryParseCacheJsonObject ，System.currentTimeMillis() - time：" + (System.currentTimeMillis() - optLong));
            }
            String str = new String(com.baidu.m.a.c.c.decode("dW5pb25JRG9iag==".getBytes()));
            if (DEBUG) {
                Log.d(TAG, "tryParseCacheJsonObject objKey：" + str);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            if (DEBUG) {
                Log.d(TAG, "tryParseCacheJsonObject ，jsonObject：" + optJSONObject);
            }
            if (optJSONObject != null) {
                String str2 = new String(com.baidu.m.a.c.c.decode("aXNUcmFja0xpbWl0ZWQ=".getBytes()));
                String str3 = new String(com.baidu.m.a.c.c.decode("aXNTdXBwb3J0".getBytes()));
                String str4 = new String(com.baidu.m.a.c.c.decode("c3RhdHVzY29kZQ==".getBytes()));
                String str5 = new String(com.baidu.m.a.c.c.decode("b2FpZA==".getBytes()));
                String str6 = new String(com.baidu.m.a.c.c.decode("YWFpZA==".getBytes()));
                String str7 = new String(com.baidu.m.a.c.c.decode("dmFpZA==".getBytes()));
                boolean optBoolean = optJSONObject.optBoolean(str2);
                boolean optBoolean2 = optJSONObject.optBoolean(str3);
                int optInt = optJSONObject.optInt(str4);
                String optString = optJSONObject.optString(str5);
                String optString2 = optJSONObject.optString(str6);
                String optString3 = optJSONObject.optString(str7);
                this.mOn.wU(optBoolean);
                this.mOn.wV(optBoolean2);
                this.mOn.Ii(optInt);
                this.mOn.Ra(optString);
                this.mOn.Rb(optString2);
                this.mOn.Rc(optString3);
                aVar.mOx = this.mOn;
                return true;
            }
            aVar.mOx = null;
            if (DEBUG) {
                Log.d(TAG, "tryParseCacheJsonObject return cause null：");
                return false;
            }
            return false;
        } catch (Exception e) {
            if (DEBUG) {
                Log.d(TAG, "tryParseCacheJsonObject ：" + e.getMessage());
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(@NonNull com.baidu.m.a.a.a aVar) {
        if (Math.abs(System.currentTimeMillis() - aVar.time) > dBg()) {
            if (DEBUG) {
                Log.d(TAG, "isExpireTime ：超过缓存有效期");
            }
            return true;
        }
        if (DEBUG) {
            Log.d(TAG, "isExpireTime ：没有超过缓存有效期");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fR(Context context) {
        try {
            if (this.mOn == null || TextUtils.isEmpty(this.mOn.getOAID())) {
                return false;
            }
            File file = new File(context.getFilesDir().getAbsolutePath() + "/bdunionid/");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, ".bd_un_info.so");
            String str = new String(com.baidu.m.a.c.c.decode("dGltZQ==".getBytes()));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str, System.currentTimeMillis());
            String str2 = new String(com.baidu.m.a.c.c.decode("dW5pb25JRG9iag==".getBytes()));
            JSONObject optJSONObject = jSONObject.optJSONObject(str2);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            String str3 = new String(com.baidu.m.a.c.c.decode("aXNUcmFja0xpbWl0ZWQ=".getBytes()));
            String str4 = new String(com.baidu.m.a.c.c.decode("aXNTdXBwb3J0".getBytes()));
            String str5 = new String(com.baidu.m.a.c.c.decode("c3RhdHVzY29kZQ==".getBytes()));
            String str6 = new String(com.baidu.m.a.c.c.decode("b2FpZA==".getBytes()));
            String str7 = new String(com.baidu.m.a.c.c.decode("YWFpZA==".getBytes()));
            String str8 = new String(com.baidu.m.a.c.c.decode("dmFpZA==".getBytes()));
            optJSONObject.put(str3, this.mOn.dAX());
            optJSONObject.put(str4, this.mOn.isSupport());
            optJSONObject.put(str5, this.mOn.getStatusCode());
            optJSONObject.put(str6, this.mOn.getOAID());
            optJSONObject.put(str7, this.mOn.getAAID());
            optJSONObject.put(str8, this.mOn.getVAID());
            jSONObject.put(str2, optJSONObject);
            com.baidu.m.a.c.e.a(QY(jSONObject.toString()), file2, false, sLock);
            if (DEBUG) {
                Log.d(TAG, "trySaveFiles, app: " + jSONObject.toString());
            }
            return true;
        } catch (Exception e) {
            if (DEBUG) {
                Log.d(TAG, "trySaveFiles, error " + e.getMessage());
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.m.a.a.a fS(Context context) {
        File file = new File(context.getFilesDir().getAbsolutePath() + "/bdunionid/");
        if (!file.exists()) {
            if (DEBUG) {
                Log.d(TAG, "getCacheObject dir 不存在 , 首次需要创建");
                return null;
            }
            return null;
        }
        File file2 = new File(file, ".bd_un_info.so");
        if (!file2.exists()) {
            if (DEBUG) {
                Log.d(TAG, "getCacheObject  file 不存在, 首次需要创建");
                return null;
            }
            return null;
        }
        String a2 = com.baidu.m.a.c.e.a(file2, sLock);
        if (DEBUG) {
            Log.d(TAG, "getCacheObject ，content：" + a2);
        }
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        String QZ = QZ(a2);
        if (DEBUG) {
            Log.d(TAG, "getCacheObject ，json：" + QZ);
        }
        try {
            JSONObject jSONObject = new JSONObject(QZ);
            com.baidu.m.a.a.a aVar = new com.baidu.m.a.a.a();
            a(aVar, jSONObject);
            return aVar;
        } catch (Exception e) {
            if (DEBUG) {
                Log.d(TAG, "getCacheObject , " + e.getMessage());
                return null;
            }
            return null;
        }
    }

    private static String d(byte[]... bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte[] bArr2 : bArr) {
            sb.append(new String(com.baidu.m.a.c.c.decode(bArr2)));
        }
        return sb.toString();
    }

    static String QY(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return com.baidu.m.a.c.c.encode(com.baidu.m.a.c.a.encrypt(mOo, mOp, str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException | Exception e) {
            return "";
        }
    }

    static String QZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(com.baidu.m.a.c.a.decrypt(mOo, mOp, com.baidu.m.a.c.c.decode(str.getBytes())));
        } catch (Exception e) {
            if (DEBUG) {
                Log.d(TAG, "getCacheObject ，decryptUnionID：" + e.getMessage());
            }
            return "";
        }
    }

    /* loaded from: classes12.dex */
    private static class a extends Handler {
        private com.baidu.m.a.a.b mOw;

        public a() {
        }

        public a(Looper looper, com.baidu.m.a.a.b bVar) {
            super(looper);
            this.mOw = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 100:
                    com.baidu.m.a.a.c cVar = (com.baidu.m.a.a.c) message.obj;
                    if (e.DEBUG) {
                        Log.d(e.TAG, "handleMessage ，what：" + (cVar == null ? "" : cVar.getOAID()));
                    }
                    if (this.mOw != null) {
                        this.mOw.a(cVar);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private boolean dBf() {
        return com.baidu.m.a.a.Ig(b.dBb());
    }

    private long dBg() {
        return com.baidu.m.a.a.Ih(b.dBb()) * 60 * 1000;
    }
}
