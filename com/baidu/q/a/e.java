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
    private static e nhA;
    private AtomicBoolean nhB = new AtomicBoolean(false);
    private AtomicBoolean nhC = new AtomicBoolean(false);
    private volatile com.baidu.q.a.a.c nhx;
    private static String TAG = "UnionIDHelper";
    private static boolean DEBUG = com.baidu.q.a.a.dMX();
    private static final String nhy = d(new byte[]{81, 72, 116, 79, 75, 72, 69, 52, 76, 51, 103, 61}, new byte[]{82, 51, 104, 90, 83, 122, 65, 105, Constants.SHORT_PING_CMD_TYPE, 49, 107, 61});
    private static final String nhz = d(new byte[]{76, 67, 77, 53, 77, 70, 90, 73, 81, 107, 107, 61}, new byte[]{90, 105, 108, 121, 79, 68, 100, 81, 86, 121, 89, 61});
    private static final Object sLock = new Object();

    private e() {
    }

    public static e dNa() {
        if (nhA == null) {
            synchronized (e.class) {
                if (nhA == null) {
                    nhA = new e();
                }
            }
        }
        return nhA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNb() {
        this.nhx = this.nhx.dNe();
        if (DEBUG) {
            Log.d(TAG, "asyncRequest, requestFromManufacturer done :" + this.nhx.getOAID());
        }
    }

    public synchronized com.baidu.q.a.a.c ge(Context context) {
        com.baidu.q.a.a.c cVar = null;
        synchronized (this) {
            if (DEBUG) {
                Log.d(TAG, "syncRequest, isClosedByCC():" + dNc());
            }
            if (!dNc()) {
                if (DEBUG) {
                    Log.d(TAG, "syncRequest,  (mIUnionId == null):" + (this.nhx == null));
                }
                if (this.nhx == null) {
                    this.nhx = new c(context).nhx;
                }
                if (!(this.nhx instanceof com.baidu.q.a.b.b) && !this.nhB.get()) {
                    b(context, new Object());
                }
                if (DEBUG) {
                    Log.d(TAG, "syncRequest, (mIUnionId instanceof UnSupportedUnionID):" + (this.nhx instanceof com.baidu.q.a.b.b));
                }
                if (DEBUG) {
                    Log.d(TAG, "syncRequest, mIUnionId.getOAID：" + this.nhx.getOAID());
                    Log.d(TAG, "syncRequest, mIUnionId.isTrackLimited：" + this.nhx.dMU());
                    Log.d(TAG, "syncRequest, mIUnionId.getStatusCode：" + this.nhx.getStatusCode());
                }
                if (this.nhx.getStatusCode() != -200) {
                    cVar = this.nhx;
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
        if (dNc()) {
            aVar.obtainMessage(100, null).sendToTarget();
        } else if (this.nhx != null && this.nhC.get()) {
            if (DEBUG) {
                Log.d(TAG, "asyncRequest, mIUnionId.getOAID：" + this.nhx.getOAID());
                Log.d(TAG, "asyncRequest, mIUnionId.isTrackLimited：" + this.nhx.dMU());
                Log.d(TAG, "asyncRequest, mIUnionId.getStatusCode：" + this.nhx.getStatusCode());
            }
            aVar.obtainMessage(100, this.nhx).sendToTarget();
        } else {
            if (!this.nhC.get()) {
                this.nhx = new c(context).nhx;
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
                        e.this.dNb();
                        if (e.DEBUG) {
                            Log.d(e.TAG, "asyncRequest, trySaveFiles！");
                        }
                        e.this.nhC.set(e.this.gf(context));
                        if (e.DEBUG) {
                            Log.d(e.TAG, "asyncRequest, trySaveFiles done");
                        }
                    }
                    if (e.DEBUG) {
                        Log.d(e.TAG, "asyncRequest, send  innerHandler message");
                    }
                    aVar.obtainMessage(100, e.this.nhx).sendToTarget();
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
                e.this.nhB.set(e.this.gg(context) != null);
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
            if (!this.nhB.get()) {
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
                this.nhx.xM(optBoolean);
                this.nhx.xN(optBoolean2);
                this.nhx.KI(optInt);
                this.nhx.Ua(optString);
                this.nhx.Ub(optString2);
                this.nhx.Uc(optString3);
                aVar.nhH = this.nhx;
                return true;
            }
            aVar.nhH = null;
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
        if (Math.abs(System.currentTimeMillis() - aVar.time) > dNd()) {
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
            if (this.nhx == null || TextUtils.isEmpty(this.nhx.getOAID())) {
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
            optJSONObject.put(str3, this.nhx.dMU());
            optJSONObject.put(str4, this.nhx.isSupport());
            optJSONObject.put(str5, this.nhx.getStatusCode());
            optJSONObject.put(str6, this.nhx.getOAID());
            optJSONObject.put(str7, this.nhx.getAAID());
            optJSONObject.put(str8, this.nhx.getVAID());
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
            return com.baidu.q.a.c.c.encode(com.baidu.q.a.c.a.encrypt(nhy, nhz, str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException | Exception e) {
            return "";
        }
    }

    static String TZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(com.baidu.q.a.c.a.decrypt(nhy, nhz, com.baidu.q.a.c.c.decode(str.getBytes())));
        } catch (Exception e) {
            if (DEBUG) {
                Log.d(TAG, "getCacheObject ，decryptUnionID：" + e.getMessage());
            }
            return "";
        }
    }

    /* loaded from: classes10.dex */
    private static class a extends Handler {
        private com.baidu.q.a.a.b nhG;

        public a() {
        }

        public a(Looper looper, com.baidu.q.a.a.b bVar) {
            super(looper);
            this.nhG = bVar;
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
                    if (this.nhG != null) {
                        this.nhG.a(cVar);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private boolean dNc() {
        return com.baidu.q.a.a.KG(b.dMY());
    }

    private long dNd() {
        return com.baidu.q.a.a.KH(b.dMY()) * 60 * 1000;
    }
}
