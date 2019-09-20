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
    private com.baidu.swan.games.binding.model.c bjW;

    public a(JsObject jsObject) {
        this.bjW = com.baidu.swan.games.binding.model.c.c(jsObject);
    }

    public void zZ() {
        f fVar = new f();
        fVar.mType = "shareVideo";
        e.c(fVar);
        final c Tg = Tg();
        if (Tg != null) {
            com.baidu.swan.apps.a.b Mm = com.baidu.swan.apps.ae.b.Mh().Mm();
            if (Mm.aD(com.baidu.swan.apps.u.a.Eo())) {
                a(Tg);
                return;
            }
            SwanAppActivity Gv = com.baidu.swan.apps.w.e.GJ().Gv();
            if (Gv == null) {
                jU("shareVideo: swanAppActivity is null");
            } else {
                Mm.a(Gv, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.q.b.a.1
                    @Override // com.baidu.swan.apps.a.a
                    public void onResult(int i) {
                        switch (i) {
                            case 0:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login success");
                                }
                                a.this.a(Tg);
                                return;
                            default:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login fail");
                                }
                                a.this.jU("shareVideo: fail, no login in");
                                return;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        com.baidu.swan.games.j.a.SA().a(cVar, new b() { // from class: com.baidu.swan.games.q.b.a.2
            @Override // com.baidu.swan.games.q.b.b
            public void a(c cVar2, String str) {
                if (a.DEBUG) {
                    Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", cVar2, str));
                }
                a.this.jU(str);
            }
        });
    }

    private c Tg() {
        c cVar = null;
        if (this.bjW == null) {
            Th();
        } else if (com.baidu.swan.apps.ae.b.Mh() == null) {
            jU("shareVideo: fail, swanApp is null");
        } else {
            String optString = this.bjW.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
            if (TextUtils.isEmpty(optString)) {
                jU("shareVideo: videoPath is invalid");
            } else {
                String ji = g.ji(optString);
                if (TextUtils.isEmpty(ji)) {
                    jU("shareVideo: videoPath is invalid");
                } else {
                    cVar = new c();
                    cVar.videoPath = ji;
                    cVar.title = this.bjW.optString("title");
                    cVar.query = this.bjW.optString("query");
                    d dVar = new d();
                    dVar.bls = this.bjW.optLong("clipMaxDuration", 30L);
                    dVar.blt = this.bjW.optLong("clipMinDuration", 3L);
                    dVar.blu = this.bjW.optString("topicSource");
                    dVar.blv = this.bjW.optString("publishTitle", com.baidu.swan.apps.u.a.Eo().getResources().getString(a.h.swangame_publish_video));
                    dVar.blw = this.bjW.optString("publishURL", "/searchbox?action=ugc&cmd=177");
                    dVar.sourceType = this.bjW.optInt("sourceType", 1);
                    dVar.sourceFrom = this.bjW.optString("sourceFrom", "tiny");
                    dVar.bly = this.bjW.optString("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                    dVar.blx = this.bjW.optString("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                    dVar.blz = this.bjW.optString("topicURL", "baiduboxapp://v1/easybrowse/open?url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dsearch&style=%7b%22menumode%22%3a%222%22%2c%22showtoolbar%22%3a%221%22%7d&newbrowser=1");
                    dVar.blA = this.bjW.optString("publishType", "9");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("app_key", com.baidu.swan.apps.ae.b.Ms());
                        jSONObject.put("frame_type", com.baidu.swan.apps.ae.b.vH());
                        jSONObject.put("query", cVar.query);
                        if (com.baidu.swan.apps.ae.b.Mh() != null && com.baidu.swan.apps.ae.b.Mh().vP() != null) {
                            jSONObject.put("title", com.baidu.swan.apps.ae.b.Mh().vP().Cz());
                        }
                    } catch (JSONException e) {
                        if (DEBUG) {
                            Log.d("ShareVideoApi", e.toString());
                        }
                    }
                    dVar.blr = jSONObject.toString();
                    cVar.blq = dVar;
                }
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jU(String str) {
        if (this.bjW != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            bVar.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
            com.baidu.swan.games.utils.a.a(this.bjW, false, bVar);
            Th();
        }
    }

    private void Th() {
        f fVar = new f();
        fVar.mType = "shareVideo";
        fVar.mValue = LivenessStat.TYPE_FACE_MATCH_FAIL;
        e.c(fVar);
    }
}
