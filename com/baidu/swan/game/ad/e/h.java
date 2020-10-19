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
public class h implements a.InterfaceC0490a, a.b, a.c, a.d {
    private com.baidu.swan.apps.adlanding.b chA;
    private com.baidu.swan.apps.adlanding.download.a.a chF;
    private com.baidu.swan.apps.adlanding.download.model.a chG;
    private com.baidu.swan.apps.media.b.a chu;
    private com.baidu.swan.game.ad.b dAK;
    private com.baidu.swan.games.view.a dAM;
    private k dAN;
    private l dAO;
    public com.baidu.swan.apps.res.widget.dialog.g dAP;
    private j dAQ;
    private boolean dAR;
    private a dAS;
    private boolean dAT;
    private boolean dAZ;
    private boolean dBa;
    private g dBb;
    public String dwN;
    private AdElementInfo dxr;
    private boolean dyM;
    private String dyV;
    private String dzr;
    private static String dAA = "0";
    private static String dAB = "100";
    private static String dAC = TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY;
    private static String dAD = TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY;
    private static String dAE = TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY;
    private static String dAF = TbEnum.SystemMessage.EVENT_ID_GROUP_UPGRADE;
    private static String dAG = "1";
    private static String dAH = "0";
    private static String dAI = "status";
    private static String dAJ = "isPaused";
    private static String KEY_TOKEN = "token";
    private static String dAY = "monitors";
    private int dAL = 256;
    private int mPausePosition = 0;
    private boolean dAU = true;
    private String dAV = dAC;
    private String dAW = dAH;
    private Map<String, String> dAX = new HashMap();
    private SwanAdDownloadState chH = SwanAdDownloadState.NOT_START;
    private Context mContext = AppRuntime.getAppContext();
    private b dxk = new b(this.mContext);
    private com.baidu.swan.game.ad.jsbridge.a dxi = new com.baidu.swan.game.ad.jsbridge.a();
    private boolean dxj = com.baidu.swan.game.ad.d.f.aMR();

    public h(String str, String str2, boolean z) {
        this.dwN = "";
        this.dyV = str;
        this.dwN = str2;
        this.dyM = z;
        this.dBa = z;
    }

    public void a(j jVar) {
        this.dAQ = jVar;
    }

    public synchronized void b(com.baidu.swan.games.binding.model.c cVar) {
        com.baidu.swan.game.ad.b.d fVar;
        k d = k.d(cVar);
        if (this.dAL == 257) {
            com.baidu.swan.game.ad.e.a.aMT().a(d);
        } else if (this.dAL == 261 || this.dAL == 260 || this.dAL == 265) {
            a(d, "3010006");
        } else {
            if (this.dAL == 258) {
                if (aNh()) {
                    this.dAL = AuthorityState.STATE_INIT_ING;
                } else {
                    c(d);
                }
            }
            if (this.dAL == 259 || this.dAL == 262 || this.dAL == 263 || this.dAL == 264 || this.dAL == 256 || this.dAL == 272) {
                com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
                String str = "";
                if (aDa != null) {
                    str = aDa.getAppKey();
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.dyV) || TextUtils.isEmpty(this.dwN)) {
                    a(d, "3010007");
                } else {
                    this.dAN = d;
                    this.dAL = 257;
                    com.baidu.swan.game.ad.b.b aMB = new b.a().vb(this.dyV).vc(this.dwN).vd(str).lu(ah.getDisplayWidth(this.mContext)).lv(ah.getDisplayHeight(this.mContext)).lw(1).aMB();
                    if (this.dBa) {
                        this.dyM = true;
                        fVar = new com.baidu.swan.game.ad.b.e(this.mContext, aMB, 5, 5);
                        com.baidu.swan.games.view.a.b.dg("gdtvideo", null);
                    } else {
                        this.dyM = false;
                        fVar = new com.baidu.swan.game.ad.b.f(this.mContext, aMB);
                        this.dzr = fVar.aMG();
                        com.baidu.swan.games.view.a.b.dg("video", null);
                    }
                    com.baidu.swan.game.ad.b.a aVar = new com.baidu.swan.game.ad.b.a(this.mContext, this.dyM);
                    aVar.a(this);
                    aVar.a(fVar, this.dxk);
                }
            }
        }
    }

    public synchronized void c(com.baidu.swan.games.binding.model.c cVar) {
        final l e = l.e(cVar);
        String str = "";
        if (this.dAL == 261 || this.dAL == 260 || this.dAL == 265) {
            if (e != null) {
                e.vk("3010004");
            }
            if (this.dAQ != null) {
                this.dAQ.onError("3010004");
            }
        } else if (this.dAL != 258 || aNh()) {
            a(e, "3010004");
        } else if (this.dxr != null && TextUtils.isEmpty(this.dxr.getVideoUrl())) {
            a(e, "3010008");
        } else if (this.dAL == 258) {
            this.dAL = 265;
            if (this.dxr != null) {
                str = this.dxr.aMi();
            }
            if (com.baidu.swan.games.view.a.c.isLandScape() && (com.baidu.swan.games.view.a.c.aTQ() || !TextUtils.isEmpty(str))) {
                SwanAppActivity ave = com.baidu.swan.apps.v.f.avu().ave();
                if (ave != null) {
                    ave.setRequestedOrientation(1);
                }
                com.baidu.swan.apps.v.f.avu().avy().hk(true);
            }
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.h.1
                @Override // java.lang.Runnable
                public void run() {
                    h.this.aNj();
                    if (com.baidu.swan.games.view.a.c.aI(h.this.dAK.getConvertView())) {
                        com.baidu.swan.games.view.a.c.removeView(h.this.dAK.getConvertView());
                    }
                    if (!com.baidu.swan.games.view.a.c.c(h.this.dAK.getConvertView(), com.baidu.swan.apps.model.a.a.a.axK())) {
                        h.this.a(e, "3010000");
                        return;
                    }
                    h.this.dAO = e;
                    h.this.dAL = 260;
                    h.this.dAK.bs(h.this.dxr.getVideoUrl());
                }
            });
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void a(AdElementInfo adElementInfo) {
        this.dxr = adElementInfo;
        this.dyM = this.dxr.aMs();
        this.dAL = 258;
        c(this.dAN);
        if (!this.dyM && this.dxr.getActionType() == 2) {
            initDownload();
        }
        com.baidu.swan.games.view.a.b.dg(getType(), "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void uV(String str) {
        this.dAL = 259;
        a(this.dAN, str);
        com.baidu.swan.games.view.a.b.V(getType(), "fail", str);
    }

    private void aNb() {
        com.baidu.swan.games.view.a.b.g(getType(), "pageclose", this.chu.getDuration() / 1000);
        aNf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNc() {
        if (this.chu != null && this.dAK != null) {
            if (this.chu.isPlaying()) {
                this.chu.pause();
                this.dAK.aLr();
            }
            this.dAL = 262;
            if (this.dyM) {
                com.baidu.swan.game.ad.c.d.b(lx(this.dxr.getDuration()), this.dxr, this.dxk);
            } else {
                com.baidu.swan.game.ad.c.c.a(getProgress(), this.mPausePosition, this.dxr, this.dxk);
            }
            if (this.dAK != null) {
                if (this.chu.isEnd()) {
                    this.dAK.aLu();
                } else {
                    this.dAK.aLv();
                }
            }
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.c
    public void aE(View view) {
        SwanAppActivity ave;
        int i;
        int i2;
        int i3;
        String format;
        if (this.chu != null && this.dxr != null && (ave = com.baidu.swan.apps.v.f.avu().ave()) != null && !this.dAR) {
            if (view != null && c.e.close_ad != view.getId()) {
                aNb();
                return;
            }
            int currentPosition = this.chu.getCurrentPosition() / 1000;
            int min = Math.min(this.dxr.aMg(), this.chu.getDuration() / 1000);
            if (currentPosition >= min) {
                aNc();
                return;
            }
            int aTO = com.baidu.swan.games.view.a.c.aTO();
            int aTP = com.baidu.swan.games.view.a.c.aTP();
            if (com.baidu.swan.games.view.a.c.isLandScape()) {
                i = (int) (aTO * 0.275f);
                i2 = (int) (aTO * 0.275f);
                i3 = (int) (0.05f * aTP);
            } else {
                int min2 = Math.min(aTO, aTP);
                i = (int) (min2 * 0.1f);
                i2 = (int) (min2 * 0.1f);
                i3 = 0;
            }
            aLr();
            com.baidu.swan.games.view.a.b.g(getType(), "pageshow", getProgress());
            this.mContext.getResources().getString(c.g.swangame_game_ad_dialog_msg_more);
            if (this.dxj) {
                format = String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_reward_msg_time_tip), Integer.valueOf(15 - (this.chu.getCurrentPosition() / 1000)));
            } else {
                format = String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_video_close_alert), Integer.valueOf(min - currentPosition));
            }
            this.dAR = true;
            this.dAP = new g.a(ave).fT(true).d(c.g.ad_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.e.h.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    if (!h.this.dxj || h.this.dAK == null) {
                        h.this.aNf();
                    } else {
                        if (h.this.chu != null) {
                            h.this.chu.pause();
                        }
                        if (h.this.dAS != null) {
                            h.this.mContext.unregisterReceiver(h.this.dAS);
                            h.this.dAS = null;
                        }
                        h.this.dAL = 262;
                        h.this.dAK.aLv();
                    }
                    h.this.dAR = false;
                    com.baidu.swan.games.view.a.b.g(h.this.getType(), "close", h.this.getProgress());
                }
            }).rk(format).c(c.g.ad_continue_watch, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.e.h.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    h.this.aNi();
                    h.this.dAR = false;
                    com.baidu.swan.games.view.a.b.g(h.this.getType(), "continue", h.this.getProgress());
                }
            }).jG(c.b.aiapps_game_continue_watch).b(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.game.ad.e.h.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    h.this.dAR = false;
                }
            }).a(new com.baidu.swan.apps.view.c.a()).n(i, 0, i2, i3).aCH();
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.d
    public void aF(View view) {
        com.baidu.swan.games.view.a.b.g(getType(), "click", aNk());
        if (this.dyM) {
            aG(view);
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0490a
    public void a(CommandType commandType, Uri uri) {
        String aMk = this.dxr.aMk();
        String packageName = this.dxr.getPackageName();
        switch (commandType) {
            case ACTION_URL:
                if (this.dxr.getActionType() == 2) {
                    aNd();
                    break;
                } else {
                    aNe();
                    break;
                }
            case OPEN_APP:
                if (this.dxr != null) {
                    an(this.mContext, packageName);
                    break;
                }
                break;
            case GET_DOWNLOAD_STATUS:
                if (this.dxi != null) {
                    if (al(this.mContext, packageName)) {
                        this.dAV = dAE;
                    }
                    String queryParameter = uri.getQueryParameter(KEY_TOKEN);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(dAI, this.dAV);
                        jSONObject.put(dAJ, this.dAW);
                        this.dxi.cI(queryParameter, jSONObject.toString());
                        break;
                    } catch (JSONException e) {
                        break;
                    }
                } else {
                    return;
                }
            case PAUSE_DOWNLOAD:
                this.dAW = dAG;
                aNd();
                break;
            case BANNER_VIEW:
                com.baidu.swan.apps.core.d.f abs = com.baidu.swan.apps.v.f.avu().abs();
                if (abs == null) {
                    if (this.mContext != null) {
                        com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                        return;
                    }
                    return;
                }
                abs.mt("adLanding").ak(com.baidu.swan.apps.core.d.f.cwD, com.baidu.swan.apps.core.d.f.cwF).a("adLanding", com.baidu.swan.apps.model.b.bU(aMk, aMk)).akS();
                break;
        }
        com.baidu.swan.game.ad.c.c.d(this.dxr, this.dxk);
        com.baidu.swan.games.view.a.b.g(getType(), "click", aNk());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SwanAdDownloadState swanAdDownloadState) {
        this.chH = swanAdDownloadState;
        if (swanAdDownloadState == SwanAdDownloadState.NOT_START) {
            this.dAV = dAC;
            this.dAW = dAH;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
            this.dAV = dAA;
            this.dAW = dAG;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
            this.dAV = dAD;
            this.dAW = dAH;
        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
            this.dAV = dAE;
            this.dAW = dAH;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
            this.dAV = dAA;
            this.dAW = dAH;
        }
    }

    private void initDownload() {
        this.chA = new com.baidu.swan.apps.adlanding.b(this.mContext, this.dxr.aMq());
        this.chF = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.game.ad.e.h.5
            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void dU(boolean z) {
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void jT(String str) {
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                if (!h.this.dAZ) {
                    h.this.d(swanAdDownloadState);
                }
                h.this.dAZ = true;
                if (h.this.chH != swanAdDownloadState) {
                    if (h.this.chH == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                        h.this.dAW = h.dAH;
                        h.this.chA.jQ("appdownloadbegin");
                    } else if (swanAdDownloadState != SwanAdDownloadState.DOWNLOAD_PAUSED) {
                        if (h.this.chH == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            h.this.dAW = h.dAH;
                            h.this.chA.jQ("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            h.this.dAW = h.dAH;
                            h.this.dAV = h.dAD;
                            h.this.chA.jQ("appdownloadfinish");
                            h.this.chA.jQ("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            h.this.dAW = h.dAH;
                            h.this.dAV = h.dAE;
                            h.this.chA.jQ("appinstallfinish");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_FAILED) {
                            h.this.dAW = h.dAH;
                            h.this.dAV = h.dAF;
                        } else if (swanAdDownloadState == SwanAdDownloadState.DELETED) {
                            h.this.dAW = h.dAH;
                            h.this.dAV = h.dAC;
                        }
                    } else {
                        h.this.dAW = h.dAG;
                        h.this.chA.jQ("appdownloadpause");
                    }
                    h.this.chH = swanAdDownloadState;
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                if (i != 0) {
                    if (i != 100 || h.this.dAV == h.dAC) {
                        if (h.this.dAV != h.dAC && h.this.dAV != h.dAF) {
                            h.this.dAV = String.valueOf(i);
                            return;
                        }
                        return;
                    }
                    h.this.dAV = h.dAD;
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void aeJ() {
                h.this.chA.jQ("appinstallbegin");
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public String aeK() {
                h.this.chA.jQ("appinstallopen");
                return "";
            }
        };
        String aMk = this.dxr.aMk();
        String packageName = this.dxr.getPackageName();
        String str = this.dAX.get(packageName);
        if (str == null) {
            this.dAX.put(packageName, aMk);
            str = aMk;
        }
        this.chG = new com.baidu.swan.apps.adlanding.download.model.a(str, packageName, this.dxr.getTitle());
        this.dAZ = false;
        com.baidu.swan.apps.t.a.asq().a(this.mContext, this.chG.aeM(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS, this.chF);
    }

    private boolean al(Context context, String str) {
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

    private boolean an(Context context, String str) {
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
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "打开失败").jR(3).showToast();
            }
        } else {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "打开失败").jR(3).showToast();
        }
        return false;
    }

    private void aNd() {
        if (ak.isAppInstalled(this.mContext, this.chG.name)) {
            this.dAV = dAE;
            an(this.mContext, this.chG.name);
            this.chA.jQ("appinstallopen");
            return;
        }
        if (this.chH == SwanAdDownloadState.NOT_START || this.chH == SwanAdDownloadState.DELETED) {
            this.dAV = dAA;
            com.baidu.swan.apps.t.a.asq().a(this.mContext, this.chG.aeM(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.chF);
        }
        if (this.chH == SwanAdDownloadState.DOWNLOADING) {
            com.baidu.swan.apps.t.a.asq().a(this.mContext, this.chG.aeM(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.chF);
        }
        if (this.chH == SwanAdDownloadState.DOWNLOAD_PAUSED) {
            this.dAW = dAH;
            com.baidu.swan.apps.t.a.asq().a(this.mContext, this.chG.aeM(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.chF);
        }
        if (this.chH == SwanAdDownloadState.DOWNLOAD_FAILED) {
            com.baidu.swan.apps.t.a.asq().a(this.mContext, this.chG.aeM(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.chF);
        }
        if (this.chH == SwanAdDownloadState.DOWNLOADED) {
            this.dAV = dAD;
            this.chF.aeJ();
            com.baidu.swan.apps.t.a.asq().a(this.mContext, this.chG.aeM(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, this.chF);
        }
        if (this.chH == SwanAdDownloadState.INSTALLED) {
            an(this.mContext, this.chG.name);
        }
    }

    private void aNe() {
        String aMk = this.dxr.aMk();
        com.baidu.swan.apps.core.d.f abs = com.baidu.swan.apps.v.f.avu().abs();
        if (abs == null) {
            if (this.mContext != null) {
                com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                return;
            }
            return;
        }
        JSONObject aMq = this.dxr.aMq();
        com.baidu.swan.apps.model.b bU = com.baidu.swan.apps.model.b.bU(aMk, aMk);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(dAY, aMq);
        } catch (JSONException e) {
        }
        bU.setParams(jSONObject.toString());
        abs.mt("adLanding").ak(com.baidu.swan.apps.core.d.f.cwD, com.baidu.swan.apps.core.d.f.cwF).a("adLanding", bU).akS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNf() {
        if (this.dAQ != null && this.chu != null) {
            this.dAQ.gO(this.chu.isEnd() || this.chu.getCurrentPosition() / 1000 >= Math.min(this.dxr.aMg(), this.chu.getDuration() / 1000));
        }
        aNg();
        if (!this.dyM && this.dxr.getActionType() == 2 && SwanAdDownloadState.DOWNLOADING == this.chH) {
            this.chF = null;
            com.baidu.swan.apps.t.a.asq().a(this.mContext, this.chG.aeM(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.chF);
        }
        com.baidu.swan.game.ad.c.c.f(this.dxr, this.dxk);
        this.dAL = 263;
        b((com.baidu.swan.games.binding.model.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNg() {
        if (this.chu != null) {
            this.chu.pause();
            this.chu.onDestroy();
        }
        if (this.dAS != null) {
            this.mContext.unregisterReceiver(this.dAS);
            this.dAS = null;
        }
        if (this.dAK != null) {
            this.dAK.aLt();
            this.dAK.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_close));
            com.baidu.swan.games.view.a.c.removeView(this.dAK.getConvertView());
        }
        if (this.dAM != null) {
            com.baidu.swan.games.view.a.c.b(this.dAM);
            this.dAM = null;
        }
        if (this.dBb != null) {
            this.dBb.release();
            this.dBb = null;
        }
    }

    private boolean aNh() {
        if (this.dxr == null) {
            return true;
        }
        long aMl = this.dxr.aMl() * 1000;
        if (aMl == 0) {
            aMl = 1740000;
        }
        return System.currentTimeMillis() - this.dxr.getCreateTime() >= aMl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getProgress() {
        if (this.chu != null) {
            return this.chu.getCurrentPosition() / 1000;
        }
        return 0;
    }

    private void c(k kVar) {
        if (this.dAQ != null) {
            this.dAQ.onLoad();
        }
        if (kVar != null) {
            kVar.aNt();
        }
        com.baidu.swan.game.ad.e.a.aMT().ak(16, "");
    }

    private void a(k kVar, String str) {
        if (this.dAQ != null) {
            this.dAQ.onError(str);
        }
        if (kVar != null) {
            kVar.vj(str);
        }
        com.baidu.swan.game.ad.e.a.aMT().ak(17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLr() {
        if (this.chu != null && this.dAK != null && this.chu.isPlaying()) {
            this.chu.pause();
            this.dAK.aLr();
            if (this.dyM) {
                com.baidu.swan.game.ad.c.d.b(lx(getProgress()), this.dxr, this.dxk);
            } else {
                com.baidu.swan.game.ad.c.c.a(getProgress(), this.mPausePosition, this.dxr, this.dxk);
            }
            this.mPausePosition = getProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNi() {
        if (this.chu != null && this.dAK != null) {
            if ((this.dAP == null || !this.dAP.isShowing()) && !this.chu.isPlaying() && !this.dAK.aLB()) {
                this.chu.resume();
                this.dAK.aLs();
                com.baidu.swan.game.ad.c.c.e(this.dxr, this.dxk);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar, String str) {
        if (lVar != null) {
            lVar.vk(str);
        }
        if (this.dAQ != null) {
            this.dAQ.onError(str);
        }
        this.dAL = 264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNj() {
        this.dxi.b(this);
        if (com.baidu.swan.games.view.a.c.isLandScape()) {
            this.dAK = new com.baidu.swan.game.ad.d(this.mContext, this.dxr, this.dxi);
        } else {
            this.dAK = new com.baidu.swan.game.ad.e(this.mContext, this.dxr, this.dxi);
        }
        if (this.dyM) {
            this.dAK.a((a.d) this);
        }
        this.dAK.a((a.c) this);
        this.chu = this.dAK.getPlayer();
        this.chu.b(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.game.ad.e.h.6
            @Override // com.baidu.swan.apps.media.b.b
            public void a(com.baidu.swan.apps.t.b.j jVar) {
                if (h.this.dAK != null) {
                    h.this.dAK.onPrepared();
                }
                h.this.dAL = 261;
                h.this.mPausePosition = 0;
                if (h.this.dAK != null) {
                    h.this.dAK.aLq();
                }
                if (h.this.dAO != null) {
                    h.this.dAO.aNu();
                }
                if (h.this.dAS == null) {
                    h.this.dAS = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    h.this.mContext.registerReceiver(h.this.dAS, intentFilter);
                }
                if (h.this.dyM) {
                    com.baidu.swan.game.ad.c.d.a(h.this.dxr, h.this.dxk);
                    return;
                }
                com.baidu.swan.game.ad.c.c.a(h.this.dxr, h.this.dxk);
                com.baidu.swan.game.ad.c.c.e(h.this.dxr, h.this.dxk);
                com.baidu.swan.game.ad.c.c.a(h.this.dyV, h.this.dwN, h.this.dzr, h.this.dxk);
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(com.baidu.swan.apps.t.b.j jVar, int i, int i2) {
                h.this.aNg();
                h.this.a(h.this.dAO, "3010001");
                return true;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(com.baidu.swan.apps.t.b.j jVar) {
                h.this.aNc();
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
        if (this.dAM == null) {
            this.dAM = new com.baidu.swan.games.view.a() { // from class: com.baidu.swan.game.ad.e.h.7
                @Override // com.baidu.swan.games.view.a
                public void aNr() {
                    h.this.dAT = true;
                    if (h.this.dAU) {
                        h.this.aNi();
                    }
                }

                @Override // com.baidu.swan.games.view.a
                public void aNs() {
                    h.this.dAT = false;
                    h.this.aLr();
                }

                @Override // com.baidu.swan.games.view.a
                public void onViewDestroy() {
                }
            };
            com.baidu.swan.games.view.a.c.a(this.dAM);
        }
        this.dAK.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (h.this.chu != null) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                    h.this.dAU = true;
                    if (h.this.dAT) {
                        h.this.aNi();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    h.this.dAU = false;
                }
            }
        }
    }

    private com.baidu.swan.game.ad.c.b lx(int i) {
        int i2;
        com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
        bVar.dzH = String.valueOf(this.dxr.getDuration());
        bVar.dzI = String.valueOf(this.mPausePosition);
        bVar.mEndTime = String.valueOf(i);
        bVar.dzJ = this.mPausePosition == 0 ? "1" : "0";
        bVar.dzK = i == this.dxr.getDuration() ? "1" : "0";
        bVar.dzL = this.mContext.getResources().getConfiguration().orientation == 1 ? "2" : "4";
        if (this.mPausePosition == 0) {
            i2 = 1;
        } else if (this.mPausePosition == this.dxr.getDuration()) {
            i2 = 3;
        } else {
            i2 = 2;
        }
        bVar.mType = String.valueOf(i2);
        bVar.dzM = (this.mPausePosition == 0 && SwanAppNetworkUtils.isWifiNetworkConnected(this.mContext)) ? "1" : "2";
        bVar.mStatus = String.valueOf(0);
        return bVar;
    }

    public String getType() {
        return this.dyM ? "gdtvideo" : "video";
    }

    private int aNk() {
        return (this.chu == null || !this.chu.isEnd()) ? getProgress() : this.chu.getDuration() / 1000;
    }

    @Override // com.baidu.swan.game.ad.a.a.d
    public void cH(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                jSONObject.put("title", this.dxr.getTitle());
                jSONObject.put("description", this.dxr.getDescription());
                jSONObject.put("autoinstall", true);
                if (this.dBb == null) {
                    this.dBb = new g(this.mContext, this.dxr, this.dxk);
                }
                this.dBb.qv(str);
                com.baidu.swan.apps.t.a.asq().a(this.mContext, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.dBb);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void aG(View view) {
        if (this.dyM && this.dxr != null) {
            com.baidu.swan.game.ad.c.d.d(this.dxr, this.dxk);
            com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
            bVar.dzz = String.valueOf(ah.getDisplayWidth(this.mContext));
            bVar.dzA = String.valueOf(ah.getDisplayHeight(this.mContext));
            bVar.dzB = String.valueOf(ah.getDisplayWidth(this.mContext));
            bVar.dzC = String.valueOf(ah.getDisplayHeight(this.mContext));
            bVar.dzD = String.valueOf((int) view.getX());
            bVar.dzE = String.valueOf((int) view.getY());
            bVar.dzF = String.valueOf((int) view.getX());
            bVar.dzG = String.valueOf((int) view.getY());
            if (this.dxr.getActionType() == 2) {
                com.baidu.swan.game.ad.c.d.a(bVar, this.dxr, this.dxk, this);
                return;
            }
            com.baidu.swan.apps.core.d.f abs = com.baidu.swan.apps.v.f.avu().abs();
            if (abs == null) {
                if (this.mContext != null) {
                    com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                }
            } else if (this.dxr != null) {
                String a2 = com.baidu.swan.game.ad.c.d.a(this.dxr.aMk(), bVar);
                abs.mt("adLanding").ak(com.baidu.swan.apps.core.d.f.cwD, com.baidu.swan.apps.core.d.f.cwF).a("adLanding", com.baidu.swan.apps.model.b.bU(a2, a2)).akS();
            }
        }
    }
}
