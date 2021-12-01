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
/* loaded from: classes7.dex */
public final class j implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public final p<? super e> f30165b;

    /* renamed from: c  reason: collision with root package name */
    public final e f30166c;

    /* renamed from: d  reason: collision with root package name */
    public e f30167d;

    /* renamed from: e  reason: collision with root package name */
    public e f30168e;

    /* renamed from: f  reason: collision with root package name */
    public e f30169f;

    /* renamed from: g  reason: collision with root package name */
    public e f30170g;

    /* renamed from: h  reason: collision with root package name */
    public e f30171h;

    /* renamed from: i  reason: collision with root package name */
    public e f30172i;

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
        this.f30165b = pVar;
        c.i.b.a.i0.a.e(eVar);
        this.f30166c = eVar;
    }

    @Override // c.i.b.a.h0.e
    public long a(g gVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            c.i.b.a.i0.a.f(this.f30172i == null);
            String scheme = gVar.a.getScheme();
            if (v.A(gVar.a)) {
                if (gVar.a.getPath().startsWith("/android_asset/")) {
                    this.f30172i = b();
                } else {
                    this.f30172i = e();
                }
            } else if (UriUtil.LOCAL_ASSET_SCHEME.equals(scheme)) {
                this.f30172i = b();
            } else if ("content".equals(scheme)) {
                this.f30172i = c();
            } else if ("rtmp".equals(scheme)) {
                this.f30172i = f();
            } else if ("data".equals(scheme)) {
                this.f30172i = d();
            } else {
                this.f30172i = this.f30166c;
            }
            return this.f30172i.a(gVar);
        }
        return invokeL.longValue;
    }

    public final e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f30168e == null) {
                this.f30168e = new AssetDataSource(this.a, this.f30165b);
            }
            return this.f30168e;
        }
        return (e) invokeV.objValue;
    }

    public final e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f30169f == null) {
                this.f30169f = new ContentDataSource(this.a, this.f30165b);
            }
            return this.f30169f;
        }
        return (e) invokeV.objValue;
    }

    @Override // c.i.b.a.h0.e
    public void close() throws IOException {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (eVar = this.f30172i) == null) {
            return;
        }
        try {
            eVar.close();
        } finally {
            this.f30172i = null;
        }
    }

    public final e d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f30171h == null) {
                this.f30171h = new d();
            }
            return this.f30171h;
        }
        return (e) invokeV.objValue;
    }

    public final e e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f30167d == null) {
                this.f30167d = new FileDataSource(this.f30165b);
            }
            return this.f30167d;
        }
        return (e) invokeV.objValue;
    }

    public final e f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f30170g == null) {
                try {
                    this.f30170g = (e) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
                }
                if (this.f30170g == null) {
                    this.f30170g = this.f30166c;
                }
            }
            return this.f30170g;
        }
        return (e) invokeV.objValue;
    }

    @Override // c.i.b.a.h0.e
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            e eVar = this.f30172i;
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
        return (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr, i2, i3)) == null) ? this.f30172i.read(bArr, i2, i3) : invokeLII.intValue;
    }
}
