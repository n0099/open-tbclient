package com.baidu.nadcore.player.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.videoplayer.ui.full.BdVideoBattery;
import com.baidu.nadcore.video.videoplayer.widget.BdTextProgressView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cx0;
import java.util.Calendar;
import java.util.Locale;
/* loaded from: classes2.dex */
public class BdLayerTitleBarView extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public RelativeLayout b;
    public ImageView c;
    public TextView d;
    public BdVideoBattery e;
    public BdTextProgressView f;
    public a g;
    public View h;

    /* loaded from: classes2.dex */
    public interface a {
        void onBack();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdLayerTitleBarView(@NonNull Context context) {
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

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                startAnimation(cx0.d());
            }
            setVisibility(4);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(this.a).cloneInContext(this.a).inflate(R.layout.obfuscated_res_0x7f0d05da, this);
            this.b = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0913d9);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f0913e6);
            this.c = imageView;
            imageView.setOnClickListener(this);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f0913e7);
            BdVideoBattery bdVideoBattery = (BdVideoBattery) findViewById(R.id.obfuscated_res_0x7f0913d8);
            this.e = bdVideoBattery;
            bdVideoBattery.setImage(R.drawable.obfuscated_res_0x7f080dac);
            this.f = (BdTextProgressView) findViewById(R.id.obfuscated_res_0x7f0913e1);
            f();
            this.h = findViewById(R.id.obfuscated_res_0x7f09213f);
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                startAnimation(cx0.c());
            }
            f();
            setVisibility(0);
        }
    }

    public void d(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z2) {
                this.b.setBackgroundColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f06085a));
            } else {
                this.b.setBackground(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080d85));
            }
            c(z);
        }
    }

    public void e(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            d(z, z2);
            setOnlyShowBackIcon(z3);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f.setTimeText(String.format(Locale.US, "%02d:%02d", Integer.valueOf(Calendar.getInstance().get(11)), Integer.valueOf(Calendar.getInstance().get(12))));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view2) == null) && view2.equals(this.c) && (aVar = this.g) != null) {
            aVar.onBack();
        }
    }

    public void setBatteryHullVisible(boolean z) {
        BdVideoBattery bdVideoBattery;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (bdVideoBattery = this.e) == null) {
            return;
        }
        bdVideoBattery.setVisibility(z ? 0 : 8);
    }

    public void setListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.g = aVar;
        }
    }

    public void setOnlyShowBackIcon(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (view2 = this.h) == null) {
            return;
        }
        view2.setVisibility(z ? 8 : 0);
    }

    public void setSystemTimeVisible(boolean z) {
        BdTextProgressView bdTextProgressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (bdTextProgressView = this.f) == null) {
            return;
        }
        bdTextProgressView.setVisibility(z ? 0 : 8);
    }

    public void setVideoTitle(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, str, i) == null) {
            this.d.setText(str);
            this.d.setTypeface(Typeface.DEFAULT_BOLD);
            this.d.setTextSize(0, i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdLayerTitleBarView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        this.d = null;
        this.e = null;
        this.f = null;
        this.a = context;
        b();
    }
}
