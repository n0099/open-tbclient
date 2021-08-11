package c.a.n0.j.k.f;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.view.ViewGroup;
import android.widget.ImageView;
import c.a.n0.a.h1.c.h.d;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static OverlayOptions a(c.a.n0.j.n.c cVar, c.a.n0.j.n.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, cVar, bVar)) == null) {
            c.a.n0.a.e0.d.g("map", "createLabel start");
            if (bVar == null) {
                return null;
            }
            c.a.n0.a.h1.c.h.d dVar = bVar.f11474a;
            if (dVar != null && dVar.n != null && dVar.f6262f != null) {
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                paint.setColor(dVar.n.f6272f);
                paint.setTextSize(dVar.n.f6273g);
                d.c cVar2 = dVar.n;
                float f2 = cVar2.f6275i;
                float f3 = cVar2.n;
                Paint paint2 = new Paint();
                paint2.setAntiAlias(true);
                paint2.setStyle(Paint.Style.FILL_AND_STROKE);
                paint2.setColor(dVar.n.f6274h);
                String str = dVar.n.f6271e;
                float f4 = f2 * 2.0f;
                float measureText = paint.measureText(str) + f4;
                float f5 = (paint.getFontMetrics().bottom - paint.getFontMetrics().top) + f4;
                if (f5 > 0.0f && measureText > 0.0f) {
                    float f6 = dVar.n.l;
                    Bitmap createBitmap = Bitmap.createBitmap((int) (measureText + f6 + 0.5d), (int) (f5 + f6 + 0.5d), Bitmap.Config.ARGB_8888);
                    createBitmap.eraseColor(Color.argb(0, 0, 0, 0));
                    Canvas canvas = new Canvas(createBitmap);
                    canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    RectF rectF = new RectF();
                    float f7 = f6 / 2.0f;
                    rectF.left = f7;
                    rectF.top = f7;
                    rectF.bottom = f5 + f7;
                    rectF.right = measureText + f7;
                    canvas.drawRoundRect(rectF, f3, f3, paint2);
                    if (f6 > 0.0f) {
                        paint2.setStyle(Paint.Style.STROKE);
                        paint2.setColor(dVar.n.m);
                        paint2.setStrokeWidth(f6);
                        canvas.drawRoundRect(rectF, f3, f3, paint2);
                    }
                    canvas.drawText(str, f2 + f7, (-paint.getFontMetrics().top) + f2 + f7, paint);
                    ImageView imageView = new ImageView(AppRuntime.getAppContext());
                    imageView.setLayoutParams(new ViewGroup.LayoutParams(createBitmap.getWidth(), createBitmap.getHeight()));
                    d.c cVar3 = dVar.n;
                    imageView.setPadding((int) cVar3.f6270j, (int) cVar3.k, 0, 0);
                    imageView.setImageBitmap(createBitmap);
                    BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(imageView);
                    MarkerOptions markerOptions = new MarkerOptions();
                    c.a.n0.a.h1.c.h.c cVar4 = dVar.f6262f;
                    MarkerOptions zIndex = markerOptions.position(new LatLng(cVar4.f6259e, cVar4.f6260f)).icon(fromView).anchor(0.0f, 0.0f).zIndex(66);
                    c.a.n0.a.e0.d.g("map", "createLabel end");
                    return zIndex;
                }
                c.a.n0.a.e0.d.b("map", "label heigth or width is 0");
                return null;
            }
            c.a.n0.a.e0.d.b("map", "marker data error");
            return null;
        }
        return (OverlayOptions) invokeLL.objValue;
    }
}
