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
    private static e oJp;
    private volatile com.baidu.r.a.a.c oJm;
    private AtomicBoolean oJq = new AtomicBoolean(false);
    private AtomicBoolean oJr = new AtomicBoolean(false);
    private static String TAG = "UnionIDHelper";
    private static boolean DEBUG = com.baidu.r.a.a.ejR();
    private static final String oJn = d(new byte[]{81, 72, 116, 79, 75, 72, 69, 52, 76, 51, 103, 61}, new byte[]{82, 51, 104, 90, 83, 122, 65, 105, Constants.SHORT_PING_CMD_TYPE, 49, 107, 61});
    private static final String oJo = d(new byte[]{76, 67, 77, 53, 77, 70, 90, 73, 81, 107, 107, 61}, new byte[]{90, 105, 108, 121, 79, 68, 100, 81, 86, 121, 89, 61});
    private static final Object sLock = new Object();

    private e() {
    }

    public static e ejU() {
        if (oJp == null) {
            synchronized (e.class) {
                if (oJp == null) {
                    oJp = new e();
                }
            }
        }
        return oJp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ejV() {
        this.oJm = this.oJm.ejY();
        if (DEBUG) {
            Log.d(TAG, "asyncRequest, requestFromManufacturer done :" + this.oJm.getOAID());
        }
    }

    public synchronized void a(final Context context, @NonNull Looper looper, @Nullable com.baidu.r.a.a.b bVar) {
        if (looper == null) {
            throw new NullPointerException("param looper not null");
        }
        final a aVar = new a(looper, bVar);
        if (ejW()) {
            aVar.obtainMessage(100, null).sendToTarget();
        } else if (this.oJm != null && this.oJr.get()) {
            if (DEBUG) {
                Log.d(TAG, "asyncRequest, mIUnionId.getOAID：" + this.oJm.getOAID());
                Log.d(TAG, "asyncRequest, mIUnionId.isTrackLimited：" + this.oJm.ejZ());
                Log.d(TAG, "asyncRequest, mIUnionId.getStatusCode：" + this.oJm.getStatusCode());
            }
            aVar.obtainMessage(100, this.oJm).sendToTarget();
        } else {
            if (!this.oJr.get()) {
                this.oJm = new c(context).oJm;
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
                        e.this.ejV();
                        if (e.DEBUG) {
                            Log.d(e.TAG, "asyncRequest, trySaveFiles！");
                        }
                        e.this.oJr.set(e.this.hc(context));
                        if (e.DEBUG) {
                            Log.d(e.TAG, "asyncRequest, trySaveFiles done");
                        }
                    }
                    if (e.DEBUG) {
                        Log.d(e.TAG, "asyncRequest, send  innerHandler message");
                    }
                    aVar.obtainMessage(100, e.this.oJm).sendToTarget();
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
                this.oJm.Ao(optBoolean);
                this.oJm.Ap(optBoolean2);
                this.oJm.OP(optInt);
                this.oJm.Yn(optString);
                this.oJm.Yo(optString2);
                this.oJm.Yp(optString3);
                aVar.oJv = this.oJm;
                return true;
            }
            aVar.oJv = null;
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
        if (Math.abs(System.currentTimeMillis() - aVar.time) > ejX()) {
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
            if (this.oJm == null || TextUtils.isEmpty(this.oJm.getOAID())) {
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
            optJSONObject.put(str3, this.oJm.ejZ());
            optJSONObject.put(str4, this.oJm.isSupport());
            optJSONObject.put(str5, this.oJm.getStatusCode());
            optJSONObject.put(str6, this.oJm.getOAID());
            optJSONObject.put(str7, this.oJm.getAAID());
            optJSONObject.put(str8, this.oJm.getVAID());
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
            return com.baidu.r.a.c.c.encode(com.baidu.r.a.c.a.encrypt(oJn, oJo, str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException | Exception e) {
            return "";
        }
    }

    static String Ym(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(com.baidu.r.a.c.a.decrypt(oJn, oJo, com.baidu.r.a.c.c.decode(str.getBytes())));
        } catch (Exception e) {
            if (DEBUG) {
                Log.d(TAG, "getCacheObject ，decryptUnionID：" + e.getMessage());
            }
            return "";
        }
    }

    /* loaded from: classes14.dex */
    private static class a extends Handler {
        private com.baidu.r.a.a.b oJu;

        public a() {
        }

        public a(Looper looper, com.baidu.r.a.a.b bVar) {
            super(looper);
            this.oJu = bVar;
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
                    if (this.oJu != null) {
                        this.oJu.a(cVar);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private boolean ejW() {
        return com.baidu.r.a.a.ON(b.ejS());
    }

    private long ejX() {
        return com.baidu.r.a.a.OO(b.ejS()) * 60 * 1000;
    }
}
