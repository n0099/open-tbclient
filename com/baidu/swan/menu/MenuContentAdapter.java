package com.baidu.swan.menu;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.k.i;
import d.a.o0.k.j;
import d.a.o0.k.o;
import d.a.o0.t.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MenuContentAdapter extends RecyclerView.Adapter<a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<o> f12053a;

    /* renamed from: b  reason: collision with root package name */
    public List<o> f12054b;

    /* renamed from: c  reason: collision with root package name */
    public int f12055c;

    /* renamed from: d  reason: collision with root package name */
    public Context f12056d;

    /* loaded from: classes3.dex */
    public static class a extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SwanAppMenuItemView f12057a;

        /* renamed from: b  reason: collision with root package name */
        public SwanAppMenuItemView f12058b;

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
            this.f12057a = (SwanAppMenuItemView) view.findViewById(i.first_line_menu_item_view);
            this.f12058b = (SwanAppMenuItemView) view.findViewById(i.second_line_menu_item_view);
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
        this.f12053a = new ArrayList();
        this.f12054b = new ArrayList();
        this.f12056d = context;
    }

    public final boolean d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) ? z || this.f12053a.size() > 5 || this.f12054b.size() > 5 : invokeZ.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onBindViewHolder(a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, i2) == null) {
            ViewGroup.LayoutParams layoutParams = aVar.itemView.getLayoutParams();
            if (layoutParams != null) {
                int i3 = layoutParams.width;
                int i4 = this.f12055c;
                if (i3 != i4) {
                    layoutParams.width = i4;
                    aVar.itemView.setLayoutParams(layoutParams);
                }
            }
            if (i2 < this.f12053a.size()) {
                aVar.f12057a.setVisibility(0);
                aVar.f12057a.h(this.f12053a.get(i2), this.f12055c);
                aVar.f12057a.setOnClickListener(null);
            } else {
                aVar.f12057a.setVisibility(this.f12053a.size() == 0 ? 8 : 4);
                aVar.f12057a.setOnClickListener(null);
            }
            if (i2 < this.f12054b.size()) {
                aVar.f12058b.setVisibility(0);
                aVar.f12058b.h(this.f12054b.get(i2), this.f12055c);
                aVar.f12058b.setOnClickListener(null);
                return;
            }
            aVar.f12058b.setVisibility(this.f12054b.size() != 0 ? 4 : 8);
            aVar.f12058b.setOnClickListener(null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2)) == null) {
            View inflate = LayoutInflater.from(this.f12056d).inflate(j.swan_app_menu_item_layout, viewGroup, false);
            ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.f12055c, -2);
            } else {
                layoutParams.width = this.f12055c;
            }
            inflate.setLayoutParams(layoutParams);
            return new a(inflate);
        }
        return (a) invokeLI.objValue;
    }

    public void g(List<List<o>> list, boolean z, int i2) {
        int max;
        List<o> list2;
        List<o> list3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{list, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.f12053a.clear();
            this.f12054b.clear();
            if (list == null) {
                return;
            }
            if (list.size() > 0 && (list3 = list.get(0)) != null) {
                this.f12053a.addAll(list3);
            }
            if (list.size() > 1 && (list2 = list.get(1)) != null) {
                this.f12054b.addAll(list2);
            }
            DisplayMetrics displayMetrics = this.f12056d.getResources().getDisplayMetrics();
            if (i2 == 0) {
                max = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            } else {
                max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
            float f2 = d(z) ? 5.5f : 5.0f;
            if (e.d()) {
                Context context = this.f12056d;
                if ((context instanceof Activity) && e.e((Activity) context)) {
                    max = e.a((Activity) this.f12056d);
                }
            }
            this.f12055c = (int) (max / f2);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Math.max(this.f12053a.size(), this.f12054b.size()) : invokeV.intValue;
    }
}
