package c.i.b.a.e0.r;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class e extends c.i.b.a.e0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long q;
    public final long r;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f33592a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1171127231, "Lc/i/b/a/e0/r/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1171127231, "Lc/i/b/a/e0/r/e$a;");
                    return;
                }
            }
            int[] iArr = new int[Layout.Alignment.values().length];
            f33592a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33592a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33592a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f33593a;

        /* renamed from: b  reason: collision with root package name */
        public long f33594b;

        /* renamed from: c  reason: collision with root package name */
        public SpannableStringBuilder f33595c;

        /* renamed from: d  reason: collision with root package name */
        public Layout.Alignment f33596d;

        /* renamed from: e  reason: collision with root package name */
        public float f33597e;

        /* renamed from: f  reason: collision with root package name */
        public int f33598f;

        /* renamed from: g  reason: collision with root package name */
        public int f33599g;

        /* renamed from: h  reason: collision with root package name */
        public float f33600h;

        /* renamed from: i  reason: collision with root package name */
        public int f33601i;

        /* renamed from: j  reason: collision with root package name */
        public float f33602j;

        public b() {
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
            c();
        }

        public e a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f33600h != Float.MIN_VALUE && this.f33601i == Integer.MIN_VALUE) {
                    b();
                }
                return new e(this.f33593a, this.f33594b, this.f33595c, this.f33596d, this.f33597e, this.f33598f, this.f33599g, this.f33600h, this.f33601i, this.f33602j);
            }
            return (e) invokeV.objValue;
        }

        public final b b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Layout.Alignment alignment = this.f33596d;
                if (alignment == null) {
                    this.f33601i = Integer.MIN_VALUE;
                } else {
                    int i2 = a.f33592a[alignment.ordinal()];
                    if (i2 == 1) {
                        this.f33601i = 0;
                    } else if (i2 == 2) {
                        this.f33601i = 1;
                    } else if (i2 != 3) {
                        String str = "Unrecognized alignment: " + this.f33596d;
                        this.f33601i = 0;
                    } else {
                        this.f33601i = 2;
                    }
                }
                return this;
            }
            return (b) invokeV.objValue;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f33593a = 0L;
                this.f33594b = 0L;
                this.f33595c = null;
                this.f33596d = null;
                this.f33597e = Float.MIN_VALUE;
                this.f33598f = Integer.MIN_VALUE;
                this.f33599g = Integer.MIN_VALUE;
                this.f33600h = Float.MIN_VALUE;
                this.f33601i = Integer.MIN_VALUE;
                this.f33602j = Float.MIN_VALUE;
            }
        }

        public b d(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) {
                this.f33594b = j2;
                return this;
            }
            return (b) invokeJ.objValue;
        }

        public b e(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f2)) == null) {
                this.f33597e = f2;
                return this;
            }
            return (b) invokeF.objValue;
        }

        public b f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                this.f33599g = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b g(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                this.f33598f = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b h(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048583, this, f2)) == null) {
                this.f33600h = f2;
                return this;
            }
            return (b) invokeF.objValue;
        }

        public b i(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
                this.f33601i = i2;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b j(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j2)) == null) {
                this.f33593a = j2;
                return this;
            }
            return (b) invokeJ.objValue;
        }

        public b k(SpannableStringBuilder spannableStringBuilder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, spannableStringBuilder)) == null) {
                this.f33595c = spannableStringBuilder;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b l(Layout.Alignment alignment) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, alignment)) == null) {
                this.f33596d = alignment;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b m(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048588, this, f2)) == null) {
                this.f33602j = f2;
                return this;
            }
            return (b) invokeF.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(CharSequence charSequence) {
        this(0L, 0L, charSequence);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r8;
            Object[] objArr = {charSequence};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue(), (CharSequence) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f33436h == Float.MIN_VALUE && this.k == Float.MIN_VALUE : invokeV.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(long j2, long j3, CharSequence charSequence) {
        this(j2, j3, charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), charSequence};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue(), (CharSequence) objArr2[2], (Layout.Alignment) objArr2[3], ((Float) objArr2[4]).floatValue(), ((Integer) objArr2[5]).intValue(), ((Integer) objArr2[6]).intValue(), ((Float) objArr2[7]).floatValue(), ((Integer) objArr2[8]).intValue(), ((Float) objArr2[9]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(long j2, long j3, CharSequence charSequence, Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4) {
        super(charSequence, alignment, f2, i2, i3, f3, i4, f4);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), charSequence, alignment, Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f3), Integer.valueOf(i4), Float.valueOf(f4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((CharSequence) objArr2[0], (Layout.Alignment) objArr2[1], ((Float) objArr2[2]).floatValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Float) objArr2[5]).floatValue(), ((Integer) objArr2[6]).intValue(), ((Float) objArr2[7]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.q = j2;
        this.r = j3;
    }
}
