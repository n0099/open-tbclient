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
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.al;
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
/* loaded from: classes9.dex */
public class h implements a.InterfaceC0431a, a.b, a.c, a.d {
    private com.baidu.swan.apps.media.b.a bNE;
    private com.baidu.swan.apps.adlanding.b bNK;
    private com.baidu.swan.apps.adlanding.download.a.a bNP;
    private com.baidu.swan.apps.adlanding.download.model.a bNQ;
    public String cZn;
    private String daV;
    private boolean dao;
    private String daz;
    private AdElementInfo dbV;
    private boolean dcF;
    private boolean dcG;
    private g dcH;
    private com.baidu.swan.game.ad.b dcp;
    private com.baidu.swan.games.view.a dcr;
    private k dcs;
    private l dct;
    public com.baidu.swan.apps.res.widget.dialog.g dcv;
    private j dcw;
    private boolean dcx;
    private a dcy;
    private boolean dcz;
    private static String dcf = "0";
    private static String dcg = "100";
    private static String dch = TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY;
    private static String dci = TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY;
    private static String dcj = TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY;
    private static String dck = TbEnum.SystemMessage.EVENT_ID_GROUP_UPGRADE;
    private static String dcl = "1";
    private static String dcm = "0";
    private static String dcn = "status";
    private static String dco = "isPaused";
    private static String KEY_TOKEN = "token";
    private static String dcE = "monitors";
    private int dcq = 256;
    private int mPausePosition = 0;
    private boolean dcA = true;
    private String dcB = dch;
    private String dcC = dcm;
    private Map<String, String> dcD = new HashMap();
    private SwanAdDownloadState bNR = SwanAdDownloadState.NOT_START;
    private Context mContext = AppRuntime.getAppContext();
    private b dbU = new b(this.mContext);
    private com.baidu.swan.game.ad.jsbridge.a cZH = new com.baidu.swan.game.ad.jsbridge.a();
    private boolean cZI = com.baidu.swan.game.ad.d.f.aAO();

    public h(String str, String str2, boolean z) {
        this.cZn = "";
        this.daz = str;
        this.cZn = str2;
        this.dao = z;
        this.dcG = z;
    }

    public void a(j jVar) {
        this.dcw = jVar;
    }

    public synchronized void b(com.baidu.swan.games.binding.model.c cVar) {
        com.baidu.swan.game.ad.b.d fVar;
        k d = k.d(cVar);
        if (this.dcq == 257) {
            com.baidu.swan.game.ad.e.a.aAQ().a(d);
        } else if (this.dcq == 261 || this.dcq == 260 || this.dcq == 265) {
            a(d, "3010006");
        } else {
            if (this.dcq == 258) {
                if (aBd()) {
                    this.dcq = AuthorityState.STATE_INIT_ING;
                } else {
                    c(d);
                }
            }
            if (this.dcq == 259 || this.dcq == 262 || this.dcq == 263 || this.dcq == 264 || this.dcq == 256 || this.dcq == 272) {
                com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
                String str = "";
                if (arv != null) {
                    str = arv.getAppKey();
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.daz) || TextUtils.isEmpty(this.cZn)) {
                    a(d, "3010007");
                } else {
                    this.dcs = d;
                    this.dcq = 257;
                    com.baidu.swan.game.ad.b.b aAx = new b.a().rC(this.daz).rD(this.cZn).rE(str).iD(ai.getDisplayWidth(this.mContext)).iE(ai.getDisplayHeight(this.mContext)).iF(1).aAx();
                    if (this.dcG) {
                        this.dao = true;
                        fVar = new com.baidu.swan.game.ad.b.e(this.mContext, aAx, 5, 5);
                        com.baidu.swan.games.view.a.b.cH("gdtvideo", null);
                    } else {
                        this.dao = false;
                        fVar = new com.baidu.swan.game.ad.b.f(this.mContext, aAx);
                        this.daV = fVar.aAD();
                        com.baidu.swan.games.view.a.b.cH("video", null);
                    }
                    com.baidu.swan.game.ad.b.a aVar = new com.baidu.swan.game.ad.b.a(this.mContext, this.dao);
                    aVar.a(this);
                    aVar.a(fVar, this.dbU);
                }
            }
        }
    }

    public synchronized void c(com.baidu.swan.games.binding.model.c cVar) {
        final l e = l.e(cVar);
        if (this.dcq == 261 || this.dcq == 260 || this.dcq == 265) {
            if (e != null) {
                e.rM("3010004");
            }
            if (this.dcw != null) {
                this.dcw.onError("3010004");
            }
        } else if (this.dcq != 258 || aBd()) {
            a(e, "3010004");
        } else if (this.dbV != null && TextUtils.isEmpty(this.dbV.getVideoUrl())) {
            a(e, "3010008");
        } else if (this.dcq == 258) {
            this.dcq = 265;
            if (com.baidu.swan.games.view.a.c.isLandScape() && com.baidu.swan.games.view.a.c.aHF()) {
                SwanAppActivity akb = com.baidu.swan.apps.v.f.akr().akb();
                if (akb != null) {
                    akb.setRequestedOrientation(1);
                }
                com.baidu.swan.apps.v.f.akr().akv().gt(true);
            }
            al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.h.1
                @Override // java.lang.Runnable
                public void run() {
                    h.this.aBf();
                    if (com.baidu.swan.games.view.a.c.aD(h.this.dcp.getConvertView())) {
                        com.baidu.swan.games.view.a.c.ay(h.this.dcp.getConvertView());
                    }
                    if (!com.baidu.swan.games.view.a.c.c(h.this.dcp.getConvertView(), com.baidu.swan.apps.model.a.a.a.amu())) {
                        h.this.a(e, "3010000");
                        return;
                    }
                    h.this.dct = e;
                    h.this.dcq = 260;
                    h.this.dcp.bl(h.this.dbV.getVideoUrl());
                }
            });
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void a(AdElementInfo adElementInfo) {
        this.dbV = adElementInfo;
        this.dao = this.dbV.aAn();
        this.dcq = 258;
        c(this.dcs);
        if (!this.dao && this.dbV.getActionType() == 2) {
            initDownload();
        }
        com.baidu.swan.games.view.a.b.cH(getType(), "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void rw(String str) {
        this.dcq = 259;
        a(this.dcs, str);
        com.baidu.swan.games.view.a.b.R(getType(), "fail", str);
    }

    @Override // com.baidu.swan.game.ad.a.a.c
    public void aAp() {
        SwanAppActivity akb;
        int i;
        int i2;
        int i3;
        if (this.bNE != null && (akb = com.baidu.swan.apps.v.f.akr().akb()) != null && !this.dcx) {
            int aHD = com.baidu.swan.games.view.a.c.aHD();
            int aHE = com.baidu.swan.games.view.a.c.aHE();
            if (com.baidu.swan.games.view.a.c.isLandScape()) {
                i = (int) (aHD * 0.275f);
                i2 = (int) (aHD * 0.275f);
                i3 = (int) (0.05f * aHE);
            } else {
                int min = Math.min(aHD, aHE);
                i = (int) (min * 0.1f);
                i2 = (int) (min * 0.1f);
                i3 = 0;
            }
            azN();
            if (this.bNE.isEnd() || (this.cZI && this.dcq == 262)) {
                com.baidu.swan.games.view.a.b.f(getType(), "pageclose", this.bNE.getDuration() / 1000);
                aBb();
                return;
            }
            com.baidu.swan.games.view.a.b.f(getType(), "pageshow", getProgress());
            int duration = this.bNE.getDuration();
            String string = this.mContext.getResources().getString(c.g.swangame_game_ad_dialog_msg_more);
            if (this.cZI) {
                string = String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_reward_msg_time_tip), Integer.valueOf(15 - (this.bNE.getCurrentPosition() / 1000)));
            } else if (this.dbV != null) {
                int currentPosition = this.bNE.getCurrentPosition() / 1000;
                int min2 = Math.min(this.dbV.aAc(), duration / 1000);
                if (currentPosition >= min2) {
                    aBb();
                    return;
                }
                string = String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_video_close_alert), Integer.valueOf(min2 - currentPosition));
            }
            this.dcx = true;
            this.dcv = new g.a(akb).ff(true).d(c.g.ad_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.e.h.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    if (!h.this.cZI || h.this.dcp == null) {
                        h.this.aBb();
                    } else {
                        if (h.this.bNE != null) {
                            h.this.bNE.pause();
                        }
                        if (h.this.dcy != null) {
                            h.this.mContext.unregisterReceiver(h.this.dcy);
                            h.this.dcy = null;
                        }
                        h.this.dcq = 262;
                        h.this.dcp.azR();
                    }
                    h.this.dcx = false;
                    com.baidu.swan.games.view.a.b.f(h.this.getType(), "close", h.this.getProgress());
                }
            }).og(string).c(c.g.ad_continue_watch, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.e.h.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    h.this.aBe();
                    h.this.dcx = false;
                    com.baidu.swan.games.view.a.b.f(h.this.getType(), "continue", h.this.getProgress());
                }
            }).gR(c.b.aiapps_game_continue_watch).a(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.game.ad.e.h.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    h.this.dcx = false;
                }
            }).a(new com.baidu.swan.apps.view.c.a()).n(i, 0, i2, i3).ard();
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.d
    public void aA(View view) {
        com.baidu.swan.games.view.a.b.f(getType(), "click", aBg());
        if (this.dao) {
            aB(view);
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0431a
    public void a(CommandType commandType, Uri uri) {
        String aAf = this.dbV.aAf();
        String packageName = this.dbV.getPackageName();
        switch (commandType) {
            case ACTION_URL:
                if (this.dbV.getActionType() == 2) {
                    aAZ();
                    break;
                } else {
                    aBa();
                    break;
                }
            case OPEN_APP:
                if (this.dbV != null) {
                    ad(this.mContext, packageName);
                    break;
                }
                break;
            case GET_DOWNLOAD_STATUS:
                if (this.cZH != null) {
                    if (ac(this.mContext, packageName)) {
                        this.dcB = dcj;
                    }
                    String queryParameter = uri.getQueryParameter(KEY_TOKEN);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(dcn, this.dcB);
                        jSONObject.put(dco, this.dcC);
                        this.cZH.cj(queryParameter, jSONObject.toString());
                        break;
                    } catch (JSONException e) {
                        break;
                    }
                } else {
                    return;
                }
            case PAUSE_DOWNLOAD:
                this.dcC = dcl;
                aAZ();
                break;
            case BANNER_VIEW:
                com.baidu.swan.apps.core.d.f Sc = com.baidu.swan.apps.v.f.akr().Sc();
                if (Sc == null) {
                    if (this.mContext != null) {
                        com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                        return;
                    }
                    return;
                }
                Sc.jO("adLanding").ag(com.baidu.swan.apps.core.d.f.cci, com.baidu.swan.apps.core.d.f.cck).a("adLanding", com.baidu.swan.apps.model.b.bB(aAf, aAf)).abl();
                break;
        }
        com.baidu.swan.game.ad.c.c.b(this.dbV, this.dbU);
    }

    private void initDownload() {
        this.bNK = new com.baidu.swan.apps.adlanding.b(this.mContext, this.dbV.aAl());
        this.bNP = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.game.ad.e.h.5
            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void Vj() {
                h.this.bNK.hp("appinstallbegin");
            }
        };
        String aAf = this.dbV.aAf();
        String packageName = this.dbV.getPackageName();
        String str = this.dcD.get(packageName);
        if (str == null) {
            this.dcD.put(packageName, aAf);
            str = aAf;
        }
        this.bNQ = new com.baidu.swan.apps.adlanding.download.model.a(str, packageName, this.dbV.getTitle());
        this.dcF = false;
        if (al.axe()) {
            com.baidu.swan.apps.t.a.aht().a(this.mContext, this.bNQ.Vl(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS, this.bNP);
        }
    }

    private boolean ac(Context context, String str) {
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

    private boolean ad(Context context, String str) {
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
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "打开失败").hc(3).showToast();
            }
        } else {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "打开失败").hc(3).showToast();
        }
        return false;
    }

    private void aAZ() {
        if (!al.axe()) {
            com.baidu.swan.apps.t.a.aht().a(this.mContext, this.bNQ.Vl(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.bNP);
        } else if (al.isAppInstalled(this.mContext, this.bNQ.name)) {
            this.dcB = dcj;
            ad(this.mContext, this.bNQ.name);
            this.bNK.hp("appinstallopen");
        } else {
            if (this.bNR == SwanAdDownloadState.NOT_START || this.bNR == SwanAdDownloadState.DELETED) {
                this.dcB = dcf;
                com.baidu.swan.apps.t.a.aht().a(this.mContext, this.bNQ.Vl(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.bNP);
            }
            if (this.bNR == SwanAdDownloadState.DOWNLOADING) {
                com.baidu.swan.apps.t.a.aht().a(this.mContext, this.bNQ.Vl(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.bNP);
            }
            if (this.bNR == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                this.dcC = dcm;
                com.baidu.swan.apps.t.a.aht().a(this.mContext, this.bNQ.Vl(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.bNP);
            }
            if (this.bNR == SwanAdDownloadState.DOWNLOAD_FAILED) {
                com.baidu.swan.apps.t.a.aht().a(this.mContext, this.bNQ.Vl(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.bNP);
            }
            if (this.bNR == SwanAdDownloadState.DOWNLOADED) {
                this.dcB = dci;
                this.bNP.Vj();
                com.baidu.swan.apps.t.a.aht().a(this.mContext, this.bNQ.Vl(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, this.bNP);
            }
            if (this.bNR == SwanAdDownloadState.INSTALLED) {
                ad(this.mContext, this.bNQ.name);
            }
        }
    }

    private void aBa() {
        String aAf = this.dbV.aAf();
        com.baidu.swan.apps.core.d.f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        if (Sc == null) {
            if (this.mContext != null) {
                com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                return;
            }
            return;
        }
        JSONObject aAl = this.dbV.aAl();
        com.baidu.swan.apps.model.b bB = com.baidu.swan.apps.model.b.bB(aAf, aAf);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(dcE, aAl);
        } catch (JSONException e) {
        }
        bB.setParams(jSONObject.toString());
        Sc.jO("adLanding").ag(com.baidu.swan.apps.core.d.f.cci, com.baidu.swan.apps.core.d.f.cck).a("adLanding", bB).abl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBb() {
        if (this.dcw != null && this.bNE != null) {
            this.dcw.fX(this.bNE.isEnd());
        }
        aBc();
        if (!this.dao && this.dbV.getActionType() == 2 && SwanAdDownloadState.DOWNLOADING == this.bNR) {
            this.bNP = null;
            com.baidu.swan.apps.t.a.aht().a(this.mContext, this.bNQ.Vl(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.bNP);
        }
        com.baidu.swan.game.ad.c.c.d(this.dbV, this.dbU);
        this.dcq = 263;
        b((com.baidu.swan.games.binding.model.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBc() {
        if (this.bNE != null) {
            this.bNE.pause();
            this.bNE.onDestroy();
        }
        if (this.dcy != null) {
            this.mContext.unregisterReceiver(this.dcy);
            this.dcy = null;
        }
        if (this.dcp != null) {
            this.dcp.azP();
            this.dcp.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_close));
            com.baidu.swan.games.view.a.c.ay(this.dcp.getConvertView());
        }
        if (this.dcr != null) {
            com.baidu.swan.games.view.a.c.b(this.dcr);
            this.dcr = null;
        }
        if (this.dcH != null) {
            this.dcH.release();
            this.dcH = null;
        }
    }

    private boolean aBd() {
        if (this.dbV == null) {
            return true;
        }
        long aAg = this.dbV.aAg() * 1000;
        if (aAg == 0) {
            aAg = 1740000;
        }
        return System.currentTimeMillis() - this.dbV.getCreateTime() >= aAg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getProgress() {
        if (this.bNE != null) {
            return this.bNE.getCurrentPosition() / 1000;
        }
        return 0;
    }

    private void c(k kVar) {
        if (this.dcw != null) {
            this.dcw.onLoad();
        }
        if (kVar != null) {
            kVar.aBj();
        }
        com.baidu.swan.game.ad.e.a.aAQ().aa(16, "");
    }

    private void a(k kVar, String str) {
        if (this.dcw != null) {
            this.dcw.onError(str);
        }
        if (kVar != null) {
            kVar.rL(str);
        }
        com.baidu.swan.game.ad.e.a.aAQ().aa(17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azN() {
        if (this.bNE != null && this.dcp != null && this.bNE.isPlaying()) {
            this.bNE.pause();
            this.dcp.azN();
            if (this.dao) {
                com.baidu.swan.game.ad.c.d.b(iG(getProgress()), this.dbV, this.dbU);
            } else {
                com.baidu.swan.game.ad.c.c.a(getProgress(), this.mPausePosition, this.dbV, this.dbU);
            }
            this.mPausePosition = getProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBe() {
        if (this.bNE != null && this.dcp != null) {
            if ((this.dcv == null || !this.dcv.isShowing()) && !this.bNE.isPlaying() && !this.bNE.isEnd()) {
                this.bNE.resume();
                this.dcp.azO();
                com.baidu.swan.game.ad.c.c.c(this.dbV, this.dbU);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar, String str) {
        if (lVar != null) {
            lVar.rM(str);
        }
        if (this.dcw != null) {
            this.dcw.onError(str);
        }
        this.dcq = 264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBf() {
        this.cZH.b(this);
        if (com.baidu.swan.games.view.a.c.isLandScape()) {
            this.dcp = new com.baidu.swan.game.ad.d(this.mContext, this.dbV, this.cZH);
        } else {
            this.dcp = new com.baidu.swan.game.ad.e(this.mContext, this.dbV, this.cZH);
        }
        if (this.dao) {
            this.dcp.a((a.d) this);
        }
        this.dcp.a((a.c) this);
        this.bNE = this.dcp.getPlayer();
        this.bNE.b(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.game.ad.e.h.6
            @Override // com.baidu.swan.apps.media.b.b
            public void a(com.baidu.swan.apps.t.b.j jVar) {
                if (h.this.dcp != null) {
                    h.this.dcp.onPrepared();
                }
                h.this.dcq = 261;
                h.this.mPausePosition = 0;
                if (h.this.dcp != null) {
                    h.this.dcp.azM();
                }
                if (h.this.dct != null) {
                    h.this.dct.aBk();
                }
                if (h.this.dcy == null) {
                    h.this.dcy = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    h.this.mContext.registerReceiver(h.this.dcy, intentFilter);
                }
                if (h.this.dao) {
                    com.baidu.swan.game.ad.c.d.a(h.this.dbV, h.this.dbU);
                    return;
                }
                com.baidu.swan.game.ad.c.c.a(h.this.dbV, h.this.dbU);
                com.baidu.swan.game.ad.c.c.c(h.this.dbV, h.this.dbU);
                com.baidu.swan.game.ad.c.c.a(h.this.daz, h.this.cZn, h.this.daV, h.this.dbU);
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(com.baidu.swan.apps.t.b.j jVar, int i, int i2) {
                h.this.aBc();
                h.this.a(h.this.dct, "3010001");
                return true;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(com.baidu.swan.apps.t.b.j jVar) {
                h.this.dcq = 262;
                if (!h.this.dao) {
                    com.baidu.swan.game.ad.c.c.a(h.this.getProgress(), h.this.mPausePosition, h.this.dbV, h.this.dbU);
                } else {
                    com.baidu.swan.game.ad.c.d.b(h.this.iG(h.this.dbV.getDuration()), h.this.dbV, h.this.dbU);
                }
                if (h.this.dcp != null) {
                    h.this.dcp.azQ();
                }
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
        if (this.dcr == null) {
            this.dcr = new com.baidu.swan.games.view.a() { // from class: com.baidu.swan.game.ad.e.h.7
                @Override // com.baidu.swan.games.view.a
                public void aBh() {
                    h.this.dcz = true;
                    if (h.this.dcA) {
                        h.this.aBe();
                    }
                }

                @Override // com.baidu.swan.games.view.a
                public void aBi() {
                    h.this.dcz = false;
                    h.this.azN();
                }

                @Override // com.baidu.swan.games.view.a
                public void onViewDestroy() {
                }
            };
            com.baidu.swan.games.view.a.c.a(this.dcr);
        }
        this.dcp.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (h.this.bNE != null) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                    h.this.dcA = true;
                    if (h.this.dcz) {
                        h.this.aBe();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    h.this.dcA = false;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.game.ad.c.b iG(int i) {
        int i2;
        com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
        bVar.dbj = String.valueOf(this.dbV.getDuration());
        bVar.dbk = String.valueOf(this.mPausePosition);
        bVar.dbl = String.valueOf(i);
        bVar.dbm = this.mPausePosition == 0 ? "1" : "0";
        bVar.dbn = i == this.dbV.getDuration() ? "1" : "0";
        bVar.dbo = this.mContext.getResources().getConfiguration().orientation == 1 ? "2" : "4";
        if (this.mPausePosition == 0) {
            i2 = 1;
        } else if (this.mPausePosition == this.dbV.getDuration()) {
            i2 = 3;
        } else {
            i2 = 2;
        }
        bVar.mType = String.valueOf(i2);
        bVar.dbp = (this.mPausePosition == 0 && SwanAppNetworkUtils.isWifiNetworkConnected(this.mContext)) ? "1" : "2";
        bVar.mStatus = String.valueOf(0);
        return bVar;
    }

    public String getType() {
        return this.dao ? "gdtvideo" : "video";
    }

    private int aBg() {
        return (this.bNE == null || !this.bNE.isEnd()) ? getProgress() : this.bNE.getDuration() / 1000;
    }

    @Override // com.baidu.swan.game.ad.a.a.d
    public void ci(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                jSONObject.put("title", this.dbV.getTitle());
                jSONObject.put("description", this.dbV.getDescription());
                jSONObject.put("autoinstall", true);
                if (this.dcH == null) {
                    this.dcH = new g(this.mContext, this.dbV, this.dbU);
                }
                this.dcH.rJ(str);
                com.baidu.swan.apps.t.a.aht().a(this.mContext, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.dcH);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void aB(View view) {
        if (this.dao && this.dbV != null) {
            com.baidu.swan.game.ad.c.d.b(this.dbV, this.dbU);
            com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
            bVar.dbb = String.valueOf(ai.getDisplayWidth(this.mContext));
            bVar.dbc = String.valueOf(ai.getDisplayHeight(this.mContext));
            bVar.dbd = String.valueOf(ai.getDisplayWidth(this.mContext));
            bVar.dbe = String.valueOf(ai.getDisplayHeight(this.mContext));
            bVar.dbf = String.valueOf((int) view.getX());
            bVar.dbg = String.valueOf((int) view.getY());
            bVar.dbh = String.valueOf((int) view.getX());
            bVar.dbi = String.valueOf((int) view.getY());
            if (this.dbV.getActionType() == 2) {
                com.baidu.swan.game.ad.c.d.a(bVar, this.dbV, this.dbU, this);
                return;
            }
            com.baidu.swan.apps.core.d.f Sc = com.baidu.swan.apps.v.f.akr().Sc();
            if (Sc == null) {
                if (this.mContext != null) {
                    com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                }
            } else if (this.dbV != null) {
                String a2 = com.baidu.swan.game.ad.c.d.a(this.dbV.aAf(), bVar);
                Sc.jO("adLanding").ag(com.baidu.swan.apps.core.d.f.cci, com.baidu.swan.apps.core.d.f.cck).a("adLanding", com.baidu.swan.apps.model.b.bB(a2, a2)).abl();
            }
        }
    }
}
