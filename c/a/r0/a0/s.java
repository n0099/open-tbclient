package c.a.r0.a0;

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
/* loaded from: classes3.dex */
public class s extends b<c.a.r0.a0.d0.o> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View m;
    public HeadImageView n;
    public TextView o;
    public TextView p;
    public TbImageView q;
    public TextView r;
    public View s;
    public c.a.r0.a0.d0.o t;
    public int u;
    public String v;
    public String w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        p(j());
    }

    @Override // c.a.r0.a0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.card_promotion_item : invokeV.intValue;
    }

    @Override // c.a.r0.a0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            if (this.f15557e != i2) {
                SkinManager.setBackgroundResource(this.m, R.drawable.addresslist_item_bg);
                SkinManager.setBackgroundResource(this.r, R.drawable.label_bg_gray);
                SkinManager.setBackgroundResource(this.s, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.r, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0105, 1);
                this.n.setPlaceHolder(1);
                this.q.setPlaceHolder(2);
            }
            this.f15557e = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if ((view == this.n || view == this.o || view == this.r) && !StringUtils.isNull(this.t.f15607h)) {
                TiebaStatic.log(new StatisticItem(this.v).param("obj_id", String.valueOf(this.t.f15604e)));
                UrlManager.getInstance().dealOneLink(i(), new String[]{this.t.f15607h});
            } else if ((view == this.m || view == this.p || view == this.q) && !StringUtils.isNull(this.t.k)) {
                TiebaStatic.log(new StatisticItem(this.w).param("obj_id", String.valueOf(this.t.f15604e)));
                UrlManager.getInstance().dealOneLink(i(), new String[]{this.t.k});
            }
        }
    }

    public final void p(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            this.m = view.findViewById(R.id.root_view);
            this.n = (HeadImageView) view.findViewById(R.id.promotion_head_img);
            this.o = (TextView) view.findViewById(R.id.promotion_name);
            this.p = (TextView) view.findViewById(R.id.promotion_desc);
            this.q = (TbImageView) view.findViewById(R.id.promotion_img);
            this.r = (TextView) view.findViewById(R.id.promotion_icon);
            this.s = view.findViewById(R.id.top_line);
            this.n.setOnClickListener(this);
            this.o.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.n.setDefaultResource(17170445);
            this.n.setPlaceHolder(1);
            this.n.setRadius(this.u);
            this.q.setDrawBorder(true);
            this.q.setBorderWidth(1);
            this.q.setPlaceHolder(2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a0.b
    /* renamed from: q */
    public void k(c.a.r0.a0.d0.o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, oVar) == null) {
            if (oVar == null) {
                this.m.setVisibility(8);
                return;
            }
            if (this.m.getVisibility() != 0) {
                this.m.setVisibility(0);
            }
            this.t = oVar;
            this.n.startLoad(oVar.f15606g, 10, false);
            this.o.setText(UtilHelper.getFixedText(oVar.f15605f, 7, true));
            if (StringUtils.isNull(oVar.m)) {
                this.r.setVisibility(8);
            } else {
                this.r.setVisibility(0);
                this.r.setText(oVar.m);
            }
            this.p.setText(oVar.f15608i);
            if (c.a.q0.s.k.c().g()) {
                this.q.setVisibility(0);
                this.q.startLoad(oVar.f15609j, 10, false);
                return;
            }
            this.q.setVisibility(8);
        }
    }

    public void s(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, str3) == null) {
            this.v = str2;
            this.w = str3;
        }
    }
}
