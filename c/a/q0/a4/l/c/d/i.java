package c.a.q0.a4.l.c.d;

import android.graphics.Bitmap;
import android.text.TextUtils;
import c.a.q0.a4.l.c.d.e;
import c.a.q0.a4.l.c.d.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.core.ImageLoader;
import java.io.File;
import java.util.List;
import java.util.Vector;
/* loaded from: classes3.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile i f15827c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public g f15828a;

    /* renamed from: b  reason: collision with root package name */
    public List<n> f15829b;

    /* loaded from: classes3.dex */
    public class a implements m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f15830a;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15830a = iVar;
        }

        @Override // c.a.q0.a4.l.c.d.m
        public void a(e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                e.a().c(bVar);
                if (c.a.w0.t.h.e(this.f15830a.f15829b)) {
                    return;
                }
                i iVar = this.f15830a;
                iVar.h((n) c.a.w0.t.h.c(iVar.f15829b, 0));
                c.a.w0.t.h.g(this.f15830a.f15829b, 0);
            }
        }
    }

    public i() {
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
        this.f15829b = new Vector();
        this.f15828a = new g.b().d();
    }

    public static i f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f15827c == null) {
                synchronized (i.class) {
                    if (f15827c == null) {
                        f15827c = new i();
                    }
                }
            }
            return f15827c;
        }
        return (i) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f15828a == null) {
            throw new IllegalStateException(ImageLoader.ERROR_NOT_INIT);
        }
    }

    public Bitmap d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Bitmap a2 = g().a(str);
            if (a2 == null || a2.isRecycled()) {
                Bitmap a3 = e().a(str);
                if (a3 == null || a3.isRecycled()) {
                    return null;
                }
                return a3;
            }
            return a2;
        }
        return (Bitmap) invokeL.objValue;
    }

    public b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c();
            String str = FileHelper.getVideoTmpDir() + File.separator + "shaft_images";
            if (!TextUtils.equals(this.f15828a.f15810c.b(), str)) {
                this.f15828a.f15810c.d(str);
            }
            return this.f15828a.f15810c;
        }
        return (b) invokeV.objValue;
    }

    public l g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c();
            return this.f15828a.f15809b;
        }
        return (l) invokeV.objValue;
    }

    public final void h(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, nVar) == null) {
            c();
            e.b b2 = e.a().b();
            if (b2 != null) {
                b2.t(this.f15828a.f15808a);
                b2.setDataSource(nVar.f15835a);
                b2.o(nVar, new a(this));
                return;
            }
            this.f15829b.add(nVar);
        }
    }

    public void i(o oVar, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, oVar, fVar) == null) {
            List<n> c2 = k.c(oVar, fVar);
            if (c.a.w0.t.h.e(c2)) {
                return;
            }
            for (n nVar : c2) {
                h(nVar);
            }
        }
    }

    public void j(p pVar, f fVar) {
        n b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, pVar, fVar) == null) || (b2 = k.b(pVar, fVar)) == null) {
            return;
        }
        h(b2);
    }
}
