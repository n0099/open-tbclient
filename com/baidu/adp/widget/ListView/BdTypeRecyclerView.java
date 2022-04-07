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
import com.repackage.ho;
import com.repackage.no;
import com.repackage.oo;
import com.repackage.uo;
import com.repackage.zo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeRecyclerView extends BdRecyclerView implements zo<BdTypeRecyclerView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerViewTypeAdapter t;
    public HashMap<BdUniqueId, ho> u;
    public HashMap<BdUniqueId, oo> v;

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

    public uo C(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.t.getItem(i) : (uo) invokeI.objValue;
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

    @Override // com.repackage.zo
    public void a(List<ho> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            for (ho<uo, TypeAdapter.ViewHolder> hoVar : list) {
                if (hoVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (hoVar.y() != null) {
                        bdUniqueId = hoVar.y();
                        if (!this.v.containsKey(bdUniqueId)) {
                            oo ooVar = new oo(hoVar.a, bdUniqueId, hoVar.e);
                            ooVar.b0(hoVar);
                            this.t.d(ooVar);
                            this.v.put(bdUniqueId, ooVar);
                        }
                    }
                    if (hoVar.w() != null) {
                        bdUniqueId = hoVar.w();
                        if (!this.v.containsKey(bdUniqueId)) {
                            oo ooVar2 = new oo(hoVar.a, bdUniqueId, hoVar.e);
                            ooVar2.b0(hoVar);
                            this.t.d(ooVar2);
                            this.v.put(bdUniqueId, ooVar2);
                        }
                    }
                    if (hoVar.x() != null) {
                        bdUniqueId = hoVar.x();
                        if (!this.v.containsKey(bdUniqueId)) {
                            oo ooVar3 = new oo(hoVar.a, bdUniqueId, hoVar.e);
                            ooVar3.b0(hoVar);
                            this.t.d(ooVar3);
                            this.v.put(bdUniqueId, ooVar3);
                        }
                    }
                    if (hoVar.v() != null) {
                        bdUniqueId = hoVar.v();
                        if (!this.v.containsKey(bdUniqueId)) {
                            oo ooVar4 = new oo(hoVar.a, bdUniqueId, hoVar.e);
                            ooVar4.b0(hoVar);
                            this.t.d(ooVar4);
                            this.v.put(bdUniqueId, ooVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.t.d(hoVar);
                    } else {
                        this.u.put(hoVar.d, hoVar);
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

    @Override // com.repackage.zo
    public List<uo> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.t.e() : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeRecyclerView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdRecyclerView, com.repackage.wo
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

    @Override // com.repackage.zo
    public void setData(List<? extends uo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (uo uoVar : list) {
                if (uoVar != null) {
                    if (this.u.containsKey(uoVar.getType())) {
                        ho hoVar = this.u.get(uoVar.getType());
                        if (hoVar.y() != null) {
                            no noVar = new no();
                            noVar.i(hoVar.y());
                            if (uoVar instanceof BaseCardInfo) {
                                noVar.position = ((BaseCardInfo) uoVar).position;
                                noVar.setSupportType(BaseCardInfo.SupportType.TOP);
                            }
                            noVar.g(uoVar);
                            arrayList.add(noVar);
                        }
                        if (hoVar.w() != null) {
                            no noVar2 = new no();
                            noVar2.i(hoVar.w());
                            if (uoVar instanceof BaseCardInfo) {
                                noVar2.position = ((BaseCardInfo) uoVar).position;
                                noVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            }
                            noVar2.g(uoVar);
                            arrayList.add(noVar2);
                        }
                        if (hoVar.x() != null) {
                            no noVar3 = new no();
                            noVar3.i(hoVar.x());
                            if (uoVar instanceof BaseCardInfo) {
                                noVar3.position = ((BaseCardInfo) uoVar).position;
                                noVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            }
                            noVar3.g(uoVar);
                            arrayList.add(noVar3);
                        }
                        if (hoVar.v() != null) {
                            no noVar4 = new no();
                            noVar4.i(hoVar.v());
                            if (uoVar instanceof BaseCardInfo) {
                                noVar4.position = ((BaseCardInfo) uoVar).position;
                                noVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                            }
                            noVar4.g(uoVar);
                            arrayList.add(noVar4);
                        }
                    } else {
                        arrayList.add(uoVar);
                    }
                }
            }
            this.t.setData(arrayList);
        }
    }

    public void setDataWithPartChange(List<uo> list, int i, int i2) {
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
