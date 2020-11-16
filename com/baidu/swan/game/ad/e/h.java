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
/* loaded from: classes12.dex */
public class h implements a.InterfaceC0514a, a.b, a.c, a.d {
    private com.baidu.swan.apps.media.b.a cuh;
    private com.baidu.swan.apps.adlanding.b cun;
    private com.baidu.swan.apps.adlanding.download.a.a cuu;
    private com.baidu.swan.apps.adlanding.download.model.a cuv;
    private AdElementInfo dJY;
    public String dJu;
    private String dLC;
    private String dLY;
    private boolean dLt;
    private boolean dNA;
    private boolean dNG;
    private boolean dNH;
    private g dNI;
    private com.baidu.swan.game.ad.b dNr;
    private com.baidu.swan.games.view.a dNt;
    private k dNu;
    private l dNv;
    public com.baidu.swan.apps.res.widget.dialog.g dNw;
    private j dNx;
    private boolean dNy;
    private a dNz;
    private static String dNh = "0";
    private static String dNi = "100";
    private static String dNj = TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY;
    private static String dNk = TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY;
    private static String dNl = TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY;
    private static String dNm = TbEnum.SystemMessage.EVENT_ID_GROUP_UPGRADE;
    private static String dNn = "1";
    private static String dNo = "0";
    private static String dNp = "status";
    private static String dNq = "isPaused";
    private static String KEY_TOKEN = "token";
    private static String dNF = "monitors";
    private int dNs = 256;
    private int mPausePosition = 0;
    private boolean dNB = true;
    private String dNC = dNj;
    private String dND = dNo;
    private Map<String, String> dNE = new HashMap();
    private SwanAdDownloadState cuw = SwanAdDownloadState.NOT_START;
    private Context mContext = AppRuntime.getAppContext();
    private b dJR = new b(this.mContext);
    private com.baidu.swan.game.ad.jsbridge.a dJP = new com.baidu.swan.game.ad.jsbridge.a();
    private boolean dJQ = com.baidu.swan.game.ad.d.f.aQD();

    public h(String str, String str2, boolean z) {
        this.dJu = "";
        this.dLC = str;
        this.dJu = str2;
        this.dLt = z;
        this.dNH = z;
    }

    public void a(j jVar) {
        this.dNx = jVar;
    }

    public synchronized void b(com.baidu.swan.games.binding.model.c cVar) {
        com.baidu.swan.game.ad.b.d fVar;
        k d = k.d(cVar);
        if (this.dNs == 257) {
            com.baidu.swan.game.ad.e.a.aQF().a(d);
        } else if (this.dNs == 261 || this.dNs == 260 || this.dNs == 265) {
            a(d, "3010006");
        } else {
            if (this.dNs == 258) {
                if (aQT()) {
                    this.dNs = AuthorityState.STATE_INIT_ING;
                } else {
                    c(d);
                }
            }
            if (this.dNs == 259 || this.dNs == 262 || this.dNs == 263 || this.dNs == 264 || this.dNs == 256 || this.dNs == 272) {
                com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
                String str = "";
                if (aGM != null) {
                    str = aGM.getAppKey();
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.dLC) || TextUtils.isEmpty(this.dJu)) {
                    a(d, "3010007");
                } else {
                    this.dNu = d;
                    this.dNs = 257;
                    com.baidu.swan.game.ad.b.b aQn = new b.a().vD(this.dLC).vE(this.dJu).vF(str).lL(ah.getDisplayWidth(this.mContext)).lM(ah.getDisplayHeight(this.mContext)).lN(1).aQn();
                    if (this.dNH) {
                        this.dLt = true;
                        fVar = new com.baidu.swan.game.ad.b.e(this.mContext, aQn, 5, 5);
                        com.baidu.swan.games.view.a.b.dm("gdtvideo", null);
                    } else {
                        this.dLt = false;
                        fVar = new com.baidu.swan.game.ad.b.f(this.mContext, aQn);
                        this.dLY = fVar.aQs();
                        com.baidu.swan.games.view.a.b.dm("video", null);
                    }
                    com.baidu.swan.game.ad.b.a aVar = new com.baidu.swan.game.ad.b.a(this.mContext, this.dLt);
                    aVar.a(this);
                    aVar.a(fVar, this.dJR);
                }
            }
        }
    }

    public synchronized void c(com.baidu.swan.games.binding.model.c cVar) {
        final l e = l.e(cVar);
        String str = "";
        if (this.dNs == 261 || this.dNs == 260 || this.dNs == 265) {
            if (e != null) {
                e.vM("3010004");
            }
            if (this.dNx != null) {
                this.dNx.onError("3010004");
            }
        } else if (this.dNs != 258 || aQT()) {
            a(e, "3010004");
        } else if (this.dJY != null && TextUtils.isEmpty(this.dJY.getVideoUrl())) {
            a(e, "3010008");
        } else if (this.dNs == 258) {
            this.dNs = 265;
            if (this.dJY != null) {
                str = this.dJY.aPU();
            }
            if (com.baidu.swan.games.view.a.c.isLandScape() && (com.baidu.swan.games.view.a.c.aXC() || !TextUtils.isEmpty(str))) {
                SwanAppActivity ayQ = com.baidu.swan.apps.v.f.azg().ayQ();
                if (ayQ != null) {
                    ayQ.setRequestedOrientation(1);
                }
                com.baidu.swan.apps.v.f.azg().azk().hJ(true);
            }
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.h.1
                @Override // java.lang.Runnable
                public void run() {
                    h.this.aQV();
                    if (com.baidu.swan.games.view.a.c.aN(h.this.dNr.getConvertView())) {
                        com.baidu.swan.games.view.a.c.removeView(h.this.dNr.getConvertView());
                    }
                    if (!com.baidu.swan.games.view.a.c.c(h.this.dNr.getConvertView(), com.baidu.swan.apps.model.a.a.a.aBw())) {
                        h.this.a(e, "3010000");
                        return;
                    }
                    h.this.dNv = e;
                    h.this.dNs = 260;
                    h.this.dNr.bs(h.this.dJY.getVideoUrl());
                }
            });
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void a(AdElementInfo adElementInfo) {
        this.dJY = adElementInfo;
        this.dLt = this.dJY.aQe();
        this.dNs = 258;
        c(this.dNu);
        if (!this.dLt && this.dJY.getActionType() == 2) {
            initDownload();
        }
        com.baidu.swan.games.view.a.b.dm(getType(), "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void vx(String str) {
        this.dNs = 259;
        a(this.dNu, str);
        com.baidu.swan.games.view.a.b.ac(getType(), "fail", str);
    }

    private void aQN() {
        com.baidu.swan.games.view.a.b.g(getType(), "pageclose", this.cuh.getDuration() / 1000);
        aQR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQO() {
        if (this.cuh != null && this.dNr != null) {
            if (this.cuh.isPlaying()) {
                this.cuh.pause();
                this.dNr.aPd();
            }
            this.dNs = 262;
            if (this.dLt) {
                com.baidu.swan.game.ad.c.d.b(lO(this.dJY.getDuration()), this.dJY, this.dJR);
            } else {
                com.baidu.swan.game.ad.c.c.a(getProgress(), this.mPausePosition, this.dJY, this.dJR);
            }
            if (this.dNr != null) {
                if (this.cuh.isEnd()) {
                    this.dNr.aPg();
                } else {
                    this.dNr.aPh();
                }
            }
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.c
    public void aJ(View view) {
        SwanAppActivity ayQ;
        int i;
        int i2;
        int i3;
        String format;
        if (this.cuh != null && this.dJY != null && (ayQ = com.baidu.swan.apps.v.f.azg().ayQ()) != null && !this.dNy) {
            if (view != null && c.e.close_ad != view.getId()) {
                aQN();
                return;
            }
            int currentPosition = this.cuh.getCurrentPosition() / 1000;
            int min = Math.min(this.dJY.aPS(), this.cuh.getDuration() / 1000);
            if (currentPosition >= min) {
                aQO();
                return;
            }
            int aXA = com.baidu.swan.games.view.a.c.aXA();
            int aXB = com.baidu.swan.games.view.a.c.aXB();
            if (com.baidu.swan.games.view.a.c.isLandScape()) {
                i = (int) (aXA * 0.275f);
                i2 = (int) (aXA * 0.275f);
                i3 = (int) (0.05f * aXB);
            } else {
                int min2 = Math.min(aXA, aXB);
                i = (int) (min2 * 0.1f);
                i2 = (int) (min2 * 0.1f);
                i3 = 0;
            }
            aPd();
            com.baidu.swan.games.view.a.b.g(getType(), "pageshow", getProgress());
            this.mContext.getResources().getString(c.g.swangame_game_ad_dialog_msg_more);
            if (this.dJQ) {
                format = String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_reward_msg_time_tip), Integer.valueOf(15 - (this.cuh.getCurrentPosition() / 1000)));
            } else {
                format = String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_video_close_alert), Integer.valueOf(min - currentPosition));
            }
            this.dNy = true;
            this.dNw = new g.a(ayQ).gs(true).d(c.g.ad_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.e.h.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    if (!h.this.dJQ || h.this.dNr == null) {
                        h.this.aQR();
                    } else {
                        if (h.this.cuh != null) {
                            h.this.cuh.pause();
                        }
                        if (h.this.dNz != null) {
                            h.this.mContext.unregisterReceiver(h.this.dNz);
                            h.this.dNz = null;
                        }
                        h.this.dNs = 262;
                        h.this.dNr.aPh();
                    }
                    h.this.dNy = false;
                    com.baidu.swan.games.view.a.b.g(h.this.getType(), "close", h.this.getProgress());
                }
            }).rL(format).c(c.g.ad_continue_watch, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.e.h.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    h.this.aQU();
                    h.this.dNy = false;
                    com.baidu.swan.games.view.a.b.g(h.this.getType(), "continue", h.this.getProgress());
                }
            }).jX(c.b.aiapps_game_continue_watch).c(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.game.ad.e.h.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    h.this.dNy = false;
                }
            }).a(new com.baidu.swan.apps.view.c.a()).n(i, 0, i2, i3).aGt();
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.d
    public void aK(View view) {
        com.baidu.swan.games.view.a.b.g(getType(), "click", aQW());
        if (this.dLt) {
            aL(view);
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0514a
    public void a(CommandType commandType, Uri uri) {
        String aPW = this.dJY.aPW();
        String packageName = this.dJY.getPackageName();
        switch (commandType) {
            case ACTION_URL:
                if (this.dJY.getActionType() == 2) {
                    aQP();
                    break;
                } else {
                    aQQ();
                    break;
                }
            case OPEN_APP:
                if (this.dJY != null) {
                    al(this.mContext, packageName);
                    break;
                }
                break;
            case GET_DOWNLOAD_STATUS:
                if (this.dJP != null) {
                    if (aj(this.mContext, packageName)) {
                        this.dNC = dNl;
                    }
                    String queryParameter = uri.getQueryParameter(KEY_TOKEN);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(dNp, this.dNC);
                        jSONObject.put(dNq, this.dND);
                        this.dJP.cO(queryParameter, jSONObject.toString());
                        break;
                    } catch (JSONException e) {
                        break;
                    }
                } else {
                    return;
                }
            case PAUSE_DOWNLOAD:
                this.dND = dNn;
                aQP();
                break;
            case BANNER_VIEW:
                com.baidu.swan.apps.core.d.f afe = com.baidu.swan.apps.v.f.azg().afe();
                if (afe == null) {
                    if (this.mContext != null) {
                        com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                        return;
                    }
                    return;
                }
                afe.mV("adLanding").al(com.baidu.swan.apps.core.d.f.cJi, com.baidu.swan.apps.core.d.f.cJk).a("adLanding", com.baidu.swan.apps.model.b.ca(aPW, aPW)).aoE();
                break;
        }
        com.baidu.swan.game.ad.c.c.d(this.dJY, this.dJR);
        com.baidu.swan.games.view.a.b.g(getType(), "click", aQW());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SwanAdDownloadState swanAdDownloadState) {
        this.cuw = swanAdDownloadState;
        if (swanAdDownloadState == SwanAdDownloadState.NOT_START) {
            this.dNC = dNj;
            this.dND = dNo;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
            this.dNC = dNh;
            this.dND = dNn;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
            this.dNC = dNk;
            this.dND = dNo;
        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
            this.dNC = dNl;
            this.dND = dNo;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
            this.dNC = dNh;
            this.dND = dNo;
        }
    }

    private void initDownload() {
        this.cun = new com.baidu.swan.apps.adlanding.b(this.mContext, this.dJY.aQc());
        this.cuu = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.game.ad.e.h.5
            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void et(boolean z) {
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void kv(String str) {
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                if (!h.this.dNG) {
                    h.this.d(swanAdDownloadState);
                }
                h.this.dNG = true;
                if (h.this.cuw != swanAdDownloadState) {
                    if (h.this.cuw == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                        h.this.dND = h.dNo;
                        h.this.cun.ks("appdownloadbegin");
                    } else if (swanAdDownloadState != SwanAdDownloadState.DOWNLOAD_PAUSED) {
                        if (h.this.cuw == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            h.this.dND = h.dNo;
                            h.this.cun.ks("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            h.this.dND = h.dNo;
                            h.this.dNC = h.dNk;
                            h.this.cun.ks("appdownloadfinish");
                            h.this.cun.ks("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            h.this.dND = h.dNo;
                            h.this.dNC = h.dNl;
                            h.this.cun.ks("appinstallfinish");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_FAILED) {
                            h.this.dND = h.dNo;
                            h.this.dNC = h.dNm;
                        } else if (swanAdDownloadState == SwanAdDownloadState.DELETED) {
                            h.this.dND = h.dNo;
                            h.this.dNC = h.dNj;
                        }
                    } else {
                        h.this.dND = h.dNn;
                        h.this.cun.ks("appdownloadpause");
                    }
                    h.this.cuw = swanAdDownloadState;
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                if (i != 0) {
                    if (i != 100 || h.this.dNC == h.dNj) {
                        if (h.this.dNC != h.dNj && h.this.dNC != h.dNm) {
                            h.this.dNC = String.valueOf(i);
                            return;
                        }
                        return;
                    }
                    h.this.dNC = h.dNk;
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void aiv() {
                h.this.cun.ks("appinstallbegin");
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public String aiw() {
                h.this.cun.ks("appinstallopen");
                return "";
            }
        };
        String aPW = this.dJY.aPW();
        String packageName = this.dJY.getPackageName();
        String str = this.dNE.get(packageName);
        if (str == null) {
            this.dNE.put(packageName, aPW);
            str = aPW;
        }
        this.cuv = new com.baidu.swan.apps.adlanding.download.model.a(str, packageName, this.dJY.getTitle());
        this.dNG = false;
        com.baidu.swan.apps.t.a.awc().a(this.mContext, this.cuv.aiy(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS, this.cuu);
    }

    private boolean aj(Context context, String str) {
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

    private boolean al(Context context, String str) {
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
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "打开失败").ki(3).showToast();
            }
        } else {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "打开失败").ki(3).showToast();
        }
        return false;
    }

    private void aQP() {
        if (ak.isAppInstalled(this.mContext, this.cuv.name)) {
            this.dNC = dNl;
            al(this.mContext, this.cuv.name);
            this.cun.ks("appinstallopen");
            return;
        }
        if (this.cuw == SwanAdDownloadState.NOT_START || this.cuw == SwanAdDownloadState.DELETED) {
            this.dNC = dNh;
            com.baidu.swan.apps.t.a.awc().a(this.mContext, this.cuv.aiy(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.cuu);
        }
        if (this.cuw == SwanAdDownloadState.DOWNLOADING) {
            com.baidu.swan.apps.t.a.awc().a(this.mContext, this.cuv.aiy(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.cuu);
        }
        if (this.cuw == SwanAdDownloadState.DOWNLOAD_PAUSED) {
            this.dND = dNo;
            com.baidu.swan.apps.t.a.awc().a(this.mContext, this.cuv.aiy(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.cuu);
        }
        if (this.cuw == SwanAdDownloadState.DOWNLOAD_FAILED) {
            com.baidu.swan.apps.t.a.awc().a(this.mContext, this.cuv.aiy(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.cuu);
        }
        if (this.cuw == SwanAdDownloadState.DOWNLOADED) {
            this.dNC = dNk;
            this.cuu.aiv();
            com.baidu.swan.apps.t.a.awc().a(this.mContext, this.cuv.aiy(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, this.cuu);
        }
        if (this.cuw == SwanAdDownloadState.INSTALLED) {
            al(this.mContext, this.cuv.name);
        }
    }

    private void aQQ() {
        String aPW = this.dJY.aPW();
        com.baidu.swan.apps.core.d.f afe = com.baidu.swan.apps.v.f.azg().afe();
        if (afe == null) {
            if (this.mContext != null) {
                com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                return;
            }
            return;
        }
        JSONObject aQc = this.dJY.aQc();
        com.baidu.swan.apps.model.b ca = com.baidu.swan.apps.model.b.ca(aPW, aPW);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(dNF, aQc);
        } catch (JSONException e) {
        }
        ca.setParams(jSONObject.toString());
        afe.mV("adLanding").al(com.baidu.swan.apps.core.d.f.cJi, com.baidu.swan.apps.core.d.f.cJk).a("adLanding", ca).aoE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQR() {
        if (this.dNx != null && this.cuh != null) {
            this.dNx.hn(this.cuh.isEnd() || this.cuh.getCurrentPosition() / 1000 >= Math.min(this.dJY.aPS(), this.cuh.getDuration() / 1000));
        }
        aQS();
        if (!this.dLt && this.dJY.getActionType() == 2 && SwanAdDownloadState.DOWNLOADING == this.cuw) {
            this.cuu = null;
            com.baidu.swan.apps.t.a.awc().a(this.mContext, this.cuv.aiy(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.cuu);
        }
        com.baidu.swan.game.ad.c.c.f(this.dJY, this.dJR);
        this.dNs = 263;
        b((com.baidu.swan.games.binding.model.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQS() {
        if (this.cuh != null) {
            this.cuh.pause();
            this.cuh.onDestroy();
        }
        if (this.dNz != null) {
            this.mContext.unregisterReceiver(this.dNz);
            this.dNz = null;
        }
        if (this.dNr != null) {
            this.dNr.aPf();
            this.dNr.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_close));
            com.baidu.swan.games.view.a.c.removeView(this.dNr.getConvertView());
        }
        if (this.dNt != null) {
            com.baidu.swan.games.view.a.c.b(this.dNt);
            this.dNt = null;
        }
        if (this.dNI != null) {
            this.dNI.release();
            this.dNI = null;
        }
    }

    private boolean aQT() {
        if (this.dJY == null) {
            return true;
        }
        long aPX = this.dJY.aPX() * 1000;
        if (aPX == 0) {
            aPX = 1740000;
        }
        return System.currentTimeMillis() - this.dJY.getCreateTime() >= aPX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getProgress() {
        if (this.cuh != null) {
            return this.cuh.getCurrentPosition() / 1000;
        }
        return 0;
    }

    private void c(k kVar) {
        if (this.dNx != null) {
            this.dNx.onLoad();
        }
        if (kVar != null) {
            kVar.aRf();
        }
        com.baidu.swan.game.ad.e.a.aQF().aq(16, "");
    }

    private void a(k kVar, String str) {
        if (this.dNx != null) {
            this.dNx.onError(str);
        }
        if (kVar != null) {
            kVar.vL(str);
        }
        com.baidu.swan.game.ad.e.a.aQF().aq(17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPd() {
        if (this.cuh != null && this.dNr != null && this.cuh.isPlaying()) {
            this.cuh.pause();
            this.dNr.aPd();
            if (this.dLt) {
                com.baidu.swan.game.ad.c.d.b(lO(getProgress()), this.dJY, this.dJR);
            } else {
                com.baidu.swan.game.ad.c.c.a(getProgress(), this.mPausePosition, this.dJY, this.dJR);
            }
            this.mPausePosition = getProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQU() {
        if (this.cuh != null && this.dNr != null) {
            if ((this.dNw == null || !this.dNw.isShowing()) && !this.cuh.isPlaying() && !this.dNr.aPn()) {
                this.cuh.resume();
                this.dNr.aPe();
                com.baidu.swan.game.ad.c.c.e(this.dJY, this.dJR);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar, String str) {
        if (lVar != null) {
            lVar.vM(str);
        }
        if (this.dNx != null) {
            this.dNx.onError(str);
        }
        this.dNs = 264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQV() {
        this.dJP.b(this);
        if (com.baidu.swan.games.view.a.c.isLandScape()) {
            this.dNr = new com.baidu.swan.game.ad.d(this.mContext, this.dJY, this.dJP);
        } else {
            this.dNr = new com.baidu.swan.game.ad.e(this.mContext, this.dJY, this.dJP);
        }
        if (this.dLt) {
            this.dNr.a((a.d) this);
        }
        this.dNr.a((a.c) this);
        this.cuh = this.dNr.getPlayer();
        this.cuh.b(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.game.ad.e.h.6
            @Override // com.baidu.swan.apps.media.b.b
            public void a(com.baidu.swan.apps.t.b.j jVar) {
                if (h.this.dNr != null) {
                    h.this.dNr.onPrepared();
                }
                h.this.dNs = 261;
                h.this.mPausePosition = 0;
                if (h.this.dNr != null) {
                    h.this.dNr.aPc();
                }
                if (h.this.dNv != null) {
                    h.this.dNv.aRg();
                }
                if (h.this.dNz == null) {
                    h.this.dNz = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    h.this.mContext.registerReceiver(h.this.dNz, intentFilter);
                }
                if (h.this.dLt) {
                    com.baidu.swan.game.ad.c.d.a(h.this.dJY, h.this.dJR);
                    return;
                }
                com.baidu.swan.game.ad.c.c.a(h.this.dJY, h.this.dJR);
                com.baidu.swan.game.ad.c.c.e(h.this.dJY, h.this.dJR);
                com.baidu.swan.game.ad.c.c.a(h.this.dLC, h.this.dJu, h.this.dLY, h.this.dJR);
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(com.baidu.swan.apps.t.b.j jVar, int i, int i2) {
                h.this.aQS();
                h.this.a(h.this.dNv, "3010001");
                return true;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(com.baidu.swan.apps.t.b.j jVar) {
                h.this.aQO();
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
        if (this.dNt == null) {
            this.dNt = new com.baidu.swan.games.view.a() { // from class: com.baidu.swan.game.ad.e.h.7
                @Override // com.baidu.swan.games.view.a
                public void aRd() {
                    h.this.dNA = true;
                    if (h.this.dNB) {
                        h.this.aQU();
                    }
                }

                @Override // com.baidu.swan.games.view.a
                public void aRe() {
                    h.this.dNA = false;
                    h.this.aPd();
                }

                @Override // com.baidu.swan.games.view.a
                public void onViewDestroy() {
                }
            };
            com.baidu.swan.games.view.a.c.a(this.dNt);
        }
        this.dNr.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (h.this.cuh != null) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                    h.this.dNB = true;
                    if (h.this.dNA) {
                        h.this.aQU();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    h.this.dNB = false;
                }
            }
        }
    }

    private com.baidu.swan.game.ad.c.b lO(int i) {
        int i2;
        com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
        bVar.dMo = String.valueOf(this.dJY.getDuration());
        bVar.dMp = String.valueOf(this.mPausePosition);
        bVar.mEndTime = String.valueOf(i);
        bVar.dMq = this.mPausePosition == 0 ? "1" : "0";
        bVar.dMr = i == this.dJY.getDuration() ? "1" : "0";
        bVar.dMs = this.mContext.getResources().getConfiguration().orientation == 1 ? "2" : "4";
        if (this.mPausePosition == 0) {
            i2 = 1;
        } else if (this.mPausePosition == this.dJY.getDuration()) {
            i2 = 3;
        } else {
            i2 = 2;
        }
        bVar.mType = String.valueOf(i2);
        bVar.dMt = (this.mPausePosition == 0 && SwanAppNetworkUtils.isWifiNetworkConnected(this.mContext)) ? "1" : "2";
        bVar.mStatus = String.valueOf(0);
        return bVar;
    }

    public String getType() {
        return this.dLt ? "gdtvideo" : "video";
    }

    private int aQW() {
        return (this.cuh == null || !this.cuh.isEnd()) ? getProgress() : this.cuh.getDuration() / 1000;
    }

    @Override // com.baidu.swan.game.ad.a.a.d
    public void cN(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                jSONObject.put("title", this.dJY.getTitle());
                jSONObject.put("description", this.dJY.getDescription());
                jSONObject.put("autoinstall", true);
                if (this.dNI == null) {
                    this.dNI = new g(this.mContext, this.dJY, this.dJR);
                }
                this.dNI.qW(str);
                com.baidu.swan.apps.t.a.awc().a(this.mContext, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.dNI);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void aL(View view) {
        if (this.dLt && this.dJY != null) {
            com.baidu.swan.game.ad.c.d.d(this.dJY, this.dJR);
            com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
            bVar.dMg = String.valueOf(ah.getDisplayWidth(this.mContext));
            bVar.dMh = String.valueOf(ah.getDisplayHeight(this.mContext));
            bVar.dMi = String.valueOf(ah.getDisplayWidth(this.mContext));
            bVar.dMj = String.valueOf(ah.getDisplayHeight(this.mContext));
            bVar.dMk = String.valueOf((int) view.getX());
            bVar.dMl = String.valueOf((int) view.getY());
            bVar.dMm = String.valueOf((int) view.getX());
            bVar.dMn = String.valueOf((int) view.getY());
            if (this.dJY.getActionType() == 2) {
                com.baidu.swan.game.ad.c.d.a(bVar, this.dJY, this.dJR, this);
                return;
            }
            com.baidu.swan.apps.core.d.f afe = com.baidu.swan.apps.v.f.azg().afe();
            if (afe == null) {
                if (this.mContext != null) {
                    com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                }
            } else if (this.dJY != null) {
                String a2 = com.baidu.swan.game.ad.c.d.a(this.dJY.aPW(), bVar);
                afe.mV("adLanding").al(com.baidu.swan.apps.core.d.f.cJi, com.baidu.swan.apps.core.d.f.cJk).a("adLanding", com.baidu.swan.apps.model.b.ca(a2, a2)).aoE();
            }
        }
    }
}
