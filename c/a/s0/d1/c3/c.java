package c.a.s0.d1.c3;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.r0.s.t.l;
import c.a.s0.d1.c1;
import c.a.s0.d1.d1;
import c.a.s0.d1.e1;
import c.a.s0.d1.i1;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.FrsTabInfo;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageView f15785e;

        public a(ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15785e = imageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Drawable maskDrawable;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                view.setTag(Boolean.valueOf(!((Boolean) view.getTag()).booleanValue()));
                ImageView imageView = this.f15785e;
                if (((Boolean) view.getTag()).booleanValue()) {
                    maskDrawable = SvgManager.getInstance().getMaskDrawable(e1.ic_icon_mask_use_complete16_svg, null);
                } else {
                    maskDrawable = SvgManager.getInstance().getMaskDrawable(e1.ic_icon_mask_use_check16_svg, null);
                }
                imageView.setImageDrawable(maskDrawable);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageView f15786e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f15787f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f15788g;

        public b(ImageView imageView, FrsTabInfo frsTabInfo, FrsTabInfo frsTabInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageView, frsTabInfo, frsTabInfo2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15786e = imageView;
            this.f15787f = frsTabInfo;
            this.f15788g = frsTabInfo2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.r0.s.g0.b.j().t("key_frs_move_area_tip", !((Boolean) this.f15786e.getTag()).booleanValue());
                c.a.s0.d1.a.h().m(this.f15787f.tab_id.intValue(), this.f15788g.tab_id.intValue());
            }
        }
    }

    public static void a(TbPageContext tbPageContext, FrsTabInfo frsTabInfo, FrsTabInfo frsTabInfo2) {
        String format;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, frsTabInfo, frsTabInfo2) == null) || frsTabInfo == null || frsTabInfo2 == null || tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        LinearLayout linearLayout = new LinearLayout(pageActivity);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(UtilHelper.getDimenPixelSize(d1.M_W_X012), UtilHelper.getDimenPixelSize(d1.M_H_X008), UtilHelper.getDimenPixelSize(d1.M_W_X012), 0);
        ImageView imageView = new ImageView(pageActivity);
        imageView.setImageDrawable(SvgManager.getInstance().getMaskDrawable(e1.ic_icon_mask_use_check16_svg, null));
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(UtilHelper.getDimenPixelSize(d1.tbds39), UtilHelper.getDimenPixelSize(d1.tbds39)));
        TextView textView = new TextView(pageActivity);
        textView.setText(i1.no_tip_again);
        textView.setPadding(UtilHelper.getDimenPixelSize(d1.M_W_X003), 0, 0, 0);
        c.a.r0.s.v.c d2 = c.a.r0.s.v.c.d(textView);
        d2.z(d1.T_X07);
        d2.v(c1.CAM_X0108);
        d2.A(i1.F_X01);
        linearLayout.addView(textView);
        imageView.setTag(Boolean.FALSE);
        imageView.setOnClickListener(new a(imageView));
        l lVar = new l(tbPageContext.getPageActivity());
        lVar.q(i1.frs_move_area_popup_title);
        if (frsTabInfo.is_general_tab.intValue() != 0 && frsTabInfo.tab_type.intValue() != 100) {
            String string = tbPageContext.getString(i1.frs_move_area_popup_content);
            String str = frsTabInfo.tab_name;
            format = String.format(string, str, frsTabInfo2.tab_name, str);
        } else {
            String string2 = tbPageContext.getString(i1.frs_move_area_popup_content_other);
            String str2 = frsTabInfo.tab_name;
            String str3 = frsTabInfo2.tab_name;
            format = String.format(string2, str2, str3, str2, str3);
        }
        lVar.n(format);
        lVar.k(3);
        lVar.l(true);
        lVar.h(linearLayout);
        lVar.p(new TBAlertConfig.a(i1.next_time, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.a(i1.frs_move_area_popup_confirm, TBAlertConfig.OperateBtnStyle.MAIN, new b(imageView, frsTabInfo, frsTabInfo2)));
        lVar.f();
        lVar.t();
    }
}
