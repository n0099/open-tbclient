package b.a.p0.f.i.n;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.bridge.BridgeJavascript;
import com.baidu.swan.game.ad.jsbridge.CommandType;
import com.baidu.swan.game.ad.view.RewardWebView;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.p0.f.i.l.a f9831a;

    /* renamed from: b  reason: collision with root package name */
    public RewardWebView f9832b;

    /* renamed from: c  reason: collision with root package name */
    public Context f9833c;

    /* renamed from: d  reason: collision with root package name */
    public String f9834d;

    /* renamed from: b.a.p0.f.i.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0523a implements ValueCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0523a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9834d = null;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f9832b == null) {
            return;
        }
        try {
            if (!str.startsWith("javascript:")) {
                str = "javascript:" + str;
            }
            this.f9832b.evaluateJavascript(str, new C0523a(this));
        } catch (Exception unused) {
        }
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        a("window.mobadssdkbridge.fireAnonymousEvent('" + str + "', '" + str2 + "')");
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            a("window.mobadssdkbridge && window.mobadssdkbridge.nativeCallComplete && window.mobadssdkbridge.nativeCallComplete(" + JSONObject.quote(str) + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    public final int d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            try {
                return context.getApplicationContext().getApplicationInfo().targetSdkVersion;
            } catch (Exception e2) {
                e2.printStackTrace();
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public boolean e(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048580, this, uri)) != null) {
            return invokeL.booleanValue;
        }
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        String host = uri.getHost();
        CommandType fromJavascriptString = CommandType.fromJavascriptString(host);
        try {
            if (BridgeJavascript.BRIDGE_SCHEME.equals(scheme)) {
                if (this.f9831a != null) {
                    this.f9831a.b(fromJavascriptString, uri);
                }
                try {
                    c(host);
                } catch (Exception unused) {
                }
                return true;
            }
        } catch (Exception unused2) {
        } catch (Throwable th) {
            try {
                c(host);
            } catch (Exception unused3) {
            }
            throw th;
        }
        try {
            c(host);
        } catch (Exception unused4) {
            return false;
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f9834d = b.f9835a + BridgeJavascript.JAVASCRIPT_SOURCE_SUFFIX;
            if (h()) {
                return;
            }
            a("javascript:(function() {\n    window.baidu = {};\n    window.baidu.mobads = {};\n    window.baidu.mobads.Sdk = {\n        isIOS: false\n    };\n    window.mobadssdkbridge = window.mobadssdkbridge || {} \n    var Sdk = window.baidu.mobads.Sdk;\n    Sdk.isIOS = (/iphone|ipad|ipod/i).test(window.navigator.userAgent.toLowerCase());\n    var mob = window.baidu.mobads;\n    mob.Act = {\n        LP: 1,\n        DL: 2,\n        MAP: 4,\n        SMS: 8,\n        MAIL: 16,\n        PHONE: 32,\n        VIDEO: 64,\n        RM: 128,\n        NA: 256,\n        APO: 512\n    };\n    var win = window;\n    win.MobadsSdk = win.MobadsSdk || {};\n    var MobadsSdk = win.MobadsSdk;\n    var send3rdLog = function(isShowLog, ad) {\n        if (!ad || !ad.mon) {\n            return;\n        }\n        var url;\n        for (var i = 0; i < ad.mon.length; ++i) {\n            url = isShowLog ? ad.mon[i].s: ad.mon[i].c;\n            if (!url) {\n                continue;\n            }\n            new Image().src = url;\n        }\n    };\n     function createUniqueId(n = 12) { // 生成n位长度的字符串\n         var str = 'abcdefghijklmnopqrstuvwxyz0123456789'; // 可以作为常量放到random外面 \n         let result = '';\n         for (let i = 0; i < n; i++) {\n             result += str[parseInt(Math.random() * str.length, 10)];\n         } \n         return result;\n     };\n     // 执行回调 \n     window.mobadssdkbridge.fireAnonymousEvent = function (token = '', res = '') { \n         var jssdkNamespace = window['__baidu_adserv'] || {};\n         var callback = jssdkNamespace['baidu_' + token];\n         if (callback) { \n             let callbackRes; \n             try {\n                 callbackRes = res && JSON.parse(res); \n             } catch (e) { \n                 callbackRes = res;\n             }\n             callback(callbackRes); \n             delete jssdkNamespace['baidu_' + token]; \n         }\n     };     Sdk.device = 'baidubox';\n     Sdk.isSupportPause = 'YES';\n    Sdk.setActionUrl = function(url, inapp, act, title, close) {\n        var opt = {};\n        if (\"[object Object]\" === Object.prototype.toString.call(url)) {\n            opt = url;\n            url = opt.url;\n            inapp = opt.inapp;\n            act = opt.act;\n            title = opt.title;\n            close = opt.close;\n               if (opt.allParamsJson) {\n                   if (opt.allParamsJson.action) {\n                       opt.action = opt.allParamsJson.action;\n                       opt.v_video = opt.allParamsJson.v_video || \"\";\n                       opt.v_video_w = opt.allParamsJson.v_video_w || \"\";\n                       opt.v_video_h = opt.allParamsJson.v_video_h || \"\";\n                       opt.v_image = opt.allParamsJson.v_image || \"\";\n                       opt.v_url = opt.allParamsJson.v_url || \"\";\n                       opt.allParamsJson = null;\n                   }\n               }\n        }\n        opt.url = url || \"\";\n        opt.inapp = inapp || false;\n        opt.act = act || 1;\n        opt.title = title || \"\";\n        opt.close = close || false;\n        opt.logurl = opt.logurl || \"\";\n        opt.weibo = opt.weibo || \"\";\n        opt.map = opt.map || \"\";\n        opt.search = opt.search || \"\";\n        opt.sms = opt.sms || \"\";\n        opt.at = opt.at || 1;\n        opt.tid = opt.tid || \"\";\n        if (MobadsSdk.setActionUrl) {\n            var DUMP_PAR = opt.inapp;\n            MobadsSdk.setActionUrl(JSON.stringify(opt), DUMP_PAR)\n        }\n    };\n    Sdk.sendClickLog = function(logurl) {\n        new Image().src = logurl;\n    };\n    Sdk.onAdPlayEnd = function() {\n        if (MobadsSdk.onAdPlayEnd) {\n            setTimeout(function() {\n                MobadsSdk.onAdPlayEnd();\n            },\n            300);\n        }\n    };\n    Sdk.open = function(url, options) {\n        var option = {\n            url: url,\n            inapp: true,\n            act: mob.Act.LP,\n            allParamsJson: options\n        };\n        Sdk.setActionUrl(option);\n        send3rdLog(false, options);\n    };\n    Sdk.startDownload = function(url, options) {\n        var ad = {};\n        ad = options || {};\n        ad.tit = options && options.tit || options.appname || \"应用\";\n        var mobadsJumpUrl = url;\n        if (/^itms-services:\\/\\//.test(url)) {\n            Sdk.setActionUrl(url, false, mob.Act.DL, ad.tit, true);\n            return;\n        }\n        if (Sdk.isIOS) {\n            var tid = options && options.pinfo && options.pinfo.tid;\n            if (tid) {\n                Sdk.sendClickLog(mobadsJumpUrl);\n            }\n            Sdk.setActionUrl({\n                url: url,\n                tid: tid || \"\",\n                inapp: true,\n                act: mob.Act.DL\n            });\n            return;\n        }\n        var mon = options && options.mon || [];\n        var id = options && options.id || 1;\n        var pk = options && options.pk || \"\";\n        var qk = options && options.qk || \"\";\n        var exp2 = options && options.exp2 || {};\n        var apoObj = options && options.apo || {};\n        var wi = options && options.wi ? true: false;\n        var title = ad.tit;\n        Sdk.setActionUrl({\n            url: mobadsJumpUrl,\n            act: mob.Act.DL,\n            apo: JSON.stringify(apoObj),\n            close: true,\n            adid: id,\n            originUrl: mobadsJumpUrl,\n            dlTunnel: 3,\n            autoOpen: true,\n            popNotif: true,\n            canCancel: true,\n            canDelete: 5,\n            mon: mon,\n            pk: pk,\n            qk: qk,\n            adid: id,\n            title: ad.tit,\n            action: options.action,\n            allParamsJson: options \n        });\n        send3rdLog(false, options);\n    };\n    Sdk.openScheme = function(url, options) {\n        var ad = {};\n        ad = options || {};\n        ad.tit = options && options.tit || \"应用\";\n        var pk = options && options.pk || \"\";\n        var option = {\n            url: url,\n            inapp: true,\n            act: ad.act,\n            title: ad.tit,\n            close: true,\n            pk: pk\n        };\n        Sdk.setActionUrl(option);\n        send3rdLog(false, options);\n    };\n    Sdk.handleClick = function(options) {\n        var ad = options || {};\n        var Act = mob.Act;\n        if (Act.LP === ad.act) {\n            Sdk.open(ad.curl, ad);\n        } else if (Act.DL === ad.act) {\n            Sdk.startDownload(ad.curl, ad);\n        } else if (Act.APO === ad.act) {\n            new Image().src = ad.curl;\n            Sdk.openScheme(ad.apo, ad);\n        }\n    };\n    Sdk.onAdPlayEnd = function() {\n        if (MobadsSdk.onAdPlayEnd) {\n            MobadsSdk.onAdPlayEnd();\n        }\n    };\n    Sdk.needsAdIcon = function() {\n        return true;\n    };\n    Sdk.getAdViewState = function(callback) {\n        if (!MobadsSdk || !MobadsSdk.getAdViewState) {\n            callback('BaiduMobAdSpamOK');\n            return;\n        }\n        MobadsSdk.getAdViewState(MobadsSdk.addAnonymousEvent(function(state) {\n            var iState = parseInt(state);\n            var sState = 'BaiduMobAdSpamOK';\n            if (iState != 0) {\n                sState = 'BaiduMobAdSpamNotOK';\n            }\n            callback(sState);\n        }));\n    };\n     // 注册回调 \n    Sdk.natRegEv = function (callback) { \n         var mobadsSdk = window['MobadsSdk'] || {};\n         var jssdkNamespace = mobadsSdk.__anoymousEvents || {}\n         var token = createUniqueId(14); \n         jssdkNamespace[token] = callback || function () { \n         }\n         mobadsSdk.__anoymousEvents = jssdkNamespace\n         return token;\n     };\n     // 获取下载状态 \n    Sdk.getDownloadStatus = function (callback, pkg) { \n         if (MobadsSdk.getDownloadStatus) {\n             var token = Sdk.natRegEv(callback);\n             MobadsSdk.getDownloadStatus(token, pkg);\n         } \n     };\n     Sdk.pauseDownload = function (pkg) { \n         if (MobadsSdk.pauseDownload) { \n             MobadsSdk.pauseDownload(pkg); \n         } \n     };\n})();");
            a(this.f9834d);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && h() && !TextUtils.isEmpty(this.f9834d)) {
            a(this.f9834d);
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? Build.VERSION.SDK_INT >= 24 || d(this.f9833c) >= 24 : invokeV.booleanValue;
    }

    public void i(b.a.p0.f.i.l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f9831a = aVar;
        }
    }

    public void j(RewardWebView rewardWebView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, rewardWebView) == null) || rewardWebView == null) {
            return;
        }
        this.f9832b = rewardWebView;
        this.f9833c = rewardWebView.getContext().getApplicationContext();
        this.f9832b.loadUrl("javascript:(function(){})()");
        f();
        a(String.format(BridgeJavascript.JS_SET_PLACEMENT_TYPE, "inline"));
    }
}
