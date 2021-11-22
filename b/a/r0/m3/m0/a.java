package b.a.r0.m3.m0;

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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DragLayer f22546a;

    /* renamed from: b  reason: collision with root package name */
    public Context f22547b;

    /* renamed from: c  reason: collision with root package name */
    public Vibrator f22548c;

    /* renamed from: d  reason: collision with root package name */
    public d f22549d;

    /* renamed from: e  reason: collision with root package name */
    public c f22550e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f22551f;

    /* renamed from: g  reason: collision with root package name */
    public float f22552g;

    /* renamed from: h  reason: collision with root package name */
    public float f22553h;

    /* renamed from: i  reason: collision with root package name */
    public b f22554i;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new Rect();
        this.f22547b = context;
        this.f22548c = (Vibrator) context.getSystemService("vibrator");
        this.f22553h = this.f22547b.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f22551f) {
            this.f22551f = false;
            this.f22554i = null;
            this.f22549d.stopMove();
            this.f22549d.onDrop();
            this.f22546a.destroyDragObject();
            this.f22546a.invalidate();
        }
    }

    public final void b(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            bVar.f22560f = false;
            bVar.f22561g = false;
            Rect rect = bVar.f22555a;
            int width = rect.width();
            int width2 = this.f22546a.getWidth();
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
            if (rect.left < this.l + this.f22553h) {
                bVar.f22560f = true;
                bVar.f22561g = false;
            }
            if (rect.right > (this.l + i3) - this.f22553h) {
                bVar.f22560f = false;
                bVar.f22561g = true;
            }
        }
    }

    public boolean c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.f22552g = motionEvent.getX(0);
            } else if (action == 1 || action == 3 || action == 4 || action == 6) {
                a();
            }
            return this.f22551f;
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
            if (this.f22551f) {
                if (this.k == null) {
                    Rect rect = new Rect();
                    this.k = rect;
                    this.f22546a.getDrawingRect(rect);
                    Rect rect2 = this.k;
                    float f2 = this.f22553h;
                    rect2.top = (int) (rect2.top - f2);
                    rect2.bottom = (int) (rect2.bottom + f2);
                }
                int action = motionEvent.getAction() & 255;
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float x = motionEvent.getX(0);
                            this.f22552g = x;
                            this.f22554i.f22555a.offset((int) (x - this.f22552g), 0);
                            b(this.f22554i);
                            i();
                        } else if (action != 3) {
                            if (action != 4) {
                            }
                        }
                    }
                    a();
                } else {
                    this.f22552g = motionEvent.getX(0);
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
            this.f22546a = dragLayer;
            dragLayer.setDragController(this);
            this.l = this.f22546a.getPaddingLeft();
            this.m = this.f22546a.getPaddingRight();
        }
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f22550e = cVar;
            cVar.setDragController(this);
        }
    }

    public void g(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.f22549d = dVar;
        }
    }

    public void h(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, view, bundle) == null) || this.f22546a == null || view == null || view.getDrawingCache() == null) {
            return;
        }
        this.f22551f = true;
        this.f22554i = new b(this.f22547b);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.f22546a.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.f22554i.f22556b = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        b bVar = this.f22554i;
        bVar.f22555a = rect;
        bVar.f22559e = bundle;
        view.setVisibility(4);
        b(this.f22554i);
        this.f22546a.setDragObject(this.f22554i);
        this.f22548c.vibrate(300L);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.j.set(this.f22554i.f22555a);
            this.f22546a.offsetRectIntoDescendantCoords((View) this.f22549d, this.j);
            this.f22549d.onSwap(this.j);
            this.f22546a.invalidate();
            b bVar = this.f22554i;
            if (bVar.f22560f) {
                this.f22549d.moveLeft();
            } else if (bVar.f22561g) {
                this.f22549d.moveRight();
            } else {
                this.f22549d.stopMove();
            }
        }
    }
}
