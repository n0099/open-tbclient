package com.baidu.mobads.cid.cesium.a;

import com.baidu.mobads.cid.cesium.a.e;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public final class h extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public a f8225f;

    /* renamed from: com.baidu.mobads.cid.cesium.a.h$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Class<?> f8226a;

        /* renamed from: b  reason: collision with root package name */
        public Method f8227b;

        /* renamed from: c  reason: collision with root package name */
        public Method f8228c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            a();
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long a(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, obj)) == null) {
                try {
                    return ((Long) this.f8228c.invoke(obj, new Object[0])).longValue();
                } catch (Exception unused) {
                    throw new e.a("");
                }
            }
            return invokeL.longValue;
        }

        private void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
                try {
                    this.f8226a = Class.forName(e.a(d.a()), true, Object.class.getClassLoader());
                    this.f8227b = e.a(this.f8226a, e.a(d.b()), new Class[]{byte[].class, Integer.TYPE, Integer.TYPE});
                    this.f8228c = e.a(this.f8226a, e.a(d.c()), null);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Object obj, byte[] bArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLII(65543, this, obj, bArr, i2, i3) == null) {
                try {
                    this.f8227b.invoke(obj, bArr, Integer.valueOf(i2), Integer.valueOf(i3));
                } catch (Exception unused) {
                    throw new e.a("");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? this.f8226a.newInstance() : invokeV.objValue;
        }
    }

    public h(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f8220a = 1099511627775L;
        this.f8221b = 4;
        this.f8222c = 32;
        this.f8223d = i2;
        this.f8224e = i3;
        this.f8225f = new a(null);
    }

    @Override // com.baidu.mobads.cid.cesium.a.g
    public b a(byte[] bArr, int i2, int i3) {
        long j;
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i2, i3)) == null) {
            try {
                Object b2 = this.f8225f.b();
                this.f8225f.a(b2, bArr, i2, i3);
                j = this.f8225f.a(b2);
            } catch (Exception unused) {
                j = 4294967295L;
            }
            return b.a(new long[]{j});
        }
        return (b) invokeLII.objValue;
    }
}
