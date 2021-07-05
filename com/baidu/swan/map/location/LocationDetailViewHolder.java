package com.baidu.swan.map.location;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.j.e;
import d.a.q0.j.o.b;
import d.a.q0.j.o.c;
/* loaded from: classes4.dex */
public class LocationDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f11985e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f11986f;

    /* renamed from: g  reason: collision with root package name */
    public View f11987g;

    /* renamed from: h  reason: collision with root package name */
    public LocationDetailAdapter f11988h;

    /* renamed from: i  reason: collision with root package name */
    public c f11989i;
    public b j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationDetailViewHolder(View view, LocationDetailAdapter locationDetailAdapter, b bVar) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, locationDetailAdapter, bVar};
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
        a(view);
        this.f11988h = locationDetailAdapter;
        this.j = bVar;
    }

    public final void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f11985e = (TextView) view.findViewById(e.main_title);
            this.f11986f = (TextView) view.findViewById(e.sub_title);
            View findViewById = view.findViewById(e.select);
            this.f11987g = findViewById;
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

    public void c(c cVar, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, cVar, str, z) == null) || cVar == null) {
            return;
        }
        this.f11989i = cVar;
        this.f11985e.setText(z ? b(cVar.f53821a.name, str) : cVar.f53821a.name);
        this.f11986f.setVisibility(0);
        this.f11986f.setText(cVar.f53821a.address);
        if (cVar.f53823c || TextUtils.isEmpty(cVar.f53821a.address)) {
            this.f11986f.setVisibility(8);
        }
        this.f11987g.setVisibility(cVar.f53822b ? 0 : 8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.f11988h.o();
            this.f11989i.f53822b = true;
            this.f11988h.notifyDataSetChanged();
            b bVar = this.j;
            if (bVar != null) {
                bVar.c(this.f11989i);
            }
        }
    }
}
