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
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String crX = "";
    private static String mUrl = "";
    private com.baidu.swan.games.binding.model.c cqe;

    public a(JsObject jsObject) {
        this.cqe = com.baidu.swan.games.binding.model.c.c(jsObject);
    }

    public void NP() {
        e eVar = new e();
        eVar.mType = UgcPluginInfo.METHOD_SHARE_VIDEO;
        f.a(eVar);
        final c apw = apw();
        if (apw != null) {
            com.baidu.swan.apps.a.b acO = com.baidu.swan.apps.runtime.e.acD().acO();
            if (acO.isLogin(com.baidu.swan.apps.w.a.TU())) {
                a(apw);
                return;
            }
            SwanAppActivity WB = com.baidu.swan.apps.y.f.WQ().WB();
            if (WB == null) {
                px("shareVideo: swanAppActivity is null");
            } else {
                acO.a(WB, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.t.b.a.1
                    @Override // com.baidu.swan.apps.a.a
                    public void onResult(int i) {
                        switch (i) {
                            case 0:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login success");
                                }
                                a.this.a(apw);
                                return;
                            default:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login fail");
                                }
                                a.this.px("shareVideo: fail, no login in");
                                return;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        com.baidu.swan.games.l.a.aoH().a(cVar, new b() { // from class: com.baidu.swan.games.t.b.a.2
            @Override // com.baidu.swan.games.t.b.b
            public void a(c cVar2, String str) {
                if (a.DEBUG) {
                    Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", cVar2, str));
                }
                a.this.px(str);
            }
        });
    }

    private c apw() {
        c cVar = null;
        if (this.cqe == null) {
            apx();
        } else if (com.baidu.swan.apps.runtime.e.acD() == null) {
            px("shareVideo: fail, swanApp is null");
        } else {
            String optString = this.cqe.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
            if (TextUtils.isEmpty(optString)) {
                px("shareVideo: videoPath is invalid");
            } else {
                String oN = l.oN(optString);
                if (TextUtils.isEmpty(oN)) {
                    px("shareVideo: videoPath is invalid");
                } else {
                    cVar = new c();
                    cVar.videoPath = oN;
                    cVar.title = this.cqe.optString("title");
                    cVar.query = this.cqe.optString("query");
                    d dVar = new d();
                    dVar.csc = this.cqe.optLong("clipMaxDuration", 30L);
                    dVar.csd = this.cqe.optLong("clipMinDuration", 3L);
                    dVar.cse = this.cqe.optString("topicSource");
                    dVar.csf = this.cqe.optString("publishTitle", com.baidu.swan.apps.w.a.TU().getResources().getString(a.h.swangame_publish_video));
                    dVar.csg = this.cqe.optString("publishURL", "/searchbox?action=ugc&cmd=177");
                    dVar.sourceType = this.cqe.optInt("sourceType", 1);
                    dVar.sourceFrom = this.cqe.optString("sourceFrom", "tiny");
                    dVar.csi = this.cqe.optString("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                    dVar.csh = this.cqe.optString("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                    dVar.csj = this.cqe.optString("topicURL", "baiduboxapp://v1/easybrowse/open?url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dsearch&style=%7b%22menumode%22%3a%222%22%2c%22showtoolbar%22%3a%221%22%7d&newbrowser=1");
                    dVar.publishType = this.cqe.optString("publishType", "9");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.acF());
                        jSONObject.put("frame_type", com.baidu.swan.apps.runtime.d.acA().Gs());
                        jSONObject.put("query", cVar.query);
                        if (com.baidu.swan.apps.runtime.e.acD() != null && com.baidu.swan.apps.runtime.e.acD().GC() != null) {
                            jSONObject.put("title", com.baidu.swan.apps.runtime.e.acD().GC().QZ());
                        }
                    } catch (JSONException e) {
                        if (DEBUG) {
                            Log.d("ShareVideoApi", e.toString());
                        }
                    }
                    dVar.swan = jSONObject.toString();
                    if (!TextUtils.isEmpty(crX)) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("id", crX);
                            if (com.baidu.swan.apps.runtime.e.acD() != null && com.baidu.swan.apps.runtime.e.acD().GC() != null) {
                                jSONObject2.put("name", com.baidu.swan.apps.runtime.e.acD().GC().QZ());
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
                    cVar.csb = dVar;
                }
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void px(String str) {
        if (this.cqe != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            bVar.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
            com.baidu.swan.games.utils.b.a(this.cqe, false, bVar);
            apx();
        }
    }

    private void apx() {
        e eVar = new e();
        eVar.mType = UgcPluginInfo.METHOD_SHARE_VIDEO;
        eVar.mValue = LivenessStat.TYPE_FACE_MATCH_FAIL;
        f.a(eVar);
    }

    public static void apy() {
        com.baidu.swan.games.network.b acQ = com.baidu.swan.apps.runtime.e.acD().acQ();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_type", 0);
            jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.acF());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
        newBuilder.addQueryParameter("data", jSONObject.toString());
        acQ.a(new Request.Builder().url(newBuilder.build()).build(), new Callback() { // from class: com.baidu.swan.games.t.b.a.3
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (a.DEBUG) {
                    iOException.printStackTrace();
                }
                a.apz();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    JSONObject jSONObject2 = (JSONObject) new JSONObject(response.body().string()).opt("data");
                    if (jSONObject2 != null) {
                        String unused = a.crX = jSONObject2.optString("community_id");
                        String unused2 = a.mUrl = jSONObject2.optString("url");
                    } else {
                        a.apz();
                    }
                } catch (JSONException e2) {
                    if (a.DEBUG) {
                        e2.printStackTrace();
                    }
                    a.apz();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void apz() {
        crX = "";
        mUrl = "";
    }
}
