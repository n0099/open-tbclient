package com.baidu.nadcore.download.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.f0.e;
import c.a.c0.f0.f;
import c.a.c0.j.j.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.FormattableUtils;
/* loaded from: classes10.dex */
public class CountDownTextView extends LinearLayout implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f37037e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f37038f;

    /* renamed from: g  reason: collision with root package name */
    public String f37039g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CountDownTextView(Context context) {
        this(context, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(f.nad_count_down_text_view, this);
            this.f37037e = (TextView) inflate.findViewById(e.ad_count_down_label_text);
            this.f37038f = (TextView) inflate.findViewById(e.ad_count_down_timer_text);
        }
    }

    @Override // c.a.c0.j.j.d
    public void onCancel(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.f37038f.setText(String.format(this.f37039g, Integer.valueOf((int) Math.ceil(((float) (j3 - j2)) / 1000.0f))));
        }
    }

    @Override // c.a.c0.j.j.d
    public void onFinish(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            this.f37038f.setText(String.format(this.f37039g, 0));
        }
    }

    @Override // c.a.c0.j.j.d
    public void onProgress(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.f37038f.setText(String.format(this.f37039g, Integer.valueOf((int) Math.ceil(((float) (j3 - j2)) / 1000.0f))));
        }
    }

    @Override // c.a.c0.j.j.d
    public void onStart(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.f37038f.setText(String.format(this.f37039g, Integer.valueOf((int) Math.ceil(((float) (j3 - j2)) / 1000.0f))));
        }
    }

    public void setLabelText(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, charSequence) == null) {
            this.f37037e.setText(charSequence);
        }
    }

    public void setTextColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f37037e.setTextColor(i2);
            this.f37038f.setTextColor(i2);
        }
    }

    public void setTextSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            float f2 = i2;
            this.f37037e.setTextSize(1, f2);
            this.f37038f.setTextSize(1, f2);
        }
    }

    public void setTimerTextFormat(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            this.f37039g = str;
            this.f37039g += FormattableUtils.SIMPLEST_FORMAT;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f37039g);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            sb.append(str2);
            this.f37039g = sb.toString();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f37039g = "%ss";
        a();
    }
}
