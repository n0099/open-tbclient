package com.baidu.swan.games.u.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.publisher.plugin.UgcPluginInfo;
import com.baidu.searchbox.ugc.model.PublishType;
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
/* loaded from: classes25.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String eet = "";
    private static String mUrl = "";
    private com.baidu.swan.games.binding.model.c ecA;

    public a(JsObject jsObject) {
        this.ecA = com.baidu.swan.games.binding.model.c.e(jsObject);
    }

    public void aqt() {
        e eVar = new e();
        eVar.mType = UgcPluginInfo.METHOD_SHARE_VIDEO;
        h.d(eVar);
        final c aZt = aZt();
        if (aZt != null) {
            com.baidu.swan.apps.a.b aKh = com.baidu.swan.apps.runtime.e.aJU().aKh();
            if (aKh.isLogin(com.baidu.swan.apps.t.a.aza())) {
                a(aZt);
                return;
            }
            SwanAppActivity aBZ = f.aCp().aBZ();
            if (aBZ == null) {
                xY("shareVideo: swanAppActivity is null");
            } else {
                aKh.a(aBZ, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.u.b.a.1
                    @Override // com.baidu.swan.apps.a.a
                    public void onResult(int i) {
                        switch (i) {
                            case 0:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login success");
                                }
                                a.this.a(aZt);
                                return;
                            default:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login fail");
                                }
                                a.this.xY("shareVideo: fail, no login in");
                                return;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        com.baidu.swan.games.m.a.aYB().a(cVar, new b() { // from class: com.baidu.swan.games.u.b.a.2
            @Override // com.baidu.swan.games.u.b.b
            public void a(c cVar2, String str) {
                if (a.DEBUG) {
                    Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", cVar2, str));
                }
                a.this.xY(str);
            }
        });
    }

    private c aZt() {
        c cVar = null;
        if (this.ecA == null) {
            aZu();
        } else if (com.baidu.swan.apps.runtime.e.aJU() == null) {
            xY("shareVideo: fail, swanApp is null");
        } else {
            String optString = this.ecA.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
            if (TextUtils.isEmpty(optString)) {
                xY("shareVideo: videoPath is invalid");
            } else {
                String xo = n.xo(optString);
                if (TextUtils.isEmpty(xo)) {
                    xY("shareVideo: videoPath is invalid");
                } else {
                    cVar = new c();
                    cVar.videoPath = xo;
                    cVar.title = this.ecA.optString("title");
                    cVar.query = this.ecA.optString("query");
                    d dVar = new d();
                    dVar.eey = this.ecA.optLong("clipMaxDuration", 30L);
                    dVar.eez = this.ecA.optLong("clipMinDuration", 3L);
                    dVar.eeA = this.ecA.optString("topicSource");
                    dVar.eeB = this.ecA.optString("publishTitle", com.baidu.swan.apps.t.a.aza().getResources().getString(a.h.swangame_publish_video));
                    dVar.eeC = this.ecA.optString("publishURL", "/searchbox?action=ugc&cmd=177");
                    dVar.sourceType = this.ecA.optInt("sourceType", 1);
                    dVar.sourceFrom = this.ecA.optString("sourceFrom", "tiny");
                    dVar.eeE = this.ecA.optString("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                    dVar.eeD = this.ecA.optString("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                    dVar.eeF = this.ecA.optString("topicURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fsv.baidu.com%2Ffeedvideoui%2Fview%2Ftopiclist");
                    dVar.publishType = this.ecA.optString(UgcConstant.PUBLISH_TYPE, PublishType.TYPE_VIDEO_SHARE);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.aJW());
                        jSONObject.put("frame_type", com.baidu.swan.apps.runtime.d.aJQ().aie());
                        jSONObject.put("query", cVar.query);
                        if (com.baidu.swan.apps.runtime.e.aJU() != null && com.baidu.swan.apps.runtime.e.aJU().aio() != null) {
                            jSONObject.put("title", com.baidu.swan.apps.runtime.e.aJU().aio().avf());
                        }
                    } catch (JSONException e) {
                        if (DEBUG) {
                            Log.d("ShareVideoApi", e.toString());
                        }
                    }
                    dVar.swan = jSONObject.toString();
                    if (!TextUtils.isEmpty(eet)) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("id", eet);
                            if (com.baidu.swan.apps.runtime.e.aJU() != null && com.baidu.swan.apps.runtime.e.aJU().aio() != null) {
                                jSONObject2.put("name", com.baidu.swan.apps.runtime.e.aJU().aio().avf());
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
                    cVar.eex = dVar;
                }
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xY(String str) {
        if (this.ecA != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            bVar.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
            com.baidu.swan.games.utils.b.a(this.ecA, false, bVar);
            aZu();
        }
    }

    private void aZu() {
        e eVar = new e();
        eVar.mType = UgcPluginInfo.METHOD_SHARE_VIDEO;
        eVar.mValue = "fail";
        h.d(eVar);
    }

    public static void aZv() {
        com.baidu.swan.games.network.b aKj = com.baidu.swan.apps.runtime.e.aJU().aKj();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_type", 0);
            jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.aJW());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
        newBuilder.addQueryParameter("data", jSONObject.toString());
        aKj.a(new Request.Builder().url(newBuilder.build()).build(), new Callback() { // from class: com.baidu.swan.games.u.b.a.3
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (a.DEBUG) {
                    iOException.printStackTrace();
                }
                a.aZw();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    JSONObject jSONObject2 = (JSONObject) new JSONObject(response.body().string()).opt("data");
                    if (jSONObject2 != null) {
                        String unused = a.eet = jSONObject2.optString("community_id");
                        String unused2 = a.mUrl = jSONObject2.optString("url");
                    } else {
                        a.aZw();
                    }
                } catch (JSONException e2) {
                    if (a.DEBUG) {
                        e2.printStackTrace();
                    }
                    a.aZw();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aZw() {
        eet = "";
        mUrl = "";
    }
}
