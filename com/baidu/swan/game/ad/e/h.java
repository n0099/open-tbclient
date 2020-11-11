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
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.a.a;
import com.baidu.swan.game.ad.b.b;
import com.baidu.swan.game.ad.c;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class h implements a.InterfaceC0516a, a.b, a.c, a.d {
    private com.baidu.swan.apps.media.b.a cvT;
    private com.baidu.swan.apps.adlanding.b cvZ;
    private com.baidu.swan.apps.adlanding.download.a.a cwe;
    private com.baidu.swan.apps.adlanding.download.model.a cwf;
    private AdElementInfo dLG;
    public String dLc;
    private String dNG;
    private boolean dNb;
    private String dNk;
    private com.baidu.swan.game.ad.b dOZ;
    private com.baidu.swan.games.view.a dPb;
    private k dPc;
    private l dPd;
    public com.baidu.swan.apps.res.widget.dialog.g dPe;
    private j dPf;
    private boolean dPg;
    private a dPh;
    private boolean dPi;
    private boolean dPo;
    private boolean dPp;
    private g dPq;
    private static String dOP = "0";
    private static String dOQ = "100";
    private static String dOR = TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY;
    private static String dOS = TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY;
    private static String dOT = TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY;
    private static String dOU = TbEnum.SystemMessage.EVENT_ID_GROUP_UPGRADE;
    private static String dOV = "1";
    private static String dOW = "0";
    private static String dOX = "status";
    private static String dOY = "isPaused";
    private static String KEY_TOKEN = "token";
    private static String dPn = "monitors";
    private int dPa = 256;
    private int mPausePosition = 0;
    private boolean dPj = true;
    private String dPk = dOR;
    private String dPl = dOW;
    private Map<String, String> dPm = new HashMap();
    private SwanAdDownloadState cwg = SwanAdDownloadState.NOT_START;
    private Context mContext = AppRuntime.getAppContext();
    private b dLz = new b(this.mContext);
    private com.baidu.swan.game.ad.jsbridge.a dLx = new com.baidu.swan.game.ad.jsbridge.a();
    private boolean dLy = com.baidu.swan.game.ad.d.f.aRl();

    public h(String str, String str2, boolean z) {
        this.dLc = "";
        this.dNk = str;
        this.dLc = str2;
        this.dNb = z;
        this.dPp = z;
    }

    public void a(j jVar) {
        this.dPf = jVar;
    }

    public synchronized void b(com.baidu.swan.games.binding.model.c cVar) {
        com.baidu.swan.game.ad.b.d fVar;
        k d = k.d(cVar);
        if (this.dPa == 257) {
            com.baidu.swan.game.ad.e.a.aRn().a(d);
        } else if (this.dPa == 261 || this.dPa == 260 || this.dPa == 265) {
            a(d, "3010006");
        } else {
            if (this.dPa == 258) {
                if (aRB()) {
                    this.dPa = AuthorityState.STATE_INIT_ING;
                } else {
                    c(d);
                }
            }
            if (this.dPa == 259 || this.dPa == 262 || this.dPa == 263 || this.dPa == 264 || this.dPa == 256 || this.dPa == 272) {
                com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
                String str = "";
                if (aHu != null) {
                    str = aHu.getAppKey();
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.dNk) || TextUtils.isEmpty(this.dLc)) {
                    a(d, "3010007");
                } else {
                    this.dPc = d;
                    this.dPa = 257;
                    com.baidu.swan.game.ad.b.b aQV = new b.a().vI(this.dNk).vJ(this.dLc).vK(str).lP(ah.getDisplayWidth(this.mContext)).lQ(ah.getDisplayHeight(this.mContext)).lR(1).aQV();
                    if (this.dPp) {
                        this.dNb = true;
                        fVar = new com.baidu.swan.game.ad.b.e(this.mContext, aQV, 5, 5);
                        com.baidu.swan.games.view.a.b.dn("gdtvideo", null);
                    } else {
                        this.dNb = false;
                        fVar = new com.baidu.swan.game.ad.b.f(this.mContext, aQV);
                        this.dNG = fVar.aRa();
                        com.baidu.swan.games.view.a.b.dn("video", null);
                    }
                    com.baidu.swan.game.ad.b.a aVar = new com.baidu.swan.game.ad.b.a(this.mContext, this.dNb);
                    aVar.a(this);
                    aVar.a(fVar, this.dLz);
                }
            }
        }
    }

    public synchronized void c(com.baidu.swan.games.binding.model.c cVar) {
        final l e = l.e(cVar);
        String str = "";
        if (this.dPa == 261 || this.dPa == 260 || this.dPa == 265) {
            if (e != null) {
                e.vR("3010004");
            }
            if (this.dPf != null) {
                this.dPf.onError("3010004");
            }
        } else if (this.dPa != 258 || aRB()) {
            a(e, "3010004");
        } else if (this.dLG != null && TextUtils.isEmpty(this.dLG.getVideoUrl())) {
            a(e, "3010008");
        } else if (this.dPa == 258) {
            this.dPa = 265;
            if (this.dLG != null) {
                str = this.dLG.aQC();
            }
            if (com.baidu.swan.games.view.a.c.isLandScape() && (com.baidu.swan.games.view.a.c.aYk() || !TextUtils.isEmpty(str))) {
                SwanAppActivity azy = com.baidu.swan.apps.v.f.azO().azy();
                if (azy != null) {
                    azy.setRequestedOrientation(1);
                }
                com.baidu.swan.apps.v.f.azO().azS().hG(true);
            }
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.h.1
                @Override // java.lang.Runnable
                public void run() {
                    h.this.aRD();
                    if (com.baidu.swan.games.view.a.c.aN(h.this.dOZ.getConvertView())) {
                        com.baidu.swan.games.view.a.c.removeView(h.this.dOZ.getConvertView());
                    }
                    if (!com.baidu.swan.games.view.a.c.c(h.this.dOZ.getConvertView(), com.baidu.swan.apps.model.a.a.a.aCe())) {
                        h.this.a(e, "3010000");
                        return;
                    }
                    h.this.dPd = e;
                    h.this.dPa = 260;
                    h.this.dOZ.bs(h.this.dLG.getVideoUrl());
                }
            });
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void a(AdElementInfo adElementInfo) {
        this.dLG = adElementInfo;
        this.dNb = this.dLG.aQM();
        this.dPa = 258;
        c(this.dPc);
        if (!this.dNb && this.dLG.getActionType() == 2) {
            initDownload();
        }
        com.baidu.swan.games.view.a.b.dn(getType(), "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void vC(String str) {
        this.dPa = 259;
        a(this.dPc, str);
        com.baidu.swan.games.view.a.b.ac(getType(), "fail", str);
    }

    private void aRv() {
        com.baidu.swan.games.view.a.b.g(getType(), "pageclose", this.cvT.getDuration() / 1000);
        aRz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRw() {
        if (this.cvT != null && this.dOZ != null) {
            if (this.cvT.isPlaying()) {
                this.cvT.pause();
                this.dOZ.aPL();
            }
            this.dPa = 262;
            if (this.dNb) {
                com.baidu.swan.game.ad.c.d.b(lS(this.dLG.getDuration()), this.dLG, this.dLz);
            } else {
                com.baidu.swan.game.ad.c.c.a(getProgress(), this.mPausePosition, this.dLG, this.dLz);
            }
            if (this.dOZ != null) {
                if (this.cvT.isEnd()) {
                    this.dOZ.aPO();
                } else {
                    this.dOZ.aPP();
                }
            }
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.c
    public void aJ(View view) {
        SwanAppActivity azy;
        int i;
        int i2;
        int i3;
        String format;
        if (this.cvT != null && this.dLG != null && (azy = com.baidu.swan.apps.v.f.azO().azy()) != null && !this.dPg) {
            if (view != null && c.e.close_ad != view.getId()) {
                aRv();
                return;
            }
            int currentPosition = this.cvT.getCurrentPosition() / 1000;
            int min = Math.min(this.dLG.aQA(), this.cvT.getDuration() / 1000);
            if (currentPosition >= min) {
                aRw();
                return;
            }
            int aYi = com.baidu.swan.games.view.a.c.aYi();
            int aYj = com.baidu.swan.games.view.a.c.aYj();
            if (com.baidu.swan.games.view.a.c.isLandScape()) {
                i = (int) (aYi * 0.275f);
                i2 = (int) (aYi * 0.275f);
                i3 = (int) (0.05f * aYj);
            } else {
                int min2 = Math.min(aYi, aYj);
                i = (int) (min2 * 0.1f);
                i2 = (int) (min2 * 0.1f);
                i3 = 0;
            }
            aPL();
            com.baidu.swan.games.view.a.b.g(getType(), "pageshow", getProgress());
            this.mContext.getResources().getString(c.g.swangame_game_ad_dialog_msg_more);
            if (this.dLy) {
                format = String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_reward_msg_time_tip), Integer.valueOf(15 - (this.cvT.getCurrentPosition() / 1000)));
            } else {
                format = String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_video_close_alert), Integer.valueOf(min - currentPosition));
            }
            this.dPg = true;
            this.dPe = new g.a(azy).gp(true).d(c.g.ad_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.e.h.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    if (!h.this.dLy || h.this.dOZ == null) {
                        h.this.aRz();
                    } else {
                        if (h.this.cvT != null) {
                            h.this.cvT.pause();
                        }
                        if (h.this.dPh != null) {
                            h.this.mContext.unregisterReceiver(h.this.dPh);
                            h.this.dPh = null;
                        }
                        h.this.dPa = 262;
                        h.this.dOZ.aPP();
                    }
                    h.this.dPg = false;
                    com.baidu.swan.games.view.a.b.g(h.this.getType(), "close", h.this.getProgress());
                }
            }).rR(format).c(c.g.ad_continue_watch, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.e.h.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    h.this.aRC();
                    h.this.dPg = false;
                    com.baidu.swan.games.view.a.b.g(h.this.getType(), "continue", h.this.getProgress());
                }
            }).kb(c.b.aiapps_game_continue_watch).c(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.game.ad.e.h.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    h.this.dPg = false;
                }
            }).a(new com.baidu.swan.apps.view.c.a()).n(i, 0, i2, i3).aHb();
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.d
    public void aK(View view) {
        com.baidu.swan.games.view.a.b.g(getType(), "click", aRE());
        if (this.dNb) {
            aL(view);
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0516a
    public void a(CommandType commandType, Uri uri) {
        String aQE = this.dLG.aQE();
        String packageName = this.dLG.getPackageName();
        switch (commandType) {
            case ACTION_URL:
                if (this.dLG.getActionType() == 2) {
                    aRx();
                    break;
                } else {
                    aRy();
                    break;
                }
            case OPEN_APP:
                if (this.dLG != null) {
                    ao(this.mContext, packageName);
                    break;
                }
                break;
            case GET_DOWNLOAD_STATUS:
                if (this.dLx != null) {
                    if (am(this.mContext, packageName)) {
                        this.dPk = dOT;
                    }
                    String queryParameter = uri.getQueryParameter(KEY_TOKEN);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(dOX, this.dPk);
                        jSONObject.put(dOY, this.dPl);
                        this.dLx.cP(queryParameter, jSONObject.toString());
                        break;
                    } catch (JSONException e) {
                        break;
                    }
                } else {
                    return;
                }
            case PAUSE_DOWNLOAD:
                this.dPl = dOV;
                aRx();
                break;
            case BANNER_VIEW:
                com.baidu.swan.apps.core.d.f afM = com.baidu.swan.apps.v.f.azO().afM();
                if (afM == null) {
                    if (this.mContext != null) {
                        com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                        return;
                    }
                    return;
                }
                afM.nb("adLanding").al(com.baidu.swan.apps.core.d.f.cKS, com.baidu.swan.apps.core.d.f.cKU).a("adLanding", com.baidu.swan.apps.model.b.cb(aQE, aQE)).apn();
                break;
        }
        com.baidu.swan.game.ad.c.c.d(this.dLG, this.dLz);
        com.baidu.swan.games.view.a.b.g(getType(), "click", aRE());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SwanAdDownloadState swanAdDownloadState) {
        this.cwg = swanAdDownloadState;
        if (swanAdDownloadState == SwanAdDownloadState.NOT_START) {
            this.dPk = dOR;
            this.dPl = dOW;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
            this.dPk = dOP;
            this.dPl = dOV;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
            this.dPk = dOS;
            this.dPl = dOW;
        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
            this.dPk = dOT;
            this.dPl = dOW;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
            this.dPk = dOP;
            this.dPl = dOW;
        }
    }

    private void initDownload() {
        this.cvZ = new com.baidu.swan.apps.adlanding.b(this.mContext, this.dLG.aQK());
        this.cwe = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.game.ad.e.h.5
            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void eq(boolean z) {
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void kB(String str) {
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                if (!h.this.dPo) {
                    h.this.d(swanAdDownloadState);
                }
                h.this.dPo = true;
                if (h.this.cwg != swanAdDownloadState) {
                    if (h.this.cwg == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                        h.this.dPl = h.dOW;
                        h.this.cvZ.ky("appdownloadbegin");
                    } else if (swanAdDownloadState != SwanAdDownloadState.DOWNLOAD_PAUSED) {
                        if (h.this.cwg == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            h.this.dPl = h.dOW;
                            h.this.cvZ.ky("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            h.this.dPl = h.dOW;
                            h.this.dPk = h.dOS;
                            h.this.cvZ.ky("appdownloadfinish");
                            h.this.cvZ.ky("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            h.this.dPl = h.dOW;
                            h.this.dPk = h.dOT;
                            h.this.cvZ.ky("appinstallfinish");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_FAILED) {
                            h.this.dPl = h.dOW;
                            h.this.dPk = h.dOU;
                        } else if (swanAdDownloadState == SwanAdDownloadState.DELETED) {
                            h.this.dPl = h.dOW;
                            h.this.dPk = h.dOR;
                        }
                    } else {
                        h.this.dPl = h.dOV;
                        h.this.cvZ.ky("appdownloadpause");
                    }
                    h.this.cwg = swanAdDownloadState;
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                if (i != 0) {
                    if (i != 100 || h.this.dPk == h.dOR) {
                        if (h.this.dPk != h.dOR && h.this.dPk != h.dOU) {
                            h.this.dPk = String.valueOf(i);
                            return;
                        }
                        return;
                    }
                    h.this.dPk = h.dOS;
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void ajd() {
                h.this.cvZ.ky("appinstallbegin");
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public String aje() {
                h.this.cvZ.ky("appinstallopen");
                return "";
            }
        };
        String aQE = this.dLG.aQE();
        String packageName = this.dLG.getPackageName();
        String str = this.dPm.get(packageName);
        if (str == null) {
            this.dPm.put(packageName, aQE);
            str = aQE;
        }
        this.cwf = new com.baidu.swan.apps.adlanding.download.model.a(str, packageName, this.dLG.getTitle());
        this.dPo = false;
        com.baidu.swan.apps.t.a.awK().a(this.mContext, this.cwf.ajg(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS, this.cwe);
    }

    private boolean am(Context context, String str) {
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

    private boolean ao(Context context, String str) {
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
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "打开失败").km(3).showToast();
            }
        } else {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "打开失败").km(3).showToast();
        }
        return false;
    }

    private void aRx() {
        if (ak.isAppInstalled(this.mContext, this.cwf.name)) {
            this.dPk = dOT;
            ao(this.mContext, this.cwf.name);
            this.cvZ.ky("appinstallopen");
            return;
        }
        if (this.cwg == SwanAdDownloadState.NOT_START || this.cwg == SwanAdDownloadState.DELETED) {
            this.dPk = dOP;
            com.baidu.swan.apps.t.a.awK().a(this.mContext, this.cwf.ajg(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.cwe);
        }
        if (this.cwg == SwanAdDownloadState.DOWNLOADING) {
            com.baidu.swan.apps.t.a.awK().a(this.mContext, this.cwf.ajg(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.cwe);
        }
        if (this.cwg == SwanAdDownloadState.DOWNLOAD_PAUSED) {
            this.dPl = dOW;
            com.baidu.swan.apps.t.a.awK().a(this.mContext, this.cwf.ajg(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.cwe);
        }
        if (this.cwg == SwanAdDownloadState.DOWNLOAD_FAILED) {
            com.baidu.swan.apps.t.a.awK().a(this.mContext, this.cwf.ajg(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.cwe);
        }
        if (this.cwg == SwanAdDownloadState.DOWNLOADED) {
            this.dPk = dOS;
            this.cwe.ajd();
            com.baidu.swan.apps.t.a.awK().a(this.mContext, this.cwf.ajg(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, this.cwe);
        }
        if (this.cwg == SwanAdDownloadState.INSTALLED) {
            ao(this.mContext, this.cwf.name);
        }
    }

    private void aRy() {
        String aQE = this.dLG.aQE();
        com.baidu.swan.apps.core.d.f afM = com.baidu.swan.apps.v.f.azO().afM();
        if (afM == null) {
            if (this.mContext != null) {
                com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                return;
            }
            return;
        }
        JSONObject aQK = this.dLG.aQK();
        com.baidu.swan.apps.model.b cb = com.baidu.swan.apps.model.b.cb(aQE, aQE);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(dPn, aQK);
        } catch (JSONException e) {
        }
        cb.setParams(jSONObject.toString());
        afM.nb("adLanding").al(com.baidu.swan.apps.core.d.f.cKS, com.baidu.swan.apps.core.d.f.cKU).a("adLanding", cb).apn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRz() {
        if (this.dPf != null && this.cvT != null) {
            this.dPf.hk(this.cvT.isEnd() || this.cvT.getCurrentPosition() / 1000 >= Math.min(this.dLG.aQA(), this.cvT.getDuration() / 1000));
        }
        aRA();
        if (!this.dNb && this.dLG.getActionType() == 2 && SwanAdDownloadState.DOWNLOADING == this.cwg) {
            this.cwe = null;
            com.baidu.swan.apps.t.a.awK().a(this.mContext, this.cwf.ajg(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.cwe);
        }
        com.baidu.swan.game.ad.c.c.f(this.dLG, this.dLz);
        this.dPa = 263;
        b((com.baidu.swan.games.binding.model.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRA() {
        if (this.cvT != null) {
            this.cvT.pause();
            this.cvT.onDestroy();
        }
        if (this.dPh != null) {
            this.mContext.unregisterReceiver(this.dPh);
            this.dPh = null;
        }
        if (this.dOZ != null) {
            this.dOZ.aPN();
            this.dOZ.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_close));
            com.baidu.swan.games.view.a.c.removeView(this.dOZ.getConvertView());
        }
        if (this.dPb != null) {
            com.baidu.swan.games.view.a.c.b(this.dPb);
            this.dPb = null;
        }
        if (this.dPq != null) {
            this.dPq.release();
            this.dPq = null;
        }
    }

    private boolean aRB() {
        if (this.dLG == null) {
            return true;
        }
        long aQF = this.dLG.aQF() * 1000;
        if (aQF == 0) {
            aQF = 1740000;
        }
        return System.currentTimeMillis() - this.dLG.getCreateTime() >= aQF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getProgress() {
        if (this.cvT != null) {
            return this.cvT.getCurrentPosition() / 1000;
        }
        return 0;
    }

    private void c(k kVar) {
        if (this.dPf != null) {
            this.dPf.onLoad();
        }
        if (kVar != null) {
            kVar.aRN();
        }
        com.baidu.swan.game.ad.e.a.aRn().aq(16, "");
    }

    private void a(k kVar, String str) {
        if (this.dPf != null) {
            this.dPf.onError(str);
        }
        if (kVar != null) {
            kVar.vQ(str);
        }
        com.baidu.swan.game.ad.e.a.aRn().aq(17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPL() {
        if (this.cvT != null && this.dOZ != null && this.cvT.isPlaying()) {
            this.cvT.pause();
            this.dOZ.aPL();
            if (this.dNb) {
                com.baidu.swan.game.ad.c.d.b(lS(getProgress()), this.dLG, this.dLz);
            } else {
                com.baidu.swan.game.ad.c.c.a(getProgress(), this.mPausePosition, this.dLG, this.dLz);
            }
            this.mPausePosition = getProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRC() {
        if (this.cvT != null && this.dOZ != null) {
            if ((this.dPe == null || !this.dPe.isShowing()) && !this.cvT.isPlaying() && !this.dOZ.aPV()) {
                this.cvT.resume();
                this.dOZ.aPM();
                com.baidu.swan.game.ad.c.c.e(this.dLG, this.dLz);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar, String str) {
        if (lVar != null) {
            lVar.vR(str);
        }
        if (this.dPf != null) {
            this.dPf.onError(str);
        }
        this.dPa = 264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRD() {
        this.dLx.b(this);
        if (com.baidu.swan.games.view.a.c.isLandScape()) {
            this.dOZ = new com.baidu.swan.game.ad.d(this.mContext, this.dLG, this.dLx);
        } else {
            this.dOZ = new com.baidu.swan.game.ad.e(this.mContext, this.dLG, this.dLx);
        }
        if (this.dNb) {
            this.dOZ.a((a.d) this);
        }
        this.dOZ.a((a.c) this);
        this.cvT = this.dOZ.getPlayer();
        this.cvT.b(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.game.ad.e.h.6
            @Override // com.baidu.swan.apps.media.b.b
            public void a(com.baidu.swan.apps.t.b.j jVar) {
                if (h.this.dOZ != null) {
                    h.this.dOZ.onPrepared();
                }
                h.this.dPa = 261;
                h.this.mPausePosition = 0;
                if (h.this.dOZ != null) {
                    h.this.dOZ.aPK();
                }
                if (h.this.dPd != null) {
                    h.this.dPd.aRO();
                }
                if (h.this.dPh == null) {
                    h.this.dPh = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    h.this.mContext.registerReceiver(h.this.dPh, intentFilter);
                }
                if (h.this.dNb) {
                    com.baidu.swan.game.ad.c.d.a(h.this.dLG, h.this.dLz);
                    return;
                }
                com.baidu.swan.game.ad.c.c.a(h.this.dLG, h.this.dLz);
                com.baidu.swan.game.ad.c.c.e(h.this.dLG, h.this.dLz);
                com.baidu.swan.game.ad.c.c.a(h.this.dNk, h.this.dLc, h.this.dNG, h.this.dLz);
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(com.baidu.swan.apps.t.b.j jVar, int i, int i2) {
                h.this.aRA();
                h.this.a(h.this.dPd, "3010001");
                return true;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(com.baidu.swan.apps.t.b.j jVar) {
                h.this.aRw();
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
        if (this.dPb == null) {
            this.dPb = new com.baidu.swan.games.view.a() { // from class: com.baidu.swan.game.ad.e.h.7
                @Override // com.baidu.swan.games.view.a
                public void aRL() {
                    h.this.dPi = true;
                    if (h.this.dPj) {
                        h.this.aRC();
                    }
                }

                @Override // com.baidu.swan.games.view.a
                public void aRM() {
                    h.this.dPi = false;
                    h.this.aPL();
                }

                @Override // com.baidu.swan.games.view.a
                public void onViewDestroy() {
                }
            };
            com.baidu.swan.games.view.a.c.a(this.dPb);
        }
        this.dOZ.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (h.this.cvT != null) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                    h.this.dPj = true;
                    if (h.this.dPi) {
                        h.this.aRC();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    h.this.dPj = false;
                }
            }
        }
    }

    private com.baidu.swan.game.ad.c.b lS(int i) {
        int i2;
        com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
        bVar.dNW = String.valueOf(this.dLG.getDuration());
        bVar.dNX = String.valueOf(this.mPausePosition);
        bVar.mEndTime = String.valueOf(i);
        bVar.dNY = this.mPausePosition == 0 ? "1" : "0";
        bVar.dNZ = i == this.dLG.getDuration() ? "1" : "0";
        bVar.dOa = this.mContext.getResources().getConfiguration().orientation == 1 ? "2" : "4";
        if (this.mPausePosition == 0) {
            i2 = 1;
        } else if (this.mPausePosition == this.dLG.getDuration()) {
            i2 = 3;
        } else {
            i2 = 2;
        }
        bVar.mType = String.valueOf(i2);
        bVar.dOb = (this.mPausePosition == 0 && SwanAppNetworkUtils.isWifiNetworkConnected(this.mContext)) ? "1" : "2";
        bVar.mStatus = String.valueOf(0);
        return bVar;
    }

    public String getType() {
        return this.dNb ? "gdtvideo" : "video";
    }

    private int aRE() {
        return (this.cvT == null || !this.cvT.isEnd()) ? getProgress() : this.cvT.getDuration() / 1000;
    }

    @Override // com.baidu.swan.game.ad.a.a.d
    public void cO(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                jSONObject.put("title", this.dLG.getTitle());
                jSONObject.put("description", this.dLG.getDescription());
                jSONObject.put("autoinstall", true);
                if (this.dPq == null) {
                    this.dPq = new g(this.mContext, this.dLG, this.dLz);
                }
                this.dPq.rc(str);
                com.baidu.swan.apps.t.a.awK().a(this.mContext, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.dPq);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void aL(View view) {
        if (this.dNb && this.dLG != null) {
            com.baidu.swan.game.ad.c.d.d(this.dLG, this.dLz);
            com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
            bVar.dNO = String.valueOf(ah.getDisplayWidth(this.mContext));
            bVar.dNP = String.valueOf(ah.getDisplayHeight(this.mContext));
            bVar.dNQ = String.valueOf(ah.getDisplayWidth(this.mContext));
            bVar.dNR = String.valueOf(ah.getDisplayHeight(this.mContext));
            bVar.dNS = String.valueOf((int) view.getX());
            bVar.dNT = String.valueOf((int) view.getY());
            bVar.dNU = String.valueOf((int) view.getX());
            bVar.dNV = String.valueOf((int) view.getY());
            if (this.dLG.getActionType() == 2) {
                com.baidu.swan.game.ad.c.d.a(bVar, this.dLG, this.dLz, this);
                return;
            }
            com.baidu.swan.apps.core.d.f afM = com.baidu.swan.apps.v.f.azO().afM();
            if (afM == null) {
                if (this.mContext != null) {
                    com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                }
            } else if (this.dLG != null) {
                String a2 = com.baidu.swan.game.ad.c.d.a(this.dLG.aQE(), bVar);
                afM.nb("adLanding").al(com.baidu.swan.apps.core.d.f.cKS, com.baidu.swan.apps.core.d.f.cKU).a("adLanding", com.baidu.swan.apps.model.b.cb(a2, a2)).apn();
            }
        }
    }
}
