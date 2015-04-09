package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdToast {
    private static HashMap<DefaultIcon, Integer> RI = new HashMap<>(2);
    private static Toast yQ;
    private final ImageView RG;
    private final Context mContext;
    private final ViewGroup mRootView;
    private CharSequence mText;
    private final TextView mTextView;
    private int RH = -1;
    private int mGravity = 16;
    private int mDuration = 0;
    private int vf = 0;
    private int vg = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT;

        /* JADX DEBUG: Replace access to removed values field (RJ) with 'values()' method */
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
        RI.put(DefaultIcon.SUCCESS, Integer.valueOf(u.icon_unite_pass));
        RI.put(DefaultIcon.FAILURE, Integer.valueOf(u.icon_unite_lose));
        RI.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.mRootView = (ViewGroup) com.baidu.adp.lib.g.b.hH().inflate(context, w.dialog_bdtoast, null);
        this.RG = (ImageView) this.mRootView.findViewById(v.toast_icon);
        this.mTextView = (TextView) this.mRootView.findViewById(v.toast_message);
    }

    public BdToast c(CharSequence charSequence) {
        this.mText = charSequence;
        return this;
    }

    public BdToast bD(int i) {
        this.RH = i;
        return this;
    }

    public BdToast bE(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast bF(int i) {
        this.mDuration = i;
        return this;
    }

    public void bG(int i) {
        this.vg = i;
    }

    public BdToast rh() {
        if (yQ != null) {
            yQ.cancel();
        }
        yQ = new Toast(this.mContext);
        if (this.RH != -1) {
            ba.c(this.RG, this.RH);
            this.RG.setVisibility(0);
        } else {
            this.RG.setVisibility(8);
        }
        ba.b(this.mTextView, s.toast_text, 1);
        this.mTextView.setText(this.mText);
        yQ.setView(this.mRootView);
        yQ.setGravity(this.mGravity, this.vf, this.vg);
        yQ.setDuration(this.mDuration);
        return this;
    }

    public BdToast ri() {
        yQ.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).c(charSequence).rh();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).c(charSequence).bF(i).rh();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).c(charSequence).bD(i).rh();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).c(charSequence).bD(i).bF(i2).rh();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).c(charSequence).bD(RI.get(defaultIcon).intValue()).rh();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).c(charSequence).bD(RI.get(defaultIcon).intValue()).bF(i).rh();
    }
}
