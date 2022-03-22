package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import c.a.d.f.p.n;
import c.a.d.o.e.a;
import c.a.d.o.e.t;
import c.a.o0.f0.g;
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
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class LoadingViewAdapter extends a<t, TabLoadingViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedList<Pair<RelativeLayout, g>> i;
    public int j;
    public int k;

    /* loaded from: classes3.dex */
    public static class TabLoadingViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public g a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TabLoadingViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
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
        super(tbPageContext.getPageActivity(), t.a);
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
    @Override // c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i, View view, ViewGroup viewGroup, t tVar, TabLoadingViewHolder tabLoadingViewHolder) {
        b0(i, view, viewGroup, tVar, tabLoadingViewHolder);
        return view;
    }

    public final int Z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? n.f(TbadkCoreApplication.getInst(), i) : invokeI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
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
            g gVar = new g(this.a, 0);
            gVar.attachView(relativeLayout);
            gVar.s(this.j);
            gVar.p(this.k);
            View view = gVar.getView();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            layoutParams.addRule(14);
            view.setLayoutParams(layoutParams);
            this.i.add(new Pair<>(relativeLayout, gVar));
            TabLoadingViewHolder tabLoadingViewHolder = new TabLoadingViewHolder(relativeLayout);
            tabLoadingViewHolder.a = gVar;
            return tabLoadingViewHolder;
        }
        return (TabLoadingViewHolder) invokeL.objValue;
    }

    public View b0(int i, View view, ViewGroup viewGroup, t tVar, TabLoadingViewHolder tabLoadingViewHolder) {
        InterceptResult invokeCommon;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view, viewGroup, tVar, tabLoadingViewHolder})) == null) {
            if (tabLoadingViewHolder != null && (gVar = tabLoadingViewHolder.a) != null) {
                gVar.m(TbadkCoreApplication.getInst().getSkinType());
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
