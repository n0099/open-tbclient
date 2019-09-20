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
    private static boolean azR = com.baidu.swan.apps.b.DEBUG;
    private CharSequence aQC;
    private CharSequence aQD;
    private Drawable aQE;
    private Uri aQF;
    private int aQG;
    private a aQH;
    private boolean aQL;
    private Context mContext;
    private CharSequence mTitleText;
    private int aQI = 2;
    private int aQJ = 1;
    private int aQK = 1;
    private int mDuration = 2;
    private int mTextSize = 14;

    /* loaded from: classes2.dex */
    public interface a {
        void Mb();
    }

    private d(Context context) {
        this.mContext = context;
    }

    public static d bw(@NonNull Context context) {
        return new d(context);
    }

    public static d a(@NonNull Context context, @NonNull CharSequence charSequence) {
        d dVar = new d(context);
        dVar.aQC = charSequence;
        return dVar;
    }

    public static d k(@NonNull Context context, @StringRes int i) {
        d dVar = new d(context);
        dVar.aQC = context.getText(i);
        return dVar;
    }

    public d dG(@NonNull int i) {
        this.aQG = i;
        return this;
    }

    public d co(boolean z) {
        this.aQL = z;
        return this;
    }

    public d e(@NonNull CharSequence charSequence) {
        this.mTitleText = charSequence;
        return this;
    }

    public d f(@NonNull CharSequence charSequence) {
        this.aQC = charSequence;
        return this;
    }

    public d dH(int i) {
        this.aQI = i;
        return this;
    }

    public d dI(int i) {
        this.aQJ = i;
        return this;
    }

    public d dJ(int i) {
        this.aQK = i;
        return this;
    }

    public d g(@NonNull CharSequence charSequence) {
        this.aQD = charSequence;
        return this;
    }

    public d dK(int i) {
        if (i < 1 || i > 10) {
            this.mDuration = 2;
        } else {
            this.mDuration = i;
        }
        return this;
    }

    public d b(a aVar) {
        this.aQH = aVar;
        return this;
    }

    public d d(@NonNull Drawable drawable) {
        this.aQE = drawable;
        return this;
    }

    public d dL(@DrawableRes int i) {
        if (this.mContext != null && this.mContext.getResources() != null) {
            this.aQE = this.mContext.getResources().getDrawable(i);
        }
        return this;
    }

    public d f(@NonNull Uri uri) {
        this.aQF = uri;
        return this;
    }

    private boolean LT() {
        if (this.mContext == null) {
            if (azR) {
                throw new IllegalArgumentException("UniversalToast mContext is null!!!");
            }
            return false;
        } else if (this.aQC == null) {
            if (azR) {
                throw new IllegalArgumentException("UniversalToast toast text is null!!!");
            }
            return false;
        } else {
            return true;
        }
    }

    public void LU() {
        cp(false);
    }

    public void LV() {
        if (LT()) {
            Ma();
            com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aQC, this.mDuration, false, this.aQG, this.aQL);
        }
    }

    public void cp(boolean z) {
        if (LT()) {
            Ma();
            if (!z && (this.mContext instanceof Activity)) {
                e.a((Activity) this.mContext, this.aQC, this.mDuration, this.aQG, this.aQL);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aQC, this.mDuration, true, this.aQG, this.aQL);
            }
        }
    }

    public void LW() {
        cq(false);
    }

    public void cq(boolean z) {
        if (LT()) {
            Ma();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aQC, this.mDuration);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.aQC, this.mDuration);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aQC, this.mDuration);
            }
        }
    }

    public void LX() {
        cr(false);
    }

    public void cr(boolean z) {
        if (LT()) {
            Ma();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aQC, this.aQE, this.mDuration, this.aQL);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.aQC, this.aQE, this.mDuration, this.aQL);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aQC, this.aQE, this.mDuration, this.aQL);
            }
        }
    }

    public void LY() {
        cs(false);
    }

    public void cs(boolean z) {
        if (LT()) {
            Ma();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aQC, this.mDuration, this.aQL);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.aQC, this.mDuration, this.aQL);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aQC, this.mDuration, this.aQL);
            }
        }
    }

    public void LZ() {
        ct(false);
    }

    public void ct(boolean z) {
        if (LT()) {
            Ma();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aQF, this.aQK, this.mTitleText, this.aQC, this.aQD, this.aQI, this.mDuration, this.aQH);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.aQF, this.aQK, this.mTitleText, this.aQC, this.aQD, this.aQI, this.aQJ, this.mDuration, this.aQH);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aQF, this.aQK, this.mTitleText, this.aQC, this.aQD, this.aQI, this.mDuration, this.aQH);
            }
        }
    }

    public static void Ma() {
        com.baidu.swan.apps.res.widget.b.a.cancel();
        e.cancel();
    }

    public static int bx(Context context) {
        return z.getStatusBarHeight() + ((int) context.getResources().getDimension(a.d.aiapps_normal_base_action_bar_height));
    }
}
