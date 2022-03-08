package c.a.r0.d1.d2.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.r0.d1.d2.g.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.itemtab.card.CardItemDetailListItemLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends c.a.l.a<c.a.r0.d1.d2.g.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public View f15434j;
    public EMTextView k;
    public ArrayList<h> l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.l.a
    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f15434j == null) {
                View inflate = LayoutInflater.from(this.f4007f).inflate(R.layout.card_item_detail_info, (ViewGroup) null, true);
                this.f15434j = inflate;
                this.k = (EMTextView) inflate.findViewById(R.id.item_detail_title);
            }
            return this.f15434j;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: n */
    public void onBindDataToView(c.a.r0.d1.d2.g.c cVar) {
        boolean z;
        View childAt;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) && cVar != null && cVar.i()) {
            ArrayList<h> g2 = cVar.g();
            if (ListUtils.getCount(g2) != ListUtils.getCount(this.l)) {
                if (ListUtils.getCount(this.l) > 0) {
                    ((ViewGroup) this.f15434j).removeViews(1, ListUtils.getCount(this.l));
                }
                z = true;
            } else {
                z = false;
            }
            if (g2 != null) {
                for (int i2 = 0; i2 < g2.size(); i2++) {
                    if (z) {
                        childAt = new CardItemDetailListItemLayout(this.f4007f);
                        ((ViewGroup) this.f15434j).addView(childAt, -1, -2);
                    } else {
                        childAt = ((ViewGroup) this.f15434j).getChildAt(i2 + 1);
                    }
                    if (childAt instanceof CardItemDetailListItemLayout) {
                        ((CardItemDetailListItemLayout) childAt).setData(g2.get(i2));
                    }
                }
            }
            ViewGroup viewGroup = (ViewGroup) this.f15434j;
            int childCount = viewGroup.getChildCount() - 1;
            while (true) {
                if (childCount <= 0) {
                    break;
                }
                if ((viewGroup.getChildAt(childCount) instanceof CardItemDetailListItemLayout) && viewGroup.getChildAt(childCount).getVisibility() == 0) {
                    ((CardItemDetailListItemLayout) viewGroup.getChildAt(childCount)).setDividerVisible(false);
                    break;
                }
                childCount--;
            }
            this.l = g2;
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) {
            c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(this.f15434j);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
            c.a.q0.r.v.c d3 = c.a.q0.r.v.c.d(this.k);
            d3.A(R.string.F_X02);
            d3.v(R.color.CAM_X0105);
            for (int i3 = 0; i3 < ((ViewGroup) this.f15434j).getChildCount(); i3++) {
                if (((ViewGroup) this.f15434j).getChildAt(i3) instanceof CardItemDetailListItemLayout) {
                    ((CardItemDetailListItemLayout) ((ViewGroup) this.f15434j).getChildAt(i3)).onChangeSkinType();
                }
            }
        }
    }
}
