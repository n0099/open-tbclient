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
import com.repackage.an;
import com.repackage.gn;
import com.repackage.hn;
import com.repackage.nn;
import com.repackage.tn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeListView extends BdListView implements tn<BdTypeListView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TypeAdapter G;
    public HashMap<BdUniqueId, an> H;
    public HashMap<BdUniqueId, hn> I;

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

    public nn G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.G.getItem(i) : (nn) invokeI.objValue;
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

    @Override // com.repackage.tn
    public void a(List<an> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            for (an<nn, TypeAdapter.ViewHolder> anVar : list) {
                if (anVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (anVar.x() != null) {
                        bdUniqueId = anVar.x();
                        if (!this.I.containsKey(bdUniqueId)) {
                            hn hnVar = new hn(anVar.a, bdUniqueId, anVar.e);
                            hnVar.b0(anVar);
                            this.G.a(hnVar);
                            this.I.put(bdUniqueId, hnVar);
                        }
                    }
                    if (anVar.v() != null) {
                        bdUniqueId = anVar.v();
                        if (!this.I.containsKey(bdUniqueId)) {
                            hn hnVar2 = new hn(anVar.a, bdUniqueId, anVar.e);
                            hnVar2.b0(anVar);
                            this.G.a(hnVar2);
                            this.I.put(bdUniqueId, hnVar2);
                        }
                    }
                    if (anVar.w() != null) {
                        bdUniqueId = anVar.w();
                        if (!this.I.containsKey(bdUniqueId)) {
                            hn hnVar3 = new hn(anVar.a, bdUniqueId, anVar.e);
                            hnVar3.b0(anVar);
                            this.G.a(hnVar3);
                            this.I.put(bdUniqueId, hnVar3);
                        }
                    }
                    if (anVar.u() != null) {
                        bdUniqueId = anVar.u();
                        if (!this.I.containsKey(bdUniqueId)) {
                            hn hnVar4 = new hn(anVar.a, bdUniqueId, anVar.e);
                            hnVar4.b0(anVar);
                            this.G.a(hnVar4);
                            this.I.put(bdUniqueId, hnVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.G.a(anVar);
                    } else {
                        this.H.put(anVar.d, anVar);
                    }
                }
            }
            setAdapter((ListAdapter) this.G);
        }
    }

    @Override // com.repackage.tn
    public List<nn> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.G.d() : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeListView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdListView, com.repackage.pn
    /* renamed from: getListView */
    public BdListView getListView2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (BdTypeListView) invokeV.objValue;
    }

    @Override // com.repackage.tn
    public void setData(List<? extends nn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (nn nnVar : list) {
                if (nnVar != null) {
                    if (this.H.containsKey(nnVar.getType())) {
                        an anVar = this.H.get(nnVar.getType());
                        if (anVar.x() != null) {
                            gn gnVar = new gn();
                            gnVar.g(anVar.x());
                            if (nnVar instanceof BaseCardInfo) {
                                gnVar.position = ((BaseCardInfo) nnVar).position;
                                gnVar.setSupportType(BaseCardInfo.SupportType.TOP);
                            }
                            gnVar.d(nnVar);
                            arrayList.add(gnVar);
                        }
                        if (anVar.v() != null) {
                            gn gnVar2 = new gn();
                            gnVar2.g(anVar.v());
                            if (nnVar instanceof BaseCardInfo) {
                                gnVar2.position = ((BaseCardInfo) nnVar).position;
                                gnVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            }
                            gnVar2.d(nnVar);
                            arrayList.add(gnVar2);
                        }
                        if (anVar.w() != null) {
                            gn gnVar3 = new gn();
                            gnVar3.g(anVar.w());
                            if (nnVar instanceof BaseCardInfo) {
                                gnVar3.position = ((BaseCardInfo) nnVar).position;
                                gnVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            }
                            gnVar3.d(nnVar);
                            arrayList.add(gnVar3);
                        }
                        if (anVar.u() != null) {
                            gn gnVar4 = new gn();
                            gnVar4.g(anVar.u());
                            if (nnVar instanceof BaseCardInfo) {
                                gnVar4.position = ((BaseCardInfo) nnVar).position;
                                gnVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                            }
                            gnVar4.d(nnVar);
                            arrayList.add(gnVar4);
                        }
                    } else {
                        arrayList.add(nnVar);
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
