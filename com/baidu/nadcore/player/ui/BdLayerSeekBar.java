package com.baidu.nadcore.player.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.videoplayer.ui.full.BdThumbSeekBar;
import com.baidu.nadcore.video.videoplayer.widget.BdTextProgressView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c11;
import com.repackage.d01;
import com.repackage.ls0;
import com.repackage.zz0;
/* loaded from: classes2.dex */
public class BdLayerSeekBar extends FrameLayout implements View.OnClickListener, BdThumbSeekBar.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public BdThumbSeekBar b;
    public BdTextProgressView c;
    public BdTextProgressView d;
    public boolean e;
    public ls0 f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdLayerSeekBar(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.nadcore.video.videoplayer.ui.full.BdThumbSeekBar.b
    public void a(BdThumbSeekBar bdThumbSeekBar, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{bdThumbSeekBar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            setPosition(i);
            ls0 ls0Var = this.f;
            if (ls0Var != null) {
                ls0Var.a(bdThumbSeekBar, i, z);
            }
        }
    }

    @Override // com.baidu.nadcore.video.videoplayer.ui.full.BdThumbSeekBar.b
    public void b(BdThumbSeekBar bdThumbSeekBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdThumbSeekBar) == null) {
            this.e = false;
            ls0 ls0Var = this.f;
            if (ls0Var != null) {
                ls0Var.b(bdThumbSeekBar);
            }
        }
    }

    @Override // com.baidu.nadcore.video.videoplayer.ui.full.BdThumbSeekBar.b
    public void c(BdThumbSeekBar bdThumbSeekBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdThumbSeekBar) == null) {
            this.e = true;
            ls0 ls0Var = this.f;
            if (ls0Var != null) {
                ls0Var.c(bdThumbSeekBar);
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0580, this);
            this.c = (BdTextProgressView) findViewById(R.id.obfuscated_res_0x7f091499);
            this.d = (BdTextProgressView) findViewById(R.id.obfuscated_res_0x7f091498);
            BdThumbSeekBar bdThumbSeekBar = (BdThumbSeekBar) findViewById(R.id.obfuscated_res_0x7f091344);
            this.b = bdThumbSeekBar;
            bdThumbSeekBar.setOnSeekBarChangeListener(this);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c.setTextSize(c11.b(12.0f));
            this.d.setTextSize(c11.b(12.0f));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.leftMargin = c11.b(3.0f);
            layoutParams.rightMargin = c11.b(1.0f);
            this.b.setLayoutParams(layoutParams);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.c.setTextSize(c11.b(10.0f));
            this.d.setTextSize(c11.b(10.0f));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
            layoutParams.leftMargin = c11.b(3.0f);
            layoutParams.rightMargin = c11.b(3.0f);
            this.b.setLayoutParams(layoutParams);
        }
    }

    public void g(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048582, this, i, i2, i3) == null) || this.e) {
            return;
        }
        setPosition(i);
        setDuration(i2);
        setBufferingPosition(i3);
    }

    public int getSeekBarMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            BdThumbSeekBar bdThumbSeekBar = this.b;
            if (bdThumbSeekBar != null) {
                return (int) bdThumbSeekBar.getMax();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
        }
    }

    public void setBufferingPosition(int i) {
        BdThumbSeekBar bdThumbSeekBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || (bdThumbSeekBar = this.b) == null) {
            return;
        }
        bdThumbSeekBar.setBufferingProgress(i);
    }

    public void setDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            BdThumbSeekBar bdThumbSeekBar = this.b;
            if (bdThumbSeekBar != null) {
                bdThumbSeekBar.setMax(i);
            }
            if (this.d != null) {
                String a = zz0.a(i, false);
                if (TextUtils.isEmpty(a)) {
                    return;
                }
                this.d.setPositionText(a);
            }
        }
    }

    public void setDurationViewMarginRight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
            layoutParams.rightMargin = i;
            this.d.setLayoutParams(layoutParams);
        }
    }

    public void setPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            BdThumbSeekBar bdThumbSeekBar = this.b;
            if (bdThumbSeekBar != null) {
                bdThumbSeekBar.setProgress(i);
            }
            boolean z = false;
            BdThumbSeekBar bdThumbSeekBar2 = this.b;
            if (bdThumbSeekBar2 != null && bdThumbSeekBar2.getMax() >= 3600.0f) {
                z = true;
            }
            String a = zz0.a(i, z);
            if (this.c == null || TextUtils.isEmpty(a)) {
                return;
            }
            this.c.setPositionText(a);
        }
    }

    public void setProgressViewMarginLeft(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams.leftMargin = i;
            this.c.setLayoutParams(layoutParams);
        }
    }

    public void setSeekBarHolderListener(ls0 ls0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, ls0Var) == null) {
            this.f = ls0Var;
        }
    }

    public void setSeekBarIcon() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            setSeekBarIcon(getContext(), this.b);
        }
    }

    public void setSeekBarStyle(@NonNull BdThumbSeekBar.BdSeekBarStyle bdSeekBarStyle) {
        BdThumbSeekBar bdThumbSeekBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, bdSeekBarStyle) == null) || (bdThumbSeekBar = this.b) == null) {
            return;
        }
        bdThumbSeekBar.setStyle(bdSeekBarStyle);
    }

    public void setSeekBarTraceHeight(int i) {
        BdThumbSeekBar bdThumbSeekBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i) == null) || (bdThumbSeekBar = this.b) == null) {
            return;
        }
        bdThumbSeekBar.setUiTraceHeight(i);
    }

    public void setSeeking(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.e = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdLayerSeekBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        this.e = false;
        this.a = context;
        d();
    }

    public static void setSeekBarIcon(Context context, BdThumbSeekBar bdThumbSeekBar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, context, bdThumbSeekBar) == null) || bdThumbSeekBar == null) {
            return;
        }
        float b = d01.c.b(context);
        Matrix matrix = new Matrix();
        float f = b / 3.0f;
        matrix.postScale(f, f);
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), R.drawable.obfuscated_res_0x7f080e27);
        bdThumbSeekBar.setThumbBitmap(Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix, true));
        Bitmap decodeResource2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.obfuscated_res_0x7f080e26);
        bdThumbSeekBar.setScaleThumbBitmap(Bitmap.createBitmap(decodeResource2, 0, 0, decodeResource2.getWidth(), decodeResource2.getHeight(), matrix, true));
    }
}
