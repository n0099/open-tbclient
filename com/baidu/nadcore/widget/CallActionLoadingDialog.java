package com.baidu.nadcore.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class CallActionLoadingDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f35882e;

    /* renamed from: f  reason: collision with root package name */
    public View f35883f;

    /* renamed from: g  reason: collision with root package name */
    public LoadingProgressBar f35884g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f35885h;

    /* renamed from: i  reason: collision with root package name */
    public String f35886i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f35887j;
    public boolean k;
    public boolean l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallActionLoadingDialog(@NonNull Context context) {
        super(context, R.style.NadCallActionLoadingDialog);
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
        this.f35886i = "";
        this.k = false;
        this.l = false;
        this.f35882e = context;
        this.f35887j = a(context);
    }

    public final boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? context instanceof Activity : invokeL.booleanValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f35883f = findViewById(R.id.root_container);
            this.f35884g = (LoadingProgressBar) findViewById(R.id.loading_bar);
            TextView textView = (TextView) findViewById(R.id.message);
            this.f35885h = textView;
            textView.setText(this.f35886i);
            setCancelable(this.k);
            setCanceledOnTouchOutside(this.l);
            c();
        }
    }

    public final void c() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (context = this.f35882e) == null) {
            return;
        }
        Resources resources = context.getResources();
        View view = this.f35883f;
        if (view != null) {
            view.setBackground(resources.getDrawable(R.drawable.nad_icon_loading_dialog_bg));
        }
        LoadingProgressBar loadingProgressBar = this.f35884g;
        if (loadingProgressBar != null) {
            loadingProgressBar.setIndeterminateDrawable(resources.getDrawable(R.drawable.nad_loading_animation));
        }
        TextView textView = this.f35885h;
        if (textView != null) {
            textView.setTextColor(resources.getColor(R.color.nad_color_white));
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.nad_call_action_loading_dialog);
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
            this.f35886i = str;
            return this;
        }
        return (CallActionLoadingDialog) invokeL.objValue;
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f35887j) {
            try {
                super.show();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
