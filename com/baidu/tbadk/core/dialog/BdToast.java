package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdToast {
    private static HashMap<DefaultIcon, Integer> FZ = new HashMap<>(2);
    private static Toast nt;
    private final ImageView FY;
    private final Context mContext;
    private final ViewGroup mRootView;
    private CharSequence mText;
    private final TextView mTextView;
    private int FA = -1;
    private int mGravity = 16;
    private int mDuration = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT;

        /* JADX DEBUG: Replace access to removed values field (Ga) with 'values()' method */
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
        FZ.put(DefaultIcon.SUCCESS, Integer.valueOf(v.icon_unite_pass));
        FZ.put(DefaultIcon.FAILURE, Integer.valueOf(v.icon_unite_lose));
        FZ.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.mRootView = (ViewGroup) com.baidu.adp.lib.g.b.ei().inflate(context, x.dialog_bdtoast, null);
        this.FY = (ImageView) this.mRootView.findViewById(w.toast_icon);
        this.mTextView = (TextView) this.mRootView.findViewById(w.toast_message);
    }

    public BdToast c(CharSequence charSequence) {
        this.mText = charSequence;
        return this;
    }

    public BdToast bI(int i) {
        this.FA = i;
        return this;
    }

    public BdToast bJ(int i) {
        this.mDuration = i;
        return this;
    }

    public BdToast nT() {
        if (nt != null) {
            nt.cancel();
        }
        nt = new Toast(this.mContext);
        if (this.FA != -1) {
            bc.c(this.FY, this.FA);
            this.FY.setVisibility(0);
        } else {
            this.FY.setVisibility(8);
        }
        bc.b(this.mTextView, t.toast_text, 1);
        this.mTextView.setText(this.mText);
        nt.setView(this.mRootView);
        nt.setGravity(this.mGravity, 0, 0);
        nt.setDuration(this.mDuration);
        return this;
    }

    public BdToast nU() {
        nt.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).c(charSequence).nT();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).c(charSequence).bI(i).nT();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).c(charSequence).bI(i).bJ(i2).nT();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).c(charSequence).bI(FZ.get(defaultIcon).intValue()).nT();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).c(charSequence).bI(FZ.get(defaultIcon).intValue()).bJ(i).nT();
    }
}
