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
import com.baidu.tieba.Cdo;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.go;
import com.baidu.tieba.jo;
import com.baidu.tieba.qn;
import com.baidu.tieba.wn;
import com.baidu.tieba.xn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeRecyclerView extends BdRecyclerView implements jo<BdTypeRecyclerView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerViewTypeAdapter t;
    public HashMap<BdUniqueId, qn> u;
    public HashMap<BdUniqueId, xn> v;
    public boolean w;
    public boolean x;
    public go y;

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
            recyclerViewTypeAdapter.h(viewGroup, view2, i, j);
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

    public Cdo B(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.t.getItem(i) : (Cdo) invokeI.objValue;
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

    public void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.t.j(i, getHeaderViewsCount());
        }
    }

    public void E(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            this.t.k(i, i2, getHeaderViewsCount());
        }
    }

    @Override // com.baidu.tieba.jo
    public void a(List<qn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            for (qn<Cdo, TypeAdapter.ViewHolder> qnVar : list) {
                if (qnVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (qnVar.getHeaderId() != null) {
                        bdUniqueId = qnVar.getHeaderId();
                        if (!this.v.containsKey(bdUniqueId)) {
                            xn xnVar = new xn(qnVar.mContext, bdUniqueId, qnVar.mPageId);
                            xnVar.u(qnVar);
                            this.t.d(xnVar);
                            this.v.put(bdUniqueId, xnVar);
                        }
                    }
                    if (qnVar.getContentId() != null) {
                        bdUniqueId = qnVar.getContentId();
                        if (!this.v.containsKey(bdUniqueId)) {
                            xn xnVar2 = new xn(qnVar.mContext, bdUniqueId, qnVar.mPageId);
                            xnVar2.u(qnVar);
                            this.t.d(xnVar2);
                            this.v.put(bdUniqueId, xnVar2);
                        }
                    }
                    if (qnVar.getExtendId() != null) {
                        bdUniqueId = qnVar.getExtendId();
                        if (!this.v.containsKey(bdUniqueId)) {
                            xn xnVar3 = new xn(qnVar.mContext, bdUniqueId, qnVar.mPageId);
                            xnVar3.u(qnVar);
                            this.t.d(xnVar3);
                            this.v.put(bdUniqueId, xnVar3);
                        }
                    }
                    if (qnVar.getBottomId() != null) {
                        bdUniqueId = qnVar.getBottomId();
                        if (!this.v.containsKey(bdUniqueId)) {
                            xn xnVar4 = new xn(qnVar.mContext, bdUniqueId, qnVar.mPageId);
                            xnVar4.u(qnVar);
                            this.t.d(xnVar4);
                            this.v.put(bdUniqueId, xnVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.t.d(qnVar);
                    } else {
                        this.u.put(qnVar.mType, qnVar);
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
            go goVar = this.y;
            if (goVar != null) {
                goVar.a();
            }
        }
    }

    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.t.getCount() : invokeV.intValue;
    }

    @Override // com.baidu.tieba.jo
    public List<Cdo> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.t.getData() : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeRecyclerView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdRecyclerView, com.baidu.tieba.fo
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

    @Override // com.baidu.tieba.jo
    public void setData(List<? extends Cdo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (Cdo cdo : list) {
                if (cdo != null) {
                    if (this.u.containsKey(cdo.getType())) {
                        qn qnVar = this.u.get(cdo.getType());
                        if (qnVar.getHeaderId() != null) {
                            wn wnVar = new wn();
                            wnVar.h(qnVar.getHeaderId());
                            if (cdo instanceof BaseCardInfo) {
                                wnVar.position = ((BaseCardInfo) cdo).position;
                                wnVar.setSupportType(BaseCardInfo.SupportType.TOP);
                            }
                            wnVar.f(cdo);
                            arrayList.add(wnVar);
                        }
                        if (qnVar.getContentId() != null) {
                            wn wnVar2 = new wn();
                            wnVar2.h(qnVar.getContentId());
                            if (cdo instanceof BaseCardInfo) {
                                wnVar2.position = ((BaseCardInfo) cdo).position;
                                wnVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            }
                            wnVar2.f(cdo);
                            arrayList.add(wnVar2);
                        }
                        if (qnVar.getExtendId() != null) {
                            wn wnVar3 = new wn();
                            wnVar3.h(qnVar.getExtendId());
                            if (cdo instanceof BaseCardInfo) {
                                wnVar3.position = ((BaseCardInfo) cdo).position;
                                wnVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            }
                            wnVar3.f(cdo);
                            arrayList.add(wnVar3);
                        }
                        if (qnVar.getBottomId() != null) {
                            wn wnVar4 = new wn();
                            wnVar4.h(qnVar.getBottomId());
                            if (cdo instanceof BaseCardInfo) {
                                wnVar4.position = ((BaseCardInfo) cdo).position;
                                wnVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                            }
                            wnVar4.f(cdo);
                            arrayList.add(wnVar4);
                        }
                    } else {
                        arrayList.add(cdo);
                    }
                }
            }
            this.t.setData(arrayList);
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
}
