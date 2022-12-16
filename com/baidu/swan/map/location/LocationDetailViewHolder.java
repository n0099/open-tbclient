package com.baidu.swan.map.location;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.q94;
import com.baidu.tieba.r94;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class LocationDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public View c;
    public LocationDetailAdapter d;
    public r94 e;
    public q94 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationDetailViewHolder(View view2, LocationDetailAdapter locationDetailAdapter, q94 q94Var) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, locationDetailAdapter, q94Var};
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
        this.f = q94Var;
    }

    public final void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            this.a = (TextView) view2.findViewById(R.id.main_title);
            this.b = (TextView) view2.findViewById(R.id.sub_title);
            View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f091ef6);
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
            q94 q94Var = this.f;
            if (q94Var != null) {
                q94Var.e(this.e);
            }
        }
    }

    public void update(r94 r94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, r94Var) == null) {
            update(r94Var, null, false);
        }
    }

    public void update(r94 r94Var, String str, boolean z) {
        CharSequence charSequence;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048580, this, r94Var, str, z) == null) && r94Var != null) {
            this.e = r94Var;
            TextView textView = this.a;
            if (z) {
                charSequence = b(r94Var.a.name, str);
            } else {
                charSequence = r94Var.a.name;
            }
            textView.setText(charSequence);
            int i = 0;
            this.b.setVisibility(0);
            this.b.setText(r94Var.a.address);
            if (r94Var.c || TextUtils.isEmpty(r94Var.a.address)) {
                this.b.setVisibility(8);
            }
            View view2 = this.c;
            if (!r94Var.b) {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }
}
