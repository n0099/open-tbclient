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
    private static boolean aTf = com.baidu.swan.apps.b.DEBUG;
    private CharSequence bjG;
    private CharSequence bjH;
    private Drawable bjI;
    private Uri bjJ;
    private int bjK;
    private a bjL;
    private boolean bjP;
    private Context mContext;
    private CharSequence mTitleText;
    private int bjM = 2;
    private int bjN = 1;
    private int bjO = 1;
    private int mDuration = 2;
    private int mTextSize = 14;

    /* loaded from: classes2.dex */
    public interface a {
        void QT();
    }

    private d(Context context) {
        this.mContext = context;
    }

    public static d bx(@NonNull Context context) {
        return new d(context);
    }

    public static d a(@NonNull Context context, @NonNull CharSequence charSequence) {
        d dVar = new d(context);
        dVar.bjG = charSequence;
        return dVar;
    }

    public static d i(@NonNull Context context, @StringRes int i) {
        d dVar = new d(context);
        dVar.bjG = context.getText(i);
        return dVar;
    }

    public d eB(@NonNull int i) {
        this.bjK = i;
        return this;
    }

    public d cF(boolean z) {
        this.bjP = z;
        return this;
    }

    public d e(@NonNull CharSequence charSequence) {
        this.mTitleText = charSequence;
        return this;
    }

    public d f(@NonNull CharSequence charSequence) {
        this.bjG = charSequence;
        return this;
    }

    public d eC(int i) {
        this.bjM = i;
        return this;
    }

    public d eD(int i) {
        this.bjN = i;
        return this;
    }

    public d eE(int i) {
        this.bjO = i;
        return this;
    }

    public d g(@NonNull CharSequence charSequence) {
        this.bjH = charSequence;
        return this;
    }

    public d eF(int i) {
        if (i < 1 || i > 10) {
            this.mDuration = 2;
        } else {
            this.mDuration = i;
        }
        return this;
    }

    public d b(a aVar) {
        this.bjL = aVar;
        return this;
    }

    public d b(@NonNull Drawable drawable) {
        this.bjI = drawable;
        return this;
    }

    public d eG(@DrawableRes int i) {
        if (this.mContext != null && this.mContext.getResources() != null) {
            this.bjI = this.mContext.getResources().getDrawable(i);
        }
        return this;
    }

    public d d(@NonNull Uri uri) {
        this.bjJ = uri;
        return this;
    }

    private boolean QM() {
        if (this.mContext == null) {
            if (aTf) {
                throw new IllegalArgumentException("UniversalToast mContext is null!!!");
            }
            return false;
        } else if (this.bjG == null) {
            if (aTf) {
                throw new IllegalArgumentException("UniversalToast toast text is null!!!");
            }
            return false;
        } else {
            return true;
        }
    }

    public void QN() {
        cG(false);
    }

    public void QO() {
        if (QM()) {
            cancelToast();
            com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.bjG, this.mDuration, false, this.bjK, this.bjP);
        }
    }

    public void cG(boolean z) {
        if (QM()) {
            cancelToast();
            if (!z && (this.mContext instanceof Activity)) {
                e.a((Activity) this.mContext, this.bjG, this.mDuration, this.bjK, this.bjP);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.bjG, this.mDuration, true, this.bjK, this.bjP);
            }
        }
    }

    public void QP() {
        cH(false);
    }

    public void cH(boolean z) {
        if (QM()) {
            cancelToast();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.bjG, this.mDuration);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.bjG, this.mDuration);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.bjG, this.mDuration);
            }
        }
    }

    public void QQ() {
        cI(false);
    }

    public void cI(boolean z) {
        if (QM()) {
            cancelToast();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.bjG, this.bjI, this.mDuration, this.bjP);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.bjG, this.bjI, this.mDuration, this.bjP);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.bjG, this.bjI, this.mDuration, this.bjP);
            }
        }
    }

    public void QR() {
        cJ(false);
    }

    public void cJ(boolean z) {
        if (QM()) {
            cancelToast();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.bjG, this.mDuration, this.bjP);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.bjG, this.mDuration, this.bjP);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.bjG, this.mDuration, this.bjP);
            }
        }
    }

    public void QS() {
        cK(false);
    }

    public void cK(boolean z) {
        if (QM()) {
            cancelToast();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.bjJ, this.bjO, this.mTitleText, this.bjG, this.bjH, this.bjM, this.mDuration, this.bjL);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.bjJ, this.bjO, this.mTitleText, this.bjG, this.bjH, this.bjM, this.bjN, this.mDuration, this.bjL);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.bjJ, this.bjO, this.mTitleText, this.bjG, this.bjH, this.bjM, this.mDuration, this.bjL);
            }
        }
    }

    public static void cancelToast() {
        com.baidu.swan.apps.res.widget.b.a.cancel();
        e.cancel();
    }

    public static int by(Context context) {
        return z.getStatusBarHeight() + ((int) context.getResources().getDimension(a.d.aiapps_normal_base_action_bar_height));
    }
}
