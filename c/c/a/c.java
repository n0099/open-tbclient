package c.c.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Base64;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.core.graphics.TypefaceCompatApi28Impl;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.SVG;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static HashSet<String> l;
    public transient /* synthetic */ FieldHolder $fh;
    public Canvas a;

    /* renamed from: b  reason: collision with root package name */
    public SVG.b f27966b;

    /* renamed from: c  reason: collision with root package name */
    public float f27967c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f27968d;

    /* renamed from: e  reason: collision with root package name */
    public SVG f27969e;

    /* renamed from: f  reason: collision with root package name */
    public h f27970f;

    /* renamed from: g  reason: collision with root package name */
    public Stack<h> f27971g;

    /* renamed from: h  reason: collision with root package name */
    public Stack<SVG.h0> f27972h;

    /* renamed from: i  reason: collision with root package name */
    public Stack<Matrix> f27973i;

    /* renamed from: j  reason: collision with root package name */
    public Stack<Canvas> f27974j;

    /* renamed from: k  reason: collision with root package name */
    public Stack<Bitmap> f27975k;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f27976b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f27977c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ int[] f27978d;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1870620013, "Lc/c/a/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1870620013, "Lc/c/a/c$a;");
                    return;
                }
            }
            int[] iArr = new int[SVG.Style.FillRule.values().length];
            f27978d = iArr;
            try {
                iArr[SVG.Style.FillRule.EvenOdd.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27978d[SVG.Style.FillRule.NonZero.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[SVG.Style.LineJoin.values().length];
            f27977c = iArr2;
            try {
                iArr2[SVG.Style.LineJoin.Miter.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f27977c[SVG.Style.LineJoin.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f27977c[SVG.Style.LineJoin.Bevel.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[SVG.Style.LineCaps.values().length];
            f27976b = iArr3;
            try {
                iArr3[SVG.Style.LineCaps.Butt.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f27976b[SVG.Style.LineCaps.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f27976b[SVG.Style.LineCaps.Square.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr4 = new int[PreserveAspectRatio.Alignment.values().length];
            a = iArr4;
            try {
                iArr4[PreserveAspectRatio.Alignment.XMidYMin.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[PreserveAspectRatio.Alignment.XMidYMid.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[PreserveAspectRatio.Alignment.XMidYMax.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[PreserveAspectRatio.Alignment.XMaxYMin.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[PreserveAspectRatio.Alignment.XMaxYMid.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[PreserveAspectRatio.Alignment.XMaxYMax.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[PreserveAspectRatio.Alignment.XMinYMid.ordinal()] = 7;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[PreserveAspectRatio.Alignment.XMinYMax.ordinal()] = 8;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements SVG.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<C1561c> a;

        /* renamed from: b  reason: collision with root package name */
        public float f27979b;

        /* renamed from: c  reason: collision with root package name */
        public float f27980c;

        /* renamed from: d  reason: collision with root package name */
        public C1561c f27981d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f27982e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f27983f;

        /* renamed from: g  reason: collision with root package name */
        public int f27984g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f27985h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c f27986i;

        public b(c cVar, SVG.v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27986i = cVar;
            this.a = new ArrayList();
            this.f27981d = null;
            this.f27982e = false;
            this.f27983f = true;
            this.f27984g = -1;
            if (vVar == null) {
                return;
            }
            vVar.h(this);
            if (this.f27985h) {
                this.f27981d.b(this.a.get(this.f27984g));
                this.a.set(this.f27984g, this.f27981d);
                this.f27985h = false;
            }
            C1561c c1561c = this.f27981d;
            if (c1561c != null) {
                this.a.add(c1561c);
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void a(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                if (this.f27985h) {
                    this.f27981d.b(this.a.get(this.f27984g));
                    this.a.set(this.f27984g, this.f27981d);
                    this.f27985h = false;
                }
                C1561c c1561c = this.f27981d;
                if (c1561c != null) {
                    this.a.add(c1561c);
                }
                this.f27979b = f2;
                this.f27980c = f3;
                this.f27981d = new C1561c(this.f27986i, f2, f3, 0.0f, 0.0f);
                this.f27984g = this.a.size();
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void b(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.f27981d.a(f2, f3);
                this.a.add(this.f27981d);
                c cVar = this.f27986i;
                C1561c c1561c = this.f27981d;
                this.f27981d = new C1561c(cVar, f2, f3, f2 - c1561c.a, f3 - c1561c.f27987b);
                this.f27985h = false;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void c(float f2, float f3, float f4, float f5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
                this.f27981d.a(f2, f3);
                this.a.add(this.f27981d);
                this.f27981d = new C1561c(this.f27986i, f4, f5, f4 - f2, f5 - f3);
                this.f27985h = false;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.add(this.f27981d);
                b(this.f27979b, this.f27980c);
                this.f27985h = true;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void d(float f2, float f3, float f4, float f5, float f6, float f7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7)}) == null) {
                if (this.f27983f || this.f27982e) {
                    this.f27981d.a(f2, f3);
                    this.a.add(this.f27981d);
                    this.f27982e = false;
                }
                this.f27981d = new C1561c(this.f27986i, f6, f7, f6 - f4, f7 - f5);
                this.f27985h = false;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void e(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f6) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Boolean.valueOf(z), Boolean.valueOf(z2), Float.valueOf(f5), Float.valueOf(f6)}) == null) {
                this.f27982e = true;
                this.f27983f = false;
                C1561c c1561c = this.f27981d;
                c.m(c1561c.a, c1561c.f27987b, f2, f3, f4, z, z2, f5, f6, this);
                this.f27983f = true;
                this.f27985h = false;
            }
        }

        public List<C1561c> f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (List) invokeV.objValue;
        }
    }

    /* renamed from: c.c.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1561c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;

        /* renamed from: b  reason: collision with root package name */
        public float f27987b;

        /* renamed from: c  reason: collision with root package name */
        public float f27988c;

        /* renamed from: d  reason: collision with root package name */
        public float f27989d;

        public C1561c(c cVar, float f2, float f3, float f4, float f5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27988c = 0.0f;
            this.f27989d = 0.0f;
            this.a = f2;
            this.f27987b = f3;
            double sqrt = Math.sqrt((f4 * f4) + (f5 * f5));
            if (sqrt != 0.0d) {
                this.f27988c = (float) (f4 / sqrt);
                this.f27989d = (float) (f5 / sqrt);
            }
        }

        public void a(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                float f4 = f2 - this.a;
                float f5 = f3 - this.f27987b;
                double sqrt = Math.sqrt((f4 * f4) + (f5 * f5));
                if (sqrt != 0.0d) {
                    this.f27988c += (float) (f4 / sqrt);
                    this.f27989d += (float) (f5 / sqrt);
                }
            }
        }

        public void b(C1561c c1561c) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c1561c) == null) {
                this.f27988c += c1561c.f27988c;
                this.f27989d += c1561c.f27989d;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return "(" + this.a + "," + this.f27987b + " " + this.f27988c + "," + this.f27989d + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements SVG.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Path a;

        /* renamed from: b  reason: collision with root package name */
        public float f27990b;

        /* renamed from: c  reason: collision with root package name */
        public float f27991c;

        public d(c cVar, SVG.v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new Path();
            if (vVar == null) {
                return;
            }
            vVar.h(this);
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void a(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.a.moveTo(f2, f3);
                this.f27990b = f2;
                this.f27991c = f3;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void b(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.a.lineTo(f2, f3);
                this.f27990b = f2;
                this.f27991c = f3;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void c(float f2, float f3, float f4, float f5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
                this.a.quadTo(f2, f3, f4, f5);
                this.f27990b = f4;
                this.f27991c = f5;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.close();
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void d(float f2, float f3, float f4, float f5, float f6, float f7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7)}) == null) {
                this.a.cubicTo(f2, f3, f4, f5, f6, f7);
                this.f27990b = f6;
                this.f27991c = f7;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void e(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f6) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Boolean.valueOf(z), Boolean.valueOf(z2), Float.valueOf(f5), Float.valueOf(f6)}) == null) {
                c.m(this.f27990b, this.f27991c, f2, f3, f4, z, z2, f5, f6, this);
                this.f27990b = f5;
                this.f27991c = f6;
            }
        }

        public Path f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (Path) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public Path f27992d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f27993e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(c cVar, Path path, float f2, float f3) {
            super(cVar, f2, f3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, path, Float.valueOf(f2), Float.valueOf(f3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((c) objArr2[0], ((Float) objArr2[1]).floatValue(), ((Float) objArr2[2]).floatValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27993e = cVar;
            this.f27992d = path;
        }

        @Override // c.c.a.c.f, c.c.a.c.j
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.f27993e.Y0()) {
                    if (this.f27993e.f27970f.f28000f) {
                        this.f27993e.a.drawTextOnPath(str, this.f27992d, this.a, this.f27994b, this.f27993e.f27970f.f28002h);
                    }
                    if (this.f27993e.f27970f.f28001g) {
                        this.f27993e.a.drawTextOnPath(str, this.f27992d, this.a, this.f27994b, this.f27993e.f27970f.f28003i);
                    }
                }
                this.a += this.f27993e.f27970f.f28002h.measureText(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;

        /* renamed from: b  reason: collision with root package name */
        public float f27994b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f27995c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(c cVar, float f2, float f3) {
            super(cVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Float.valueOf(f2), Float.valueOf(f3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((c) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27995c = cVar;
            this.a = f2;
            this.f27994b = f3;
        }

        @Override // c.c.a.c.j
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.C("TextSequence render", new Object[0]);
                if (this.f27995c.Y0()) {
                    if (this.f27995c.f27970f.f28000f) {
                        this.f27995c.a.drawText(str, this.a, this.f27994b, this.f27995c.f27970f.f28002h);
                    }
                    if (this.f27995c.f27970f.f28001g) {
                        this.f27995c.a.drawText(str, this.a, this.f27994b, this.f27995c.f27970f.f28003i);
                    }
                }
                this.a += this.f27995c.f27970f.f28002h.measureText(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;

        /* renamed from: b  reason: collision with root package name */
        public float f27996b;

        /* renamed from: c  reason: collision with root package name */
        public Path f27997c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f27998d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(c cVar, float f2, float f3, Path path) {
            super(cVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Float.valueOf(f2), Float.valueOf(f3), path};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((c) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27998d = cVar;
            this.a = f2;
            this.f27996b = f3;
            this.f27997c = path;
        }

        @Override // c.c.a.c.j
        public boolean a(SVG.w0 w0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, w0Var)) == null) {
                if (w0Var instanceof SVG.x0) {
                    c.Z0("Using <textPath> elements in a clip path is not supported.", new Object[0]);
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // c.c.a.c.j
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.f27998d.Y0()) {
                    Path path = new Path();
                    this.f27998d.f27970f.f28002h.getTextPath(str, 0, str.length(), this.a, this.f27996b, path);
                    this.f27997c.addPath(path);
                }
                this.a += this.f27998d.f27970f.f28002h.measureText(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Cloneable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public SVG.Style f27999e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f28000f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f28001g;

        /* renamed from: h  reason: collision with root package name */
        public Paint f28002h;

        /* renamed from: i  reason: collision with root package name */
        public Paint f28003i;

        /* renamed from: j  reason: collision with root package name */
        public SVG.b f28004j;

        /* renamed from: k  reason: collision with root package name */
        public SVG.b f28005k;
        public boolean l;
        public boolean m;

        public h(c cVar) {
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
                    return;
                }
            }
            Paint paint = new Paint();
            this.f28002h = paint;
            paint.setFlags(385);
            this.f28002h.setStyle(Paint.Style.FILL);
            this.f28002h.setTypeface(Typeface.DEFAULT);
            Paint paint2 = new Paint();
            this.f28003i = paint2;
            paint2.setFlags(385);
            this.f28003i.setStyle(Paint.Style.STROKE);
            this.f28003i.setTypeface(Typeface.DEFAULT);
            this.f27999e = SVG.Style.a();
        }

        public Object clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    h hVar = (h) super.clone();
                    hVar.f27999e = (SVG.Style) this.f27999e.clone();
                    hVar.f28002h = new Paint(this.f28002h);
                    hVar.f28003i = new Paint(this.f28003i);
                    return hVar;
                } catch (CloneNotSupportedException e2) {
                    throw new InternalError(e2.toString());
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class i extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;

        /* renamed from: b  reason: collision with root package name */
        public float f28006b;

        /* renamed from: c  reason: collision with root package name */
        public RectF f28007c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f28008d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(c cVar, float f2, float f3) {
            super(cVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Float.valueOf(f2), Float.valueOf(f3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((c) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28008d = cVar;
            this.f28007c = new RectF();
            this.a = f2;
            this.f28006b = f3;
        }

        @Override // c.c.a.c.j
        public boolean a(SVG.w0 w0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, w0Var)) == null) {
                if (w0Var instanceof SVG.x0) {
                    SVG.x0 x0Var = (SVG.x0) w0Var;
                    SVG.l0 n = w0Var.a.n(x0Var.n);
                    if (n == null) {
                        c.J("TextPath path reference '%s' not found", x0Var.n);
                        return false;
                    }
                    SVG.u uVar = (SVG.u) n;
                    Path f2 = new d(this.f28008d, uVar.o).f();
                    Matrix matrix = uVar.n;
                    if (matrix != null) {
                        f2.transform(matrix);
                    }
                    RectF rectF = new RectF();
                    f2.computeBounds(rectF, true);
                    this.f28007c.union(rectF);
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // c.c.a.c.j
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.f28008d.Y0()) {
                    Rect rect = new Rect();
                    this.f28008d.f27970f.f28002h.getTextBounds(str, 0, str.length(), rect);
                    RectF rectF = new RectF(rect);
                    rectF.offset(this.a, this.f28006b);
                    this.f28007c.union(rectF);
                }
                this.a += this.f28008d.f27970f.f28002h.measureText(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public abstract class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j(c cVar) {
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

        public boolean a(SVG.w0 w0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, w0Var)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        public abstract void b(String str);

        public /* synthetic */ j(c cVar, a aVar) {
            this(cVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1839392182, "Lc/c/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1839392182, "Lc/c/a/c;");
        }
    }

    public c(Canvas canvas, SVG.b bVar, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {canvas, bVar, Float.valueOf(f2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = canvas;
        this.f27967c = f2;
        this.f27966b = bVar;
    }

    public static void C(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, objArr) == null) {
        }
    }

    public static void J(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, objArr) == null) {
            String.format(str, objArr);
        }
    }

    public static synchronized void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (c.class) {
                HashSet<String> hashSet = new HashSet<>();
                l = hashSet;
                hashSet.add("Structure");
                l.add("BasicStructure");
                l.add("ConditionalProcessing");
                l.add("Image");
                l.add("Style");
                l.add("ViewportAttribute");
                l.add("Shape");
                l.add("BasicText");
                l.add("PaintAttribute");
                l.add("BasicPaintAttribute");
                l.add("OpacityAttribute");
                l.add("BasicGraphicsAttribute");
                l.add("Marker");
                l.add("Gradient");
                l.add("Pattern");
                l.add("Clip");
                l.add("BasicClip");
                l.add("Mask");
                l.add("View");
            }
        }
    }

    public static void Z0(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, objArr) == null) {
            String.format(str, objArr);
        }
    }

    public static void m(float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, float f7, float f8, SVG.w wVar) {
        float f9;
        SVG.w wVar2;
        double d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Boolean.valueOf(z), Boolean.valueOf(z2), Float.valueOf(f7), Float.valueOf(f8), wVar}) == null) {
            if (f2 == f7 && f3 == f8) {
                return;
            }
            if (f4 == 0.0f) {
                f9 = f7;
                wVar2 = wVar;
            } else if (f5 != 0.0f) {
                float abs = Math.abs(f4);
                float abs2 = Math.abs(f5);
                double radians = (float) Math.toRadians(f6 % 360.0d);
                double cos = Math.cos(radians);
                double sin = Math.sin(radians);
                double d3 = (f2 - f7) / 2.0d;
                double d4 = (f3 - f8) / 2.0d;
                double d5 = (cos * d3) + (sin * d4);
                double d6 = ((-sin) * d3) + (d4 * cos);
                double d7 = abs * abs;
                double d8 = abs2 * abs2;
                double d9 = d5 * d5;
                double d10 = d6 * d6;
                double d11 = (d9 / d7) + (d10 / d8);
                if (d11 > 1.0d) {
                    abs *= (float) Math.sqrt(d11);
                    abs2 *= (float) Math.sqrt(d11);
                    d7 = abs * abs;
                    d8 = abs2 * abs2;
                }
                double d12 = z == z2 ? -1.0d : 1.0d;
                double d13 = d7 * d8;
                double d14 = d7 * d10;
                double d15 = d8 * d9;
                double d16 = ((d13 - d14) - d15) / (d14 + d15);
                if (d16 < 0.0d) {
                    d16 = 0.0d;
                }
                double sqrt = d12 * Math.sqrt(d16);
                double d17 = abs;
                double d18 = abs2;
                double d19 = ((d17 * d6) / d18) * sqrt;
                float f10 = abs;
                float f11 = abs2;
                double d20 = sqrt * (-((d18 * d5) / d17));
                double d21 = ((f2 + f7) / 2.0d) + ((cos * d19) - (sin * d20));
                double d22 = ((f3 + f8) / 2.0d) + (sin * d19) + (cos * d20);
                double d23 = (d5 - d19) / d17;
                double d24 = (d6 - d20) / d18;
                double d25 = ((-d5) - d19) / d17;
                double d26 = ((-d6) - d20) / d18;
                double d27 = (d23 * d23) + (d24 * d24);
                double degrees = Math.toDegrees((d24 < 0.0d ? -1.0d : 1.0d) * Math.acos(d23 / Math.sqrt(d27)));
                double degrees2 = Math.toDegrees(((d23 * d26) - (d24 * d25) < 0.0d ? -1.0d : 1.0d) * Math.acos(((d23 * d25) + (d24 * d26)) / Math.sqrt(d27 * ((d25 * d25) + (d26 * d26)))));
                if (z2 || degrees2 <= 0.0d) {
                    d2 = 360.0d;
                    if (z2 && degrees2 < 0.0d) {
                        degrees2 += 360.0d;
                    }
                } else {
                    d2 = 360.0d;
                    degrees2 -= 360.0d;
                }
                float[] n = n(degrees % d2, degrees2 % d2);
                Matrix matrix = new Matrix();
                matrix.postScale(f10, f11);
                matrix.postRotate(f6);
                matrix.postTranslate((float) d21, (float) d22);
                matrix.mapPoints(n);
                n[n.length - 2] = f7;
                n[n.length - 1] = f8;
                for (int i2 = 0; i2 < n.length; i2 += 6) {
                    wVar.d(n[i2], n[i2 + 1], n[i2 + 2], n[i2 + 3], n[i2 + 4], n[i2 + 5]);
                }
                return;
            } else {
                wVar2 = wVar;
                f9 = f7;
            }
            wVar2.b(f9, f8);
        }
    }

    public static float[] n(double d2, double d3) {
        InterceptResult invokeCommon;
        float radians;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3)})) == null) {
            int ceil = (int) Math.ceil(Math.abs(d3) / 90.0d);
            double radians2 = Math.toRadians(d2);
            double radians3 = (float) (Math.toRadians(d3) / ceil);
            double d4 = radians3 / 2.0d;
            double sin = (Math.sin(d4) * 1.3333333333333333d) / (Math.cos(d4) + 1.0d);
            float[] fArr = new float[ceil * 6];
            int i2 = 0;
            int i3 = 0;
            while (i2 < ceil) {
                double d5 = (i2 * radians) + radians2;
                double cos = Math.cos(d5);
                double sin2 = Math.sin(d5);
                int i4 = i3 + 1;
                int i5 = ceil;
                double d6 = radians2;
                fArr[i3] = (float) (cos - (sin * sin2));
                int i6 = i4 + 1;
                fArr[i4] = (float) (sin2 + (cos * sin));
                double d7 = d5 + radians3;
                double cos2 = Math.cos(d7);
                double sin3 = Math.sin(d7);
                int i7 = i6 + 1;
                fArr[i6] = (float) ((sin * sin3) + cos2);
                int i8 = i7 + 1;
                fArr[i7] = (float) (sin3 - (sin * cos2));
                int i9 = i8 + 1;
                fArr[i8] = (float) cos2;
                fArr[i9] = (float) sin3;
                i2++;
                radians2 = d6;
                i3 = i9 + 1;
                ceil = i5;
            }
            return fArr;
        }
        return (float[]) invokeCommon.objValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.restore();
            this.f27970f = this.f27971g.pop();
        }
    }

    public final void A0(SVG.l0 l0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l0Var) == null) || (l0Var instanceof SVG.s)) {
            return;
        }
        S0();
        y(l0Var);
        if (l0Var instanceof SVG.d0) {
            x0((SVG.d0) l0Var);
        } else if (l0Var instanceof SVG.b1) {
            E0((SVG.b1) l0Var);
        } else if (l0Var instanceof SVG.q0) {
            B0((SVG.q0) l0Var);
        } else if (l0Var instanceof SVG.l) {
            q0((SVG.l) l0Var);
        } else if (l0Var instanceof SVG.n) {
            r0((SVG.n) l0Var);
        } else if (l0Var instanceof SVG.u) {
            t0((SVG.u) l0Var);
        } else if (l0Var instanceof SVG.a0) {
            w0((SVG.a0) l0Var);
        } else if (l0Var instanceof SVG.d) {
            o0((SVG.d) l0Var);
        } else if (l0Var instanceof SVG.i) {
            p0((SVG.i) l0Var);
        } else if (l0Var instanceof SVG.p) {
            s0((SVG.p) l0Var);
        } else if (l0Var instanceof SVG.z) {
            v0((SVG.z) l0Var);
        } else if (l0Var instanceof SVG.y) {
            u0((SVG.y) l0Var);
        } else if (l0Var instanceof SVG.u0) {
            D0((SVG.u0) l0Var);
        }
        R0();
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.save();
            this.f27971g.push(this.f27970f);
            this.f27970f = (h) this.f27970f.clone();
        }
    }

    public final void B0(SVG.q0 q0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, q0Var) == null) {
            C("Switch render", new Object[0]);
            W0(this.f27970f, q0Var);
            if (E()) {
                Matrix matrix = q0Var.n;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                t(q0Var);
                boolean n0 = n0();
                K0(q0Var);
                if (n0) {
                    k0(q0Var);
                }
                U0(q0Var);
            }
        }
    }

    public final void C0(SVG.r0 r0Var, SVG.o oVar, SVG.o oVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, r0Var, oVar, oVar2) == null) {
            C("Symbol render", new Object[0]);
            if (oVar == null || !oVar.i()) {
                if (oVar2 == null || !oVar2.i()) {
                    PreserveAspectRatio preserveAspectRatio = r0Var.n;
                    if (preserveAspectRatio == null) {
                        preserveAspectRatio = PreserveAspectRatio.f54798d;
                    }
                    W0(this.f27970f, r0Var);
                    this.f27970f.f28004j = new SVG.b(0.0f, 0.0f, oVar != null ? oVar.f(this) : this.f27970f.f28004j.f54815g, oVar2 != null ? oVar2.f(this) : this.f27970f.f28004j.f54816h);
                    if (!this.f27970f.f27999e.z.booleanValue()) {
                        SVG.b bVar = this.f27970f.f28004j;
                        O0(bVar.f54813e, bVar.f54814f, bVar.f54815g, bVar.f54816h);
                    }
                    SVG.b bVar2 = r0Var.o;
                    if (bVar2 != null) {
                        this.a.concat(s(this.f27970f.f28004j, bVar2, preserveAspectRatio));
                        this.f27970f.f28005k = r0Var.o;
                    }
                    boolean n0 = n0();
                    F0(r0Var, true);
                    if (n0) {
                        k0(r0Var);
                    }
                    U0(r0Var);
                }
            }
        }
    }

    public final void D(boolean z, SVG.b bVar, SVG.t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), bVar, tVar}) == null) {
            SVG.l0 n = this.f27969e.n(tVar.f54843e);
            if (n == null) {
                Object[] objArr = new Object[2];
                objArr[0] = z ? "Fill" : "Stroke";
                objArr[1] = tVar.f54843e;
                J("%s reference '%s' not found", objArr);
                SVG.m0 m0Var = tVar.f54844f;
                if (m0Var != null) {
                    P0(this.f27970f, z, m0Var);
                    return;
                } else if (z) {
                    this.f27970f.f28000f = false;
                    return;
                } else {
                    this.f27970f.f28001g = false;
                    return;
                }
            }
            if (n instanceof SVG.k0) {
                b0(z, bVar, (SVG.k0) n);
            }
            if (n instanceof SVG.o0) {
                h0(z, bVar, (SVG.o0) n);
            }
            if (n instanceof SVG.b0) {
                Q0(z, (SVG.b0) n);
            }
        }
    }

    public final void D0(SVG.u0 u0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, u0Var) == null) {
            C("Text render", new Object[0]);
            W0(this.f27970f, u0Var);
            if (E()) {
                Matrix matrix = u0Var.r;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                List<SVG.o> list = u0Var.n;
                float f2 = 0.0f;
                float f3 = (list == null || list.size() == 0) ? 0.0f : u0Var.n.get(0).f(this);
                List<SVG.o> list2 = u0Var.o;
                float g2 = (list2 == null || list2.size() == 0) ? 0.0f : u0Var.o.get(0).g(this);
                List<SVG.o> list3 = u0Var.p;
                float f4 = (list3 == null || list3.size() == 0) ? 0.0f : u0Var.p.get(0).f(this);
                List<SVG.o> list4 = u0Var.q;
                if (list4 != null && list4.size() != 0) {
                    f2 = u0Var.q.get(0).g(this);
                }
                SVG.Style.TextAnchor S = S();
                if (S != SVG.Style.TextAnchor.Start) {
                    float r = r(u0Var);
                    if (S == SVG.Style.TextAnchor.Middle) {
                        r /= 2.0f;
                    }
                    f3 -= r;
                }
                if (u0Var.f54830h == null) {
                    i iVar = new i(this, f3, g2);
                    I(u0Var, iVar);
                    RectF rectF = iVar.f28007c;
                    u0Var.f54830h = new SVG.b(rectF.left, rectF.top, rectF.width(), iVar.f28007c.height());
                }
                U0(u0Var);
                v(u0Var);
                t(u0Var);
                boolean n0 = n0();
                I(u0Var, new f(this, f3 + f4, g2 + f2));
                if (n0) {
                    k0(u0Var);
                }
            }
        }
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Boolean bool = this.f27970f.f27999e.E;
            if (bool != null) {
                return bool.booleanValue();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void E0(SVG.b1 b1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, b1Var) == null) {
            C("Use render", new Object[0]);
            SVG.o oVar = b1Var.r;
            if (oVar == null || !oVar.i()) {
                SVG.o oVar2 = b1Var.s;
                if (oVar2 == null || !oVar2.i()) {
                    W0(this.f27970f, b1Var);
                    if (E()) {
                        SVG.l0 n = b1Var.a.n(b1Var.o);
                        if (n == null) {
                            J("Use reference '%s' not found", b1Var.o);
                            return;
                        }
                        Matrix matrix = b1Var.n;
                        if (matrix != null) {
                            this.a.concat(matrix);
                        }
                        Matrix matrix2 = new Matrix();
                        SVG.o oVar3 = b1Var.p;
                        float f2 = oVar3 != null ? oVar3.f(this) : 0.0f;
                        SVG.o oVar4 = b1Var.q;
                        matrix2.preTranslate(f2, oVar4 != null ? oVar4.g(this) : 0.0f);
                        this.a.concat(matrix2);
                        t(b1Var);
                        boolean n0 = n0();
                        j0(b1Var);
                        if (n instanceof SVG.d0) {
                            S0();
                            SVG.d0 d0Var = (SVG.d0) n;
                            SVG.o oVar5 = b1Var.r;
                            if (oVar5 == null) {
                                oVar5 = d0Var.r;
                            }
                            SVG.o oVar6 = b1Var.s;
                            if (oVar6 == null) {
                                oVar6 = d0Var.s;
                            }
                            y0(d0Var, oVar5, oVar6);
                            R0();
                        } else if (n instanceof SVG.r0) {
                            SVG.o oVar7 = b1Var.r;
                            if (oVar7 == null) {
                                oVar7 = new SVG.o(100.0f, SVG.Unit.percent);
                            }
                            SVG.o oVar8 = b1Var.s;
                            if (oVar8 == null) {
                                oVar8 = new SVG.o(100.0f, SVG.Unit.percent);
                            }
                            S0();
                            C0((SVG.r0) n, oVar7, oVar8);
                            R0();
                        } else {
                            A0(n);
                        }
                        i0();
                        if (n0) {
                            k0(b1Var);
                        }
                        U0(b1Var);
                    }
                }
            }
        }
    }

    public final void F(SVG.i0 i0Var, Path path) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, i0Var, path) == null) {
            SVG.m0 m0Var = this.f27970f.f27999e.f54805f;
            if (m0Var instanceof SVG.t) {
                SVG.l0 n = this.f27969e.n(((SVG.t) m0Var).f54843e);
                if (n instanceof SVG.x) {
                    P(i0Var, path, (SVG.x) n);
                    return;
                }
            }
            this.a.drawPath(path, this.f27970f.f28002h);
        }
    }

    public final void F0(SVG.h0 h0Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, h0Var, z) == null) {
            if (z) {
                j0(h0Var);
            }
            for (SVG.l0 l0Var : h0Var.getChildren()) {
                A0(l0Var);
            }
            if (z) {
                i0();
            }
        }
    }

    public final void G(Path path) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, path) == null) {
            h hVar = this.f27970f;
            if (hVar.f27999e.P == SVG.Style.VectorEffect.NonScalingStroke) {
                Matrix matrix = this.a.getMatrix();
                Path path2 = new Path();
                path.transform(matrix, path2);
                this.a.setMatrix(new Matrix());
                Shader shader = this.f27970f.f28003i.getShader();
                Matrix matrix2 = new Matrix();
                if (shader != null) {
                    shader.getLocalMatrix(matrix2);
                    Matrix matrix3 = new Matrix(matrix2);
                    matrix3.postConcat(matrix);
                    shader.setLocalMatrix(matrix3);
                }
                this.a.drawPath(path2, this.f27970f.f28003i);
                this.a.setMatrix(matrix);
                if (shader != null) {
                    shader.setLocalMatrix(matrix2);
                    return;
                }
                return;
            }
            this.a.drawPath(path, hVar.f28003i);
        }
    }

    public void G0(SVG svg, SVG.b bVar, PreserveAspectRatio preserveAspectRatio, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{svg, bVar, preserveAspectRatio, Boolean.valueOf(z)}) == null) {
            this.f27969e = svg;
            this.f27968d = z;
            SVG.d0 j2 = svg.j();
            if (j2 == null) {
                Z0("Nothing to render. Document is empty.", new Object[0]);
                return;
            }
            N0();
            y(j2);
            SVG.o oVar = j2.r;
            SVG.o oVar2 = j2.s;
            if (bVar == null) {
                bVar = j2.o;
            }
            SVG.b bVar2 = bVar;
            if (preserveAspectRatio == null) {
                preserveAspectRatio = j2.n;
            }
            z0(j2, oVar, oVar2, bVar2, preserveAspectRatio);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(this.a.getWidth(), this.a.getHeight(), Bitmap.Config.ARGB_8888);
                this.f27975k.push(createBitmap);
                Canvas canvas = new Canvas(createBitmap);
                canvas.setMatrix(this.a.getMatrix());
                this.a = canvas;
            } catch (OutOfMemoryError e2) {
                J("Not enough memory to create temporary bitmaps for mask processing", new Object[0]);
                throw e2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x010c, code lost:
        if (r7 != 8) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void H0(SVG.q qVar, C1561c c1561c) {
        float f2;
        SVG.b bVar;
        boolean n0;
        float f3;
        float f4;
        float f5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, qVar, c1561c) == null) {
            S0();
            Float f6 = qVar.u;
            float f7 = 0.0f;
            if (f6 != null) {
                if (Float.isNaN(f6.floatValue())) {
                    if (c1561c.f27988c != 0.0f || c1561c.f27989d != 0.0f) {
                        f2 = (float) Math.toDegrees(Math.atan2(c1561c.f27989d, c1561c.f27988c));
                    }
                } else {
                    f2 = qVar.u.floatValue();
                }
                float b2 = !qVar.p ? 1.0f : this.f27970f.f27999e.f54810k.b(this.f27967c);
                this.f27970f = Q(qVar);
                Matrix matrix = new Matrix();
                matrix.preTranslate(c1561c.a, c1561c.f27987b);
                matrix.preRotate(f2);
                matrix.preScale(b2, b2);
                SVG.o oVar = qVar.q;
                float f8 = oVar == null ? oVar.f(this) : 0.0f;
                SVG.o oVar2 = qVar.r;
                float g2 = oVar2 == null ? oVar2.g(this) : 0.0f;
                SVG.o oVar3 = qVar.s;
                float f9 = oVar3 == null ? oVar3.f(this) : 3.0f;
                SVG.o oVar4 = qVar.t;
                float g3 = oVar4 != null ? oVar4.g(this) : 3.0f;
                bVar = qVar.o;
                if (bVar == null) {
                    float f10 = f9 / bVar.f54815g;
                    float f11 = g3 / bVar.f54816h;
                    PreserveAspectRatio preserveAspectRatio = qVar.n;
                    if (preserveAspectRatio == null) {
                        preserveAspectRatio = PreserveAspectRatio.f54798d;
                    }
                    if (!preserveAspectRatio.equals(PreserveAspectRatio.f54797c)) {
                        f10 = preserveAspectRatio.b() == PreserveAspectRatio.Scale.Slice ? Math.max(f10, f11) : Math.min(f10, f11);
                        f11 = f10;
                    }
                    matrix.preTranslate((-f8) * f10, (-g2) * f11);
                    this.a.concat(matrix);
                    SVG.b bVar2 = qVar.o;
                    float f12 = bVar2.f54815g * f10;
                    float f13 = bVar2.f54816h * f11;
                    switch (a.a[preserveAspectRatio.a().ordinal()]) {
                        case 1:
                        case 2:
                        case 3:
                            f3 = (f9 - f12) / 2.0f;
                            f4 = 0.0f - f3;
                            break;
                        case 4:
                        case 5:
                        case 6:
                            f3 = f9 - f12;
                            f4 = 0.0f - f3;
                            break;
                        default:
                            f4 = 0.0f;
                            break;
                    }
                    int i2 = a.a[preserveAspectRatio.a().ordinal()];
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 5) {
                                if (i2 != 6) {
                                    if (i2 != 7) {
                                    }
                                }
                            }
                        }
                        f5 = g3 - f13;
                        f7 = 0.0f - f5;
                        if (!this.f27970f.f27999e.z.booleanValue()) {
                            O0(f4, f7, f9, g3);
                        }
                        matrix.reset();
                        matrix.preScale(f10, f11);
                        this.a.concat(matrix);
                    }
                    f5 = (g3 - f13) / 2.0f;
                    f7 = 0.0f - f5;
                    if (!this.f27970f.f27999e.z.booleanValue()) {
                    }
                    matrix.reset();
                    matrix.preScale(f10, f11);
                    this.a.concat(matrix);
                } else {
                    matrix.preTranslate(-f8, -g2);
                    this.a.concat(matrix);
                    if (!this.f27970f.f27999e.z.booleanValue()) {
                        O0(0.0f, 0.0f, f9, g3);
                    }
                }
                n0 = n0();
                F0(qVar, false);
                if (n0) {
                    k0(qVar);
                }
                R0();
            }
            f2 = 0.0f;
            if (!qVar.p) {
            }
            this.f27970f = Q(qVar);
            Matrix matrix2 = new Matrix();
            matrix2.preTranslate(c1561c.a, c1561c.f27987b);
            matrix2.preRotate(f2);
            matrix2.preScale(b2, b2);
            SVG.o oVar5 = qVar.q;
            if (oVar5 == null) {
            }
            SVG.o oVar22 = qVar.r;
            if (oVar22 == null) {
            }
            SVG.o oVar32 = qVar.s;
            if (oVar32 == null) {
            }
            SVG.o oVar42 = qVar.t;
            if (oVar42 != null) {
            }
            bVar = qVar.o;
            if (bVar == null) {
            }
            n0 = n0();
            F0(qVar, false);
            if (n0) {
            }
            R0();
        }
    }

    public final void I(SVG.w0 w0Var, j jVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, w0Var, jVar) == null) && E()) {
            Iterator<SVG.l0> it = w0Var.f54823i.iterator();
            boolean z = true;
            while (it.hasNext()) {
                SVG.l0 next = it.next();
                if (next instanceof SVG.a1) {
                    jVar.b(T0(((SVG.a1) next).f54811c, z, !it.hasNext()));
                } else {
                    m0(next, jVar);
                }
                z = false;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a2 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void I0(SVG.k kVar) {
        SVG.q qVar;
        String str;
        SVG.q qVar2;
        String str2;
        SVG.q qVar3;
        List<C1561c> p;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048592, this, kVar) != null) {
            return;
        }
        SVG.Style style = this.f27970f.f27999e;
        if (style.B == null && style.C == null && style.D == null) {
            return;
        }
        String str3 = this.f27970f.f27999e.B;
        if (str3 != null) {
            SVG.l0 n = kVar.a.n(str3);
            if (n != null) {
                qVar = (SVG.q) n;
                str = this.f27970f.f27999e.C;
                if (str != null) {
                    SVG.l0 n2 = kVar.a.n(str);
                    if (n2 != null) {
                        qVar2 = (SVG.q) n2;
                        str2 = this.f27970f.f27999e.D;
                        if (str2 != null) {
                            SVG.l0 n3 = kVar.a.n(str2);
                            if (n3 != null) {
                                qVar3 = (SVG.q) n3;
                                if (!(kVar instanceof SVG.u)) {
                                    p = new b(this, ((SVG.u) kVar).o).f();
                                } else if (kVar instanceof SVG.p) {
                                    p = o((SVG.p) kVar);
                                } else {
                                    p = p((SVG.y) kVar);
                                }
                                if (p == null && (size = p.size()) != 0) {
                                    SVG.Style style2 = this.f27970f.f27999e;
                                    style2.D = null;
                                    style2.C = null;
                                    style2.B = null;
                                    if (qVar != null) {
                                        H0(qVar, p.get(0));
                                    }
                                    if (qVar2 != null) {
                                        for (int i2 = 1; i2 < size - 1; i2++) {
                                            H0(qVar2, p.get(i2));
                                        }
                                    }
                                    if (qVar3 == null) {
                                        H0(qVar3, p.get(size - 1));
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            J("Marker reference '%s' not found", this.f27970f.f27999e.D);
                        }
                        qVar3 = null;
                        if (!(kVar instanceof SVG.u)) {
                        }
                        if (p == null) {
                            return;
                        }
                        SVG.Style style22 = this.f27970f.f27999e;
                        style22.D = null;
                        style22.C = null;
                        style22.B = null;
                        if (qVar != null) {
                        }
                        if (qVar2 != null) {
                        }
                        if (qVar3 == null) {
                        }
                    } else {
                        J("Marker reference '%s' not found", this.f27970f.f27999e.C);
                    }
                }
                qVar2 = null;
                str2 = this.f27970f.f27999e.D;
                if (str2 != null) {
                }
                qVar3 = null;
                if (!(kVar instanceof SVG.u)) {
                }
                if (p == null) {
                }
            } else {
                J("Marker reference '%s' not found", this.f27970f.f27999e.B);
            }
        }
        qVar = null;
        str = this.f27970f.f27999e.C;
        if (str != null) {
        }
        qVar2 = null;
        str2 = this.f27970f.f27999e.D;
        if (str2 != null) {
        }
        qVar3 = null;
        if (!(kVar instanceof SVG.u)) {
        }
        if (p == null) {
        }
    }

    public final void J0(SVG.r rVar, SVG.i0 i0Var) {
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, rVar, i0Var) == null) {
            C("Mask render", new Object[0]);
            Boolean bool = rVar.n;
            boolean z = true;
            if (bool != null && bool.booleanValue()) {
                SVG.o oVar = rVar.r;
                f2 = oVar != null ? oVar.f(this) : i0Var.f54830h.f54815g;
                SVG.o oVar2 = rVar.s;
                f3 = oVar2 != null ? oVar2.g(this) : i0Var.f54830h.f54816h;
                SVG.o oVar3 = rVar.p;
                if (oVar3 != null) {
                    oVar3.f(this);
                } else {
                    SVG.b bVar = i0Var.f54830h;
                    float f4 = bVar.f54813e;
                    float f5 = bVar.f54815g;
                }
                SVG.o oVar4 = rVar.q;
                if (oVar4 != null) {
                    oVar4.g(this);
                } else {
                    SVG.b bVar2 = i0Var.f54830h;
                    float f6 = bVar2.f54814f;
                    float f7 = bVar2.f54816h;
                }
            } else {
                SVG.o oVar5 = rVar.p;
                if (oVar5 != null) {
                    oVar5.e(this, 1.0f);
                }
                SVG.o oVar6 = rVar.q;
                if (oVar6 != null) {
                    oVar6.e(this, 1.0f);
                }
                SVG.o oVar7 = rVar.r;
                float e2 = oVar7 != null ? oVar7.e(this, 1.0f) : 1.2f;
                SVG.o oVar8 = rVar.s;
                float e3 = oVar8 != null ? oVar8.e(this, 1.0f) : 1.2f;
                SVG.b bVar3 = i0Var.f54830h;
                float f8 = bVar3.f54813e;
                float f9 = bVar3.f54815g;
                float f10 = bVar3.f54814f;
                f2 = e2 * f9;
                f3 = e3 * bVar3.f54816h;
            }
            if (f2 == 0.0f || f3 == 0.0f) {
                return;
            }
            S0();
            h Q = Q(rVar);
            this.f27970f = Q;
            Q.f27999e.q = Float.valueOf(1.0f);
            Boolean bool2 = rVar.o;
            if (bool2 != null && !bool2.booleanValue()) {
                z = false;
            }
            if (!z) {
                Canvas canvas = this.a;
                SVG.b bVar4 = i0Var.f54830h;
                canvas.translate(bVar4.f54813e, bVar4.f54814f);
                Canvas canvas2 = this.a;
                SVG.b bVar5 = i0Var.f54830h;
                canvas2.scale(bVar5.f54815g, bVar5.f54816h);
            }
            F0(rVar, false);
            R0();
        }
    }

    public final void K(SVG.w0 w0Var, StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, w0Var, sb) == null) {
            Iterator<SVG.l0> it = w0Var.f54823i.iterator();
            boolean z = true;
            while (it.hasNext()) {
                SVG.l0 next = it.next();
                if (next instanceof SVG.w0) {
                    K((SVG.w0) next, sb);
                } else if (next instanceof SVG.a1) {
                    sb.append(T0(((SVG.a1) next).f54811c, z, !it.hasNext()));
                }
                z = false;
            }
        }
    }

    public final void K0(SVG.q0 q0Var) {
        Set<String> f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, q0Var) == null) {
            String language = Locale.getDefault().getLanguage();
            c.c.a.d e2 = this.f27969e.e();
            for (SVG.l0 l0Var : q0Var.getChildren()) {
                if (l0Var instanceof SVG.e0) {
                    SVG.e0 e0Var = (SVG.e0) l0Var;
                    if (e0Var.a() == null && ((f2 = e0Var.f()) == null || (!f2.isEmpty() && f2.contains(language)))) {
                        Set<String> h2 = e0Var.h();
                        if (h2 != null) {
                            if (l == null) {
                                Z();
                            }
                            if (!h2.isEmpty() && l.containsAll(h2)) {
                            }
                        }
                        Set<String> e3 = e0Var.e();
                        if (e3 != null) {
                            if (!e3.isEmpty() && e2 != null) {
                                for (String str : e3) {
                                    if (!e2.a(str)) {
                                        break;
                                    }
                                }
                            }
                        }
                        Set<String> m = e0Var.m();
                        if (m != null) {
                            if (!m.isEmpty() && e2 != null) {
                                for (String str2 : m) {
                                    if (e2.b(str2, this.f27970f.f27999e.u.intValue(), String.valueOf(this.f27970f.f27999e.v)) == null) {
                                        break;
                                    }
                                }
                            }
                        }
                        A0(l0Var);
                        return;
                    }
                }
            }
        }
    }

    public final void L(SVG.j jVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, jVar, str) == null) {
            SVG.l0 n = jVar.a.n(str);
            if (n == null) {
                Z0("Gradient reference '%s' not found", str);
            } else if (!(n instanceof SVG.j)) {
                J("Gradient href attributes must point to other gradient elements", new Object[0]);
            } else if (n == jVar) {
                J("Circular reference in gradient href attribute '%s'", str);
            } else {
                SVG.j jVar2 = (SVG.j) n;
                if (jVar.f54832i == null) {
                    jVar.f54832i = jVar2.f54832i;
                }
                if (jVar.f54833j == null) {
                    jVar.f54833j = jVar2.f54833j;
                }
                if (jVar.f54834k == null) {
                    jVar.f54834k = jVar2.f54834k;
                }
                if (jVar.f54831h.isEmpty()) {
                    jVar.f54831h = jVar2.f54831h;
                }
                try {
                    if (jVar instanceof SVG.k0) {
                        M((SVG.k0) jVar, (SVG.k0) n);
                    } else {
                        N((SVG.o0) jVar, (SVG.o0) n);
                    }
                } catch (ClassCastException unused) {
                }
                String str2 = jVar2.l;
                if (str2 != null) {
                    L(jVar, str2);
                }
            }
        }
    }

    public final void L0(SVG.x0 x0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, x0Var) == null) {
            C("TextPath render", new Object[0]);
            W0(this.f27970f, x0Var);
            if (E() && Y0()) {
                SVG.l0 n = x0Var.a.n(x0Var.n);
                if (n == null) {
                    J("TextPath reference '%s' not found", x0Var.n);
                    return;
                }
                SVG.u uVar = (SVG.u) n;
                Path f2 = new d(this, uVar.o).f();
                Matrix matrix = uVar.n;
                if (matrix != null) {
                    f2.transform(matrix);
                }
                PathMeasure pathMeasure = new PathMeasure(f2, false);
                SVG.o oVar = x0Var.o;
                float e2 = oVar != null ? oVar.e(this, pathMeasure.getLength()) : 0.0f;
                SVG.Style.TextAnchor S = S();
                if (S != SVG.Style.TextAnchor.Start) {
                    float r = r(x0Var);
                    if (S == SVG.Style.TextAnchor.Middle) {
                        r /= 2.0f;
                    }
                    e2 -= r;
                }
                v((SVG.i0) x0Var.c());
                boolean n0 = n0();
                I(x0Var, new e(this, f2, e2, 0.0f));
                if (n0) {
                    k0(x0Var);
                }
            }
        }
    }

    public final void M(SVG.k0 k0Var, SVG.k0 k0Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, k0Var, k0Var2) == null) {
            if (k0Var.m == null) {
                k0Var.m = k0Var2.m;
            }
            if (k0Var.n == null) {
                k0Var.n = k0Var2.n;
            }
            if (k0Var.o == null) {
                k0Var.o = k0Var2.o;
            }
            if (k0Var.p == null) {
                k0Var.p = k0Var2.p;
            }
        }
    }

    public final boolean M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            h hVar = this.f27970f;
            if (hVar.f27999e.K != null && !hVar.m) {
                Z0("Masks are not supported when using getPicture()", new Object[0]);
            }
            if (this.f27970f.f27999e.q.floatValue() >= 1.0f) {
                h hVar2 = this.f27970f;
                if (hVar2.f27999e.K == null || !hVar2.m) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void N(SVG.o0 o0Var, SVG.o0 o0Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, o0Var, o0Var2) == null) {
            if (o0Var.m == null) {
                o0Var.m = o0Var2.m;
            }
            if (o0Var.n == null) {
                o0Var.n = o0Var2.n;
            }
            if (o0Var.o == null) {
                o0Var.o = o0Var2.o;
            }
            if (o0Var.p == null) {
                o0Var.p = o0Var2.p;
            }
            if (o0Var.q == null) {
                o0Var.q = o0Var2.q;
            }
        }
    }

    public final void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f27970f = new h(this);
            this.f27971g = new Stack<>();
            V0(this.f27970f, SVG.Style.a());
            h hVar = this.f27970f;
            hVar.f28004j = this.f27966b;
            hVar.l = false;
            hVar.m = this.f27968d;
            this.f27971g.push((h) hVar.clone());
            this.f27974j = new Stack<>();
            this.f27975k = new Stack<>();
            this.f27973i = new Stack<>();
            this.f27972h = new Stack<>();
        }
    }

    public final void O(SVG.x xVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, xVar, str) == null) {
            SVG.l0 n = xVar.a.n(str);
            if (n == null) {
                Z0("Pattern reference '%s' not found", str);
            } else if (!(n instanceof SVG.x)) {
                J("Pattern href attributes must point to other pattern elements", new Object[0]);
            } else if (n == xVar) {
                J("Circular reference in pattern href attribute '%s'", str);
            } else {
                SVG.x xVar2 = (SVG.x) n;
                if (xVar.p == null) {
                    xVar.p = xVar2.p;
                }
                if (xVar.q == null) {
                    xVar.q = xVar2.q;
                }
                if (xVar.r == null) {
                    xVar.r = xVar2.r;
                }
                if (xVar.s == null) {
                    xVar.s = xVar2.s;
                }
                if (xVar.t == null) {
                    xVar.t = xVar2.t;
                }
                if (xVar.u == null) {
                    xVar.u = xVar2.u;
                }
                if (xVar.v == null) {
                    xVar.v = xVar2.v;
                }
                if (xVar.f54823i.isEmpty()) {
                    xVar.f54823i = xVar2.f54823i;
                }
                if (xVar.o == null) {
                    xVar.o = xVar2.o;
                }
                if (xVar.n == null) {
                    xVar.n = xVar2.n;
                }
                String str2 = xVar2.w;
                if (str2 != null) {
                    O(xVar, str2);
                }
            }
        }
    }

    public final void O0(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            float f6 = f4 + f2;
            float f7 = f5 + f3;
            SVG.c cVar = this.f27970f.f27999e.A;
            if (cVar != null) {
                f2 += cVar.f54819d.f(this);
                f3 += this.f27970f.f27999e.A.a.g(this);
                f6 -= this.f27970f.f27999e.A.f54817b.f(this);
                f7 -= this.f27970f.f27999e.A.f54818c.g(this);
            }
            this.a.clipRect(f2, f3, f6, f7);
        }
    }

    public final void P(SVG.i0 i0Var, Path path, SVG.x xVar) {
        float f2;
        float f3;
        float f4;
        float f5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048604, this, i0Var, path, xVar) == null) {
            Boolean bool = xVar.p;
            boolean z = bool != null && bool.booleanValue();
            String str = xVar.w;
            if (str != null) {
                O(xVar, str);
            }
            if (z) {
                SVG.o oVar = xVar.s;
                f2 = oVar != null ? oVar.f(this) : 0.0f;
                SVG.o oVar2 = xVar.t;
                f4 = oVar2 != null ? oVar2.g(this) : 0.0f;
                SVG.o oVar3 = xVar.u;
                f5 = oVar3 != null ? oVar3.f(this) : 0.0f;
                SVG.o oVar4 = xVar.v;
                f3 = oVar4 != null ? oVar4.g(this) : 0.0f;
            } else {
                SVG.o oVar5 = xVar.s;
                float e2 = oVar5 != null ? oVar5.e(this, 1.0f) : 0.0f;
                SVG.o oVar6 = xVar.t;
                float e3 = oVar6 != null ? oVar6.e(this, 1.0f) : 0.0f;
                SVG.o oVar7 = xVar.u;
                float e4 = oVar7 != null ? oVar7.e(this, 1.0f) : 0.0f;
                SVG.o oVar8 = xVar.v;
                float e5 = oVar8 != null ? oVar8.e(this, 1.0f) : 0.0f;
                SVG.b bVar = i0Var.f54830h;
                float f6 = bVar.f54813e;
                float f7 = bVar.f54815g;
                f2 = (e2 * f7) + f6;
                float f8 = bVar.f54814f;
                float f9 = bVar.f54816h;
                float f10 = e4 * f7;
                f3 = e5 * f9;
                f4 = (e3 * f9) + f8;
                f5 = f10;
            }
            if (f5 == 0.0f || f3 == 0.0f) {
                return;
            }
            PreserveAspectRatio preserveAspectRatio = xVar.n;
            if (preserveAspectRatio == null) {
                preserveAspectRatio = PreserveAspectRatio.f54798d;
            }
            S0();
            this.a.clipPath(path);
            h hVar = new h(this);
            V0(hVar, SVG.Style.a());
            hVar.f27999e.z = Boolean.FALSE;
            R(xVar, hVar);
            this.f27970f = hVar;
            SVG.b bVar2 = i0Var.f54830h;
            Matrix matrix = xVar.r;
            if (matrix != null) {
                this.a.concat(matrix);
                Matrix matrix2 = new Matrix();
                if (xVar.r.invert(matrix2)) {
                    SVG.b bVar3 = i0Var.f54830h;
                    SVG.b bVar4 = i0Var.f54830h;
                    SVG.b bVar5 = i0Var.f54830h;
                    float[] fArr = {bVar3.f54813e, bVar3.f54814f, bVar3.b(), bVar4.f54814f, bVar4.b(), i0Var.f54830h.c(), bVar5.f54813e, bVar5.c()};
                    matrix2.mapPoints(fArr);
                    RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
                    for (int i2 = 2; i2 <= 6; i2 += 2) {
                        if (fArr[i2] < rectF.left) {
                            rectF.left = fArr[i2];
                        }
                        if (fArr[i2] > rectF.right) {
                            rectF.right = fArr[i2];
                        }
                        int i3 = i2 + 1;
                        if (fArr[i3] < rectF.top) {
                            rectF.top = fArr[i3];
                        }
                        if (fArr[i3] > rectF.bottom) {
                            rectF.bottom = fArr[i3];
                        }
                    }
                    float f11 = rectF.left;
                    float f12 = rectF.top;
                    bVar2 = new SVG.b(f11, f12, rectF.right - f11, rectF.bottom - f12);
                }
            }
            float floor = f2 + (((float) Math.floor((bVar2.f54813e - f2) / f5)) * f5);
            float b2 = bVar2.b();
            float c2 = bVar2.c();
            SVG.b bVar6 = new SVG.b(0.0f, 0.0f, f5, f3);
            for (float floor2 = f4 + (((float) Math.floor((bVar2.f54814f - f4) / f3)) * f3); floor2 < c2; floor2 += f3) {
                for (float f13 = floor; f13 < b2; f13 += f5) {
                    bVar6.f54813e = f13;
                    bVar6.f54814f = floor2;
                    S0();
                    if (!this.f27970f.f27999e.z.booleanValue()) {
                        O0(bVar6.f54813e, bVar6.f54814f, bVar6.f54815g, bVar6.f54816h);
                    }
                    SVG.b bVar7 = xVar.o;
                    if (bVar7 != null) {
                        this.a.concat(s(bVar6, bVar7, preserveAspectRatio));
                    } else {
                        Boolean bool2 = xVar.q;
                        boolean z2 = bool2 == null || bool2.booleanValue();
                        this.a.translate(f13, floor2);
                        if (!z2) {
                            Canvas canvas = this.a;
                            SVG.b bVar8 = i0Var.f54830h;
                            canvas.scale(bVar8.f54815g, bVar8.f54816h);
                        }
                    }
                    boolean n0 = n0();
                    for (SVG.l0 l0Var : xVar.f54823i) {
                        A0(l0Var);
                    }
                    if (n0) {
                        k0(xVar);
                    }
                    R0();
                }
            }
            R0();
        }
    }

    public final void P0(h hVar, boolean z, SVG.m0 m0Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{hVar, Boolean.valueOf(z), m0Var}) == null) {
            SVG.Style style = hVar.f27999e;
            float floatValue = (z ? style.f54807h : style.f54809j).floatValue();
            if (m0Var instanceof SVG.f) {
                i2 = ((SVG.f) m0Var).f54822e;
            } else if (!(m0Var instanceof SVG.g)) {
                return;
            } else {
                i2 = hVar.f27999e.r.f54822e;
            }
            int z2 = i2 | (z(floatValue) << 24);
            if (z) {
                hVar.f28002h.setColor(z2);
            } else {
                hVar.f28003i.setColor(z2);
            }
        }
    }

    public final h Q(SVG.l0 l0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, l0Var)) == null) {
            h hVar = new h(this);
            V0(hVar, SVG.Style.a());
            R(l0Var, hVar);
            return hVar;
        }
        return (h) invokeL.objValue;
    }

    public final void Q0(boolean z, SVG.b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048607, this, z, b0Var) == null) {
            if (z) {
                if (a0(b0Var.f54837e, 2147483648L)) {
                    h hVar = this.f27970f;
                    SVG.Style style = hVar.f27999e;
                    SVG.m0 m0Var = b0Var.f54837e.L;
                    style.f54805f = m0Var;
                    hVar.f28000f = m0Var != null;
                }
                if (a0(b0Var.f54837e, 4294967296L)) {
                    this.f27970f.f27999e.f54807h = b0Var.f54837e.M;
                }
                if (a0(b0Var.f54837e, 6442450944L)) {
                    h hVar2 = this.f27970f;
                    P0(hVar2, z, hVar2.f27999e.f54805f);
                    return;
                }
                return;
            }
            if (a0(b0Var.f54837e, 2147483648L)) {
                h hVar3 = this.f27970f;
                SVG.Style style2 = hVar3.f27999e;
                SVG.m0 m0Var2 = b0Var.f54837e.L;
                style2.f54808i = m0Var2;
                hVar3.f28001g = m0Var2 != null;
            }
            if (a0(b0Var.f54837e, 4294967296L)) {
                this.f27970f.f27999e.f54809j = b0Var.f54837e.M;
            }
            if (a0(b0Var.f54837e, 6442450944L)) {
                h hVar4 = this.f27970f;
                P0(hVar4, z, hVar4.f27999e.f54808i);
            }
        }
    }

    public final h R(SVG.l0 l0Var, h hVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048608, this, l0Var, hVar)) == null) {
            ArrayList<SVG.j0> arrayList = new ArrayList();
            while (true) {
                if (l0Var instanceof SVG.j0) {
                    arrayList.add(0, (SVG.j0) l0Var);
                }
                SVG.h0 h0Var = l0Var.f54840b;
                if (h0Var == null) {
                    break;
                }
                l0Var = (SVG.l0) h0Var;
            }
            for (SVG.j0 j0Var : arrayList) {
                W0(hVar, j0Var);
            }
            SVG.b bVar = this.f27969e.j().o;
            hVar.f28005k = bVar;
            if (bVar == null) {
                hVar.f28005k = this.f27966b;
            }
            hVar.f28004j = this.f27966b;
            hVar.m = this.f27970f.m;
            return hVar;
        }
        return (h) invokeLL.objValue;
    }

    public final void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.a.restore();
            this.f27970f = this.f27971g.pop();
        }
    }

    public final SVG.Style.TextAnchor S() {
        InterceptResult invokeV;
        SVG.Style.TextAnchor textAnchor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            SVG.Style style = this.f27970f.f27999e;
            if (style.x != SVG.Style.TextDirection.LTR && (textAnchor = style.y) != SVG.Style.TextAnchor.Middle) {
                SVG.Style.TextAnchor textAnchor2 = SVG.Style.TextAnchor.Start;
                return textAnchor == textAnchor2 ? SVG.Style.TextAnchor.End : textAnchor2;
            }
            return this.f27970f.f27999e.y;
        }
        return (SVG.Style.TextAnchor) invokeV.objValue;
    }

    public final void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.a.save();
            this.f27971g.push(this.f27970f);
            this.f27970f = (h) this.f27970f.clone();
        }
    }

    public final Path.FillType T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            SVG.Style.FillRule fillRule = this.f27970f.f27999e.J;
            if (fillRule == null) {
                return Path.FillType.WINDING;
            }
            if (a.f27978d[fillRule.ordinal()] != 1) {
                return Path.FillType.WINDING;
            }
            return Path.FillType.EVEN_ODD;
        }
        return (Path.FillType) invokeV.objValue;
    }

    public final String T0(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048613, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (this.f27970f.l) {
                return str.replaceAll("[\\n\\t]", " ");
            }
            String replaceAll = str.replaceAll("\\n", "").replaceAll("\\t", " ");
            if (z) {
                replaceAll = replaceAll.replaceAll("^\\s+", "");
            }
            if (z2) {
                replaceAll = replaceAll.replaceAll("\\s+$", "");
            }
            return replaceAll.replaceAll("\\s{2,}", " ");
        }
        return (String) invokeCommon.objValue;
    }

    public float U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f27970f.f28002h.getTextSize() : invokeV.floatValue;
    }

    public final void U0(SVG.i0 i0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, i0Var) == null) || i0Var.f54840b == null || i0Var.f54830h == null) {
            return;
        }
        Matrix matrix = new Matrix();
        if (this.f27973i.peek().invert(matrix)) {
            SVG.b bVar = i0Var.f54830h;
            SVG.b bVar2 = i0Var.f54830h;
            SVG.b bVar3 = i0Var.f54830h;
            float[] fArr = {bVar.f54813e, bVar.f54814f, bVar.b(), bVar2.f54814f, bVar2.b(), i0Var.f54830h.c(), bVar3.f54813e, bVar3.c()};
            matrix.preConcat(this.a.getMatrix());
            matrix.mapPoints(fArr);
            RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
            for (int i2 = 2; i2 <= 6; i2 += 2) {
                if (fArr[i2] < rectF.left) {
                    rectF.left = fArr[i2];
                }
                if (fArr[i2] > rectF.right) {
                    rectF.right = fArr[i2];
                }
                int i3 = i2 + 1;
                if (fArr[i3] < rectF.top) {
                    rectF.top = fArr[i3];
                }
                if (fArr[i3] > rectF.bottom) {
                    rectF.bottom = fArr[i3];
                }
            }
            SVG.i0 i0Var2 = (SVG.i0) this.f27972h.peek();
            SVG.b bVar4 = i0Var2.f54830h;
            if (bVar4 == null) {
                i0Var2.f54830h = SVG.b.a(rectF.left, rectF.top, rectF.right, rectF.bottom);
            } else {
                bVar4.e(SVG.b.a(rectF.left, rectF.top, rectF.right, rectF.bottom));
            }
        }
    }

    public float V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f27970f.f28002h.getTextSize() / 2.0f : invokeV.floatValue;
    }

    public final void V0(h hVar, SVG.Style style) {
        SVG svg;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048617, this, hVar, style) == null) {
            if (a0(style, 4096L)) {
                hVar.f27999e.r = style.r;
            }
            if (a0(style, 2048L)) {
                hVar.f27999e.q = style.q;
            }
            if (a0(style, 1L)) {
                hVar.f27999e.f54805f = style.f54805f;
                hVar.f28000f = style.f54805f != null;
            }
            if (a0(style, 4L)) {
                hVar.f27999e.f54807h = style.f54807h;
            }
            if (a0(style, 6149L)) {
                P0(hVar, true, hVar.f27999e.f54805f);
            }
            if (a0(style, 2L)) {
                hVar.f27999e.f54806g = style.f54806g;
            }
            if (a0(style, 8L)) {
                hVar.f27999e.f54808i = style.f54808i;
                hVar.f28001g = style.f54808i != null;
            }
            if (a0(style, 16L)) {
                hVar.f27999e.f54809j = style.f54809j;
            }
            if (a0(style, 6168L)) {
                P0(hVar, false, hVar.f27999e.f54808i);
            }
            if (a0(style, 34359738368L)) {
                hVar.f27999e.P = style.P;
            }
            if (a0(style, 32L)) {
                SVG.Style style2 = hVar.f27999e;
                SVG.o oVar = style.f54810k;
                style2.f54810k = oVar;
                hVar.f28003i.setStrokeWidth(oVar.c(this));
            }
            if (a0(style, 64L)) {
                hVar.f27999e.l = style.l;
                int i2 = a.f27976b[style.l.ordinal()];
                if (i2 == 1) {
                    hVar.f28003i.setStrokeCap(Paint.Cap.BUTT);
                } else if (i2 == 2) {
                    hVar.f28003i.setStrokeCap(Paint.Cap.ROUND);
                } else if (i2 == 3) {
                    hVar.f28003i.setStrokeCap(Paint.Cap.SQUARE);
                }
            }
            if (a0(style, 128L)) {
                hVar.f27999e.m = style.m;
                int i3 = a.f27977c[style.m.ordinal()];
                if (i3 == 1) {
                    hVar.f28003i.setStrokeJoin(Paint.Join.MITER);
                } else if (i3 == 2) {
                    hVar.f28003i.setStrokeJoin(Paint.Join.ROUND);
                } else if (i3 == 3) {
                    hVar.f28003i.setStrokeJoin(Paint.Join.BEVEL);
                }
            }
            if (a0(style, 256L)) {
                hVar.f27999e.n = style.n;
                hVar.f28003i.setStrokeMiter(style.n.floatValue());
            }
            if (a0(style, 512L)) {
                hVar.f27999e.o = style.o;
            }
            if (a0(style, 1024L)) {
                hVar.f27999e.p = style.p;
            }
            Typeface typeface = null;
            if (a0(style, 1536L)) {
                SVG.o[] oVarArr = hVar.f27999e.o;
                if (oVarArr == null) {
                    hVar.f28003i.setPathEffect(null);
                } else {
                    int length = oVarArr.length;
                    int i4 = length % 2 == 0 ? length : length * 2;
                    float[] fArr = new float[i4];
                    float f2 = 0.0f;
                    for (int i5 = 0; i5 < i4; i5++) {
                        fArr[i5] = hVar.f27999e.o[i5 % length].c(this);
                        f2 += fArr[i5];
                    }
                    if (f2 == 0.0f) {
                        hVar.f28003i.setPathEffect(null);
                    } else {
                        float c2 = hVar.f27999e.p.c(this);
                        if (c2 < 0.0f) {
                            c2 = (c2 % f2) + f2;
                        }
                        hVar.f28003i.setPathEffect(new DashPathEffect(fArr, c2));
                    }
                }
            }
            if (a0(style, 16384L)) {
                float U = U();
                hVar.f27999e.t = style.t;
                hVar.f28002h.setTextSize(style.t.e(this, U));
                hVar.f28003i.setTextSize(style.t.e(this, U));
            }
            if (a0(style, 8192L)) {
                hVar.f27999e.s = style.s;
            }
            if (a0(style, 32768L)) {
                if (style.u.intValue() == -1 && hVar.f27999e.u.intValue() > 100) {
                    SVG.Style style3 = hVar.f27999e;
                    style3.u = Integer.valueOf(style3.u.intValue() - 100);
                } else if (style.u.intValue() == 1 && hVar.f27999e.u.intValue() < 900) {
                    SVG.Style style4 = hVar.f27999e;
                    style4.u = Integer.valueOf(style4.u.intValue() + 100);
                } else {
                    hVar.f27999e.u = style.u;
                }
            }
            if (a0(style, 65536L)) {
                hVar.f27999e.v = style.v;
            }
            if (a0(style, 106496L)) {
                if (hVar.f27999e.s != null && (svg = this.f27969e) != null) {
                    c.c.a.d e2 = svg.e();
                    for (String str : hVar.f27999e.s) {
                        SVG.Style style5 = hVar.f27999e;
                        Typeface x = x(str, style5.u, style5.v);
                        if (x != null || e2 == null) {
                            typeface = x;
                            continue;
                        } else {
                            typeface = e2.b(str, hVar.f27999e.u.intValue(), String.valueOf(hVar.f27999e.v));
                            continue;
                        }
                        if (typeface != null) {
                            break;
                        }
                    }
                }
                if (typeface == null) {
                    SVG.Style style6 = hVar.f27999e;
                    typeface = x(TypefaceCompatApi28Impl.DEFAULT_FAMILY, style6.u, style6.v);
                }
                hVar.f28002h.setTypeface(typeface);
                hVar.f28003i.setTypeface(typeface);
            }
            if (a0(style, PlaybackStateCompat.ACTION_PREPARE_FROM_URI)) {
                hVar.f27999e.w = style.w;
                hVar.f28002h.setStrikeThruText(style.w == SVG.Style.TextDecoration.LineThrough);
                hVar.f28002h.setUnderlineText(style.w == SVG.Style.TextDecoration.Underline);
                if (Build.VERSION.SDK_INT >= 17) {
                    hVar.f28003i.setStrikeThruText(style.w == SVG.Style.TextDecoration.LineThrough);
                    hVar.f28003i.setUnderlineText(style.w == SVG.Style.TextDecoration.Underline);
                }
            }
            if (a0(style, 68719476736L)) {
                hVar.f27999e.x = style.x;
            }
            if (a0(style, PlaybackStateCompat.ACTION_SET_REPEAT_MODE)) {
                hVar.f27999e.y = style.y;
            }
            if (a0(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED)) {
                hVar.f27999e.z = style.z;
            }
            if (a0(style, 2097152L)) {
                hVar.f27999e.B = style.B;
            }
            if (a0(style, 4194304L)) {
                hVar.f27999e.C = style.C;
            }
            if (a0(style, 8388608L)) {
                hVar.f27999e.D = style.D;
            }
            if (a0(style, 16777216L)) {
                hVar.f27999e.E = style.E;
            }
            if (a0(style, 33554432L)) {
                hVar.f27999e.F = style.F;
            }
            if (a0(style, 1048576L)) {
                hVar.f27999e.A = style.A;
            }
            if (a0(style, AccountConstants.TYPE_MODIFY_NICKNAME)) {
                hVar.f27999e.I = style.I;
            }
            if (a0(style, 536870912L)) {
                hVar.f27999e.J = style.J;
            }
            if (a0(style, 1073741824L)) {
                hVar.f27999e.K = style.K;
            }
            if (a0(style, 67108864L)) {
                hVar.f27999e.G = style.G;
            }
            if (a0(style, 134217728L)) {
                hVar.f27999e.H = style.H;
            }
            if (a0(style, AnimatedStateListDrawableCompat.AnimatedStateListState.REVERSIBLE_FLAG_BIT)) {
                hVar.f27999e.N = style.N;
            }
            if (a0(style, 17179869184L)) {
                hVar.f27999e.O = style.O;
            }
        }
    }

    public SVG.b W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            h hVar = this.f27970f;
            SVG.b bVar = hVar.f28005k;
            return bVar != null ? bVar : hVar.f28004j;
        }
        return (SVG.b) invokeV.objValue;
    }

    public final void W0(h hVar, SVG.j0 j0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, hVar, j0Var) == null) {
            hVar.f27999e.b(j0Var.f54840b == null);
            SVG.Style style = j0Var.f54837e;
            if (style != null) {
                V0(hVar, style);
            }
            if (this.f27969e.k()) {
                for (CSSParser.d dVar : this.f27969e.b()) {
                    if (CSSParser.m(dVar.a, j0Var)) {
                        V0(hVar, dVar.f54792b);
                    }
                }
            }
            SVG.Style style2 = j0Var.f54838f;
            if (style2 != null) {
                V0(hVar, style2);
            }
        }
    }

    public float X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.f27967c : invokeV.floatValue;
    }

    public final void X0() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            SVG.Style style = this.f27970f.f27999e;
            SVG.m0 m0Var = style.N;
            if (m0Var instanceof SVG.f) {
                i2 = ((SVG.f) m0Var).f54822e;
            } else if (!(m0Var instanceof SVG.g)) {
                return;
            } else {
                i2 = style.r.f54822e;
            }
            Float f2 = this.f27970f.f27999e.O;
            if (f2 != null) {
                i2 |= z(f2.floatValue()) << 24;
            }
            this.a.drawColor(i2);
        }
    }

    public final Path.FillType Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            SVG.Style.FillRule fillRule = this.f27970f.f27999e.f54806g;
            if (fillRule == null) {
                return Path.FillType.WINDING;
            }
            if (a.f27978d[fillRule.ordinal()] != 1) {
                return Path.FillType.WINDING;
            }
            return Path.FillType.EVEN_ODD;
        }
        return (Path.FillType) invokeV.objValue;
    }

    public final boolean Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            Boolean bool = this.f27970f.f27999e.F;
            if (bool != null) {
                return bool.booleanValue();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean a0(SVG.Style style, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048624, this, style, j2)) == null) ? (style.f54804e & j2) != 0 : invokeLJ.booleanValue;
    }

    public final void b0(boolean z, SVG.b bVar, SVG.k0 k0Var) {
        float e2;
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{Boolean.valueOf(z), bVar, k0Var}) == null) {
            String str = k0Var.l;
            if (str != null) {
                L(k0Var, str);
            }
            Boolean bool = k0Var.f54832i;
            int i2 = 0;
            boolean z2 = bool != null && bool.booleanValue();
            h hVar = this.f27970f;
            Paint paint = z ? hVar.f28002h : hVar.f28003i;
            if (z2) {
                SVG.b W = W();
                SVG.o oVar = k0Var.m;
                float f5 = oVar != null ? oVar.f(this) : 0.0f;
                SVG.o oVar2 = k0Var.n;
                float g2 = oVar2 != null ? oVar2.g(this) : 0.0f;
                SVG.o oVar3 = k0Var.o;
                float f6 = oVar3 != null ? oVar3.f(this) : W.f54815g;
                SVG.o oVar4 = k0Var.p;
                e2 = oVar4 != null ? oVar4.g(this) : 0.0f;
                f4 = f6;
                f2 = f5;
                f3 = g2;
            } else {
                SVG.o oVar5 = k0Var.m;
                float e3 = oVar5 != null ? oVar5.e(this, 1.0f) : 0.0f;
                SVG.o oVar6 = k0Var.n;
                float e4 = oVar6 != null ? oVar6.e(this, 1.0f) : 0.0f;
                SVG.o oVar7 = k0Var.o;
                float e5 = oVar7 != null ? oVar7.e(this, 1.0f) : 1.0f;
                SVG.o oVar8 = k0Var.p;
                e2 = oVar8 != null ? oVar8.e(this, 1.0f) : 0.0f;
                f2 = e3;
                f3 = e4;
                f4 = e5;
            }
            S0();
            this.f27970f = Q(k0Var);
            Matrix matrix = new Matrix();
            if (!z2) {
                matrix.preTranslate(bVar.f54813e, bVar.f54814f);
                matrix.preScale(bVar.f54815g, bVar.f54816h);
            }
            Matrix matrix2 = k0Var.f54833j;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            int size = k0Var.f54831h.size();
            if (size == 0) {
                R0();
                if (z) {
                    this.f27970f.f28000f = false;
                    return;
                } else {
                    this.f27970f.f28001g = false;
                    return;
                }
            }
            int[] iArr = new int[size];
            float[] fArr = new float[size];
            float f7 = -1.0f;
            Iterator<SVG.l0> it = k0Var.f54831h.iterator();
            while (it.hasNext()) {
                SVG.c0 c0Var = (SVG.c0) it.next();
                if (i2 != 0 && c0Var.f54820h.floatValue() < f7) {
                    fArr[i2] = f7;
                } else {
                    fArr[i2] = c0Var.f54820h.floatValue();
                    f7 = c0Var.f54820h.floatValue();
                }
                S0();
                W0(this.f27970f, c0Var);
                SVG.f fVar = (SVG.f) this.f27970f.f27999e.G;
                if (fVar == null) {
                    fVar = SVG.f.f54821f;
                }
                iArr[i2] = fVar.f54822e | (z(this.f27970f.f27999e.H.floatValue()) << 24);
                i2++;
                R0();
            }
            if ((f2 == f4 && f3 == e2) || size == 1) {
                R0();
                paint.setColor(iArr[size - 1]);
                return;
            }
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            SVG.GradientSpread gradientSpread = k0Var.f54834k;
            if (gradientSpread != null) {
                if (gradientSpread == SVG.GradientSpread.reflect) {
                    tileMode = Shader.TileMode.MIRROR;
                } else if (gradientSpread == SVG.GradientSpread.repeat) {
                    tileMode = Shader.TileMode.REPEAT;
                }
            }
            R0();
            LinearGradient linearGradient = new LinearGradient(f2, f3, f4, e2, iArr, fArr, tileMode);
            linearGradient.setLocalMatrix(matrix);
            paint.setShader(linearGradient);
        }
    }

    public final Path c0(SVG.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, dVar)) == null) {
            SVG.o oVar = dVar.o;
            float f2 = oVar != null ? oVar.f(this) : 0.0f;
            SVG.o oVar2 = dVar.p;
            float g2 = oVar2 != null ? oVar2.g(this) : 0.0f;
            float c2 = dVar.q.c(this);
            float f3 = f2 - c2;
            float f4 = g2 - c2;
            float f5 = f2 + c2;
            float f6 = g2 + c2;
            if (dVar.f54830h == null) {
                float f7 = 2.0f * c2;
                dVar.f54830h = new SVG.b(f3, f4, f7, f7);
            }
            float f8 = 0.5522848f * c2;
            Path path = new Path();
            path.moveTo(f2, f4);
            float f9 = f2 + f8;
            float f10 = g2 - f8;
            path.cubicTo(f9, f4, f5, f10, f5, g2);
            float f11 = g2 + f8;
            path.cubicTo(f5, f11, f9, f6, f2, f6);
            float f12 = f2 - f8;
            path.cubicTo(f12, f6, f3, f11, f3, g2);
            path.cubicTo(f3, f10, f12, f4, f2, f4);
            path.close();
            return path;
        }
        return (Path) invokeL.objValue;
    }

    public final Path d0(SVG.i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, iVar)) == null) {
            SVG.o oVar = iVar.o;
            float f2 = oVar != null ? oVar.f(this) : 0.0f;
            SVG.o oVar2 = iVar.p;
            float g2 = oVar2 != null ? oVar2.g(this) : 0.0f;
            float f3 = iVar.q.f(this);
            float g3 = iVar.r.g(this);
            float f4 = f2 - f3;
            float f5 = g2 - g3;
            float f6 = f2 + f3;
            float f7 = g2 + g3;
            if (iVar.f54830h == null) {
                iVar.f54830h = new SVG.b(f4, f5, f3 * 2.0f, 2.0f * g3);
            }
            float f8 = f3 * 0.5522848f;
            float f9 = 0.5522848f * g3;
            Path path = new Path();
            path.moveTo(f2, f5);
            float f10 = f2 + f8;
            float f11 = g2 - f9;
            path.cubicTo(f10, f5, f6, f11, f6, g2);
            float f12 = f9 + g2;
            path.cubicTo(f6, f12, f10, f7, f2, f7);
            float f13 = f2 - f8;
            path.cubicTo(f13, f7, f4, f12, f4, g2);
            path.cubicTo(f4, f11, f13, f5, f2, f5);
            path.close();
            return path;
        }
        return (Path) invokeL.objValue;
    }

    public final Path e0(SVG.p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, pVar)) == null) {
            SVG.o oVar = pVar.o;
            float f2 = oVar == null ? 0.0f : oVar.f(this);
            SVG.o oVar2 = pVar.p;
            float g2 = oVar2 == null ? 0.0f : oVar2.g(this);
            SVG.o oVar3 = pVar.q;
            float f3 = oVar3 == null ? 0.0f : oVar3.f(this);
            SVG.o oVar4 = pVar.r;
            float g3 = oVar4 != null ? oVar4.g(this) : 0.0f;
            if (pVar.f54830h == null) {
                pVar.f54830h = new SVG.b(Math.min(f2, g2), Math.min(g2, g3), Math.abs(f3 - f2), Math.abs(g3 - g2));
            }
            Path path = new Path();
            path.moveTo(f2, g2);
            path.lineTo(f3, g3);
            return path;
        }
        return (Path) invokeL.objValue;
    }

    public final Path f0(SVG.y yVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, yVar)) == null) {
            Path path = new Path();
            float[] fArr = yVar.o;
            path.moveTo(fArr[0], fArr[1]);
            int i2 = 2;
            while (true) {
                float[] fArr2 = yVar.o;
                if (i2 >= fArr2.length) {
                    break;
                }
                path.lineTo(fArr2[i2], fArr2[i2 + 1]);
                i2 += 2;
            }
            if (yVar instanceof SVG.z) {
                path.close();
            }
            if (yVar.f54830h == null) {
                yVar.f54830h = q(path);
            }
            path.setFillType(T());
            return path;
        }
        return (Path) invokeL.objValue;
    }

    public final Path g0(SVG.a0 a0Var) {
        InterceptResult invokeL;
        float f2;
        float g2;
        Path path;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, a0Var)) == null) {
            if (a0Var.s == null && a0Var.t == null) {
                f2 = 0.0f;
                g2 = 0.0f;
            } else {
                SVG.o oVar = a0Var.s;
                if (oVar == null) {
                    f2 = a0Var.t.g(this);
                } else if (a0Var.t == null) {
                    f2 = oVar.f(this);
                } else {
                    f2 = oVar.f(this);
                    g2 = a0Var.t.g(this);
                }
                g2 = f2;
            }
            float min = Math.min(f2, a0Var.q.f(this) / 2.0f);
            float min2 = Math.min(g2, a0Var.r.g(this) / 2.0f);
            SVG.o oVar2 = a0Var.o;
            float f3 = oVar2 != null ? oVar2.f(this) : 0.0f;
            SVG.o oVar3 = a0Var.p;
            float g3 = oVar3 != null ? oVar3.g(this) : 0.0f;
            float f4 = a0Var.q.f(this);
            float g4 = a0Var.r.g(this);
            if (a0Var.f54830h == null) {
                a0Var.f54830h = new SVG.b(f3, g3, f4, g4);
            }
            float f5 = f3 + f4;
            float f6 = g3 + g4;
            Path path2 = new Path();
            if (min != 0.0f && min2 != 0.0f) {
                float f7 = min * 0.5522848f;
                float f8 = 0.5522848f * min2;
                float f9 = g3 + min2;
                path2.moveTo(f3, f9);
                float f10 = f9 - f8;
                float f11 = f3 + min;
                float f12 = f11 - f7;
                path2.cubicTo(f3, f10, f12, g3, f11, g3);
                float f13 = f5 - min;
                path2.lineTo(f13, g3);
                float f14 = f13 + f7;
                path2.cubicTo(f14, g3, f5, f10, f5, f9);
                float f15 = f6 - min2;
                path2.lineTo(f5, f15);
                float f16 = f15 + f8;
                path = path2;
                path2.cubicTo(f5, f16, f14, f6, f13, f6);
                path.lineTo(f11, f6);
                path.cubicTo(f12, f6, f3, f16, f3, f15);
                path.lineTo(f3, f9);
            } else {
                path = path2;
                path.moveTo(f3, g3);
                path.lineTo(f5, g3);
                path.lineTo(f5, f6);
                path.lineTo(f3, f6);
                path.lineTo(f3, g3);
            }
            path.close();
            return path;
        }
        return (Path) invokeL.objValue;
    }

    public final void h(SVG.k kVar, Path path, Matrix matrix) {
        Path f0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048631, this, kVar, path, matrix) == null) {
            W0(this.f27970f, kVar);
            if (E() && Y0()) {
                Matrix matrix2 = kVar.n;
                if (matrix2 != null) {
                    matrix.preConcat(matrix2);
                }
                if (kVar instanceof SVG.a0) {
                    f0 = g0((SVG.a0) kVar);
                } else if (kVar instanceof SVG.d) {
                    f0 = c0((SVG.d) kVar);
                } else if (kVar instanceof SVG.i) {
                    f0 = d0((SVG.i) kVar);
                } else if (!(kVar instanceof SVG.y)) {
                    return;
                } else {
                    f0 = f0((SVG.y) kVar);
                }
                t(kVar);
                path.setFillType(f0.getFillType());
                path.addPath(f0, matrix);
            }
        }
    }

    public final void h0(boolean z, SVG.b bVar, SVG.o0 o0Var) {
        float f2;
        float e2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{Boolean.valueOf(z), bVar, o0Var}) == null) {
            String str = o0Var.l;
            if (str != null) {
                L(o0Var, str);
            }
            Boolean bool = o0Var.f54832i;
            int i2 = 0;
            boolean z2 = bool != null && bool.booleanValue();
            h hVar = this.f27970f;
            Paint paint = z ? hVar.f28002h : hVar.f28003i;
            if (z2) {
                SVG.o oVar = new SVG.o(50.0f, SVG.Unit.percent);
                SVG.o oVar2 = o0Var.m;
                float f4 = oVar2 != null ? oVar2.f(this) : oVar.f(this);
                SVG.o oVar3 = o0Var.n;
                float g2 = oVar3 != null ? oVar3.g(this) : oVar.g(this);
                SVG.o oVar4 = o0Var.o;
                e2 = oVar4 != null ? oVar4.c(this) : oVar.c(this);
                f2 = f4;
                f3 = g2;
            } else {
                SVG.o oVar5 = o0Var.m;
                float e3 = oVar5 != null ? oVar5.e(this, 1.0f) : 0.5f;
                SVG.o oVar6 = o0Var.n;
                float e4 = oVar6 != null ? oVar6.e(this, 1.0f) : 0.5f;
                SVG.o oVar7 = o0Var.o;
                f2 = e3;
                e2 = oVar7 != null ? oVar7.e(this, 1.0f) : 0.5f;
                f3 = e4;
            }
            S0();
            this.f27970f = Q(o0Var);
            Matrix matrix = new Matrix();
            if (!z2) {
                matrix.preTranslate(bVar.f54813e, bVar.f54814f);
                matrix.preScale(bVar.f54815g, bVar.f54816h);
            }
            Matrix matrix2 = o0Var.f54833j;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            int size = o0Var.f54831h.size();
            if (size == 0) {
                R0();
                if (z) {
                    this.f27970f.f28000f = false;
                    return;
                } else {
                    this.f27970f.f28001g = false;
                    return;
                }
            }
            int[] iArr = new int[size];
            float[] fArr = new float[size];
            float f5 = -1.0f;
            Iterator<SVG.l0> it = o0Var.f54831h.iterator();
            while (it.hasNext()) {
                SVG.c0 c0Var = (SVG.c0) it.next();
                if (i2 != 0 && c0Var.f54820h.floatValue() < f5) {
                    fArr[i2] = f5;
                } else {
                    fArr[i2] = c0Var.f54820h.floatValue();
                    f5 = c0Var.f54820h.floatValue();
                }
                S0();
                W0(this.f27970f, c0Var);
                SVG.f fVar = (SVG.f) this.f27970f.f27999e.G;
                if (fVar == null) {
                    fVar = SVG.f.f54821f;
                }
                iArr[i2] = fVar.f54822e | (z(this.f27970f.f27999e.H.floatValue()) << 24);
                i2++;
                R0();
            }
            if (e2 != 0.0f && size != 1) {
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                SVG.GradientSpread gradientSpread = o0Var.f54834k;
                if (gradientSpread != null) {
                    if (gradientSpread == SVG.GradientSpread.reflect) {
                        tileMode = Shader.TileMode.MIRROR;
                    } else if (gradientSpread == SVG.GradientSpread.repeat) {
                        tileMode = Shader.TileMode.REPEAT;
                    }
                }
                R0();
                RadialGradient radialGradient = new RadialGradient(f2, f3, e2, iArr, fArr, tileMode);
                radialGradient.setLocalMatrix(matrix);
                paint.setShader(radialGradient);
                return;
            }
            R0();
            paint.setColor(iArr[size - 1]);
        }
    }

    public final void i(SVG.u uVar, Path path, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048633, this, uVar, path, matrix) == null) {
            W0(this.f27970f, uVar);
            if (E() && Y0()) {
                Matrix matrix2 = uVar.n;
                if (matrix2 != null) {
                    matrix.preConcat(matrix2);
                }
                Path f2 = new d(this, uVar.o).f();
                if (uVar.f54830h == null) {
                    uVar.f54830h = q(f2);
                }
                t(uVar);
                path.setFillType(T());
                path.addPath(f2, matrix);
            }
        }
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            this.f27972h.pop();
            this.f27973i.pop();
        }
    }

    public final void j(SVG.l0 l0Var, boolean z, Path path, Matrix matrix) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048635, this, new Object[]{l0Var, Boolean.valueOf(z), path, matrix}) == null) && E()) {
            B();
            if (l0Var instanceof SVG.b1) {
                if (z) {
                    l((SVG.b1) l0Var, path, matrix);
                } else {
                    J("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
                }
            } else if (l0Var instanceof SVG.u) {
                i((SVG.u) l0Var, path, matrix);
            } else if (l0Var instanceof SVG.u0) {
                k((SVG.u0) l0Var, path, matrix);
            } else if (l0Var instanceof SVG.k) {
                h((SVG.k) l0Var, path, matrix);
            } else {
                J("Invalid %s element found in clipPath definition", l0Var.getClass().getSimpleName());
            }
            A();
        }
    }

    public final void j0(SVG.h0 h0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, h0Var) == null) {
            this.f27972h.push(h0Var);
            this.f27973i.push(this.a.getMatrix());
        }
    }

    public final void k(SVG.u0 u0Var, Path path, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048637, this, u0Var, path, matrix) == null) {
            W0(this.f27970f, u0Var);
            if (E()) {
                Matrix matrix2 = u0Var.r;
                if (matrix2 != null) {
                    matrix.preConcat(matrix2);
                }
                List<SVG.o> list = u0Var.n;
                float f2 = 0.0f;
                float f3 = (list == null || list.size() == 0) ? 0.0f : u0Var.n.get(0).f(this);
                List<SVG.o> list2 = u0Var.o;
                float g2 = (list2 == null || list2.size() == 0) ? 0.0f : u0Var.o.get(0).g(this);
                List<SVG.o> list3 = u0Var.p;
                float f4 = (list3 == null || list3.size() == 0) ? 0.0f : u0Var.p.get(0).f(this);
                List<SVG.o> list4 = u0Var.q;
                if (list4 != null && list4.size() != 0) {
                    f2 = u0Var.q.get(0).g(this);
                }
                if (this.f27970f.f27999e.y != SVG.Style.TextAnchor.Start) {
                    float r = r(u0Var);
                    if (this.f27970f.f27999e.y == SVG.Style.TextAnchor.Middle) {
                        r /= 2.0f;
                    }
                    f3 -= r;
                }
                if (u0Var.f54830h == null) {
                    i iVar = new i(this, f3, g2);
                    I(u0Var, iVar);
                    RectF rectF = iVar.f28007c;
                    u0Var.f54830h = new SVG.b(rectF.left, rectF.top, rectF.width(), iVar.f28007c.height());
                }
                t(u0Var);
                Path path2 = new Path();
                I(u0Var, new g(this, f3 + f4, g2 + f2, path2));
                path.setFillType(T());
                path.addPath(path2, matrix);
            }
        }
    }

    public final void k0(SVG.i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, i0Var) == null) {
            h hVar = this.f27970f;
            String str = hVar.f27999e.K;
            if (str != null && hVar.m) {
                SVG.l0 n = this.f27969e.n(str);
                H();
                J0((SVG.r) n, i0Var);
                Bitmap l0 = l0();
                Canvas pop = this.f27974j.pop();
                this.a = pop;
                pop.save();
                this.a.setMatrix(new Matrix());
                this.a.drawBitmap(l0, 0.0f, 0.0f, this.f27970f.f28002h);
                l0.recycle();
                this.a.restore();
            }
            R0();
        }
    }

    public final void l(SVG.b1 b1Var, Path path, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048639, this, b1Var, path, matrix) == null) {
            W0(this.f27970f, b1Var);
            if (E() && Y0()) {
                Matrix matrix2 = b1Var.n;
                if (matrix2 != null) {
                    matrix.preConcat(matrix2);
                }
                SVG.l0 n = b1Var.a.n(b1Var.o);
                if (n == null) {
                    J("Use reference '%s' not found", b1Var.o);
                    return;
                }
                t(b1Var);
                j(n, false, path, matrix);
            }
        }
    }

    public final Bitmap l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            Bitmap pop = this.f27975k.pop();
            Bitmap pop2 = this.f27975k.pop();
            int width = pop.getWidth();
            int height = pop.getHeight();
            int[] iArr = new int[width];
            int[] iArr2 = new int[width];
            int i2 = 0;
            while (i2 < height) {
                pop.getPixels(iArr, 0, width, 0, i2, width, 1);
                int i3 = i2;
                pop2.getPixels(iArr2, 0, width, 0, i2, width, 1);
                for (int i4 = 0; i4 < width; i4++) {
                    int i5 = iArr[i4];
                    int i6 = i5 & 255;
                    int i7 = (i5 >> 8) & 255;
                    int i8 = (i5 >> 16) & 255;
                    int i9 = (i5 >> 24) & 255;
                    if (i9 == 0) {
                        iArr2[i4] = 0;
                    } else {
                        int i10 = iArr2[i4];
                        iArr2[i4] = (i10 & 16777215) | (((((i10 >> 24) & 255) * (((((i8 * 6963) + (i7 * 23442)) + (i6 * 2362)) * i9) / 8355840)) / 255) << 24);
                    }
                }
                pop2.setPixels(iArr2, 0, width, 0, i3, width, 1);
                i2 = i3 + 1;
            }
            pop.recycle();
            return pop2;
        }
        return (Bitmap) invokeV.objValue;
    }

    public final void m0(SVG.l0 l0Var, j jVar) {
        float f2;
        float f3;
        float f4;
        float f5;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048641, this, l0Var, jVar) == null) && jVar.a((SVG.w0) l0Var)) {
            if (l0Var instanceof SVG.x0) {
                S0();
                L0((SVG.x0) l0Var);
                R0();
            } else if (l0Var instanceof SVG.t0) {
                C("TSpan render", new Object[0]);
                S0();
                SVG.t0 t0Var = (SVG.t0) l0Var;
                W0(this.f27970f, t0Var);
                if (E()) {
                    boolean z = jVar instanceof f;
                    float f6 = 0.0f;
                    if (z) {
                        List<SVG.o> list = t0Var.n;
                        if (list != null && list.size() != 0) {
                            f5 = t0Var.n.get(0).f(this);
                        } else {
                            f5 = ((f) jVar).a;
                        }
                        List<SVG.o> list2 = t0Var.o;
                        if (list2 != null && list2.size() != 0) {
                            f3 = t0Var.o.get(0).g(this);
                        } else {
                            f3 = ((f) jVar).f27994b;
                        }
                        List<SVG.o> list3 = t0Var.p;
                        f4 = (list3 == null || list3.size() == 0) ? 0.0f : t0Var.p.get(0).f(this);
                        List<SVG.o> list4 = t0Var.q;
                        if (list4 != null && list4.size() != 0) {
                            f6 = t0Var.q.get(0).g(this);
                        }
                        f2 = f6;
                        f6 = f5;
                    } else {
                        f2 = 0.0f;
                        f3 = 0.0f;
                        f4 = 0.0f;
                    }
                    v((SVG.i0) t0Var.c());
                    if (z) {
                        f fVar = (f) jVar;
                        fVar.a = f6 + f4;
                        fVar.f27994b = f3 + f2;
                    }
                    boolean n0 = n0();
                    I(t0Var, jVar);
                    if (n0) {
                        k0(t0Var);
                    }
                }
                R0();
            } else if (l0Var instanceof SVG.s0) {
                S0();
                SVG.s0 s0Var = (SVG.s0) l0Var;
                W0(this.f27970f, s0Var);
                if (E()) {
                    v((SVG.i0) s0Var.c());
                    SVG.l0 n = l0Var.a.n(s0Var.n);
                    if (n == null || !(n instanceof SVG.w0)) {
                        J("Tref reference '%s' not found", s0Var.n);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        K((SVG.w0) n, sb);
                        if (sb.length() > 0) {
                            jVar.b(sb.toString());
                        }
                    }
                }
                R0();
            }
        }
    }

    public final boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            if (M0()) {
                this.a.saveLayerAlpha(null, z(this.f27970f.f27999e.q.floatValue()), 31);
                this.f27971g.push(this.f27970f);
                h hVar = (h) this.f27970f.clone();
                this.f27970f = hVar;
                String str = hVar.f27999e.K;
                if (str != null && hVar.m) {
                    SVG.l0 n = this.f27969e.n(str);
                    if (n != null && (n instanceof SVG.r)) {
                        this.f27974j.push(this.a);
                        H();
                    } else {
                        J("Mask reference '%s' not found", this.f27970f.f27999e.K);
                        this.f27970f.f27999e.K = null;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final List<C1561c> o(SVG.p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, pVar)) == null) {
            SVG.o oVar = pVar.o;
            float f2 = oVar != null ? oVar.f(this) : 0.0f;
            SVG.o oVar2 = pVar.p;
            float g2 = oVar2 != null ? oVar2.g(this) : 0.0f;
            SVG.o oVar3 = pVar.q;
            float f3 = oVar3 != null ? oVar3.f(this) : 0.0f;
            SVG.o oVar4 = pVar.r;
            float g3 = oVar4 != null ? oVar4.g(this) : 0.0f;
            ArrayList arrayList = new ArrayList(2);
            float f4 = f3 - f2;
            float f5 = g3 - g2;
            arrayList.add(new C1561c(this, f2, g2, f4, f5));
            arrayList.add(new C1561c(this, f3, g3, f4, f5));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void o0(SVG.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, dVar) == null) {
            C("Circle render", new Object[0]);
            SVG.o oVar = dVar.q;
            if (oVar == null || oVar.i()) {
                return;
            }
            W0(this.f27970f, dVar);
            if (E() && Y0()) {
                Matrix matrix = dVar.n;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                Path c0 = c0(dVar);
                U0(dVar);
                v(dVar);
                t(dVar);
                boolean n0 = n0();
                if (this.f27970f.f28000f) {
                    F(dVar, c0);
                }
                if (this.f27970f.f28001g) {
                    G(c0);
                }
                if (n0) {
                    k0(dVar);
                }
            }
        }
    }

    public final List<C1561c> p(SVG.y yVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, yVar)) == null) {
            int length = yVar.o.length;
            int i2 = 2;
            if (length < 2) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            float[] fArr = yVar.o;
            C1561c c1561c = new C1561c(this, fArr[0], fArr[1], 0.0f, 0.0f);
            float f2 = 0.0f;
            float f3 = 0.0f;
            while (i2 < length) {
                float[] fArr2 = yVar.o;
                float f4 = fArr2[i2];
                float f5 = fArr2[i2 + 1];
                c1561c.a(f4, f5);
                arrayList.add(c1561c);
                i2 += 2;
                c1561c = new C1561c(this, f4, f5, f4 - c1561c.a, f5 - c1561c.f27987b);
                f3 = f5;
                f2 = f4;
            }
            if (yVar instanceof SVG.z) {
                float[] fArr3 = yVar.o;
                if (f2 != fArr3[0] && f3 != fArr3[1]) {
                    float f6 = fArr3[0];
                    float f7 = fArr3[1];
                    c1561c.a(f6, f7);
                    arrayList.add(c1561c);
                    C1561c c1561c2 = new C1561c(this, f6, f7, f6 - c1561c.a, f7 - c1561c.f27987b);
                    c1561c2.b((C1561c) arrayList.get(0));
                    arrayList.add(c1561c2);
                    arrayList.set(0, c1561c2);
                }
            } else {
                arrayList.add(c1561c);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void p0(SVG.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, iVar) == null) {
            C("Ellipse render", new Object[0]);
            SVG.o oVar = iVar.q;
            if (oVar == null || iVar.r == null || oVar.i() || iVar.r.i()) {
                return;
            }
            W0(this.f27970f, iVar);
            if (E() && Y0()) {
                Matrix matrix = iVar.n;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                Path d0 = d0(iVar);
                U0(iVar);
                v(iVar);
                t(iVar);
                boolean n0 = n0();
                if (this.f27970f.f28000f) {
                    F(iVar, d0);
                }
                if (this.f27970f.f28001g) {
                    G(d0);
                }
                if (n0) {
                    k0(iVar);
                }
            }
        }
    }

    public final SVG.b q(Path path) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, path)) == null) {
            RectF rectF = new RectF();
            path.computeBounds(rectF, true);
            return new SVG.b(rectF.left, rectF.top, rectF.width(), rectF.height());
        }
        return (SVG.b) invokeL.objValue;
    }

    public final void q0(SVG.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, lVar) == null) {
            C("Group render", new Object[0]);
            W0(this.f27970f, lVar);
            if (E()) {
                Matrix matrix = lVar.n;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                t(lVar);
                boolean n0 = n0();
                F0(lVar, true);
                if (n0) {
                    k0(lVar);
                }
                U0(lVar);
            }
        }
    }

    public final float r(SVG.w0 w0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, w0Var)) == null) {
            k kVar = new k(this, null);
            I(w0Var, kVar);
            return kVar.a;
        }
        return invokeL.floatValue;
    }

    public final void r0(SVG.n nVar) {
        SVG.o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, nVar) == null) {
            C("Image render", new Object[0]);
            SVG.o oVar2 = nVar.r;
            if (oVar2 == null || oVar2.i() || (oVar = nVar.s) == null || oVar.i() || nVar.o == null) {
                return;
            }
            PreserveAspectRatio preserveAspectRatio = nVar.n;
            if (preserveAspectRatio == null) {
                preserveAspectRatio = PreserveAspectRatio.f54798d;
            }
            Bitmap w = w(nVar.o);
            if (w == null) {
                c.c.a.d e2 = this.f27969e.e();
                if (e2 == null) {
                    return;
                }
                w = e2.c(nVar.o);
            }
            if (w == null) {
                J("Could not locate image '%s'", nVar.o);
                return;
            }
            W0(this.f27970f, nVar);
            if (E() && Y0()) {
                Matrix matrix = nVar.t;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                SVG.o oVar3 = nVar.p;
                float f2 = oVar3 != null ? oVar3.f(this) : 0.0f;
                SVG.o oVar4 = nVar.q;
                this.f27970f.f28004j = new SVG.b(f2, oVar4 != null ? oVar4.g(this) : 0.0f, nVar.r.f(this), nVar.s.f(this));
                if (!this.f27970f.f27999e.z.booleanValue()) {
                    SVG.b bVar = this.f27970f.f28004j;
                    O0(bVar.f54813e, bVar.f54814f, bVar.f54815g, bVar.f54816h);
                }
                SVG.b bVar2 = new SVG.b(0.0f, 0.0f, w.getWidth(), w.getHeight());
                nVar.f54830h = bVar2;
                this.a.concat(s(this.f27970f.f28004j, bVar2, preserveAspectRatio));
                U0(nVar);
                t(nVar);
                boolean n0 = n0();
                X0();
                this.a.drawBitmap(w, 0.0f, 0.0f, new Paint());
                if (n0) {
                    k0(nVar);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0088, code lost:
        if (r11 != 8) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Matrix s(SVG.b bVar, SVG.b bVar2, PreserveAspectRatio preserveAspectRatio) {
        InterceptResult invokeLLL;
        int i2;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048651, this, bVar, bVar2, preserveAspectRatio)) == null) {
            Matrix matrix = new Matrix();
            if (preserveAspectRatio != null && preserveAspectRatio.a() != null) {
                float f4 = bVar.f54815g / bVar2.f54815g;
                float f5 = bVar.f54816h / bVar2.f54816h;
                float f6 = -bVar2.f54813e;
                float f7 = -bVar2.f54814f;
                if (preserveAspectRatio.equals(PreserveAspectRatio.f54797c)) {
                    matrix.preTranslate(bVar.f54813e, bVar.f54814f);
                    matrix.preScale(f4, f5);
                    matrix.preTranslate(f6, f7);
                    return matrix;
                }
                float max = preserveAspectRatio.b() == PreserveAspectRatio.Scale.Slice ? Math.max(f4, f5) : Math.min(f4, f5);
                float f8 = bVar.f54815g / max;
                float f9 = bVar.f54816h / max;
                switch (a.a[preserveAspectRatio.a().ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        f3 = (bVar2.f54815g - f8) / 2.0f;
                        f6 -= f3;
                        i2 = a.a[preserveAspectRatio.a().ordinal()];
                        if (i2 != 2) {
                            if (i2 != 3) {
                                if (i2 != 5) {
                                    if (i2 != 6) {
                                        if (i2 != 7) {
                                            break;
                                        }
                                    }
                                }
                            }
                            f2 = bVar2.f54816h - f9;
                            f7 -= f2;
                            matrix.preTranslate(bVar.f54813e, bVar.f54814f);
                            matrix.preScale(max, max);
                            matrix.preTranslate(f6, f7);
                            break;
                        }
                        f2 = (bVar2.f54816h - f9) / 2.0f;
                        f7 -= f2;
                        matrix.preTranslate(bVar.f54813e, bVar.f54814f);
                        matrix.preScale(max, max);
                        matrix.preTranslate(f6, f7);
                    case 4:
                    case 5:
                    case 6:
                        f3 = bVar2.f54815g - f8;
                        f6 -= f3;
                        i2 = a.a[preserveAspectRatio.a().ordinal()];
                        if (i2 != 2) {
                        }
                        f2 = (bVar2.f54816h - f9) / 2.0f;
                        f7 -= f2;
                        matrix.preTranslate(bVar.f54813e, bVar.f54814f);
                        matrix.preScale(max, max);
                        matrix.preTranslate(f6, f7);
                        break;
                    default:
                        i2 = a.a[preserveAspectRatio.a().ordinal()];
                        if (i2 != 2) {
                        }
                        f2 = (bVar2.f54816h - f9) / 2.0f;
                        f7 -= f2;
                        matrix.preTranslate(bVar.f54813e, bVar.f54814f);
                        matrix.preScale(max, max);
                        matrix.preTranslate(f6, f7);
                        break;
                }
            }
            return matrix;
        }
        return (Matrix) invokeLLL.objValue;
    }

    public final void s0(SVG.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, pVar) == null) {
            C("Line render", new Object[0]);
            W0(this.f27970f, pVar);
            if (E() && Y0() && this.f27970f.f28001g) {
                Matrix matrix = pVar.n;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                Path e0 = e0(pVar);
                U0(pVar);
                v(pVar);
                t(pVar);
                boolean n0 = n0();
                G(e0);
                I0(pVar);
                if (n0) {
                    k0(pVar);
                }
            }
        }
    }

    public final void t(SVG.i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, i0Var) == null) {
            u(i0Var, i0Var.f54830h);
        }
    }

    public final void t0(SVG.u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, uVar) == null) {
            C("Path render", new Object[0]);
            if (uVar.o == null) {
                return;
            }
            W0(this.f27970f, uVar);
            if (E() && Y0()) {
                h hVar = this.f27970f;
                if (hVar.f28001g || hVar.f28000f) {
                    Matrix matrix = uVar.n;
                    if (matrix != null) {
                        this.a.concat(matrix);
                    }
                    Path f2 = new d(this, uVar.o).f();
                    if (uVar.f54830h == null) {
                        uVar.f54830h = q(f2);
                    }
                    U0(uVar);
                    v(uVar);
                    t(uVar);
                    boolean n0 = n0();
                    if (this.f27970f.f28000f) {
                        f2.setFillType(Y());
                        F(uVar, f2);
                    }
                    if (this.f27970f.f28001g) {
                        G(f2);
                    }
                    I0(uVar);
                    if (n0) {
                        k0(uVar);
                    }
                }
            }
        }
    }

    public final void u(SVG.i0 i0Var, SVG.b bVar) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048655, this, i0Var, bVar) == null) || (str = this.f27970f.f27999e.I) == null) {
            return;
        }
        SVG.l0 n = i0Var.a.n(str);
        if (n == null) {
            J("ClipPath reference '%s' not found", this.f27970f.f27999e.I);
            return;
        }
        SVG.e eVar = (SVG.e) n;
        if (eVar.f54823i.isEmpty()) {
            this.a.clipRect(0, 0, 0, 0);
            return;
        }
        Boolean bool = eVar.o;
        boolean z = bool == null || bool.booleanValue();
        if ((i0Var instanceof SVG.l) && !z) {
            Z0("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", i0Var.getClass().getSimpleName());
            return;
        }
        B();
        if (!z) {
            Matrix matrix = new Matrix();
            matrix.preTranslate(bVar.f54813e, bVar.f54814f);
            matrix.preScale(bVar.f54815g, bVar.f54816h);
            this.a.concat(matrix);
        }
        Matrix matrix2 = eVar.n;
        if (matrix2 != null) {
            this.a.concat(matrix2);
        }
        this.f27970f = Q(eVar);
        t(eVar);
        Path path = new Path();
        for (SVG.l0 l0Var : eVar.f54823i) {
            j(l0Var, true, path, new Matrix());
        }
        this.a.clipPath(path);
        A();
    }

    public final void u0(SVG.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, yVar) == null) {
            C("PolyLine render", new Object[0]);
            W0(this.f27970f, yVar);
            if (E() && Y0()) {
                h hVar = this.f27970f;
                if (hVar.f28001g || hVar.f28000f) {
                    Matrix matrix = yVar.n;
                    if (matrix != null) {
                        this.a.concat(matrix);
                    }
                    if (yVar.o.length < 2) {
                        return;
                    }
                    Path f0 = f0(yVar);
                    U0(yVar);
                    v(yVar);
                    t(yVar);
                    boolean n0 = n0();
                    if (this.f27970f.f28000f) {
                        F(yVar, f0);
                    }
                    if (this.f27970f.f28001g) {
                        G(f0);
                    }
                    I0(yVar);
                    if (n0) {
                        k0(yVar);
                    }
                }
            }
        }
    }

    public final void v(SVG.i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, i0Var) == null) {
            SVG.m0 m0Var = this.f27970f.f27999e.f54805f;
            if (m0Var instanceof SVG.t) {
                D(true, i0Var.f54830h, (SVG.t) m0Var);
            }
            SVG.m0 m0Var2 = this.f27970f.f27999e.f54808i;
            if (m0Var2 instanceof SVG.t) {
                D(false, i0Var.f54830h, (SVG.t) m0Var2);
            }
        }
    }

    public final void v0(SVG.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, zVar) == null) {
            C("Polygon render", new Object[0]);
            W0(this.f27970f, zVar);
            if (E() && Y0()) {
                h hVar = this.f27970f;
                if (hVar.f28001g || hVar.f28000f) {
                    Matrix matrix = zVar.n;
                    if (matrix != null) {
                        this.a.concat(matrix);
                    }
                    if (zVar.o.length < 2) {
                        return;
                    }
                    Path f0 = f0(zVar);
                    U0(zVar);
                    v(zVar);
                    t(zVar);
                    boolean n0 = n0();
                    if (this.f27970f.f28000f) {
                        F(zVar, f0);
                    }
                    if (this.f27970f.f28001g) {
                        G(f0);
                    }
                    I0(zVar);
                    if (n0) {
                        k0(zVar);
                    }
                }
            }
        }
    }

    public final Bitmap w(String str) {
        InterceptResult invokeL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048659, this, str)) == null) {
            if (str.startsWith(WebGLImageLoader.DATA_URL) && str.length() >= 14 && (indexOf = str.indexOf(44)) != -1 && indexOf >= 12 && DataUrlLoader.BASE64_TAG.equals(str.substring(indexOf - 7, indexOf))) {
                byte[] decode = Base64.decode(str.substring(indexOf + 1), 0);
                return BitmapFactory.decodeByteArray(decode, 0, decode.length);
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    public final void w0(SVG.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, a0Var) == null) {
            C("Rect render", new Object[0]);
            SVG.o oVar = a0Var.q;
            if (oVar == null || a0Var.r == null || oVar.i() || a0Var.r.i()) {
                return;
            }
            W0(this.f27970f, a0Var);
            if (E() && Y0()) {
                Matrix matrix = a0Var.n;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                Path g0 = g0(a0Var);
                U0(a0Var);
                v(a0Var);
                t(a0Var);
                boolean n0 = n0();
                if (this.f27970f.f28000f) {
                    F(a0Var, g0);
                }
                if (this.f27970f.f28001g) {
                    G(g0);
                }
                if (n0) {
                    k0(a0Var);
                }
            }
        }
    }

    public final Typeface x(String str, Integer num, SVG.Style.FontStyle fontStyle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048661, this, str, num, fontStyle)) == null) {
            int i2 = 1;
            boolean z = fontStyle == SVG.Style.FontStyle.Italic;
            if (num.intValue() <= 500) {
                i2 = z ? 2 : 0;
            } else if (z) {
                i2 = 3;
            }
            if (str.equals("serif")) {
                return Typeface.create(Typeface.SERIF, i2);
            }
            if (str.equals(TypefaceCompatApi28Impl.DEFAULT_FAMILY)) {
                return Typeface.create(Typeface.SANS_SERIF, i2);
            }
            if (str.equals("monospace")) {
                return Typeface.create(Typeface.MONOSPACE, i2);
            }
            if (str.equals("cursive")) {
                return Typeface.create(Typeface.SANS_SERIF, i2);
            }
            if (str.equals("fantasy")) {
                return Typeface.create(Typeface.SANS_SERIF, i2);
            }
            return null;
        }
        return (Typeface) invokeLLL.objValue;
    }

    public final void x0(SVG.d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, d0Var) == null) {
            y0(d0Var, d0Var.r, d0Var.s);
        }
    }

    public final void y(SVG.l0 l0Var) {
        Boolean bool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048663, this, l0Var) == null) && (l0Var instanceof SVG.j0) && (bool = ((SVG.j0) l0Var).f54836d) != null) {
            this.f27970f.l = bool.booleanValue();
        }
    }

    public final void y0(SVG.d0 d0Var, SVG.o oVar, SVG.o oVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048664, this, d0Var, oVar, oVar2) == null) {
            z0(d0Var, oVar, oVar2, d0Var.o, d0Var.n);
        }
    }

    public final int z(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048665, this, f2)) == null) {
            int i2 = (int) (f2 * 256.0f);
            if (i2 < 0) {
                return 0;
            }
            if (i2 > 255) {
                return 255;
            }
            return i2;
        }
        return invokeF.intValue;
    }

    public final void z0(SVG.d0 d0Var, SVG.o oVar, SVG.o oVar2, SVG.b bVar, PreserveAspectRatio preserveAspectRatio) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048666, this, d0Var, oVar, oVar2, bVar, preserveAspectRatio) == null) {
            C("Svg render", new Object[0]);
            if (oVar == null || !oVar.i()) {
                if (oVar2 == null || !oVar2.i()) {
                    if (preserveAspectRatio == null && (preserveAspectRatio = d0Var.n) == null) {
                        preserveAspectRatio = PreserveAspectRatio.f54798d;
                    }
                    W0(this.f27970f, d0Var);
                    if (E()) {
                        if (d0Var.f54840b != null) {
                            SVG.o oVar3 = d0Var.p;
                            float f3 = oVar3 != null ? oVar3.f(this) : 0.0f;
                            SVG.o oVar4 = d0Var.q;
                            r1 = f3;
                            f2 = oVar4 != null ? oVar4.g(this) : 0.0f;
                        } else {
                            f2 = 0.0f;
                        }
                        SVG.b W = W();
                        this.f27970f.f28004j = new SVG.b(r1, f2, oVar != null ? oVar.f(this) : W.f54815g, oVar2 != null ? oVar2.g(this) : W.f54816h);
                        if (!this.f27970f.f27999e.z.booleanValue()) {
                            SVG.b bVar2 = this.f27970f.f28004j;
                            O0(bVar2.f54813e, bVar2.f54814f, bVar2.f54815g, bVar2.f54816h);
                        }
                        u(d0Var, this.f27970f.f28004j);
                        if (bVar != null) {
                            this.a.concat(s(this.f27970f.f28004j, bVar, preserveAspectRatio));
                            this.f27970f.f28005k = d0Var.o;
                        } else {
                            this.a.translate(r1, f2);
                        }
                        boolean n0 = n0();
                        X0();
                        F0(d0Var, true);
                        if (n0) {
                            k0(d0Var);
                        }
                        U0(d0Var);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f28009b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(c cVar) {
            super(cVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((c) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28009b = cVar;
            this.a = 0.0f;
        }

        @Override // c.c.a.c.j
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a += this.f28009b.f27970f.f28002h.measureText(str);
            }
        }

        public /* synthetic */ k(c cVar, a aVar) {
            this(cVar);
        }
    }
}
