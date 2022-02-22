package com.baidu.nadcore.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import c.a.d0.l0.j;
import c.a.d0.l0.l;
import c.a.d0.l0.m;
import c.a.d0.l0.n;
import c.a.d0.l0.p;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class CallActionLoadingDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f37479e;

    /* renamed from: f  reason: collision with root package name */
    public View f37480f;

    /* renamed from: g  reason: collision with root package name */
    public LoadingProgressBar f37481g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f37482h;

    /* renamed from: i  reason: collision with root package name */
    public String f37483i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f37484j;
    public boolean k;
    public boolean l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallActionLoadingDialog(@NonNull Context context) {
        super(context, p.NadCallActionLoadingDialog);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37483i = "";
        this.k = false;
        this.l = false;
        this.f37479e = context;
        this.f37484j = a(context);
    }

    public final boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? context instanceof Activity : invokeL.booleanValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f37480f = findViewById(m.root_container);
            this.f37481g = (LoadingProgressBar) findViewById(m.loading_bar);
            TextView textView = (TextView) findViewById(m.message);
            this.f37482h = textView;
            textView.setText(this.f37483i);
            setCancelable(this.k);
            setCanceledOnTouchOutside(this.l);
            c();
        }
    }

    public final void c() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (context = this.f37479e) == null) {
            return;
        }
        Resources resources = context.getResources();
        View view = this.f37480f;
        if (view != null) {
            view.setBackground(resources.getDrawable(l.nad_icon_loading_dialog_bg));
        }
        LoadingProgressBar loadingProgressBar = this.f37481g;
        if (loadingProgressBar != null) {
            loadingProgressBar.setIndeterminateDrawable(resources.getDrawable(l.nad_loading_animation));
        }
        TextView textView = this.f37482h;
        if (textView != null) {
            textView.setTextColor(resources.getColor(j.nad_color_white));
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(n.nad_call_action_loading_dialog);
            b();
        }
    }

    public CallActionLoadingDialog setCancelWhenBackKey(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            this.k = z;
            return this;
        }
        return (CallActionLoadingDialog) invokeZ.objValue;
    }

    public CallActionLoadingDialog setCancelWhenTouchOutside(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.l = z;
            return this;
        }
        return (CallActionLoadingDialog) invokeZ.objValue;
    }

    public CallActionLoadingDialog setMessage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.f37483i = str;
            return this;
        }
        return (CallActionLoadingDialog) invokeL.objValue;
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f37484j) {
            try {
                super.show();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
