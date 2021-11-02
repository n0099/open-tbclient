package b.a.r0.q1.q;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import b.a.e.e.m.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.indicator.SlidingTabLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f22743a;

    /* renamed from: b  reason: collision with root package name */
    public View f22744b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f22745c;

    /* renamed from: d  reason: collision with root package name */
    public SlidingTabLayout f22746d;

    /* renamed from: e  reason: collision with root package name */
    public Context f22747e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f22748f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f22749g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22750h;

    /* renamed from: i  reason: collision with root package name */
    public d f22751i;

    /* renamed from: b.a.r0.q1.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1110a extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f22752a;

        public C1110a(a aVar) {
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
            this.f22752a = aVar;
        }

        @Override // b.a.e.e.m.d
        public void a(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f22752a.f22745c == null) {
                return;
            }
            if (animation == this.f22752a.f22748f) {
                this.f22752a.f22745c.setVisibility(0);
                this.f22752a.f22745c.setClickable(true);
            } else if (animation == this.f22752a.f22749g) {
                this.f22752a.f22745c.setVisibility(8);
                this.f22752a.f22745c.setClickable(false);
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
        this.f22750h = true;
        this.f22751i = new C1110a(this);
        this.f22744b = view;
        this.f22747e = context;
        this.f22745c = (TextView) view.findViewById(R.id.tab_widget_switch);
        this.f22743a = (ImageView) view.findViewById(R.id.tab_widget_more);
        this.f22746d = (SlidingTabLayout) view.findViewById(R.id.tab_widget_sliding_tab);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22750h = true;
            TextView textView = this.f22745c;
            if (textView != null) {
                textView.clearAnimation();
                this.f22745c.startAnimation(f());
            }
            SkinManager.setImageResource(this.f22743a, R.drawable.lego_icon_triangle_down_normal);
        }
    }

    public final Animation e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f22748f == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f22747e, R.anim.fade_in);
                this.f22748f = loadAnimation;
                loadAnimation.setAnimationListener(this.f22751i);
            }
            return this.f22748f;
        }
        return (Animation) invokeV.objValue;
    }

    public final Animation f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f22749g == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f22747e, R.anim.fade_out);
                this.f22749g = loadAnimation;
                loadAnimation.setAnimationListener(this.f22751i);
            }
            return this.f22749g;
        }
        return (Animation) invokeV.objValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f22744b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f22745c, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.f22745c, R.color.CAM_X0106, 1);
            if (this.f22750h) {
                SkinManager.setImageResource(this.f22743a, R.drawable.lego_icon_triangle_down_normal);
            } else {
                SkinManager.setImageResource(this.f22743a, R.drawable.lego_icon_triangle_up_normal);
            }
            SkinManager.setBackgroundResource(this.f22743a, R.drawable.lego_btn_more_selector);
            SlidingTabLayout slidingTabLayout = this.f22746d;
            if (slidingTabLayout != null) {
                slidingTabLayout.onChangeSkinType(i2);
            }
        }
    }

    public void h(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) || (imageView = this.f22743a) == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    public void i(ViewPager viewPager, int i2) {
        SlidingTabLayout slidingTabLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, viewPager, i2) == null) || (slidingTabLayout = this.f22746d) == null) {
            return;
        }
        slidingTabLayout.setViewPager(viewPager, i2);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f22750h = false;
            TextView textView = this.f22745c;
            if (textView != null) {
                textView.clearAnimation();
                this.f22745c.setVisibility(0);
                this.f22745c.startAnimation(e());
            }
            SkinManager.setImageResource(this.f22743a, R.drawable.lego_icon_triangle_up_normal);
        }
    }
}
