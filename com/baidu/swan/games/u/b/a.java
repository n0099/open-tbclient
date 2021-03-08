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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String emm = "";
    private static String mUrl = "";
    private com.baidu.swan.games.binding.model.c ekt;

    public a(JsObject jsObject) {
        this.ekt = com.baidu.swan.games.binding.model.c.e(jsObject);
    }

    public void aom() {
        e eVar = new e();
        eVar.mType = "shareVideo";
        h.d(eVar);
        final c aYj = aYj();
        if (aYj != null) {
            com.baidu.swan.apps.a.b aJa = com.baidu.swan.apps.runtime.e.aIN().aJa();
            if (aJa.isLogin(com.baidu.swan.apps.t.a.awZ())) {
                a(aYj);
                return;
            }
            SwanAppActivity azY = f.aAo().azY();
            if (azY == null) {
                xm("shareVideo: swanAppActivity is null");
            } else {
                aJa.a(azY, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.u.b.a.1
                    @Override // com.baidu.swan.apps.a.a
                    public void onResult(int i) {
                        switch (i) {
                            case 0:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login success");
                                }
                                a.this.a(aYj);
                                return;
                            default:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login fail");
                                }
                                a.this.xm("shareVideo: fail, no login in");
                                return;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        com.baidu.swan.games.m.a.aXr().a(cVar, new b() { // from class: com.baidu.swan.games.u.b.a.2
            @Override // com.baidu.swan.games.u.b.b
            public void a(c cVar2, String str) {
                if (a.DEBUG) {
                    Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", cVar2, str));
                }
                a.this.xm(str);
            }
        });
    }

    private c aYj() {
        c cVar = null;
        if (this.ekt == null) {
            aYk();
        } else if (com.baidu.swan.apps.runtime.e.aIN() == null) {
            xm("shareVideo: fail, swanApp is null");
        } else {
            String optString = this.ekt.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
            if (TextUtils.isEmpty(optString)) {
                xm("shareVideo: videoPath is invalid");
            } else {
                String wC = n.wC(optString);
                if (TextUtils.isEmpty(wC)) {
                    xm("shareVideo: videoPath is invalid");
                } else {
                    cVar = new c();
                    cVar.videoPath = wC;
                    cVar.title = this.ekt.optString("title");
                    cVar.query = this.ekt.optString("query");
                    d dVar = new d();
                    dVar.ems = this.ekt.optLong("clipMaxDuration", 30L);
                    dVar.emt = this.ekt.optLong("clipMinDuration", 3L);
                    dVar.emu = this.ekt.optString("topicSource");
                    dVar.emv = this.ekt.optString("publishTitle", com.baidu.swan.apps.t.a.awZ().getResources().getString(a.h.swangame_publish_video));
                    dVar.emw = this.ekt.optString("publishURL", "/searchbox?action=ugc&cmd=177");
                    dVar.sourceType = this.ekt.optInt("sourceType", 1);
                    dVar.sourceFrom = this.ekt.optString("sourceFrom", "tiny");
                    dVar.emy = this.ekt.optString("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                    dVar.emx = this.ekt.optString("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                    dVar.emz = this.ekt.optString("topicURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fsv.baidu.com%2Ffeedvideoui%2Fview%2Ftopiclist");
                    dVar.publishType = this.ekt.optString("publishType", "9");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.aIP());
                        jSONObject.put("frame_type", com.baidu.swan.apps.runtime.d.aIJ().getFrameType());
                        jSONObject.put("query", cVar.query);
                        if (com.baidu.swan.apps.runtime.e.aIN() != null && com.baidu.swan.apps.runtime.e.aIN().agc() != null) {
                            jSONObject.put("title", com.baidu.swan.apps.runtime.e.aIN().agc().atf());
                        }
                    } catch (JSONException e) {
                        if (DEBUG) {
                            Log.d("ShareVideoApi", e.toString());
                        }
                    }
                    dVar.emr = jSONObject.toString();
                    if (!TextUtils.isEmpty(emm)) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("id", emm);
                            if (com.baidu.swan.apps.runtime.e.aIN() != null && com.baidu.swan.apps.runtime.e.aIN().agc() != null) {
                                jSONObject2.put("name", com.baidu.swan.apps.runtime.e.aIN().agc().atf());
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
                        dVar.emA = -1;
                    } else {
                        dVar.emA = 0;
                    }
                    cVar.emq = dVar;
                }
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xm(String str) {
        if (this.ekt != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            bVar.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
            com.baidu.swan.games.utils.b.a(this.ekt, false, bVar);
            aYk();
        }
    }

    private void aYk() {
        e eVar = new e();
        eVar.mType = "shareVideo";
        eVar.mValue = com.baidu.pass.biometrics.face.liveness.c.a.p;
        h.d(eVar);
    }

    public static void aYl() {
        com.baidu.swan.games.network.b aJc = com.baidu.swan.apps.runtime.e.aIN().aJc();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_type", 0);
            jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.aIP());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
        newBuilder.addQueryParameter("data", jSONObject.toString());
        aJc.a(new Request.Builder().url(newBuilder.build()).build(), new Callback() { // from class: com.baidu.swan.games.u.b.a.3
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (a.DEBUG) {
                    iOException.printStackTrace();
                }
                a.aYm();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    JSONObject jSONObject2 = (JSONObject) new JSONObject(response.body().string()).opt("data");
                    if (jSONObject2 != null) {
                        String unused = a.emm = jSONObject2.optString("community_id");
                        String unused2 = a.mUrl = jSONObject2.optString("url");
                    } else {
                        a.aYm();
                    }
                } catch (JSONException e2) {
                    if (a.DEBUG) {
                        e2.printStackTrace();
                    }
                    a.aYm();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aYm() {
        emm = "";
        mUrl = "";
    }
}
