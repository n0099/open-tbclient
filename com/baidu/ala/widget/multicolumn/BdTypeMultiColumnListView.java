package com.baidu.ala.widget.multicolumn;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cn;
import com.baidu.tieba.pm;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huewu.pla.lib.internal.PLA_AdapterView;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class BdTypeMultiColumnListView extends BdMultiColumnListView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TypeAdapter mTypeAdapter;

    @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView, com.huewu.pla.lib.internal.PLA_AdapterView
    @Deprecated
    public void setOnItemClickListener(PLA_AdapterView.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
        }
    }

    @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView, com.huewu.pla.lib.internal.PLA_AdapterView
    @Deprecated
    public void setOnItemLongClickListener(PLA_AdapterView.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdTypeMultiColumnListView(Context context) {
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
        this.mTypeAdapter = null;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdTypeMultiColumnListView(Context context, AttributeSet attributeSet) {
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
        this.mTypeAdapter = null;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdTypeMultiColumnListView(Context context, AttributeSet attributeSet, int i) {
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
        this.mTypeAdapter = null;
        init();
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (this.mTypeAdapter == null) {
                this.mTypeAdapter = new TypeAdapter();
            }
            super.setOnItemClickListener(new PLA_AdapterView.d(this) { // from class: com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BdTypeMultiColumnListView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.huewu.pla.lib.internal.PLA_AdapterView.d
                public void onItemClick(PLA_AdapterView<?> pLA_AdapterView, View view2, int i, long j) {
                    TypeAdapter typeAdapter;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{pLA_AdapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && (typeAdapter = this.this$0.mTypeAdapter) != null) {
                        typeAdapter.e(pLA_AdapterView, view2, i, j);
                    }
                }
            });
            super.setOnItemLongClickListener(new PLA_AdapterView.e(this) { // from class: com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BdTypeMultiColumnListView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.huewu.pla.lib.internal.PLA_AdapterView.e
                public boolean onItemLongClick(PLA_AdapterView<?> pLA_AdapterView, View view2, int i, long j) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{pLA_AdapterView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                        TypeAdapter typeAdapter = this.this$0.mTypeAdapter;
                        if (typeAdapter != null) {
                            return typeAdapter.f(pLA_AdapterView, view2, i, j);
                        }
                        return false;
                    }
                    return invokeCommon.booleanValue;
                }
            });
        }
    }

    public List<cn> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mTypeAdapter.c();
        }
        return (List) invokeV.objValue;
    }

    public void addAdapters(List<pm> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            Iterator<pm> it = list.iterator();
            while (it.hasNext()) {
                this.mTypeAdapter.a(it.next());
            }
            setAdapter((ListAdapter) this.mTypeAdapter);
        }
    }

    public cn getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return this.mTypeAdapter.getItem(i);
        }
        return (cn) invokeI.objValue;
    }

    public void setData(List<? extends cn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.mTypeAdapter.i(list);
        }
    }
}
