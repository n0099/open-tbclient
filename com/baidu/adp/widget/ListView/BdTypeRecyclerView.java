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
import com.repackage.eo;
import com.repackage.ko;
import com.repackage.lo;
import com.repackage.ro;
import com.repackage.uo;
import com.repackage.xo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeRecyclerView extends BdRecyclerView implements xo<BdTypeRecyclerView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerViewTypeAdapter t;
    public HashMap<BdUniqueId, eo> u;
    public HashMap<BdUniqueId, lo> v;
    public boolean w;
    public boolean x;
    public uo y;

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

    public ro C(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.t.getItem(i) : (ro) invokeI.objValue;
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

    @Override // com.repackage.xo
    public void a(List<eo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            for (eo<ro, TypeAdapter.ViewHolder> eoVar : list) {
                if (eoVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (eoVar.y() != null) {
                        bdUniqueId = eoVar.y();
                        if (!this.v.containsKey(bdUniqueId)) {
                            lo loVar = new lo(eoVar.a, bdUniqueId, eoVar.e);
                            loVar.b0(eoVar);
                            this.t.d(loVar);
                            this.v.put(bdUniqueId, loVar);
                        }
                    }
                    if (eoVar.w() != null) {
                        bdUniqueId = eoVar.w();
                        if (!this.v.containsKey(bdUniqueId)) {
                            lo loVar2 = new lo(eoVar.a, bdUniqueId, eoVar.e);
                            loVar2.b0(eoVar);
                            this.t.d(loVar2);
                            this.v.put(bdUniqueId, loVar2);
                        }
                    }
                    if (eoVar.x() != null) {
                        bdUniqueId = eoVar.x();
                        if (!this.v.containsKey(bdUniqueId)) {
                            lo loVar3 = new lo(eoVar.a, bdUniqueId, eoVar.e);
                            loVar3.b0(eoVar);
                            this.t.d(loVar3);
                            this.v.put(bdUniqueId, loVar3);
                        }
                    }
                    if (eoVar.v() != null) {
                        bdUniqueId = eoVar.v();
                        if (!this.v.containsKey(bdUniqueId)) {
                            lo loVar4 = new lo(eoVar.a, bdUniqueId, eoVar.e);
                            loVar4.b0(eoVar);
                            this.t.d(loVar4);
                            this.v.put(bdUniqueId, loVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.t.d(eoVar);
                    } else {
                        this.u.put(eoVar.d, eoVar);
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
            uo uoVar = this.y;
            if (uoVar != null) {
                uoVar.a();
            }
        }
    }

    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.t.getCount() : invokeV.intValue;
    }

    @Override // com.repackage.xo
    public List<ro> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.t.e() : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeRecyclerView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdRecyclerView, com.repackage.to
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

    @Override // com.repackage.xo
    public void setData(List<? extends ro> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (ro roVar : list) {
                if (roVar != null) {
                    if (this.u.containsKey(roVar.getType())) {
                        eo eoVar = this.u.get(roVar.getType());
                        if (eoVar.y() != null) {
                            ko koVar = new ko();
                            koVar.i(eoVar.y());
                            if (roVar instanceof BaseCardInfo) {
                                koVar.position = ((BaseCardInfo) roVar).position;
                                koVar.setSupportType(BaseCardInfo.SupportType.TOP);
                            }
                            koVar.g(roVar);
                            arrayList.add(koVar);
                        }
                        if (eoVar.w() != null) {
                            ko koVar2 = new ko();
                            koVar2.i(eoVar.w());
                            if (roVar instanceof BaseCardInfo) {
                                koVar2.position = ((BaseCardInfo) roVar).position;
                                koVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            }
                            koVar2.g(roVar);
                            arrayList.add(koVar2);
                        }
                        if (eoVar.x() != null) {
                            ko koVar3 = new ko();
                            koVar3.i(eoVar.x());
                            if (roVar instanceof BaseCardInfo) {
                                koVar3.position = ((BaseCardInfo) roVar).position;
                                koVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            }
                            koVar3.g(roVar);
                            arrayList.add(koVar3);
                        }
                        if (eoVar.v() != null) {
                            ko koVar4 = new ko();
                            koVar4.i(eoVar.v());
                            if (roVar instanceof BaseCardInfo) {
                                koVar4.position = ((BaseCardInfo) roVar).position;
                                koVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                            }
                            koVar4.g(roVar);
                            arrayList.add(koVar4);
                        }
                    } else {
                        arrayList.add(roVar);
                    }
                }
            }
            this.t.setData(arrayList);
        }
    }

    public void setDataWithPartChange(List<ro> list, int i, int i2) {
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
