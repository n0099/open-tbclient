package com.baidu.swan.games.u.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.publisher.plugin.UgcPluginInfo;
import com.baidu.searchbox.ugc.model.UgcConstant;
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
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String dKN = "";
    private static String mUrl = "";
    private com.baidu.swan.games.binding.model.c dIU;

    public a(JsObject jsObject) {
        this.dIU = com.baidu.swan.games.binding.model.c.e(jsObject);
    }

    public void ajz() {
        e eVar = new e();
        eVar.mType = UgcPluginInfo.METHOD_SHARE_VIDEO;
        h.d(eVar);
        final c aSC = aSC();
        if (aSC != null) {
            com.baidu.swan.apps.a.b aDn = com.baidu.swan.apps.runtime.e.aDa().aDn();
            if (aDn.isLogin(com.baidu.swan.apps.t.a.asf())) {
                a(aSC);
                return;
            }
            SwanAppActivity ave = f.avu().ave();
            if (ave == null) {
                wP("shareVideo: swanAppActivity is null");
            } else {
                aDn.a(ave, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.u.b.a.1
                    @Override // com.baidu.swan.apps.a.a
                    public void onResult(int i) {
                        switch (i) {
                            case 0:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login success");
                                }
                                a.this.a(aSC);
                                return;
                            default:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login fail");
                                }
                                a.this.wP("shareVideo: fail, no login in");
                                return;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        com.baidu.swan.games.m.a.aRK().a(cVar, new b() { // from class: com.baidu.swan.games.u.b.a.2
            @Override // com.baidu.swan.games.u.b.b
            public void a(c cVar2, String str) {
                if (a.DEBUG) {
                    Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", cVar2, str));
                }
                a.this.wP(str);
            }
        });
    }

    private c aSC() {
        c cVar = null;
        if (this.dIU == null) {
            aSD();
        } else if (com.baidu.swan.apps.runtime.e.aDa() == null) {
            wP("shareVideo: fail, swanApp is null");
        } else {
            String optString = this.dIU.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
            if (TextUtils.isEmpty(optString)) {
                wP("shareVideo: videoPath is invalid");
            } else {
                String wf = n.wf(optString);
                if (TextUtils.isEmpty(wf)) {
                    wP("shareVideo: videoPath is invalid");
                } else {
                    cVar = new c();
                    cVar.videoPath = wf;
                    cVar.title = this.dIU.optString("title");
                    cVar.query = this.dIU.optString("query");
                    d dVar = new d();
                    dVar.dKS = this.dIU.optLong("clipMaxDuration", 30L);
                    dVar.dKT = this.dIU.optLong("clipMinDuration", 3L);
                    dVar.dKU = this.dIU.optString("topicSource");
                    dVar.dKV = this.dIU.optString("publishTitle", com.baidu.swan.apps.t.a.asf().getResources().getString(a.h.swangame_publish_video));
                    dVar.dKW = this.dIU.optString("publishURL", "/searchbox?action=ugc&cmd=177");
                    dVar.sourceType = this.dIU.optInt("sourceType", 1);
                    dVar.sourceFrom = this.dIU.optString("sourceFrom", "tiny");
                    dVar.dKY = this.dIU.optString("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                    dVar.dKX = this.dIU.optString("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                    dVar.dKZ = this.dIU.optString("topicURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fsv.baidu.com%2Ffeedvideoui%2Fview%2Ftopiclist");
                    dVar.publishType = this.dIU.optString(UgcConstant.PUBLISH_TYPE, "9");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.aDc());
                        jSONObject.put("frame_type", com.baidu.swan.apps.runtime.d.aCW().abk());
                        jSONObject.put("query", cVar.query);
                        if (com.baidu.swan.apps.runtime.e.aDa() != null && com.baidu.swan.apps.runtime.e.aDa().abu() != null) {
                            jSONObject.put("title", com.baidu.swan.apps.runtime.e.aDa().abu().aoj());
                        }
                    } catch (JSONException e) {
                        if (DEBUG) {
                            Log.d("ShareVideoApi", e.toString());
                        }
                    }
                    dVar.swan = jSONObject.toString();
                    if (!TextUtils.isEmpty(dKN)) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("id", dKN);
                            if (com.baidu.swan.apps.runtime.e.aDa() != null && com.baidu.swan.apps.runtime.e.aDa().abu() != null) {
                                jSONObject2.put("name", com.baidu.swan.apps.runtime.e.aDa().abu().aoj());
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
                    cVar.dKR = dVar;
                }
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wP(String str) {
        if (this.dIU != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            bVar.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
            com.baidu.swan.games.utils.b.a(this.dIU, false, bVar);
            aSD();
        }
    }

    private void aSD() {
        e eVar = new e();
        eVar.mType = UgcPluginInfo.METHOD_SHARE_VIDEO;
        eVar.mValue = "fail";
        h.d(eVar);
    }

    public static void aSE() {
        com.baidu.swan.games.network.b aDp = com.baidu.swan.apps.runtime.e.aDa().aDp();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_type", 0);
            jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.aDc());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
        newBuilder.addQueryParameter("data", jSONObject.toString());
        aDp.a(new Request.Builder().url(newBuilder.build()).build(), new Callback() { // from class: com.baidu.swan.games.u.b.a.3
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (a.DEBUG) {
                    iOException.printStackTrace();
                }
                a.aSF();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    JSONObject jSONObject2 = (JSONObject) new JSONObject(response.body().string()).opt("data");
                    if (jSONObject2 != null) {
                        String unused = a.dKN = jSONObject2.optString("community_id");
                        String unused2 = a.mUrl = jSONObject2.optString("url");
                    } else {
                        a.aSF();
                    }
                } catch (JSONException e2) {
                    if (a.DEBUG) {
                        e2.printStackTrace();
                    }
                    a.aSF();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aSF() {
        dKN = "";
        mUrl = "";
    }
}
