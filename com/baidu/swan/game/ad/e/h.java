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
public class h implements a.InterfaceC0505a, a.b, a.c, a.d {
    private com.baidu.swan.apps.media.b.a cFb;
    private com.baidu.swan.apps.adlanding.b cFh;
    private com.baidu.swan.apps.adlanding.download.a.a cFm;
    private com.baidu.swan.apps.adlanding.download.model.a cFn;
    private AdElementInfo dYQ;
    public String dYk;
    private String eaO;
    private boolean eaj;
    private String eas;
    private com.baidu.swan.game.ad.b eci;
    private com.baidu.swan.games.view.a eck;
    private k ecl;
    private l ecm;
    public com.baidu.swan.apps.res.widget.dialog.g ecn;
    private j eco;
    private boolean ecp;
    private a ecq;
    private boolean ecr;
    private boolean ecx;
    private boolean ecy;
    private g ecz;
    private static String ebY = "0";
    private static String ebZ = StatisticData.ERROR_CODE_NOT_FOUND;
    private static String eca = "101";
    private static String ecb = "102";
    private static String ecc = "103";
    private static String ecd = TbEnum.SystemMessage.EVENT_ID_GROUP_UPGRADE;
    private static String ece = "1";
    private static String ecf = "0";
    private static String ecg = "status";
    private static String ech = "isPaused";
    private static String KEY_TOKEN = "token";
    private static String ecw = "monitors";
    private int ecj = 256;
    private int mPausePosition = 0;
    private boolean ecs = true;
    private String ect = eca;
    private String ecu = ecf;
    private Map<String, String> ecv = new HashMap();
    private SwanAdDownloadState cFo = SwanAdDownloadState.NOT_START;
    private Context mContext = AppRuntime.getAppContext();
    private b dYJ = new b(this.mContext);
    private com.baidu.swan.game.ad.jsbridge.a dYH = new com.baidu.swan.game.ad.jsbridge.a();
    private boolean dYI = com.baidu.swan.game.ad.d.f.aSy();

    public h(String str, String str2, boolean z) {
        this.dYk = "";
        this.eas = str;
        this.dYk = str2;
        this.eaj = z;
        this.ecy = z;
    }

    public void a(j jVar) {
        this.eco = jVar;
    }

    public synchronized void b(com.baidu.swan.games.binding.model.c cVar) {
        com.baidu.swan.game.ad.b.d fVar;
        k d = k.d(cVar);
        if (this.ecj == 257) {
            com.baidu.swan.game.ad.e.a.aSA().a(d);
        } else if (this.ecj == 261 || this.ecj == 260 || this.ecj == 265) {
            a(d, "3010006");
        } else {
            if (this.ecj == 258) {
                if (aSO()) {
                    this.ecj = AuthorityState.STATE_INIT_ING;
                } else {
                    c(d);
                }
            }
            if (this.ecj == 259 || this.ecj == 262 || this.ecj == 263 || this.ecj == 264 || this.ecj == 256 || this.ecj == 272) {
                com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
                String str = "";
                if (aIN != null) {
                    str = aIN.getAppKey();
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.eas) || TextUtils.isEmpty(this.dYk)) {
                    a(d, "3010007");
                } else {
                    this.ecl = d;
                    this.ecj = 257;
                    com.baidu.swan.game.ad.b.b aSi = new b.a().vy(this.eas).vz(this.dYk).vA(str).kP(ah.getDisplayWidth(this.mContext)).kQ(ah.getDisplayHeight(this.mContext)).kR(1).aSi();
                    if (this.ecy) {
                        this.eaj = true;
                        fVar = new com.baidu.swan.game.ad.b.e(this.mContext, aSi, 5, 5);
                        com.baidu.swan.games.view.a.b.dl("gdtvideo", null);
                    } else {
                        this.eaj = false;
                        fVar = new com.baidu.swan.game.ad.b.f(this.mContext, aSi);
                        this.eaO = fVar.aSn();
                        com.baidu.swan.games.view.a.b.dl("video", null);
                    }
                    com.baidu.swan.game.ad.b.a aVar = new com.baidu.swan.game.ad.b.a(this.mContext, this.eaj);
                    aVar.a(this);
                    aVar.a(fVar, this.dYJ);
                }
            }
        }
    }

    public synchronized void c(com.baidu.swan.games.binding.model.c cVar) {
        final l e = l.e(cVar);
        String str = "";
        if (this.ecj == 261 || this.ecj == 260 || this.ecj == 265) {
            if (e != null) {
                e.vH("3010004");
            }
            if (this.eco != null) {
                this.eco.onError("3010004");
            }
        } else if (this.ecj != 258 || aSO()) {
            a(e, "3010004");
        } else if (this.dYQ != null && TextUtils.isEmpty(this.dYQ.getVideoUrl())) {
            a(e, "3010008");
        } else if (this.ecj == 258) {
            this.ecj = 265;
            if (this.dYQ != null) {
                str = this.dYQ.aRT();
            }
            if (com.baidu.swan.games.view.a.c.isLandScape() && (com.baidu.swan.games.view.a.c.aZv() || !TextUtils.isEmpty(str))) {
                SwanAppActivity azY = com.baidu.swan.apps.v.f.aAo().azY();
                if (azY != null) {
                    azY.setRequestedOrientation(1);
                }
                com.baidu.swan.apps.v.f.aAo().aAs().io(true);
            }
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.h.1
                @Override // java.lang.Runnable
                public void run() {
                    h.this.aSQ();
                    if (com.baidu.swan.games.view.a.c.aU(h.this.eci.getConvertView())) {
                        com.baidu.swan.games.view.a.c.removeView(h.this.eci.getConvertView());
                    }
                    if (!com.baidu.swan.games.view.a.c.c(h.this.eci.getConvertView(), com.baidu.swan.apps.model.a.a.a.aCF())) {
                        h.this.a(e, "3010000");
                        return;
                    }
                    h.this.ecm = e;
                    h.this.ecj = 260;
                    h.this.eci.start(h.this.dYQ.getVideoUrl());
                }
            });
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void a(AdElementInfo adElementInfo) {
        this.dYQ = adElementInfo;
        this.eaj = this.dYQ.aSc();
        this.ecj = 258;
        c(this.ecl);
        if (!this.eaj && this.dYQ.getActionType() == 2) {
            initDownload();
        }
        com.baidu.swan.games.view.a.b.dl(getType(), "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void vs(String str) {
        this.ecj = 259;
        a(this.ecl, str);
        com.baidu.swan.games.view.a.b.ai(getType(), com.baidu.pass.biometrics.face.liveness.c.a.p, str);
    }

    private void aSI() {
        com.baidu.swan.games.view.a.b.i(getType(), "pageclose", this.cFb.getDuration() / 1000);
        aSM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSJ() {
        if (this.cFb != null && this.eci != null) {
            if (this.cFb.isPlaying()) {
                this.cFb.pause();
                this.eci.pausePlay();
            }
            this.ecj = 262;
            if (this.eaj) {
                com.baidu.swan.game.ad.c.d.b(kS(this.dYQ.getDuration()), this.dYQ, this.dYJ);
            } else {
                com.baidu.swan.game.ad.c.c.a(getProgress(), this.mPausePosition, this.dYQ, this.dYJ);
            }
            if (this.eci != null) {
                if (this.cFb.isEnd()) {
                    this.eci.playCompletion();
                } else {
                    this.eci.aRg();
                }
            }
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.c
    public void aQ(View view) {
        SwanAppActivity azY;
        int i;
        int i2;
        int i3;
        String format;
        if (this.cFb != null && this.dYQ != null && (azY = com.baidu.swan.apps.v.f.aAo().azY()) != null && !this.ecp) {
            if (view != null && c.e.close_ad != view.getId()) {
                aSI();
                return;
            }
            int currentPosition = this.cFb.getCurrentPosition() / 1000;
            int min = Math.min(this.dYQ.aRR(), this.cFb.getDuration() / 1000);
            if (currentPosition >= min) {
                aSJ();
                return;
            }
            int aZt = com.baidu.swan.games.view.a.c.aZt();
            int aZu = com.baidu.swan.games.view.a.c.aZu();
            if (com.baidu.swan.games.view.a.c.isLandScape()) {
                i = (int) (aZt * 0.275f);
                i2 = (int) (aZt * 0.275f);
                i3 = (int) (0.05f * aZu);
            } else {
                int min2 = Math.min(aZt, aZu);
                i = (int) (min2 * 0.1f);
                i2 = (int) (min2 * 0.1f);
                i3 = 0;
            }
            pausePlay();
            com.baidu.swan.games.view.a.b.i(getType(), "pageshow", getProgress());
            this.mContext.getResources().getString(c.g.swangame_game_ad_dialog_msg_more);
            if (this.dYI) {
                format = String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_reward_msg_time_tip), Integer.valueOf(15 - (this.cFb.getCurrentPosition() / 1000)));
            } else {
                format = String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_video_close_alert), Integer.valueOf(min - currentPosition));
            }
            this.ecp = true;
            this.ecn = new g.a(azY).gR(true).d(c.g.ad_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.e.h.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    if (!h.this.dYI || h.this.eci == null) {
                        h.this.aSM();
                    } else {
                        if (h.this.cFb != null) {
                            h.this.cFb.pause();
                        }
                        if (h.this.ecq != null) {
                            h.this.mContext.unregisterReceiver(h.this.ecq);
                            h.this.ecq = null;
                        }
                        h.this.ecj = 262;
                        h.this.eci.aRg();
                    }
                    h.this.ecp = false;
                    com.baidu.swan.games.view.a.b.i(h.this.getType(), "close", h.this.getProgress());
                }
            }).rE(format).c(c.g.ad_continue_watch, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.e.h.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    h.this.aSP();
                    h.this.ecp = false;
                    com.baidu.swan.games.view.a.b.i(h.this.getType(), "continue", h.this.getProgress());
                }
            }).iW(c.b.aiapps_game_continue_watch).c(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.game.ad.e.h.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    h.this.ecp = false;
                }
            }).a(new com.baidu.swan.apps.view.c.a()).r(i, 0, i2, i3).aIa();
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.d
    public void aR(View view) {
        com.baidu.swan.games.view.a.b.i(getType(), "click", aSR());
        if (this.eaj) {
            aS(view);
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0505a
    public void a(CommandType commandType, Uri uri) {
        String aRU = this.dYQ.aRU();
        String packageName = this.dYQ.getPackageName();
        switch (commandType) {
            case ACTION_URL:
                if (this.dYQ.getActionType() == 2) {
                    aSK();
                    break;
                } else {
                    aSL();
                    break;
                }
            case OPEN_APP:
                if (this.dYQ != null) {
                    au(this.mContext, packageName);
                    break;
                }
                break;
            case GET_DOWNLOAD_STATUS:
                if (this.dYH != null) {
                    if (as(this.mContext, packageName)) {
                        this.ect = ecc;
                    }
                    String queryParameter = uri.getQueryParameter(KEY_TOKEN);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(ecg, this.ect);
                        jSONObject.put(ech, this.ecu);
                        this.dYH.cN(queryParameter, jSONObject.toString());
                        break;
                    } catch (JSONException e) {
                        break;
                    }
                } else {
                    return;
                }
            case PAUSE_DOWNLOAD:
                this.ecu = ece;
                aSK();
                break;
            case BANNER_VIEW:
                com.baidu.swan.apps.core.d.f aga = com.baidu.swan.apps.v.f.aAo().aga();
                if (aga == null) {
                    if (this.mContext != null) {
                        com.baidu.swan.apps.res.widget.b.d.u(this.mContext, c.g.aiapps_open_fragment_failed_toast).aIv();
                        return;
                    }
                    return;
                }
                aga.mJ("adLanding").af(com.baidu.swan.apps.core.d.f.cTZ, com.baidu.swan.apps.core.d.f.cUb).a("adLanding", com.baidu.swan.apps.model.b.bZ(aRU, aRU)).apL();
                break;
        }
        com.baidu.swan.game.ad.c.c.d(this.dYQ, this.dYJ);
        com.baidu.swan.games.view.a.b.i(getType(), "click", aSR());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SwanAdDownloadState swanAdDownloadState) {
        this.cFo = swanAdDownloadState;
        if (swanAdDownloadState == SwanAdDownloadState.NOT_START) {
            this.ect = eca;
            this.ecu = ecf;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
            this.ect = ebY;
            this.ecu = ece;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
            this.ect = ecb;
            this.ecu = ecf;
        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
            this.ect = ecc;
            this.ecu = ecf;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
            this.ect = ebY;
            this.ecu = ecf;
        }
    }

    private void initDownload() {
        this.cFh = new com.baidu.swan.apps.adlanding.b(this.mContext, this.dYQ.aSa());
        this.cFm = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.game.ad.e.h.5
            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void eP(boolean z) {
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void kj(String str) {
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                if (!h.this.ecx) {
                    h.this.d(swanAdDownloadState);
                }
                h.this.ecx = true;
                if (h.this.cFo != swanAdDownloadState) {
                    if (h.this.cFo == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                        h.this.ecu = h.ecf;
                        h.this.cFh.kg("appdownloadbegin");
                    } else if (swanAdDownloadState != SwanAdDownloadState.DOWNLOAD_PAUSED) {
                        if (h.this.cFo == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            h.this.ecu = h.ecf;
                            h.this.cFh.kg("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            h.this.ecu = h.ecf;
                            h.this.ect = h.ecb;
                            h.this.cFh.kg("appdownloadfinish");
                            h.this.cFh.kg("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            h.this.ecu = h.ecf;
                            h.this.ect = h.ecc;
                            h.this.cFh.kg("appinstallfinish");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_FAILED) {
                            h.this.ecu = h.ecf;
                            h.this.ect = h.ecd;
                        } else if (swanAdDownloadState == SwanAdDownloadState.DELETED) {
                            h.this.ecu = h.ecf;
                            h.this.ect = h.eca;
                        }
                    } else {
                        h.this.ecu = h.ece;
                        h.this.cFh.kg("appdownloadpause");
                    }
                    h.this.cFo = swanAdDownloadState;
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                if (i != 0) {
                    if (i != 100 || h.this.ect == h.eca) {
                        if (h.this.ect != h.eca && h.this.ect != h.ecd) {
                            h.this.ect = String.valueOf(i);
                            return;
                        }
                        return;
                    }
                    h.this.ect = h.ecb;
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void ajv() {
                h.this.cFh.kg("appinstallbegin");
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public String ajw() {
                h.this.cFh.kg("appinstallopen");
                return "";
            }
        };
        String aRU = this.dYQ.aRU();
        String packageName = this.dYQ.getPackageName();
        String str = this.ecv.get(packageName);
        if (str == null) {
            this.ecv.put(packageName, aRU);
            str = aRU;
        }
        this.cFn = new com.baidu.swan.apps.adlanding.download.model.a(str, packageName, this.dYQ.getTitle());
        this.ecx = false;
        com.baidu.swan.apps.t.a.axj().a(this.mContext, this.cFn.ajy(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS, this.cFm);
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
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "打开失败").jk(3).aIv();
            }
        } else {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "打开失败").jk(3).aIv();
        }
        return false;
    }

    private void aSK() {
        if (ak.isAppInstalled(this.mContext, this.cFn.name)) {
            this.ect = ecc;
            au(this.mContext, this.cFn.name);
            this.cFh.kg("appinstallopen");
            return;
        }
        if (this.cFo == SwanAdDownloadState.NOT_START || this.cFo == SwanAdDownloadState.DELETED) {
            this.ect = ebY;
            com.baidu.swan.apps.t.a.axj().a(this.mContext, this.cFn.ajy(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.cFm);
        }
        if (this.cFo == SwanAdDownloadState.DOWNLOADING) {
            com.baidu.swan.apps.t.a.axj().a(this.mContext, this.cFn.ajy(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.cFm);
        }
        if (this.cFo == SwanAdDownloadState.DOWNLOAD_PAUSED) {
            this.ecu = ecf;
            com.baidu.swan.apps.t.a.axj().a(this.mContext, this.cFn.ajy(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.cFm);
        }
        if (this.cFo == SwanAdDownloadState.DOWNLOAD_FAILED) {
            com.baidu.swan.apps.t.a.axj().a(this.mContext, this.cFn.ajy(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.cFm);
        }
        if (this.cFo == SwanAdDownloadState.DOWNLOADED) {
            this.ect = ecb;
            this.cFm.ajv();
            com.baidu.swan.apps.t.a.axj().a(this.mContext, this.cFn.ajy(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, this.cFm);
        }
        if (this.cFo == SwanAdDownloadState.INSTALLED) {
            au(this.mContext, this.cFn.name);
        }
    }

    private void aSL() {
        String aRU = this.dYQ.aRU();
        com.baidu.swan.apps.core.d.f aga = com.baidu.swan.apps.v.f.aAo().aga();
        if (aga == null) {
            if (this.mContext != null) {
                com.baidu.swan.apps.res.widget.b.d.u(this.mContext, c.g.aiapps_open_fragment_failed_toast).aIv();
                return;
            }
            return;
        }
        JSONObject aSa = this.dYQ.aSa();
        com.baidu.swan.apps.model.b bZ = com.baidu.swan.apps.model.b.bZ(aRU, aRU);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(ecw, aSa);
        } catch (JSONException e) {
        }
        bZ.setParams(jSONObject.toString());
        aga.mJ("adLanding").af(com.baidu.swan.apps.core.d.f.cTZ, com.baidu.swan.apps.core.d.f.cUb).a("adLanding", bZ).apL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSM() {
        if (this.eco != null && this.cFb != null) {
            this.eco.hS(this.cFb.isEnd() || this.cFb.getCurrentPosition() / 1000 >= Math.min(this.dYQ.aRR(), this.cFb.getDuration() / 1000));
        }
        aSN();
        if (!this.eaj && this.dYQ.getActionType() == 2 && SwanAdDownloadState.DOWNLOADING == this.cFo) {
            this.cFm = null;
            com.baidu.swan.apps.t.a.axj().a(this.mContext, this.cFn.ajy(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.cFm);
        }
        com.baidu.swan.game.ad.c.c.f(this.dYQ, this.dYJ);
        this.ecj = 263;
        b((com.baidu.swan.games.binding.model.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSN() {
        if (this.cFb != null) {
            this.cFb.pause();
            this.cFb.onDestroy();
        }
        if (this.ecq != null) {
            this.mContext.unregisterReceiver(this.ecq);
            this.ecq = null;
        }
        if (this.eci != null) {
            this.eci.aRf();
            this.eci.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_close));
            com.baidu.swan.games.view.a.c.removeView(this.eci.getConvertView());
        }
        if (this.eck != null) {
            com.baidu.swan.games.view.a.c.b(this.eck);
            this.eck = null;
        }
        if (this.ecz != null) {
            this.ecz.release();
            this.ecz = null;
        }
    }

    private boolean aSO() {
        if (this.dYQ == null) {
            return true;
        }
        long aRV = this.dYQ.aRV() * 1000;
        if (aRV == 0) {
            aRV = 1740000;
        }
        return System.currentTimeMillis() - this.dYQ.getCreateTime() >= aRV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getProgress() {
        if (this.cFb != null) {
            return this.cFb.getCurrentPosition() / 1000;
        }
        return 0;
    }

    private void c(k kVar) {
        if (this.eco != null) {
            this.eco.onLoad();
        }
        if (kVar != null) {
            kVar.onLoadSuccess();
        }
        com.baidu.swan.game.ad.e.a.aSA().ax(16, "");
    }

    private void a(k kVar, String str) {
        if (this.eco != null) {
            this.eco.onError(str);
        }
        if (kVar != null) {
            kVar.vG(str);
        }
        com.baidu.swan.game.ad.e.a.aSA().ax(17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pausePlay() {
        if (this.cFb != null && this.eci != null && this.cFb.isPlaying()) {
            this.cFb.pause();
            this.eci.pausePlay();
            if (this.eaj) {
                com.baidu.swan.game.ad.c.d.b(kS(getProgress()), this.dYQ, this.dYJ);
            } else {
                com.baidu.swan.game.ad.c.c.a(getProgress(), this.mPausePosition, this.dYQ, this.dYJ);
            }
            this.mPausePosition = getProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSP() {
        if (this.cFb != null && this.eci != null) {
            if ((this.ecn == null || !this.ecn.isShowing()) && !this.cFb.isPlaying() && !this.eci.aRm()) {
                this.cFb.resume();
                this.eci.resumePlay();
                com.baidu.swan.game.ad.c.c.e(this.dYQ, this.dYJ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar, String str) {
        if (lVar != null) {
            lVar.vH(str);
        }
        if (this.eco != null) {
            this.eco.onError(str);
        }
        this.ecj = 264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSQ() {
        this.dYH.b(this);
        if (com.baidu.swan.games.view.a.c.isLandScape()) {
            this.eci = new com.baidu.swan.game.ad.d(this.mContext, this.dYQ, this.dYH);
        } else {
            this.eci = new com.baidu.swan.game.ad.e(this.mContext, this.dYQ, this.dYH);
        }
        if (this.eaj) {
            this.eci.a((a.d) this);
        }
        this.eci.a((a.c) this);
        this.cFb = this.eci.getPlayer();
        this.cFb.b(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.game.ad.e.h.6
            @Override // com.baidu.swan.apps.media.b.b
            public void a(com.baidu.swan.apps.t.b.j jVar) {
                if (h.this.eci != null) {
                    h.this.eci.onPrepared();
                }
                h.this.ecj = 261;
                h.this.mPausePosition = 0;
                if (h.this.eci != null) {
                    h.this.eci.aRe();
                }
                if (h.this.ecm != null) {
                    h.this.ecm.aTb();
                }
                if (h.this.ecq == null) {
                    h.this.ecq = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    h.this.mContext.registerReceiver(h.this.ecq, intentFilter);
                }
                if (h.this.eaj) {
                    com.baidu.swan.game.ad.c.d.a(h.this.dYQ, h.this.dYJ);
                    return;
                }
                com.baidu.swan.game.ad.c.c.a(h.this.dYQ, h.this.dYJ);
                com.baidu.swan.game.ad.c.c.e(h.this.dYQ, h.this.dYJ);
                com.baidu.swan.game.ad.c.c.a(h.this.eas, h.this.dYk, h.this.eaO, h.this.dYJ);
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(com.baidu.swan.apps.t.b.j jVar, int i, int i2) {
                h.this.aSN();
                h.this.a(h.this.ecm, "3010001");
                return true;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(com.baidu.swan.apps.t.b.j jVar) {
                h.this.aSJ();
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
        if (this.eck == null) {
            this.eck = new com.baidu.swan.games.view.a() { // from class: com.baidu.swan.game.ad.e.h.7
                @Override // com.baidu.swan.games.view.a
                public void aSY() {
                    h.this.ecr = true;
                    if (h.this.ecs) {
                        h.this.aSP();
                    }
                }

                @Override // com.baidu.swan.games.view.a
                public void aSZ() {
                    h.this.ecr = false;
                    h.this.pausePlay();
                }

                @Override // com.baidu.swan.games.view.a
                public void aTa() {
                }
            };
            com.baidu.swan.games.view.a.c.a(this.eck);
        }
        this.eci.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (h.this.cFb != null) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                    h.this.ecs = true;
                    if (h.this.ecr) {
                        h.this.aSP();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    h.this.ecs = false;
                }
            }
        }
    }

    private com.baidu.swan.game.ad.c.b kS(int i) {
        int i2;
        com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
        bVar.ebf = String.valueOf(this.dYQ.getDuration());
        bVar.ebg = String.valueOf(this.mPausePosition);
        bVar.mEndTime = String.valueOf(i);
        bVar.ebh = this.mPausePosition == 0 ? "1" : "0";
        bVar.ebi = i == this.dYQ.getDuration() ? "1" : "0";
        bVar.ebj = this.mContext.getResources().getConfiguration().orientation == 1 ? "2" : "4";
        if (this.mPausePosition == 0) {
            i2 = 1;
        } else if (this.mPausePosition == this.dYQ.getDuration()) {
            i2 = 3;
        } else {
            i2 = 2;
        }
        bVar.mType = String.valueOf(i2);
        bVar.ebk = (this.mPausePosition == 0 && SwanAppNetworkUtils.isWifiNetworkConnected(this.mContext)) ? "1" : "2";
        bVar.mStatus = String.valueOf(0);
        return bVar;
    }

    public String getType() {
        return this.eaj ? "gdtvideo" : "video";
    }

    private int aSR() {
        return (this.cFb == null || !this.cFb.isEnd()) ? getProgress() : this.cFb.getDuration() / 1000;
    }

    @Override // com.baidu.swan.game.ad.a.a.d
    public void cM(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                jSONObject.put("title", this.dYQ.getTitle());
                jSONObject.put("description", this.dYQ.getDescription());
                jSONObject.put("autoinstall", true);
                if (this.ecz == null) {
                    this.ecz = new g(this.mContext, this.dYQ, this.dYJ);
                }
                this.ecz.qK(str);
                com.baidu.swan.apps.t.a.axj().a(this.mContext, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.ecz);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void aS(View view) {
        if (this.eaj && this.dYQ != null) {
            com.baidu.swan.game.ad.c.d.d(this.dYQ, this.dYJ);
            com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
            bVar.eaX = String.valueOf(ah.getDisplayWidth(this.mContext));
            bVar.eaY = String.valueOf(ah.getDisplayHeight(this.mContext));
            bVar.eaZ = String.valueOf(ah.getDisplayWidth(this.mContext));
            bVar.eba = String.valueOf(ah.getDisplayHeight(this.mContext));
            bVar.ebb = String.valueOf((int) view.getX());
            bVar.ebc = String.valueOf((int) view.getY());
            bVar.ebd = String.valueOf((int) view.getX());
            bVar.ebe = String.valueOf((int) view.getY());
            if (this.dYQ.getActionType() == 2) {
                com.baidu.swan.game.ad.c.d.a(bVar, this.dYQ, this.dYJ, this);
                return;
            }
            com.baidu.swan.apps.core.d.f aga = com.baidu.swan.apps.v.f.aAo().aga();
            if (aga == null) {
                if (this.mContext != null) {
                    com.baidu.swan.apps.res.widget.b.d.u(this.mContext, c.g.aiapps_open_fragment_failed_toast).aIv();
                }
            } else if (this.dYQ != null) {
                String a2 = com.baidu.swan.game.ad.c.d.a(this.dYQ.aRU(), bVar);
                aga.mJ("adLanding").af(com.baidu.swan.apps.core.d.f.cTZ, com.baidu.swan.apps.core.d.f.cUb).a("adLanding", com.baidu.swan.apps.model.b.bZ(a2, a2)).apL();
            }
        }
    }
}
