package c.a.s0.g0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
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
/* loaded from: classes6.dex */
public class h extends a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final int f12903j;
    public static final int k;
    public static final int l;
    public static final int m;
    public static final int n;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f12904b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f12905c;

    /* renamed from: d  reason: collision with root package name */
    public TBSpecificationBtn f12906d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f12907e;

    /* renamed from: f  reason: collision with root package name */
    public int f12908f;

    /* renamed from: g  reason: collision with root package name */
    public int f12909g;

    /* renamed from: h  reason: collision with root package name */
    public int f12910h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12911i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-767426835, "Lc/a/s0/g0/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-767426835, "Lc/a/s0/g0/h;");
                return;
            }
        }
        f12903j = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds312);
        k = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds84);
        l = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
        m = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds32);
        n = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
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
        this.a = (ImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f12904b = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f12905c = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.f12907e = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.f12906d = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        c.a.s0.s.k0.n.a aVar = new c.a.s0.s.k0.n.a();
        this.f12906d.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.f12906d.setTextSize(R.dimen.T_X05);
        this.f12906d.setConfig(aVar);
        this.f12908f = R.drawable.new_pic_emotion_08;
        this.f12909g = R.color.CAM_X0107;
        this.f12910h = R.color.CAM_X0109;
        this.f12906d.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        l(0);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f12906d.getVisibility() == 0) {
                ViewGroup.LayoutParams layoutParams = this.f12907e.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.topMargin = k;
                    this.f12907e.setLayoutParams(marginLayoutParams);
                }
                if (!this.f12911i) {
                    this.f12904b.setVisibility(8);
                }
                this.f12909g = R.color.CAM_X0107;
            } else if (this.f12904b.getVisibility() == 8) {
                ViewGroup.LayoutParams layoutParams2 = this.f12907e.getLayoutParams();
                if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                    marginLayoutParams2.topMargin = k;
                    this.f12907e.setLayoutParams(marginLayoutParams2);
                }
                this.f12909g = R.color.CAM_X0107;
            } else if (this.f12905c.getVisibility() == 0) {
                ViewGroup.LayoutParams layoutParams3 = this.f12907e.getLayoutParams();
                if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                    marginLayoutParams3.topMargin = m;
                    this.f12907e.setLayoutParams(marginLayoutParams3);
                }
                ViewGroup.LayoutParams layoutParams4 = this.f12905c.getLayoutParams();
                if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                    marginLayoutParams4.topMargin = n;
                    this.f12905c.setLayoutParams(marginLayoutParams4);
                }
                this.f12909g = R.color.CAM_X0107;
                this.f12910h = R.color.CAM_X0109;
            } else {
                ViewGroup.LayoutParams layoutParams5 = this.a.getLayoutParams();
                int i2 = f12903j;
                layoutParams5.width = i2;
                layoutParams5.height = i2;
                this.a.setLayoutParams(layoutParams5);
                ViewGroup.LayoutParams layoutParams6 = this.f12907e.getLayoutParams();
                if (layoutParams6 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams6;
                    marginLayoutParams5.topMargin = l;
                    this.f12907e.setLayoutParams(marginLayoutParams5);
                }
                this.f12910h = R.color.CAM_X0109;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f12906d : (View) invokeV.objValue;
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f12905c : (TextView) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f12906d.setVisibility(8);
            this.f12905c.setVisibility(8);
            SkinManager.setViewTextColor(this.f12904b, R.color.CAM_X0109, 1);
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
        this.f12906d.setText(str);
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f12908f = i2;
            SkinManager.setImageResource(this.a, i2);
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f12908f = i2;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f12911i = z;
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i2;
                this.a.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            int i3 = n.i(TbadkCoreApplication.getInst());
            int dimensionPixelSize = i3 <= 0 ? TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds200) : (int) (i3 * 0.16d);
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = dimensionPixelSize + i2;
                this.a.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            if (str == null) {
                this.f12904b.setVisibility(8);
            } else {
                this.f12904b.setVisibility(0);
                this.f12904b.setText(str);
            }
            a();
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || str == null) {
            return;
        }
        this.f12905c.setText(str);
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || str == null) {
            return;
        }
        this.f12905c.setText(str);
        this.f12905c.setVisibility(0);
        a();
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource(this.a, this.f12908f);
            SkinManager.setViewTextColor(this.f12904b, this.f12910h, 1, skinType);
            SkinManager.setViewTextColor(this.f12905c, this.f12909g, 1, skinType);
            TBSpecificationBtn tBSpecificationBtn = this.f12906d;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.changeSkinType();
            }
        }
    }

    @Override // c.a.s0.g0.a
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onViewAttached();
            onChangeSkinType();
        }
    }

    @Override // c.a.s0.g0.a
    public void onViewDettached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onViewDettached();
            this.a.setImageResource(0);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f12906d.setVisibility(0);
            this.f12905c.setVisibility(0);
            SkinManager.setViewTextColor(this.f12904b, R.color.CAM_X0109, 1);
            a();
        }
    }
}
