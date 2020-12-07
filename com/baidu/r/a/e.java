package com.baidu.r.a;

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
/* loaded from: classes14.dex */
public class e {
    private static e oJn;
    private volatile com.baidu.r.a.a.c oJk;
    private AtomicBoolean oJo = new AtomicBoolean(false);
    private AtomicBoolean oJp = new AtomicBoolean(false);
    private static String TAG = "UnionIDHelper";
    private static boolean DEBUG = com.baidu.r.a.a.ejQ();
    private static final String oJl = d(new byte[]{81, 72, 116, 79, 75, 72, 69, 52, 76, 51, 103, 61}, new byte[]{82, 51, 104, 90, 83, 122, 65, 105, Constants.SHORT_PING_CMD_TYPE, 49, 107, 61});
    private static final String oJm = d(new byte[]{76, 67, 77, 53, 77, 70, 90, 73, 81, 107, 107, 61}, new byte[]{90, 105, 108, 121, 79, 68, 100, 81, 86, 121, 89, 61});
    private static final Object sLock = new Object();

    private e() {
    }

    public static e ejT() {
        if (oJn == null) {
            synchronized (e.class) {
                if (oJn == null) {
                    oJn = new e();
                }
            }
        }
        return oJn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ejU() {
        this.oJk = this.oJk.ejX();
        if (DEBUG) {
            Log.d(TAG, "asyncRequest, requestFromManufacturer done :" + this.oJk.getOAID());
        }
    }

    public synchronized void a(final Context context, @NonNull Looper looper, @Nullable com.baidu.r.a.a.b bVar) {
        if (looper == null) {
            throw new NullPointerException("param looper not null");
        }
        final a aVar = new a(looper, bVar);
        if (ejV()) {
            aVar.obtainMessage(100, null).sendToTarget();
        } else if (this.oJk != null && this.oJp.get()) {
            if (DEBUG) {
                Log.d(TAG, "asyncRequest, mIUnionId.getOAID：" + this.oJk.getOAID());
                Log.d(TAG, "asyncRequest, mIUnionId.isTrackLimited：" + this.oJk.ejY());
                Log.d(TAG, "asyncRequest, mIUnionId.getStatusCode：" + this.oJk.getStatusCode());
            }
            aVar.obtainMessage(100, this.oJk).sendToTarget();
        } else {
            if (!this.oJp.get()) {
                this.oJk = new c(context).oJk;
            }
            new Thread(new Runnable() { // from class: com.baidu.r.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    if (e.DEBUG) {
                        Log.d(e.TAG, "asyncRequest, Thread runn！");
                    }
                    com.baidu.r.a.a.a hd = e.this.hd(context);
                    if (e.DEBUG) {
                        Log.d(e.TAG, "asyncRequest, cachedBean == null ？" + (hd == null));
                    }
                    if (hd == null || e.this.a(hd)) {
                        if (e.DEBUG) {
                            Log.d(e.TAG, "asyncRequest, requestFromManufacturer");
                        }
                        e.this.ejU();
                        if (e.DEBUG) {
                            Log.d(e.TAG, "asyncRequest, trySaveFiles！");
                        }
                        e.this.oJp.set(e.this.hc(context));
                        if (e.DEBUG) {
                            Log.d(e.TAG, "asyncRequest, trySaveFiles done");
                        }
                    }
                    if (e.DEBUG) {
                        Log.d(e.TAG, "asyncRequest, send  innerHandler message");
                    }
                    aVar.obtainMessage(100, e.this.oJk).sendToTarget();
                }
            }).start();
        }
    }

    private boolean a(com.baidu.r.a.a.a aVar, JSONObject jSONObject) {
        try {
            long optLong = jSONObject.optLong(new String(com.baidu.r.a.c.c.decode("dGltZQ==".getBytes())));
            aVar.time = optLong;
            if (DEBUG) {
                Log.d(TAG, "tryParseCacheJsonObject ，time：" + optLong);
                Log.d(TAG, "tryParseCacheJsonObject ，System.currentTimeMillis() - time：" + (System.currentTimeMillis() - optLong));
            }
            String str = new String(com.baidu.r.a.c.c.decode("dW5pb25JRG9iag==".getBytes()));
            if (DEBUG) {
                Log.d(TAG, "tryParseCacheJsonObject objKey：" + str);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            if (DEBUG) {
                Log.d(TAG, "tryParseCacheJsonObject ，jsonObject：" + optJSONObject);
            }
            if (optJSONObject != null) {
                String str2 = new String(com.baidu.r.a.c.c.decode("aXNUcmFja0xpbWl0ZWQ=".getBytes()));
                String str3 = new String(com.baidu.r.a.c.c.decode("aXNTdXBwb3J0".getBytes()));
                String str4 = new String(com.baidu.r.a.c.c.decode("c3RhdHVzY29kZQ==".getBytes()));
                String str5 = new String(com.baidu.r.a.c.c.decode("b2FpZA==".getBytes()));
                String str6 = new String(com.baidu.r.a.c.c.decode("YWFpZA==".getBytes()));
                String str7 = new String(com.baidu.r.a.c.c.decode("dmFpZA==".getBytes()));
                boolean optBoolean = optJSONObject.optBoolean(str2);
                boolean optBoolean2 = optJSONObject.optBoolean(str3);
                int optInt = optJSONObject.optInt(str4);
                String optString = optJSONObject.optString(str5);
                String optString2 = optJSONObject.optString(str6);
                String optString3 = optJSONObject.optString(str7);
                this.oJk.Ao(optBoolean);
                this.oJk.Ap(optBoolean2);
                this.oJk.OP(optInt);
                this.oJk.Yn(optString);
                this.oJk.Yo(optString2);
                this.oJk.Yp(optString3);
                aVar.oJt = this.oJk;
                return true;
            }
            aVar.oJt = null;
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
    public boolean a(@NonNull com.baidu.r.a.a.a aVar) {
        if (Math.abs(System.currentTimeMillis() - aVar.time) > ejW()) {
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
    public boolean hc(Context context) {
        try {
            if (this.oJk == null || TextUtils.isEmpty(this.oJk.getOAID())) {
                return false;
            }
            File file = new File(context.getFilesDir().getAbsolutePath() + "/bdunionid/");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, ".bd_un_info.so");
            String str = new String(com.baidu.r.a.c.c.decode("dGltZQ==".getBytes()));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str, System.currentTimeMillis());
            String str2 = new String(com.baidu.r.a.c.c.decode("dW5pb25JRG9iag==".getBytes()));
            JSONObject optJSONObject = jSONObject.optJSONObject(str2);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            String str3 = new String(com.baidu.r.a.c.c.decode("aXNUcmFja0xpbWl0ZWQ=".getBytes()));
            String str4 = new String(com.baidu.r.a.c.c.decode("aXNTdXBwb3J0".getBytes()));
            String str5 = new String(com.baidu.r.a.c.c.decode("c3RhdHVzY29kZQ==".getBytes()));
            String str6 = new String(com.baidu.r.a.c.c.decode("b2FpZA==".getBytes()));
            String str7 = new String(com.baidu.r.a.c.c.decode("YWFpZA==".getBytes()));
            String str8 = new String(com.baidu.r.a.c.c.decode("dmFpZA==".getBytes()));
            optJSONObject.put(str3, this.oJk.ejY());
            optJSONObject.put(str4, this.oJk.isSupport());
            optJSONObject.put(str5, this.oJk.getStatusCode());
            optJSONObject.put(str6, this.oJk.getOAID());
            optJSONObject.put(str7, this.oJk.getAAID());
            optJSONObject.put(str8, this.oJk.getVAID());
            jSONObject.put(str2, optJSONObject);
            com.baidu.r.a.c.e.a(Yl(jSONObject.toString()), file2, false, sLock);
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
    public com.baidu.r.a.a.a hd(Context context) {
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
        String a2 = com.baidu.r.a.c.e.a(file2, sLock);
        if (DEBUG) {
            Log.d(TAG, "getCacheObject ，content：" + a2);
        }
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        String Ym = Ym(a2);
        if (DEBUG) {
            Log.d(TAG, "getCacheObject ，json：" + Ym);
        }
        try {
            JSONObject jSONObject = new JSONObject(Ym);
            com.baidu.r.a.a.a aVar = new com.baidu.r.a.a.a();
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
            sb.append(new String(com.baidu.r.a.c.c.decode(bArr2)));
        }
        return sb.toString();
    }

    static String Yl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return com.baidu.r.a.c.c.encode(com.baidu.r.a.c.a.encrypt(oJl, oJm, str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException | Exception e) {
            return "";
        }
    }

    static String Ym(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(com.baidu.r.a.c.a.decrypt(oJl, oJm, com.baidu.r.a.c.c.decode(str.getBytes())));
        } catch (Exception e) {
            if (DEBUG) {
                Log.d(TAG, "getCacheObject ，decryptUnionID：" + e.getMessage());
            }
            return "";
        }
    }

    /* loaded from: classes14.dex */
    private static class a extends Handler {
        private com.baidu.r.a.a.b oJs;

        public a() {
        }

        public a(Looper looper, com.baidu.r.a.a.b bVar) {
            super(looper);
            this.oJs = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 100:
                    com.baidu.r.a.a.c cVar = (com.baidu.r.a.a.c) message.obj;
                    if (e.DEBUG) {
                        Log.d(e.TAG, "handleMessage ，what：" + (cVar == null ? "" : cVar.getOAID()));
                    }
                    if (this.oJs != null) {
                        this.oJs.a(cVar);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private boolean ejV() {
        return com.baidu.r.a.a.ON(b.ejR());
    }

    private long ejW() {
        return com.baidu.r.a.a.OO(b.ejR()) * 60 * 1000;
    }
}
