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
import c.a.c0.h0.o;
import c.a.c0.h0.q;
import c.a.c0.h0.r;
import c.a.c0.h0.s;
import c.a.c0.s.v0.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.videoplayer.ui.full.BdVideoBattery;
import com.baidu.nadcore.video.videoplayer.widget.BdTextProgressView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
import java.util.Locale;
/* loaded from: classes10.dex */
public class BdLayerTitleBarView extends FrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f38131e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f38132f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f38133g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f38134h;

    /* renamed from: i  reason: collision with root package name */
    public BdVideoBattery f38135i;

    /* renamed from: j  reason: collision with root package name */
    public BdTextProgressView f38136j;

    /* renamed from: k  reason: collision with root package name */
    public a f38137k;
    public View l;

    /* loaded from: classes10.dex */
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
            LayoutInflater.from(this.f38131e).cloneInContext(this.f38131e).inflate(s.nad_videoplayer_bd_layer_control_titlebar_layout, this);
            this.f38132f = (RelativeLayout) findViewById(r.main_container);
            ImageView imageView = (ImageView) findViewById(r.main_title_back_button);
            this.f38133g = imageView;
            imageView.setOnClickListener(this);
            this.f38134h = (TextView) findViewById(r.main_title_text);
            BdVideoBattery bdVideoBattery = (BdVideoBattery) findViewById(r.main_battery_view);
            this.f38135i = bdVideoBattery;
            bdVideoBattery.setImage(q.nad_videoplayer_player_batteryhull);
            this.f38136j = (BdTextProgressView) findViewById(r.main_system_time_text);
            updateTimeText();
            this.l = findViewById(r.top_function_container);
        }
    }

    public void hide(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                startAnimation(f.d());
            }
            setVisibility(4);
        }
    }

    public boolean isShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? getVisibility() == 0 : invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view.equals(this.f38133g) && (aVar = this.f38137k) != null) {
            aVar.onBack();
        }
    }

    public void setBatteryHullVisible(boolean z) {
        BdVideoBattery bdVideoBattery;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (bdVideoBattery = this.f38135i) == null) {
            return;
        }
        bdVideoBattery.setVisibility(z ? 0 : 8);
    }

    public void setListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.f38137k = aVar;
        }
    }

    public void setOnlyShowBackIcon(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (view = this.l) == null) {
            return;
        }
        view.setVisibility(z ? 8 : 0);
    }

    public void setSystemTimeVisible(boolean z) {
        BdTextProgressView bdTextProgressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (bdTextProgressView = this.f38136j) == null) {
            return;
        }
        bdTextProgressView.setVisibility(z ? 0 : 8);
    }

    public void setVideoTitle(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2) == null) {
            this.f38134h.setText(str);
            this.f38134h.setTypeface(Typeface.DEFAULT_BOLD);
            this.f38134h.setTextSize(0, i2);
        }
    }

    public void show(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                startAnimation(f.c());
            }
            updateTimeText();
            setVisibility(0);
        }
    }

    public void updateTimeText() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f38136j.setTimeText(String.format(Locale.US, "%02d:%02d", Integer.valueOf(Calendar.getInstance().get(11)), Integer.valueOf(Calendar.getInstance().get(12))));
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
        this.f38134h = null;
        this.f38135i = null;
        this.f38136j = null;
        this.f38131e = context;
        a();
    }

    public void show(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z2) {
                this.f38132f.setBackgroundColor(getContext().getResources().getColor(o.nad_videoplayer_transparent));
            } else {
                this.f38132f.setBackground(getContext().getResources().getDrawable(q.nad_videoplayer_control_title_background));
            }
            show(z);
        }
    }

    public void show(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            show(z, z2);
            setOnlyShowBackIcon(z3);
        }
    }
}
