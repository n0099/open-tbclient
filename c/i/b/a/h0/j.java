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
    public final p<? super e> f29681b;

    /* renamed from: c  reason: collision with root package name */
    public final e f29682c;

    /* renamed from: d  reason: collision with root package name */
    public e f29683d;

    /* renamed from: e  reason: collision with root package name */
    public e f29684e;

    /* renamed from: f  reason: collision with root package name */
    public e f29685f;

    /* renamed from: g  reason: collision with root package name */
    public e f29686g;

    /* renamed from: h  reason: collision with root package name */
    public e f29687h;

    /* renamed from: i  reason: collision with root package name */
    public e f29688i;

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
        this.f29681b = pVar;
        c.i.b.a.i0.a.e(eVar);
        this.f29682c = eVar;
    }

    @Override // c.i.b.a.h0.e
    public long a(g gVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            c.i.b.a.i0.a.f(this.f29688i == null);
            String scheme = gVar.a.getScheme();
            if (v.A(gVar.a)) {
                if (gVar.a.getPath().startsWith("/android_asset/")) {
                    this.f29688i = b();
                } else {
                    this.f29688i = e();
                }
            } else if (UriUtil.LOCAL_ASSET_SCHEME.equals(scheme)) {
                this.f29688i = b();
            } else if ("content".equals(scheme)) {
                this.f29688i = c();
            } else if ("rtmp".equals(scheme)) {
                this.f29688i = f();
            } else if ("data".equals(scheme)) {
                this.f29688i = d();
            } else {
                this.f29688i = this.f29682c;
            }
            return this.f29688i.a(gVar);
        }
        return invokeL.longValue;
    }

    public final e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f29684e == null) {
                this.f29684e = new AssetDataSource(this.a, this.f29681b);
            }
            return this.f29684e;
        }
        return (e) invokeV.objValue;
    }

    public final e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f29685f == null) {
                this.f29685f = new ContentDataSource(this.a, this.f29681b);
            }
            return this.f29685f;
        }
        return (e) invokeV.objValue;
    }

    @Override // c.i.b.a.h0.e
    public void close() throws IOException {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (eVar = this.f29688i) == null) {
            return;
        }
        try {
            eVar.close();
        } finally {
            this.f29688i = null;
        }
    }

    public final e d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f29687h == null) {
                this.f29687h = new d();
            }
            return this.f29687h;
        }
        return (e) invokeV.objValue;
    }

    public final e e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f29683d == null) {
                this.f29683d = new FileDataSource(this.f29681b);
            }
            return this.f29683d;
        }
        return (e) invokeV.objValue;
    }

    public final e f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f29686g == null) {
                try {
                    this.f29686g = (e) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
                }
                if (this.f29686g == null) {
                    this.f29686g = this.f29682c;
                }
            }
            return this.f29686g;
        }
        return (e) invokeV.objValue;
    }

    @Override // c.i.b.a.h0.e
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            e eVar = this.f29688i;
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
        return (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr, i2, i3)) == null) ? this.f29688i.read(bArr, i2, i3) : invokeLII.intValue;
    }
}
