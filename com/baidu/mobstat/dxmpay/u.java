package com.baidu.mobstat.dxmpay;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static u f38120b;

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f38121c;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: d  reason: collision with root package name */
    public List<PermissionEnum> f38122d;

    /* renamed from: e  reason: collision with root package name */
    public String f38123e;

    /* renamed from: f  reason: collision with root package name */
    public String f38124f;

    /* renamed from: g  reason: collision with root package name */
    public List<JSONObject> f38125g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1455169661, "Lcom/baidu/mobstat/dxmpay/u;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1455169661, "Lcom/baidu/mobstat/dxmpay/u;");
                return;
            }
        }
        f38121c = Pattern.compile("\\s*|\t|\r|\n");
    }

    public u() {
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
        this.f38122d = new ArrayList();
        this.f38123e = "android.permission.APP_LIST";
        this.a = 100;
        this.f38125g = new ArrayList();
    }

    public static synchronized u a() {
        InterceptResult invokeV;
        u uVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (u.class) {
                if (f38120b == null) {
                    f38120b = new u();
                }
                uVar = f38120b;
            }
            return uVar;
        }
        return (u) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TextUtils.isEmpty(this.f38124f) ? "" : this.f38124f : (String) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f38124f = str;
        }
    }
}
