package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import com.repackage.ae5;
import com.repackage.gs4;
import com.repackage.mi;
import com.repackage.zx5;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MultiLinkCardView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public TextView c;
    public RelativeLayout d;
    public RelativeLayout e;
    public RelativeLayout f;
    public TbImageView g;
    public TbImageView h;
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
        mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds136);
        mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
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
            ae5 ae5Var = new ae5();
            List<zx5> a = ae5Var.a(list, list2);
            boolean b = ae5Var.b();
            if (ListUtils.isEmpty(a)) {
                return;
            }
            if (UbsABTestHelper.showNewUI()) {
                TBSelector.makeDrawableSelector().gradientLinear(R.color.CAM_X0601, R.color.CAM_X0606).radius(mi.f(getContext(), R.dimen.tbds10)).into(this.j);
            }
            this.d.setVisibility(8);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
            this.j.setVisibility(8);
            int size = a.size() > 3 ? 3 : a.size();
            for (int i = 0; i < size; i++) {
                if (a.get(i) instanceof PbLinkData) {
                    PbLinkData pbLinkData = (PbLinkData) a.get(i);
                    if (i < a.size() && pbLinkData != null) {
                        this.m.get(i).setVisibility(0);
                        this.n.get(i).K(pbLinkData.picUrl, 10, false);
                        if (pbLinkData.urlType == 2 && !TextUtils.isEmpty(pbLinkData.linkFrom)) {
                            this.o.get(i).setText(pbLinkData.linkFrom);
                            this.o.get(i).setVisibility(0);
                        }
                    }
                } else if (a.get(i) instanceof PbGoodsData) {
                    PbGoodsData pbGoodsData = (PbGoodsData) a.get(i);
                    if (i < a.size() && pbGoodsData != null) {
                        this.m.get(i).setVisibility(0);
                        this.n.get(i).K(pbGoodsData.picUrl, 10, false);
                    }
                }
                if (a.size() > 3 && i == 2) {
                    this.j.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0435, Integer.valueOf(a.size() - 3)));
                    this.j.setVisibility(0);
                }
            }
            this.k.setText(getContext().getString(b ? R.string.obfuscated_res_0x7f0f0b1a : R.string.obfuscated_res_0x7f0f0b1b, Integer.valueOf(a.size())));
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
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0581, this);
        this.d = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091b0f);
        this.e = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091b10);
        this.f = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091b11);
        this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f090ccf);
        this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f090cd0);
        this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f090cd1);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090fea);
        this.g = tbImageView;
        tbImageView.setDrawCorner(true);
        this.g.setGifIconSupport(false);
        this.g.setLongIconSupport(false);
        this.g.setConrers(15);
        this.g.setPlaceHolder(1);
        this.g.setRadius(mi.f(getContext(), R.dimen.tbds10));
        TbImageView tbImageView2 = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090fec);
        this.h = tbImageView2;
        tbImageView2.setDrawCorner(true);
        this.h.setGifIconSupport(false);
        this.h.setLongIconSupport(false);
        this.h.setConrers(15);
        this.h.setPlaceHolder(1);
        this.h.setRadius(mi.f(getContext(), R.dimen.tbds10));
        TbImageView tbImageView3 = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090fed);
        this.i = tbImageView3;
        tbImageView3.setDrawCorner(true);
        this.i.setGifIconSupport(false);
        this.i.setLongIconSupport(false);
        this.i.setPlaceHolder(1);
        this.i.setConrers(15);
        this.i.setRadius(mi.f(getContext(), R.dimen.tbds10));
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f092215);
        this.j = textView;
        gs4.d(textView).y(R.array.S_O_X001);
        this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f092214);
        this.l = (ImageView) findViewById(R.id.obfuscated_res_0x7f090feb);
        this.o = new ArrayList();
        this.n = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.m = arrayList;
        arrayList.add(this.d);
        this.m.add(this.e);
        this.m.add(this.f);
        this.n.add(this.g);
        this.n.add(this.h);
        this.n.add(this.i);
        this.o.add(this.a);
        this.o.add(this.b);
        this.o.add(this.c);
        b();
    }
}
