package b.a.r0.x0.r1;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.f.p.l;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.e1;
import b.a.r0.x0.f1;
import b.a.r0.x0.g1;
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
/* loaded from: classes6.dex */
public class b extends b.a.r0.b0.b<c> {
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
        View i4 = i();
        this.m = (TbImageView) i4.findViewById(f1.ad_portrait);
        this.n = (TextView) i4.findViewById(f1.ad_title);
        this.o = (TextView) i4.findViewById(f1.ad_desc);
        this.r = (ConstrainImageGroup) i4.findViewById(f1.ad_img_layout);
        this.p = i4.findViewById(f1.item_divider);
        this.q = (RelativeLayout) i4.findViewById(f1.frs_ad_list_item_view);
        i4.setOnClickListener(this);
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? g1.frs_ad_list_item_view : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f16223e == i2) {
            return;
        }
        this.f16223e = i2;
        SkinManager.setViewTextColor(this.n, c1.CAM_X0105);
        SkinManager.setViewTextColor(this.o, c1.CAM_X0109);
        SkinManager.setBackgroundResource(this.q, e1.ad_list_item_bg);
        this.r.onChangeSkinType();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: o */
    public void j(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) || cVar == null) {
            return;
        }
        this.m.setPlaceHolder(1);
        this.m.startLoad(cVar.k(), 10, false);
        this.m.setRadius(l.g(getContext(), d1.tbds26));
        this.m.setDrawerType(1);
        this.m.setDrawBorder(true);
        this.m.setBorderColor(SkinManager.getColor(c1.black_alpha15));
        this.m.setBorderWidth(l.g(getContext(), d1.tbds1));
        this.m.setDefaultResource(e1.transparent_bg);
        this.m.setDefaultBgResource(e1.transparent_bg);
        this.n.setText(cVar.i());
        this.o.setText(cVar.g());
        SkinManager.setViewTextColor(this.n, c1.CAM_X0105);
        SkinManager.setViewTextColor(this.o, c1.CAM_X0109);
        SkinManager.setBackgroundResource(this.q, e1.ad_list_item_bg);
        if (ListUtils.getCount(cVar.q()) > 0) {
            b.a.q0.e1.j.f fVar = new b.a.q0.e1.j.f(3);
            fVar.d(1.0d);
            this.r.setVisibility(0);
            this.r.setFromCDN(true);
            this.r.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d1.tbds20));
            this.r.setImageProcessor(fVar);
            this.r.setImageMediaList(cVar.q());
            if (!cVar.p()) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.g(getContext(), d1.tbds16));
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
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.g(getContext(), d1.tbds1));
            layoutParams2.addRule(12);
            this.p.setLayoutParams(layoutParams2);
            SkinManager.setBackgroundColor(this.p, c1.CAM_X0204);
            this.p.setVisibility(0);
            return;
        }
        this.p.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
        }
    }

    public void p(b.a.e.f.k.b<TbImageView> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) || (constrainImageGroup = this.r) == null) {
            return;
        }
        constrainImageGroup.setImageViewPool(bVar);
    }

    public void q(b.a.e.f.k.b<ConstrainImageLayout> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || (constrainImageGroup = this.r) == null) {
            return;
        }
        constrainImageGroup.setConstrainLayoutPool(bVar);
    }

    public void s(double d2) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Double.valueOf(d2)}) == null) || (constrainImageGroup = this.r) == null) {
            return;
        }
        constrainImageGroup.setSingleImageRatio(d2);
    }
}
