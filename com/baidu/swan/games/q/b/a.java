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
    private com.baidu.swan.games.binding.model.c biL;

    public a(JsObject jsObject) {
        this.biL = com.baidu.swan.games.binding.model.c.c(jsObject);
    }

    public void zo() {
        f fVar = new f();
        fVar.mType = "shareVideo";
        e.c(fVar);
        final c Sj = Sj();
        if (Sj != null) {
            com.baidu.swan.apps.a.b Lv = com.baidu.swan.apps.ae.b.Lq().Lv();
            if (Lv.aD(com.baidu.swan.apps.u.a.DB())) {
                a(Sj);
                return;
            }
            SwanAppActivity FH = com.baidu.swan.apps.w.e.FV().FH();
            if (FH == null) {
                jK("shareVideo: swanAppActivity is null");
            } else {
                Lv.a(FH, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.games.q.b.a.1
                    @Override // com.baidu.swan.apps.a.a
                    public void onResult(int i) {
                        switch (i) {
                            case 0:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login success");
                                }
                                a.this.a(Sj);
                                return;
                            default:
                                if (a.DEBUG) {
                                    Log.d("ShareVideoApi", "login fail");
                                }
                                a.this.jK("shareVideo: fail, no login in");
                                return;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        com.baidu.swan.games.j.a.RD().a(cVar, new b() { // from class: com.baidu.swan.games.q.b.a.2
            @Override // com.baidu.swan.games.q.b.b
            public void a(c cVar2, String str) {
                if (a.DEBUG) {
                    Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", cVar2, str));
                }
                a.this.jK(str);
            }
        });
    }

    private c Sj() {
        c cVar = null;
        if (this.biL == null) {
            Sk();
        } else if (com.baidu.swan.apps.ae.b.Lq() == null) {
            jK("shareVideo: fail, swanApp is null");
        } else {
            String optString = this.biL.optString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
            if (TextUtils.isEmpty(optString)) {
                jK("shareVideo: videoPath is invalid");
            } else {
                String iY = g.iY(optString);
                if (TextUtils.isEmpty(iY)) {
                    jK("shareVideo: videoPath is invalid");
                } else {
                    cVar = new c();
                    cVar.videoPath = iY;
                    cVar.title = this.biL.optString("title");
                    cVar.query = this.biL.optString("query");
                    d dVar = new d();
                    dVar.bkh = this.biL.optLong("clipMaxDuration", 30L);
                    dVar.bki = this.biL.optLong("clipMinDuration", 3L);
                    dVar.bkj = this.biL.optString("topicSource");
                    dVar.bkk = this.biL.optString("publishTitle", com.baidu.swan.apps.u.a.DB().getResources().getString(a.h.swangame_publish_video));
                    dVar.bkl = this.biL.optString("publishURL", "/searchbox?action=ugc&cmd=177");
                    dVar.sourceType = this.biL.optInt("sourceType", 1);
                    dVar.sourceFrom = this.biL.optString("sourceFrom", "tiny");
                    dVar.bkn = this.biL.optString("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                    dVar.bkm = this.biL.optString("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                    dVar.bko = this.biL.optString("topicURL", "baiduboxapp://v1/easybrowse/open?url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dsearch&style=%7b%22menumode%22%3a%222%22%2c%22showtoolbar%22%3a%221%22%7d&newbrowser=1");
                    dVar.bkp = this.biL.optString("publishType", "9");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("app_key", com.baidu.swan.apps.ae.b.LB());
                        jSONObject.put("frame_type", com.baidu.swan.apps.ae.b.vc());
                        jSONObject.put("query", cVar.query);
                        if (com.baidu.swan.apps.ae.b.Lq() != null && com.baidu.swan.apps.ae.b.Lq().vk() != null) {
                            jSONObject.put("title", com.baidu.swan.apps.ae.b.Lq().vk().BM());
                        }
                    } catch (JSONException e) {
                        if (DEBUG) {
                            Log.d("ShareVideoApi", e.toString());
                        }
                    }
                    dVar.bkg = jSONObject.toString();
                    cVar.bkf = dVar;
                }
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jK(String str) {
        if (this.biL != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            bVar.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
            com.baidu.swan.games.utils.a.a(this.biL, false, bVar);
            Sk();
        }
    }

    private void Sk() {
        f fVar = new f();
        fVar.mType = "shareVideo";
        fVar.mValue = LivenessStat.TYPE_FACE_MATCH_FAIL;
        e.c(fVar);
    }
}
