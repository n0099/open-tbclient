package com.baidu.tbadk.core.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.lang.ref.SoftReference;
import java.util.HashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class BdToast {
    private static HashMap<DefaultIcon, Integer> abE = new HashMap<>(2);
    private static SoftReference<Toast> abz;
    private final ViewGroup aaQ;
    private final ImageView abA;
    private CharSequence abB;
    private final TextView abu;
    private final Context mContext;
    private Toast yz;
    private int abC = -1;
    private int mGravity = 16;
    private int HD = 0;
    private int uo = 0;
    private int up = 0;
    private int abD = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT
    }

    static {
        abE.put(DefaultIcon.SUCCESS, Integer.valueOf(d.g.icon_unite_pass));
        abE.put(DefaultIcon.FAILURE, Integer.valueOf(d.g.icon_unite_lose));
        abE.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.aaQ = (ViewGroup) LayoutInflater.from(context).inflate(d.j.dialog_bdtoast, (ViewGroup) null);
        this.abA = (ImageView) this.aaQ.findViewById(d.h.toast_icon);
        this.abu = (TextView) this.aaQ.findViewById(d.h.toast_message);
    }

    public BdToast b(CharSequence charSequence) {
        this.abB = charSequence;
        this.abu.setText(this.abB);
        return this;
    }

    public void cn(int i) {
        this.abD = i;
    }

    public BdToast co(int i) {
        this.abC = i;
        return this;
    }

    public BdToast cp(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast cq(int i) {
        this.HD = i;
        return this;
    }

    public void cr(int i) {
        this.up = i;
    }

    public void E(float f) {
        this.abu.setLineSpacing(0.0f, f);
    }

    public BdToast tu() {
        this.yz = new Toast(this.mContext);
        tv();
        if (this.abC != -1) {
            aj.c(this.abA, this.abC);
            this.abA.setVisibility(0);
        } else {
            this.abA.setVisibility(8);
        }
        aj.c(this.abu, d.e.cp_cont_g, 1);
        this.abu.setText(this.abB);
        this.yz.setGravity(this.mGravity, this.uo, this.up);
        this.yz.setDuration(this.HD);
        cs(this.abD);
        this.yz.setView(this.aaQ);
        return this;
    }

    private BdToast l(int i, int i2, int i3) {
        this.mGravity = i;
        this.uo = i2;
        this.up = i3;
        return tu();
    }

    public static BdToast a(Context context, int i, int i2, int i3) {
        return new BdToast(context).l(i, i2, i3);
    }

    private void tv() {
        if (abz != null && abz.get() != null) {
            abz.get().cancel();
        }
        abz = new SoftReference<>(this.yz);
    }

    private void cs(int i) {
        if (i > 0) {
            this.aaQ.setPadding(i, this.aaQ.getTop(), i, this.aaQ.getBottom());
        }
    }

    public BdToast tw() {
        this.abu.setText(this.abB);
        this.yz.setGravity(this.mGravity, this.uo, this.up);
        this.yz.setDuration(this.HD);
        this.yz.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).b(charSequence).tu();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).cq(i).tu();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).co(i).tu();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).b(charSequence).co(i).cq(i2).tu();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).b(charSequence).co(abE.get(defaultIcon).intValue()).tu();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).b(charSequence).co(abE.get(defaultIcon).intValue()).cq(i).tu();
    }
}
