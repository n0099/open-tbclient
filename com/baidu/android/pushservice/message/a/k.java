package com.baidu.android.pushservice.message.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;
    public static final k a;

    /* renamed from: b  reason: collision with root package name */
    public static final k f24761b;

    /* renamed from: c  reason: collision with root package name */
    public static final k f24762c;

    /* renamed from: d  reason: collision with root package name */
    public static final k f24763d;

    /* renamed from: e  reason: collision with root package name */
    public static final k f24764e;

    /* renamed from: f  reason: collision with root package name */
    public static final k f24765f;

    /* renamed from: g  reason: collision with root package name */
    public static final k f24766g;

    /* renamed from: h  reason: collision with root package name */
    public static final k f24767h;
    public static final k i;
    public static final k j;
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
        f24761b = new k("MSG_TYPE_SINGLE_PRIVATE", 1, 0);
        f24762c = new k("MSG_TYPE_MULTI_PRIVATE", 2, 1);
        f24763d = new k("MSG_TYPE_SINGLE_PUBLIC", 3, 2);
        f24764e = new k("MSG_TYPE_MULTI_PUBLIC", 4, 3);
        f24765f = new k("MSG_TYPE_MULTI_PRIVATE_NOTIFICATION", 5, 5);
        f24766g = new k("MSG_TYPE_PRIVATE_MESSAGE", 6, 6);
        f24767h = new k("MSG_TYPE_CLEAR_MESSAGE", 7, 8);
        i = new k("MSG_TYPE_APP_PRIORITY", 8, 30);
        j = new k("MSG_TYPE_INNERBIND", 9, 101);
        k kVar = new k("MSG_TYPE_APPSTAT_COMMAND", 10, 104);
        k = kVar;
        m = new k[]{a, f24761b, f24762c, f24763d, f24764e, f24765f, f24766g, f24767h, i, j, kVar};
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
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 5 ? i2 != 6 ? i2 != 8 ? i2 != 30 ? i2 != 101 ? i2 != 104 ? a : k : j : i : f24767h : f24766g : f24765f : f24764e : f24763d : f24762c : f24761b : (k) invokeI.objValue;
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
