package com.baidu.sapi2.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.a.b;
import c.a.c0.a.d;
import c.a.c0.a.e;
import c.a.c0.a.f;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class SweepLightLoadingView extends FrameLayout implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f44869a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f44870b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f44871c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f44872d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SweepLightLoadingView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(f.layout_sapi_sdk_sweep_light_loading_view, (ViewGroup) this, true);
            this.f44869a = inflate;
            this.f44870b = (ImageView) inflate.findViewById(e.sapi_sdk_loading_logo);
            this.f44871c = (ImageView) this.f44869a.findViewById(e.sapi_sdk_sweep_iv);
            this.f44872d = (LinearLayout) this.f44869a.findViewById(e.sapi_sdk_sweep_light_loading_bg_layout);
            if (SapiAccountManager.getInstance().getConfignation().isNightMode || SapiAccountManager.getInstance().getConfignation().isDarkMode) {
                this.f44872d.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_na_activity_color));
                this.f44870b.setImageResource(d.sapi_sdk_sweep_light_logo_dark);
                this.f44871c.setImageResource(d.sapi_sdk_sweep_light_dark);
                this.f44869a.findViewById(e.sapi_sdk_sweep_bg_view).setBackgroundColor(getResources().getColor(b.sapi_sdk_sweep_loading_bg_dark));
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.f44871c.startAnimation(AnimationUtils.loadAnimation(getContext(), c.a.c0.a.a.sapi_sdk_sweep_light_trans));
        }
    }

    @TargetApi(11)
    private void c() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) || (imageView = this.f44871c) == null) {
            return;
        }
        imageView.clearAnimation();
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (i2 == 0) {
                b();
            } else {
                c();
            }
            super.setVisibility(i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SweepLightLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SweepLightLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        a();
    }
}
