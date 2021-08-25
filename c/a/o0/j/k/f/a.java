package c.a.o0.j.k.f;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import c.a.o0.a.h1.c.h.d;
import c.a.o0.a.v2.n0;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.o0.j.k.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class View$OnClickListenerC0609a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.j.n.c f11688e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.h1.c.h.d f11689f;

        public View$OnClickListenerC0609a(c.a.o0.j.n.c cVar, c.a.o0.a.h1.c.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11688e = cVar;
            this.f11689f = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.o0.j.l.a.a(this.f11688e, this.f11689f);
            }
        }
    }

    public static View a(c.a.o0.j.n.c cVar, c.a.o0.a.h1.c.h.d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, cVar, dVar)) == null) {
            c.a.o0.a.e0.d.g("map", "creatCallout start");
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setColor(dVar.m.f6518f);
            paint.setTextSize(dVar.m.f6519g);
            d.b bVar = dVar.m;
            float f2 = bVar.f6521i;
            float f3 = bVar.f6515j;
            Paint paint2 = new Paint();
            paint2.setAntiAlias(true);
            paint2.setStyle(Paint.Style.FILL_AND_STROKE);
            paint2.setColor(dVar.m.l);
            String str = dVar.m.f6517e;
            int g2 = n0.g(6.0f);
            float f4 = f2 * 2.0f;
            float measureText = paint.measureText(str) + f4;
            float f5 = paint.getFontMetrics().bottom - paint.getFontMetrics().top;
            float f6 = g2 + f5 + f4;
            if (f6 > 0.0f && measureText > 0.0f) {
                Bitmap createBitmap = Bitmap.createBitmap((int) measureText, (int) f6, Bitmap.Config.ARGB_8888);
                createBitmap.eraseColor(Color.argb(0, 0, 0, 0));
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                RectF rectF = new RectF();
                rectF.left = 0.0f;
                rectF.top = 0.0f;
                float f7 = f5 + f4;
                rectF.bottom = f7;
                rectF.right = measureText;
                canvas.drawRoundRect(rectF, f3, f3, paint2);
                Path path = new Path();
                float f8 = measureText / 2.0f;
                float f9 = g2 / 2;
                path.moveTo(f8 - f9, f7);
                path.lineTo(f8, f6);
                path.lineTo(f8 + f9, f7);
                path.close();
                canvas.drawPath(path, paint2);
                canvas.drawText(str, f2, (-paint.getFontMetrics().top) + f2, paint);
                ImageView imageView = new ImageView(AppRuntime.getAppContext());
                imageView.setLayoutParams(new ViewGroup.LayoutParams(createBitmap.getWidth(), createBitmap.getHeight()));
                imageView.setImageBitmap(createBitmap);
                imageView.setOnClickListener(new View$OnClickListenerC0609a(cVar, dVar));
                c.a.o0.a.e0.d.g("map", "creatCallout end");
                return imageView;
            }
            c.a.o0.a.e0.d.l("map", "callout height or wodth is 0");
            return new ImageView(AppRuntime.getAppContext());
        }
        return (View) invokeLL.objValue;
    }
}
