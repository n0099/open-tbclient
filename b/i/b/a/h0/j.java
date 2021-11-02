package b.i.b.a.h0;

import android.content.Context;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import b.i.b.a.i0.v;
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
/* loaded from: classes6.dex */
public final class j implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f32557a;

    /* renamed from: b  reason: collision with root package name */
    public final p<? super e> f32558b;

    /* renamed from: c  reason: collision with root package name */
    public final e f32559c;

    /* renamed from: d  reason: collision with root package name */
    public e f32560d;

    /* renamed from: e  reason: collision with root package name */
    public e f32561e;

    /* renamed from: f  reason: collision with root package name */
    public e f32562f;

    /* renamed from: g  reason: collision with root package name */
    public e f32563g;

    /* renamed from: h  reason: collision with root package name */
    public e f32564h;

    /* renamed from: i  reason: collision with root package name */
    public e f32565i;

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
        this.f32557a = context.getApplicationContext();
        this.f32558b = pVar;
        b.i.b.a.i0.a.e(eVar);
        this.f32559c = eVar;
    }

    @Override // b.i.b.a.h0.e
    public long a(g gVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            b.i.b.a.i0.a.f(this.f32565i == null);
            String scheme = gVar.f32529a.getScheme();
            if (v.A(gVar.f32529a)) {
                if (gVar.f32529a.getPath().startsWith("/android_asset/")) {
                    this.f32565i = b();
                } else {
                    this.f32565i = e();
                }
            } else if (UriUtil.LOCAL_ASSET_SCHEME.equals(scheme)) {
                this.f32565i = b();
            } else if ("content".equals(scheme)) {
                this.f32565i = c();
            } else if ("rtmp".equals(scheme)) {
                this.f32565i = f();
            } else if ("data".equals(scheme)) {
                this.f32565i = d();
            } else {
                this.f32565i = this.f32559c;
            }
            return this.f32565i.a(gVar);
        }
        return invokeL.longValue;
    }

    public final e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f32561e == null) {
                this.f32561e = new AssetDataSource(this.f32557a, this.f32558b);
            }
            return this.f32561e;
        }
        return (e) invokeV.objValue;
    }

    public final e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f32562f == null) {
                this.f32562f = new ContentDataSource(this.f32557a, this.f32558b);
            }
            return this.f32562f;
        }
        return (e) invokeV.objValue;
    }

    @Override // b.i.b.a.h0.e
    public void close() throws IOException {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (eVar = this.f32565i) == null) {
            return;
        }
        try {
            eVar.close();
        } finally {
            this.f32565i = null;
        }
    }

    public final e d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f32564h == null) {
                this.f32564h = new d();
            }
            return this.f32564h;
        }
        return (e) invokeV.objValue;
    }

    public final e e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f32560d == null) {
                this.f32560d = new FileDataSource(this.f32558b);
            }
            return this.f32560d;
        }
        return (e) invokeV.objValue;
    }

    public final e f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f32563g == null) {
                try {
                    this.f32563g = (e) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
                }
                if (this.f32563g == null) {
                    this.f32563g = this.f32559c;
                }
            }
            return this.f32563g;
        }
        return (e) invokeV.objValue;
    }

    @Override // b.i.b.a.h0.e
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            e eVar = this.f32565i;
            if (eVar == null) {
                return null;
            }
            return eVar.getUri();
        }
        return (Uri) invokeV.objValue;
    }

    @Override // b.i.b.a.h0.e
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr, i2, i3)) == null) ? this.f32565i.read(bArr, i2, i3) : invokeLII.intValue;
    }
}
