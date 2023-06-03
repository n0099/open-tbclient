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
import com.baidu.tieba.bo;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.in;
import com.baidu.tieba.on;
import com.baidu.tieba.pn;
import com.baidu.tieba.vn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeListView extends BdListView implements bo<BdTypeListView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TypeAdapter G;
    public HashMap<BdUniqueId, in> H;
    public HashMap<BdUniqueId, pn> I;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeListView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdListView, com.baidu.tieba.xn
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
            HashMap<BdUniqueId, pn> hashMap = this.I;
            if (hashMap != null) {
                hashMap.clear();
            }
            HashMap<BdUniqueId, in> hashMap2 = this.H;
            if (hashMap2 != null) {
                hashMap2.clear();
            }
            TypeAdapter typeAdapter = this.G;
            if (typeAdapter != null) {
                typeAdapter.b();
            }
        }
    }

    @Override // com.baidu.tieba.bo
    public List<vn> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.G.c();
        }
        return (List) invokeV.objValue;
    }

    public vn G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return this.G.getItem(i);
        }
        return (vn) invokeI.objValue;
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

    @Override // com.baidu.tieba.bo
    public void addAdapters(List<in> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            for (in<vn, TypeAdapter.ViewHolder> inVar : list) {
                if (inVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (inVar.getHeaderId() != null) {
                        bdUniqueId = inVar.getHeaderId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            pn pnVar = new pn(inVar.mContext, bdUniqueId, inVar.mPageId);
                            pnVar.u(inVar);
                            this.G.a(pnVar);
                            this.I.put(bdUniqueId, pnVar);
                        }
                    }
                    if (inVar.getContentId() != null) {
                        bdUniqueId = inVar.getContentId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            pn pnVar2 = new pn(inVar.mContext, bdUniqueId, inVar.mPageId);
                            pnVar2.u(inVar);
                            this.G.a(pnVar2);
                            this.I.put(bdUniqueId, pnVar2);
                        }
                    }
                    if (inVar.getExtendId() != null) {
                        bdUniqueId = inVar.getExtendId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            pn pnVar3 = new pn(inVar.mContext, bdUniqueId, inVar.mPageId);
                            pnVar3.u(inVar);
                            this.G.a(pnVar3);
                            this.I.put(bdUniqueId, pnVar3);
                        }
                    }
                    if (inVar.getBottomId() != null) {
                        bdUniqueId = inVar.getBottomId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            pn pnVar4 = new pn(inVar.mContext, bdUniqueId, inVar.mPageId);
                            pnVar4.u(inVar);
                            this.G.a(pnVar4);
                            this.I.put(bdUniqueId, pnVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.G.a(inVar);
                    } else {
                        this.H.put(inVar.mType, inVar);
                    }
                }
            }
            setAdapter((ListAdapter) this.G);
        }
    }

    @Override // com.baidu.tieba.bo
    public void setData(List<? extends vn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (vn vnVar : list) {
                if (vnVar != null) {
                    if (this.H.containsKey(vnVar.getType())) {
                        in inVar = this.H.get(vnVar.getType());
                        if (inVar.getHeaderId() != null) {
                            on onVar = new on();
                            onVar.e(inVar.getHeaderId());
                            if (vnVar instanceof BaseCardInfo) {
                                onVar.position = ((BaseCardInfo) vnVar).position;
                                onVar.setSupportType(BaseCardInfo.SupportType.TOP);
                            }
                            onVar.d(vnVar);
                            arrayList.add(onVar);
                        }
                        if (inVar.getContentId() != null) {
                            on onVar2 = new on();
                            onVar2.e(inVar.getContentId());
                            if (vnVar instanceof BaseCardInfo) {
                                onVar2.position = ((BaseCardInfo) vnVar).position;
                                onVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            }
                            onVar2.d(vnVar);
                            arrayList.add(onVar2);
                        }
                        if (inVar.getExtendId() != null) {
                            on onVar3 = new on();
                            onVar3.e(inVar.getExtendId());
                            if (vnVar instanceof BaseCardInfo) {
                                onVar3.position = ((BaseCardInfo) vnVar).position;
                                onVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            }
                            onVar3.d(vnVar);
                            arrayList.add(onVar3);
                        }
                        if (inVar.getBottomId() != null) {
                            on onVar4 = new on();
                            onVar4.e(inVar.getBottomId());
                            if (vnVar instanceof BaseCardInfo) {
                                onVar4.position = ((BaseCardInfo) vnVar).position;
                                onVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                            }
                            onVar4.d(vnVar);
                            arrayList.add(onVar4);
                        }
                    } else {
                        arrayList.add(vnVar);
                    }
                }
            }
            this.G.i(arrayList);
        }
    }
}
