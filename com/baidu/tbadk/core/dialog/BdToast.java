package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdToast {
    private static SoftReference<Toast> XQ;
    private static HashMap<DefaultIcon, Integer> XV = new HashMap<>(2);
    private final ImageView XR;
    private CharSequence XS;
    private final Context mContext;
    private final ViewGroup mRootView;
    private final TextView mTextView;
    private Toast yJ;
    private int XT = -1;
    private int mGravity = 16;
    private int IA = 0;
    private int uu = 0;
    private int uv = 0;
    private int XU = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT;

        /* JADX DEBUG: Replace access to removed values field (XW) with 'values()' method */
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
        XV.put(DefaultIcon.SUCCESS, Integer.valueOf(n.e.icon_unite_pass));
        XV.put(DefaultIcon.FAILURE, Integer.valueOf(n.e.icon_unite_lose));
        XV.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.mRootView = (ViewGroup) LayoutInflater.from(context).inflate(n.g.dialog_bdtoast, (ViewGroup) null);
        this.XR = (ImageView) this.mRootView.findViewById(n.f.toast_icon);
        this.mTextView = (TextView) this.mRootView.findViewById(n.f.toast_message);
    }

    public BdToast c(CharSequence charSequence) {
        this.XS = charSequence;
        this.mTextView.setText(this.XS);
        return this;
    }

    public void bX(int i) {
        this.XU = i;
    }

    public BdToast bY(int i) {
        this.XT = i;
        return this;
    }

    public BdToast bZ(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast ca(int i) {
        this.IA = i;
        return this;
    }

    public void cb(int i) {
        this.uv = i;
    }

    public BdToast tC() {
        this.yJ = new Toast(this.mContext);
        tD();
        if (this.XT != -1) {
            as.c(this.XR, this.XT);
            this.XR.setVisibility(0);
        } else {
            this.XR.setVisibility(8);
        }
        as.b(this.mTextView, n.c.toast_text, 1);
        this.mTextView.setText(this.XS);
        this.yJ.setGravity(this.mGravity, this.uu, this.uv);
        this.yJ.setDuration(this.IA);
        cc(this.XU);
        this.yJ.setView(this.mRootView);
        return this;
    }

    private BdToast n(int i, int i2, int i3) {
        this.mGravity = i;
        this.uu = i2;
        this.uv = i3;
        return tC();
    }

    public static BdToast a(Context context, int i, int i2, int i3) {
        return new BdToast(context).n(i, i2, i3);
    }

    private void tD() {
        if (XQ != null && XQ.get() != null) {
            XQ.get().cancel();
        }
        XQ = new SoftReference<>(this.yJ);
    }

    private void cc(int i) {
        if (i > 0) {
            this.mRootView.setPadding(i, this.mRootView.getTop(), i, this.mRootView.getBottom());
        }
    }

    public BdToast tE() {
        this.mTextView.setText(this.XS);
        this.yJ.setGravity(this.mGravity, this.uu, this.uv);
        this.yJ.setDuration(this.IA);
        this.yJ.show();
        return this;
    }

    public static BdToast b(Context context, CharSequence charSequence) {
        return new BdToast(context).c(charSequence).tC();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).c(charSequence).ca(i).tC();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).c(charSequence).bY(i).tC();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).c(charSequence).bY(i).ca(i2).tC();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).c(charSequence).bY(XV.get(defaultIcon).intValue()).tC();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).c(charSequence).bY(XV.get(defaultIcon).intValue()).ca(i).tC();
    }
}
