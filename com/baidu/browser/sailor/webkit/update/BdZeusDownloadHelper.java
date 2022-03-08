package com.baidu.browser.sailor.webkit.update;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.BdSailorClient;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.blink.EngineManager;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.io.File;
/* loaded from: classes4.dex */
public final class BdZeusDownloadHelper {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static BdZeusDownloadHelper f31697g = null;

    /* renamed from: h  reason: collision with root package name */
    public static String f31698h = null;

    /* renamed from: i  reason: collision with root package name */
    public static String f31699i = null;

    /* renamed from: j  reason: collision with root package name */
    public static String f31700j = "com.baidu.android.appswitchsdk:web";
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f31701b;

    /* renamed from: c  reason: collision with root package name */
    public int f31702c;

    /* renamed from: d  reason: collision with root package name */
    public String f31703d;

    /* renamed from: e  reason: collision with root package name */
    public long f31704e;

    /* renamed from: f  reason: collision with root package name */
    public long f31705f;

    /* loaded from: classes4.dex */
    public class ZeusDownloadTaskListener implements BdSailorClient.IDownloadTaskListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdZeusDownloadHelper this$0;

        public ZeusDownloadTaskListener(BdZeusDownloadHelper bdZeusDownloadHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdZeusDownloadHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bdZeusDownloadHelper;
        }

        public /* synthetic */ ZeusDownloadTaskListener(BdZeusDownloadHelper bdZeusDownloadHelper, b bVar) {
            this(bdZeusDownloadHelper);
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadCancel(String str, long j2, long j3, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3), str2}) == null) {
                this.this$0.f31702c = a.f31710f;
                Log.i(EngineManager.LOG_TAG, "onDownloadCancel");
                WebKitFactory.getLoadErrorCode().addDownloadInfo(1026);
                ZeusPerformanceTiming.setZeusDownloadInfo(WebKitFactory.getLoadErrorCode().getDownloadInfo());
                ZeusPerformanceTiming.recordDownloadInitStatistics();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadFail(String str, long j2, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Long.valueOf(j2), str2, str3}) == null) {
                this.this$0.f31702c = a.f31709e;
                Log.i(EngineManager.LOG_TAG, "onDownloadFail");
                this.this$0.d("");
                WebKitFactory.getLoadErrorCode().addDownloadInfo(1025);
                ZeusPerformanceTiming.setDownloadFailDetail(str3);
                ZeusPerformanceTiming.setZeusDownloadInfo(WebKitFactory.getLoadErrorCode().getDownloadInfo());
                ZeusPerformanceTiming.recordDownloadInitStatistics();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadPause(String str, long j2, long j3, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3), str2}) == null) {
                this.this$0.f31702c = a.f31706b;
                Log.i(EngineManager.LOG_TAG, "onDownloadPause");
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadStart(String str, long j2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Long.valueOf(j2), str2}) == null) {
                this.this$0.f31702c = a.a;
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadSuccess(String str, String str2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Long.valueOf(j2)}) == null) {
                this.this$0.f31702c = a.f31708d;
                Log.i(EngineManager.LOG_TAG, "aKey:" + str + ", aFilelength:" + j2);
                Log.i(EngineManager.LOG_TAG, "onDownloadSuccess");
                if (TextUtils.isEmpty(BdZeusDownloadHelper.f31699i)) {
                    WebKitFactory.getLoadErrorCode().addDownloadInfo(1007);
                    return;
                }
                this.this$0.d("");
                File file = new File(BdZeusDownloadHelper.f31699i);
                if (!file.exists()) {
                    Log.e("Apk file is not exist.");
                    WebKitFactory.getLoadErrorCode().addDownloadInfo(1009);
                    if (TextUtils.isEmpty(this.this$0.f31701b)) {
                        return;
                    }
                    BdZeusDownloadHelper bdZeusDownloadHelper = this.this$0;
                    bdZeusDownloadHelper.e(bdZeusDownloadHelper.f31701b, this.this$0.f31703d);
                } else if (file.length() != j2) {
                    Log.e("Apk file download failed: wrong size");
                    WebKitFactory.getLoadErrorCode().addDownloadInfo(1010);
                    file.delete();
                    if (TextUtils.isEmpty(this.this$0.f31701b)) {
                        return;
                    }
                    BdZeusDownloadHelper bdZeusDownloadHelper2 = this.this$0;
                    bdZeusDownloadHelper2.e(bdZeusDownloadHelper2.f31701b, this.this$0.f31703d);
                } else {
                    Log.i(EngineManager.LOG_TAG, " begine check md5");
                    String a = c.a.k.b.c.b.a(BdZeusDownloadHelper.f31699i);
                    if (a == null || !a.equalsIgnoreCase(this.this$0.f31703d)) {
                        WebKitFactory.getLoadErrorCode().addDownloadInfo(1011);
                        Log.i(EngineManager.LOG_TAG, " check md5 failed ");
                        return;
                    }
                    Log.i(EngineManager.LOG_TAG, " begine install");
                    if (WebKitFactory.getCurEngine() != 1) {
                        BdSailorPlatform.getStatic().c("download-webkit-end", String.valueOf(System.currentTimeMillis()));
                        BdSailorPlatform.getStatic().a();
                    }
                    BdSailorPlatform.getWebkitManager().installZeusFromDownload(BdZeusDownloadHelper.f31699i);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloading(String str, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                BdZeusDownloadHelper bdZeusDownloadHelper = this.this$0;
                bdZeusDownloadHelper.f31704e += j2;
                bdZeusDownloadHelper.f31705f = j3;
                bdZeusDownloadHelper.f31702c = a.a;
            }
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f31706b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f31707c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final int f31708d = 4;

        /* renamed from: e  reason: collision with root package name */
        public static final int f31709e = 5;

        /* renamed from: f  reason: collision with root package name */
        public static final int f31710f = 6;

        /* renamed from: g  reason: collision with root package name */
        public static final int f31711g = 7;

        /* renamed from: h  reason: collision with root package name */
        public static final /* synthetic */ int[] f31712h;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(637300350, "Lcom/baidu/browser/sailor/webkit/update/BdZeusDownloadHelper$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(637300350, "Lcom/baidu/browser/sailor/webkit/update/BdZeusDownloadHelper$a;");
                    return;
                }
            }
            f31712h = new int[]{1, 2, 3, 4, 5, 6, 7};
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(939209627, "Lcom/baidu/browser/sailor/webkit/update/BdZeusDownloadHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(939209627, "Lcom/baidu/browser/sailor/webkit/update/BdZeusDownloadHelper;");
        }
    }

    public BdZeusDownloadHelper(Context context) {
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
        this.f31701b = "";
        this.f31703d = "";
        this.a = context;
        int i4 = a.f31707c;
        if (context != null) {
            f31698h = this.a.getExternalFilesDir("").getAbsolutePath() + "/baidu/zeus/";
            f31699i = f31698h + "updateZeus.zes";
        }
    }

    public static BdZeusDownloadHelper b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f31697g == null) {
                synchronized (BdZeusDownloadHelper.class) {
                    if (f31697g == null) {
                        f31697g = new BdZeusDownloadHelper(context);
                    }
                }
            }
            return f31697g;
        }
        return (BdZeusDownloadHelper) invokeL.objValue;
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            SharedPreferences.Editor edit = this.a.getSharedPreferences(f31700j, 0).edit();
            edit.putString("zeus_download_id", str);
            edit.commit();
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(f31698h)) {
                return;
            }
            try {
                File file = new File(f31698h);
                if (file.exists()) {
                    for (File file2 : file.listFiles()) {
                        file2.delete();
                    }
                }
            } catch (Exception e2) {
                Log.e(e2.toString());
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0034: INVOKE  (r0v8 long A[REMOVE]) =  type: STATIC call: java.lang.System.currentTimeMillis():long)] */
    public final void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            if (TextUtils.isEmpty(str)) {
                WebKitFactory.getLoadErrorCode().addDownloadInfo(1004);
                return;
            }
            this.f31701b = str;
            this.f31703d = str2;
            if (TextUtils.isEmpty(this.a.getSharedPreferences(f31700j, 0).getString("zeus_download_id", ""))) {
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                d(sb.toString());
            }
            try {
                BdSailorClient sailorClient = BdSailor.getInstance().getSailorClient();
                if (sailorClient == null) {
                    WebKitFactory.getLoadErrorCode().addDownloadInfo(1005);
                } else if (TextUtils.isEmpty(f31698h)) {
                    WebKitFactory.getLoadErrorCode().addDownloadInfo(1006);
                } else {
                    sailorClient.onDownloadTask(this.f31701b, "", f31698h, "updateZeus.zes", BdSailorClient.DownloadTaskType.ZEUS, new ZeusDownloadTaskListener(this, null));
                }
            } catch (Throwable th) {
                LoadErrorCode loadErrorCode = WebKitFactory.getLoadErrorCode();
                loadErrorCode.addDownloadInfo("1008" + th.toString());
                th.printStackTrace();
            }
        }
    }
}
