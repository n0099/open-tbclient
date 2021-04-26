package com.baidu.fsg.base.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.fsg.base.utils.ResUtils;
/* loaded from: classes2.dex */
public class BdActionBar extends RelativeLayout {
    public static final float FOCUS_ALPHA_VALUE = 0.5f;
    public static final float NORMAL_ALPHA_VALUE = 1.0f;
    public static final int TEXT_ALIGN_CENTER = 1;
    public static final int TEXT_ALIGN_LEFT = 0;
    public static final int TEXT_ALIGN_RIGHT = 2;

    /* renamed from: a  reason: collision with root package name */
    public String f5643a;

    /* renamed from: b  reason: collision with root package name */
    public View f5644b;

    /* renamed from: c  reason: collision with root package name */
    public View f5645c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f5646d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f5647e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f5648f;

    /* renamed from: g  reason: collision with root package name */
    public View f5649g;

    /* renamed from: h  reason: collision with root package name */
    public View f5650h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f5651i;
    public View j;
    public ImageView k;
    public TextView l;
    public View m;
    public TextView mTitleCenterText;
    public TextView n;
    public ImageView o;
    public ImageView p;

    public BdActionBar(Context context) {
        super(context);
        this.f5643a = "";
        a();
    }

    public String getLayoutId() {
        return "rim_base_action_bar";
    }

    public View getRightImgZone1ImgView() {
        return this.f5651i;
    }

    public View getRightImgZone2ImgView() {
        return this.k;
    }

    public View getRightImgZone2NotifyView() {
        return this.l;
    }

    public int getRightImgZone2NotifyVisibility() {
        return this.l.getVisibility();
    }

    public View getRightZone1View() {
        return this.f5650h;
    }

    public View getRightZoneView() {
        return this.j;
    }

    public String getTitle() {
        return this.f5643a;
    }

    public void hideLeftZone() {
        this.f5645c.setVisibility(8);
    }

    public boolean isLeftZoneImageSelected() {
        return this.f5645c.isSelected();
    }

    public void setBottomSeperatorvisible(boolean z) {
        ImageView imageView = this.p;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public void setCloseOnClickListener(View.OnClickListener onClickListener) {
        this.f5649g.setVisibility(0);
        this.f5649g.setOnClickListener(onClickListener);
        this.mTitleCenterText.setMaxEms(ResUtils.getInteger(getContext(), "wallet_base_titlebar_centertext_maxems_1"));
    }

    public void setImgZoneBackgroundResource(int i2) {
        this.f5650h.setBackgroundResource(i2);
        this.j.setBackgroundResource(i2);
    }

    public void setLeftImgZone2NotifyText(String str, float f2) {
        if (!TextUtils.isEmpty(str)) {
            this.f5647e.setVisibility(0);
        }
        if (f2 < 0.0f) {
            return;
        }
        this.f5647e.setText(str);
        this.f5647e.setTextSize(f2);
    }

    public void setLeftImgZone2NotifyTextColor(int i2) {
        this.f5647e.setTextColor(i2);
    }

    public void setLeftImgZone2NotifyTextColorStateList(ColorStateList colorStateList) {
        this.f5647e.setTextColor(colorStateList);
    }

    public void setLeftZoneImageSelected(boolean z) {
    }

    public void setLeftZoneImageSrc(int i2) {
        Drawable drawable = i2 != 0 ? getResources().getDrawable(i2) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        this.f5646d.setImageDrawable(drawable);
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        this.f5645c.setVisibility(0);
        this.f5645c.setOnClickListener(onClickListener);
    }

    public void setRightImgZone1Enable(boolean z) {
        this.f5651i.setEnabled(z);
        this.f5650h.setEnabled(z);
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        this.f5650h.setOnClickListener(onClickListener);
    }

    public void setRightImgZone1Src(int i2) {
        this.f5650h.setVisibility(0);
        this.f5651i.setVisibility(0);
        this.f5651i.setImageResource(i2);
    }

    public void setRightImgZone1Visibility(int i2) {
        this.f5650h.setVisibility(i2);
    }

    public void setRightImgZone2Enable(boolean z) {
        this.k.setEnabled(z);
        this.j.setEnabled(z);
    }

    public void setRightImgZone2NotifyClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.l.setVisibility(0);
        }
        this.l.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2NotifyText(String str) {
        if (!TextUtils.isEmpty(str)) {
            setRightImgZone2NotifyVisibility(0);
        }
        this.l.setText(str);
    }

    public void setRightImgZone2NotifyTextBg(int i2) {
        this.l.setBackgroundResource(i2);
        this.l.setPadding(12, 6, 12, 6);
    }

    public void setRightImgZone2NotifyTextColor(int i2) {
        this.l.setTextColor(i2);
    }

    public void setRightImgZone2NotifyTextSize(float f2) {
        this.l.setTextSize(f2);
    }

    public void setRightImgZone2NotifyTextViewPadding(int i2, int i3, int i4, int i5) {
        this.l.setPadding(i2, i3, i4, i5);
    }

    public void setRightImgZone2NotifyVisibility(int i2) {
        this.l.setVisibility(i2);
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.j.setVisibility(0);
        }
        this.j.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2Src(int i2) {
        this.k.setVisibility(0);
        this.k.setImageResource(i2);
    }

    public void setRightImgZone2Visibility(int i2) {
        this.j.setVisibility(i2);
    }

    public void setSafeIconVisible(boolean z) {
        if (z) {
            this.o.setVisibility(0);
        } else {
            this.o.setVisibility(8);
        }
    }

    public void setTitle(int i2) {
        setTitle(getResources().getString(i2));
    }

    public void setTitleCenterSafeTipColor(int i2) {
        this.n.setTextColor(i2);
    }

    public void setTitleCenterSafeTipText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.m.setVisibility(8);
            return;
        }
        this.m.setVisibility(0);
        this.n.setText(str);
    }

    public void setTitleColor(int i2) {
        this.mTitleCenterText.setTextColor(i2);
    }

    public void setTitleShadowLayer(float f2, float f3, float f4, int i2) {
        this.mTitleCenterText.setShadowLayer(f2, f3, f4, i2);
    }

    public void setTitlebgColor(int i2) {
        View view = this.f5644b;
        if (view == null) {
            return;
        }
        view.setBackgroundColor(i2);
    }

    public void setbackBg(Drawable drawable) {
        this.f5645c.setBackgroundDrawable(drawable);
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), getLayoutId()), this);
        this.f5644b = findViewById(ResUtils.id(getContext(), "title"));
        this.f5645c = findViewById(ResUtils.id(getContext(), "title_left_imgzone2"));
        this.f5646d = (ImageView) findViewById(ResUtils.id(getContext(), "title_left_imgzone2_img"));
        this.f5648f = (TextView) findViewById(ResUtils.id(getContext(), "wallet_titlebar_left_imgzone2_close"));
        this.f5647e = (TextView) findViewById(ResUtils.id(getContext(), "title_left_imgzone2_notify"));
        this.f5645c.setOnTouchListener(new a(this));
        View findViewById = findViewById(ResUtils.id(getContext(), "title_close"));
        this.f5649g = findViewById;
        findViewById.setOnTouchListener(new b(this));
        this.mTitleCenterText = (TextView) findViewById(ResUtils.id(getContext(), "title_center_text"));
        this.m = findViewById(ResUtils.id(getContext(), "title_center_safe_layout"));
        this.n = (TextView) findViewById(ResUtils.id(getContext(), "title_center_safe_tip"));
        this.o = (ImageView) findViewById(ResUtils.id(getContext(), "safe_icon"));
        this.f5650h = findViewById(ResUtils.id(getContext(), "title_right_imgzone1"));
        this.f5651i = (ImageView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_img1"));
        this.j = findViewById(ResUtils.id(getContext(), "title_right_imgzone2"));
        this.k = (ImageView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_img"));
        this.l = (TextView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_notify"));
        if (!TextUtils.isEmpty(this.f5643a)) {
            setTitle(this.f5643a);
        }
        this.p = (ImageView) findViewById(ResUtils.id(getContext(), "title_bottom_seperator"));
    }

    public void setTitle(String str) {
        this.f5643a = str;
        this.mTitleCenterText.setText(str);
    }

    public void setRightImgZone2Src(String str) {
        this.k.setVisibility(0);
    }

    public BdActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5643a = "";
        a();
    }

    public void setLeftZoneImageSrc(Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        this.f5646d.setImageDrawable(drawable);
    }

    public void setRightImgZone1Src(String str) {
        this.f5650h.setVisibility(0);
        this.f5651i.setVisibility(0);
    }

    public BdActionBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f5643a = "";
        a();
    }
}
