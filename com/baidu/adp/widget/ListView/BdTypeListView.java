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
import com.baidu.tieba.ci;
import com.baidu.tieba.ii;
import com.baidu.tieba.ji;
import com.baidu.tieba.pi;
import com.baidu.tieba.vi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeListView extends BdListView implements vi<BdTypeListView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TypeAdapter G;
    public HashMap<BdUniqueId, ci> H;
    public HashMap<BdUniqueId, ji> I;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.BdTypeListView' to match base method */
    @Override // com.baidu.adp.widget.ListView.BdListView, com.baidu.tieba.ri
    /* renamed from: getListView */
    public BdListView getListView2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this : (BdTypeListView) invokeV.objValue;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    @Deprecated
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onItemClickListener) == null) {
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    @Deprecated
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onItemLongClickListener) == null) {
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
                typeAdapter.e(adapterView, view2, i, j);
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
                    return typeAdapter.f(adapterView, view2, i, j);
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

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            HashMap<BdUniqueId, ji> hashMap = this.I;
            if (hashMap != null) {
                hashMap.clear();
            }
            HashMap<BdUniqueId, ci> hashMap2 = this.H;
            if (hashMap2 != null) {
                hashMap2.clear();
            }
            TypeAdapter typeAdapter = this.G;
            if (typeAdapter != null) {
                typeAdapter.b();
            }
        }
    }

    @Override // com.baidu.tieba.vi
    public List<pi> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.G.c();
        }
        return (List) invokeV.objValue;
    }

    public pi G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return this.G.getItem(i);
        }
        return (pi) invokeI.objValue;
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
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

    @Override // com.baidu.tieba.vi
    public void addAdapters(List<ci> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            for (ci<pi, TypeAdapter.ViewHolder> ciVar : list) {
                if (ciVar != null) {
                    BdUniqueId bdUniqueId = null;
                    if (ciVar.getHeaderId() != null) {
                        bdUniqueId = ciVar.getHeaderId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            ji jiVar = new ji(ciVar.mContext, bdUniqueId, ciVar.mPageId);
                            jiVar.x(ciVar);
                            this.G.a(jiVar);
                            this.I.put(bdUniqueId, jiVar);
                        }
                    }
                    if (ciVar.getContentId() != null) {
                        bdUniqueId = ciVar.getContentId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            ji jiVar2 = new ji(ciVar.mContext, bdUniqueId, ciVar.mPageId);
                            jiVar2.x(ciVar);
                            this.G.a(jiVar2);
                            this.I.put(bdUniqueId, jiVar2);
                        }
                    }
                    if (ciVar.getExtendId() != null) {
                        bdUniqueId = ciVar.getExtendId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            ji jiVar3 = new ji(ciVar.mContext, bdUniqueId, ciVar.mPageId);
                            jiVar3.x(ciVar);
                            this.G.a(jiVar3);
                            this.I.put(bdUniqueId, jiVar3);
                        }
                    }
                    if (ciVar.getBottomId() != null) {
                        bdUniqueId = ciVar.getBottomId();
                        if (!this.I.containsKey(bdUniqueId)) {
                            ji jiVar4 = new ji(ciVar.mContext, bdUniqueId, ciVar.mPageId);
                            jiVar4.x(ciVar);
                            this.G.a(jiVar4);
                            this.I.put(bdUniqueId, jiVar4);
                        }
                    }
                    if (bdUniqueId == null) {
                        this.G.a(ciVar);
                    } else {
                        this.H.put(ciVar.mType, ciVar);
                    }
                }
            }
            setAdapter((ListAdapter) this.G);
        }
    }

    @Override // com.baidu.tieba.vi
    public void setData(List<? extends pi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (pi piVar : list) {
                if (piVar != null) {
                    if (this.H.containsKey(piVar.getType())) {
                        ci ciVar = this.H.get(piVar.getType());
                        if (ciVar.getHeaderId() != null) {
                            ii iiVar = new ii();
                            iiVar.e(ciVar.getHeaderId());
                            if (piVar instanceof BaseCardInfo) {
                                iiVar.position = ((BaseCardInfo) piVar).position;
                                iiVar.setSupportType(BaseCardInfo.SupportType.TOP);
                            }
                            iiVar.d(piVar);
                            arrayList.add(iiVar);
                        }
                        if (ciVar.getContentId() != null) {
                            ii iiVar2 = new ii();
                            iiVar2.e(ciVar.getContentId());
                            if (piVar instanceof BaseCardInfo) {
                                iiVar2.position = ((BaseCardInfo) piVar).position;
                                iiVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            }
                            iiVar2.d(piVar);
                            arrayList.add(iiVar2);
                        }
                        if (ciVar.getExtendId() != null) {
                            ii iiVar3 = new ii();
                            iiVar3.e(ciVar.getExtendId());
                            if (piVar instanceof BaseCardInfo) {
                                iiVar3.position = ((BaseCardInfo) piVar).position;
                                iiVar3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            }
                            iiVar3.d(piVar);
                            arrayList.add(iiVar3);
                        }
                        if (ciVar.getBottomId() != null) {
                            ii iiVar4 = new ii();
                            iiVar4.e(ciVar.getBottomId());
                            if (piVar instanceof BaseCardInfo) {
                                iiVar4.position = ((BaseCardInfo) piVar).position;
                                iiVar4.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                            }
                            iiVar4.d(piVar);
                            arrayList.add(iiVar4);
                        }
                    } else {
                        arrayList.add(piVar);
                    }
                }
            }
            this.G.i(arrayList);
        }
    }
}
