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
    private com.baidu.swan.games.binding.model.c bjy;

    public a(JsObject jsObject) {
        this.bjy = com.baidu.swan.games.binding.model.c.c(jsObject);
    }

    public void zV() {
        f fVar = new f();
        fVar.mType = "shareVideo";
        e.c(fVar);
        final c Tc = Tc();
        if (Tc != null) {
            com.baidu.swan.apps.a.b Mi = com.baidu.swan.apps.ae.b.Md().Mi();
            if (Mi.aD(com.baidu.swan.apps.u.a.Ek())) {
                a(Tc);
                return;
            }
            SwanAppActivity Gr = com.baidu.swan.apps.w.e.GF().Gr();
            if (Gr == null) {
                jS("shareVideo: swanAppActivity is null");
            } else {
                Mi.a(Gr, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.q.b.a.1
                    @Override // com.baidu.swan.apps.a.a
                    public void onResult(int i) {
                        switch (i) {
                            case 0:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login success");
                                }
                                a.this.a(Tc);
                                return;
                            default:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login fail");
                                }
                                a.this.jS("shareVideo: fail, no login in");
                                return;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        com.baidu.swan.games.j.a.Sw().a(cVar, new b() { // from class: com.baidu.swan.games.q.b.a.2
            @Override // com.baidu.swan.games.q.b.b
            public void a(c cVar2, String str) {
                if (a.DEBUG) {
                    Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", cVar2, str));
                }
                a.this.jS(str);
            }
        });
    }

    private c Tc() {
        c cVar = null;
        if (this.bjy == null) {
            Td();
        } else if (com.baidu.swan.apps.ae.b.Md() == null) {
            jS("shareVideo: fail, swanApp is null");
        } else {
            String optString = this.bjy.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
            if (TextUtils.isEmpty(optString)) {
                jS("shareVideo: videoPath is invalid");
            } else {
                String jg = g.jg(optString);
                if (TextUtils.isEmpty(jg)) {
                    jS("shareVideo: videoPath is invalid");
                } else {
                    cVar = new c();
                    cVar.videoPath = jg;
                    cVar.title = this.bjy.optString("title");
                    cVar.query = this.bjy.optString("query");
                    d dVar = new d();
                    dVar.bkU = this.bjy.optLong("clipMaxDuration", 30L);
                    dVar.bkV = this.bjy.optLong("clipMinDuration", 3L);
                    dVar.bkW = this.bjy.optString("topicSource");
                    dVar.bkX = this.bjy.optString("publishTitle", com.baidu.swan.apps.u.a.Ek().getResources().getString(a.h.swangame_publish_video));
                    dVar.bkY = this.bjy.optString("publishURL", "/searchbox?action=ugc&cmd=177");
                    dVar.sourceType = this.bjy.optInt("sourceType", 1);
                    dVar.sourceFrom = this.bjy.optString("sourceFrom", "tiny");
                    dVar.bla = this.bjy.optString("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                    dVar.bkZ = this.bjy.optString("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                    dVar.blb = this.bjy.optString("topicURL", "baiduboxapp://v1/easybrowse/open?url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dsearch&style=%7b%22menumode%22%3a%222%22%2c%22showtoolbar%22%3a%221%22%7d&newbrowser=1");
                    dVar.blc = this.bjy.optString("publishType", "9");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("app_key", com.baidu.swan.apps.ae.b.Mo());
                        jSONObject.put("frame_type", com.baidu.swan.apps.ae.b.vD());
                        jSONObject.put("query", cVar.query);
                        if (com.baidu.swan.apps.ae.b.Md() != null && com.baidu.swan.apps.ae.b.Md().vL() != null) {
                            jSONObject.put("title", com.baidu.swan.apps.ae.b.Md().vL().Cv());
                        }
                    } catch (JSONException e) {
                        if (DEBUG) {
                            Log.d("ShareVideoApi", e.toString());
                        }
                    }
                    dVar.bkT = jSONObject.toString();
                    cVar.bkS = dVar;
                }
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jS(String str) {
        if (this.bjy != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            bVar.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
            com.baidu.swan.games.utils.a.a(this.bjy, false, bVar);
            Td();
        }
    }

    private void Td() {
        f fVar = new f();
        fVar.mType = "shareVideo";
        fVar.mValue = LivenessStat.TYPE_FACE_MATCH_FAIL;
        e.c(fVar);
    }
}
