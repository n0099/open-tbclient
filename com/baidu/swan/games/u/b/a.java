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
    private static String ekL = "";
    private static String mUrl = "";
    private com.baidu.swan.games.binding.model.c eiS;

    public a(JsObject jsObject) {
        this.eiS = com.baidu.swan.games.binding.model.c.e(jsObject);
    }

    public void aoj() {
        e eVar = new e();
        eVar.mType = "shareVideo";
        h.d(eVar);
        final c aYg = aYg();
        if (aYg != null) {
            com.baidu.swan.apps.a.b aIX = com.baidu.swan.apps.runtime.e.aIK().aIX();
            if (aIX.isLogin(com.baidu.swan.apps.t.a.awW())) {
                a(aYg);
                return;
            }
            SwanAppActivity azV = f.aAl().azV();
            if (azV == null) {
                xf("shareVideo: swanAppActivity is null");
            } else {
                aIX.a(azV, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.u.b.a.1
                    @Override // com.baidu.swan.apps.a.a
                    public void onResult(int i) {
                        switch (i) {
                            case 0:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login success");
                                }
                                a.this.a(aYg);
                                return;
                            default:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login fail");
                                }
                                a.this.xf("shareVideo: fail, no login in");
                                return;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        com.baidu.swan.games.m.a.aXo().a(cVar, new b() { // from class: com.baidu.swan.games.u.b.a.2
            @Override // com.baidu.swan.games.u.b.b
            public void a(c cVar2, String str) {
                if (a.DEBUG) {
                    Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", cVar2, str));
                }
                a.this.xf(str);
            }
        });
    }

    private c aYg() {
        c cVar = null;
        if (this.eiS == null) {
            aYh();
        } else if (com.baidu.swan.apps.runtime.e.aIK() == null) {
            xf("shareVideo: fail, swanApp is null");
        } else {
            String optString = this.eiS.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
            if (TextUtils.isEmpty(optString)) {
                xf("shareVideo: videoPath is invalid");
            } else {
                String wv = n.wv(optString);
                if (TextUtils.isEmpty(wv)) {
                    xf("shareVideo: videoPath is invalid");
                } else {
                    cVar = new c();
                    cVar.videoPath = wv;
                    cVar.title = this.eiS.optString("title");
                    cVar.query = this.eiS.optString("query");
                    d dVar = new d();
                    dVar.ekR = this.eiS.optLong("clipMaxDuration", 30L);
                    dVar.ekS = this.eiS.optLong("clipMinDuration", 3L);
                    dVar.ekT = this.eiS.optString("topicSource");
                    dVar.ekU = this.eiS.optString("publishTitle", com.baidu.swan.apps.t.a.awW().getResources().getString(a.h.swangame_publish_video));
                    dVar.ekV = this.eiS.optString("publishURL", "/searchbox?action=ugc&cmd=177");
                    dVar.sourceType = this.eiS.optInt("sourceType", 1);
                    dVar.sourceFrom = this.eiS.optString("sourceFrom", "tiny");
                    dVar.ekX = this.eiS.optString("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                    dVar.ekW = this.eiS.optString("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                    dVar.ekY = this.eiS.optString("topicURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fsv.baidu.com%2Ffeedvideoui%2Fview%2Ftopiclist");
                    dVar.publishType = this.eiS.optString("publishType", "9");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.aIM());
                        jSONObject.put("frame_type", com.baidu.swan.apps.runtime.d.aIG().getFrameType());
                        jSONObject.put("query", cVar.query);
                        if (com.baidu.swan.apps.runtime.e.aIK() != null && com.baidu.swan.apps.runtime.e.aIK().afZ() != null) {
                            jSONObject.put("title", com.baidu.swan.apps.runtime.e.aIK().afZ().atc());
                        }
                    } catch (JSONException e) {
                        if (DEBUG) {
                            Log.d("ShareVideoApi", e.toString());
                        }
                    }
                    dVar.ekQ = jSONObject.toString();
                    if (!TextUtils.isEmpty(ekL)) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("id", ekL);
                            if (com.baidu.swan.apps.runtime.e.aIK() != null && com.baidu.swan.apps.runtime.e.aIK().afZ() != null) {
                                jSONObject2.put("name", com.baidu.swan.apps.runtime.e.aIK().afZ().atc());
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
                        dVar.ekZ = -1;
                    } else {
                        dVar.ekZ = 0;
                    }
                    cVar.ekP = dVar;
                }
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xf(String str) {
        if (this.eiS != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            bVar.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
            com.baidu.swan.games.utils.b.a(this.eiS, false, bVar);
            aYh();
        }
    }

    private void aYh() {
        e eVar = new e();
        eVar.mType = "shareVideo";
        eVar.mValue = com.baidu.pass.biometrics.face.liveness.c.a.p;
        h.d(eVar);
    }

    public static void aYi() {
        com.baidu.swan.games.network.b aIZ = com.baidu.swan.apps.runtime.e.aIK().aIZ();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_type", 0);
            jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.aIM());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
        newBuilder.addQueryParameter("data", jSONObject.toString());
        aIZ.a(new Request.Builder().url(newBuilder.build()).build(), new Callback() { // from class: com.baidu.swan.games.u.b.a.3
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (a.DEBUG) {
                    iOException.printStackTrace();
                }
                a.aYj();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    JSONObject jSONObject2 = (JSONObject) new JSONObject(response.body().string()).opt("data");
                    if (jSONObject2 != null) {
                        String unused = a.ekL = jSONObject2.optString("community_id");
                        String unused2 = a.mUrl = jSONObject2.optString("url");
                    } else {
                        a.aYj();
                    }
                } catch (JSONException e2) {
                    if (a.DEBUG) {
                        e2.printStackTrace();
                    }
                    a.aYj();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aYj() {
        ekL = "";
        mUrl = "";
    }
}
