package com.baidu.browser.sailor.webkit.update;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.k.b.c.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.blink.EngineManager;
import com.baidu.webkit.internal.blink.WebKitVersionBlink;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.internal.daemon.ZeusThreadPoolUtil;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.net.INetListener;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class BdZeusUpdate {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static BdZeusUpdate f31713e;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f31714b;

    /* renamed from: c  reason: collision with root package name */
    public String f31715c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f31716d;

    /* loaded from: classes4.dex */
    public class BdZesuUpdateTask extends BdNetTask implements INetListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ByteArrayOutputStream mOutputStream;
        public final /* synthetic */ BdZeusUpdate this$0;

        public BdZesuUpdateTask(BdZeusUpdate bdZeusUpdate, Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdZeusUpdate, context, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bdZeusUpdate;
            setUrl(BdZeusUpdate.b(str, context));
            setMethod(BdNet.HttpMethod.METHOD_GET);
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetDownloadComplete(BdNet bdNet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdNet) == null) {
            }
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdNet, bdNetTask, netError, i2) == null) {
                this.mOutputStream.reset();
            }
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetReceiveData(BdNet bdNet, BdNetTask bdNetTask, byte[] bArr, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, bdNet, bdNetTask, bArr, i2) == null) {
                if (this.mOutputStream == null) {
                    this.mOutputStream = new ByteArrayOutputStream();
                }
                if (i2 > 0) {
                    this.mOutputStream.write(bArr, 0, i2);
                }
            }
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetReceiveHeaders(BdNet bdNet, BdNetTask bdNetTask) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, bdNet, bdNetTask) == null) {
            }
        }

        @Override // com.baidu.webkit.net.INetListener
        public boolean onNetRedirect(BdNet bdNet, BdNetTask bdNetTask, int i2) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, bdNet, bdNetTask, i2)) == null) {
                return false;
            }
            return invokeLLI.booleanValue;
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetResponseCode(BdNet bdNet, BdNetTask bdNetTask, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048581, this, bdNet, bdNetTask, i2) == null) {
            }
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetStateChanged(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetState netState, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLI(1048582, this, bdNet, bdNetTask, netState, i2) == null) {
            }
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetTaskComplete(BdNet bdNet, BdNetTask bdNetTask) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, bdNet, bdNetTask) == null) {
                ByteArrayOutputStream byteArrayOutputStream = this.mOutputStream;
                if (byteArrayOutputStream != null) {
                    try {
                        String byteArrayOutputStream2 = byteArrayOutputStream.toString("utf-8");
                        Log.d(EngineManager.LOG_TAG, "received data = ".concat(String.valueOf(byteArrayOutputStream2)));
                        if (byteArrayOutputStream2.length() > 0) {
                            JSONObject jSONObject = new JSONObject(byteArrayOutputStream2);
                            if (jSONObject.has("data")) {
                                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                                if (jSONObject2.has("version")) {
                                    this.this$0.f31714b = jSONObject2.getString("version");
                                }
                                if (jSONObject2.has("link")) {
                                    this.this$0.a = jSONObject2.getString("link");
                                }
                                if (jSONObject2.has(PackageTable.MD5)) {
                                    this.this$0.f31715c = jSONObject2.getString(PackageTable.MD5);
                                }
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                Log.i(EngineManager.LOG_TAG, "check received data");
                release();
                this.this$0.g();
            }
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetTaskStart(BdNet bdNet, BdNetTask bdNetTask) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdNet, bdNetTask) == null) {
            }
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetUploadComplete(BdNet bdNet, BdNetTask bdNetTask) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, bdNet, bdNetTask) == null) {
            }
        }

        @Override // com.baidu.webkit.net.INetListener
        public void onNetUploadData(BdNet bdNet, BdNetTask bdNetTask, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLII(1048586, this, bdNet, bdNetTask, i2, i3) == null) {
            }
        }

        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                ByteArrayOutputStream byteArrayOutputStream = this.mOutputStream;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.reset();
                        this.mOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                this.mOutputStream = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f31717e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BdZeusUpdate f31718f;

        public a(BdZeusUpdate bdZeusUpdate, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdZeusUpdate, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31718f = bdZeusUpdate;
            this.f31717e = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LoadErrorCode loadErrorCode;
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f31717e == null) {
                return;
            }
            Log.i(EngineManager.LOG_TAG, "start check zeus update async");
            BdZeusUpdate bdZeusUpdate = this.f31718f;
            Context context = this.f31717e;
            if (!WebKitFactory.isUserPrivacyEnabled()) {
                loadErrorCode = WebKitFactory.getLoadErrorCode();
                i2 = 1000;
            } else if (bdZeusUpdate.f31716d) {
                return;
            } else {
                if (b.d(context)) {
                    BdZesuUpdateTask bdZesuUpdateTask = new BdZesuUpdateTask(bdZeusUpdate, context, "https://mbrowser.baidu.com/api/update/kernel?version=");
                    BdNet bdNet = new BdNet(context);
                    bdNet.setEventListener(bdZesuUpdateTask);
                    bdNet.start(bdZesuUpdateTask, false);
                    bdZeusUpdate.f31716d = true;
                    return;
                }
                loadErrorCode = WebKitFactory.getLoadErrorCode();
                i2 = 1001;
            }
            loadErrorCode.addDownloadInfo(i2);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-630792824, "Lcom/baidu/browser/sailor/webkit/update/BdZeusUpdate;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-630792824, "Lcom/baidu/browser/sailor/webkit/update/BdZeusUpdate;");
        }
    }

    public BdZeusUpdate() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static BdZeusUpdate a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f31713e == null) {
                synchronized (BdZeusUpdate.class) {
                    if (f31713e == null) {
                        f31713e = new BdZeusUpdate();
                    }
                }
            }
            return f31713e;
        }
        return (BdZeusUpdate) invokeV.objValue;
    }

    public static String b(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, context)) == null) {
            if (TextUtils.isEmpty(str) || context == null) {
                return str;
            }
            StringBuilder sb = new StringBuilder(str);
            String zeusVersionByUpdate = WebKitVersionBlink.getZeusVersionByUpdate();
            String sdkVersionName = WebKitFactory.getSdkVersionName();
            Log.w("sdk in=".concat(String.valueOf(zeusVersionByUpdate)));
            Log.w("sdk out=".concat(String.valueOf(sdkVersionName)));
            sb.append(zeusVersionByUpdate);
            sb.append("&");
            if (!TextUtils.isEmpty(sdkVersionName)) {
                d(sb, "sdk", sdkVersionName);
            }
            String cuid = BdSailorPlatform.getInstance().getCuid();
            String f2 = !TextUtils.isEmpty(cuid) ? b.f(cuid) : "";
            if (!TextUtils.isEmpty(f2)) {
                d(sb, "cuid", f2);
            }
            String str2 = Build.MODEL;
            String str3 = Build.VERSION.RELEASE;
            int i2 = Build.VERSION.SDK_INT;
            String str4 = Build.MANUFACTURER;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str2.replace("_", "-"));
            stringBuffer.append("_");
            stringBuffer.append(str3);
            stringBuffer.append("_");
            stringBuffer.append(i2);
            stringBuffer.append("_");
            stringBuffer.append(str4.replace("_", "-"));
            String f3 = b.f(stringBuffer.toString().replace(" ", "-"));
            if (!TextUtils.isEmpty(f3)) {
                d(sb, BdZeusUtil.URL_KEY_MACHINE, f3);
            }
            String packageName = context.getPackageName();
            if (!TextUtils.isEmpty(packageName)) {
                d(sb, "app", packageName);
            }
            PackageInfo h2 = h(context);
            if (h2 != null) {
                String str5 = h2.versionName;
                if (!TextUtils.isEmpty(str5)) {
                    d(sb, "appversion", str5);
                }
            }
            String f4 = f(context);
            if (!TextUtils.isEmpty(f4)) {
                sb.append("from");
                sb.append("=");
                sb.append(f4);
            }
            if (!BdZeusUtil.isWebkitLoaded()) {
                sb.append("&");
                sb.append("nozeus");
                sb.append("=");
                sb.append("1");
            }
            Log.i(EngineManager.LOG_TAG, "startCheck url = " + sb.toString());
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static void d(StringBuilder sb, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, sb, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        sb.append("&");
    }

    public static boolean e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                long[] jArr = new long[8];
                for (int i2 = 0; i2 < 8; i2++) {
                    jArr[i2] = 0;
                }
                try {
                    String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX, 4);
                    String[] split2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX, 4);
                    jArr[0] = Long.parseLong(split[0]);
                    jArr[1] = Long.parseLong(split[1]);
                    jArr[2] = Long.parseLong(split[2]);
                    jArr[3] = Long.parseLong(split[3]);
                    jArr[4] = Long.parseLong(split2[0]);
                    jArr[5] = Long.parseLong(split2[1]);
                    jArr[6] = Long.parseLong(split2[2]);
                    jArr[7] = Long.parseLong(split2[3]);
                } catch (Throwable unused) {
                }
                if (jArr[0] == jArr[4] && jArr[1] <= jArr[5] && jArr[2] == jArr[6] && jArr[3] < jArr[7]) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65542, null, context)) != null) {
            return (String) invokeL.objValue;
        }
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            inputStream = context.getResources().openRawResource(context.getResources().getIdentifier("tnconfig", "raw", context.getPackageName()));
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    String trim = new String(byteArrayOutputStream.toByteArray()).trim();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception unused) {
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    return trim;
                } catch (Exception unused3) {
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception unused4) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            return BdZeusUtil.DEFAULT_TNNUMBER;
                        } catch (Exception unused5) {
                            return BdZeusUtil.DEFAULT_TNNUMBER;
                        }
                    }
                    return BdZeusUtil.DEFAULT_TNNUMBER;
                } catch (Throwable th2) {
                    th = th2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused6) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused7) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused8) {
            } catch (Throwable th3) {
                byteArrayOutputStream = null;
                th = th3;
            }
        } catch (Exception unused9) {
            inputStream = null;
        } catch (Throwable th4) {
            byteArrayOutputStream = null;
            th = th4;
            inputStream = null;
        }
    }

    public static PackageInfo h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (PackageInfo) invokeL.objValue;
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            ZeusThreadPoolUtil.executeIgnoreZeus(new a(this, context));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (BdSailor.getInstance().getAppContext() == null) {
                WebKitFactory.getLoadErrorCode().addDownloadInfo(1002);
                return;
            }
            String zeusVersionName = WebKitFactory.getZeusVersionName();
            boolean z = false;
            if (WebKitFactory.getCurEngine() == 1) {
                if (e(zeusVersionName, this.f31714b)) {
                    BdZeusDownloadHelper.b(BdSailor.getInstance().getAppContext()).e(this.a, this.f31715c);
                    return;
                } else {
                    WebKitFactory.getLoadErrorCode().addDownloadInfo(1003);
                    return;
                }
            }
            String packageName = BdSailor.getInstance().getAppContext().getPackageName();
            if (packageName != null && packageName.equalsIgnoreCase(BdSailorPlatform.LITE_PACKAGE_NAME)) {
                z = true;
            }
            if (z) {
                try {
                    float a2 = c.a.k.a.k.b.a() / 1024.0f;
                    String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("update_zeus_mem_size_mb");
                    if (a2 < (TextUtils.isEmpty(GetCloudSettingsValue) ? 1024 : Integer.valueOf(GetCloudSettingsValue).intValue())) {
                        return;
                    }
                    BdSailorPlatform.getStatic().c("MemMbSize", String.valueOf(a2));
                } catch (Exception unused) {
                }
            }
            BdSailorPlatform.getStatic().c("download-webkit-start", String.valueOf(System.currentTimeMillis()));
            BdSailorPlatform.getStatic().a();
            Log.i(EngineManager.LOG_TAG, "start download zeus");
            BdZeusDownloadHelper.b(BdSailor.getInstance().getAppContext()).e(this.a, this.f31715c);
        }
    }
}
