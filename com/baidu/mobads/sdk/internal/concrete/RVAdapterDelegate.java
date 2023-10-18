package com.baidu.mobads.sdk.internal.concrete;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a.a;
import com.baidu.mobads.sdk.internal.a.b;
import com.baidu.mobads.sdk.internal.a.c;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes3.dex */
public class RVAdapterDelegate extends RecyclerView.Adapter<RVViewHolderDelegate> implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c a;
    public final b b;

    public RVAdapterDelegate(@NonNull IAdInterListener iAdInterListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iAdInterListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = c.a(iAdInterListener, this);
        registerAdapterDataObserver(new ViewPager2.DataSetChangeObserver(this) { // from class: com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RVAdapterDelegate a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.a.a("onChanged");
                }
            }
        });
        this.b = new b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            Object a = this.a.a("getItemId", Integer.valueOf(i));
            if (a instanceof Integer) {
                return ((Integer) a).intValue();
            }
            return super.getItemId(i);
        }
        return invokeI.longValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            Object a = this.a.a("getItemType", Integer.valueOf(i));
            if (a instanceof Integer) {
                return ((Integer) a).intValue();
            }
            return super.getItemViewType(i);
        }
        return invokeI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@NonNull RVViewHolderDelegate rVViewHolderDelegate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, rVViewHolderDelegate)) == null) {
            Object a = this.a.a("onFailedToRecycleView", rVViewHolderDelegate.getDelegator());
            if (a instanceof Boolean) {
                return ((Boolean) a).booleanValue();
            }
            return super.onFailedToRecycleView((RVAdapterDelegate) rVViewHolderDelegate);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, recyclerView) == null) {
            super.onAttachedToRecyclerView(recyclerView);
            this.a.a("onAttachedToRecyclerView", recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, recyclerView) == null) {
            super.onDetachedFromRecyclerView(recyclerView);
            this.a.a("onDetachedFromRecyclerView", recyclerView);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, obj) == null) {
            this.a.setTarget(obj);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a.getCode();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a.getData();
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a.getDelegator();
        }
        return (IAdInterListener) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Object a = this.a.a("getItemCount", new Object[0]);
            if (!(a instanceof Integer)) {
                return 0;
            }
            return ((Integer) a).intValue();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a.getMessage();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a.getTarget();
        }
        return invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a.getType();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, str, str2, objArr)) == null) {
            if ("notifyItemChanged".equals(str2)) {
                notifyItemChanged(this.b.a(objArr, 0, 0), this.b.a(objArr, 1, (Object) null));
            } else if ("notifyRangeInserted".equals(str2)) {
                notifyItemRangeInserted(this.b.a(objArr, 0, 0), this.b.a(objArr, 1, 0));
            } else if ("notifyRangeRemoved".equals(str2)) {
                notifyItemRangeRemoved(this.b.a(objArr, 0, 0), this.b.a(objArr, 1, 0));
            } else if ("notifyItemRangeChanged".equals(str2)) {
                notifyItemRangeChanged(this.b.a(objArr, 0, 0), this.b.a(objArr, 1, 0));
            } else if ("notifyDataSetChanged".equals(str2)) {
                notifyDataSetChanged();
            }
            return null;
        }
        return invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RVViewHolderDelegate rVViewHolderDelegate, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, rVViewHolderDelegate, i) == null) {
            this.a.a("onBindViewHolder", rVViewHolderDelegate.getDelegator(), Integer.valueOf(i));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RVViewHolderDelegate onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, viewGroup, i)) == null) {
            Object a = this.a.a("onCreateViewHolder", viewGroup, Integer.valueOf(i));
            if (a instanceof RVViewHolderDelegate) {
                return (RVViewHolderDelegate) a;
            }
            return new RVViewHolderDelegate(this, this.a.getDelegator(), viewGroup) { // from class: com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RVAdapterDelegate a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, viewGroup);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r9, viewGroup};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((IAdInterListener) objArr2[0], (View) objArr2[1]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }
            };
        }
        return (RVViewHolderDelegate) invokeLI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RVViewHolderDelegate rVViewHolderDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, rVViewHolderDelegate) == null) {
            super.onViewAttachedToWindow((RVAdapterDelegate) rVViewHolderDelegate);
            this.a.a("onViewAttachedToWindow", rVViewHolderDelegate.getDelegator());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull RVViewHolderDelegate rVViewHolderDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, rVViewHolderDelegate) == null) {
            super.onViewDetachedFromWindow((RVAdapterDelegate) rVViewHolderDelegate);
            this.a.a("onViewDetachedFromWindow", rVViewHolderDelegate.getDelegator());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull RVViewHolderDelegate rVViewHolderDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, rVViewHolderDelegate) == null) {
            super.onViewRecycled((RVAdapterDelegate) rVViewHolderDelegate);
            this.a.a("onViewRecycled", rVViewHolderDelegate.getDelegator());
        }
    }
}
