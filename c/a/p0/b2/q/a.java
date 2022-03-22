package c.a.p0.b2.q;

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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public View f12575b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f12576c;

    /* renamed from: d  reason: collision with root package name */
    public SlidingTabLayout f12577d;

    /* renamed from: e  reason: collision with root package name */
    public Context f12578e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f12579f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f12580g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12581h;
    public d i;

    /* renamed from: c.a.p0.b2.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0946a extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0946a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.a.f12576c == null) {
                return;
            }
            if (animation == this.a.f12579f) {
                this.a.f12576c.setVisibility(0);
                this.a.f12576c.setClickable(true);
            } else if (animation == this.a.f12580g) {
                this.a.f12576c.setVisibility(8);
                this.a.f12576c.setClickable(false);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12581h = true;
        this.i = new C0946a(this);
        this.f12575b = view;
        this.f12578e = context;
        this.f12576c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091e55);
        this.a = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f091e53);
        this.f12577d = (SlidingTabLayout) view.findViewById(R.id.obfuscated_res_0x7f091e54);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f12581h = true;
            TextView textView = this.f12576c;
            if (textView != null) {
                textView.clearAnimation();
                this.f12576c.startAnimation(f());
            }
            SkinManager.setImageResource(this.a, R.drawable.lego_icon_triangle_down_normal);
        }
    }

    public final Animation e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f12579f == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f12578e, R.anim.obfuscated_res_0x7f010063);
                this.f12579f = loadAnimation;
                loadAnimation.setAnimationListener(this.i);
            }
            return this.f12579f;
        }
        return (Animation) invokeV.objValue;
    }

    public final Animation f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f12580g == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f12578e, R.anim.obfuscated_res_0x7f010064);
                this.f12580g = loadAnimation;
                loadAnimation.setAnimationListener(this.i);
            }
            return this.f12580g;
        }
        return (Animation) invokeV.objValue;
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            SkinManager.setBackgroundColor(this.f12575b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.f12576c, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.f12576c, R.color.CAM_X0106, 1);
            if (this.f12581h) {
                SkinManager.setImageResource(this.a, R.drawable.lego_icon_triangle_down_normal);
            } else {
                SkinManager.setImageResource(this.a, R.drawable.lego_icon_triangle_up_normal);
            }
            SkinManager.setBackgroundResource(this.a, R.drawable.lego_btn_more_selector);
            SlidingTabLayout slidingTabLayout = this.f12577d;
            if (slidingTabLayout != null) {
                slidingTabLayout.onChangeSkinType(i);
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

    public void i(ViewPager viewPager, int i) {
        SlidingTabLayout slidingTabLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, viewPager, i) == null) || (slidingTabLayout = this.f12577d) == null) {
            return;
        }
        slidingTabLayout.setViewPager(viewPager, i);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f12581h = false;
            TextView textView = this.f12576c;
            if (textView != null) {
                textView.clearAnimation();
                this.f12576c.setVisibility(0);
                this.f12576c.startAnimation(e());
            }
            SkinManager.setImageResource(this.a, R.drawable.lego_icon_triangle_up_normal);
        }
    }
}
