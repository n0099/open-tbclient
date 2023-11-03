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
import com.baidu.tieba.bi;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.hi;
import com.baidu.tieba.ii;
import com.baidu.tieba.oi;
import com.baidu.tieba.ui;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeListView extends BdListView implements ui<BdTypeListView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TypeAdapter G;
    public HashMap<BdUniqueId, bi> H;
    public HashMap<BdUniqueId, ii> I;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeListView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdListView, com.baidu.tieba.qi
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
                    return typeAdapter.h(adapterView, view2, i, j);
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
            HashMap<BdUniqueId, ii> hashMap = this.I;
            if (hashMap != null) {
                hashMap.clear();
            }
            HashMap<BdUniqueId, bi> hashMap2 = this.H;
            if (hashMap2 != null) {
                hashMap2.clear();
            }
            TypeAdapter typeAdapter = this.G;
            if (typeAdapter != null) {
                typeAdapter.b();
            }
        }
    }

    @Override // com.baidu.tieba.ui
    public List<oi> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.G.c();
        }
        return (List) invokeV.objValue;
    }

    public oi G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return this.G.getItem(i);
        }
        return (oi) invokeI.objValue;
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

    @Override // com.baidu.tieba.ui
    public void addAdapters(List<bi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            for (bi<oi, TypeAdapter.ViewHolder> biVar : list) {
                if (biVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (biVar.getHeaderId() != null) {
                        bdUniqueId = biVar.getHeaderId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            ii iiVar = new ii(biVar.mContext, bdUniqueId, biVar.mPageId);
                            iiVar.x(biVar);
                            this.G.a(iiVar);
                            this.I.put(bdUniqueId, iiVar);
                        }
                    }
                    if (biVar.getContentId() != null) {
                        bdUniqueId = biVar.getContentId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            ii iiVar2 = new ii(biVar.mContext, bdUniqueId, biVar.mPageId);
                            iiVar2.x(biVar);
                            this.G.a(iiVar2);
                            this.I.put(bdUniqueId, iiVar2);
                        }
                    }
                    if (biVar.getExtendId() != null) {
                        bdUniqueId = biVar.getExtendId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            ii iiVar3 = new ii(biVar.mContext, bdUniqueId, biVar.mPageId);
                            iiVar3.x(biVar);
                            this.G.a(iiVar3);
                            this.I.put(bdUniqueId, iiVar3);
                        }
                    }
                    if (biVar.getBottomId() != null) {
                        bdUniqueId = biVar.getBottomId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            ii iiVar4 = new ii(biVar.mContext, bdUniqueId, biVar.mPageId);
                            iiVar4.x(biVar);
                            this.G.a(iiVar4);
                            this.I.put(bdUniqueId, iiVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.G.a(biVar);
                    } else {
                        this.H.put(biVar.mType, biVar);
                    }
                }
            }
            setAdapter((ListAdapter) this.G);
        }
    }

    @Override // com.baidu.tieba.ui
    public void setData(List<? extends oi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (oi oiVar : list) {
                if (oiVar != null) {
                    if (this.H.containsKey(oiVar.getType())) {
                        bi biVar = this.H.get(oiVar.getType());
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
            this.G.i(arrayList);
        }
    }
}
