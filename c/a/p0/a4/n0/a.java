package c.a.p0.a4.n0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DragLayer a;

    /* renamed from: b  reason: collision with root package name */
    public Context f12300b;

    /* renamed from: c  reason: collision with root package name */
    public Vibrator f12301c;

    /* renamed from: d  reason: collision with root package name */
    public d f12302d;

    /* renamed from: e  reason: collision with root package name */
    public c f12303e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12304f;

    /* renamed from: g  reason: collision with root package name */
    public float f12305g;

    /* renamed from: h  reason: collision with root package name */
    public float f12306h;
    public b i;
    public Rect j;
    public Rect k;
    public int l;
    public int m;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new Rect();
        this.f12300b = context;
        this.f12301c = (Vibrator) context.getSystemService("vibrator");
        this.f12306h = this.f12300b.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f12304f) {
            this.f12304f = false;
            this.i = null;
            this.f12302d.c();
            this.f12302d.e();
            this.a.a();
            this.a.invalidate();
        }
    }

    public final void b(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            bVar.f12311f = false;
            bVar.f12312g = false;
            Rect rect = bVar.a;
            int width = rect.width();
            int width2 = this.a.getWidth();
            int i = this.l;
            int i2 = (width2 - i) - this.m;
            if (rect.left < i) {
                rect.left = i;
                rect.right = i + width;
            }
            int i3 = rect.right;
            int i4 = this.l;
            if (i3 > i4 + i2) {
                int i5 = i4 + i2;
                rect.right = i5;
                rect.left = i5 - width;
            }
            if (rect.left < this.l + this.f12306h) {
                bVar.f12311f = true;
                bVar.f12312g = false;
            }
            if (rect.right > (this.l + i2) - this.f12306h) {
                bVar.f12311f = false;
                bVar.f12312g = true;
            }
        }
    }

    public boolean c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.f12305g = motionEvent.getX(0);
            } else if (action == 1 || action == 3 || action == 4 || action == 6) {
                a();
            }
            return this.f12304f;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
        if (r0 != 6) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            if (this.f12304f) {
                if (this.k == null) {
                    Rect rect = new Rect();
                    this.k = rect;
                    this.a.getDrawingRect(rect);
                    Rect rect2 = this.k;
                    float f2 = this.f12306h;
                    rect2.top = (int) (rect2.top - f2);
                    rect2.bottom = (int) (rect2.bottom + f2);
                }
                int action = motionEvent.getAction() & 255;
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float x = motionEvent.getX(0);
                            this.f12305g = x;
                            this.i.a.offset((int) (x - this.f12305g), 0);
                            b(this.i);
                            i();
                        } else if (action != 3) {
                            if (action != 4) {
                            }
                        }
                    }
                    a();
                } else {
                    this.f12305g = motionEvent.getX(0);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void e(DragLayer dragLayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dragLayer) == null) {
            this.a = dragLayer;
            dragLayer.setDragController(this);
            this.l = this.a.getPaddingLeft();
            this.m = this.a.getPaddingRight();
        }
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f12303e = cVar;
            cVar.setDragController(this);
        }
    }

    public void g(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.f12302d = dVar;
        }
    }

    public void h(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, view, bundle) == null) || this.a == null || view == null || view.getDrawingCache() == null) {
            return;
        }
        this.f12304f = true;
        this.i = new b(this.f12300b);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.a.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.i.f12307b = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        b bVar = this.i;
        bVar.a = rect;
        bVar.f12310e = bundle;
        view.setVisibility(4);
        b(this.i);
        this.a.setDragObject(this.i);
        this.f12301c.vibrate(300L);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.j.set(this.i.a);
            this.a.offsetRectIntoDescendantCoords((View) this.f12302d, this.j);
            this.f12302d.a(this.j);
            this.a.invalidate();
            b bVar = this.i;
            if (bVar.f12311f) {
                this.f12302d.b();
            } else if (bVar.f12312g) {
                this.f12302d.d();
            } else {
                this.f12302d.c();
            }
        }
    }
}
