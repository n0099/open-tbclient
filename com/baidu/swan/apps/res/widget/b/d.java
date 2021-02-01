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
    private static boolean mIsDebug = com.baidu.swan.apps.b.DEBUG;
    private CharSequence dDq;
    private CharSequence dDr;
    private Drawable dDs;
    private Uri dDt;
    private int dDu;
    private a dDv;
    private boolean dDz;
    private Context mContext;
    private CharSequence mTitleText;
    private int dDw = 2;
    private int dDx = 1;
    private int dDy = 1;
    private int mDuration = 2;
    private int mTextSize = 14;

    /* loaded from: classes9.dex */
    public interface a {
        void agr();
    }

    private d(Context context) {
        this.mContext = context;
    }

    public static d dm(@NonNull Context context) {
        return new d(context);
    }

    public static d a(@NonNull Context context, @NonNull CharSequence charSequence) {
        d dVar = new d(context);
        dVar.dDq = charSequence;
        return dVar;
    }

    public static d u(@NonNull Context context, @StringRes int i) {
        d dVar = new d(context);
        dVar.dDq = context.getText(i);
        return dVar;
    }

    public d jf(@NonNull int i) {
        this.dDu = i;
        return this;
    }

    public d hc(boolean z) {
        this.dDz = z;
        return this;
    }

    public d g(@NonNull CharSequence charSequence) {
        this.mTitleText = charSequence;
        return this;
    }

    public d h(@NonNull CharSequence charSequence) {
        this.dDq = charSequence;
        return this;
    }

    public d jg(int i) {
        this.dDw = i;
        return this;
    }

    public d jh(int i) {
        this.dDx = i;
        return this;
    }

    public d ji(int i) {
        this.dDy = i;
        return this;
    }

    public d i(@NonNull CharSequence charSequence) {
        this.dDr = charSequence;
        return this;
    }

    public d jj(int i) {
        if (i < 1 || i > 10) {
            this.mDuration = 2;
        } else {
            this.mDuration = i;
        }
        return this;
    }

    public d b(a aVar) {
        this.dDv = aVar;
        return this;
    }

    public d i(@NonNull Drawable drawable) {
        this.dDs = drawable;
        return this;
    }

    public d jk(@DrawableRes int i) {
        if (this.mContext != null && this.mContext.getResources() != null) {
            this.dDs = this.mContext.getResources().getDrawable(i);
        }
        return this;
    }

    public d f(@NonNull Uri uri) {
        this.dDt = uri;
        return this;
    }

    private boolean aIr() {
        if (this.mContext == null) {
            if (mIsDebug) {
                throw new IllegalArgumentException("UniversalToast mContext is null!!!");
            }
            return false;
        } else if (this.dDq == null) {
            if (mIsDebug) {
                throw new IllegalArgumentException("UniversalToast toast text is null!!!");
            }
            return false;
        } else {
            return true;
        }
    }

    public void aIs() {
        hd(false);
    }

    public void aIt() {
        if (aIr()) {
            cancelToast();
            com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dDq, this.mDuration, false, this.dDu, this.dDz);
        }
    }

    public void hd(boolean z) {
        if (aIr()) {
            cancelToast();
            if (!z && (this.mContext instanceof Activity)) {
                e.a((Activity) this.mContext, this.dDq, this.mDuration, this.dDu, this.dDz);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dDq, this.mDuration, true, this.dDu, this.dDz);
            }
        }
    }

    public void aIu() {
        he(false);
    }

    public void he(boolean z) {
        if (aIr()) {
            cancelToast();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dDq, this.mDuration);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.dDq, this.mDuration);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dDq, this.mDuration);
            }
        }
    }

    public void aIv() {
        hf(false);
    }

    public void hf(boolean z) {
        if (aIr()) {
            cancelToast();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dDq, this.dDs, this.mDuration, this.dDz);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.dDq, this.dDs, this.mDuration, this.dDz);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dDq, this.dDs, this.mDuration, this.dDz);
            }
        }
    }

    public void aIw() {
        hg(false);
    }

    public void hg(boolean z) {
        if (aIr()) {
            cancelToast();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dDq, this.mDuration, this.dDz);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.dDq, this.mDuration, this.dDz);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dDq, this.mDuration, this.dDz);
            }
        }
    }

    public void aIx() {
        hh(false);
    }

    public void hh(boolean z) {
        if (aIr()) {
            cancelToast();
            if (!z && (this.mContext instanceof Activity)) {
                e.a((Activity) this.mContext, this.dDq, this.mTextSize, this.dDr, this.mDuration, this.dDv);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dDq, this.mTextSize, this.dDr, this.mDuration, this.dDv);
            }
        }
    }

    public void aIy() {
        hi(false);
    }

    public void hi(boolean z) {
        if (aIr()) {
            cancelToast();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dDt, this.dDy, this.mTitleText, this.dDq, this.dDr, this.dDw, this.mDuration, this.dDv);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.dDt, this.dDy, this.mTitleText, this.dDq, this.dDr, this.dDw, this.dDx, this.mDuration, this.dDv);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dDt, this.dDy, this.mTitleText, this.dDq, this.dDr, this.dDw, this.mDuration, this.dDv);
            }
        }
    }

    public static void cancelToast() {
        com.baidu.swan.apps.res.widget.b.a.cancel();
        e.cancel();
    }

    public static int dn(Context context) {
        return ah.getStatusBarHeight() + ((int) context.getResources().getDimension(a.d.aiapps_normal_base_action_bar_height));
    }
}
