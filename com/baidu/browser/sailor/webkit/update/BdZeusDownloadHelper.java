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
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.File;
/* loaded from: classes5.dex */
public final class BdZeusDownloadHelper {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static BdZeusDownloadHelper f38616g = null;

    /* renamed from: h  reason: collision with root package name */
    public static String f38617h = null;

    /* renamed from: i  reason: collision with root package name */
    public static String f38618i = null;

    /* renamed from: j  reason: collision with root package name */
    public static String f38619j = "com.baidu.android.appswitchsdk:web";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f38620a;

    /* renamed from: b  reason: collision with root package name */
    public String f38621b;

    /* renamed from: c  reason: collision with root package name */
    public int f38622c;

    /* renamed from: d  reason: collision with root package name */
    public String f38623d;

    /* renamed from: e  reason: collision with root package name */
    public long f38624e;

    /* renamed from: f  reason: collision with root package name */
    public long f38625f;

    /* loaded from: classes5.dex */
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
                this.this$0.f38622c = a.f38631f;
                Log.i(EngineManager.LOG_TAG, "onDownloadCancel");
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadFail(String str, long j2, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Long.valueOf(j2), str2, str3}) == null) {
                this.this$0.f38622c = a.f38630e;
                Log.i(EngineManager.LOG_TAG, "onDownloadFail");
                this.this$0.d("");
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadPause(String str, long j2, long j3, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3), str2}) == null) {
                this.this$0.f38622c = a.f38627b;
                Log.i(EngineManager.LOG_TAG, "onDownloadPause");
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadStart(String str, long j2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Long.valueOf(j2), str2}) == null) {
                this.this$0.f38622c = a.f38626a;
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadSuccess(String str, String str2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Long.valueOf(j2)}) == null) {
                this.this$0.f38622c = a.f38629d;
                Log.i(EngineManager.LOG_TAG, "aKey:" + str + ", aFilelength:" + j2);
                Log.i(EngineManager.LOG_TAG, "onDownloadSuccess");
                if (TextUtils.isEmpty(BdZeusDownloadHelper.f38618i)) {
                    return;
                }
                this.this$0.d("");
                File file = new File(BdZeusDownloadHelper.f38618i);
                if (!file.exists()) {
                    Log.e("Apk file is not exist.");
                    if (TextUtils.isEmpty(this.this$0.f38621b)) {
                        return;
                    }
                    BdZeusDownloadHelper bdZeusDownloadHelper = this.this$0;
                    bdZeusDownloadHelper.e(bdZeusDownloadHelper.f38621b, this.this$0.f38623d);
                } else if (file.length() != j2) {
                    Log.e("Apk file download failed: wrong size");
                    file.delete();
                    if (TextUtils.isEmpty(this.this$0.f38621b)) {
                        return;
                    }
                    BdZeusDownloadHelper bdZeusDownloadHelper2 = this.this$0;
                    bdZeusDownloadHelper2.e(bdZeusDownloadHelper2.f38621b, this.this$0.f38623d);
                } else {
                    Log.i(EngineManager.LOG_TAG, " begine check md5");
                    String a2 = c.a.k.b.c.b.a(BdZeusDownloadHelper.f38618i);
                    if (a2 == null || !a2.equalsIgnoreCase(this.this$0.f38623d)) {
                        Log.i(EngineManager.LOG_TAG, " check md5 failed ");
                        return;
                    }
                    Log.i(EngineManager.LOG_TAG, " begine install");
                    if (WebKitFactory.getCurEngine() != 1) {
                        BdSailorPlatform.getStatic().c("download-webkit-end", String.valueOf(System.currentTimeMillis()));
                        BdSailorPlatform.getStatic().a();
                    }
                    BdSailorPlatform.getWebkitManager().installZeusFromDownload(BdZeusDownloadHelper.f38618i);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloading(String str, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                BdZeusDownloadHelper bdZeusDownloadHelper = this.this$0;
                bdZeusDownloadHelper.f38624e += j2;
                bdZeusDownloadHelper.f38625f = j3;
                bdZeusDownloadHelper.f38622c = a.f38626a;
            }
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static final int f38626a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f38627b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f38628c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final int f38629d = 4;

        /* renamed from: e  reason: collision with root package name */
        public static final int f38630e = 5;

        /* renamed from: f  reason: collision with root package name */
        public static final int f38631f = 6;

        /* renamed from: g  reason: collision with root package name */
        public static final int f38632g = 7;

        /* renamed from: h  reason: collision with root package name */
        public static final /* synthetic */ int[] f38633h;
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
            f38633h = new int[]{1, 2, 3, 4, 5, 6, 7};
        }
    }

    /* loaded from: classes5.dex */
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
        this.f38621b = "";
        this.f38623d = "";
        this.f38620a = context;
        int i4 = a.f38628c;
        if (context != null) {
            f38617h = this.f38620a.getExternalFilesDir("").getAbsolutePath() + "/baidu/zeus/";
            f38618i = f38617h + "updateZeus.zes";
        }
    }

    public static BdZeusDownloadHelper b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f38616g == null) {
                synchronized (BdZeusDownloadHelper.class) {
                    if (f38616g == null) {
                        f38616g = new BdZeusDownloadHelper(context);
                    }
                }
            }
            return f38616g;
        }
        return (BdZeusDownloadHelper) invokeL.objValue;
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            SharedPreferences.Editor edit = this.f38620a.getSharedPreferences(f38619j, 0).edit();
            edit.putString("zeus_download_id", str);
            edit.commit();
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(f38617h)) {
                return;
            }
            try {
                File file = new File(f38617h);
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

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x002c: INVOKE  (r0v6 long A[REMOVE]) =  type: STATIC call: java.lang.System.currentTimeMillis():long)] */
    public final void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f38621b = str;
        this.f38623d = str2;
        if (TextUtils.isEmpty(this.f38620a.getSharedPreferences(f38619j, 0).getString("zeus_download_id", ""))) {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            d(sb.toString());
        }
        try {
            BdSailorClient sailorClient = BdSailor.getInstance().getSailorClient();
            if (sailorClient == null || TextUtils.isEmpty(f38617h)) {
                return;
            }
            sailorClient.onDownloadTask(this.f38621b, "", f38617h, "updateZeus.zes", BdSailorClient.DownloadTaskType.ZEUS, new ZeusDownloadTaskListener(this, null));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
