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
    private static SoftReference<Toast> Yt;
    private static HashMap<DefaultIcon, Integer> Yy = new HashMap<>(2);
    private final ImageView Yu;
    private CharSequence Yv;
    private final Context mContext;
    private final ViewGroup mRootView;
    private final TextView mTextView;
    private Toast yL;
    private int Yw = -1;
    private int mGravity = 16;
    private int IR = 0;
    private int uw = 0;
    private int ux = 0;
    private int Yx = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT;

        /* JADX DEBUG: Replace access to removed values field (Yz) with 'values()' method */
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
        Yy.put(DefaultIcon.SUCCESS, Integer.valueOf(n.f.icon_unite_pass));
        Yy.put(DefaultIcon.FAILURE, Integer.valueOf(n.f.icon_unite_lose));
        Yy.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.mRootView = (ViewGroup) LayoutInflater.from(context).inflate(n.h.dialog_bdtoast, (ViewGroup) null);
        this.Yu = (ImageView) this.mRootView.findViewById(n.g.toast_icon);
        this.mTextView = (TextView) this.mRootView.findViewById(n.g.toast_message);
    }

    public BdToast b(CharSequence charSequence) {
        this.Yv = charSequence;
        this.mTextView.setText(this.Yv);
        return this;
    }

    public void bQ(int i) {
        this.Yx = i;
    }

    public BdToast bR(int i) {
        this.Yw = i;
        return this;
    }

    public BdToast bS(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast bT(int i) {
        this.IR = i;
        return this;
    }

    public void bU(int i) {
        this.ux = i;
    }

    public BdToast tm() {
        this.yL = new Toast(this.mContext);
        tn();
        if (this.Yw != -1) {
            as.c(this.Yu, this.Yw);
            this.Yu.setVisibility(0);
        } else {
            this.Yu.setVisibility(8);
        }
        as.b(this.mTextView, n.d.toast_text, 1);
        this.mTextView.setText(this.Yv);
        this.yL.setGravity(this.mGravity, this.uw, this.ux);
        this.yL.setDuration(this.IR);
        bV(this.Yx);
        this.yL.setView(this.mRootView);
        return this;
    }

    private BdToast n(int i, int i2, int i3) {
        this.mGravity = i;
        this.uw = i2;
        this.ux = i3;
        return tm();
    }

    public static BdToast a(Context context, int i, int i2, int i3) {
        return new BdToast(context).n(i, i2, i3);
    }

    private void tn() {
        if (Yt != null && Yt.get() != null) {
            Yt.get().cancel();
        }
        Yt = new SoftReference<>(this.yL);
    }

    private void bV(int i) {
        if (i > 0) {
            this.mRootView.setPadding(i, this.mRootView.getTop(), i, this.mRootView.getBottom());
        }
    }

    public BdToast to() {
        this.mTextView.setText(this.Yv);
        this.yL.setGravity(this.mGravity, this.uw, this.ux);
        this.yL.setDuration(this.IR);
        this.yL.show();
        return this;
    }

    public static BdToast b(Context context, CharSequence charSequence) {
        return new BdToast(context).b(charSequence).tm();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).bT(i).tm();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).bR(i).tm();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).b(charSequence).bR(i).bT(i2).tm();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).b(charSequence).bR(Yy.get(defaultIcon).intValue()).tm();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).b(charSequence).bR(Yy.get(defaultIcon).intValue()).bT(i).tm();
    }
}
