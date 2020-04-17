package com.baidu.ar.child.b;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.ar.f.q;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IHttpResponse;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* loaded from: classes3.dex */
    public interface a {
        void d(byte[] bArr);
    }

    public void a(byte[] bArr, String str, final a aVar) {
        String fq = q.fq();
        HashMap hashMap = new HashMap();
        hashMap.put("image", Base64.encodeToString(bArr, 0));
        hashMap.put("svc_name", "child-face");
        hashMap.put("vid", str);
        com.baidu.ar.child.b.a.a(fq, hashMap, new com.baidu.ar.ihttp.a() { // from class: com.baidu.ar.child.b.b.1
            @Override // com.baidu.ar.ihttp.a
            public void a(HttpException httpException) {
                Log.e("bdar-child", httpException.getMessage());
            }

            @Override // com.baidu.ar.ihttp.a
            public void a(IHttpResponse iHttpResponse) {
                try {
                    String content = iHttpResponse.getContent();
                    if (TextUtils.isEmpty(content)) {
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(content);
                        if (jSONObject.has("err_no")) {
                            if (jSONObject.getInt("err_no") == 0) {
                                if (jSONObject.has("feature_res")) {
                                    byte[] decode = Base64.decode(jSONObject.getString("feature_res"), 0);
                                    if (aVar != null) {
                                        aVar.d(decode);
                                    }
                                }
                            } else if (aVar != null) {
                                aVar.d(null);
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }
}
