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
import com.baidu.tieba.Cdo;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.kn;
import com.baidu.tieba.qn;
import com.baidu.tieba.rn;
import com.baidu.tieba.xn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeListView extends BdListView implements Cdo<BdTypeListView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TypeAdapter G;
    public HashMap<BdUniqueId, kn> H;
    public HashMap<BdUniqueId, rn> I;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeListView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdListView, com.baidu.tieba.zn
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

    public xn G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return this.G.getItem(i);
        }
        return (xn) invokeI.objValue;
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

    @Override // com.baidu.tieba.Cdo
    public void a(List<kn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            for (kn<xn, TypeAdapter.ViewHolder> knVar : list) {
                if (knVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (knVar.getHeaderId() != null) {
                        bdUniqueId = knVar.getHeaderId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            rn rnVar = new rn(knVar.mContext, bdUniqueId, knVar.mPageId);
                            rnVar.u(knVar);
                            this.G.a(rnVar);
                            this.I.put(bdUniqueId, rnVar);
                        }
                    }
                    if (knVar.getContentId() != null) {
                        bdUniqueId = knVar.getContentId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            rn rnVar2 = new rn(knVar.mContext, bdUniqueId, knVar.mPageId);
                            rnVar2.u(knVar);
                            this.G.a(rnVar2);
                            this.I.put(bdUniqueId, rnVar2);
                        }
                    }
                    if (knVar.getExtendId() != null) {
                        bdUniqueId = knVar.getExtendId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            rn rnVar3 = new rn(knVar.mContext, bdUniqueId, knVar.mPageId);
                            rnVar3.u(knVar);
                            this.G.a(rnVar3);
                            this.I.put(bdUniqueId, rnVar3);
                        }
                    }
                    if (knVar.getBottomId() != null) {
                        bdUniqueId = knVar.getBottomId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            rn rnVar4 = new rn(knVar.mContext, bdUniqueId, knVar.mPageId);
                            rnVar4.u(knVar);
                            this.G.a(rnVar4);
                            this.I.put(bdUniqueId, rnVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.G.a(knVar);
                    } else {
                        this.H.put(knVar.mType, knVar);
                    }
                }
            }
            setAdapter((ListAdapter) this.G);
        }
    }

    @Override // com.baidu.tieba.Cdo
    public void setData(List<? extends xn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (xn xnVar : list) {
                if (xnVar != null) {
                    if (this.H.containsKey(xnVar.getType())) {
                        kn knVar = this.H.get(xnVar.getType());
                        if (knVar.getHeaderId() != null) {
                            qn qnVar = new qn();
                            qnVar.g(knVar.getHeaderId());
                            if (xnVar instanceof BaseCardInfo) {
                                qnVar.position = ((BaseCardInfo) xnVar).position;
                                qnVar.setSupportType(BaseCardInfo.SupportType.TOP);
                            }
                            qnVar.f(xnVar);
                            arrayList.add(qnVar);
                        }
                        if (knVar.getContentId() != null) {
                            qn qnVar2 = new qn();
                            qnVar2.g(knVar.getContentId());
                            if (xnVar instanceof BaseCardInfo) {
                                qnVar2.position = ((BaseCardInfo) xnVar).position;
                                qnVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            }
                            qnVar2.f(xnVar);
                            arrayList.add(qnVar2);
                        }
                        if (knVar.getExtendId() != null) {
                            qn qnVar3 = new qn();
                            qnVar3.g(knVar.getExtendId());
                            if (xnVar instanceof BaseCardInfo) {
                                qnVar3.position = ((BaseCardInfo) xnVar).position;
                                qnVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            }
                            qnVar3.f(xnVar);
                            arrayList.add(qnVar3);
                        }
                        if (knVar.getBottomId() != null) {
                            qn qnVar4 = new qn();
                            qnVar4.g(knVar.getBottomId());
                            if (xnVar instanceof BaseCardInfo) {
                                qnVar4.position = ((BaseCardInfo) xnVar).position;
                                qnVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                            }
                            qnVar4.f(xnVar);
                            arrayList.add(qnVar4);
                        }
                    } else {
                        arrayList.add(xnVar);
                    }
                }
            }
            this.G.h(arrayList);
        }
    }

    @Override // com.baidu.tieba.Cdo
    public List<xn> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.G.d();
        }
        return (List) invokeV.objValue;
    }
}
