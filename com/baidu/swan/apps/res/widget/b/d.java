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
/* loaded from: classes8.dex */
public class d {
    private static boolean mIsDebug = com.baidu.swan.apps.b.DEBUG;
    private CharSequence dER;
    private CharSequence dES;
    private Drawable dET;
    private Uri dEU;
    private int dEV;
    private a dEW;
    private boolean dFa;
    private Context mContext;
    private CharSequence mTitleText;
    private int dEX = 2;
    private int dEY = 1;
    private int dEZ = 1;
    private int mDuration = 2;
    private int mTextSize = 14;

    /* loaded from: classes8.dex */
    public interface a {
        void agu();
    }

    private d(Context context) {
        this.mContext = context;
    }

    public static d dl(@NonNull Context context) {
        return new d(context);
    }

    public static d a(@NonNull Context context, @NonNull CharSequence charSequence) {
        d dVar = new d(context);
        dVar.dER = charSequence;
        return dVar;
    }

    public static d u(@NonNull Context context, @StringRes int i) {
        d dVar = new d(context);
        dVar.dER = context.getText(i);
        return dVar;
    }

    public d jg(@NonNull int i) {
        this.dEV = i;
        return this;
    }

    public d hc(boolean z) {
        this.dFa = z;
        return this;
    }

    public d g(@NonNull CharSequence charSequence) {
        this.mTitleText = charSequence;
        return this;
    }

    public d h(@NonNull CharSequence charSequence) {
        this.dER = charSequence;
        return this;
    }

    public d jh(int i) {
        this.dEX = i;
        return this;
    }

    public d ji(int i) {
        this.dEY = i;
        return this;
    }

    public d jj(int i) {
        this.dEZ = i;
        return this;
    }

    public d i(@NonNull CharSequence charSequence) {
        this.dES = charSequence;
        return this;
    }

    public d jk(int i) {
        if (i < 1 || i > 10) {
            this.mDuration = 2;
        } else {
            this.mDuration = i;
        }
        return this;
    }

    public d b(a aVar) {
        this.dEW = aVar;
        return this;
    }

    public d i(@NonNull Drawable drawable) {
        this.dET = drawable;
        return this;
    }

    public d jl(@DrawableRes int i) {
        if (this.mContext != null && this.mContext.getResources() != null) {
            this.dET = this.mContext.getResources().getDrawable(i);
        }
        return this;
    }

    public d f(@NonNull Uri uri) {
        this.dEU = uri;
        return this;
    }

    private boolean aIu() {
        if (this.mContext == null) {
            if (mIsDebug) {
                throw new IllegalArgumentException("UniversalToast mContext is null!!!");
            }
            return false;
        } else if (this.dER == null) {
            if (mIsDebug) {
                throw new IllegalArgumentException("UniversalToast toast text is null!!!");
            }
            return false;
        } else {
            return true;
        }
    }

    public void aIv() {
        hd(false);
    }

    public void aIw() {
        if (aIu()) {
            cancelToast();
            com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dER, this.mDuration, false, this.dEV, this.dFa);
        }
    }

    public void hd(boolean z) {
        if (aIu()) {
            cancelToast();
            if (!z && (this.mContext instanceof Activity)) {
                e.a((Activity) this.mContext, this.dER, this.mDuration, this.dEV, this.dFa);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dER, this.mDuration, true, this.dEV, this.dFa);
            }
        }
    }

    public void aIx() {
        he(false);
    }

    public void he(boolean z) {
        if (aIu()) {
            cancelToast();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dER, this.mDuration);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.dER, this.mDuration);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dER, this.mDuration);
            }
        }
    }

    public void aIy() {
        hf(false);
    }

    public void hf(boolean z) {
        if (aIu()) {
            cancelToast();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dER, this.dET, this.mDuration, this.dFa);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.dER, this.dET, this.mDuration, this.dFa);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dER, this.dET, this.mDuration, this.dFa);
            }
        }
    }

    public void aIz() {
        hg(false);
    }

    public void hg(boolean z) {
        if (aIu()) {
            cancelToast();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dER, this.mDuration, this.dFa);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.dER, this.mDuration, this.dFa);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dER, this.mDuration, this.dFa);
            }
        }
    }

    public void aIA() {
        hh(false);
    }

    public void hh(boolean z) {
        if (aIu()) {
            cancelToast();
            if (!z && (this.mContext instanceof Activity)) {
                e.a((Activity) this.mContext, this.dER, this.mTextSize, this.dES, this.mDuration, this.dEW);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dER, this.mTextSize, this.dES, this.mDuration, this.dEW);
            }
        }
    }

    public void aIB() {
        hi(false);
    }

    public void hi(boolean z) {
        if (aIu()) {
            cancelToast();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dEU, this.dEZ, this.mTitleText, this.dER, this.dES, this.dEX, this.mDuration, this.dEW);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.dEU, this.dEZ, this.mTitleText, this.dER, this.dES, this.dEX, this.dEY, this.mDuration, this.dEW);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dEU, this.dEZ, this.mTitleText, this.dER, this.dES, this.dEX, this.mDuration, this.dEW);
            }
        }
    }

    public static void cancelToast() {
        com.baidu.swan.apps.res.widget.b.a.cancel();
        e.cancel();
    }

    public static int dm(Context context) {
        return ah.getStatusBarHeight() + ((int) context.getResources().getDimension(a.d.aiapps_normal_base_action_bar_height));
    }
}
