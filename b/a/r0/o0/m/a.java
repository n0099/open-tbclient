package b.a.r0.o0.m;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.m.g;
import b.a.e.f.p.l;
import b.a.q0.c1.o;
import b.a.r0.o0.d.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends PopupWindow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f23337a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f23338b;

    /* renamed from: c  reason: collision with root package name */
    public d f23339c;

    /* renamed from: d  reason: collision with root package name */
    public View f23340d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f23341e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f23342f;

    /* renamed from: g  reason: collision with root package name */
    public int f23343g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f23344h;

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f23345i;

    /* renamed from: b.a.r0.o0.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1136a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23346e;

        public View$OnClickListenerC1136a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23346e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f23346e.f23341e) {
                    if (this.f23346e.f23339c != null) {
                        this.f23346e.f23339c.onItemClick(1);
                    }
                } else if (view == this.f23346e.f23342f && this.f23346e.f23339c != null) {
                    this.f23346e.f23339c.onItemClick(2);
                }
                this.f23346e.i();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23347e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23347e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23347e.i();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f23348a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23348a = aVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f23348a.g();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void onItemClick(int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23344h = new View$OnClickListenerC1136a(this);
        this.f23345i = new b(this);
        this.f23337a = context;
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(this.f23337a).inflate(R.layout.layout_sort_select, (ViewGroup) null);
            this.f23340d = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.sort_type_level_text);
            this.f23341e = textView;
            b.a.q0.s.u.c.d(textView).A(R.string.F_X01);
            TextView textView2 = (TextView) this.f23340d.findViewById(R.id.sort_type_update_text);
            this.f23342f = textView2;
            b.a.q0.s.u.c.d(textView2).A(R.string.F_X01);
            this.f23341e.setOnClickListener(this.f23344h);
            this.f23342f.setOnClickListener(this.f23344h);
        }
    }

    public final View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            e();
            FrameLayout frameLayout = new FrameLayout(this.f23337a);
            FrameLayout frameLayout2 = new FrameLayout(this.f23337a);
            this.f23338b = frameLayout2;
            frameLayout.addView(frameLayout2);
            frameLayout.addView(this.f23340d);
            this.f23338b.setOnClickListener(this.f23345i);
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0901).setShapeRadius(l.g(this.f23337a, R.dimen.tbds10)).setShadowColor(R.color.CAM_X0804).setShadowRadius(l.g(this.f23337a, R.dimen.tbds21)).setOffsetX(0).setOffsetY(l.g(this.f23337a, R.dimen.tbds4)).into(this.f23340d);
            return frameLayout;
        }
        return (View) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.dismiss();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || o.a()) {
            return;
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(240L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setAnimationListener(new c(this));
        this.f23340d.startAnimation(translateAnimation);
        this.f23338b.startAnimation(alphaAnimation);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f23343g == 1) {
                SkinManager.setViewTextColor(this.f23341e, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f23342f, R.color.CAM_X0108);
            } else {
                SkinManager.setViewTextColor(this.f23342f, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f23341e, R.color.CAM_X0108);
            }
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0901).setShapeRadius(l.g(this.f23337a, R.dimen.tbds10)).setShadowColor(R.color.CAM_X0804).setShadowRadius(l.g(this.f23337a, R.dimen.tbds21)).setOffsetX(0).setOffsetY(l.g(this.f23337a, R.dimen.tbds4)).into(this.f23340d);
        }
    }

    public void k(List<h> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, list, i2) == null) || list == null) {
            return;
        }
        this.f23343g = i2;
        View f2 = f();
        for (h hVar : list) {
            if (hVar.f23079b == 1) {
                this.f23341e.setText(hVar.f23078a);
            } else {
                this.f23342f.setText(hVar.f23078a);
            }
            if (i2 == 1) {
                SkinManager.setViewTextColor(this.f23341e, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f23342f, R.color.CAM_X0108);
            } else {
                SkinManager.setViewTextColor(this.f23342f, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f23341e, R.color.CAM_X0108);
            }
        }
        setContentView(f2);
    }

    public void l(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            this.f23339c = dVar;
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
            translateAnimation.setDuration(350L);
            translateAnimation.setInterpolator(new DecelerateInterpolator());
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(350L);
            alphaAnimation.setInterpolator(new LinearInterpolator());
            this.f23340d.startAnimation(translateAnimation);
            this.f23338b.startAnimation(alphaAnimation);
        }
    }

    public void o(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, view) == null) || view == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 24) {
            if (g.k(this, view)) {
                n();
                return;
            }
            return;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        if (g.m(this, view, 0, iArr[0] - this.f23337a.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.f23337a.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
            n();
        }
    }
}
