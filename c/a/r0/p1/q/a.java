package c.a.r0.p1.q;

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
    public ImageView f23683a;

    /* renamed from: b  reason: collision with root package name */
    public View f23684b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f23685c;

    /* renamed from: d  reason: collision with root package name */
    public SlidingTabLayout f23686d;

    /* renamed from: e  reason: collision with root package name */
    public Context f23687e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f23688f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f23689g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23690h;

    /* renamed from: i  reason: collision with root package name */
    public d f23691i;

    /* renamed from: c.a.r0.p1.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1101a extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f23692a;

        public C1101a(a aVar) {
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
            this.f23692a = aVar;
        }

        @Override // c.a.e.e.m.d
        public void a(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f23692a.f23685c == null) {
                return;
            }
            if (animation == this.f23692a.f23688f) {
                this.f23692a.f23685c.setVisibility(0);
                this.f23692a.f23685c.setClickable(true);
            } else if (animation == this.f23692a.f23689g) {
                this.f23692a.f23685c.setVisibility(8);
                this.f23692a.f23685c.setClickable(false);
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
        this.f23690h = true;
        this.f23691i = new C1101a(this);
        this.f23684b = view;
        this.f23687e = context;
        this.f23685c = (TextView) view.findViewById(R.id.tab_widget_switch);
        this.f23683a = (ImageView) view.findViewById(R.id.tab_widget_more);
        this.f23686d = (SlidingTabLayout) view.findViewById(R.id.tab_widget_sliding_tab);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f23690h = true;
            TextView textView = this.f23685c;
            if (textView != null) {
                textView.clearAnimation();
                this.f23685c.startAnimation(f());
            }
            SkinManager.setImageResource(this.f23683a, R.drawable.lego_icon_triangle_down_normal);
        }
    }

    public final Animation e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f23688f == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f23687e, R.anim.fade_in);
                this.f23688f = loadAnimation;
                loadAnimation.setAnimationListener(this.f23691i);
            }
            return this.f23688f;
        }
        return (Animation) invokeV.objValue;
    }

    public final Animation f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f23689g == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f23687e, R.anim.fade_out);
                this.f23689g = loadAnimation;
                loadAnimation.setAnimationListener(this.f23691i);
            }
            return this.f23689g;
        }
        return (Animation) invokeV.objValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f23684b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f23685c, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.f23685c, R.color.CAM_X0106, 1);
            if (this.f23690h) {
                SkinManager.setImageResource(this.f23683a, R.drawable.lego_icon_triangle_down_normal);
            } else {
                SkinManager.setImageResource(this.f23683a, R.drawable.lego_icon_triangle_up_normal);
            }
            SkinManager.setBackgroundResource(this.f23683a, R.drawable.lego_btn_more_selector);
            SlidingTabLayout slidingTabLayout = this.f23686d;
            if (slidingTabLayout != null) {
                slidingTabLayout.onChangeSkinType(i2);
            }
        }
    }

    public void h(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) || (imageView = this.f23683a) == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public void i(ViewPager viewPager, int i2) {
        SlidingTabLayout slidingTabLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, viewPager, i2) == null) || (slidingTabLayout = this.f23686d) == null) {
            return;
        }
        slidingTabLayout.setViewPager(viewPager, i2);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f23690h = false;
            TextView textView = this.f23685c;
            if (textView != null) {
                textView.clearAnimation();
                this.f23685c.setVisibility(0);
                this.f23685c.startAnimation(e());
            }
            SkinManager.setImageResource(this.f23683a, R.drawable.lego_icon_triangle_up_normal);
        }
    }
}
