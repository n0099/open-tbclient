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
    private static boolean dBc = com.baidu.swan.apps.b.DEBUG;
    private CharSequence dBm;
    private CharSequence dBn;
    private Drawable dBo;
    private Uri dBp;
    private int dBq;
    private a dBr;
    private boolean dBv;
    private Context mContext;
    private CharSequence mTitleText;
    private int dBs = 2;
    private int dBt = 1;
    private int dBu = 1;
    private int mDuration = 2;
    private int mTextSize = 14;

    /* loaded from: classes8.dex */
    public interface a {
        void afT();
    }

    private d(Context context) {
        this.mContext = context;
    }

    public static d dn(@NonNull Context context) {
        return new d(context);
    }

    public static d a(@NonNull Context context, @NonNull CharSequence charSequence) {
        d dVar = new d(context);
        dVar.dBm = charSequence;
        return dVar;
    }

    public static d u(@NonNull Context context, @StringRes int i) {
        d dVar = new d(context);
        dVar.dBm = context.getText(i);
        return dVar;
    }

    public d jc(@NonNull int i) {
        this.dBq = i;
        return this;
    }

    public d ha(boolean z) {
        this.dBv = z;
        return this;
    }

    public d g(@NonNull CharSequence charSequence) {
        this.mTitleText = charSequence;
        return this;
    }

    public d h(@NonNull CharSequence charSequence) {
        this.dBm = charSequence;
        return this;
    }

    public d jd(int i) {
        this.dBs = i;
        return this;
    }

    public d je(int i) {
        this.dBt = i;
        return this;
    }

    public d jf(int i) {
        this.dBu = i;
        return this;
    }

    public d i(@NonNull CharSequence charSequence) {
        this.dBn = charSequence;
        return this;
    }

    public d jg(int i) {
        if (i < 1 || i > 10) {
            this.mDuration = 2;
        } else {
            this.mDuration = i;
        }
        return this;
    }

    public d b(a aVar) {
        this.dBr = aVar;
        return this;
    }

    public d i(@NonNull Drawable drawable) {
        this.dBo = drawable;
        return this;
    }

    public d jh(@DrawableRes int i) {
        if (this.mContext != null && this.mContext.getResources() != null) {
            this.dBo = this.mContext.getResources().getDrawable(i);
        }
        return this;
    }

    public d f(@NonNull Uri uri) {
        this.dBp = uri;
        return this;
    }

    private boolean aHY() {
        if (this.mContext == null) {
            if (dBc) {
                throw new IllegalArgumentException("UniversalToast mContext is null!!!");
            }
            return false;
        } else if (this.dBm == null) {
            if (dBc) {
                throw new IllegalArgumentException("UniversalToast toast text is null!!!");
            }
            return false;
        } else {
            return true;
        }
    }

    public void aHZ() {
        hb(false);
    }

    public void aIa() {
        if (aHY()) {
            cancelToast();
            com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dBm, this.mDuration, false, this.dBq, this.dBv);
        }
    }

    public void hb(boolean z) {
        if (aHY()) {
            cancelToast();
            if (!z && (this.mContext instanceof Activity)) {
                e.a((Activity) this.mContext, this.dBm, this.mDuration, this.dBq, this.dBv);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dBm, this.mDuration, true, this.dBq, this.dBv);
            }
        }
    }

    public void aIb() {
        hc(false);
    }

    public void hc(boolean z) {
        if (aHY()) {
            cancelToast();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dBm, this.mDuration);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.dBm, this.mDuration);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dBm, this.mDuration);
            }
        }
    }

    public void aIc() {
        hd(false);
    }

    public void hd(boolean z) {
        if (aHY()) {
            cancelToast();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dBm, this.dBo, this.mDuration, this.dBv);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.dBm, this.dBo, this.mDuration, this.dBv);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dBm, this.dBo, this.mDuration, this.dBv);
            }
        }
    }

    public void aId() {
        he(false);
    }

    public void he(boolean z) {
        if (aHY()) {
            cancelToast();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dBm, this.mDuration, this.dBv);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.dBm, this.mDuration, this.dBv);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dBm, this.mDuration, this.dBv);
            }
        }
    }

    public void aIe() {
        hf(false);
    }

    public void hf(boolean z) {
        if (aHY()) {
            cancelToast();
            if (!z && (this.mContext instanceof Activity)) {
                e.a((Activity) this.mContext, this.dBm, this.mTextSize, this.dBn, this.mDuration, this.dBr);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dBm, this.mTextSize, this.dBn, this.mDuration, this.dBr);
            }
        }
    }

    public void aIf() {
        hg(false);
    }

    public void hg(boolean z) {
        if (aHY()) {
            cancelToast();
            if (z) {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dBp, this.dBu, this.mTitleText, this.dBm, this.dBn, this.dBs, this.mDuration, this.dBr);
            } else if (this.mContext instanceof Activity) {
                e.a((Activity) this.mContext, this.dBp, this.dBu, this.mTitleText, this.dBm, this.dBn, this.dBs, this.dBt, this.mDuration, this.dBr);
            } else {
                com.baidu.swan.apps.res.widget.b.a.a(this.mContext, this.dBp, this.dBu, this.mTitleText, this.dBm, this.dBn, this.dBs, this.mDuration, this.dBr);
            }
        }
    }

    public static void cancelToast() {
        com.baidu.swan.apps.res.widget.b.a.cancel();
        e.cancel();
    }

    /* renamed from: do  reason: not valid java name */
    public static int m27do(Context context) {
        return ah.getStatusBarHeight() + ((int) context.getResources().getDimension(a.d.aiapps_normal_base_action_bar_height));
    }
}
