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
import com.baidu.tieba.c11;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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

    public void d(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z2) {
                this.b.setBackgroundColor(getContext().getResources().getColor(R.color.nad_videoplayer_transparent));
            } else {
                this.b.setBackground(getContext().getResources().getDrawable(R.drawable.nad_videoplayer_control_title_background));
            }
            c(z);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                startAnimation(c11.d());
            }
            setVisibility(4);
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                startAnimation(c11.c());
            }
            f();
            setVisibility(0);
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
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (bdVideoBattery = this.e) != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            bdVideoBattery.setVisibility(i);
        }
    }

    public void setListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.g = aVar;
        }
    }

    public void setOnlyShowBackIcon(boolean z) {
        View view2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && (view2 = this.h) != null) {
            if (z) {
                i = 8;
            } else {
                i = 0;
            }
            view2.setVisibility(i);
        }
    }

    public void setSystemTimeVisible(boolean z) {
        BdTextProgressView bdTextProgressView;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && (bdTextProgressView = this.f) != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            bdTextProgressView.setVisibility(i);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(this.a).cloneInContext(this.a).inflate(R.layout.nad_videoplayer_bd_layer_control_titlebar_layout, this);
            this.b = (RelativeLayout) findViewById(R.id.main_container);
            ImageView imageView = (ImageView) findViewById(R.id.main_title_back_button);
            this.c = imageView;
            imageView.setOnClickListener(this);
            this.d = (TextView) findViewById(R.id.main_title_text);
            BdVideoBattery bdVideoBattery = (BdVideoBattery) findViewById(R.id.main_battery_view);
            this.e = bdVideoBattery;
            bdVideoBattery.setImage(R.drawable.nad_videoplayer_player_batteryhull);
            this.f = (BdTextProgressView) findViewById(R.id.main_system_time_text);
            f();
            this.h = findViewById(R.id.top_function_container);
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

    public void setVideoTitle(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, str, i) == null) {
            this.d.setText(str);
            this.d.setTypeface(Typeface.DEFAULT_BOLD);
            this.d.setTextSize(0, i);
        }
    }
}
