package com.baidu.searchbox.v8engine.net.io;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f42854a;

    /* renamed from: b  reason: collision with root package name */
    public int f42855b;

    /* renamed from: c  reason: collision with root package name */
    public int f42856c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42857d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f42858e;

    /* renamed from: f  reason: collision with root package name */
    public e f42859f;

    /* renamed from: g  reason: collision with root package name */
    public e f42860g;

    public e() {
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
        this.f42854a = new byte[8192];
        this.f42858e = true;
        this.f42857d = false;
    }

    public e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.f42857d = true;
            return new e(this.f42854a, this.f42855b, this.f42856c, true, false);
        }
        return (e) invokeV.objValue;
    }

    @Nullable
    public e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            e eVar = this.f42859f;
            if (eVar == this) {
                eVar = null;
            }
            e eVar2 = this.f42860g;
            eVar2.f42859f = this.f42859f;
            this.f42859f.f42860g = eVar2;
            this.f42859f = null;
            this.f42860g = null;
            return eVar;
        }
        return (e) invokeV.objValue;
    }

    public e a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar)) == null) {
            eVar.f42860g = this;
            eVar.f42859f = this.f42859f;
            this.f42859f.f42860g = eVar;
            this.f42859f = eVar;
            return eVar;
        }
        return (e) invokeL.objValue;
    }

    public e(byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f42854a = bArr;
        this.f42855b = i2;
        this.f42856c = i3;
        this.f42857d = z;
        this.f42858e = z2;
    }
}
