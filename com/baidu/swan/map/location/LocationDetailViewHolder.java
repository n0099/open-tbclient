package com.baidu.swan.map.location;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.p0.j.e;
import b.a.p0.j.o.b;
import b.a.p0.j.o.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class LocationDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f44793e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f44794f;

    /* renamed from: g  reason: collision with root package name */
    public View f44795g;

    /* renamed from: h  reason: collision with root package name */
    public LocationDetailAdapter f44796h;

    /* renamed from: i  reason: collision with root package name */
    public c f44797i;
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
        this.f44796h = locationDetailAdapter;
        this.j = bVar;
    }

    public final void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f44793e = (TextView) view.findViewById(e.main_title);
            this.f44794f = (TextView) view.findViewById(e.sub_title);
            View findViewById = view.findViewById(e.select);
            this.f44795g = findViewById;
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
            this.f44796h.resetSelectStatus();
            this.f44797i.f10960b = true;
            this.f44796h.notifyDataSetChanged();
            b bVar = this.j;
            if (bVar != null) {
                bVar.c(this.f44797i);
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
        this.f44797i = cVar;
        this.f44793e.setText(z ? b(cVar.f10959a.name, str) : cVar.f10959a.name);
        this.f44794f.setVisibility(0);
        this.f44794f.setText(cVar.f10959a.address);
        if (cVar.f10961c || TextUtils.isEmpty(cVar.f10959a.address)) {
            this.f44794f.setVisibility(8);
        }
        this.f44795g.setVisibility(cVar.f10960b ? 0 : 8);
    }
}
