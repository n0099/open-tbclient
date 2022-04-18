package com.baidu.swan.map.location;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.u54;
import com.repackage.v54;
/* loaded from: classes2.dex */
public class LocationDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public View c;
    public LocationDetailAdapter d;
    public v54 e;
    public u54 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationDetailViewHolder(View view2, LocationDetailAdapter locationDetailAdapter, u54 u54Var) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, locationDetailAdapter, u54Var};
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
        a(view2);
        this.d = locationDetailAdapter;
        this.f = u54Var;
    }

    public final void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091373);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091db6);
            View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f091c59);
            this.c = findViewById;
            findViewById.setVisibility(8);
            this.itemView.setOnClickListener(this);
        }
    }

    public final CharSequence b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            return Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>"));
        }
        return (CharSequence) invokeLL.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            this.d.f();
            this.e.b = true;
            this.d.notifyDataSetChanged();
            u54 u54Var = this.f;
            if (u54Var != null) {
                u54Var.c(this.e);
            }
        }
    }

    public void update(v54 v54Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, v54Var) == null) {
            update(v54Var, null, false);
        }
    }

    public void update(v54 v54Var, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048580, this, v54Var, str, z) == null) || v54Var == null) {
            return;
        }
        this.e = v54Var;
        this.a.setText(z ? b(v54Var.a.name, str) : v54Var.a.name);
        this.b.setVisibility(0);
        this.b.setText(v54Var.a.address);
        if (v54Var.c || TextUtils.isEmpty(v54Var.a.address)) {
            this.b.setVisibility(8);
        }
        this.c.setVisibility(v54Var.b ? 0 : 8);
    }
}
