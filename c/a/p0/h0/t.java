package c.a.p0.h0;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class t extends b<c.a.p0.h0.e0.p> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public HeadImageView j;
    public TextView k;
    public TextView l;
    public TbImageView m;
    public TextView n;
    public View o;
    public c.a.p0.h0.e0.p p;
    public int q;
    public String r;
    public String s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = tbPageContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070266);
        q(k());
    }

    @Override // c.a.p0.h0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01b7 : invokeV.intValue;
    }

    @Override // c.a.p0.h0.b
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundResource(this.i, R.drawable.addresslist_item_bg);
                SkinManager.setBackgroundResource(this.n, R.drawable.label_bg_gray);
                SkinManager.setBackgroundResource(this.o, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.n, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0105, 1);
                this.j.setPlaceHolder(1);
                this.m.setPlaceHolder(2);
            }
            this.a = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if ((view == this.j || view == this.k || view == this.n) && !StringUtils.isNull(this.p.f15347d)) {
                TiebaStatic.log(new StatisticItem(this.r).param("obj_id", String.valueOf(this.p.a)));
                UrlManager.getInstance().dealOneLink(j(), new String[]{this.p.f15347d});
            } else if ((view == this.i || view == this.l || view == this.m) && !StringUtils.isNull(this.p.f15350g)) {
                TiebaStatic.log(new StatisticItem(this.s).param("obj_id", String.valueOf(this.p.a)));
                UrlManager.getInstance().dealOneLink(j(), new String[]{this.p.f15350g});
            }
        }
    }

    public final void q(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            this.i = view.findViewById(R.id.obfuscated_res_0x7f091aee);
            this.j = (HeadImageView) view.findViewById(R.id.obfuscated_res_0x7f09193d);
            this.k = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091940);
            this.l = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09193c);
            this.m = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f09193f);
            this.n = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09193e);
            this.o = view.findViewById(R.id.obfuscated_res_0x7f0920c0);
            this.j.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.i.setOnClickListener(this);
            this.j.setDefaultResource(17170445);
            this.j.setPlaceHolder(1);
            this.j.setRadius(this.q);
            this.m.setDrawBorder(true);
            this.m.setBorderWidth(1);
            this.m.setPlaceHolder(2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h0.b
    /* renamed from: s */
    public void l(c.a.p0.h0.e0.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pVar) == null) {
            if (pVar == null) {
                this.i.setVisibility(8);
                return;
            }
            if (this.i.getVisibility() != 0) {
                this.i.setVisibility(0);
            }
            this.p = pVar;
            this.j.J(pVar.f15346c, 10, false);
            this.k.setText(UtilHelper.getFixedText(pVar.f15345b, 7, true));
            if (StringUtils.isNull(pVar.i)) {
                this.n.setVisibility(8);
            } else {
                this.n.setVisibility(0);
                this.n.setText(pVar.i);
            }
            this.l.setText(pVar.f15348e);
            if (c.a.o0.r.l.c().g()) {
                this.m.setVisibility(0);
                this.m.J(pVar.f15349f, 10, false);
                return;
            }
            this.m.setVisibility(8);
        }
    }

    public void t(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) {
            this.r = str2;
            this.s = str3;
        }
    }
}
