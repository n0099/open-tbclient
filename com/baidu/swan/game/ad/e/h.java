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
/* loaded from: classes19.dex */
public class h implements a.InterfaceC0478a, a.b, a.c, a.d {
    private com.baidu.swan.apps.media.b.a bTg;
    private com.baidu.swan.apps.adlanding.b bTm;
    private com.baidu.swan.apps.adlanding.download.a.a bTr;
    private com.baidu.swan.apps.adlanding.download.model.a bTs;
    public String diF;
    private AdElementInfo djj;
    private boolean dkE;
    private String dkN;
    private String dlj;
    private com.baidu.swan.game.ad.b dmD;
    private com.baidu.swan.games.view.a dmF;
    private k dmG;
    private l dmH;
    public com.baidu.swan.apps.res.widget.dialog.g dmI;
    private j dmJ;
    private boolean dmK;
    private a dmL;
    private boolean dmM;
    private boolean dmS;
    private boolean dmT;
    private g dmU;
    private static String dmt = "0";
    private static String dmu = "100";
    private static String dmv = TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY;
    private static String dmw = TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY;
    private static String dmx = TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY;
    private static String dmy = TbEnum.SystemMessage.EVENT_ID_GROUP_UPGRADE;
    private static String dmz = "1";
    private static String dmA = "0";
    private static String dmB = "status";
    private static String dmC = "isPaused";
    private static String KEY_TOKEN = "token";
    private static String dmR = "monitors";
    private int dmE = 256;
    private int mPausePosition = 0;
    private boolean dmN = true;
    private String dmO = dmv;
    private String dmP = dmA;
    private Map<String, String> dmQ = new HashMap();
    private SwanAdDownloadState bTt = SwanAdDownloadState.NOT_START;
    private Context mContext = AppRuntime.getAppContext();
    private b djc = new b(this.mContext);
    private com.baidu.swan.game.ad.jsbridge.a dja = new com.baidu.swan.game.ad.jsbridge.a();
    private boolean djb = com.baidu.swan.game.ad.d.f.aJx();

    public h(String str, String str2, boolean z) {
        this.diF = "";
        this.dkN = str;
        this.diF = str2;
        this.dkE = z;
        this.dmT = z;
    }

    public void a(j jVar) {
        this.dmJ = jVar;
    }

    public synchronized void b(com.baidu.swan.games.binding.model.c cVar) {
        com.baidu.swan.game.ad.b.d fVar;
        k d = k.d(cVar);
        if (this.dmE == 257) {
            com.baidu.swan.game.ad.e.a.aJz().a(d);
        } else if (this.dmE == 261 || this.dmE == 260 || this.dmE == 265) {
            a(d, "3010006");
        } else {
            if (this.dmE == 258) {
                if (aJN()) {
                    this.dmE = AuthorityState.STATE_INIT_ING;
                } else {
                    c(d);
                }
            }
            if (this.dmE == 259 || this.dmE == 262 || this.dmE == 263 || this.dmE == 264 || this.dmE == 256 || this.dmE == 272) {
                com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
                String str = "";
                if (azI != null) {
                    str = azI.getAppKey();
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.dkN) || TextUtils.isEmpty(this.diF)) {
                    a(d, "3010007");
                } else {
                    this.dmG = d;
                    this.dmE = 257;
                    com.baidu.swan.game.ad.b.b aJh = new b.a().tW(this.dkN).tX(this.diF).tY(str).kM(ah.getDisplayWidth(this.mContext)).kN(ah.getDisplayHeight(this.mContext)).kO(1).aJh();
                    if (this.dmT) {
                        this.dkE = true;
                        fVar = new com.baidu.swan.game.ad.b.e(this.mContext, aJh, 5, 5);
                        com.baidu.swan.games.view.a.b.db("gdtvideo", null);
                    } else {
                        this.dkE = false;
                        fVar = new com.baidu.swan.game.ad.b.f(this.mContext, aJh);
                        this.dlj = fVar.aJm();
                        com.baidu.swan.games.view.a.b.db("video", null);
                    }
                    com.baidu.swan.game.ad.b.a aVar = new com.baidu.swan.game.ad.b.a(this.mContext, this.dkE);
                    aVar.a(this);
                    aVar.a(fVar, this.djc);
                }
            }
        }
    }

    public synchronized void c(com.baidu.swan.games.binding.model.c cVar) {
        final l e = l.e(cVar);
        String str = "";
        if (this.dmE == 261 || this.dmE == 260 || this.dmE == 265) {
            if (e != null) {
                e.uf("3010004");
            }
            if (this.dmJ != null) {
                this.dmJ.onError("3010004");
            }
        } else if (this.dmE != 258 || aJN()) {
            a(e, "3010004");
        } else if (this.djj != null && TextUtils.isEmpty(this.djj.getVideoUrl())) {
            a(e, "3010008");
        } else if (this.dmE == 258) {
            this.dmE = 265;
            if (this.djj != null) {
                str = this.djj.aIO();
            }
            if (com.baidu.swan.games.view.a.c.isLandScape() && (com.baidu.swan.games.view.a.c.aQv() || !TextUtils.isEmpty(str))) {
                SwanAppActivity arI = com.baidu.swan.apps.v.f.arY().arI();
                if (arI != null) {
                    arI.setRequestedOrientation(1);
                }
                com.baidu.swan.apps.v.f.arY().asc().gQ(true);
            }
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.h.1
                @Override // java.lang.Runnable
                public void run() {
                    h.this.aJP();
                    if (com.baidu.swan.games.view.a.c.aF(h.this.dmD.getConvertView())) {
                        com.baidu.swan.games.view.a.c.removeView(h.this.dmD.getConvertView());
                    }
                    if (!com.baidu.swan.games.view.a.c.c(h.this.dmD.getConvertView(), com.baidu.swan.apps.model.a.a.a.auq())) {
                        h.this.a(e, "3010000");
                        return;
                    }
                    h.this.dmH = e;
                    h.this.dmE = 260;
                    h.this.dmD.bq(h.this.djj.getVideoUrl());
                }
            });
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void a(AdElementInfo adElementInfo) {
        this.djj = adElementInfo;
        this.dkE = this.djj.aIY();
        this.dmE = 258;
        c(this.dmG);
        if (!this.dkE && this.djj.getActionType() == 2) {
            initDownload();
        }
        com.baidu.swan.games.view.a.b.db(getType(), "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void tQ(String str) {
        this.dmE = 259;
        a(this.dmG, str);
        com.baidu.swan.games.view.a.b.U(getType(), "fail", str);
    }

    private void aJH() {
        com.baidu.swan.games.view.a.b.f(getType(), "pageclose", this.bTg.getDuration() / 1000);
        aJL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJI() {
        if (this.bTg != null && this.dmD != null) {
            if (this.bTg.isPlaying()) {
                this.bTg.pause();
                this.dmD.aHX();
            }
            this.dmE = 262;
            if (this.dkE) {
                com.baidu.swan.game.ad.c.d.b(kP(this.djj.getDuration()), this.djj, this.djc);
            } else {
                com.baidu.swan.game.ad.c.c.a(getProgress(), this.mPausePosition, this.djj, this.djc);
            }
            if (this.dmD != null) {
                if (this.bTg.isEnd()) {
                    this.dmD.aIa();
                } else {
                    this.dmD.aIb();
                }
            }
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.c
    public void aB(View view) {
        SwanAppActivity arI;
        int i;
        int i2;
        int i3;
        String format;
        if (this.bTg != null && this.djj != null && (arI = com.baidu.swan.apps.v.f.arY().arI()) != null && !this.dmK) {
            if (view != null && c.e.close_ad != view.getId()) {
                aJH();
                return;
            }
            int currentPosition = this.bTg.getCurrentPosition() / 1000;
            int min = Math.min(this.djj.aIM(), this.bTg.getDuration() / 1000);
            if (currentPosition >= min) {
                aJI();
                return;
            }
            int aQt = com.baidu.swan.games.view.a.c.aQt();
            int aQu = com.baidu.swan.games.view.a.c.aQu();
            if (com.baidu.swan.games.view.a.c.isLandScape()) {
                i = (int) (aQt * 0.275f);
                i2 = (int) (aQt * 0.275f);
                i3 = (int) (0.05f * aQu);
            } else {
                int min2 = Math.min(aQt, aQu);
                i = (int) (min2 * 0.1f);
                i2 = (int) (min2 * 0.1f);
                i3 = 0;
            }
            aHX();
            com.baidu.swan.games.view.a.b.f(getType(), "pageshow", getProgress());
            this.mContext.getResources().getString(c.g.swangame_game_ad_dialog_msg_more);
            if (this.djb) {
                format = String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_reward_msg_time_tip), Integer.valueOf(15 - (this.bTg.getCurrentPosition() / 1000)));
            } else {
                format = String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_video_close_alert), Integer.valueOf(min - currentPosition));
            }
            this.dmK = true;
            this.dmI = new g.a(arI).fz(true).d(c.g.ad_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.e.h.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    if (!h.this.djb || h.this.dmD == null) {
                        h.this.aJL();
                    } else {
                        if (h.this.bTg != null) {
                            h.this.bTg.pause();
                        }
                        if (h.this.dmL != null) {
                            h.this.mContext.unregisterReceiver(h.this.dmL);
                            h.this.dmL = null;
                        }
                        h.this.dmE = 262;
                        h.this.dmD.aIb();
                    }
                    h.this.dmK = false;
                    com.baidu.swan.games.view.a.b.f(h.this.getType(), "close", h.this.getProgress());
                }
            }).qf(format).c(c.g.ad_continue_watch, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.e.h.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    h.this.aJO();
                    h.this.dmK = false;
                    com.baidu.swan.games.view.a.b.f(h.this.getType(), "continue", h.this.getProgress());
                }
            }).iY(c.b.aiapps_game_continue_watch).b(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.game.ad.e.h.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    h.this.dmK = false;
                }
            }).a(new com.baidu.swan.apps.view.c.a()).n(i, 0, i2, i3).azp();
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.d
    public void aC(View view) {
        com.baidu.swan.games.view.a.b.f(getType(), "click", aJQ());
        if (this.dkE) {
            aD(view);
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0478a
    public void a(CommandType commandType, Uri uri) {
        String aIQ = this.djj.aIQ();
        String packageName = this.djj.getPackageName();
        switch (commandType) {
            case ACTION_URL:
                if (this.djj.getActionType() == 2) {
                    aJJ();
                    break;
                } else {
                    aJK();
                    break;
                }
            case OPEN_APP:
                if (this.djj != null) {
                    ah(this.mContext, packageName);
                    break;
                }
                break;
            case GET_DOWNLOAD_STATUS:
                if (this.dja != null) {
                    if (af(this.mContext, packageName)) {
                        this.dmO = dmx;
                    }
                    String queryParameter = uri.getQueryParameter(KEY_TOKEN);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(dmB, this.dmO);
                        jSONObject.put(dmC, this.dmP);
                        this.dja.cD(queryParameter, jSONObject.toString());
                        break;
                    } catch (JSONException e) {
                        break;
                    }
                } else {
                    return;
                }
            case PAUSE_DOWNLOAD:
                this.dmP = dmz;
                aJJ();
                break;
            case BANNER_VIEW:
                com.baidu.swan.apps.core.d.f XX = com.baidu.swan.apps.v.f.arY().XX();
                if (XX == null) {
                    if (this.mContext != null) {
                        com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                        return;
                    }
                    return;
                }
                XX.lo("adLanding").al(com.baidu.swan.apps.core.d.f.cik, com.baidu.swan.apps.core.d.f.cim).a("adLanding", com.baidu.swan.apps.model.b.bP(aIQ, aIQ)).ahx();
                break;
        }
        com.baidu.swan.game.ad.c.c.d(this.djj, this.djc);
        com.baidu.swan.games.view.a.b.f(getType(), "click", aJQ());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SwanAdDownloadState swanAdDownloadState) {
        this.bTt = swanAdDownloadState;
        if (swanAdDownloadState == SwanAdDownloadState.NOT_START) {
            this.dmO = dmv;
            this.dmP = dmA;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
            this.dmO = dmt;
            this.dmP = dmz;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
            this.dmO = dmw;
            this.dmP = dmA;
        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
            this.dmO = dmx;
            this.dmP = dmA;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
            this.dmO = dmt;
            this.dmP = dmA;
        }
    }

    private void initDownload() {
        this.bTm = new com.baidu.swan.apps.adlanding.b(this.mContext, this.djj.aIW());
        this.bTr = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.game.ad.e.h.5
            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void dA(boolean z) {
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void iO(String str) {
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                if (!h.this.dmS) {
                    h.this.d(swanAdDownloadState);
                }
                h.this.dmS = true;
                if (h.this.bTt != swanAdDownloadState) {
                    if (h.this.bTt == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                        h.this.dmP = h.dmA;
                        h.this.bTm.iL("appdownloadbegin");
                    } else if (swanAdDownloadState != SwanAdDownloadState.DOWNLOAD_PAUSED) {
                        if (h.this.bTt == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            h.this.dmP = h.dmA;
                            h.this.bTm.iL("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            h.this.dmP = h.dmA;
                            h.this.dmO = h.dmw;
                            h.this.bTm.iL("appdownloadfinish");
                            h.this.bTm.iL("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            h.this.dmP = h.dmA;
                            h.this.dmO = h.dmx;
                            h.this.bTm.iL("appinstallfinish");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_FAILED) {
                            h.this.dmP = h.dmA;
                            h.this.dmO = h.dmy;
                        } else if (swanAdDownloadState == SwanAdDownloadState.DELETED) {
                            h.this.dmP = h.dmA;
                            h.this.dmO = h.dmv;
                        }
                    } else {
                        h.this.dmP = h.dmz;
                        h.this.bTm.iL("appdownloadpause");
                    }
                    h.this.bTt = swanAdDownloadState;
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                if (i != 0) {
                    if (i != 100 || h.this.dmO == h.dmv) {
                        if (h.this.dmO != h.dmv && h.this.dmO != h.dmy) {
                            h.this.dmO = String.valueOf(i);
                            return;
                        }
                        return;
                    }
                    h.this.dmO = h.dmw;
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void abo() {
                h.this.bTm.iL("appinstallbegin");
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public String abp() {
                h.this.bTm.iL("appinstallopen");
                return "";
            }
        };
        String aIQ = this.djj.aIQ();
        String packageName = this.djj.getPackageName();
        String str = this.dmQ.get(packageName);
        if (str == null) {
            this.dmQ.put(packageName, aIQ);
            str = aIQ;
        }
        this.bTs = new com.baidu.swan.apps.adlanding.download.model.a(str, packageName, this.djj.getTitle());
        this.dmS = false;
        com.baidu.swan.apps.t.a.aoT().a(this.mContext, this.bTs.abr(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS, this.bTr);
    }

    private boolean af(Context context, String str) {
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

    private boolean ah(Context context, String str) {
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
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "打开失败").jj(3).showToast();
            }
        } else {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "打开失败").jj(3).showToast();
        }
        return false;
    }

    private void aJJ() {
        if (ak.isAppInstalled(this.mContext, this.bTs.name)) {
            this.dmO = dmx;
            ah(this.mContext, this.bTs.name);
            this.bTm.iL("appinstallopen");
            return;
        }
        if (this.bTt == SwanAdDownloadState.NOT_START || this.bTt == SwanAdDownloadState.DELETED) {
            this.dmO = dmt;
            com.baidu.swan.apps.t.a.aoT().a(this.mContext, this.bTs.abr(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.bTr);
        }
        if (this.bTt == SwanAdDownloadState.DOWNLOADING) {
            com.baidu.swan.apps.t.a.aoT().a(this.mContext, this.bTs.abr(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.bTr);
        }
        if (this.bTt == SwanAdDownloadState.DOWNLOAD_PAUSED) {
            this.dmP = dmA;
            com.baidu.swan.apps.t.a.aoT().a(this.mContext, this.bTs.abr(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.bTr);
        }
        if (this.bTt == SwanAdDownloadState.DOWNLOAD_FAILED) {
            com.baidu.swan.apps.t.a.aoT().a(this.mContext, this.bTs.abr(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.bTr);
        }
        if (this.bTt == SwanAdDownloadState.DOWNLOADED) {
            this.dmO = dmw;
            this.bTr.abo();
            com.baidu.swan.apps.t.a.aoT().a(this.mContext, this.bTs.abr(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, this.bTr);
        }
        if (this.bTt == SwanAdDownloadState.INSTALLED) {
            ah(this.mContext, this.bTs.name);
        }
    }

    private void aJK() {
        String aIQ = this.djj.aIQ();
        com.baidu.swan.apps.core.d.f XX = com.baidu.swan.apps.v.f.arY().XX();
        if (XX == null) {
            if (this.mContext != null) {
                com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                return;
            }
            return;
        }
        JSONObject aIW = this.djj.aIW();
        com.baidu.swan.apps.model.b bP = com.baidu.swan.apps.model.b.bP(aIQ, aIQ);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(dmR, aIW);
        } catch (JSONException e) {
        }
        bP.setParams(jSONObject.toString());
        XX.lo("adLanding").al(com.baidu.swan.apps.core.d.f.cik, com.baidu.swan.apps.core.d.f.cim).a("adLanding", bP).ahx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJL() {
        if (this.dmJ != null && this.bTg != null) {
            this.dmJ.gu(this.bTg.isEnd() || this.bTg.getCurrentPosition() / 1000 >= Math.min(this.djj.aIM(), this.bTg.getDuration() / 1000));
        }
        aJM();
        if (!this.dkE && this.djj.getActionType() == 2 && SwanAdDownloadState.DOWNLOADING == this.bTt) {
            this.bTr = null;
            com.baidu.swan.apps.t.a.aoT().a(this.mContext, this.bTs.abr(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.bTr);
        }
        com.baidu.swan.game.ad.c.c.f(this.djj, this.djc);
        this.dmE = 263;
        b((com.baidu.swan.games.binding.model.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJM() {
        if (this.bTg != null) {
            this.bTg.pause();
            this.bTg.onDestroy();
        }
        if (this.dmL != null) {
            this.mContext.unregisterReceiver(this.dmL);
            this.dmL = null;
        }
        if (this.dmD != null) {
            this.dmD.aHZ();
            this.dmD.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_close));
            com.baidu.swan.games.view.a.c.removeView(this.dmD.getConvertView());
        }
        if (this.dmF != null) {
            com.baidu.swan.games.view.a.c.b(this.dmF);
            this.dmF = null;
        }
        if (this.dmU != null) {
            this.dmU.release();
            this.dmU = null;
        }
    }

    private boolean aJN() {
        if (this.djj == null) {
            return true;
        }
        long aIR = this.djj.aIR() * 1000;
        if (aIR == 0) {
            aIR = 1740000;
        }
        return System.currentTimeMillis() - this.djj.getCreateTime() >= aIR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getProgress() {
        if (this.bTg != null) {
            return this.bTg.getCurrentPosition() / 1000;
        }
        return 0;
    }

    private void c(k kVar) {
        if (this.dmJ != null) {
            this.dmJ.onLoad();
        }
        if (kVar != null) {
            kVar.aJZ();
        }
        com.baidu.swan.game.ad.e.a.aJz().Y(16, "");
    }

    private void a(k kVar, String str) {
        if (this.dmJ != null) {
            this.dmJ.onError(str);
        }
        if (kVar != null) {
            kVar.ue(str);
        }
        com.baidu.swan.game.ad.e.a.aJz().Y(17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHX() {
        if (this.bTg != null && this.dmD != null && this.bTg.isPlaying()) {
            this.bTg.pause();
            this.dmD.aHX();
            if (this.dkE) {
                com.baidu.swan.game.ad.c.d.b(kP(getProgress()), this.djj, this.djc);
            } else {
                com.baidu.swan.game.ad.c.c.a(getProgress(), this.mPausePosition, this.djj, this.djc);
            }
            this.mPausePosition = getProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJO() {
        if (this.bTg != null && this.dmD != null) {
            if ((this.dmI == null || !this.dmI.isShowing()) && !this.bTg.isPlaying() && !this.dmD.aIh()) {
                this.bTg.resume();
                this.dmD.aHY();
                com.baidu.swan.game.ad.c.c.e(this.djj, this.djc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar, String str) {
        if (lVar != null) {
            lVar.uf(str);
        }
        if (this.dmJ != null) {
            this.dmJ.onError(str);
        }
        this.dmE = 264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJP() {
        this.dja.b(this);
        if (com.baidu.swan.games.view.a.c.isLandScape()) {
            this.dmD = new com.baidu.swan.game.ad.d(this.mContext, this.djj, this.dja);
        } else {
            this.dmD = new com.baidu.swan.game.ad.e(this.mContext, this.djj, this.dja);
        }
        if (this.dkE) {
            this.dmD.a((a.d) this);
        }
        this.dmD.a((a.c) this);
        this.bTg = this.dmD.getPlayer();
        this.bTg.b(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.game.ad.e.h.6
            @Override // com.baidu.swan.apps.media.b.b
            public void a(com.baidu.swan.apps.t.b.j jVar) {
                if (h.this.dmD != null) {
                    h.this.dmD.onPrepared();
                }
                h.this.dmE = 261;
                h.this.mPausePosition = 0;
                if (h.this.dmD != null) {
                    h.this.dmD.aHW();
                }
                if (h.this.dmH != null) {
                    h.this.dmH.aKa();
                }
                if (h.this.dmL == null) {
                    h.this.dmL = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    h.this.mContext.registerReceiver(h.this.dmL, intentFilter);
                }
                if (h.this.dkE) {
                    com.baidu.swan.game.ad.c.d.a(h.this.djj, h.this.djc);
                    return;
                }
                com.baidu.swan.game.ad.c.c.a(h.this.djj, h.this.djc);
                com.baidu.swan.game.ad.c.c.e(h.this.djj, h.this.djc);
                com.baidu.swan.game.ad.c.c.a(h.this.dkN, h.this.diF, h.this.dlj, h.this.djc);
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(com.baidu.swan.apps.t.b.j jVar, int i, int i2) {
                h.this.aJM();
                h.this.a(h.this.dmH, "3010001");
                return true;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(com.baidu.swan.apps.t.b.j jVar) {
                h.this.aJI();
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
        if (this.dmF == null) {
            this.dmF = new com.baidu.swan.games.view.a() { // from class: com.baidu.swan.game.ad.e.h.7
                @Override // com.baidu.swan.games.view.a
                public void aJX() {
                    h.this.dmM = true;
                    if (h.this.dmN) {
                        h.this.aJO();
                    }
                }

                @Override // com.baidu.swan.games.view.a
                public void aJY() {
                    h.this.dmM = false;
                    h.this.aHX();
                }

                @Override // com.baidu.swan.games.view.a
                public void onViewDestroy() {
                }
            };
            com.baidu.swan.games.view.a.c.a(this.dmF);
        }
        this.dmD.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (h.this.bTg != null) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                    h.this.dmN = true;
                    if (h.this.dmM) {
                        h.this.aJO();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    h.this.dmN = false;
                }
            }
        }
    }

    private com.baidu.swan.game.ad.c.b kP(int i) {
        int i2;
        com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
        bVar.dlz = String.valueOf(this.djj.getDuration());
        bVar.dlA = String.valueOf(this.mPausePosition);
        bVar.dlB = String.valueOf(i);
        bVar.dlC = this.mPausePosition == 0 ? "1" : "0";
        bVar.dlD = i == this.djj.getDuration() ? "1" : "0";
        bVar.dlE = this.mContext.getResources().getConfiguration().orientation == 1 ? "2" : "4";
        if (this.mPausePosition == 0) {
            i2 = 1;
        } else if (this.mPausePosition == this.djj.getDuration()) {
            i2 = 3;
        } else {
            i2 = 2;
        }
        bVar.mType = String.valueOf(i2);
        bVar.dlF = (this.mPausePosition == 0 && SwanAppNetworkUtils.isWifiNetworkConnected(this.mContext)) ? "1" : "2";
        bVar.mStatus = String.valueOf(0);
        return bVar;
    }

    public String getType() {
        return this.dkE ? "gdtvideo" : "video";
    }

    private int aJQ() {
        return (this.bTg == null || !this.bTg.isEnd()) ? getProgress() : this.bTg.getDuration() / 1000;
    }

    @Override // com.baidu.swan.game.ad.a.a.d
    public void cC(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                jSONObject.put("title", this.djj.getTitle());
                jSONObject.put("description", this.djj.getDescription());
                jSONObject.put("autoinstall", true);
                if (this.dmU == null) {
                    this.dmU = new g(this.mContext, this.djj, this.djc);
                }
                this.dmU.pq(str);
                com.baidu.swan.apps.t.a.aoT().a(this.mContext, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.dmU);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void aD(View view) {
        if (this.dkE && this.djj != null) {
            com.baidu.swan.game.ad.c.d.d(this.djj, this.djc);
            com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
            bVar.dlr = String.valueOf(ah.getDisplayWidth(this.mContext));
            bVar.dls = String.valueOf(ah.getDisplayHeight(this.mContext));
            bVar.dlt = String.valueOf(ah.getDisplayWidth(this.mContext));
            bVar.dlu = String.valueOf(ah.getDisplayHeight(this.mContext));
            bVar.dlv = String.valueOf((int) view.getX());
            bVar.dlw = String.valueOf((int) view.getY());
            bVar.dlx = String.valueOf((int) view.getX());
            bVar.dly = String.valueOf((int) view.getY());
            if (this.djj.getActionType() == 2) {
                com.baidu.swan.game.ad.c.d.a(bVar, this.djj, this.djc, this);
                return;
            }
            com.baidu.swan.apps.core.d.f XX = com.baidu.swan.apps.v.f.arY().XX();
            if (XX == null) {
                if (this.mContext != null) {
                    com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                }
            } else if (this.djj != null) {
                String a2 = com.baidu.swan.game.ad.c.d.a(this.djj.aIQ(), bVar);
                XX.lo("adLanding").al(com.baidu.swan.apps.core.d.f.cik, com.baidu.swan.apps.core.d.f.cim).a("adLanding", com.baidu.swan.apps.model.b.bP(a2, a2)).ahx();
            }
        }
    }
}
