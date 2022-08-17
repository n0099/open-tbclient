package com.baidu.pass.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class CommonDialog extends Dialog implements com.baidu.pass.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class Builder implements com.baidu.pass.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;
        public CharSequence b;
        public String c;
        public boolean d;
        public boolean e;
        public String f;
        public View.OnClickListener g;
        public String h;
        public View.OnClickListener i;
        public int j;

        public Builder(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = false;
            this.a = context;
        }

        public CommonDialog build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0683, (ViewGroup) null);
                CommonDialog commonDialog = new CommonDialog(this.a, R.style.obfuscated_res_0x7f1003ce);
                TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091763);
                TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091760);
                View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f091761);
                TextView textView3 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09163f);
                TextView textView4 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0919f6);
                View findViewById2 = inflate.findViewById(R.id.obfuscated_res_0x7f091764);
                textView.setText(this.c);
                textView2.setText(TextUtils.isEmpty(this.b) ? "" : this.b);
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
                textView2.setHighlightColor(0);
                int i = this.j;
                if (i > 0) {
                    textView2.setGravity(i);
                }
                textView3.setText(this.h);
                textView3.setOnClickListener(new a(this, commonDialog));
                textView4.setText(this.f);
                textView4.setOnClickListener(new b(this, commonDialog));
                commonDialog.setContentView(inflate);
                commonDialog.setCancelable(this.e);
                commonDialog.setCanceledOnTouchOutside(this.e);
                Window window = commonDialog.getWindow();
                window.setGravity(17);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.x = 30;
                attributes.y = 30;
                attributes.width = -1;
                attributes.height = -2;
                window.setAttributes(attributes);
                if (this.d) {
                    inflate.findViewById(R.id.obfuscated_res_0x7f091762).setBackgroundResource(R.drawable.obfuscated_res_0x7f080e5d);
                    textView.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f0608a6));
                    textView2.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f06089f));
                    findViewById.setBackgroundColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f0608a5));
                    textView3.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f0608a1));
                    textView4.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f0608a3));
                    findViewById2.setBackgroundColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f0608a5));
                }
                Context context = this.a;
                if (context instanceof Activity) {
                    Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
                    WindowManager.LayoutParams attributes2 = commonDialog.getWindow().getAttributes();
                    attributes.width = defaultDisplay.getWidth();
                    attributes.height = -2;
                    commonDialog.getWindow().setAttributes(attributes2);
                }
                return commonDialog;
            }
            return (CommonDialog) invokeV.objValue;
        }

        public Builder setCancelable(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.e = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setDarkMode(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.d = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setMessage(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, charSequence)) == null) {
                this.b = charSequence;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setMessageGravity(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                this.j = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setNegativeButton(String str, View.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, onClickListener)) == null) {
                this.h = str;
                this.i = onClickListener;
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder setPositiveBtn(String str, View.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, onClickListener)) == null) {
                this.f = str;
                this.g = onClickListener;
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder setTitle(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.c = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonDialog(Context context, int i) {
        super(context, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
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
    }
}
