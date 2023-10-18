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
import com.baidu.tieba.ei;
import com.baidu.tieba.lh;
import com.baidu.tieba.rh;
import com.baidu.tieba.sh;
import com.baidu.tieba.yh;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeListView extends BdListView implements ei<BdTypeListView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TypeAdapter G;
    public HashMap<BdUniqueId, lh> H;
    public HashMap<BdUniqueId, sh> I;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeListView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdListView, com.baidu.tieba.ai
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
            HashMap<BdUniqueId, sh> hashMap = this.I;
            if (hashMap != null) {
                hashMap.clear();
            }
            HashMap<BdUniqueId, lh> hashMap2 = this.H;
            if (hashMap2 != null) {
                hashMap2.clear();
            }
            TypeAdapter typeAdapter = this.G;
            if (typeAdapter != null) {
                typeAdapter.b();
            }
        }
    }

    @Override // com.baidu.tieba.ei
    public List<yh> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.G.c();
        }
        return (List) invokeV.objValue;
    }

    public yh G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return this.G.getItem(i);
        }
        return (yh) invokeI.objValue;
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

    @Override // com.baidu.tieba.ei
    public void addAdapters(List<lh> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            for (lh<yh, TypeAdapter.ViewHolder> lhVar : list) {
                if (lhVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (lhVar.getHeaderId() != null) {
                        bdUniqueId = lhVar.getHeaderId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            sh shVar = new sh(lhVar.mContext, bdUniqueId, lhVar.mPageId);
                            shVar.u(lhVar);
                            this.G.a(shVar);
                            this.I.put(bdUniqueId, shVar);
                        }
                    }
                    if (lhVar.getContentId() != null) {
                        bdUniqueId = lhVar.getContentId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            sh shVar2 = new sh(lhVar.mContext, bdUniqueId, lhVar.mPageId);
                            shVar2.u(lhVar);
                            this.G.a(shVar2);
                            this.I.put(bdUniqueId, shVar2);
                        }
                    }
                    if (lhVar.getExtendId() != null) {
                        bdUniqueId = lhVar.getExtendId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            sh shVar3 = new sh(lhVar.mContext, bdUniqueId, lhVar.mPageId);
                            shVar3.u(lhVar);
                            this.G.a(shVar3);
                            this.I.put(bdUniqueId, shVar3);
                        }
                    }
                    if (lhVar.getBottomId() != null) {
                        bdUniqueId = lhVar.getBottomId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            sh shVar4 = new sh(lhVar.mContext, bdUniqueId, lhVar.mPageId);
                            shVar4.u(lhVar);
                            this.G.a(shVar4);
                            this.I.put(bdUniqueId, shVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.G.a(lhVar);
                    } else {
                        this.H.put(lhVar.mType, lhVar);
                    }
                }
            }
            setAdapter((ListAdapter) this.G);
        }
    }

    @Override // com.baidu.tieba.ei
    public void setData(List<? extends yh> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (yh yhVar : list) {
                if (yhVar != null) {
                    if (this.H.containsKey(yhVar.getType())) {
                        lh lhVar = this.H.get(yhVar.getType());
                        if (lhVar.getHeaderId() != null) {
                            rh rhVar = new rh();
                            rhVar.e(lhVar.getHeaderId());
                            if (yhVar instanceof BaseCardInfo) {
                                rhVar.position = ((BaseCardInfo) yhVar).position;
                                rhVar.setSupportType(BaseCardInfo.SupportType.TOP);
                            }
                            rhVar.d(yhVar);
                            arrayList.add(rhVar);
                        }
                        if (lhVar.getContentId() != null) {
                            rh rhVar2 = new rh();
                            rhVar2.e(lhVar.getContentId());
                            if (yhVar instanceof BaseCardInfo) {
                                rhVar2.position = ((BaseCardInfo) yhVar).position;
                                rhVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            }
                            rhVar2.d(yhVar);
                            arrayList.add(rhVar2);
                        }
                        if (lhVar.getExtendId() != null) {
                            rh rhVar3 = new rh();
                            rhVar3.e(lhVar.getExtendId());
                            if (yhVar instanceof BaseCardInfo) {
                                rhVar3.position = ((BaseCardInfo) yhVar).position;
                                rhVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            }
                            rhVar3.d(yhVar);
                            arrayList.add(rhVar3);
                        }
                        if (lhVar.getBottomId() != null) {
                            rh rhVar4 = new rh();
                            rhVar4.e(lhVar.getBottomId());
                            if (yhVar instanceof BaseCardInfo) {
                                rhVar4.position = ((BaseCardInfo) yhVar).position;
                                rhVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                            }
                            rhVar4.d(yhVar);
                            arrayList.add(rhVar4);
                        }
                    } else {
                        arrayList.add(yhVar);
                    }
                }
            }
            this.G.i(arrayList);
        }
    }
}
