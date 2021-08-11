package c.a.p0.o1.q;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import c.a.e.e.m.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.indicator.SlidingTabLayout;
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
    public ImageView f22745a;

    /* renamed from: b  reason: collision with root package name */
    public View f22746b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f22747c;

    /* renamed from: d  reason: collision with root package name */
    public SlidingTabLayout f22748d;

    /* renamed from: e  reason: collision with root package name */
    public Context f22749e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f22750f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f22751g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22752h;

    /* renamed from: i  reason: collision with root package name */
    public d f22753i;

    /* renamed from: c.a.p0.o1.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1057a extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f22754a;

        public C1057a(a aVar) {
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
            this.f22754a = aVar;
        }

        @Override // c.a.e.e.m.d
        public void a(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f22754a.f22747c == null) {
                return;
            }
            if (animation == this.f22754a.f22750f) {
                this.f22754a.f22747c.setVisibility(0);
                this.f22754a.f22747c.setClickable(true);
            } else if (animation == this.f22754a.f22751g) {
                this.f22754a.f22747c.setVisibility(8);
                this.f22754a.f22747c.setClickable(false);
            }
        }
    }

    public a(Context context, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22752h = true;
        this.f22753i = new C1057a(this);
        this.f22746b = view;
        this.f22749e = context;
        this.f22747c = (TextView) view.findViewById(R.id.tab_widget_switch);
        this.f22745a = (ImageView) view.findViewById(R.id.tab_widget_more);
        this.f22748d = (SlidingTabLayout) view.findViewById(R.id.tab_widget_sliding_tab);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22752h = true;
            TextView textView = this.f22747c;
            if (textView != null) {
                textView.clearAnimation();
                this.f22747c.startAnimation(f());
            }
            SkinManager.setImageResource(this.f22745a, R.drawable.lego_icon_triangle_down_normal);
        }
    }

    public final Animation e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f22750f == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f22749e, R.anim.fade_in);
                this.f22750f = loadAnimation;
                loadAnimation.setAnimationListener(this.f22753i);
            }
            return this.f22750f;
        }
        return (Animation) invokeV.objValue;
    }

    public final Animation f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f22751g == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f22749e, R.anim.fade_out);
                this.f22751g = loadAnimation;
                loadAnimation.setAnimationListener(this.f22753i);
            }
            return this.f22751g;
        }
        return (Animation) invokeV.objValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f22746b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f22747c, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.f22747c, R.color.CAM_X0106, 1);
            if (this.f22752h) {
                SkinManager.setImageResource(this.f22745a, R.drawable.lego_icon_triangle_down_normal);
            } else {
                SkinManager.setImageResource(this.f22745a, R.drawable.lego_icon_triangle_up_normal);
            }
            SkinManager.setBackgroundResource(this.f22745a, R.drawable.lego_btn_more_selector);
            SlidingTabLayout slidingTabLayout = this.f22748d;
            if (slidingTabLayout != null) {
                slidingTabLayout.onChangeSkinType(i2);
            }
        }
    }

    public void h(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) || (imageView = this.f22745a) == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public void i(ViewPager viewPager, int i2) {
        SlidingTabLayout slidingTabLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, viewPager, i2) == null) || (slidingTabLayout = this.f22748d) == null) {
            return;
        }
        slidingTabLayout.setViewPager(viewPager, i2);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f22752h = false;
            TextView textView = this.f22747c;
            if (textView != null) {
                textView.clearAnimation();
                this.f22747c.setVisibility(0);
                this.f22747c.startAnimation(e());
            }
            SkinManager.setImageResource(this.f22745a, R.drawable.lego_icon_triangle_up_normal);
        }
    }
}
