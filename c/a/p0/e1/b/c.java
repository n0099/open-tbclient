package c.a.p0.e1.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
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
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public final View f13771b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f13772c;

    /* renamed from: d  reason: collision with root package name */
    public final EditText f13773d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f13774e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f13775f;

    /* renamed from: g  reason: collision with root package name */
    public final BdTypeListView f13776g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f13777h;
    public int i;

    public c(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = 3;
        this.a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02ce, (ViewGroup) null);
        this.f13771b = inflate;
        this.f13772c = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091c19);
        this.f13777h = (ImageView) this.f13771b.findViewById(R.id.obfuscated_res_0x7f091c1c);
        this.f13773d = (EditText) this.f13771b.findViewById(R.id.obfuscated_res_0x7f090d75);
        this.f13774e = (ImageView) this.f13771b.findViewById(R.id.obfuscated_res_0x7f090d65);
        this.f13773d.setHint(R.string.obfuscated_res_0x7f0f1090);
        TextView textView = (TextView) this.f13771b.findViewById(R.id.obfuscated_res_0x7f090d64);
        this.f13775f = textView;
        textView.setText(tbPageContext.getString(R.string.obfuscated_res_0x7f0f036c));
        this.f13776g = (BdTypeListView) this.f13771b.findViewById(R.id.obfuscated_res_0x7f091c1d);
        a();
        b(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f13772c.getLayoutParams();
            layoutParams.height = n.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f0702ff);
            int f2 = n.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f0702fb);
            layoutParams.rightMargin = f2;
            layoutParams.leftMargin = f2;
            int immersiveStickyBarHeight = UtilHelper.getImmersiveStickyBarHeight();
            if (immersiveStickyBarHeight > 0) {
                layoutParams.topMargin = immersiveStickyBarHeight;
            }
            this.f13772c.setLayoutParams(layoutParams);
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.i == i) {
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f13777h, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
        SkinManager.setViewTextColor(this.f13775f, R.color.CAM_X0302, 1);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f13774e, R.drawable.obfuscated_res_0x7f08097f, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (i == 2) {
            this.f13773d.setHintTextColor(SkinManager.getColor(R.color.s_navbar_title_color));
        } else {
            this.f13773d.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        }
        SkinManager.setNavbarTitleColor(this.f13773d, R.color.CAM_X0105, R.color.s_navbar_title_color);
        this.i = i;
    }
}
