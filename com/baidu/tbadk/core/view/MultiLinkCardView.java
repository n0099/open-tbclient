package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PbGoodsData;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.b.d;
import d.a.p0.b1.l0;
import d.a.q0.a0.e0.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MultiLinkCardView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f12501e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12502f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12503g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f12504h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f12505i;
    public RelativeLayout j;
    public TbImageView k;
    public TbImageView l;
    public TbImageView m;
    public TextView n;
    public TextView o;
    public ImageView p;
    public List<RelativeLayout> q;
    public List<TbImageView> r;
    public List<TextView> s;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1043075280, "Lcom/baidu/tbadk/core/view/MultiLinkCardView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1043075280, "Lcom/baidu/tbadk/core/view/MultiLinkCardView;");
                return;
            }
        }
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds136);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiLinkCardView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void a(List<PbLinkData> list, List<PbGoodsData> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, list, list2) == null) {
            new ArrayList();
            l0 l0Var = new l0();
            List<c> a2 = l0Var.a(list, list2);
            boolean b2 = l0Var.b();
            if (ListUtils.isEmpty(a2)) {
                return;
            }
            if (d.o0()) {
                TBSelector.makeDrawableSelector().gradientLinear(R.color.CAM_X0601, R.color.CAM_X0606).radius(l.g(getContext(), R.dimen.tbds10)).into(this.n);
            }
            this.f12504h.setVisibility(8);
            this.f12505i.setVisibility(8);
            this.j.setVisibility(8);
            this.n.setVisibility(8);
            int size = a2.size() > 3 ? 3 : a2.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (a2.get(i2) instanceof PbLinkData) {
                    PbLinkData pbLinkData = (PbLinkData) a2.get(i2);
                    if (i2 < a2.size() && pbLinkData != null) {
                        this.q.get(i2).setVisibility(0);
                        this.r.get(i2).M(pbLinkData.picUrl, 10, false);
                        if (pbLinkData.urlType == 2 && !TextUtils.isEmpty(pbLinkData.linkFrom)) {
                            this.s.get(i2).setText(pbLinkData.linkFrom);
                            this.s.get(i2).setVisibility(0);
                        }
                    }
                } else if (a2.get(i2) instanceof PbGoodsData) {
                    PbGoodsData pbGoodsData = (PbGoodsData) a2.get(i2);
                    if (i2 < a2.size() && pbGoodsData != null) {
                        this.q.get(i2).setVisibility(0);
                        this.r.get(i2).M(pbGoodsData.picUrl, 10, false);
                    }
                }
                if (a2.size() > 3 && i2 == 2) {
                    this.n.setText(getContext().getString(R.string.constrain_image_extra_text, Integer.valueOf(a2.size() - 3)));
                    this.n.setVisibility(0);
                }
            }
            this.o.setText(getContext().getString(b2 ? R.string.multi_goods_count : R.string.multi_link_count, Integer.valueOf(a2.size())));
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundResource(this, R.drawable.bg_link_card);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0107);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.p, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
            for (int i2 = 0; i2 < this.s.size(); i2++) {
                SkinManager.setViewTextColor(this.s.get(i2), R.color.CAM_X0101);
                TBSelector.makeDrawableSelector().setShape(0).defaultColor(R.color.cp_link_tip_d_alpha66).blRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).brRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds10)).tlRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).trRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).into(this.s.get(i2));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiLinkCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiLinkCardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        LayoutInflater.from(context).inflate(R.layout.multi_link_card_layout, this);
        this.f12504h = (RelativeLayout) findViewById(R.id.rl_multi_link_first);
        this.f12505i = (RelativeLayout) findViewById(R.id.rl_multi_link_second);
        this.j = (RelativeLayout) findViewById(R.id.rl_multi_link_third);
        this.f12501e = (TextView) findViewById(R.id.goods_from_tag_first);
        this.f12502f = (TextView) findViewById(R.id.goods_from_tag_second);
        this.f12503g = (TextView) findViewById(R.id.goods_from_tag_third);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.iv_multi_link_first_icon);
        this.k = tbImageView;
        tbImageView.setDrawCorner(true);
        this.k.setGifIconSupport(false);
        this.k.setLongIconSupport(false);
        this.k.setConrers(15);
        this.k.setPlaceHolder(1);
        this.k.setRadius(l.g(getContext(), R.dimen.tbds10));
        TbImageView tbImageView2 = (TbImageView) findViewById(R.id.iv_multi_link_second_icon);
        this.l = tbImageView2;
        tbImageView2.setDrawCorner(true);
        this.l.setGifIconSupport(false);
        this.l.setLongIconSupport(false);
        this.l.setConrers(15);
        this.l.setPlaceHolder(1);
        this.l.setRadius(l.g(getContext(), R.dimen.tbds10));
        TbImageView tbImageView3 = (TbImageView) findViewById(R.id.iv_multi_link_third_icon);
        this.m = tbImageView3;
        tbImageView3.setDrawCorner(true);
        this.m.setGifIconSupport(false);
        this.m.setLongIconSupport(false);
        this.m.setPlaceHolder(1);
        this.m.setConrers(15);
        this.m.setRadius(l.g(getContext(), R.dimen.tbds10));
        TextView textView = (TextView) findViewById(R.id.tv_multi_link_more_link_count);
        this.n = textView;
        d.a.p0.s.u.c.d(textView).w(R.array.S_O_X001);
        this.o = (TextView) findViewById(R.id.tv_multi_link_count);
        this.p = (ImageView) findViewById(R.id.iv_multi_link_right_arrow);
        this.s = new ArrayList();
        this.r = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.q = arrayList;
        arrayList.add(this.f12504h);
        this.q.add(this.f12505i);
        this.q.add(this.j);
        this.r.add(this.k);
        this.r.add(this.l);
        this.r.add(this.m);
        this.s.add(this.f12501e);
        this.s.add(this.f12502f);
        this.s.add(this.f12503g);
        b();
    }
}
