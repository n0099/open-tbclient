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
import com.baidu.swan.apps.w.f;
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
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String dgT = "";
    private static String mUrl = "";
    private com.baidu.swan.games.binding.model.c deZ;

    public a(JsObject jsObject) {
        this.deZ = com.baidu.swan.games.binding.model.c.e(jsObject);
    }

    public void Zy() {
        e eVar = new e();
        eVar.mType = UgcPluginInfo.METHOD_SHARE_VIDEO;
        h.d(eVar);
        final c aCK = aCK();
        if (aCK != null) {
            com.baidu.swan.apps.a.b apZ = com.baidu.swan.apps.runtime.e.apM().apZ();
            if (apZ.isLogin(com.baidu.swan.apps.u.a.afX())) {
                a(aCK);
                return;
            }
            SwanAppActivity aiL = f.ajb().aiL();
            if (aiL == null) {
                sv("shareVideo: swanAppActivity is null");
            } else {
                apZ.a(aiL, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.u.b.a.1
                    @Override // com.baidu.swan.apps.a.a
                    public void onResult(int i) {
                        switch (i) {
                            case 0:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login success");
                                }
                                a.this.a(aCK);
                                return;
                            default:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login fail");
                                }
                                a.this.sv("shareVideo: fail, no login in");
                                return;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        com.baidu.swan.games.m.a.aBU().a(cVar, new b() { // from class: com.baidu.swan.games.u.b.a.2
            @Override // com.baidu.swan.games.u.b.b
            public void a(c cVar2, String str) {
                if (a.DEBUG) {
                    Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", cVar2, str));
                }
                a.this.sv(str);
            }
        });
    }

    private c aCK() {
        c cVar = null;
        if (this.deZ == null) {
            aCL();
        } else if (com.baidu.swan.apps.runtime.e.apM() == null) {
            sv("shareVideo: fail, swanApp is null");
        } else {
            String optString = this.deZ.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
            if (TextUtils.isEmpty(optString)) {
                sv("shareVideo: videoPath is invalid");
            } else {
                String rJ = n.rJ(optString);
                if (TextUtils.isEmpty(rJ)) {
                    sv("shareVideo: videoPath is invalid");
                } else {
                    cVar = new c();
                    cVar.videoPath = rJ;
                    cVar.title = this.deZ.optString("title");
                    cVar.query = this.deZ.optString("query");
                    d dVar = new d();
                    dVar.dgY = this.deZ.optLong("clipMaxDuration", 30L);
                    dVar.dgZ = this.deZ.optLong("clipMinDuration", 3L);
                    dVar.dha = this.deZ.optString("topicSource");
                    dVar.dhb = this.deZ.optString("publishTitle", com.baidu.swan.apps.u.a.afX().getResources().getString(a.h.swangame_publish_video));
                    dVar.dhc = this.deZ.optString("publishURL", "/searchbox?action=ugc&cmd=177");
                    dVar.sourceType = this.deZ.optInt("sourceType", 1);
                    dVar.sourceFrom = this.deZ.optString("sourceFrom", "tiny");
                    dVar.dhe = this.deZ.optString("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                    dVar.dhd = this.deZ.optString("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                    dVar.dhf = this.deZ.optString("topicURL", "baiduboxapp://v1/easybrowse/open?url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dsearch&style=%7b%22menumode%22%3a%222%22%2c%22showtoolbar%22%3a%221%22%7d&newbrowser=1");
                    dVar.publishType = this.deZ.optString(UgcConstant.PUBLISH_TYPE, "9");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.apO());
                        jSONObject.put("frame_type", com.baidu.swan.apps.runtime.d.apI().RF());
                        jSONObject.put("query", cVar.query);
                        if (com.baidu.swan.apps.runtime.e.apM() != null && com.baidu.swan.apps.runtime.e.apM().RP() != null) {
                            jSONObject.put("title", com.baidu.swan.apps.runtime.e.apM().RP().acZ());
                        }
                    } catch (JSONException e) {
                        if (DEBUG) {
                            Log.d("ShareVideoApi", e.toString());
                        }
                    }
                    dVar.swan = jSONObject.toString();
                    if (!TextUtils.isEmpty(dgT)) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("id", dgT);
                            if (com.baidu.swan.apps.runtime.e.apM() != null && com.baidu.swan.apps.runtime.e.apM().RP() != null) {
                                jSONObject2.put("name", com.baidu.swan.apps.runtime.e.apM().RP().acZ());
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
                    cVar.dgX = dVar;
                }
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sv(String str) {
        if (this.deZ != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            bVar.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
            com.baidu.swan.games.utils.b.a(this.deZ, false, bVar);
            aCL();
        }
    }

    private void aCL() {
        e eVar = new e();
        eVar.mType = UgcPluginInfo.METHOD_SHARE_VIDEO;
        eVar.mValue = "fail";
        h.d(eVar);
    }

    public static void aCM() {
        com.baidu.swan.games.network.b aqb = com.baidu.swan.apps.runtime.e.apM().aqb();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_type", 0);
            jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.apO());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
        newBuilder.addQueryParameter("data", jSONObject.toString());
        aqb.a(new Request.Builder().url(newBuilder.build()).build(), new Callback() { // from class: com.baidu.swan.games.u.b.a.3
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (a.DEBUG) {
                    iOException.printStackTrace();
                }
                a.aCN();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    JSONObject jSONObject2 = (JSONObject) new JSONObject(response.body().string()).opt("data");
                    if (jSONObject2 != null) {
                        String unused = a.dgT = jSONObject2.optString("community_id");
                        String unused2 = a.mUrl = jSONObject2.optString("url");
                    } else {
                        a.aCN();
                    }
                } catch (JSONException e2) {
                    if (a.DEBUG) {
                        e2.printStackTrace();
                    }
                    a.aCN();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aCN() {
        dgT = "";
        mUrl = "";
    }
}
