package com.baidu.network_service_plugin;

import android.os.Build;
import android.support.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.network_service_plugin.FlutterNetModelAuto;
import com.baidu.network_service_plugin.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
/* loaded from: classes10.dex */
public class b implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private HashMap<String, a> cfW = new HashMap<>();

    /* loaded from: classes10.dex */
    public interface a {
        boolean cancelLoadData();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "network_service_plugin").setMethodCallHandler(new b());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, final MethodChannel.Result result) {
        Object obj;
        if (methodCall.method.equals("getPlatformVersion")) {
            result.success("Android " + Build.VERSION.RELEASE);
        } else if (methodCall.method.equals("loadData")) {
            final long currentTimeMillis = System.currentTimeMillis();
            String str = (String) methodCall.argument("host");
            String str2 = (String) methodCall.argument("address");
            ((Integer) methodCall.argument("cmd")).intValue();
            HashMap hashMap = (HashMap) methodCall.argument("headers");
            HashMap<String, Object> hashMap2 = (HashMap) methodCall.argument("params");
            HashMap hashMap3 = (HashMap) methodCall.argument("fileParams");
            String str3 = (String) methodCall.argument("identifier");
            final HashMap hashMap4 = (HashMap) methodCall.argument("extra");
            boolean booleanValue = methodCall.hasArgument("useProto") ? ((Boolean) methodCall.argument("useProto")).booleanValue() : false;
            if (str2.startsWith("/")) {
                str2 = str2.substring(1);
            }
            if (!str2.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                str2 = str + "/" + str2;
            }
            hashMap2.put("tbs", TbadkCoreApplication.getInst().getTbs());
            hashMap2.put("sdk_ver", TbadkCoreApplication.getInst().getSdk_ver());
            hashMap2.put("framework_ver", TbadkCoreApplication.getInst().getFramework_ver());
            hashMap2.put("swan_game_ver", TbadkCoreApplication.getInst().getSwan_game_ver());
            if (booleanValue) {
                BdUniqueId gen = BdUniqueId.gen();
                int jT = c.jT(str2);
                h a2 = c.a(jT, hashMap, hashMap2);
                if (jT != 0 && a2 != null) {
                    FlutterNetModelAuto J = c.J(str3, jT);
                    J.setUniqueId(gen);
                    J.jS(str2);
                    J.a(new FlutterNetModelAuto.a() { // from class: com.baidu.network_service_plugin.b.1
                        @Override // com.baidu.network_service_plugin.FlutterNetModelAuto.a
                        public void a(String str4, HashMap hashMap5, MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
                            b.this.cfW.remove(str4);
                            if (hashMap5 != null) {
                                hashMap5.put("start_time", String.valueOf(currentTimeMillis));
                            }
                            result.success(b.this.a(hashMap5, null, mvcHttpResponsedMessage.getError(), mvcHttpResponsedMessage.getErrorString(), str4));
                        }
                    });
                    this.cfW.put(str3, J);
                    try {
                        J.loadData();
                        return;
                    } catch (Exception e) {
                        BdLog.e("netModel loadData exception" + e.toString());
                        return;
                    }
                }
                return;
            }
            com.baidu.network_service_plugin.a aVar = new com.baidu.network_service_plugin.a(str3);
            aVar.jS(str2);
            aVar.a(new a.b() { // from class: com.baidu.network_service_plugin.b.2
                @Override // com.baidu.network_service_plugin.a.b
                public void a(HashMap<String, String> hashMap5, HashMap<String, String> hashMap6, int i, String str4, Object obj2, String str5) {
                    b.this.cfW.remove(str5);
                    if (hashMap5 != null) {
                        hashMap5.put("start_time", String.valueOf(currentTimeMillis));
                    }
                    HashMap a3 = b.this.a(hashMap5, obj2, i, str4, str5);
                    if (hashMap4 != null && (hashMap4.get("performance") instanceof Boolean) && ((Boolean) hashMap4.get("performance")).booleanValue()) {
                        HashMap hashMap7 = new HashMap();
                        hashMap7.put("network", hashMap6);
                        hashMap7.put("send_time", Long.valueOf(System.currentTimeMillis()));
                        a3.put("performInfo", hashMap7);
                    }
                    result.success(a3);
                }
            });
            if (hashMap3 != null && (hashMap3 instanceof Map) && (obj = hashMap3.get("debugfile")) != null && (obj instanceof byte[])) {
                byte[] bArr = (byte[]) obj;
                if (bArr.length > 3145728) {
                    result.error("file is too big", "", null);
                    return;
                }
                hashMap2.put("debugfile", bArr);
                hashMap2.put("type", "android");
                aVar.dX(true);
            }
            aVar.setParams(hashMap2);
            this.cfW.put(str3, aVar);
            try {
                aVar.loadData();
            } catch (Exception e2) {
                BdLog.e("netModel loadData exception" + e2.toString());
            }
        } else if (methodCall.method.equals("cancel")) {
            List list = (List) methodCall.arguments;
            for (int i = 0; i < list.size(); i++) {
                Map map = (Map) list.get(i);
                String str4 = (String) map.get("api");
                ((Integer) map.get("cmd")).intValue();
                a aVar2 = this.cfW.get((String) map.get("identifier"));
                if (aVar2 != null) {
                    aVar2.cancelLoadData();
                }
            }
        } else if (methodCall.method.equals("sendImMessage")) {
            int intValue = ((Integer) methodCall.argument("msgId")).intValue();
            String str5 = (String) methodCall.argument("identifier");
            final FlutterNetModelAuto a3 = c.a(str5, intValue, (HashMap) methodCall.argument("params"));
            if (a3 == null) {
                result.error("-1", "ImNetModel init fail :" + intValue, null);
                return;
            }
            a3.a(new FlutterNetModelAuto.b() { // from class: com.baidu.network_service_plugin.b.3
                @Override // com.baidu.network_service_plugin.FlutterNetModelAuto.b
                public void a(String str6, HashMap hashMap5, SocketResponsedMessage socketResponsedMessage, SocketMessage socketMessage, NetMessage netMessage) {
                    b.this.cfW.remove(str6);
                    a3.a((FlutterNetModelAuto.b) null);
                    result.success(b.this.a(hashMap5, c.d(socketResponsedMessage), socketResponsedMessage.getError(), socketResponsedMessage.getErrorString(), str6));
                }
            });
            a3.setUniqueId(BdUniqueId.gen());
            this.cfW.put(str5, a3);
            if (a3 != null) {
                try {
                    a3.loadData();
                } catch (Exception e3) {
                    BdLog.e("netModel loadData exception" + e3.toString());
                }
            }
        } else {
            result.notImplemented();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap a(HashMap<String, String> hashMap, Object obj, int i, String str, String str2) {
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        hashMap3.put(BaseJsonData.TAG_ERRNO, Integer.valueOf(i));
        hashMap3.put(BaseJsonData.TAG_ERRMSG, str);
        if (i == -1 && "cancle".equals(str)) {
            hashMap3.put("canceled", true);
        }
        hashMap2.put("requestInfo", hashMap);
        hashMap2.put("identifier", str2);
        hashMap2.put("errorInfo", hashMap3);
        if (i == 0) {
            hashMap2.put("data", obj);
        }
        return hashMap2;
    }
}
