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
/* loaded from: classes6.dex */
public class e {
    private static e oVB;
    private AtomicBoolean oVC = new AtomicBoolean(false);
    private AtomicBoolean oVD = new AtomicBoolean(false);
    private volatile com.baidu.n.a.a.c oVy;
    private static String TAG = "UnionIDHelper";
    private static boolean DEBUG = com.baidu.n.a.a.eiD();
    private static final String oVz = d(new byte[]{81, 72, 116, 79, 75, 72, 69, 52, 76, 51, 103, 61}, new byte[]{82, 51, 104, 90, 83, 122, 65, 105, Constants.SHORT_PING_CMD_TYPE, 49, 107, 61});
    private static final String oVA = d(new byte[]{76, 67, 77, 53, 77, 70, 90, 73, 81, 107, 107, 61}, new byte[]{90, 105, 108, 121, 79, 68, 100, 81, 86, 121, 89, 61});
    private static final Object sLock = new Object();

    private e() {
    }

    public static e eiG() {
        if (oVB == null) {
            synchronized (e.class) {
                if (oVB == null) {
                    oVB = new e();
                }
            }
        }
        return oVB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eiH() {
        this.oVy = this.oVy.eiK();
        if (DEBUG) {
            Log.d(TAG, "asyncRequest, requestFromManufacturer done :" + this.oVy.getOAID());
        }
    }

    public synchronized void a(final Context context, @NonNull Looper looper, @Nullable com.baidu.n.a.a.b bVar) {
        if (looper == null) {
            throw new NullPointerException("param looper not null");
        }
        final a aVar = new a(looper, bVar);
        if (eiI()) {
            aVar.obtainMessage(100, null).sendToTarget();
        } else if (this.oVy != null && this.oVD.get()) {
            if (DEBUG) {
                Log.d(TAG, "asyncRequest, mIUnionId.getOAID：" + this.oVy.getOAID());
                Log.d(TAG, "asyncRequest, mIUnionId.isTrackLimited：" + this.oVy.eiL());
                Log.d(TAG, "asyncRequest, mIUnionId.getStatusCode：" + this.oVy.getStatusCode());
            }
            aVar.obtainMessage(100, this.oVy).sendToTarget();
        } else {
            if (!this.oVD.get()) {
                this.oVy = new c(context).oVy;
            }
            new Thread(new Runnable() { // from class: com.baidu.n.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    if (e.DEBUG) {
                        Log.d(e.TAG, "asyncRequest, Thread runn！");
                    }
                    com.baidu.n.a.a.a ht = e.this.ht(context);
                    if (e.DEBUG) {
                        Log.d(e.TAG, "asyncRequest, cachedBean == null ？" + (ht == null));
                    }
                    if (ht == null || e.this.a(ht)) {
                        if (e.DEBUG) {
                            Log.d(e.TAG, "asyncRequest, requestFromManufacturer");
                        }
                        e.this.eiH();
                        if (e.DEBUG) {
                            Log.d(e.TAG, "asyncRequest, trySaveFiles！");
                        }
                        e.this.oVD.set(e.this.hs(context));
                        if (e.DEBUG) {
                            Log.d(e.TAG, "asyncRequest, trySaveFiles done");
                        }
                    }
                    if (e.DEBUG) {
                        Log.d(e.TAG, "asyncRequest, send  innerHandler message");
                    }
                    aVar.obtainMessage(100, e.this.oVy).sendToTarget();
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
                this.oVy.AE(optBoolean);
                this.oVy.AF(optBoolean2);
                this.oVy.Nu(optInt);
                this.oVy.XZ(optString);
                this.oVy.Ya(optString2);
                this.oVy.Yb(optString3);
                aVar.oVH = this.oVy;
                return true;
            }
            aVar.oVH = null;
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
        if (Math.abs(System.currentTimeMillis() - aVar.time) > eiJ()) {
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
    public boolean hs(Context context) {
        try {
            if (this.oVy == null || TextUtils.isEmpty(this.oVy.getOAID())) {
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
            optJSONObject.put(str3, this.oVy.eiL());
            optJSONObject.put(str4, this.oVy.isSupport());
            optJSONObject.put(str5, this.oVy.getStatusCode());
            optJSONObject.put(str6, this.oVy.getOAID());
            optJSONObject.put(str7, this.oVy.getAAID());
            optJSONObject.put(str8, this.oVy.getVAID());
            jSONObject.put(str2, optJSONObject);
            com.baidu.n.a.c.e.a(XX(jSONObject.toString()), file2, false, sLock);
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
    public com.baidu.n.a.a.a ht(Context context) {
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
        String XY = XY(a2);
        if (DEBUG) {
            Log.d(TAG, "getCacheObject ，json：" + XY);
        }
        try {
            JSONObject jSONObject = new JSONObject(XY);
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

    static String XX(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return com.baidu.n.a.c.c.encode(com.baidu.n.a.c.a.encrypt(oVz, oVA, str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException | Exception e) {
            return "";
        }
    }

    static String XY(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(com.baidu.n.a.c.a.decrypt(oVz, oVA, com.baidu.n.a.c.c.decode(str.getBytes())));
        } catch (Exception e) {
            if (DEBUG) {
                Log.d(TAG, "getCacheObject ，decryptUnionID：" + e.getMessage());
            }
            return "";
        }
    }

    /* loaded from: classes6.dex */
    private static class a extends Handler {
        private com.baidu.n.a.a.b oVG;

        public a() {
        }

        public a(Looper looper, com.baidu.n.a.a.b bVar) {
            super(looper);
            this.oVG = bVar;
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
                    if (this.oVG != null) {
                        this.oVG.a(cVar);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private boolean eiI() {
        return com.baidu.n.a.a.Ns(b.eiE());
    }

    private long eiJ() {
        return com.baidu.n.a.a.Nt(b.eiE()) * 60 * 1000;
    }
}
