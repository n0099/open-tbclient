package c.a.p0.i3.k0;

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
    public DragLayer f20041a;

    /* renamed from: b  reason: collision with root package name */
    public Context f20042b;

    /* renamed from: c  reason: collision with root package name */
    public Vibrator f20043c;

    /* renamed from: d  reason: collision with root package name */
    public d f20044d;

    /* renamed from: e  reason: collision with root package name */
    public c f20045e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20046f;

    /* renamed from: g  reason: collision with root package name */
    public float f20047g;

    /* renamed from: h  reason: collision with root package name */
    public float f20048h;

    /* renamed from: i  reason: collision with root package name */
    public b f20049i;

    /* renamed from: j  reason: collision with root package name */
    public Rect f20050j;
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
        this.f20050j = new Rect();
        this.f20042b = context;
        this.f20043c = (Vibrator) context.getSystemService("vibrator");
        this.f20048h = this.f20042b.getResources().getDisplayMetrics().density * 20.0f;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f20046f) {
            this.f20046f = false;
            this.f20049i = null;
            this.f20044d.stopMove();
            this.f20044d.onDrop();
            this.f20041a.destroyDragObject();
            this.f20041a.invalidate();
        }
    }

    public final void b(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            bVar.f20056f = false;
            bVar.f20057g = false;
            Rect rect = bVar.f20051a;
            int width = rect.width();
            int width2 = this.f20041a.getWidth();
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
            if (rect.left < this.l + this.f20048h) {
                bVar.f20056f = true;
                bVar.f20057g = false;
            }
            if (rect.right > (this.l + i3) - this.f20048h) {
                bVar.f20056f = false;
                bVar.f20057g = true;
            }
        }
    }

    public boolean c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.f20047g = motionEvent.getX(0);
            } else if (action == 1 || action == 3 || action == 4 || action == 6) {
                a();
            }
            return this.f20046f;
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
            if (this.f20046f) {
                if (this.k == null) {
                    Rect rect = new Rect();
                    this.k = rect;
                    this.f20041a.getDrawingRect(rect);
                    Rect rect2 = this.k;
                    float f2 = this.f20048h;
                    rect2.top = (int) (rect2.top - f2);
                    rect2.bottom = (int) (rect2.bottom + f2);
                }
                int action = motionEvent.getAction() & 255;
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            float x = motionEvent.getX(0);
                            this.f20047g = x;
                            this.f20049i.f20051a.offset((int) (x - this.f20047g), 0);
                            b(this.f20049i);
                            i();
                        } else if (action != 3) {
                            if (action != 4) {
                            }
                        }
                    }
                    a();
                } else {
                    this.f20047g = motionEvent.getX(0);
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
            this.f20041a = dragLayer;
            dragLayer.setDragController(this);
            this.l = this.f20041a.getPaddingLeft();
            this.m = this.f20041a.getPaddingRight();
        }
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f20045e = cVar;
            cVar.setDragController(this);
        }
    }

    public void g(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.f20044d = dVar;
        }
    }

    public void h(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, view, bundle) == null) || this.f20041a == null || view == null || view.getDrawingCache() == null) {
            return;
        }
        this.f20046f = true;
        this.f20049i = new b(this.f20042b);
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        this.f20041a.offsetDescendantRectToMyCoords(view, rect);
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        this.f20049i.f20052b = Bitmap.createBitmap(view.getDrawingCache());
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        b bVar = this.f20049i;
        bVar.f20051a = rect;
        bVar.f20055e = bundle;
        view.setVisibility(4);
        b(this.f20049i);
        this.f20041a.setDragObject(this.f20049i);
        this.f20043c.vibrate(300L);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f20050j.set(this.f20049i.f20051a);
            this.f20041a.offsetRectIntoDescendantCoords((View) this.f20044d, this.f20050j);
            this.f20044d.onSwap(this.f20050j);
            this.f20041a.invalidate();
            b bVar = this.f20049i;
            if (bVar.f20056f) {
                this.f20044d.moveLeft();
            } else if (bVar.f20057g) {
                this.f20044d.moveRight();
            } else {
                this.f20044d.stopMove();
            }
        }
    }
}
