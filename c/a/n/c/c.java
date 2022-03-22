package c.a.n.c;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f3840b;

    /* renamed from: c  reason: collision with root package name */
    public String f3841c;

    /* renamed from: d  reason: collision with root package name */
    public String f3842d;

    public c() {
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
        b();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3842d : (String) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String str = Build.MODEL;
            this.a = str;
            if (TextUtils.isEmpty(str)) {
                this.a = "NUL";
            } else {
                this.a = this.a.replace("_", "-");
            }
            String str2 = Build.MANUFACTURER;
            this.f3840b = str2;
            if (TextUtils.isEmpty(str2)) {
                this.f3840b = "NUL";
            } else {
                this.f3840b = this.f3840b.replace("_", "-");
            }
            String str3 = Build.VERSION.RELEASE;
            this.f3841c = str3;
            if (TextUtils.isEmpty(str3)) {
                this.f3841c = "0.0";
            } else {
                this.f3841c = this.f3841c.replace("_", "-");
            }
            this.f3842d = c();
        }
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String str = this.a;
            String str2 = this.f3841c;
            int i = Build.VERSION.SDK_INT;
            String str3 = this.f3840b;
            return str + "_" + str2 + "_" + i + "_" + str3;
        }
        return (String) invokeV.objValue;
    }
}
