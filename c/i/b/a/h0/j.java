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
/* loaded from: classes4.dex */
public final class j implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f33758a;

    /* renamed from: b  reason: collision with root package name */
    public final p<? super e> f33759b;

    /* renamed from: c  reason: collision with root package name */
    public final e f33760c;

    /* renamed from: d  reason: collision with root package name */
    public e f33761d;

    /* renamed from: e  reason: collision with root package name */
    public e f33762e;

    /* renamed from: f  reason: collision with root package name */
    public e f33763f;

    /* renamed from: g  reason: collision with root package name */
    public e f33764g;

    /* renamed from: h  reason: collision with root package name */
    public e f33765h;

    /* renamed from: i  reason: collision with root package name */
    public e f33766i;

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
        this.f33758a = context.getApplicationContext();
        this.f33759b = pVar;
        c.i.b.a.i0.a.e(eVar);
        this.f33760c = eVar;
    }

    @Override // c.i.b.a.h0.e
    public long a(g gVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            c.i.b.a.i0.a.f(this.f33766i == null);
            String scheme = gVar.f33729a.getScheme();
            if (v.A(gVar.f33729a)) {
                if (gVar.f33729a.getPath().startsWith("/android_asset/")) {
                    this.f33766i = b();
                } else {
                    this.f33766i = e();
                }
            } else if (UriUtil.LOCAL_ASSET_SCHEME.equals(scheme)) {
                this.f33766i = b();
            } else if ("content".equals(scheme)) {
                this.f33766i = c();
            } else if ("rtmp".equals(scheme)) {
                this.f33766i = f();
            } else if ("data".equals(scheme)) {
                this.f33766i = d();
            } else {
                this.f33766i = this.f33760c;
            }
            return this.f33766i.a(gVar);
        }
        return invokeL.longValue;
    }

    public final e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f33762e == null) {
                this.f33762e = new AssetDataSource(this.f33758a, this.f33759b);
            }
            return this.f33762e;
        }
        return (e) invokeV.objValue;
    }

    public final e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f33763f == null) {
                this.f33763f = new ContentDataSource(this.f33758a, this.f33759b);
            }
            return this.f33763f;
        }
        return (e) invokeV.objValue;
    }

    @Override // c.i.b.a.h0.e
    public void close() throws IOException {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (eVar = this.f33766i) == null) {
            return;
        }
        try {
            eVar.close();
        } finally {
            this.f33766i = null;
        }
    }

    public final e d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f33765h == null) {
                this.f33765h = new d();
            }
            return this.f33765h;
        }
        return (e) invokeV.objValue;
    }

    public final e e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f33761d == null) {
                this.f33761d = new FileDataSource(this.f33759b);
            }
            return this.f33761d;
        }
        return (e) invokeV.objValue;
    }

    public final e f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f33764g == null) {
                try {
                    this.f33764g = (e) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
                }
                if (this.f33764g == null) {
                    this.f33764g = this.f33760c;
                }
            }
            return this.f33764g;
        }
        return (e) invokeV.objValue;
    }

    @Override // c.i.b.a.h0.e
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            e eVar = this.f33766i;
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
        return (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr, i2, i3)) == null) ? this.f33766i.read(bArr, i2, i3) : invokeLII.intValue;
    }
}
