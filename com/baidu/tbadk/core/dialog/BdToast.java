package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdToast {
    private static HashMap<DefaultIcon, Integer> BO = new HashMap<>(2);
    private static Toast nr;
    private final ImageView BM;
    private CharSequence BN;
    private final Context mContext;
    private final ViewGroup mRootView;
    private final TextView mTextView;
    private int Bn = -1;
    private int mGravity = 16;
    private int vu = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE;

        /* JADX DEBUG: Replace access to removed values field (BP) with 'values()' method */
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
        BO.put(DefaultIcon.SUCCESS, Integer.valueOf(u.icon_unite_pass));
        BO.put(DefaultIcon.FAILURE, Integer.valueOf(u.icon_unite_lose));
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.mRootView = (ViewGroup) com.baidu.adp.lib.g.b.ek().inflate(context, w.dialog_bdtoast, null);
        this.BM = (ImageView) this.mRootView.findViewById(v.toast_icon);
        this.mTextView = (TextView) this.mRootView.findViewById(v.toast_message);
    }

    public BdToast a(CharSequence charSequence) {
        this.BN = charSequence;
        return this;
    }

    public BdToast bh(int i) {
        this.Bn = i;
        return this;
    }

    public BdToast bi(int i) {
        this.vu = i;
        return this;
    }

    public BdToast lb() {
        if (nr != null) {
            nr.cancel();
        }
        nr = new Toast(this.mContext);
        if (this.Bn != -1) {
            aw.c(this.BM, this.Bn);
            this.BM.setVisibility(0);
        } else {
            this.BM.setVisibility(8);
        }
        aw.b(this.mTextView, s.toast_text, 1);
        this.mTextView.setText(this.BN);
        nr.setView(this.mRootView);
        nr.setGravity(this.mGravity, 0, 0);
        nr.setDuration(this.vu);
        return this;
    }

    public BdToast lc() {
        nr.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).a(charSequence).lb();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).a(charSequence).bh(i).lb();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).a(charSequence).bh(i).bi(i2).lb();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).a(charSequence).bh(BO.get(defaultIcon).intValue()).lb();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).a(charSequence).bh(BO.get(defaultIcon).intValue()).bi(i).lb();
    }
}
