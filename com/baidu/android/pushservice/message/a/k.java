package com.baidu.android.pushservice.message.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;
    public static final k a;

    /* renamed from: b  reason: collision with root package name */
    public static final k f32311b;

    /* renamed from: c  reason: collision with root package name */
    public static final k f32312c;

    /* renamed from: d  reason: collision with root package name */
    public static final k f32313d;

    /* renamed from: e  reason: collision with root package name */
    public static final k f32314e;

    /* renamed from: f  reason: collision with root package name */
    public static final k f32315f;

    /* renamed from: g  reason: collision with root package name */
    public static final k f32316g;

    /* renamed from: h  reason: collision with root package name */
    public static final k f32317h;

    /* renamed from: i  reason: collision with root package name */
    public static final k f32318i;

    /* renamed from: j  reason: collision with root package name */
    public static final k f32319j;
    public static final k k;
    public static final /* synthetic */ k[] m;
    public transient /* synthetic */ FieldHolder $fh;
    public int l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(562031752, "Lcom/baidu/android/pushservice/message/a/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(562031752, "Lcom/baidu/android/pushservice/message/a/k;");
                return;
            }
        }
        a = new k("MSG_TYPE_INVALID", 0, -1);
        f32311b = new k("MSG_TYPE_SINGLE_PRIVATE", 1, 0);
        f32312c = new k("MSG_TYPE_MULTI_PRIVATE", 2, 1);
        f32313d = new k("MSG_TYPE_SINGLE_PUBLIC", 3, 2);
        f32314e = new k("MSG_TYPE_MULTI_PUBLIC", 4, 3);
        f32315f = new k("MSG_TYPE_MULTI_PRIVATE_NOTIFICATION", 5, 5);
        f32316g = new k("MSG_TYPE_PRIVATE_MESSAGE", 6, 6);
        f32317h = new k("MSG_TYPE_CLEAR_MESSAGE", 7, 8);
        f32318i = new k("MSG_TYPE_APP_PRIORITY", 8, 30);
        f32319j = new k("MSG_TYPE_INNERBIND", 9, 101);
        k kVar = new k("MSG_TYPE_APPSTAT_COMMAND", 10, 104);
        k = kVar;
        m = new k[]{a, f32311b, f32312c, f32313d, f32314e, f32315f, f32316g, f32317h, f32318i, f32319j, kVar};
    }

    public k(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = i3;
    }

    public static k a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 5 ? i2 != 6 ? i2 != 8 ? i2 != 30 ? i2 != 101 ? i2 != 104 ? a : k : f32319j : f32318i : f32317h : f32316g : f32315f : f32314e : f32313d : f32312c : f32311b : (k) invokeI.objValue;
    }

    public static k[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (k[]) m.clone() : (k[]) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.l : invokeV.intValue;
    }
}
