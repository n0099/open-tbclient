package com.baidu.adp.widget.ListView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DiffUtil;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.Cdo;
import com.baidu.tieba.ao;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.kn;
import com.baidu.tieba.qn;
import com.baidu.tieba.rn;
import com.baidu.tieba.xn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeRecyclerView extends BdRecyclerView implements Cdo<BdTypeRecyclerView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerViewTypeAdapter t;
    public HashMap<BdUniqueId, kn> u;
    public HashMap<BdUniqueId, rn> v;
    public boolean w;
    public boolean x;
    public ao y;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeRecyclerView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdRecyclerView, com.baidu.tieba.zn
    /* renamed from: getListView */
    public BdRecyclerView getListView2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this : (BdTypeRecyclerView) invokeV.objValue;
    }

    @Override // com.baidu.adp.widget.ListView.BdRecyclerView
    @Deprecated
    public void setOnItemClickListener(BdRecyclerView.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, iVar) == null) {
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdRecyclerView
    public void setOnItemLongClickListener(BdRecyclerView.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, jVar) == null) {
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
                recyclerViewTypeAdapter.i(viewGroup, view2, i, j);
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
                    return recyclerViewTypeAdapter.j(viewGroup, view2, i, j);
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class c<T extends xn> extends DiffUtil.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<T> a;
        public final List<T> b;
        public final DiffUtil.ItemCallback<T> c;

        public c(@NonNull List<T> list, @NonNull List<T> list2, @NonNull DiffUtil.ItemCallback<T> itemCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list, list2, itemCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
            this.b = list2;
            this.c = itemCallback;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
                T t = this.a.get(i);
                T t2 = this.b.get(i2);
                if (t != null && t2 != null) {
                    return this.c.areContentsTheSame(t, t2);
                }
                if (t == null && t2 == null) {
                    return true;
                }
                throw new AssertionError();
            }
            return invokeII.booleanValue;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
                T t = this.a.get(i);
                T t2 = this.b.get(i2);
                if (t != null && t2 != null) {
                    return this.c.areItemsTheSame(t, t2);
                }
                if (t == null && t2 == null) {
                    return true;
                }
                return false;
            }
            return invokeII.booleanValue;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.b.size();
            }
            return invokeV.intValue;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a.size();
            }
            return invokeV.intValue;
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
        F();
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
        F();
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
        F();
    }

    public final List<xn> D(@NonNull Collection<? extends xn> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, collection)) == null) {
            ArrayList arrayList = new ArrayList();
            for (xn xnVar : collection) {
                if (xnVar != null) {
                    if (this.u.containsKey(xnVar.getType())) {
                        kn knVar = this.u.get(xnVar.getType());
                        if (knVar.getHeaderId() != null) {
                            qn qnVar = new qn();
                            qnVar.g(knVar.getHeaderId());
                            if (xnVar instanceof BaseCardInfo) {
                                qnVar.position = ((BaseCardInfo) xnVar).position;
                                qnVar.setSupportType(BaseCardInfo.SupportType.TOP);
                            }
                            qnVar.f(xnVar);
                            arrayList.add(qnVar);
                        }
                        if (knVar.getContentId() != null) {
                            qn qnVar2 = new qn();
                            qnVar2.g(knVar.getContentId());
                            if (xnVar instanceof BaseCardInfo) {
                                qnVar2.position = ((BaseCardInfo) xnVar).position;
                                qnVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            }
                            qnVar2.f(xnVar);
                            arrayList.add(qnVar2);
                        }
                        if (knVar.getExtendId() != null) {
                            qn qnVar3 = new qn();
                            qnVar3.g(knVar.getExtendId());
                            if (xnVar instanceof BaseCardInfo) {
                                qnVar3.position = ((BaseCardInfo) xnVar).position;
                                qnVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            }
                            qnVar3.f(xnVar);
                            arrayList.add(qnVar3);
                        }
                        if (knVar.getBottomId() != null) {
                            qn qnVar4 = new qn();
                            qnVar4.g(knVar.getBottomId());
                            if (xnVar instanceof BaseCardInfo) {
                                qnVar4.position = ((BaseCardInfo) xnVar).position;
                                qnVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                            }
                            qnVar4.f(xnVar);
                            arrayList.add(qnVar4);
                        }
                    } else {
                        arrayList.add(xnVar);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.baidu.tieba.Cdo
    public void a(List<kn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            for (kn<xn, TypeAdapter.ViewHolder> knVar : list) {
                if (knVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (knVar.getHeaderId() != null) {
                        bdUniqueId = knVar.getHeaderId();
                        if (!this.v.containsKey(bdUniqueId)) {
                            rn rnVar = new rn(knVar.mContext, bdUniqueId, knVar.mPageId);
                            rnVar.u(knVar);
                            this.t.d(rnVar);
                            this.v.put(bdUniqueId, rnVar);
                        }
                    }
                    if (knVar.getContentId() != null) {
                        bdUniqueId = knVar.getContentId();
                        if (!this.v.containsKey(bdUniqueId)) {
                            rn rnVar2 = new rn(knVar.mContext, bdUniqueId, knVar.mPageId);
                            rnVar2.u(knVar);
                            this.t.d(rnVar2);
                            this.v.put(bdUniqueId, rnVar2);
                        }
                    }
                    if (knVar.getExtendId() != null) {
                        bdUniqueId = knVar.getExtendId();
                        if (!this.v.containsKey(bdUniqueId)) {
                            rn rnVar3 = new rn(knVar.mContext, bdUniqueId, knVar.mPageId);
                            rnVar3.u(knVar);
                            this.t.d(rnVar3);
                            this.v.put(bdUniqueId, rnVar3);
                        }
                    }
                    if (knVar.getBottomId() != null) {
                        bdUniqueId = knVar.getBottomId();
                        if (!this.v.containsKey(bdUniqueId)) {
                            rn rnVar4 = new rn(knVar.mContext, bdUniqueId, knVar.mPageId);
                            rnVar4.u(knVar);
                            this.t.d(rnVar4);
                            this.v.put(bdUniqueId, rnVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.t.d(knVar);
                    } else {
                        this.u.put(knVar.mType, knVar);
                    }
                }
            }
            setAdapter(this.t);
        }
    }

    public xn E(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return this.t.getItem(i);
        }
        return (xn) invokeI.objValue;
    }

    public void G(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.t.k(i, getHeaderViewsCount());
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdRecyclerView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.w && !this.x) {
                this.x = true;
                ao aoVar = this.y;
                if (aoVar != null) {
                    aoVar.a();
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, parcelable) == null) {
            super.onRestoreInstanceState(parcelable);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, motionEvent)) == null) {
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Exception e) {
                BdLog.e(e);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.Cdo
    public void setData(List<? extends xn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            this.t.setData(D(list));
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
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

    public void H(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            this.t.l(i, i2, getHeaderViewsCount());
        }
    }

    public void I(@NonNull List<? extends xn> list, boolean z, @NonNull DiffUtil.ItemCallback<? extends xn> itemCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{list, Boolean.valueOf(z), itemCallback}) == null) {
            List<xn> data = this.t.getData();
            if (!z) {
                list = D(list);
            }
            DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new c(data, list, itemCallback));
            data.clear();
            data.addAll(list);
            calculateDiff.dispatchUpdatesTo(this.t);
        }
    }

    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.t.getCount();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.Cdo
    public List<xn> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.t.getData();
        }
        return (List) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return super.onSaveInstanceState();
        }
        return (Parcelable) invokeV.objValue;
    }
}
