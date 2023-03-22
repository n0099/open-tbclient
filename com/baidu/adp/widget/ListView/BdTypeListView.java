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
import com.baidu.tieba.an;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.gn;
import com.baidu.tieba.mn;
import com.baidu.tieba.tm;
import com.baidu.tieba.zm;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeListView extends BdListView implements mn<BdTypeListView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TypeAdapter G;
    public HashMap<BdUniqueId, tm> H;
    public HashMap<BdUniqueId, an> I;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeListView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdListView, com.baidu.tieba.in
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
        G();
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
        G();
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
        G();
    }

    public gn F(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return this.G.getItem(i);
        }
        return (gn) invokeI.objValue;
    }

    public final void G() {
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

    @Override // com.baidu.tieba.mn
    public void addAdapters(List<tm> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            for (tm<gn, TypeAdapter.ViewHolder> tmVar : list) {
                if (tmVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (tmVar.getHeaderId() != null) {
                        bdUniqueId = tmVar.getHeaderId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            an anVar = new an(tmVar.mContext, bdUniqueId, tmVar.mPageId);
                            anVar.u(tmVar);
                            this.G.a(anVar);
                            this.I.put(bdUniqueId, anVar);
                        }
                    }
                    if (tmVar.getContentId() != null) {
                        bdUniqueId = tmVar.getContentId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            an anVar2 = new an(tmVar.mContext, bdUniqueId, tmVar.mPageId);
                            anVar2.u(tmVar);
                            this.G.a(anVar2);
                            this.I.put(bdUniqueId, anVar2);
                        }
                    }
                    if (tmVar.getExtendId() != null) {
                        bdUniqueId = tmVar.getExtendId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            an anVar3 = new an(tmVar.mContext, bdUniqueId, tmVar.mPageId);
                            anVar3.u(tmVar);
                            this.G.a(anVar3);
                            this.I.put(bdUniqueId, anVar3);
                        }
                    }
                    if (tmVar.getBottomId() != null) {
                        bdUniqueId = tmVar.getBottomId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            an anVar4 = new an(tmVar.mContext, bdUniqueId, tmVar.mPageId);
                            anVar4.u(tmVar);
                            this.G.a(anVar4);
                            this.I.put(bdUniqueId, anVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.G.a(tmVar);
                    } else {
                        this.H.put(tmVar.mType, tmVar);
                    }
                }
            }
            setAdapter((ListAdapter) this.G);
        }
    }

    @Override // com.baidu.tieba.mn
    public void setData(List<? extends gn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (gn gnVar : list) {
                if (gnVar != null) {
                    if (this.H.containsKey(gnVar.getType())) {
                        tm tmVar = this.H.get(gnVar.getType());
                        if (tmVar.getHeaderId() != null) {
                            zm zmVar = new zm();
                            zmVar.g(tmVar.getHeaderId());
                            if (gnVar instanceof BaseCardInfo) {
                                zmVar.position = ((BaseCardInfo) gnVar).position;
                                zmVar.setSupportType(BaseCardInfo.SupportType.TOP);
                            }
                            zmVar.f(gnVar);
                            arrayList.add(zmVar);
                        }
                        if (tmVar.getContentId() != null) {
                            zm zmVar2 = new zm();
                            zmVar2.g(tmVar.getContentId());
                            if (gnVar instanceof BaseCardInfo) {
                                zmVar2.position = ((BaseCardInfo) gnVar).position;
                                zmVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            }
                            zmVar2.f(gnVar);
                            arrayList.add(zmVar2);
                        }
                        if (tmVar.getExtendId() != null) {
                            zm zmVar3 = new zm();
                            zmVar3.g(tmVar.getExtendId());
                            if (gnVar instanceof BaseCardInfo) {
                                zmVar3.position = ((BaseCardInfo) gnVar).position;
                                zmVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            }
                            zmVar3.f(gnVar);
                            arrayList.add(zmVar3);
                        }
                        if (tmVar.getBottomId() != null) {
                            zm zmVar4 = new zm();
                            zmVar4.g(tmVar.getBottomId());
                            if (gnVar instanceof BaseCardInfo) {
                                zmVar4.position = ((BaseCardInfo) gnVar).position;
                                zmVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                            }
                            zmVar4.f(gnVar);
                            arrayList.add(zmVar4);
                        }
                    } else {
                        arrayList.add(gnVar);
                    }
                }
            }
            this.G.h(arrayList);
        }
    }

    @Override // com.baidu.tieba.mn
    public List<gn> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.G.d();
        }
        return (List) invokeV.objValue;
    }
}
