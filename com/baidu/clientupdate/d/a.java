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
import com.baidu.searchbox.cloudcommand.dao.CloudCommandTable;
import com.baidu.searchbox.unitedscheme.SchemeDescPatchListener;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.LogUtil;
import java.io.File;
import java.net.URI;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static a a;
    public transient /* synthetic */ FieldHolder $fh;
    public Context b;
    public ClientUpdateInfo c;
    public RuleInfo d;
    public BroadcastReceiver e;
    public boolean f;
    public String g;
    public com.baidu.clientupdate.c.a h;
    public com.baidu.clientupdate.a.d i;

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.f = false;
        this.g = null;
        this.b = context;
        this.i = com.baidu.clientupdate.a.d.a(context);
        this.h = com.baidu.clientupdate.c.a.a(context);
    }

    public static synchronized a a(Context context) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a(context);
                }
                aVar = a;
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
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Download download = new Download();
            download.mFileName = appInfo.mSname;
            download.mSavedPath = str;
            download.mUrl = appInfo.mDownurl;
            download.mMimeType = "application/vnd.android.package-archive";
            download.mSourceKey = appInfo.mPackageName + "@" + appInfo.mVercode;
            DownloadManager.getInstance(this.b).start(download);
        }
    }

    private void a(AppInfo appInfo, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, appInfo, str, z) == null) {
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
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Download download = new Download();
            download.mFileName = appInfo.mSname;
            download.mSavedPath = str;
            download.mUrl = appInfo.mDownurl;
            download.mMimeType = "application/vnd.android.package-archive";
            download.mSourceKey = appInfo.mPackageName + "@" + appInfo.mVercode;
            DownloadManager.getInstance(this.b).start(download, z);
        }
    }

    private void b(AppInfo appInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, appInfo, str) == null) {
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
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Download download = new Download();
            download.mFileName = appInfo.mSname;
            download.mSavedPath = str;
            download.mUrl = appInfo.mPatchDownUrl;
            download.mMimeType = SchemeDescPatchListener.PATCH;
            download.mSourceKey = appInfo.mPackageName + "@" + appInfo.mVercode;
            DownloadManager.getInstance(this.b).start(download);
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            synchronized (a.class) {
                if (a != null && a.e != null) {
                    a.b.unregisterReceiver(a.e);
                }
            }
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            try {
                File file = new File(com.baidu.util.a.a(this.b).a("lcsdk_xml", "path", ""));
                if (file.exists() && file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        file2.delete();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ClientUpdateInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (ClientUpdateInfo) invokeV.objValue;
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
                    this.c = clientUpdateInfo;
                    if (clientUpdateInfo != null) {
                        clientUpdateInfo.mStatus = jSONObject.optString("status");
                        this.c.mReverson = jSONObject.optString("re_version");
                    }
                    return this.c;
                } else if (Integer.valueOf(optString).intValue() == 0) {
                    f();
                    ClientUpdateInfo clientUpdateInfo2 = new ClientUpdateInfo();
                    this.c = clientUpdateInfo2;
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
                this.g = str;
                if (!TextUtils.isEmpty(clientUpdateInfo.mStatus) && Integer.valueOf(clientUpdateInfo.mStatus).intValue() == 1) {
                    if (!TextUtils.isEmpty(clientUpdateInfo.mPatchDownUrl) && !TextUtils.isEmpty(clientUpdateInfo.mPatchSize) && Integer.valueOf(clientUpdateInfo.mPatchSize).intValue() > 0) {
                        b((AppInfo) clientUpdateInfo, str);
                    }
                    this.f = true;
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
                if (this.c == null) {
                    this.c = clientUpdateInfo;
                }
                this.g = str;
                if (!TextUtils.isEmpty(clientUpdateInfo.mStatus) && Integer.valueOf(clientUpdateInfo.mStatus).intValue() == 1 && !TextUtils.isEmpty(clientUpdateInfo.mDownurl) && !TextUtils.isEmpty(clientUpdateInfo.mSize) && Integer.valueOf(clientUpdateInfo.mSize).intValue() > 0) {
                    a((AppInfo) clientUpdateInfo, str, z);
                    this.f = false;
                }
            }
        }
    }

    public synchronized void a(JSONObject jSONObject, IClientUpdaterCallback iClientUpdaterCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, iClientUpdaterCallback) == null) {
            synchronized (this) {
                try {
                    this.f = false;
                } catch (Exception e) {
                    e.printStackTrace();
                    com.baidu.clientupdate.a.d dVar = this.i;
                    String c = this.h.c();
                    String b = this.h.b();
                    dVar.a(c, "0", b, "a5", "1", (System.currentTimeMillis() / 1000) + "", "", "parseResult", e.toString());
                }
                if (jSONObject == null) {
                    iClientUpdaterCallback.onCompleted(null, null);
                    com.baidu.clientupdate.a.d dVar2 = this.i;
                    String c2 = this.h.c();
                    String b2 = this.h.b();
                    dVar2.a(c2, "0", b2, "a5", "0", (System.currentTimeMillis() / 1000) + "", "", "parseResult", "");
                    return;
                }
                String optString = jSONObject.optString("status");
                if (TextUtils.isEmpty(optString)) {
                    iClientUpdaterCallback.onCompleted(null, null);
                } else if (Integer.valueOf(optString).intValue() == 1) {
                    this.c = (ClientUpdateInfo) h.a(jSONObject.optJSONObject("clientupdate"), 0);
                    if (!new URI(this.c.mDownurl).getHost().endsWith(PublicSuffixDatabase.BAIDU_TLD_PLUS_ONE)) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(CloudCommandTable.MSG_ID, "3");
                        jSONObject2.put("messageDetail", "下载地址有问题");
                        if (iClientUpdaterCallback != null) {
                            iClientUpdaterCallback.onError(jSONObject2);
                        }
                    }
                    this.d = (RuleInfo) h.a(jSONObject.optJSONObject("rule"), 3);
                    if (this.c != null) {
                        this.c.mStatus = jSONObject.optString("status");
                        this.c.mReverson = jSONObject.optString("re_version");
                    }
                    if (this.c != null) {
                        LogUtil.logD("ClientUpdateUtility", "mClientUpdateInfo: " + this.c.toString());
                    }
                    iClientUpdaterCallback.onCompleted(this.c, this.d);
                } else if (Integer.valueOf(optString).intValue() == 0) {
                    f();
                    ClientUpdateInfo clientUpdateInfo = new ClientUpdateInfo();
                    this.c = clientUpdateInfo;
                    clientUpdateInfo.mStatus = optString;
                    iClientUpdaterCallback.onCompleted(clientUpdateInfo, null);
                }
                com.baidu.clientupdate.a.d dVar3 = this.i;
                String c3 = this.h.c();
                String b3 = this.h.b();
                dVar3.a(c3, "0", b3, "a5", "0", (System.currentTimeMillis() / 1000) + "", "", "parseResult", "");
                LogUtil.logE("ClientUpdateUtility", "加入统计耗时：" + (System.currentTimeMillis() - ClientUpdater.stime));
            }
        }
    }

    public RuleInfo b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.d : (RuleInfo) invokeV.objValue;
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
                    RuleInfo ruleInfo = (RuleInfo) h.a(jSONObject.optJSONObject("rule"), 3);
                    this.d = ruleInfo;
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
                if (this.c == null) {
                    this.c = clientUpdateInfo;
                }
                this.g = str;
                if (!TextUtils.isEmpty(clientUpdateInfo.mStatus) && Integer.valueOf(clientUpdateInfo.mStatus).intValue() == 1 && !TextUtils.isEmpty(clientUpdateInfo.mDownurl) && !TextUtils.isEmpty(clientUpdateInfo.mSize) && Integer.valueOf(clientUpdateInfo.mSize).intValue() > 0) {
                    a((AppInfo) clientUpdateInfo, str);
                    this.f = false;
                }
            }
        }
    }

    public synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.c = null;
                }
                if (this.g != null) {
                    this.g = null;
                }
                this.f = false;
            }
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f : invokeV.booleanValue;
    }
}
