package com.baidu.nadcore.widget.feed;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.tieba.du0;
import com.baidu.tieba.hu0;
import com.baidu.tieba.pr0;
import com.baidu.tieba.sr0;
/* loaded from: classes3.dex */
public abstract class AdFeedVideoBaseView extends AdFeedBaseView {
    public du0 i;

    /* loaded from: classes3.dex */
    public class a extends hu0 {
        public a() {
        }

        @Override // com.baidu.tieba.hu0, com.baidu.tieba.au0
        public void onEnd(int i) {
            AdFeedVideoBaseView adFeedVideoBaseView = AdFeedVideoBaseView.this;
            if (adFeedVideoBaseView.b != null && (adFeedVideoBaseView.getTag() instanceof AdBaseModel)) {
                AdFeedVideoBaseView adFeedVideoBaseView2 = AdFeedVideoBaseView.this;
                adFeedVideoBaseView2.b.f((AdBaseModel) adFeedVideoBaseView2.getTag());
            }
        }

        @Override // com.baidu.tieba.hu0, com.baidu.tieba.au0
        public void onError(int i, int i2, String str) {
            AdFeedVideoBaseView adFeedVideoBaseView = AdFeedVideoBaseView.this;
            if (adFeedVideoBaseView.b != null && (adFeedVideoBaseView.getTag() instanceof AdBaseModel)) {
                AdFeedVideoBaseView adFeedVideoBaseView2 = AdFeedVideoBaseView.this;
                adFeedVideoBaseView2.b.e((AdBaseModel) adFeedVideoBaseView2.getTag(), str);
            }
        }

        @Override // com.baidu.tieba.hu0, com.baidu.tieba.au0
        public void onPause() {
            AdFeedVideoBaseView adFeedVideoBaseView = AdFeedVideoBaseView.this;
            if (adFeedVideoBaseView.b != null && (adFeedVideoBaseView.getTag() instanceof AdBaseModel)) {
                AdFeedVideoBaseView adFeedVideoBaseView2 = AdFeedVideoBaseView.this;
                adFeedVideoBaseView2.b.c((AdBaseModel) adFeedVideoBaseView2.getTag());
            }
        }

        @Override // com.baidu.tieba.hu0, com.baidu.tieba.au0
        public void onPrepared() {
            AdFeedVideoBaseView adFeedVideoBaseView = AdFeedVideoBaseView.this;
            if (adFeedVideoBaseView.b != null && (adFeedVideoBaseView.getTag() instanceof AdBaseModel)) {
                AdFeedVideoBaseView adFeedVideoBaseView2 = AdFeedVideoBaseView.this;
                adFeedVideoBaseView2.b.d((AdBaseModel) adFeedVideoBaseView2.getTag());
            }
        }

        @Override // com.baidu.tieba.hu0, com.baidu.tieba.au0
        public void onResume() {
            AdFeedVideoBaseView adFeedVideoBaseView = AdFeedVideoBaseView.this;
            if (adFeedVideoBaseView.b != null && (adFeedVideoBaseView.getTag() instanceof AdBaseModel)) {
                AdFeedVideoBaseView adFeedVideoBaseView2 = AdFeedVideoBaseView.this;
                adFeedVideoBaseView2.b.a((AdBaseModel) adFeedVideoBaseView2.getTag());
            }
        }

        @Override // com.baidu.tieba.hu0, com.baidu.tieba.au0
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
        pr0 pr0Var;
        du0 du0Var = this.i;
        if (du0Var != null && (pr0Var = adBaseModel.j) != null) {
            du0Var.c(pr0Var);
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

    public AdFeedVideoBaseView(Context context, AttributeSet attributeSet, int i, sr0 sr0Var) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.nadcore.widget.feed.AdFeedBaseView
    public void c() {
        super.c();
        du0 du0Var = this.i;
        if (du0Var != null) {
            du0Var.release();
            this.i = null;
        }
    }

    public long getVideoPosMs() {
        du0 du0Var = this.i;
        if (du0Var == null) {
            return -1L;
        }
        return du0Var.b();
    }
}
