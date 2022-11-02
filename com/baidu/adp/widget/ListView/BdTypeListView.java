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
import com.baidu.tieba.co;
import com.baidu.tieba.jn;
import com.baidu.tieba.pn;
import com.baidu.tieba.qn;
import com.baidu.tieba.wn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeListView extends BdListView implements co<BdTypeListView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TypeAdapter G;
    public HashMap<BdUniqueId, jn> H;
    public HashMap<BdUniqueId, qn> I;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeListView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdListView, com.baidu.tieba.yn
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
                typeAdapter.f(adapterView, view2, i, j);
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

    public wn G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return this.G.getItem(i);
        }
        return (wn) invokeI.objValue;
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

    @Override // com.baidu.tieba.co
    public void a(List<jn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            for (jn<wn, TypeAdapter.ViewHolder> jnVar : list) {
                if (jnVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (jnVar.getHeaderId() != null) {
                        bdUniqueId = jnVar.getHeaderId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            qn qnVar = new qn(jnVar.mContext, bdUniqueId, jnVar.mPageId);
                            qnVar.u(jnVar);
                            this.G.a(qnVar);
                            this.I.put(bdUniqueId, qnVar);
                        }
                    }
                    if (jnVar.getContentId() != null) {
                        bdUniqueId = jnVar.getContentId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            qn qnVar2 = new qn(jnVar.mContext, bdUniqueId, jnVar.mPageId);
                            qnVar2.u(jnVar);
                            this.G.a(qnVar2);
                            this.I.put(bdUniqueId, qnVar2);
                        }
                    }
                    if (jnVar.getExtendId() != null) {
                        bdUniqueId = jnVar.getExtendId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            qn qnVar3 = new qn(jnVar.mContext, bdUniqueId, jnVar.mPageId);
                            qnVar3.u(jnVar);
                            this.G.a(qnVar3);
                            this.I.put(bdUniqueId, qnVar3);
                        }
                    }
                    if (jnVar.getBottomId() != null) {
                        bdUniqueId = jnVar.getBottomId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            qn qnVar4 = new qn(jnVar.mContext, bdUniqueId, jnVar.mPageId);
                            qnVar4.u(jnVar);
                            this.G.a(qnVar4);
                            this.I.put(bdUniqueId, qnVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.G.a(jnVar);
                    } else {
                        this.H.put(jnVar.mType, jnVar);
                    }
                }
            }
            setAdapter((ListAdapter) this.G);
        }
    }

    @Override // com.baidu.tieba.co
    public void setData(List<? extends wn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (wn wnVar : list) {
                if (wnVar != null) {
                    if (this.H.containsKey(wnVar.getType())) {
                        jn jnVar = this.H.get(wnVar.getType());
                        if (jnVar.getHeaderId() != null) {
                            pn pnVar = new pn();
                            pnVar.h(jnVar.getHeaderId());
                            if (wnVar instanceof BaseCardInfo) {
                                pnVar.position = ((BaseCardInfo) wnVar).position;
                                pnVar.setSupportType(BaseCardInfo.SupportType.TOP);
                            }
                            pnVar.f(wnVar);
                            arrayList.add(pnVar);
                        }
                        if (jnVar.getContentId() != null) {
                            pn pnVar2 = new pn();
                            pnVar2.h(jnVar.getContentId());
                            if (wnVar instanceof BaseCardInfo) {
                                pnVar2.position = ((BaseCardInfo) wnVar).position;
                                pnVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            }
                            pnVar2.f(wnVar);
                            arrayList.add(pnVar2);
                        }
                        if (jnVar.getExtendId() != null) {
                            pn pnVar3 = new pn();
                            pnVar3.h(jnVar.getExtendId());
                            if (wnVar instanceof BaseCardInfo) {
                                pnVar3.position = ((BaseCardInfo) wnVar).position;
                                pnVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            }
                            pnVar3.f(wnVar);
                            arrayList.add(pnVar3);
                        }
                        if (jnVar.getBottomId() != null) {
                            pn pnVar4 = new pn();
                            pnVar4.h(jnVar.getBottomId());
                            if (wnVar instanceof BaseCardInfo) {
                                pnVar4.position = ((BaseCardInfo) wnVar).position;
                                pnVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                            }
                            pnVar4.f(wnVar);
                            arrayList.add(pnVar4);
                        }
                    } else {
                        arrayList.add(wnVar);
                    }
                }
            }
            this.G.h(arrayList);
        }
    }

    @Override // com.baidu.tieba.co
    public List<wn> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.G.d();
        }
        return (List) invokeV.objValue;
    }
}
