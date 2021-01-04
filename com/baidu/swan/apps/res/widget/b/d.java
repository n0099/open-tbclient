package com.baidu.swan.apps.res.widget.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
/* loaded from: classes9.dex */
public class d {
    private static boolean dFO = com.baidu.swan.apps.b.DEBUG;
    private CharSequence dFY;
    private CharSequence dFZ;
    private Drawable dGa;
    private Uri dGb;
    private int dGc;
    private a dGd;
    private boolean dGh;
    private Context mContext;
    private CharSequence mTitleText;
    private int dGe = 2;
    private int dGf = 1;
    private int dGg = 1;
    private int mDuration = 2;
    private int mTextSize = 14;

    /* loaded from: classes9.dex */
    public interface a {
        void ajM();
    }

    private d(Context context) {
        this.mContext = context;
    }

    /* renamed from: do  reason: not valid java name */
    public static d m32do(@NonNull Context context) {
        return new d(context);
    }

    public static d a(@NonNull Context context, @NonNull CharSequence charSequence) {
        d dVar = new d(context);
        dVar.dFY = charSequence;
        return dVar;
    }

    public static d u(@NonNull Context context, @StringRes int i) {
        d dVar = new d(context);
        dVar.dFY = context.getText(i);
        return dVar;
    }

    public d kI(@NonNull int i) {
        this.dGc = i;
        return this;
    }

    public d he(boolean z) {
        this.dGh = z;
        return this;
    }

    public d g(@NonNull CharSequence charSequence) {
        this.mTitleText = charSequence;
        return this;
    }

    public d h(@NonNull CharSequence charSequence) {
        this.dFY = charSequence;
        return this;
    }

    public d kJ(int i) {
        this.dGe = i;
        return this;
    }

    public d kK(int i) {
        this.dGf = i;
        return this;
    }

    public d kL(int i) {
        this.dGg = i;
        return this;
    }

    public d i(@NonNull CharSequence charSequence) {
        this.dFZ = charSequence;
        return this;
    }

    public d kM(int i) {
        if (i < 1 || i > 10) {
            this.mDuration = 2;
        } else {
            this.mDuration = i;
        }
        return this;
    }

    public d b(a aVar) {
        this.dGd = aVar;
        return this;
    }

    public d i(@NonNull Drawable drawable) {
        this.dGa = drawable;
        return this;
    }

    public d kN(@DrawableRes int i) {
        if (this.mContext != null && this.mContext.getResources() != null) {
            this.dGa = this.mContext.getResources().getDrawable(i);
        }
        return this;
    }

    public d f(@NonNull Uri uri) {
        this.dGb = uri;
        return this;
    }

    private boolean aLR() {
        if (this.mContext == null) {
            if (dFO) {
                throw new IllegalArgumentException("UniversalToast mContext is null!!!");
            }
            return false;
        } else if (this.dFY == null) {
            if (dFO) {
                throw new IllegalArgumentException("UniversalToast toast text is null!!!");
            }
            return false;
        } else {
            return true;
        }
    }

    public void aLS() {
        hf(false);
    }

    public void aLT() {
        if (aLR()) {
            cancelToast();
            com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dFY, this.mDuration, false, this.dGc, this.dGh);
        }
    }

    public void hf(boolean z) {
        if (aLR()) {
            cancelToast();
            if (!z && (this.mContext instanceof Activity)) {
                e.a((Activity) this.mContext, this.dFY, this.mDuration, this.dGc, this.dGh);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dFY, this.mDuration, true, this.dGc, this.dGh);
            }
        }
    }

    public void aLU() {
        hg(false);
    }

    public void hg(boolean z) {
        if (aLR()) {
            cancelToast();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dFY, this.mDuration);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.dFY, this.mDuration);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dFY, this.mDuration);
            }
        }
    }

    public void aLV() {
        hh(false);
    }

    public void hh(boolean z) {
        if (aLR()) {
            cancelToast();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dFY, this.dGa, this.mDuration, this.dGh);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.dFY, this.dGa, this.mDuration, this.dGh);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dFY, this.dGa, this.mDuration, this.dGh);
            }
        }
    }

    public void aLW() {
        hi(false);
    }

    public void hi(boolean z) {
        if (aLR()) {
            cancelToast();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dFY, this.mDuration, this.dGh);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.dFY, this.mDuration, this.dGh);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dFY, this.mDuration, this.dGh);
            }
        }
    }

    public void aLX() {
        hj(false);
    }

    public void hj(boolean z) {
        if (aLR()) {
            cancelToast();
            if (!z && (this.mContext instanceof Activity)) {
                e.a((Activity) this.mContext, this.dFY, this.mTextSize, this.dFZ, this.mDuration, this.dGd);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dFY, this.mTextSize, this.dFZ, this.mDuration, this.dGd);
            }
        }
    }

    public void aLY() {
        hk(false);
    }

    public void hk(boolean z) {
        if (aLR()) {
            cancelToast();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dGb, this.dGg, this.mTitleText, this.dFY, this.dFZ, this.dGe, this.mDuration, this.dGd);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.dGb, this.dGg, this.mTitleText, this.dFY, this.dFZ, this.dGe, this.dGf, this.mDuration, this.dGd);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dGb, this.dGg, this.mTitleText, this.dFY, this.dFZ, this.dGe, this.mDuration, this.dGd);
            }
        }
    }

    public static void cancelToast() {
        com.baidu.swan.apps.res.widget.b.a.cancel();
        e.cancel();
    }

    public static int dp(Context context) {
        return ah.getStatusBarHeight() + ((int) context.getResources().getDimension(a.d.aiapps_normal_base_action_bar_height));
    }
}
