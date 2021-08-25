package com.baidu.swan.map.location;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.a.o0.j.e;
import c.a.o0.j.o.b;
import c.a.o0.j.o.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class LocationDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f47039e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f47040f;

    /* renamed from: g  reason: collision with root package name */
    public View f47041g;

    /* renamed from: h  reason: collision with root package name */
    public LocationDetailAdapter f47042h;

    /* renamed from: i  reason: collision with root package name */
    public c f47043i;

    /* renamed from: j  reason: collision with root package name */
    public b f47044j;

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
        this.f47042h = locationDetailAdapter;
        this.f47044j = bVar;
    }

    public final void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f47039e = (TextView) view.findViewById(e.main_title);
            this.f47040f = (TextView) view.findViewById(e.sub_title);
            View findViewById = view.findViewById(e.select);
            this.f47041g = findViewById;
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
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            this.f47042h.resetSelectStatus();
            this.f47043i.f11736b = true;
            this.f47042h.notifyDataSetChanged();
            b bVar = this.f47044j;
            if (bVar != null) {
                bVar.c(this.f47043i);
            }
        }
    }

    public void update(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            update(cVar, null, false);
        }
    }

    public void update(c cVar, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048580, this, cVar, str, z) == null) || cVar == null) {
            return;
        }
        this.f47043i = cVar;
        this.f47039e.setText(z ? b(cVar.f11735a.name, str) : cVar.f11735a.name);
        this.f47040f.setVisibility(0);
        this.f47040f.setText(cVar.f11735a.address);
        if (cVar.f11737c || TextUtils.isEmpty(cVar.f11735a.address)) {
            this.f47040f.setVisibility(8);
        }
        this.f47041g.setVisibility(cVar.f11736b ? 0 : 8);
    }
}
