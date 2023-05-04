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
import com.baidu.tieba.bn;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.cn;
import com.baidu.tieba.in;
import com.baidu.tieba.on;
import com.baidu.tieba.vm;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeListView extends BdListView implements on<BdTypeListView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TypeAdapter G;
    public HashMap<BdUniqueId, vm> H;
    public HashMap<BdUniqueId, cn> I;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeListView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdListView, com.baidu.tieba.kn
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
            HashMap<BdUniqueId, cn> hashMap = this.I;
            if (hashMap != null) {
                hashMap.clear();
            }
            HashMap<BdUniqueId, vm> hashMap2 = this.H;
            if (hashMap2 != null) {
                hashMap2.clear();
            }
            TypeAdapter typeAdapter = this.G;
            if (typeAdapter != null) {
                typeAdapter.b();
            }
        }
    }

    @Override // com.baidu.tieba.on
    public List<in> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.G.c();
        }
        return (List) invokeV.objValue;
    }

    public in G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return this.G.getItem(i);
        }
        return (in) invokeI.objValue;
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

    @Override // com.baidu.tieba.on
    public void addAdapters(List<vm> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            for (vm<in, TypeAdapter.ViewHolder> vmVar : list) {
                if (vmVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (vmVar.getHeaderId() != null) {
                        bdUniqueId = vmVar.getHeaderId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            cn cnVar = new cn(vmVar.mContext, bdUniqueId, vmVar.mPageId);
                            cnVar.u(vmVar);
                            this.G.a(cnVar);
                            this.I.put(bdUniqueId, cnVar);
                        }
                    }
                    if (vmVar.getContentId() != null) {
                        bdUniqueId = vmVar.getContentId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            cn cnVar2 = new cn(vmVar.mContext, bdUniqueId, vmVar.mPageId);
                            cnVar2.u(vmVar);
                            this.G.a(cnVar2);
                            this.I.put(bdUniqueId, cnVar2);
                        }
                    }
                    if (vmVar.getExtendId() != null) {
                        bdUniqueId = vmVar.getExtendId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            cn cnVar3 = new cn(vmVar.mContext, bdUniqueId, vmVar.mPageId);
                            cnVar3.u(vmVar);
                            this.G.a(cnVar3);
                            this.I.put(bdUniqueId, cnVar3);
                        }
                    }
                    if (vmVar.getBottomId() != null) {
                        bdUniqueId = vmVar.getBottomId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            cn cnVar4 = new cn(vmVar.mContext, bdUniqueId, vmVar.mPageId);
                            cnVar4.u(vmVar);
                            this.G.a(cnVar4);
                            this.I.put(bdUniqueId, cnVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.G.a(vmVar);
                    } else {
                        this.H.put(vmVar.mType, vmVar);
                    }
                }
            }
            setAdapter((ListAdapter) this.G);
        }
    }

    @Override // com.baidu.tieba.on
    public void setData(List<? extends in> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (in inVar : list) {
                if (inVar != null) {
                    if (this.H.containsKey(inVar.getType())) {
                        vm vmVar = this.H.get(inVar.getType());
                        if (vmVar.getHeaderId() != null) {
                            bn bnVar = new bn();
                            bnVar.e(vmVar.getHeaderId());
                            if (inVar instanceof BaseCardInfo) {
                                bnVar.position = ((BaseCardInfo) inVar).position;
                                bnVar.setSupportType(BaseCardInfo.SupportType.TOP);
                            }
                            bnVar.d(inVar);
                            arrayList.add(bnVar);
                        }
                        if (vmVar.getContentId() != null) {
                            bn bnVar2 = new bn();
                            bnVar2.e(vmVar.getContentId());
                            if (inVar instanceof BaseCardInfo) {
                                bnVar2.position = ((BaseCardInfo) inVar).position;
                                bnVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            }
                            bnVar2.d(inVar);
                            arrayList.add(bnVar2);
                        }
                        if (vmVar.getExtendId() != null) {
                            bn bnVar3 = new bn();
                            bnVar3.e(vmVar.getExtendId());
                            if (inVar instanceof BaseCardInfo) {
                                bnVar3.position = ((BaseCardInfo) inVar).position;
                                bnVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            }
                            bnVar3.d(inVar);
                            arrayList.add(bnVar3);
                        }
                        if (vmVar.getBottomId() != null) {
                            bn bnVar4 = new bn();
                            bnVar4.e(vmVar.getBottomId());
                            if (inVar instanceof BaseCardInfo) {
                                bnVar4.position = ((BaseCardInfo) inVar).position;
                                bnVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                            }
                            bnVar4.d(inVar);
                            arrayList.add(bnVar4);
                        }
                    } else {
                        arrayList.add(inVar);
                    }
                }
            }
            this.G.i(arrayList);
        }
    }
}
