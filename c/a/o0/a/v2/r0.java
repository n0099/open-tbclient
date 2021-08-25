package c.a.o0.a.v2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class r0 {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static Context f9375a;
    public transient /* synthetic */ FieldHolder $fh;

    @TargetApi(11)
    /* loaded from: classes.dex */
    public static class a extends r0 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static ClipboardManager f9376b;

        /* renamed from: c  reason: collision with root package name */
        public static ClipData f9377c;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(41272451, "Lc/a/o0/a/v2/r0$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(41272451, "Lc/a/o0/a/v2/r0$a;");
            }
        }

        @SuppressLint({"ServiceCast"})
        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            f9376b = (ClipboardManager) r0.f9375a.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
        }

        @Override // c.a.o0.a.v2.r0
        public CharSequence a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    f9377c = f9376b.getPrimaryClip();
                } catch (Exception e2) {
                    if (c.a.o0.a.k.f7049a) {
                        throw e2;
                    }
                }
                ClipData clipData = f9377c;
                return (clipData == null || clipData.getItemCount() <= 0) ? "" : f9377c.getItemAt(0).getText();
            }
            return (CharSequence) invokeV.objValue;
        }

        @Override // c.a.o0.a.v2.r0
        public void c(CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence) == null) {
                ClipData newPlainText = ClipData.newPlainText("text/plain", charSequence);
                f9377c = newPlainText;
                try {
                    f9376b.setPrimaryClip(newPlainText);
                } catch (RuntimeException e2) {
                    if (c.a.o0.a.k.f7049a) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends r0 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static android.text.ClipboardManager f9378b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(41272482, "Lc/a/o0/a/v2/r0$b;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(41272482, "Lc/a/o0/a/v2/r0$b;");
            }
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            f9378b = (android.text.ClipboardManager) r0.f9375a.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
        }

        @Override // c.a.o0.a.v2.r0
        public CharSequence a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f9378b.getText() : (CharSequence) invokeV.objValue;
        }

        @Override // c.a.o0.a.v2.r0
        public void c(CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence) == null) {
                f9378b.setText(charSequence);
            }
        }
    }

    public r0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static r0 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            f9375a = context.getApplicationContext();
            if (d.c()) {
                return new a();
            }
            return new b();
        }
        return (r0) invokeL.objValue;
    }

    public abstract CharSequence a();

    public abstract void c(CharSequence charSequence);
}
