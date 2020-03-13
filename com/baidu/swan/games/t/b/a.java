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
    private static String crZ = "";
    private static String mUrl = "";
    private com.baidu.swan.games.binding.model.c cqg;

    public a(JsObject jsObject) {
        this.cqg = com.baidu.swan.games.binding.model.c.c(jsObject);
    }

    public void NR() {
        e eVar = new e();
        eVar.mType = UgcPluginInfo.METHOD_SHARE_VIDEO;
        f.a(eVar);
        final c apy = apy();
        if (apy != null) {
            com.baidu.swan.apps.a.b acQ = com.baidu.swan.apps.runtime.e.acF().acQ();
            if (acQ.isLogin(com.baidu.swan.apps.w.a.TW())) {
                a(apy);
                return;
            }
            SwanAppActivity WD = com.baidu.swan.apps.y.f.WS().WD();
            if (WD == null) {
                px("shareVideo: swanAppActivity is null");
            } else {
                acQ.a(WD, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.t.b.a.1
                    @Override // com.baidu.swan.apps.a.a
                    public void onResult(int i) {
                        switch (i) {
                            case 0:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login success");
                                }
                                a.this.a(apy);
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
        com.baidu.swan.games.l.a.aoJ().a(cVar, new b() { // from class: com.baidu.swan.games.t.b.a.2
            @Override // com.baidu.swan.games.t.b.b
            public void a(c cVar2, String str) {
                if (a.DEBUG) {
                    Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", cVar2, str));
                }
                a.this.px(str);
            }
        });
    }

    private c apy() {
        c cVar = null;
        if (this.cqg == null) {
            apz();
        } else if (com.baidu.swan.apps.runtime.e.acF() == null) {
            px("shareVideo: fail, swanApp is null");
        } else {
            String optString = this.cqg.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
            if (TextUtils.isEmpty(optString)) {
                px("shareVideo: videoPath is invalid");
            } else {
                String oN = l.oN(optString);
                if (TextUtils.isEmpty(oN)) {
                    px("shareVideo: videoPath is invalid");
                } else {
                    cVar = new c();
                    cVar.videoPath = oN;
                    cVar.title = this.cqg.optString("title");
                    cVar.query = this.cqg.optString("query");
                    d dVar = new d();
                    dVar.cse = this.cqg.optLong("clipMaxDuration", 30L);
                    dVar.csf = this.cqg.optLong("clipMinDuration", 3L);
                    dVar.csg = this.cqg.optString("topicSource");
                    dVar.csh = this.cqg.optString("publishTitle", com.baidu.swan.apps.w.a.TW().getResources().getString(a.h.swangame_publish_video));
                    dVar.csi = this.cqg.optString("publishURL", "/searchbox?action=ugc&cmd=177");
                    dVar.sourceType = this.cqg.optInt("sourceType", 1);
                    dVar.sourceFrom = this.cqg.optString("sourceFrom", "tiny");
                    dVar.csk = this.cqg.optString("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                    dVar.csj = this.cqg.optString("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                    dVar.csl = this.cqg.optString("topicURL", "baiduboxapp://v1/easybrowse/open?url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dsearch&style=%7b%22menumode%22%3a%222%22%2c%22showtoolbar%22%3a%221%22%7d&newbrowser=1");
                    dVar.publishType = this.cqg.optString("publishType", "9");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.acH());
                        jSONObject.put("frame_type", com.baidu.swan.apps.runtime.d.acC().Gu());
                        jSONObject.put("query", cVar.query);
                        if (com.baidu.swan.apps.runtime.e.acF() != null && com.baidu.swan.apps.runtime.e.acF().GE() != null) {
                            jSONObject.put("title", com.baidu.swan.apps.runtime.e.acF().GE().Rb());
                        }
                    } catch (JSONException e) {
                        if (DEBUG) {
                            Log.d("ShareVideoApi", e.toString());
                        }
                    }
                    dVar.swan = jSONObject.toString();
                    if (!TextUtils.isEmpty(crZ)) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("id", crZ);
                            if (com.baidu.swan.apps.runtime.e.acF() != null && com.baidu.swan.apps.runtime.e.acF().GE() != null) {
                                jSONObject2.put("name", com.baidu.swan.apps.runtime.e.acF().GE().Rb());
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
                    cVar.csd = dVar;
                }
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void px(String str) {
        if (this.cqg != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            bVar.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
            com.baidu.swan.games.utils.b.a(this.cqg, false, bVar);
            apz();
        }
    }

    private void apz() {
        e eVar = new e();
        eVar.mType = UgcPluginInfo.METHOD_SHARE_VIDEO;
        eVar.mValue = LivenessStat.TYPE_FACE_MATCH_FAIL;
        f.a(eVar);
    }

    public static void apA() {
        com.baidu.swan.games.network.b acS = com.baidu.swan.apps.runtime.e.acF().acS();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_type", 0);
            jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.acH());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
        newBuilder.addQueryParameter("data", jSONObject.toString());
        acS.a(new Request.Builder().url(newBuilder.build()).build(), new Callback() { // from class: com.baidu.swan.games.t.b.a.3
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (a.DEBUG) {
                    iOException.printStackTrace();
                }
                a.apB();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    JSONObject jSONObject2 = (JSONObject) new JSONObject(response.body().string()).opt("data");
                    if (jSONObject2 != null) {
                        String unused = a.crZ = jSONObject2.optString("community_id");
                        String unused2 = a.mUrl = jSONObject2.optString("url");
                    } else {
                        a.apB();
                    }
                } catch (JSONException e2) {
                    if (a.DEBUG) {
                        e2.printStackTrace();
                    }
                    a.apB();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void apB() {
        crZ = "";
        mUrl = "";
    }
}
