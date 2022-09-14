package com.baidu.swan.menu;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.dj4;
import com.baidu.tieba.g94;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class MenuContentAdapter extends RecyclerView.Adapter<a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<g94> a;
    public List<g94> b;
    public int c;
    public Context d;

    /* loaded from: classes3.dex */
    public static class a extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SwanAppMenuItemView a;
        public SwanAppMenuItemView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (SwanAppMenuItemView) view2.findViewById(R.id.obfuscated_res_0x7f0909cc);
            this.b = (SwanAppMenuItemView) view2.findViewById(R.id.obfuscated_res_0x7f091e25);
        }
    }

    public MenuContentAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.d = context;
    }

    public final boolean d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) ? z || this.a.size() > 5 || this.b.size() > 5 : invokeZ.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onBindViewHolder(a aVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, i) == null) {
            ViewGroup.LayoutParams layoutParams = aVar.itemView.getLayoutParams();
            if (layoutParams != null) {
                int i2 = layoutParams.width;
                int i3 = this.c;
                if (i2 != i3) {
                    layoutParams.width = i3;
                    aVar.itemView.setLayoutParams(layoutParams);
                }
            }
            if (i < this.a.size()) {
                aVar.a.setVisibility(0);
                aVar.a.h(this.a.get(i), this.c);
                aVar.a.setOnClickListener(null);
            } else {
                aVar.a.setVisibility(this.a.size() == 0 ? 8 : 4);
                aVar.a.setOnClickListener(null);
            }
            if (i < this.b.size()) {
                aVar.b.setVisibility(0);
                aVar.b.h(this.b.get(i), this.c);
                aVar.b.setOnClickListener(null);
                return;
            }
            aVar.b.setVisibility(this.b.size() != 0 ? 4 : 8);
            aVar.b.setOnClickListener(null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
            View inflate = LayoutInflater.from(this.d).inflate(R.layout.obfuscated_res_0x7f0d0814, viewGroup, false);
            ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(this.c, -2);
            } else {
                layoutParams.width = this.c;
            }
            inflate.setLayoutParams(layoutParams);
            return new a(inflate);
        }
        return (a) invokeLI.objValue;
    }

    public void g(List<List<g94>> list, boolean z, int i) {
        int max;
        List<g94> list2;
        List<g94> list3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{list, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            this.a.clear();
            this.b.clear();
            if (list == null) {
                return;
            }
            if (list.size() > 0 && (list3 = list.get(0)) != null) {
                this.a.addAll(list3);
            }
            if (list.size() > 1 && (list2 = list.get(1)) != null) {
                this.b.addAll(list2);
            }
            DisplayMetrics displayMetrics = this.d.getResources().getDisplayMetrics();
            if (i == 0) {
                max = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            } else {
                max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
            float f = d(z) ? 5.5f : 5.0f;
            if (dj4.d()) {
                Context context = this.d;
                if ((context instanceof Activity) && dj4.e((Activity) context)) {
                    max = dj4.a((Activity) this.d);
                }
            }
            this.c = (int) (max / f);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Math.max(this.a.size(), this.b.size()) : invokeV.intValue;
    }
}
