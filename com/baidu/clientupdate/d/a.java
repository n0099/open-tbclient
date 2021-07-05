package com.baidu.clientupdate.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.clientupdate.ClientUpdater;
import com.baidu.clientupdate.IClientUpdaterCallback;
import com.baidu.clientupdate.appinfo.AppInfo;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.clientupdate.appinfo.RuleInfo;
import com.baidu.clientupdate.download.Download;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.unitedscheme.SchemeDescPatchListener;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.LogUtil;
import com.bytedance.sdk.component.net.tnc.TNCManager;
import com.heytap.mcssdk.mode.Message;
import java.io.File;
import java.net.URI;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static a f4640a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f4641b;

    /* renamed from: c  reason: collision with root package name */
    public ClientUpdateInfo f4642c;

    /* renamed from: d  reason: collision with root package name */
    public RuleInfo f4643d;

    /* renamed from: e  reason: collision with root package name */
    public BroadcastReceiver f4644e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4645f;

    /* renamed from: g  reason: collision with root package name */
    public String f4646g;

    /* renamed from: h  reason: collision with root package name */
    public com.baidu.clientupdate.c.a f4647h;

    /* renamed from: i  reason: collision with root package name */
    public com.baidu.clientupdate.a.d f4648i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1147889938, "Lcom/baidu/clientupdate/d/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1147889938, "Lcom/baidu/clientupdate/d/a;");
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4642c = null;
        this.f4643d = null;
        this.f4645f = false;
        this.f4646g = null;
        this.f4641b = context;
        this.f4648i = com.baidu.clientupdate.a.d.a(context);
        this.f4647h = com.baidu.clientupdate.c.a.a(context);
    }

    public static synchronized a a(Context context) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (a.class) {
                if (f4640a == null) {
                    f4640a = new a(context);
                }
                aVar = f4640a;
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    private void a(AppInfo appInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, appInfo, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    File file = new File(str);
                    if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
                        File file2 = new File(Environment.getExternalStorageDirectory(), "Download");
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        str = file2.getAbsolutePath();
                        LogUtil.logE("ClientUpdateUtility", "savapath=====" + str);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            Download download = new Download();
            download.mFileName = appInfo.mSname;
            download.mSavedPath = str;
            download.mUrl = appInfo.mDownurl;
            download.mMimeType = "application/vnd.android.package-archive";
            download.mSourceKey = appInfo.mPackageName + TNCManager.TNC_PROBE_HEADER_SECEPTOR + appInfo.mVercode;
            DownloadManager.getInstance(this.f4641b).start(download);
        }
    }

    private void a(AppInfo appInfo, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65540, this, appInfo, str, z) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    File file = new File(str);
                    if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
                        File file2 = new File(Environment.getExternalStorageDirectory(), "Download");
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        str = file2.getAbsolutePath();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            Download download = new Download();
            download.mFileName = appInfo.mSname;
            download.mSavedPath = str;
            download.mUrl = appInfo.mDownurl;
            download.mMimeType = "application/vnd.android.package-archive";
            download.mSourceKey = appInfo.mPackageName + TNCManager.TNC_PROBE_HEADER_SECEPTOR + appInfo.mVercode;
            DownloadManager.getInstance(this.f4641b).start(download, z);
        }
    }

    private void b(AppInfo appInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, appInfo, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    File file = new File(str);
                    if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
                        File file2 = new File(Environment.getExternalStorageDirectory(), "Download");
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        str = file2.getAbsolutePath();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            Download download = new Download();
            download.mFileName = appInfo.mSname;
            download.mSavedPath = str;
            download.mUrl = appInfo.mPatchDownUrl;
            download.mMimeType = SchemeDescPatchListener.PATCH;
            download.mSourceKey = appInfo.mPackageName + TNCManager.TNC_PROBE_HEADER_SECEPTOR + appInfo.mVercode;
            DownloadManager.getInstance(this.f4641b).start(download);
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            synchronized (a.class) {
                if (f4640a != null && f4640a.f4644e != null) {
                    f4640a.f4641b.unregisterReceiver(f4640a.f4644e);
                }
            }
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            try {
                File file = new File(com.baidu.util.a.a(this.f4641b).a("lcsdk_xml", "path", ""));
                if (file.exists() && file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        file2.delete();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public ClientUpdateInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f4642c : (ClientUpdateInfo) invokeV.objValue;
    }

    public synchronized ClientUpdateInfo a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            synchronized (this) {
                if (jSONObject == null) {
                    return null;
                }
                String optString = jSONObject.optString("status");
                if (TextUtils.isEmpty(optString)) {
                    return null;
                }
                if (Integer.valueOf(optString).intValue() == 1) {
                    ClientUpdateInfo clientUpdateInfo = (ClientUpdateInfo) h.a(jSONObject.optJSONObject("clientupdate"), 0);
                    this.f4642c = clientUpdateInfo;
                    if (clientUpdateInfo != null) {
                        clientUpdateInfo.mStatus = jSONObject.optString("status");
                        this.f4642c.mReverson = jSONObject.optString("re_version");
                    }
                    return this.f4642c;
                } else if (Integer.valueOf(optString).intValue() == 0) {
                    f();
                    ClientUpdateInfo clientUpdateInfo2 = new ClientUpdateInfo();
                    this.f4642c = clientUpdateInfo2;
                    clientUpdateInfo2.mStatus = optString;
                    return clientUpdateInfo2;
                } else {
                    return null;
                }
            }
        }
        return (ClientUpdateInfo) invokeL.objValue;
    }

    public synchronized void a(ClientUpdateInfo clientUpdateInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, clientUpdateInfo, str) == null) {
            synchronized (this) {
                if (clientUpdateInfo == null) {
                    return;
                }
                this.f4646g = str;
                if (!TextUtils.isEmpty(clientUpdateInfo.mStatus) && Integer.valueOf(clientUpdateInfo.mStatus).intValue() == 1) {
                    if (!TextUtils.isEmpty(clientUpdateInfo.mPatchDownUrl) && !TextUtils.isEmpty(clientUpdateInfo.mPatchSize) && Integer.valueOf(clientUpdateInfo.mPatchSize).intValue() > 0) {
                        b((AppInfo) clientUpdateInfo, str);
                    }
                    this.f4645f = true;
                }
            }
        }
    }

    public synchronized void a(ClientUpdateInfo clientUpdateInfo, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, clientUpdateInfo, str, z) == null) {
            synchronized (this) {
                if (clientUpdateInfo == null) {
                    return;
                }
                if (this.f4642c == null) {
                    this.f4642c = clientUpdateInfo;
                }
                this.f4646g = str;
                if (!TextUtils.isEmpty(clientUpdateInfo.mStatus) && Integer.valueOf(clientUpdateInfo.mStatus).intValue() == 1 && !TextUtils.isEmpty(clientUpdateInfo.mDownurl) && !TextUtils.isEmpty(clientUpdateInfo.mSize) && Integer.valueOf(clientUpdateInfo.mSize).intValue() > 0) {
                    a((AppInfo) clientUpdateInfo, str, z);
                    this.f4645f = false;
                }
            }
        }
    }

    public synchronized void a(JSONObject jSONObject, IClientUpdaterCallback iClientUpdaterCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, iClientUpdaterCallback) == null) {
            synchronized (this) {
                try {
                    this.f4645f = false;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    com.baidu.clientupdate.a.d dVar = this.f4648i;
                    String c2 = this.f4647h.c();
                    String b2 = this.f4647h.b();
                    dVar.a(c2, "0", b2, "a5", "1", (System.currentTimeMillis() / 1000) + "", "", "parseResult", e2.toString());
                }
                if (jSONObject == null) {
                    iClientUpdaterCallback.onCompleted(null, null);
                    com.baidu.clientupdate.a.d dVar2 = this.f4648i;
                    String c3 = this.f4647h.c();
                    String b3 = this.f4647h.b();
                    dVar2.a(c3, "0", b3, "a5", "0", (System.currentTimeMillis() / 1000) + "", "", "parseResult", "");
                    return;
                }
                String optString = jSONObject.optString("status");
                if (TextUtils.isEmpty(optString)) {
                    iClientUpdaterCallback.onCompleted(null, null);
                } else if (Integer.valueOf(optString).intValue() == 1) {
                    this.f4642c = (ClientUpdateInfo) h.a(jSONObject.optJSONObject("clientupdate"), 0);
                    if (!new URI(this.f4642c.mDownurl).getHost().endsWith("baidu.com")) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("msgId", "3");
                        jSONObject2.put("messageDetail", "下载地址有问题");
                        if (iClientUpdaterCallback != null) {
                            iClientUpdaterCallback.onError(jSONObject2);
                        }
                    }
                    this.f4643d = (RuleInfo) h.a(jSONObject.optJSONObject(Message.RULE), 3);
                    if (this.f4642c != null) {
                        this.f4642c.mStatus = jSONObject.optString("status");
                        this.f4642c.mReverson = jSONObject.optString("re_version");
                    }
                    if (this.f4642c != null) {
                        LogUtil.logD("ClientUpdateUtility", "mClientUpdateInfo: " + this.f4642c.toString());
                    }
                    iClientUpdaterCallback.onCompleted(this.f4642c, this.f4643d);
                } else if (Integer.valueOf(optString).intValue() == 0) {
                    f();
                    ClientUpdateInfo clientUpdateInfo = new ClientUpdateInfo();
                    this.f4642c = clientUpdateInfo;
                    clientUpdateInfo.mStatus = optString;
                    iClientUpdaterCallback.onCompleted(clientUpdateInfo, null);
                }
                com.baidu.clientupdate.a.d dVar3 = this.f4648i;
                String c4 = this.f4647h.c();
                String b4 = this.f4647h.b();
                dVar3.a(c4, "0", b4, "a5", "0", (System.currentTimeMillis() / 1000) + "", "", "parseResult", "");
                LogUtil.logE("ClientUpdateUtility", "加入统计耗时：" + (System.currentTimeMillis() - ClientUpdater.stime));
            }
        }
    }

    public RuleInfo b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f4643d : (RuleInfo) invokeV.objValue;
    }

    public synchronized RuleInfo b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) {
            synchronized (this) {
                if (jSONObject == null) {
                    return null;
                }
                String optString = jSONObject.optString("status");
                if (TextUtils.isEmpty(optString)) {
                    return null;
                }
                if (Integer.valueOf(optString).intValue() == 1) {
                    RuleInfo ruleInfo = (RuleInfo) h.a(jSONObject.optJSONObject(Message.RULE), 3);
                    this.f4643d = ruleInfo;
                    return ruleInfo;
                }
                return null;
            }
        }
        return (RuleInfo) invokeL.objValue;
    }

    public synchronized void b(ClientUpdateInfo clientUpdateInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, clientUpdateInfo, str) == null) {
            synchronized (this) {
                if (clientUpdateInfo == null) {
                    return;
                }
                if (this.f4642c == null) {
                    this.f4642c = clientUpdateInfo;
                }
                this.f4646g = str;
                if (!TextUtils.isEmpty(clientUpdateInfo.mStatus) && Integer.valueOf(clientUpdateInfo.mStatus).intValue() == 1 && !TextUtils.isEmpty(clientUpdateInfo.mDownurl) && !TextUtils.isEmpty(clientUpdateInfo.mSize) && Integer.valueOf(clientUpdateInfo.mSize).intValue() > 0) {
                    a((AppInfo) clientUpdateInfo, str);
                    this.f4645f = false;
                }
            }
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                if (this.f4642c != null) {
                    this.f4642c = null;
                }
                if (this.f4646g != null) {
                    this.f4646g = null;
                }
                this.f4645f = false;
            }
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f4645f : invokeV.booleanValue;
    }
}
