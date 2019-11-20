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
    private static boolean aSN = com.baidu.swan.apps.b.DEBUG;
    private CharSequence bjo;
    private CharSequence bjp;
    private Drawable bjq;
    private Uri bjr;
    private int bjs;
    private a bjt;
    private boolean bjx;
    private Context mContext;
    private CharSequence mTitleText;
    private int bju = 2;
    private int bjv = 1;
    private int bjw = 1;
    private int mDuration = 2;
    private int mTextSize = 14;

    /* loaded from: classes2.dex */
    public interface a {
        void QU();
    }

    private d(Context context) {
        this.mContext = context;
    }

    public static d bx(@NonNull Context context) {
        return new d(context);
    }

    public static d a(@NonNull Context context, @NonNull CharSequence charSequence) {
        d dVar = new d(context);
        dVar.bjo = charSequence;
        return dVar;
    }

    public static d i(@NonNull Context context, @StringRes int i) {
        d dVar = new d(context);
        dVar.bjo = context.getText(i);
        return dVar;
    }

    public d eB(@NonNull int i) {
        this.bjs = i;
        return this;
    }

    public d cF(boolean z) {
        this.bjx = z;
        return this;
    }

    public d e(@NonNull CharSequence charSequence) {
        this.mTitleText = charSequence;
        return this;
    }

    public d f(@NonNull CharSequence charSequence) {
        this.bjo = charSequence;
        return this;
    }

    public d eC(int i) {
        this.bju = i;
        return this;
    }

    public d eD(int i) {
        this.bjv = i;
        return this;
    }

    public d eE(int i) {
        this.bjw = i;
        return this;
    }

    public d g(@NonNull CharSequence charSequence) {
        this.bjp = charSequence;
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
        this.bjt = aVar;
        return this;
    }

    public d c(@NonNull Drawable drawable) {
        this.bjq = drawable;
        return this;
    }

    public d eG(@DrawableRes int i) {
        if (this.mContext != null && this.mContext.getResources() != null) {
            this.bjq = this.mContext.getResources().getDrawable(i);
        }
        return this;
    }

    public d d(@NonNull Uri uri) {
        this.bjr = uri;
        return this;
    }

    private boolean QN() {
        if (this.mContext == null) {
            if (aSN) {
                throw new IllegalArgumentException("UniversalToast mContext is null!!!");
            }
            return false;
        } else if (this.bjo == null) {
            if (aSN) {
                throw new IllegalArgumentException("UniversalToast toast text is null!!!");
            }
            return false;
        } else {
            return true;
        }
    }

    public void QO() {
        cG(false);
    }

    public void QP() {
        if (QN()) {
            cancelToast();
            com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.bjo, this.mDuration, false, this.bjs, this.bjx);
        }
    }

    public void cG(boolean z) {
        if (QN()) {
            cancelToast();
            if (!z && (this.mContext instanceof Activity)) {
                e.a((Activity) this.mContext, this.bjo, this.mDuration, this.bjs, this.bjx);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.bjo, this.mDuration, true, this.bjs, this.bjx);
            }
        }
    }

    public void QQ() {
        cH(false);
    }

    public void cH(boolean z) {
        if (QN()) {
            cancelToast();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.bjo, this.mDuration);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.bjo, this.mDuration);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.bjo, this.mDuration);
            }
        }
    }

    public void QR() {
        cI(false);
    }

    public void cI(boolean z) {
        if (QN()) {
            cancelToast();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.bjo, this.bjq, this.mDuration, this.bjx);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.bjo, this.bjq, this.mDuration, this.bjx);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.bjo, this.bjq, this.mDuration, this.bjx);
            }
        }
    }

    public void QS() {
        cJ(false);
    }

    public void cJ(boolean z) {
        if (QN()) {
            cancelToast();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.bjo, this.mDuration, this.bjx);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.bjo, this.mDuration, this.bjx);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.bjo, this.mDuration, this.bjx);
            }
        }
    }

    public void QT() {
        cK(false);
    }

    public void cK(boolean z) {
        if (QN()) {
            cancelToast();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.bjr, this.bjw, this.mTitleText, this.bjo, this.bjp, this.bju, this.mDuration, this.bjt);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.bjr, this.bjw, this.mTitleText, this.bjo, this.bjp, this.bju, this.bjv, this.mDuration, this.bjt);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.bjr, this.bjw, this.mTitleText, this.bjo, this.bjp, this.bju, this.mDuration, this.bjt);
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
