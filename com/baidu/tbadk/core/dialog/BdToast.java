package com.baidu.tbadk.core.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import java.lang.ref.SoftReference;
import java.util.HashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class BdToast {
    private static SoftReference<Toast> acs;
    private static HashMap<DefaultIcon, Integer> acx = new HashMap<>(2);
    private Toast AG;
    private final ViewGroup abM;
    private final ImageView act;
    private CharSequence acu;
    private final Context mContext;
    private final TextView mTextView;
    private int acv = -1;
    private int mGravity = 16;
    private int mDuration = 0;
    private int wy = 0;
    private int wz = 0;
    private int acw = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT
    }

    static {
        acx.put(DefaultIcon.SUCCESS, Integer.valueOf(d.g.icon_unite_pass));
        acx.put(DefaultIcon.FAILURE, Integer.valueOf(d.g.icon_unite_lose));
        acx.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.abM = (ViewGroup) LayoutInflater.from(context).inflate(d.j.dialog_bdtoast, (ViewGroup) null);
        this.act = (ImageView) this.abM.findViewById(d.h.toast_icon);
        this.mTextView = (TextView) this.abM.findViewById(d.h.toast_message);
    }

    public BdToast b(CharSequence charSequence) {
        this.acu = charSequence;
        this.mTextView.setText(this.acu);
        return this;
    }

    public void cn(int i) {
        this.acw = i;
    }

    public BdToast co(int i) {
        this.acv = i;
        return this;
    }

    public BdToast cp(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast cq(int i) {
        this.mDuration = i;
        return this;
    }

    public void cr(int i) {
        this.wz = i;
    }

    public void P(float f) {
        this.mTextView.setLineSpacing(0.0f, f);
    }

    public BdToast tx() {
        this.AG = new Toast(this.mContext);
        ty();
        if (this.acv != -1) {
            ai.c(this.act, this.acv);
            this.act.setVisibility(0);
        } else {
            this.act.setVisibility(8);
        }
        ai.c(this.mTextView, d.e.cp_cont_g, 1);
        this.mTextView.setText(this.acu);
        this.AG.setGravity(this.mGravity, this.wy, this.wz);
        this.AG.setDuration(this.mDuration);
        cs(this.acw);
        this.AG.setView(this.abM);
        return this;
    }

    private BdToast l(int i, int i2, int i3) {
        this.mGravity = i;
        this.wy = i2;
        this.wz = i3;
        return tx();
    }

    public static BdToast a(Context context, int i, int i2, int i3) {
        return new BdToast(context).l(i, i2, i3);
    }

    private void ty() {
        if (acs != null && acs.get() != null) {
            acs.get().cancel();
        }
        acs = new SoftReference<>(this.AG);
    }

    private void cs(int i) {
        if (i > 0) {
            this.abM.setPadding(i, this.abM.getTop(), i, this.abM.getBottom());
        }
    }

    public BdToast tz() {
        this.mTextView.setText(this.acu);
        this.AG.setGravity(this.mGravity, this.wy, this.wz);
        this.AG.setDuration(this.mDuration);
        this.AG.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).b(charSequence).tx();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).cq(i).tx();
    }

    public static BdToast b(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).b(charSequence).co(i).tx();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).b(charSequence).co(i).cq(i2).tx();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).b(charSequence).co(acx.get(defaultIcon).intValue()).tx();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).b(charSequence).co(acx.get(defaultIcon).intValue()).cq(i).tx();
    }
}
