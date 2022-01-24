package com.baidu.swan.map.location;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.a.r0.m.f;
import c.a.r0.m.p.b;
import c.a.r0.m.p.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class LocationDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f39913e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f39914f;

    /* renamed from: g  reason: collision with root package name */
    public View f39915g;

    /* renamed from: h  reason: collision with root package name */
    public LocationDetailAdapter f39916h;

    /* renamed from: i  reason: collision with root package name */
    public c f39917i;

    /* renamed from: j  reason: collision with root package name */
    public b f39918j;

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
        this.f39916h = locationDetailAdapter;
        this.f39918j = bVar;
    }

    public final void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f39913e = (TextView) view.findViewById(f.main_title);
            this.f39914f = (TextView) view.findViewById(f.sub_title);
            View findViewById = view.findViewById(f.select);
            this.f39915g = findViewById;
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
            this.f39916h.resetSelectStatus();
            this.f39917i.f11533b = true;
            this.f39916h.notifyDataSetChanged();
            b bVar = this.f39918j;
            if (bVar != null) {
                bVar.d(this.f39917i);
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
        this.f39917i = cVar;
        this.f39913e.setText(z ? b(cVar.a.name, str) : cVar.a.name);
        this.f39914f.setVisibility(0);
        this.f39914f.setText(cVar.a.address);
        if (cVar.f11534c || TextUtils.isEmpty(cVar.a.address)) {
            this.f39914f.setVisibility(8);
        }
        this.f39915g.setVisibility(cVar.f11533b ? 0 : 8);
    }
}
