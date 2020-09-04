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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String dwL = "";
    private static String mUrl = "";
    private com.baidu.swan.games.binding.model.c duS;

    public a(JsObject jsObject) {
        this.duS = com.baidu.swan.games.binding.model.c.e(jsObject);
    }

    public void age() {
        e eVar = new e();
        eVar.mType = UgcPluginInfo.METHOD_SHARE_VIDEO;
        h.d(eVar);
        final c aPi = aPi();
        if (aPi != null) {
            com.baidu.swan.apps.a.b azV = com.baidu.swan.apps.runtime.e.azI().azV();
            if (azV.isLogin(com.baidu.swan.apps.t.a.aoJ())) {
                a(aPi);
                return;
            }
            SwanAppActivity arI = f.arY().arI();
            if (arI == null) {
                vK("shareVideo: swanAppActivity is null");
            } else {
                azV.a(arI, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.u.b.a.1
                    @Override // com.baidu.swan.apps.a.a
                    public void onResult(int i) {
                        switch (i) {
                            case 0:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login success");
                                }
                                a.this.a(aPi);
                                return;
                            default:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login fail");
                                }
                                a.this.vK("shareVideo: fail, no login in");
                                return;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        com.baidu.swan.games.m.a.aOq().a(cVar, new b() { // from class: com.baidu.swan.games.u.b.a.2
            @Override // com.baidu.swan.games.u.b.b
            public void a(c cVar2, String str) {
                if (a.DEBUG) {
                    Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", cVar2, str));
                }
                a.this.vK(str);
            }
        });
    }

    private c aPi() {
        c cVar = null;
        if (this.duS == null) {
            aPj();
        } else if (com.baidu.swan.apps.runtime.e.azI() == null) {
            vK("shareVideo: fail, swanApp is null");
        } else {
            String optString = this.duS.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
            if (TextUtils.isEmpty(optString)) {
                vK("shareVideo: videoPath is invalid");
            } else {
                String va = n.va(optString);
                if (TextUtils.isEmpty(va)) {
                    vK("shareVideo: videoPath is invalid");
                } else {
                    cVar = new c();
                    cVar.videoPath = va;
                    cVar.title = this.duS.optString("title");
                    cVar.query = this.duS.optString("query");
                    d dVar = new d();
                    dVar.dwQ = this.duS.optLong("clipMaxDuration", 30L);
                    dVar.dwR = this.duS.optLong("clipMinDuration", 3L);
                    dVar.dwS = this.duS.optString("topicSource");
                    dVar.dwT = this.duS.optString("publishTitle", com.baidu.swan.apps.t.a.aoJ().getResources().getString(a.h.swangame_publish_video));
                    dVar.dwU = this.duS.optString("publishURL", "/searchbox?action=ugc&cmd=177");
                    dVar.sourceType = this.duS.optInt("sourceType", 1);
                    dVar.sourceFrom = this.duS.optString("sourceFrom", "tiny");
                    dVar.dwW = this.duS.optString("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                    dVar.dwV = this.duS.optString("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                    dVar.dwX = this.duS.optString("topicURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fsv.baidu.com%2Ffeedvideoui%2Fview%2Ftopiclist");
                    dVar.publishType = this.duS.optString(UgcConstant.PUBLISH_TYPE, "9");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.azK());
                        jSONObject.put("frame_type", com.baidu.swan.apps.runtime.d.azE().XP());
                        jSONObject.put("query", cVar.query);
                        if (com.baidu.swan.apps.runtime.e.azI() != null && com.baidu.swan.apps.runtime.e.azI().XZ() != null) {
                            jSONObject.put("title", com.baidu.swan.apps.runtime.e.azI().XZ().akO());
                        }
                    } catch (JSONException e) {
                        if (DEBUG) {
                            Log.d("ShareVideoApi", e.toString());
                        }
                    }
                    dVar.swan = jSONObject.toString();
                    if (!TextUtils.isEmpty(dwL)) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("id", dwL);
                            if (com.baidu.swan.apps.runtime.e.azI() != null && com.baidu.swan.apps.runtime.e.azI().XZ() != null) {
                                jSONObject2.put("name", com.baidu.swan.apps.runtime.e.azI().XZ().akO());
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
                    cVar.dwP = dVar;
                }
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vK(String str) {
        if (this.duS != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            bVar.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
            com.baidu.swan.games.utils.b.a(this.duS, false, bVar);
            aPj();
        }
    }

    private void aPj() {
        e eVar = new e();
        eVar.mType = UgcPluginInfo.METHOD_SHARE_VIDEO;
        eVar.mValue = "fail";
        h.d(eVar);
    }

    public static void aPk() {
        com.baidu.swan.games.network.b azX = com.baidu.swan.apps.runtime.e.azI().azX();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_type", 0);
            jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.azK());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
        newBuilder.addQueryParameter("data", jSONObject.toString());
        azX.a(new Request.Builder().url(newBuilder.build()).build(), new Callback() { // from class: com.baidu.swan.games.u.b.a.3
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (a.DEBUG) {
                    iOException.printStackTrace();
                }
                a.aPl();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    JSONObject jSONObject2 = (JSONObject) new JSONObject(response.body().string()).opt("data");
                    if (jSONObject2 != null) {
                        String unused = a.dwL = jSONObject2.optString("community_id");
                        String unused2 = a.mUrl = jSONObject2.optString("url");
                    } else {
                        a.aPl();
                    }
                } catch (JSONException e2) {
                    if (a.DEBUG) {
                        e2.printStackTrace();
                    }
                    a.aPl();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aPl() {
        dwL = "";
        mUrl = "";
    }
}
