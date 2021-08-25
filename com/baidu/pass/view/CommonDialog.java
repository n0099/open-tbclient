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
import com.baidu.pass.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class CommonDialog extends Dialog implements com.baidu.pass.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class Builder implements com.baidu.pass.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f44152a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f44153b;

        /* renamed from: c  reason: collision with root package name */
        public String f44154c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f44155d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f44156e;

        /* renamed from: f  reason: collision with root package name */
        public String f44157f;

        /* renamed from: g  reason: collision with root package name */
        public View.OnClickListener f44158g;

        /* renamed from: h  reason: collision with root package name */
        public String f44159h;

        /* renamed from: i  reason: collision with root package name */
        public View.OnClickListener f44160i;

        /* renamed from: j  reason: collision with root package name */
        public int f44161j;

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
            this.f44156e = false;
            this.f44152a = context;
        }

        public CommonDialog build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                View inflate = LayoutInflater.from(this.f44152a).inflate(R.layout.pass_sdk_base_ui_common_dialog, (ViewGroup) null);
                CommonDialog commonDialog = new CommonDialog(this.f44152a, R.style.pass_base_ui_common_dialog_style);
                TextView textView = (TextView) inflate.findViewById(R.id.pass_base_ui_dialog_title);
                TextView textView2 = (TextView) inflate.findViewById(R.id.pass_base_ui_dialog_content);
                View findViewById = inflate.findViewById(R.id.pass_base_ui_dialog_horizontal_split_line);
                TextView textView3 = (TextView) inflate.findViewById(R.id.negative_btn);
                TextView textView4 = (TextView) inflate.findViewById(R.id.positive_btn);
                View findViewById2 = inflate.findViewById(R.id.pass_base_ui_dialog_vertical_split_line);
                textView.setText(this.f44154c);
                textView2.setText(TextUtils.isEmpty(this.f44153b) ? "" : this.f44153b);
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
                textView2.setHighlightColor(0);
                int i2 = this.f44161j;
                if (i2 > 0) {
                    textView2.setGravity(i2);
                }
                textView3.setText(this.f44159h);
                textView3.setOnClickListener(new a(this, commonDialog));
                textView4.setText(this.f44157f);
                textView4.setOnClickListener(new b(this, commonDialog));
                commonDialog.setContentView(inflate);
                commonDialog.setCancelable(this.f44156e);
                commonDialog.setCanceledOnTouchOutside(this.f44156e);
                Window window = commonDialog.getWindow();
                window.setGravity(17);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.x = 30;
                attributes.y = 30;
                attributes.width = -1;
                attributes.height = -2;
                window.setAttributes(attributes);
                if (this.f44155d) {
                    inflate.findViewById(R.id.pass_base_ui_dialog_root_view).setBackgroundResource(R.drawable.pass_base_ui_common_dialog_dark_bg);
                    textView.setTextColor(this.f44152a.getResources().getColor(R.color.pass_base_ui_dialog_title_dark_text_color));
                    textView2.setTextColor(this.f44152a.getResources().getColor(R.color.pass_base_ui_dialog_content_text_dark_color));
                    findViewById.setBackgroundColor(this.f44152a.getResources().getColor(R.color.pass_base_ui_dialog_split_line_dark_color));
                    textView3.setTextColor(this.f44152a.getResources().getColor(R.color.pass_base_ui_dialog_negative_btn_text_dark_color));
                    textView4.setTextColor(this.f44152a.getResources().getColor(R.color.pass_base_ui_dialog_positive_btn_text_dark_color));
                    findViewById2.setBackgroundColor(this.f44152a.getResources().getColor(R.color.pass_base_ui_dialog_split_line_dark_color));
                }
                Context context = this.f44152a;
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
                this.f44156e = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setDarkMode(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.f44155d = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setMessage(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, charSequence)) == null) {
                this.f44153b = charSequence;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setMessageGravity(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.f44161j = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setNegativeButton(String str, View.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, onClickListener)) == null) {
                this.f44159h = str;
                this.f44160i = onClickListener;
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder setPositiveBtn(String str, View.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, onClickListener)) == null) {
                this.f44157f = str;
                this.f44158g = onClickListener;
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder setTitle(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.f44154c = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonDialog(Context context, int i2) {
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
