package com.baidu.ar.auth;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.auth.l;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.f.q;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class b implements l {
    private volatile IHttpRequest bK;
    private boolean iZ;
    private String ja;
    private String jb;
    private l.a jc;
    private int jd = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a {
        boolean jf;
        JSONObject jg;
        String jh;

        private a() {
        }
    }

    public b(f fVar) {
        this.iZ = fVar.jm;
        this.ja = fVar.jp;
        this.jb = fVar.jq;
    }

    private String O(String str) {
        return com.baidu.ar.f.j.aM(str + (TextUtils.isEmpty(this.ja) ? DuMixARConfig.getAPIKey() : this.jb));
    }

    private String P(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    private void a(final j jVar) {
        if (this.bK == null) {
            return;
        }
        this.bK.enqueue(new com.baidu.ar.ihttp.a() { // from class: com.baidu.ar.auth.b.1
            @Override // com.baidu.ar.ihttp.a
            public void a(HttpException httpException) {
                b.this.b(jVar);
            }

            @Override // com.baidu.ar.ihttp.a
            public void a(IHttpResponse iHttpResponse) {
                try {
                    a b = b.this.b(iHttpResponse);
                    if (b.jf) {
                        b.this.d(b.jg);
                        if (jVar != null) {
                            jVar.onSuccess();
                        }
                    } else if (jVar != null) {
                        jVar.onError(b.jh, 0);
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
        aVar.jf = jSONObject.getInt("errorNum") == 0;
        if (aVar.jf) {
            aVar.jg = jSONObject.optJSONObject("data");
        } else {
            aVar.jh = jSONObject.has(TiebaInitialize.LogFields.ERROR_MESSAGE) ? jSONObject.getString(TiebaInitialize.LogFields.ERROR_MESSAGE) : "";
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(j jVar) {
        int i = this.jd + 1;
        this.jd = i;
        if (i > 5) {
            return;
        }
        com.baidu.ar.f.b.b("ARAuth", "retry " + this.jd + " at " + System.currentTimeMillis());
        try {
            Thread.currentThread();
            Thread.sleep(this.jd * 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a(jVar);
    }

    private long[] bQ() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void d(JSONObject jSONObject) {
        if (this.jc == null) {
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
        this.jc.a(hashSet);
    }

    private String g(Context context) {
        UUID eV = new com.baidu.ar.f.e(context).eV();
        String uuid = eV == null ? "" : eV.toString();
        StringBuilder sb = new StringBuilder();
        String eT = com.baidu.ar.f.c.eT();
        a(sb, "app_id", TextUtils.isEmpty(this.ja) ? DuMixARConfig.getAipAppId() : this.ja);
        a(sb, "dumix_type", eT);
        a(sb, "fr", "-1");
        a(sb, "timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        a(sb, "user_id", uuid);
        a(sb, "sign", O(sb.toString()));
        return sb.toString();
    }

    @Override // com.baidu.ar.auth.l
    public void a(l.a aVar) {
        this.jc = aVar;
    }

    @Override // com.baidu.ar.auth.l
    public void doAuth(Context context, j jVar) {
        this.bK = HttpFactory.newRequest();
        if (this.bK == null) {
            return;
        }
        long[] bQ = bQ();
        if (bQ[0] != 1) {
            com.baidu.ar.f.b.b("ARAuth", "time err. " + bQ[1]);
            return;
        }
        String fk = q.fk();
        this.bK.setMethod("POST").setUrl(fk).addHeader("Content-Type: application/x-www-form-urlencoded").setBody(g(context));
        a(jVar);
    }
}
