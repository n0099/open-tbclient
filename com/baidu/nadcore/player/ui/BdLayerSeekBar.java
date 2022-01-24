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
import c.a.c0.g0.c;
import c.a.c0.g0.f;
import c.a.c0.h0.a.d.b;
import c.a.c0.k0.m;
import c.a.c0.k0.n;
import c.a.c0.v.f0.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.videoplayer.ui.full.BdThumbSeekBar;
import com.baidu.nadcore.video.videoplayer.widget.BdTextProgressView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class BdLayerSeekBar extends FrameLayout implements View.OnClickListener, BdThumbSeekBar.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f37102e;

    /* renamed from: f  reason: collision with root package name */
    public BdThumbSeekBar f37103f;

    /* renamed from: g  reason: collision with root package name */
    public BdTextProgressView f37104g;

    /* renamed from: h  reason: collision with root package name */
    public BdTextProgressView f37105h;

    /* renamed from: i  reason: collision with root package name */
    public l f37106i;
    public boolean isSeeking;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdLayerSeekBar(@NonNull Context context) {
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
            LayoutInflater.from(this.f37102e).inflate(n.nad_bd_layer_seek_bar, this);
            this.f37104g = (BdTextProgressView) findViewById(m.nad_main_progress_text);
            this.f37105h = (BdTextProgressView) findViewById(m.nad_main_duration_text);
            BdThumbSeekBar bdThumbSeekBar = (BdThumbSeekBar) findViewById(m.main_view_seekbar);
            this.f37103f = bdThumbSeekBar;
            bdThumbSeekBar.setOnSeekBarChangeListener(this);
        }
    }

    public int getSeekBarMax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BdThumbSeekBar bdThumbSeekBar = this.f37103f;
            if (bdThumbSeekBar != null) {
                return (int) bdThumbSeekBar.getMax();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public int limitPosition(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (i2 < 0) {
                return 0;
            }
            return ((float) i2) > this.f37103f.getMax() ? (int) this.f37103f.getMax() : i2;
        }
        return invokeI.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    @Override // com.baidu.nadcore.video.videoplayer.ui.full.BdThumbSeekBar.b
    public void onProgressChanged(BdThumbSeekBar bdThumbSeekBar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{bdThumbSeekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            setPosition(i2);
            l lVar = this.f37106i;
            if (lVar != null) {
                lVar.onProgressChanged(bdThumbSeekBar, i2, z);
            }
        }
    }

    @Override // com.baidu.nadcore.video.videoplayer.ui.full.BdThumbSeekBar.b
    public void onStartTrackingTouch(BdThumbSeekBar bdThumbSeekBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdThumbSeekBar) == null) {
            this.isSeeking = true;
            l lVar = this.f37106i;
            if (lVar != null) {
                lVar.onStartTrackingTouch(bdThumbSeekBar);
            }
        }
    }

    @Override // com.baidu.nadcore.video.videoplayer.ui.full.BdThumbSeekBar.b
    public void onStopTrackingTouch(BdThumbSeekBar bdThumbSeekBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdThumbSeekBar) == null) {
            this.isSeeking = false;
            l lVar = this.f37106i;
            if (lVar != null) {
                lVar.onStopTrackingTouch(bdThumbSeekBar);
            }
        }
    }

    public void setBufferingPosition(int i2) {
        BdThumbSeekBar bdThumbSeekBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (bdThumbSeekBar = this.f37103f) == null) {
            return;
        }
        bdThumbSeekBar.setBufferingProgress(i2);
    }

    public void setDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            BdThumbSeekBar bdThumbSeekBar = this.f37103f;
            if (bdThumbSeekBar != null) {
                bdThumbSeekBar.setMax(i2);
            }
            if (this.f37105h != null) {
                String a = c.a(i2, false);
                if (TextUtils.isEmpty(a)) {
                    return;
                }
                this.f37105h.setPositionText(a);
            }
        }
    }

    public void setDurationViewMarginRight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f37105h.getLayoutParams();
            layoutParams.rightMargin = i2;
            this.f37105h.setLayoutParams(layoutParams);
        }
    }

    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            BdThumbSeekBar bdThumbSeekBar = this.f37103f;
            if (bdThumbSeekBar != null) {
                bdThumbSeekBar.setProgress(i2);
            }
            boolean z = false;
            BdThumbSeekBar bdThumbSeekBar2 = this.f37103f;
            if (bdThumbSeekBar2 != null && bdThumbSeekBar2.getMax() >= 3600.0f) {
                z = true;
            }
            String a = c.a(i2, z);
            if (this.f37104g == null || TextUtils.isEmpty(a)) {
                return;
            }
            this.f37104g.setPositionText(a);
        }
    }

    public void setProgressViewMarginLeft(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f37104g.getLayoutParams();
            layoutParams.leftMargin = i2;
            this.f37104g.setLayoutParams(layoutParams);
        }
    }

    public void setSeekBarHolderListener(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, lVar) == null) {
            this.f37106i = lVar;
        }
    }

    public void setSeekBarIcon() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            setSeekBarIcon(getContext(), this.f37103f);
        }
    }

    public void setSeekBarStyle(@NonNull BdThumbSeekBar.BdSeekBarStyle bdSeekBarStyle) {
        BdThumbSeekBar bdThumbSeekBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, bdSeekBarStyle) == null) || (bdThumbSeekBar = this.f37103f) == null) {
            return;
        }
        bdThumbSeekBar.setStyle(bdSeekBarStyle);
    }

    public void setSeekBarTraceHeight(int i2) {
        BdThumbSeekBar bdThumbSeekBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || (bdThumbSeekBar = this.f37103f) == null) {
            return;
        }
        bdThumbSeekBar.setUiTraceHeight(i2);
    }

    public void setSeeking(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.isSeeking = z;
        }
    }

    public void switchToFull() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f37104g.setTextSize(b.b(12.0f));
            this.f37105h.setTextSize(b.b(12.0f));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f37103f.getLayoutParams();
            layoutParams.leftMargin = b.b(3.0f);
            layoutParams.rightMargin = b.b(1.0f);
            this.f37103f.setLayoutParams(layoutParams);
        }
    }

    public void switchToHalf() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f37104g.setTextSize(b.b(10.0f));
            this.f37105h.setTextSize(b.b(10.0f));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f37103f.getLayoutParams();
            layoutParams.leftMargin = b.b(3.0f);
            layoutParams.rightMargin = b.b(3.0f);
            this.f37103f.setLayoutParams(layoutParams);
        }
    }

    public void syncPos(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048596, this, i2, i3, i4) == null) || this.isSeeking) {
            return;
        }
        setPosition(i2);
        setDuration(i3);
        setBufferingPosition(i4);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isSeeking = false;
        this.f37102e = context;
        a();
    }

    public static void setSeekBarIcon(Context context, BdThumbSeekBar bdThumbSeekBar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, context, bdThumbSeekBar) == null) || bdThumbSeekBar == null) {
            return;
        }
        float b2 = f.c.b(context);
        Matrix matrix = new Matrix();
        float f2 = b2 / 3.0f;
        matrix.postScale(f2, f2);
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), c.a.c0.k0.l.nad_videoplayer_new_player_seekbar_thumb_new);
        bdThumbSeekBar.setThumbBitmap(Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix, true));
        Bitmap decodeResource2 = BitmapFactory.decodeResource(context.getResources(), c.a.c0.k0.l.nad_videoplayer_new_player_seekbar_thumb_big);
        bdThumbSeekBar.setScaleThumbBitmap(Bitmap.createBitmap(decodeResource2, 0, 0, decodeResource2.getWidth(), decodeResource2.getHeight(), matrix, true));
    }

    public void syncPos(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048595, this, i2, i3) == null) || this.isSeeking) {
            return;
        }
        setPosition(i2);
        setBufferingPosition(i3);
    }
}
