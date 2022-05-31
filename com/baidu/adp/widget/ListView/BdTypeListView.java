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
import com.repackage.cn;
import com.repackage.dn;
import com.repackage.jn;
import com.repackage.pn;
import com.repackage.wm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeListView extends BdListView implements pn<BdTypeListView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TypeAdapter G;
    public HashMap<BdUniqueId, wm> H;
    public HashMap<BdUniqueId, dn> I;

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

    public jn G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.G.getItem(i) : (jn) invokeI.objValue;
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

    @Override // com.repackage.pn
    public void a(List<wm> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            for (wm<jn, TypeAdapter.ViewHolder> wmVar : list) {
                if (wmVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (wmVar.y() != null) {
                        bdUniqueId = wmVar.y();
                        if (!this.I.containsKey(bdUniqueId)) {
                            dn dnVar = new dn(wmVar.a, bdUniqueId, wmVar.e);
                            dnVar.b0(wmVar);
                            this.G.a(dnVar);
                            this.I.put(bdUniqueId, dnVar);
                        }
                    }
                    if (wmVar.w() != null) {
                        bdUniqueId = wmVar.w();
                        if (!this.I.containsKey(bdUniqueId)) {
                            dn dnVar2 = new dn(wmVar.a, bdUniqueId, wmVar.e);
                            dnVar2.b0(wmVar);
                            this.G.a(dnVar2);
                            this.I.put(bdUniqueId, dnVar2);
                        }
                    }
                    if (wmVar.x() != null) {
                        bdUniqueId = wmVar.x();
                        if (!this.I.containsKey(bdUniqueId)) {
                            dn dnVar3 = new dn(wmVar.a, bdUniqueId, wmVar.e);
                            dnVar3.b0(wmVar);
                            this.G.a(dnVar3);
                            this.I.put(bdUniqueId, dnVar3);
                        }
                    }
                    if (wmVar.v() != null) {
                        bdUniqueId = wmVar.v();
                        if (!this.I.containsKey(bdUniqueId)) {
                            dn dnVar4 = new dn(wmVar.a, bdUniqueId, wmVar.e);
                            dnVar4.b0(wmVar);
                            this.G.a(dnVar4);
                            this.I.put(bdUniqueId, dnVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.G.a(wmVar);
                    } else {
                        this.H.put(wmVar.d, wmVar);
                    }
                }
            }
            setAdapter((ListAdapter) this.G);
        }
    }

    @Override // com.repackage.pn
    public List<jn> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.G.d() : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeListView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdListView, com.repackage.ln
    /* renamed from: getListView */
    public BdListView getListView2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (BdTypeListView) invokeV.objValue;
    }

    @Override // com.repackage.pn
    public void setData(List<? extends jn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (jn jnVar : list) {
                if (jnVar != null) {
                    if (this.H.containsKey(jnVar.getType())) {
                        wm wmVar = this.H.get(jnVar.getType());
                        if (wmVar.y() != null) {
                            cn cnVar = new cn();
                            cnVar.i(wmVar.y());
                            if (jnVar instanceof BaseCardInfo) {
                                cnVar.position = ((BaseCardInfo) jnVar).position;
                                cnVar.setSupportType(BaseCardInfo.SupportType.TOP);
                            }
                            cnVar.g(jnVar);
                            arrayList.add(cnVar);
                        }
                        if (wmVar.w() != null) {
                            cn cnVar2 = new cn();
                            cnVar2.i(wmVar.w());
                            if (jnVar instanceof BaseCardInfo) {
                                cnVar2.position = ((BaseCardInfo) jnVar).position;
                                cnVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            }
                            cnVar2.g(jnVar);
                            arrayList.add(cnVar2);
                        }
                        if (wmVar.x() != null) {
                            cn cnVar3 = new cn();
                            cnVar3.i(wmVar.x());
                            if (jnVar instanceof BaseCardInfo) {
                                cnVar3.position = ((BaseCardInfo) jnVar).position;
                                cnVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            }
                            cnVar3.g(jnVar);
                            arrayList.add(cnVar3);
                        }
                        if (wmVar.v() != null) {
                            cn cnVar4 = new cn();
                            cnVar4.i(wmVar.v());
                            if (jnVar instanceof BaseCardInfo) {
                                cnVar4.position = ((BaseCardInfo) jnVar).position;
                                cnVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                            }
                            cnVar4.g(jnVar);
                            arrayList.add(cnVar4);
                        }
                    } else {
                        arrayList.add(jnVar);
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
