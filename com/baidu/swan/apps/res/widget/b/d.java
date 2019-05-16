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
    private static boolean ayM = com.baidu.swan.apps.b.DEBUG;
    private boolean aPD;
    private CharSequence aPu;
    private CharSequence aPv;
    private Drawable aPw;
    private Uri aPx;
    private int aPy;
    private a aPz;
    private Context mContext;
    private CharSequence mTitleText;
    private int aPA = 2;
    private int aPB = 1;
    private int aPC = 1;
    private int mDuration = 2;
    private int mTextSize = 14;

    /* loaded from: classes2.dex */
    public interface a {
        void Lk();
    }

    private d(Context context) {
        this.mContext = context;
    }

    public static d bw(@NonNull Context context) {
        return new d(context);
    }

    public static d a(@NonNull Context context, @NonNull CharSequence charSequence) {
        d dVar = new d(context);
        dVar.aPu = charSequence;
        return dVar;
    }

    public static d k(@NonNull Context context, @StringRes int i) {
        d dVar = new d(context);
        dVar.aPu = context.getText(i);
        return dVar;
    }

    public d dC(@NonNull int i) {
        this.aPy = i;
        return this;
    }

    public d cl(boolean z) {
        this.aPD = z;
        return this;
    }

    public d e(@NonNull CharSequence charSequence) {
        this.mTitleText = charSequence;
        return this;
    }

    public d f(@NonNull CharSequence charSequence) {
        this.aPu = charSequence;
        return this;
    }

    public d dD(int i) {
        this.aPA = i;
        return this;
    }

    public d dE(int i) {
        this.aPB = i;
        return this;
    }

    public d dF(int i) {
        this.aPC = i;
        return this;
    }

    public d g(@NonNull CharSequence charSequence) {
        this.aPv = charSequence;
        return this;
    }

    public d dG(int i) {
        if (i < 1 || i > 10) {
            this.mDuration = 2;
        } else {
            this.mDuration = i;
        }
        return this;
    }

    public d b(a aVar) {
        this.aPz = aVar;
        return this;
    }

    public d d(@NonNull Drawable drawable) {
        this.aPw = drawable;
        return this;
    }

    public d dH(@DrawableRes int i) {
        if (this.mContext != null && this.mContext.getResources() != null) {
            this.aPw = this.mContext.getResources().getDrawable(i);
        }
        return this;
    }

    public d f(@NonNull Uri uri) {
        this.aPx = uri;
        return this;
    }

    private boolean Lc() {
        if (this.mContext == null) {
            if (ayM) {
                throw new IllegalArgumentException("UniversalToast mContext is null!!!");
            }
            return false;
        } else if (this.aPu == null) {
            if (ayM) {
                throw new IllegalArgumentException("UniversalToast toast text is null!!!");
            }
            return false;
        } else {
            return true;
        }
    }

    public void Ld() {
        cm(false);
    }

    public void Le() {
        if (Lc()) {
            Lj();
            com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aPu, this.mDuration, false, this.aPy, this.aPD);
        }
    }

    public void cm(boolean z) {
        if (Lc()) {
            Lj();
            if (!z && (this.mContext instanceof Activity)) {
                e.a((Activity) this.mContext, this.aPu, this.mDuration, this.aPy, this.aPD);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aPu, this.mDuration, true, this.aPy, this.aPD);
            }
        }
    }

    public void Lf() {
        cn(false);
    }

    public void cn(boolean z) {
        if (Lc()) {
            Lj();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aPu, this.mDuration);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.aPu, this.mDuration);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aPu, this.mDuration);
            }
        }
    }

    public void Lg() {
        co(false);
    }

    public void co(boolean z) {
        if (Lc()) {
            Lj();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aPu, this.aPw, this.mDuration, this.aPD);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.aPu, this.aPw, this.mDuration, this.aPD);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aPu, this.aPw, this.mDuration, this.aPD);
            }
        }
    }

    public void Lh() {
        cp(false);
    }

    public void cp(boolean z) {
        if (Lc()) {
            Lj();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aPu, this.mDuration, this.aPD);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.aPu, this.mDuration, this.aPD);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aPu, this.mDuration, this.aPD);
            }
        }
    }

    public void Li() {
        cq(false);
    }

    public void cq(boolean z) {
        if (Lc()) {
            Lj();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aPx, this.aPC, this.mTitleText, this.aPu, this.aPv, this.aPA, this.mDuration, this.aPz);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.aPx, this.aPC, this.mTitleText, this.aPu, this.aPv, this.aPA, this.aPB, this.mDuration, this.aPz);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aPx, this.aPC, this.mTitleText, this.aPu, this.aPv, this.aPA, this.mDuration, this.aPz);
            }
        }
    }

    public static void Lj() {
        com.baidu.swan.apps.res.widget.b.a.cancel();
        e.cancel();
    }

    public static int bx(Context context) {
        return z.getStatusBarHeight() + ((int) context.getResources().getDimension(a.d.aiapps_normal_base_action_bar_height));
    }
}
