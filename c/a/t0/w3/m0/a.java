package c.a.t0.w3.m0;

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
    public Context f25628b;

    /* renamed from: c  reason: collision with root package name */
    public Vibrator f25629c;

    /* renamed from: d  reason: collision with root package name */
    public d f25630d;

    /* renamed from: e  reason: collision with root package name */
    public c f25631e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f25632f;

    /* renamed from: g  reason: collision with root package name */
    public float f25633g;

    /* renamed from: h  reason: collision with root package name */
    public float f25634h;

    /* renamed from: i  reason: collision with root package name */
    public b f25635i;

    /* renamed from: j  reason: collision with root package name */
    public Rect f25636j;

    /* renamed from: k  reason: collision with root package name */
    public Rect f25637k;
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
        this.f25636j = new Rect();
        this.f25628b = context;
        this.f25629c = (Vibrator) context.getSystemService("vibrator");
        this.f25634h = this.f25628b.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f25632f) {
            this.f25632f = false;
            this.f25635i = null;
            this.f25630d.stopMove();
            this.f25630d.onDrop();
            this.a.destroyDragObject();
            this.a.invalidate();
        }
    }

    public final void b(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            bVar.f25642f = false;
            bVar.f25643g = false;
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
            if (rect.left < this.l + this.f25634h) {
                bVar.f25642f = true;
                bVar.f25643g = false;
            }
            if (rect.right > (this.l + i3) - this.f25634h) {
                bVar.f25642f = false;
                bVar.f25643g = true;
            }
        }
    }

    public boolean c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.f25633g = motionEvent.getX(0);
            } else if (action == 1 || action == 3 || action == 4 || action == 6) {
                a();
            }
            return this.f25632f;
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
            if (this.f25632f) {
                if (this.f25637k == null) {
                    Rect rect = new Rect();
                    this.f25637k = rect;
                    this.a.getDrawingRect(rect);
                    Rect rect2 = this.f25637k;
                    float f2 = this.f25634h;
                    rect2.top = (int) (rect2.top - f2);
                    rect2.bottom = (int) (rect2.bottom + f2);
                }
                int action = motionEvent.getAction() & 255;
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float x = motionEvent.getX(0);
                            this.f25633g = x;
                            this.f25635i.a.offset((int) (x - this.f25633g), 0);
                            b(this.f25635i);
                            i();
                        } else if (action != 3) {
                            if (action != 4) {
                            }
                        }
                    }
                    a();
                } else {
                    this.f25633g = motionEvent.getX(0);
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
            this.f25631e = cVar;
            cVar.setDragController(this);
        }
    }

    public void g(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.f25630d = dVar;
        }
    }

    public void h(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, view, bundle) == null) || this.a == null || view == null || view.getDrawingCache() == null) {
            return;
        }
        this.f25632f = true;
        this.f25635i = new b(this.f25628b);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.a.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.f25635i.f25638b = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        b bVar = this.f25635i;
        bVar.a = rect;
        bVar.f25641e = bundle;
        view.setVisibility(4);
        b(this.f25635i);
        this.a.setDragObject(this.f25635i);
        this.f25629c.vibrate(300L);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f25636j.set(this.f25635i.a);
            this.a.offsetRectIntoDescendantCoords((View) this.f25630d, this.f25636j);
            this.f25630d.onSwap(this.f25636j);
            this.a.invalidate();
            b bVar = this.f25635i;
            if (bVar.f25642f) {
                this.f25630d.moveLeft();
            } else if (bVar.f25643g) {
                this.f25630d.moveRight();
            } else {
                this.f25630d.stopMove();
            }
        }
    }
}
