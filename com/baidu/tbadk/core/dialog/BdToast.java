package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.n;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdToast {
    private static HashMap<DefaultIcon, Integer> Si = new HashMap<>(2);
    private static Toast yE;
    private final ImageView Sf;
    private final Context mContext;
    private final ViewGroup mRootView;
    private CharSequence mText;
    private final TextView mTextView;
    private int Sg = -1;
    private int mGravity = 16;
    private int mDuration = 0;
    private int ur = 0;
    private int us = 0;
    private int Sh = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT;

        /* JADX DEBUG: Replace access to removed values field (Sj) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static DefaultIcon[] valuesCustom() {
            DefaultIcon[] valuesCustom = values();
            int length = valuesCustom.length;
            DefaultIcon[] defaultIconArr = new DefaultIcon[length];
            System.arraycopy(valuesCustom, 0, defaultIconArr, 0, length);
            return defaultIconArr;
        }
    }

    static {
        Si.put(DefaultIcon.SUCCESS, Integer.valueOf(p.icon_unite_pass));
        Si.put(DefaultIcon.FAILURE, Integer.valueOf(p.icon_unite_lose));
        Si.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.mRootView = (ViewGroup) com.baidu.adp.lib.g.b.hr().inflate(context, r.dialog_bdtoast, null);
        this.Sf = (ImageView) this.mRootView.findViewById(q.toast_icon);
        this.mTextView = (TextView) this.mRootView.findViewById(q.toast_message);
    }

    public BdToast c(CharSequence charSequence) {
        this.mText = charSequence;
        return this;
    }

    public void bE(int i) {
        this.Sh = i;
    }

    public BdToast bF(int i) {
        this.Sg = i;
        return this;
    }

    public BdToast bG(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast bH(int i) {
        this.mDuration = i;
        return this;
    }

    public void bI(int i) {
        this.us = i;
    }

    public BdToast rQ() {
        if (yE != null) {
            yE.cancel();
        }
        yE = new Toast(this.mContext);
        if (this.Sg != -1) {
            ay.c(this.Sf, this.Sg);
            this.Sf.setVisibility(0);
        } else {
            this.Sf.setVisibility(8);
        }
        ay.b(this.mTextView, n.toast_text, 1);
        this.mTextView.setText(this.mText);
        bJ(this.Sh);
        yE.setView(this.mRootView);
        yE.setGravity(this.mGravity, this.ur, this.us);
        yE.setDuration(this.mDuration);
        return this;
    }

    private void bJ(int i) {
        if (i > 0) {
            this.mRootView.setPadding(i, this.mRootView.getTop(), i, this.mRootView.getBottom());
        }
    }

    public BdToast rR() {
        yE.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).c(charSequence).rQ();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).c(charSequence).bH(i).rQ();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).c(charSequence).bF(i).rQ();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).c(charSequence).bF(i).bH(i2).rQ();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).c(charSequence).bF(Si.get(defaultIcon).intValue()).rQ();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).c(charSequence).bF(Si.get(defaultIcon).intValue()).bH(i).rQ();
    }
}
