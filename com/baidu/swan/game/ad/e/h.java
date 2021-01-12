package com.baidu.swan.game.ad.e;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.a.a;
import com.baidu.swan.game.ad.b.b;
import com.baidu.swan.game.ad.c;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
import com.bytedance.sdk.openadsdk.preload.falconx.statistic.StatisticData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class h implements a.InterfaceC0502a, a.b, a.c, a.d {
    private com.baidu.swan.apps.media.b.a cBf;
    private com.baidu.swan.apps.adlanding.b cBl;
    private com.baidu.swan.apps.adlanding.download.a.a cBq;
    private com.baidu.swan.apps.adlanding.download.model.a cBr;
    public String dUD;
    private AdElementInfo dVh;
    private boolean dWB;
    private String dWK;
    private String dXg;
    private com.baidu.swan.game.ad.b dYA;
    private com.baidu.swan.games.view.a dYC;
    private k dYD;
    private l dYE;
    public com.baidu.swan.apps.res.widget.dialog.g dYF;
    private j dYG;
    private boolean dYH;
    private a dYI;
    private boolean dYJ;
    private boolean dYP;
    private boolean dYQ;
    private g dYR;
    private static String dYq = "0";
    private static String dYr = StatisticData.ERROR_CODE_NOT_FOUND;
    private static String dYs = "101";
    private static String dYt = TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY;
    private static String dYu = TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY;
    private static String dYv = TbEnum.SystemMessage.EVENT_ID_GROUP_UPGRADE;
    private static String dYw = "1";
    private static String dYx = "0";
    private static String dYy = "status";
    private static String dYz = "isPaused";
    private static String KEY_TOKEN = "token";
    private static String dYO = "monitors";
    private int dYB = 256;
    private int mPausePosition = 0;
    private boolean dYK = true;
    private String dYL = dYs;
    private String dYM = dYx;
    private Map<String, String> dYN = new HashMap();
    private SwanAdDownloadState cBs = SwanAdDownloadState.NOT_START;
    private Context mContext = AppRuntime.getAppContext();
    private b dVa = new b(this.mContext);
    private com.baidu.swan.game.ad.jsbridge.a dUY = new com.baidu.swan.game.ad.jsbridge.a();
    private boolean dUZ = com.baidu.swan.game.ad.d.f.aSj();

    public h(String str, String str2, boolean z) {
        this.dUD = "";
        this.dWK = str;
        this.dUD = str2;
        this.dWB = z;
        this.dYQ = z;
    }

    public void a(j jVar) {
        this.dYG = jVar;
    }

    public synchronized void b(com.baidu.swan.games.binding.model.c cVar) {
        com.baidu.swan.game.ad.b.d fVar;
        k d = k.d(cVar);
        if (this.dYB == 257) {
            com.baidu.swan.game.ad.e.a.aSl().a(d);
        } else if (this.dYB == 261 || this.dYB == 260 || this.dYB == 265) {
            a(d, "3010006");
        } else {
            if (this.dYB == 258) {
                if (aSz()) {
                    this.dYB = AuthorityState.STATE_INIT_ING;
                } else {
                    c(d);
                }
            }
            if (this.dYB == 259 || this.dYB == 262 || this.dYB == 263 || this.dYB == 264 || this.dYB == 256 || this.dYB == 272) {
                com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
                String str = "";
                if (aIr != null) {
                    str = aIr.getAppKey();
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.dWK) || TextUtils.isEmpty(this.dUD)) {
                    a(d, "3010007");
                } else {
                    this.dYD = d;
                    this.dYB = 257;
                    com.baidu.swan.game.ad.b.b aRT = new b.a().uY(this.dWK).uZ(this.dUD).va(str).kL(ah.getDisplayWidth(this.mContext)).kM(ah.getDisplayHeight(this.mContext)).kN(1).aRT();
                    if (this.dYQ) {
                        this.dWB = true;
                        fVar = new com.baidu.swan.game.ad.b.e(this.mContext, aRT, 5, 5);
                        com.baidu.swan.games.view.a.b.dr("gdtvideo", null);
                    } else {
                        this.dWB = false;
                        fVar = new com.baidu.swan.game.ad.b.f(this.mContext, aRT);
                        this.dXg = fVar.aRY();
                        com.baidu.swan.games.view.a.b.dr("video", null);
                    }
                    com.baidu.swan.game.ad.b.a aVar = new com.baidu.swan.game.ad.b.a(this.mContext, this.dWB);
                    aVar.a(this);
                    aVar.a(fVar, this.dVa);
                }
            }
        }
    }

    public synchronized void c(com.baidu.swan.games.binding.model.c cVar) {
        final l e = l.e(cVar);
        String str = "";
        if (this.dYB == 261 || this.dYB == 260 || this.dYB == 265) {
            if (e != null) {
                e.vh("3010004");
            }
            if (this.dYG != null) {
                this.dYG.onError("3010004");
            }
        } else if (this.dYB != 258 || aSz()) {
            a(e, "3010004");
        } else if (this.dVh != null && TextUtils.isEmpty(this.dVh.getVideoUrl())) {
            a(e, "3010008");
        } else if (this.dYB == 258) {
            this.dYB = 265;
            if (this.dVh != null) {
                str = this.dVh.aRA();
            }
            if (com.baidu.swan.games.view.a.c.isLandScape() && (com.baidu.swan.games.view.a.c.aZg() || !TextUtils.isEmpty(str))) {
                SwanAppActivity azx = com.baidu.swan.apps.v.f.azN().azx();
                if (azx != null) {
                    azx.setRequestedOrientation(1);
                }
                com.baidu.swan.apps.v.f.azN().azR().im(true);
            }
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.h.1
                @Override // java.lang.Runnable
                public void run() {
                    h.this.aSB();
                    if (com.baidu.swan.games.view.a.c.aY(h.this.dYA.getConvertView())) {
                        com.baidu.swan.games.view.a.c.removeView(h.this.dYA.getConvertView());
                    }
                    if (!com.baidu.swan.games.view.a.c.c(h.this.dYA.getConvertView(), com.baidu.swan.apps.model.a.a.a.aCf())) {
                        h.this.a(e, "3010000");
                        return;
                    }
                    h.this.dYE = e;
                    h.this.dYB = 260;
                    h.this.dYA.start(h.this.dVh.getVideoUrl());
                }
            });
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void a(AdElementInfo adElementInfo) {
        this.dVh = adElementInfo;
        this.dWB = this.dVh.aRK();
        this.dYB = 258;
        c(this.dYD);
        if (!this.dWB && this.dVh.getActionType() == 2) {
            initDownload();
        }
        com.baidu.swan.games.view.a.b.dr(getType(), "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void uS(String str) {
        this.dYB = 259;
        a(this.dYD, str);
        com.baidu.swan.games.view.a.b.ah(getType(), com.baidu.pass.biometrics.face.liveness.c.a.p, str);
    }

    private void aSt() {
        com.baidu.swan.games.view.a.b.h(getType(), "pageclose", this.cBf.getDuration() / 1000);
        aSx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSu() {
        if (this.cBf != null && this.dYA != null) {
            if (this.cBf.isPlaying()) {
                this.cBf.pause();
                this.dYA.aQJ();
            }
            this.dYB = 262;
            if (this.dWB) {
                com.baidu.swan.game.ad.c.d.b(kO(this.dVh.getDuration()), this.dVh, this.dVa);
            } else {
                com.baidu.swan.game.ad.c.c.a(getProgress(), this.mPausePosition, this.dVh, this.dVa);
            }
            if (this.dYA != null) {
                if (this.cBf.isEnd()) {
                    this.dYA.aQM();
                } else {
                    this.dYA.aQN();
                }
            }
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.c
    public void aU(View view) {
        SwanAppActivity azx;
        int i;
        int i2;
        int i3;
        String format;
        if (this.cBf != null && this.dVh != null && (azx = com.baidu.swan.apps.v.f.azN().azx()) != null && !this.dYH) {
            if (view != null && c.e.close_ad != view.getId()) {
                aSt();
                return;
            }
            int currentPosition = this.cBf.getCurrentPosition() / 1000;
            int min = Math.min(this.dVh.aRy(), this.cBf.getDuration() / 1000);
            if (currentPosition >= min) {
                aSu();
                return;
            }
            int aZe = com.baidu.swan.games.view.a.c.aZe();
            int aZf = com.baidu.swan.games.view.a.c.aZf();
            if (com.baidu.swan.games.view.a.c.isLandScape()) {
                i = (int) (aZe * 0.275f);
                i2 = (int) (aZe * 0.275f);
                i3 = (int) (0.05f * aZf);
            } else {
                int min2 = Math.min(aZe, aZf);
                i = (int) (min2 * 0.1f);
                i2 = (int) (min2 * 0.1f);
                i3 = 0;
            }
            aQJ();
            com.baidu.swan.games.view.a.b.h(getType(), "pageshow", getProgress());
            this.mContext.getResources().getString(c.g.swangame_game_ad_dialog_msg_more);
            if (this.dUZ) {
                format = String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_reward_msg_time_tip), Integer.valueOf(15 - (this.cBf.getCurrentPosition() / 1000)));
            } else {
                format = String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_video_close_alert), Integer.valueOf(min - currentPosition));
            }
            this.dYH = true;
            this.dYF = new g.a(azx).gP(true).d(c.g.ad_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.e.h.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    if (!h.this.dUZ || h.this.dYA == null) {
                        h.this.aSx();
                    } else {
                        if (h.this.cBf != null) {
                            h.this.cBf.pause();
                        }
                        if (h.this.dYI != null) {
                            h.this.mContext.unregisterReceiver(h.this.dYI);
                            h.this.dYI = null;
                        }
                        h.this.dYB = 262;
                        h.this.dYA.aQN();
                    }
                    h.this.dYH = false;
                    com.baidu.swan.games.view.a.b.h(h.this.getType(), "close", h.this.getProgress());
                }
            }).re(format).c(c.g.ad_continue_watch, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.e.h.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    h.this.aSA();
                    h.this.dYH = false;
                    com.baidu.swan.games.view.a.b.h(h.this.getType(), "continue", h.this.getProgress());
                }
            }).iS(c.b.aiapps_game_continue_watch).c(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.game.ad.e.h.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    h.this.dYH = false;
                }
            }).a(new com.baidu.swan.apps.view.c.a()).r(i, 0, i2, i3).aHE();
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.d
    public void aV(View view) {
        com.baidu.swan.games.view.a.b.h(getType(), "click", aSC());
        if (this.dWB) {
            aW(view);
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0502a
    public void a(CommandType commandType, Uri uri) {
        String aRC = this.dVh.aRC();
        String packageName = this.dVh.getPackageName();
        switch (commandType) {
            case ACTION_URL:
                if (this.dVh.getActionType() == 2) {
                    aSv();
                    break;
                } else {
                    aSw();
                    break;
                }
            case OPEN_APP:
                if (this.dVh != null) {
                    aw(this.mContext, packageName);
                    break;
                }
                break;
            case GET_DOWNLOAD_STATUS:
                if (this.dUY != null) {
                    if (au(this.mContext, packageName)) {
                        this.dYL = dYu;
                    }
                    String queryParameter = uri.getQueryParameter(KEY_TOKEN);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(dYy, this.dYL);
                        jSONObject.put(dYz, this.dYM);
                        this.dUY.cT(queryParameter, jSONObject.toString());
                        break;
                    } catch (JSONException e) {
                        break;
                    }
                } else {
                    return;
                }
            case PAUSE_DOWNLOAD:
                this.dYM = dYw;
                aSv();
                break;
            case BANNER_VIEW:
                com.baidu.swan.apps.core.d.f afz = com.baidu.swan.apps.v.f.azN().afz();
                if (afz == null) {
                    if (this.mContext != null) {
                        com.baidu.swan.apps.res.widget.b.d.u(this.mContext, c.g.aiapps_open_fragment_failed_toast).aHZ();
                        return;
                    }
                    return;
                }
                afz.mk("adLanding").ai(com.baidu.swan.apps.core.d.f.cQm, com.baidu.swan.apps.core.d.f.cQo).a("adLanding", com.baidu.swan.apps.model.b.cf(aRC, aRC)).apk();
                break;
        }
        com.baidu.swan.game.ad.c.c.d(this.dVh, this.dVa);
        com.baidu.swan.games.view.a.b.h(getType(), "click", aSC());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SwanAdDownloadState swanAdDownloadState) {
        this.cBs = swanAdDownloadState;
        if (swanAdDownloadState == SwanAdDownloadState.NOT_START) {
            this.dYL = dYs;
            this.dYM = dYx;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
            this.dYL = dYq;
            this.dYM = dYw;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
            this.dYL = dYt;
            this.dYM = dYx;
        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
            this.dYL = dYu;
            this.dYM = dYx;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
            this.dYL = dYq;
            this.dYM = dYx;
        }
    }

    private void initDownload() {
        this.cBl = new com.baidu.swan.apps.adlanding.b(this.mContext, this.dVh.aRI());
        this.cBq = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.game.ad.e.h.5
            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void eN(boolean z) {
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void jK(String str) {
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                if (!h.this.dYP) {
                    h.this.d(swanAdDownloadState);
                }
                h.this.dYP = true;
                if (h.this.cBs != swanAdDownloadState) {
                    if (h.this.cBs == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                        h.this.dYM = h.dYx;
                        h.this.cBl.jH("appdownloadbegin");
                    } else if (swanAdDownloadState != SwanAdDownloadState.DOWNLOAD_PAUSED) {
                        if (h.this.cBs == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            h.this.dYM = h.dYx;
                            h.this.cBl.jH("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            h.this.dYM = h.dYx;
                            h.this.dYL = h.dYt;
                            h.this.cBl.jH("appdownloadfinish");
                            h.this.cBl.jH("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            h.this.dYM = h.dYx;
                            h.this.dYL = h.dYu;
                            h.this.cBl.jH("appinstallfinish");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_FAILED) {
                            h.this.dYM = h.dYx;
                            h.this.dYL = h.dYv;
                        } else if (swanAdDownloadState == SwanAdDownloadState.DELETED) {
                            h.this.dYM = h.dYx;
                            h.this.dYL = h.dYs;
                        }
                    } else {
                        h.this.dYM = h.dYw;
                        h.this.cBl.jH("appdownloadpause");
                    }
                    h.this.cBs = swanAdDownloadState;
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                if (i != 0) {
                    if (i != 100 || h.this.dYL == h.dYs) {
                        if (h.this.dYL != h.dYs && h.this.dYL != h.dYv) {
                            h.this.dYL = String.valueOf(i);
                            return;
                        }
                        return;
                    }
                    h.this.dYL = h.dYt;
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void aiU() {
                h.this.cBl.jH("appinstallbegin");
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public String aiV() {
                h.this.cBl.jH("appinstallopen");
                return "";
            }
        };
        String aRC = this.dVh.aRC();
        String packageName = this.dVh.getPackageName();
        String str = this.dYN.get(packageName);
        if (str == null) {
            this.dYN.put(packageName, aRC);
            str = aRC;
        }
        this.cBr = new com.baidu.swan.apps.adlanding.download.model.a(str, packageName, this.dVh.getTitle());
        this.dYP = false;
        com.baidu.swan.apps.t.a.awI().a(this.mContext, this.cBr.aiX(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS, this.cBq);
    }

    private boolean au(Context context, String str) {
        if (context != null) {
            try {
                if (context.getPackageManager() != null) {
                    context.getPackageManager().getPackageInfo(str, 0);
                    return true;
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    private boolean aw(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0 && queryIntentActivities.iterator().next() != null) {
            String str2 = queryIntentActivities.iterator().next().activityInfo.name;
            Intent intent2 = new Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setComponent(new ComponentName(str, str2));
            intent2.setFlags(268435456);
            try {
                context.startActivity(intent2);
                return true;
            } catch (Exception e) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "打开失败").jg(3).aHZ();
            }
        } else {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "打开失败").jg(3).aHZ();
        }
        return false;
    }

    private void aSv() {
        if (ak.isAppInstalled(this.mContext, this.cBr.name)) {
            this.dYL = dYu;
            aw(this.mContext, this.cBr.name);
            this.cBl.jH("appinstallopen");
            return;
        }
        if (this.cBs == SwanAdDownloadState.NOT_START || this.cBs == SwanAdDownloadState.DELETED) {
            this.dYL = dYq;
            com.baidu.swan.apps.t.a.awI().a(this.mContext, this.cBr.aiX(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.cBq);
        }
        if (this.cBs == SwanAdDownloadState.DOWNLOADING) {
            com.baidu.swan.apps.t.a.awI().a(this.mContext, this.cBr.aiX(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.cBq);
        }
        if (this.cBs == SwanAdDownloadState.DOWNLOAD_PAUSED) {
            this.dYM = dYx;
            com.baidu.swan.apps.t.a.awI().a(this.mContext, this.cBr.aiX(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.cBq);
        }
        if (this.cBs == SwanAdDownloadState.DOWNLOAD_FAILED) {
            com.baidu.swan.apps.t.a.awI().a(this.mContext, this.cBr.aiX(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.cBq);
        }
        if (this.cBs == SwanAdDownloadState.DOWNLOADED) {
            this.dYL = dYt;
            this.cBq.aiU();
            com.baidu.swan.apps.t.a.awI().a(this.mContext, this.cBr.aiX(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, this.cBq);
        }
        if (this.cBs == SwanAdDownloadState.INSTALLED) {
            aw(this.mContext, this.cBr.name);
        }
    }

    private void aSw() {
        String aRC = this.dVh.aRC();
        com.baidu.swan.apps.core.d.f afz = com.baidu.swan.apps.v.f.azN().afz();
        if (afz == null) {
            if (this.mContext != null) {
                com.baidu.swan.apps.res.widget.b.d.u(this.mContext, c.g.aiapps_open_fragment_failed_toast).aHZ();
                return;
            }
            return;
        }
        JSONObject aRI = this.dVh.aRI();
        com.baidu.swan.apps.model.b cf = com.baidu.swan.apps.model.b.cf(aRC, aRC);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(dYO, aRI);
        } catch (JSONException e) {
        }
        cf.setParams(jSONObject.toString());
        afz.mk("adLanding").ai(com.baidu.swan.apps.core.d.f.cQm, com.baidu.swan.apps.core.d.f.cQo).a("adLanding", cf).apk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSx() {
        if (this.dYG != null && this.cBf != null) {
            this.dYG.hQ(this.cBf.isEnd() || this.cBf.getCurrentPosition() / 1000 >= Math.min(this.dVh.aRy(), this.cBf.getDuration() / 1000));
        }
        aSy();
        if (!this.dWB && this.dVh.getActionType() == 2 && SwanAdDownloadState.DOWNLOADING == this.cBs) {
            this.cBq = null;
            com.baidu.swan.apps.t.a.awI().a(this.mContext, this.cBr.aiX(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.cBq);
        }
        com.baidu.swan.game.ad.c.c.f(this.dVh, this.dVa);
        this.dYB = 263;
        b((com.baidu.swan.games.binding.model.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSy() {
        if (this.cBf != null) {
            this.cBf.pause();
            this.cBf.onDestroy();
        }
        if (this.dYI != null) {
            this.mContext.unregisterReceiver(this.dYI);
            this.dYI = null;
        }
        if (this.dYA != null) {
            this.dYA.aQL();
            this.dYA.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_close));
            com.baidu.swan.games.view.a.c.removeView(this.dYA.getConvertView());
        }
        if (this.dYC != null) {
            com.baidu.swan.games.view.a.c.b(this.dYC);
            this.dYC = null;
        }
        if (this.dYR != null) {
            this.dYR.release();
            this.dYR = null;
        }
    }

    private boolean aSz() {
        if (this.dVh == null) {
            return true;
        }
        long aRD = this.dVh.aRD() * 1000;
        if (aRD == 0) {
            aRD = 1740000;
        }
        return System.currentTimeMillis() - this.dVh.getCreateTime() >= aRD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getProgress() {
        if (this.cBf != null) {
            return this.cBf.getCurrentPosition() / 1000;
        }
        return 0;
    }

    private void c(k kVar) {
        if (this.dYG != null) {
            this.dYG.onLoad();
        }
        if (kVar != null) {
            kVar.onLoadSuccess();
        }
        com.baidu.swan.game.ad.e.a.aSl().at(16, "");
    }

    private void a(k kVar, String str) {
        if (this.dYG != null) {
            this.dYG.onError(str);
        }
        if (kVar != null) {
            kVar.vg(str);
        }
        com.baidu.swan.game.ad.e.a.aSl().at(17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQJ() {
        if (this.cBf != null && this.dYA != null && this.cBf.isPlaying()) {
            this.cBf.pause();
            this.dYA.aQJ();
            if (this.dWB) {
                com.baidu.swan.game.ad.c.d.b(kO(getProgress()), this.dVh, this.dVa);
            } else {
                com.baidu.swan.game.ad.c.c.a(getProgress(), this.mPausePosition, this.dVh, this.dVa);
            }
            this.mPausePosition = getProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSA() {
        if (this.cBf != null && this.dYA != null) {
            if ((this.dYF == null || !this.dYF.isShowing()) && !this.cBf.isPlaying() && !this.dYA.aQT()) {
                this.cBf.resume();
                this.dYA.aQK();
                com.baidu.swan.game.ad.c.c.e(this.dVh, this.dVa);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar, String str) {
        if (lVar != null) {
            lVar.vh(str);
        }
        if (this.dYG != null) {
            this.dYG.onError(str);
        }
        this.dYB = 264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSB() {
        this.dUY.b(this);
        if (com.baidu.swan.games.view.a.c.isLandScape()) {
            this.dYA = new com.baidu.swan.game.ad.d(this.mContext, this.dVh, this.dUY);
        } else {
            this.dYA = new com.baidu.swan.game.ad.e(this.mContext, this.dVh, this.dUY);
        }
        if (this.dWB) {
            this.dYA.a((a.d) this);
        }
        this.dYA.a((a.c) this);
        this.cBf = this.dYA.getPlayer();
        this.cBf.b(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.game.ad.e.h.6
            @Override // com.baidu.swan.apps.media.b.b
            public void a(com.baidu.swan.apps.t.b.j jVar) {
                if (h.this.dYA != null) {
                    h.this.dYA.onPrepared();
                }
                h.this.dYB = 261;
                h.this.mPausePosition = 0;
                if (h.this.dYA != null) {
                    h.this.dYA.aQI();
                }
                if (h.this.dYE != null) {
                    h.this.dYE.aSM();
                }
                if (h.this.dYI == null) {
                    h.this.dYI = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    h.this.mContext.registerReceiver(h.this.dYI, intentFilter);
                }
                if (h.this.dWB) {
                    com.baidu.swan.game.ad.c.d.a(h.this.dVh, h.this.dVa);
                    return;
                }
                com.baidu.swan.game.ad.c.c.a(h.this.dVh, h.this.dVa);
                com.baidu.swan.game.ad.c.c.e(h.this.dVh, h.this.dVa);
                com.baidu.swan.game.ad.c.c.a(h.this.dWK, h.this.dUD, h.this.dXg, h.this.dVa);
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(com.baidu.swan.apps.t.b.j jVar, int i, int i2) {
                h.this.aSy();
                h.this.a(h.this.dYE, "3010001");
                return true;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(com.baidu.swan.apps.t.b.j jVar) {
                h.this.aSu();
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void c(com.baidu.swan.apps.t.b.j jVar) {
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void d(com.baidu.swan.apps.t.b.j jVar) {
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void e(com.baidu.swan.apps.t.b.j jVar) {
            }
        });
        if (this.dYC == null) {
            this.dYC = new com.baidu.swan.games.view.a() { // from class: com.baidu.swan.game.ad.e.h.7
                @Override // com.baidu.swan.games.view.a
                public void aSJ() {
                    h.this.dYJ = true;
                    if (h.this.dYK) {
                        h.this.aSA();
                    }
                }

                @Override // com.baidu.swan.games.view.a
                public void aSK() {
                    h.this.dYJ = false;
                    h.this.aQJ();
                }

                @Override // com.baidu.swan.games.view.a
                public void aSL() {
                }
            };
            com.baidu.swan.games.view.a.c.a(this.dYC);
        }
        this.dYA.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (h.this.cBf != null) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                    h.this.dYK = true;
                    if (h.this.dYJ) {
                        h.this.aSA();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    h.this.dYK = false;
                }
            }
        }
    }

    private com.baidu.swan.game.ad.c.b kO(int i) {
        int i2;
        com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
        bVar.dXx = String.valueOf(this.dVh.getDuration());
        bVar.dXy = String.valueOf(this.mPausePosition);
        bVar.mEndTime = String.valueOf(i);
        bVar.dXz = this.mPausePosition == 0 ? "1" : "0";
        bVar.dXA = i == this.dVh.getDuration() ? "1" : "0";
        bVar.dXB = this.mContext.getResources().getConfiguration().orientation == 1 ? "2" : "4";
        if (this.mPausePosition == 0) {
            i2 = 1;
        } else if (this.mPausePosition == this.dVh.getDuration()) {
            i2 = 3;
        } else {
            i2 = 2;
        }
        bVar.mType = String.valueOf(i2);
        bVar.dXC = (this.mPausePosition == 0 && SwanAppNetworkUtils.isWifiNetworkConnected(this.mContext)) ? "1" : "2";
        bVar.mStatus = String.valueOf(0);
        return bVar;
    }

    public String getType() {
        return this.dWB ? "gdtvideo" : "video";
    }

    private int aSC() {
        return (this.cBf == null || !this.cBf.isEnd()) ? getProgress() : this.cBf.getDuration() / 1000;
    }

    @Override // com.baidu.swan.game.ad.a.a.d
    public void cS(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                jSONObject.put("title", this.dVh.getTitle());
                jSONObject.put("description", this.dVh.getDescription());
                jSONObject.put("autoinstall", true);
                if (this.dYR == null) {
                    this.dYR = new g(this.mContext, this.dVh, this.dVa);
                }
                this.dYR.ql(str);
                com.baidu.swan.apps.t.a.awI().a(this.mContext, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.dYR);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void aW(View view) {
        if (this.dWB && this.dVh != null) {
            com.baidu.swan.game.ad.c.d.d(this.dVh, this.dVa);
            com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
            bVar.dXp = String.valueOf(ah.getDisplayWidth(this.mContext));
            bVar.dXq = String.valueOf(ah.getDisplayHeight(this.mContext));
            bVar.dXr = String.valueOf(ah.getDisplayWidth(this.mContext));
            bVar.dXs = String.valueOf(ah.getDisplayHeight(this.mContext));
            bVar.dXt = String.valueOf((int) view.getX());
            bVar.dXu = String.valueOf((int) view.getY());
            bVar.dXv = String.valueOf((int) view.getX());
            bVar.dXw = String.valueOf((int) view.getY());
            if (this.dVh.getActionType() == 2) {
                com.baidu.swan.game.ad.c.d.a(bVar, this.dVh, this.dVa, this);
                return;
            }
            com.baidu.swan.apps.core.d.f afz = com.baidu.swan.apps.v.f.azN().afz();
            if (afz == null) {
                if (this.mContext != null) {
                    com.baidu.swan.apps.res.widget.b.d.u(this.mContext, c.g.aiapps_open_fragment_failed_toast).aHZ();
                }
            } else if (this.dVh != null) {
                String a2 = com.baidu.swan.game.ad.c.d.a(this.dVh.aRC(), bVar);
                afz.mk("adLanding").ai(com.baidu.swan.apps.core.d.f.cQm, com.baidu.swan.apps.core.d.f.cQo).a("adLanding", com.baidu.swan.apps.model.b.cf(a2, a2)).apk();
            }
        }
    }
}
