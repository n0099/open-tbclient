package c.a.s0.v3.m0;

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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DragLayer a;

    /* renamed from: b  reason: collision with root package name */
    public Context f24973b;

    /* renamed from: c  reason: collision with root package name */
    public Vibrator f24974c;

    /* renamed from: d  reason: collision with root package name */
    public d f24975d;

    /* renamed from: e  reason: collision with root package name */
    public c f24976e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f24977f;

    /* renamed from: g  reason: collision with root package name */
    public float f24978g;

    /* renamed from: h  reason: collision with root package name */
    public float f24979h;

    /* renamed from: i  reason: collision with root package name */
    public b f24980i;

    /* renamed from: j  reason: collision with root package name */
    public Rect f24981j;

    /* renamed from: k  reason: collision with root package name */
    public Rect f24982k;
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
        this.f24981j = new Rect();
        this.f24973b = context;
        this.f24974c = (Vibrator) context.getSystemService("vibrator");
        this.f24979h = this.f24973b.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f24977f) {
            this.f24977f = false;
            this.f24980i = null;
            this.f24975d.stopMove();
            this.f24975d.onDrop();
            this.a.destroyDragObject();
            this.a.invalidate();
        }
    }

    public final void b(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            bVar.f24987f = false;
            bVar.f24988g = false;
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
            if (rect.left < this.l + this.f24979h) {
                bVar.f24987f = true;
                bVar.f24988g = false;
            }
            if (rect.right > (this.l + i3) - this.f24979h) {
                bVar.f24987f = false;
                bVar.f24988g = true;
            }
        }
    }

    public boolean c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.f24978g = motionEvent.getX(0);
            } else if (action == 1 || action == 3 || action == 4 || action == 6) {
                a();
            }
            return this.f24977f;
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
            if (this.f24977f) {
                if (this.f24982k == null) {
                    Rect rect = new Rect();
                    this.f24982k = rect;
                    this.a.getDrawingRect(rect);
                    Rect rect2 = this.f24982k;
                    float f2 = this.f24979h;
                    rect2.top = (int) (rect2.top - f2);
                    rect2.bottom = (int) (rect2.bottom + f2);
                }
                int action = motionEvent.getAction() & 255;
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float x = motionEvent.getX(0);
                            this.f24978g = x;
                            this.f24980i.a.offset((int) (x - this.f24978g), 0);
                            b(this.f24980i);
                            i();
                        } else if (action != 3) {
                            if (action != 4) {
                            }
                        }
                    }
                    a();
                } else {
                    this.f24978g = motionEvent.getX(0);
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
            this.f24976e = cVar;
            cVar.setDragController(this);
        }
    }

    public void g(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.f24975d = dVar;
        }
    }

    public void h(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, view, bundle) == null) || this.a == null || view == null || view.getDrawingCache() == null) {
            return;
        }
        this.f24977f = true;
        this.f24980i = new b(this.f24973b);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.a.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.f24980i.f24983b = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        b bVar = this.f24980i;
        bVar.a = rect;
        bVar.f24986e = bundle;
        view.setVisibility(4);
        b(this.f24980i);
        this.a.setDragObject(this.f24980i);
        this.f24974c.vibrate(300L);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f24981j.set(this.f24980i.a);
            this.a.offsetRectIntoDescendantCoords((View) this.f24975d, this.f24981j);
            this.f24975d.onSwap(this.f24981j);
            this.a.invalidate();
            b bVar = this.f24980i;
            if (bVar.f24987f) {
                this.f24975d.moveLeft();
            } else if (bVar.f24988g) {
                this.f24975d.moveRight();
            } else {
                this.f24975d.stopMove();
            }
        }
    }
}
