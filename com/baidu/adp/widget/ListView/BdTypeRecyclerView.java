package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.g;
import c.a.e.l.e.h;
import c.a.e.l.e.n;
import c.a.e.l.e.s;
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
/* loaded from: classes4.dex */
public class BdTypeRecyclerView extends BdRecyclerView implements s<BdTypeRecyclerView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerViewTypeAdapter x;
    public HashMap<BdUniqueId, c.a.e.l.e.a> y;
    public HashMap<BdUniqueId, h> z;

    /* loaded from: classes4.dex */
    public class a implements BdRecyclerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdTypeRecyclerView f36548e;

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
            this.f36548e = bdTypeRecyclerView;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view, Object obj, int i2, long j2) {
            RecyclerViewTypeAdapter recyclerViewTypeAdapter;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (recyclerViewTypeAdapter = this.f36548e.x) == null) {
                return;
            }
            recyclerViewTypeAdapter.onItemClick(viewGroup, view, i2, j2);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements BdRecyclerView.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BdTypeRecyclerView f36549a;

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
            this.f36549a = bdTypeRecyclerView;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.j
        public boolean a(ViewGroup viewGroup, View view, Object obj, int i2, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view, obj, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
                RecyclerViewTypeAdapter recyclerViewTypeAdapter = this.f36549a.x;
                if (recyclerViewTypeAdapter != null) {
                    return recyclerViewTypeAdapter.onItemLongClick(viewGroup, view, i2, j2);
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
        t();
    }

    @Override // c.a.e.l.e.s
    public void addAdapters(List<c.a.e.l.e.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            for (c.a.e.l.e.a<n, TypeAdapter.ViewHolder> aVar : list) {
                if (aVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (aVar.y() != null) {
                        bdUniqueId = aVar.y();
                        if (!this.z.containsKey(bdUniqueId)) {
                            h hVar = new h(aVar.f2958e, bdUniqueId, aVar.f2962i);
                            hVar.j0(aVar);
                            this.x.addAdapter(hVar);
                            this.z.put(bdUniqueId, hVar);
                        }
                    }
                    if (aVar.w() != null) {
                        bdUniqueId = aVar.w();
                        if (!this.z.containsKey(bdUniqueId)) {
                            h hVar2 = new h(aVar.f2958e, bdUniqueId, aVar.f2962i);
                            hVar2.j0(aVar);
                            this.x.addAdapter(hVar2);
                            this.z.put(bdUniqueId, hVar2);
                        }
                    }
                    if (aVar.x() != null) {
                        bdUniqueId = aVar.x();
                        if (!this.z.containsKey(bdUniqueId)) {
                            h hVar3 = new h(aVar.f2958e, bdUniqueId, aVar.f2962i);
                            hVar3.j0(aVar);
                            this.x.addAdapter(hVar3);
                            this.z.put(bdUniqueId, hVar3);
                        }
                    }
                    if (aVar.v() != null) {
                        bdUniqueId = aVar.v();
                        if (!this.z.containsKey(bdUniqueId)) {
                            h hVar4 = new h(aVar.f2958e, bdUniqueId, aVar.f2962i);
                            hVar4.j0(aVar);
                            this.x.addAdapter(hVar4);
                            this.z.put(bdUniqueId, hVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.x.addAdapter(aVar);
                    } else {
                        this.y.put(aVar.f2961h, aVar);
                    }
                }
            }
            setAdapter(this.x);
        }
    }

    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.x.getCount() : invokeV.intValue;
    }

    @Override // c.a.e.l.e.s
    public List<n> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.x.getData() : (List) invokeV.objValue;
    }

    public n getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.x.getItem(i2) : (n) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeRecyclerView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdRecyclerView, c.a.e.l.e.p
    /* renamed from: getListView */
    public BdRecyclerView getListView2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (BdTypeRecyclerView) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, parcelable) == null) {
            super.onRestoreInstanceState(parcelable);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? super.onSaveInstanceState() : (Parcelable) invokeV.objValue;
    }

    public void removeItem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.x.removeItem(i2, getHeaderViewsCount());
        }
    }

    public void removeItemList(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
            this.x.removeItemList(i2, i3, getHeaderViewsCount());
        }
    }

    @Override // c.a.e.l.e.s
    public void setData(List<? extends n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (n nVar : list) {
                if (nVar != null) {
                    if (this.y.containsKey(nVar.getType())) {
                        c.a.e.l.e.a aVar = this.y.get(nVar.getType());
                        if (aVar.y() != null) {
                            g gVar = new g();
                            gVar.k(aVar.y());
                            if (nVar instanceof BaseCardInfo) {
                                gVar.position = ((BaseCardInfo) nVar).position;
                                gVar.setSupportType(BaseCardInfo.SupportType.TOP);
                            }
                            gVar.i(nVar);
                            arrayList.add(gVar);
                        }
                        if (aVar.w() != null) {
                            g gVar2 = new g();
                            gVar2.k(aVar.w());
                            if (nVar instanceof BaseCardInfo) {
                                gVar2.position = ((BaseCardInfo) nVar).position;
                                gVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            }
                            gVar2.i(nVar);
                            arrayList.add(gVar2);
                        }
                        if (aVar.x() != null) {
                            g gVar3 = new g();
                            gVar3.k(aVar.x());
                            if (nVar instanceof BaseCardInfo) {
                                gVar3.position = ((BaseCardInfo) nVar).position;
                                gVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            }
                            gVar3.i(nVar);
                            arrayList.add(gVar3);
                        }
                        if (aVar.v() != null) {
                            g gVar4 = new g();
                            gVar4.k(aVar.v());
                            if (nVar instanceof BaseCardInfo) {
                                gVar4.position = ((BaseCardInfo) nVar).position;
                                gVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                            }
                            gVar4.i(nVar);
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
        if (interceptable == null || interceptable.invokeLII(1048588, this, list, i2, i3) == null) {
            this.x.setDataWithPartChanged(list, i2, i3);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdRecyclerView
    @Deprecated
    public void setOnItemClickListener(BdRecyclerView.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iVar) == null) {
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdRecyclerView
    public void setOnItemLongClickListener(BdRecyclerView.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jVar) == null) {
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
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
        t();
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
        t();
    }
}
