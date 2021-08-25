package com.baidu.android.pushservice.message;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final h f37594a;

    /* renamed from: b  reason: collision with root package name */
    public static final h f37595b;

    /* renamed from: c  reason: collision with root package name */
    public static final h f37596c;

    /* renamed from: d  reason: collision with root package name */
    public static final h f37597d;

    /* renamed from: e  reason: collision with root package name */
    public static final h f37598e;

    /* renamed from: f  reason: collision with root package name */
    public static final h f37599f;

    /* renamed from: g  reason: collision with root package name */
    public static final h f37600g;

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ h[] f37601i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public short f37602h;

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
        f37594a = new h("TYPE_INVALUE", 0, -1);
        f37595b = new h("MSG_ID_HANDSHAKE", 1, 1);
        f37596c = new h("MSG_ID_HEARTBEAT_SERVER", 2, 2);
        f37597d = new h("MSG_ID_HEARTBEAT_CLIENT", 3, 4);
        f37598e = new h("MSG_ID_PUSH_MSG", 4, 3);
        f37599f = new h("MSG_ID_TINY_HEARTBEAT_CLIENT", 5, 5);
        h hVar = new h("MSG_ID_TINY_HEARTBEAT_SERVER", 6, 6);
        f37600g = hVar;
        f37601i = new h[]{f37594a, f37595b, f37596c, f37597d, f37598e, f37599f, hVar};
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
        this.f37602h = (short) i3;
    }

    public static h a(short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Short.valueOf(s)})) == null) {
            switch (s) {
                case 1:
                    return f37595b;
                case 2:
                    return f37596c;
                case 3:
                    return f37598e;
                case 4:
                    return f37597d;
                case 5:
                    return f37599f;
                case 6:
                    return f37600g;
                default:
                    return f37594a;
            }
        }
        return (h) invokeCommon.objValue;
    }

    public static h[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (h[]) f37601i.clone() : (h[]) invokeV.objValue;
    }

    public short b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f37602h : invokeV.shortValue;
    }
}
