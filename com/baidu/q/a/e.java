package com.baidu.q.a;

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
/* loaded from: classes10.dex */
public class e {
    private static e nhi;
    private volatile com.baidu.q.a.a.c nhf;
    private AtomicBoolean nhj = new AtomicBoolean(false);
    private AtomicBoolean nhk = new AtomicBoolean(false);
    private static String TAG = "UnionIDHelper";
    private static boolean DEBUG = com.baidu.q.a.a.dMO();
    private static final String nhg = d(new byte[]{81, 72, 116, 79, 75, 72, 69, 52, 76, 51, 103, 61}, new byte[]{82, 51, 104, 90, 83, 122, 65, 105, Constants.SHORT_PING_CMD_TYPE, 49, 107, 61});
    private static final String nhh = d(new byte[]{76, 67, 77, 53, 77, 70, 90, 73, 81, 107, 107, 61}, new byte[]{90, 105, 108, 121, 79, 68, 100, 81, 86, 121, 89, 61});
    private static final Object sLock = new Object();

    private e() {
    }

    public static e dMR() {
        if (nhi == null) {
            synchronized (e.class) {
                if (nhi == null) {
                    nhi = new e();
                }
            }
        }
        return nhi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMS() {
        this.nhf = this.nhf.dMV();
        if (DEBUG) {
            Log.d(TAG, "asyncRequest, requestFromManufacturer done :" + this.nhf.getOAID());
        }
    }

    public synchronized com.baidu.q.a.a.c ge(Context context) {
        com.baidu.q.a.a.c cVar = null;
        synchronized (this) {
            if (DEBUG) {
                Log.d(TAG, "syncRequest, isClosedByCC():" + dMT());
            }
            if (!dMT()) {
                if (DEBUG) {
                    Log.d(TAG, "syncRequest,  (mIUnionId == null):" + (this.nhf == null));
                }
                if (this.nhf == null) {
                    this.nhf = new c(context).nhf;
                }
                if (!(this.nhf instanceof com.baidu.q.a.b.b) && !this.nhj.get()) {
                    b(context, new Object());
                }
                if (DEBUG) {
                    Log.d(TAG, "syncRequest, (mIUnionId instanceof UnSupportedUnionID):" + (this.nhf instanceof com.baidu.q.a.b.b));
                }
                if (DEBUG) {
                    Log.d(TAG, "syncRequest, mIUnionId.getOAID：" + this.nhf.getOAID());
                    Log.d(TAG, "syncRequest, mIUnionId.isTrackLimited：" + this.nhf.dML());
                    Log.d(TAG, "syncRequest, mIUnionId.getStatusCode：" + this.nhf.getStatusCode());
                }
                if (this.nhf.getStatusCode() != -200) {
                    cVar = this.nhf;
                }
            }
        }
        return cVar;
    }

    public synchronized void a(final Context context, @NonNull Looper looper, @Nullable com.baidu.q.a.a.b bVar) {
        if (looper == null) {
            throw new NullPointerException("param looper not null");
        }
        final a aVar = new a(looper, bVar);
        if (dMT()) {
            aVar.obtainMessage(100, null).sendToTarget();
        } else if (this.nhf != null && this.nhk.get()) {
            if (DEBUG) {
                Log.d(TAG, "asyncRequest, mIUnionId.getOAID：" + this.nhf.getOAID());
                Log.d(TAG, "asyncRequest, mIUnionId.isTrackLimited：" + this.nhf.dML());
                Log.d(TAG, "asyncRequest, mIUnionId.getStatusCode：" + this.nhf.getStatusCode());
            }
            aVar.obtainMessage(100, this.nhf).sendToTarget();
        } else {
            if (!this.nhk.get()) {
                this.nhf = new c(context).nhf;
            }
            new Thread(new Runnable() { // from class: com.baidu.q.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    if (e.DEBUG) {
                        Log.d(e.TAG, "asyncRequest, Thread runn！");
                    }
                    com.baidu.q.a.a.a gg = e.this.gg(context);
                    if (e.DEBUG) {
                        Log.d(e.TAG, "asyncRequest, cachedBean == null ？" + (gg == null));
                    }
                    if (gg == null || e.this.a(gg)) {
                        if (e.DEBUG) {
                            Log.d(e.TAG, "asyncRequest, requestFromManufacturer");
                        }
                        e.this.dMS();
                        if (e.DEBUG) {
                            Log.d(e.TAG, "asyncRequest, trySaveFiles！");
                        }
                        e.this.nhk.set(e.this.gf(context));
                        if (e.DEBUG) {
                            Log.d(e.TAG, "asyncRequest, trySaveFiles done");
                        }
                    }
                    if (e.DEBUG) {
                        Log.d(e.TAG, "asyncRequest, send  innerHandler message");
                    }
                    aVar.obtainMessage(100, e.this.nhf).sendToTarget();
                }
            }).start();
        }
    }

    private void b(final Context context, final Object obj) {
        new Thread(new Runnable() { // from class: com.baidu.q.a.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.DEBUG) {
                    Log.d(e.TAG, "syncReadFromCache, thread runn:");
                }
                e.this.nhj.set(e.this.gg(context) != null);
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
            if (!this.nhj.get()) {
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

    private boolean a(com.baidu.q.a.a.a aVar, JSONObject jSONObject) {
        try {
            long optLong = jSONObject.optLong(new String(com.baidu.q.a.c.c.decode("dGltZQ==".getBytes())));
            aVar.time = optLong;
            if (DEBUG) {
                Log.d(TAG, "tryParseCacheJsonObject ，time：" + optLong);
                Log.d(TAG, "tryParseCacheJsonObject ，System.currentTimeMillis() - time：" + (System.currentTimeMillis() - optLong));
            }
            String str = new String(com.baidu.q.a.c.c.decode("dW5pb25JRG9iag==".getBytes()));
            if (DEBUG) {
                Log.d(TAG, "tryParseCacheJsonObject objKey：" + str);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            if (DEBUG) {
                Log.d(TAG, "tryParseCacheJsonObject ，jsonObject：" + optJSONObject);
            }
            if (optJSONObject != null) {
                String str2 = new String(com.baidu.q.a.c.c.decode("aXNUcmFja0xpbWl0ZWQ=".getBytes()));
                String str3 = new String(com.baidu.q.a.c.c.decode("aXNTdXBwb3J0".getBytes()));
                String str4 = new String(com.baidu.q.a.c.c.decode("c3RhdHVzY29kZQ==".getBytes()));
                String str5 = new String(com.baidu.q.a.c.c.decode("b2FpZA==".getBytes()));
                String str6 = new String(com.baidu.q.a.c.c.decode("YWFpZA==".getBytes()));
                String str7 = new String(com.baidu.q.a.c.c.decode("dmFpZA==".getBytes()));
                boolean optBoolean = optJSONObject.optBoolean(str2);
                boolean optBoolean2 = optJSONObject.optBoolean(str3);
                int optInt = optJSONObject.optInt(str4);
                String optString = optJSONObject.optString(str5);
                String optString2 = optJSONObject.optString(str6);
                String optString3 = optJSONObject.optString(str7);
                this.nhf.xK(optBoolean);
                this.nhf.xL(optBoolean2);
                this.nhf.KI(optInt);
                this.nhf.Ua(optString);
                this.nhf.Ub(optString2);
                this.nhf.Uc(optString3);
                aVar.nhp = this.nhf;
                return true;
            }
            aVar.nhp = null;
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
    public boolean a(@NonNull com.baidu.q.a.a.a aVar) {
        if (Math.abs(System.currentTimeMillis() - aVar.time) > dMU()) {
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
    public boolean gf(Context context) {
        try {
            if (this.nhf == null || TextUtils.isEmpty(this.nhf.getOAID())) {
                return false;
            }
            File file = new File(context.getFilesDir().getAbsolutePath() + "/bdunionid/");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, ".bd_un_info.so");
            String str = new String(com.baidu.q.a.c.c.decode("dGltZQ==".getBytes()));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str, System.currentTimeMillis());
            String str2 = new String(com.baidu.q.a.c.c.decode("dW5pb25JRG9iag==".getBytes()));
            JSONObject optJSONObject = jSONObject.optJSONObject(str2);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            String str3 = new String(com.baidu.q.a.c.c.decode("aXNUcmFja0xpbWl0ZWQ=".getBytes()));
            String str4 = new String(com.baidu.q.a.c.c.decode("aXNTdXBwb3J0".getBytes()));
            String str5 = new String(com.baidu.q.a.c.c.decode("c3RhdHVzY29kZQ==".getBytes()));
            String str6 = new String(com.baidu.q.a.c.c.decode("b2FpZA==".getBytes()));
            String str7 = new String(com.baidu.q.a.c.c.decode("YWFpZA==".getBytes()));
            String str8 = new String(com.baidu.q.a.c.c.decode("dmFpZA==".getBytes()));
            optJSONObject.put(str3, this.nhf.dML());
            optJSONObject.put(str4, this.nhf.isSupport());
            optJSONObject.put(str5, this.nhf.getStatusCode());
            optJSONObject.put(str6, this.nhf.getOAID());
            optJSONObject.put(str7, this.nhf.getAAID());
            optJSONObject.put(str8, this.nhf.getVAID());
            jSONObject.put(str2, optJSONObject);
            com.baidu.q.a.c.e.a(TY(jSONObject.toString()), file2, false, sLock);
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
    public com.baidu.q.a.a.a gg(Context context) {
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
        String a2 = com.baidu.q.a.c.e.a(file2, sLock);
        if (DEBUG) {
            Log.d(TAG, "getCacheObject ，content：" + a2);
        }
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        String TZ = TZ(a2);
        if (DEBUG) {
            Log.d(TAG, "getCacheObject ，json：" + TZ);
        }
        try {
            JSONObject jSONObject = new JSONObject(TZ);
            com.baidu.q.a.a.a aVar = new com.baidu.q.a.a.a();
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
            sb.append(new String(com.baidu.q.a.c.c.decode(bArr2)));
        }
        return sb.toString();
    }

    static String TY(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return com.baidu.q.a.c.c.encode(com.baidu.q.a.c.a.encrypt(nhg, nhh, str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException | Exception e) {
            return "";
        }
    }

    static String TZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(com.baidu.q.a.c.a.decrypt(nhg, nhh, com.baidu.q.a.c.c.decode(str.getBytes())));
        } catch (Exception e) {
            if (DEBUG) {
                Log.d(TAG, "getCacheObject ，decryptUnionID：" + e.getMessage());
            }
            return "";
        }
    }

    /* loaded from: classes10.dex */
    private static class a extends Handler {
        private com.baidu.q.a.a.b nho;

        public a() {
        }

        public a(Looper looper, com.baidu.q.a.a.b bVar) {
            super(looper);
            this.nho = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 100:
                    com.baidu.q.a.a.c cVar = (com.baidu.q.a.a.c) message.obj;
                    if (e.DEBUG) {
                        Log.d(e.TAG, "handleMessage ，what：" + (cVar == null ? "" : cVar.getOAID()));
                    }
                    if (this.nho != null) {
                        this.nho.a(cVar);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private boolean dMT() {
        return com.baidu.q.a.a.KG(b.dMP());
    }

    private long dMU() {
        return com.baidu.q.a.a.KH(b.dMP()) * 60 * 1000;
    }
}
