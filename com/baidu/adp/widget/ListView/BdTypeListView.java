package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.e.k.e.g;
import c.a.e.k.e.h;
import c.a.e.k.e.n;
import c.a.e.k.e.s;
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
/* loaded from: classes4.dex */
public class BdTypeListView extends BdListView implements s<BdTypeListView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TypeAdapter K;
    public HashMap<BdUniqueId, c.a.e.k.e.a> L;
    public HashMap<BdUniqueId, h> M;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdTypeListView f36278e;

        public a(BdTypeListView bdTypeListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTypeListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36278e = bdTypeListView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            TypeAdapter typeAdapter;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (typeAdapter = this.f36278e.K) == null) {
                return;
            }
            typeAdapter.d(adapterView, view, i2, j2);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdTypeListView f36279e;

        public b(BdTypeListView bdTypeListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTypeListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36279e = bdTypeListView;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
                TypeAdapter typeAdapter = this.f36279e.K;
                if (typeAdapter != null) {
                    return typeAdapter.e(adapterView, view, i2, j2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.K = null;
        x();
    }

    @Override // c.a.e.k.e.s
    public void addAdapters(List<c.a.e.k.e.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            for (c.a.e.k.e.a<n, TypeAdapter.ViewHolder> aVar : list) {
                if (aVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (aVar.y() != null) {
                        bdUniqueId = aVar.y();
                        if (!this.M.containsKey(bdUniqueId)) {
                            h hVar = new h(aVar.f2904e, bdUniqueId, aVar.f2908i);
                            hVar.j0(aVar);
                            this.K.a(hVar);
                            this.M.put(bdUniqueId, hVar);
                        }
                    }
                    if (aVar.w() != null) {
                        bdUniqueId = aVar.w();
                        if (!this.M.containsKey(bdUniqueId)) {
                            h hVar2 = new h(aVar.f2904e, bdUniqueId, aVar.f2908i);
                            hVar2.j0(aVar);
                            this.K.a(hVar2);
                            this.M.put(bdUniqueId, hVar2);
                        }
                    }
                    if (aVar.x() != null) {
                        bdUniqueId = aVar.x();
                        if (!this.M.containsKey(bdUniqueId)) {
                            h hVar3 = new h(aVar.f2904e, bdUniqueId, aVar.f2908i);
                            hVar3.j0(aVar);
                            this.K.a(hVar3);
                            this.M.put(bdUniqueId, hVar3);
                        }
                    }
                    if (aVar.v() != null) {
                        bdUniqueId = aVar.v();
                        if (!this.M.containsKey(bdUniqueId)) {
                            h hVar4 = new h(aVar.f2904e, bdUniqueId, aVar.f2908i);
                            hVar4.j0(aVar);
                            this.K.a(hVar4);
                            this.M.put(bdUniqueId, hVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.K.a(aVar);
                    } else {
                        this.L.put(aVar.f2907h, aVar);
                    }
                }
            }
            setAdapter((ListAdapter) this.K);
        }
    }

    @Override // c.a.e.k.e.s
    public List<n> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.K.b() : (List) invokeV.objValue;
    }

    public n getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.K.getItem(i2) : (n) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeListView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdListView, c.a.e.k.e.p
    /* renamed from: getListView */
    public BdListView getListView2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (BdTypeListView) invokeV.objValue;
    }

    @Override // c.a.e.k.e.s
    public void setData(List<? extends n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (n nVar : list) {
                if (nVar != null) {
                    if (this.L.containsKey(nVar.getType())) {
                        c.a.e.k.e.a aVar = this.L.get(nVar.getType());
                        if (aVar.y() != null) {
                            g gVar = new g();
                            gVar.k(aVar.y());
                            if (nVar instanceof BaseCardInfo) {
                                gVar.position = ((BaseCardInfo) nVar).position;
                                gVar.setSupportType(BaseCardInfo.SupportType.TOP);
                            }
                            gVar.i(nVar);
                            arrayList.add(gVar);
                        }
                        if (aVar.w() != null) {
                            g gVar2 = new g();
                            gVar2.k(aVar.w());
                            if (nVar instanceof BaseCardInfo) {
                                gVar2.position = ((BaseCardInfo) nVar).position;
                                gVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            }
                            gVar2.i(nVar);
                            arrayList.add(gVar2);
                        }
                        if (aVar.x() != null) {
                            g gVar3 = new g();
                            gVar3.k(aVar.x());
                            if (nVar instanceof BaseCardInfo) {
                                gVar3.position = ((BaseCardInfo) nVar).position;
                                gVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            }
                            gVar3.i(nVar);
                            arrayList.add(gVar3);
                        }
                        if (aVar.v() != null) {
                            g gVar4 = new g();
                            gVar4.k(aVar.v());
                            if (nVar instanceof BaseCardInfo) {
                                gVar4.position = ((BaseCardInfo) nVar).position;
                                gVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                            }
                            gVar4.i(nVar);
                            arrayList.add(gVar4);
                        }
                    } else {
                        arrayList.add(nVar);
                    }
                }
            }
            this.K.f(arrayList);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    @Deprecated
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onItemClickListener) == null) {
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    @Deprecated
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onItemLongClickListener) == null) {
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.K == null) {
                this.K = new TypeAdapter();
            }
            if (this.L == null) {
                this.L = new HashMap<>();
            }
            if (this.M == null) {
                this.M = new HashMap<>();
            }
            super.setOnItemClickListener(new a(this));
            super.setOnItemLongClickListener(new b(this));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.K = null;
        x();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdTypeListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.K = null;
        x();
    }
}
