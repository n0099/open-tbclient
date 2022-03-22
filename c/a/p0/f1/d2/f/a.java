package c.a.p0.f1.d2.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.p0.f1.d2.g.h;
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
public class a extends c.a.l.a<c.a.p0.f1.d2.g.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public View f13914f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f13915g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<h> f13916h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.l.a
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f13914f == null) {
                View inflate = LayoutInflater.from(this.f3392b).inflate(R.layout.obfuscated_res_0x7f0d01a6, (ViewGroup) null, true);
                this.f13914f = inflate;
                this.f13915g = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f090f68);
            }
            return this.f13914f;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: o */
    public void a(c.a.p0.f1.d2.g.c cVar) {
        boolean z;
        View childAt;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) && cVar != null && cVar.g()) {
            ArrayList<h> e2 = cVar.e();
            if (ListUtils.getCount(e2) != ListUtils.getCount(this.f13916h)) {
                if (ListUtils.getCount(this.f13916h) > 0) {
                    ((ViewGroup) this.f13914f).removeViews(1, ListUtils.getCount(this.f13916h));
                }
                z = true;
            } else {
                z = false;
            }
            if (e2 != null) {
                for (int i = 0; i < e2.size(); i++) {
                    if (z) {
                        childAt = new CardItemDetailListItemLayout(this.f3392b);
                        ((ViewGroup) this.f13914f).addView(childAt, -1, -2);
                    } else {
                        childAt = ((ViewGroup) this.f13914f).getChildAt(i + 1);
                    }
                    if (childAt instanceof CardItemDetailListItemLayout) {
                        ((CardItemDetailListItemLayout) childAt).setData(e2.get(i));
                    }
                }
            }
            ViewGroup viewGroup = (ViewGroup) this.f13914f;
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
            this.f13916h = e2;
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.f13914f);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.f13915g);
            d3.A(R.string.F_X02);
            d3.v(R.color.CAM_X0105);
            for (int i2 = 0; i2 < ((ViewGroup) this.f13914f).getChildCount(); i2++) {
                if (((ViewGroup) this.f13914f).getChildAt(i2) instanceof CardItemDetailListItemLayout) {
                    ((CardItemDetailListItemLayout) ((ViewGroup) this.f13914f).getChildAt(i2)).d();
                }
            }
        }
    }
}
