package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.cn;
import com.baidu.tieba.in;
import com.baidu.tieba.pm;
import com.baidu.tieba.vm;
import com.baidu.tieba.wm;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeListView extends BdListView implements in<BdTypeListView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TypeAdapter G;
    public HashMap<BdUniqueId, pm> H;
    public HashMap<BdUniqueId, wm> I;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeListView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdListView, com.baidu.tieba.en
    /* renamed from: getListView */
    public BdListView getListView2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this : (BdTypeListView) invokeV.objValue;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    @Deprecated
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onItemClickListener) == null) {
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    @Deprecated
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onItemLongClickListener) == null) {
        }
    }

    /* loaded from: classes.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdTypeListView a;

        public a(BdTypeListView bdTypeListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTypeListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTypeListView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            TypeAdapter typeAdapter;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && (typeAdapter = this.a.G) != null) {
                typeAdapter.e(adapterView, view2, i, j);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdTypeListView a;

        public b(BdTypeListView bdTypeListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTypeListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTypeListView;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                TypeAdapter typeAdapter = this.a.G;
                if (typeAdapter != null) {
                    return typeAdapter.f(adapterView, view2, i, j);
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdTypeListView(Context context) {
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
        this.G = null;
        H();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdTypeListView(Context context, AttributeSet attributeSet) {
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
        this.G = null;
        H();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdTypeListView(Context context, AttributeSet attributeSet, int i) {
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
        this.G = null;
        H();
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            HashMap<BdUniqueId, wm> hashMap = this.I;
            if (hashMap != null) {
                hashMap.clear();
            }
            HashMap<BdUniqueId, pm> hashMap2 = this.H;
            if (hashMap2 != null) {
                hashMap2.clear();
            }
            TypeAdapter typeAdapter = this.G;
            if (typeAdapter != null) {
                typeAdapter.b();
            }
        }
    }

    @Override // com.baidu.tieba.in
    public List<cn> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.G.c();
        }
        return (List) invokeV.objValue;
    }

    public cn G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return this.G.getItem(i);
        }
        return (cn) invokeI.objValue;
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.G == null) {
                this.G = new TypeAdapter();
            }
            if (this.H == null) {
                this.H = new HashMap<>();
            }
            if (this.I == null) {
                this.I = new HashMap<>();
            }
            super.setOnItemClickListener(new a(this));
            super.setOnItemLongClickListener(new b(this));
        }
    }

    @Override // com.baidu.tieba.in
    public void addAdapters(List<pm> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            for (pm<cn, TypeAdapter.ViewHolder> pmVar : list) {
                if (pmVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (pmVar.getHeaderId() != null) {
                        bdUniqueId = pmVar.getHeaderId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            wm wmVar = new wm(pmVar.mContext, bdUniqueId, pmVar.mPageId);
                            wmVar.u(pmVar);
                            this.G.a(wmVar);
                            this.I.put(bdUniqueId, wmVar);
                        }
                    }
                    if (pmVar.getContentId() != null) {
                        bdUniqueId = pmVar.getContentId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            wm wmVar2 = new wm(pmVar.mContext, bdUniqueId, pmVar.mPageId);
                            wmVar2.u(pmVar);
                            this.G.a(wmVar2);
                            this.I.put(bdUniqueId, wmVar2);
                        }
                    }
                    if (pmVar.getExtendId() != null) {
                        bdUniqueId = pmVar.getExtendId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            wm wmVar3 = new wm(pmVar.mContext, bdUniqueId, pmVar.mPageId);
                            wmVar3.u(pmVar);
                            this.G.a(wmVar3);
                            this.I.put(bdUniqueId, wmVar3);
                        }
                    }
                    if (pmVar.getBottomId() != null) {
                        bdUniqueId = pmVar.getBottomId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            wm wmVar4 = new wm(pmVar.mContext, bdUniqueId, pmVar.mPageId);
                            wmVar4.u(pmVar);
                            this.G.a(wmVar4);
                            this.I.put(bdUniqueId, wmVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.G.a(pmVar);
                    } else {
                        this.H.put(pmVar.mType, pmVar);
                    }
                }
            }
            setAdapter((ListAdapter) this.G);
        }
    }

    @Override // com.baidu.tieba.in
    public void setData(List<? extends cn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (cn cnVar : list) {
                if (cnVar != null) {
                    if (this.H.containsKey(cnVar.getType())) {
                        pm pmVar = this.H.get(cnVar.getType());
                        if (pmVar.getHeaderId() != null) {
                            vm vmVar = new vm();
                            vmVar.e(pmVar.getHeaderId());
                            if (cnVar instanceof BaseCardInfo) {
                                vmVar.position = ((BaseCardInfo) cnVar).position;
                                vmVar.setSupportType(BaseCardInfo.SupportType.TOP);
                            }
                            vmVar.d(cnVar);
                            arrayList.add(vmVar);
                        }
                        if (pmVar.getContentId() != null) {
                            vm vmVar2 = new vm();
                            vmVar2.e(pmVar.getContentId());
                            if (cnVar instanceof BaseCardInfo) {
                                vmVar2.position = ((BaseCardInfo) cnVar).position;
                                vmVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            }
                            vmVar2.d(cnVar);
                            arrayList.add(vmVar2);
                        }
                        if (pmVar.getExtendId() != null) {
                            vm vmVar3 = new vm();
                            vmVar3.e(pmVar.getExtendId());
                            if (cnVar instanceof BaseCardInfo) {
                                vmVar3.position = ((BaseCardInfo) cnVar).position;
                                vmVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            }
                            vmVar3.d(cnVar);
                            arrayList.add(vmVar3);
                        }
                        if (pmVar.getBottomId() != null) {
                            vm vmVar4 = new vm();
                            vmVar4.e(pmVar.getBottomId());
                            if (cnVar instanceof BaseCardInfo) {
                                vmVar4.position = ((BaseCardInfo) cnVar).position;
                                vmVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                            }
                            vmVar4.d(cnVar);
                            arrayList.add(vmVar4);
                        }
                    } else {
                        arrayList.add(cnVar);
                    }
                }
            }
            this.G.i(arrayList);
        }
    }
}
