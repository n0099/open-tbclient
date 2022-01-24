package com.baidu.apollon.base.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public abstract class BaseDialog extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f32376b;

    /* renamed from: c  reason: collision with root package name */
    public Button f32377c;

    /* renamed from: d  reason: collision with root package name */
    public Button f32378d;

    /* renamed from: e  reason: collision with root package name */
    public ImageButton f32379e;

    /* renamed from: f  reason: collision with root package name */
    public View f32380f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout.LayoutParams f32381g;

    /* renamed from: h  reason: collision with root package name */
    public LayoutInflater f32382h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f32383i;
    public Context mContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseDialog(Context context) {
        super(context, ResUtils.style(context, "ApollonPromptDialog"));
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
        this.f32383i = new View.OnClickListener(this) { // from class: com.baidu.apollon.base.widget.BaseDialog.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaseDialog a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.a.dismiss();
                }
            }
        };
        this.mContext = context;
    }

    public void addContentView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            this.f32376b.removeAllViews();
            this.f32376b.addView(view, this.f32381g);
        }
    }

    public void hideButtons() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            findViewById(ResUtils.id(this.mContext, "dialog_btns")).setVisibility(8);
        }
    }

    public void hideNegativeButton() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Button button = this.f32378d;
            if (button != null) {
                button.setVisibility(8);
            }
            View view = this.f32380f;
            if (view != null) {
                view.setVisibility(8);
            }
            this.f32377c.setBackgroundResource(ResUtils.drawable(this.mContext, "wallet_base_dialog_btn_selector"));
        }
    }

    public void hidePositiveButton() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Button button = this.f32377c;
            if (button != null) {
                button.setVisibility(8);
            }
            View view = this.f32380f;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    public void hideTitle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.setVisibility(8);
        }
    }

    public void hideTitleLine() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            findViewById(ResUtils.id(this.mContext, "dialog_title_line")).setVisibility(8);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            requestWindowFeature(1);
            setContentView(ResUtils.layout(this.mContext, "wallet_base_layout_dialog_base"));
            this.a = (TextView) findViewById(ResUtils.id(this.mContext, "dialog_title"));
            this.f32377c = (Button) findViewById(ResUtils.id(this.mContext, "positive_btn"));
            this.f32378d = (Button) findViewById(ResUtils.id(this.mContext, "negative_btn"));
            this.f32379e = (ImageButton) findViewById(ResUtils.id(this.mContext, "dialog_title_close"));
            this.f32380f = findViewById(ResUtils.id(this.mContext, "btn_line"));
            this.f32377c.setOnClickListener(this.f32383i);
            this.f32378d.setOnClickListener(this.f32383i);
            this.f32379e.setOnClickListener(this.f32383i);
            this.f32376b = (LinearLayout) findViewById(ResUtils.id(this.mContext, "dialog_content_layout"));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.f32381g = layoutParams;
            layoutParams.gravity = 17;
            this.f32382h = LayoutInflater.from(this.mContext);
            setCanceledOnTouchOutside(false);
            setCancelable(false);
        }
    }

    public void setNegativeBtn(View.OnClickListener onClickListener) {
        Button button;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) || (button = this.f32378d) == null) {
            return;
        }
        if (onClickListener == null) {
            onClickListener = this.f32383i;
        }
        button.setOnClickListener(onClickListener);
    }

    public void setPositiveBtn(View.OnClickListener onClickListener) {
        Button button;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) || (button = this.f32377c) == null) {
            return;
        }
        if (onClickListener == null) {
            onClickListener = this.f32383i;
        }
        button.setOnClickListener(onClickListener);
    }

    public void setTitleText(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || (textView = this.a) == null) {
            return;
        }
        textView.setText(i2);
    }

    public void setTitleTextBackgroud(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (textView = this.a) == null) {
            return;
        }
        textView.setBackgroundColor(i2);
    }

    public void showCloseBtn(boolean z) {
        ImageButton imageButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (imageButton = this.f32379e) == null) {
            return;
        }
        imageButton.setVisibility(z ? 0 : 4);
    }

    public void addContentView(View view, LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, view, layoutParams) == null) {
            this.f32376b.removeAllViews();
            this.f32376b.addView(view, layoutParams);
        }
    }

    public void setNegativeBtn(int i2, View.OnClickListener onClickListener) {
        Button button;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048586, this, i2, onClickListener) == null) || (button = this.f32378d) == null) {
            return;
        }
        button.setText(i2);
        Button button2 = this.f32378d;
        if (onClickListener == null) {
            onClickListener = this.f32383i;
        }
        button2.setOnClickListener(onClickListener);
    }

    public void setPositiveBtn(int i2, View.OnClickListener onClickListener) {
        Button button;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048589, this, i2, onClickListener) == null) || (button = this.f32377c) == null) {
            return;
        }
        button.setText(i2);
        Button button2 = this.f32377c;
        if (onClickListener == null) {
            onClickListener = this.f32383i;
        }
        button2.setOnClickListener(onClickListener);
    }

    public void setTitleText(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || (textView = this.a) == null) {
            return;
        }
        textView.setText(str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseDialog(Context context, int i2) {
        super(context, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32383i = new View.OnClickListener(this) { // from class: com.baidu.apollon.base.widget.BaseDialog.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaseDialog a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr3;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.a.dismiss();
                }
            }
        };
        this.mContext = context;
    }

    public void addContentView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f32376b.removeAllViews();
            this.f32376b.addView(this.f32382h.inflate(i2, (ViewGroup) null), this.f32381g);
        }
    }

    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, str, onClickListener) == null) || this.f32378d == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f32378d.setText(str);
        }
        Button button = this.f32378d;
        if (onClickListener == null) {
            onClickListener = this.f32383i;
        }
        button.setOnClickListener(onClickListener);
    }

    public void setPositiveBtn(SpannableString spannableString, View.OnClickListener onClickListener) {
        Button button;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, spannableString, onClickListener) == null) || (button = this.f32377c) == null) {
            return;
        }
        button.setText(spannableString);
        Button button2 = this.f32377c;
        if (onClickListener == null) {
            onClickListener = this.f32383i;
        }
        button2.setOnClickListener(onClickListener);
    }

    public void addContentView(int i2, LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, layoutParams) == null) {
            this.f32376b.removeAllViews();
            this.f32376b.addView(this.f32382h.inflate(i2, (ViewGroup) null), layoutParams);
        }
    }

    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, str, onClickListener) == null) || this.f32377c == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f32377c.setText(str);
        }
        Button button = this.f32377c;
        if (onClickListener == null) {
            onClickListener = this.f32383i;
        }
        button.setOnClickListener(onClickListener);
    }
}
