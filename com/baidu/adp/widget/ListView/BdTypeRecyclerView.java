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
import com.baidu.tieba.bn;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.en;
import com.baidu.tieba.lm;
import com.baidu.tieba.rm;
import com.baidu.tieba.sm;
import com.baidu.tieba.ym;
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
public class BdTypeRecyclerView extends BdRecyclerView implements en<BdTypeRecyclerView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isDataSet;
    public boolean isDrawed;
    public HashMap<BdUniqueId, lm> mAdapterMap;
    public HashMap<BdUniqueId, sm> mSpitAdapterMap;
    public RecyclerViewTypeAdapter mTypeAdapter;
    public bn onListSecondDispatchDraw;
    public View.OnTouchListener recyclerViewTouchListener;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeRecyclerView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdRecyclerView, com.baidu.tieba.an
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
                    return recyclerViewTypeAdapter.r(viewGroup, view2, i, j);
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class c<T extends ym> extends DiffUtil.Callback {
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

    private List<ym> addData2List(@NonNull Collection<? extends ym> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, collection)) == null) {
            ArrayList arrayList = new ArrayList();
            for (ym ymVar : collection) {
                if (ymVar != null) {
                    if (this.mAdapterMap.containsKey(ymVar.getType())) {
                        lm lmVar = this.mAdapterMap.get(ymVar.getType());
                        if (lmVar.getHeaderId() != null) {
                            rm rmVar = new rm();
                            rmVar.e(lmVar.getHeaderId());
                            if (ymVar instanceof BaseCardInfo) {
                                rmVar.position = ((BaseCardInfo) ymVar).position;
                                rmVar.setSupportType(BaseCardInfo.SupportType.TOP);
                            }
                            rmVar.d(ymVar);
                            arrayList.add(rmVar);
                        }
                        if (lmVar.getContentId() != null) {
                            rm rmVar2 = new rm();
                            rmVar2.e(lmVar.getContentId());
                            if (ymVar instanceof BaseCardInfo) {
                                rmVar2.position = ((BaseCardInfo) ymVar).position;
                                rmVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            }
                            rmVar2.d(ymVar);
                            arrayList.add(rmVar2);
                        }
                        if (lmVar.getExtendId() != null) {
                            rm rmVar3 = new rm();
                            rmVar3.e(lmVar.getExtendId());
                            if (ymVar instanceof BaseCardInfo) {
                                rmVar3.position = ((BaseCardInfo) ymVar).position;
                                rmVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            }
                            rmVar3.d(ymVar);
                            arrayList.add(rmVar3);
                        }
                        if (lmVar.getBottomId() != null) {
                            rm rmVar4 = new rm();
                            rmVar4.e(lmVar.getBottomId());
                            if (ymVar instanceof BaseCardInfo) {
                                rmVar4.position = ((BaseCardInfo) ymVar).position;
                                rmVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                            }
                            rmVar4.d(ymVar);
                            arrayList.add(rmVar4);
                        }
                    } else {
                        arrayList.add(ymVar);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.baidu.tieba.en
    public void addAdapters(List<lm> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            for (lm<ym, TypeAdapter.ViewHolder> lmVar : list) {
                if (lmVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (lmVar.getHeaderId() != null) {
                        bdUniqueId = lmVar.getHeaderId();
                        if (!this.mSpitAdapterMap.containsKey(bdUniqueId)) {
                            sm smVar = new sm(lmVar.mContext, bdUniqueId, lmVar.mPageId);
                            smVar.u(lmVar);
                            this.mTypeAdapter.l(smVar);
                            this.mSpitAdapterMap.put(bdUniqueId, smVar);
                        }
                    }
                    if (lmVar.getContentId() != null) {
                        bdUniqueId = lmVar.getContentId();
                        if (!this.mSpitAdapterMap.containsKey(bdUniqueId)) {
                            sm smVar2 = new sm(lmVar.mContext, bdUniqueId, lmVar.mPageId);
                            smVar2.u(lmVar);
                            this.mTypeAdapter.l(smVar2);
                            this.mSpitAdapterMap.put(bdUniqueId, smVar2);
                        }
                    }
                    if (lmVar.getExtendId() != null) {
                        bdUniqueId = lmVar.getExtendId();
                        if (!this.mSpitAdapterMap.containsKey(bdUniqueId)) {
                            sm smVar3 = new sm(lmVar.mContext, bdUniqueId, lmVar.mPageId);
                            smVar3.u(lmVar);
                            this.mTypeAdapter.l(smVar3);
                            this.mSpitAdapterMap.put(bdUniqueId, smVar3);
                        }
                    }
                    if (lmVar.getBottomId() != null) {
                        bdUniqueId = lmVar.getBottomId();
                        if (!this.mSpitAdapterMap.containsKey(bdUniqueId)) {
                            sm smVar4 = new sm(lmVar.mContext, bdUniqueId, lmVar.mPageId);
                            smVar4.u(lmVar);
                            this.mTypeAdapter.l(smVar4);
                            this.mSpitAdapterMap.put(bdUniqueId, smVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.mTypeAdapter.l(lmVar);
                    } else {
                        this.mAdapterMap.put(lmVar.mType, lmVar);
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
                bn bnVar = this.onListSecondDispatchDraw;
                if (bnVar != null) {
                    bnVar.a();
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

    public ym getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return this.mTypeAdapter.getItem(i);
        }
        return (ym) invokeI.objValue;
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
            this.mTypeAdapter.s(i, getHeaderViewsCount());
        }
    }

    @Override // com.baidu.tieba.en
    public void setData(List<? extends ym> list) {
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

    @Override // com.baidu.tieba.en
    public List<ym> getData() {
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
            this.mTypeAdapter.t(i, i2, getHeaderViewsCount());
        }
    }

    public void updateData(@NonNull List<? extends ym> list, boolean z, @NonNull DiffUtil.ItemCallback<? extends ym> itemCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{list, Boolean.valueOf(z), itemCallback}) == null) {
            List<ym> data = this.mTypeAdapter.getData();
            if (!z) {
                list = addData2List(list);
            }
            DiffUtil.calculateDiff(new c(data, list, itemCallback)).dispatchUpdatesTo(this.mTypeAdapter);
            data.clear();
            data.addAll(list);
        }
    }
}
