package c.a.r0.y3.n0;

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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DragLayer a;

    /* renamed from: b  reason: collision with root package name */
    public Context f25104b;

    /* renamed from: c  reason: collision with root package name */
    public Vibrator f25105c;

    /* renamed from: d  reason: collision with root package name */
    public d f25106d;

    /* renamed from: e  reason: collision with root package name */
    public c f25107e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f25108f;

    /* renamed from: g  reason: collision with root package name */
    public float f25109g;

    /* renamed from: h  reason: collision with root package name */
    public float f25110h;

    /* renamed from: i  reason: collision with root package name */
    public b f25111i;

    /* renamed from: j  reason: collision with root package name */
    public Rect f25112j;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25112j = new Rect();
        this.f25104b = context;
        this.f25105c = (Vibrator) context.getSystemService("vibrator");
        this.f25110h = this.f25104b.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f25108f) {
            this.f25108f = false;
            this.f25111i = null;
            this.f25106d.stopMove();
            this.f25106d.onDrop();
            this.a.destroyDragObject();
            this.a.invalidate();
        }
    }

    public final void b(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            bVar.f25117f = false;
            bVar.f25118g = false;
            Rect rect = bVar.a;
            int width = rect.width();
            int width2 = this.a.getWidth();
            int i2 = this.l;
            int i3 = (width2 - i2) - this.m;
            if (rect.left < i2) {
                rect.left = i2;
                rect.right = i2 + width;
            }
            int i4 = rect.right;
            int i5 = this.l;
            if (i4 > i5 + i3) {
                int i6 = i5 + i3;
                rect.right = i6;
                rect.left = i6 - width;
            }
            if (rect.left < this.l + this.f25110h) {
                bVar.f25117f = true;
                bVar.f25118g = false;
            }
            if (rect.right > (this.l + i3) - this.f25110h) {
                bVar.f25117f = false;
                bVar.f25118g = true;
            }
        }
    }

    public boolean c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.f25109g = motionEvent.getX(0);
            } else if (action == 1 || action == 3 || action == 4 || action == 6) {
                a();
            }
            return this.f25108f;
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
            if (this.f25108f) {
                if (this.k == null) {
                    Rect rect = new Rect();
                    this.k = rect;
                    this.a.getDrawingRect(rect);
                    Rect rect2 = this.k;
                    float f2 = this.f25110h;
                    rect2.top = (int) (rect2.top - f2);
                    rect2.bottom = (int) (rect2.bottom + f2);
                }
                int action = motionEvent.getAction() & 255;
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float x = motionEvent.getX(0);
                            this.f25109g = x;
                            this.f25111i.a.offset((int) (x - this.f25109g), 0);
                            b(this.f25111i);
                            i();
                        } else if (action != 3) {
                            if (action != 4) {
                            }
                        }
                    }
                    a();
                } else {
                    this.f25109g = motionEvent.getX(0);
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
            this.f25107e = cVar;
            cVar.setDragController(this);
        }
    }

    public void g(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.f25106d = dVar;
        }
    }

    public void h(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, view, bundle) == null) || this.a == null || view == null || view.getDrawingCache() == null) {
            return;
        }
        this.f25108f = true;
        this.f25111i = new b(this.f25104b);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.a.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.f25111i.f25113b = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        b bVar = this.f25111i;
        bVar.a = rect;
        bVar.f25116e = bundle;
        view.setVisibility(4);
        b(this.f25111i);
        this.a.setDragObject(this.f25111i);
        this.f25105c.vibrate(300L);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f25112j.set(this.f25111i.a);
            this.a.offsetRectIntoDescendantCoords((View) this.f25106d, this.f25112j);
            this.f25106d.onSwap(this.f25112j);
            this.a.invalidate();
            b bVar = this.f25111i;
            if (bVar.f25117f) {
                this.f25106d.moveLeft();
            } else if (bVar.f25118g) {
                this.f25106d.moveRight();
            } else {
                this.f25106d.stopMove();
            }
        }
    }
}
