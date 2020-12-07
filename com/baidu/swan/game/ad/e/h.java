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
public class h implements a.InterfaceC0526a, a.b, a.c, a.d {
    private com.baidu.swan.apps.media.b.a cBb;
    private com.baidu.swan.apps.adlanding.b cBh;
    private com.baidu.swan.apps.adlanding.download.a.a cBm;
    private com.baidu.swan.apps.adlanding.download.model.a cBn;
    private AdElementInfo dQW;
    public String dQs;
    private String dSV;
    private boolean dSq;
    private String dSz;
    private boolean dUE;
    private boolean dUF;
    private g dUG;
    private com.baidu.swan.game.ad.b dUp;
    private com.baidu.swan.games.view.a dUr;
    private k dUs;
    private l dUt;
    public com.baidu.swan.apps.res.widget.dialog.g dUu;
    private j dUv;
    private boolean dUw;
    private a dUx;
    private boolean dUy;
    private static String dUf = "0";
    private static String dUg = "100";
    private static String dUh = TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY;
    private static String dUi = TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY;
    private static String dUj = TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY;
    private static String dUk = TbEnum.SystemMessage.EVENT_ID_GROUP_UPGRADE;
    private static String dUl = "1";
    private static String dUm = "0";
    private static String dUn = "status";
    private static String dUo = "isPaused";
    private static String KEY_TOKEN = "token";
    private static String dUD = "monitors";
    private int dUq = 256;
    private int mPausePosition = 0;
    private boolean dUz = true;
    private String dUA = dUh;
    private String dUB = dUm;
    private Map<String, String> dUC = new HashMap();
    private SwanAdDownloadState cBo = SwanAdDownloadState.NOT_START;
    private Context mContext = AppRuntime.getAppContext();
    private b dQP = new b(this.mContext);
    private com.baidu.swan.game.ad.jsbridge.a dQN = new com.baidu.swan.game.ad.jsbridge.a();
    private boolean dQO = com.baidu.swan.game.ad.d.f.aTI();

    public h(String str, String str2, boolean z) {
        this.dQs = "";
        this.dSz = str;
        this.dQs = str2;
        this.dSq = z;
        this.dUF = z;
    }

    public void a(j jVar) {
        this.dUv = jVar;
    }

    public synchronized void b(com.baidu.swan.games.binding.model.c cVar) {
        com.baidu.swan.game.ad.b.d fVar;
        k d = k.d(cVar);
        if (this.dUq == 257) {
            com.baidu.swan.game.ad.e.a.aTK().a(d);
        } else if (this.dUq == 261 || this.dUq == 260 || this.dUq == 265) {
            a(d, "3010006");
        } else {
            if (this.dUq == 258) {
                if (aTY()) {
                    this.dUq = AuthorityState.STATE_INIT_ING;
                } else {
                    c(d);
                }
            }
            if (this.dUq == 259 || this.dUq == 262 || this.dUq == 263 || this.dUq == 264 || this.dUq == 256 || this.dUq == 272) {
                com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
                String str = "";
                if (aJU != null) {
                    str = aJU.getAppKey();
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.dSz) || TextUtils.isEmpty(this.dQs)) {
                    a(d, "3010007");
                } else {
                    this.dUs = d;
                    this.dUq = 257;
                    com.baidu.swan.game.ad.b.b aTs = new b.a().wk(this.dSz).wl(this.dQs).wm(str).mj(ah.getDisplayWidth(this.mContext)).mk(ah.getDisplayHeight(this.mContext)).ml(1).aTs();
                    if (this.dUF) {
                        this.dSq = true;
                        fVar = new com.baidu.swan.game.ad.b.e(this.mContext, aTs, 5, 5);
                        com.baidu.swan.games.view.a.b.dt("gdtvideo", null);
                    } else {
                        this.dSq = false;
                        fVar = new com.baidu.swan.game.ad.b.f(this.mContext, aTs);
                        this.dSV = fVar.aTx();
                        com.baidu.swan.games.view.a.b.dt("video", null);
                    }
                    com.baidu.swan.game.ad.b.a aVar = new com.baidu.swan.game.ad.b.a(this.mContext, this.dSq);
                    aVar.a(this);
                    aVar.a(fVar, this.dQP);
                }
            }
        }
    }

    public synchronized void c(com.baidu.swan.games.binding.model.c cVar) {
        final l e = l.e(cVar);
        String str = "";
        if (this.dUq == 261 || this.dUq == 260 || this.dUq == 265) {
            if (e != null) {
                e.wt("3010004");
            }
            if (this.dUv != null) {
                this.dUv.onError("3010004");
            }
        } else if (this.dUq != 258 || aTY()) {
            a(e, "3010004");
        } else if (this.dQW != null && TextUtils.isEmpty(this.dQW.getVideoUrl())) {
            a(e, "3010008");
        } else if (this.dUq == 258) {
            this.dUq = 265;
            if (this.dQW != null) {
                str = this.dQW.aSZ();
            }
            if (com.baidu.swan.games.view.a.c.isLandScape() && (com.baidu.swan.games.view.a.c.baH() || !TextUtils.isEmpty(str))) {
                SwanAppActivity aBZ = com.baidu.swan.apps.v.f.aCp().aBZ();
                if (aBZ != null) {
                    aBZ.setRequestedOrientation(1);
                }
                com.baidu.swan.apps.v.f.aCp().aCt().hY(true);
            }
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.h.1
                @Override // java.lang.Runnable
                public void run() {
                    h.this.aUa();
                    if (com.baidu.swan.games.view.a.c.aP(h.this.dUp.getConvertView())) {
                        com.baidu.swan.games.view.a.c.removeView(h.this.dUp.getConvertView());
                    }
                    if (!com.baidu.swan.games.view.a.c.c(h.this.dUp.getConvertView(), com.baidu.swan.apps.model.a.a.a.aEF())) {
                        h.this.a(e, "3010000");
                        return;
                    }
                    h.this.dUt = e;
                    h.this.dUq = 260;
                    h.this.dUp.bv(h.this.dQW.getVideoUrl());
                }
            });
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void a(AdElementInfo adElementInfo) {
        this.dQW = adElementInfo;
        this.dSq = this.dQW.aTj();
        this.dUq = 258;
        c(this.dUs);
        if (!this.dSq && this.dQW.getActionType() == 2) {
            initDownload();
        }
        com.baidu.swan.games.view.a.b.dt(getType(), "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void we(String str) {
        this.dUq = 259;
        a(this.dUs, str);
        com.baidu.swan.games.view.a.b.af(getType(), "fail", str);
    }

    private void aTS() {
        com.baidu.swan.games.view.a.b.g(getType(), "pageclose", this.cBb.getDuration() / 1000);
        aTW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTT() {
        if (this.cBb != null && this.dUp != null) {
            if (this.cBb.isPlaying()) {
                this.cBb.pause();
                this.dUp.aSi();
            }
            this.dUq = 262;
            if (this.dSq) {
                com.baidu.swan.game.ad.c.d.b(mm(this.dQW.getDuration()), this.dQW, this.dQP);
            } else {
                com.baidu.swan.game.ad.c.c.a(getProgress(), this.mPausePosition, this.dQW, this.dQP);
            }
            if (this.dUp != null) {
                if (this.cBb.isEnd()) {
                    this.dUp.aSl();
                } else {
                    this.dUp.aSm();
                }
            }
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.c
    public void aL(View view) {
        SwanAppActivity aBZ;
        int i;
        int i2;
        int i3;
        String format;
        if (this.cBb != null && this.dQW != null && (aBZ = com.baidu.swan.apps.v.f.aCp().aBZ()) != null && !this.dUw) {
            if (view != null && c.e.close_ad != view.getId()) {
                aTS();
                return;
            }
            int currentPosition = this.cBb.getCurrentPosition() / 1000;
            int min = Math.min(this.dQW.aSX(), this.cBb.getDuration() / 1000);
            if (currentPosition >= min) {
                aTT();
                return;
            }
            int baF = com.baidu.swan.games.view.a.c.baF();
            int baG = com.baidu.swan.games.view.a.c.baG();
            if (com.baidu.swan.games.view.a.c.isLandScape()) {
                i = (int) (baF * 0.275f);
                i2 = (int) (baF * 0.275f);
                i3 = (int) (0.05f * baG);
            } else {
                int min2 = Math.min(baF, baG);
                i = (int) (min2 * 0.1f);
                i2 = (int) (min2 * 0.1f);
                i3 = 0;
            }
            aSi();
            com.baidu.swan.games.view.a.b.g(getType(), "pageshow", getProgress());
            this.mContext.getResources().getString(c.g.swangame_game_ad_dialog_msg_more);
            if (this.dQO) {
                format = String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_reward_msg_time_tip), Integer.valueOf(15 - (this.cBb.getCurrentPosition() / 1000)));
            } else {
                format = String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_video_close_alert), Integer.valueOf(min - currentPosition));
            }
            this.dUw = true;
            this.dUu = new g.a(aBZ).gH(true).d(c.g.ad_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.e.h.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    if (!h.this.dQO || h.this.dUp == null) {
                        h.this.aTW();
                    } else {
                        if (h.this.cBb != null) {
                            h.this.cBb.pause();
                        }
                        if (h.this.dUx != null) {
                            h.this.mContext.unregisterReceiver(h.this.dUx);
                            h.this.dUx = null;
                        }
                        h.this.dUq = 262;
                        h.this.dUp.aSm();
                    }
                    h.this.dUw = false;
                    com.baidu.swan.games.view.a.b.g(h.this.getType(), "close", h.this.getProgress());
                }
            }).st(format).c(c.g.ad_continue_watch, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.e.h.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    h.this.aTZ();
                    h.this.dUw = false;
                    com.baidu.swan.games.view.a.b.g(h.this.getType(), "continue", h.this.getProgress());
                }
            }).kv(c.b.aiapps_game_continue_watch).c(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.game.ad.e.h.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    h.this.dUw = false;
                }
            }).a(new com.baidu.swan.apps.view.c.a()).q(i, 0, i2, i3).aJB();
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.d
    public void aM(View view) {
        com.baidu.swan.games.view.a.b.g(getType(), "click", aUb());
        if (this.dSq) {
            aN(view);
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0526a
    public void a(CommandType commandType, Uri uri) {
        String aTb = this.dQW.aTb();
        String packageName = this.dQW.getPackageName();
        switch (commandType) {
            case ACTION_URL:
                if (this.dQW.getActionType() == 2) {
                    aTU();
                    break;
                } else {
                    aTV();
                    break;
                }
            case OPEN_APP:
                if (this.dQW != null) {
                    ao(this.mContext, packageName);
                    break;
                }
                break;
            case GET_DOWNLOAD_STATUS:
                if (this.dQN != null) {
                    if (am(this.mContext, packageName)) {
                        this.dUA = dUj;
                    }
                    String queryParameter = uri.getQueryParameter(KEY_TOKEN);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(dUn, this.dUA);
                        jSONObject.put(dUo, this.dUB);
                        this.dQN.cV(queryParameter, jSONObject.toString());
                        break;
                    } catch (JSONException e) {
                        break;
                    }
                } else {
                    return;
                }
            case PAUSE_DOWNLOAD:
                this.dUB = dUl;
                aTU();
                break;
            case BANNER_VIEW:
                com.baidu.swan.apps.core.d.f aim = com.baidu.swan.apps.v.f.aCp().aim();
                if (aim == null) {
                    if (this.mContext != null) {
                        com.baidu.swan.apps.res.widget.b.d.t(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                        return;
                    }
                    return;
                }
                aim.nC("adLanding").an(com.baidu.swan.apps.core.d.f.cQb, com.baidu.swan.apps.core.d.f.cQd).a("adLanding", com.baidu.swan.apps.model.b.ch(aTb, aTb)).arM();
                break;
        }
        com.baidu.swan.game.ad.c.c.d(this.dQW, this.dQP);
        com.baidu.swan.games.view.a.b.g(getType(), "click", aUb());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SwanAdDownloadState swanAdDownloadState) {
        this.cBo = swanAdDownloadState;
        if (swanAdDownloadState == SwanAdDownloadState.NOT_START) {
            this.dUA = dUh;
            this.dUB = dUm;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
            this.dUA = dUf;
            this.dUB = dUl;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
            this.dUA = dUi;
            this.dUB = dUm;
        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
            this.dUA = dUj;
            this.dUB = dUm;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
            this.dUA = dUf;
            this.dUB = dUm;
        }
    }

    private void initDownload() {
        this.cBh = new com.baidu.swan.apps.adlanding.b(this.mContext, this.dQW.aTh());
        this.cBm = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.game.ad.e.h.5
            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void eI(boolean z) {
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void lc(String str) {
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                if (!h.this.dUE) {
                    h.this.d(swanAdDownloadState);
                }
                h.this.dUE = true;
                if (h.this.cBo != swanAdDownloadState) {
                    if (h.this.cBo == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                        h.this.dUB = h.dUm;
                        h.this.cBh.kZ("appdownloadbegin");
                    } else if (swanAdDownloadState != SwanAdDownloadState.DOWNLOAD_PAUSED) {
                        if (h.this.cBo == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            h.this.dUB = h.dUm;
                            h.this.cBh.kZ("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            h.this.dUB = h.dUm;
                            h.this.dUA = h.dUi;
                            h.this.cBh.kZ("appdownloadfinish");
                            h.this.cBh.kZ("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            h.this.dUB = h.dUm;
                            h.this.dUA = h.dUj;
                            h.this.cBh.kZ("appinstallfinish");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_FAILED) {
                            h.this.dUB = h.dUm;
                            h.this.dUA = h.dUk;
                        } else if (swanAdDownloadState == SwanAdDownloadState.DELETED) {
                            h.this.dUB = h.dUm;
                            h.this.dUA = h.dUh;
                        }
                    } else {
                        h.this.dUB = h.dUl;
                        h.this.cBh.kZ("appdownloadpause");
                    }
                    h.this.cBo = swanAdDownloadState;
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                if (i != 0) {
                    if (i != 100 || h.this.dUA == h.dUh) {
                        if (h.this.dUA != h.dUh && h.this.dUA != h.dUk) {
                            h.this.dUA = String.valueOf(i);
                            return;
                        }
                        return;
                    }
                    h.this.dUA = h.dUi;
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void alD() {
                h.this.cBh.kZ("appinstallbegin");
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public String alE() {
                h.this.cBh.kZ("appinstallopen");
                return "";
            }
        };
        String aTb = this.dQW.aTb();
        String packageName = this.dQW.getPackageName();
        String str = this.dUC.get(packageName);
        if (str == null) {
            this.dUC.put(packageName, aTb);
            str = aTb;
        }
        this.cBn = new com.baidu.swan.apps.adlanding.download.model.a(str, packageName, this.dQW.getTitle());
        this.dUE = false;
        com.baidu.swan.apps.t.a.azk().a(this.mContext, this.cBn.alG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS, this.cBm);
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
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "打开失败").kG(3).showToast();
            }
        } else {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "打开失败").kG(3).showToast();
        }
        return false;
    }

    private void aTU() {
        if (ak.isAppInstalled(this.mContext, this.cBn.name)) {
            this.dUA = dUj;
            ao(this.mContext, this.cBn.name);
            this.cBh.kZ("appinstallopen");
            return;
        }
        if (this.cBo == SwanAdDownloadState.NOT_START || this.cBo == SwanAdDownloadState.DELETED) {
            this.dUA = dUf;
            com.baidu.swan.apps.t.a.azk().a(this.mContext, this.cBn.alG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.cBm);
        }
        if (this.cBo == SwanAdDownloadState.DOWNLOADING) {
            com.baidu.swan.apps.t.a.azk().a(this.mContext, this.cBn.alG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.cBm);
        }
        if (this.cBo == SwanAdDownloadState.DOWNLOAD_PAUSED) {
            this.dUB = dUm;
            com.baidu.swan.apps.t.a.azk().a(this.mContext, this.cBn.alG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.cBm);
        }
        if (this.cBo == SwanAdDownloadState.DOWNLOAD_FAILED) {
            com.baidu.swan.apps.t.a.azk().a(this.mContext, this.cBn.alG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.cBm);
        }
        if (this.cBo == SwanAdDownloadState.DOWNLOADED) {
            this.dUA = dUi;
            this.cBm.alD();
            com.baidu.swan.apps.t.a.azk().a(this.mContext, this.cBn.alG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, this.cBm);
        }
        if (this.cBo == SwanAdDownloadState.INSTALLED) {
            ao(this.mContext, this.cBn.name);
        }
    }

    private void aTV() {
        String aTb = this.dQW.aTb();
        com.baidu.swan.apps.core.d.f aim = com.baidu.swan.apps.v.f.aCp().aim();
        if (aim == null) {
            if (this.mContext != null) {
                com.baidu.swan.apps.res.widget.b.d.t(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                return;
            }
            return;
        }
        JSONObject aTh = this.dQW.aTh();
        com.baidu.swan.apps.model.b ch = com.baidu.swan.apps.model.b.ch(aTb, aTb);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(dUD, aTh);
        } catch (JSONException e) {
        }
        ch.setParams(jSONObject.toString());
        aim.nC("adLanding").an(com.baidu.swan.apps.core.d.f.cQb, com.baidu.swan.apps.core.d.f.cQd).a("adLanding", ch).arM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTW() {
        if (this.dUv != null && this.cBb != null) {
            this.dUv.hC(this.cBb.isEnd() || this.cBb.getCurrentPosition() / 1000 >= Math.min(this.dQW.aSX(), this.cBb.getDuration() / 1000));
        }
        aTX();
        if (!this.dSq && this.dQW.getActionType() == 2 && SwanAdDownloadState.DOWNLOADING == this.cBo) {
            this.cBm = null;
            com.baidu.swan.apps.t.a.azk().a(this.mContext, this.cBn.alG(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.cBm);
        }
        com.baidu.swan.game.ad.c.c.f(this.dQW, this.dQP);
        this.dUq = 263;
        b((com.baidu.swan.games.binding.model.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTX() {
        if (this.cBb != null) {
            this.cBb.pause();
            this.cBb.onDestroy();
        }
        if (this.dUx != null) {
            this.mContext.unregisterReceiver(this.dUx);
            this.dUx = null;
        }
        if (this.dUp != null) {
            this.dUp.aSk();
            this.dUp.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_close));
            com.baidu.swan.games.view.a.c.removeView(this.dUp.getConvertView());
        }
        if (this.dUr != null) {
            com.baidu.swan.games.view.a.c.b(this.dUr);
            this.dUr = null;
        }
        if (this.dUG != null) {
            this.dUG.release();
            this.dUG = null;
        }
    }

    private boolean aTY() {
        if (this.dQW == null) {
            return true;
        }
        long aTc = this.dQW.aTc() * 1000;
        if (aTc == 0) {
            aTc = 1740000;
        }
        return System.currentTimeMillis() - this.dQW.getCreateTime() >= aTc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getProgress() {
        if (this.cBb != null) {
            return this.cBb.getCurrentPosition() / 1000;
        }
        return 0;
    }

    private void c(k kVar) {
        if (this.dUv != null) {
            this.dUv.onLoad();
        }
        if (kVar != null) {
            kVar.aUk();
        }
        com.baidu.swan.game.ad.e.a.aTK().aq(16, "");
    }

    private void a(k kVar, String str) {
        if (this.dUv != null) {
            this.dUv.onError(str);
        }
        if (kVar != null) {
            kVar.ws(str);
        }
        com.baidu.swan.game.ad.e.a.aTK().aq(17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSi() {
        if (this.cBb != null && this.dUp != null && this.cBb.isPlaying()) {
            this.cBb.pause();
            this.dUp.aSi();
            if (this.dSq) {
                com.baidu.swan.game.ad.c.d.b(mm(getProgress()), this.dQW, this.dQP);
            } else {
                com.baidu.swan.game.ad.c.c.a(getProgress(), this.mPausePosition, this.dQW, this.dQP);
            }
            this.mPausePosition = getProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTZ() {
        if (this.cBb != null && this.dUp != null) {
            if ((this.dUu == null || !this.dUu.isShowing()) && !this.cBb.isPlaying() && !this.dUp.aSs()) {
                this.cBb.resume();
                this.dUp.aSj();
                com.baidu.swan.game.ad.c.c.e(this.dQW, this.dQP);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar, String str) {
        if (lVar != null) {
            lVar.wt(str);
        }
        if (this.dUv != null) {
            this.dUv.onError(str);
        }
        this.dUq = 264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUa() {
        this.dQN.b(this);
        if (com.baidu.swan.games.view.a.c.isLandScape()) {
            this.dUp = new com.baidu.swan.game.ad.d(this.mContext, this.dQW, this.dQN);
        } else {
            this.dUp = new com.baidu.swan.game.ad.e(this.mContext, this.dQW, this.dQN);
        }
        if (this.dSq) {
            this.dUp.a((a.d) this);
        }
        this.dUp.a((a.c) this);
        this.cBb = this.dUp.getPlayer();
        this.cBb.b(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.game.ad.e.h.6
            @Override // com.baidu.swan.apps.media.b.b
            public void a(com.baidu.swan.apps.t.b.j jVar) {
                if (h.this.dUp != null) {
                    h.this.dUp.onPrepared();
                }
                h.this.dUq = 261;
                h.this.mPausePosition = 0;
                if (h.this.dUp != null) {
                    h.this.dUp.aSh();
                }
                if (h.this.dUt != null) {
                    h.this.dUt.aUl();
                }
                if (h.this.dUx == null) {
                    h.this.dUx = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    h.this.mContext.registerReceiver(h.this.dUx, intentFilter);
                }
                if (h.this.dSq) {
                    com.baidu.swan.game.ad.c.d.a(h.this.dQW, h.this.dQP);
                    return;
                }
                com.baidu.swan.game.ad.c.c.a(h.this.dQW, h.this.dQP);
                com.baidu.swan.game.ad.c.c.e(h.this.dQW, h.this.dQP);
                com.baidu.swan.game.ad.c.c.a(h.this.dSz, h.this.dQs, h.this.dSV, h.this.dQP);
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(com.baidu.swan.apps.t.b.j jVar, int i, int i2) {
                h.this.aTX();
                h.this.a(h.this.dUt, "3010001");
                return true;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(com.baidu.swan.apps.t.b.j jVar) {
                h.this.aTT();
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
        if (this.dUr == null) {
            this.dUr = new com.baidu.swan.games.view.a() { // from class: com.baidu.swan.game.ad.e.h.7
                @Override // com.baidu.swan.games.view.a
                public void aUi() {
                    h.this.dUy = true;
                    if (h.this.dUz) {
                        h.this.aTZ();
                    }
                }

                @Override // com.baidu.swan.games.view.a
                public void aUj() {
                    h.this.dUy = false;
                    h.this.aSi();
                }

                @Override // com.baidu.swan.games.view.a
                public void onViewDestroy() {
                }
            };
            com.baidu.swan.games.view.a.c.a(this.dUr);
        }
        this.dUp.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (h.this.cBb != null) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                    h.this.dUz = true;
                    if (h.this.dUy) {
                        h.this.aTZ();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    h.this.dUz = false;
                }
            }
        }
    }

    private com.baidu.swan.game.ad.c.b mm(int i) {
        int i2;
        com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
        bVar.dTm = String.valueOf(this.dQW.getDuration());
        bVar.dTn = String.valueOf(this.mPausePosition);
        bVar.mEndTime = String.valueOf(i);
        bVar.dTo = this.mPausePosition == 0 ? "1" : "0";
        bVar.dTp = i == this.dQW.getDuration() ? "1" : "0";
        bVar.dTq = this.mContext.getResources().getConfiguration().orientation == 1 ? "2" : "4";
        if (this.mPausePosition == 0) {
            i2 = 1;
        } else if (this.mPausePosition == this.dQW.getDuration()) {
            i2 = 3;
        } else {
            i2 = 2;
        }
        bVar.mType = String.valueOf(i2);
        bVar.dTr = (this.mPausePosition == 0 && SwanAppNetworkUtils.isWifiNetworkConnected(this.mContext)) ? "1" : "2";
        bVar.mStatus = String.valueOf(0);
        return bVar;
    }

    public String getType() {
        return this.dSq ? "gdtvideo" : "video";
    }

    private int aUb() {
        return (this.cBb == null || !this.cBb.isEnd()) ? getProgress() : this.cBb.getDuration() / 1000;
    }

    @Override // com.baidu.swan.game.ad.a.a.d
    public void cU(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                jSONObject.put("title", this.dQW.getTitle());
                jSONObject.put("description", this.dQW.getDescription());
                jSONObject.put("autoinstall", true);
                if (this.dUG == null) {
                    this.dUG = new g(this.mContext, this.dQW, this.dQP);
                }
                this.dUG.rD(str);
                com.baidu.swan.apps.t.a.azk().a(this.mContext, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.dUG);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void aN(View view) {
        if (this.dSq && this.dQW != null) {
            com.baidu.swan.game.ad.c.d.d(this.dQW, this.dQP);
            com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
            bVar.dTe = String.valueOf(ah.getDisplayWidth(this.mContext));
            bVar.dTf = String.valueOf(ah.getDisplayHeight(this.mContext));
            bVar.dTg = String.valueOf(ah.getDisplayWidth(this.mContext));
            bVar.dTh = String.valueOf(ah.getDisplayHeight(this.mContext));
            bVar.dTi = String.valueOf((int) view.getX());
            bVar.dTj = String.valueOf((int) view.getY());
            bVar.dTk = String.valueOf((int) view.getX());
            bVar.dTl = String.valueOf((int) view.getY());
            if (this.dQW.getActionType() == 2) {
                com.baidu.swan.game.ad.c.d.a(bVar, this.dQW, this.dQP, this);
                return;
            }
            com.baidu.swan.apps.core.d.f aim = com.baidu.swan.apps.v.f.aCp().aim();
            if (aim == null) {
                if (this.mContext != null) {
                    com.baidu.swan.apps.res.widget.b.d.t(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                }
            } else if (this.dQW != null) {
                String a2 = com.baidu.swan.game.ad.c.d.a(this.dQW.aTb(), bVar);
                aim.nC("adLanding").an(com.baidu.swan.apps.core.d.f.cQb, com.baidu.swan.apps.core.d.f.cQd).a("adLanding", com.baidu.swan.apps.model.b.ch(a2, a2)).arM();
            }
        }
    }
}
