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
    private a MA;
    private a My;
    private a Mz;
    private final View mView;
    private int Mx = -1;
    private final AppCompatDrawableManager Mw = AppCompatDrawableManager.get();

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(View view) {
        this.mView = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), attributeSet, R.styleable.ViewBackgroundHelper, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(R.styleable.ViewBackgroundHelper_android_background)) {
                this.Mx = obtainStyledAttributes.getResourceId(R.styleable.ViewBackgroundHelper_android_background, -1);
                ColorStateList j = this.Mw.j(this.mView.getContext(), this.Mx);
                if (j != null) {
                    d(j);
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
        this.Mx = i;
        d(this.Mw != null ? this.Mw.j(this.mView.getContext(), i) : null);
        if (fH()) {
            fI();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Drawable drawable) {
        this.Mx = -1;
        d((ColorStateList) null);
        if (fH()) {
            fI();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.Mz == null) {
            this.Mz = new a();
        }
        this.Mz.MB = colorStateList;
        this.Mz.Xj = null;
        this.Mz.Xl = true;
        if (fH()) {
            fI();
        }
    }

    private boolean fH() {
        ColorStateList b;
        if (this.Mz != null && this.Mz.Xl) {
            if (this.Mx >= 0 && (b = this.Mw.b(this.mView.getContext(), this.Mx, this.Mz.MB)) != null) {
                this.Mz.Xj = b;
                return true;
            } else if (this.Mz.Xj != this.Mz.MB) {
                this.Mz.Xj = this.Mz.MB;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList getSupportBackgroundTintList() {
        if (this.Mz != null) {
            return this.Mz.Xj;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.Mz == null) {
            this.Mz = new a();
        }
        this.Mz.uo = mode;
        this.Mz.Xk = true;
        fI();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.Mz != null) {
            return this.Mz.uo;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fI() {
        Drawable background = this.mView.getBackground();
        if (background != null) {
            if (Build.VERSION.SDK_INT != 21 || !d(background)) {
                if (this.Mz != null) {
                    AppCompatDrawableManager.a(background, this.Mz, this.mView.getDrawableState());
                } else if (this.My != null) {
                    AppCompatDrawableManager.a(background, this.My, this.mView.getDrawableState());
                }
            }
        }
    }

    void d(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.My == null) {
                this.My = new a();
            }
            this.My.Xj = colorStateList;
            this.My.Xl = true;
        } else {
            this.My = null;
        }
        fI();
    }

    private boolean d(Drawable drawable) {
        if (this.MA == null) {
            this.MA = new a();
        }
        a aVar = this.MA;
        aVar.clear();
        ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(this.mView);
        if (backgroundTintList != null) {
            aVar.Xl = true;
            aVar.Xj = backgroundTintList;
        }
        PorterDuff.Mode backgroundTintMode = ViewCompat.getBackgroundTintMode(this.mView);
        if (backgroundTintMode != null) {
            aVar.Xk = true;
            aVar.uo = backgroundTintMode;
        }
        if (aVar.Xl || aVar.Xk) {
            AppCompatDrawableManager.a(drawable, aVar, this.mView.getDrawableState());
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends t {
        public ColorStateList MB;

        a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // android.support.v7.widget.t
        public void clear() {
            super.clear();
            this.MB = null;
        }
    }
}
