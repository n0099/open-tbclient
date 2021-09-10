package c.a.r0.j3.l0;

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

    /* renamed from: a  reason: collision with root package name */
    public DragLayer f20938a;

    /* renamed from: b  reason: collision with root package name */
    public Context f20939b;

    /* renamed from: c  reason: collision with root package name */
    public Vibrator f20940c;

    /* renamed from: d  reason: collision with root package name */
    public d f20941d;

    /* renamed from: e  reason: collision with root package name */
    public c f20942e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20943f;

    /* renamed from: g  reason: collision with root package name */
    public float f20944g;

    /* renamed from: h  reason: collision with root package name */
    public float f20945h;

    /* renamed from: i  reason: collision with root package name */
    public b f20946i;

    /* renamed from: j  reason: collision with root package name */
    public Rect f20947j;
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
        this.f20947j = new Rect();
        this.f20939b = context;
        this.f20940c = (Vibrator) context.getSystemService("vibrator");
        this.f20945h = this.f20939b.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f20943f) {
            this.f20943f = false;
            this.f20946i = null;
            this.f20941d.stopMove();
            this.f20941d.onDrop();
            this.f20938a.destroyDragObject();
            this.f20938a.invalidate();
        }
    }

    public final void b(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            bVar.f20953f = false;
            bVar.f20954g = false;
            Rect rect = bVar.f20948a;
            int width = rect.width();
            int width2 = this.f20938a.getWidth();
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
            if (rect.left < this.l + this.f20945h) {
                bVar.f20953f = true;
                bVar.f20954g = false;
            }
            if (rect.right > (this.l + i3) - this.f20945h) {
                bVar.f20953f = false;
                bVar.f20954g = true;
            }
        }
    }

    public boolean c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.f20944g = motionEvent.getX(0);
            } else if (action == 1 || action == 3 || action == 4 || action == 6) {
                a();
            }
            return this.f20943f;
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
            if (this.f20943f) {
                if (this.k == null) {
                    Rect rect = new Rect();
                    this.k = rect;
                    this.f20938a.getDrawingRect(rect);
                    Rect rect2 = this.k;
                    float f2 = this.f20945h;
                    rect2.top = (int) (rect2.top - f2);
                    rect2.bottom = (int) (rect2.bottom + f2);
                }
                int action = motionEvent.getAction() & 255;
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float x = motionEvent.getX(0);
                            this.f20944g = x;
                            this.f20946i.f20948a.offset((int) (x - this.f20944g), 0);
                            b(this.f20946i);
                            i();
                        } else if (action != 3) {
                            if (action != 4) {
                            }
                        }
                    }
                    a();
                } else {
                    this.f20944g = motionEvent.getX(0);
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
            this.f20938a = dragLayer;
            dragLayer.setDragController(this);
            this.l = this.f20938a.getPaddingLeft();
            this.m = this.f20938a.getPaddingRight();
        }
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f20942e = cVar;
            cVar.setDragController(this);
        }
    }

    public void g(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.f20941d = dVar;
        }
    }

    public void h(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, view, bundle) == null) || this.f20938a == null || view == null || view.getDrawingCache() == null) {
            return;
        }
        this.f20943f = true;
        this.f20946i = new b(this.f20939b);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.f20938a.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.f20946i.f20949b = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        b bVar = this.f20946i;
        bVar.f20948a = rect;
        bVar.f20952e = bundle;
        view.setVisibility(4);
        b(this.f20946i);
        this.f20938a.setDragObject(this.f20946i);
        this.f20940c.vibrate(300L);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f20947j.set(this.f20946i.f20948a);
            this.f20938a.offsetRectIntoDescendantCoords((View) this.f20941d, this.f20947j);
            this.f20941d.onSwap(this.f20947j);
            this.f20938a.invalidate();
            b bVar = this.f20946i;
            if (bVar.f20953f) {
                this.f20941d.moveLeft();
            } else if (bVar.f20954g) {
                this.f20941d.moveRight();
            } else {
                this.f20941d.stopMove();
            }
        }
    }
}
