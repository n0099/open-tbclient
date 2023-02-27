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
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class SweepLightLoadingView extends FrameLayout implements NoProguard {
    public View a;
    public ImageView b;
    public ImageView c;
    public LinearLayout d;

    public SweepLightLoadingView(Context context) {
        super(context);
        a();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 0) {
            b();
        } else {
            c();
        }
        super.setVisibility(i);
    }

    public SweepLightLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public SweepLightLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_sapi_sdk_sweep_light_loading_view, (ViewGroup) this, true);
        this.a = inflate;
        this.b = (ImageView) inflate.findViewById(R.id.sapi_sdk_loading_logo);
        this.c = (ImageView) this.a.findViewById(R.id.sapi_sdk_sweep_iv);
        this.d = (LinearLayout) this.a.findViewById(R.id.sapi_sdk_sweep_light_loading_bg_layout);
        if (SapiAccountManager.getInstance().getConfignation().isNightMode || SapiAccountManager.getInstance().getConfignation().isDarkMode) {
            this.d.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_dark_mode_na_activity_color));
            this.b.setImageResource(R.drawable.sapi_sdk_sweep_light_logo_dark);
            this.c.setImageResource(R.drawable.sapi_sdk_sweep_light_dark);
            this.a.findViewById(R.id.sapi_sdk_sweep_bg_view).setBackgroundColor(getResources().getColor(R.color.sapi_sdk_sweep_loading_bg_dark));
        }
    }

    private void b() {
        this.c.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.sapi_sdk_sweep_light_trans));
    }

    @TargetApi(11)
    private void c() {
        ImageView imageView = this.c;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }
}
