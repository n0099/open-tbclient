package com.baidu.n.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    private static e oKU;
    private volatile com.baidu.n.a.a.c oKR;
    private AtomicBoolean oKV = new AtomicBoolean(false);
    private AtomicBoolean oKW = new AtomicBoolean(false);
    private static String TAG = "UnionIDHelper";
    private static boolean DEBUG = com.baidu.n.a.a.egd();
    private static final String oKS = d(new byte[]{81, 72, 116, 79, 75, 72, 69, 52, 76, 51, 103, 61}, new byte[]{82, 51, 104, 90, 83, 122, 65, 105, Constants.SHORT_PING_CMD_TYPE, 49, 107, 61});
    private static final String oKT = d(new byte[]{76, 67, 77, 53, 77, 70, 90, 73, 81, 107, 107, 61}, new byte[]{90, 105, 108, 121, 79, 68, 100, 81, 86, 121, 89, 61});
    private static final Object sLock = new Object();

    private e() {
    }

    public static e egg() {
        if (oKU == null) {
            synchronized (e.class) {
                if (oKU == null) {
                    oKU = new e();
                }
            }
        }
        return oKU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egh() {
        this.oKR = this.oKR.egk();
        if (DEBUG) {
            Log.d(TAG, "asyncRequest, requestFromManufacturer done :" + this.oKR.getOAID());
        }
    }

    public synchronized void a(final Context context, @NonNull Looper looper, @Nullable com.baidu.n.a.a.b bVar) {
        if (looper == null) {
            throw new NullPointerException("param looper not null");
        }
        final a aVar = new a(looper, bVar);
        if (egi()) {
            aVar.obtainMessage(100, null).sendToTarget();
        } else if (this.oKR != null && this.oKW.get()) {
            if (DEBUG) {
                Log.d(TAG, "asyncRequest, mIUnionId.getOAID：" + this.oKR.getOAID());
                Log.d(TAG, "asyncRequest, mIUnionId.isTrackLimited：" + this.oKR.egl());
                Log.d(TAG, "asyncRequest, mIUnionId.getStatusCode：" + this.oKR.getStatusCode());
            }
            aVar.obtainMessage(100, this.oKR).sendToTarget();
        } else {
            if (!this.oKW.get()) {
                this.oKR = new c(context).oKR;
            }
            new Thread(new Runnable() { // from class: com.baidu.n.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    if (e.DEBUG) {
                        Log.d(e.TAG, "asyncRequest, Thread runn！");
                    }
                    com.baidu.n.a.a.a hq = e.this.hq(context);
                    if (e.DEBUG) {
                        Log.d(e.TAG, "asyncRequest, cachedBean == null ？" + (hq == null));
                    }
                    if (hq == null || e.this.a(hq)) {
                        if (e.DEBUG) {
                            Log.d(e.TAG, "asyncRequest, requestFromManufacturer");
                        }
                        e.this.egh();
                        if (e.DEBUG) {
                            Log.d(e.TAG, "asyncRequest, trySaveFiles！");
                        }
                        e.this.oKW.set(e.this.hp(context));
                        if (e.DEBUG) {
                            Log.d(e.TAG, "asyncRequest, trySaveFiles done");
                        }
                    }
                    if (e.DEBUG) {
                        Log.d(e.TAG, "asyncRequest, send  innerHandler message");
                    }
                    aVar.obtainMessage(100, e.this.oKR).sendToTarget();
                }
            }).start();
        }
    }

    private boolean a(com.baidu.n.a.a.a aVar, JSONObject jSONObject) {
        try {
            long optLong = jSONObject.optLong(new String(com.baidu.n.a.c.c.decode("dGltZQ==".getBytes())));
            aVar.time = optLong;
            if (DEBUG) {
                Log.d(TAG, "tryParseCacheJsonObject ，time：" + optLong);
                Log.d(TAG, "tryParseCacheJsonObject ，System.currentTimeMillis() - time：" + (System.currentTimeMillis() - optLong));
            }
            String str = new String(com.baidu.n.a.c.c.decode("dW5pb25JRG9iag==".getBytes()));
            if (DEBUG) {
                Log.d(TAG, "tryParseCacheJsonObject objKey：" + str);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            if (DEBUG) {
                Log.d(TAG, "tryParseCacheJsonObject ，jsonObject：" + optJSONObject);
            }
            if (optJSONObject != null) {
                String str2 = new String(com.baidu.n.a.c.c.decode("aXNUcmFja0xpbWl0ZWQ=".getBytes()));
                String str3 = new String(com.baidu.n.a.c.c.decode("aXNTdXBwb3J0".getBytes()));
                String str4 = new String(com.baidu.n.a.c.c.decode("c3RhdHVzY29kZQ==".getBytes()));
                String str5 = new String(com.baidu.n.a.c.c.decode("b2FpZA==".getBytes()));
                String str6 = new String(com.baidu.n.a.c.c.decode("YWFpZA==".getBytes()));
                String str7 = new String(com.baidu.n.a.c.c.decode("dmFpZA==".getBytes()));
                boolean optBoolean = optJSONObject.optBoolean(str2);
                boolean optBoolean2 = optJSONObject.optBoolean(str3);
                int optInt = optJSONObject.optInt(str4);
                String optString = optJSONObject.optString(str5);
                String optString2 = optJSONObject.optString(str6);
                String optString3 = optJSONObject.optString(str7);
                this.oKR.Al(optBoolean);
                this.oKR.Am(optBoolean2);
                this.oKR.MX(optInt);
                this.oKR.WN(optString);
                this.oKR.WO(optString2);
                this.oKR.WP(optString3);
                aVar.oLa = this.oKR;
                return true;
            }
            aVar.oLa = null;
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
    public boolean a(@NonNull com.baidu.n.a.a.a aVar) {
        if (Math.abs(System.currentTimeMillis() - aVar.time) > egj()) {
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
    public boolean hp(Context context) {
        try {
            if (this.oKR == null || TextUtils.isEmpty(this.oKR.getOAID())) {
                return false;
            }
            File file = new File(context.getFilesDir().getAbsolutePath() + "/bdunionid/");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, ".bd_un_info.so");
            String str = new String(com.baidu.n.a.c.c.decode("dGltZQ==".getBytes()));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str, System.currentTimeMillis());
            String str2 = new String(com.baidu.n.a.c.c.decode("dW5pb25JRG9iag==".getBytes()));
            JSONObject optJSONObject = jSONObject.optJSONObject(str2);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            String str3 = new String(com.baidu.n.a.c.c.decode("aXNUcmFja0xpbWl0ZWQ=".getBytes()));
            String str4 = new String(com.baidu.n.a.c.c.decode("aXNTdXBwb3J0".getBytes()));
            String str5 = new String(com.baidu.n.a.c.c.decode("c3RhdHVzY29kZQ==".getBytes()));
            String str6 = new String(com.baidu.n.a.c.c.decode("b2FpZA==".getBytes()));
            String str7 = new String(com.baidu.n.a.c.c.decode("YWFpZA==".getBytes()));
            String str8 = new String(com.baidu.n.a.c.c.decode("dmFpZA==".getBytes()));
            optJSONObject.put(str3, this.oKR.egl());
            optJSONObject.put(str4, this.oKR.isSupport());
            optJSONObject.put(str5, this.oKR.getStatusCode());
            optJSONObject.put(str6, this.oKR.getOAID());
            optJSONObject.put(str7, this.oKR.getAAID());
            optJSONObject.put(str8, this.oKR.getVAID());
            jSONObject.put(str2, optJSONObject);
            com.baidu.n.a.c.e.a(WL(jSONObject.toString()), file2, false, sLock);
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
    public com.baidu.n.a.a.a hq(Context context) {
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
        String a2 = com.baidu.n.a.c.e.a(file2, sLock);
        if (DEBUG) {
            Log.d(TAG, "getCacheObject ，content：" + a2);
        }
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        String WM = WM(a2);
        if (DEBUG) {
            Log.d(TAG, "getCacheObject ，json：" + WM);
        }
        try {
            JSONObject jSONObject = new JSONObject(WM);
            com.baidu.n.a.a.a aVar = new com.baidu.n.a.a.a();
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
            sb.append(new String(com.baidu.n.a.c.c.decode(bArr2)));
        }
        return sb.toString();
    }

    static String WL(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return com.baidu.n.a.c.c.encode(com.baidu.n.a.c.a.encrypt(oKS, oKT, str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException | Exception e) {
            return "";
        }
    }

    static String WM(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(com.baidu.n.a.c.a.decrypt(oKS, oKT, com.baidu.n.a.c.c.decode(str.getBytes())));
        } catch (Exception e) {
            if (DEBUG) {
                Log.d(TAG, "getCacheObject ，decryptUnionID：" + e.getMessage());
            }
            return "";
        }
    }

    /* loaded from: classes4.dex */
    private static class a extends Handler {
        private com.baidu.n.a.a.b oKZ;

        public a() {
        }

        public a(Looper looper, com.baidu.n.a.a.b bVar) {
            super(looper);
            this.oKZ = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 100:
                    com.baidu.n.a.a.c cVar = (com.baidu.n.a.a.c) message.obj;
                    if (e.DEBUG) {
                        Log.d(e.TAG, "handleMessage ，what：" + (cVar == null ? "" : cVar.getOAID()));
                    }
                    if (this.oKZ != null) {
                        this.oKZ.a(cVar);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private boolean egi() {
        return com.baidu.n.a.a.MV(b.ege());
    }

    private long egj() {
        return com.baidu.n.a.a.MW(b.ege()) * 60 * 1000;
    }
}
