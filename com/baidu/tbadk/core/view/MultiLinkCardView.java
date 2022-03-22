package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.o0.c1.q0;
import c.a.p0.h0.e0.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class MultiLinkCardView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f30030b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f30031c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f30032d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f30033e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f30034f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f30035g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f30036h;
    public TbImageView i;
    public TextView j;
    public TextView k;
    public ImageView l;
    public List<RelativeLayout> m;
    public List<TbImageView> n;
    public List<TextView> o;

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
        n.f(TbadkCoreApplication.getInst(), R.dimen.tbds136);
        n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            q0 q0Var = new q0();
            List<c> a = q0Var.a(list, list2);
            boolean b2 = q0Var.b();
            if (ListUtils.isEmpty(a)) {
                return;
            }
            if (UbsABTestHelper.showNewUI()) {
                TBSelector.makeDrawableSelector().gradientLinear(R.color.CAM_X0601, R.color.CAM_X0606).radius(n.f(getContext(), R.dimen.tbds10)).into(this.j);
            }
            this.f30032d.setVisibility(8);
            this.f30033e.setVisibility(8);
            this.f30034f.setVisibility(8);
            this.j.setVisibility(8);
            int size = a.size() > 3 ? 3 : a.size();
            for (int i = 0; i < size; i++) {
                if (a.get(i) instanceof PbLinkData) {
                    PbLinkData pbLinkData = (PbLinkData) a.get(i);
                    if (i < a.size() && pbLinkData != null) {
                        this.m.get(i).setVisibility(0);
                        this.n.get(i).J(pbLinkData.picUrl, 10, false);
                        if (pbLinkData.urlType == 2 && !TextUtils.isEmpty(pbLinkData.linkFrom)) {
                            this.o.get(i).setText(pbLinkData.linkFrom);
                            this.o.get(i).setVisibility(0);
                        }
                    }
                } else if (a.get(i) instanceof PbGoodsData) {
                    PbGoodsData pbGoodsData = (PbGoodsData) a.get(i);
                    if (i < a.size() && pbGoodsData != null) {
                        this.m.get(i).setVisibility(0);
                        this.n.get(i).J(pbGoodsData.picUrl, 10, false);
                    }
                }
                if (a.size() > 3 && i == 2) {
                    this.j.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0427, Integer.valueOf(a.size() - 3)));
                    this.j.setVisibility(0);
                }
            }
            this.k.setText(getContext().getString(b2 ? R.string.obfuscated_res_0x7f0f0b08 : R.string.obfuscated_res_0x7f0f0b09, Integer.valueOf(a.size())));
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundResource(this, R.drawable.bg_link_card);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0107);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
            for (int i = 0; i < this.o.size(); i++) {
                SkinManager.setViewTextColor(this.o.get(i), (int) R.color.CAM_X0101);
                TBSelector.makeDrawableSelector().setShape(0).defaultColor(R.color.cp_link_tip_d_alpha66).blRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).brRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds10)).tlRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).trRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).into(this.o.get(i));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiLinkCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0593, this);
        this.f30032d = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091ad0);
        this.f30033e = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091ad1);
        this.f30034f = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091ad2);
        this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f090cdb);
        this.f30030b = (TextView) findViewById(R.id.obfuscated_res_0x7f090cdc);
        this.f30031c = (TextView) findViewById(R.id.obfuscated_res_0x7f090cdd);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090fe3);
        this.f30035g = tbImageView;
        tbImageView.setDrawCorner(true);
        this.f30035g.setGifIconSupport(false);
        this.f30035g.setLongIconSupport(false);
        this.f30035g.setConrers(15);
        this.f30035g.setPlaceHolder(1);
        this.f30035g.setRadius(n.f(getContext(), R.dimen.tbds10));
        TbImageView tbImageView2 = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090fe5);
        this.f30036h = tbImageView2;
        tbImageView2.setDrawCorner(true);
        this.f30036h.setGifIconSupport(false);
        this.f30036h.setLongIconSupport(false);
        this.f30036h.setConrers(15);
        this.f30036h.setPlaceHolder(1);
        this.f30036h.setRadius(n.f(getContext(), R.dimen.tbds10));
        TbImageView tbImageView3 = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090fe6);
        this.i = tbImageView3;
        tbImageView3.setDrawCorner(true);
        this.i.setGifIconSupport(false);
        this.i.setLongIconSupport(false);
        this.i.setPlaceHolder(1);
        this.i.setConrers(15);
        this.i.setRadius(n.f(getContext(), R.dimen.tbds10));
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0921d9);
        this.j = textView;
        c.a.o0.r.v.c.d(textView).y(R.array.S_O_X001);
        this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f0921d8);
        this.l = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fe4);
        this.o = new ArrayList();
        this.n = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.m = arrayList;
        arrayList.add(this.f30032d);
        this.m.add(this.f30033e);
        this.m.add(this.f30034f);
        this.n.add(this.f30035g);
        this.n.add(this.f30036h);
        this.n.add(this.i);
        this.o.add(this.a);
        this.o.add(this.f30030b);
        this.o.add(this.f30031c);
        b();
    }
}
