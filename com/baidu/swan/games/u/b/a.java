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
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String dXu = "";
    private static String mUrl = "";
    private com.baidu.swan.games.binding.model.c dVB;

    public a(JsObject jsObject) {
        this.dVB = com.baidu.swan.games.binding.model.c.e(jsObject);
    }

    public void anl() {
        e eVar = new e();
        eVar.mType = UgcPluginInfo.METHOD_SHARE_VIDEO;
        h.d(eVar);
        final c aWo = aWo();
        if (aWo != null) {
            com.baidu.swan.apps.a.b aGZ = com.baidu.swan.apps.runtime.e.aGM().aGZ();
            if (aGZ.isLogin(com.baidu.swan.apps.t.a.avS())) {
                a(aWo);
                return;
            }
            SwanAppActivity ayQ = f.azg().ayQ();
            if (ayQ == null) {
                xr("shareVideo: swanAppActivity is null");
            } else {
                aGZ.a(ayQ, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.u.b.a.1
                    @Override // com.baidu.swan.apps.a.a
                    public void onResult(int i) {
                        switch (i) {
                            case 0:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login success");
                                }
                                a.this.a(aWo);
                                return;
                            default:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login fail");
                                }
                                a.this.xr("shareVideo: fail, no login in");
                                return;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        com.baidu.swan.games.m.a.aVw().a(cVar, new b() { // from class: com.baidu.swan.games.u.b.a.2
            @Override // com.baidu.swan.games.u.b.b
            public void a(c cVar2, String str) {
                if (a.DEBUG) {
                    Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", cVar2, str));
                }
                a.this.xr(str);
            }
        });
    }

    private c aWo() {
        c cVar = null;
        if (this.dVB == null) {
            aWp();
        } else if (com.baidu.swan.apps.runtime.e.aGM() == null) {
            xr("shareVideo: fail, swanApp is null");
        } else {
            String optString = this.dVB.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
            if (TextUtils.isEmpty(optString)) {
                xr("shareVideo: videoPath is invalid");
            } else {
                String wH = n.wH(optString);
                if (TextUtils.isEmpty(wH)) {
                    xr("shareVideo: videoPath is invalid");
                } else {
                    cVar = new c();
                    cVar.videoPath = wH;
                    cVar.title = this.dVB.optString("title");
                    cVar.query = this.dVB.optString("query");
                    d dVar = new d();
                    dVar.dXz = this.dVB.optLong("clipMaxDuration", 30L);
                    dVar.dXA = this.dVB.optLong("clipMinDuration", 3L);
                    dVar.dXB = this.dVB.optString("topicSource");
                    dVar.dXC = this.dVB.optString("publishTitle", com.baidu.swan.apps.t.a.avS().getResources().getString(a.h.swangame_publish_video));
                    dVar.dXD = this.dVB.optString("publishURL", "/searchbox?action=ugc&cmd=177");
                    dVar.sourceType = this.dVB.optInt("sourceType", 1);
                    dVar.sourceFrom = this.dVB.optString("sourceFrom", "tiny");
                    dVar.dXF = this.dVB.optString("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                    dVar.dXE = this.dVB.optString("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                    dVar.dXG = this.dVB.optString("topicURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fsv.baidu.com%2Ffeedvideoui%2Fview%2Ftopiclist");
                    dVar.publishType = this.dVB.optString(UgcConstant.PUBLISH_TYPE, "9");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.aGO());
                        jSONObject.put("frame_type", com.baidu.swan.apps.runtime.d.aGI().aeW());
                        jSONObject.put("query", cVar.query);
                        if (com.baidu.swan.apps.runtime.e.aGM() != null && com.baidu.swan.apps.runtime.e.aGM().afg() != null) {
                            jSONObject.put("title", com.baidu.swan.apps.runtime.e.aGM().afg().arW());
                        }
                    } catch (JSONException e) {
                        if (DEBUG) {
                            Log.d("ShareVideoApi", e.toString());
                        }
                    }
                    dVar.swan = jSONObject.toString();
                    if (!TextUtils.isEmpty(dXu)) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("id", dXu);
                            if (com.baidu.swan.apps.runtime.e.aGM() != null && com.baidu.swan.apps.runtime.e.aGM().afg() != null) {
                                jSONObject2.put("name", com.baidu.swan.apps.runtime.e.aGM().afg().arW());
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
                    cVar.dXy = dVar;
                }
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(String str) {
        if (this.dVB != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            bVar.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
            com.baidu.swan.games.utils.b.a(this.dVB, false, bVar);
            aWp();
        }
    }

    private void aWp() {
        e eVar = new e();
        eVar.mType = UgcPluginInfo.METHOD_SHARE_VIDEO;
        eVar.mValue = "fail";
        h.d(eVar);
    }

    public static void aWq() {
        com.baidu.swan.games.network.b aHb = com.baidu.swan.apps.runtime.e.aGM().aHb();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_type", 0);
            jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.aGO());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
        newBuilder.addQueryParameter("data", jSONObject.toString());
        aHb.a(new Request.Builder().url(newBuilder.build()).build(), new Callback() { // from class: com.baidu.swan.games.u.b.a.3
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (a.DEBUG) {
                    iOException.printStackTrace();
                }
                a.aWr();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    JSONObject jSONObject2 = (JSONObject) new JSONObject(response.body().string()).opt("data");
                    if (jSONObject2 != null) {
                        String unused = a.dXu = jSONObject2.optString("community_id");
                        String unused2 = a.mUrl = jSONObject2.optString("url");
                    } else {
                        a.aWr();
                    }
                } catch (JSONException e2) {
                    if (a.DEBUG) {
                        e2.printStackTrace();
                    }
                    a.aWr();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aWr() {
        dXu = "";
        mUrl = "";
    }
}
