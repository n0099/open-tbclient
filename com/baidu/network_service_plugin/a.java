package com.baidu.network_service_plugin;

import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.network_service_plugin.FlutterNetModel;
import com.baidu.sapi2.activity.SlideActiviy;
import com.baidu.searchbox.datachannel.Contract;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tieba.im.settingcache.d;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;
/* loaded from: classes6.dex */
public class a implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private static c aPE = new c(CmdConfigSocket.CMD_UPDATE_MASK_INFO) { // from class: com.baidu.network_service_plugin.a.1
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
                        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.network_service_plugin.a.1.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                            public Void doInBackground(Void... voidArr) {
                                if (!TextUtils.isEmpty(list)) {
                                    d.bYb().y(TbadkApplication.getCurrentAccount(), list, z);
                                }
                                return null;
                            }
                        }.execute(new Void[0]);
                    }
                }
            }
        }
    };
    protected BdUniqueId unique_id = BdUniqueId.gen();
    private HashMap<String, FlutterNetModel> aPD = new HashMap<>();

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MessageManager.getInstance().registerListener(aPE);
        new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "network_service_plugin").setMethodCallHandler(new a());
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    public void onMethodCall(MethodCall methodCall, final MethodChannel.Result result) {
        if (methodCall.method.equals("getPlatformVersion")) {
            result.success("Android " + Build.VERSION.RELEASE);
        } else if (methodCall.method.equals("isNetworkReachable")) {
            result.success(Boolean.valueOf(j.isNetWorkAvailable()));
        } else if (methodCall.method.equals("loadData")) {
            String str = (String) methodCall.argument(Contract.SCHEME_KEY_HOST);
            String str2 = (String) methodCall.argument(SlideActiviy.ADDRESS_PAGE_NAME);
            ((Integer) methodCall.argument("cmd")).intValue();
            HashMap hashMap = (HashMap) methodCall.argument("headers");
            HashMap<String, Object> hashMap2 = (HashMap) methodCall.argument("params");
            String str3 = (String) methodCall.argument("identifier");
            if (str2.startsWith("/")) {
                str2 = str2.substring(1);
            }
            if (!str2.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                str2 = str + "/" + str2;
            }
            hashMap2.put("tbs", TbadkCoreApplication.getInst().getTbs());
            FlutterNetModel flutterNetModel = new FlutterNetModel(FlutterNetModel.NetModelType.TYPE_NETWORK, str3);
            flutterNetModel.eJ(str2);
            flutterNetModel.a(new FlutterNetModel.c() { // from class: com.baidu.network_service_plugin.a.2
                @Override // com.baidu.network_service_plugin.FlutterNetModel.c
                public void a(HashMap<String, String> hashMap3, int i, String str4, Object obj, String str5) {
                    a.this.aPD.remove(str5);
                    result.success(a.this.a(hashMap3, obj, i, str4, str5));
                }
            });
            if (flutterNetModel == null) {
                result.error("init netModel fail!", "", "");
                return;
            }
            flutterNetModel.setUniqueId(this.unique_id);
            flutterNetModel.setParams(hashMap2);
            this.aPD.put(str3, flutterNetModel);
            try {
                flutterNetModel.loadData();
            } catch (Exception e) {
                BdLog.e("netModel loadData exception" + e.toString());
            }
        } else if (methodCall.method.equals(UgcUBCUtils.UGC_TIME_CANCEL)) {
            List list = (List) methodCall.arguments;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    Map map = (Map) list.get(i2);
                    String str4 = (String) map.get("api");
                    ((Integer) map.get("cmd")).intValue();
                    FlutterNetModel flutterNetModel2 = this.aPD.get((String) map.get("identifier"));
                    if (flutterNetModel2 != null) {
                        flutterNetModel2.cancelLoadData();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        } else if (methodCall.method.equals("sendImMessage")) {
            String str5 = (String) methodCall.argument("identifier");
            int intValue = ((Integer) methodCall.argument("msgId")).intValue();
            HashMap hashMap3 = (HashMap) methodCall.argument("params");
            if (intValue == 104102) {
                a(str5, result);
                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
                requestUpdateMaskInfoMessage.setIsMask(Integer.valueOf((String) hashMap3.get("isMask")).intValue());
                requestUpdateMaskInfoMessage.setMaskType(Integer.valueOf((String) hashMap3.get("type")).intValue());
                requestUpdateMaskInfoMessage.setList((String) hashMap3.get("list"));
                MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
            }
        } else {
            result.notImplemented();
        }
    }

    private void a(final String str, final MethodChannel.Result result) {
        MessageManager.getInstance().registerListener(new c(CmdConfigSocket.CMD_UPDATE_MASK_INFO) { // from class: com.baidu.network_service_plugin.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                    ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                    Message<?> orginalMessage = responseUpdateMaskInfoMessage.getOrginalMessage();
                    if ((orginalMessage instanceof RequestUpdateMaskInfoMessage) && ((RequestUpdateMaskInfoMessage) orginalMessage).getMaskType() == 12) {
                        result.success(a.this.a(null, null, responseUpdateMaskInfoMessage.getError(), responseUpdateMaskInfoMessage.getErrorString(), str));
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap a(HashMap<String, String> hashMap, Object obj, int i, String str, String str2) {
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        hashMap3.put("errno", Integer.valueOf(i));
        hashMap3.put(BaseJsonData.TAG_ERRMSG, str);
        hashMap2.put("requestInfo", hashMap);
        hashMap2.put("identifier", str2);
        hashMap2.put("errorInfo", hashMap3);
        if (i == 0) {
            hashMap2.put("data", obj);
        }
        return hashMap2;
    }
}
