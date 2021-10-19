package com.baidu.swan.menu;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import c.a.p0.k.i;
import c.a.p0.k.j;
import c.a.p0.k.o;
import c.a.p0.t.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class MenuContentAdapter extends RecyclerView.Adapter<a> {
    public static /* synthetic */ Interceptable $ic;
    public static final int ORIENTATION_PORTRAIT = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<o> f47196a;

    /* renamed from: b  reason: collision with root package name */
    public List<o> f47197b;

    /* renamed from: c  reason: collision with root package name */
    public int f47198c;

    /* renamed from: d  reason: collision with root package name */
    public Context f47199d;

    /* loaded from: classes6.dex */
    public static class a extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SwanAppMenuItemView f47200a;

        /* renamed from: b  reason: collision with root package name */
        public SwanAppMenuItemView f47201b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47200a = (SwanAppMenuItemView) view.findViewById(i.first_line_menu_item_view);
            this.f47201b = (SwanAppMenuItemView) view.findViewById(i.second_line_menu_item_view);
        }
    }

    public MenuContentAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47196a = new ArrayList();
        this.f47197b = new ArrayList();
        this.f47199d = context;
    }

    public final boolean a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) ? z || this.f47196a.size() > 5 || this.f47197b.size() > 5 : invokeZ.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Math.max(this.f47196a.size(), this.f47197b.size()) : invokeV.intValue;
    }

    public void updateData(List<List<o>> list, boolean z, int i2) {
        int max;
        List<o> list2;
        List<o> list3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{list, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.f47196a.clear();
            this.f47197b.clear();
            if (list == null) {
                return;
            }
            if (list.size() > 0 && (list3 = list.get(0)) != null) {
                this.f47196a.addAll(list3);
            }
            if (list.size() > 1 && (list2 = list.get(1)) != null) {
                this.f47197b.addAll(list2);
            }
            DisplayMetrics displayMetrics = this.f47199d.getResources().getDisplayMetrics();
            if (i2 == 0) {
                max = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            } else {
                max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
            float f2 = a(z) ? 5.5f : 5.0f;
            if (e.d()) {
                Context context = this.f47199d;
                if ((context instanceof Activity) && e.e((Activity) context)) {
                    max = e.a((Activity) this.f47199d);
                }
            }
            this.f47198c = (int) (max / f2);
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, aVar, i2) == null) {
            ViewGroup.LayoutParams layoutParams = aVar.itemView.getLayoutParams();
            if (layoutParams != null) {
                int i3 = layoutParams.width;
                int i4 = this.f47198c;
                if (i3 != i4) {
                    layoutParams.width = i4;
                    aVar.itemView.setLayoutParams(layoutParams);
                }
            }
            if (i2 < this.f47196a.size()) {
                aVar.f47200a.setVisibility(0);
                aVar.f47200a.h(this.f47196a.get(i2), this.f47198c);
                aVar.f47200a.setOnClickListener(null);
            } else {
                aVar.f47200a.setVisibility(this.f47196a.size() == 0 ? 8 : 4);
                aVar.f47200a.setOnClickListener(null);
            }
            if (i2 < this.f47197b.size()) {
                aVar.f47201b.setVisibility(0);
                aVar.f47201b.h(this.f47197b.get(i2), this.f47198c);
                aVar.f47201b.setOnClickListener(null);
                return;
            }
            aVar.f47201b.setVisibility(this.f47197b.size() != 0 ? 4 : 8);
            aVar.f47201b.setOnClickListener(null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i2)) == null) {
            View inflate = LayoutInflater.from(this.f47199d).inflate(j.swan_app_menu_item_layout, viewGroup, false);
            ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.f47198c, -2);
            } else {
                layoutParams.width = this.f47198c;
            }
            inflate.setLayoutParams(layoutParams);
            return new a(inflate);
        }
        return (a) invokeLI.objValue;
    }
}
