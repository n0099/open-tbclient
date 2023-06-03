package com.baidu.browser.sailor.webkit.update;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.BdSailorClient;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tieba.qx;
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
/* loaded from: classes3.dex */
public final class BdZeusDownloadHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static BdZeusDownloadHelper g = null;
    public static String h = null;
    public static String i = null;
    public static String j = "com.baidu.android.appswitchsdk:web";
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public String b;
    public int c;
    public String d;
    public long e;
    public long f;

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        public void onDownloadCancel(String str, long j, long j2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), str2}) == null) {
                this.this$0.c = a.f;
                Log.i(EngineManager.LOG_TAG, "onDownloadCancel");
                WebKitFactory.getLoadErrorCode().addDownloadInfo(1026);
                ZeusPerformanceTiming.setZeusDownloadInfo(WebKitFactory.getLoadErrorCode().getDownloadInfo());
                ZeusPerformanceTiming.recordDownloadInitStatistics();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadFail(String str, long j, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Long.valueOf(j), str2, str3}) == null) {
                this.this$0.c = a.e;
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
        public void onDownloadPause(String str, long j, long j2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), str2}) == null) {
                this.this$0.c = a.b;
                Log.i(EngineManager.LOG_TAG, "onDownloadPause");
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadStart(String str, long j, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Long.valueOf(j), str2}) == null) {
                this.this$0.c = a.a;
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadSuccess(String str, String str2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Long.valueOf(j)}) == null) {
                this.this$0.c = a.d;
                Log.i(EngineManager.LOG_TAG, "aKey:" + str + ", aFilelength:" + j);
                Log.i(EngineManager.LOG_TAG, "onDownloadSuccess");
                if (TextUtils.isEmpty(BdZeusDownloadHelper.i)) {
                    WebKitFactory.getLoadErrorCode().addDownloadInfo(1007);
                    return;
                }
                this.this$0.d("");
                File file = new File(BdZeusDownloadHelper.i);
                if (!file.exists()) {
                    Log.e("Apk file is not exist.");
                    WebKitFactory.getLoadErrorCode().addDownloadInfo(1009);
                    if (TextUtils.isEmpty(this.this$0.b)) {
                        return;
                    }
                    BdZeusDownloadHelper bdZeusDownloadHelper = this.this$0;
                    bdZeusDownloadHelper.e(bdZeusDownloadHelper.b, this.this$0.d);
                } else if (file.length() != j) {
                    Log.e("Apk file download failed: wrong size");
                    WebKitFactory.getLoadErrorCode().addDownloadInfo(1010);
                    file.delete();
                    if (TextUtils.isEmpty(this.this$0.b)) {
                        return;
                    }
                    BdZeusDownloadHelper bdZeusDownloadHelper2 = this.this$0;
                    bdZeusDownloadHelper2.e(bdZeusDownloadHelper2.b, this.this$0.d);
                } else {
                    Log.i(EngineManager.LOG_TAG, " begine check md5");
                    String a = qx.a(BdZeusDownloadHelper.i);
                    if (a == null || !a.equalsIgnoreCase(this.this$0.d)) {
                        WebKitFactory.getLoadErrorCode().addDownloadInfo(1011);
                        Log.i(EngineManager.LOG_TAG, " check md5 failed ");
                        return;
                    }
                    Log.i(EngineManager.LOG_TAG, " begine install");
                    if (WebKitFactory.getCurEngine() != 1) {
                        BdSailorPlatform.getStatic().c("download-webkit-end", String.valueOf(System.currentTimeMillis()));
                        BdSailorPlatform.getStatic().a();
                    }
                    BdSailorPlatform.getWebkitManager().installZeusFromDownload(BdZeusDownloadHelper.i);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloading(String str, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)}) == null) {
                BdZeusDownloadHelper bdZeusDownloadHelper = this.this$0;
                bdZeusDownloadHelper.e += j;
                bdZeusDownloadHelper.f = j2;
                bdZeusDownloadHelper.c = a.a;
            }
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        public static final int f = 6;
        public static final int g = 7;
        public static final /* synthetic */ int[] h;
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
            h = new int[]{1, 2, 3, 4, 5, 6, 7};
        }
    }

    /* loaded from: classes3.dex */
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
        this.b = "";
        this.d = "";
        this.a = context;
        int i4 = a.c;
        if (context != null) {
            h = this.a.getExternalFilesDir("").getAbsolutePath() + "/baidu/zeus/";
            i = h + "updateZeus.zes";
        }
    }

    public static BdZeusDownloadHelper b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (g == null) {
                synchronized (BdZeusDownloadHelper.class) {
                    if (g == null) {
                        g = new BdZeusDownloadHelper(context);
                    }
                }
            }
            return g;
        }
        return (BdZeusDownloadHelper) invokeL.objValue;
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            SharedPreferences.Editor edit = this.a.getSharedPreferences(j, 0).edit();
            edit.putString("zeus_download_id", str);
            edit.commit();
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(h)) {
                return;
            }
            try {
                File file = new File(h);
                if (file.exists()) {
                    for (File file2 : file.listFiles()) {
                        file2.delete();
                    }
                }
            } catch (Exception e) {
                Log.e(e.toString());
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0035: INVOKE  (r0v8 long A[REMOVE]) =  type: STATIC call: java.lang.System.currentTimeMillis():long)] */
    public final void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            if (TextUtils.isEmpty(str)) {
                WebKitFactory.getLoadErrorCode().addDownloadInfo(1004);
                return;
            }
            this.b = str;
            this.d = str2;
            if (TextUtils.isEmpty(this.a.getSharedPreferences(j, 0).getString("zeus_download_id", ""))) {
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                d(sb.toString());
            }
            try {
                BdSailorClient sailorClient = BdSailor.getInstance().getSailorClient();
                if (sailorClient == null) {
                    WebKitFactory.getLoadErrorCode().addDownloadInfo(1005);
                } else if (TextUtils.isEmpty(h)) {
                    WebKitFactory.getLoadErrorCode().addDownloadInfo(1006);
                } else {
                    sailorClient.onDownloadTask(this.b, "", h, "updateZeus.zes", BdSailorClient.DownloadTaskType.ZEUS, new ZeusDownloadTaskListener(this, null));
                }
            } catch (Throwable th) {
                LoadErrorCode loadErrorCode = WebKitFactory.getLoadErrorCode();
                loadErrorCode.addDownloadInfo(DownloadStatisticConstants.DOWNLOAD_WINDOWN_UBC_ID + th.toString());
                th.printStackTrace();
            }
        }
    }
}
