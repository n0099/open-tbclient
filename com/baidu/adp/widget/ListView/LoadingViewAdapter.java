package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.eo;
import com.repackage.mi;
import com.repackage.x45;
import com.repackage.yo;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class LoadingViewAdapter extends eo<yo, TabLoadingViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedList<Pair<RelativeLayout, x45>> i;
    public int j;
    public int k;

    /* loaded from: classes.dex */
    public static class TabLoadingViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public x45 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TabLoadingViewHolder(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingViewAdapter(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), yo.a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new LinkedList<>();
        this.j = Z(R.dimen.tbds304);
        this.k = Z(R.dimen.tbds198);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.repackage.eo
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, yo yoVar, TabLoadingViewHolder tabLoadingViewHolder) {
        b0(i, view2, viewGroup, yoVar, tabLoadingViewHolder);
        return view2;
    }

    public final int Z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? mi.f(TbadkCoreApplication.getInst(), i) : invokeI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: a0 */
    public TabLoadingViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            RelativeLayout relativeLayout = new RelativeLayout(this.a);
            ViewGroup.LayoutParams u = u(viewGroup);
            u.width = -1;
            u.height = -1;
            relativeLayout.setLayoutParams(u);
            relativeLayout.setGravity(1);
            x45 x45Var = new x45(this.a, 0);
            x45Var.attachView(relativeLayout);
            x45Var.s(this.j);
            x45Var.p(this.k);
            View view2 = x45Var.getView();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view2.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            layoutParams.addRule(14);
            view2.setLayoutParams(layoutParams);
            this.i.add(new Pair<>(relativeLayout, x45Var));
            TabLoadingViewHolder tabLoadingViewHolder = new TabLoadingViewHolder(relativeLayout);
            tabLoadingViewHolder.a = x45Var;
            return tabLoadingViewHolder;
        }
        return (TabLoadingViewHolder) invokeL.objValue;
    }

    public View b0(int i, View view2, ViewGroup viewGroup, yo yoVar, TabLoadingViewHolder tabLoadingViewHolder) {
        InterceptResult invokeCommon;
        x45 x45Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, yoVar, tabLoadingViewHolder})) == null) {
            if (tabLoadingViewHolder != null && (x45Var = tabLoadingViewHolder.a) != null) {
                x45Var.m(TbadkCoreApplication.getInst().getSkinType());
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
