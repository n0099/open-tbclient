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
/* loaded from: classes5.dex */
public class h implements a.InterfaceC0499a, a.b, a.c, a.d {
    private com.baidu.swan.apps.media.b.a cDB;
    private com.baidu.swan.apps.adlanding.b cDH;
    private com.baidu.swan.apps.adlanding.download.a.a cDM;
    private com.baidu.swan.apps.adlanding.download.model.a cDN;
    public String dWJ;
    private AdElementInfo dXp;
    private boolean dYI;
    private String dYQ;
    private String dZm;
    private com.baidu.swan.game.ad.b eaH;
    private com.baidu.swan.games.view.a eaJ;
    private k eaK;
    private l eaL;
    public com.baidu.swan.apps.res.widget.dialog.g eaM;
    private j eaN;
    private boolean eaO;
    private a eaP;
    private boolean eaQ;
    private boolean eaW;
    private boolean eaX;
    private g eaY;
    private static String eax = "0";
    private static String eay = StatisticData.ERROR_CODE_NOT_FOUND;
    private static String eaz = "101";
    private static String eaA = "102";
    private static String eaB = "103";
    private static String eaC = TbEnum.SystemMessage.EVENT_ID_GROUP_UPGRADE;
    private static String eaD = "1";
    private static String eaE = "0";
    private static String eaF = "status";
    private static String eaG = "isPaused";
    private static String KEY_TOKEN = "token";
    private static String eaV = "monitors";
    private int eaI = 256;
    private int mPausePosition = 0;
    private boolean eaR = true;
    private String eaS = eaz;
    private String eaT = eaE;
    private Map<String, String> eaU = new HashMap();
    private SwanAdDownloadState cDO = SwanAdDownloadState.NOT_START;
    private Context mContext = AppRuntime.getAppContext();
    private b dXi = new b(this.mContext);
    private com.baidu.swan.game.ad.jsbridge.a dXg = new com.baidu.swan.game.ad.jsbridge.a();
    private boolean dXh = com.baidu.swan.game.ad.d.f.aSv();

    public h(String str, String str2, boolean z) {
        this.dWJ = "";
        this.dYQ = str;
        this.dWJ = str2;
        this.dYI = z;
        this.eaX = z;
    }

    public void a(j jVar) {
        this.eaN = jVar;
    }

    public synchronized void b(com.baidu.swan.games.binding.model.c cVar) {
        com.baidu.swan.game.ad.b.d fVar;
        k d = k.d(cVar);
        if (this.eaI == 257) {
            com.baidu.swan.game.ad.e.a.aSx().a(d);
        } else if (this.eaI == 261 || this.eaI == 260 || this.eaI == 265) {
            a(d, "3010006");
        } else {
            if (this.eaI == 258) {
                if (aSL()) {
                    this.eaI = AuthorityState.STATE_INIT_ING;
                } else {
                    c(d);
                }
            }
            if (this.eaI == 259 || this.eaI == 262 || this.eaI == 263 || this.eaI == 264 || this.eaI == 256 || this.eaI == 272) {
                com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
                String str = "";
                if (aIK != null) {
                    str = aIK.getAppKey();
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.dYQ) || TextUtils.isEmpty(this.dWJ)) {
                    a(d, "3010007");
                } else {
                    this.eaK = d;
                    this.eaI = 257;
                    com.baidu.swan.game.ad.b.b aSf = new b.a().vr(this.dYQ).vs(this.dWJ).vt(str).kO(ah.getDisplayWidth(this.mContext)).kP(ah.getDisplayHeight(this.mContext)).kQ(1).aSf();
                    if (this.eaX) {
                        this.dYI = true;
                        fVar = new com.baidu.swan.game.ad.b.e(this.mContext, aSf, 5, 5);
                        com.baidu.swan.games.view.a.b.dl("gdtvideo", null);
                    } else {
                        this.dYI = false;
                        fVar = new com.baidu.swan.game.ad.b.f(this.mContext, aSf);
                        this.dZm = fVar.aSk();
                        com.baidu.swan.games.view.a.b.dl("video", null);
                    }
                    com.baidu.swan.game.ad.b.a aVar = new com.baidu.swan.game.ad.b.a(this.mContext, this.dYI);
                    aVar.a(this);
                    aVar.a(fVar, this.dXi);
                }
            }
        }
    }

    public synchronized void c(com.baidu.swan.games.binding.model.c cVar) {
        final l e = l.e(cVar);
        String str = "";
        if (this.eaI == 261 || this.eaI == 260 || this.eaI == 265) {
            if (e != null) {
                e.vA("3010004");
            }
            if (this.eaN != null) {
                this.eaN.onError("3010004");
            }
        } else if (this.eaI != 258 || aSL()) {
            a(e, "3010004");
        } else if (this.dXp != null && TextUtils.isEmpty(this.dXp.getVideoUrl())) {
            a(e, "3010008");
        } else if (this.eaI == 258) {
            this.eaI = 265;
            if (this.dXp != null) {
                str = this.dXp.aRQ();
            }
            if (com.baidu.swan.games.view.a.c.isLandScape() && (com.baidu.swan.games.view.a.c.aZs() || !TextUtils.isEmpty(str))) {
                SwanAppActivity azV = com.baidu.swan.apps.v.f.aAl().azV();
                if (azV != null) {
                    azV.setRequestedOrientation(1);
                }
                com.baidu.swan.apps.v.f.aAl().aAp().io(true);
            }
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.h.1
                @Override // java.lang.Runnable
                public void run() {
                    h.this.aSN();
                    if (com.baidu.swan.games.view.a.c.aU(h.this.eaH.getConvertView())) {
                        com.baidu.swan.games.view.a.c.removeView(h.this.eaH.getConvertView());
                    }
                    if (!com.baidu.swan.games.view.a.c.c(h.this.eaH.getConvertView(), com.baidu.swan.apps.model.a.a.a.aCC())) {
                        h.this.a(e, "3010000");
                        return;
                    }
                    h.this.eaL = e;
                    h.this.eaI = 260;
                    h.this.eaH.start(h.this.dXp.getVideoUrl());
                }
            });
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void a(AdElementInfo adElementInfo) {
        this.dXp = adElementInfo;
        this.dYI = this.dXp.aRZ();
        this.eaI = 258;
        c(this.eaK);
        if (!this.dYI && this.dXp.getActionType() == 2) {
            initDownload();
        }
        com.baidu.swan.games.view.a.b.dl(getType(), "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void vl(String str) {
        this.eaI = 259;
        a(this.eaK, str);
        com.baidu.swan.games.view.a.b.ai(getType(), com.baidu.pass.biometrics.face.liveness.c.a.p, str);
    }

    private void aSF() {
        com.baidu.swan.games.view.a.b.i(getType(), "pageclose", this.cDB.getDuration() / 1000);
        aSJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSG() {
        if (this.cDB != null && this.eaH != null) {
            if (this.cDB.isPlaying()) {
                this.cDB.pause();
                this.eaH.pausePlay();
            }
            this.eaI = 262;
            if (this.dYI) {
                com.baidu.swan.game.ad.c.d.b(kR(this.dXp.getDuration()), this.dXp, this.dXi);
            } else {
                com.baidu.swan.game.ad.c.c.a(getProgress(), this.mPausePosition, this.dXp, this.dXi);
            }
            if (this.eaH != null) {
                if (this.cDB.isEnd()) {
                    this.eaH.playCompletion();
                } else {
                    this.eaH.aRd();
                }
            }
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.c
    public void aQ(View view) {
        SwanAppActivity azV;
        int i;
        int i2;
        int i3;
        String format;
        if (this.cDB != null && this.dXp != null && (azV = com.baidu.swan.apps.v.f.aAl().azV()) != null && !this.eaO) {
            if (view != null && c.e.close_ad != view.getId()) {
                aSF();
                return;
            }
            int currentPosition = this.cDB.getCurrentPosition() / 1000;
            int min = Math.min(this.dXp.aRO(), this.cDB.getDuration() / 1000);
            if (currentPosition >= min) {
                aSG();
                return;
            }
            int aZq = com.baidu.swan.games.view.a.c.aZq();
            int aZr = com.baidu.swan.games.view.a.c.aZr();
            if (com.baidu.swan.games.view.a.c.isLandScape()) {
                i = (int) (aZq * 0.275f);
                i2 = (int) (aZq * 0.275f);
                i3 = (int) (0.05f * aZr);
            } else {
                int min2 = Math.min(aZq, aZr);
                i = (int) (min2 * 0.1f);
                i2 = (int) (min2 * 0.1f);
                i3 = 0;
            }
            pausePlay();
            com.baidu.swan.games.view.a.b.i(getType(), "pageshow", getProgress());
            this.mContext.getResources().getString(c.g.swangame_game_ad_dialog_msg_more);
            if (this.dXh) {
                format = String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_reward_msg_time_tip), Integer.valueOf(15 - (this.cDB.getCurrentPosition() / 1000)));
            } else {
                format = String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_video_close_alert), Integer.valueOf(min - currentPosition));
            }
            this.eaO = true;
            this.eaM = new g.a(azV).gR(true).d(c.g.ad_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.e.h.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    if (!h.this.dXh || h.this.eaH == null) {
                        h.this.aSJ();
                    } else {
                        if (h.this.cDB != null) {
                            h.this.cDB.pause();
                        }
                        if (h.this.eaP != null) {
                            h.this.mContext.unregisterReceiver(h.this.eaP);
                            h.this.eaP = null;
                        }
                        h.this.eaI = 262;
                        h.this.eaH.aRd();
                    }
                    h.this.eaO = false;
                    com.baidu.swan.games.view.a.b.i(h.this.getType(), "close", h.this.getProgress());
                }
            }).rx(format).c(c.g.ad_continue_watch, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.e.h.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    h.this.aSM();
                    h.this.eaO = false;
                    com.baidu.swan.games.view.a.b.i(h.this.getType(), "continue", h.this.getProgress());
                }
            }).iV(c.b.aiapps_game_continue_watch).c(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.game.ad.e.h.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    h.this.eaO = false;
                }
            }).a(new com.baidu.swan.apps.view.c.a()).r(i, 0, i2, i3).aHX();
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.d
    public void aR(View view) {
        com.baidu.swan.games.view.a.b.i(getType(), "click", aSO());
        if (this.dYI) {
            aS(view);
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0499a
    public void a(CommandType commandType, Uri uri) {
        String aRR = this.dXp.aRR();
        String packageName = this.dXp.getPackageName();
        switch (commandType) {
            case ACTION_URL:
                if (this.dXp.getActionType() == 2) {
                    aSH();
                    break;
                } else {
                    aSI();
                    break;
                }
            case OPEN_APP:
                if (this.dXp != null) {
                    au(this.mContext, packageName);
                    break;
                }
                break;
            case GET_DOWNLOAD_STATUS:
                if (this.dXg != null) {
                    if (as(this.mContext, packageName)) {
                        this.eaS = eaB;
                    }
                    String queryParameter = uri.getQueryParameter(KEY_TOKEN);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(eaF, this.eaS);
                        jSONObject.put(eaG, this.eaT);
                        this.dXg.cN(queryParameter, jSONObject.toString());
                        break;
                    } catch (JSONException e) {
                        break;
                    }
                } else {
                    return;
                }
            case PAUSE_DOWNLOAD:
                this.eaT = eaD;
                aSH();
                break;
            case BANNER_VIEW:
                com.baidu.swan.apps.core.d.f afX = com.baidu.swan.apps.v.f.aAl().afX();
                if (afX == null) {
                    if (this.mContext != null) {
                        com.baidu.swan.apps.res.widget.b.d.u(this.mContext, c.g.aiapps_open_fragment_failed_toast).aIs();
                        return;
                    }
                    return;
                }
                afX.mC("adLanding").af(com.baidu.swan.apps.core.d.f.cSz, com.baidu.swan.apps.core.d.f.cSB).a("adLanding", com.baidu.swan.apps.model.b.bZ(aRR, aRR)).apI();
                break;
        }
        com.baidu.swan.game.ad.c.c.d(this.dXp, this.dXi);
        com.baidu.swan.games.view.a.b.i(getType(), "click", aSO());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SwanAdDownloadState swanAdDownloadState) {
        this.cDO = swanAdDownloadState;
        if (swanAdDownloadState == SwanAdDownloadState.NOT_START) {
            this.eaS = eaz;
            this.eaT = eaE;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
            this.eaS = eax;
            this.eaT = eaD;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
            this.eaS = eaA;
            this.eaT = eaE;
        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
            this.eaS = eaB;
            this.eaT = eaE;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
            this.eaS = eax;
            this.eaT = eaE;
        }
    }

    private void initDownload() {
        this.cDH = new com.baidu.swan.apps.adlanding.b(this.mContext, this.dXp.aRX());
        this.cDM = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.game.ad.e.h.5
            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void eP(boolean z) {
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void kc(String str) {
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                if (!h.this.eaW) {
                    h.this.d(swanAdDownloadState);
                }
                h.this.eaW = true;
                if (h.this.cDO != swanAdDownloadState) {
                    if (h.this.cDO == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                        h.this.eaT = h.eaE;
                        h.this.cDH.jZ("appdownloadbegin");
                    } else if (swanAdDownloadState != SwanAdDownloadState.DOWNLOAD_PAUSED) {
                        if (h.this.cDO == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            h.this.eaT = h.eaE;
                            h.this.cDH.jZ("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            h.this.eaT = h.eaE;
                            h.this.eaS = h.eaA;
                            h.this.cDH.jZ("appdownloadfinish");
                            h.this.cDH.jZ("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            h.this.eaT = h.eaE;
                            h.this.eaS = h.eaB;
                            h.this.cDH.jZ("appinstallfinish");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_FAILED) {
                            h.this.eaT = h.eaE;
                            h.this.eaS = h.eaC;
                        } else if (swanAdDownloadState == SwanAdDownloadState.DELETED) {
                            h.this.eaT = h.eaE;
                            h.this.eaS = h.eaz;
                        }
                    } else {
                        h.this.eaT = h.eaD;
                        h.this.cDH.jZ("appdownloadpause");
                    }
                    h.this.cDO = swanAdDownloadState;
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                if (i != 0) {
                    if (i != 100 || h.this.eaS == h.eaz) {
                        if (h.this.eaS != h.eaz && h.this.eaS != h.eaC) {
                            h.this.eaS = String.valueOf(i);
                            return;
                        }
                        return;
                    }
                    h.this.eaS = h.eaA;
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void ajs() {
                h.this.cDH.jZ("appinstallbegin");
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public String ajt() {
                h.this.cDH.jZ("appinstallopen");
                return "";
            }
        };
        String aRR = this.dXp.aRR();
        String packageName = this.dXp.getPackageName();
        String str = this.eaU.get(packageName);
        if (str == null) {
            this.eaU.put(packageName, aRR);
            str = aRR;
        }
        this.cDN = new com.baidu.swan.apps.adlanding.download.model.a(str, packageName, this.dXp.getTitle());
        this.eaW = false;
        com.baidu.swan.apps.t.a.axg().a(this.mContext, this.cDN.ajv(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS, this.cDM);
    }

    private boolean as(Context context, String str) {
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

    private boolean au(Context context, String str) {
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
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "打开失败").jj(3).aIs();
            }
        } else {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "打开失败").jj(3).aIs();
        }
        return false;
    }

    private void aSH() {
        if (ak.isAppInstalled(this.mContext, this.cDN.name)) {
            this.eaS = eaB;
            au(this.mContext, this.cDN.name);
            this.cDH.jZ("appinstallopen");
            return;
        }
        if (this.cDO == SwanAdDownloadState.NOT_START || this.cDO == SwanAdDownloadState.DELETED) {
            this.eaS = eax;
            com.baidu.swan.apps.t.a.axg().a(this.mContext, this.cDN.ajv(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.cDM);
        }
        if (this.cDO == SwanAdDownloadState.DOWNLOADING) {
            com.baidu.swan.apps.t.a.axg().a(this.mContext, this.cDN.ajv(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.cDM);
        }
        if (this.cDO == SwanAdDownloadState.DOWNLOAD_PAUSED) {
            this.eaT = eaE;
            com.baidu.swan.apps.t.a.axg().a(this.mContext, this.cDN.ajv(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.cDM);
        }
        if (this.cDO == SwanAdDownloadState.DOWNLOAD_FAILED) {
            com.baidu.swan.apps.t.a.axg().a(this.mContext, this.cDN.ajv(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.cDM);
        }
        if (this.cDO == SwanAdDownloadState.DOWNLOADED) {
            this.eaS = eaA;
            this.cDM.ajs();
            com.baidu.swan.apps.t.a.axg().a(this.mContext, this.cDN.ajv(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, this.cDM);
        }
        if (this.cDO == SwanAdDownloadState.INSTALLED) {
            au(this.mContext, this.cDN.name);
        }
    }

    private void aSI() {
        String aRR = this.dXp.aRR();
        com.baidu.swan.apps.core.d.f afX = com.baidu.swan.apps.v.f.aAl().afX();
        if (afX == null) {
            if (this.mContext != null) {
                com.baidu.swan.apps.res.widget.b.d.u(this.mContext, c.g.aiapps_open_fragment_failed_toast).aIs();
                return;
            }
            return;
        }
        JSONObject aRX = this.dXp.aRX();
        com.baidu.swan.apps.model.b bZ = com.baidu.swan.apps.model.b.bZ(aRR, aRR);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(eaV, aRX);
        } catch (JSONException e) {
        }
        bZ.setParams(jSONObject.toString());
        afX.mC("adLanding").af(com.baidu.swan.apps.core.d.f.cSz, com.baidu.swan.apps.core.d.f.cSB).a("adLanding", bZ).apI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSJ() {
        if (this.eaN != null && this.cDB != null) {
            this.eaN.hS(this.cDB.isEnd() || this.cDB.getCurrentPosition() / 1000 >= Math.min(this.dXp.aRO(), this.cDB.getDuration() / 1000));
        }
        aSK();
        if (!this.dYI && this.dXp.getActionType() == 2 && SwanAdDownloadState.DOWNLOADING == this.cDO) {
            this.cDM = null;
            com.baidu.swan.apps.t.a.axg().a(this.mContext, this.cDN.ajv(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.cDM);
        }
        com.baidu.swan.game.ad.c.c.f(this.dXp, this.dXi);
        this.eaI = 263;
        b((com.baidu.swan.games.binding.model.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSK() {
        if (this.cDB != null) {
            this.cDB.pause();
            this.cDB.onDestroy();
        }
        if (this.eaP != null) {
            this.mContext.unregisterReceiver(this.eaP);
            this.eaP = null;
        }
        if (this.eaH != null) {
            this.eaH.aRc();
            this.eaH.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_close));
            com.baidu.swan.games.view.a.c.removeView(this.eaH.getConvertView());
        }
        if (this.eaJ != null) {
            com.baidu.swan.games.view.a.c.b(this.eaJ);
            this.eaJ = null;
        }
        if (this.eaY != null) {
            this.eaY.release();
            this.eaY = null;
        }
    }

    private boolean aSL() {
        if (this.dXp == null) {
            return true;
        }
        long aRS = this.dXp.aRS() * 1000;
        if (aRS == 0) {
            aRS = 1740000;
        }
        return System.currentTimeMillis() - this.dXp.getCreateTime() >= aRS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getProgress() {
        if (this.cDB != null) {
            return this.cDB.getCurrentPosition() / 1000;
        }
        return 0;
    }

    private void c(k kVar) {
        if (this.eaN != null) {
            this.eaN.onLoad();
        }
        if (kVar != null) {
            kVar.onLoadSuccess();
        }
        com.baidu.swan.game.ad.e.a.aSx().ax(16, "");
    }

    private void a(k kVar, String str) {
        if (this.eaN != null) {
            this.eaN.onError(str);
        }
        if (kVar != null) {
            kVar.vz(str);
        }
        com.baidu.swan.game.ad.e.a.aSx().ax(17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pausePlay() {
        if (this.cDB != null && this.eaH != null && this.cDB.isPlaying()) {
            this.cDB.pause();
            this.eaH.pausePlay();
            if (this.dYI) {
                com.baidu.swan.game.ad.c.d.b(kR(getProgress()), this.dXp, this.dXi);
            } else {
                com.baidu.swan.game.ad.c.c.a(getProgress(), this.mPausePosition, this.dXp, this.dXi);
            }
            this.mPausePosition = getProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSM() {
        if (this.cDB != null && this.eaH != null) {
            if ((this.eaM == null || !this.eaM.isShowing()) && !this.cDB.isPlaying() && !this.eaH.aRj()) {
                this.cDB.resume();
                this.eaH.resumePlay();
                com.baidu.swan.game.ad.c.c.e(this.dXp, this.dXi);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar, String str) {
        if (lVar != null) {
            lVar.vA(str);
        }
        if (this.eaN != null) {
            this.eaN.onError(str);
        }
        this.eaI = 264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSN() {
        this.dXg.b(this);
        if (com.baidu.swan.games.view.a.c.isLandScape()) {
            this.eaH = new com.baidu.swan.game.ad.d(this.mContext, this.dXp, this.dXg);
        } else {
            this.eaH = new com.baidu.swan.game.ad.e(this.mContext, this.dXp, this.dXg);
        }
        if (this.dYI) {
            this.eaH.a((a.d) this);
        }
        this.eaH.a((a.c) this);
        this.cDB = this.eaH.getPlayer();
        this.cDB.b(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.game.ad.e.h.6
            @Override // com.baidu.swan.apps.media.b.b
            public void a(com.baidu.swan.apps.t.b.j jVar) {
                if (h.this.eaH != null) {
                    h.this.eaH.onPrepared();
                }
                h.this.eaI = 261;
                h.this.mPausePosition = 0;
                if (h.this.eaH != null) {
                    h.this.eaH.aRb();
                }
                if (h.this.eaL != null) {
                    h.this.eaL.aSY();
                }
                if (h.this.eaP == null) {
                    h.this.eaP = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    h.this.mContext.registerReceiver(h.this.eaP, intentFilter);
                }
                if (h.this.dYI) {
                    com.baidu.swan.game.ad.c.d.a(h.this.dXp, h.this.dXi);
                    return;
                }
                com.baidu.swan.game.ad.c.c.a(h.this.dXp, h.this.dXi);
                com.baidu.swan.game.ad.c.c.e(h.this.dXp, h.this.dXi);
                com.baidu.swan.game.ad.c.c.a(h.this.dYQ, h.this.dWJ, h.this.dZm, h.this.dXi);
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(com.baidu.swan.apps.t.b.j jVar, int i, int i2) {
                h.this.aSK();
                h.this.a(h.this.eaL, "3010001");
                return true;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(com.baidu.swan.apps.t.b.j jVar) {
                h.this.aSG();
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
        if (this.eaJ == null) {
            this.eaJ = new com.baidu.swan.games.view.a() { // from class: com.baidu.swan.game.ad.e.h.7
                @Override // com.baidu.swan.games.view.a
                public void aSV() {
                    h.this.eaQ = true;
                    if (h.this.eaR) {
                        h.this.aSM();
                    }
                }

                @Override // com.baidu.swan.games.view.a
                public void aSW() {
                    h.this.eaQ = false;
                    h.this.pausePlay();
                }

                @Override // com.baidu.swan.games.view.a
                public void aSX() {
                }
            };
            com.baidu.swan.games.view.a.c.a(this.eaJ);
        }
        this.eaH.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (h.this.cDB != null) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                    h.this.eaR = true;
                    if (h.this.eaQ) {
                        h.this.aSM();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    h.this.eaR = false;
                }
            }
        }
    }

    private com.baidu.swan.game.ad.c.b kR(int i) {
        int i2;
        com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
        bVar.dZD = String.valueOf(this.dXp.getDuration());
        bVar.dZE = String.valueOf(this.mPausePosition);
        bVar.mEndTime = String.valueOf(i);
        bVar.dZF = this.mPausePosition == 0 ? "1" : "0";
        bVar.dZG = i == this.dXp.getDuration() ? "1" : "0";
        bVar.dZH = this.mContext.getResources().getConfiguration().orientation == 1 ? "2" : "4";
        if (this.mPausePosition == 0) {
            i2 = 1;
        } else if (this.mPausePosition == this.dXp.getDuration()) {
            i2 = 3;
        } else {
            i2 = 2;
        }
        bVar.mType = String.valueOf(i2);
        bVar.dZI = (this.mPausePosition == 0 && SwanAppNetworkUtils.isWifiNetworkConnected(this.mContext)) ? "1" : "2";
        bVar.mStatus = String.valueOf(0);
        return bVar;
    }

    public String getType() {
        return this.dYI ? "gdtvideo" : "video";
    }

    private int aSO() {
        return (this.cDB == null || !this.cDB.isEnd()) ? getProgress() : this.cDB.getDuration() / 1000;
    }

    @Override // com.baidu.swan.game.ad.a.a.d
    public void cM(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                jSONObject.put("title", this.dXp.getTitle());
                jSONObject.put("description", this.dXp.getDescription());
                jSONObject.put("autoinstall", true);
                if (this.eaY == null) {
                    this.eaY = new g(this.mContext, this.dXp, this.dXi);
                }
                this.eaY.qD(str);
                com.baidu.swan.apps.t.a.axg().a(this.mContext, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.eaY);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void aS(View view) {
        if (this.dYI && this.dXp != null) {
            com.baidu.swan.game.ad.c.d.d(this.dXp, this.dXi);
            com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
            bVar.dZv = String.valueOf(ah.getDisplayWidth(this.mContext));
            bVar.dZw = String.valueOf(ah.getDisplayHeight(this.mContext));
            bVar.dZx = String.valueOf(ah.getDisplayWidth(this.mContext));
            bVar.dZy = String.valueOf(ah.getDisplayHeight(this.mContext));
            bVar.dZz = String.valueOf((int) view.getX());
            bVar.dZA = String.valueOf((int) view.getY());
            bVar.dZB = String.valueOf((int) view.getX());
            bVar.dZC = String.valueOf((int) view.getY());
            if (this.dXp.getActionType() == 2) {
                com.baidu.swan.game.ad.c.d.a(bVar, this.dXp, this.dXi, this);
                return;
            }
            com.baidu.swan.apps.core.d.f afX = com.baidu.swan.apps.v.f.aAl().afX();
            if (afX == null) {
                if (this.mContext != null) {
                    com.baidu.swan.apps.res.widget.b.d.u(this.mContext, c.g.aiapps_open_fragment_failed_toast).aIs();
                }
            } else if (this.dXp != null) {
                String a2 = com.baidu.swan.game.ad.c.d.a(this.dXp.aRR(), bVar);
                afX.mC("adLanding").af(com.baidu.swan.apps.core.d.f.cSz, com.baidu.swan.apps.core.d.f.cSB).a("adLanding", com.baidu.swan.apps.model.b.bZ(a2, a2)).apI();
            }
        }
    }
}
