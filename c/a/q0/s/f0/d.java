package c.a.q0.s.f0;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f13825a;

    /* renamed from: b  reason: collision with root package name */
    public View f13826b;

    /* renamed from: c  reason: collision with root package name */
    public int f13827c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup.LayoutParams f13828d;

    /* renamed from: e  reason: collision with root package name */
    public int f13829e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f13830f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f13831g;

    /* renamed from: h  reason: collision with root package name */
    public int f13832h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13833i;

    /* renamed from: j  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f13834j;
    public int k;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f13835e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13835e = dVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13835e.k();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f13836e;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13836e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13836e.l();
            }
        }
    }

    public d(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13825a = 3;
        int i4 = R.color.CAM_X0201;
        this.f13832h = i4;
        this.f13833i = false;
        this.f13834j = null;
        this.k = 0;
        h(activity, i4, true);
    }

    public static d c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, activity)) == null) ? new d(activity) : (d) invokeL.objValue;
    }

    public static d d(Activity activity, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{activity, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? new d(activity, i2, z) : (d) invokeCommon.objValue;
    }

    public static d e(Activity activity, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65543, null, activity, z)) == null) ? new d(activity, z) : (d) invokeLZ.objValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Rect rect = new Rect();
            this.f13826b.getWindowVisibleDisplayFrame(rect);
            return rect.bottom;
        }
        return invokeV.intValue;
    }

    public final void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (this.f13830f != null) {
                c.a.e.e.m.e.a().removeCallbacks(this.f13830f);
                this.f13830f = null;
            }
            this.f13830f = new b(this);
            c.a.e.e.m.e.a().postDelayed(this.f13830f, i2);
        }
    }

    public final void h(Activity activity, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.f13832h = i2;
            this.f13833i = z;
            FrameLayout frameLayout = (FrameLayout) activity.findViewById(16908290);
            this.f13831g = frameLayout;
            if (z) {
                SkinManager.setBackgroundColor(frameLayout, i2);
            } else {
                SkinManager.setBackgroundColor(frameLayout, i2, 0);
            }
            View childAt = this.f13831g.getChildAt(0);
            this.f13826b = childAt;
            if (childAt == null) {
                return;
            }
            this.f13834j = new a(this);
            this.f13826b.getViewTreeObserver().addOnGlobalLayoutListener(this.f13834j);
            this.f13828d = this.f13826b.getLayoutParams();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f13830f != null) {
                c.a.e.e.m.e.a().removeCallbacks(this.f13830f);
                this.f13830f = null;
            }
            View view = this.f13826b;
            if (view != null) {
                view.getViewTreeObserver().removeGlobalOnLayoutListener(this.f13834j);
                this.f13834j = null;
            }
            this.f13826b = null;
            this.f13831g = null;
        }
    }

    public void j(int i2) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i2) == null) && this.f13833i) {
            if (i2 != this.f13825a && (frameLayout = this.f13831g) != null) {
                SkinManager.setBackgroundColor(frameLayout, this.f13832h);
            }
            this.f13825a = i2;
        }
    }

    public final void k() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (view = this.f13826b) == null) {
            return;
        }
        int height = view.getHeight();
        if (height > this.f13829e) {
            this.f13829e = height;
        }
        int f2 = f();
        int i2 = this.k;
        if (i2 > 0 && i2 <= this.f13828d.height) {
            f2 -= i2;
        }
        if (f2 != this.f13827c) {
            int i3 = this.f13829e;
            int i4 = i3 - f2;
            if (i4 == 0) {
                this.f13828d.height = i3;
                l();
            } else if (i4 > 200) {
                this.f13828d.height = i3 - i4;
                g(200);
                if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i4) && i4 < (this.f13829e * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i4) {
                    TbadkCoreApplication.getInst().setKeyboardHeight(i4);
                }
            }
            this.f13827c = f2;
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f13826b.requestLayout();
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.k = i2;
        }
    }

    public d(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f13825a = 3;
        int i4 = R.color.CAM_X0201;
        this.f13832h = i4;
        this.f13833i = false;
        this.f13834j = null;
        this.k = 0;
        h(activity, i4, z);
    }

    public d(Activity activity, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f13825a = 3;
        this.f13832h = R.color.CAM_X0201;
        this.f13833i = false;
        this.f13834j = null;
        this.k = 0;
        h(activity, i2, z);
    }
}
