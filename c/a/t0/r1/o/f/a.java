package c.a.t0.r1.o.f;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import c.a.t0.r1.d;
import c.a.t0.r1.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.hottopic.view.indicator.SlidingTabLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public View f21952b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f21953c;

    /* renamed from: d  reason: collision with root package name */
    public View f21954d;

    /* renamed from: e  reason: collision with root package name */
    public SlidingTabLayout f21955e;

    /* renamed from: f  reason: collision with root package name */
    public Context f21956f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f21957g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f21958h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21959i;

    /* renamed from: j  reason: collision with root package name */
    public Animation.AnimationListener f21960j;

    /* renamed from: c.a.t0.r1.o.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class animation.Animation$AnimationListenerC1358a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public animation.Animation$AnimationListenerC1358a(a aVar) {
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

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.a.f21953c == null) {
                return;
            }
            if (animation == this.a.f21957g) {
                this.a.f21953c.setVisibility(0);
                this.a.f21953c.setClickable(true);
            } else if (animation == this.a.f21958h) {
                this.a.f21953c.setVisibility(8);
                this.a.f21953c.setClickable(false);
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
        this.f21959i = true;
        this.f21960j = new animation.Animation$AnimationListenerC1358a(this);
        this.f21956f = context;
        this.f21952b = view;
        this.f21953c = (TextView) view.findViewById(e.topic_tab_widget_switch);
        this.f21954d = view.findViewById(e.topic_tab_widget_line);
        ImageView imageView = (ImageView) view.findViewById(e.topic_tab_widget_more);
        this.a = imageView;
        imageView.setContentDescription("展开");
        this.f21955e = (SlidingTabLayout) view.findViewById(e.topic_tab_widget_sliding_tab);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21959i = true;
            TextView textView = this.f21953c;
            if (textView != null) {
                textView.clearAnimation();
                this.f21953c.startAnimation(f());
            }
            if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
                this.a.setImageResource(d.icon_topic_triangle_down_normal);
                this.a.setBackgroundResource(d.rec_topic_btn_more_selector);
            } else {
                this.a.setImageResource(d.icon_topic_triangle_down_normal_1);
                this.a.setBackgroundResource(d.rec_topic_btn_more_selector_1);
            }
            this.f21955e.setDrawBottomLine(true);
            this.f21954d.setVisibility(0);
        }
    }

    public final Animation e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f21957g == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f21956f, c.a.t0.r1.a.fade_in);
                this.f21957g = loadAnimation;
                loadAnimation.setAnimationListener(this.f21960j);
            }
            return this.f21957g;
        }
        return (Animation) invokeV.objValue;
    }

    public final Animation f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f21958h == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f21956f, c.a.t0.r1.a.fade_out);
                this.f21958h = loadAnimation;
                loadAnimation.setAnimationListener(this.f21960j);
            }
            return this.f21958h;
        }
        return (Animation) invokeV.objValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f21952b, c.a.t0.r1.b.common_color_10274);
            SkinManager.setBackgroundColor(this.f21953c, c.a.t0.r1.b.CAM_X0205);
            SkinManager.setViewTextColor(this.f21953c, c.a.t0.r1.b.CAM_X0106, 1);
            SkinManager.setBackgroundColor(this.f21954d, c.a.t0.r1.b.CAM_X0204);
            if (this.f21959i) {
                if (1 != i2 && 4 != i2) {
                    this.a.setImageResource(d.icon_topic_triangle_down_normal);
                    this.a.setBackgroundResource(d.rec_topic_btn_more_selector);
                } else {
                    this.a.setImageResource(d.icon_topic_triangle_down_normal_1);
                    this.a.setBackgroundResource(d.rec_topic_btn_more_selector_1);
                }
            } else if (1 != i2 && 4 != i2) {
                this.a.setImageResource(d.icon_topic_triangle_up_normal);
                this.a.setBackgroundResource(d.rec_topic_btn_more_up_selector);
            } else {
                this.a.setImageResource(d.icon_topic_triangle_up_normal_1);
                this.a.setBackgroundResource(d.rec_topic_btn_more_up_selector_1);
            }
            SlidingTabLayout slidingTabLayout = this.f21955e;
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

    public void i(ViewPager viewPager) {
        SlidingTabLayout slidingTabLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, viewPager) == null) || (slidingTabLayout = this.f21955e) == null) {
            return;
        }
        slidingTabLayout.setViewPager(viewPager);
    }

    public void j(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (view = this.f21952b) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f21959i = false;
            TextView textView = this.f21953c;
            if (textView != null) {
                textView.clearAnimation();
                this.f21953c.setVisibility(0);
                this.f21953c.startAnimation(e());
            }
            if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
                this.a.setImageResource(d.icon_topic_triangle_up_normal);
                this.a.setBackgroundResource(d.rec_topic_btn_more_up_selector);
            } else {
                this.a.setImageResource(d.icon_topic_triangle_up_normal_1);
                this.a.setBackgroundResource(d.rec_topic_btn_more_up_selector_1);
            }
            this.f21955e.setDrawBottomLine(false);
            this.f21954d.setVisibility(8);
        }
    }
}
