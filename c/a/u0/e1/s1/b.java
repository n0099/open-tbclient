package c.a.u0.e1.s1;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.u0.e1.c1;
import c.a.u0.e1.d1;
import c.a.u0.e1.e1;
import c.a.u0.e1.f1;
import c.a.u0.e1.g1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b extends c.a.u0.g0.b<c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView m;
    public TextView n;
    public TextView o;
    public View p;
    public RelativeLayout q;
    public ConstrainImageGroup r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext) {
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
        View j2 = j();
        this.m = (TbImageView) j2.findViewById(f1.ad_portrait);
        this.n = (TextView) j2.findViewById(f1.ad_title);
        this.o = (TextView) j2.findViewById(f1.ad_desc);
        this.r = (ConstrainImageGroup) j2.findViewById(f1.ad_img_layout);
        this.p = j2.findViewById(f1.item_divider);
        this.q = (RelativeLayout) j2.findViewById(f1.frs_ad_list_item_view);
        j2.setOnClickListener(this);
    }

    @Override // c.a.u0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? g1.frs_ad_list_item_view : invokeV.intValue;
    }

    @Override // c.a.u0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f17874e == i2) {
            return;
        }
        this.f17874e = i2;
        SkinManager.setViewTextColor(this.n, c1.CAM_X0105);
        SkinManager.setViewTextColor(this.o, c1.CAM_X0109);
        SkinManager.setBackgroundResource(this.q, e1.ad_list_item_bg);
        this.r.onChangeSkinType();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.u0.g0.b
    /* renamed from: p */
    public void k(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) || cVar == null) {
            return;
        }
        this.m.setPlaceHolder(1);
        this.m.startLoad(cVar.k(), 10, false);
        this.m.setRadius(n.f(getContext(), d1.tbds26));
        this.m.setDrawerType(1);
        this.m.setDrawBorder(true);
        this.m.setBorderColor(SkinManager.getColor(c1.black_alpha15));
        this.m.setBorderWidth(n.f(getContext(), d1.tbds1));
        this.m.setDefaultResource(e1.transparent_bg);
        this.m.setDefaultBgResource(e1.transparent_bg);
        this.n.setText(cVar.i());
        this.o.setText(cVar.g());
        SkinManager.setViewTextColor(this.n, c1.CAM_X0105);
        SkinManager.setViewTextColor(this.o, c1.CAM_X0109);
        SkinManager.setBackgroundResource(this.q, e1.ad_list_item_bg);
        if (ListUtils.getCount(cVar.q()) > 0) {
            c.a.t0.f1.j.f fVar = new c.a.t0.f1.j.f(3);
            fVar.d(1.0d);
            this.r.setVisibility(0);
            this.r.setFromCDN(true);
            this.r.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d1.tbds20));
            this.r.setImageProcessor(fVar);
            this.r.setImageMediaList(cVar.q());
            if (!cVar.p()) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, n.f(getContext(), d1.tbds16));
                layoutParams.addRule(12);
                this.p.setLayoutParams(layoutParams);
                SkinManager.setBackgroundColor(this.p, c1.CAM_X0204);
                this.p.setVisibility(0);
                return;
            }
            this.p.setVisibility(8);
            return;
        }
        this.r.setVisibility(8);
        if (!cVar.p()) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, n.f(getContext(), d1.tbds1));
            layoutParams2.addRule(12);
            this.p.setLayoutParams(layoutParams2);
            SkinManager.setBackgroundColor(this.p, c1.CAM_X0204);
            this.p.setVisibility(0);
            return;
        }
        this.p.setVisibility(8);
    }

    public void q(c.a.d.f.k.b<TbImageView> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) || (constrainImageGroup = this.r) == null) {
            return;
        }
        constrainImageGroup.setImageViewPool(bVar);
    }

    public void s(c.a.d.f.k.b<ConstrainImageLayout> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || (constrainImageGroup = this.r) == null) {
            return;
        }
        constrainImageGroup.setConstrainLayoutPool(bVar);
    }

    public void t(double d2) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Double.valueOf(d2)}) == null) || (constrainImageGroup = this.r) == null) {
            return;
        }
        constrainImageGroup.setSingleImageRatio(d2);
    }
}
