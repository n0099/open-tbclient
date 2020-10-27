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
    private static String dTk = "";
    private static String mUrl = "";
    private com.baidu.swan.games.binding.model.c dRr;

    public a(JsObject jsObject) {
        this.dRr = com.baidu.swan.games.binding.model.c.e(jsObject);
    }

    public void alt() {
        e eVar = new e();
        eVar.mType = UgcPluginInfo.METHOD_SHARE_VIDEO;
        h.d(eVar);
        final c aUw = aUw();
        if (aUw != null) {
            com.baidu.swan.apps.a.b aFh = com.baidu.swan.apps.runtime.e.aEU().aFh();
            if (aFh.isLogin(com.baidu.swan.apps.t.a.aua())) {
                a(aUw);
                return;
            }
            SwanAppActivity awY = f.axo().awY();
            if (awY == null) {
                xi("shareVideo: swanAppActivity is null");
            } else {
                aFh.a(awY, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.u.b.a.1
                    @Override // com.baidu.swan.apps.a.a
                    public void onResult(int i) {
                        switch (i) {
                            case 0:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login success");
                                }
                                a.this.a(aUw);
                                return;
                            default:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login fail");
                                }
                                a.this.xi("shareVideo: fail, no login in");
                                return;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        com.baidu.swan.games.m.a.aTE().a(cVar, new b() { // from class: com.baidu.swan.games.u.b.a.2
            @Override // com.baidu.swan.games.u.b.b
            public void a(c cVar2, String str) {
                if (a.DEBUG) {
                    Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", cVar2, str));
                }
                a.this.xi(str);
            }
        });
    }

    private c aUw() {
        c cVar = null;
        if (this.dRr == null) {
            aUx();
        } else if (com.baidu.swan.apps.runtime.e.aEU() == null) {
            xi("shareVideo: fail, swanApp is null");
        } else {
            String optString = this.dRr.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
            if (TextUtils.isEmpty(optString)) {
                xi("shareVideo: videoPath is invalid");
            } else {
                String wy = n.wy(optString);
                if (TextUtils.isEmpty(wy)) {
                    xi("shareVideo: videoPath is invalid");
                } else {
                    cVar = new c();
                    cVar.videoPath = wy;
                    cVar.title = this.dRr.optString("title");
                    cVar.query = this.dRr.optString("query");
                    d dVar = new d();
                    dVar.dTp = this.dRr.optLong("clipMaxDuration", 30L);
                    dVar.dTq = this.dRr.optLong("clipMinDuration", 3L);
                    dVar.dTr = this.dRr.optString("topicSource");
                    dVar.dTs = this.dRr.optString("publishTitle", com.baidu.swan.apps.t.a.aua().getResources().getString(a.h.swangame_publish_video));
                    dVar.dTt = this.dRr.optString("publishURL", "/searchbox?action=ugc&cmd=177");
                    dVar.sourceType = this.dRr.optInt("sourceType", 1);
                    dVar.sourceFrom = this.dRr.optString("sourceFrom", "tiny");
                    dVar.dTv = this.dRr.optString("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                    dVar.dTu = this.dRr.optString("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                    dVar.dTw = this.dRr.optString("topicURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fsv.baidu.com%2Ffeedvideoui%2Fview%2Ftopiclist");
                    dVar.publishType = this.dRr.optString(UgcConstant.PUBLISH_TYPE, "9");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.aEW());
                        jSONObject.put("frame_type", com.baidu.swan.apps.runtime.d.aEQ().ade());
                        jSONObject.put("query", cVar.query);
                        if (com.baidu.swan.apps.runtime.e.aEU() != null && com.baidu.swan.apps.runtime.e.aEU().ado() != null) {
                            jSONObject.put("title", com.baidu.swan.apps.runtime.e.aEU().ado().aqe());
                        }
                    } catch (JSONException e) {
                        if (DEBUG) {
                            Log.d("ShareVideoApi", e.toString());
                        }
                    }
                    dVar.swan = jSONObject.toString();
                    if (!TextUtils.isEmpty(dTk)) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("id", dTk);
                            if (com.baidu.swan.apps.runtime.e.aEU() != null && com.baidu.swan.apps.runtime.e.aEU().ado() != null) {
                                jSONObject2.put("name", com.baidu.swan.apps.runtime.e.aEU().ado().aqe());
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
                    cVar.dTo = dVar;
                }
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xi(String str) {
        if (this.dRr != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            bVar.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
            com.baidu.swan.games.utils.b.a(this.dRr, false, bVar);
            aUx();
        }
    }

    private void aUx() {
        e eVar = new e();
        eVar.mType = UgcPluginInfo.METHOD_SHARE_VIDEO;
        eVar.mValue = "fail";
        h.d(eVar);
    }

    public static void aUy() {
        com.baidu.swan.games.network.b aFj = com.baidu.swan.apps.runtime.e.aEU().aFj();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_type", 0);
            jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.aEW());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
        newBuilder.addQueryParameter("data", jSONObject.toString());
        aFj.a(new Request.Builder().url(newBuilder.build()).build(), new Callback() { // from class: com.baidu.swan.games.u.b.a.3
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (a.DEBUG) {
                    iOException.printStackTrace();
                }
                a.aUz();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    JSONObject jSONObject2 = (JSONObject) new JSONObject(response.body().string()).opt("data");
                    if (jSONObject2 != null) {
                        String unused = a.dTk = jSONObject2.optString("community_id");
                        String unused2 = a.mUrl = jSONObject2.optString("url");
                    } else {
                        a.aUz();
                    }
                } catch (JSONException e2) {
                    if (a.DEBUG) {
                        e2.printStackTrace();
                    }
                    a.aUz();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aUz() {
        dTk = "";
        mUrl = "";
    }
}
