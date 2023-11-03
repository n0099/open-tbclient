package com.baidu.live.feed.search.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieTask;
/* loaded from: classes3.dex */
public class LiveBaseLottieView extends LottieAnimationView {
    public LottieTask<LottieComposition> a;
    public String b;
    public Drawable c;
    public LottieListener d;
    public LottieListener e;

    /* loaded from: classes3.dex */
    public class a implements LottieListener<LottieComposition> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(LottieComposition lottieComposition) {
            LiveBaseLottieView.this.setComposition(lottieComposition);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements LottieListener<Throwable> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
            th.printStackTrace();
            if (LiveBaseLottieView.this.c != null) {
                LiveBaseLottieView liveBaseLottieView = LiveBaseLottieView.this;
                liveBaseLottieView.setBackground(liveBaseLottieView.c);
            }
        }
    }

    public LiveBaseLottieView(Context context) {
        super(context);
        this.b = "";
        this.d = new a();
        this.e = new b();
    }

    public final void r(String str) {
        this.b = str;
        LottieTask<LottieComposition> lottieTask = this.a;
        if (lottieTask != null) {
            lottieTask.removeListener(this.d);
            this.a.removeFailureListener(this.e);
        }
        LottieTask<LottieComposition> fromUrl = LottieCompositionFactory.fromUrl(getContext(), str);
        this.a = fromUrl;
        fromUrl.addListener(this.d).addFailureListener(this.e);
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void setAnimationFromUrl(String str) {
        this.b = str;
        if (!TextUtils.isEmpty(str)) {
            r(str);
        }
    }

    public void setFailBackground(Drawable drawable) {
        this.c = drawable;
    }

    public LiveBaseLottieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = "";
        this.d = new a();
        this.e = new b();
    }

    public LiveBaseLottieView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = "";
        this.d = new a();
        this.e = new b();
    }

    public String getLottieUrl() {
        return this.b;
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LottieTask<LottieComposition> lottieTask = this.a;
        if (lottieTask != null) {
            lottieTask.removeListener(this.d);
            this.a.removeFailureListener(this.e);
            this.a = null;
        }
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void playAnimation() {
        try {
            super.playAnimation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
