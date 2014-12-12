package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdToast {
    private static HashMap<DefaultIcon, Integer> FW = new HashMap<>(2);
    private static Toast nq;
    private final ImageView FV;
    private final Context mContext;
    private final ViewGroup mRootView;
    private CharSequence mText;
    private final TextView mTextView;
    private int Fy = -1;
    private int mGravity = 16;
    private int mDuration = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT;

        /* JADX DEBUG: Replace access to removed values field (FX) with 'values()' method */
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
        FW.put(DefaultIcon.SUCCESS, Integer.valueOf(v.icon_unite_pass));
        FW.put(DefaultIcon.FAILURE, Integer.valueOf(v.icon_unite_lose));
        FW.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.mRootView = (ViewGroup) com.baidu.adp.lib.g.b.ek().inflate(context, x.dialog_bdtoast, null);
        this.FV = (ImageView) this.mRootView.findViewById(w.toast_icon);
        this.mTextView = (TextView) this.mRootView.findViewById(w.toast_message);
    }

    public BdToast c(CharSequence charSequence) {
        this.mText = charSequence;
        return this;
    }

    public BdToast bD(int i) {
        this.Fy = i;
        return this;
    }

    public BdToast bE(int i) {
        this.mDuration = i;
        return this;
    }

    public BdToast nX() {
        if (nq != null) {
            nq.cancel();
        }
        nq = new Toast(this.mContext);
        if (this.Fy != -1) {
            ax.c(this.FV, this.Fy);
            this.FV.setVisibility(0);
        } else {
            this.FV.setVisibility(8);
        }
        ax.b(this.mTextView, t.toast_text, 1);
        this.mTextView.setText(this.mText);
        nq.setView(this.mRootView);
        nq.setGravity(this.mGravity, 0, 0);
        nq.setDuration(this.mDuration);
        return this;
    }

    public BdToast nY() {
        nq.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).c(charSequence).nX();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).c(charSequence).bD(i).nX();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).c(charSequence).bD(i).bE(i2).nX();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).c(charSequence).bD(FW.get(defaultIcon).intValue()).nX();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).c(charSequence).bD(FW.get(defaultIcon).intValue()).bE(i).nX();
    }
}
