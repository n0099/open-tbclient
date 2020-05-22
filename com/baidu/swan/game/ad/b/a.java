package com.baidu.swan.game.ad.b;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.baidu.swan.game.ad.RewardWebView;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private AdElementInfo cPP;
    private String cQS = "setActionUrl";
    private String cQT = "inline";
    private String cQU = null;
    private RewardWebView cQw;
    private c cQz;
    private Context mAppContext;

    public a(RewardWebView rewardWebView, c cVar, AdElementInfo adElementInfo) {
        this.cQz = cVar;
        this.cQw = rewardWebView;
        this.mAppContext = this.cQw.getContext().getApplicationContext();
        this.cPP = adElementInfo;
        if (Build.VERSION.SDK_INT >= 19) {
            this.cQw.loadUrl("javascript:(function(){})()");
        }
        awn();
        qy(String.format("javascript:(function(){window.mobadssdkbridge.setPlacementType('%s');})()", this.cQT));
    }

    private void awn() {
        this.cQU = b.cQW + ";}());";
        if (!awo()) {
            qy("javascript:(function() {\n    window.baidu = {};\n    window.baidu.mobads = {};\n    window.baidu.mobads.Sdk = {\n        isIOS: false\n    };\n    var Sdk = window.baidu.mobads.Sdk;\n    Sdk.isIOS = (/iphone|ipad|ipod/i).test(window.navigator.userAgent.toLowerCase());\n    var mob = window.baidu.mobads;\n    mob.Act = {\n        LP: 1,\n        DL: 2,\n        MAP: 4,\n        SMS: 8,\n        MAIL: 16,\n        PHONE: 32,\n        VIDEO: 64,\n        RM: 128,\n        NA: 256,\n        APO: 512\n    };\n    var win = window;\n    win.MobadsSdk = win.MobadsSdk || {};\n    var MobadsSdk = win.MobadsSdk;\n    var send3rdLog = function(isShowLog, ad) {\n        if (!ad || !ad.mon) {\n            return;\n        }\n        var url;\n        for (var i = 0; i < ad.mon.length; ++i) {\n            url = isShowLog ? ad.mon[i].s: ad.mon[i].c;\n            if (!url) {\n                continue;\n            }\n            new Image().src = url;\n        }\n    };\n    Sdk.setActionUrl = function(url, inapp, act, title, close) {\n        var opt = {};\n        if (\"[object Object]\" === Object.prototype.toString.call(url)) {\n            opt = url;\n            url = opt.url;\n            inapp = opt.inapp;\n            act = opt.act;\n            title = opt.title;\n            close = opt.close;\n               if (opt.allParamsJson) {\n                   if (opt.allParamsJson.action) {\n                       opt.action = opt.allParamsJson.action;\n                       opt.v_video = opt.allParamsJson.v_video || \"\";\n                       opt.v_video_w = opt.allParamsJson.v_video_w || \"\";\n                       opt.v_video_h = opt.allParamsJson.v_video_h || \"\";\n                       opt.v_image = opt.allParamsJson.v_image || \"\";\n                       opt.v_url = opt.allParamsJson.v_url || \"\";\n                       opt.allParamsJson = null;\n                   }\n               }\n        }\n        opt.url = url || \"\";\n        opt.inapp = inapp || false;\n        opt.act = act || 1;\n        opt.title = title || \"\";\n        opt.close = close || false;\n        opt.logurl = opt.logurl || \"\";\n        opt.weibo = opt.weibo || \"\";\n        opt.map = opt.map || \"\";\n        opt.search = opt.search || \"\";\n        opt.sms = opt.sms || \"\";\n        opt.at = opt.at || 1;\n        opt.tid = opt.tid || \"\";\n        if (MobadsSdk.setActionUrl) {\n            var DUMP_PAR = opt.inapp;\n            MobadsSdk.setActionUrl(JSON.stringify(opt), DUMP_PAR)\n        }\n    };\n    Sdk.sendClickLog = function(logurl) {\n        new Image().src = logurl;\n    };\n    Sdk.onAdPlayEnd = function() {\n        if (MobadsSdk.onAdPlayEnd) {\n            setTimeout(function() {\n                MobadsSdk.onAdPlayEnd();\n            },\n            300);\n        }\n    };\n    Sdk.open = function(url, options) {\n        var option = {\n            url: url,\n            inapp: true,\n            act: mob.Act.LP,\n            allParamsJson: options\n        };\n        Sdk.setActionUrl(option);\n        send3rdLog(false, options);\n    };\n    Sdk.startDownload = function(url, options) {\n        var ad = {};\n        ad = options || {};\n        ad.tit = options && options.tit || options.appname || \"应用\";\n        var mobadsJumpUrl = url;\n        if (/^itms-services:\\/\\//.test(url)) {\n            Sdk.setActionUrl(url, false, mob.Act.DL, ad.tit, true);\n            return;\n        }\n        if (Sdk.isIOS) {\n            var tid = options && options.pinfo && options.pinfo.tid;\n            if (tid) {\n                Sdk.sendClickLog(mobadsJumpUrl);\n            }\n            Sdk.setActionUrl({\n                url: url,\n                tid: tid || \"\",\n                inapp: true,\n                act: mob.Act.DL\n            });\n            return;\n        }\n        var mon = options && options.mon || [];\n        var id = options && options.id || 1;\n        var pk = options && options.pk || \"\";\n        var qk = options && options.qk || \"\";\n        var exp2 = options && options.exp2 || {};\n        var apoObj = options && options.apo || {};\n        var wi = options && options.wi ? true: false;\n        var title = ad.tit;\n        Sdk.setActionUrl({\n            url: mobadsJumpUrl,\n            act: mob.Act.DL,\n            apo: JSON.stringify(apoObj),\n            close: true,\n            adid: id,\n            originUrl: mobadsJumpUrl,\n            dlTunnel: 3,\n            autoOpen: true,\n            popNotif: true,\n            canCancel: true,\n            canDelete: 5,\n            mon: mon,\n            pk: pk,\n            qk: qk,\n            adid: id,\n            title: ad.tit,\n            action: options.action,\n            allParamsJson: options \n        });\n        send3rdLog(false, options);\n    };\n    Sdk.openScheme = function(url, options) {\n        var ad = {};\n        ad = options || {};\n        ad.tit = options && options.tit || \"应用\";\n        var pk = options && options.pk || \"\";\n        var option = {\n            url: url,\n            inapp: true,\n            act: ad.act,\n            title: ad.tit,\n            close: true,\n            pk: pk\n        };\n        Sdk.setActionUrl(option);\n        send3rdLog(false, options);\n    };\n    Sdk.handleClick = function(options) {\n        var ad = options || {};\n        var Act = mob.Act;\n        if (Act.LP === ad.act) {\n            Sdk.open(ad.curl, ad);\n        } else if (Act.DL === ad.act) {\n            Sdk.startDownload(ad.curl, ad);\n        } else if (Act.APO === ad.act) {\n            new Image().src = ad.curl;\n            Sdk.openScheme(ad.apo, ad);\n        }\n    };\n    Sdk.onAdPlayEnd = function() {\n        if (MobadsSdk.onAdPlayEnd) {\n            MobadsSdk.onAdPlayEnd();\n        }\n    };\n    Sdk.needsAdIcon = function() {\n        return true;\n    };\n    Sdk.getAdViewState = function(callback) {\n        if (!MobadsSdk || !MobadsSdk.getAdViewState) {\n            callback('BaiduMobAdSpamOK');\n            return;\n        }\n        MobadsSdk.getAdViewState(MobadsSdk.addAnonymousEvent(function(state) {\n            var iState = parseInt(state);\n            var sState = 'BaiduMobAdSpamOK';\n            if (iState != 0) {\n                sState = 'BaiduMobAdSpamNotOK';\n            }\n            callback(sState);\n        }));\n    };\n})();");
        }
        if (!awo()) {
            qy(this.cQU);
        }
    }

    public boolean awo() {
        return Build.VERSION.SDK_INT >= 24 || dj(this.mAppContext) >= 24;
    }

    public void awp() {
        if (awo() && !TextUtils.isEmpty(this.cQU)) {
            qy(this.cQU);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [109=4, 110=4] */
    public boolean k(Uri uri) {
        boolean z = false;
        if (uri != null) {
            String scheme = uri.getScheme();
            String host = uri.getHost();
            try {
                if ("mobadssdk".equals(scheme)) {
                    qw(host);
                    z = true;
                    try {
                        qx(host);
                    } catch (Exception e) {
                    }
                } else {
                    try {
                        qx(host);
                    } catch (Exception e2) {
                    }
                }
            } catch (Exception e3) {
                try {
                    qx(host);
                } catch (Exception e4) {
                }
            } catch (Throwable th) {
                try {
                    qx(host);
                } catch (Exception e5) {
                }
                throw th;
            }
        }
        return z;
    }

    private void qw(String str) {
        if (this.cQS.equals(str) && this.cQz != null) {
            this.cQz.a(this.cPP);
        }
    }

    private void qx(String str) {
        qy("window.mobadssdkbridge && window.mobadssdkbridge.nativeCallComplete && window.mobadssdkbridge.nativeCallComplete(" + JSONObject.quote(str) + ")");
    }

    public void qy(String str) {
        if (this.cQw != null) {
            try {
                if (!str.startsWith("javascript:")) {
                    str = "javascript:" + str;
                }
                if (Build.VERSION.SDK_INT < 19) {
                    this.cQw.loadUrl(str);
                } else {
                    this.cQw.evaluateJavascript(str, new ValueCallback<String>() { // from class: com.baidu.swan.game.ad.b.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str2) {
                        }
                    });
                }
            } catch (Exception e) {
            }
        }
    }

    private int dj(Context context) {
        try {
            return context.getApplicationContext().getApplicationInfo().targetSdkVersion;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
