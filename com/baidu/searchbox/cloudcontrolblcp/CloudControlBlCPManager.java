package com.baidu.searchbox.cloudcontrolblcp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.searchbox.cloudcontrol.CloudControlManager;
import com.baidu.searchbox.cloudcontrol.constant.CloudControlConstant;
import com.baidu.searchbox.cloudcontrol.data.CloudControlRequestInfo;
import com.baidu.searchbox.cloudcontrol.utils.CloudControlUrlConfig;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.tieba.a90;
import com.baidu.tieba.b90;
import com.baidu.tieba.v80;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CloudControlBlCPManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_FILTER = "filter";
    public static final String KEY_MSGDATA = "msgdata";
    public static final String KEY_PARAMS = "params";
    public static final String KEY_VERSIONASC = "version_asc";
    public static final long LOGIN_METHOD_ID = 1;
    public static final long NOTIFY_METHOD_ID = 2;
    public static final long SERVICE_ID = 4;
    public static final String UBC_CLOUD_CTROL_LCP_ID = "1312";
    public static CloudControlBlCPManager mCloudControlManager;
    public transient /* synthetic */ FieldHolder $fh;
    public String TAG;
    public b90 blcpResponse;
    public BroadcastReceiver iConnectListener;
    public boolean isSmallFlow;
    public byte[] mLoginRequest;

    public CloudControlBlCPManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.TAG = "CloudControlBlCPManager";
        this.blcpResponse = new b90(this) { // from class: com.baidu.searchbox.cloudcontrolblcp.CloudControlBlCPManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CloudControlBlCPManager this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.tieba.b90
            public void onResponse(int i3, String str, long j, long j2, long j3, byte[] bArr) {
                String str2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i3), str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), bArr}) == null) {
                    if (AppConfig.isDebug()) {
                        String str3 = this.this$0.TAG;
                        Log.d(str3, "收到数据 response :errorCode:" + i3 + "errorMsg:" + str + WebGLImageLoader.DATA_URL + new String(bArr));
                    }
                    if (i3 != 0) {
                        return;
                    }
                    int i4 = (j2 > 1L ? 1 : (j2 == 1L ? 0 : -1));
                    if (i4 == 0 || j2 == 2) {
                        try {
                            JSONObject jSONObject = new JSONObject(new String(bArr));
                            if (AppConfig.isDebug()) {
                                String str4 = this.this$0.TAG;
                                Log.d(str4, "response is " + jSONObject.toString());
                            }
                            JSONObject optJSONObject = jSONObject.optJSONObject(CloudControlBlCPManager.KEY_MSGDATA);
                            if (optJSONObject == null) {
                                return;
                            }
                            if (i4 == 0) {
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
            }
        };
        this.iConnectListener = new BroadcastReceiver(this) { // from class: com.baidu.searchbox.cloudcontrolblcp.CloudControlBlCPManager.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CloudControlBlCPManager this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                boolean z;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, context, intent) == null) && intent != null && "com.baidu.lcp.sdk.broadcast".equals(intent.getAction())) {
                    if (intent.getIntExtra("com.baidu.lcp.sdk.connect.state", -1) == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (AppConfig.isDebug()) {
                        String str = this.this$0.TAG;
                        Log.d(str, "长连接是否已连接 ：" + intent.getIntExtra("com.baidu.lcp.sdk.connect.state", -1));
                    }
                    if (this.this$0.isSmallFlow && z) {
                        ExecutorUtilsExt.postOnElastic(new Runnable(this) { // from class: com.baidu.searchbox.cloudcontrolblcp.CloudControlBlCPManager.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass2 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                                    newInitContext2.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext2);
                                    int i3 = newInitContext2.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext2.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext2);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.this$1.this$0.invoke();
                                }
                            }
                        }, "lcp_login_cloud", 2);
                    }
                }
            }
        };
    }

    public void registerConnectStateListener(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.isSmallFlow = v80.d(context);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.lcp.sdk.broadcast");
            LocalBroadcastManager.getInstance(context).registerReceiver(this.iConnectListener, intentFilter);
            if (v80.b() == 0) {
                invoke();
            }
        }
    }

    public static CloudControlBlCPManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (CloudControlBlCPManager.class) {
                if (mCloudControlManager == null) {
                    mCloudControlManager = new CloudControlBlCPManager();
                }
            }
            return mCloudControlManager;
        }
        return (CloudControlBlCPManager) invokeV.objValue;
    }

    private byte[] getLoginRequest() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
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
        return (byte[]) invokeV.objValue;
    }

    public void invoke() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
            v80.c(bLCPRequest, this.blcpResponse);
            a90 a90Var = new a90();
            a90Var.a = 4L;
            a90Var.b = 2L;
            v80.c(a90Var, this.blcpResponse);
        }
    }
}
