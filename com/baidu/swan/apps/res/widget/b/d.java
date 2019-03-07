package com.baidu.swan.apps.res.widget.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.b;
/* loaded from: classes2.dex */
public class d {
    private static boolean axR = com.baidu.swan.apps.c.DEBUG;
    private CharSequence aNm;
    private CharSequence aNn;
    private Drawable aNo;
    private Uri aNp;
    private int aNq;
    private a aNr;
    private boolean aNv;
    private Context mContext;
    private CharSequence mTitleText;
    private int aNs = 2;
    private int aNt = 1;
    private int aNu = 1;
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
        dVar.aNm = charSequence;
        return dVar;
    }

    public static d l(@NonNull Context context, @StringRes int i) {
        d dVar = new d(context);
        dVar.aNm = context.getText(i);
        return dVar;
    }

    public d ds(@NonNull int i) {
        this.aNq = i;
        return this;
    }

    public d bY(boolean z) {
        this.aNv = z;
        return this;
    }

    public d e(@NonNull CharSequence charSequence) {
        this.mTitleText = charSequence;
        return this;
    }

    public d f(@NonNull CharSequence charSequence) {
        this.aNm = charSequence;
        return this;
    }

    public d dt(int i) {
        this.aNs = i;
        return this;
    }

    public d du(int i) {
        this.aNt = i;
        return this;
    }

    public d dv(int i) {
        this.aNu = i;
        return this;
    }

    public d g(@NonNull CharSequence charSequence) {
        this.aNn = charSequence;
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
        this.aNr = aVar;
        return this;
    }

    public d e(@NonNull Drawable drawable) {
        this.aNo = drawable;
        return this;
    }

    public d dx(@DrawableRes int i) {
        if (this.mContext != null && this.mContext.getResources() != null) {
            this.aNo = this.mContext.getResources().getDrawable(i);
        }
        return this;
    }

    public d f(@NonNull Uri uri) {
        this.aNp = uri;
        return this;
    }

    private boolean IJ() {
        if (this.mContext == null) {
            if (axR) {
                throw new IllegalArgumentException("UniversalToast mContext is null!!!");
            }
            return false;
        } else if (this.aNm == null) {
            if (axR) {
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
            com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNm, this.mDuration, false, this.aNq, this.aNv);
        }
    }

    public void bZ(boolean z) {
        if (IJ()) {
            IQ();
            if (!z && (this.mContext instanceof Activity)) {
                e.a((Activity) this.mContext, this.aNm, this.mDuration, this.aNq, this.aNv);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNm, this.mDuration, true, this.aNq, this.aNv);
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
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNm, this.mDuration);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.aNm, this.mDuration);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNm, this.mDuration);
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
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNm, this.aNo, this.mDuration, this.aNv);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.aNm, this.aNo, this.mDuration, this.aNv);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNm, this.aNo, this.mDuration, this.aNv);
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
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNm, this.mDuration, this.aNv);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.aNm, this.mDuration, this.aNv);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNm, this.mDuration, this.aNv);
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
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNp, this.aNu, this.mTitleText, this.aNm, this.aNn, this.aNs, this.mDuration, this.aNr);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.aNp, this.aNu, this.mTitleText, this.aNm, this.aNn, this.aNs, this.aNt, this.mDuration, this.aNr);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNp, this.aNu, this.mTitleText, this.aNm, this.aNn, this.aNs, this.mDuration, this.aNr);
            }
        }
    }

    public static void IQ() {
        com.baidu.swan.apps.res.widget.b.a.cancel();
        e.cancel();
    }

    public static int bY(Context context) {
        return x.getStatusBarHeight() + ((int) context.getResources().getDimension(b.d.aiapps_normal_base_action_bar_height));
    }
}
