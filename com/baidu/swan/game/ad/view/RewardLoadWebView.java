package com.baidu.swan.game.ad.view;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.bridge.BridgeJavascript;
import com.baidu.sapi2.SapiWebView;
import com.baidu.swan.game.ad.entity.AdElementInfo;
/* loaded from: classes3.dex */
public class RewardLoadWebView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public String f11615e;

    /* renamed from: f  reason: collision with root package name */
    public RewardWebView f11616f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.l0.f.i.n.a f11617g;

    /* loaded from: classes3.dex */
    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (RewardLoadWebView.this.f11617g.h()) {
                RewardLoadWebView.this.f11617g.a("javascript:(function() {\n    window.baidu = {};\n    window.baidu.mobads = {};\n    window.baidu.mobads.Sdk = {\n        isIOS: false\n    };\n    window.mobadssdkbridge = window.mobadssdkbridge || {} \n    var Sdk = window.baidu.mobads.Sdk;\n    Sdk.isIOS = (/iphone|ipad|ipod/i).test(window.navigator.userAgent.toLowerCase());\n    var mob = window.baidu.mobads;\n    mob.Act = {\n        LP: 1,\n        DL: 2,\n        MAP: 4,\n        SMS: 8,\n        MAIL: 16,\n        PHONE: 32,\n        VIDEO: 64,\n        RM: 128,\n        NA: 256,\n        APO: 512\n    };\n    var win = window;\n    win.MobadsSdk = win.MobadsSdk || {};\n    var MobadsSdk = win.MobadsSdk;\n    var send3rdLog = function(isShowLog, ad) {\n        if (!ad || !ad.mon) {\n            return;\n        }\n        var url;\n        for (var i = 0; i < ad.mon.length; ++i) {\n            url = isShowLog ? ad.mon[i].s: ad.mon[i].c;\n            if (!url) {\n                continue;\n            }\n            new Image().src = url;\n        }\n    };\n     function createUniqueId(n = 12) { // 生成n位长度的字符串\n         var str = 'abcdefghijklmnopqrstuvwxyz0123456789'; // 可以作为常量放到random外面 \n         let result = '';\n         for (let i = 0; i < n; i++) {\n             result += str[parseInt(Math.random() * str.length, 10)];\n         } \n         return result;\n     };\n     // 执行回调 \n     window.mobadssdkbridge.fireAnonymousEvent = function (token = '', res = '') { \n         var jssdkNamespace = window['__baidu_adserv'] || {};\n         var callback = jssdkNamespace['baidu_' + token];\n         if (callback) { \n             let callbackRes; \n             try {\n                 callbackRes = res && JSON.parse(res); \n             } catch (e) { \n                 callbackRes = res;\n             }\n             callback(callbackRes); \n             delete jssdkNamespace['baidu_' + token]; \n         }\n     };     Sdk.device = 'baidubox';\n     Sdk.isSupportPause = 'YES';\n    Sdk.setActionUrl = function(url, inapp, act, title, close) {\n        var opt = {};\n        if (\"[object Object]\" === Object.prototype.toString.call(url)) {\n            opt = url;\n            url = opt.url;\n            inapp = opt.inapp;\n            act = opt.act;\n            title = opt.title;\n            close = opt.close;\n               if (opt.allParamsJson) {\n                   if (opt.allParamsJson.action) {\n                       opt.action = opt.allParamsJson.action;\n                       opt.v_video = opt.allParamsJson.v_video || \"\";\n                       opt.v_video_w = opt.allParamsJson.v_video_w || \"\";\n                       opt.v_video_h = opt.allParamsJson.v_video_h || \"\";\n                       opt.v_image = opt.allParamsJson.v_image || \"\";\n                       opt.v_url = opt.allParamsJson.v_url || \"\";\n                       opt.allParamsJson = null;\n                   }\n               }\n        }\n        opt.url = url || \"\";\n        opt.inapp = inapp || false;\n        opt.act = act || 1;\n        opt.title = title || \"\";\n        opt.close = close || false;\n        opt.logurl = opt.logurl || \"\";\n        opt.weibo = opt.weibo || \"\";\n        opt.map = opt.map || \"\";\n        opt.search = opt.search || \"\";\n        opt.sms = opt.sms || \"\";\n        opt.at = opt.at || 1;\n        opt.tid = opt.tid || \"\";\n        if (MobadsSdk.setActionUrl) {\n            var DUMP_PAR = opt.inapp;\n            MobadsSdk.setActionUrl(JSON.stringify(opt), DUMP_PAR)\n        }\n    };\n    Sdk.sendClickLog = function(logurl) {\n        new Image().src = logurl;\n    };\n    Sdk.onAdPlayEnd = function() {\n        if (MobadsSdk.onAdPlayEnd) {\n            setTimeout(function() {\n                MobadsSdk.onAdPlayEnd();\n            },\n            300);\n        }\n    };\n    Sdk.open = function(url, options) {\n        var option = {\n            url: url,\n            inapp: true,\n            act: mob.Act.LP,\n            allParamsJson: options\n        };\n        Sdk.setActionUrl(option);\n        send3rdLog(false, options);\n    };\n    Sdk.startDownload = function(url, options) {\n        var ad = {};\n        ad = options || {};\n        ad.tit = options && options.tit || options.appname || \"应用\";\n        var mobadsJumpUrl = url;\n        if (/^itms-services:\\/\\//.test(url)) {\n            Sdk.setActionUrl(url, false, mob.Act.DL, ad.tit, true);\n            return;\n        }\n        if (Sdk.isIOS) {\n            var tid = options && options.pinfo && options.pinfo.tid;\n            if (tid) {\n                Sdk.sendClickLog(mobadsJumpUrl);\n            }\n            Sdk.setActionUrl({\n                url: url,\n                tid: tid || \"\",\n                inapp: true,\n                act: mob.Act.DL\n            });\n            return;\n        }\n        var mon = options && options.mon || [];\n        var id = options && options.id || 1;\n        var pk = options && options.pk || \"\";\n        var qk = options && options.qk || \"\";\n        var exp2 = options && options.exp2 || {};\n        var apoObj = options && options.apo || {};\n        var wi = options && options.wi ? true: false;\n        var title = ad.tit;\n        Sdk.setActionUrl({\n            url: mobadsJumpUrl,\n            act: mob.Act.DL,\n            apo: JSON.stringify(apoObj),\n            close: true,\n            adid: id,\n            originUrl: mobadsJumpUrl,\n            dlTunnel: 3,\n            autoOpen: true,\n            popNotif: true,\n            canCancel: true,\n            canDelete: 5,\n            mon: mon,\n            pk: pk,\n            qk: qk,\n            adid: id,\n            title: ad.tit,\n            action: options.action,\n            allParamsJson: options \n        });\n        send3rdLog(false, options);\n    };\n    Sdk.openScheme = function(url, options) {\n        var ad = {};\n        ad = options || {};\n        ad.tit = options && options.tit || \"应用\";\n        var pk = options && options.pk || \"\";\n        var option = {\n            url: url,\n            inapp: true,\n            act: ad.act,\n            title: ad.tit,\n            close: true,\n            pk: pk\n        };\n        Sdk.setActionUrl(option);\n        send3rdLog(false, options);\n    };\n    Sdk.handleClick = function(options) {\n        var ad = options || {};\n        var Act = mob.Act;\n        if (Act.LP === ad.act) {\n            Sdk.open(ad.curl, ad);\n        } else if (Act.DL === ad.act) {\n            Sdk.startDownload(ad.curl, ad);\n        } else if (Act.APO === ad.act) {\n            new Image().src = ad.curl;\n            Sdk.openScheme(ad.apo, ad);\n        }\n    };\n    Sdk.onAdPlayEnd = function() {\n        if (MobadsSdk.onAdPlayEnd) {\n            MobadsSdk.onAdPlayEnd();\n        }\n    };\n    Sdk.needsAdIcon = function() {\n        return true;\n    };\n    Sdk.getAdViewState = function(callback) {\n        if (!MobadsSdk || !MobadsSdk.getAdViewState) {\n            callback('BaiduMobAdSpamOK');\n            return;\n        }\n        MobadsSdk.getAdViewState(MobadsSdk.addAnonymousEvent(function(state) {\n            var iState = parseInt(state);\n            var sState = 'BaiduMobAdSpamOK';\n            if (iState != 0) {\n                sState = 'BaiduMobAdSpamNotOK';\n            }\n            callback(sState);\n        }));\n    };\n     // 注册回调 \n    Sdk.natRegEv = function (callback) { \n         var mobadsSdk = window['MobadsSdk'] || {};\n         var jssdkNamespace = mobadsSdk.__anoymousEvents || {}\n         var token = createUniqueId(14); \n         jssdkNamespace[token] = callback || function () { \n         }\n         mobadsSdk.__anoymousEvents = jssdkNamespace\n         return token;\n     };\n     // 获取下载状态 \n    Sdk.getDownloadStatus = function (callback, pkg) { \n         if (MobadsSdk.getDownloadStatus) {\n             var token = Sdk.natRegEv(callback);\n             MobadsSdk.getDownloadStatus(token, pkg);\n         } \n     };\n     Sdk.pauseDownload = function (pkg) { \n         if (MobadsSdk.pauseDownload) { \n             MobadsSdk.pauseDownload(pkg); \n         } \n     };\n})();");
            }
            RewardLoadWebView.this.f11617g.g();
            if (webView.getParent() != null) {
                ((View) webView.getParent()).setBackgroundResource(0);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                Uri parse = Uri.parse(str);
                if (BridgeJavascript.BRIDGE_SCHEME.equals(parse.getScheme())) {
                    return RewardLoadWebView.this.f11617g.e(parse);
                }
                return true;
            } catch (Exception unused) {
                return true;
            }
        }
    }

    public RewardLoadWebView(Context context) {
        super(context);
        this.f11615e = "";
    }

    public void b(String str, AdElementInfo adElementInfo, d.a.l0.f.i.n.a aVar) {
        if (TextUtils.equals("reward_banner_html", str)) {
            this.f11615e = adElementInfo.k();
        } else if (TextUtils.equals("reward_end_frame_html", str)) {
            this.f11615e = adElementInfo.s();
        } else if (TextUtils.equals("reward_banner_land_html", str)) {
            this.f11615e = adElementInfo.x();
        }
        this.f11617g = aVar;
        RewardWebView rewardWebView = new RewardWebView(getContext());
        this.f11616f = rewardWebView;
        rewardWebView.setWebViewClient(new a());
        this.f11617g.j(this.f11616f);
        this.f11616f.loadDataWithBaseURL(null, this.f11615e, SapiWebView.DATA_MIME_TYPE, "UTF-8", null);
        addView(this.f11616f, new RelativeLayout.LayoutParams(-1, -1));
    }

    public void c() {
        RewardWebView rewardWebView = this.f11616f;
        if (rewardWebView != null) {
            rewardWebView.destroy();
        }
    }
}
