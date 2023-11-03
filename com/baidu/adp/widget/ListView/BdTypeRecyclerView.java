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
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DiffUtil;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.bi;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.hi;
import com.baidu.tieba.ii;
import com.baidu.tieba.oi;
import com.baidu.tieba.ri;
import com.baidu.tieba.ui;
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
public class BdTypeRecyclerView extends BdRecyclerView implements ui<BdTypeRecyclerView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isDataSet;
    public boolean isDrawed;
    public HashMap<BdUniqueId, bi> mAdapterMap;
    public HashMap<BdUniqueId, ii> mSpitAdapterMap;
    public RecyclerViewTypeAdapter mTypeAdapter;
    public ri onListSecondDispatchDraw;
    public View.OnTouchListener recyclerViewTouchListener;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeRecyclerView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdRecyclerView, com.baidu.tieba.qi
    /* renamed from: getListView */
    public BdRecyclerView getListView2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : (BdTypeRecyclerView) invokeV.objValue;
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
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) && (recyclerViewTypeAdapter = this.a.mTypeAdapter) != null) {
                recyclerViewTypeAdapter.q(viewGroup, view2, i, j);
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
                RecyclerViewTypeAdapter recyclerViewTypeAdapter = this.a.mTypeAdapter;
                if (recyclerViewTypeAdapter != null) {
                    return recyclerViewTypeAdapter.s(viewGroup, view2, i, j);
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class c<T extends oi> extends DiffUtil.Callback {
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
        @Nullable
        public Object getChangePayload(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2)) == null) {
                T t = this.a.get(i);
                T t2 = this.b.get(i2);
                if (t != null && t2 != null) {
                    return this.c.getChangePayload(t, t2);
                }
                return null;
            }
            return invokeII.objValue;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.b.size();
            }
            return invokeV.intValue;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
        this.mTypeAdapter = null;
        init();
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
        this.mTypeAdapter = null;
        init();
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
        this.mTypeAdapter = null;
        init();
    }

    private List<oi> addData2List(@NonNull Collection<? extends oi> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, collection)) == null) {
            ArrayList arrayList = new ArrayList();
            for (oi oiVar : collection) {
                if (oiVar != null) {
                    if (this.mAdapterMap.containsKey(oiVar.getType())) {
                        bi biVar = this.mAdapterMap.get(oiVar.getType());
                        if (biVar.getHeaderId() != null) {
                            hi hiVar = new hi();
                            hiVar.e(biVar.getHeaderId());
                            if (oiVar instanceof BaseCardInfo) {
                                hiVar.position = ((BaseCardInfo) oiVar).position;
                                hiVar.setSupportType(BaseCardInfo.SupportType.TOP);
                            }
                            hiVar.d(oiVar);
                            arrayList.add(hiVar);
                        }
                        if (biVar.getContentId() != null) {
                            hi hiVar2 = new hi();
                            hiVar2.e(biVar.getContentId());
                            if (oiVar instanceof BaseCardInfo) {
                                hiVar2.position = ((BaseCardInfo) oiVar).position;
                                hiVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            }
                            hiVar2.d(oiVar);
                            arrayList.add(hiVar2);
                        }
                        if (biVar.getExtendId() != null) {
                            hi hiVar3 = new hi();
                            hiVar3.e(biVar.getExtendId());
                            if (oiVar instanceof BaseCardInfo) {
                                hiVar3.position = ((BaseCardInfo) oiVar).position;
                                hiVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            }
                            hiVar3.d(oiVar);
                            arrayList.add(hiVar3);
                        }
                        if (biVar.getBottomId() != null) {
                            hi hiVar4 = new hi();
                            hiVar4.e(biVar.getBottomId());
                            if (oiVar instanceof BaseCardInfo) {
                                hiVar4.position = ((BaseCardInfo) oiVar).position;
                                hiVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                            }
                            hiVar4.d(oiVar);
                            arrayList.add(hiVar4);
                        }
                    } else {
                        arrayList.add(oiVar);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ui
    public void addAdapters(List<bi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            for (bi<oi, TypeAdapter.ViewHolder> biVar : list) {
                if (biVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (biVar.getHeaderId() != null) {
                        bdUniqueId = biVar.getHeaderId();
                        if (!this.mSpitAdapterMap.containsKey(bdUniqueId)) {
                            ii iiVar = new ii(biVar.mContext, bdUniqueId, biVar.mPageId);
                            iiVar.x(biVar);
                            this.mTypeAdapter.l(iiVar);
                            this.mSpitAdapterMap.put(bdUniqueId, iiVar);
                        }
                    }
                    if (biVar.getContentId() != null) {
                        bdUniqueId = biVar.getContentId();
                        if (!this.mSpitAdapterMap.containsKey(bdUniqueId)) {
                            ii iiVar2 = new ii(biVar.mContext, bdUniqueId, biVar.mPageId);
                            iiVar2.x(biVar);
                            this.mTypeAdapter.l(iiVar2);
                            this.mSpitAdapterMap.put(bdUniqueId, iiVar2);
                        }
                    }
                    if (biVar.getExtendId() != null) {
                        bdUniqueId = biVar.getExtendId();
                        if (!this.mSpitAdapterMap.containsKey(bdUniqueId)) {
                            ii iiVar3 = new ii(biVar.mContext, bdUniqueId, biVar.mPageId);
                            iiVar3.x(biVar);
                            this.mTypeAdapter.l(iiVar3);
                            this.mSpitAdapterMap.put(bdUniqueId, iiVar3);
                        }
                    }
                    if (biVar.getBottomId() != null) {
                        bdUniqueId = biVar.getBottomId();
                        if (!this.mSpitAdapterMap.containsKey(bdUniqueId)) {
                            ii iiVar4 = new ii(biVar.mContext, bdUniqueId, biVar.mPageId);
                            iiVar4.x(biVar);
                            this.mTypeAdapter.l(iiVar4);
                            this.mSpitAdapterMap.put(bdUniqueId, iiVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.mTypeAdapter.l(biVar);
                    } else {
                        this.mAdapterMap.put(biVar.mType, biVar);
                    }
                }
            }
            setAdapter(this.mTypeAdapter);
        }
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            if (this.mTypeAdapter == null) {
                this.mTypeAdapter = new RecyclerViewTypeAdapter();
            }
            if (this.mAdapterMap == null) {
                this.mAdapterMap = new HashMap<>();
            }
            if (this.mSpitAdapterMap == null) {
                this.mSpitAdapterMap = new HashMap<>();
            }
            super.setOnItemClickListener(new a(this));
            super.setOnItemLongClickListener(new b(this));
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdRecyclerView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.isDataSet && !this.isDrawed) {
                this.isDrawed = true;
                ri riVar = this.onListSecondDispatchDraw;
                if (riVar != null) {
                    riVar.a();
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            View.OnTouchListener onTouchListener = this.recyclerViewTouchListener;
            if (onTouchListener != null) {
                onTouchListener.onTouch(getListView2(), motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public oi getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return this.mTypeAdapter.getItem(i);
        }
        return (oi) invokeI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, parcelable) == null) {
            super.onRestoreInstanceState(parcelable);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, motionEvent)) == null) {
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Exception e) {
                BdLog.e(e);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void removeItem(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.mTypeAdapter.t(i, getHeaderViewsCount());
        }
    }

    @Override // com.baidu.tieba.ui
    public void setData(List<? extends oi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            this.mTypeAdapter.setData(addData2List(list));
        }
    }

    public void setRecyclerViewTouchListener(View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onTouchListener) == null) {
            this.recyclerViewTouchListener = onTouchListener;
        }
    }

    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mTypeAdapter.getCount();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ui
    public List<oi> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mTypeAdapter.getData();
        }
        return (List) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return super.onSaveInstanceState();
        }
        return (Parcelable) invokeV.objValue;
    }

    public void removeItemList(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i, i2) == null) {
            this.mTypeAdapter.u(i, i2, getHeaderViewsCount());
        }
    }

    public void updateData(@NonNull List<? extends oi> list, boolean z, @NonNull DiffUtil.ItemCallback<? extends oi> itemCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{list, Boolean.valueOf(z), itemCallback}) == null) {
            List<oi> data = this.mTypeAdapter.getData();
            if (!z) {
                list = addData2List(list);
            }
            DiffUtil.calculateDiff(new c(data, list, itemCallback)).dispatchUpdatesTo(this.mTypeAdapter);
            data.clear();
            data.addAll(list);
        }
    }
}
