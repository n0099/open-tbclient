package c.a.n0.j.p0.g.b;

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
import c.a.n0.j.n0.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@UiThread
/* loaded from: classes2.dex */
public class a implements c.a.n0.j.p0.g.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.n0.j.p0.g.e.a f8888b;

    /* renamed from: c  reason: collision with root package name */
    public b f8889c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f8890d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f8891e;

    /* renamed from: f  reason: collision with root package name */
    public int f8892f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f8893g;

    /* renamed from: h  reason: collision with root package name */
    public ObjectAnimator f8894h;
    public d i;

    /* renamed from: c.a.n0.j.p0.g.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC0726a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC0726a(a aVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if (f2 > 0 && this.a.f8893g) {
                    this.a.f8890d.sendEmptyMessageDelayed(1, f2);
                }
                this.a.k();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void c();

        void p();

        void v(int i);
    }

    public a(@NonNull Context context, @NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.i = dVar;
        j(i());
        h();
        b();
    }

    @NonNull
    public static a c(int i, @NonNull Context context, @NonNull d dVar) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65538, null, i, context, dVar)) == null) {
            if (i != 1) {
                if (i != 2) {
                    return new c.a.n0.j.p0.g.c.a(context, dVar);
                }
                return new c.a.n0.j.p0.g.d.a(context, dVar);
            }
            return new c.a.n0.j.p0.g.c.a(context, dVar);
        }
        return (a) invokeILL.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f8891e.setVisibility(8);
            c.a.n0.j.p0.b.a(this.f8891e, g());
        }
    }

    public final ObjectAnimator d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f8891e, PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.2f, 6.0f), Keyframe.ofFloat(0.4f, -6.0f), Keyframe.ofFloat(0.6f, 6.0f), Keyframe.ofFloat(0.8f, -6.0f), Keyframe.ofFloat(1.0f, 0.0f)));
            ofPropertyValuesHolder.setDuration(600L);
            return ofPropertyValuesHolder;
        }
        return (ObjectAnimator) invokeV.objValue;
    }

    @Override // c.a.n0.j.p0.g.a
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f8893g = false;
            this.f8890d.removeCallbacksAndMessages(null);
            c.a.n0.j.p0.b.d(this.f8891e);
        }
    }

    @Override // c.a.n0.j.p0.g.b.b
    public void e(c.a.n0.j.p0.g.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f8888b = aVar;
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

    public final c.a.n0.a.c1.e.a.a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.n0.a.c1.e.a.a aVar = new c.a.n0.a.c1.e.a.a();
            aVar.l(g.a(this.i.left) - this.f8892f);
            aVar.m(g.a(this.i.top) - this.f8892f);
            aVar.n(-2);
            aVar.j(-2);
            return aVar;
        }
        return (c.a.n0.a.c1.e.a.a) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f8894h = d();
            this.f8890d = new HandlerC0726a(this, Looper.getMainLooper());
        }
    }

    @Override // c.a.n0.j.p0.g.a
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f8893g = false;
            this.f8890d.removeMessages(1);
            this.f8891e.setVisibility(8);
        }
    }

    @SuppressLint({"InflateParams"})
    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d07ee, (ViewGroup) null) : (View) invokeV.objValue;
    }

    public final void j(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            this.f8892f = (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0706bb);
            this.f8891e = new FrameLayout(this.a);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g.a(this.i.width), g.a(this.i.height));
            int i = this.f8892f;
            layoutParams.setMargins(i, i, i, i);
            this.f8891e.setBackgroundColor(0);
            this.f8891e.addView(view, layoutParams);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f8894h.start();
        }
    }

    @Override // c.a.n0.j.p0.g.b.b
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && this.f8893g) {
            this.f8890d.removeMessages(1);
            if (z) {
                this.f8890d.sendEmptyMessage(1);
            }
        }
    }

    @Override // c.a.n0.j.p0.g.a
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f8893g = true;
            this.f8891e.setVisibility(0);
            this.f8890d.removeMessages(1);
            this.f8890d.sendEmptyMessage(1);
        }
    }

    @Override // c.a.n0.j.p0.g.b.b
    public void u(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.f8889c = bVar;
        }
    }

    @Override // c.a.n0.j.p0.g.b.b
    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            c.a.n0.j.p0.b.f(this.f8891e, g());
        }
    }
}
