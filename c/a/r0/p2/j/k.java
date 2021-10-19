package c.a.r0.p2.j;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f23529a;

    /* renamed from: b  reason: collision with root package name */
    public View f23530b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f23531c;

    /* renamed from: d  reason: collision with root package name */
    public View f23532d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f23533e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f23534f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f23535g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f23536h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.c4.e f23537i;

    /* renamed from: j  reason: collision with root package name */
    public UserData f23538j;
    public int k;
    public boolean l;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f23539e;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23539e = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f23539e.f23537i == null) {
                    if (this.f23539e.f23529a != null) {
                        this.f23539e.f23529a.getPageActivity().finish();
                        return;
                    }
                    return;
                }
                c.a.r0.p2.f.b bVar = new c.a.r0.p2.f.b();
                bVar.f23232a = 8;
                this.f23539e.f23537i.a(view, bVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f23540e;

        public b(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23540e = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "1"));
                c.a.r0.p2.f.b bVar = new c.a.r0.p2.f.b();
                bVar.f23232a = 40;
                Bundle bundle = new Bundle();
                bVar.f23233b = bundle;
                bundle.putSerializable(UserData.TYPE_USER, this.f23540e.f23538j);
                if (this.f23540e.f23537i != null) {
                    this.f23540e.f23537i.a(view, bVar);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f23541e;

        public c(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23541e = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && c.a.e.e.p.j.z()) {
                TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "2"));
                if (this.f23541e.f23537i != null) {
                    c.a.r0.p2.f.b bVar = new c.a.r0.p2.f.b();
                    bVar.f23232a = 9;
                    this.f23541e.f23537i.a(view, bVar);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, view2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TbPageContext) objArr2[0], (View) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = UtilHelper.getStatusBarHeight();
        this.f23530b = view2;
        d();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f23530b == null) {
            return;
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = this.f23530b.getLayoutParams();
            layoutParams.height = this.k;
            this.f23530b.setLayoutParams(layoutParams);
            return;
        }
        this.f23530b.setVisibility(8);
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23531c : (View) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            View view = this.f23530b;
            if (view != null) {
                SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
            }
            SkinManager.setBackgroundColor(this.f23532d, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f23533e, R.color.CAM_X0105);
            m(this.f23532d.getAlpha() > 0.5f);
        }
    }

    public void h(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f2) == null) {
            float f3 = 0.0f;
            if (f2 >= 0.0f || f2 <= 1.0f) {
                View view = this.f23530b;
                if (view != null) {
                    view.setAlpha(f2);
                }
                this.f23532d.setAlpha(f2);
                this.f23533e.setAlpha(f2);
            }
            float f4 = f2 < 0.5f ? 1.0f - (f2 * 2.0f) : (f2 * 2.0f) - 1.0f;
            if (f4 > 1.0f) {
                f3 = 1.0f;
            } else if (f4 >= 0.0f) {
                f3 = f4;
            }
            this.f23534f.setAlpha(f3);
            this.f23536h.setAlpha(f3);
            this.f23535g.setAlpha(f3);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                this.f23532d.setVisibility(8);
                this.f23533e.setVisibility(8);
                return;
            }
            this.f23532d.setVisibility(0);
            this.f23533e.setVisibility(0);
        }
    }

    public void j(c.a.r0.c4.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.f23537i = eVar;
        }
    }

    public void k(PersonStatus personStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, personStatus) == null) {
            n();
        }
    }

    public void l(c.a.r0.p2.e.a aVar, PersonStatus personStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar, personStatus) == null) {
            if (aVar != null && aVar.j() != null) {
                UserData j2 = aVar.j();
                this.f23538j = j2;
                this.f23533e.setText(j2.getName_show());
            }
            n();
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || this.f23534f == null) {
            return;
        }
        if (z) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f23534f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f23536h, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f23535g, R.drawable.icon_pure_topbar_createchat44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f23534f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f23536h, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f23535g, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.l) {
                this.f23536h.setVisibility(8);
                this.f23535g.setVisibility(8);
            } else if (TbadkCoreApplication.isLogin()) {
                this.f23535g.setVisibility(0);
                this.f23536h.setVisibility(0);
            } else {
                this.f23536h.setVisibility(8);
                this.f23535g.setVisibility(8);
            }
        }
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f23529a = tbPageContext;
        this.l = z;
        this.f23531c = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.f23532d = view.findViewById(R.id.person_center_nav_bg);
        this.f23533e = (TextView) view.findViewById(R.id.person_center_nav_title);
        ImageView imageView = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.f23534f = imageView;
        imageView.setOnClickListener(new a(this));
        ImageView imageView2 = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.f23535g = imageView2;
        imageView2.setOnClickListener(new b(this));
        ImageView imageView3 = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.f23536h = imageView3;
        imageView3.setOnClickListener(new c(this));
    }
}
