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
    public ImageView f19884a;

    /* renamed from: b  reason: collision with root package name */
    public View f19885b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19886c;

    /* renamed from: d  reason: collision with root package name */
    public View f19887d;

    /* renamed from: e  reason: collision with root package name */
    public SlidingTabLayout f19888e;

    /* renamed from: f  reason: collision with root package name */
    public Context f19889f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f19890g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f19891h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19892i;
    public Animation.AnimationListener j;

    /* renamed from: b.a.r0.j1.o.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class animation.Animation$AnimationListenerC1000a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f19893a;

        public animation.Animation$AnimationListenerC1000a(a aVar) {
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
            this.f19893a = aVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f19893a.f19886c == null) {
                return;
            }
            if (animation == this.f19893a.f19890g) {
                this.f19893a.f19886c.setVisibility(0);
                this.f19893a.f19886c.setClickable(true);
            } else if (animation == this.f19893a.f19891h) {
                this.f19893a.f19886c.setVisibility(8);
                this.f19893a.f19886c.setClickable(false);
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
        this.f19892i = true;
        this.j = new animation.Animation$AnimationListenerC1000a(this);
        this.f19889f = context;
        this.f19885b = view;
        this.f19886c = (TextView) view.findViewById(e.topic_tab_widget_switch);
        this.f19887d = view.findViewById(e.topic_tab_widget_line);
        ImageView imageView = (ImageView) view.findViewById(e.topic_tab_widget_more);
        this.f19884a = imageView;
        imageView.setContentDescription("展开");
        this.f19888e = (SlidingTabLayout) view.findViewById(e.topic_tab_widget_sliding_tab);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f19892i = true;
            TextView textView = this.f19886c;
            if (textView != null) {
                textView.clearAnimation();
                this.f19886c.startAnimation(f());
            }
            if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
                this.f19884a.setImageResource(d.icon_topic_triangle_down_normal);
                this.f19884a.setBackgroundResource(d.rec_topic_btn_more_selector);
            } else {
                this.f19884a.setImageResource(d.icon_topic_triangle_down_normal_1);
                this.f19884a.setBackgroundResource(d.rec_topic_btn_more_selector_1);
            }
            this.f19888e.setDrawBottomLine(true);
            this.f19887d.setVisibility(0);
        }
    }

    public final Animation e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f19890g == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f19889f, b.a.r0.j1.a.fade_in);
                this.f19890g = loadAnimation;
                loadAnimation.setAnimationListener(this.j);
            }
            return this.f19890g;
        }
        return (Animation) invokeV.objValue;
    }

    public final Animation f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f19891h == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f19889f, b.a.r0.j1.a.fade_out);
                this.f19891h = loadAnimation;
                loadAnimation.setAnimationListener(this.j);
            }
            return this.f19891h;
        }
        return (Animation) invokeV.objValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f19885b, b.a.r0.j1.b.common_color_10274);
            SkinManager.setBackgroundColor(this.f19886c, b.a.r0.j1.b.CAM_X0205);
            SkinManager.setViewTextColor(this.f19886c, b.a.r0.j1.b.CAM_X0106, 1);
            SkinManager.setBackgroundColor(this.f19887d, b.a.r0.j1.b.CAM_X0204);
            if (this.f19892i) {
                if (1 != i2 && 4 != i2) {
                    this.f19884a.setImageResource(d.icon_topic_triangle_down_normal);
                    this.f19884a.setBackgroundResource(d.rec_topic_btn_more_selector);
                } else {
                    this.f19884a.setImageResource(d.icon_topic_triangle_down_normal_1);
                    this.f19884a.setBackgroundResource(d.rec_topic_btn_more_selector_1);
                }
            } else if (1 != i2 && 4 != i2) {
                this.f19884a.setImageResource(d.icon_topic_triangle_up_normal);
                this.f19884a.setBackgroundResource(d.rec_topic_btn_more_up_selector);
            } else {
                this.f19884a.setImageResource(d.icon_topic_triangle_up_normal_1);
                this.f19884a.setBackgroundResource(d.rec_topic_btn_more_up_selector_1);
            }
            SlidingTabLayout slidingTabLayout = this.f19888e;
            if (slidingTabLayout != null) {
                slidingTabLayout.onChangeSkinType(i2);
            }
        }
    }

    public void h(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) || (imageView = this.f19884a) == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public void i(ViewPager viewPager) {
        SlidingTabLayout slidingTabLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, viewPager) == null) || (slidingTabLayout = this.f19888e) == null) {
            return;
        }
        slidingTabLayout.setViewPager(viewPager);
    }

    public void j(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (view = this.f19885b) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f19892i = false;
            TextView textView = this.f19886c;
            if (textView != null) {
                textView.clearAnimation();
                this.f19886c.setVisibility(0);
                this.f19886c.startAnimation(e());
            }
            if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
                this.f19884a.setImageResource(d.icon_topic_triangle_up_normal);
                this.f19884a.setBackgroundResource(d.rec_topic_btn_more_up_selector);
            } else {
                this.f19884a.setImageResource(d.icon_topic_triangle_up_normal_1);
                this.f19884a.setBackgroundResource(d.rec_topic_btn_more_up_selector_1);
            }
            this.f19888e.setDrawBottomLine(false);
            this.f19887d.setVisibility(8);
        }
    }
}
