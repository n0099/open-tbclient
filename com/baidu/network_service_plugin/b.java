package com.baidu.network_service_plugin;

import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.network_service_plugin.FlutterNetModelAuto;
import com.baidu.network_service_plugin.a;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.im.settingcache.d;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
/* loaded from: classes6.dex */
public class b implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private static com.baidu.adp.framework.listener.c btx = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_UPDATE_MASK_INFO) { // from class: com.baidu.network_service_plugin.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                Message<?> orginalMessage = responseUpdateMaskInfoMessage.getOrginalMessage();
                if (orginalMessage instanceof RequestUpdateMaskInfoMessage) {
                    RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                    if (requestUpdateMaskInfoMessage.getMaskType() == 12) {
                        final boolean z = requestUpdateMaskInfoMessage.getIsMask() == 0;
                        if (responseUpdateMaskInfoMessage.getError() != 0) {
                            l.showToast(TbadkCoreApplication.getInst(), "网络不稳定，请稍后再试");
                            return;
                        }
                        final String list = requestUpdateMaskInfoMessage.getList();
                        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.network_service_plugin.b.1.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                            public Void doInBackground(Void... voidArr) {
                                if (!TextUtils.isEmpty(list)) {
                                    d.cpr().z(TbadkApplication.getCurrentAccount(), list, z);
                                }
                                return null;
                            }
                        }.execute(new Void[0]);
                    }
                }
            }
        }
    };
    private HashMap<String, a> btw = new HashMap<>();

    /* loaded from: classes6.dex */
    public interface a {
        boolean cancelLoadData();
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MessageManager.getInstance().registerListener(btx);
        new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "network_service_plugin").setMethodCallHandler(new b());
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    public void onMethodCall(MethodCall methodCall, final MethodChannel.Result result) {
        FlutterNetModelAuto a2;
        Object obj;
        if (methodCall.method.equals("getPlatformVersion")) {
            result.success("Android " + Build.VERSION.RELEASE);
        } else if (methodCall.method.equals("loadData")) {
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
            if (booleanValue) {
                BdUniqueId gen = BdUniqueId.gen();
                int gp = c.gp(str2);
                h a3 = c.a(gp, hashMap, hashMap2);
                if (gp != 0 && a3 != null) {
                    FlutterNetModelAuto F = c.F(str3, gp);
                    F.setUniqueId(gen);
                    F.go(str2);
                    F.a(new FlutterNetModelAuto.a() { // from class: com.baidu.network_service_plugin.b.2
                        @Override // com.baidu.network_service_plugin.FlutterNetModelAuto.a
                        public void a(String str4, HashMap hashMap5, MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
                            b.this.btw.remove(str4);
                            result.success(b.this.a(hashMap5, null, mvcHttpResponsedMessage.getError(), mvcHttpResponsedMessage.getErrorString(), str4));
                        }
                    });
                    this.btw.put(str3, F);
                    try {
                        F.loadData();
                        return;
                    } catch (Exception e) {
                        BdLog.e("netModel loadData exception" + e.toString());
                        return;
                    }
                }
                return;
            }
            com.baidu.network_service_plugin.a aVar = new com.baidu.network_service_plugin.a(str3);
            aVar.go(str2);
            aVar.a(new a.b() { // from class: com.baidu.network_service_plugin.b.3
                @Override // com.baidu.network_service_plugin.a.b
                public void a(HashMap<String, String> hashMap5, HashMap<String, String> hashMap6, int i, String str4, Object obj2, String str5) {
                    b.this.btw.remove(str5);
                    HashMap a4 = b.this.a(hashMap5, obj2, i, str4, str5);
                    if (hashMap4 != null && (hashMap4.get("performance") instanceof Boolean) && ((Boolean) hashMap4.get("performance")).booleanValue()) {
                        HashMap hashMap7 = new HashMap();
                        hashMap7.put("network", hashMap6);
                        hashMap7.put("send_time", Long.valueOf(System.currentTimeMillis()));
                        a4.put("performInfo", hashMap7);
                    }
                    result.success(a4);
                }
            });
            if (hashMap3 != null && (hashMap3 instanceof Map) && (obj = hashMap3.get("debugfile")) != null && (obj instanceof String)) {
                byte[] bytes = ((String) obj).getBytes();
                if (bytes.length > 3145728) {
                    result.error("file is too big", "", (Object) null);
                    return;
                }
                hashMap2.put("debugfile", bytes);
                hashMap2.put("type", "android");
                aVar.cP(true);
            }
            aVar.setParams(hashMap2);
            this.btw.put(str3, aVar);
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
                a aVar2 = this.btw.get((String) map.get("identifier"));
                if (aVar2 != null) {
                    aVar2.cancelLoadData();
                }
            }
        } else if (methodCall.method.equals("sendImMessage")) {
            int intValue = ((Integer) methodCall.argument("msgId")).intValue();
            String str5 = (String) methodCall.argument("identifier");
            HashMap hashMap5 = (HashMap) methodCall.argument("params");
            if (intValue == 104102) {
                a2 = c.a(str5, intValue, hashMap5);
            } else {
                a2 = intValue == 107129 ? c.a(str5, intValue, hashMap5) : null;
            }
            if (a2 == null) {
                result.error("-1", "ImNetModel init fail :" + intValue, (Object) null);
                return;
            }
            a2.a(new FlutterNetModelAuto.b() { // from class: com.baidu.network_service_plugin.b.4
                @Override // com.baidu.network_service_plugin.FlutterNetModelAuto.b
                public void a(String str6, HashMap hashMap6, SocketResponsedMessage socketResponsedMessage, SocketMessage socketMessage, NetMessage netMessage) {
                    b.this.btw.remove(str6);
                    result.success(b.this.a(hashMap6, c.d(socketResponsedMessage), socketResponsedMessage.getError(), socketResponsedMessage.getErrorString(), str6));
                }
            });
            a2.setUniqueId(BdUniqueId.gen());
            this.btw.put(str5, a2);
            if (a2 != null) {
                try {
                    a2.loadData();
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
