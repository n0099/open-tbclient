package com.baidu.swan.games.q.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.apps.statistic.e;
import com.baidu.swan.games.f.g;
import com.tencent.connect.share.QzonePublish;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.binding.model.c bCK;

    public a(JsObject jsObject) {
        this.bCK = com.baidu.swan.games.binding.model.c.c(jsObject);
    }

    public void EU() {
        f fVar = new f();
        fVar.mType = "shareVideo";
        e.c(fVar);
        final c XX = XX();
        if (XX != null) {
            com.baidu.swan.apps.a.b Re = com.baidu.swan.apps.ae.b.QZ().Re();
            if (Re.isLogin(com.baidu.swan.apps.u.a.Ji())) {
                a(XX);
                return;
            }
            SwanAppActivity Lp = com.baidu.swan.apps.w.e.LD().Lp();
            if (Lp == null) {
                kw("shareVideo: swanAppActivity is null");
            } else {
                Re.a(Lp, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.q.b.a.1
                    @Override // com.baidu.swan.apps.a.a
                    public void onResult(int i) {
                        switch (i) {
                            case 0:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login success");
                                }
                                a.this.a(XX);
                                return;
                            default:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login fail");
                                }
                                a.this.kw("shareVideo: fail, no login in");
                                return;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        com.baidu.swan.games.j.a.Xr().a(cVar, new b() { // from class: com.baidu.swan.games.q.b.a.2
            @Override // com.baidu.swan.games.q.b.b
            public void a(c cVar2, String str) {
                if (a.DEBUG) {
                    Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", cVar2, str));
                }
                a.this.kw(str);
            }
        });
    }

    private c XX() {
        c cVar = null;
        if (this.bCK == null) {
            XY();
        } else if (com.baidu.swan.apps.ae.b.QZ() == null) {
            kw("shareVideo: fail, swanApp is null");
        } else {
            String optString = this.bCK.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
            if (TextUtils.isEmpty(optString)) {
                kw("shareVideo: videoPath is invalid");
            } else {
                String jL = g.jL(optString);
                if (TextUtils.isEmpty(jL)) {
                    kw("shareVideo: videoPath is invalid");
                } else {
                    cVar = new c();
                    cVar.videoPath = jL;
                    cVar.title = this.bCK.optString("title");
                    cVar.query = this.bCK.optString("query");
                    d dVar = new d();
                    dVar.bEg = this.bCK.optLong("clipMaxDuration", 30L);
                    dVar.bEh = this.bCK.optLong("clipMinDuration", 3L);
                    dVar.bEi = this.bCK.optString("topicSource");
                    dVar.bEj = this.bCK.optString("publishTitle", com.baidu.swan.apps.u.a.Ji().getResources().getString(a.h.swangame_publish_video));
                    dVar.bEk = this.bCK.optString("publishURL", "/searchbox?action=ugc&cmd=177");
                    dVar.sourceType = this.bCK.optInt("sourceType", 1);
                    dVar.sourceFrom = this.bCK.optString("sourceFrom", "tiny");
                    dVar.bEm = this.bCK.optString("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                    dVar.bEl = this.bCK.optString("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                    dVar.bEn = this.bCK.optString("topicURL", "baiduboxapp://v1/easybrowse/open?url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dsearch&style=%7b%22menumode%22%3a%222%22%2c%22showtoolbar%22%3a%221%22%7d&newbrowser=1");
                    dVar.bEo = this.bCK.optString("publishType", "9");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("app_key", com.baidu.swan.apps.ae.b.Rk());
                        jSONObject.put("frame_type", com.baidu.swan.apps.ae.b.AB());
                        jSONObject.put("query", cVar.query);
                        if (com.baidu.swan.apps.ae.b.QZ() != null && com.baidu.swan.apps.ae.b.QZ().AJ() != null) {
                            jSONObject.put("title", com.baidu.swan.apps.ae.b.QZ().AJ().Ht());
                        }
                    } catch (JSONException e) {
                        if (DEBUG) {
                            Log.d("ShareVideoApi", e.toString());
                        }
                    }
                    dVar.bEf = jSONObject.toString();
                    cVar.bEe = dVar;
                }
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kw(String str) {
        if (this.bCK != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            bVar.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
            com.baidu.swan.games.utils.a.a(this.bCK, false, bVar);
            XY();
        }
    }

    private void XY() {
        f fVar = new f();
        fVar.mType = "shareVideo";
        fVar.mValue = LivenessStat.TYPE_FACE_MATCH_FAIL;
        e.c(fVar);
    }
}
