package c.a.r0.o0.m;

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
import c.a.e.e.m.g;
import c.a.e.e.p.l;
import c.a.q0.d1.o;
import c.a.r0.o0.d.h;
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
/* loaded from: classes3.dex */
public class a extends PopupWindow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f22971a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f22972b;

    /* renamed from: c  reason: collision with root package name */
    public d f22973c;

    /* renamed from: d  reason: collision with root package name */
    public View f22974d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f22975e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22976f;

    /* renamed from: g  reason: collision with root package name */
    public int f22977g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f22978h;

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f22979i;

    /* renamed from: c.a.r0.o0.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1071a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22980e;

        public View$OnClickListenerC1071a(a aVar) {
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
            this.f22980e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f22980e.f22975e) {
                    if (this.f22980e.f22973c != null) {
                        this.f22980e.f22973c.onItemClick(1);
                    }
                } else if (view == this.f22980e.f22976f && this.f22980e.f22973c != null) {
                    this.f22980e.f22973c.onItemClick(2);
                }
                this.f22980e.i();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22981e;

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
            this.f22981e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22981e.i();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f22982a;

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
            this.f22982a = aVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f22982a.g();
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

    /* loaded from: classes3.dex */
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
        this.f22978h = new View$OnClickListenerC1071a(this);
        this.f22979i = new b(this);
        this.f22971a = context;
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
            View inflate = LayoutInflater.from(this.f22971a).inflate(R.layout.layout_sort_select, (ViewGroup) null);
            this.f22974d = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.sort_type_level_text);
            this.f22975e = textView;
            c.a.q0.s.u.c.d(textView).A(R.string.F_X01);
            TextView textView2 = (TextView) this.f22974d.findViewById(R.id.sort_type_update_text);
            this.f22976f = textView2;
            c.a.q0.s.u.c.d(textView2).A(R.string.F_X01);
            this.f22975e.setOnClickListener(this.f22978h);
            this.f22976f.setOnClickListener(this.f22978h);
        }
    }

    public final View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            e();
            FrameLayout frameLayout = new FrameLayout(this.f22971a);
            FrameLayout frameLayout2 = new FrameLayout(this.f22971a);
            this.f22972b = frameLayout2;
            frameLayout.addView(frameLayout2);
            frameLayout.addView(this.f22974d);
            this.f22972b.setOnClickListener(this.f22979i);
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0901).setShapeRadius(l.g(this.f22971a, R.dimen.tbds10)).setShadowColor(R.color.CAM_X0804).setShadowRadius(l.g(this.f22971a, R.dimen.tbds21)).setOffsetX(0).setOffsetY(l.g(this.f22971a, R.dimen.tbds4)).into(this.f22974d);
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
        this.f22974d.startAnimation(translateAnimation);
        this.f22972b.startAnimation(alphaAnimation);
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
            if (this.f22977g == 1) {
                SkinManager.setViewTextColor(this.f22975e, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f22976f, R.color.CAM_X0108);
            } else {
                SkinManager.setViewTextColor(this.f22976f, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f22975e, R.color.CAM_X0108);
            }
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0901).setShapeRadius(l.g(this.f22971a, R.dimen.tbds10)).setShadowColor(R.color.CAM_X0804).setShadowRadius(l.g(this.f22971a, R.dimen.tbds21)).setOffsetX(0).setOffsetY(l.g(this.f22971a, R.dimen.tbds4)).into(this.f22974d);
        }
    }

    public void k(List<h> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, list, i2) == null) || list == null) {
            return;
        }
        this.f22977g = i2;
        View f2 = f();
        for (h hVar : list) {
            if (hVar.f22705b == 1) {
                this.f22975e.setText(hVar.f22704a);
            } else {
                this.f22976f.setText(hVar.f22704a);
            }
            if (i2 == 1) {
                SkinManager.setViewTextColor(this.f22975e, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f22976f, R.color.CAM_X0108);
            } else {
                SkinManager.setViewTextColor(this.f22976f, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f22975e, R.color.CAM_X0108);
            }
        }
        setContentView(f2);
    }

    public void l(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            this.f22973c = dVar;
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
            this.f22974d.startAnimation(translateAnimation);
            this.f22972b.startAnimation(alphaAnimation);
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
        if (g.m(this, view, 0, iArr[0] - this.f22971a.getResources().getDimensionPixelOffset(R.dimen.tbds44), iArr[1] + view.getHeight() + this.f22971a.getResources().getDimensionPixelOffset(R.dimen.tbds20))) {
            n();
        }
    }
}
