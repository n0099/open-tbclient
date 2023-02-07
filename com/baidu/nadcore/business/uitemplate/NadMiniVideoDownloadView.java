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
import com.baidu.tieba.b51;
import com.baidu.tieba.cl0;
import com.baidu.tieba.vl0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class NadMiniVideoDownloadView extends RoundCornerFrameLayout implements vl0<NadMiniVideoDownloadView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdProgressButton g;
    public NadRoundProgressBar h;
    public AdImageView i;
    public TextView j;
    public int k;
    public float l;
    public String m;
    public AdDownloadStatus n;
    public Boolean o;

    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.nad_mini_video_download_view : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vl0
    @Nullable
    public NadMiniVideoDownloadView getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this : (NadMiniVideoDownloadView) invokeV.objValue;
    }

    public void setStrokeColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
        }
    }

    public void setStrokeWidth(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048597, this, f) == null) {
        }
    }

    public void setTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
        }
    }

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
        this.n = AdDownloadStatus.NONE;
        this.o = Boolean.FALSE;
        g();
    }

    @DrawableRes
    public int f(@NonNull cl0 cl0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cl0Var)) == null) {
            int i = a.a[cl0Var.c.ordinal()];
            if (i == 1) {
                return R.drawable.nad_mini_video_ad_pop_download_begin;
            }
            if (i != 3) {
                if (i != 4) {
                    if (i != 5) {
                        if (i == 6) {
                            return R.drawable.nad_mini_video_ad_pop_download_begin;
                        }
                        return -1;
                    }
                    return R.drawable.nad_mini_video_ad_pop_download_open;
                }
                return R.drawable.nad_mini_video_ad_pop_download_complete;
            }
            return R.drawable.nad_mini_video_ad_pop_download_pause;
        }
        return invokeL.intValue;
    }

    public void setProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            if (this.o.booleanValue()) {
                this.h.setVisibility(8);
            } else {
                this.h.setVisibility(0);
            }
            this.i.setVisibility(8);
            this.h.setProgress(i);
            this.g.setProgressNoText(i);
        }
    }

    public void setStateImageRes(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            if (i == -1) {
                this.i.setVisibility(4);
                return;
            }
            if (this.o.booleanValue()) {
                this.i.setVisibility(8);
            } else {
                this.i.setVisibility(0);
            }
            this.h.setVisibility(8);
            this.i.setImageDrawable(getResources().getDrawable(i));
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
        this.n = AdDownloadStatus.NONE;
        this.o = Boolean.FALSE;
        g();
    }

    @Override // com.baidu.tieba.vl0
    public void update(String str, @NonNull cl0 cl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, str, cl0Var) == null) {
            this.m = str;
            AdDownloadStatus adDownloadStatus = cl0Var.c;
            this.n = adDownloadStatus;
            if (adDownloadStatus == AdDownloadStatus.DOWNLOADING) {
                this.m = "已下载 : " + this.m;
                setProgress((int) (cl0Var.i * 100.0f));
            } else if (adDownloadStatus == AdDownloadStatus.COMPLETED) {
                setProgress(100);
            } else {
                setStateImageRes(f(cl0Var));
            }
            setText(this.m);
            postInvalidate();
        }
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
        this.n = AdDownloadStatus.NONE;
        this.o = Boolean.FALSE;
        g();
    }

    @Override // com.baidu.tieba.vl0
    public void b(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, viewGroup) != null) || !(viewGroup instanceof RelativeLayout)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        viewGroup.addView(this, layoutParams);
        viewGroup.setVisibility(0);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(i);
            gradientDrawable.setCornerRadius(this.l);
            setBackground(gradientDrawable);
        }
    }

    public void setBorderRadius(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f) == null) {
            this.l = f;
            AdProgressButton adProgressButton = this.g;
            if (adProgressButton != null) {
                adProgressButton.setRadius((int) f);
            }
        }
    }

    public void setIconArrowSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.o = Boolean.valueOf(z);
        }
    }

    public void setImageViewLayout(FrameLayout.LayoutParams layoutParams) {
        AdImageView adImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, layoutParams) == null) && (adImageView = this.i) != null && this.h != null) {
            adImageView.setLayoutParams(layoutParams);
            this.i.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.h.setLayoutParams(layoutParams);
        }
    }

    public void setMax(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.h.setMax(i);
            this.g.setMax(i);
        }
    }

    public void setProgressColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.k = i;
            AdProgressButton adProgressButton = this.g;
            if (adProgressButton != null) {
                adProgressButton.setForeground(i);
            }
        }
    }

    public void setRoundProgressBarVisible(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            NadRoundProgressBar nadRoundProgressBar = this.h;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            nadRoundProgressBar.setVisibility(i);
        }
    }

    public void setStateImageIcon(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            if (this.o.booleanValue()) {
                this.i.setVisibility(8);
            } else {
                this.i.setVisibility(0);
            }
            this.i.g(str);
            this.h.setVisibility(8);
        }
    }

    public void setStateImageIconVisible(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            AdImageView adImageView = this.i;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            adImageView.setVisibility(i);
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.j.setText(str);
        }
    }

    public void setTextSize(float f) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048600, this, f) == null) && (textView = this.j) != null) {
            textView.setTextSize(1, f);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) this, true);
            this.h = (NadRoundProgressBar) findViewById(R.id.mini_video_ad_pop_state_progress_bar);
            this.i = (AdImageView) findViewById(R.id.mini_video_ad_pop_state_icon);
            this.j = (TextView) findViewById(R.id.mini_video_ad_pop_state_text);
            this.g = (AdProgressButton) findViewById(R.id.mini_video_ad_pop_progress_btn);
            h();
        }
    }

    @NonNull
    public AdDownloadStatus getDownloadStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.n;
        }
        return (AdDownloadStatus) invokeV.objValue;
    }

    public int getMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.h.getMax();
        }
        return invokeV.intValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.h.setMax(100);
            this.g.setMax(100);
            this.g.setText("");
            int i = this.k;
            if (i >= 0) {
                this.g.setForeground(i);
            } else {
                this.g.setForeground(getResources().getColor(R.color.nad_mini_video_download_progress_color));
            }
            this.h.setRoundWidth(b51.c.a(getContext(), 1.0f));
            this.h.setCircleColor(getResources().getColor(R.color.nad_mini_video_download_circular_progress_color));
            this.h.setCircleProgressColor(getResources().getColor(R.color.nad_mini_video_download_circular_progress_color));
            this.j.setTextColor(getResources().getColor(R.color.nad_mini_video_download_circular_progress_color));
            this.g.setBackgroundDrawable(null);
        }
    }
}
