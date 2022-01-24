package c.a.t0.y1.q;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import c.a.d.f.m.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.indicator.SlidingTabLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public View f25538b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f25539c;

    /* renamed from: d  reason: collision with root package name */
    public SlidingTabLayout f25540d;

    /* renamed from: e  reason: collision with root package name */
    public Context f25541e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f25542f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f25543g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f25544h;

    /* renamed from: i  reason: collision with root package name */
    public d f25545i;

    /* renamed from: c.a.t0.y1.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1539a extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1539a(a aVar) {
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
            this.a = aVar;
        }

        @Override // c.a.d.f.m.d
        public void a(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.a.f25539c == null) {
                return;
            }
            if (animation == this.a.f25542f) {
                this.a.f25539c.setVisibility(0);
                this.a.f25539c.setClickable(true);
            } else if (animation == this.a.f25543g) {
                this.a.f25539c.setVisibility(8);
                this.a.f25539c.setClickable(false);
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
        this.f25544h = true;
        this.f25545i = new C1539a(this);
        this.f25538b = view;
        this.f25541e = context;
        this.f25539c = (TextView) view.findViewById(R.id.tab_widget_switch);
        this.a = (ImageView) view.findViewById(R.id.tab_widget_more);
        this.f25540d = (SlidingTabLayout) view.findViewById(R.id.tab_widget_sliding_tab);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f25544h = true;
            TextView textView = this.f25539c;
            if (textView != null) {
                textView.clearAnimation();
                this.f25539c.startAnimation(f());
            }
            SkinManager.setImageResource(this.a, R.drawable.lego_icon_triangle_down_normal);
        }
    }

    public final Animation e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f25542f == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f25541e, R.anim.fade_in);
                this.f25542f = loadAnimation;
                loadAnimation.setAnimationListener(this.f25545i);
            }
            return this.f25542f;
        }
        return (Animation) invokeV.objValue;
    }

    public final Animation f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f25543g == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f25541e, R.anim.fade_out);
                this.f25543g = loadAnimation;
                loadAnimation.setAnimationListener(this.f25545i);
            }
            return this.f25543g;
        }
        return (Animation) invokeV.objValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f25538b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f25539c, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.f25539c, R.color.CAM_X0106, 1);
            if (this.f25544h) {
                SkinManager.setImageResource(this.a, R.drawable.lego_icon_triangle_down_normal);
            } else {
                SkinManager.setImageResource(this.a, R.drawable.lego_icon_triangle_up_normal);
            }
            SkinManager.setBackgroundResource(this.a, R.drawable.lego_btn_more_selector);
            SlidingTabLayout slidingTabLayout = this.f25540d;
            if (slidingTabLayout != null) {
                slidingTabLayout.onChangeSkinType(i2);
            }
        }
    }

    public void h(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) || (imageView = this.a) == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public void i(ViewPager viewPager, int i2) {
        SlidingTabLayout slidingTabLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, viewPager, i2) == null) || (slidingTabLayout = this.f25540d) == null) {
            return;
        }
        slidingTabLayout.setViewPager(viewPager, i2);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f25544h = false;
            TextView textView = this.f25539c;
            if (textView != null) {
                textView.clearAnimation();
                this.f25539c.setVisibility(0);
                this.f25539c.startAnimation(e());
            }
            SkinManager.setImageResource(this.a, R.drawable.lego_icon_triangle_up_normal);
        }
    }
}
