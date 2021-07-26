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
import d.a.d.e.p.l;
import d.a.d.k.e.a;
import d.a.d.k.e.t;
import d.a.p0.f0.g;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class LoadingViewAdapter extends a<t, TabLoadingViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedList<Pair<RelativeLayout, g>> m;
    public int n;
    public int o;

    /* loaded from: classes.dex */
    public static class TabLoadingViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public g f2419a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TabLoadingViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
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
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingViewAdapter(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), t.f42436e);
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
        this.m = new LinkedList<>();
        this.n = e0(R.dimen.tbds304);
        this.o = e0(R.dimen.tbds198);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.d.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, t tVar, TabLoadingViewHolder tabLoadingViewHolder) {
        g0(i2, view, viewGroup, tVar, tabLoadingViewHolder);
        return view;
    }

    public final int e0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? l.g(TbadkCoreApplication.getInst(), i2) : invokeI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: f0 */
    public TabLoadingViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            RelativeLayout relativeLayout = new RelativeLayout(this.f42341e);
            ViewGroup.LayoutParams u = u(viewGroup);
            u.width = -1;
            u.height = -1;
            relativeLayout.setLayoutParams(u);
            relativeLayout.setGravity(1);
            g gVar = new g(this.f42341e, 0);
            gVar.attachView(relativeLayout);
            gVar.q(this.n);
            gVar.o(this.o);
            View view = gVar.getView();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            layoutParams.addRule(14);
            view.setLayoutParams(layoutParams);
            this.m.add(new Pair<>(relativeLayout, gVar));
            TabLoadingViewHolder tabLoadingViewHolder = new TabLoadingViewHolder(relativeLayout);
            tabLoadingViewHolder.f2419a = gVar;
            return tabLoadingViewHolder;
        }
        return (TabLoadingViewHolder) invokeL.objValue;
    }

    public View g0(int i2, View view, ViewGroup viewGroup, t tVar, TabLoadingViewHolder tabLoadingViewHolder) {
        InterceptResult invokeCommon;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, tVar, tabLoadingViewHolder})) == null) {
            if (tabLoadingViewHolder != null && (gVar = tabLoadingViewHolder.f2419a) != null) {
                gVar.l(TbadkCoreApplication.getInst().getSkinType());
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
