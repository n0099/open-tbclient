package com.baidu.ar.auth;

import android.content.Context;
import android.os.Build;
import android.support.media.ExifInterface;
import android.text.TextUtils;
import com.baidu.ar.auth.l;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.f.q;
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
/* loaded from: classes11.dex */
class b implements l {
    private volatile IHttpRequest bX;
    private boolean jq;
    private String jr;
    private String js;
    private l.a jt;
    private int ju = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static final class a {
        boolean jw;
        JSONObject jx;
        String jy;

        private a() {
        }
    }

    public b(f fVar) {
        this.jq = fVar.jD;
        this.jr = fVar.jG;
        this.js = fVar.jH;
    }

    private String O(String str) {
        return com.baidu.ar.f.j.aN(str + (TextUtils.isEmpty(this.jr) ? DuMixARConfig.getAPIKey() : this.js));
    }

    private String P(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    private void a(final j jVar) {
        if (this.bX == null) {
            return;
        }
        this.bX.enqueue(new com.baidu.ar.ihttp.a() { // from class: com.baidu.ar.auth.b.1
            @Override // com.baidu.ar.ihttp.a
            public void a(HttpException httpException) {
                b.this.b(jVar);
            }

            @Override // com.baidu.ar.ihttp.a
            public void a(IHttpResponse iHttpResponse) {
                try {
                    a b = b.this.b(iHttpResponse);
                    if (b.jw) {
                        b.this.e(b.jx);
                        if (jVar != null) {
                            jVar.onSuccess();
                        }
                    } else if (jVar != null) {
                        jVar.onError(b.jy, 0);
                    }
                } catch (Exception e) {
                    b.this.b(jVar);
                }
            }
        });
    }

    private void a(StringBuilder sb, String str, String str2) {
        if (sb.length() > 0) {
            sb.append(ETAG.ITEM_SEPARATOR);
        }
        sb.append(str + ETAG.EQUAL + P(str2));
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
        aVar.jw = jSONObject.getInt("errorNum") == 0;
        if (aVar.jw) {
            aVar.jx = jSONObject.optJSONObject("data");
        } else {
            aVar.jy = jSONObject.has(TiebaInitialize.LogFields.ERROR_MESSAGE) ? jSONObject.getString(TiebaInitialize.LogFields.ERROR_MESSAGE) : "";
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(j jVar) {
        int i = this.ju + 1;
        this.ju = i;
        if (i > 5) {
            if (jVar != null) {
                jVar.onSuccess();
                return;
            }
            return;
        }
        com.baidu.ar.f.b.b("ARAuth", "retry " + this.ju + " at " + System.currentTimeMillis());
        try {
            Thread.currentThread();
            Thread.sleep(this.ju * 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a(jVar);
    }

    private long[] cf() {
        long currentTimeMillis = System.currentTimeMillis();
        int i = 0;
        while (currentTimeMillis < 946656000000L) {
            int i2 = i + 1;
            if (i >= 10) {
                break;
            }
            try {
                Thread.currentThread();
                Thread.sleep(50L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentTimeMillis = System.currentTimeMillis();
            i = i2;
        }
        long[] jArr = new long[2];
        jArr[0] = currentTimeMillis < 946656000000L ? 0 : 1;
        jArr[1] = currentTimeMillis;
        return jArr;
    }

    private String cg() {
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
        if (this.jt == null) {
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
        this.jt.a(hashSet);
    }

    private String h(Context context) {
        UUID fl = new com.baidu.ar.f.e(context).fl();
        String uuid = fl == null ? "" : fl.toString();
        StringBuilder sb = new StringBuilder();
        String fj = com.baidu.ar.f.c.fj();
        a(sb, "app_id", TextUtils.isEmpty(this.jr) ? DuMixARConfig.getAipAppId() : this.jr);
        a(sb, Constants.PHONE_BRAND, Build.BRAND);
        a(sb, Config.DEVICE_PART, Build.DEVICE);
        a(sb, "dumix_type", fj);
        a(sb, "fr", "-1");
        a(sb, HttpConstants.HTTP_MANUFACTURER, Build.MANUFACTURER);
        a(sb, "model", Build.MODEL);
        a(sb, HttpConstants.HTTP_OS_TYPE, "android");
        a(sb, "serial_num", i(context));
        a(sb, "timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        a(sb, "user_id", uuid);
        a(sb, "sign", O(sb.toString()));
        return sb.toString();
    }

    private String i(Context context) {
        String cg = Build.VERSION.SDK_INT > 28 ? cg() : (Build.VERSION.SDK_INT <= 27 || context.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) ? Build.SERIAL : Build.getSerial();
        return "unknown".equals(cg) ? "" : cg;
    }

    @Override // com.baidu.ar.auth.l
    public void a(l.a aVar) {
        this.jt = aVar;
    }

    @Override // com.baidu.ar.auth.l
    public void doAuth(Context context, j jVar) {
        this.bX = HttpFactory.newRequest();
        if (this.bX == null) {
            return;
        }
        long[] cf = cf();
        if (cf[0] != 1) {
            com.baidu.ar.f.b.b("ARAuth", "time err. " + cf[1]);
            if (jVar != null) {
                jVar.onSuccess();
                return;
            }
            return;
        }
        String fA = q.fA();
        this.bX.setMethod("POST").setUrl(fA).addHeader("Content-Type: application/x-www-form-urlencoded").setBody(h(context));
        a(jVar);
    }
}
