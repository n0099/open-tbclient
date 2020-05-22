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
    private static String dcg = "";
    private static String mUrl = "";
    private com.baidu.swan.games.binding.model.c dak;

    public a(JsObject jsObject) {
        this.dak = com.baidu.swan.games.binding.model.c.e(jsObject);
    }

    public void Ys() {
        e eVar = new e();
        eVar.mType = UgcPluginInfo.METHOD_SHARE_VIDEO;
        h.d(eVar);
        final c aBE = aBE();
        if (aBE != null) {
            com.baidu.swan.apps.a.b aoS = com.baidu.swan.apps.runtime.e.aoF().aoS();
            if (aoS.isLogin(com.baidu.swan.apps.u.a.aeR())) {
                a(aBE);
                return;
            }
            SwanAppActivity ahF = f.ahV().ahF();
            if (ahF == null) {
                sm("shareVideo: swanAppActivity is null");
            } else {
                aoS.a(ahF, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.u.b.a.1
                    @Override // com.baidu.swan.apps.a.a
                    public void onResult(int i) {
                        switch (i) {
                            case 0:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login success");
                                }
                                a.this.a(aBE);
                                return;
                            default:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login fail");
                                }
                                a.this.sm("shareVideo: fail, no login in");
                                return;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        com.baidu.swan.games.m.a.aAO().a(cVar, new b() { // from class: com.baidu.swan.games.u.b.a.2
            @Override // com.baidu.swan.games.u.b.b
            public void a(c cVar2, String str) {
                if (a.DEBUG) {
                    Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", cVar2, str));
                }
                a.this.sm(str);
            }
        });
    }

    private c aBE() {
        c cVar = null;
        if (this.dak == null) {
            aBF();
        } else if (com.baidu.swan.apps.runtime.e.aoF() == null) {
            sm("shareVideo: fail, swanApp is null");
        } else {
            String optString = this.dak.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
            if (TextUtils.isEmpty(optString)) {
                sm("shareVideo: videoPath is invalid");
            } else {
                String rB = n.rB(optString);
                if (TextUtils.isEmpty(rB)) {
                    sm("shareVideo: videoPath is invalid");
                } else {
                    cVar = new c();
                    cVar.videoPath = rB;
                    cVar.title = this.dak.optString("title");
                    cVar.query = this.dak.optString("query");
                    d dVar = new d();
                    dVar.dcl = this.dak.optLong("clipMaxDuration", 30L);
                    dVar.dcm = this.dak.optLong("clipMinDuration", 3L);
                    dVar.dcn = this.dak.optString("topicSource");
                    dVar.dco = this.dak.optString("publishTitle", com.baidu.swan.apps.u.a.aeR().getResources().getString(a.h.swangame_publish_video));
                    dVar.dcp = this.dak.optString("publishURL", "/searchbox?action=ugc&cmd=177");
                    dVar.sourceType = this.dak.optInt("sourceType", 1);
                    dVar.sourceFrom = this.dak.optString("sourceFrom", "tiny");
                    dVar.dcr = this.dak.optString("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                    dVar.dcq = this.dak.optString("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                    dVar.dcs = this.dak.optString("topicURL", "baiduboxapp://v1/easybrowse/open?url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dsearch&style=%7b%22menumode%22%3a%222%22%2c%22showtoolbar%22%3a%221%22%7d&newbrowser=1");
                    dVar.publishType = this.dak.optString(UgcConstant.PUBLISH_TYPE, "9");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.aoH());
                        jSONObject.put("frame_type", com.baidu.swan.apps.runtime.d.aoB().Qz());
                        jSONObject.put("query", cVar.query);
                        if (com.baidu.swan.apps.runtime.e.aoF() != null && com.baidu.swan.apps.runtime.e.aoF().QJ() != null) {
                            jSONObject.put("title", com.baidu.swan.apps.runtime.e.aoF().QJ().abT());
                        }
                    } catch (JSONException e) {
                        if (DEBUG) {
                            Log.d("ShareVideoApi", e.toString());
                        }
                    }
                    dVar.swan = jSONObject.toString();
                    if (!TextUtils.isEmpty(dcg)) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("id", dcg);
                            if (com.baidu.swan.apps.runtime.e.aoF() != null && com.baidu.swan.apps.runtime.e.aoF().QJ() != null) {
                                jSONObject2.put("name", com.baidu.swan.apps.runtime.e.aoF().QJ().abT());
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
                    cVar.dck = dVar;
                }
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sm(String str) {
        if (this.dak != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            bVar.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
            com.baidu.swan.games.utils.b.a(this.dak, false, bVar);
            aBF();
        }
    }

    private void aBF() {
        e eVar = new e();
        eVar.mType = UgcPluginInfo.METHOD_SHARE_VIDEO;
        eVar.mValue = "fail";
        h.d(eVar);
    }

    public static void aBG() {
        com.baidu.swan.games.network.b aoU = com.baidu.swan.apps.runtime.e.aoF().aoU();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_type", 0);
            jSONObject.put("app_key", com.baidu.swan.apps.runtime.e.aoH());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
        newBuilder.addQueryParameter("data", jSONObject.toString());
        aoU.a(new Request.Builder().url(newBuilder.build()).build(), new Callback() { // from class: com.baidu.swan.games.u.b.a.3
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (a.DEBUG) {
                    iOException.printStackTrace();
                }
                a.aBH();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    JSONObject jSONObject2 = (JSONObject) new JSONObject(response.body().string()).opt("data");
                    if (jSONObject2 != null) {
                        String unused = a.dcg = jSONObject2.optString("community_id");
                        String unused2 = a.mUrl = jSONObject2.optString("url");
                    } else {
                        a.aBH();
                    }
                } catch (JSONException e2) {
                    if (a.DEBUG) {
                        e2.printStackTrace();
                    }
                    a.aBH();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aBH() {
        dcg = "";
        mUrl = "";
    }
}
