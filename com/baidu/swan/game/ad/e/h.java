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
/* loaded from: classes10.dex */
public class h implements a.InterfaceC0473a, a.b, a.c, a.d {
    private com.baidu.swan.apps.media.b.a bVg;
    private com.baidu.swan.apps.adlanding.b bVm;
    private com.baidu.swan.apps.adlanding.download.a.a bVr;
    private com.baidu.swan.apps.adlanding.download.model.a bVs;
    public String dkH;
    private AdElementInfo dll;
    private boolean dmG;
    private String dmP;
    private String dnl;
    private com.baidu.swan.game.ad.b doG;
    private com.baidu.swan.games.view.a doI;
    private k doJ;
    private l doK;
    public com.baidu.swan.apps.res.widget.dialog.g doL;
    private j doM;
    private boolean doN;
    private a doO;
    private boolean doP;
    private boolean doV;
    private boolean doW;
    private g doX;
    private static String dow = "0";
    private static String dox = "100";
    private static String doy = TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY;
    private static String doz = TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY;
    private static String doA = TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY;
    private static String doB = TbEnum.SystemMessage.EVENT_ID_GROUP_UPGRADE;
    private static String doC = "1";
    private static String doD = "0";
    private static String doE = "status";
    private static String doF = "isPaused";
    private static String KEY_TOKEN = "token";
    private static String doU = "monitors";
    private int doH = 256;
    private int mPausePosition = 0;
    private boolean doQ = true;
    private String doR = doy;
    private String doS = doD;
    private Map<String, String> doT = new HashMap();
    private SwanAdDownloadState bVt = SwanAdDownloadState.NOT_START;
    private Context mContext = AppRuntime.getAppContext();
    private b dle = new b(this.mContext);
    private com.baidu.swan.game.ad.jsbridge.a dlc = new com.baidu.swan.game.ad.jsbridge.a();
    private boolean dld = com.baidu.swan.game.ad.d.f.aKi();

    public h(String str, String str2, boolean z) {
        this.dkH = "";
        this.dmP = str;
        this.dkH = str2;
        this.dmG = z;
        this.doW = z;
    }

    public void a(j jVar) {
        this.doM = jVar;
    }

    public synchronized void b(com.baidu.swan.games.binding.model.c cVar) {
        com.baidu.swan.game.ad.b.d fVar;
        k d = k.d(cVar);
        if (this.doH == 257) {
            com.baidu.swan.game.ad.e.a.aKk().a(d);
        } else if (this.doH == 261 || this.doH == 260 || this.doH == 265) {
            a(d, "3010006");
        } else {
            if (this.doH == 258) {
                if (aKy()) {
                    this.doH = AuthorityState.STATE_INIT_ING;
                } else {
                    c(d);
                }
            }
            if (this.doH == 259 || this.doH == 262 || this.doH == 263 || this.doH == 264 || this.doH == 256 || this.doH == 272) {
                com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
                String str = "";
                if (aAr != null) {
                    str = aAr.getAppKey();
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.dmP) || TextUtils.isEmpty(this.dkH)) {
                    a(d, "3010007");
                } else {
                    this.doJ = d;
                    this.doH = 257;
                    com.baidu.swan.game.ad.b.b aJS = new b.a().up(this.dmP).uq(this.dkH).ur(str).kX(ah.getDisplayWidth(this.mContext)).kY(ah.getDisplayHeight(this.mContext)).kZ(1).aJS();
                    if (this.doW) {
                        this.dmG = true;
                        fVar = new com.baidu.swan.game.ad.b.e(this.mContext, aJS, 5, 5);
                        com.baidu.swan.games.view.a.b.db("gdtvideo", null);
                    } else {
                        this.dmG = false;
                        fVar = new com.baidu.swan.game.ad.b.f(this.mContext, aJS);
                        this.dnl = fVar.aJX();
                        com.baidu.swan.games.view.a.b.db("video", null);
                    }
                    com.baidu.swan.game.ad.b.a aVar = new com.baidu.swan.game.ad.b.a(this.mContext, this.dmG);
                    aVar.a(this);
                    aVar.a(fVar, this.dle);
                }
            }
        }
    }

    public synchronized void c(com.baidu.swan.games.binding.model.c cVar) {
        final l e = l.e(cVar);
        String str = "";
        if (this.doH == 261 || this.doH == 260 || this.doH == 265) {
            if (e != null) {
                e.uy("3010004");
            }
            if (this.doM != null) {
                this.doM.onError("3010004");
            }
        } else if (this.doH != 258 || aKy()) {
            a(e, "3010004");
        } else if (this.dll != null && TextUtils.isEmpty(this.dll.getVideoUrl())) {
            a(e, "3010008");
        } else if (this.doH == 258) {
            this.doH = 265;
            if (this.dll != null) {
                str = this.dll.aJz();
            }
            if (com.baidu.swan.games.view.a.c.isLandScape() && (com.baidu.swan.games.view.a.c.aRh() || !TextUtils.isEmpty(str))) {
                SwanAppActivity ast = com.baidu.swan.apps.v.f.asJ().ast();
                if (ast != null) {
                    ast.setRequestedOrientation(1);
                }
                com.baidu.swan.apps.v.f.asJ().asN().gO(true);
            }
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.h.1
                @Override // java.lang.Runnable
                public void run() {
                    h.this.aKA();
                    if (com.baidu.swan.games.view.a.c.aH(h.this.doG.getConvertView())) {
                        com.baidu.swan.games.view.a.c.removeView(h.this.doG.getConvertView());
                    }
                    if (!com.baidu.swan.games.view.a.c.c(h.this.doG.getConvertView(), com.baidu.swan.apps.model.a.a.a.auZ())) {
                        h.this.a(e, "3010000");
                        return;
                    }
                    h.this.doK = e;
                    h.this.doH = 260;
                    h.this.doG.bs(h.this.dll.getVideoUrl());
                }
            });
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void a(AdElementInfo adElementInfo) {
        this.dll = adElementInfo;
        this.dmG = this.dll.aJJ();
        this.doH = 258;
        c(this.doJ);
        if (!this.dmG && this.dll.getActionType() == 2) {
            initDownload();
        }
        com.baidu.swan.games.view.a.b.db(getType(), "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void uj(String str) {
        this.doH = 259;
        a(this.doJ, str);
        com.baidu.swan.games.view.a.b.U(getType(), "fail", str);
    }

    private void aKs() {
        com.baidu.swan.games.view.a.b.f(getType(), "pageclose", this.bVg.getDuration() / 1000);
        aKw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKt() {
        if (this.bVg != null && this.doG != null) {
            if (this.bVg.isPlaying()) {
                this.bVg.pause();
                this.doG.aII();
            }
            this.doH = 262;
            if (this.dmG) {
                com.baidu.swan.game.ad.c.d.b(la(this.dll.getDuration()), this.dll, this.dle);
            } else {
                com.baidu.swan.game.ad.c.c.a(getProgress(), this.mPausePosition, this.dll, this.dle);
            }
            if (this.doG != null) {
                if (this.bVg.isEnd()) {
                    this.doG.aIL();
                } else {
                    this.doG.aIM();
                }
            }
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.c
    public void aD(View view) {
        SwanAppActivity ast;
        int i;
        int i2;
        int i3;
        String format;
        if (this.bVg != null && this.dll != null && (ast = com.baidu.swan.apps.v.f.asJ().ast()) != null && !this.doN) {
            if (view != null && c.e.close_ad != view.getId()) {
                aKs();
                return;
            }
            int currentPosition = this.bVg.getCurrentPosition() / 1000;
            int min = Math.min(this.dll.aJx(), this.bVg.getDuration() / 1000);
            if (currentPosition >= min) {
                aKt();
                return;
            }
            int aRf = com.baidu.swan.games.view.a.c.aRf();
            int aRg = com.baidu.swan.games.view.a.c.aRg();
            if (com.baidu.swan.games.view.a.c.isLandScape()) {
                i = (int) (aRf * 0.275f);
                i2 = (int) (aRf * 0.275f);
                i3 = (int) (0.05f * aRg);
            } else {
                int min2 = Math.min(aRf, aRg);
                i = (int) (min2 * 0.1f);
                i2 = (int) (min2 * 0.1f);
                i3 = 0;
            }
            aII();
            com.baidu.swan.games.view.a.b.f(getType(), "pageshow", getProgress());
            this.mContext.getResources().getString(c.g.swangame_game_ad_dialog_msg_more);
            if (this.dld) {
                format = String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_reward_msg_time_tip), Integer.valueOf(15 - (this.bVg.getCurrentPosition() / 1000)));
            } else {
                format = String.format(this.mContext.getResources().getString(c.g.swangame_game_ad_video_close_alert), Integer.valueOf(min - currentPosition));
            }
            this.doN = true;
            this.doL = new g.a(ast).fx(true).d(c.g.ad_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.e.h.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    if (!h.this.dld || h.this.doG == null) {
                        h.this.aKw();
                    } else {
                        if (h.this.bVg != null) {
                            h.this.bVg.pause();
                        }
                        if (h.this.doO != null) {
                            h.this.mContext.unregisterReceiver(h.this.doO);
                            h.this.doO = null;
                        }
                        h.this.doH = 262;
                        h.this.doG.aIM();
                    }
                    h.this.doN = false;
                    com.baidu.swan.games.view.a.b.f(h.this.getType(), "close", h.this.getProgress());
                }
            }).qy(format).c(c.g.ad_continue_watch, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.e.h.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    h.this.aKz();
                    h.this.doN = false;
                    com.baidu.swan.games.view.a.b.f(h.this.getType(), "continue", h.this.getProgress());
                }
            }).jj(c.b.aiapps_game_continue_watch).b(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.game.ad.e.h.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    h.this.doN = false;
                }
            }).a(new com.baidu.swan.apps.view.c.a()).n(i, 0, i2, i3).azY();
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.d
    public void aE(View view) {
        com.baidu.swan.games.view.a.b.f(getType(), "click", aKB());
        if (this.dmG) {
            aF(view);
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0473a
    public void a(CommandType commandType, Uri uri) {
        String aJB = this.dll.aJB();
        String packageName = this.dll.getPackageName();
        switch (commandType) {
            case ACTION_URL:
                if (this.dll.getActionType() == 2) {
                    aKu();
                    break;
                } else {
                    aKv();
                    break;
                }
            case OPEN_APP:
                if (this.dll != null) {
                    ak(this.mContext, packageName);
                    break;
                }
                break;
            case GET_DOWNLOAD_STATUS:
                if (this.dlc != null) {
                    if (ai(this.mContext, packageName)) {
                        this.doR = doA;
                    }
                    String queryParameter = uri.getQueryParameter(KEY_TOKEN);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(doE, this.doR);
                        jSONObject.put(doF, this.doS);
                        this.dlc.cD(queryParameter, jSONObject.toString());
                        break;
                    } catch (JSONException e) {
                        break;
                    }
                } else {
                    return;
                }
            case PAUSE_DOWNLOAD:
                this.doS = doC;
                aKu();
                break;
            case BANNER_VIEW:
                com.baidu.swan.apps.core.d.f YG = com.baidu.swan.apps.v.f.asJ().YG();
                if (YG == null) {
                    if (this.mContext != null) {
                        com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                        return;
                    }
                    return;
                }
                YG.lH("adLanding").al(com.baidu.swan.apps.core.d.f.ckl, com.baidu.swan.apps.core.d.f.ckn).a("adLanding", com.baidu.swan.apps.model.b.bP(aJB, aJB)).aih();
                break;
        }
        com.baidu.swan.game.ad.c.c.d(this.dll, this.dle);
        com.baidu.swan.games.view.a.b.f(getType(), "click", aKB());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SwanAdDownloadState swanAdDownloadState) {
        this.bVt = swanAdDownloadState;
        if (swanAdDownloadState == SwanAdDownloadState.NOT_START) {
            this.doR = doy;
            this.doS = doD;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
            this.doR = dow;
            this.doS = doC;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
            this.doR = doz;
            this.doS = doD;
        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
            this.doR = doA;
            this.doS = doD;
        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
            this.doR = dow;
            this.doS = doD;
        }
    }

    private void initDownload() {
        this.bVm = new com.baidu.swan.apps.adlanding.b(this.mContext, this.dll.aJH());
        this.bVr = new com.baidu.swan.apps.adlanding.download.a.a() { // from class: com.baidu.swan.game.ad.e.h.5
            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void dy(boolean z) {
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void jh(String str) {
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void a(SwanAdDownloadState swanAdDownloadState, int i) {
                if (!h.this.doV) {
                    h.this.d(swanAdDownloadState);
                }
                h.this.doV = true;
                if (h.this.bVt != swanAdDownloadState) {
                    if (h.this.bVt == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                        h.this.doS = h.doD;
                        h.this.bVm.je("appdownloadbegin");
                    } else if (swanAdDownloadState != SwanAdDownloadState.DOWNLOAD_PAUSED) {
                        if (h.this.bVt == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                            h.this.doS = h.doD;
                            h.this.bVm.je("appdownloadcontinue");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                            h.this.doS = h.doD;
                            h.this.doR = h.doz;
                            h.this.bVm.je("appdownloadfinish");
                            h.this.bVm.je("appinstallbegin");
                        } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                            h.this.doS = h.doD;
                            h.this.doR = h.doA;
                            h.this.bVm.je("appinstallfinish");
                        } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_FAILED) {
                            h.this.doS = h.doD;
                            h.this.doR = h.doB;
                        } else if (swanAdDownloadState == SwanAdDownloadState.DELETED) {
                            h.this.doS = h.doD;
                            h.this.doR = h.doy;
                        }
                    } else {
                        h.this.doS = h.doC;
                        h.this.bVm.je("appdownloadpause");
                    }
                    h.this.bVt = swanAdDownloadState;
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void b(SwanAdDownloadState swanAdDownloadState, int i) {
                if (i != 0) {
                    if (i != 100 || h.this.doR == h.doy) {
                        if (h.this.doR != h.doy && h.this.doR != h.doB) {
                            h.this.doR = String.valueOf(i);
                            return;
                        }
                        return;
                    }
                    h.this.doR = h.doz;
                }
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public void abX() {
                h.this.bVm.je("appinstallbegin");
            }

            @Override // com.baidu.swan.apps.adlanding.download.a.a
            public String abY() {
                h.this.bVm.je("appinstallopen");
                return "";
            }
        };
        String aJB = this.dll.aJB();
        String packageName = this.dll.getPackageName();
        String str = this.doT.get(packageName);
        if (str == null) {
            this.doT.put(packageName, aJB);
            str = aJB;
        }
        this.bVs = new com.baidu.swan.apps.adlanding.download.model.a(str, packageName, this.dll.getTitle());
        this.doV = false;
        com.baidu.swan.apps.t.a.apE().a(this.mContext, this.bVs.aca(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS, this.bVr);
    }

    private boolean ai(Context context, String str) {
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

    private boolean ak(Context context, String str) {
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
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "打开失败").ju(3).showToast();
            }
        } else {
            com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "打开失败").ju(3).showToast();
        }
        return false;
    }

    private void aKu() {
        if (ak.isAppInstalled(this.mContext, this.bVs.name)) {
            this.doR = doA;
            ak(this.mContext, this.bVs.name);
            this.bVm.je("appinstallopen");
            return;
        }
        if (this.bVt == SwanAdDownloadState.NOT_START || this.bVt == SwanAdDownloadState.DELETED) {
            this.doR = dow;
            com.baidu.swan.apps.t.a.apE().a(this.mContext, this.bVs.aca(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.bVr);
        }
        if (this.bVt == SwanAdDownloadState.DOWNLOADING) {
            com.baidu.swan.apps.t.a.apE().a(this.mContext, this.bVs.aca(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.bVr);
        }
        if (this.bVt == SwanAdDownloadState.DOWNLOAD_PAUSED) {
            this.doS = doD;
            com.baidu.swan.apps.t.a.apE().a(this.mContext, this.bVs.aca(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.bVr);
        }
        if (this.bVt == SwanAdDownloadState.DOWNLOAD_FAILED) {
            com.baidu.swan.apps.t.a.apE().a(this.mContext, this.bVs.aca(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.bVr);
        }
        if (this.bVt == SwanAdDownloadState.DOWNLOADED) {
            this.doR = doz;
            this.bVr.abX();
            com.baidu.swan.apps.t.a.apE().a(this.mContext, this.bVs.aca(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP, this.bVr);
        }
        if (this.bVt == SwanAdDownloadState.INSTALLED) {
            ak(this.mContext, this.bVs.name);
        }
    }

    private void aKv() {
        String aJB = this.dll.aJB();
        com.baidu.swan.apps.core.d.f YG = com.baidu.swan.apps.v.f.asJ().YG();
        if (YG == null) {
            if (this.mContext != null) {
                com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                return;
            }
            return;
        }
        JSONObject aJH = this.dll.aJH();
        com.baidu.swan.apps.model.b bP = com.baidu.swan.apps.model.b.bP(aJB, aJB);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(doU, aJH);
        } catch (JSONException e) {
        }
        bP.setParams(jSONObject.toString());
        YG.lH("adLanding").al(com.baidu.swan.apps.core.d.f.ckl, com.baidu.swan.apps.core.d.f.ckn).a("adLanding", bP).aih();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKw() {
        if (this.doM != null && this.bVg != null) {
            this.doM.gs(this.bVg.isEnd() || this.bVg.getCurrentPosition() / 1000 >= Math.min(this.dll.aJx(), this.bVg.getDuration() / 1000));
        }
        aKx();
        if (!this.dmG && this.dll.getActionType() == 2 && SwanAdDownloadState.DOWNLOADING == this.bVt) {
            this.bVr = null;
            com.baidu.swan.apps.t.a.apE().a(this.mContext, this.bVs.aca(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.bVr);
        }
        com.baidu.swan.game.ad.c.c.f(this.dll, this.dle);
        this.doH = 263;
        b((com.baidu.swan.games.binding.model.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKx() {
        if (this.bVg != null) {
            this.bVg.pause();
            this.bVg.onDestroy();
        }
        if (this.doO != null) {
            this.mContext.unregisterReceiver(this.doO);
            this.doO = null;
        }
        if (this.doG != null) {
            this.doG.aIK();
            this.doG.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_close));
            com.baidu.swan.games.view.a.c.removeView(this.doG.getConvertView());
        }
        if (this.doI != null) {
            com.baidu.swan.games.view.a.c.b(this.doI);
            this.doI = null;
        }
        if (this.doX != null) {
            this.doX.release();
            this.doX = null;
        }
    }

    private boolean aKy() {
        if (this.dll == null) {
            return true;
        }
        long aJC = this.dll.aJC() * 1000;
        if (aJC == 0) {
            aJC = 1740000;
        }
        return System.currentTimeMillis() - this.dll.getCreateTime() >= aJC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getProgress() {
        if (this.bVg != null) {
            return this.bVg.getCurrentPosition() / 1000;
        }
        return 0;
    }

    private void c(k kVar) {
        if (this.doM != null) {
            this.doM.onLoad();
        }
        if (kVar != null) {
            kVar.aKK();
        }
        com.baidu.swan.game.ad.e.a.aKk().Z(16, "");
    }

    private void a(k kVar, String str) {
        if (this.doM != null) {
            this.doM.onError(str);
        }
        if (kVar != null) {
            kVar.ux(str);
        }
        com.baidu.swan.game.ad.e.a.aKk().Z(17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aII() {
        if (this.bVg != null && this.doG != null && this.bVg.isPlaying()) {
            this.bVg.pause();
            this.doG.aII();
            if (this.dmG) {
                com.baidu.swan.game.ad.c.d.b(la(getProgress()), this.dll, this.dle);
            } else {
                com.baidu.swan.game.ad.c.c.a(getProgress(), this.mPausePosition, this.dll, this.dle);
            }
            this.mPausePosition = getProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKz() {
        if (this.bVg != null && this.doG != null) {
            if ((this.doL == null || !this.doL.isShowing()) && !this.bVg.isPlaying() && !this.doG.aIS()) {
                this.bVg.resume();
                this.doG.aIJ();
                com.baidu.swan.game.ad.c.c.e(this.dll, this.dle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar, String str) {
        if (lVar != null) {
            lVar.uy(str);
        }
        if (this.doM != null) {
            this.doM.onError(str);
        }
        this.doH = 264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKA() {
        this.dlc.b(this);
        if (com.baidu.swan.games.view.a.c.isLandScape()) {
            this.doG = new com.baidu.swan.game.ad.d(this.mContext, this.dll, this.dlc);
        } else {
            this.doG = new com.baidu.swan.game.ad.e(this.mContext, this.dll, this.dlc);
        }
        if (this.dmG) {
            this.doG.a((a.d) this);
        }
        this.doG.a((a.c) this);
        this.bVg = this.doG.getPlayer();
        this.bVg.b(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.game.ad.e.h.6
            @Override // com.baidu.swan.apps.media.b.b
            public void a(com.baidu.swan.apps.t.b.j jVar) {
                if (h.this.doG != null) {
                    h.this.doG.onPrepared();
                }
                h.this.doH = 261;
                h.this.mPausePosition = 0;
                if (h.this.doG != null) {
                    h.this.doG.aIH();
                }
                if (h.this.doK != null) {
                    h.this.doK.aKL();
                }
                if (h.this.doO == null) {
                    h.this.doO = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    h.this.mContext.registerReceiver(h.this.doO, intentFilter);
                }
                if (h.this.dmG) {
                    com.baidu.swan.game.ad.c.d.a(h.this.dll, h.this.dle);
                    return;
                }
                com.baidu.swan.game.ad.c.c.a(h.this.dll, h.this.dle);
                com.baidu.swan.game.ad.c.c.e(h.this.dll, h.this.dle);
                com.baidu.swan.game.ad.c.c.a(h.this.dmP, h.this.dkH, h.this.dnl, h.this.dle);
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(com.baidu.swan.apps.t.b.j jVar, int i, int i2) {
                h.this.aKx();
                h.this.a(h.this.doK, "3010001");
                return true;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(com.baidu.swan.apps.t.b.j jVar) {
                h.this.aKt();
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
        if (this.doI == null) {
            this.doI = new com.baidu.swan.games.view.a() { // from class: com.baidu.swan.game.ad.e.h.7
                @Override // com.baidu.swan.games.view.a
                public void aKI() {
                    h.this.doP = true;
                    if (h.this.doQ) {
                        h.this.aKz();
                    }
                }

                @Override // com.baidu.swan.games.view.a
                public void aKJ() {
                    h.this.doP = false;
                    h.this.aII();
                }

                @Override // com.baidu.swan.games.view.a
                public void onViewDestroy() {
                }
            };
            com.baidu.swan.games.view.a.c.a(this.doI);
        }
        this.doG.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (h.this.bVg != null) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                    h.this.doQ = true;
                    if (h.this.doP) {
                        h.this.aKz();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    h.this.doQ = false;
                }
            }
        }
    }

    private com.baidu.swan.game.ad.c.b la(int i) {
        int i2;
        com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
        bVar.dnC = String.valueOf(this.dll.getDuration());
        bVar.dnD = String.valueOf(this.mPausePosition);
        bVar.mEndTime = String.valueOf(i);
        bVar.dnE = this.mPausePosition == 0 ? "1" : "0";
        bVar.dnF = i == this.dll.getDuration() ? "1" : "0";
        bVar.dnG = this.mContext.getResources().getConfiguration().orientation == 1 ? "2" : "4";
        if (this.mPausePosition == 0) {
            i2 = 1;
        } else if (this.mPausePosition == this.dll.getDuration()) {
            i2 = 3;
        } else {
            i2 = 2;
        }
        bVar.mType = String.valueOf(i2);
        bVar.dnH = (this.mPausePosition == 0 && SwanAppNetworkUtils.isWifiNetworkConnected(this.mContext)) ? "1" : "2";
        bVar.mStatus = String.valueOf(0);
        return bVar;
    }

    public String getType() {
        return this.dmG ? "gdtvideo" : "video";
    }

    private int aKB() {
        return (this.bVg == null || !this.bVg.isEnd()) ? getProgress() : this.bVg.getDuration() / 1000;
    }

    @Override // com.baidu.swan.game.ad.a.a.d
    public void cC(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                jSONObject.put("title", this.dll.getTitle());
                jSONObject.put("description", this.dll.getDescription());
                jSONObject.put("autoinstall", true);
                if (this.doX == null) {
                    this.doX = new g(this.mContext, this.dll, this.dle);
                }
                this.doX.pJ(str);
                com.baidu.swan.apps.t.a.apE().a(this.mContext, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.doX);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void aF(View view) {
        if (this.dmG && this.dll != null) {
            com.baidu.swan.game.ad.c.d.d(this.dll, this.dle);
            com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
            bVar.dnu = String.valueOf(ah.getDisplayWidth(this.mContext));
            bVar.dnv = String.valueOf(ah.getDisplayHeight(this.mContext));
            bVar.dnw = String.valueOf(ah.getDisplayWidth(this.mContext));
            bVar.dnx = String.valueOf(ah.getDisplayHeight(this.mContext));
            bVar.dny = String.valueOf((int) view.getX());
            bVar.dnz = String.valueOf((int) view.getY());
            bVar.dnA = String.valueOf((int) view.getX());
            bVar.dnB = String.valueOf((int) view.getY());
            if (this.dll.getActionType() == 2) {
                com.baidu.swan.game.ad.c.d.a(bVar, this.dll, this.dle, this);
                return;
            }
            com.baidu.swan.apps.core.d.f YG = com.baidu.swan.apps.v.f.asJ().YG();
            if (YG == null) {
                if (this.mContext != null) {
                    com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                }
            } else if (this.dll != null) {
                String a2 = com.baidu.swan.game.ad.c.d.a(this.dll.aJB(), bVar);
                YG.lH("adLanding").al(com.baidu.swan.apps.core.d.f.ckl, com.baidu.swan.apps.core.d.f.ckn).a("adLanding", com.baidu.swan.apps.model.b.bP(a2, a2)).aih();
            }
        }
    }
}
