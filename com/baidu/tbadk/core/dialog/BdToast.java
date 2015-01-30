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
    private static HashMap<DefaultIcon, Integer> Gc = new HashMap<>(2);
    private static Toast nt;
    private final ImageView Gb;
    private final Context mContext;
    private final ViewGroup mRootView;
    private CharSequence mText;
    private final TextView mTextView;
    private int FD = -1;
    private int mGravity = 16;
    private int mDuration = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT;

        /* JADX DEBUG: Replace access to removed values field (Gd) with 'values()' method */
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
        Gc.put(DefaultIcon.SUCCESS, Integer.valueOf(v.icon_unite_pass));
        Gc.put(DefaultIcon.FAILURE, Integer.valueOf(v.icon_unite_lose));
        Gc.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.mRootView = (ViewGroup) com.baidu.adp.lib.g.b.ei().inflate(context, x.dialog_bdtoast, null);
        this.Gb = (ImageView) this.mRootView.findViewById(w.toast_icon);
        this.mTextView = (TextView) this.mRootView.findViewById(w.toast_message);
    }

    public BdToast c(CharSequence charSequence) {
        this.mText = charSequence;
        return this;
    }

    public BdToast bI(int i) {
        this.FD = i;
        return this;
    }

    public BdToast bJ(int i) {
        this.mDuration = i;
        return this;
    }

    public BdToast oa() {
        if (nt != null) {
            nt.cancel();
        }
        nt = new Toast(this.mContext);
        if (this.FD != -1) {
            bc.c(this.Gb, this.FD);
            this.Gb.setVisibility(0);
        } else {
            this.Gb.setVisibility(8);
        }
        bc.b(this.mTextView, t.toast_text, 1);
        this.mTextView.setText(this.mText);
        nt.setView(this.mRootView);
        nt.setGravity(this.mGravity, 0, 0);
        nt.setDuration(this.mDuration);
        return this;
    }

    public BdToast ob() {
        nt.show();
        return this;
    }

    public static BdToast a(Context context, CharSequence charSequence) {
        return new BdToast(context).c(charSequence).oa();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).c(charSequence).bI(i).oa();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).c(charSequence).bI(i).bJ(i2).oa();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).c(charSequence).bI(Gc.get(defaultIcon).intValue()).oa();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).c(charSequence).bI(Gc.get(defaultIcon).intValue()).bJ(i).oa();
    }
}
