package c.a.p0.h.o0.g.b;

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
import c.a.p0.f.f;
import c.a.p0.h.m0.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@UiThread
/* loaded from: classes3.dex */
public class a implements c.a.p0.h.o0.g.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f11458e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.h.o0.g.e.a f11459f;

    /* renamed from: g  reason: collision with root package name */
    public b f11460g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f11461h;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f11462i;

    /* renamed from: j  reason: collision with root package name */
    public int f11463j;
    public boolean k;
    public ObjectAnimator l;
    public d m;

    /* renamed from: c.a.p0.h.o0.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class HandlerC0588a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f11464a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC0588a(a aVar, Looper looper) {
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
            this.f11464a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1) {
                int f2 = this.f11464a.f();
                if (f2 > 0 && this.f11464a.k) {
                    this.f11464a.f11461h.sendEmptyMessageDelayed(1, f2);
                }
                this.f11464a.k();
            }
        }
    }

    /* loaded from: classes3.dex */
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
        this.f11458e = context;
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
                    return new c.a.p0.h.o0.g.c.a(context, dVar);
                }
                return new c.a.p0.h.o0.g.d.a(context, dVar);
            }
            return new c.a.p0.h.o0.g.c.a(context, dVar);
        }
        return (a) invokeILL.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f11462i.setVisibility(8);
            c.a.p0.h.o0.b.a(this.f11462i, g());
        }
    }

    public final ObjectAnimator d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f11462i, PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.2f, 6.0f), Keyframe.ofFloat(0.4f, -6.0f), Keyframe.ofFloat(0.6f, 6.0f), Keyframe.ofFloat(0.8f, -6.0f), Keyframe.ofFloat(1.0f, 0.0f)));
            ofPropertyValuesHolder.setDuration(600L);
            return ofPropertyValuesHolder;
        }
        return (ObjectAnimator) invokeV.objValue;
    }

    @Override // c.a.p0.h.o0.g.a
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.k = false;
            this.f11461h.removeCallbacksAndMessages(null);
            c.a.p0.h.o0.b.d(this.f11462i);
        }
    }

    @Override // c.a.p0.h.o0.g.b.b
    public void e(c.a.p0.h.o0.g.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f11459f = aVar;
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

    public final c.a.p0.a.l1.e.a.a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.p0.a.l1.e.a.a aVar = new c.a.p0.a.l1.e.a.a();
            aVar.o(g.a(this.m.left) - this.f11463j);
            aVar.p(g.a(this.m.top) - this.f11463j);
            aVar.q(-2);
            aVar.m(-2);
            return aVar;
        }
        return (c.a.p0.a.l1.e.a.a) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.l = d();
            this.f11461h = new HandlerC0588a(this, Looper.getMainLooper());
        }
    }

    @Override // c.a.p0.h.o0.g.a
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.k = false;
            this.f11461h.removeMessages(1);
            this.f11462i.setVisibility(8);
        }
    }

    @SuppressLint({"InflateParams"})
    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? LayoutInflater.from(this.f11458e).inflate(f.swangame_recommend_button, (ViewGroup) null) : (View) invokeV.objValue;
    }

    public final void j(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            this.f11463j = (int) this.f11458e.getResources().getDimension(c.a.p0.f.c.swangame_recommend_button_root_padding);
            this.f11462i = new FrameLayout(this.f11458e);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g.a(this.m.width), g.a(this.m.height));
            int i2 = this.f11463j;
            layoutParams.setMargins(i2, i2, i2, i2);
            this.f11462i.setBackgroundColor(0);
            this.f11462i.addView(view, layoutParams);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.l.start();
        }
    }

    @Override // c.a.p0.h.o0.g.b.b
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && this.k) {
            this.f11461h.removeMessages(1);
            if (z) {
                this.f11461h.sendEmptyMessage(1);
            }
        }
    }

    @Override // c.a.p0.h.o0.g.a
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.k = true;
            this.f11462i.setVisibility(0);
            this.f11461h.removeMessages(1);
            this.f11461h.sendEmptyMessage(1);
        }
    }

    @Override // c.a.p0.h.o0.g.b.b
    public void t(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.f11460g = bVar;
        }
    }
}
