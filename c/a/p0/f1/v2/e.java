package c.a.p0.f1.v2;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.o0.r.t.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;

        public a(ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Drawable maskDrawable;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                view.setTag(Boolean.valueOf(!((Boolean) view.getTag()).booleanValue()));
                ImageView imageView = this.a;
                if (((Boolean) view.getTag()).booleanValue()) {
                    maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.obfuscated_res_0x7f0805f1, null);
                } else {
                    maskDrawable = SvgManager.getInstance().getMaskDrawable(R.drawable.obfuscated_res_0x7f0805f0, null);
                }
                imageView.setImageDrawable(maskDrawable);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f14777b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FrsTabInfo f14778c;

        public b(ImageView imageView, FrsTabInfo frsTabInfo, FrsTabInfo frsTabInfo2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageView, frsTabInfo, frsTabInfo2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageView;
            this.f14777b = frsTabInfo;
            this.f14778c = frsTabInfo2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.o0.r.j0.b.k().u("key_frs_move_area_tip", !((Boolean) this.a.getTag()).booleanValue());
                c.a.p0.f1.a.h().m(this.f14777b.tab_id.intValue(), this.f14778c.tab_id.intValue());
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
        linearLayout.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X012), UtilHelper.getDimenPixelSize(R.dimen.M_H_X008), UtilHelper.getDimenPixelSize(R.dimen.M_W_X012), 0);
        ImageView imageView = new ImageView(pageActivity);
        imageView.setImageDrawable(SvgManager.getInstance().getMaskDrawable(R.drawable.obfuscated_res_0x7f0805f0, null));
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds39), UtilHelper.getDimenPixelSize(R.dimen.tbds39)));
        TextView textView = new TextView(pageActivity);
        textView.setText(R.string.obfuscated_res_0x7f0f0c5d);
        textView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), 0, 0, 0);
        c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(textView);
        d2.z(R.dimen.T_X07);
        d2.v(R.color.CAM_X0108);
        d2.A(R.string.F_X01);
        linearLayout.addView(textView);
        imageView.setTag(Boolean.FALSE);
        imageView.setOnClickListener(new a(imageView));
        o oVar = new o(tbPageContext.getPageActivity());
        oVar.v(R.string.obfuscated_res_0x7f0f070c);
        if (frsTabInfo.is_general_tab.intValue() != 0 && frsTabInfo.tab_type.intValue() != 100) {
            String string = tbPageContext.getString(R.string.obfuscated_res_0x7f0f070a);
            String str = frsTabInfo.tab_name;
            format = String.format(string, str, frsTabInfo2.tab_name, str);
        } else {
            String string2 = tbPageContext.getString(R.string.obfuscated_res_0x7f0f070b);
            String str2 = frsTabInfo.tab_name;
            String str3 = frsTabInfo2.tab_name;
            format = String.format(string2, str2, str3, str2, str3);
        }
        oVar.p(format);
        oVar.m(3);
        oVar.n(true);
        oVar.j(linearLayout);
        oVar.r(new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0c21, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0709, TBAlertConfig.OperateBtnStyle.MAIN, new b(imageView, frsTabInfo, frsTabInfo2)));
        oVar.g();
        oVar.y();
    }
}
