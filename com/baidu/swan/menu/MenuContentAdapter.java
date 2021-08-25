package com.baidu.swan.menu;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import c.a.o0.k.i;
import c.a.o0.k.j;
import c.a.o0.k.o;
import c.a.o0.t.e;
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
    public List<o> f47067a;

    /* renamed from: b  reason: collision with root package name */
    public List<o> f47068b;

    /* renamed from: c  reason: collision with root package name */
    public int f47069c;

    /* renamed from: d  reason: collision with root package name */
    public Context f47070d;

    /* loaded from: classes6.dex */
    public static class a extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SwanAppMenuItemView f47071a;

        /* renamed from: b  reason: collision with root package name */
        public SwanAppMenuItemView f47072b;

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
            this.f47071a = (SwanAppMenuItemView) view.findViewById(i.first_line_menu_item_view);
            this.f47072b = (SwanAppMenuItemView) view.findViewById(i.second_line_menu_item_view);
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
        this.f47067a = new ArrayList();
        this.f47068b = new ArrayList();
        this.f47070d = context;
    }

    public final boolean a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) ? z || this.f47067a.size() > 5 || this.f47068b.size() > 5 : invokeZ.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Math.max(this.f47067a.size(), this.f47068b.size()) : invokeV.intValue;
    }

    public void updateData(List<List<o>> list, boolean z, int i2) {
        int max;
        List<o> list2;
        List<o> list3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{list, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.f47067a.clear();
            this.f47068b.clear();
            if (list == null) {
                return;
            }
            if (list.size() > 0 && (list3 = list.get(0)) != null) {
                this.f47067a.addAll(list3);
            }
            if (list.size() > 1 && (list2 = list.get(1)) != null) {
                this.f47068b.addAll(list2);
            }
            DisplayMetrics displayMetrics = this.f47070d.getResources().getDisplayMetrics();
            if (i2 == 0) {
                max = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            } else {
                max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
            float f2 = a(z) ? 5.5f : 5.0f;
            if (e.d()) {
                Context context = this.f47070d;
                if ((context instanceof Activity) && e.e((Activity) context)) {
                    max = e.a((Activity) this.f47070d);
                }
            }
            this.f47069c = (int) (max / f2);
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
                int i4 = this.f47069c;
                if (i3 != i4) {
                    layoutParams.width = i4;
                    aVar.itemView.setLayoutParams(layoutParams);
                }
            }
            if (i2 < this.f47067a.size()) {
                aVar.f47071a.setVisibility(0);
                aVar.f47071a.h(this.f47067a.get(i2), this.f47069c);
                aVar.f47071a.setOnClickListener(null);
            } else {
                aVar.f47071a.setVisibility(this.f47067a.size() == 0 ? 8 : 4);
                aVar.f47071a.setOnClickListener(null);
            }
            if (i2 < this.f47068b.size()) {
                aVar.f47072b.setVisibility(0);
                aVar.f47072b.h(this.f47068b.get(i2), this.f47069c);
                aVar.f47072b.setOnClickListener(null);
                return;
            }
            aVar.f47072b.setVisibility(this.f47068b.size() != 0 ? 4 : 8);
            aVar.f47072b.setOnClickListener(null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i2)) == null) {
            View inflate = LayoutInflater.from(this.f47070d).inflate(j.swan_app_menu_item_layout, viewGroup, false);
            ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.f47069c, -2);
            } else {
                layoutParams.width = this.f47069c;
            }
            inflate.setLayoutParams(layoutParams);
            return new a(inflate);
        }
        return (a) invokeLI.objValue;
    }
}
