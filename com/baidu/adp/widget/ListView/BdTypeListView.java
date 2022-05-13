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
import com.repackage.eo;
import com.repackage.ko;
import com.repackage.lo;
import com.repackage.ro;
import com.repackage.xo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeListView extends BdListView implements xo<BdTypeListView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TypeAdapter G;
    public HashMap<BdUniqueId, eo> H;
    public HashMap<BdUniqueId, lo> I;

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

    public ro G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.G.getItem(i) : (ro) invokeI.objValue;
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

    @Override // com.repackage.xo
    public void a(List<eo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            for (eo<ro, TypeAdapter.ViewHolder> eoVar : list) {
                if (eoVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (eoVar.y() != null) {
                        bdUniqueId = eoVar.y();
                        if (!this.I.containsKey(bdUniqueId)) {
                            lo loVar = new lo(eoVar.a, bdUniqueId, eoVar.e);
                            loVar.b0(eoVar);
                            this.G.a(loVar);
                            this.I.put(bdUniqueId, loVar);
                        }
                    }
                    if (eoVar.w() != null) {
                        bdUniqueId = eoVar.w();
                        if (!this.I.containsKey(bdUniqueId)) {
                            lo loVar2 = new lo(eoVar.a, bdUniqueId, eoVar.e);
                            loVar2.b0(eoVar);
                            this.G.a(loVar2);
                            this.I.put(bdUniqueId, loVar2);
                        }
                    }
                    if (eoVar.x() != null) {
                        bdUniqueId = eoVar.x();
                        if (!this.I.containsKey(bdUniqueId)) {
                            lo loVar3 = new lo(eoVar.a, bdUniqueId, eoVar.e);
                            loVar3.b0(eoVar);
                            this.G.a(loVar3);
                            this.I.put(bdUniqueId, loVar3);
                        }
                    }
                    if (eoVar.v() != null) {
                        bdUniqueId = eoVar.v();
                        if (!this.I.containsKey(bdUniqueId)) {
                            lo loVar4 = new lo(eoVar.a, bdUniqueId, eoVar.e);
                            loVar4.b0(eoVar);
                            this.G.a(loVar4);
                            this.I.put(bdUniqueId, loVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.G.a(eoVar);
                    } else {
                        this.H.put(eoVar.d, eoVar);
                    }
                }
            }
            setAdapter((ListAdapter) this.G);
        }
    }

    @Override // com.repackage.xo
    public List<ro> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.G.d() : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeListView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdListView, com.repackage.to
    /* renamed from: getListView */
    public BdListView getListView2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (BdTypeListView) invokeV.objValue;
    }

    @Override // com.repackage.xo
    public void setData(List<? extends ro> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (ro roVar : list) {
                if (roVar != null) {
                    if (this.H.containsKey(roVar.getType())) {
                        eo eoVar = this.H.get(roVar.getType());
                        if (eoVar.y() != null) {
                            ko koVar = new ko();
                            koVar.i(eoVar.y());
                            if (roVar instanceof BaseCardInfo) {
                                koVar.position = ((BaseCardInfo) roVar).position;
                                koVar.setSupportType(BaseCardInfo.SupportType.TOP);
                            }
                            koVar.g(roVar);
                            arrayList.add(koVar);
                        }
                        if (eoVar.w() != null) {
                            ko koVar2 = new ko();
                            koVar2.i(eoVar.w());
                            if (roVar instanceof BaseCardInfo) {
                                koVar2.position = ((BaseCardInfo) roVar).position;
                                koVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            }
                            koVar2.g(roVar);
                            arrayList.add(koVar2);
                        }
                        if (eoVar.x() != null) {
                            ko koVar3 = new ko();
                            koVar3.i(eoVar.x());
                            if (roVar instanceof BaseCardInfo) {
                                koVar3.position = ((BaseCardInfo) roVar).position;
                                koVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            }
                            koVar3.g(roVar);
                            arrayList.add(koVar3);
                        }
                        if (eoVar.v() != null) {
                            ko koVar4 = new ko();
                            koVar4.i(eoVar.v());
                            if (roVar instanceof BaseCardInfo) {
                                koVar4.position = ((BaseCardInfo) roVar).position;
                                koVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                            }
                            koVar4.g(roVar);
                            arrayList.add(koVar4);
                        }
                    } else {
                        arrayList.add(roVar);
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
