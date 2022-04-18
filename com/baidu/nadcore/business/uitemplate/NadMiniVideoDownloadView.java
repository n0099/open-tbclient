package com.baidu.nadcore.business.uitemplate;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.view.AdProgressButton;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.NadRoundProgressBar;
import com.baidu.nadcore.widget.RoundCornerFrameLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c11;
import com.repackage.hk0;
import com.repackage.rj0;
/* loaded from: classes2.dex */
public class NadMiniVideoDownloadView extends RoundCornerFrameLayout implements hk0<NadMiniVideoDownloadView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdProgressButton g;
    public NadRoundProgressBar h;
    public AdImageView i;
    public TextView j;
    public int k;
    public float l;
    public String m;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1963783489, "Lcom/baidu/nadcore/business/uitemplate/NadMiniVideoDownloadView$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1963783489, "Lcom/baidu/nadcore/business/uitemplate/NadMiniVideoDownloadView$a;");
                    return;
                }
            }
            int[] iArr = new int[AdDownloadStatus.values().length];
            a = iArr;
            try {
                iArr[AdDownloadStatus.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AdDownloadStatus.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AdDownloadStatus.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AdDownloadStatus.COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[AdDownloadStatus.INSTALLED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[AdDownloadStatus.FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadMiniVideoDownloadView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = -1;
        f();
    }

    @Override // com.repackage.hk0
    public void c(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) && (viewGroup instanceof RelativeLayout)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13, -1);
            viewGroup.addView(this, layoutParams);
            viewGroup.setVisibility(0);
        }
    }

    @DrawableRes
    public int e(@NonNull rj0 rj0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rj0Var)) == null) {
            int i = a.a[rj0Var.c.ordinal()];
            if (i != 1) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            if (i != 6) {
                                return -1;
                            }
                            return R.drawable.obfuscated_res_0x7f080dc5;
                        }
                        return R.drawable.obfuscated_res_0x7f080dc7;
                    }
                    return R.drawable.obfuscated_res_0x7f080dc6;
                }
                return R.drawable.obfuscated_res_0x7f080dc8;
            }
            return R.drawable.obfuscated_res_0x7f080dc5;
        }
        return invokeL.intValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) this, true);
            this.h = (NadRoundProgressBar) findViewById(R.id.obfuscated_res_0x7f09141e);
            this.i = (AdImageView) findViewById(R.id.obfuscated_res_0x7f09141d);
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f09141f);
            this.g = (AdProgressButton) findViewById(R.id.obfuscated_res_0x7f09141c);
            g();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.h.setMax(100);
            this.g.setMax(100);
            this.g.setText("");
            int i = this.k;
            if (i >= 0) {
                this.g.setForeground(i);
            } else {
                this.g.setForeground(getResources().getColor(R.color.obfuscated_res_0x7f06082e));
            }
            this.h.setRoundWidth(c11.c.a(getContext(), 1.0f));
            this.h.setCircleColor(getResources().getColor(R.color.obfuscated_res_0x7f06082d));
            this.h.setCircleProgressColor(getResources().getColor(R.color.obfuscated_res_0x7f06082d));
            this.j.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06082d));
            this.g.setBackgroundDrawable(null);
        }
    }

    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.obfuscated_res_0x7f0d05c1 : invokeV.intValue;
    }

    public int getMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.h.getMax() : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.hk0
    @Nullable
    public NadMiniVideoDownloadView getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this : (NadMiniVideoDownloadView) invokeV.objValue;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(i);
            gradientDrawable.setCornerRadius(this.l);
            setBackground(gradientDrawable);
        }
    }

    public void setBorderRadius(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f) == null) {
            this.l = f;
            AdProgressButton adProgressButton = this.g;
            if (adProgressButton != null) {
                adProgressButton.setRadius((int) f);
            }
        }
    }

    public void setImageViewLayout(FrameLayout.LayoutParams layoutParams) {
        AdImageView adImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, layoutParams) == null) || (adImageView = this.i) == null || this.h == null) {
            return;
        }
        adImageView.setLayoutParams(layoutParams);
        this.i.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.h.setLayoutParams(layoutParams);
    }

    public void setMax(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.h.setMax(i);
            this.g.setMax(i);
        }
    }

    public void setProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.h.setVisibility(0);
            this.i.setVisibility(8);
            this.h.setProgress(i);
            this.g.setProgressNoText(i);
        }
    }

    public void setProgressColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.k = i;
            AdProgressButton adProgressButton = this.g;
            if (adProgressButton != null) {
                adProgressButton.setForeground(i);
            }
        }
    }

    public void setRoundProgressBarVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.h.setVisibility(z ? 0 : 8);
        }
    }

    public void setStateImageIcon(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.i.setVisibility(0);
            this.i.g(str);
            this.h.setVisibility(8);
        }
    }

    public void setStateImageIconVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.i.setVisibility(z ? 0 : 8);
        }
    }

    public void setStateImageRes(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            if (i == -1) {
                this.i.setVisibility(4);
                return;
            }
            this.i.setVisibility(0);
            this.h.setVisibility(8);
            this.i.setImageDrawable(getResources().getDrawable(i));
        }
    }

    public void setStrokeColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
        }
    }

    public void setStrokeWidth(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048595, this, f) == null) {
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.j.setText(str);
        }
    }

    public void setTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
        }
    }

    public void setTextSize(float f) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048598, this, f) == null) || (textView = this.j) == null) {
            return;
        }
        textView.setTextSize(1, f);
    }

    @Override // com.repackage.hk0
    public void update(String str, @NonNull rj0 rj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, str, rj0Var) == null) {
            this.m = str;
            if (rj0Var.c == AdDownloadStatus.DOWNLOADING) {
                this.m = "已下载 : " + this.m;
                setProgress((int) (rj0Var.i * 100.0f));
            } else {
                setStateImageRes(e(rj0Var));
            }
            setText(this.m);
            postInvalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadMiniVideoDownloadView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = -1;
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NadMiniVideoDownloadView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.k = -1;
        f();
    }
}
