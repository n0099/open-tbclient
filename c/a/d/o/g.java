package c.a.d.o;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.style.DynamicDrawableSpan;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
/* loaded from: classes.dex */
public class g extends DynamicDrawableSpan {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Drawable a;

    /* renamed from: b  reason: collision with root package name */
    public Uri f2643b;

    /* renamed from: c  reason: collision with root package name */
    public int f2644c;

    /* renamed from: d  reason: collision with root package name */
    public Context f2645d;

    /* renamed from: e  reason: collision with root package name */
    public a f2646e;

    /* renamed from: f  reason: collision with root package name */
    public Rect f2647f;

    /* loaded from: classes.dex */
    public interface a {
        Drawable a(g gVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(a aVar, int i, int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2647f = new Rect();
        this.f2644c = i;
        this.f2646e = aVar;
    }

    public void a(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, drawable) == null) {
            this.a = drawable;
        }
    }

    public void b(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3, i4) == null) {
            this.f2647f.set(i, i2, i3, i4);
        }
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint}) == null) || (drawable = getDrawable()) == null) {
            return;
        }
        canvas.save();
        int i6 = drawable.getBounds().bottom;
        if (((DynamicDrawableSpan) this).mVerticalAlignment == 0) {
            i4 = i5;
        }
        canvas.translate(f2, i4 - (drawable.getBounds().bottom - 4));
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Drawable drawable = this.a;
            if (drawable == null) {
                a aVar = this.f2646e;
                drawable = aVar != null ? aVar.a(this) : null;
            }
            if (drawable != null) {
                return drawable;
            }
            try {
                if (this.f2643b != null) {
                    InputStream openInputStream = this.f2645d.getContentResolver().openInputStream(this.f2643b);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f2645d.getResources(), BitmapFactory.decodeStream(openInputStream));
                    try {
                        bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                        openInputStream.close();
                        return bitmapDrawable;
                    } catch (Exception unused) {
                        drawable = bitmapDrawable;
                    }
                } else {
                    drawable = this.f2645d.getResources().getDrawable(this.f2644c);
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                }
            } catch (Exception unused2) {
            }
            return drawable;
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{paint, charSequence, Integer.valueOf(i), Integer.valueOf(i2), fontMetricsInt})) == null) {
            if (this.a == null && this.f2646e != null) {
                if (fontMetricsInt != null) {
                    int i3 = -this.f2647f.bottom;
                    fontMetricsInt.ascent = i3;
                    fontMetricsInt.descent = 0;
                    fontMetricsInt.top = i3;
                    fontMetricsInt.bottom = 0;
                }
                return this.f2647f.right;
            }
            return super.getSize(paint, charSequence, i, i2, fontMetricsInt);
        }
        return invokeCommon.intValue;
    }
}
