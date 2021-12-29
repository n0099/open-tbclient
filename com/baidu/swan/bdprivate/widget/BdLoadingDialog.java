package com.baidu.swan.bdprivate.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;
import c.a.r0.b.f;
import c.a.r0.b.g;
import c.a.r0.b.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class BdLoadingDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f40914e;

    /* renamed from: f  reason: collision with root package name */
    public Context f40915f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdLoadingDialog(Context context) {
        super(context, i.BdWaitingDialog);
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
        this.f40915f = context;
    }

    public static BdLoadingDialog show(Context context, CharSequence charSequence) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, charSequence)) == null) ? show(context, charSequence, false) : (BdLoadingDialog) invokeLL.objValue;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(g.loading_layout);
            ((TextView) findViewById(f.message)).setText(this.f40914e);
        }
    }

    public void setMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f40914e = str;
        }
    }

    public static BdLoadingDialog show(Context context, CharSequence charSequence, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, context, charSequence, z)) == null) ? show(context, charSequence, z, null) : (BdLoadingDialog) invokeLLZ.objValue;
    }

    public void setMessage(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, charSequence) == null) {
            this.f40914e = charSequence.toString();
        }
    }

    public static BdLoadingDialog show(Context context, CharSequence charSequence, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, charSequence, Boolean.valueOf(z), onCancelListener})) == null) {
            BdLoadingDialog bdLoadingDialog = new BdLoadingDialog(context);
            bdLoadingDialog.setMessage(charSequence);
            bdLoadingDialog.setCancelable(z);
            bdLoadingDialog.setOnCancelListener(onCancelListener);
            bdLoadingDialog.show();
            return bdLoadingDialog;
        }
        return (BdLoadingDialog) invokeCommon.objValue;
    }

    public void setMessage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f40914e = this.f40915f.getResources().getString(i2);
        }
    }
}
