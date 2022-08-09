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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bn;
import com.repackage.hn;
import com.repackage.in;
import com.repackage.on;
import com.repackage.un;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeListView extends BdListView implements un<BdTypeListView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TypeAdapter G;
    public HashMap<BdUniqueId, bn> H;
    public HashMap<BdUniqueId, in> I;

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
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || (typeAdapter = this.a.G) == null) {
                return;
            }
            typeAdapter.f(adapterView, view2, i, j);
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
                    return typeAdapter.g(adapterView, view2, i, j);
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

    public on G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.G.getItem(i) : (on) invokeI.objValue;
    }

    public final void H() {
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

    @Override // com.repackage.un
    public void a(List<bn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            for (bn<on, TypeAdapter.ViewHolder> bnVar : list) {
                if (bnVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (bnVar.getHeaderId() != null) {
                        bdUniqueId = bnVar.getHeaderId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            in inVar = new in(bnVar.mContext, bdUniqueId, bnVar.mPageId);
                            inVar.u(bnVar);
                            this.G.a(inVar);
                            this.I.put(bdUniqueId, inVar);
                        }
                    }
                    if (bnVar.getContentId() != null) {
                        bdUniqueId = bnVar.getContentId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            in inVar2 = new in(bnVar.mContext, bdUniqueId, bnVar.mPageId);
                            inVar2.u(bnVar);
                            this.G.a(inVar2);
                            this.I.put(bdUniqueId, inVar2);
                        }
                    }
                    if (bnVar.getExtendId() != null) {
                        bdUniqueId = bnVar.getExtendId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            in inVar3 = new in(bnVar.mContext, bdUniqueId, bnVar.mPageId);
                            inVar3.u(bnVar);
                            this.G.a(inVar3);
                            this.I.put(bdUniqueId, inVar3);
                        }
                    }
                    if (bnVar.getBottomId() != null) {
                        bdUniqueId = bnVar.getBottomId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            in inVar4 = new in(bnVar.mContext, bdUniqueId, bnVar.mPageId);
                            inVar4.u(bnVar);
                            this.G.a(inVar4);
                            this.I.put(bdUniqueId, inVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.G.a(bnVar);
                    } else {
                        this.H.put(bnVar.mType, bnVar);
                    }
                }
            }
            setAdapter((ListAdapter) this.G);
        }
    }

    @Override // com.repackage.un
    public List<on> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.G.d() : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeListView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdListView, com.repackage.qn
    /* renamed from: getListView */
    public BdListView getListView2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (BdTypeListView) invokeV.objValue;
    }

    @Override // com.repackage.un
    public void setData(List<? extends on> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (on onVar : list) {
                if (onVar != null) {
                    if (this.H.containsKey(onVar.getType())) {
                        bn bnVar = this.H.get(onVar.getType());
                        if (bnVar.getHeaderId() != null) {
                            hn hnVar = new hn();
                            hnVar.h(bnVar.getHeaderId());
                            if (onVar instanceof BaseCardInfo) {
                                hnVar.position = ((BaseCardInfo) onVar).position;
                                hnVar.setSupportType(BaseCardInfo.SupportType.TOP);
                            }
                            hnVar.f(onVar);
                            arrayList.add(hnVar);
                        }
                        if (bnVar.getContentId() != null) {
                            hn hnVar2 = new hn();
                            hnVar2.h(bnVar.getContentId());
                            if (onVar instanceof BaseCardInfo) {
                                hnVar2.position = ((BaseCardInfo) onVar).position;
                                hnVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            }
                            hnVar2.f(onVar);
                            arrayList.add(hnVar2);
                        }
                        if (bnVar.getExtendId() != null) {
                            hn hnVar3 = new hn();
                            hnVar3.h(bnVar.getExtendId());
                            if (onVar instanceof BaseCardInfo) {
                                hnVar3.position = ((BaseCardInfo) onVar).position;
                                hnVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            }
                            hnVar3.f(onVar);
                            arrayList.add(hnVar3);
                        }
                        if (bnVar.getBottomId() != null) {
                            hn hnVar4 = new hn();
                            hnVar4.h(bnVar.getBottomId());
                            if (onVar instanceof BaseCardInfo) {
                                hnVar4.position = ((BaseCardInfo) onVar).position;
                                hnVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                            }
                            hnVar4.f(onVar);
                            arrayList.add(hnVar4);
                        }
                    } else {
                        arrayList.add(onVar);
                    }
                }
            }
            this.G.h(arrayList);
        }
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
}
