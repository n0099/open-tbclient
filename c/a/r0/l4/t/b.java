package c.a.r0.l4.t;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.g;
import c.a.d.f.p.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b extends PopupWindow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public ValueAnimator f19631b;

    /* renamed from: c  reason: collision with root package name */
    public ValueAnimator f19632c;

    /* renamed from: d  reason: collision with root package name */
    public BaseFragmentActivity f19633d;

    /* renamed from: e  reason: collision with root package name */
    public View f19634e;

    /* renamed from: f  reason: collision with root package name */
    public ListView f19635f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f19636g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.l4.k.b f19637h;

    /* renamed from: i  reason: collision with root package name */
    public int f19638i;

    /* renamed from: j  reason: collision with root package name */
    public f f19639j;

    /* renamed from: k  reason: collision with root package name */
    public final AdapterView.OnItemClickListener f19640k;
    public final View.OnClickListener l;

    /* loaded from: classes6.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19641e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19641e = bVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                c.a.q0.f.a item = this.f19641e.f19637h.getItem(i2);
                if (this.f19641e.f19639j != null) {
                    this.f19641e.f19639j.onItemClick(i2, item);
                }
                this.f19641e.j();
            }
        }
    }

    /* renamed from: c.a.r0.l4.t.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC1171b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19642e;

        public View$OnClickListenerC1171b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19642e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19642e.j();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19643e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19643e = bVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = this.f19643e.f19635f.getLayoutParams();
                layoutParams.height = intValue;
                this.f19643e.f19635f.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f19644e;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19644e = bVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = this.f19644e.f19635f.getLayoutParams();
                layoutParams.height = intValue;
                this.f19644e.f19635f.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.h();
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

    /* loaded from: classes6.dex */
    public interface f {
        void onItemClick(int i2, c.a.q0.f.a aVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext().getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
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
        this.f19640k = new a(this);
        this.l = new View$OnClickListenerC1171b(this);
        this.f19633d = baseFragmentActivity;
        setWidth(-1);
        setHeight(-1);
        setContentView(g(new ArrayList(), c.a.q0.f.a.f11963f));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j();
        }
    }

    public final int e(List<c.a.q0.f.a> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, str)) == null) {
            if (list != null && list.size() != 0 && !TextUtils.isEmpty(str)) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    c.a.q0.f.a aVar = list.get(i2);
                    if (aVar != null && str.equals(aVar.b())) {
                        return i2;
                    }
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ListView listView = this.f19635f;
            if (listView != null) {
                listView.clearAnimation();
            }
            ViewGroup viewGroup = this.f19636g;
            if (viewGroup != null) {
                viewGroup.clearAnimation();
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final View g(List<c.a.q0.f.a> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, list, str)) == null) {
            BdListView bdListView = new BdListView(this.f19633d.getPageContext().getPageActivity());
            this.f19635f = bdListView;
            bdListView.setCacheColorHint(this.f19633d.getResources().getColor(17170445));
            bdListView.setDivider(null);
            bdListView.setDividerHeight(0);
            bdListView.setFadingEdgeLength(0);
            c.a.r0.l4.k.b bVar = new c.a.r0.l4.k.b(this.f19633d);
            this.f19637h = bVar;
            bVar.b(list, str);
            bdListView.setAdapter((ListAdapter) this.f19637h);
            FrameLayout frameLayout = new FrameLayout(this.f19633d.getPageContext().getPageActivity());
            FrameLayout frameLayout2 = new FrameLayout(this.f19633d.getPageContext().getPageActivity());
            this.f19636g = frameLayout2;
            frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
            this.f19635f.setOnItemClickListener(this.f19640k);
            frameLayout.setOnClickListener(this.l);
            SkinManager.setBackgroundColor(this.f19634e, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f19635f, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f19636g, R.color.black_alpha70);
            return frameLayout;
        }
        return (View) invokeLL.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.dismiss();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f19632c == null) {
                ValueAnimator ofInt = ValueAnimator.ofInt(this.f19635f.getHeight(), 0);
                this.f19632c = ofInt;
                ofInt.addUpdateListener(new d(this));
                this.f19632c.setDuration(350L);
            }
            this.f19632c.start();
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(350L);
            alphaAnimation.setInterpolator(new LinearInterpolator());
            alphaAnimation.setAnimationListener(new e(this));
            this.f19636g.startAnimation(alphaAnimation);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            i();
        }
    }

    public void k(List<c.a.q0.f.a> list, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, list, str) == null) || list == null) {
            return;
        }
        this.f19638i = e(list, str);
        this.a = -2;
        if (list.size() > 5) {
            this.a = this.f19633d.getResources().getDimensionPixelSize(R.dimen.ds618);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f19635f.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.a);
        } else {
            layoutParams.height = this.a;
        }
        this.f19635f.setLayoutParams(layoutParams);
        if (this.a < 0) {
            this.a = l.f(this.f19633d, R.dimen.tbds168) * list.size();
        }
        this.f19637h.b(list, str);
        this.f19637h.notifyDataSetChanged();
    }

    public void l(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            this.f19639j = fVar;
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.f19631b == null) {
                ValueAnimator ofInt = ValueAnimator.ofInt(0, this.a);
                this.f19631b = ofInt;
                ofInt.addUpdateListener(new c(this));
                this.f19631b.setDuration(350L);
            }
            this.f19631b.start();
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(350L);
            alphaAnimation.setInterpolator(new LinearInterpolator());
            this.f19636g.startAnimation(alphaAnimation);
        }
    }

    public void n(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            this.f19635f.setSelection(this.f19638i);
            if (Build.VERSION.SDK_INT < 24) {
                if (g.k(this, view)) {
                    m();
                    return;
                }
                return;
            }
            int statusBarHeight = UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int height = (iArr[1] + view.getHeight()) - statusBarHeight;
            ((FrameLayout.LayoutParams) this.f19635f.getLayoutParams()).topMargin = height;
            ((FrameLayout.LayoutParams) this.f19636g.getLayoutParams()).topMargin = height;
            if (g.m(this, view, 0, 0, 0)) {
                m();
            }
        }
    }
}
