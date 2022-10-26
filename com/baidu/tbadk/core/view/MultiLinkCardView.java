package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
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
import com.baidu.tieba.fj;
import com.baidu.tieba.nv4;
import com.baidu.tieba.ri5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public List m;
    public List n;
    public List o;

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
        fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds136);
        fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
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
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d05ce, this);
        this.d = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091c5c);
        this.e = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091c5d);
        this.f = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091c5e);
        this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f090ceb);
        this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f090cec);
        this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f090ced);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f09100b);
        this.g = tbImageView;
        tbImageView.setDrawCorner(true);
        this.g.setGifIconSupport(false);
        this.g.setLongIconSupport(false);
        this.g.setConrers(15);
        this.g.setPlaceHolder(1);
        this.g.setRadius(fj.f(getContext(), R.dimen.tbds10));
        TbImageView tbImageView2 = (TbImageView) findViewById(R.id.obfuscated_res_0x7f09100d);
        this.h = tbImageView2;
        tbImageView2.setDrawCorner(true);
        this.h.setGifIconSupport(false);
        this.h.setLongIconSupport(false);
        this.h.setConrers(15);
        this.h.setPlaceHolder(1);
        this.h.setRadius(fj.f(getContext(), R.dimen.tbds10));
        TbImageView tbImageView3 = (TbImageView) findViewById(R.id.obfuscated_res_0x7f09100e);
        this.i = tbImageView3;
        tbImageView3.setDrawCorner(true);
        this.i.setGifIconSupport(false);
        this.i.setLongIconSupport(false);
        this.i.setPlaceHolder(1);
        this.i.setConrers(15);
        this.i.setRadius(fj.f(getContext(), R.dimen.tbds10));
        TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0923b7);
        this.j = textView;
        nv4.d(textView).y(R.array.S_O_X001);
        this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f0923b6);
        this.l = (ImageView) findViewById(R.id.obfuscated_res_0x7f09100c);
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

    public void a(List list, List list2) {
        int size;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, list, list2) == null) {
            new ArrayList();
            ri5 ri5Var = new ri5();
            List a = ri5Var.a(list, list2);
            boolean c = ri5Var.c();
            if (ListUtils.isEmpty(a)) {
                return;
            }
            if (UbsABTestHelper.showNewUI()) {
                TBSelector.makeDrawableSelector().gradientLinear(R.color.CAM_X0601, R.color.CAM_X0606).radius(fj.f(getContext(), R.dimen.tbds10)).into(this.j);
            }
            this.d.setVisibility(8);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
            this.j.setVisibility(8);
            if (a.size() > 3) {
                size = 3;
            } else {
                size = a.size();
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (a.get(i2) instanceof PbLinkData) {
                    PbLinkData pbLinkData = (PbLinkData) a.get(i2);
                    if (i2 < a.size() && pbLinkData != null) {
                        ((RelativeLayout) this.m.get(i2)).setVisibility(0);
                        ((TbImageView) this.n.get(i2)).L(pbLinkData.picUrl, 10, false);
                        if (pbLinkData.urlType == 2 && !TextUtils.isEmpty(pbLinkData.linkFrom)) {
                            ((TextView) this.o.get(i2)).setText(pbLinkData.linkFrom);
                            ((TextView) this.o.get(i2)).setVisibility(0);
                        }
                    }
                } else if (a.get(i2) instanceof PbGoodsData) {
                    PbGoodsData pbGoodsData = (PbGoodsData) a.get(i2);
                    if (i2 < a.size() && pbGoodsData != null) {
                        ((RelativeLayout) this.m.get(i2)).setVisibility(0);
                        ((TbImageView) this.n.get(i2)).L(pbGoodsData.picUrl, 10, false);
                    }
                }
                if (a.size() > 3 && i2 == 2) {
                    this.j.setText(getContext().getString(R.string.obfuscated_res_0x7f0f044a, Integer.valueOf(a.size() - 3)));
                    this.j.setVisibility(0);
                }
            }
            TextView textView = this.k;
            Context context = getContext();
            if (c) {
                i = R.string.obfuscated_res_0x7f0f0b4d;
            } else {
                i = R.string.obfuscated_res_0x7f0f0b4e;
            }
            textView.setText(context.getString(i, Integer.valueOf(a.size())));
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundResource(this, R.drawable.bg_link_card);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0107);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
            for (int i = 0; i < this.o.size(); i++) {
                SkinManager.setViewTextColor((View) this.o.get(i), (int) R.color.CAM_X0101);
                TBSelector.makeDrawableSelector().setShape(0).defaultColor(R.color.cp_link_tip_d_alpha66).blRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).brRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds10)).tlRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).trRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).into((View) this.o.get(i));
            }
        }
    }
}
