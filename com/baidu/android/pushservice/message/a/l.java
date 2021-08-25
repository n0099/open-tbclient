package com.baidu.android.pushservice.message.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final l f37573a;

    /* renamed from: b  reason: collision with root package name */
    public static final l f37574b;

    /* renamed from: c  reason: collision with root package name */
    public static final l f37575c;

    /* renamed from: d  reason: collision with root package name */
    public static final l f37576d;

    /* renamed from: e  reason: collision with root package name */
    public static final l f37577e;

    /* renamed from: f  reason: collision with root package name */
    public static final l f37578f;

    /* renamed from: g  reason: collision with root package name */
    public static final l f37579g;

    /* renamed from: h  reason: collision with root package name */
    public static final l f37580h;

    /* renamed from: i  reason: collision with root package name */
    public static final l f37581i;

    /* renamed from: j  reason: collision with root package name */
    public static final l f37582j;
    public static final l k;
    public static final l l;
    public static final /* synthetic */ l[] n;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(562031783, "Lcom/baidu/android/pushservice/message/a/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(562031783, "Lcom/baidu/android/pushservice/message/a/l;");
                return;
            }
        }
        f37573a = new l("MSG_TYPE_INVALID", 0, -1);
        f37574b = new l("MSG_TYPE_SINGLE_PRIVATE", 1, 0);
        f37575c = new l("MSG_TYPE_MULTI_PRIVATE", 2, 1);
        f37576d = new l("MSG_TYPE_SINGLE_PUBLIC", 3, 2);
        f37577e = new l("MSG_TYPE_MULTI_PUBLIC", 4, 3);
        f37578f = new l("MSG_TYPE_MULTI_PRIVATE_NOTIFICATION", 5, 5);
        f37579g = new l("MSG_TYPE_PRIVATE_MESSAGE", 6, 6);
        f37580h = new l("MSG_TYPE_CLEAR_MESSAGE", 7, 8);
        f37581i = new l("MSG_TYPE_CROSS_PUSH", 8, 20);
        f37582j = new l("MSG_TYPE_APP_PRIORITY", 9, 30);
        k = new l("MSG_TYPE_INNERBIND", 10, 101);
        l lVar = new l("MSG_TYPE_APPSTAT_COMMAND", 11, 104);
        l = lVar;
        n = new l[]{f37573a, f37574b, f37575c, f37576d, f37577e, f37578f, f37579g, f37580h, f37581i, f37582j, k, lVar};
    }

    public l(String str, int i2, int i3) {
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
        this.m = i3;
    }

    public static l a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 5 ? i2 != 6 ? i2 != 8 ? i2 != 20 ? i2 != 30 ? i2 != 101 ? i2 != 104 ? f37573a : l : k : f37582j : f37581i : f37580h : f37579g : f37578f : f37577e : f37576d : f37575c : f37574b : (l) invokeI.objValue;
    }

    public static l[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (l[]) n.clone() : (l[]) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m : invokeV.intValue;
    }
}
