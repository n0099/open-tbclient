package c.a.q0.u0.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f24878a;

    /* renamed from: b  reason: collision with root package name */
    public final View f24879b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f24880c;

    /* renamed from: d  reason: collision with root package name */
    public final EditText f24881d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f24882e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f24883f;

    /* renamed from: g  reason: collision with root package name */
    public final BdTypeListView f24884g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f24885h;

    /* renamed from: i  reason: collision with root package name */
    public int f24886i;

    public c(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24886i = 3;
        this.f24878a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.forum_search_main, (ViewGroup) null);
        this.f24879b = inflate;
        this.f24880c = (RelativeLayout) inflate.findViewById(R.id.search_area_root);
        this.f24885h = (ImageView) this.f24879b.findViewById(R.id.search_bar_icon);
        this.f24881d = (EditText) this.f24879b.findViewById(R.id.home_et_search);
        this.f24882e = (ImageView) this.f24879b.findViewById(R.id.home_bt_search_del);
        this.f24881d.setHint(R.string.search_bar_you_want_post_to_share);
        TextView textView = (TextView) this.f24879b.findViewById(R.id.home_bt_search_cancel_s);
        this.f24883f = textView;
        textView.setText(tbPageContext.getString(R.string.cancel));
        this.f24884g = (BdTypeListView) this.f24879b.findViewById(R.id.search_bar_list);
        a();
        b(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f24880c.getLayoutParams();
            layoutParams.height = l.g(this.f24878a.getPageActivity(), R.dimen.ds88);
            int g2 = l.g(this.f24878a.getPageActivity(), R.dimen.ds8);
            layoutParams.rightMargin = g2;
            layoutParams.leftMargin = g2;
            int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
            if (immersiveStickyBarHeight > 0) {
                layoutParams.topMargin = immersiveStickyBarHeight;
            }
            this.f24880c.setLayoutParams(layoutParams);
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f24886i == i2) {
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f24885h, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        SkinManager.setViewTextColor(this.f24883f, R.color.CAM_X0302, 1);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f24882e, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (i2 == 2) {
            this.f24881d.setHintTextColor(SkinManager.getColor(R.color.s_navbar_title_color));
        } else {
            this.f24881d.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        }
        SkinManager.setNavbarTitleColor(this.f24881d, R.color.CAM_X0105, R.color.s_navbar_title_color);
        this.f24886i = i2;
    }
}
