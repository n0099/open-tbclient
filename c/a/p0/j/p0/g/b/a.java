package c.a.p0.j.p0.g.b;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.j.n0.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@UiThread
/* loaded from: classes2.dex */
public class a implements c.a.p0.j.p0.g.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f10651e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.j.p0.g.e.a f10652f;

    /* renamed from: g  reason: collision with root package name */
    public b f10653g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f10654h;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f10655i;

    /* renamed from: j  reason: collision with root package name */
    public int f10656j;
    public boolean k;
    public ObjectAnimator l;
    public d m;

    /* renamed from: c.a.p0.j.p0.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC0732a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC0732a(a aVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1) {
                int f2 = this.a.f();
                if (f2 > 0 && this.a.k) {
                    this.a.f10654h.sendEmptyMessageDelayed(1, f2);
                }
                this.a.k();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void c();

        void o();

        void u(int i2);
    }

    public a(@NonNull Context context, @NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10651e = context;
        this.m = dVar;
        j(i());
        h();
        b();
    }

    @NonNull
    public static a c(int i2, @NonNull Context context, @NonNull d dVar) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65538, null, i2, context, dVar)) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return new c.a.p0.j.p0.g.c.a(context, dVar);
                }
                return new c.a.p0.j.p0.g.d.a(context, dVar);
            }
            return new c.a.p0.j.p0.g.c.a(context, dVar);
        }
        return (a) invokeILL.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f10655i.setVisibility(8);
            c.a.p0.j.p0.b.a(this.f10655i, g());
        }
    }

    public final ObjectAnimator d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f10655i, PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.2f, 6.0f), Keyframe.ofFloat(0.4f, -6.0f), Keyframe.ofFloat(0.6f, 6.0f), Keyframe.ofFloat(0.8f, -6.0f), Keyframe.ofFloat(1.0f, 0.0f)));
            ofPropertyValuesHolder.setDuration(600L);
            return ofPropertyValuesHolder;
        }
        return (ObjectAnimator) invokeV.objValue;
    }

    @Override // c.a.p0.j.p0.g.a
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.k = false;
            this.f10654h.removeCallbacksAndMessages(null);
            c.a.p0.j.p0.b.d(this.f10655i);
        }
    }

    @Override // c.a.p0.j.p0.g.b.b
    public void e(c.a.p0.j.p0.g.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f10652f = aVar;
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 5000;
        }
        return invokeV.intValue;
    }

    public final c.a.p0.a.c1.e.a.a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.p0.a.c1.e.a.a aVar = new c.a.p0.a.c1.e.a.a();
            aVar.m(g.a(this.m.left) - this.f10656j);
            aVar.n(g.a(this.m.top) - this.f10656j);
            aVar.o(-2);
            aVar.k(-2);
            return aVar;
        }
        return (c.a.p0.a.c1.e.a.a) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.l = d();
            this.f10654h = new HandlerC0732a(this, Looper.getMainLooper());
        }
    }

    @Override // c.a.p0.j.p0.g.a
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.k = false;
            this.f10654h.removeMessages(1);
            this.f10655i.setVisibility(8);
        }
    }

    @SuppressLint({"InflateParams"})
    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? LayoutInflater.from(this.f10651e).inflate(R.layout.swangame_recommend_button, (ViewGroup) null) : (View) invokeV.objValue;
    }

    public final void j(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            this.f10656j = (int) this.f10651e.getResources().getDimension(R.dimen.swangame_recommend_button_root_padding);
            this.f10655i = new FrameLayout(this.f10651e);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g.a(this.m.width), g.a(this.m.height));
            int i2 = this.f10656j;
            layoutParams.setMargins(i2, i2, i2, i2);
            this.f10655i.setBackgroundColor(0);
            this.f10655i.addView(view, layoutParams);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.l.start();
        }
    }

    @Override // c.a.p0.j.p0.g.b.b
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && this.k) {
            this.f10654h.removeMessages(1);
            if (z) {
                this.f10654h.sendEmptyMessage(1);
            }
        }
    }

    @Override // c.a.p0.j.p0.g.a
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.k = true;
            this.f10655i.setVisibility(0);
            this.f10654h.removeMessages(1);
            this.f10654h.sendEmptyMessage(1);
        }
    }

    @Override // c.a.p0.j.p0.g.b.b
    public void t(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.f10653g = bVar;
        }
    }

    @Override // c.a.p0.j.p0.g.b.b
    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            c.a.p0.j.p0.b.f(this.f10655i, g());
        }
    }
}
