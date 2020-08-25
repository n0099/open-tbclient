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
    private com.baidu.swan.apps.media.b.a bTc;
    private com.baidu.swan.apps.adlanding.b bTi;
    private com.baidu.swan.apps.adlanding.download.a.a bTn;
    private com.baidu.swan.apps.adlanding.download.model.a bTo;
    public String diB;
    private AdElementInfo djf;
    private boolean dkA;
    private String dkJ;
    private String dlf;
    private com.baidu.swan.games.view.a dmB;
    private k dmC;
    private l dmD;
    public com.baidu.swan.apps.res.widget.dialog.g dmE;
    private j dmF;
    private boolean dmG;
    private a dmH;
    private boolean dmI;
    private boolean dmO;
    private boolean dmP;
    private g dmQ;
    private com.baidu.swan.game.ad.b dmz;
    private static String dmp = "0";
    private static String dmq = "100";
    private static String dmr = TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY;
    private static String dms = TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY;
    private static String dmt = TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY;
    private static String dmu = TbEnum.SystemMessage.EVENT_ID_GROUP_UPGRADE;
    private static String dmv = "1";
    private static String dmw = "0";
    private static String dmx = "status";
    private static String dmy = "isPaused";
    private static String KEY_TOKEN = "token";
    private static String dmN = "monitors";
    private int dmA = 256;
    private int mPausePosition = 0;
    private boolean dmJ = true;
    private String dmK = dmr;
    private String dmL = dmw;
    private Map<String, String> dmM = new HashMap();
    private SwanAdDownloadState bTp = SwanAdDownloadState.NOT_START;
    private Context mContext = AppRuntime.getAppContext();
    private b diY = new b(this.mContext);
    private com.baidu.swan.game.ad.jsbridge.a diW = new com.baidu.swan.game.ad.jsbridge.a();
    private boolean diX = com.baidu.swan.game.ad.d.f.aJx();

    public h(String str, String str2, boolean z) {
        this.diB = "";
        this.dkJ = str;
        this.diB = str2;
        this.dkA = z;
        this.dmP = z;
    }

    public void a(j jVar) {
        this.dmF = jVar;
    }

    public synchronized void b(com.baidu.swan.games.binding.model.c cVar) {
        com.baidu.swan.game.ad.b.d fVar;
        k d = k.d(cVar);
        if (this.dmA == 257) {
            com.baidu.swan.game.ad.e.a.aJz().a(d);
        } else if (this.dmA == 261 || this.dmA == 260 || this.dmA == 265) {
            a(d, "3010006");
        } else {
            if (this.dmA == 258) {
                if (aJN()) {
                    this.dmA = AuthorityState.STATE_INIT_ING;
                } else {
                    c(d);
                }
            }
            if (this.dmA == 259 || this.dmA == 262 || this.dmA == 263 || this.dmA == 264 || this.dmA == 256 || this.dmA == 272) {
                com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
                String str = "";
                if (azI != null) {
                    str = azI.getAppKey();
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.dkJ) || TextUtils.isEmpty(this.diB)) {
                    a(d, "3010007");
                } else {
                    this.dmC = d;
                    this.dmA = 257;
                    com.baidu.swan.game.ad.b.b aJh = new b.a().tV(this.dkJ).tW(this.diB).tX(str).kM(ah.getDisplayWidth(this.mContext)).kN(ah.getDisplayHeight(this.mContext)).kO(1).aJh();
                    if (this.dmP) {
                        this.dkA = true;
                        fVar = new com.baidu.swan.game.ad.b.e(this.mContext, aJh, 5, 5);
                        com.baidu.swan.games.view.a.b.db("gdtvideo", null);
                    } else {
                        this.dkA = false;
                        fVar = new com.baidu.swan.game.ad.b.f(this.mContext, aJh);
                        this.dlf = fVar.aJm();
                        com.baidu.swan.games.view.a.b.db("video", null);
                    }
                    com.baidu.swan.game.ad.b.a aVar = new com.baidu.swan.game.ad.b.a(this.mContext, this.dkA);
                    aVar.a(this);
                    aVar.a(fVar, this.diY);
                }
            }
        }
    }

    public synchronized void c(com.baidu.swan.games.binding.model.c cVar) {
        final l e = l.e(cVar);
        String str = "";
        if (this.dmA == 261 || this.dmA == 260 || this.dmA == 265) {
            if (e != null) {
                e.ue("3010004");
            }
            if (this.dmF != null) {
                this.dmF.onError("3010004");
            }
        } else if (this.dmA != 258 || aJN()) {
            a(e, "3010004");
        } else if (this.djf != null && TextUtils.isEmpty(this.djf.getVideoUrl())) {
            a(e, "3010008");
        } else if (this.dmA == 258) {
            this.dmA = 265;
            if (this.djf != null) {
                str = this.djf.aIO();
            }
            if (com.baidu.swan.games.view.a.c.isLandScape() && (com.baidu.swan.games.view.a.c.aQv() || !TextUtils.isEmpty(str))) {
                SwanAppActivity arI = com.baidu.swan.apps.v.f.arY().arI();
                if (arI != null) {
                    arI.setRequestedOrientation(1);
                }
                com.baidu.swan.apps.v.f.arY().asc().gP(true);
            }
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.h.1
                @Override // java.lang.Runnable
                public void run() {
                    h.this.aJP();
                    if (com.baidu.swan.games.view.a.c.aF(h.this.dmz.getConvertView())) {
                        com.baidu.swan.games.view.a.c.removeView(h.this.dmz.getConvertView());
                    }
                    if (!com.baidu.swan.games.view.a.c.c(h.this.dmz.getConvertView(), com.baidu.swan.apps.model.a.a.a.auq())) {
                        h.this.a(e, "3010000");
                        return;
                    }
                    h.this.dmD = e;
                    h.this.dmA = 260;
                    h.this.dmz.bq(h.this.djf.getVideoUrl());
                }
            });
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void a(AdElementInfo adElementInfo) {
        this.djf = adElementInfo;
        this.dkA = this.djf.aIY();
        this.dmA = 258;
        c(this.dmC);
        if (!this.dkA && this.djf.getActionType() == 2) {
            initDownload();
        }
        com.baidu.swan.games.view.a.b.db(getType(), "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void tP(String str) {
        this.dmA = 259;
        a(this.dmC, str);
        com.baidu.swan.games.view.a.b.U(getType(), "fail", str);
    }

    private void aJH() {
        com.baidu.swan.games.view.a.b.f(getType(), "pageclose", this.bTc.getDuration() / 1000);
        aJL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJI() {
        if (this.bTc != null && this.dmz != null) {
            if (this.bTc.isPlaying()) {
                this.bTc.pause();
                this.dmz.aHX();
            }
            this.dmA = 262;
            if (this.dkA) {
                com.baidu.swan.game.ad.c.d.b(kP(this.djf.getDuration()), this.djf, this.diY);
            } else {
                com.baidu.swan.game.ad.c.c.a(getProgress(), this.mPausePosition, this.djf, this.diY);
            }
            if (this.dmz != null) {
                if (this.bTc.isEnd()) {
                    this.dmz.aIa();
                } else {
                    this.dmz.aIb();
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
        if (this.bTc != null && this.djf != null && (arI = com.baidu.swan.apps.v.f.arY().arI()) != null && !this.dmG) {
            if (view != null && c.e.close_ad != view.getId()) {
                aJH();
                return;
            }
            int currentPosition = this.bTc.getCurrentPosition() / 1000;
            int min = Math.min(this.djf.aIM(), this.bTc.getDuration() / 1000);
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
            if (this.diX) {
                format = String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_reward_msg_time_tip), Integer.valueOf(15 - (this.bTc.getCurrentPosition() / 1000)));
            } else {
                format = String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_video_close_alert), Integer.valueOf(min - currentPosition));
            }
            this.dmG = true;
            this.dmE = new g.a(arI).fy(true).d(c.g.ad_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.e.h.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    if (!h.this.diX || h.this.dmz == null) {
                        h.this.aJL();
                    } else {
                        if (h.this.bTc != null) {
                            h.this.bTc.pause();
                        }
                        if (h.this.dmH != null) {
                            h.this.mContext.unregisterReceiver(h.this.dmH);
                            h.this.dmH = null;
                        }
                        h.this.dmA = 262;
                        h.this.dmz.aIb();
                    }
                    h.this.dmG = false;
                    com.baidu.swan.games.view.a.b.f(h.this.getType(), "close", h.this.getProgress());
                }
            }).qe(format).c(c.g.ad_continue_watch, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.e.h.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    h.this.aJO();
                    h.this.dmG = false;
                    com.baidu.swan.games.view.a.b.f(h.this.getType(), "continue", h.this.getProgress());
                }
            }).iY(c.b.aiapps_game_continue_watch).b(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.game.ad.e.h.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    h.this.dmG = false;
                }
            }).a(new com.baidu.swan.apps.view.c.a()).n(i, 0, i2, i3).azp();
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.d
    public void aC(View view) {
        com.baidu.swan.games.view.a.b.f(getType(), "click", aJQ());
        if (this.dkA) {
            aD(view);
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0478a
    public void a(CommandType commandType, Uri uri) {
        String aIQ = this.djf.aIQ();
        String packageName = this.djf.getPackageName();
        switch (commandType) {
            case ACTION_URL:
                if (this.djf.getActionType() == 2) {
                    aJJ();
                    break;
                } else {
                    aJK();
                    break;
                }
            case OPEN_APP:
                if (this.djf != null) {
                    ah(this.mContext, packageName);
                    break;
                }
                break;
            case GET_DOWNLOAD_STATUS:
                if (this.diW != null) {
                    if (af(this.mContext, packageName)) {
                        this.dmK = dmt;
                    }
                    String queryParameter = uri.getQueryParameter(KEY_TOKEN);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(dmx, this.dmK);
                        jSONObject.put(dmy, this.dmL);
                        this.diW.cD(queryParameter, jSONObject.toString());
                        break;
                    } catch (JSONException e) {
                        break;
                    }
                } else {
                    return;
                }
            case PAUSE_DOWNLOAD:
                this.dmL = dmv;
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
                XX.ln("adLanding").al(com.baidu.swan.apps.core.d.f.cig, com.baidu.swan.apps.core.d.f.cii).a("adLanding", com.baidu.swan.apps.model.b.bP(aIQ, aIQ)).ahx();
                break;
        }
        com.baidu.swan.game.ad.c.c.d(this.djf, this.diY);
        com.baidu.swan.games.view.a.b.f(getType(), "click", aJQ());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SwanAdDownloadState swanAdDownloadState) {
        this.bTp = swanAdDownloadState;
        if (swanAdDownloadState == SwanAdDownloadState.NOT_START) {
            this.dmK = dmr;
            this.dmL = dmw;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
            this.dmK = dmp;
            this.dmL = dmv;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
            this.dmK = dms;
            this.dmL = dmw;
        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
            this.dmK = dmt;
            this.dmL = dmw;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
            this.dmK = dmp;
            this.dmL = dmw;
        }
    }

    private void initDownload() {
        this.bTi = new com.baidu.swan.apps.adlanding.b(this.mContext, this.djf.aIW());
        this.bTn = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.game.ad.e.h.5
            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void dz(boolean z) {
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void iN(String str) {
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                if (!h.this.dmO) {
                    h.this.d(swanAdDownloadState);
                }
                h.this.dmO = true;
                if (h.this.bTp != swanAdDownloadState) {
                    if (h.this.bTp == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                        h.this.dmL = h.dmw;
                        h.this.bTi.iK("appdownloadbegin");
                    } else if (swanAdDownloadState != SwanAdDownloadState.DOWNLOAD_PAUSED) {
                        if (h.this.bTp == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            h.this.dmL = h.dmw;
                            h.this.bTi.iK("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            h.this.dmL = h.dmw;
                            h.this.dmK = h.dms;
                            h.this.bTi.iK("appdownloadfinish");
                            h.this.bTi.iK("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            h.this.dmL = h.dmw;
                            h.this.dmK = h.dmt;
                            h.this.bTi.iK("appinstallfinish");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_FAILED) {
                            h.this.dmL = h.dmw;
                            h.this.dmK = h.dmu;
                        } else if (swanAdDownloadState == SwanAdDownloadState.DELETED) {
                            h.this.dmL = h.dmw;
                            h.this.dmK = h.dmr;
                        }
                    } else {
                        h.this.dmL = h.dmv;
                        h.this.bTi.iK("appdownloadpause");
                    }
                    h.this.bTp = swanAdDownloadState;
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                if (i != 0) {
                    if (i != 100 || h.this.dmK == h.dmr) {
                        if (h.this.dmK != h.dmr && h.this.dmK != h.dmu) {
                            h.this.dmK = String.valueOf(i);
                            return;
                        }
                        return;
                    }
                    h.this.dmK = h.dms;
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void abo() {
                h.this.bTi.iK("appinstallbegin");
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public String abp() {
                h.this.bTi.iK("appinstallopen");
                return "";
            }
        };
        String aIQ = this.djf.aIQ();
        String packageName = this.djf.getPackageName();
        String str = this.dmM.get(packageName);
        if (str == null) {
            this.dmM.put(packageName, aIQ);
            str = aIQ;
        }
        this.bTo = new com.baidu.swan.apps.adlanding.download.model.a(str, packageName, this.djf.getTitle());
        this.dmO = false;
        com.baidu.swan.apps.t.a.aoT().a(this.mContext, this.bTo.abr(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS, this.bTn);
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
        if (ak.isAppInstalled(this.mContext, this.bTo.name)) {
            this.dmK = dmt;
            ah(this.mContext, this.bTo.name);
            this.bTi.iK("appinstallopen");
            return;
        }
        if (this.bTp == SwanAdDownloadState.NOT_START || this.bTp == SwanAdDownloadState.DELETED) {
            this.dmK = dmp;
            com.baidu.swan.apps.t.a.aoT().a(this.mContext, this.bTo.abr(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.bTn);
        }
        if (this.bTp == SwanAdDownloadState.DOWNLOADING) {
            com.baidu.swan.apps.t.a.aoT().a(this.mContext, this.bTo.abr(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.bTn);
        }
        if (this.bTp == SwanAdDownloadState.DOWNLOAD_PAUSED) {
            this.dmL = dmw;
            com.baidu.swan.apps.t.a.aoT().a(this.mContext, this.bTo.abr(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.bTn);
        }
        if (this.bTp == SwanAdDownloadState.DOWNLOAD_FAILED) {
            com.baidu.swan.apps.t.a.aoT().a(this.mContext, this.bTo.abr(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.bTn);
        }
        if (this.bTp == SwanAdDownloadState.DOWNLOADED) {
            this.dmK = dms;
            this.bTn.abo();
            com.baidu.swan.apps.t.a.aoT().a(this.mContext, this.bTo.abr(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, this.bTn);
        }
        if (this.bTp == SwanAdDownloadState.INSTALLED) {
            ah(this.mContext, this.bTo.name);
        }
    }

    private void aJK() {
        String aIQ = this.djf.aIQ();
        com.baidu.swan.apps.core.d.f XX = com.baidu.swan.apps.v.f.arY().XX();
        if (XX == null) {
            if (this.mContext != null) {
                com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                return;
            }
            return;
        }
        JSONObject aIW = this.djf.aIW();
        com.baidu.swan.apps.model.b bP = com.baidu.swan.apps.model.b.bP(aIQ, aIQ);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(dmN, aIW);
        } catch (JSONException e) {
        }
        bP.setParams(jSONObject.toString());
        XX.ln("adLanding").al(com.baidu.swan.apps.core.d.f.cig, com.baidu.swan.apps.core.d.f.cii).a("adLanding", bP).ahx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJL() {
        if (this.dmF != null && this.bTc != null) {
            this.dmF.gt(this.bTc.isEnd() || this.bTc.getCurrentPosition() / 1000 >= Math.min(this.djf.aIM(), this.bTc.getDuration() / 1000));
        }
        aJM();
        if (!this.dkA && this.djf.getActionType() == 2 && SwanAdDownloadState.DOWNLOADING == this.bTp) {
            this.bTn = null;
            com.baidu.swan.apps.t.a.aoT().a(this.mContext, this.bTo.abr(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.bTn);
        }
        com.baidu.swan.game.ad.c.c.f(this.djf, this.diY);
        this.dmA = 263;
        b((com.baidu.swan.games.binding.model.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJM() {
        if (this.bTc != null) {
            this.bTc.pause();
            this.bTc.onDestroy();
        }
        if (this.dmH != null) {
            this.mContext.unregisterReceiver(this.dmH);
            this.dmH = null;
        }
        if (this.dmz != null) {
            this.dmz.aHZ();
            this.dmz.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_close));
            com.baidu.swan.games.view.a.c.removeView(this.dmz.getConvertView());
        }
        if (this.dmB != null) {
            com.baidu.swan.games.view.a.c.b(this.dmB);
            this.dmB = null;
        }
        if (this.dmQ != null) {
            this.dmQ.release();
            this.dmQ = null;
        }
    }

    private boolean aJN() {
        if (this.djf == null) {
            return true;
        }
        long aIR = this.djf.aIR() * 1000;
        if (aIR == 0) {
            aIR = 1740000;
        }
        return System.currentTimeMillis() - this.djf.getCreateTime() >= aIR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getProgress() {
        if (this.bTc != null) {
            return this.bTc.getCurrentPosition() / 1000;
        }
        return 0;
    }

    private void c(k kVar) {
        if (this.dmF != null) {
            this.dmF.onLoad();
        }
        if (kVar != null) {
            kVar.aJZ();
        }
        com.baidu.swan.game.ad.e.a.aJz().Y(16, "");
    }

    private void a(k kVar, String str) {
        if (this.dmF != null) {
            this.dmF.onError(str);
        }
        if (kVar != null) {
            kVar.ud(str);
        }
        com.baidu.swan.game.ad.e.a.aJz().Y(17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHX() {
        if (this.bTc != null && this.dmz != null && this.bTc.isPlaying()) {
            this.bTc.pause();
            this.dmz.aHX();
            if (this.dkA) {
                com.baidu.swan.game.ad.c.d.b(kP(getProgress()), this.djf, this.diY);
            } else {
                com.baidu.swan.game.ad.c.c.a(getProgress(), this.mPausePosition, this.djf, this.diY);
            }
            this.mPausePosition = getProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJO() {
        if (this.bTc != null && this.dmz != null) {
            if ((this.dmE == null || !this.dmE.isShowing()) && !this.bTc.isPlaying() && !this.dmz.aIh()) {
                this.bTc.resume();
                this.dmz.aHY();
                com.baidu.swan.game.ad.c.c.e(this.djf, this.diY);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar, String str) {
        if (lVar != null) {
            lVar.ue(str);
        }
        if (this.dmF != null) {
            this.dmF.onError(str);
        }
        this.dmA = 264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJP() {
        this.diW.b(this);
        if (com.baidu.swan.games.view.a.c.isLandScape()) {
            this.dmz = new com.baidu.swan.game.ad.d(this.mContext, this.djf, this.diW);
        } else {
            this.dmz = new com.baidu.swan.game.ad.e(this.mContext, this.djf, this.diW);
        }
        if (this.dkA) {
            this.dmz.a((a.d) this);
        }
        this.dmz.a((a.c) this);
        this.bTc = this.dmz.getPlayer();
        this.bTc.b(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.game.ad.e.h.6
            @Override // com.baidu.swan.apps.media.b.b
            public void a(com.baidu.swan.apps.t.b.j jVar) {
                if (h.this.dmz != null) {
                    h.this.dmz.onPrepared();
                }
                h.this.dmA = 261;
                h.this.mPausePosition = 0;
                if (h.this.dmz != null) {
                    h.this.dmz.aHW();
                }
                if (h.this.dmD != null) {
                    h.this.dmD.aKa();
                }
                if (h.this.dmH == null) {
                    h.this.dmH = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    h.this.mContext.registerReceiver(h.this.dmH, intentFilter);
                }
                if (h.this.dkA) {
                    com.baidu.swan.game.ad.c.d.a(h.this.djf, h.this.diY);
                    return;
                }
                com.baidu.swan.game.ad.c.c.a(h.this.djf, h.this.diY);
                com.baidu.swan.game.ad.c.c.e(h.this.djf, h.this.diY);
                com.baidu.swan.game.ad.c.c.a(h.this.dkJ, h.this.diB, h.this.dlf, h.this.diY);
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(com.baidu.swan.apps.t.b.j jVar, int i, int i2) {
                h.this.aJM();
                h.this.a(h.this.dmD, "3010001");
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
        if (this.dmB == null) {
            this.dmB = new com.baidu.swan.games.view.a() { // from class: com.baidu.swan.game.ad.e.h.7
                @Override // com.baidu.swan.games.view.a
                public void aJX() {
                    h.this.dmI = true;
                    if (h.this.dmJ) {
                        h.this.aJO();
                    }
                }

                @Override // com.baidu.swan.games.view.a
                public void aJY() {
                    h.this.dmI = false;
                    h.this.aHX();
                }

                @Override // com.baidu.swan.games.view.a
                public void onViewDestroy() {
                }
            };
            com.baidu.swan.games.view.a.c.a(this.dmB);
        }
        this.dmz.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (h.this.bTc != null) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                    h.this.dmJ = true;
                    if (h.this.dmI) {
                        h.this.aJO();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    h.this.dmJ = false;
                }
            }
        }
    }

    private com.baidu.swan.game.ad.c.b kP(int i) {
        int i2;
        com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
        bVar.dlv = String.valueOf(this.djf.getDuration());
        bVar.dlw = String.valueOf(this.mPausePosition);
        bVar.dlx = String.valueOf(i);
        bVar.dly = this.mPausePosition == 0 ? "1" : "0";
        bVar.dlz = i == this.djf.getDuration() ? "1" : "0";
        bVar.dlA = this.mContext.getResources().getConfiguration().orientation == 1 ? "2" : "4";
        if (this.mPausePosition == 0) {
            i2 = 1;
        } else if (this.mPausePosition == this.djf.getDuration()) {
            i2 = 3;
        } else {
            i2 = 2;
        }
        bVar.mType = String.valueOf(i2);
        bVar.dlB = (this.mPausePosition == 0 && SwanAppNetworkUtils.isWifiNetworkConnected(this.mContext)) ? "1" : "2";
        bVar.mStatus = String.valueOf(0);
        return bVar;
    }

    public String getType() {
        return this.dkA ? "gdtvideo" : "video";
    }

    private int aJQ() {
        return (this.bTc == null || !this.bTc.isEnd()) ? getProgress() : this.bTc.getDuration() / 1000;
    }

    @Override // com.baidu.swan.game.ad.a.a.d
    public void cC(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                jSONObject.put("title", this.djf.getTitle());
                jSONObject.put("description", this.djf.getDescription());
                jSONObject.put("autoinstall", true);
                if (this.dmQ == null) {
                    this.dmQ = new g(this.mContext, this.djf, this.diY);
                }
                this.dmQ.pp(str);
                com.baidu.swan.apps.t.a.aoT().a(this.mContext, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.dmQ);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void aD(View view) {
        if (this.dkA && this.djf != null) {
            com.baidu.swan.game.ad.c.d.d(this.djf, this.diY);
            com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
            bVar.dln = String.valueOf(ah.getDisplayWidth(this.mContext));
            bVar.dlo = String.valueOf(ah.getDisplayHeight(this.mContext));
            bVar.dlp = String.valueOf(ah.getDisplayWidth(this.mContext));
            bVar.dlq = String.valueOf(ah.getDisplayHeight(this.mContext));
            bVar.dlr = String.valueOf((int) view.getX());
            bVar.dls = String.valueOf((int) view.getY());
            bVar.dlt = String.valueOf((int) view.getX());
            bVar.dlu = String.valueOf((int) view.getY());
            if (this.djf.getActionType() == 2) {
                com.baidu.swan.game.ad.c.d.a(bVar, this.djf, this.diY, this);
                return;
            }
            com.baidu.swan.apps.core.d.f XX = com.baidu.swan.apps.v.f.arY().XX();
            if (XX == null) {
                if (this.mContext != null) {
                    com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                }
            } else if (this.djf != null) {
                String a2 = com.baidu.swan.game.ad.c.d.a(this.djf.aIQ(), bVar);
                XX.ln("adLanding").al(com.baidu.swan.apps.core.d.f.cig, com.baidu.swan.apps.core.d.f.cii).a("adLanding", com.baidu.swan.apps.model.b.bP(a2, a2)).ahx();
            }
        }
    }
}
