package com.baidu.live.business.util;

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
    public boolean d;
    public LottieListener e;
    public LottieListener f;
    public LottieListener g;

    /* loaded from: classes3.dex */
    public class a implements LottieListener<LottieComposition> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(LottieComposition lottieComposition) {
            LiveBaseLottieView.this.d = true;
            LiveBaseLottieView.this.setComposition(lottieComposition);
            if (LiveBaseLottieView.this.c != null) {
                LiveBaseLottieView.this.setBackgroundColor(0);
            }
            if (LiveBaseLottieView.this.e != null) {
                LiveBaseLottieView.this.e.onResult(lottieComposition);
            }
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
            LiveBaseLottieView.this.d = false;
            th.printStackTrace();
        }
    }

    public LiveBaseLottieView(Context context) {
        super(context);
        this.b = "";
        this.f = new a();
        this.g = new b();
    }

    public final void q(String str) {
        this.b = str;
        LottieTask<LottieComposition> lottieTask = this.a;
        if (lottieTask != null) {
            lottieTask.removeListener(this.f);
            this.a.removeFailureListener(this.g);
        }
        LottieTask<LottieComposition> fromUrl = LottieCompositionFactory.fromUrl(getContext(), str);
        this.a = fromUrl;
        fromUrl.addListener(this.f).addFailureListener(this.g);
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void setAnimationFromUrl(String str) {
        this.b = str;
        if (!TextUtils.isEmpty(str)) {
            q(str);
        }
    }

    public void setDefaultBackground(Drawable drawable) {
        this.c = drawable;
        if (drawable != null) {
            setBackground(drawable);
        }
    }

    public void setSuccessListener(LottieListener lottieListener) {
        this.e = lottieListener;
    }

    public LiveBaseLottieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = "";
        this.f = new a();
        this.g = new b();
    }

    public LiveBaseLottieView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = "";
        this.f = new a();
        this.g = new b();
    }

    public String getLottieUrl() {
        return this.b;
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LottieTask<LottieComposition> lottieTask = this.a;
        if (lottieTask != null) {
            lottieTask.removeListener(this.f);
            this.a.removeFailureListener(this.g);
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
