package com.baidu.tbadk.core.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.lang.ref.SoftReference;
import java.util.HashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class BdToast {
    private static SoftReference<Toast> bOg;
    private static HashMap<DefaultIcon, Integer> bOj = new HashMap<>(2);
    private Toast El;
    private final Context mContext;
    private final ImageView mIconView;
    private final ViewGroup mRootView;
    private CharSequence mText;
    private final TextView mTextView;
    private int mIconResId = -1;
    private boolean bOh = false;
    private int mGravity = 16;
    private int mDuration = 0;
    private int zQ = 0;
    private int zR = 0;
    private int bOi = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT
    }

    static {
        bOj.put(DefaultIcon.SUCCESS, Integer.valueOf((int) R.drawable.icon_pure_toast_succeed_n_svg));
        bOj.put(DefaultIcon.FAILURE, Integer.valueOf((int) R.drawable.icon_pure_toast_mistake_n_svg));
        bOj.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.mRootView = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.dialog_bdtoast, (ViewGroup) null);
        this.mIconView = (ImageView) this.mRootView.findViewById(R.id.toast_icon);
        this.mTextView = (TextView) this.mRootView.findViewById(R.id.toast_message);
    }

    public BdToast h(CharSequence charSequence) {
        this.mText = charSequence;
        this.mTextView.setText(this.mText);
        return this;
    }

    public void hF(int i) {
        this.bOi = i;
    }

    public BdToast r(int i, boolean z) {
        this.mIconResId = i;
        this.bOh = z;
        return this;
    }

    public BdToast hG(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast hH(int i) {
        this.mDuration = i;
        return this;
    }

    public void setOffsetY(int i) {
        this.zR = i;
    }

    public void am(float f) {
        this.mTextView.setLineSpacing(0.0f, f);
    }

    public BdToast agU() {
        this.El = new Toast(this.mContext);
        agV();
        if (this.mIconResId != -1) {
            if (this.bOh) {
                SvgManager.ajv().a(this.mIconView, this.mIconResId, R.color.cp_cont_a, null);
            } else {
                am.c(this.mIconView, this.mIconResId);
            }
            this.mIconView.setVisibility(0);
        } else {
            this.mIconView.setVisibility(8);
        }
        this.mRootView.setBackgroundDrawable(am.X(com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds32), am.getColor(R.color.cp_hud_a)));
        am.f(this.mTextView, R.color.cp_cont_a, 1);
        this.mTextView.setText(this.mText);
        this.El.setGravity(this.mGravity, this.zQ, this.zR);
        this.El.setDuration(this.mDuration);
        hJ(this.bOi);
        this.El.setView(this.mRootView);
        return this;
    }

    public BdToast hI(int i) {
        this.El = new Toast(this.mContext);
        agV();
        if (this.mIconResId != -1) {
            if (this.bOh) {
                SvgManager.ajv().a(this.mIconView, this.mIconResId, R.color.cp_cont_a, null);
            } else {
                am.c(this.mIconView, this.mIconResId);
            }
            this.mIconView.setVisibility(0);
        } else {
            this.mIconView.setVisibility(8);
        }
        am.d(this.mTextView, R.color.cp_cont_a, 1, i);
        this.mTextView.setText(this.mText);
        this.El.setGravity(this.mGravity, this.zQ, this.zR);
        this.El.setDuration(this.mDuration);
        hJ(this.bOi);
        this.El.setView(this.mRootView);
        return this;
    }

    private void agV() {
        if (bOg != null && bOg.get() != null) {
            bOg.get().cancel();
        }
        bOg = new SoftReference<>(this.El);
    }

    private void hJ(int i) {
        if (i > 0) {
            this.mRootView.setPadding(i, this.mRootView.getTop(), i, this.mRootView.getBottom());
        }
    }

    public BdToast agW() {
        this.mTextView.setText(this.mText);
        this.El.setGravity(this.mGravity, this.zQ, this.zR);
        this.El.setDuration(this.mDuration);
        this.El.show();
        return this;
    }

    public static BdToast b(Context context, CharSequence charSequence) {
        return new BdToast(context).h(charSequence).agU();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).h(charSequence).hH(i).agU();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).h(charSequence).hH(i).hI(i2);
    }

    public static BdToast b(Context context, CharSequence charSequence, int i, boolean z) {
        return new BdToast(context).h(charSequence).r(i, z).agU();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2, boolean z) {
        return new BdToast(context).h(charSequence).r(i, z).hH(i2).agU();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).h(charSequence).r(bOj.get(defaultIcon).intValue(), true).agU();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).h(charSequence).r(bOj.get(defaultIcon).intValue(), true).hH(i).agU();
    }
}
