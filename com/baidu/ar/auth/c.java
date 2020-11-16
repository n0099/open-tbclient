package com.baidu.ar.auth;

import android.content.Context;
import android.os.Build;
import android.support.media.ExifInterface;
import android.text.TextUtils;
import com.baidu.ar.auth.m;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.g.s;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobstat.Config;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes12.dex */
class c implements m {
    private volatile IHttpRequest bO;
    private boolean jc;
    private String jd;
    private String je;
    private m.a jf;
    private int jg = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static final class a {
        boolean ji;
        JSONObject jj;
        String jk;

        private a() {
        }
    }

    public c(g gVar) {
        this.jc = gVar.jt;
        this.jd = gVar.jw;
        this.je = gVar.jx;
    }

    private String P(String str) {
        return com.baidu.ar.g.l.aR(str + (TextUtils.isEmpty(this.jd) ? DuMixARConfig.getAPIKey() : this.je));
    }

    private String Q(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    private void a(final k kVar) {
        if (this.bO == null) {
            return;
        }
        this.bO.enqueue(new com.baidu.ar.ihttp.a() { // from class: com.baidu.ar.auth.c.1
            @Override // com.baidu.ar.ihttp.a
            public void a(HttpException httpException) {
                c.this.b(kVar);
            }

            @Override // com.baidu.ar.ihttp.a
            public void a(IHttpResponse iHttpResponse) {
                try {
                    a b = c.this.b(iHttpResponse);
                    if (b.ji) {
                        c.this.e(b.jj);
                        if (kVar != null) {
                            kVar.onSuccess();
                        }
                    } else if (kVar != null) {
                        kVar.onError(b.jk, 0);
                    }
                } catch (Exception e) {
                    c.this.b(kVar);
                }
            }
        });
    }

    private void a(StringBuilder sb, String str, String str2) {
        if (sb.length() > 0) {
            sb.append(ETAG.ITEM_SEPARATOR);
        }
        sb.append(str + ETAG.EQUAL + Q(str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a b(IHttpResponse iHttpResponse) {
        if (iHttpResponse == null || !iHttpResponse.isSuccess()) {
            throw new HttpException(4, "response fail");
        }
        JSONObject jSONObject = new JSONObject(iHttpResponse.getContent());
        if (jSONObject == null || !jSONObject.has("errorNum")) {
            throw new HttpException(4, "response format is error");
        }
        a aVar = new a();
        aVar.ji = jSONObject.getInt("errorNum") == 0;
        if (aVar.ji) {
            aVar.jj = jSONObject.optJSONObject("data");
        } else {
            aVar.jk = jSONObject.has(TiebaInitialize.LogFields.ERROR_MESSAGE) ? jSONObject.getString(TiebaInitialize.LogFields.ERROR_MESSAGE) : "";
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(k kVar) {
        int i = this.jg + 1;
        this.jg = i;
        if (i > 5) {
            if (kVar != null) {
                kVar.onSuccess();
                return;
            }
            return;
        }
        com.baidu.ar.g.b.b("ARAuth", "retry " + this.jg + " at " + System.currentTimeMillis());
        try {
            Thread.currentThread();
            Thread.sleep(this.jg * 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a(kVar);
    }

    private String cx() {
        String str = Build.CPU_ABI;
        if (Build.VERSION.SDK_INT >= 21) {
            str = Arrays.asList(Build.SUPPORTED_ABIS).toString();
        }
        String uuid = new UUID(("182020" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (str.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10)).hashCode(), "dumix corp".hashCode()).toString();
        String str2 = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
        if (!TextUtils.isEmpty(Build.MANUFACTURER)) {
            str2 = String.valueOf(Build.MANUFACTURER.charAt(0));
        }
        return str2 + uuid.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toUpperCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(JSONObject jSONObject) {
        if (this.jf == null) {
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
        this.jf.a(hashSet);
    }

    private String h(Context context) {
        UUID gz = new com.baidu.ar.g.g(context).gz();
        String uuid = gz == null ? "" : gz.toString();
        StringBuilder sb = new StringBuilder();
        String gx = com.baidu.ar.g.c.gx();
        a(sb, "app_id", TextUtils.isEmpty(this.jd) ? DuMixARConfig.getAipAppId() : this.jd);
        a(sb, Constants.PHONE_BRAND, Build.BRAND);
        a(sb, Config.DEVICE_PART, Build.DEVICE);
        a(sb, "dumix_type", gx);
        a(sb, "fr", "-1");
        a(sb, HttpConstants.HTTP_MANUFACTURER, Build.MANUFACTURER);
        a(sb, "model", Build.MODEL);
        a(sb, HttpConstants.HTTP_OS_TYPE, "android");
        a(sb, "serial_num", i(context));
        a(sb, "timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        a(sb, "user_id", uuid);
        a(sb, "sign", P(sb.toString()));
        return sb.toString();
    }

    private String i(Context context) {
        String cx = Build.VERSION.SDK_INT > 28 ? cx() : (Build.VERSION.SDK_INT <= 27 || context.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) ? Build.SERIAL : Build.getSerial();
        return "unknown".equals(cx) ? "" : cx;
    }

    @Override // com.baidu.ar.auth.m
    public void a(m.a aVar) {
        this.jf = aVar;
    }

    @Override // com.baidu.ar.auth.m
    public void doAuth(Context context, k kVar) {
        this.bO = HttpFactory.newRequest();
        if (this.bO == null) {
            return;
        }
        long[] a2 = o.a(10, 50L);
        if (a2[0] != 1) {
            com.baidu.ar.g.b.b("ARAuth", "time err. " + a2[1]);
            if (kVar != null) {
                kVar.onSuccess();
                return;
            }
            return;
        }
        String gP = s.gP();
        this.bO.setMethod("POST").setUrl(gP).addHeader("Content-Type: application/x-www-form-urlencoded").setBody(h(context));
        a(kVar);
    }
}
