package b.a.p0.m.l.f;

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
import b.a.p0.a.i1.c.h.d;
import b.a.p0.a.z2.n0;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.m.l.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class View$OnClickListenerC0635a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.m.o.c f11601e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.i1.c.h.d f11602f;

        public View$OnClickListenerC0635a(b.a.p0.m.o.c cVar, b.a.p0.a.i1.c.h.d dVar) {
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
            this.f11601e = cVar;
            this.f11602f = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.p0.m.m.a.a(this.f11601e, this.f11602f);
            }
        }
    }

    public static View a(b.a.p0.m.o.c cVar, b.a.p0.a.i1.c.h.d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, cVar, dVar)) == null) {
            b.a.p0.a.e0.d.i("map", "creatCallout start");
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setColor(dVar.m.f6496f);
            paint.setTextSize(dVar.m.f6497g);
            d.b bVar = dVar.m;
            float f2 = bVar.f6499i;
            float f3 = bVar.j;
            Paint paint2 = new Paint();
            paint2.setAntiAlias(true);
            paint2.setStyle(Paint.Style.FILL_AND_STROKE);
            paint2.setColor(dVar.m.l);
            String str = dVar.m.f6495e;
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
                imageView.setOnClickListener(new View$OnClickListenerC0635a(cVar, dVar));
                b.a.p0.a.e0.d.i("map", "creatCallout end");
                return imageView;
            }
            b.a.p0.a.e0.d.o("map", "callout height or wodth is 0");
            return new ImageView(AppRuntime.getAppContext());
        }
        return (View) invokeLL.objValue;
    }
}
