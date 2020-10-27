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
public class h implements a.InterfaceC0504a, a.b, a.c, a.d {
    private com.baidu.swan.apps.media.b.a cpV;
    private com.baidu.swan.apps.adlanding.b cqb;
    private com.baidu.swan.apps.adlanding.download.a.a cqg;
    private com.baidu.swan.apps.adlanding.download.model.a cqh;
    private AdElementInfo dFO;
    public String dFk;
    private String dHO;
    private boolean dHj;
    private String dHs;
    private com.baidu.swan.game.ad.b dJh;
    private com.baidu.swan.games.view.a dJj;
    private k dJk;
    private l dJl;
    public com.baidu.swan.apps.res.widget.dialog.g dJm;
    private j dJn;
    private boolean dJo;
    private a dJp;
    private boolean dJq;
    private boolean dJw;
    private boolean dJx;
    private g dJy;
    private static String dIX = "0";
    private static String dIY = "100";
    private static String dIZ = TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY;
    private static String dJa = TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY;
    private static String dJb = TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY;
    private static String dJc = TbEnum.SystemMessage.EVENT_ID_GROUP_UPGRADE;
    private static String dJd = "1";
    private static String dJe = "0";
    private static String dJf = "status";
    private static String dJg = "isPaused";
    private static String KEY_TOKEN = "token";
    private static String dJv = "monitors";
    private int dJi = 256;
    private int mPausePosition = 0;
    private boolean dJr = true;
    private String dJs = dIZ;
    private String dJt = dJe;
    private Map<String, String> dJu = new HashMap();
    private SwanAdDownloadState cqi = SwanAdDownloadState.NOT_START;
    private Context mContext = AppRuntime.getAppContext();
    private b dFH = new b(this.mContext);
    private com.baidu.swan.game.ad.jsbridge.a dFF = new com.baidu.swan.game.ad.jsbridge.a();
    private boolean dFG = com.baidu.swan.game.ad.d.f.aOL();

    public h(String str, String str2, boolean z) {
        this.dFk = "";
        this.dHs = str;
        this.dFk = str2;
        this.dHj = z;
        this.dJx = z;
    }

    public void a(j jVar) {
        this.dJn = jVar;
    }

    public synchronized void b(com.baidu.swan.games.binding.model.c cVar) {
        com.baidu.swan.game.ad.b.d fVar;
        k d = k.d(cVar);
        if (this.dJi == 257) {
            com.baidu.swan.game.ad.e.a.aON().a(d);
        } else if (this.dJi == 261 || this.dJi == 260 || this.dJi == 265) {
            a(d, "3010006");
        } else {
            if (this.dJi == 258) {
                if (aPb()) {
                    this.dJi = AuthorityState.STATE_INIT_ING;
                } else {
                    c(d);
                }
            }
            if (this.dJi == 259 || this.dJi == 262 || this.dJi == 263 || this.dJi == 264 || this.dJi == 256 || this.dJi == 272) {
                com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
                String str = "";
                if (aEU != null) {
                    str = aEU.getAppKey();
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.dHs) || TextUtils.isEmpty(this.dFk)) {
                    a(d, "3010007");
                } else {
                    this.dJk = d;
                    this.dJi = 257;
                    com.baidu.swan.game.ad.b.b aOv = new b.a().vu(this.dHs).vv(this.dFk).vw(str).lF(ah.getDisplayWidth(this.mContext)).lG(ah.getDisplayHeight(this.mContext)).lH(1).aOv();
                    if (this.dJx) {
                        this.dHj = true;
                        fVar = new com.baidu.swan.game.ad.b.e(this.mContext, aOv, 5, 5);
                        com.baidu.swan.games.view.a.b.dn("gdtvideo", null);
                    } else {
                        this.dHj = false;
                        fVar = new com.baidu.swan.game.ad.b.f(this.mContext, aOv);
                        this.dHO = fVar.aOA();
                        com.baidu.swan.games.view.a.b.dn("video", null);
                    }
                    com.baidu.swan.game.ad.b.a aVar = new com.baidu.swan.game.ad.b.a(this.mContext, this.dHj);
                    aVar.a(this);
                    aVar.a(fVar, this.dFH);
                }
            }
        }
    }

    public synchronized void c(com.baidu.swan.games.binding.model.c cVar) {
        final l e = l.e(cVar);
        String str = "";
        if (this.dJi == 261 || this.dJi == 260 || this.dJi == 265) {
            if (e != null) {
                e.vD("3010004");
            }
            if (this.dJn != null) {
                this.dJn.onError("3010004");
            }
        } else if (this.dJi != 258 || aPb()) {
            a(e, "3010004");
        } else if (this.dFO != null && TextUtils.isEmpty(this.dFO.getVideoUrl())) {
            a(e, "3010008");
        } else if (this.dJi == 258) {
            this.dJi = 265;
            if (this.dFO != null) {
                str = this.dFO.aOc();
            }
            if (com.baidu.swan.games.view.a.c.isLandScape() && (com.baidu.swan.games.view.a.c.aVK() || !TextUtils.isEmpty(str))) {
                SwanAppActivity awY = com.baidu.swan.apps.v.f.axo().awY();
                if (awY != null) {
                    awY.setRequestedOrientation(1);
                }
                com.baidu.swan.apps.v.f.axo().axs().hx(true);
            }
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.h.1
                @Override // java.lang.Runnable
                public void run() {
                    h.this.aPd();
                    if (com.baidu.swan.games.view.a.c.aJ(h.this.dJh.getConvertView())) {
                        com.baidu.swan.games.view.a.c.removeView(h.this.dJh.getConvertView());
                    }
                    if (!com.baidu.swan.games.view.a.c.c(h.this.dJh.getConvertView(), com.baidu.swan.apps.model.a.a.a.azE())) {
                        h.this.a(e, "3010000");
                        return;
                    }
                    h.this.dJl = e;
                    h.this.dJi = 260;
                    h.this.dJh.bs(h.this.dFO.getVideoUrl());
                }
            });
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void a(AdElementInfo adElementInfo) {
        this.dFO = adElementInfo;
        this.dHj = this.dFO.aOm();
        this.dJi = 258;
        c(this.dJk);
        if (!this.dHj && this.dFO.getActionType() == 2) {
            initDownload();
        }
        com.baidu.swan.games.view.a.b.dn(getType(), "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void vo(String str) {
        this.dJi = 259;
        a(this.dJk, str);
        com.baidu.swan.games.view.a.b.ac(getType(), "fail", str);
    }

    private void aOV() {
        com.baidu.swan.games.view.a.b.g(getType(), "pageclose", this.cpV.getDuration() / 1000);
        aOZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOW() {
        if (this.cpV != null && this.dJh != null) {
            if (this.cpV.isPlaying()) {
                this.cpV.pause();
                this.dJh.aNl();
            }
            this.dJi = 262;
            if (this.dHj) {
                com.baidu.swan.game.ad.c.d.b(lI(this.dFO.getDuration()), this.dFO, this.dFH);
            } else {
                com.baidu.swan.game.ad.c.c.a(getProgress(), this.mPausePosition, this.dFO, this.dFH);
            }
            if (this.dJh != null) {
                if (this.cpV.isEnd()) {
                    this.dJh.aNo();
                } else {
                    this.dJh.aNp();
                }
            }
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.c
    public void aF(View view) {
        SwanAppActivity awY;
        int i;
        int i2;
        int i3;
        String format;
        if (this.cpV != null && this.dFO != null && (awY = com.baidu.swan.apps.v.f.axo().awY()) != null && !this.dJo) {
            if (view != null && c.e.close_ad != view.getId()) {
                aOV();
                return;
            }
            int currentPosition = this.cpV.getCurrentPosition() / 1000;
            int min = Math.min(this.dFO.aOa(), this.cpV.getDuration() / 1000);
            if (currentPosition >= min) {
                aOW();
                return;
            }
            int aVI = com.baidu.swan.games.view.a.c.aVI();
            int aVJ = com.baidu.swan.games.view.a.c.aVJ();
            if (com.baidu.swan.games.view.a.c.isLandScape()) {
                i = (int) (aVI * 0.275f);
                i2 = (int) (aVI * 0.275f);
                i3 = (int) (0.05f * aVJ);
            } else {
                int min2 = Math.min(aVI, aVJ);
                i = (int) (min2 * 0.1f);
                i2 = (int) (min2 * 0.1f);
                i3 = 0;
            }
            aNl();
            com.baidu.swan.games.view.a.b.g(getType(), "pageshow", getProgress());
            this.mContext.getResources().getString(c.g.swangame_game_ad_dialog_msg_more);
            if (this.dFG) {
                format = String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_reward_msg_time_tip), Integer.valueOf(15 - (this.cpV.getCurrentPosition() / 1000)));
            } else {
                format = String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_video_close_alert), Integer.valueOf(min - currentPosition));
            }
            this.dJo = true;
            this.dJm = new g.a(awY).gg(true).d(c.g.ad_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.e.h.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    if (!h.this.dFG || h.this.dJh == null) {
                        h.this.aOZ();
                    } else {
                        if (h.this.cpV != null) {
                            h.this.cpV.pause();
                        }
                        if (h.this.dJp != null) {
                            h.this.mContext.unregisterReceiver(h.this.dJp);
                            h.this.dJp = null;
                        }
                        h.this.dJi = 262;
                        h.this.dJh.aNp();
                    }
                    h.this.dJo = false;
                    com.baidu.swan.games.view.a.b.g(h.this.getType(), "close", h.this.getProgress());
                }
            }).rD(format).c(c.g.ad_continue_watch, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.e.h.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    h.this.aPc();
                    h.this.dJo = false;
                    com.baidu.swan.games.view.a.b.g(h.this.getType(), "continue", h.this.getProgress());
                }
            }).jR(c.b.aiapps_game_continue_watch).c(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.game.ad.e.h.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    h.this.dJo = false;
                }
            }).a(new com.baidu.swan.apps.view.c.a()).n(i, 0, i2, i3).aEB();
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.d
    public void aG(View view) {
        com.baidu.swan.games.view.a.b.g(getType(), "click", aPe());
        if (this.dHj) {
            aH(view);
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0504a
    public void a(CommandType commandType, Uri uri) {
        String aOe = this.dFO.aOe();
        String packageName = this.dFO.getPackageName();
        switch (commandType) {
            case ACTION_URL:
                if (this.dFO.getActionType() == 2) {
                    aOX();
                    break;
                } else {
                    aOY();
                    break;
                }
            case OPEN_APP:
                if (this.dFO != null) {
                    ao(this.mContext, packageName);
                    break;
                }
                break;
            case GET_DOWNLOAD_STATUS:
                if (this.dFF != null) {
                    if (am(this.mContext, packageName)) {
                        this.dJs = dJb;
                    }
                    String queryParameter = uri.getQueryParameter(KEY_TOKEN);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(dJf, this.dJs);
                        jSONObject.put(dJg, this.dJt);
                        this.dFF.cP(queryParameter, jSONObject.toString());
                        break;
                    } catch (JSONException e) {
                        break;
                    }
                } else {
                    return;
                }
            case PAUSE_DOWNLOAD:
                this.dJt = dJd;
                aOX();
                break;
            case BANNER_VIEW:
                com.baidu.swan.apps.core.d.f adm = com.baidu.swan.apps.v.f.axo().adm();
                if (adm == null) {
                    if (this.mContext != null) {
                        com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                        return;
                    }
                    return;
                }
                adm.mM("adLanding").al(com.baidu.swan.apps.core.d.f.cEZ, com.baidu.swan.apps.core.d.f.cFb).a("adLanding", com.baidu.swan.apps.model.b.cb(aOe, aOe)).amM();
                break;
        }
        com.baidu.swan.game.ad.c.c.d(this.dFO, this.dFH);
        com.baidu.swan.games.view.a.b.g(getType(), "click", aPe());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SwanAdDownloadState swanAdDownloadState) {
        this.cqi = swanAdDownloadState;
        if (swanAdDownloadState == SwanAdDownloadState.NOT_START) {
            this.dJs = dIZ;
            this.dJt = dJe;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
            this.dJs = dIX;
            this.dJt = dJd;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
            this.dJs = dJa;
            this.dJt = dJe;
        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
            this.dJs = dJb;
            this.dJt = dJe;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
            this.dJs = dIX;
            this.dJt = dJe;
        }
    }

    private void initDownload() {
        this.cqb = new com.baidu.swan.apps.adlanding.b(this.mContext, this.dFO.aOk());
        this.cqg = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.game.ad.e.h.5
            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void eh(boolean z) {
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void km(String str) {
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                if (!h.this.dJw) {
                    h.this.d(swanAdDownloadState);
                }
                h.this.dJw = true;
                if (h.this.cqi != swanAdDownloadState) {
                    if (h.this.cqi == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                        h.this.dJt = h.dJe;
                        h.this.cqb.kj("appdownloadbegin");
                    } else if (swanAdDownloadState != SwanAdDownloadState.DOWNLOAD_PAUSED) {
                        if (h.this.cqi == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            h.this.dJt = h.dJe;
                            h.this.cqb.kj("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            h.this.dJt = h.dJe;
                            h.this.dJs = h.dJa;
                            h.this.cqb.kj("appdownloadfinish");
                            h.this.cqb.kj("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            h.this.dJt = h.dJe;
                            h.this.dJs = h.dJb;
                            h.this.cqb.kj("appinstallfinish");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_FAILED) {
                            h.this.dJt = h.dJe;
                            h.this.dJs = h.dJc;
                        } else if (swanAdDownloadState == SwanAdDownloadState.DELETED) {
                            h.this.dJt = h.dJe;
                            h.this.dJs = h.dIZ;
                        }
                    } else {
                        h.this.dJt = h.dJd;
                        h.this.cqb.kj("appdownloadpause");
                    }
                    h.this.cqi = swanAdDownloadState;
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                if (i != 0) {
                    if (i != 100 || h.this.dJs == h.dIZ) {
                        if (h.this.dJs != h.dIZ && h.this.dJs != h.dJc) {
                            h.this.dJs = String.valueOf(i);
                            return;
                        }
                        return;
                    }
                    h.this.dJs = h.dJa;
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void agD() {
                h.this.cqb.kj("appinstallbegin");
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public String agE() {
                h.this.cqb.kj("appinstallopen");
                return "";
            }
        };
        String aOe = this.dFO.aOe();
        String packageName = this.dFO.getPackageName();
        String str = this.dJu.get(packageName);
        if (str == null) {
            this.dJu.put(packageName, aOe);
            str = aOe;
        }
        this.cqh = new com.baidu.swan.apps.adlanding.download.model.a(str, packageName, this.dFO.getTitle());
        this.dJw = false;
        com.baidu.swan.apps.t.a.auk().a(this.mContext, this.cqh.agG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS, this.cqg);
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
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "打开失败").kc(3).showToast();
            }
        } else {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "打开失败").kc(3).showToast();
        }
        return false;
    }

    private void aOX() {
        if (ak.isAppInstalled(this.mContext, this.cqh.name)) {
            this.dJs = dJb;
            ao(this.mContext, this.cqh.name);
            this.cqb.kj("appinstallopen");
            return;
        }
        if (this.cqi == SwanAdDownloadState.NOT_START || this.cqi == SwanAdDownloadState.DELETED) {
            this.dJs = dIX;
            com.baidu.swan.apps.t.a.auk().a(this.mContext, this.cqh.agG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.cqg);
        }
        if (this.cqi == SwanAdDownloadState.DOWNLOADING) {
            com.baidu.swan.apps.t.a.auk().a(this.mContext, this.cqh.agG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.cqg);
        }
        if (this.cqi == SwanAdDownloadState.DOWNLOAD_PAUSED) {
            this.dJt = dJe;
            com.baidu.swan.apps.t.a.auk().a(this.mContext, this.cqh.agG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.cqg);
        }
        if (this.cqi == SwanAdDownloadState.DOWNLOAD_FAILED) {
            com.baidu.swan.apps.t.a.auk().a(this.mContext, this.cqh.agG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.cqg);
        }
        if (this.cqi == SwanAdDownloadState.DOWNLOADED) {
            this.dJs = dJa;
            this.cqg.agD();
            com.baidu.swan.apps.t.a.auk().a(this.mContext, this.cqh.agG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, this.cqg);
        }
        if (this.cqi == SwanAdDownloadState.INSTALLED) {
            ao(this.mContext, this.cqh.name);
        }
    }

    private void aOY() {
        String aOe = this.dFO.aOe();
        com.baidu.swan.apps.core.d.f adm = com.baidu.swan.apps.v.f.axo().adm();
        if (adm == null) {
            if (this.mContext != null) {
                com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                return;
            }
            return;
        }
        JSONObject aOk = this.dFO.aOk();
        com.baidu.swan.apps.model.b cb = com.baidu.swan.apps.model.b.cb(aOe, aOe);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(dJv, aOk);
        } catch (JSONException e) {
        }
        cb.setParams(jSONObject.toString());
        adm.mM("adLanding").al(com.baidu.swan.apps.core.d.f.cEZ, com.baidu.swan.apps.core.d.f.cFb).a("adLanding", cb).amM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOZ() {
        if (this.dJn != null && this.cpV != null) {
            this.dJn.hb(this.cpV.isEnd() || this.cpV.getCurrentPosition() / 1000 >= Math.min(this.dFO.aOa(), this.cpV.getDuration() / 1000));
        }
        aPa();
        if (!this.dHj && this.dFO.getActionType() == 2 && SwanAdDownloadState.DOWNLOADING == this.cqi) {
            this.cqg = null;
            com.baidu.swan.apps.t.a.auk().a(this.mContext, this.cqh.agG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.cqg);
        }
        com.baidu.swan.game.ad.c.c.f(this.dFO, this.dFH);
        this.dJi = 263;
        b((com.baidu.swan.games.binding.model.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPa() {
        if (this.cpV != null) {
            this.cpV.pause();
            this.cpV.onDestroy();
        }
        if (this.dJp != null) {
            this.mContext.unregisterReceiver(this.dJp);
            this.dJp = null;
        }
        if (this.dJh != null) {
            this.dJh.aNn();
            this.dJh.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_close));
            com.baidu.swan.games.view.a.c.removeView(this.dJh.getConvertView());
        }
        if (this.dJj != null) {
            com.baidu.swan.games.view.a.c.b(this.dJj);
            this.dJj = null;
        }
        if (this.dJy != null) {
            this.dJy.release();
            this.dJy = null;
        }
    }

    private boolean aPb() {
        if (this.dFO == null) {
            return true;
        }
        long aOf = this.dFO.aOf() * 1000;
        if (aOf == 0) {
            aOf = 1740000;
        }
        return System.currentTimeMillis() - this.dFO.getCreateTime() >= aOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getProgress() {
        if (this.cpV != null) {
            return this.cpV.getCurrentPosition() / 1000;
        }
        return 0;
    }

    private void c(k kVar) {
        if (this.dJn != null) {
            this.dJn.onLoad();
        }
        if (kVar != null) {
            kVar.aPn();
        }
        com.baidu.swan.game.ad.e.a.aON().am(16, "");
    }

    private void a(k kVar, String str) {
        if (this.dJn != null) {
            this.dJn.onError(str);
        }
        if (kVar != null) {
            kVar.vC(str);
        }
        com.baidu.swan.game.ad.e.a.aON().am(17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNl() {
        if (this.cpV != null && this.dJh != null && this.cpV.isPlaying()) {
            this.cpV.pause();
            this.dJh.aNl();
            if (this.dHj) {
                com.baidu.swan.game.ad.c.d.b(lI(getProgress()), this.dFO, this.dFH);
            } else {
                com.baidu.swan.game.ad.c.c.a(getProgress(), this.mPausePosition, this.dFO, this.dFH);
            }
            this.mPausePosition = getProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPc() {
        if (this.cpV != null && this.dJh != null) {
            if ((this.dJm == null || !this.dJm.isShowing()) && !this.cpV.isPlaying() && !this.dJh.aNv()) {
                this.cpV.resume();
                this.dJh.aNm();
                com.baidu.swan.game.ad.c.c.e(this.dFO, this.dFH);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar, String str) {
        if (lVar != null) {
            lVar.vD(str);
        }
        if (this.dJn != null) {
            this.dJn.onError(str);
        }
        this.dJi = 264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPd() {
        this.dFF.b(this);
        if (com.baidu.swan.games.view.a.c.isLandScape()) {
            this.dJh = new com.baidu.swan.game.ad.d(this.mContext, this.dFO, this.dFF);
        } else {
            this.dJh = new com.baidu.swan.game.ad.e(this.mContext, this.dFO, this.dFF);
        }
        if (this.dHj) {
            this.dJh.a((a.d) this);
        }
        this.dJh.a((a.c) this);
        this.cpV = this.dJh.getPlayer();
        this.cpV.b(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.game.ad.e.h.6
            @Override // com.baidu.swan.apps.media.b.b
            public void a(com.baidu.swan.apps.t.b.j jVar) {
                if (h.this.dJh != null) {
                    h.this.dJh.onPrepared();
                }
                h.this.dJi = 261;
                h.this.mPausePosition = 0;
                if (h.this.dJh != null) {
                    h.this.dJh.aNk();
                }
                if (h.this.dJl != null) {
                    h.this.dJl.aPo();
                }
                if (h.this.dJp == null) {
                    h.this.dJp = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    h.this.mContext.registerReceiver(h.this.dJp, intentFilter);
                }
                if (h.this.dHj) {
                    com.baidu.swan.game.ad.c.d.a(h.this.dFO, h.this.dFH);
                    return;
                }
                com.baidu.swan.game.ad.c.c.a(h.this.dFO, h.this.dFH);
                com.baidu.swan.game.ad.c.c.e(h.this.dFO, h.this.dFH);
                com.baidu.swan.game.ad.c.c.a(h.this.dHs, h.this.dFk, h.this.dHO, h.this.dFH);
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(com.baidu.swan.apps.t.b.j jVar, int i, int i2) {
                h.this.aPa();
                h.this.a(h.this.dJl, "3010001");
                return true;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(com.baidu.swan.apps.t.b.j jVar) {
                h.this.aOW();
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
        if (this.dJj == null) {
            this.dJj = new com.baidu.swan.games.view.a() { // from class: com.baidu.swan.game.ad.e.h.7
                @Override // com.baidu.swan.games.view.a
                public void aPl() {
                    h.this.dJq = true;
                    if (h.this.dJr) {
                        h.this.aPc();
                    }
                }

                @Override // com.baidu.swan.games.view.a
                public void aPm() {
                    h.this.dJq = false;
                    h.this.aNl();
                }

                @Override // com.baidu.swan.games.view.a
                public void onViewDestroy() {
                }
            };
            com.baidu.swan.games.view.a.c.a(this.dJj);
        }
        this.dJh.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (h.this.cpV != null) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                    h.this.dJr = true;
                    if (h.this.dJq) {
                        h.this.aPc();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    h.this.dJr = false;
                }
            }
        }
    }

    private com.baidu.swan.game.ad.c.b lI(int i) {
        int i2;
        com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
        bVar.dIe = String.valueOf(this.dFO.getDuration());
        bVar.dIf = String.valueOf(this.mPausePosition);
        bVar.mEndTime = String.valueOf(i);
        bVar.dIg = this.mPausePosition == 0 ? "1" : "0";
        bVar.dIh = i == this.dFO.getDuration() ? "1" : "0";
        bVar.dIi = this.mContext.getResources().getConfiguration().orientation == 1 ? "2" : "4";
        if (this.mPausePosition == 0) {
            i2 = 1;
        } else if (this.mPausePosition == this.dFO.getDuration()) {
            i2 = 3;
        } else {
            i2 = 2;
        }
        bVar.mType = String.valueOf(i2);
        bVar.dIj = (this.mPausePosition == 0 && SwanAppNetworkUtils.isWifiNetworkConnected(this.mContext)) ? "1" : "2";
        bVar.mStatus = String.valueOf(0);
        return bVar;
    }

    public String getType() {
        return this.dHj ? "gdtvideo" : "video";
    }

    private int aPe() {
        return (this.cpV == null || !this.cpV.isEnd()) ? getProgress() : this.cpV.getDuration() / 1000;
    }

    @Override // com.baidu.swan.game.ad.a.a.d
    public void cO(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                jSONObject.put("title", this.dFO.getTitle());
                jSONObject.put("description", this.dFO.getDescription());
                jSONObject.put("autoinstall", true);
                if (this.dJy == null) {
                    this.dJy = new g(this.mContext, this.dFO, this.dFH);
                }
                this.dJy.qO(str);
                com.baidu.swan.apps.t.a.auk().a(this.mContext, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.dJy);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void aH(View view) {
        if (this.dHj && this.dFO != null) {
            com.baidu.swan.game.ad.c.d.d(this.dFO, this.dFH);
            com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
            bVar.dHW = String.valueOf(ah.getDisplayWidth(this.mContext));
            bVar.dHX = String.valueOf(ah.getDisplayHeight(this.mContext));
            bVar.dHY = String.valueOf(ah.getDisplayWidth(this.mContext));
            bVar.dHZ = String.valueOf(ah.getDisplayHeight(this.mContext));
            bVar.dIa = String.valueOf((int) view.getX());
            bVar.dIb = String.valueOf((int) view.getY());
            bVar.dIc = String.valueOf((int) view.getX());
            bVar.dId = String.valueOf((int) view.getY());
            if (this.dFO.getActionType() == 2) {
                com.baidu.swan.game.ad.c.d.a(bVar, this.dFO, this.dFH, this);
                return;
            }
            com.baidu.swan.apps.core.d.f adm = com.baidu.swan.apps.v.f.axo().adm();
            if (adm == null) {
                if (this.mContext != null) {
                    com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                }
            } else if (this.dFO != null) {
                String a2 = com.baidu.swan.game.ad.c.d.a(this.dFO.aOe(), bVar);
                adm.mM("adLanding").al(com.baidu.swan.apps.core.d.f.cEZ, com.baidu.swan.apps.core.d.f.cFb).a("adLanding", com.baidu.swan.apps.model.b.cb(a2, a2)).amM();
            }
        }
    }
}
