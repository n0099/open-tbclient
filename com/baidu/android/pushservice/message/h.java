package com.baidu.android.pushservice.message;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final h f36617a;

    /* renamed from: b  reason: collision with root package name */
    public static final h f36618b;

    /* renamed from: c  reason: collision with root package name */
    public static final h f36619c;

    /* renamed from: d  reason: collision with root package name */
    public static final h f36620d;

    /* renamed from: e  reason: collision with root package name */
    public static final h f36621e;

    /* renamed from: f  reason: collision with root package name */
    public static final h f36622f;

    /* renamed from: g  reason: collision with root package name */
    public static final h f36623g;

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ h[] f36624i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public short f36625h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(706729533, "Lcom/baidu/android/pushservice/message/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(706729533, "Lcom/baidu/android/pushservice/message/h;");
                return;
            }
        }
        f36617a = new h("TYPE_INVALUE", 0, -1);
        f36618b = new h("MSG_ID_HANDSHAKE", 1, 1);
        f36619c = new h("MSG_ID_HEARTBEAT_SERVER", 2, 2);
        f36620d = new h("MSG_ID_HEARTBEAT_CLIENT", 3, 4);
        f36621e = new h("MSG_ID_PUSH_MSG", 4, 3);
        f36622f = new h("MSG_ID_TINY_HEARTBEAT_CLIENT", 5, 5);
        h hVar = new h("MSG_ID_TINY_HEARTBEAT_SERVER", 6, 6);
        f36623g = hVar;
        f36624i = new h[]{f36617a, f36618b, f36619c, f36620d, f36621e, f36622f, hVar};
    }

    public h(String str, int i2, int i3) {
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
        this.f36625h = (short) i3;
    }

    public static h a(short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Short.valueOf(s)})) == null) {
            switch (s) {
                case 1:
                    return f36618b;
                case 2:
                    return f36619c;
                case 3:
                    return f36621e;
                case 4:
                    return f36620d;
                case 5:
                    return f36622f;
                case 6:
                    return f36623g;
                default:
                    return f36617a;
            }
        }
        return (h) invokeCommon.objValue;
    }

    public static h[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (h[]) f36624i.clone() : (h[]) invokeV.objValue;
    }

    public short b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f36625h : invokeV.shortValue;
    }
}
