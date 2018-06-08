package com.baidu.tbadk.core.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import java.lang.ref.SoftReference;
import java.util.HashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class BdToast {
    private static SoftReference<Toast> alj;
    private static HashMap<DefaultIcon, Integer> alk = new HashMap<>(2);
    private Toast Dq;
    private final Context mContext;
    private final ImageView mIconView;
    private final ViewGroup mRootView;
    private CharSequence mText;
    private final TextView mTextView;
    private int mIconResId = -1;
    private int mGravity = 16;
    private int mDuration = 0;
    private int zd = 0;
    private int ze = 0;
    private int paddingHorizontal = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT
    }

    static {
        alk.put(DefaultIcon.SUCCESS, Integer.valueOf(d.f.icon_unite_pass));
        alk.put(DefaultIcon.FAILURE, Integer.valueOf(d.f.icon_unite_lose));
        alk.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.mRootView = (ViewGroup) LayoutInflater.from(context).inflate(d.i.dialog_bdtoast, (ViewGroup) null);
        this.mIconView = (ImageView) this.mRootView.findViewById(d.g.toast_icon);
        this.mTextView = (TextView) this.mRootView.findViewById(d.g.toast_message);
    }

    public BdToast h(CharSequence charSequence) {
        this.mText = charSequence;
        this.mTextView.setText(this.mText);
        return this;
    }

    public void cm(int i) {
        this.paddingHorizontal = i;
    }

    public BdToast cn(int i) {
        this.mIconResId = i;
        return this;
    }

    public BdToast co(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast cp(int i) {
        this.mDuration = i;
        return this;
    }

    public void setOffsetY(int i) {
        this.ze = i;
    }

    public void Y(float f) {
        this.mTextView.setLineSpacing(0.0f, f);
    }

    public BdToast xg() {
        this.Dq = new Toast(this.mContext);
        xh();
        if (this.mIconResId != -1) {
            al.c(this.mIconView, this.mIconResId);
            this.mIconView.setVisibility(0);
        } else {
            this.mIconView.setVisibility(8);
        }
        al.c(this.mTextView, d.C0141d.cp_cont_g, 1);
        this.mTextView.setText(this.mText);
        this.Dq.setGravity(this.mGravity, this.zd, this.ze);
        this.Dq.setDuration(this.mDuration);
        cq(this.paddingHorizontal);
        this.Dq.setView(this.mRootView);
        return this;
    }

    private void xh() {
        if (alj != null && alj.get() != null) {
            alj.get().cancel();
        }
        alj = new SoftReference<>(this.Dq);
    }

    private void cq(int i) {
        if (i > 0) {
            this.mRootView.setPadding(i, this.mRootView.getTop(), i, this.mRootView.getBottom());
        }
    }

    public BdToast xi() {
        this.mTextView.setText(this.mText);
        this.Dq.setGravity(this.mGravity, this.zd, this.ze);
        this.Dq.setDuration(this.mDuration);
        this.Dq.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).h(charSequence).xg();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).h(charSequence).cp(i).xg();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).h(charSequence).cn(i).xg();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).h(charSequence).cn(i).cp(i2).xg();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).h(charSequence).cn(alk.get(defaultIcon).intValue()).xg();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).h(charSequence).cn(alk.get(defaultIcon).intValue()).cp(i).xg();
    }
}
