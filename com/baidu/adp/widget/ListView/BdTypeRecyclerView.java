package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import c.a.d.o.e.g;
import c.a.d.o.e.h;
import c.a.d.o.e.n;
import c.a.d.o.e.s;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class BdTypeRecyclerView extends BdRecyclerView implements s<BdTypeRecyclerView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerViewTypeAdapter t;
    public HashMap<BdUniqueId, c.a.d.o.e.a> u;
    public HashMap<BdUniqueId, h> v;

    /* loaded from: classes3.dex */
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
        public void b(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            RecyclerViewTypeAdapter recyclerViewTypeAdapter;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) || (recyclerViewTypeAdapter = this.a.t) == null) {
                return;
            }
            recyclerViewTypeAdapter.i(viewGroup, view, i, j);
        }
    }

    /* loaded from: classes3.dex */
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
        public boolean a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                RecyclerViewTypeAdapter recyclerViewTypeAdapter = this.a.t;
                if (recyclerViewTypeAdapter != null) {
                    return recyclerViewTypeAdapter.j(viewGroup, view, i, j);
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

    public n C(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.t.getItem(i) : (n) invokeI.objValue;
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

    @Override // c.a.d.o.e.s
    public void a(List<c.a.d.o.e.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            for (c.a.d.o.e.a<n, TypeAdapter.ViewHolder> aVar : list) {
                if (aVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (aVar.y() != null) {
                        bdUniqueId = aVar.y();
                        if (!this.v.containsKey(bdUniqueId)) {
                            h hVar = new h(aVar.a, bdUniqueId, aVar.f2571e);
                            hVar.b0(aVar);
                            this.t.d(hVar);
                            this.v.put(bdUniqueId, hVar);
                        }
                    }
                    if (aVar.w() != null) {
                        bdUniqueId = aVar.w();
                        if (!this.v.containsKey(bdUniqueId)) {
                            h hVar2 = new h(aVar.a, bdUniqueId, aVar.f2571e);
                            hVar2.b0(aVar);
                            this.t.d(hVar2);
                            this.v.put(bdUniqueId, hVar2);
                        }
                    }
                    if (aVar.x() != null) {
                        bdUniqueId = aVar.x();
                        if (!this.v.containsKey(bdUniqueId)) {
                            h hVar3 = new h(aVar.a, bdUniqueId, aVar.f2571e);
                            hVar3.b0(aVar);
                            this.t.d(hVar3);
                            this.v.put(bdUniqueId, hVar3);
                        }
                    }
                    if (aVar.v() != null) {
                        bdUniqueId = aVar.v();
                        if (!this.v.containsKey(bdUniqueId)) {
                            h hVar4 = new h(aVar.a, bdUniqueId, aVar.f2571e);
                            hVar4.b0(aVar);
                            this.t.d(hVar4);
                            this.v.put(bdUniqueId, hVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.t.d(aVar);
                    } else {
                        this.u.put(aVar.f2570d, aVar);
                    }
                }
            }
            setAdapter(this.t);
        }
    }

    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.t.getCount() : invokeV.intValue;
    }

    @Override // c.a.d.o.e.s
    public List<n> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.t.e() : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeRecyclerView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdRecyclerView, c.a.d.o.e.p
    /* renamed from: getListView */
    public BdRecyclerView getListView2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this : (BdTypeRecyclerView) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, parcelable) == null) {
            super.onRestoreInstanceState(parcelable);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? super.onSaveInstanceState() : (Parcelable) invokeV.objValue;
    }

    @Override // c.a.d.o.e.s
    public void setData(List<? extends n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (n nVar : list) {
                if (nVar != null) {
                    if (this.u.containsKey(nVar.getType())) {
                        c.a.d.o.e.a aVar = this.u.get(nVar.getType());
                        if (aVar.y() != null) {
                            g gVar = new g();
                            gVar.i(aVar.y());
                            if (nVar instanceof BaseCardInfo) {
                                gVar.position = ((BaseCardInfo) nVar).position;
                                gVar.setSupportType(BaseCardInfo.SupportType.TOP);
                            }
                            gVar.g(nVar);
                            arrayList.add(gVar);
                        }
                        if (aVar.w() != null) {
                            g gVar2 = new g();
                            gVar2.i(aVar.w());
                            if (nVar instanceof BaseCardInfo) {
                                gVar2.position = ((BaseCardInfo) nVar).position;
                                gVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            }
                            gVar2.g(nVar);
                            arrayList.add(gVar2);
                        }
                        if (aVar.x() != null) {
                            g gVar3 = new g();
                            gVar3.i(aVar.x());
                            if (nVar instanceof BaseCardInfo) {
                                gVar3.position = ((BaseCardInfo) nVar).position;
                                gVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            }
                            gVar3.g(nVar);
                            arrayList.add(gVar3);
                        }
                        if (aVar.v() != null) {
                            g gVar4 = new g();
                            gVar4.i(aVar.v());
                            if (nVar instanceof BaseCardInfo) {
                                gVar4.position = ((BaseCardInfo) nVar).position;
                                gVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                            }
                            gVar4.g(nVar);
                            arrayList.add(gVar4);
                        }
                    } else {
                        arrayList.add(nVar);
                    }
                }
            }
            this.t.setData(arrayList);
        }
    }

    public void setDataWithPartChange(List<n> list, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048589, this, list, i, i2) == null) {
            this.t.m(list, i, i2);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdRecyclerView
    @Deprecated
    public void setOnItemClickListener(BdRecyclerView.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, iVar) == null) {
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdRecyclerView
    public void setOnItemLongClickListener(BdRecyclerView.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jVar) == null) {
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
