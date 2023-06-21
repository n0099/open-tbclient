package com.baidu.nadcore.widget.feed;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.tieba.bs0;
import com.baidu.tieba.ju0;
import com.baidu.tieba.nu0;
import com.baidu.tieba.yr0;
/* loaded from: classes3.dex */
public abstract class AdFeedVideoBaseView extends AdFeedBaseView {
    public ju0 i;

    /* loaded from: classes3.dex */
    public class a extends nu0 {
        public a() {
        }

        @Override // com.baidu.tieba.nu0, com.baidu.tieba.gu0
        public void onEnd(int i) {
            AdFeedVideoBaseView adFeedVideoBaseView = AdFeedVideoBaseView.this;
            if (adFeedVideoBaseView.b != null && (adFeedVideoBaseView.getTag() instanceof AdBaseModel)) {
                AdFeedVideoBaseView adFeedVideoBaseView2 = AdFeedVideoBaseView.this;
                adFeedVideoBaseView2.b.f((AdBaseModel) adFeedVideoBaseView2.getTag());
            }
        }

        @Override // com.baidu.tieba.nu0, com.baidu.tieba.gu0
        public void onError(int i, int i2, String str) {
            AdFeedVideoBaseView adFeedVideoBaseView = AdFeedVideoBaseView.this;
            if (adFeedVideoBaseView.b != null && (adFeedVideoBaseView.getTag() instanceof AdBaseModel)) {
                AdFeedVideoBaseView adFeedVideoBaseView2 = AdFeedVideoBaseView.this;
                adFeedVideoBaseView2.b.e((AdBaseModel) adFeedVideoBaseView2.getTag(), str);
            }
        }

        @Override // com.baidu.tieba.nu0, com.baidu.tieba.gu0
        public void onPause() {
            AdFeedVideoBaseView adFeedVideoBaseView = AdFeedVideoBaseView.this;
            if (adFeedVideoBaseView.b != null && (adFeedVideoBaseView.getTag() instanceof AdBaseModel)) {
                AdFeedVideoBaseView adFeedVideoBaseView2 = AdFeedVideoBaseView.this;
                adFeedVideoBaseView2.b.c((AdBaseModel) adFeedVideoBaseView2.getTag());
            }
        }

        @Override // com.baidu.tieba.nu0, com.baidu.tieba.gu0
        public void onPrepared() {
            AdFeedVideoBaseView adFeedVideoBaseView = AdFeedVideoBaseView.this;
            if (adFeedVideoBaseView.b != null && (adFeedVideoBaseView.getTag() instanceof AdBaseModel)) {
                AdFeedVideoBaseView adFeedVideoBaseView2 = AdFeedVideoBaseView.this;
                adFeedVideoBaseView2.b.d((AdBaseModel) adFeedVideoBaseView2.getTag());
            }
        }

        @Override // com.baidu.tieba.nu0, com.baidu.tieba.gu0
        public void onResume() {
            AdFeedVideoBaseView adFeedVideoBaseView = AdFeedVideoBaseView.this;
            if (adFeedVideoBaseView.b != null && (adFeedVideoBaseView.getTag() instanceof AdBaseModel)) {
                AdFeedVideoBaseView adFeedVideoBaseView2 = AdFeedVideoBaseView.this;
                adFeedVideoBaseView2.b.a((AdBaseModel) adFeedVideoBaseView2.getTag());
            }
        }

        @Override // com.baidu.tieba.nu0, com.baidu.tieba.gu0
        public void onStart() {
            AdFeedVideoBaseView adFeedVideoBaseView = AdFeedVideoBaseView.this;
            if (adFeedVideoBaseView.b != null && (adFeedVideoBaseView.getTag() instanceof AdBaseModel)) {
                AdFeedVideoBaseView adFeedVideoBaseView2 = AdFeedVideoBaseView.this;
                adFeedVideoBaseView2.b.b((AdBaseModel) adFeedVideoBaseView2.getTag());
            }
        }
    }

    public AdFeedVideoBaseView(@NonNull Context context) {
        super(context);
    }

    public final void i(@NonNull AdBaseModel adBaseModel) {
        yr0 yr0Var;
        ju0 ju0Var = this.i;
        if (ju0Var != null && (yr0Var = adBaseModel.j) != null) {
            ju0Var.c(yr0Var);
            this.i.a(new a());
        }
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void update(@NonNull AdBaseModel adBaseModel) {
        super.update(adBaseModel);
        i(adBaseModel);
    }

    public AdFeedVideoBaseView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdFeedVideoBaseView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null);
    }

    public AdFeedVideoBaseView(Context context, AttributeSet attributeSet, int i, bs0 bs0Var) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void c() {
        super.c();
        ju0 ju0Var = this.i;
        if (ju0Var != null) {
            ju0Var.release();
            this.i = null;
        }
    }

    public long getVideoPosMs() {
        ju0 ju0Var = this.i;
        if (ju0Var == null) {
            return -1L;
        }
        return ju0Var.b();
    }
}
