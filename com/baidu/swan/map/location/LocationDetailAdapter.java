package com.baidu.swan.map.location;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.p0.j.f;
import c.a.p0.j.o.b;
import c.a.p0.j.o.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class LocationDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f47162a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f47163b;

    /* renamed from: c  reason: collision with root package name */
    public List<c> f47164c;

    /* renamed from: d  reason: collision with root package name */
    public b f47165d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47166e;

    /* renamed from: f  reason: collision with root package name */
    public String f47167f;

    public LocationDetailAdapter(Context context, RecyclerView recyclerView, b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, recyclerView, bVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47163b = recyclerView;
        this.f47162a = context;
        this.f47165d = bVar;
        this.f47166e = z;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.f47167f) : invokeV.booleanValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            RecyclerView recyclerView = this.f47163b;
            return recyclerView != null && recyclerView.computeVerticalScrollOffset() > 0;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<c> list = this.f47164c;
            if (list == null) {
                return 0;
            }
            return list.size() + (this.f47166e ? 1 : 0);
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? (!this.f47166e || i2 < getItemCount() + (-1)) ? 100 : 101 : invokeI.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, viewHolder, i2) == null) {
            if (viewHolder.getItemViewType() != 101) {
                ((LocationDetailViewHolder) viewHolder).update(this.f47164c.get(i2), this.f47167f, b());
            } else {
                ((LocationFooterViewHolder) viewHolder).setVisibility(c());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i2)) == null) {
            if (i2 != 101) {
                return new LocationDetailViewHolder(LayoutInflater.from(this.f47162a).inflate(f.ai_apps_location_item, viewGroup, false), this, this.f47165d);
            }
            return new LocationFooterViewHolder(LayoutInflater.from(this.f47162a).inflate(f.ai_apps_location_footer, viewGroup, false));
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public void resetSelectStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            for (c cVar : this.f47164c) {
                cVar.f11772b = false;
            }
        }
    }

    public void setData(List<c> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            setData(list, null);
        }
    }

    public void setData(List<c> list, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, str) == null) || list == null) {
            return;
        }
        this.f47164c = list;
        this.f47167f = str;
        notifyDataSetChanged();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocationDetailAdapter(Context context, RecyclerView recyclerView, b bVar) {
        this(context, recyclerView, bVar, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, recyclerView, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (RecyclerView) objArr2[1], (b) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
