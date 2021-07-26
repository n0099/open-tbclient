package com.baidu.adp.widget.ListView;

import android.content.Context;
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
import d.a.d.k.e.g;
import d.a.d.k.e.h;
import d.a.d.k.e.n;
import d.a.d.k.e.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeRecyclerView extends BdRecyclerView implements s<BdTypeRecyclerView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerViewTypeAdapter x;
    public HashMap<BdUniqueId, d.a.d.k.e.a> y;
    public HashMap<BdUniqueId, h> z;

    /* loaded from: classes.dex */
    public class a implements BdRecyclerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdTypeRecyclerView f2414e;

        public a(BdTypeRecyclerView bdTypeRecyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTypeRecyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2414e = bdTypeRecyclerView;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view, Object obj, int i2, long j) {
            RecyclerViewTypeAdapter recyclerViewTypeAdapter;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i2), Long.valueOf(j)}) == null) || (recyclerViewTypeAdapter = this.f2414e.x) == null) {
                return;
            }
            recyclerViewTypeAdapter.i(viewGroup, view, i2, j);
        }
    }

    /* loaded from: classes.dex */
    public class b implements BdRecyclerView.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BdTypeRecyclerView f2415a;

        public b(BdTypeRecyclerView bdTypeRecyclerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTypeRecyclerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2415a = bdTypeRecyclerView;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.j
        public boolean a(ViewGroup viewGroup, View view, Object obj, int i2, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
                RecyclerViewTypeAdapter recyclerViewTypeAdapter = this.f2415a.x;
                if (recyclerViewTypeAdapter != null) {
                    return recyclerViewTypeAdapter.j(viewGroup, view, i2, j);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = null;
        C();
    }

    public n B(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.x.getItem(i2) : (n) invokeI.objValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.x == null) {
                this.x = new RecyclerViewTypeAdapter();
            }
            if (this.y == null) {
                this.y = new HashMap<>();
            }
            if (this.z == null) {
                this.z = new HashMap<>();
            }
            super.setOnItemClickListener(new a(this));
            super.setOnItemLongClickListener(new b(this));
        }
    }

    public void D(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.x.k(i2, getHeaderViewsCount());
        }
    }

    public void E(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            this.x.l(i2, i3, getHeaderViewsCount());
        }
    }

    @Override // d.a.d.k.e.s
    public void a(List<d.a.d.k.e.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            for (d.a.d.k.e.a<n, TypeAdapter.ViewHolder> aVar : list) {
                if (aVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (aVar.y() != null) {
                        bdUniqueId = aVar.y();
                        if (!this.z.containsKey(bdUniqueId)) {
                            h hVar = new h(aVar.f42341e, bdUniqueId, aVar.f42345i);
                            hVar.g0(aVar);
                            this.x.d(hVar);
                            this.z.put(bdUniqueId, hVar);
                        }
                    }
                    if (aVar.w() != null) {
                        bdUniqueId = aVar.w();
                        if (!this.z.containsKey(bdUniqueId)) {
                            h hVar2 = new h(aVar.f42341e, bdUniqueId, aVar.f42345i);
                            hVar2.g0(aVar);
                            this.x.d(hVar2);
                            this.z.put(bdUniqueId, hVar2);
                        }
                    }
                    if (aVar.x() != null) {
                        bdUniqueId = aVar.x();
                        if (!this.z.containsKey(bdUniqueId)) {
                            h hVar3 = new h(aVar.f42341e, bdUniqueId, aVar.f42345i);
                            hVar3.g0(aVar);
                            this.x.d(hVar3);
                            this.z.put(bdUniqueId, hVar3);
                        }
                    }
                    if (aVar.v() != null) {
                        bdUniqueId = aVar.v();
                        if (!this.z.containsKey(bdUniqueId)) {
                            h hVar4 = new h(aVar.f42341e, bdUniqueId, aVar.f42345i);
                            hVar4.g0(aVar);
                            this.x.d(hVar4);
                            this.z.put(bdUniqueId, hVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.x.d(aVar);
                    } else {
                        this.y.put(aVar.f42344h, aVar);
                    }
                }
            }
            setAdapter(this.x);
        }
    }

    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.x.getCount() : invokeV.intValue;
    }

    @Override // d.a.d.k.e.s
    public List<n> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.x.e() : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeRecyclerView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdRecyclerView, d.a.d.k.e.p
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

    @Override // d.a.d.k.e.s
    public void setData(List<? extends n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (n nVar : list) {
                if (nVar != null) {
                    if (this.y.containsKey(nVar.getType())) {
                        d.a.d.k.e.a aVar = this.y.get(nVar.getType());
                        if (aVar.y() != null) {
                            g gVar = new g();
                            gVar.e(aVar.y());
                            if (nVar instanceof BaseCardInfo) {
                                gVar.position = ((BaseCardInfo) nVar).position;
                                gVar.setSupportType(BaseCardInfo.SupportType.TOP);
                            }
                            gVar.d(nVar);
                            arrayList.add(gVar);
                        }
                        if (aVar.w() != null) {
                            g gVar2 = new g();
                            gVar2.e(aVar.w());
                            if (nVar instanceof BaseCardInfo) {
                                gVar2.position = ((BaseCardInfo) nVar).position;
                                gVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            }
                            gVar2.d(nVar);
                            arrayList.add(gVar2);
                        }
                        if (aVar.x() != null) {
                            g gVar3 = new g();
                            gVar3.e(aVar.x());
                            if (nVar instanceof BaseCardInfo) {
                                gVar3.position = ((BaseCardInfo) nVar).position;
                                gVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            }
                            gVar3.d(nVar);
                            arrayList.add(gVar3);
                        }
                        if (aVar.v() != null) {
                            g gVar4 = new g();
                            gVar4.e(aVar.v());
                            if (nVar instanceof BaseCardInfo) {
                                gVar4.position = ((BaseCardInfo) nVar).position;
                                gVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                            }
                            gVar4.d(nVar);
                            arrayList.add(gVar4);
                        }
                    } else {
                        arrayList.add(nVar);
                    }
                }
            }
            this.x.setData(arrayList);
        }
    }

    public void setDataWithPartChange(List<n> list, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048589, this, list, i2, i3) == null) {
            this.x.m(list, i2, i3);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.x = null;
        C();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdTypeRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.x = null;
        C();
    }
}
