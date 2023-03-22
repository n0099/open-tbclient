package com.baidu.searchbox.cloudcontrolblcp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.searchbox.cloudcontrol.CloudControlManager;
import com.baidu.searchbox.cloudcontrol.constant.CloudControlConstant;
import com.baidu.searchbox.cloudcontrol.data.CloudControlRequestInfo;
import com.baidu.searchbox.cloudcontrol.utils.CloudControlUrlConfig;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.tieba.p70;
import com.baidu.tieba.u70;
import com.baidu.tieba.v70;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CloudControlBlCPManager {
    public static final String KEY_FILTER = "filter";
    public static final String KEY_MSGDATA = "msgdata";
    public static final String KEY_PARAMS = "params";
    public static final String KEY_VERSIONASC = "version_asc";
    public static final long LOGIN_METHOD_ID = 1;
    public static final long NOTIFY_METHOD_ID = 2;
    public static final long SERVICE_ID = 4;
    public static final String UBC_CLOUD_CTROL_LCP_ID = "1312";
    public static CloudControlBlCPManager mCloudControlManager;
    public String TAG = "CloudControlBlCPManager";
    public v70 blcpResponse = new v70() { // from class: com.baidu.searchbox.cloudcontrolblcp.CloudControlBlCPManager.1
        @Override // com.baidu.tieba.v70
        public void onResponse(int i, String str, long j, long j2, long j3, byte[] bArr) {
            String str2;
            if (AppConfig.isDebug()) {
                String str3 = CloudControlBlCPManager.this.TAG;
                Log.d(str3, "收到数据 response :errorCode:" + i + "errorMsg:" + str + WebGLImageLoader.DATA_URL + new String(bArr));
            }
            if (i != 0) {
                return;
            }
            int i2 = (j2 > 1L ? 1 : (j2 == 1L ? 0 : -1));
            if (i2 == 0 || j2 == 2) {
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr));
                    if (AppConfig.isDebug()) {
                        String str4 = CloudControlBlCPManager.this.TAG;
                        Log.d(str4, "response is " + jSONObject.toString());
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject(CloudControlBlCPManager.KEY_MSGDATA);
                    if (optJSONObject == null) {
                        return;
                    }
                    if (i2 == 0) {
                        str2 = CloudControlConstant.LOGIN_RUN_TYPE;
                    } else {
                        str2 = "lcs";
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("version_asc", "1");
                    CloudControlManager.getInstance().getConnectData(optJSONObject, jSONObject2, str2);
                } catch (JSONException unused) {
                }
            }
        }
    };
    public BroadcastReceiver iConnectListener = new BroadcastReceiver() { // from class: com.baidu.searchbox.cloudcontrolblcp.CloudControlBlCPManager.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z;
            if (intent != null && "com.baidu.lcp.sdk.broadcast".equals(intent.getAction())) {
                if (intent.getIntExtra("com.baidu.lcp.sdk.connect.state", -1) == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (AppConfig.isDebug()) {
                    String str = CloudControlBlCPManager.this.TAG;
                    Log.d(str, "长连接是否已连接 ：" + intent.getIntExtra("com.baidu.lcp.sdk.connect.state", -1));
                }
                if (CloudControlBlCPManager.this.isSmallFlow && z) {
                    ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.cloudcontrolblcp.CloudControlBlCPManager.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CloudControlBlCPManager.this.invoke();
                        }
                    }, "lcp_login_cloud", 2);
                }
            }
        }
    };
    public boolean isSmallFlow;
    public byte[] mLoginRequest;

    public static CloudControlBlCPManager getInstance() {
        synchronized (CloudControlBlCPManager.class) {
            if (mCloudControlManager == null) {
                mCloudControlManager = new CloudControlBlCPManager();
            }
        }
        return mCloudControlManager;
    }

    public void registerConnectStateListener(Context context) {
        this.isSmallFlow = p70.d(context);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.lcp.sdk.broadcast");
        LocalBroadcastManager.getInstance(context).registerReceiver(this.iConnectListener, intentFilter);
        if (p70.b() == 0) {
            invoke();
        }
    }

    private byte[] getLoginRequest() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        Uri parse = Uri.parse(CloudControlUrlConfig.getCloudControlUrl(""));
        for (String str : parse.getQueryParameterNames()) {
            jSONObject2.put(str, parse.getQueryParameter(str));
        }
        jSONObject.put("params", jSONObject2);
        ArrayList<CloudControlRequestInfo> postData = CloudControlManager.getInstance().getPostData("0");
        for (int i = 0; i < postData.size(); i++) {
            CloudControlRequestInfo cloudControlRequestInfo = postData.get(i);
            jSONObject3.put(cloudControlRequestInfo.getServiceName(), cloudControlRequestInfo.getFilter());
        }
        jSONObject.put("filter", jSONObject3);
        if (AppConfig.isDebug()) {
            String str2 = this.TAG;
            Log.d(str2, "login json " + jSONObject.toString());
        }
        return jSONObject.toString().getBytes();
    }

    public void invoke() {
        BLCPRequest bLCPRequest = new BLCPRequest();
        bLCPRequest.a = 4L;
        bLCPRequest.b = 1L;
        bLCPRequest.d = System.currentTimeMillis();
        try {
            if (this.mLoginRequest == null) {
                this.mLoginRequest = getLoginRequest();
            }
            bLCPRequest.c = this.mLoginRequest;
        } catch (JSONException unused) {
        }
        if (bLCPRequest.c.length <= 0) {
            return;
        }
        p70.c(bLCPRequest, this.blcpResponse);
        u70 u70Var = new u70();
        u70Var.a = 4L;
        u70Var.b = 2L;
        p70.c(u70Var, this.blcpResponse);
    }
}
