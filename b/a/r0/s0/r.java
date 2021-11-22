package b.a.r0.s0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class r extends PopupWindow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f24702a;

    /* renamed from: b  reason: collision with root package name */
    public ListView f24703b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f24704c;

    /* renamed from: d  reason: collision with root package name */
    public w f24705d;

    /* renamed from: e  reason: collision with root package name */
    public int f24706e;

    /* renamed from: f  reason: collision with root package name */
    public d f24707f;

    /* loaded from: classes5.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ r f24708e;

        public a(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24708e = rVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                b.a.q0.f.a item = this.f24708e.f24705d.getItem(i2);
                if ((item instanceof b.a.q0.f.a) && this.f24708e.f24707f != null) {
                    this.f24708e.f24707f.onItemClick(i2, item);
                }
                this.f24708e.h();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ r f24709e;

        public b(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24709e = rVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f24709e.h();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f24710a;

        public c(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24710a = rVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f24710a.f();
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

    /* loaded from: classes5.dex */
    public interface d {
        void onItemClick(int i2, b.a.q0.f.a aVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(Context context) {
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
        this.f24702a = context;
        setWidth(-1);
        setHeight(-1);
        setContentView(e(new ArrayList(), b.a.q0.f.a.f13260f));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    public final int d(List<b.a.q0.f.a> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, list, str)) == null) {
            if (list != null && list.size() != 0 && !TextUtils.isEmpty(str)) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    b.a.q0.f.a aVar = list.get(i2);
                    if (aVar != null && str.equals(aVar.b())) {
                        return i2;
                    }
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            h();
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final View e(List<b.a.q0.f.a> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, str)) == null) {
            BdListView bdListView = new BdListView(this.f24702a);
            this.f24703b = bdListView;
            bdListView.setCacheColorHint(this.f24702a.getResources().getColor(17170445));
            bdListView.setDivider(null);
            bdListView.setDividerHeight(0);
            bdListView.setFadingEdgeLength(0);
            w wVar = new w(this.f24702a);
            this.f24705d = wVar;
            wVar.b(list, str);
            bdListView.setAdapter((ListAdapter) this.f24705d);
            bdListView.setOnItemClickListener(new a(this));
            FrameLayout frameLayout = new FrameLayout(this.f24702a);
            FrameLayout frameLayout2 = new FrameLayout(this.f24702a);
            this.f24704c = frameLayout2;
            frameLayout2.setBackgroundColor(this.f24702a.getResources().getColor(R.color.common_color_10175));
            frameLayout2.setOnClickListener(new b(this));
            frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
            return frameLayout;
        }
        return (View) invokeLL.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.dismiss();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation.setDuration(350L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setInterpolator(new AccelerateInterpolator());
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(350L);
            alphaAnimation.setInterpolator(new LinearInterpolator());
            alphaAnimation.setAnimationListener(new c(this));
            this.f24703b.startAnimation(translateAnimation);
            this.f24704c.startAnimation(alphaAnimation);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            g();
        }
    }

    public void i(List<b.a.q0.f.a> list, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, list, str) == null) || list == null) {
            return;
        }
        this.f24706e = d(list, str);
        int dimensionPixelSize = list.size() > 5 ? this.f24702a.getResources().getDimensionPixelSize(R.dimen.ds618) : -2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f24703b.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, dimensionPixelSize);
        } else {
            layoutParams.height = dimensionPixelSize;
        }
        this.f24703b.setLayoutParams(layoutParams);
        this.f24705d.b(list, str);
        this.f24705d.notifyDataSetChanged();
    }

    public void j(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.f24707f = dVar;
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
            translateAnimation.setDuration(350L);
            translateAnimation.setInterpolator(new DecelerateInterpolator());
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(350L);
            alphaAnimation.setInterpolator(new LinearInterpolator());
            this.f24703b.startAnimation(translateAnimation);
            this.f24704c.startAnimation(alphaAnimation);
        }
    }

    public void l(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            this.f24703b.setSelection(this.f24706e);
            if (Build.VERSION.SDK_INT < 24) {
                if (b.a.e.f.m.g.k(this, view)) {
                    k();
                }
            } else if (b.a.e.f.m.g.m(this, view, 0, 0, view.getHeight())) {
                k();
            }
        }
    }
}
