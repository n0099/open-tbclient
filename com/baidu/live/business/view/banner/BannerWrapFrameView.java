package com.baidu.live.business.view.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.business.model.data.LiveBannerEntity;
import com.baidu.tieba.R;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes3.dex */
public class BannerWrapFrameView extends FrameLayout {
    public Context a;
    public SimpleDraweeView b;
    public FrameLayout c;
    public View d;
    public LiveBannerEntity e;

    public void b(String str) {
    }

    public BannerWrapFrameView(@NonNull Context context) {
        this(context, null);
    }

    public void setData(LiveBannerEntity liveBannerEntity) {
        this.e = liveBannerEntity;
    }

    public BannerWrapFrameView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BannerWrapFrameView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        a();
    }

    public final void a() {
        View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d05f6, this);
        this.d = inflate;
        this.b = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f091630);
        this.c = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091632);
    }

    public LiveBannerEntity getLiveBannerEntity() {
        return this.e;
    }

    public SimpleDraweeView getSimpleDraweeView() {
        return this.b;
    }

    public FrameLayout getStatusViewContainer() {
        return this.c;
    }
}
