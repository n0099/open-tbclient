package com.baidu.k;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.a.h;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class a implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private static CustomMessageListener PN = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.k.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                try {
                    j.isNetWorkAvailable();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
                a.mMethodChannel.invokeMethod("setNetInfo", a.adg());
            }
        }
    };
    private static MethodChannel mMethodChannel;

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        mMethodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "network_info");
        mMethodChannel.setMethodCallHandler(new a());
        init();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    private static void init() {
        MessageManager.getInstance().registerListener(PN);
    }

    static HashMap adg() {
        HashMap hashMap = new HashMap();
        hashMap.put("isNetWorkAvailable", Boolean.valueOf(j.isNetWorkAvailable()));
        hashMap.put("netType", Integer.valueOf(j.netType()));
        String netType = h.getNetType();
        if (netType != null) {
            hashMap.put("getNetTypeString", netType);
        }
        return hashMap;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        HashMap hashMap;
        if (methodCall.method.equals("isNetWorkAvailable")) {
            result.success(Boolean.valueOf(j.isNetWorkAvailable()));
        } else if (methodCall.method.equals("isNetworkAvailableForImmediately")) {
            result.success(Boolean.valueOf(j.isNetworkAvailableForImmediately()));
        } else if (methodCall.method.equals("getNetInfo")) {
            result.success(adg());
        } else if (methodCall.method.equals("getDnsIp")) {
            String str = (String) methodCall.argument("url");
            HashMap hashMap2 = new HashMap();
            try {
                hashMap = jU(str);
            } catch (Exception e) {
                hashMap = hashMap2;
            }
            result.success(hashMap);
        } else if (methodCall.method.equals("jumpRealNameAuthWebActivity")) {
            adh();
        }
    }

    String a(BDHttpDnsResult.ResolveType resolveType) {
        if (resolveType == BDHttpDnsResult.ResolveType.RESOLVE_NONE) {
            return "BDHttpDnsResult.ResolveType.RESOLVE_NONE";
        }
        if (resolveType == BDHttpDnsResult.ResolveType.RESOLVE_NONEED) {
            return "BDHttpDnsResult.ResolveType.RESOLVE_NONEED";
        }
        if (resolveType == BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE) {
            return "BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_CACHE";
        }
        if (resolveType == BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE) {
            return "BDHttpDnsResult.ResolveType.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE";
        }
        if (resolveType == BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE) {
            return "BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS_CACHE";
        }
        if (resolveType == BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS) {
            return "BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS";
        }
        return "";
    }

    String a(BDHttpDnsResult.ResolveStatus resolveStatus) {
        if (resolveStatus == BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK) {
            return "BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK";
        }
        if (resolveStatus == BDHttpDnsResult.ResolveStatus.BDHttpDnsInputError) {
            return "BDHttpDnsResult.ResolveStatus.BDHttpDnsInputError";
        }
        if (resolveStatus == BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorCacheMiss) {
            return "BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorCacheMiss";
        }
        if (resolveStatus == BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorDnsResolve) {
            return "BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorDnsResolve";
        }
        return "";
    }

    private HashMap jU(String str) throws Exception {
        String host;
        HashMap hashMap = new HashMap();
        URL url = new URL(str);
        if (!TextUtils.isEmpty(str)) {
            try {
                host = url.getHost();
            } catch (Exception e) {
                BdLog.e(e);
            }
            if (!TextUtils.isEmpty(host)) {
                if (host.contains("hiphotos.baidu.com")) {
                    host = "hiphotos.baidu.com";
                }
                BDHttpDnsResult j = BDHttpDns.Q(BdBaseApplication.getInst().getApplicationContext()).j(host, true);
                if (j != null) {
                    hashMap.put("dnsResolveType", a(j.sZ()));
                    hashMap.put("dnsResolveStatus", a(j.ta()));
                    ArrayList<String> tb = j.tb();
                    if (tb != null && tb.size() > 0) {
                        hashMap.put("dnsIpList", tb);
                        return hashMap;
                    }
                }
            }
        }
        com.baidu.adp.lib.network.http.a ml = com.baidu.adp.lib.network.http.a.ml();
        if (ml != null) {
            String bL = ml.bL(str);
            if (!TextUtils.isEmpty(bL)) {
                hashMap.put("dnsIp", bL);
            }
        }
        return hashMap;
    }

    private void adh() {
        Context applicationContext = TbadkCoreApplication.getInst().getApplicationContext();
        StringBuilder sb = new StringBuilder(UrlSchemaHelper.REAL_NAME_AUTH_URL);
        sb.append("&u=").append(URLEncoder.encode(UrlSchemaHelper.FINISH_THIS_WEBVIEW));
        com.baidu.tbadk.browser.a.startWebActivity(applicationContext, "", sb.toString(), true, true, true, true, true, false);
    }
}
