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
    public String f5499a;

    /* renamed from: b  reason: collision with root package name */
    public View f5500b;

    /* renamed from: c  reason: collision with root package name */
    public View f5501c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f5502d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f5503e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f5504f;

    /* renamed from: g  reason: collision with root package name */
    public View f5505g;

    /* renamed from: h  reason: collision with root package name */
    public View f5506h;
    public ImageView i;
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
        this.f5499a = "";
        a();
    }

    public String getLayoutId() {
        return "rim_base_action_bar";
    }

    public View getRightImgZone1ImgView() {
        return this.i;
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
        return this.f5506h;
    }

    public View getRightZoneView() {
        return this.j;
    }

    public String getTitle() {
        return this.f5499a;
    }

    public void hideLeftZone() {
        this.f5501c.setVisibility(8);
    }

    public boolean isLeftZoneImageSelected() {
        return this.f5501c.isSelected();
    }

    public void setBottomSeperatorvisible(boolean z) {
        ImageView imageView = this.p;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    public void setCloseOnClickListener(View.OnClickListener onClickListener) {
        this.f5505g.setVisibility(0);
        this.f5505g.setOnClickListener(onClickListener);
        this.mTitleCenterText.setMaxEms(ResUtils.getInteger(getContext(), "wallet_base_titlebar_centertext_maxems_1"));
    }

    public void setImgZoneBackgroundResource(int i) {
        this.f5506h.setBackgroundResource(i);
        this.j.setBackgroundResource(i);
    }

    public void setLeftImgZone2NotifyText(String str, float f2) {
        if (!TextUtils.isEmpty(str)) {
            this.f5503e.setVisibility(0);
        }
        if (f2 < 0.0f) {
            return;
        }
        this.f5503e.setText(str);
        this.f5503e.setTextSize(f2);
    }

    public void setLeftImgZone2NotifyTextColor(int i) {
        this.f5503e.setTextColor(i);
    }

    public void setLeftImgZone2NotifyTextColorStateList(ColorStateList colorStateList) {
        this.f5503e.setTextColor(colorStateList);
    }

    public void setLeftZoneImageSelected(boolean z) {
    }

    public void setLeftZoneImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        this.f5502d.setImageDrawable(drawable);
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        this.f5501c.setVisibility(0);
        this.f5501c.setOnClickListener(onClickListener);
    }

    public void setRightImgZone1Enable(boolean z) {
        this.i.setEnabled(z);
        this.f5506h.setEnabled(z);
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        this.f5506h.setOnClickListener(onClickListener);
    }

    public void setRightImgZone1Src(int i) {
        this.f5506h.setVisibility(0);
        this.i.setVisibility(0);
        this.i.setImageResource(i);
    }

    public void setRightImgZone1Visibility(int i) {
        this.f5506h.setVisibility(i);
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

    public void setRightImgZone2NotifyTextBg(int i) {
        this.l.setBackgroundResource(i);
        this.l.setPadding(12, 6, 12, 6);
    }

    public void setRightImgZone2NotifyTextColor(int i) {
        this.l.setTextColor(i);
    }

    public void setRightImgZone2NotifyTextSize(float f2) {
        this.l.setTextSize(f2);
    }

    public void setRightImgZone2NotifyTextViewPadding(int i, int i2, int i3, int i4) {
        this.l.setPadding(i, i2, i3, i4);
    }

    public void setRightImgZone2NotifyVisibility(int i) {
        this.l.setVisibility(i);
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.j.setVisibility(0);
        }
        this.j.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2Src(int i) {
        this.k.setVisibility(0);
        this.k.setImageResource(i);
    }

    public void setRightImgZone2Visibility(int i) {
        this.j.setVisibility(i);
    }

    public void setSafeIconVisible(boolean z) {
        if (z) {
            this.o.setVisibility(0);
        } else {
            this.o.setVisibility(8);
        }
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public void setTitleCenterSafeTipColor(int i) {
        this.n.setTextColor(i);
    }

    public void setTitleCenterSafeTipText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.m.setVisibility(8);
            return;
        }
        this.m.setVisibility(0);
        this.n.setText(str);
    }

    public void setTitleColor(int i) {
        this.mTitleCenterText.setTextColor(i);
    }

    public void setTitleShadowLayer(float f2, float f3, float f4, int i) {
        this.mTitleCenterText.setShadowLayer(f2, f3, f4, i);
    }

    public void setTitlebgColor(int i) {
        View view = this.f5500b;
        if (view == null) {
            return;
        }
        view.setBackgroundColor(i);
    }

    public void setbackBg(Drawable drawable) {
        this.f5501c.setBackgroundDrawable(drawable);
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), getLayoutId()), this);
        this.f5500b = findViewById(ResUtils.id(getContext(), "title"));
        this.f5501c = findViewById(ResUtils.id(getContext(), "title_left_imgzone2"));
        this.f5502d = (ImageView) findViewById(ResUtils.id(getContext(), "title_left_imgzone2_img"));
        this.f5504f = (TextView) findViewById(ResUtils.id(getContext(), "wallet_titlebar_left_imgzone2_close"));
        this.f5503e = (TextView) findViewById(ResUtils.id(getContext(), "title_left_imgzone2_notify"));
        this.f5501c.setOnTouchListener(new a(this));
        View findViewById = findViewById(ResUtils.id(getContext(), "title_close"));
        this.f5505g = findViewById;
        findViewById.setOnTouchListener(new b(this));
        this.mTitleCenterText = (TextView) findViewById(ResUtils.id(getContext(), "title_center_text"));
        this.m = findViewById(ResUtils.id(getContext(), "title_center_safe_layout"));
        this.n = (TextView) findViewById(ResUtils.id(getContext(), "title_center_safe_tip"));
        this.o = (ImageView) findViewById(ResUtils.id(getContext(), "safe_icon"));
        this.f5506h = findViewById(ResUtils.id(getContext(), "title_right_imgzone1"));
        this.i = (ImageView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_img1"));
        this.j = findViewById(ResUtils.id(getContext(), "title_right_imgzone2"));
        this.k = (ImageView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_img"));
        this.l = (TextView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_notify"));
        if (!TextUtils.isEmpty(this.f5499a)) {
            setTitle(this.f5499a);
        }
        this.p = (ImageView) findViewById(ResUtils.id(getContext(), "title_bottom_seperator"));
    }

    public void setTitle(String str) {
        this.f5499a = str;
        this.mTitleCenterText.setText(str);
    }

    public void setRightImgZone2Src(String str) {
        this.k.setVisibility(0);
    }

    public BdActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5499a = "";
        a();
    }

    public void setLeftZoneImageSrc(Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        this.f5502d.setImageDrawable(drawable);
    }

    public void setRightImgZone1Src(String str) {
        this.f5506h.setVisibility(0);
        this.i.setVisibility(0);
    }

    public BdActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5499a = "";
        a();
    }
}
