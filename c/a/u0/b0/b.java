package c.a.u0.b0;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.annotation.RestrictTo;
import c.a.u0.b0.a;
import c.a.u0.b0.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.ArrayList;
/* loaded from: classes7.dex */
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
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public float f15498b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f15499c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f15500d;

    /* renamed from: e  reason: collision with root package name */
    public final c.a.u0.b0.c f15501e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f15502f;

    /* renamed from: g  reason: collision with root package name */
    public float f15503g;

    /* renamed from: h  reason: collision with root package name */
    public float f15504h;

    /* renamed from: i  reason: collision with root package name */
    public long f15505i;

    /* renamed from: j  reason: collision with root package name */
    public float f15506j;
    public final ArrayList<j> k;
    public final ArrayList<k> l;

    /* loaded from: classes7.dex */
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
                    super((String) objArr2[0], (C0979b) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.u0.b0.c
        /* renamed from: c */
        public float a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? view.getAlpha() : invokeL.floatValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.u0.b0.c
        /* renamed from: d */
        public void b(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048579, this, view, f2) == null) {
                view.setAlpha(f2);
            }
        }
    }

    /* renamed from: c.a.u0.b0.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0979b extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
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
                    super((String) objArr2[0], (C0979b) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.u0.b0.c
        /* renamed from: c */
        public float a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? view.getTranslationY() : invokeL.floatValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.u0.b0.c
        /* renamed from: d */
        public void b(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048579, this, view, f2) == null) {
                view.setTranslationY(f2);
            }
        }
    }

    /* loaded from: classes7.dex */
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
                    super((String) objArr2[0], (C0979b) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.u0.b0.c
        /* renamed from: c */
        public float a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? view.getScaleX() : invokeL.floatValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.u0.b0.c
        /* renamed from: d */
        public void b(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048579, this, view, f2) == null) {
                view.setScaleX(f2);
            }
        }
    }

    /* loaded from: classes7.dex */
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
                    super((String) objArr2[0], (C0979b) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.u0.b0.c
        /* renamed from: c */
        public float a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? view.getScaleY() : invokeL.floatValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.u0.b0.c
        /* renamed from: d */
        public void b(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048579, this, view, f2) == null) {
                view.setScaleY(f2);
            }
        }
    }

    /* loaded from: classes7.dex */
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
                    super((String) objArr2[0], (C0979b) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.u0.b0.c
        /* renamed from: c */
        public float a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? view.getRotation() : invokeL.floatValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.u0.b0.c
        /* renamed from: d */
        public void b(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048579, this, view, f2) == null) {
                view.setRotation(f2);
            }
        }
    }

    /* loaded from: classes7.dex */
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
                    super((String) objArr2[0], (C0979b) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.u0.b0.c
        /* renamed from: c */
        public float a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? view.getRotationX() : invokeL.floatValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.u0.b0.c
        /* renamed from: d */
        public void b(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048579, this, view, f2) == null) {
                view.setRotationX(f2);
            }
        }
    }

    /* loaded from: classes7.dex */
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
                    super((String) objArr2[0], (C0979b) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.u0.b0.c
        /* renamed from: c */
        public float a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? view.getRotationY() : invokeL.floatValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.u0.b0.c
        /* renamed from: d */
        public void b(View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048579, this, view, f2) == null) {
                view.setRotationY(f2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;

        /* renamed from: b  reason: collision with root package name */
        public float f15507b;

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

    /* loaded from: classes7.dex */
    public interface j {
        void a(b bVar, boolean z, float f2, float f3);
    }

    /* loaded from: classes7.dex */
    public interface k {
        void a(b bVar, float f2, float f3);
    }

    /* loaded from: classes7.dex */
    public static abstract class l extends c.a.u0.b0.c<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ l(String str, C0979b c0979b) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1581391252, "Lc/a/u0/b0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1581391252, "Lc/a/u0/b0/b;");
                return;
            }
        }
        m = new c(AnimationProperty.TRANSLATE_Y);
        n = new d(AnimationProperty.SCALE_X);
        o = new e(AnimationProperty.SCALE_Y);
        p = new f("rotation");
        q = new g(AnimationProperty.ROTATE_X);
        r = new h(AnimationProperty.ROTATE_Y);
        s = new a(AnimationProperty.OPACITY);
    }

    public <K> b(K k2, c.a.u0.b0.c<K> cVar) {
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
        this.a = 0.0f;
        this.f15498b = Float.MAX_VALUE;
        this.f15499c = false;
        this.f15502f = false;
        this.f15503g = Float.MAX_VALUE;
        this.f15504h = -Float.MAX_VALUE;
        this.f15505i = 0L;
        this.k = new ArrayList<>();
        this.l = new ArrayList<>();
        this.f15500d = k2;
        this.f15501e = cVar;
        if (cVar != p && cVar != q && cVar != r) {
            if (cVar == s) {
                this.f15506j = 0.00390625f;
                return;
            } else if (cVar != n && cVar != o) {
                this.f15506j = 1.0f;
                return;
            } else {
                this.f15506j = 0.00390625f;
                return;
            }
        }
        this.f15506j = 0.1f;
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

    @Override // c.a.u0.b0.a.b
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            long j3 = this.f15505i;
            if (j3 == 0) {
                this.f15505i = j2;
                g(this.f15498b);
                return false;
            }
            this.f15505i = j2;
            boolean j4 = j(j2 - j3);
            float min = Math.min(this.f15498b, this.f15503g);
            this.f15498b = min;
            float max = Math.max(min, this.f15504h);
            this.f15498b = max;
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
            this.f15502f = false;
            c.a.u0.b0.a.i().l(this);
            this.f15505i = 0L;
            this.f15499c = false;
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                if (this.k.get(i2) != null) {
                    this.k.get(i2).a(this, z, this.f15498b, this.a);
                }
            }
            f(this.k);
        }
    }

    public final float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15501e.a(this.f15500d) : invokeV.floatValue;
    }

    public float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f15506j * 0.75f : invokeV.floatValue;
    }

    public void g(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            this.f15501e.b(this.f15500d, f2);
            for (int i2 = 0; i2 < this.l.size(); i2++) {
                if (this.l.get(i2) != null) {
                    this.l.get(i2).a(this, this.f15498b, this.a);
                }
            }
            f(this.l);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                if (this.f15502f) {
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f15502f) {
            return;
        }
        this.f15502f = true;
        if (!this.f15499c) {
            this.f15498b = d();
        }
        float f2 = this.f15498b;
        if (f2 <= this.f15503g && f2 >= this.f15504h) {
            c.a.u0.b0.a.i().f(this, 0L);
            return;
        }
        throw new IllegalArgumentException("Starting value need to be in between min value and max value");
    }

    public abstract boolean j(long j2);
}
