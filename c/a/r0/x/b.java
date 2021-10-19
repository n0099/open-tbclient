package c.a.r0.x;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.annotation.RestrictTo;
import c.a.r0.x.a;
import c.a.r0.x.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public abstract class b<T extends b<T>> implements a.b {
    public static /* synthetic */ Interceptable $ic;
    public static final l m;
    public static final l n;
    public static final l o;
    public static final l p;
    public static final l q;
    public static final l r;
    public static final l s;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f26586a;

    /* renamed from: b  reason: collision with root package name */
    public float f26587b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26588c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f26589d;

    /* renamed from: e  reason: collision with root package name */
    public final c.a.r0.x.c f26590e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f26591f;

    /* renamed from: g  reason: collision with root package name */
    public float f26592g;

    /* renamed from: h  reason: collision with root package name */
    public float f26593h;

    /* renamed from: i  reason: collision with root package name */
    public long f26594i;

    /* renamed from: j  reason: collision with root package name */
    public float f26595j;
    public final ArrayList<j> k;
    public final ArrayList<k> l;

    /* loaded from: classes4.dex */
    public static class a extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(str, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (C1248b) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.x.c
        /* renamed from: c */
        public float a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? view.getAlpha() : invokeL.floatValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.x.c
        /* renamed from: d */
        public void b(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048579, this, view, f2) == null) {
                view.setAlpha(f2);
            }
        }
    }

    /* renamed from: c.a.r0.x.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1248b extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class c extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(str, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (C1248b) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.x.c
        /* renamed from: c */
        public float a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? view.getTranslationY() : invokeL.floatValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.x.c
        /* renamed from: d */
        public void b(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048579, this, view, f2) == null) {
                view.setTranslationY(f2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(str, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (C1248b) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.x.c
        /* renamed from: c */
        public float a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? view.getScaleX() : invokeL.floatValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.x.c
        /* renamed from: d */
        public void b(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048579, this, view, f2) == null) {
                view.setScaleX(f2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str) {
            super(str, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (C1248b) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.x.c
        /* renamed from: c */
        public float a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? view.getScaleY() : invokeL.floatValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.x.c
        /* renamed from: d */
        public void b(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048579, this, view, f2) == null) {
                view.setScaleY(f2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class f extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str) {
            super(str, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (C1248b) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.x.c
        /* renamed from: c */
        public float a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? view.getRotation() : invokeL.floatValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.x.c
        /* renamed from: d */
        public void b(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048579, this, view, f2) == null) {
                view.setRotation(f2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class g extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str) {
            super(str, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (C1248b) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.x.c
        /* renamed from: c */
        public float a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? view.getRotationX() : invokeL.floatValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.x.c
        /* renamed from: d */
        public void b(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048579, this, view, f2) == null) {
                view.setRotationX(f2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class h extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str) {
            super(str, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (C1248b) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.x.c
        /* renamed from: c */
        public float a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? view.getRotationY() : invokeL.floatValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.x.c
        /* renamed from: d */
        public void b(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048579, this, view, f2) == null) {
                view.setRotationY(f2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public float f26596a;

        /* renamed from: b  reason: collision with root package name */
        public float f26597b;

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
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface j {
        void a(b bVar, boolean z, float f2, float f3);
    }

    /* loaded from: classes4.dex */
    public interface k {
        void a(b bVar, float f2, float f3);
    }

    /* loaded from: classes4.dex */
    public static abstract class l extends c.a.r0.x.c<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ l(String str, C1248b c1248b) {
            this(str);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-634657701, "Lc/a/r0/x/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-634657701, "Lc/a/r0/x/b;");
                return;
            }
        }
        m = new c("translationY");
        n = new d("scaleX");
        o = new e("scaleY");
        p = new f("rotation");
        q = new g("rotationX");
        r = new h("rotationY");
        s = new a("alpha");
    }

    public <K> b(K k2, c.a.r0.x.c<K> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k2, cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f26586a = 0.0f;
        this.f26587b = Float.MAX_VALUE;
        this.f26588c = false;
        this.f26591f = false;
        this.f26592g = Float.MAX_VALUE;
        this.f26593h = -Float.MAX_VALUE;
        this.f26594i = 0L;
        this.k = new ArrayList<>();
        this.l = new ArrayList<>();
        this.f26589d = k2;
        this.f26590e = cVar;
        if (cVar != p && cVar != q && cVar != r) {
            if (cVar == s) {
                this.f26595j = 0.00390625f;
                return;
            } else if (cVar != n && cVar != o) {
                this.f26595j = 1.0f;
                return;
            } else {
                this.f26595j = 0.00390625f;
                return;
            }
        }
        this.f26595j = 0.1f;
    }

    public static <T> void f(ArrayList<T> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, arrayList) == null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size) == null) {
                    arrayList.remove(size);
                }
            }
        }
    }

    @Override // c.a.r0.x.a.b
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            long j3 = this.f26594i;
            if (j3 == 0) {
                this.f26594i = j2;
                g(this.f26587b);
                return false;
            }
            this.f26594i = j2;
            boolean j4 = j(j2 - j3);
            float min = Math.min(this.f26587b, this.f26592g);
            this.f26587b = min;
            float max = Math.max(min, this.f26593h);
            this.f26587b = max;
            g(max);
            if (j4) {
                c(false);
            }
            return j4;
        }
        return invokeJ.booleanValue;
    }

    public T b(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar)) == null) {
            if (!this.k.contains(jVar)) {
                this.k.add(jVar);
            }
            return this;
        }
        return (T) invokeL.objValue;
    }

    public final void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f26591f = false;
            c.a.r0.x.a.i().l(this);
            this.f26594i = 0L;
            this.f26588c = false;
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                if (this.k.get(i2) != null) {
                    this.k.get(i2).a(this, z, this.f26587b, this.f26586a);
                }
            }
            f(this.k);
        }
    }

    public final float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f26590e.a(this.f26589d) : invokeV.floatValue;
    }

    public float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f26595j * 0.75f : invokeV.floatValue;
    }

    public void g(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            this.f26590e.b(this.f26589d, f2);
            for (int i2 = 0; i2 < this.l.size(); i2++) {
                if (this.l.get(i2) != null) {
                    this.l.get(i2).a(this, this.f26587b, this.f26586a);
                }
            }
            f(this.l);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                if (this.f26591f) {
                    return;
                }
                i();
                return;
            }
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f26591f) {
            return;
        }
        this.f26591f = true;
        if (!this.f26588c) {
            this.f26587b = d();
        }
        float f2 = this.f26587b;
        if (f2 <= this.f26592g && f2 >= this.f26593h) {
            c.a.r0.x.a.i().f(this, 0L);
            return;
        }
        throw new IllegalArgumentException("Starting value need to be in between min value and max value");
    }

    public abstract boolean j(long j2);
}
