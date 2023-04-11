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
import com.baidu.tieba.an;
import com.baidu.tieba.bn;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.hn;
import com.baidu.tieba.nn;
import com.baidu.tieba.um;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeListView extends BdListView implements nn<BdTypeListView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TypeAdapter G;
    public HashMap<BdUniqueId, um> H;
    public HashMap<BdUniqueId, bn> I;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeListView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdListView, com.baidu.tieba.jn
    /* renamed from: getListView */
    public BdListView getListView2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (BdTypeListView) invokeV.objValue;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    @Deprecated
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onItemClickListener) == null) {
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    @Deprecated
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onItemLongClickListener) == null) {
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
                typeAdapter.d(adapterView, view2, i, j);
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
                    return typeAdapter.e(adapterView, view2, i, j);
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
        G();
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
        G();
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
        G();
    }

    public hn F(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return this.G.getItem(i);
        }
        return (hn) invokeI.objValue;
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
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

    @Override // com.baidu.tieba.nn
    public void addAdapters(List<um> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            for (um<hn, TypeAdapter.ViewHolder> umVar : list) {
                if (umVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (umVar.getHeaderId() != null) {
                        bdUniqueId = umVar.getHeaderId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            bn bnVar = new bn(umVar.mContext, bdUniqueId, umVar.mPageId);
                            bnVar.u(umVar);
                            this.G.a(bnVar);
                            this.I.put(bdUniqueId, bnVar);
                        }
                    }
                    if (umVar.getContentId() != null) {
                        bdUniqueId = umVar.getContentId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            bn bnVar2 = new bn(umVar.mContext, bdUniqueId, umVar.mPageId);
                            bnVar2.u(umVar);
                            this.G.a(bnVar2);
                            this.I.put(bdUniqueId, bnVar2);
                        }
                    }
                    if (umVar.getExtendId() != null) {
                        bdUniqueId = umVar.getExtendId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            bn bnVar3 = new bn(umVar.mContext, bdUniqueId, umVar.mPageId);
                            bnVar3.u(umVar);
                            this.G.a(bnVar3);
                            this.I.put(bdUniqueId, bnVar3);
                        }
                    }
                    if (umVar.getBottomId() != null) {
                        bdUniqueId = umVar.getBottomId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            bn bnVar4 = new bn(umVar.mContext, bdUniqueId, umVar.mPageId);
                            bnVar4.u(umVar);
                            this.G.a(bnVar4);
                            this.I.put(bdUniqueId, bnVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.G.a(umVar);
                    } else {
                        this.H.put(umVar.mType, umVar);
                    }
                }
            }
            setAdapter((ListAdapter) this.G);
        }
    }

    @Override // com.baidu.tieba.nn
    public void setData(List<? extends hn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (hn hnVar : list) {
                if (hnVar != null) {
                    if (this.H.containsKey(hnVar.getType())) {
                        um umVar = this.H.get(hnVar.getType());
                        if (umVar.getHeaderId() != null) {
                            an anVar = new an();
                            anVar.e(umVar.getHeaderId());
                            if (hnVar instanceof BaseCardInfo) {
                                anVar.position = ((BaseCardInfo) hnVar).position;
                                anVar.setSupportType(BaseCardInfo.SupportType.TOP);
                            }
                            anVar.d(hnVar);
                            arrayList.add(anVar);
                        }
                        if (umVar.getContentId() != null) {
                            an anVar2 = new an();
                            anVar2.e(umVar.getContentId());
                            if (hnVar instanceof BaseCardInfo) {
                                anVar2.position = ((BaseCardInfo) hnVar).position;
                                anVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            }
                            anVar2.d(hnVar);
                            arrayList.add(anVar2);
                        }
                        if (umVar.getExtendId() != null) {
                            an anVar3 = new an();
                            anVar3.e(umVar.getExtendId());
                            if (hnVar instanceof BaseCardInfo) {
                                anVar3.position = ((BaseCardInfo) hnVar).position;
                                anVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            }
                            anVar3.d(hnVar);
                            arrayList.add(anVar3);
                        }
                        if (umVar.getBottomId() != null) {
                            an anVar4 = new an();
                            anVar4.e(umVar.getBottomId());
                            if (hnVar instanceof BaseCardInfo) {
                                anVar4.position = ((BaseCardInfo) hnVar).position;
                                anVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                            }
                            anVar4.d(hnVar);
                            arrayList.add(anVar4);
                        }
                    } else {
                        arrayList.add(hnVar);
                    }
                }
            }
            this.G.f(arrayList);
        }
    }

    @Override // com.baidu.tieba.nn
    public List<hn> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.G.b();
        }
        return (List) invokeV.objValue;
    }
}
