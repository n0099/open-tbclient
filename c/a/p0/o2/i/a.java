package c.a.p0.o2.i;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import c.a.o0.k0.d.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes2.dex */
public class a extends c.a.o0.k0.f.a<c.a.p0.o2.h.a, b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public View f16864g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16865h;
    public TextView i;
    public TextView j;
    public TextView k;
    public View l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, viewEventCenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1], (ViewEventCenter) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16864g = view;
        this.f16865h = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09202b);
        TextView textView = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0906d7);
        this.i = textView;
        textView.setSingleLine();
        this.i.setEllipsize(TextUtils.TruncateAt.END);
        this.j = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091ffb);
        this.k = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0912c5);
        this.l = view.findViewById(R.id.obfuscated_res_0x7f091255);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.k0.f.e
    /* renamed from: m */
    public void i(c.a.p0.o2.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            super.i(aVar);
            if (aVar == null) {
                return;
            }
            if (this.f16865h != null) {
                if (aVar.k() == 49) {
                    if (StringUtils.isNull(aVar.c())) {
                        if (StringUtils.isNull(aVar.m())) {
                            this.f16865h.setText(g(R.string.obfuscated_res_0x7f0f0da3));
                        } else {
                            this.f16865h.setText(aVar.m());
                        }
                    } else {
                        this.f16865h.setText(aVar.c());
                    }
                } else if (aVar.i() != null) {
                    if (aVar.s()) {
                        this.f16865h.setText(String.format("%s%s", g(R.string.obfuscated_res_0x7f0f0da5), aVar.i()));
                    } else {
                        this.f16865h.setText(aVar.i());
                    }
                }
            }
            if (this.i != null) {
                if (aVar.k() == 49 && !TextUtils.isEmpty(aVar.m())) {
                    this.i.setText(String.format(g(R.string.obfuscated_res_0x7f0f0da6), aVar.m()));
                } else if (aVar.k() == 49) {
                    this.i.setText(String.format(g(R.string.obfuscated_res_0x7f0f0da6), g(R.string.obfuscated_res_0x7f0f0da3)));
                } else if (aVar.d() != null) {
                    this.i.setText(aVar.d());
                }
            }
            if (aVar.k() == 49) {
                this.k.setVisibility(aVar.q() ? 0 : 8);
            } else {
                this.k.setVisibility(8);
            }
            if (this.j != null) {
                String postTimeString = StringHelper.getPostTimeString(new Date(aVar.l()));
                if (postTimeString == null) {
                    postTimeString = "";
                }
                this.j.setText(postTimeString);
            }
        }
    }

    @Override // c.a.p0.a4.v
    @SuppressLint({"ResourceAsColor"})
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i)) == null) {
            SkinManager.setBackgroundResource(this.f16864g, R.drawable.list_item_selector);
            SkinManager.setBackgroundResource(this.l, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f16865h, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0101);
            TBSelector.makeDrawableSelector().cornerRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds6)).gradientLinear(DrawableSelector.LEFT_RIGHT, R.color.CAM_X0308, R.color.CAM_X0301).into(this.k);
            return true;
        }
        return invokeLI.booleanValue;
    }
}
