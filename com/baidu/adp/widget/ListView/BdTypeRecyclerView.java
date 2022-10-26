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
import com.baidu.tieba.eo;
import com.baidu.tieba.ho;
import com.baidu.tieba.ko;
import com.baidu.tieba.rn;
import com.baidu.tieba.xn;
import com.baidu.tieba.yn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeRecyclerView extends BdRecyclerView implements ko<BdTypeRecyclerView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerViewTypeAdapter t;
    public HashMap<BdUniqueId, rn> u;
    public HashMap<BdUniqueId, yn> v;
    public boolean w;
    public boolean x;
    public ho y;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.BdRecyclerView, com.baidu.tieba.go
    public BdTypeRecyclerView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this : (BdTypeRecyclerView) invokeV.objValue;
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
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) && (recyclerViewTypeAdapter = this.a.t) != null) {
                recyclerViewTypeAdapter.h(viewGroup, view2, i, j);
            }
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
                    return recyclerViewTypeAdapter.i(viewGroup, view2, i, j);
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
        C();
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
        C();
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
        C();
    }

    public eo B(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return this.t.getItem(i);
        }
        return (eo) invokeI.objValue;
    }

    public void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.t.j(i, getHeaderViewsCount());
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdRecyclerView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.w && !this.x) {
                this.x = true;
                ho hoVar = this.y;
                if (hoVar != null) {
                    hoVar.a();
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, parcelable) == null) {
            super.onRestoreInstanceState(parcelable);
        }
    }

    public final void C() {
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

    public void E(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            this.t.k(i, i2, getHeaderViewsCount());
        }
    }

    @Override // com.baidu.tieba.ko
    public void a(List<rn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            for (rn<eo, TypeAdapter.ViewHolder> rnVar : list) {
                if (rnVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (rnVar.getHeaderId() != null) {
                        bdUniqueId = rnVar.getHeaderId();
                        if (!this.v.containsKey(bdUniqueId)) {
                            yn ynVar = new yn(rnVar.mContext, bdUniqueId, rnVar.mPageId);
                            ynVar.u(rnVar);
                            this.t.d(ynVar);
                            this.v.put(bdUniqueId, ynVar);
                        }
                    }
                    if (rnVar.getContentId() != null) {
                        bdUniqueId = rnVar.getContentId();
                        if (!this.v.containsKey(bdUniqueId)) {
                            yn ynVar2 = new yn(rnVar.mContext, bdUniqueId, rnVar.mPageId);
                            ynVar2.u(rnVar);
                            this.t.d(ynVar2);
                            this.v.put(bdUniqueId, ynVar2);
                        }
                    }
                    if (rnVar.getExtendId() != null) {
                        bdUniqueId = rnVar.getExtendId();
                        if (!this.v.containsKey(bdUniqueId)) {
                            yn ynVar3 = new yn(rnVar.mContext, bdUniqueId, rnVar.mPageId);
                            ynVar3.u(rnVar);
                            this.t.d(ynVar3);
                            this.v.put(bdUniqueId, ynVar3);
                        }
                    }
                    if (rnVar.getBottomId() != null) {
                        bdUniqueId = rnVar.getBottomId();
                        if (!this.v.containsKey(bdUniqueId)) {
                            yn ynVar4 = new yn(rnVar.mContext, bdUniqueId, rnVar.mPageId);
                            ynVar4.u(rnVar);
                            this.t.d(ynVar4);
                            this.v.put(bdUniqueId, ynVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.t.d(rnVar);
                    } else {
                        this.u.put(rnVar.mType, rnVar);
                    }
                }
            }
            setAdapter(this.t);
        }
    }

    @Override // com.baidu.tieba.ko
    public void setData(List<? extends eo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (eo eoVar : list) {
                if (eoVar != null) {
                    if (this.u.containsKey(eoVar.getType())) {
                        rn rnVar = this.u.get(eoVar.getType());
                        if (rnVar.getHeaderId() != null) {
                            xn xnVar = new xn();
                            xnVar.h(rnVar.getHeaderId());
                            if (eoVar instanceof BaseCardInfo) {
                                xnVar.position = ((BaseCardInfo) eoVar).position;
                                xnVar.setSupportType(BaseCardInfo.SupportType.TOP);
                            }
                            xnVar.f(eoVar);
                            arrayList.add(xnVar);
                        }
                        if (rnVar.getContentId() != null) {
                            xn xnVar2 = new xn();
                            xnVar2.h(rnVar.getContentId());
                            if (eoVar instanceof BaseCardInfo) {
                                xnVar2.position = ((BaseCardInfo) eoVar).position;
                                xnVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            }
                            xnVar2.f(eoVar);
                            arrayList.add(xnVar2);
                        }
                        if (rnVar.getExtendId() != null) {
                            xn xnVar3 = new xn();
                            xnVar3.h(rnVar.getExtendId());
                            if (eoVar instanceof BaseCardInfo) {
                                xnVar3.position = ((BaseCardInfo) eoVar).position;
                                xnVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            }
                            xnVar3.f(eoVar);
                            arrayList.add(xnVar3);
                        }
                        if (rnVar.getBottomId() != null) {
                            xn xnVar4 = new xn();
                            xnVar4.h(rnVar.getBottomId());
                            if (eoVar instanceof BaseCardInfo) {
                                xnVar4.position = ((BaseCardInfo) eoVar).position;
                                xnVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                            }
                            xnVar4.f(eoVar);
                            arrayList.add(xnVar4);
                        }
                    } else {
                        arrayList.add(eoVar);
                    }
                }
            }
            this.t.setData(arrayList);
        }
    }

    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.t.getCount();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ko
    public List<eo> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.t.getData();
        }
        return (List) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return super.onSaveInstanceState();
        }
        return (Parcelable) invokeV.objValue;
    }
}
