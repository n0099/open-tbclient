package c.i.b.a.g0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float A;
    public float B;
    public int C;
    public int D;
    public int E;
    public int F;
    public StaticLayout G;
    public int H;
    public int I;
    public int J;
    public Rect K;

    /* renamed from: a  reason: collision with root package name */
    public final RectF f33708a;

    /* renamed from: b  reason: collision with root package name */
    public final float f33709b;

    /* renamed from: c  reason: collision with root package name */
    public final float f33710c;

    /* renamed from: d  reason: collision with root package name */
    public final float f33711d;

    /* renamed from: e  reason: collision with root package name */
    public final float f33712e;

    /* renamed from: f  reason: collision with root package name */
    public final float f33713f;

    /* renamed from: g  reason: collision with root package name */
    public final float f33714g;

    /* renamed from: h  reason: collision with root package name */
    public final TextPaint f33715h;

    /* renamed from: i  reason: collision with root package name */
    public final Paint f33716i;

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f33717j;
    public Layout.Alignment k;
    public Bitmap l;
    public float m;
    public int n;
    public int o;
    public float p;
    public int q;
    public float r;
    public float s;
    public boolean t;
    public boolean u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33708a = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{16843287, 16843288}, 0, 0);
        this.f33714g = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f33713f = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        float round = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.f33709b = round;
        this.f33710c = round;
        this.f33711d = round;
        this.f33712e = round;
        TextPaint textPaint = new TextPaint();
        this.f33715h = textPaint;
        textPaint.setAntiAlias(true);
        this.f33715h.setSubpixelText(true);
        Paint paint = new Paint();
        this.f33716i = paint;
        paint.setAntiAlias(true);
        this.f33716i.setStyle(Paint.Style.FILL);
    }

    public static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, charSequence, charSequence2)) == null) ? charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2)) : invokeLL.booleanValue;
    }

    public void b(c.i.b.a.e0.b bVar, boolean z, boolean z2, c.i.b.a.e0.a aVar, float f2, float f3, Canvas canvas, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{bVar, Boolean.valueOf(z), Boolean.valueOf(z2), aVar, Float.valueOf(f2), Float.valueOf(f3), canvas, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            boolean z3 = bVar.f33462g == null;
            int i6 = -16777216;
            if (z3) {
                if (TextUtils.isEmpty(bVar.f33460e)) {
                    return;
                }
                i6 = (bVar.o && z) ? bVar.p : aVar.f33456c;
            }
            if (a(this.f33717j, bVar.f33460e) && v.a(this.k, bVar.f33461f) && this.l == bVar.f33462g && this.m == bVar.f33463h && this.n == bVar.f33464i && v.a(Integer.valueOf(this.o), Integer.valueOf(bVar.f33465j)) && this.p == bVar.k && v.a(Integer.valueOf(this.q), Integer.valueOf(bVar.l)) && this.r == bVar.m && this.s == bVar.n && this.t == z && this.u == z2 && this.v == aVar.f33454a && this.w == aVar.f33455b && this.x == i6 && this.z == aVar.f33457d && this.y == aVar.f33458e && v.a(this.f33715h.getTypeface(), aVar.f33459f) && this.A == f2 && this.B == f3 && this.C == i2 && this.D == i3 && this.E == i4 && this.F == i5) {
                d(canvas, z3);
                return;
            }
            this.f33717j = bVar.f33460e;
            this.k = bVar.f33461f;
            this.l = bVar.f33462g;
            this.m = bVar.f33463h;
            this.n = bVar.f33464i;
            this.o = bVar.f33465j;
            this.p = bVar.k;
            this.q = bVar.l;
            this.r = bVar.m;
            this.s = bVar.n;
            this.t = z;
            this.u = z2;
            this.v = aVar.f33454a;
            this.w = aVar.f33455b;
            this.x = i6;
            this.z = aVar.f33457d;
            this.y = aVar.f33458e;
            this.f33715h.setTypeface(aVar.f33459f);
            this.A = f2;
            this.B = f3;
            this.C = i2;
            this.D = i3;
            this.E = i4;
            this.F = i5;
            if (z3) {
                g();
            } else {
                f();
            }
            d(canvas, z3);
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            canvas.drawBitmap(this.l, (Rect) null, this.K, (Paint) null);
        }
    }

    public final void d(Canvas canvas, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, canvas, z) == null) {
            if (z) {
                e(canvas);
            } else {
                c(canvas);
            }
        }
    }

    public final void e(Canvas canvas) {
        StaticLayout staticLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) || (staticLayout = this.G) == null) {
            return;
        }
        int save = canvas.save();
        canvas.translate(this.H, this.I);
        if (Color.alpha(this.x) > 0) {
            this.f33716i.setColor(this.x);
            canvas.drawRect(-this.J, 0.0f, staticLayout.getWidth() + this.J, staticLayout.getHeight(), this.f33716i);
        }
        if (Color.alpha(this.w) > 0) {
            this.f33716i.setColor(this.w);
            float lineTop = staticLayout.getLineTop(0);
            int lineCount = staticLayout.getLineCount();
            int i2 = 0;
            while (i2 < lineCount) {
                this.f33708a.left = staticLayout.getLineLeft(i2) - this.J;
                this.f33708a.right = staticLayout.getLineRight(i2) + this.J;
                RectF rectF = this.f33708a;
                rectF.top = lineTop;
                rectF.bottom = staticLayout.getLineBottom(i2);
                RectF rectF2 = this.f33708a;
                float f2 = rectF2.bottom;
                float f3 = this.f33709b;
                canvas.drawRoundRect(rectF2, f3, f3, this.f33716i);
                i2++;
                lineTop = f2;
            }
        }
        int i3 = this.z;
        if (i3 == 1) {
            this.f33715h.setStrokeJoin(Paint.Join.ROUND);
            this.f33715h.setStrokeWidth(this.f33710c);
            this.f33715h.setColor(this.y);
            this.f33715h.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout.draw(canvas);
        } else if (i3 == 2) {
            TextPaint textPaint = this.f33715h;
            float f4 = this.f33711d;
            float f5 = this.f33712e;
            textPaint.setShadowLayer(f4, f5, f5, this.y);
        } else if (i3 == 3 || i3 == 4) {
            boolean z = this.z == 3;
            int i4 = z ? -1 : this.y;
            int i5 = z ? this.y : -1;
            float f6 = this.f33711d / 2.0f;
            this.f33715h.setColor(this.v);
            this.f33715h.setStyle(Paint.Style.FILL);
            float f7 = -f6;
            this.f33715h.setShadowLayer(this.f33711d, f7, f7, i4);
            staticLayout.draw(canvas);
            this.f33715h.setShadowLayer(this.f33711d, f6, f6, i5);
        }
        this.f33715h.setColor(this.v);
        this.f33715h.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas);
        this.f33715h.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas.restoreToCount(save);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f() {
        float f2;
        int i2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int i3 = this.E;
            int i4 = this.C;
            int i5 = this.F;
            int i6 = this.D;
            float f4 = i3 - i4;
            float f5 = i4 + (this.p * f4);
            float f6 = i5 - i6;
            float f7 = i6 + (this.m * f6);
            int round = Math.round(f4 * this.r);
            float f8 = this.s;
            int round2 = f8 != Float.MIN_VALUE ? Math.round(f6 * f8) : Math.round(round * (this.l.getHeight() / this.l.getWidth()));
            int i7 = this.o;
            if (i7 != 2) {
                if (i7 == 1) {
                    f2 = round / 2;
                }
                int round3 = Math.round(f5);
                i2 = this.q;
                if (i2 == 2) {
                    if (i2 == 1) {
                        f3 = round2 / 2;
                    }
                    int round4 = Math.round(f7);
                    this.K = new Rect(round3, round4, round + round3, round2 + round4);
                }
                f3 = round2;
                f7 -= f3;
                int round42 = Math.round(f7);
                this.K = new Rect(round3, round42, round + round3, round2 + round42);
            }
            f2 = round;
            f5 -= f2;
            int round32 = Math.round(f5);
            i2 = this.q;
            if (i2 == 2) {
            }
            f7 -= f3;
            int round422 = Math.round(f7);
            this.K = new Rect(round32, round422, round + round32, round2 + round422);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:76:0x0049 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v14, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.text.SpannableStringBuilder] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v6 */
    public final void g() {
        ?? spannableStringBuilder;
        int i2;
        int i3;
        int i4;
        int round;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int i6 = this.E - this.C;
            int i7 = this.F - this.D;
            this.f33715h.setTextSize(this.A);
            int i8 = (int) ((this.A * 0.125f) + 0.5f);
            int i9 = i8 * 2;
            int i10 = i6 - i9;
            float f2 = this.r;
            if (f2 != Float.MIN_VALUE) {
                i10 = (int) (i10 * f2);
            }
            if (i10 <= 0) {
                return;
            }
            if (this.u && this.t) {
                spannableStringBuilder = this.f33717j;
            } else if (!this.t) {
                spannableStringBuilder = this.f33717j.toString();
            } else {
                spannableStringBuilder = new SpannableStringBuilder(this.f33717j);
                int length = spannableStringBuilder.length();
                AbsoluteSizeSpan[] absoluteSizeSpanArr = (AbsoluteSizeSpan[]) spannableStringBuilder.getSpans(0, length, AbsoluteSizeSpan.class);
                RelativeSizeSpan[] relativeSizeSpanArr = (RelativeSizeSpan[]) spannableStringBuilder.getSpans(0, length, RelativeSizeSpan.class);
                for (AbsoluteSizeSpan absoluteSizeSpan : absoluteSizeSpanArr) {
                    spannableStringBuilder.removeSpan(absoluteSizeSpan);
                }
                for (RelativeSizeSpan relativeSizeSpan : relativeSizeSpanArr) {
                    spannableStringBuilder.removeSpan(relativeSizeSpan);
                }
            }
            CharSequence charSequence = spannableStringBuilder;
            Layout.Alignment alignment = this.k;
            if (alignment == null) {
                alignment = Layout.Alignment.ALIGN_CENTER;
            }
            Layout.Alignment alignment2 = alignment;
            StaticLayout staticLayout = new StaticLayout(charSequence, this.f33715h, i10, alignment2, this.f33713f, this.f33714g, true);
            this.G = staticLayout;
            int height = staticLayout.getHeight();
            int lineCount = this.G.getLineCount();
            int i11 = 0;
            for (int i12 = 0; i12 < lineCount; i12++) {
                i11 = Math.max((int) Math.ceil(this.G.getLineWidth(i12)), i11);
            }
            if (this.r == Float.MIN_VALUE || i11 >= i10) {
                i10 = i11;
            }
            int i13 = i10 + i9;
            float f3 = this.p;
            if (f3 != Float.MIN_VALUE) {
                int round2 = Math.round(i6 * f3) + this.C;
                int i14 = this.q;
                if (i14 == 2) {
                    round2 -= i13;
                } else if (i14 == 1) {
                    round2 = ((round2 * 2) - i13) / 2;
                }
                i2 = Math.max(round2, this.C);
                i3 = Math.min(i13 + i2, this.E);
            } else {
                i2 = (i6 - i13) / 2;
                i3 = i2 + i13;
            }
            int i15 = i3 - i2;
            if (i15 <= 0) {
                return;
            }
            float f4 = this.m;
            if (f4 != Float.MIN_VALUE) {
                if (this.n == 0) {
                    round = Math.round(i7 * f4);
                    i5 = this.D;
                } else {
                    int lineBottom = this.G.getLineBottom(0) - this.G.getLineTop(0);
                    float f5 = this.m;
                    if (f5 >= 0.0f) {
                        round = Math.round(f5 * lineBottom);
                        i5 = this.D;
                    } else {
                        round = Math.round((f5 + 1.0f) * lineBottom);
                        i5 = this.F;
                    }
                }
                i4 = round + i5;
                int i16 = this.o;
                if (i16 == 2) {
                    i4 -= height;
                } else if (i16 == 1) {
                    i4 = ((i4 * 2) - height) / 2;
                }
                int i17 = i4 + height;
                int i18 = this.F;
                if (i17 > i18) {
                    i4 = i18 - height;
                } else {
                    int i19 = this.D;
                    if (i4 < i19) {
                        i4 = i19;
                    }
                }
            } else {
                i4 = (this.F - height) - ((int) (i7 * this.B));
            }
            this.G = new StaticLayout(charSequence, this.f33715h, i15, alignment2, this.f33713f, this.f33714g, true);
            this.H = i2;
            this.I = i4;
            this.J = i8;
        }
    }
}
