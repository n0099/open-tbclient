package com.baidu.live.tbadk.core.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.util.SkinManager;
import java.lang.ref.SoftReference;
import java.util.HashMap;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
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
    private int mGravity = 16;
    private int mDuration = 0;
    private int offsetX = 0;
    private int offsetY = 0;
    private int paddingHorizontal = 0;

    /* loaded from: classes6.dex */
    public enum DefaultIcon {
        SUCCESS,
        FAILURE,
        NOT
    }

    static {
        sDefaultIconMap.put(DefaultIcon.SUCCESS, Integer.valueOf(a.f.sdk_icon_unite_pass));
        sDefaultIconMap.put(DefaultIcon.FAILURE, Integer.valueOf(a.f.sdk_icon_unite_lose));
        sDefaultIconMap.put(DefaultIcon.NOT, 0);
    }

    private BdToast(Context context) {
        this.mContext = context;
        this.mRootView = (ViewGroup) LayoutInflater.from(context).inflate(a.h.sdk_dialog_bdtoast, (ViewGroup) null);
        this.mIconView = (ImageView) this.mRootView.findViewById(a.g.toast_icon);
        this.mTextView = (TextView) this.mRootView.findViewById(a.g.toast_message);
    }

    public void cancel() {
        if (this.mToast != null) {
            this.mToast.cancel();
        }
    }

    public BdToast setText(CharSequence charSequence) {
        this.mText = charSequence;
        this.mTextView.setText(this.mText);
        return this;
    }

    public void setPaddingHorizontal(int i) {
        this.paddingHorizontal = i;
    }

    public BdToast setIcon(int i) {
        this.mIconResId = i;
        return this;
    }

    public BdToast setGravity(int i) {
        this.mGravity = i;
        return this;
    }

    public BdToast setDuration(int i) {
        this.mDuration = i;
        return this;
    }

    public void setOffsetX(int i) {
        this.offsetX = i;
    }

    public void setOffsetY(int i) {
        this.offsetY = i;
    }

    public void setExtraTextLineSpacing(float f) {
        this.mTextView.setLineSpacing(0.0f, f);
    }

    public BdToast create() {
        this.mToast = new Toast(this.mContext);
        updateStaticToast();
        if (this.mIconResId != -1) {
            SkinManager.setImageResource(this.mIconView, this.mIconResId);
            this.mIconView.setVisibility(0);
        } else {
            this.mIconView.setVisibility(8);
        }
        SkinManager.setViewTextColor(this.mTextView, a.d.sdk_cp_cont_g, 1);
        this.mTextView.setText(this.mText);
        this.mToast.setGravity(this.mGravity, this.offsetX, this.offsetY);
        this.mToast.setDuration(this.mDuration);
        updateHorizontalPadding(this.paddingHorizontal);
        this.mToast.setView(this.mRootView);
        return this;
    }

    private BdToast create(int i, int i2, int i3) {
        this.mGravity = i;
        this.offsetX = i2;
        this.offsetY = i3;
        return create();
    }

    public static BdToast makeText(Context context, int i, int i2, int i3) {
        return new BdToast(context).create(i, i2, i3);
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

    public BdToast show() {
        this.mTextView.setText(this.mText);
        this.mToast.setGravity(this.mGravity, this.offsetX, this.offsetY);
        this.mToast.setDuration(this.mDuration);
        this.mToast.show();
        return this;
    }

    public static BdToast makeText(Context context, CharSequence charSequence) {
        return new BdToast(context).setText(charSequence).create();
    }

    public static BdToast makeText(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).setText(charSequence).setDuration(i).create();
    }

    public static BdToast makeTextWithIcon(Context context, CharSequence charSequence, int i) {
        return new BdToast(context).setText(charSequence).setIcon(i).create();
    }

    public static BdToast makeTextWithIcon(Context context, CharSequence charSequence, int i, int i2) {
        return new BdToast(context).setText(charSequence).setIcon(i).setDuration(i2).create();
    }

    public static BdToast makeTextWithDefaultIcon(Context context, CharSequence charSequence, DefaultIcon defaultIcon) {
        return new BdToast(context).setText(charSequence).setIcon(sDefaultIconMap.get(defaultIcon).intValue()).create();
    }

    public static BdToast makeTextWithDefaultIcon(Context context, CharSequence charSequence, DefaultIcon defaultIcon, int i) {
        return new BdToast(context).setText(charSequence).setIcon(sDefaultIconMap.get(defaultIcon).intValue()).setDuration(i).create();
    }
}
