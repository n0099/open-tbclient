package com.baidu.tbadk.core.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.lang.ref.SoftReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class BdToast {
    private static SoftReference<Toast> aaY;
    private static HashMap<DefaultIcon, Integer> abd = new HashMap<>(2);
    private final ImageView aaZ;
    private final ViewGroup aas;
    private CharSequence aba;
    private final Context mContext;
    private final TextView mTextView;
    private Toast yZ;
    private int abb = -1;
    private int mGravity = 16;
    private int It = 0;
    private int uN = 0;
    private int uO = 0;
    private int abc = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT;

        /* JADX DEBUG: Replace access to removed values field (abe) with 'values()' method */
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
        abd.put(DefaultIcon.SUCCESS, Integer.valueOf(w.g.icon_unite_pass));
        abd.put(DefaultIcon.FAILURE, Integer.valueOf(w.g.icon_unite_lose));
        abd.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.aas = (ViewGroup) LayoutInflater.from(context).inflate(w.j.dialog_bdtoast, (ViewGroup) null);
        this.aaZ = (ImageView) this.aas.findViewById(w.h.toast_icon);
        this.mTextView = (TextView) this.aas.findViewById(w.h.toast_message);
    }

    public BdToast b(CharSequence charSequence) {
        this.aba = charSequence;
        this.mTextView.setText(this.aba);
        return this;
    }

    public void ck(int i) {
        this.abc = i;
    }

    public BdToast cl(int i) {
        this.abb = i;
        return this;
    }

    public BdToast cm(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast cn(int i) {
        this.It = i;
        return this;
    }

    public void co(int i) {
        this.uO = i;
    }

    public void Q(float f) {
        this.mTextView.setLineSpacing(0.0f, f);
    }

    public BdToast tW() {
        this.yZ = new Toast(this.mContext);
        tX();
        if (this.abb != -1) {
            aq.c(this.aaZ, this.abb);
            this.aaZ.setVisibility(0);
        } else {
            this.aaZ.setVisibility(8);
        }
        aq.c(this.mTextView, w.e.cp_cont_g, 1);
        this.mTextView.setText(this.aba);
        this.yZ.setGravity(this.mGravity, this.uN, this.uO);
        this.yZ.setDuration(this.It);
        cp(this.abc);
        this.yZ.setView(this.aas);
        return this;
    }

    private BdToast l(int i, int i2, int i3) {
        this.mGravity = i;
        this.uN = i2;
        this.uO = i3;
        return tW();
    }

    public static BdToast a(Context context, int i, int i2, int i3) {
        return new BdToast(context).l(i, i2, i3);
    }

    private void tX() {
        if (aaY != null && aaY.get() != null) {
            aaY.get().cancel();
        }
        aaY = new SoftReference<>(this.yZ);
    }

    private void cp(int i) {
        if (i > 0) {
            this.aas.setPadding(i, this.aas.getTop(), i, this.aas.getBottom());
        }
    }

    public BdToast tY() {
        this.mTextView.setText(this.aba);
        this.yZ.setGravity(this.mGravity, this.uN, this.uO);
        this.yZ.setDuration(this.It);
        this.yZ.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).b(charSequence).tW();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).cn(i).tW();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).cl(i).tW();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).b(charSequence).cl(i).cn(i2).tW();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).b(charSequence).cl(abd.get(defaultIcon).intValue()).tW();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).b(charSequence).cl(abd.get(defaultIcon).intValue()).cn(i).tW();
    }
}
