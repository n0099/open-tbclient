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
/* loaded from: classes3.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String dyM = "";
    private static String mUrl = "";
    private com.baidu.swan.games.binding.model.c dwT;

    public a(JsObject jsObject) {
        this.dwT = com.baidu.swan.games.binding.model.c.e(jsObject);
    }

    public void agO() {
        e eVar = new e();
        eVar.mType = UgcPluginInfo.METHOD_SHARE_VIDEO;
        h.d(eVar);
        final c aPT = aPT();
        if (aPT != null) {
            com.baidu.swan.apps.a.b aAE = com.baidu.swan.apps.runtime.e.aAr().aAE();
            if (aAE.isLogin(com.baidu.swan.apps.t.a.apu())) {
                a(aPT);
                return;
            }
            SwanAppActivity ast = f.asJ().ast();
            if (ast == null) {
                wd("shareVideo: swanAppActivity is null");
            } else {
                aAE.a(ast, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.u.b.a.1
                    @Override // com.baidu.swan.apps.a.a
                    public void onResult(int i) {
                        switch (i) {
                            case 0:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login success");
                                }
                                a.this.a(aPT);
                                return;
                            default:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login fail");
                                }
                                a.this.wd("shareVideo: fail, no login in");
                                return;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        com.baidu.swan.games.m.a.aPb().a(cVar, new b() { // from class: com.baidu.swan.games.u.b.a.2
            @Override // com.baidu.swan.games.u.b.b
            public void a(c cVar2, String str) {
                if (a.DEBUG) {
                    Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", cVar2, str));
                }
                a.this.wd(str);
            }
        });
    }

    private c aPT() {
        c cVar = null;
        if (this.dwT == null) {
            aPU();
        } else if (com.baidu.swan.apps.runtime.e.aAr() == null) {
            wd("shareVideo: fail, swanApp is null");
        } else {
            String optString = this.dwT.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
            if (TextUtils.isEmpty(optString)) {
                wd("shareVideo: videoPath is invalid");
            } else {
                String vt = n.vt(optString);
                if (TextUtils.isEmpty(vt)) {
                    wd("shareVideo: videoPath is invalid");
                } else {
                    cVar = new c();
                    cVar.videoPath = vt;
                    cVar.title = this.dwT.optString("title");
                    cVar.query = this.dwT.optString("query");
                    d dVar = new d();
                    dVar.dyR = this.dwT.optLong("clipMaxDuration", 30L);
                    dVar.dyS = this.dwT.optLong("clipMinDuration", 3L);
                    dVar.dyT = this.dwT.optString("topicSource");
                    dVar.dyU = this.dwT.optString("publishTitle", com.baidu.swan.apps.t.a.apu().getResources().getString(a.h.swangame_publish_video));
                    dVar.dyV = this.dwT.optString("publishURL", "/searchbox?action=ugc&cmd=177");
                    dVar.sourceType = this.dwT.optInt("sourceType", 1);
                    dVar.sourceFrom = this.dwT.optString("sourceFrom", "tiny");
                    dVar.dyX = this.dwT.optString("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                    dVar.dyW = this.dwT.optString("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                    dVar.dyY = this.dwT.optString("topicURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fsv.baidu.com%2Ffeedvideoui%2Fview%2Ftopiclist");
                    dVar.publishType = this.dwT.optString(UgcConstant.PUBLISH_TYPE, "9");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.aAt());
                        jSONObject.put("frame_type", com.baidu.swan.apps.runtime.d.aAn().Yy());
                        jSONObject.put("query", cVar.query);
                        if (com.baidu.swan.apps.runtime.e.aAr() != null && com.baidu.swan.apps.runtime.e.aAr().YI() != null) {
                            jSONObject.put("title", com.baidu.swan.apps.runtime.e.aAr().YI().aly());
                        }
                    } catch (JSONException e) {
                        if (DEBUG) {
                            Log.d("ShareVideoApi", e.toString());
                        }
                    }
                    dVar.swan = jSONObject.toString();
                    if (!TextUtils.isEmpty(dyM)) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("id", dyM);
                            if (com.baidu.swan.apps.runtime.e.aAr() != null && com.baidu.swan.apps.runtime.e.aAr().YI() != null) {
                                jSONObject2.put("name", com.baidu.swan.apps.runtime.e.aAr().YI().aly());
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
                    cVar.dyQ = dVar;
                }
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wd(String str) {
        if (this.dwT != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            bVar.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
            com.baidu.swan.games.utils.b.a(this.dwT, false, bVar);
            aPU();
        }
    }

    private void aPU() {
        e eVar = new e();
        eVar.mType = UgcPluginInfo.METHOD_SHARE_VIDEO;
        eVar.mValue = "fail";
        h.d(eVar);
    }

    public static void aPV() {
        com.baidu.swan.games.network.b aAG = com.baidu.swan.apps.runtime.e.aAr().aAG();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_type", 0);
            jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.aAt());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
        newBuilder.addQueryParameter("data", jSONObject.toString());
        aAG.a(new Request.Builder().url(newBuilder.build()).build(), new Callback() { // from class: com.baidu.swan.games.u.b.a.3
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (a.DEBUG) {
                    iOException.printStackTrace();
                }
                a.aPW();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    JSONObject jSONObject2 = (JSONObject) new JSONObject(response.body().string()).opt("data");
                    if (jSONObject2 != null) {
                        String unused = a.dyM = jSONObject2.optString("community_id");
                        String unused2 = a.mUrl = jSONObject2.optString("url");
                    } else {
                        a.aPW();
                    }
                } catch (JSONException e2) {
                    if (a.DEBUG) {
                        e2.printStackTrace();
                    }
                    a.aPW();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aPW() {
        dyM = "";
        mUrl = "";
    }
}
