package com.baidu.ar.child.b;

import android.support.media.ExifInterface;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.ar.g.s;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IHttpResponse;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class b {

    /* loaded from: classes14.dex */
    public interface a {
        void e(byte[] bArr);
    }

    private void a(a aVar, byte[] bArr) {
        if (aVar != null) {
            aVar.e(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, a aVar) {
        if (jSONObject.has("err_no")) {
            if (jSONObject.getInt("err_no") != 0) {
                a(aVar, (byte[]) null);
            } else if (jSONObject.has("feature_res")) {
                byte[] decode = Base64.decode(jSONObject.getString("feature_res"), 0);
                if (aVar != null) {
                    aVar.e(decode);
                }
                a(aVar, decode);
            }
        }
    }

    private String v(int i) {
        switch (i) {
            case -90:
                return "HR";
            case 0:
                return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
            case 90:
                return "HL";
            case 180:
                return "FV";
            default:
                return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
        }
    }

    public void a(byte[] bArr, int i, final a aVar) {
        String gV = s.gV();
        HashMap hashMap = new HashMap();
        String encodeToString = Base64.encodeToString(bArr, 0);
        String v = v(i);
        hashMap.put("image", encodeToString);
        hashMap.put("svc_name", "child-face");
        hashMap.put("vid", v);
        com.baidu.ar.child.b.a.a(gV, hashMap, new com.baidu.ar.ihttp.a() { // from class: com.baidu.ar.child.b.b.1
            @Override // com.baidu.ar.ihttp.a
            public void a(HttpException httpException) {
                Log.e("ChildRequestController", httpException.getMessage());
            }

            @Override // com.baidu.ar.ihttp.a
            public void a(IHttpResponse iHttpResponse) {
                try {
                    String content = iHttpResponse.getContent();
                    if (TextUtils.isEmpty(content)) {
                        return;
                    }
                    try {
                        b.this.a(new JSONObject(content), aVar);
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
