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
    private static boolean axV = com.baidu.swan.apps.b.DEBUG;
    private CharSequence aNq;
    private CharSequence aNr;
    private Drawable aNs;
    private Uri aNt;
    private int aNu;
    private a aNv;
    private boolean aNz;
    private Context mContext;
    private CharSequence mTitleText;
    private int aNw = 2;
    private int aNx = 1;
    private int aNy = 1;
    private int mDuration = 2;
    private int mTextSize = 14;

    /* loaded from: classes2.dex */
    public interface a {
        void IP();
    }

    private d(Context context) {
        this.mContext = context;
    }

    public static d bX(@NonNull Context context) {
        return new d(context);
    }

    public static d a(@NonNull Context context, @NonNull CharSequence charSequence) {
        d dVar = new d(context);
        dVar.aNq = charSequence;
        return dVar;
    }

    public static d l(@NonNull Context context, @StringRes int i) {
        d dVar = new d(context);
        dVar.aNq = context.getText(i);
        return dVar;
    }

    public d dr(@NonNull int i) {
        this.aNu = i;
        return this;
    }

    public d bY(boolean z) {
        this.aNz = z;
        return this;
    }

    public d e(@NonNull CharSequence charSequence) {
        this.mTitleText = charSequence;
        return this;
    }

    public d f(@NonNull CharSequence charSequence) {
        this.aNq = charSequence;
        return this;
    }

    public d ds(int i) {
        this.aNw = i;
        return this;
    }

    public d dt(int i) {
        this.aNx = i;
        return this;
    }

    public d du(int i) {
        this.aNy = i;
        return this;
    }

    public d g(@NonNull CharSequence charSequence) {
        this.aNr = charSequence;
        return this;
    }

    public d dv(int i) {
        if (i < 1 || i > 10) {
            this.mDuration = 2;
        } else {
            this.mDuration = i;
        }
        return this;
    }

    public d b(a aVar) {
        this.aNv = aVar;
        return this;
    }

    public d e(@NonNull Drawable drawable) {
        this.aNs = drawable;
        return this;
    }

    public d dw(@DrawableRes int i) {
        if (this.mContext != null && this.mContext.getResources() != null) {
            this.aNs = this.mContext.getResources().getDrawable(i);
        }
        return this;
    }

    public d f(@NonNull Uri uri) {
        this.aNt = uri;
        return this;
    }

    private boolean IH() {
        if (this.mContext == null) {
            if (axV) {
                throw new IllegalArgumentException("UniversalToast mContext is null!!!");
            }
            return false;
        } else if (this.aNq == null) {
            if (axV) {
                throw new IllegalArgumentException("UniversalToast toast text is null!!!");
            }
            return false;
        } else {
            return true;
        }
    }

    public void II() {
        bZ(false);
    }

    public void IJ() {
        if (IH()) {
            IO();
            com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNq, this.mDuration, false, this.aNu, this.aNz);
        }
    }

    public void bZ(boolean z) {
        if (IH()) {
            IO();
            if (!z && (this.mContext instanceof Activity)) {
                e.a((Activity) this.mContext, this.aNq, this.mDuration, this.aNu, this.aNz);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNq, this.mDuration, true, this.aNu, this.aNz);
            }
        }
    }

    public void IK() {
        ca(false);
    }

    public void ca(boolean z) {
        if (IH()) {
            IO();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNq, this.mDuration);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.aNq, this.mDuration);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNq, this.mDuration);
            }
        }
    }

    public void IL() {
        cb(false);
    }

    public void cb(boolean z) {
        if (IH()) {
            IO();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNq, this.aNs, this.mDuration, this.aNz);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.aNq, this.aNs, this.mDuration, this.aNz);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNq, this.aNs, this.mDuration, this.aNz);
            }
        }
    }

    public void IM() {
        cc(false);
    }

    public void cc(boolean z) {
        if (IH()) {
            IO();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNq, this.mDuration, this.aNz);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.aNq, this.mDuration, this.aNz);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNq, this.mDuration, this.aNz);
            }
        }
    }

    public void IN() {
        cd(false);
    }

    public void cd(boolean z) {
        if (IH()) {
            IO();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNt, this.aNy, this.mTitleText, this.aNq, this.aNr, this.aNw, this.mDuration, this.aNv);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.aNt, this.aNy, this.mTitleText, this.aNq, this.aNr, this.aNw, this.aNx, this.mDuration, this.aNv);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.aNt, this.aNy, this.mTitleText, this.aNq, this.aNr, this.aNw, this.mDuration, this.aNv);
            }
        }
    }

    public static void IO() {
        com.baidu.swan.apps.res.widget.b.a.cancel();
        e.cancel();
    }

    public static int bY(Context context) {
        return x.getStatusBarHeight() + ((int) context.getResources().getDimension(a.d.aiapps_normal_base_action_bar_height));
    }
}
