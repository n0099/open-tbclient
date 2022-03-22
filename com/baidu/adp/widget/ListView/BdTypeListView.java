package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.g;
import c.a.d.o.e.h;
import c.a.d.o.e.n;
import c.a.d.o.e.s;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class BdTypeListView extends BdListView implements s<BdTypeListView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TypeAdapter G;
    public HashMap<BdUniqueId, c.a.d.o.e.a> H;
    public HashMap<BdUniqueId, h> I;

    /* loaded from: classes3.dex */
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
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TypeAdapter typeAdapter;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) || (typeAdapter = this.a.G) == null) {
                return;
            }
            typeAdapter.f(adapterView, view, i, j);
        }
    }

    /* loaded from: classes3.dex */
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
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                TypeAdapter typeAdapter = this.a.G;
                if (typeAdapter != null) {
                    return typeAdapter.g(adapterView, view, i, j);
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

    public n G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.G.getItem(i) : (n) invokeI.objValue;
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

    @Override // c.a.d.o.e.s
    public void a(List<c.a.d.o.e.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            for (c.a.d.o.e.a<n, TypeAdapter.ViewHolder> aVar : list) {
                if (aVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (aVar.y() != null) {
                        bdUniqueId = aVar.y();
                        if (!this.I.containsKey(bdUniqueId)) {
                            h hVar = new h(aVar.a, bdUniqueId, aVar.f2571e);
                            hVar.b0(aVar);
                            this.G.a(hVar);
                            this.I.put(bdUniqueId, hVar);
                        }
                    }
                    if (aVar.w() != null) {
                        bdUniqueId = aVar.w();
                        if (!this.I.containsKey(bdUniqueId)) {
                            h hVar2 = new h(aVar.a, bdUniqueId, aVar.f2571e);
                            hVar2.b0(aVar);
                            this.G.a(hVar2);
                            this.I.put(bdUniqueId, hVar2);
                        }
                    }
                    if (aVar.x() != null) {
                        bdUniqueId = aVar.x();
                        if (!this.I.containsKey(bdUniqueId)) {
                            h hVar3 = new h(aVar.a, bdUniqueId, aVar.f2571e);
                            hVar3.b0(aVar);
                            this.G.a(hVar3);
                            this.I.put(bdUniqueId, hVar3);
                        }
                    }
                    if (aVar.v() != null) {
                        bdUniqueId = aVar.v();
                        if (!this.I.containsKey(bdUniqueId)) {
                            h hVar4 = new h(aVar.a, bdUniqueId, aVar.f2571e);
                            hVar4.b0(aVar);
                            this.G.a(hVar4);
                            this.I.put(bdUniqueId, hVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.G.a(aVar);
                    } else {
                        this.H.put(aVar.f2570d, aVar);
                    }
                }
            }
            setAdapter((ListAdapter) this.G);
        }
    }

    @Override // c.a.d.o.e.s
    public List<n> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.G.d() : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeListView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdListView, c.a.d.o.e.p
    /* renamed from: getListView */
    public BdListView getListView2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (BdTypeListView) invokeV.objValue;
    }

    @Override // c.a.d.o.e.s
    public void setData(List<? extends n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (n nVar : list) {
                if (nVar != null) {
                    if (this.H.containsKey(nVar.getType())) {
                        c.a.d.o.e.a aVar = this.H.get(nVar.getType());
                        if (aVar.y() != null) {
                            g gVar = new g();
                            gVar.i(aVar.y());
                            if (nVar instanceof BaseCardInfo) {
                                gVar.position = ((BaseCardInfo) nVar).position;
                                gVar.setSupportType(BaseCardInfo.SupportType.TOP);
                            }
                            gVar.g(nVar);
                            arrayList.add(gVar);
                        }
                        if (aVar.w() != null) {
                            g gVar2 = new g();
                            gVar2.i(aVar.w());
                            if (nVar instanceof BaseCardInfo) {
                                gVar2.position = ((BaseCardInfo) nVar).position;
                                gVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            }
                            gVar2.g(nVar);
                            arrayList.add(gVar2);
                        }
                        if (aVar.x() != null) {
                            g gVar3 = new g();
                            gVar3.i(aVar.x());
                            if (nVar instanceof BaseCardInfo) {
                                gVar3.position = ((BaseCardInfo) nVar).position;
                                gVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            }
                            gVar3.g(nVar);
                            arrayList.add(gVar3);
                        }
                        if (aVar.v() != null) {
                            g gVar4 = new g();
                            gVar4.i(aVar.v());
                            if (nVar instanceof BaseCardInfo) {
                                gVar4.position = ((BaseCardInfo) nVar).position;
                                gVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                            }
                            gVar4.g(nVar);
                            arrayList.add(gVar4);
                        }
                    } else {
                        arrayList.add(nVar);
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
