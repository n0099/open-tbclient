package com.baidu.swan.games.t.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.publisher.plugin.UgcPluginInfo;
import com.baidu.searchbox.ugc.model.PublishType;
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
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String cnI = "";
    private static String mUrl = "";
    private com.baidu.swan.games.binding.model.c clO;

    public a(JsObject jsObject) {
        this.clO = com.baidu.swan.games.binding.model.c.c(jsObject);
    }

    public void Lf() {
        e eVar = new e();
        eVar.mType = UgcPluginInfo.METHOD_SHARE_VIDEO;
        f.a(eVar);
        final c amP = amP();
        if (amP != null) {
            com.baidu.swan.apps.a.b aad = com.baidu.swan.apps.runtime.e.ZS().aad();
            if (aad.isLogin(com.baidu.swan.apps.w.a.Rk())) {
                a(amP);
                return;
            }
            SwanAppActivity TQ = com.baidu.swan.apps.y.f.Uf().TQ();
            if (TQ == null) {
                pf("shareVideo: swanAppActivity is null");
            } else {
                aad.a(TQ, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.t.b.a.1
                    @Override // com.baidu.swan.apps.a.a
                    public void onResult(int i) {
                        switch (i) {
                            case 0:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login success");
                                }
                                a.this.a(amP);
                                return;
                            default:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login fail");
                                }
                                a.this.pf("shareVideo: fail, no login in");
                                return;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        com.baidu.swan.games.l.a.amb().a(cVar, new b() { // from class: com.baidu.swan.games.t.b.a.2
            @Override // com.baidu.swan.games.t.b.b
            public void a(c cVar2, String str) {
                if (a.DEBUG) {
                    Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", cVar2, str));
                }
                a.this.pf(str);
            }
        });
    }

    private c amP() {
        c cVar = null;
        if (this.clO == null) {
            amQ();
        } else if (com.baidu.swan.apps.runtime.e.ZS() == null) {
            pf("shareVideo: fail, swanApp is null");
        } else {
            String optString = this.clO.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
            if (TextUtils.isEmpty(optString)) {
                pf("shareVideo: videoPath is invalid");
            } else {
                String ov = l.ov(optString);
                if (TextUtils.isEmpty(ov)) {
                    pf("shareVideo: videoPath is invalid");
                } else {
                    cVar = new c();
                    cVar.videoPath = ov;
                    cVar.title = this.clO.optString("title");
                    cVar.query = this.clO.optString("query");
                    d dVar = new d();
                    dVar.cnN = this.clO.optLong("clipMaxDuration", 30L);
                    dVar.cnO = this.clO.optLong("clipMinDuration", 3L);
                    dVar.cnP = this.clO.optString("topicSource");
                    dVar.cnQ = this.clO.optString("publishTitle", com.baidu.swan.apps.w.a.Rk().getResources().getString(a.h.swangame_publish_video));
                    dVar.cnR = this.clO.optString("publishURL", "/searchbox?action=ugc&cmd=177");
                    dVar.sourceType = this.clO.optInt("sourceType", 1);
                    dVar.sourceFrom = this.clO.optString("sourceFrom", "tiny");
                    dVar.cnT = this.clO.optString("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                    dVar.cnS = this.clO.optString("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                    dVar.cnU = this.clO.optString("topicURL", "baiduboxapp://v1/easybrowse/open?url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dsearch&style=%7b%22menumode%22%3a%222%22%2c%22showtoolbar%22%3a%221%22%7d&newbrowser=1");
                    dVar.publishType = this.clO.optString("publishType", PublishType.TYPE_VIDEO_SHARE);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.ZU());
                        jSONObject.put("frame_type", com.baidu.swan.apps.runtime.d.ZP().DH());
                        jSONObject.put("query", cVar.query);
                        if (com.baidu.swan.apps.runtime.e.ZS() != null && com.baidu.swan.apps.runtime.e.ZS().DR() != null) {
                            jSONObject.put("title", com.baidu.swan.apps.runtime.e.ZS().DR().Op());
                        }
                    } catch (JSONException e) {
                        if (DEBUG) {
                            Log.d("ShareVideoApi", e.toString());
                        }
                    }
                    dVar.swan = jSONObject.toString();
                    if (!TextUtils.isEmpty(cnI)) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("id", cnI);
                            if (com.baidu.swan.apps.runtime.e.ZS() != null && com.baidu.swan.apps.runtime.e.ZS().DR() != null) {
                                jSONObject2.put("name", com.baidu.swan.apps.runtime.e.ZS().DR().Op());
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
                    cVar.cnM = dVar;
                }
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pf(String str) {
        if (this.clO != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            bVar.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
            com.baidu.swan.games.utils.b.a(this.clO, false, bVar);
            amQ();
        }
    }

    private void amQ() {
        e eVar = new e();
        eVar.mType = UgcPluginInfo.METHOD_SHARE_VIDEO;
        eVar.mValue = LivenessStat.TYPE_FACE_MATCH_FAIL;
        f.a(eVar);
    }

    public static void amR() {
        com.baidu.swan.games.network.b aaf = com.baidu.swan.apps.runtime.e.ZS().aaf();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_type", 0);
            jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.ZU());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
        newBuilder.addQueryParameter("data", jSONObject.toString());
        aaf.a(new Request.Builder().url(newBuilder.build()).build(), new Callback() { // from class: com.baidu.swan.games.t.b.a.3
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (a.DEBUG) {
                    iOException.printStackTrace();
                }
                a.amS();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    JSONObject jSONObject2 = (JSONObject) new JSONObject(response.body().string()).opt("data");
                    if (jSONObject2 != null) {
                        String unused = a.cnI = jSONObject2.optString("community_id");
                        String unused2 = a.mUrl = jSONObject2.optString("url");
                    } else {
                        a.amS();
                    }
                } catch (JSONException e2) {
                    if (a.DEBUG) {
                        e2.printStackTrace();
                    }
                    a.amS();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void amS() {
        cnI = "";
        mUrl = "";
    }
}
