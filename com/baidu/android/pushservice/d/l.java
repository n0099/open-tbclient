package com.baidu.android.pushservice.d;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f3071a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f3072b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f3073c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f3074d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f3075e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f3076f;

        /* renamed from: g  reason: collision with root package name */
        public static final a f3077g;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ a[] f3078i;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public int f3079h;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2103704225, "Lcom/baidu/android/pushservice/d/l$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2103704225, "Lcom/baidu/android/pushservice/d/l$a;");
                    return;
                }
            }
            f3071a = new a("MODEL_O", 0, 1);
            f3072b = new a("MODEL_C", 1, 2);
            f3073c = new a("MODEL_HW", 2, 3);
            f3074d = new a("MODEL_XM", 3, 4);
            f3075e = new a("MODEL_MZ", 4, 5);
            f3076f = new a("MODEL_OP", 5, 6);
            a aVar = new a("MODEL_VI", 6, 7);
            f3077g = aVar;
            f3078i = new a[]{f3071a, f3072b, f3073c, f3074d, f3075e, f3076f, aVar};
        }

        public a(String str, int i2, int i3) {
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
            this.f3079h = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.f3079h : invokeV.intValue;
        }
    }

    public static int a(Context context) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            int a2 = a.f3071a.a();
            int b2 = com.baidu.android.pushservice.b.d.a(context).b();
            if (com.baidu.android.pushservice.b.d.l(context)) {
                aVar = a.f3073c;
            } else if (com.baidu.android.pushservice.b.d.k(context)) {
                aVar = a.f3074d;
            } else if (com.baidu.android.pushservice.b.d.m(context)) {
                aVar = a.f3076f;
            } else if (com.baidu.android.pushservice.b.d.n(context)) {
                aVar = a.f3077g;
            } else if (com.baidu.android.pushservice.b.d.j(context)) {
                aVar = a.f3075e;
            } else if (b2 != 2 && b2 != 4 && b2 != 3) {
                return a2;
            } else {
                aVar = a.f3072b;
            }
            return aVar.a();
        }
        return invokeL.intValue;
    }
}
