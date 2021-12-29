package c.i.b.a.h0;

import android.content.Context;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.util.UriUtil;
import com.google.android.exoplayer2.upstream.AssetDataSource;
import com.google.android.exoplayer2.upstream.ContentDataSource;
import com.google.android.exoplayer2.upstream.FileDataSource;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes9.dex */
public final class j implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public final p<? super e> f30613b;

    /* renamed from: c  reason: collision with root package name */
    public final e f30614c;

    /* renamed from: d  reason: collision with root package name */
    public e f30615d;

    /* renamed from: e  reason: collision with root package name */
    public e f30616e;

    /* renamed from: f  reason: collision with root package name */
    public e f30617f;

    /* renamed from: g  reason: collision with root package name */
    public e f30618g;

    /* renamed from: h  reason: collision with root package name */
    public e f30619h;

    /* renamed from: i  reason: collision with root package name */
    public e f30620i;

    public j(Context context, p<? super e> pVar, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, pVar, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context.getApplicationContext();
        this.f30613b = pVar;
        c.i.b.a.i0.a.e(eVar);
        this.f30614c = eVar;
    }

    @Override // c.i.b.a.h0.e
    public long a(g gVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            c.i.b.a.i0.a.f(this.f30620i == null);
            String scheme = gVar.a.getScheme();
            if (v.A(gVar.a)) {
                if (gVar.a.getPath().startsWith("/android_asset/")) {
                    this.f30620i = b();
                } else {
                    this.f30620i = e();
                }
            } else if (UriUtil.LOCAL_ASSET_SCHEME.equals(scheme)) {
                this.f30620i = b();
            } else if ("content".equals(scheme)) {
                this.f30620i = c();
            } else if ("rtmp".equals(scheme)) {
                this.f30620i = f();
            } else if ("data".equals(scheme)) {
                this.f30620i = d();
            } else {
                this.f30620i = this.f30614c;
            }
            return this.f30620i.a(gVar);
        }
        return invokeL.longValue;
    }

    public final e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f30616e == null) {
                this.f30616e = new AssetDataSource(this.a, this.f30613b);
            }
            return this.f30616e;
        }
        return (e) invokeV.objValue;
    }

    public final e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f30617f == null) {
                this.f30617f = new ContentDataSource(this.a, this.f30613b);
            }
            return this.f30617f;
        }
        return (e) invokeV.objValue;
    }

    @Override // c.i.b.a.h0.e
    public void close() throws IOException {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (eVar = this.f30620i) == null) {
            return;
        }
        try {
            eVar.close();
        } finally {
            this.f30620i = null;
        }
    }

    public final e d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f30619h == null) {
                this.f30619h = new d();
            }
            return this.f30619h;
        }
        return (e) invokeV.objValue;
    }

    public final e e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f30615d == null) {
                this.f30615d = new FileDataSource(this.f30613b);
            }
            return this.f30615d;
        }
        return (e) invokeV.objValue;
    }

    public final e f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f30618g == null) {
                try {
                    this.f30618g = (e) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
                }
                if (this.f30618g == null) {
                    this.f30618g = this.f30614c;
                }
            }
            return this.f30618g;
        }
        return (e) invokeV.objValue;
    }

    @Override // c.i.b.a.h0.e
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            e eVar = this.f30620i;
            if (eVar == null) {
                return null;
            }
            return eVar.getUri();
        }
        return (Uri) invokeV.objValue;
    }

    @Override // c.i.b.a.h0.e
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr, i2, i3)) == null) ? this.f30620i.read(bArr, i2, i3) : invokeLII.intValue;
    }
}
