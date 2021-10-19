package c.a.q0.g0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class h extends a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final int f13437i;

    /* renamed from: j  reason: collision with root package name */
    public static final int f13438j;
    public static final int k;
    public static final int l;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f13439a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f13440b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f13441c;

    /* renamed from: d  reason: collision with root package name */
    public TBSpecificationBtn f13442d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f13443e;

    /* renamed from: f  reason: collision with root package name */
    public int f13444f;

    /* renamed from: g  reason: collision with root package name */
    public int f13445g;

    /* renamed from: h  reason: collision with root package name */
    public int f13446h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(41919791, "Lc/a/q0/g0/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(41919791, "Lc/a/q0/g0/h;");
                return;
            }
        }
        f13437i = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds312);
        f13438j = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds84);
        k = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
        l = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds32);
        m = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, onClickListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f13439a = (ImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f13440b = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f13441c = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.f13443e = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.f13442d = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        c.a.q0.s.f0.n.a aVar = new c.a.q0.s.f0.n.a();
        this.f13442d.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.f13442d.setTextSize(R.dimen.T_X05);
        this.f13442d.setConfig(aVar);
        this.f13444f = R.drawable.new_pic_emotion_08;
        this.f13445g = R.color.CAM_X0107;
        this.f13446h = R.color.CAM_X0109;
        this.f13442d.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        k(0);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f13442d.getVisibility() == 0) {
                ViewGroup.LayoutParams layoutParams = this.f13443e.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.topMargin = f13438j;
                    this.f13443e.setLayoutParams(marginLayoutParams);
                }
                this.f13440b.setVisibility(8);
                this.f13445g = R.color.CAM_X0107;
            } else if (this.f13440b.getVisibility() == 8) {
                ViewGroup.LayoutParams layoutParams2 = this.f13443e.getLayoutParams();
                if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                    marginLayoutParams2.topMargin = f13438j;
                    this.f13443e.setLayoutParams(marginLayoutParams2);
                }
                this.f13445g = R.color.CAM_X0107;
            } else if (this.f13441c.getVisibility() == 0) {
                ViewGroup.LayoutParams layoutParams3 = this.f13443e.getLayoutParams();
                if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                    marginLayoutParams3.topMargin = l;
                    this.f13443e.setLayoutParams(marginLayoutParams3);
                }
                ViewGroup.LayoutParams layoutParams4 = this.f13441c.getLayoutParams();
                if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                    marginLayoutParams4.topMargin = m;
                    this.f13441c.setLayoutParams(marginLayoutParams4);
                }
                this.f13445g = R.color.CAM_X0107;
                this.f13446h = R.color.CAM_X0109;
            } else {
                ViewGroup.LayoutParams layoutParams5 = this.f13439a.getLayoutParams();
                int i2 = f13437i;
                layoutParams5.width = i2;
                layoutParams5.height = i2;
                this.f13439a.setLayoutParams(layoutParams5);
                ViewGroup.LayoutParams layoutParams6 = this.f13443e.getLayoutParams();
                if (layoutParams6 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams6;
                    marginLayoutParams5.topMargin = k;
                    this.f13443e.setLayoutParams(marginLayoutParams5);
                }
                this.f13446h = R.color.CAM_X0109;
            }
            onChangeSkinType();
        }
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.attachedView : (View) invokeV.objValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13442d : (View) invokeV.objValue;
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13441c : (TextView) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f13442d.setVisibility(8);
            this.f13441c.setVisibility(8);
            SkinManager.setViewTextColor(this.f13440b, R.color.CAM_X0109, 1);
            a();
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            SkinManager.setBackgroundColor(this.attachedView, i2);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || str == null) {
            return;
        }
        this.f13442d.setText(str);
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f13444f = i2;
            SkinManager.setImageResource(this.f13439a, i2);
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f13444f = i2;
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            ViewGroup.LayoutParams layoutParams = this.f13439a.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i2;
                this.f13439a.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            int i3 = l.i(TbadkCoreApplication.getInst());
            int dimensionPixelSize = i3 <= 0 ? TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds200) : (int) (i3 * 0.16d);
            ViewGroup.LayoutParams layoutParams = this.f13439a.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = dimensionPixelSize + i2;
                this.f13439a.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            if (str == null) {
                this.f13440b.setVisibility(8);
            } else {
                this.f13440b.setVisibility(0);
                this.f13440b.setText(str);
            }
            a();
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || str == null) {
            return;
        }
        this.f13441c.setText(str);
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || str == null) {
            return;
        }
        this.f13441c.setText(str);
        this.f13441c.setVisibility(0);
        a();
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f13442d.setVisibility(0);
            this.f13441c.setVisibility(0);
            SkinManager.setViewTextColor(this.f13440b, R.color.CAM_X0109, 1);
            a();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource(this.f13439a, this.f13444f);
            SkinManager.setViewTextColor(this.f13440b, this.f13446h, 1, skinType);
            SkinManager.setViewTextColor(this.f13441c, this.f13445g, 1, skinType);
            TBSpecificationBtn tBSpecificationBtn = this.f13442d;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.changeSkinType();
            }
        }
    }

    @Override // c.a.q0.g0.a
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onViewAttached();
            onChangeSkinType();
        }
    }

    @Override // c.a.q0.g0.a
    public void onViewDettached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onViewDettached();
            this.f13439a.setImageResource(0);
        }
    }
}
