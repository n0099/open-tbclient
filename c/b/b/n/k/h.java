package c.b.b.n.k;

import androidx.core.view.InputDeviceCompat;
import c.b.b.q.a;
import c.b.b.q.i0;
import c.b.b.q.w;
import c.b.b.q.x;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.request.CloudControlRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.SevenZipUtils;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
/* loaded from: classes9.dex */
public class h implements c.b.b.q.h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final x<Texture> f27919e;

    /* renamed from: f  reason: collision with root package name */
    public final c.b.b.q.a<a> f27920f;

    /* loaded from: classes9.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c.b.b.q.a<p> a;

        /* renamed from: b  reason: collision with root package name */
        public final c.b.b.q.a<q> f27925b;

        /* loaded from: classes9.dex */
        public class a implements o<q> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String[] a;

            public a(c cVar, String[] strArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, strArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = strArr;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.b.b.n.k.h.c.o
            /* renamed from: b */
            public void a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qVar) == null) {
                    qVar.f27944i = Integer.parseInt(this.a[1]);
                    qVar.f27945j = Integer.parseInt(this.a[2]);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b implements o<q> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String[] a;

            public b(c cVar, String[] strArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, strArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = strArr;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.b.b.n.k.h.c.o
            /* renamed from: b */
            public void a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qVar) == null) {
                    qVar.f27942g = Integer.parseInt(this.a[1]);
                    qVar.f27943h = Integer.parseInt(this.a[2]);
                    qVar.f27944i = Integer.parseInt(this.a[3]);
                    qVar.f27945j = Integer.parseInt(this.a[4]);
                }
            }
        }

        /* renamed from: c.b.b.n.k.h$c$c  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1595c implements o<q> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String[] a;

            public C1595c(c cVar, String[] strArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, strArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = strArr;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.b.b.n.k.h.c.o
            /* renamed from: b */
            public void a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qVar) == null) {
                    String str = this.a[1];
                    if (str.equals("true")) {
                        qVar.f27946k = 90;
                    } else if (!str.equals("false")) {
                        qVar.f27946k = Integer.parseInt(str);
                    }
                    qVar.l = qVar.f27946k == 90;
                }
            }
        }

        /* loaded from: classes9.dex */
        public class d implements o<q> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String[] a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean[] f27926b;

            public d(c cVar, String[] strArr, boolean[] zArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, strArr, zArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = strArr;
                this.f27926b = zArr;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.b.b.n.k.h.c.o
            /* renamed from: b */
            public void a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qVar) == null) {
                    int parseInt = Integer.parseInt(this.a[1]);
                    qVar.m = parseInt;
                    if (parseInt != -1) {
                        this.f27926b[0] = true;
                    }
                }
            }
        }

        /* loaded from: classes9.dex */
        public class e implements Comparator<q> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public e(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(q qVar, q qVar2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, qVar, qVar2)) == null) {
                    int i2 = qVar.m;
                    if (i2 == -1) {
                        i2 = Integer.MAX_VALUE;
                    }
                    int i3 = qVar2.m;
                    return i2 - (i3 != -1 ? i3 : Integer.MAX_VALUE);
                }
                return invokeLL.intValue;
            }
        }

        /* loaded from: classes9.dex */
        public class f implements o<p> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String[] a;

            public f(c cVar, String[] strArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, strArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = strArr;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.b.b.n.k.h.c.o
            /* renamed from: b */
            public void a(p pVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar) == null) {
                    pVar.f27928c = Integer.parseInt(this.a[1]);
                    pVar.f27929d = Integer.parseInt(this.a[2]);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class g implements o<p> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String[] a;

            public g(c cVar, String[] strArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, strArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = strArr;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.b.b.n.k.h.c.o
            /* renamed from: b */
            public void a(p pVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar) == null) {
                    pVar.f27931f = Pixmap.Format.valueOf(this.a[1]);
                }
            }
        }

        /* renamed from: c.b.b.n.k.h$c$h  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1596h implements o<p> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String[] a;

            public C1596h(c cVar, String[] strArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, strArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = strArr;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.b.b.n.k.h.c.o
            /* renamed from: b */
            public void a(p pVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar) == null) {
                    pVar.f27932g = Texture.TextureFilter.valueOf(this.a[1]);
                    pVar.f27933h = Texture.TextureFilter.valueOf(this.a[2]);
                    pVar.f27930e = pVar.f27932g.isMipMap();
                }
            }
        }

        /* loaded from: classes9.dex */
        public class i implements o<p> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String[] a;

            public i(c cVar, String[] strArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, strArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = strArr;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.b.b.n.k.h.c.o
            /* renamed from: b */
            public void a(p pVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar) == null) {
                    if (this.a[1].indexOf(120) != -1) {
                        pVar.f27934i = Texture.TextureWrap.Repeat;
                    }
                    if (this.a[1].indexOf(121) != -1) {
                        pVar.f27935j = Texture.TextureWrap.Repeat;
                    }
                }
            }
        }

        /* loaded from: classes9.dex */
        public class j implements o<p> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String[] a;

            public j(c cVar, String[] strArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, strArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = strArr;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.b.b.n.k.h.c.o
            /* renamed from: b */
            public void a(p pVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar) == null) {
                    pVar.f27936k = this.a[1].equals("true");
                }
            }
        }

        /* loaded from: classes9.dex */
        public class k implements o<q> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String[] a;

            public k(c cVar, String[] strArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, strArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = strArr;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.b.b.n.k.h.c.o
            /* renamed from: b */
            public void a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qVar) == null) {
                    qVar.f27938c = Integer.parseInt(this.a[1]);
                    qVar.f27939d = Integer.parseInt(this.a[2]);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class l implements o<q> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String[] a;

            public l(c cVar, String[] strArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, strArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = strArr;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.b.b.n.k.h.c.o
            /* renamed from: b */
            public void a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qVar) == null) {
                    qVar.f27940e = Integer.parseInt(this.a[1]);
                    qVar.f27941f = Integer.parseInt(this.a[2]);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class m implements o<q> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String[] a;

            public m(c cVar, String[] strArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, strArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = strArr;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.b.b.n.k.h.c.o
            /* renamed from: b */
            public void a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qVar) == null) {
                    qVar.f27938c = Integer.parseInt(this.a[1]);
                    qVar.f27939d = Integer.parseInt(this.a[2]);
                    qVar.f27940e = Integer.parseInt(this.a[3]);
                    qVar.f27941f = Integer.parseInt(this.a[4]);
                }
            }
        }

        /* loaded from: classes9.dex */
        public class n implements o<q> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String[] a;

            public n(c cVar, String[] strArr) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, strArr};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = strArr;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.b.b.n.k.h.c.o
            /* renamed from: b */
            public void a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qVar) == null) {
                    qVar.f27942g = Integer.parseInt(this.a[1]);
                    qVar.f27943h = Integer.parseInt(this.a[2]);
                }
            }
        }

        /* loaded from: classes9.dex */
        public interface o<T> {
            void a(T t);
        }

        /* loaded from: classes9.dex */
        public static class p {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public c.b.b.m.a a;

            /* renamed from: b  reason: collision with root package name */
            public Texture f27927b;

            /* renamed from: c  reason: collision with root package name */
            public float f27928c;

            /* renamed from: d  reason: collision with root package name */
            public float f27929d;

            /* renamed from: e  reason: collision with root package name */
            public boolean f27930e;

            /* renamed from: f  reason: collision with root package name */
            public Pixmap.Format f27931f;

            /* renamed from: g  reason: collision with root package name */
            public Texture.TextureFilter f27932g;

            /* renamed from: h  reason: collision with root package name */
            public Texture.TextureFilter f27933h;

            /* renamed from: i  reason: collision with root package name */
            public Texture.TextureWrap f27934i;

            /* renamed from: j  reason: collision with root package name */
            public Texture.TextureWrap f27935j;

            /* renamed from: k  reason: collision with root package name */
            public boolean f27936k;

            public p() {
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
                this.f27931f = Pixmap.Format.RGBA8888;
                Texture.TextureFilter textureFilter = Texture.TextureFilter.Nearest;
                this.f27932g = textureFilter;
                this.f27933h = textureFilter;
                Texture.TextureWrap textureWrap = Texture.TextureWrap.ClampToEdge;
                this.f27934i = textureWrap;
                this.f27935j = textureWrap;
            }
        }

        /* loaded from: classes9.dex */
        public static class q {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public p a;

            /* renamed from: b  reason: collision with root package name */
            public String f27937b;

            /* renamed from: c  reason: collision with root package name */
            public int f27938c;

            /* renamed from: d  reason: collision with root package name */
            public int f27939d;

            /* renamed from: e  reason: collision with root package name */
            public int f27940e;

            /* renamed from: f  reason: collision with root package name */
            public int f27941f;

            /* renamed from: g  reason: collision with root package name */
            public float f27942g;

            /* renamed from: h  reason: collision with root package name */
            public float f27943h;

            /* renamed from: i  reason: collision with root package name */
            public int f27944i;

            /* renamed from: j  reason: collision with root package name */
            public int f27945j;

            /* renamed from: k  reason: collision with root package name */
            public int f27946k;
            public boolean l;
            public int m;
            public String[] n;
            public int[][] o;
            public boolean p;

            public q() {
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
                this.m = -1;
            }
        }

        public c(c.b.b.m.a aVar, c.b.b.m.a aVar2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new c.b.b.q.a<>();
            this.f27925b = new c.b.b.q.a<>();
            b(aVar, aVar2, z);
        }

        public static int c(String[] strArr, String str) throws IOException {
            InterceptResult invokeLL;
            int indexOf;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLL = interceptable.invokeLL(65537, null, strArr, str)) != null) {
                return invokeLL.intValue;
            }
            if (str == null) {
                return 0;
            }
            String trim = str.trim();
            if (trim.length() == 0 || (indexOf = trim.indexOf(58)) == -1) {
                return 0;
            }
            strArr[0] = trim.substring(0, indexOf).trim();
            int i2 = 1;
            int i3 = indexOf + 1;
            while (true) {
                int indexOf2 = trim.indexOf(44, i3);
                if (indexOf2 == -1) {
                    strArr[i2] = trim.substring(i3).trim();
                    return i2;
                }
                strArr[i2] = trim.substring(i3, indexOf2).trim();
                i3 = indexOf2 + 1;
                if (i2 == 4) {
                    return 4;
                }
                i2++;
            }
        }

        public c.b.b.q.a<p> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (c.b.b.q.a) invokeV.objValue;
        }

        public void b(c.b.b.m.a aVar, c.b.b.m.a aVar2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, aVar2, z) == null) {
                String[] strArr = new String[5];
                w wVar = new w(15, 0.99f);
                wVar.i("size", new f(this, strArr));
                wVar.i("format", new g(this, strArr));
                wVar.i(CloudControlRequest.REQUEST_KEY_FILTER, new C1596h(this, strArr));
                wVar.i("repeat", new i(this, strArr));
                wVar.i("pma", new j(this, strArr));
                boolean z2 = true;
                boolean[] zArr = {false};
                w wVar2 = new w(127, 0.99f);
                wVar2.i("xy", new k(this, strArr));
                wVar2.i("size", new l(this, strArr));
                wVar2.i(AnimationProperty.BOUNDS, new m(this, strArr));
                wVar2.i("offset", new n(this, strArr));
                wVar2.i("orig", new a(this, strArr));
                wVar2.i(SevenZipUtils.LZMA_META_KEY_OFFSET, new b(this, strArr));
                wVar2.i(AnimationProperty.ROTATE, new C1595c(this, strArr));
                wVar2.i("index", new d(this, strArr, zArr));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(aVar.m()), 1024);
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        while (readLine != null && readLine.trim().length() == 0) {
                            readLine = bufferedReader.readLine();
                        }
                        while (readLine != null && readLine.trim().length() != 0 && c(strArr, readLine) != 0) {
                            readLine = bufferedReader.readLine();
                        }
                        p pVar = null;
                        c.b.b.q.a aVar3 = null;
                        c.b.b.q.a aVar4 = null;
                        while (readLine != null) {
                            if (readLine.trim().length() == 0) {
                                readLine = bufferedReader.readLine();
                                pVar = null;
                            } else if (pVar == null) {
                                pVar = new p();
                                pVar.a = aVar2.a(readLine);
                                while (true) {
                                    readLine = bufferedReader.readLine();
                                    if (c(strArr, readLine) == 0) {
                                        break;
                                    }
                                    o oVar = (o) wVar.c(strArr[0]);
                                    if (oVar != null) {
                                        oVar.a(pVar);
                                    }
                                }
                                this.a.a(pVar);
                            } else {
                                q qVar = new q();
                                qVar.a = pVar;
                                qVar.f27937b = readLine.trim();
                                if (z) {
                                    qVar.p = z2;
                                }
                                while (true) {
                                    readLine = bufferedReader.readLine();
                                    int c2 = c(strArr, readLine);
                                    if (c2 == 0) {
                                        break;
                                    }
                                    o oVar2 = (o) wVar2.c(strArr[0]);
                                    if (oVar2 != null) {
                                        oVar2.a(qVar);
                                    } else {
                                        if (aVar3 == null) {
                                            aVar3 = new c.b.b.q.a(8);
                                            aVar4 = new c.b.b.q.a(8);
                                        }
                                        aVar3.a(strArr[0]);
                                        int[] iArr = new int[c2];
                                        int i2 = 0;
                                        while (i2 < c2) {
                                            int i3 = i2 + 1;
                                            try {
                                                iArr[i2] = Integer.parseInt(strArr[i3]);
                                            } catch (NumberFormatException unused) {
                                            }
                                            i2 = i3;
                                        }
                                        aVar4.a(iArr);
                                    }
                                    z2 = true;
                                }
                                if (qVar.f27944i == 0 && qVar.f27945j == 0) {
                                    qVar.f27944i = qVar.f27940e;
                                    qVar.f27945j = qVar.f27941f;
                                }
                                if (aVar3 != null && aVar3.f28143f > 0) {
                                    qVar.n = (String[]) aVar3.m(String.class);
                                    qVar.o = (int[][]) aVar4.m(int[].class);
                                    aVar3.clear();
                                    aVar4.clear();
                                }
                                this.f27925b.a(qVar);
                            }
                        }
                        i0.a(bufferedReader);
                        if (zArr[0]) {
                            this.f27925b.sort(new e(this));
                        }
                    } catch (Throwable th) {
                        i0.a(bufferedReader);
                        throw th;
                    }
                } catch (Exception e2) {
                    throw new GdxRuntimeException("Error reading texture atlas file: " + aVar, e2);
                }
            }
        }
    }

    public h() {
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
        this.f27919e = new x<>(4);
        this.f27920f = new c.b.b.q.a<>();
    }

    public g a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            int i2 = this.f27920f.f28143f;
            for (int i3 = 0; i3 < i2; i3++) {
                if (this.f27920f.get(i3).f27922i.equals(str)) {
                    return i(this.f27920f.get(i3));
                }
            }
            return null;
        }
        return (g) invokeL.objValue;
    }

    @Override // c.b.b.q.h
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            x.a<Texture> it = this.f27919e.iterator();
            while (it.hasNext()) {
                it.next().dispose();
            }
            this.f27919e.b(0);
        }
    }

    public a f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            int i2 = this.f27920f.f28143f;
            for (int i3 = 0; i3 < i2; i3++) {
                if (this.f27920f.get(i3).f27922i.equals(str)) {
                    return this.f27920f.get(i3);
                }
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    public c.b.b.q.a<a> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f27920f : (c.b.b.q.a) invokeV.objValue;
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f27919e.c(cVar.a.f28143f);
            a.b<c.p> it = cVar.a.iterator();
            while (it.hasNext()) {
                c.p next = it.next();
                if (next.f27927b == null) {
                    next.f27927b = new Texture(next.a, next.f27931f, next.f27930e);
                }
                next.f27927b.l(next.f27932g, next.f27933h);
                next.f27927b.m(next.f27934i, next.f27935j);
                this.f27919e.add(next.f27927b);
            }
            this.f27920f.e(cVar.f27925b.f28143f);
            a.b<c.q> it2 = cVar.f27925b.iterator();
            while (it2.hasNext()) {
                c.q next2 = it2.next();
                a aVar = new a(next2.a.f27927b, next2.f27938c, next2.f27939d, next2.l ? next2.f27941f : next2.f27940e, next2.l ? next2.f27940e : next2.f27941f);
                aVar.f27921h = next2.m;
                aVar.f27922i = next2.f27937b;
                aVar.f27923j = next2.f27942g;
                aVar.f27924k = next2.f27943h;
                aVar.o = next2.f27945j;
                aVar.n = next2.f27944i;
                aVar.p = next2.l;
                aVar.q = next2.f27946k;
                aVar.r = next2.n;
                aVar.s = next2.o;
                if (next2.p) {
                    aVar.a(false, true);
                }
                this.f27920f.a(aVar);
            }
        }
    }

    public final g i(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            if (aVar.l == aVar.n && aVar.m == aVar.o) {
                if (aVar.p) {
                    g gVar = new g(aVar);
                    gVar.s(0.0f, 0.0f, aVar.b(), aVar.c());
                    gVar.q(true);
                    return gVar;
                }
                return new g(aVar);
            }
            return new b(aVar);
        }
        return (g) invokeL.objValue;
    }

    public h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27919e = new x<>(4);
        this.f27920f = new c.b.b.q.a<>();
        h(cVar);
    }

    /* loaded from: classes9.dex */
    public static class a extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public int f27921h;

        /* renamed from: i  reason: collision with root package name */
        public String f27922i;

        /* renamed from: j  reason: collision with root package name */
        public float f27923j;

        /* renamed from: k  reason: collision with root package name */
        public float f27924k;
        public int l;
        public int m;
        public int n;
        public int o;
        public boolean p;
        public int q;
        public String[] r;
        public int[][] s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Texture texture, int i2, int i3, int i4, int i5) {
            super(texture, i2, i3, i4, i5);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {texture, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Texture) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f27921h = -1;
            this.n = i4;
            this.o = i5;
            this.l = i4;
            this.m = i5;
        }

        @Override // c.b.b.n.k.i
        public void a(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                super.a(z, z2);
                if (z) {
                    this.f27923j = (this.n - this.f27923j) - m();
                }
                if (z2) {
                    this.f27924k = (this.o - this.f27924k) - l();
                }
            }
        }

        public int[] k(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                String[] strArr = this.r;
                if (strArr != null) {
                    int length = strArr.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (str.equals(this.r[i2])) {
                            return this.s[i2];
                        }
                    }
                    return null;
                }
                return null;
            }
            return (int[]) invokeL.objValue;
        }

        public float l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.p ? this.l : this.m;
            }
            return invokeV.floatValue;
        }

        public float m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.p ? this.m : this.l;
            }
            return invokeV.floatValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f27922i : (String) invokeV.objValue;
        }

        public a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27921h = -1;
            i(aVar);
            this.f27921h = aVar.f27921h;
            this.f27922i = aVar.f27922i;
            this.f27923j = aVar.f27923j;
            this.f27924k = aVar.f27924k;
            this.l = aVar.l;
            this.m = aVar.m;
            this.n = aVar.n;
            this.o = aVar.o;
            this.p = aVar.p;
            this.q = aVar.q;
            this.r = aVar.r;
            this.s = aVar.s;
        }
    }

    /* loaded from: classes9.dex */
    public static class b extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final a t;
        public float u;
        public float v;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.t = new a(aVar);
            this.u = aVar.f27923j;
            this.v = aVar.f27924k;
            i(aVar);
            v(aVar.n / 2.0f, aVar.o / 2.0f);
            int c2 = aVar.c();
            int b2 = aVar.b();
            if (aVar.p) {
                super.q(true);
                super.s(aVar.f27923j, aVar.f27924k, b2, c2);
            } else {
                super.s(aVar.f27923j, aVar.f27924k, c2, b2);
            }
            t(1.0f, 1.0f, 1.0f, 1.0f);
        }

        public float B() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? super.k() / this.t.l() : invokeV.floatValue;
        }

        public float C() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? super.n() / this.t.m() : invokeV.floatValue;
        }

        @Override // c.b.b.n.k.g, c.b.b.n.k.i
        public void a(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                if (this.t.p) {
                    super.a(z2, z);
                } else {
                    super.a(z, z2);
                }
                float l = l();
                float m = m();
                a aVar = this.t;
                float f2 = aVar.f27923j;
                float f3 = aVar.f27924k;
                float C = C();
                float B = B();
                a aVar2 = this.t;
                aVar2.f27923j = this.u;
                aVar2.f27924k = this.v;
                aVar2.a(z, z2);
                a aVar3 = this.t;
                float f4 = aVar3.f27923j;
                this.u = f4;
                float f5 = aVar3.f27924k;
                this.v = f5;
                float f6 = f4 * C;
                aVar3.f27923j = f6;
                float f7 = f5 * B;
                aVar3.f27924k = f7;
                A(f6 - f2, f7 - f3);
                v(l, m);
            }
        }

        @Override // c.b.b.n.k.g
        public float k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (super.k() / this.t.l()) * this.t.o : invokeV.floatValue;
        }

        @Override // c.b.b.n.k.g
        public float l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? super.l() + this.t.f27923j : invokeV.floatValue;
        }

        @Override // c.b.b.n.k.g
        public float m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? super.m() + this.t.f27924k : invokeV.floatValue;
        }

        @Override // c.b.b.n.k.g
        public float n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (super.n() / this.t.m()) * this.t.n : invokeV.floatValue;
        }

        @Override // c.b.b.n.k.g
        public float o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? super.o() - this.t.f27923j : invokeV.floatValue;
        }

        @Override // c.b.b.n.k.g
        public float p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? super.p() - this.t.f27924k : invokeV.floatValue;
        }

        @Override // c.b.b.n.k.g
        public void q(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
                super.q(z);
                float l = l();
                float m = m();
                a aVar = this.t;
                float f2 = aVar.f27923j;
                float f3 = aVar.f27924k;
                float C = C();
                float B = B();
                if (z) {
                    a aVar2 = this.t;
                    aVar2.f27923j = f3;
                    aVar2.f27924k = ((aVar2.o * B) - f2) - (aVar2.l * C);
                } else {
                    a aVar3 = this.t;
                    aVar3.f27923j = ((aVar3.n * C) - f3) - (aVar3.m * B);
                    aVar3.f27924k = f2;
                }
                a aVar4 = this.t;
                A(aVar4.f27923j - f2, aVar4.f27924k - f3);
                v(l, m);
            }
        }

        @Override // c.b.b.n.k.g
        public void s(float f2, float f3, float f4, float f5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
                a aVar = this.t;
                float f6 = f4 / aVar.n;
                float f7 = f5 / aVar.o;
                aVar.f27923j = this.u * f6;
                aVar.f27924k = this.v * f7;
                int i2 = aVar.p ? aVar.m : aVar.l;
                a aVar2 = this.t;
                int i3 = aVar2.p ? aVar2.l : aVar2.m;
                a aVar3 = this.t;
                super.s(f2 + aVar3.f27923j, f3 + aVar3.f27924k, i2 * f6, i3 * f7);
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.t.toString() : (String) invokeV.objValue;
        }

        @Override // c.b.b.n.k.g
        public void v(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                a aVar = this.t;
                super.v(f2 - aVar.f27923j, f3 - aVar.f27924k);
            }
        }

        @Override // c.b.b.n.k.g
        public void z(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                s(o(), p(), f2, f3);
            }
        }

        public b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.t = bVar.t;
            this.u = bVar.u;
            this.v = bVar.v;
            r(bVar);
        }
    }
}
