package com.baidu.swan.games.u.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.statistic.a.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.i.n;
import com.tencent.connect.share.QzonePublish;
import java.io.IOException;
import java.util.Locale;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String enr = "";
    private static String mUrl = "";
    private com.baidu.swan.games.binding.model.c elx;

    public a(JsObject jsObject) {
        this.elx = com.baidu.swan.games.binding.model.c.e(jsObject);
    }

    public void arG() {
        e eVar = new e();
        eVar.mType = "shareVideo";
        h.d(eVar);
        final c bbO = bbO();
        if (bbO != null) {
            com.baidu.swan.apps.a.b aMy = com.baidu.swan.apps.runtime.e.aMl().aMy();
            if (aMy.isLogin(com.baidu.swan.apps.t.a.aAs())) {
                a(bbO);
                return;
            }
            SwanAppActivity aDr = f.aDH().aDr();
            if (aDr == null) {
                xX("shareVideo: swanAppActivity is null");
            } else {
                aMy.a(aDr, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.u.b.a.1
                    @Override // com.baidu.swan.apps.a.a
                    public void onResult(int i) {
                        switch (i) {
                            case 0:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login success");
                                }
                                a.this.a(bbO);
                                return;
                            default:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login fail");
                                }
                                a.this.xX("shareVideo: fail, no login in");
                                return;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        com.baidu.swan.games.m.a.baW().a(cVar, new b() { // from class: com.baidu.swan.games.u.b.a.2
            @Override // com.baidu.swan.games.u.b.b
            public void a(c cVar2, String str) {
                if (a.DEBUG) {
                    Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", cVar2, str));
                }
                a.this.xX(str);
            }
        });
    }

    private c bbO() {
        c cVar = null;
        if (this.elx == null) {
            bbP();
        } else if (com.baidu.swan.apps.runtime.e.aMl() == null) {
            xX("shareVideo: fail, swanApp is null");
        } else {
            String optString = this.elx.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
            if (TextUtils.isEmpty(optString)) {
                xX("shareVideo: videoPath is invalid");
            } else {
                String xn = n.xn(optString);
                if (TextUtils.isEmpty(xn)) {
                    xX("shareVideo: videoPath is invalid");
                } else {
                    cVar = new c();
                    cVar.videoPath = xn;
                    cVar.title = this.elx.optString("title");
                    cVar.query = this.elx.optString("query");
                    d dVar = new d();
                    dVar.eny = this.elx.optLong("clipMaxDuration", 30L);
                    dVar.enz = this.elx.optLong("clipMinDuration", 3L);
                    dVar.enA = this.elx.optString("topicSource");
                    dVar.enB = this.elx.optString("publishTitle", com.baidu.swan.apps.t.a.aAs().getResources().getString(a.h.swangame_publish_video));
                    dVar.enC = this.elx.optString("publishURL", "/searchbox?action=ugc&cmd=177");
                    dVar.sourceType = this.elx.optInt("sourceType", 1);
                    dVar.sourceFrom = this.elx.optString("sourceFrom", "tiny");
                    dVar.enE = this.elx.optString("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                    dVar.enD = this.elx.optString("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                    dVar.enF = this.elx.optString("topicURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fsv.baidu.com%2Ffeedvideoui%2Fview%2Ftopiclist");
                    dVar.publishType = this.elx.optString("publishType", "9");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.aMn());
                        jSONObject.put("frame_type", com.baidu.swan.apps.runtime.d.aMh().ajl());
                        jSONObject.put("query", cVar.query);
                        if (com.baidu.swan.apps.runtime.e.aMl() != null && com.baidu.swan.apps.runtime.e.aMl().ajv() != null) {
                            jSONObject.put("title", com.baidu.swan.apps.runtime.e.aMl().ajv().awy());
                        }
                    } catch (JSONException e) {
                        if (DEBUG) {
                            Log.d("ShareVideoApi", e.toString());
                        }
                    }
                    dVar.enx = jSONObject.toString();
                    if (!TextUtils.isEmpty(enr)) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("id", enr);
                            if (com.baidu.swan.apps.runtime.e.aMl() != null && com.baidu.swan.apps.runtime.e.aMl().ajv() != null) {
                                jSONObject2.put("name", com.baidu.swan.apps.runtime.e.aMl().ajv().awy());
                            }
                            jSONObject2.put("type", "interest");
                            jSONObject2.put("post_id", "");
                        } catch (JSONException e2) {
                            if (DEBUG) {
                                Log.d("ShareVideoApi", e2.toString());
                            }
                        }
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(jSONObject2);
                        JSONObject jSONObject3 = new JSONObject();
                        try {
                            jSONObject3.put("tag", jSONArray);
                        } catch (JSONException e3) {
                            if (DEBUG) {
                                Log.d("ShareVideoApi", e3.toString());
                            }
                        }
                        dVar.target = jSONObject3.toString();
                        dVar.enG = -1;
                    } else {
                        dVar.enG = 0;
                    }
                    cVar.enw = dVar;
                }
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xX(String str) {
        if (this.elx != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            bVar.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
            com.baidu.swan.games.utils.b.a(this.elx, false, bVar);
            bbP();
        }
    }

    private void bbP() {
        e eVar = new e();
        eVar.mType = "shareVideo";
        eVar.mValue = com.baidu.pass.biometrics.face.liveness.c.a.p;
        h.d(eVar);
    }

    public static void bbQ() {
        com.baidu.swan.games.network.b aMA = com.baidu.swan.apps.runtime.e.aMl().aMA();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_type", 0);
            jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.aMn());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
        newBuilder.addQueryParameter("data", jSONObject.toString());
        aMA.a(new Request.Builder().url(newBuilder.build()).build(), new Callback() { // from class: com.baidu.swan.games.u.b.a.3
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (a.DEBUG) {
                    iOException.printStackTrace();
                }
                a.bbR();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    JSONObject jSONObject2 = (JSONObject) new JSONObject(response.body().string()).opt("data");
                    if (jSONObject2 != null) {
                        String unused = a.enr = jSONObject2.optString("community_id");
                        String unused2 = a.mUrl = jSONObject2.optString("url");
                    } else {
                        a.bbR();
                    }
                } catch (JSONException e2) {
                    if (a.DEBUG) {
                        e2.printStackTrace();
                    }
                    a.bbR();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bbR() {
        enr = "";
        mUrl = "";
    }
}
