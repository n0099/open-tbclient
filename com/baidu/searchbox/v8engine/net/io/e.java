package com.baidu.searchbox.v8engine.net.io;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f10246a;

    /* renamed from: b  reason: collision with root package name */
    public int f10247b;

    /* renamed from: c  reason: collision with root package name */
    public int f10248c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10249d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10250e;

    /* renamed from: f  reason: collision with root package name */
    public e f10251f;

    /* renamed from: g  reason: collision with root package name */
    public e f10252g;

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
        this.f10246a = new byte[8192];
        this.f10250e = true;
        this.f10249d = false;
    }

    public e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.f10249d = true;
            return new e(this.f10246a, this.f10247b, this.f10248c, true, false);
        }
        return (e) invokeV.objValue;
    }

    @Nullable
    public e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            e eVar = this.f10251f;
            if (eVar == this) {
                eVar = null;
            }
            e eVar2 = this.f10252g;
            eVar2.f10251f = this.f10251f;
            this.f10251f.f10252g = eVar2;
            this.f10251f = null;
            this.f10252g = null;
            return eVar;
        }
        return (e) invokeV.objValue;
    }

    public e a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar)) == null) {
            eVar.f10252g = this;
            eVar.f10251f = this.f10251f;
            this.f10251f.f10252g = eVar;
            this.f10251f = eVar;
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
        this.f10246a = bArr;
        this.f10247b = i2;
        this.f10248c = i3;
        this.f10249d = z;
        this.f10250e = z2;
    }
}
