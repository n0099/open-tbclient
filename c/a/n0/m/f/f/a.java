package c.a.n0.m.f.f;

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
import c.a.n0.a.p2.n0;
import c.a.n0.a.y0.c.h.d;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.m.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class View$OnClickListenerC0744a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.m.i.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.y0.c.h.d f9029b;

        public View$OnClickListenerC0744a(c.a.n0.m.i.c cVar, c.a.n0.a.y0.c.h.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
            this.f9029b = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.n0.m.g.a.a(this.a, this.f9029b);
            }
        }
    }

    public static View a(c.a.n0.m.i.c cVar, c.a.n0.a.y0.c.h.d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, cVar, dVar)) == null) {
            c.a.n0.a.u.d.i("map", "creatCallout start");
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setColor(dVar.i.f7719b);
            paint.setTextSize(dVar.i.f7720c);
            d.b bVar = dVar.i;
            float f2 = bVar.f7722e;
            float f3 = bVar.f7713f;
            Paint paint2 = new Paint();
            paint2.setAntiAlias(true);
            paint2.setStyle(Paint.Style.FILL_AND_STROKE);
            paint2.setColor(dVar.i.f7715h);
            String str = dVar.i.a;
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
                imageView.setOnClickListener(new View$OnClickListenerC0744a(cVar, dVar));
                c.a.n0.a.u.d.i("map", "creatCallout end");
                return imageView;
            }
            c.a.n0.a.u.d.o("map", "callout height or wodth is 0");
            return new ImageView(AppRuntime.getAppContext());
        }
        return (View) invokeLL.objValue;
    }
}
