package com.baidu.pass.biometrics.face.liveness.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.pass.biometrics.base.NoProguard;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class YYProtocolActivity extends Activity implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f27979b;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYProtocolActivity a;

        public a(YYProtocolActivity yYProtocolActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYProtocolActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYProtocolActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.finish();
            }
        }
    }

    public YYProtocolActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.a.setOnClickListener(new a(this));
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fc3);
            WebView webView = (WebView) findViewById(R.id.obfuscated_res_0x7f092445);
            this.f27979b = webView;
            webView.setWebChromeClient(new WebChromeClient());
            this.f27979b.setWebViewClient(new WebViewClient());
            this.f27979b.loadUrl(PassBioEnv.YY_PERSONAL_INFO_PROTOCOL);
        }
    }

    public static void newLoginStatusBarTint(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, activity) == null) {
            if (!b(activity, true)) {
                a(activity, true);
            }
            setTranslucentStatus(activity);
            setRootViewFitsSystemWindows(activity, false);
        }
    }

    public static void setRootViewFitsSystemWindows(Activity activity, boolean z) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65542, null, activity, z) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) activity.findViewById(16908290);
        if (viewGroup2.getChildCount() <= 0 || (viewGroup = (ViewGroup) viewGroup2.getChildAt(0)) == null) {
            return;
        }
        viewGroup.setFitsSystemWindows(z);
    }

    public static void setTranslucentStatus(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, activity) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 21) {
                Window window = activity.getWindow();
                window.getDecorView().setSystemUiVisibility(Build.VERSION.SDK_INT >= 23 ? 9472 : 1280);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(0);
            } else if (i >= 19) {
                Window window2 = activity.getWindow();
                WindowManager.LayoutParams attributes = window2.getAttributes();
                attributes.flags |= CodedInputStream.DEFAULT_SIZE_LIMIT;
                window2.setAttributes(attributes);
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            requestWindowFeature(1);
            if (Build.VERSION.SDK_INT >= 19) {
                getWindow().addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            }
            getWindow().addFlags(128);
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d04a9);
            b();
            a();
            newLoginStatusBarTint(this);
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDestroy();
            WebView webView = this.f27979b;
            if (webView != null) {
                webView.destroy();
                this.f27979b = null;
            }
        }
    }

    public static boolean a(Activity activity, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, activity, z)) == null) {
            try {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i = declaredField.getInt(null);
                int i2 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, z ? i2 | i : (~i) & i2);
                activity.getWindow().setAttributes(attributes);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLZ.booleanValue;
    }

    public static boolean b(Activity activity, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, z)) == null) {
            Window window = activity.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            window.getDecorView().setSystemUiVisibility(8192);
            Class<?> cls = activity.getWindow().getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                Window window2 = activity.getWindow();
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(z ? i : 0);
                objArr[1] = Integer.valueOf(i);
                method.invoke(window2, objArr);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLZ.booleanValue;
    }
}
