package com.baidu.ar.auth;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.ar.auth.k;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.h.s;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import com.baidu.mobstat.Config;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b implements k {
    public volatile IHttpRequest bR;
    public boolean jr;
    public String js;
    public String jt;
    public k.a ju;
    public int jv = 0;

    /* loaded from: classes.dex */
    public static final class a {
        public boolean jx;
        public JSONObject jy;
        public String jz;

        public a() {
        }
    }

    public b(f fVar) {
        this.jr = fVar.jI;
        this.js = fVar.jL;
        this.jt = fVar.jM;
    }

    private String S(String str) {
        String aPIKey = TextUtils.isEmpty(this.js) ? DuMixARConfig.getAPIKey() : this.jt;
        return com.baidu.ar.h.l.aU(str + aPIKey);
    }

    private String T(String str) {
        try {
            return URLEncoder.encode(str, IMAudioTransRequest.CHARSET);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    private void a(final IAuthCallback iAuthCallback) {
        if (this.bR == null) {
            return;
        }
        this.bR.enqueue(new com.baidu.ar.ihttp.a() { // from class: com.baidu.ar.auth.b.1
            @Override // com.baidu.ar.ihttp.a
            public void a(HttpException httpException) {
                b.this.b(iAuthCallback);
            }

            @Override // com.baidu.ar.ihttp.a
            public void a(IHttpResponse iHttpResponse) {
                try {
                    a b = b.this.b(iHttpResponse);
                    if (b.jx) {
                        b.this.e(b.jy);
                        if (iAuthCallback != null) {
                            iAuthCallback.onSuccess();
                        }
                    } else if (iAuthCallback != null) {
                        iAuthCallback.onError(b.jz, 0);
                    }
                } catch (Exception unused) {
                    b.this.b(iAuthCallback);
                }
            }
        });
    }

    private void a(StringBuilder sb, String str, String str2) {
        if (sb.length() > 0) {
            sb.append("&");
        }
        sb.append(str + "=" + T(str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a b(IHttpResponse iHttpResponse) {
        if (iHttpResponse == null || !iHttpResponse.isSuccess()) {
            throw new HttpException(4, "response fail");
        }
        JSONObject jSONObject = new JSONObject(iHttpResponse.getContent());
        if (jSONObject.has("errorNum")) {
            a aVar = new a();
            boolean z = jSONObject.getInt("errorNum") == 0;
            aVar.jx = z;
            if (z) {
                aVar.jy = jSONObject.optJSONObject("data");
            } else {
                aVar.jz = jSONObject.has("errorMsg") ? jSONObject.getString("errorMsg") : "";
            }
            return aVar;
        }
        throw new HttpException(4, "response format is error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(IAuthCallback iAuthCallback) {
        int i = this.jv + 1;
        this.jv = i;
        if (i > 5) {
            if (iAuthCallback != null) {
                iAuthCallback.onSuccess();
                return;
            }
            return;
        }
        com.baidu.ar.h.b.b("ARAuth", "retry " + this.jv + " at " + System.currentTimeMillis());
        try {
            Thread.currentThread();
            Thread.sleep(this.jv * 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a(iAuthCallback);
    }

    private String cw() {
        String str = Build.CPU_ABI;
        if (Build.VERSION.SDK_INT >= 21) {
            str = Arrays.asList(Build.SUPPORTED_ABIS).toString();
        }
        String uuid = new UUID(("182020" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (str.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10)).hashCode(), -335774081).toString();
        String valueOf = !TextUtils.isEmpty(Build.MANUFACTURER) ? String.valueOf(Build.MANUFACTURER.charAt(0)) : ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
        return valueOf + uuid.replace("-", "").toUpperCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(JSONObject jSONObject) {
        if (this.ju == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        if (jSONObject == null || !jSONObject.has("features")) {
            hashSet.addAll(FeatureCodes.getAll());
        } else {
            JSONArray optJSONArray = jSONObject.optJSONArray("features");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    hashSet.add(Integer.valueOf(optJSONArray.optInt(i)));
                }
            }
        }
        this.ju.a(hashSet);
    }

    private String i(Context context) {
        UUID gz = new com.baidu.ar.h.g(context).gz();
        String uuid = gz == null ? "" : gz.toString();
        StringBuilder sb = new StringBuilder();
        String gx = com.baidu.ar.h.c.gx();
        a(sb, "app_id", TextUtils.isEmpty(this.js) ? DuMixARConfig.getAipAppId() : this.js);
        a(sb, Constants.PHONE_BRAND, Build.BRAND);
        a(sb, Config.DEVICE_PART, Build.DEVICE);
        a(sb, "dumix_type", gx);
        a(sb, "fr", "-1");
        a(sb, HttpConstants.HTTP_MANUFACTURER, Build.MANUFACTURER);
        a(sb, "model", Build.MODEL);
        a(sb, "os_type", "android");
        a(sb, "serial_num", j(context));
        a(sb, "timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        a(sb, "user_id", uuid);
        a(sb, "sign", S(sb.toString()));
        return sb.toString();
    }

    private String j(Context context) {
        int i = Build.VERSION.SDK_INT;
        String cw = i > 28 ? cw() : (i <= 27 || context.checkSelfPermission(com.kuaishou.weapon.p0.h.c) != 0) ? Build.SERIAL : Build.getSerial();
        return "unknown".equals(cw) ? "" : cw;
    }

    @Override // com.baidu.ar.auth.k
    public void a(k.a aVar) {
        this.ju = aVar;
    }

    @Override // com.baidu.ar.auth.k
    public void doAuth(Context context, IAuthCallback iAuthCallback) {
        this.bR = HttpFactory.newRequest();
        if (this.bR == null) {
            return;
        }
        long[] a2 = m.a(10, 50L);
        if (a2[0] == 1) {
            String gP = s.gP();
            this.bR.setMethod("POST").setUrl(gP).addHeader("Content-Type: application/x-www-form-urlencoded").setBody(i(context));
            a(iAuthCallback);
            return;
        }
        com.baidu.ar.h.b.b("ARAuth", "time err. " + a2[1]);
        if (iAuthCallback != null) {
            iAuthCallback.onSuccess();
        }
    }
}
