package com.baidu.nadcore.widget.feed;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.tieba.av0;
import com.baidu.tieba.ev0;
import com.baidu.tieba.ms0;
import com.baidu.tieba.ps0;
/* loaded from: classes3.dex */
public abstract class AdFeedVideoBaseView extends AdFeedBaseView {
    public av0 i;

    /* loaded from: classes3.dex */
    public class a extends ev0 {
        public a() {
        }

        @Override // com.baidu.tieba.ev0, com.baidu.tieba.xu0
        public void onEnd(int i) {
            AdFeedVideoBaseView adFeedVideoBaseView = AdFeedVideoBaseView.this;
            if (adFeedVideoBaseView.b != null && (adFeedVideoBaseView.getTag() instanceof AdBaseModel)) {
                AdFeedVideoBaseView adFeedVideoBaseView2 = AdFeedVideoBaseView.this;
                adFeedVideoBaseView2.b.f((AdBaseModel) adFeedVideoBaseView2.getTag());
            }
        }

        @Override // com.baidu.tieba.ev0, com.baidu.tieba.xu0
        public void onError(int i, int i2, String str) {
            AdFeedVideoBaseView adFeedVideoBaseView = AdFeedVideoBaseView.this;
            if (adFeedVideoBaseView.b != null && (adFeedVideoBaseView.getTag() instanceof AdBaseModel)) {
                AdFeedVideoBaseView adFeedVideoBaseView2 = AdFeedVideoBaseView.this;
                adFeedVideoBaseView2.b.e((AdBaseModel) adFeedVideoBaseView2.getTag(), str);
            }
        }

        @Override // com.baidu.tieba.ev0, com.baidu.tieba.xu0
        public void onPause() {
            AdFeedVideoBaseView adFeedVideoBaseView = AdFeedVideoBaseView.this;
            if (adFeedVideoBaseView.b != null && (adFeedVideoBaseView.getTag() instanceof AdBaseModel)) {
                AdFeedVideoBaseView adFeedVideoBaseView2 = AdFeedVideoBaseView.this;
                adFeedVideoBaseView2.b.c((AdBaseModel) adFeedVideoBaseView2.getTag());
            }
        }

        @Override // com.baidu.tieba.ev0, com.baidu.tieba.xu0
        public void onPrepared() {
            AdFeedVideoBaseView adFeedVideoBaseView = AdFeedVideoBaseView.this;
            if (adFeedVideoBaseView.b != null && (adFeedVideoBaseView.getTag() instanceof AdBaseModel)) {
                AdFeedVideoBaseView adFeedVideoBaseView2 = AdFeedVideoBaseView.this;
                adFeedVideoBaseView2.b.d((AdBaseModel) adFeedVideoBaseView2.getTag());
            }
        }

        @Override // com.baidu.tieba.ev0, com.baidu.tieba.xu0
        public void onResume() {
            AdFeedVideoBaseView adFeedVideoBaseView = AdFeedVideoBaseView.this;
            if (adFeedVideoBaseView.b != null && (adFeedVideoBaseView.getTag() instanceof AdBaseModel)) {
                AdFeedVideoBaseView adFeedVideoBaseView2 = AdFeedVideoBaseView.this;
                adFeedVideoBaseView2.b.a((AdBaseModel) adFeedVideoBaseView2.getTag());
            }
        }

        @Override // com.baidu.tieba.ev0, com.baidu.tieba.xu0
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
        ms0 ms0Var;
        av0 av0Var = this.i;
        if (av0Var != null && (ms0Var = adBaseModel.j) != null) {
            av0Var.c(ms0Var);
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

    public AdFeedVideoBaseView(Context context, AttributeSet attributeSet, int i, ps0 ps0Var) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void c() {
        super.c();
        av0 av0Var = this.i;
        if (av0Var != null) {
            av0Var.release();
            this.i = null;
        }
    }

    public long getVideoPosMs() {
        av0 av0Var = this.i;
        if (av0Var == null) {
            return -1L;
        }
        return av0Var.b();
    }
}
