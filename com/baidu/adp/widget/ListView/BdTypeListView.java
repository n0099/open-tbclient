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
import com.baidu.tieba.jn;
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
public class BdTypeListView extends BdListView implements vn<BdTypeListView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TypeAdapter G;
    public HashMap<BdUniqueId, cn> H;
    public HashMap<BdUniqueId, jn> I;

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

    public pn G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.G.getItem(i) : (pn) invokeI.objValue;
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

    @Override // com.baidu.tieba.vn
    public void a(List<cn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            for (cn<pn, TypeAdapter.ViewHolder> cnVar : list) {
                if (cnVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (cnVar.getHeaderId() != null) {
                        bdUniqueId = cnVar.getHeaderId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            jn jnVar = new jn(cnVar.mContext, bdUniqueId, cnVar.mPageId);
                            jnVar.u(cnVar);
                            this.G.a(jnVar);
                            this.I.put(bdUniqueId, jnVar);
                        }
                    }
                    if (cnVar.getContentId() != null) {
                        bdUniqueId = cnVar.getContentId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            jn jnVar2 = new jn(cnVar.mContext, bdUniqueId, cnVar.mPageId);
                            jnVar2.u(cnVar);
                            this.G.a(jnVar2);
                            this.I.put(bdUniqueId, jnVar2);
                        }
                    }
                    if (cnVar.getExtendId() != null) {
                        bdUniqueId = cnVar.getExtendId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            jn jnVar3 = new jn(cnVar.mContext, bdUniqueId, cnVar.mPageId);
                            jnVar3.u(cnVar);
                            this.G.a(jnVar3);
                            this.I.put(bdUniqueId, jnVar3);
                        }
                    }
                    if (cnVar.getBottomId() != null) {
                        bdUniqueId = cnVar.getBottomId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            jn jnVar4 = new jn(cnVar.mContext, bdUniqueId, cnVar.mPageId);
                            jnVar4.u(cnVar);
                            this.G.a(jnVar4);
                            this.I.put(bdUniqueId, jnVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.G.a(cnVar);
                    } else {
                        this.H.put(cnVar.mType, cnVar);
                    }
                }
            }
            setAdapter((ListAdapter) this.G);
        }
    }

    @Override // com.baidu.tieba.vn
    public List<pn> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.G.d() : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeListView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdListView, com.baidu.tieba.rn
    /* renamed from: getListView */
    public BdListView getListView2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (BdTypeListView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vn
    public void setData(List<? extends pn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (pn pnVar : list) {
                if (pnVar != null) {
                    if (this.H.containsKey(pnVar.getType())) {
                        cn cnVar = this.H.get(pnVar.getType());
                        if (cnVar.getHeaderId() != null) {
                            in inVar = new in();
                            inVar.h(cnVar.getHeaderId());
                            if (pnVar instanceof BaseCardInfo) {
                                inVar.position = ((BaseCardInfo) pnVar).position;
                                inVar.setSupportType(BaseCardInfo.SupportType.TOP);
                            }
                            inVar.f(pnVar);
                            arrayList.add(inVar);
                        }
                        if (cnVar.getContentId() != null) {
                            in inVar2 = new in();
                            inVar2.h(cnVar.getContentId());
                            if (pnVar instanceof BaseCardInfo) {
                                inVar2.position = ((BaseCardInfo) pnVar).position;
                                inVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            }
                            inVar2.f(pnVar);
                            arrayList.add(inVar2);
                        }
                        if (cnVar.getExtendId() != null) {
                            in inVar3 = new in();
                            inVar3.h(cnVar.getExtendId());
                            if (pnVar instanceof BaseCardInfo) {
                                inVar3.position = ((BaseCardInfo) pnVar).position;
                                inVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            }
                            inVar3.f(pnVar);
                            arrayList.add(inVar3);
                        }
                        if (cnVar.getBottomId() != null) {
                            in inVar4 = new in();
                            inVar4.h(cnVar.getBottomId());
                            if (pnVar instanceof BaseCardInfo) {
                                inVar4.position = ((BaseCardInfo) pnVar).position;
                                inVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                            }
                            inVar4.f(pnVar);
                            arrayList.add(inVar4);
                        }
                    } else {
                        arrayList.add(pnVar);
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
