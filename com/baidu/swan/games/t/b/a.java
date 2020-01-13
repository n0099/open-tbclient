package com.baidu.swan.games.t.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.publisher.plugin.UgcPluginInfo;
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
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String cnV = "";
    private static String mUrl = "";
    private com.baidu.swan.games.binding.model.c cmb;

    public a(JsObject jsObject) {
        this.cmb = com.baidu.swan.games.binding.model.c.c(jsObject);
    }

    public void LB() {
        e eVar = new e();
        eVar.mType = UgcPluginInfo.METHOD_SHARE_VIDEO;
        f.a(eVar);
        final c ani = ani();
        if (ani != null) {
            com.baidu.swan.apps.a.b aaA = com.baidu.swan.apps.runtime.e.aap().aaA();
            if (aaA.isLogin(com.baidu.swan.apps.w.a.RG())) {
                a(ani);
                return;
            }
            SwanAppActivity Un = com.baidu.swan.apps.y.f.UC().Un();
            if (Un == null) {
                pi("shareVideo: swanAppActivity is null");
            } else {
                aaA.a(Un, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.t.b.a.1
                    @Override // com.baidu.swan.apps.a.a
                    public void onResult(int i) {
                        switch (i) {
                            case 0:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login success");
                                }
                                a.this.a(ani);
                                return;
                            default:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login fail");
                                }
                                a.this.pi("shareVideo: fail, no login in");
                                return;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        com.baidu.swan.games.l.a.amu().a(cVar, new b() { // from class: com.baidu.swan.games.t.b.a.2
            @Override // com.baidu.swan.games.t.b.b
            public void a(c cVar2, String str) {
                if (a.DEBUG) {
                    Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", cVar2, str));
                }
                a.this.pi(str);
            }
        });
    }

    private c ani() {
        c cVar = null;
        if (this.cmb == null) {
            anj();
        } else if (com.baidu.swan.apps.runtime.e.aap() == null) {
            pi("shareVideo: fail, swanApp is null");
        } else {
            String optString = this.cmb.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
            if (TextUtils.isEmpty(optString)) {
                pi("shareVideo: videoPath is invalid");
            } else {
                String oy = l.oy(optString);
                if (TextUtils.isEmpty(oy)) {
                    pi("shareVideo: videoPath is invalid");
                } else {
                    cVar = new c();
                    cVar.videoPath = oy;
                    cVar.title = this.cmb.optString("title");
                    cVar.query = this.cmb.optString("query");
                    d dVar = new d();
                    dVar.coa = this.cmb.optLong("clipMaxDuration", 30L);
                    dVar.cob = this.cmb.optLong("clipMinDuration", 3L);
                    dVar.coc = this.cmb.optString("topicSource");
                    dVar.cod = this.cmb.optString("publishTitle", com.baidu.swan.apps.w.a.RG().getResources().getString(a.h.swangame_publish_video));
                    dVar.coe = this.cmb.optString("publishURL", "/searchbox?action=ugc&cmd=177");
                    dVar.sourceType = this.cmb.optInt("sourceType", 1);
                    dVar.sourceFrom = this.cmb.optString("sourceFrom", "tiny");
                    dVar.cog = this.cmb.optString("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                    dVar.cof = this.cmb.optString("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                    dVar.coh = this.cmb.optString("topicURL", "baiduboxapp://v1/easybrowse/open?url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dsearch&style=%7b%22menumode%22%3a%222%22%2c%22showtoolbar%22%3a%221%22%7d&newbrowser=1");
                    dVar.publishType = this.cmb.optString("publishType", "9");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.aar());
                        jSONObject.put("frame_type", com.baidu.swan.apps.runtime.d.aam().Ed());
                        jSONObject.put("query", cVar.query);
                        if (com.baidu.swan.apps.runtime.e.aap() != null && com.baidu.swan.apps.runtime.e.aap().En() != null) {
                            jSONObject.put("title", com.baidu.swan.apps.runtime.e.aap().En().OL());
                        }
                    } catch (JSONException e) {
                        if (DEBUG) {
                            Log.d("ShareVideoApi", e.toString());
                        }
                    }
                    dVar.swan = jSONObject.toString();
                    if (!TextUtils.isEmpty(cnV)) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("id", cnV);
                            if (com.baidu.swan.apps.runtime.e.aap() != null && com.baidu.swan.apps.runtime.e.aap().En() != null) {
                                jSONObject2.put("name", com.baidu.swan.apps.runtime.e.aap().En().OL());
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
                    cVar.cnZ = dVar;
                }
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pi(String str) {
        if (this.cmb != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            bVar.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
            com.baidu.swan.games.utils.b.a(this.cmb, false, bVar);
            anj();
        }
    }

    private void anj() {
        e eVar = new e();
        eVar.mType = UgcPluginInfo.METHOD_SHARE_VIDEO;
        eVar.mValue = LivenessStat.TYPE_FACE_MATCH_FAIL;
        f.a(eVar);
    }

    public static void ank() {
        com.baidu.swan.games.network.b aaC = com.baidu.swan.apps.runtime.e.aap().aaC();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_type", 0);
            jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.aar());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
        newBuilder.addQueryParameter("data", jSONObject.toString());
        aaC.a(new Request.Builder().url(newBuilder.build()).build(), new Callback() { // from class: com.baidu.swan.games.t.b.a.3
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (a.DEBUG) {
                    iOException.printStackTrace();
                }
                a.anl();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    JSONObject jSONObject2 = (JSONObject) new JSONObject(response.body().string()).opt("data");
                    if (jSONObject2 != null) {
                        String unused = a.cnV = jSONObject2.optString("community_id");
                        String unused2 = a.mUrl = jSONObject2.optString("url");
                    } else {
                        a.anl();
                    }
                } catch (JSONException e2) {
                    if (a.DEBUG) {
                        e2.printStackTrace();
                    }
                    a.anl();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void anl() {
        cnV = "";
        mUrl = "";
    }
}
