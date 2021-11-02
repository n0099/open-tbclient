package b.a.r0.j1.o.f;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import b.a.r0.j1.d;
import b.a.r0.j1.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.hottopic.view.indicator.SlidingTabLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f18550a;

    /* renamed from: b  reason: collision with root package name */
    public View f18551b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f18552c;

    /* renamed from: d  reason: collision with root package name */
    public View f18553d;

    /* renamed from: e  reason: collision with root package name */
    public SlidingTabLayout f18554e;

    /* renamed from: f  reason: collision with root package name */
    public Context f18555f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f18556g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f18557h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f18558i;
    public Animation.AnimationListener j;

    /* renamed from: b.a.r0.j1.o.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class animation.Animation$AnimationListenerC0939a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f18559a;

        public animation.Animation$AnimationListenerC0939a(a aVar) {
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
            this.f18559a = aVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f18559a.f18552c == null) {
                return;
            }
            if (animation == this.f18559a.f18556g) {
                this.f18559a.f18552c.setVisibility(0);
                this.f18559a.f18552c.setClickable(true);
            } else if (animation == this.f18559a.f18557h) {
                this.f18559a.f18552c.setVisibility(8);
                this.f18559a.f18552c.setClickable(false);
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
        this.f18558i = true;
        this.j = new animation.Animation$AnimationListenerC0939a(this);
        this.f18555f = context;
        this.f18551b = view;
        this.f18552c = (TextView) view.findViewById(e.topic_tab_widget_switch);
        this.f18553d = view.findViewById(e.topic_tab_widget_line);
        ImageView imageView = (ImageView) view.findViewById(e.topic_tab_widget_more);
        this.f18550a = imageView;
        imageView.setContentDescription("展开");
        this.f18554e = (SlidingTabLayout) view.findViewById(e.topic_tab_widget_sliding_tab);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f18558i = true;
            TextView textView = this.f18552c;
            if (textView != null) {
                textView.clearAnimation();
                this.f18552c.startAnimation(f());
            }
            if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
                this.f18550a.setImageResource(d.icon_topic_triangle_down_normal);
                this.f18550a.setBackgroundResource(d.rec_topic_btn_more_selector);
            } else {
                this.f18550a.setImageResource(d.icon_topic_triangle_down_normal_1);
                this.f18550a.setBackgroundResource(d.rec_topic_btn_more_selector_1);
            }
            this.f18554e.setDrawBottomLine(true);
            this.f18553d.setVisibility(0);
        }
    }

    public final Animation e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f18556g == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f18555f, b.a.r0.j1.a.fade_in);
                this.f18556g = loadAnimation;
                loadAnimation.setAnimationListener(this.j);
            }
            return this.f18556g;
        }
        return (Animation) invokeV.objValue;
    }

    public final Animation f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f18557h == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f18555f, b.a.r0.j1.a.fade_out);
                this.f18557h = loadAnimation;
                loadAnimation.setAnimationListener(this.j);
            }
            return this.f18557h;
        }
        return (Animation) invokeV.objValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f18551b, b.a.r0.j1.b.common_color_10274);
            SkinManager.setBackgroundColor(this.f18552c, b.a.r0.j1.b.CAM_X0205);
            SkinManager.setViewTextColor(this.f18552c, b.a.r0.j1.b.CAM_X0106, 1);
            SkinManager.setBackgroundColor(this.f18553d, b.a.r0.j1.b.CAM_X0204);
            if (this.f18558i) {
                if (1 != i2 && 4 != i2) {
                    this.f18550a.setImageResource(d.icon_topic_triangle_down_normal);
                    this.f18550a.setBackgroundResource(d.rec_topic_btn_more_selector);
                } else {
                    this.f18550a.setImageResource(d.icon_topic_triangle_down_normal_1);
                    this.f18550a.setBackgroundResource(d.rec_topic_btn_more_selector_1);
                }
            } else if (1 != i2 && 4 != i2) {
                this.f18550a.setImageResource(d.icon_topic_triangle_up_normal);
                this.f18550a.setBackgroundResource(d.rec_topic_btn_more_up_selector);
            } else {
                this.f18550a.setImageResource(d.icon_topic_triangle_up_normal_1);
                this.f18550a.setBackgroundResource(d.rec_topic_btn_more_up_selector_1);
            }
            SlidingTabLayout slidingTabLayout = this.f18554e;
            if (slidingTabLayout != null) {
                slidingTabLayout.onChangeSkinType(i2);
            }
        }
    }

    public void h(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) || (imageView = this.f18550a) == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public void i(ViewPager viewPager) {
        SlidingTabLayout slidingTabLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, viewPager) == null) || (slidingTabLayout = this.f18554e) == null) {
            return;
        }
        slidingTabLayout.setViewPager(viewPager);
    }

    public void j(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (view = this.f18551b) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f18558i = false;
            TextView textView = this.f18552c;
            if (textView != null) {
                textView.clearAnimation();
                this.f18552c.setVisibility(0);
                this.f18552c.startAnimation(e());
            }
            if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
                this.f18550a.setImageResource(d.icon_topic_triangle_up_normal);
                this.f18550a.setBackgroundResource(d.rec_topic_btn_more_up_selector);
            } else {
                this.f18550a.setImageResource(d.icon_topic_triangle_up_normal_1);
                this.f18550a.setBackgroundResource(d.rec_topic_btn_more_up_selector_1);
            }
            this.f18554e.setDrawBottomLine(false);
            this.f18553d.setVisibility(8);
        }
    }
}
