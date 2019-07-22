package com.baidu.swan.apps.res.widget.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.z;
/* loaded from: classes2.dex */
public class d {
    private static boolean azt = com.baidu.swan.apps.b.DEBUG;
    private CharSequence aQe;
    private CharSequence aQf;
    private Drawable aQg;
    private Uri aQh;
    private int aQi;
    private a aQj;
    private boolean aQn;
    private Context mContext;
    private CharSequence mTitleText;
    private int aQk = 2;
    private int aQl = 1;
    private int aQm = 1;
    private int mDuration = 2;
    private int mTextSize = 14;

    /* loaded from: classes2.dex */
    public interface a {
        void LX();
    }

    private d(Context context) {
        this.mContext = context;
    }

    public static d bw(@NonNull Context context) {
        return new d(context);
    }

    public static d a(@NonNull Context context, @NonNull CharSequence charSequence) {
        d dVar = new d(context);
        dVar.aQe = charSequence;
        return dVar;
    }

    public static d k(@NonNull Context context, @StringRes int i) {
        d dVar = new d(context);
        dVar.aQe = context.getText(i);
        return dVar;
    }

    public d dF(@NonNull int i) {
        this.aQi = i;
        return this;
    }

    public d co(boolean z) {
        this.aQn = z;
        return this;
    }

    public d e(@NonNull CharSequence charSequence) {
        this.mTitleText = charSequence;
        return this;
    }

    public d f(@NonNull CharSequence charSequence) {
        this.aQe = charSequence;
        return this;
    }

    public d dG(int i) {
        this.aQk = i;
        return this;
    }

    public d dH(int i) {
        this.aQl = i;
        return this;
    }

    public d dI(int i) {
        this.aQm = i;
        return this;
    }

    public d g(@NonNull CharSequence charSequence) {
        this.aQf = charSequence;
        return this;
    }

    public d dJ(int i) {
        if (i < 1 || i > 10) {
            this.mDuration = 2;
        } else {
            this.mDuration = i;
        }
        return this;
    }

    public d b(a aVar) {
        this.aQj = aVar;
        return this;
    }

    public d d(@NonNull Drawable drawable) {
        this.aQg = drawable;
        return this;
    }

    public d dK(@DrawableRes int i) {
        if (this.mContext != null && this.mContext.getResources() != null) {
            this.aQg = this.mContext.getResources().getDrawable(i);
        }
        return this;
    }

    public d f(@NonNull Uri uri) {
        this.aQh = uri;
        return this;
    }

    private boolean LP() {
        if (this.mContext == null) {
            if (azt) {
                throw new IllegalArgumentException("UniversalToast mContext is null!!!");
            }
            return false;
        } else if (this.aQe == null) {
            if (azt) {
                throw new IllegalArgumentException("UniversalToast toast text is null!!!");
            }
            return false;
        } else {
            return true;
        }
    }

    public void LQ() {
        cp(false);
    }

    public void LR() {
        if (LP()) {
            LW();
            com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aQe, this.mDuration, false, this.aQi, this.aQn);
        }
    }

    public void cp(boolean z) {
        if (LP()) {
            LW();
            if (!z && (this.mContext instanceof Activity)) {
                e.a((Activity) this.mContext, this.aQe, this.mDuration, this.aQi, this.aQn);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aQe, this.mDuration, true, this.aQi, this.aQn);
            }
        }
    }

    public void LS() {
        cq(false);
    }

    public void cq(boolean z) {
        if (LP()) {
            LW();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aQe, this.mDuration);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.aQe, this.mDuration);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aQe, this.mDuration);
            }
        }
    }

    public void LT() {
        cr(false);
    }

    public void cr(boolean z) {
        if (LP()) {
            LW();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aQe, this.aQg, this.mDuration, this.aQn);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.aQe, this.aQg, this.mDuration, this.aQn);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aQe, this.aQg, this.mDuration, this.aQn);
            }
        }
    }

    public void LU() {
        cs(false);
    }

    public void cs(boolean z) {
        if (LP()) {
            LW();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aQe, this.mDuration, this.aQn);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.aQe, this.mDuration, this.aQn);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aQe, this.mDuration, this.aQn);
            }
        }
    }

    public void LV() {
        ct(false);
    }

    public void ct(boolean z) {
        if (LP()) {
            LW();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aQh, this.aQm, this.mTitleText, this.aQe, this.aQf, this.aQk, this.mDuration, this.aQj);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.aQh, this.aQm, this.mTitleText, this.aQe, this.aQf, this.aQk, this.aQl, this.mDuration, this.aQj);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aQh, this.aQm, this.mTitleText, this.aQe, this.aQf, this.aQk, this.mDuration, this.aQj);
            }
        }
    }

    public static void LW() {
        com.baidu.swan.apps.res.widget.b.a.cancel();
        e.cancel();
    }

    public static int bx(Context context) {
        return z.getStatusBarHeight() + ((int) context.getResources().getDimension(a.d.aiapps_normal_base_action_bar_height));
    }
}
