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
/* loaded from: classes3.dex */
public class h implements a.InterfaceC0519a, a.b, a.c, a.d {
    private com.baidu.swan.apps.media.b.a cFR;
    private com.baidu.swan.apps.adlanding.b cFX;
    private com.baidu.swan.apps.adlanding.download.a.a cGc;
    private com.baidu.swan.apps.adlanding.download.model.a cGd;
    private AdElementInfo dZT;
    public String dZp;
    private String ebS;
    private boolean ebn;
    private String ebw;
    private boolean edB;
    private boolean edC;
    private g edD;
    private com.baidu.swan.game.ad.b edm;
    private com.baidu.swan.games.view.a edo;
    private k edp;
    private l edq;
    public com.baidu.swan.apps.res.widget.dialog.g edr;
    private j eds;
    private boolean edt;
    private a edu;
    private boolean edv;
    private static String edc = "0";
    private static String edd = StatisticData.ERROR_CODE_NOT_FOUND;
    private static String ede = "101";
    private static String edf = TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY;
    private static String edg = TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY;
    private static String edh = TbEnum.SystemMessage.EVENT_ID_GROUP_UPGRADE;
    private static String edi = "1";
    private static String edj = "0";
    private static String edk = "status";
    private static String edl = "isPaused";
    private static String KEY_TOKEN = "token";
    private static String edA = "monitors";
    private int edn = 256;
    private int mPausePosition = 0;
    private boolean edw = true;
    private String edx = ede;
    private String edy = edj;
    private Map<String, String> edz = new HashMap();
    private SwanAdDownloadState cGe = SwanAdDownloadState.NOT_START;
    private Context mContext = AppRuntime.getAppContext();
    private b dZM = new b(this.mContext);
    private com.baidu.swan.game.ad.jsbridge.a dZK = new com.baidu.swan.game.ad.jsbridge.a();
    private boolean dZL = com.baidu.swan.game.ad.d.f.aWd();

    public h(String str, String str2, boolean z) {
        this.dZp = "";
        this.ebw = str;
        this.dZp = str2;
        this.ebn = z;
        this.edC = z;
    }

    public void a(j jVar) {
        this.eds = jVar;
    }

    public synchronized void b(com.baidu.swan.games.binding.model.c cVar) {
        com.baidu.swan.game.ad.b.d fVar;
        k d = k.d(cVar);
        if (this.edn == 257) {
            com.baidu.swan.game.ad.e.a.aWf().a(d);
        } else if (this.edn == 261 || this.edn == 260 || this.edn == 265) {
            a(d, "3010006");
        } else {
            if (this.edn == 258) {
                if (aWt()) {
                    this.edn = AuthorityState.STATE_INIT_ING;
                } else {
                    c(d);
                }
            }
            if (this.edn == 259 || this.edn == 262 || this.edn == 263 || this.edn == 264 || this.edn == 256 || this.edn == 272) {
                com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
                String str = "";
                if (aMl != null) {
                    str = aMl.getAppKey();
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.ebw) || TextUtils.isEmpty(this.dZp)) {
                    a(d, "3010007");
                } else {
                    this.edp = d;
                    this.edn = 257;
                    com.baidu.swan.game.ad.b.b aVN = new b.a().wj(this.ebw).wk(this.dZp).wl(str).mr(ah.getDisplayWidth(this.mContext)).ms(ah.getDisplayHeight(this.mContext)).mt(1).aVN();
                    if (this.edC) {
                        this.ebn = true;
                        fVar = new com.baidu.swan.game.ad.b.e(this.mContext, aVN, 5, 5);
                        com.baidu.swan.games.view.a.b.ds("gdtvideo", null);
                    } else {
                        this.ebn = false;
                        fVar = new com.baidu.swan.game.ad.b.f(this.mContext, aVN);
                        this.ebS = fVar.aVS();
                        com.baidu.swan.games.view.a.b.ds("video", null);
                    }
                    com.baidu.swan.game.ad.b.a aVar = new com.baidu.swan.game.ad.b.a(this.mContext, this.ebn);
                    aVar.a(this);
                    aVar.a(fVar, this.dZM);
                }
            }
        }
    }

    public synchronized void c(com.baidu.swan.games.binding.model.c cVar) {
        final l e = l.e(cVar);
        String str = "";
        if (this.edn == 261 || this.edn == 260 || this.edn == 265) {
            if (e != null) {
                e.ws("3010004");
            }
            if (this.eds != null) {
                this.eds.onError("3010004");
            }
        } else if (this.edn != 258 || aWt()) {
            a(e, "3010004");
        } else if (this.dZT != null && TextUtils.isEmpty(this.dZT.getVideoUrl())) {
            a(e, "3010008");
        } else if (this.edn == 258) {
            this.edn = 265;
            if (this.dZT != null) {
                str = this.dZT.aVu();
            }
            if (com.baidu.swan.games.view.a.c.isLandScape() && (com.baidu.swan.games.view.a.c.bda() || !TextUtils.isEmpty(str))) {
                SwanAppActivity aDr = com.baidu.swan.apps.v.f.aDH().aDr();
                if (aDr != null) {
                    aDr.setRequestedOrientation(1);
                }
                com.baidu.swan.apps.v.f.aDH().aDL().iq(true);
            }
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.h.1
                @Override // java.lang.Runnable
                public void run() {
                    h.this.aWv();
                    if (com.baidu.swan.games.view.a.c.aY(h.this.edm.getConvertView())) {
                        com.baidu.swan.games.view.a.c.removeView(h.this.edm.getConvertView());
                    }
                    if (!com.baidu.swan.games.view.a.c.c(h.this.edm.getConvertView(), com.baidu.swan.apps.model.a.a.a.aFZ())) {
                        h.this.a(e, "3010000");
                        return;
                    }
                    h.this.edq = e;
                    h.this.edn = 260;
                    h.this.edm.start(h.this.dZT.getVideoUrl());
                }
            });
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void a(AdElementInfo adElementInfo) {
        this.dZT = adElementInfo;
        this.ebn = this.dZT.aVE();
        this.edn = 258;
        c(this.edp);
        if (!this.ebn && this.dZT.getActionType() == 2) {
            initDownload();
        }
        com.baidu.swan.games.view.a.b.ds(getType(), "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void wd(String str) {
        this.edn = 259;
        a(this.edp, str);
        com.baidu.swan.games.view.a.b.ai(getType(), com.baidu.pass.biometrics.face.liveness.c.a.p, str);
    }

    private void aWn() {
        com.baidu.swan.games.view.a.b.h(getType(), "pageclose", this.cFR.getDuration() / 1000);
        aWr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWo() {
        if (this.cFR != null && this.edm != null) {
            if (this.cFR.isPlaying()) {
                this.cFR.pause();
                this.edm.aUD();
            }
            this.edn = 262;
            if (this.ebn) {
                com.baidu.swan.game.ad.c.d.b(mu(this.dZT.getDuration()), this.dZT, this.dZM);
            } else {
                com.baidu.swan.game.ad.c.c.a(getProgress(), this.mPausePosition, this.dZT, this.dZM);
            }
            if (this.edm != null) {
                if (this.cFR.isEnd()) {
                    this.edm.aUG();
                } else {
                    this.edm.aUH();
                }
            }
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.c
    public void aU(View view) {
        SwanAppActivity aDr;
        int i;
        int i2;
        int i3;
        String format;
        if (this.cFR != null && this.dZT != null && (aDr = com.baidu.swan.apps.v.f.aDH().aDr()) != null && !this.edt) {
            if (view != null && c.e.close_ad != view.getId()) {
                aWn();
                return;
            }
            int currentPosition = this.cFR.getCurrentPosition() / 1000;
            int min = Math.min(this.dZT.aVs(), this.cFR.getDuration() / 1000);
            if (currentPosition >= min) {
                aWo();
                return;
            }
            int bcY = com.baidu.swan.games.view.a.c.bcY();
            int bcZ = com.baidu.swan.games.view.a.c.bcZ();
            if (com.baidu.swan.games.view.a.c.isLandScape()) {
                i = (int) (bcY * 0.275f);
                i2 = (int) (bcY * 0.275f);
                i3 = (int) (0.05f * bcZ);
            } else {
                int min2 = Math.min(bcY, bcZ);
                i = (int) (min2 * 0.1f);
                i2 = (int) (min2 * 0.1f);
                i3 = 0;
            }
            aUD();
            com.baidu.swan.games.view.a.b.h(getType(), "pageshow", getProgress());
            this.mContext.getResources().getString(c.g.swangame_game_ad_dialog_msg_more);
            if (this.dZL) {
                format = String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_reward_msg_time_tip), Integer.valueOf(15 - (this.cFR.getCurrentPosition() / 1000)));
            } else {
                format = String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_video_close_alert), Integer.valueOf(min - currentPosition));
            }
            this.edt = true;
            this.edr = new g.a(aDr).gT(true).d(c.g.ad_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.e.h.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    if (!h.this.dZL || h.this.edm == null) {
                        h.this.aWr();
                    } else {
                        if (h.this.cFR != null) {
                            h.this.cFR.pause();
                        }
                        if (h.this.edu != null) {
                            h.this.mContext.unregisterReceiver(h.this.edu);
                            h.this.edu = null;
                        }
                        h.this.edn = 262;
                        h.this.edm.aUH();
                    }
                    h.this.edt = false;
                    com.baidu.swan.games.view.a.b.h(h.this.getType(), "close", h.this.getProgress());
                }
            }).sp(format).c(c.g.ad_continue_watch, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.e.h.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    h.this.aWu();
                    h.this.edt = false;
                    com.baidu.swan.games.view.a.b.h(h.this.getType(), "continue", h.this.getProgress());
                }
            }).ky(c.b.aiapps_game_continue_watch).c(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.game.ad.e.h.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    h.this.edt = false;
                }
            }).a(new com.baidu.swan.apps.view.c.a()).r(i, 0, i2, i3).aLy();
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.d
    public void aV(View view) {
        com.baidu.swan.games.view.a.b.h(getType(), "click", aWw());
        if (this.ebn) {
            aW(view);
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0519a
    public void a(CommandType commandType, Uri uri) {
        String aVw = this.dZT.aVw();
        String packageName = this.dZT.getPackageName();
        switch (commandType) {
            case ACTION_URL:
                if (this.dZT.getActionType() == 2) {
                    aWp();
                    break;
                } else {
                    aWq();
                    break;
                }
            case OPEN_APP:
                if (this.dZT != null) {
                    aw(this.mContext, packageName);
                    break;
                }
                break;
            case GET_DOWNLOAD_STATUS:
                if (this.dZK != null) {
                    if (au(this.mContext, packageName)) {
                        this.edx = edg;
                    }
                    String queryParameter = uri.getQueryParameter(KEY_TOKEN);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(edk, this.edx);
                        jSONObject.put(edl, this.edy);
                        this.dZK.cU(queryParameter, jSONObject.toString());
                        break;
                    } catch (JSONException e) {
                        break;
                    }
                } else {
                    return;
                }
            case PAUSE_DOWNLOAD:
                this.edy = edi;
                aWp();
                break;
            case BANNER_VIEW:
                com.baidu.swan.apps.core.d.f ajt = com.baidu.swan.apps.v.f.aDH().ajt();
                if (ajt == null) {
                    if (this.mContext != null) {
                        com.baidu.swan.apps.res.widget.b.d.u(this.mContext, c.g.aiapps_open_fragment_failed_toast).aLT();
                        return;
                    }
                    return;
                }
                ajt.nv("adLanding").ai(com.baidu.swan.apps.core.d.f.cUY, com.baidu.swan.apps.core.d.f.cVa).a("adLanding", com.baidu.swan.apps.model.b.cg(aVw, aVw)).atf();
                break;
        }
        com.baidu.swan.game.ad.c.c.d(this.dZT, this.dZM);
        com.baidu.swan.games.view.a.b.h(getType(), "click", aWw());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SwanAdDownloadState swanAdDownloadState) {
        this.cGe = swanAdDownloadState;
        if (swanAdDownloadState == SwanAdDownloadState.NOT_START) {
            this.edx = ede;
            this.edy = edj;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
            this.edx = edc;
            this.edy = edi;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
            this.edx = edf;
            this.edy = edj;
        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
            this.edx = edg;
            this.edy = edj;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
            this.edx = edc;
            this.edy = edj;
        }
    }

    private void initDownload() {
        this.cFX = new com.baidu.swan.apps.adlanding.b(this.mContext, this.dZT.aVC());
        this.cGc = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.game.ad.e.h.5
            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void eR(boolean z) {
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void kV(String str) {
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                if (!h.this.edB) {
                    h.this.d(swanAdDownloadState);
                }
                h.this.edB = true;
                if (h.this.cGe != swanAdDownloadState) {
                    if (h.this.cGe == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                        h.this.edy = h.edj;
                        h.this.cFX.kS("appdownloadbegin");
                    } else if (swanAdDownloadState != SwanAdDownloadState.DOWNLOAD_PAUSED) {
                        if (h.this.cGe == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            h.this.edy = h.edj;
                            h.this.cFX.kS("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            h.this.edy = h.edj;
                            h.this.edx = h.edf;
                            h.this.cFX.kS("appdownloadfinish");
                            h.this.cFX.kS("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            h.this.edy = h.edj;
                            h.this.edx = h.edg;
                            h.this.cFX.kS("appinstallfinish");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_FAILED) {
                            h.this.edy = h.edj;
                            h.this.edx = h.edh;
                        } else if (swanAdDownloadState == SwanAdDownloadState.DELETED) {
                            h.this.edy = h.edj;
                            h.this.edx = h.ede;
                        }
                    } else {
                        h.this.edy = h.edi;
                        h.this.cFX.kS("appdownloadpause");
                    }
                    h.this.cGe = swanAdDownloadState;
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                if (i != 0) {
                    if (i != 100 || h.this.edx == h.ede) {
                        if (h.this.edx != h.ede && h.this.edx != h.edh) {
                            h.this.edx = String.valueOf(i);
                            return;
                        }
                        return;
                    }
                    h.this.edx = h.edf;
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void amO() {
                h.this.cFX.kS("appinstallbegin");
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public String amP() {
                h.this.cFX.kS("appinstallopen");
                return "";
            }
        };
        String aVw = this.dZT.aVw();
        String packageName = this.dZT.getPackageName();
        String str = this.edz.get(packageName);
        if (str == null) {
            this.edz.put(packageName, aVw);
            str = aVw;
        }
        this.cGd = new com.baidu.swan.apps.adlanding.download.model.a(str, packageName, this.dZT.getTitle());
        this.edB = false;
        com.baidu.swan.apps.t.a.aAC().a(this.mContext, this.cGd.amR(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS, this.cGc);
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
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "打开失败").kM(3).aLT();
            }
        } else {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "打开失败").kM(3).aLT();
        }
        return false;
    }

    private void aWp() {
        if (ak.isAppInstalled(this.mContext, this.cGd.name)) {
            this.edx = edg;
            aw(this.mContext, this.cGd.name);
            this.cFX.kS("appinstallopen");
            return;
        }
        if (this.cGe == SwanAdDownloadState.NOT_START || this.cGe == SwanAdDownloadState.DELETED) {
            this.edx = edc;
            com.baidu.swan.apps.t.a.aAC().a(this.mContext, this.cGd.amR(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.cGc);
        }
        if (this.cGe == SwanAdDownloadState.DOWNLOADING) {
            com.baidu.swan.apps.t.a.aAC().a(this.mContext, this.cGd.amR(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.cGc);
        }
        if (this.cGe == SwanAdDownloadState.DOWNLOAD_PAUSED) {
            this.edy = edj;
            com.baidu.swan.apps.t.a.aAC().a(this.mContext, this.cGd.amR(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.cGc);
        }
        if (this.cGe == SwanAdDownloadState.DOWNLOAD_FAILED) {
            com.baidu.swan.apps.t.a.aAC().a(this.mContext, this.cGd.amR(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.cGc);
        }
        if (this.cGe == SwanAdDownloadState.DOWNLOADED) {
            this.edx = edf;
            this.cGc.amO();
            com.baidu.swan.apps.t.a.aAC().a(this.mContext, this.cGd.amR(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, this.cGc);
        }
        if (this.cGe == SwanAdDownloadState.INSTALLED) {
            aw(this.mContext, this.cGd.name);
        }
    }

    private void aWq() {
        String aVw = this.dZT.aVw();
        com.baidu.swan.apps.core.d.f ajt = com.baidu.swan.apps.v.f.aDH().ajt();
        if (ajt == null) {
            if (this.mContext != null) {
                com.baidu.swan.apps.res.widget.b.d.u(this.mContext, c.g.aiapps_open_fragment_failed_toast).aLT();
                return;
            }
            return;
        }
        JSONObject aVC = this.dZT.aVC();
        com.baidu.swan.apps.model.b cg = com.baidu.swan.apps.model.b.cg(aVw, aVw);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(edA, aVC);
        } catch (JSONException e) {
        }
        cg.setParams(jSONObject.toString());
        ajt.nv("adLanding").ai(com.baidu.swan.apps.core.d.f.cUY, com.baidu.swan.apps.core.d.f.cVa).a("adLanding", cg).atf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWr() {
        if (this.eds != null && this.cFR != null) {
            this.eds.hU(this.cFR.isEnd() || this.cFR.getCurrentPosition() / 1000 >= Math.min(this.dZT.aVs(), this.cFR.getDuration() / 1000));
        }
        aWs();
        if (!this.ebn && this.dZT.getActionType() == 2 && SwanAdDownloadState.DOWNLOADING == this.cGe) {
            this.cGc = null;
            com.baidu.swan.apps.t.a.aAC().a(this.mContext, this.cGd.amR(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.cGc);
        }
        com.baidu.swan.game.ad.c.c.f(this.dZT, this.dZM);
        this.edn = 263;
        b((com.baidu.swan.games.binding.model.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWs() {
        if (this.cFR != null) {
            this.cFR.pause();
            this.cFR.onDestroy();
        }
        if (this.edu != null) {
            this.mContext.unregisterReceiver(this.edu);
            this.edu = null;
        }
        if (this.edm != null) {
            this.edm.aUF();
            this.edm.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_close));
            com.baidu.swan.games.view.a.c.removeView(this.edm.getConvertView());
        }
        if (this.edo != null) {
            com.baidu.swan.games.view.a.c.b(this.edo);
            this.edo = null;
        }
        if (this.edD != null) {
            this.edD.release();
            this.edD = null;
        }
    }

    private boolean aWt() {
        if (this.dZT == null) {
            return true;
        }
        long aVx = this.dZT.aVx() * 1000;
        if (aVx == 0) {
            aVx = 1740000;
        }
        return System.currentTimeMillis() - this.dZT.getCreateTime() >= aVx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getProgress() {
        if (this.cFR != null) {
            return this.cFR.getCurrentPosition() / 1000;
        }
        return 0;
    }

    private void c(k kVar) {
        if (this.eds != null) {
            this.eds.onLoad();
        }
        if (kVar != null) {
            kVar.onLoadSuccess();
        }
        com.baidu.swan.game.ad.e.a.aWf().as(16, "");
    }

    private void a(k kVar, String str) {
        if (this.eds != null) {
            this.eds.onError(str);
        }
        if (kVar != null) {
            kVar.wr(str);
        }
        com.baidu.swan.game.ad.e.a.aWf().as(17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUD() {
        if (this.cFR != null && this.edm != null && this.cFR.isPlaying()) {
            this.cFR.pause();
            this.edm.aUD();
            if (this.ebn) {
                com.baidu.swan.game.ad.c.d.b(mu(getProgress()), this.dZT, this.dZM);
            } else {
                com.baidu.swan.game.ad.c.c.a(getProgress(), this.mPausePosition, this.dZT, this.dZM);
            }
            this.mPausePosition = getProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWu() {
        if (this.cFR != null && this.edm != null) {
            if ((this.edr == null || !this.edr.isShowing()) && !this.cFR.isPlaying() && !this.edm.aUN()) {
                this.cFR.resume();
                this.edm.aUE();
                com.baidu.swan.game.ad.c.c.e(this.dZT, this.dZM);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar, String str) {
        if (lVar != null) {
            lVar.ws(str);
        }
        if (this.eds != null) {
            this.eds.onError(str);
        }
        this.edn = 264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWv() {
        this.dZK.b(this);
        if (com.baidu.swan.games.view.a.c.isLandScape()) {
            this.edm = new com.baidu.swan.game.ad.d(this.mContext, this.dZT, this.dZK);
        } else {
            this.edm = new com.baidu.swan.game.ad.e(this.mContext, this.dZT, this.dZK);
        }
        if (this.ebn) {
            this.edm.a((a.d) this);
        }
        this.edm.a((a.c) this);
        this.cFR = this.edm.getPlayer();
        this.cFR.b(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.game.ad.e.h.6
            @Override // com.baidu.swan.apps.media.b.b
            public void a(com.baidu.swan.apps.t.b.j jVar) {
                if (h.this.edm != null) {
                    h.this.edm.onPrepared();
                }
                h.this.edn = 261;
                h.this.mPausePosition = 0;
                if (h.this.edm != null) {
                    h.this.edm.aUC();
                }
                if (h.this.edq != null) {
                    h.this.edq.aWG();
                }
                if (h.this.edu == null) {
                    h.this.edu = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    h.this.mContext.registerReceiver(h.this.edu, intentFilter);
                }
                if (h.this.ebn) {
                    com.baidu.swan.game.ad.c.d.a(h.this.dZT, h.this.dZM);
                    return;
                }
                com.baidu.swan.game.ad.c.c.a(h.this.dZT, h.this.dZM);
                com.baidu.swan.game.ad.c.c.e(h.this.dZT, h.this.dZM);
                com.baidu.swan.game.ad.c.c.a(h.this.ebw, h.this.dZp, h.this.ebS, h.this.dZM);
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(com.baidu.swan.apps.t.b.j jVar, int i, int i2) {
                h.this.aWs();
                h.this.a(h.this.edq, "3010001");
                return true;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(com.baidu.swan.apps.t.b.j jVar) {
                h.this.aWo();
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
        if (this.edo == null) {
            this.edo = new com.baidu.swan.games.view.a() { // from class: com.baidu.swan.game.ad.e.h.7
                @Override // com.baidu.swan.games.view.a
                public void aWD() {
                    h.this.edv = true;
                    if (h.this.edw) {
                        h.this.aWu();
                    }
                }

                @Override // com.baidu.swan.games.view.a
                public void aWE() {
                    h.this.edv = false;
                    h.this.aUD();
                }

                @Override // com.baidu.swan.games.view.a
                public void aWF() {
                }
            };
            com.baidu.swan.games.view.a.c.a(this.edo);
        }
        this.edm.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (h.this.cFR != null) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                    h.this.edw = true;
                    if (h.this.edv) {
                        h.this.aWu();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    h.this.edw = false;
                }
            }
        }
    }

    private com.baidu.swan.game.ad.c.b mu(int i) {
        int i2;
        com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
        bVar.ecj = String.valueOf(this.dZT.getDuration());
        bVar.eck = String.valueOf(this.mPausePosition);
        bVar.mEndTime = String.valueOf(i);
        bVar.ecl = this.mPausePosition == 0 ? "1" : "0";
        bVar.ecm = i == this.dZT.getDuration() ? "1" : "0";
        bVar.ecn = this.mContext.getResources().getConfiguration().orientation == 1 ? "2" : "4";
        if (this.mPausePosition == 0) {
            i2 = 1;
        } else if (this.mPausePosition == this.dZT.getDuration()) {
            i2 = 3;
        } else {
            i2 = 2;
        }
        bVar.mType = String.valueOf(i2);
        bVar.eco = (this.mPausePosition == 0 && SwanAppNetworkUtils.isWifiNetworkConnected(this.mContext)) ? "1" : "2";
        bVar.mStatus = String.valueOf(0);
        return bVar;
    }

    public String getType() {
        return this.ebn ? "gdtvideo" : "video";
    }

    private int aWw() {
        return (this.cFR == null || !this.cFR.isEnd()) ? getProgress() : this.cFR.getDuration() / 1000;
    }

    @Override // com.baidu.swan.game.ad.a.a.d
    public void cT(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                jSONObject.put("title", this.dZT.getTitle());
                jSONObject.put("description", this.dZT.getDescription());
                jSONObject.put("autoinstall", true);
                if (this.edD == null) {
                    this.edD = new g(this.mContext, this.dZT, this.dZM);
                }
                this.edD.rw(str);
                com.baidu.swan.apps.t.a.aAC().a(this.mContext, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.edD);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void aW(View view) {
        if (this.ebn && this.dZT != null) {
            com.baidu.swan.game.ad.c.d.d(this.dZT, this.dZM);
            com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
            bVar.ecb = String.valueOf(ah.getDisplayWidth(this.mContext));
            bVar.ecc = String.valueOf(ah.getDisplayHeight(this.mContext));
            bVar.ecd = String.valueOf(ah.getDisplayWidth(this.mContext));
            bVar.ece = String.valueOf(ah.getDisplayHeight(this.mContext));
            bVar.ecf = String.valueOf((int) view.getX());
            bVar.ecg = String.valueOf((int) view.getY());
            bVar.ech = String.valueOf((int) view.getX());
            bVar.eci = String.valueOf((int) view.getY());
            if (this.dZT.getActionType() == 2) {
                com.baidu.swan.game.ad.c.d.a(bVar, this.dZT, this.dZM, this);
                return;
            }
            com.baidu.swan.apps.core.d.f ajt = com.baidu.swan.apps.v.f.aDH().ajt();
            if (ajt == null) {
                if (this.mContext != null) {
                    com.baidu.swan.apps.res.widget.b.d.u(this.mContext, c.g.aiapps_open_fragment_failed_toast).aLT();
                }
            } else if (this.dZT != null) {
                String a2 = com.baidu.swan.game.ad.c.d.a(this.dZT.aVw(), bVar);
                ajt.nv("adLanding").ai(com.baidu.swan.apps.core.d.f.cUY, com.baidu.swan.apps.core.d.f.cVa).a("adLanding", com.baidu.swan.apps.model.b.cg(a2, a2)).atf();
            }
        }
    }
}
