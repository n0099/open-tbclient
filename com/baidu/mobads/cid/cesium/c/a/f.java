package com.baidu.mobads.cid.cesium.c.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final b f42904b;

    /* renamed from: c  reason: collision with root package name */
    public final int f42905c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f42906d;

    public f(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42904b = bVar;
        this.f42905c = bVar.a();
    }

    public abstract void a();

    public abstract void a(boolean z, String str, byte[] bArr, byte[] bArr2);

    public abstract void a(byte[] bArr, int i2, int i3, byte[] bArr2, int i4);

    public abstract void b();

    public abstract void b(byte[] bArr, int i2, int i3, byte[] bArr2, int i4);

    public abstract void c();

    public void c(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), bArr2, Integer.valueOf(i4)}) == null) {
            a(bArr, i2, i3, bArr2, i4);
        }
    }

    public void d(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), bArr2, Integer.valueOf(i4)}) == null) {
            b(bArr, i2, i3, bArr2, i4);
        }
    }
}
