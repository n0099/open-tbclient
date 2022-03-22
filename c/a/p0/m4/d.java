package c.a.p0.m4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.v0.r.t;
import c.a.v0.r.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.TextWordsEntity;
import com.baidu.ugc.editvideo.subtitle.NewSubTitleCreater;
import com.baidu.ugc.editvideo.subtitle.ninepatchchunk.NinePatchChunk;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static d k;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f16382b;

    /* renamed from: c  reason: collision with root package name */
    public Context f16383c;

    /* renamed from: d  reason: collision with root package name */
    public TextWordsEntity.TextStyleEntity f16384d;

    /* renamed from: e  reason: collision with root package name */
    public TextWordsEntity.TextFontEntity f16385e;

    /* renamed from: f  reason: collision with root package name */
    public final TextPaint f16386f;

    /* renamed from: g  reason: collision with root package name */
    public final TextPaint f16387g;

    /* renamed from: h  reason: collision with root package name */
    public final TextPaint f16388h;
    public int i;
    public List<String> j;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16382b = 5;
        this.j = new ArrayList();
        this.f16386f = new TextPaint(1);
        this.f16387g = new TextPaint(1);
        this.f16388h = new TextPaint(1);
        this.a = t.j(R.dimen.tbds72);
    }

    public static d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (k == null) {
                synchronized (d.class) {
                    if (k == null) {
                        k = new d();
                    }
                }
            }
            return k;
        }
        return (d) invokeV.objValue;
    }

    public final void a(String str, Canvas canvas, int i, int i2, int i3, TextPaint textPaint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, canvas, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), textPaint}) == null) {
            i(textPaint);
            canvas.drawText(str, i, i2, textPaint);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f16386f.setTypeface(Typeface.DEFAULT);
            this.f16387g.setTypeface(Typeface.DEFAULT);
            this.f16388h.setTypeface(Typeface.DEFAULT);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f16386f.setShader(null);
            this.f16386f.setColor(-1);
            this.f16386f.clearShadowLayer();
            this.f16387g.clearShadowLayer();
            this.f16388h.clearShadowLayer();
            this.j.clear();
        }
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (str.contains("\n")) {
                String[] split = str.split("\n");
                if (split.length > 1) {
                    int i = 0;
                    int i2 = 0;
                    for (int i3 = 0; i3 < split.length; i3++) {
                        int length = split[i3].length();
                        if (length > i2) {
                            i = i3;
                            i2 = length;
                        }
                    }
                    return split[i];
                }
                return str;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (int) (v.e() * 0.85d) : invokeV.intValue;
    }

    public final int[] g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new int[]{0, 0};
            }
            String e2 = e(str);
            int[] iArr = new int[2];
            TextPaint textPaint = new TextPaint(1);
            i(textPaint);
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setTextSize(this.a);
            float measureText = textPaint.measureText(e2) + 2.0f + 40.0f;
            if (measureText > f()) {
                measureText = f() + 2.0f;
            }
            float f2 = 0.0f;
            if (measureText > 0.0f) {
                StaticLayout measuredStaticLayout = NewSubTitleCreater.getMeasuredStaticLayout(str, textPaint, (int) measureText, this.f16382b, Layout.Alignment.ALIGN_CENTER, 0);
                this.i = measuredStaticLayout.getLineCount();
                int i = 0;
                for (int i2 = 0; i2 < this.i; i2++) {
                    int lineEnd = measuredStaticLayout.getLineEnd(i2);
                    if (lineEnd != 0) {
                        this.j.add(str.substring(i, lineEnd));
                        i = lineEnd;
                    }
                }
                f2 = measuredStaticLayout.getHeight() + 2.0f + 40.0f;
            }
            iArr[0] = (int) measureText;
            iArr[1] = (int) f2;
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public Bitmap h(Context context, String str, TextWordsEntity.TextStyleEntity textStyleEntity, TextWordsEntity.TextFontEntity textFontEntity) {
        InterceptResult invokeLLLL;
        int i;
        int i2;
        int i3;
        Canvas canvas;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, context, str, textStyleEntity, textFontEntity)) == null) {
            c();
            this.f16383c = context;
            this.f16384d = textStyleEntity;
            this.f16385e = textFontEntity;
            this.f16386f.setTextSize(this.a);
            int[] g2 = g(str);
            if (g2[0] >= 1 && g2[1] >= 1) {
                Bitmap a = c.a.v0.r.f.a(this.f16384d);
                NinePatchChunk f2 = c.a.v0.r.f.f(a, this.f16384d);
                if (f2 != null) {
                    Rect rect = f2.padding;
                    i = rect.left;
                    int i4 = rect.top;
                    g2[0] = g2[0] + i;
                    g2[1] = g2[1] + i4;
                    g2[0] = g2[0] + rect.right;
                    g2[1] = g2[1] + rect.bottom;
                    if (a != null && g2[0] < a.getWidth()) {
                        g2[0] = a.getWidth();
                    }
                    i2 = i4;
                } else {
                    i = 0;
                    i2 = 0;
                }
                Bitmap createBitmap = Bitmap.createBitmap(g2[0], g2[1], Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                canvas2.save();
                int i5 = 20;
                c.a.v0.r.f.b(a, f2, canvas2, 20);
                int g3 = c.a.v0.r.f.g(this.f16386f);
                int i6 = i + 20;
                int abs = (g3 / 2) + ((int) (Math.abs(this.f16386f.ascent() + this.f16386f.descent()) / 2.0f)) + 20 + i2;
                int i7 = 0;
                while (i7 < this.i) {
                    int i8 = i7 + 1;
                    c.a.v0.r.f.c(this.f16386f, this.f16384d, null);
                    int[] d2 = c.a.v0.r.f.d(this.f16386f, this.f16387g, this.f16388h, this.f16384d, null);
                    c.a.v0.r.f.e(canvas2, this.f16386f, i6, (g3 * i7) + i5 + i2, (g3 * i8) + i5 + i2, this.f16384d, null);
                    if (d2[0] != 0) {
                        i3 = i7;
                        canvas = canvas2;
                        a(this.j.get(i7), canvas2, i6, abs, i3, this.f16387g);
                    } else {
                        i3 = i7;
                        canvas = canvas2;
                    }
                    if (d2[1] != 0) {
                        a(this.j.get(i3), canvas, i6, abs, i3, this.f16388h);
                    }
                    a(this.j.get(i3), canvas, i6, abs, i3, this.f16386f);
                    abs += g3;
                    canvas2 = canvas;
                    i7 = i8;
                    i5 = 20;
                }
                canvas2.restore();
                return createBitmap;
            }
            return Bitmap.createBitmap(10, this.a, Bitmap.Config.ARGB_8888);
        }
        return (Bitmap) invokeLLLL.objValue;
    }

    public final void i(TextPaint textPaint) {
        TextWordsEntity.TextFontEntity textFontEntity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, textPaint) == null) || (textFontEntity = this.f16385e) == null) {
            return;
        }
        try {
            if (textFontEntity.isDefault()) {
                b();
                return;
            }
            this.f16385e.setFontRootDir(new File(FileHelper.getVideoTmpDir()));
            textPaint.setTypeface(Typeface.createFromFile(this.f16385e.getSourceFile()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.a = i;
        }
    }
}
