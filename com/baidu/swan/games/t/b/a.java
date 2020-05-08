package com.baidu.swan.games.t.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.publisher.plugin.UgcPluginInfo;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.statistic.a.e;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.games.h.l;
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
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String cRk = "";
    private static String mUrl = "";
    private com.baidu.swan.games.binding.model.c cPs;

    public a(JsObject jsObject) {
        this.cPs = com.baidu.swan.games.binding.model.c.c(jsObject);
    }

    public void VH() {
        e eVar = new e();
        eVar.mType = UgcPluginInfo.METHOD_SHARE_VIDEO;
        f.a(eVar);
        final c axN = axN();
        if (axN != null) {
            com.baidu.swan.apps.a.b akX = com.baidu.swan.apps.runtime.e.akM().akX();
            if (akX.isLogin(com.baidu.swan.apps.w.a.abN())) {
                a(axN);
                return;
            }
            SwanAppActivity aeu = com.baidu.swan.apps.y.f.aeJ().aeu();
            if (aeu == null) {
                qJ("shareVideo: swanAppActivity is null");
            } else {
                akX.a(aeu, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.t.b.a.1
                    @Override // com.baidu.swan.apps.a.a
                    public void onResult(int i) {
                        switch (i) {
                            case 0:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login success");
                                }
                                a.this.a(axN);
                                return;
                            default:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login fail");
                                }
                                a.this.qJ("shareVideo: fail, no login in");
                                return;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        com.baidu.swan.games.l.a.awZ().a(cVar, new b() { // from class: com.baidu.swan.games.t.b.a.2
            @Override // com.baidu.swan.games.t.b.b
            public void a(c cVar2, String str) {
                if (a.DEBUG) {
                    Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", cVar2, str));
                }
                a.this.qJ(str);
            }
        });
    }

    private c axN() {
        c cVar = null;
        if (this.cPs == null) {
            axO();
        } else if (com.baidu.swan.apps.runtime.e.akM() == null) {
            qJ("shareVideo: fail, swanApp is null");
        } else {
            String optString = this.cPs.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
            if (TextUtils.isEmpty(optString)) {
                qJ("shareVideo: videoPath is invalid");
            } else {
                String pZ = l.pZ(optString);
                if (TextUtils.isEmpty(pZ)) {
                    qJ("shareVideo: videoPath is invalid");
                } else {
                    cVar = new c();
                    cVar.videoPath = pZ;
                    cVar.title = this.cPs.optString("title");
                    cVar.query = this.cPs.optString("query");
                    d dVar = new d();
                    dVar.cRp = this.cPs.optLong("clipMaxDuration", 30L);
                    dVar.cRq = this.cPs.optLong("clipMinDuration", 3L);
                    dVar.cRr = this.cPs.optString("topicSource");
                    dVar.cRs = this.cPs.optString("publishTitle", com.baidu.swan.apps.w.a.abN().getResources().getString(a.h.swangame_publish_video));
                    dVar.cRt = this.cPs.optString("publishURL", "/searchbox?action=ugc&cmd=177");
                    dVar.sourceType = this.cPs.optInt("sourceType", 1);
                    dVar.sourceFrom = this.cPs.optString("sourceFrom", "tiny");
                    dVar.cRv = this.cPs.optString("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                    dVar.cRu = this.cPs.optString("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                    dVar.cRw = this.cPs.optString("topicURL", "baiduboxapp://v1/easybrowse/open?url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dsearch&style=%7b%22menumode%22%3a%222%22%2c%22showtoolbar%22%3a%221%22%7d&newbrowser=1");
                    dVar.publishType = this.cPs.optString(UgcConstant.PUBLISH_TYPE, "9");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.akO());
                        jSONObject.put("frame_type", com.baidu.swan.apps.runtime.d.akJ().Ol());
                        jSONObject.put("query", cVar.query);
                        if (com.baidu.swan.apps.runtime.e.akM() != null && com.baidu.swan.apps.runtime.e.akM().Ov() != null) {
                            jSONObject.put("title", com.baidu.swan.apps.runtime.e.akM().Ov().YS());
                        }
                    } catch (JSONException e) {
                        if (DEBUG) {
                            Log.d("ShareVideoApi", e.toString());
                        }
                    }
                    dVar.swan = jSONObject.toString();
                    if (!TextUtils.isEmpty(cRk)) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("id", cRk);
                            if (com.baidu.swan.apps.runtime.e.akM() != null && com.baidu.swan.apps.runtime.e.akM().Ov() != null) {
                                jSONObject2.put("name", com.baidu.swan.apps.runtime.e.akM().Ov().YS());
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
                        dVar.showToast = -1;
                    } else {
                        dVar.showToast = 0;
                    }
                    cVar.cRo = dVar;
                }
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qJ(String str) {
        if (this.cPs != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            bVar.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
            com.baidu.swan.games.utils.b.a(this.cPs, false, bVar);
            axO();
        }
    }

    private void axO() {
        e eVar = new e();
        eVar.mType = UgcPluginInfo.METHOD_SHARE_VIDEO;
        eVar.mValue = "fail";
        f.a(eVar);
    }

    public static void axP() {
        com.baidu.swan.games.network.b akZ = com.baidu.swan.apps.runtime.e.akM().akZ();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_type", 0);
            jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.akO());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
        newBuilder.addQueryParameter("data", jSONObject.toString());
        akZ.a(new Request.Builder().url(newBuilder.build()).build(), new Callback() { // from class: com.baidu.swan.games.t.b.a.3
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (a.DEBUG) {
                    iOException.printStackTrace();
                }
                a.axQ();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    JSONObject jSONObject2 = (JSONObject) new JSONObject(response.body().string()).opt("data");
                    if (jSONObject2 != null) {
                        String unused = a.cRk = jSONObject2.optString("community_id");
                        String unused2 = a.mUrl = jSONObject2.optString("url");
                    } else {
                        a.axQ();
                    }
                } catch (JSONException e2) {
                    if (a.DEBUG) {
                        e2.printStackTrace();
                    }
                    a.axQ();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void axQ() {
        cRk = "";
        mUrl = "";
    }
}
