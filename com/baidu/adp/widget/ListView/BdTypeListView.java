package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.eo;
import com.baidu.tieba.ko;
import com.baidu.tieba.rn;
import com.baidu.tieba.xn;
import com.baidu.tieba.yn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeListView extends BdListView implements ko {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TypeAdapter G;
    public HashMap H;
    public HashMap I;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeListView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdListView, com.baidu.tieba.go
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
        public void onItemClick(AdapterView adapterView, View view2, int i, long j) {
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
        public boolean onItemLongClick(AdapterView adapterView, View view2, int i, long j) {
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

    public eo G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return this.G.getItem(i);
        }
        return (eo) invokeI.objValue;
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.G == null) {
                this.G = new TypeAdapter();
            }
            if (this.H == null) {
                this.H = new HashMap();
            }
            if (this.I == null) {
                this.I = new HashMap();
            }
            super.setOnItemClickListener(new a(this));
            super.setOnItemLongClickListener(new b(this));
        }
    }

    @Override // com.baidu.tieba.ko
    public void a(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                rn rnVar = (rn) it.next();
                if (rnVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (rnVar.getHeaderId() != null) {
                        bdUniqueId = rnVar.getHeaderId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            yn ynVar = new yn(rnVar.mContext, bdUniqueId, rnVar.mPageId);
                            ynVar.u(rnVar);
                            this.G.a(ynVar);
                            this.I.put(bdUniqueId, ynVar);
                        }
                    }
                    if (rnVar.getContentId() != null) {
                        bdUniqueId = rnVar.getContentId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            yn ynVar2 = new yn(rnVar.mContext, bdUniqueId, rnVar.mPageId);
                            ynVar2.u(rnVar);
                            this.G.a(ynVar2);
                            this.I.put(bdUniqueId, ynVar2);
                        }
                    }
                    if (rnVar.getExtendId() != null) {
                        bdUniqueId = rnVar.getExtendId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            yn ynVar3 = new yn(rnVar.mContext, bdUniqueId, rnVar.mPageId);
                            ynVar3.u(rnVar);
                            this.G.a(ynVar3);
                            this.I.put(bdUniqueId, ynVar3);
                        }
                    }
                    if (rnVar.getBottomId() != null) {
                        bdUniqueId = rnVar.getBottomId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            yn ynVar4 = new yn(rnVar.mContext, bdUniqueId, rnVar.mPageId);
                            ynVar4.u(rnVar);
                            this.G.a(ynVar4);
                            this.I.put(bdUniqueId, ynVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.G.a(rnVar);
                    } else {
                        this.H.put(rnVar.mType, rnVar);
                    }
                }
            }
            setAdapter((ListAdapter) this.G);
        }
    }

    @Override // com.baidu.tieba.ko
    public void setData(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                eo eoVar = (eo) it.next();
                if (eoVar != null) {
                    if (this.H.containsKey(eoVar.getType())) {
                        rn rnVar = (rn) this.H.get(eoVar.getType());
                        if (rnVar.getHeaderId() != null) {
                            xn xnVar = new xn();
                            xnVar.h(rnVar.getHeaderId());
                            if (eoVar instanceof BaseCardInfo) {
                                xnVar.position = ((BaseCardInfo) eoVar).position;
                                xnVar.setSupportType(BaseCardInfo.SupportType.TOP);
                            }
                            xnVar.f(eoVar);
                            arrayList.add(xnVar);
                        }
                        if (rnVar.getContentId() != null) {
                            xn xnVar2 = new xn();
                            xnVar2.h(rnVar.getContentId());
                            if (eoVar instanceof BaseCardInfo) {
                                xnVar2.position = ((BaseCardInfo) eoVar).position;
                                xnVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            }
                            xnVar2.f(eoVar);
                            arrayList.add(xnVar2);
                        }
                        if (rnVar.getExtendId() != null) {
                            xn xnVar3 = new xn();
                            xnVar3.h(rnVar.getExtendId());
                            if (eoVar instanceof BaseCardInfo) {
                                xnVar3.position = ((BaseCardInfo) eoVar).position;
                                xnVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            }
                            xnVar3.f(eoVar);
                            arrayList.add(xnVar3);
                        }
                        if (rnVar.getBottomId() != null) {
                            xn xnVar4 = new xn();
                            xnVar4.h(rnVar.getBottomId());
                            if (eoVar instanceof BaseCardInfo) {
                                xnVar4.position = ((BaseCardInfo) eoVar).position;
                                xnVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                            }
                            xnVar4.f(eoVar);
                            arrayList.add(xnVar4);
                        }
                    } else {
                        arrayList.add(eoVar);
                    }
                }
            }
            this.G.h(arrayList);
        }
    }

    @Override // com.baidu.tieba.ko
    public List getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.G.d();
        }
        return (List) invokeV.objValue;
    }
}
