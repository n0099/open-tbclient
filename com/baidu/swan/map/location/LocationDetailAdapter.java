package com.baidu.swan.map.location;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.s44;
import com.repackage.t44;
import java.util.List;
/* loaded from: classes2.dex */
public class LocationDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public RecyclerView b;
    public List<t44> c;
    public s44 d;
    public boolean e;
    public String f;

    public LocationDetailAdapter(Context context, RecyclerView recyclerView, s44 s44Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, recyclerView, s44Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = recyclerView;
        this.a = context;
        this.d = s44Var;
        this.e = z;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.f) : invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            RecyclerView recyclerView = this.b;
            return recyclerView != null && recyclerView.computeVerticalScrollOffset() > 0;
        }
        return invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (t44 t44Var : this.c) {
                t44Var.b = false;
            }
        }
    }

    public void g(List<t44> list, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, list, str) == null) || list == null) {
            return;
        }
        this.c = list;
        this.f = str;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<t44> list = this.c;
            if (list == null) {
                return 0;
            }
            return list.size() + (this.e ? 1 : 0);
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? (!this.e || i < getItemCount() + (-1)) ? 100 : 101 : invokeI.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, viewHolder, i) == null) {
            if (viewHolder.getItemViewType() != 101) {
                ((LocationDetailViewHolder) viewHolder).update(this.c.get(i), this.f, d());
            } else {
                ((LocationFooterViewHolder) viewHolder).b(e());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, viewGroup, i)) == null) {
            if (i != 101) {
                return new LocationDetailViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0084, viewGroup, false), this, this.d);
            }
            return new LocationFooterViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0083, viewGroup, false));
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public void setData(List<t44> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            g(list, null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocationDetailAdapter(Context context, RecyclerView recyclerView, s44 s44Var) {
        this(context, recyclerView, s44Var, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, recyclerView, s44Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (RecyclerView) objArr2[1], (s44) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
