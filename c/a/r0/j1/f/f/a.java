package c.a.r0.j1.f.f;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.indicator.SlidingTabLayout;
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
    public ImageView f19576a;

    /* renamed from: b  reason: collision with root package name */
    public View f19577b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19578c;

    /* renamed from: d  reason: collision with root package name */
    public View f19579d;

    /* renamed from: e  reason: collision with root package name */
    public SlidingTabLayout f19580e;

    /* renamed from: f  reason: collision with root package name */
    public Context f19581f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f19582g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f19583h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19584i;

    /* renamed from: j  reason: collision with root package name */
    public Animation.AnimationListener f19585j;

    /* renamed from: c.a.r0.j1.f.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class animation.Animation$AnimationListenerC0941a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f19586a;

        public animation.Animation$AnimationListenerC0941a(a aVar) {
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
            this.f19586a = aVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f19586a.f19578c == null) {
                return;
            }
            if (animation == this.f19586a.f19582g) {
                this.f19586a.f19578c.setVisibility(0);
                this.f19586a.f19578c.setClickable(true);
            } else if (animation == this.f19586a.f19583h) {
                this.f19586a.f19578c.setVisibility(8);
                this.f19586a.f19578c.setClickable(false);
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
        this.f19584i = true;
        this.f19585j = new animation.Animation$AnimationListenerC0941a(this);
        this.f19581f = context;
        this.f19577b = view;
        this.f19578c = (TextView) view.findViewById(R.id.topic_tab_widget_switch);
        this.f19579d = view.findViewById(R.id.topic_tab_widget_line);
        ImageView imageView = (ImageView) view.findViewById(R.id.topic_tab_widget_more);
        this.f19576a = imageView;
        imageView.setContentDescription("展开");
        this.f19580e = (SlidingTabLayout) view.findViewById(R.id.topic_tab_widget_sliding_tab);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f19584i = true;
            TextView textView = this.f19578c;
            if (textView != null) {
                textView.clearAnimation();
                this.f19578c.startAnimation(f());
            }
            if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
                this.f19576a.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                this.f19576a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
            } else {
                this.f19576a.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                this.f19576a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
            }
            this.f19580e.setDrawBottomLine(true);
            this.f19579d.setVisibility(0);
        }
    }

    public final Animation e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f19582g == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f19581f, R.anim.fade_in);
                this.f19582g = loadAnimation;
                loadAnimation.setAnimationListener(this.f19585j);
            }
            return this.f19582g;
        }
        return (Animation) invokeV.objValue;
    }

    public final Animation f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f19583h == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f19581f, R.anim.fade_out);
                this.f19583h = loadAnimation;
                loadAnimation.setAnimationListener(this.f19585j);
            }
            return this.f19583h;
        }
        return (Animation) invokeV.objValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f19577b, R.color.common_color_10274);
            SkinManager.setBackgroundColor(this.f19578c, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.f19578c, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundColor(this.f19579d, R.color.CAM_X0204);
            if (this.f19584i) {
                if (1 != i2 && 4 != i2) {
                    this.f19576a.setImageResource(R.drawable.icon_topic_triangle_down_normal);
                    this.f19576a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector);
                } else {
                    this.f19576a.setImageResource(R.drawable.icon_topic_triangle_down_normal_1);
                    this.f19576a.setBackgroundResource(R.drawable.rec_topic_btn_more_selector_1);
                }
            } else if (1 != i2 && 4 != i2) {
                this.f19576a.setImageResource(R.drawable.icon_topic_triangle_up_normal);
                this.f19576a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
            } else {
                this.f19576a.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
                this.f19576a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
            }
            SlidingTabLayout slidingTabLayout = this.f19580e;
            if (slidingTabLayout != null) {
                slidingTabLayout.onChangeSkinType(i2);
            }
        }
    }

    public void h(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) || (imageView = this.f19576a) == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public void i(ViewPager viewPager) {
        SlidingTabLayout slidingTabLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, viewPager) == null) || (slidingTabLayout = this.f19580e) == null) {
            return;
        }
        slidingTabLayout.setViewPager(viewPager);
    }

    public void j(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (view = this.f19577b) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f19584i = false;
            TextView textView = this.f19578c;
            if (textView != null) {
                textView.clearAnimation();
                this.f19578c.setVisibility(0);
                this.f19578c.startAnimation(e());
            }
            if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
                this.f19576a.setImageResource(R.drawable.icon_topic_triangle_up_normal);
                this.f19576a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector);
            } else {
                this.f19576a.setImageResource(R.drawable.icon_topic_triangle_up_normal_1);
                this.f19576a.setBackgroundResource(R.drawable.rec_topic_btn_more_up_selector_1);
            }
            this.f19580e.setDrawBottomLine(false);
            this.f19579d.setVisibility(8);
        }
    }
}
