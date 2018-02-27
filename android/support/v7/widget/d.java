package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes2.dex */
class d {
    private a Ms;
    private a Mt;
    private a Mu;
    private final View mView;
    private int Mr = -1;
    private final AppCompatDrawableManager Mq = AppCompatDrawableManager.get();

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(View view) {
        this.mView = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), attributeSet, R.styleable.ViewBackgroundHelper, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(R.styleable.ViewBackgroundHelper_android_background)) {
                this.Mr = obtainStyledAttributes.getResourceId(R.styleable.ViewBackgroundHelper_android_background, -1);
                ColorStateList k = this.Mq.k(this.mView.getContext(), this.Mr);
                if (k != null) {
                    d(k);
                }
            }
            if (obtainStyledAttributes.hasValue(R.styleable.ViewBackgroundHelper_backgroundTint)) {
                ViewCompat.setBackgroundTintList(this.mView, obtainStyledAttributes.getColorStateList(R.styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.ViewBackgroundHelper_backgroundTintMode)) {
                ViewCompat.setBackgroundTintMode(this.mView, DrawableUtils.a(obtainStyledAttributes.getInt(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void be(int i) {
        this.Mr = i;
        d(this.Mq != null ? this.Mq.k(this.mView.getContext(), i) : null);
        if (fH()) {
            fI();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Drawable drawable) {
        this.Mr = -1;
        d((ColorStateList) null);
        if (fH()) {
            fI();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.Mt == null) {
            this.Mt = new a();
        }
        this.Mt.Mv = colorStateList;
        this.Mt.Xc = null;
        this.Mt.Xe = true;
        if (fH()) {
            fI();
        }
    }

    private boolean fH() {
        ColorStateList b;
        if (this.Mt != null && this.Mt.Xe) {
            if (this.Mr >= 0 && (b = this.Mq.b(this.mView.getContext(), this.Mr, this.Mt.Mv)) != null) {
                this.Mt.Xc = b;
                return true;
            } else if (this.Mt.Xc != this.Mt.Mv) {
                this.Mt.Xc = this.Mt.Mv;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList getSupportBackgroundTintList() {
        if (this.Mt != null) {
            return this.Mt.Xc;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.Mt == null) {
            this.Mt = new a();
        }
        this.Mt.uo = mode;
        this.Mt.Xd = true;
        fI();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.Mt != null) {
            return this.Mt.uo;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fI() {
        Drawable background = this.mView.getBackground();
        if (background != null) {
            if (Build.VERSION.SDK_INT != 21 || !d(background)) {
                if (this.Mt != null) {
                    AppCompatDrawableManager.a(background, this.Mt, this.mView.getDrawableState());
                } else if (this.Ms != null) {
                    AppCompatDrawableManager.a(background, this.Ms, this.mView.getDrawableState());
                }
            }
        }
    }

    void d(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.Ms == null) {
                this.Ms = new a();
            }
            this.Ms.Xc = colorStateList;
            this.Ms.Xe = true;
        } else {
            this.Ms = null;
        }
        fI();
    }

    private boolean d(Drawable drawable) {
        if (this.Mu == null) {
            this.Mu = new a();
        }
        a aVar = this.Mu;
        aVar.clear();
        ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(this.mView);
        if (backgroundTintList != null) {
            aVar.Xe = true;
            aVar.Xc = backgroundTintList;
        }
        PorterDuff.Mode backgroundTintMode = ViewCompat.getBackgroundTintMode(this.mView);
        if (backgroundTintMode != null) {
            aVar.Xd = true;
            aVar.uo = backgroundTintMode;
        }
        if (aVar.Xe || aVar.Xd) {
            AppCompatDrawableManager.a(drawable, aVar, this.mView.getDrawableState());
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends t {
        public ColorStateList Mv;

        a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.v7.widget.t
        public void clear() {
            super.clear();
            this.Mv = null;
        }
    }
}
