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
/* loaded from: classes.dex */
public final class BdZeusDownloadHelper {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static BdZeusDownloadHelper f4376g = null;

    /* renamed from: h  reason: collision with root package name */
    public static String f4377h = null;

    /* renamed from: i  reason: collision with root package name */
    public static String f4378i = null;
    public static String j = "com.baidu.android.appswitchsdk:web";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f4379a;

    /* renamed from: b  reason: collision with root package name */
    public String f4380b;

    /* renamed from: c  reason: collision with root package name */
    public int f4381c;

    /* renamed from: d  reason: collision with root package name */
    public String f4382d;

    /* renamed from: e  reason: collision with root package name */
    public long f4383e;

    /* renamed from: f  reason: collision with root package name */
    public long f4384f;

    /* loaded from: classes.dex */
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
        public void onDownloadCancel(String str, long j, long j2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), str2}) == null) {
                this.this$0.f4381c = a.f4390f;
                Log.i(EngineManager.LOG_TAG, "onDownloadCancel");
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadFail(String str, long j, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Long.valueOf(j), str2, str3}) == null) {
                this.this$0.f4381c = a.f4389e;
                Log.i(EngineManager.LOG_TAG, "onDownloadFail");
                this.this$0.d("");
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadPause(String str, long j, long j2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), str2}) == null) {
                this.this$0.f4381c = a.f4386b;
                Log.i(EngineManager.LOG_TAG, "onDownloadPause");
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadStart(String str, long j, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Long.valueOf(j), str2}) == null) {
                this.this$0.f4381c = a.f4385a;
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloadSuccess(String str, String str2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Long.valueOf(j)}) == null) {
                this.this$0.f4381c = a.f4388d;
                Log.i(EngineManager.LOG_TAG, "aKey:" + str + ", aFilelength:" + j);
                Log.i(EngineManager.LOG_TAG, "onDownloadSuccess");
                if (TextUtils.isEmpty(BdZeusDownloadHelper.f4378i)) {
                    return;
                }
                this.this$0.d("");
                File file = new File(BdZeusDownloadHelper.f4378i);
                if (!file.exists()) {
                    Log.e("Apk file is not exist.");
                    if (TextUtils.isEmpty(this.this$0.f4380b)) {
                        return;
                    }
                    BdZeusDownloadHelper bdZeusDownloadHelper = this.this$0;
                    bdZeusDownloadHelper.e(bdZeusDownloadHelper.f4380b, this.this$0.f4382d);
                } else if (file.length() != j) {
                    Log.e("Apk file download failed: wrong size");
                    file.delete();
                    if (TextUtils.isEmpty(this.this$0.f4380b)) {
                        return;
                    }
                    BdZeusDownloadHelper bdZeusDownloadHelper2 = this.this$0;
                    bdZeusDownloadHelper2.e(bdZeusDownloadHelper2.f4380b, this.this$0.f4382d);
                } else {
                    Log.i(EngineManager.LOG_TAG, " begine check md5");
                    String a2 = d.a.j.b.c.b.a(BdZeusDownloadHelper.f4378i);
                    if (a2 == null || !a2.equalsIgnoreCase(this.this$0.f4382d)) {
                        Log.i(EngineManager.LOG_TAG, " check md5 failed ");
                        return;
                    }
                    Log.i(EngineManager.LOG_TAG, " begine install");
                    if (WebKitFactory.getCurEngine() != 1) {
                        BdSailorPlatform.getStatic().c("download-webkit-end", String.valueOf(System.currentTimeMillis()));
                        BdSailorPlatform.getStatic().a();
                    }
                    BdSailorPlatform.getWebkitManager().installZeusFromDownload(BdZeusDownloadHelper.f4378i);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorClient.IDownloadTaskListener
        @Keep
        public void onDownloading(String str, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)}) == null) {
                BdZeusDownloadHelper bdZeusDownloadHelper = this.this$0;
                bdZeusDownloadHelper.f4383e += j;
                bdZeusDownloadHelper.f4384f = j2;
                bdZeusDownloadHelper.f4381c = a.f4385a;
            }
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static final int f4385a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f4386b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f4387c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final int f4388d = 4;

        /* renamed from: e  reason: collision with root package name */
        public static final int f4389e = 5;

        /* renamed from: f  reason: collision with root package name */
        public static final int f4390f = 6;

        /* renamed from: g  reason: collision with root package name */
        public static final int f4391g = 7;

        /* renamed from: h  reason: collision with root package name */
        public static final /* synthetic */ int[] f4392h;
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
            f4392h = new int[]{1, 2, 3, 4, 5, 6, 7};
        }
    }

    /* loaded from: classes.dex */
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
        this.f4380b = "";
        this.f4382d = "";
        this.f4379a = context;
        int i4 = a.f4387c;
        if (context != null) {
            f4377h = this.f4379a.getExternalFilesDir("").getAbsolutePath() + "/baidu/zeus/";
            f4378i = f4377h + "updateZeus.zes";
        }
    }

    public static BdZeusDownloadHelper b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f4376g == null) {
                synchronized (BdZeusDownloadHelper.class) {
                    if (f4376g == null) {
                        f4376g = new BdZeusDownloadHelper(context);
                    }
                }
            }
            return f4376g;
        }
        return (BdZeusDownloadHelper) invokeL.objValue;
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            SharedPreferences.Editor edit = this.f4379a.getSharedPreferences(j, 0).edit();
            edit.putString("zeus_download_id", str);
            edit.commit();
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(f4377h)) {
                return;
            }
            try {
                File file = new File(f4377h);
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
        this.f4380b = str;
        this.f4382d = str2;
        if (TextUtils.isEmpty(this.f4379a.getSharedPreferences(j, 0).getString("zeus_download_id", ""))) {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            d(sb.toString());
        }
        try {
            BdSailorClient sailorClient = BdSailor.getInstance().getSailorClient();
            if (sailorClient == null || TextUtils.isEmpty(f4377h)) {
                return;
            }
            sailorClient.onDownloadTask(this.f4380b, "", f4377h, "updateZeus.zes", BdSailorClient.DownloadTaskType.ZEUS, new ZeusDownloadTaskListener(this, null));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
