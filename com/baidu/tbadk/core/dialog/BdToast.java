package com.baidu.tbadk.core.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.adp.lib.util.w;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.lang.ref.SoftReference;
import java.util.HashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class BdToast {
    private static SoftReference<Toast> mToastStatic;
    private static HashMap<DefaultIcon, Integer> sDefaultIconMap = new HashMap<>(2);
    private final Context mContext;
    private final ImageView mIconView;
    private final ViewGroup mRootView;
    private CharSequence mText;
    private final TextView mTextView;
    private Toast mToast;
    private int mIconResId = -1;
    private boolean ehH = false;
    private int mGravity = 16;
    private int mDuration = 0;
    private int offsetX = 0;
    private int offsetY = 0;
    private int paddingHorizontal = 0;

    /* loaded from: classes.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT
    }

    static {
        sDefaultIconMap.put(DefaultIcon.SUCCESS, Integer.valueOf(R.drawable.icon_pure_toast_succeed40_svg));
        sDefaultIconMap.put(DefaultIcon.FAILURE, Integer.valueOf(R.drawable.icon_pure_toast_mistake40_svg));
        sDefaultIconMap.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.mRootView = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.dialog_bdtoast, (ViewGroup) null);
        this.mIconView = (ImageView) this.mRootView.findViewById(R.id.toast_icon);
        this.mTextView = (TextView) this.mRootView.findViewById(R.id.toast_message);
    }

    public BdToast i(CharSequence charSequence) {
        this.mText = charSequence;
        this.mTextView.setText(this.mText);
        return this;
    }

    public void setPaddingHorizontal(int i) {
        this.paddingHorizontal = i;
    }

    public BdToast D(int i, boolean z) {
        this.mIconResId = i;
        this.ehH = z;
        return this;
    }

    public BdToast nN(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast nO(int i) {
        this.mDuration = i;
        return this;
    }

    public void setOffsetY(int i) {
        this.offsetY = i;
    }

    public void setExtraTextLineSpacing(float f) {
        this.mTextView.setLineSpacing(0.0f, f);
    }

    public BdToast bif() {
        this.mToast = new Toast(this.mContext);
        w.b(this.mToast);
        updateStaticToast();
        if (this.mIconResId != -1) {
            if (this.ehH) {
                SvgManager.bkl().a(this.mIconView, this.mIconResId, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            } else {
                ap.setImageResource(this.mIconView, this.mIconResId);
            }
            this.mIconView.setVisibility(0);
        } else {
            this.mIconView.setVisibility(8);
        }
        this.mRootView.setBackgroundDrawable(ap.aO(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds32), ap.getColor(R.color.cp_hud_a)));
        ap.setViewTextColor(this.mTextView, R.color.cp_cont_a, 1);
        this.mTextView.setText(this.mText);
        this.mToast.setGravity(this.mGravity, this.offsetX, this.offsetY);
        this.mToast.setDuration(this.mDuration);
        updateHorizontalPadding(this.paddingHorizontal);
        this.mToast.setView(this.mRootView);
        return this;
    }

    public BdToast nP(int i) {
        this.mToast = new Toast(this.mContext);
        updateStaticToast();
        if (this.mIconResId != -1) {
            if (this.ehH) {
                SvgManager.bkl().a(this.mIconView, this.mIconResId, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            } else {
                ap.setImageResource(this.mIconView, this.mIconResId);
            }
            this.mIconView.setVisibility(0);
        } else {
            this.mIconView.setVisibility(8);
        }
        ap.setViewTextColor(this.mTextView, R.color.cp_cont_a, 1, i);
        this.mTextView.setText(this.mText);
        this.mToast.setGravity(this.mGravity, this.offsetX, this.offsetY);
        this.mToast.setDuration(this.mDuration);
        updateHorizontalPadding(this.paddingHorizontal);
        this.mToast.setView(this.mRootView);
        return this;
    }

    private void updateStaticToast() {
        if (mToastStatic != null && mToastStatic.get() != null) {
            mToastStatic.get().cancel();
        }
        mToastStatic = new SoftReference<>(this.mToast);
    }

    private void updateHorizontalPadding(int i) {
        if (i > 0) {
            this.mRootView.setPadding(i, this.mRootView.getTop(), i, this.mRootView.getBottom());
        }
    }

    public BdToast big() {
        this.mTextView.setText(this.mText);
        this.mToast.setGravity(this.mGravity, this.offsetX, this.offsetY);
        this.mToast.setDuration(this.mDuration);
        this.mToast.show();
        return this;
    }

    public static BdToast b(Context context, CharSequence charSequence) {
        return new BdToast(context).i(charSequence).bif();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).i(charSequence).nO(i).bif();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).i(charSequence).nO(i).nP(i2);
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, boolean z) {
        return new BdToast(context).i(charSequence).D(i, z).bif();
    }

    public static BdToast a(Context context, CharSequence charSequence, int i, int i2, boolean z) {
        return new BdToast(context).i(charSequence).D(i, z).nO(i2).bif();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).i(charSequence).D(sDefaultIconMap.get(defaultIcon).intValue(), true).bif();
    }

    public static BdToast a(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).i(charSequence).D(sDefaultIconMap.get(defaultIcon).intValue(), true).nO(i).bif();
    }
}
