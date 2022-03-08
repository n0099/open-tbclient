package c.a.r0.o2.d;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.n;
import c.a.r0.o2.e.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b extends c.a.d.o.e.a<c, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f20326b;

        /* renamed from: c  reason: collision with root package name */
        public View f20327c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view, TextView textView, View view2) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, textView, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 3;
            this.f20326b = textView;
            this.f20327c = view2;
        }

        public void a(c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null) {
                return;
            }
            this.f20326b.setText(cVar.f20369e);
            this.f20327c.setVisibility(cVar.f20370f ? 0 : 8);
        }

        public void onChangeSkinType(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.a == i2) {
                return;
            }
            SkinManager.setViewTextColor(this.f20326b, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.f20327c, R.color.CAM_X0204);
            this.a = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), c.a.r0.o2.e.a.f20362b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: Z */
    public a M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
            linearLayout.setOrientation(1);
            linearLayout.setPadding(n.f(viewGroup.getContext(), R.dimen.tbds44), 0, n.f(viewGroup.getContext(), R.dimen.tbds44), n.f(viewGroup.getContext(), R.dimen.tbds12));
            linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            View view = new View(viewGroup.getContext());
            linearLayout.addView(view, new LinearLayout.LayoutParams(-1, n.f(viewGroup.getContext(), R.dimen.tbds1)));
            TextView textView = new TextView(viewGroup.getContext());
            textView.setTextColor(viewGroup.getContext().getResources().getColor(R.color.CAM_X0105));
            textView.setTextSize(0, n.f(viewGroup.getContext(), R.dimen.tbds47));
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setIncludeFontPadding(false);
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setPadding(0, n.f(viewGroup.getContext(), R.dimen.tbds48), 0, 0);
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
            a aVar = new a(linearLayout, textView, view);
            aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: a0 */
    public View S(int i2, View view, ViewGroup viewGroup, c cVar, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, cVar, aVar})) == null) {
            if (cVar == null || aVar == null) {
                return null;
            }
            aVar.a(cVar);
            aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return aVar.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
