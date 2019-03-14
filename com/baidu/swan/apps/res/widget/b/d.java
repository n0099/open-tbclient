package com.baidu.swan.apps.res.widget.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.x;
/* loaded from: classes2.dex */
public class d {
    private static boolean axS = com.baidu.swan.apps.b.DEBUG;
    private CharSequence aNn;
    private CharSequence aNo;
    private Drawable aNp;
    private Uri aNq;
    private int aNr;
    private a aNs;
    private boolean aNw;
    private Context mContext;
    private CharSequence mTitleText;
    private int aNt = 2;
    private int aNu = 1;
    private int aNv = 1;
    private int mDuration = 2;
    private int mTextSize = 14;

    /* loaded from: classes2.dex */
    public interface a {
        void IR();
    }

    private d(Context context) {
        this.mContext = context;
    }

    public static d bX(@NonNull Context context) {
        return new d(context);
    }

    public static d a(@NonNull Context context, @NonNull CharSequence charSequence) {
        d dVar = new d(context);
        dVar.aNn = charSequence;
        return dVar;
    }

    public static d l(@NonNull Context context, @StringRes int i) {
        d dVar = new d(context);
        dVar.aNn = context.getText(i);
        return dVar;
    }

    public d ds(@NonNull int i) {
        this.aNr = i;
        return this;
    }

    public d bY(boolean z) {
        this.aNw = z;
        return this;
    }

    public d e(@NonNull CharSequence charSequence) {
        this.mTitleText = charSequence;
        return this;
    }

    public d f(@NonNull CharSequence charSequence) {
        this.aNn = charSequence;
        return this;
    }

    public d dt(int i) {
        this.aNt = i;
        return this;
    }

    public d du(int i) {
        this.aNu = i;
        return this;
    }

    public d dv(int i) {
        this.aNv = i;
        return this;
    }

    public d g(@NonNull CharSequence charSequence) {
        this.aNo = charSequence;
        return this;
    }

    public d dw(int i) {
        if (i < 1 || i > 10) {
            this.mDuration = 2;
        } else {
            this.mDuration = i;
        }
        return this;
    }

    public d b(a aVar) {
        this.aNs = aVar;
        return this;
    }

    public d e(@NonNull Drawable drawable) {
        this.aNp = drawable;
        return this;
    }

    public d dx(@DrawableRes int i) {
        if (this.mContext != null && this.mContext.getResources() != null) {
            this.aNp = this.mContext.getResources().getDrawable(i);
        }
        return this;
    }

    public d f(@NonNull Uri uri) {
        this.aNq = uri;
        return this;
    }

    private boolean IJ() {
        if (this.mContext == null) {
            if (axS) {
                throw new IllegalArgumentException("UniversalToast mContext is null!!!");
            }
            return false;
        } else if (this.aNn == null) {
            if (axS) {
                throw new IllegalArgumentException("UniversalToast toast text is null!!!");
            }
            return false;
        } else {
            return true;
        }
    }

    public void IK() {
        bZ(false);
    }

    public void IL() {
        if (IJ()) {
            IQ();
            com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNn, this.mDuration, false, this.aNr, this.aNw);
        }
    }

    public void bZ(boolean z) {
        if (IJ()) {
            IQ();
            if (!z && (this.mContext instanceof Activity)) {
                e.a((Activity) this.mContext, this.aNn, this.mDuration, this.aNr, this.aNw);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNn, this.mDuration, true, this.aNr, this.aNw);
            }
        }
    }

    public void IM() {
        ca(false);
    }

    public void ca(boolean z) {
        if (IJ()) {
            IQ();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNn, this.mDuration);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.aNn, this.mDuration);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNn, this.mDuration);
            }
        }
    }

    public void IN() {
        cb(false);
    }

    public void cb(boolean z) {
        if (IJ()) {
            IQ();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNn, this.aNp, this.mDuration, this.aNw);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.aNn, this.aNp, this.mDuration, this.aNw);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNn, this.aNp, this.mDuration, this.aNw);
            }
        }
    }

    public void IO() {
        cc(false);
    }

    public void cc(boolean z) {
        if (IJ()) {
            IQ();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNn, this.mDuration, this.aNw);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.aNn, this.mDuration, this.aNw);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNn, this.mDuration, this.aNw);
            }
        }
    }

    public void IP() {
        cd(false);
    }

    public void cd(boolean z) {
        if (IJ()) {
            IQ();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNq, this.aNv, this.mTitleText, this.aNn, this.aNo, this.aNt, this.mDuration, this.aNs);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.aNq, this.aNv, this.mTitleText, this.aNn, this.aNo, this.aNt, this.aNu, this.mDuration, this.aNs);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNq, this.aNv, this.mTitleText, this.aNn, this.aNo, this.aNt, this.mDuration, this.aNs);
            }
        }
    }

    public static void IQ() {
        com.baidu.swan.apps.res.widget.b.a.cancel();
        e.cancel();
    }

    public static int bY(Context context) {
        return x.getStatusBarHeight() + ((int) context.getResources().getDimension(a.d.aiapps_normal_base_action_bar_height));
    }
}
