package com.baidu.sapi2.views;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.NoProguard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.b0.a.e;
import d.a.b0.a.f;
import d.a.b0.a.h;
/* loaded from: classes2.dex */
public class LoadingDialog extends Dialog implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class Builder implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f10029a;

        /* renamed from: b  reason: collision with root package name */
        public String f10030b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f10031c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f10032d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f10033e;

        public Builder(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10031c = true;
            this.f10032d = false;
            this.f10033e = false;
            this.f10029a = context;
        }

        public LoadingDialog createDialog() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                View inflate = LayoutInflater.from(this.f10029a).inflate(f.layout_sapi_sdk_loading_dialog, (ViewGroup) null);
                LoadingDialog loadingDialog = new LoadingDialog(this.f10029a, h.sapi_sdk_loading_dialog);
                TextView textView = (TextView) inflate.findViewById(e.tipTextView);
                if (this.f10031c) {
                    textView.setText(this.f10030b);
                } else {
                    textView.setVisibility(8);
                }
                loadingDialog.setContentView(inflate);
                loadingDialog.setCancelable(this.f10032d);
                loadingDialog.setCanceledOnTouchOutside(this.f10033e);
                return loadingDialog;
            }
            return (LoadingDialog) invokeV.objValue;
        }

        public Builder setCancelOutside(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.f10033e = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setCancelable(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f10032d = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setMessage(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f10030b = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setShowMessage(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.f10031c = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingDialog(Context context, int i2) {
        super(context, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
