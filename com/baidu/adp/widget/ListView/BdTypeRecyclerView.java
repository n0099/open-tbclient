package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cn;
import com.repackage.dn;
import com.repackage.jn;
import com.repackage.mn;
import com.repackage.pn;
import com.repackage.wm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeRecyclerView extends BdRecyclerView implements pn<BdTypeRecyclerView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerViewTypeAdapter t;
    public HashMap<BdUniqueId, wm> u;
    public HashMap<BdUniqueId, dn> v;
    public boolean w;
    public boolean x;
    public mn y;

    /* loaded from: classes.dex */
    public class a implements BdRecyclerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdTypeRecyclerView a;

        public a(BdTypeRecyclerView bdTypeRecyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTypeRecyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTypeRecyclerView;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view2, Object obj, int i, long j) {
            RecyclerViewTypeAdapter recyclerViewTypeAdapter;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) || (recyclerViewTypeAdapter = this.a.t) == null) {
                return;
            }
            recyclerViewTypeAdapter.i(viewGroup, view2, i, j);
        }
    }

    /* loaded from: classes.dex */
    public class b implements BdRecyclerView.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdTypeRecyclerView a;

        public b(BdTypeRecyclerView bdTypeRecyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTypeRecyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTypeRecyclerView;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.j
        public boolean a(ViewGroup viewGroup, View view2, Object obj, int i, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view2, obj, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                RecyclerViewTypeAdapter recyclerViewTypeAdapter = this.a.t;
                if (recyclerViewTypeAdapter != null) {
                    return recyclerViewTypeAdapter.j(viewGroup, view2, i, j);
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdTypeRecyclerView(Context context) {
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
        this.t = null;
        D();
    }

    public jn C(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.t.getItem(i) : (jn) invokeI.objValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.t == null) {
                this.t = new RecyclerViewTypeAdapter();
            }
            if (this.u == null) {
                this.u = new HashMap<>();
            }
            if (this.v == null) {
                this.v = new HashMap<>();
            }
            super.setOnItemClickListener(new a(this));
            super.setOnItemLongClickListener(new b(this));
        }
    }

    public void E(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.t.k(i, getHeaderViewsCount());
        }
    }

    public void F(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            this.t.l(i, i2, getHeaderViewsCount());
        }
    }

    @Override // com.repackage.pn
    public void a(List<wm> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            for (wm<jn, TypeAdapter.ViewHolder> wmVar : list) {
                if (wmVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (wmVar.y() != null) {
                        bdUniqueId = wmVar.y();
                        if (!this.v.containsKey(bdUniqueId)) {
                            dn dnVar = new dn(wmVar.a, bdUniqueId, wmVar.e);
                            dnVar.b0(wmVar);
                            this.t.d(dnVar);
                            this.v.put(bdUniqueId, dnVar);
                        }
                    }
                    if (wmVar.w() != null) {
                        bdUniqueId = wmVar.w();
                        if (!this.v.containsKey(bdUniqueId)) {
                            dn dnVar2 = new dn(wmVar.a, bdUniqueId, wmVar.e);
                            dnVar2.b0(wmVar);
                            this.t.d(dnVar2);
                            this.v.put(bdUniqueId, dnVar2);
                        }
                    }
                    if (wmVar.x() != null) {
                        bdUniqueId = wmVar.x();
                        if (!this.v.containsKey(bdUniqueId)) {
                            dn dnVar3 = new dn(wmVar.a, bdUniqueId, wmVar.e);
                            dnVar3.b0(wmVar);
                            this.t.d(dnVar3);
                            this.v.put(bdUniqueId, dnVar3);
                        }
                    }
                    if (wmVar.v() != null) {
                        bdUniqueId = wmVar.v();
                        if (!this.v.containsKey(bdUniqueId)) {
                            dn dnVar4 = new dn(wmVar.a, bdUniqueId, wmVar.e);
                            dnVar4.b0(wmVar);
                            this.t.d(dnVar4);
                            this.v.put(bdUniqueId, dnVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.t.d(wmVar);
                    } else {
                        this.u.put(wmVar.d, wmVar);
                    }
                }
            }
            setAdapter(this.t);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdRecyclerView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (!this.w || this.x) {
                return;
            }
            this.x = true;
            mn mnVar = this.y;
            if (mnVar != null) {
                mnVar.a();
            }
        }
    }

    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.t.getCount() : invokeV.intValue;
    }

    @Override // com.repackage.pn
    public List<jn> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.t.e() : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeRecyclerView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdRecyclerView, com.repackage.ln
    /* renamed from: getListView */
    public BdRecyclerView getListView2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this : (BdTypeRecyclerView) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, parcelable) == null) {
            super.onRestoreInstanceState(parcelable);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? super.onSaveInstanceState() : (Parcelable) invokeV.objValue;
    }

    @Override // com.repackage.pn
    public void setData(List<? extends jn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (jn jnVar : list) {
                if (jnVar != null) {
                    if (this.u.containsKey(jnVar.getType())) {
                        wm wmVar = this.u.get(jnVar.getType());
                        if (wmVar.y() != null) {
                            cn cnVar = new cn();
                            cnVar.i(wmVar.y());
                            if (jnVar instanceof BaseCardInfo) {
                                cnVar.position = ((BaseCardInfo) jnVar).position;
                                cnVar.setSupportType(BaseCardInfo.SupportType.TOP);
                            }
                            cnVar.g(jnVar);
                            arrayList.add(cnVar);
                        }
                        if (wmVar.w() != null) {
                            cn cnVar2 = new cn();
                            cnVar2.i(wmVar.w());
                            if (jnVar instanceof BaseCardInfo) {
                                cnVar2.position = ((BaseCardInfo) jnVar).position;
                                cnVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            }
                            cnVar2.g(jnVar);
                            arrayList.add(cnVar2);
                        }
                        if (wmVar.x() != null) {
                            cn cnVar3 = new cn();
                            cnVar3.i(wmVar.x());
                            if (jnVar instanceof BaseCardInfo) {
                                cnVar3.position = ((BaseCardInfo) jnVar).position;
                                cnVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            }
                            cnVar3.g(jnVar);
                            arrayList.add(cnVar3);
                        }
                        if (wmVar.v() != null) {
                            cn cnVar4 = new cn();
                            cnVar4.i(wmVar.v());
                            if (jnVar instanceof BaseCardInfo) {
                                cnVar4.position = ((BaseCardInfo) jnVar).position;
                                cnVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                            }
                            cnVar4.g(jnVar);
                            arrayList.add(cnVar4);
                        }
                    } else {
                        arrayList.add(jnVar);
                    }
                }
            }
            this.t.setData(arrayList);
        }
    }

    public void setDataWithPartChange(List<jn> list, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048590, this, list, i, i2) == null) {
            this.t.m(list, i, i2);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdRecyclerView
    @Deprecated
    public void setOnItemClickListener(BdRecyclerView.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, iVar) == null) {
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdRecyclerView
    public void setOnItemLongClickListener(BdRecyclerView.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jVar) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdTypeRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.t = null;
        D();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdTypeRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.t = null;
        D();
    }
}
