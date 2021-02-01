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
/* loaded from: classes5.dex */
public class BdActionBar extends RelativeLayout {
    public static final float FOCUS_ALPHA_VALUE = 0.5f;
    public static final float NORMAL_ALPHA_VALUE = 1.0f;
    public static final int TEXT_ALIGN_CENTER = 1;
    public static final int TEXT_ALIGN_LEFT = 0;
    public static final int TEXT_ALIGN_RIGHT = 2;

    /* renamed from: a  reason: collision with root package name */
    private String f2020a;

    /* renamed from: b  reason: collision with root package name */
    private View f2021b;
    private View c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private View g;
    private View h;
    private ImageView i;
    private View j;
    private ImageView k;
    private TextView l;
    private View m;
    protected TextView mTitleCenterText;
    private TextView n;
    private ImageView o;
    private ImageView p;

    public BdActionBar(Context context) {
        super(context);
        this.f2020a = "";
        a();
    }

    public BdActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2020a = "";
        a();
    }

    public BdActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2020a = "";
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), getLayoutId()), this);
        this.f2021b = findViewById(ResUtils.id(getContext(), "title"));
        this.c = findViewById(ResUtils.id(getContext(), "title_left_imgzone2"));
        this.d = (ImageView) findViewById(ResUtils.id(getContext(), "title_left_imgzone2_img"));
        this.f = (TextView) findViewById(ResUtils.id(getContext(), "wallet_titlebar_left_imgzone2_close"));
        this.e = (TextView) findViewById(ResUtils.id(getContext(), "title_left_imgzone2_notify"));
        this.c.setOnTouchListener(new a(this));
        this.g = findViewById(ResUtils.id(getContext(), "title_close"));
        this.g.setOnTouchListener(new b(this));
        this.mTitleCenterText = (TextView) findViewById(ResUtils.id(getContext(), "title_center_text"));
        this.m = findViewById(ResUtils.id(getContext(), "title_center_safe_layout"));
        this.n = (TextView) findViewById(ResUtils.id(getContext(), "title_center_safe_tip"));
        this.o = (ImageView) findViewById(ResUtils.id(getContext(), "safe_icon"));
        this.h = findViewById(ResUtils.id(getContext(), "title_right_imgzone1"));
        this.i = (ImageView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_img1"));
        this.j = findViewById(ResUtils.id(getContext(), "title_right_imgzone2"));
        this.k = (ImageView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_img"));
        this.l = (TextView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_notify"));
        if (!TextUtils.isEmpty(this.f2020a)) {
            setTitle(this.f2020a);
        }
        this.p = (ImageView) findViewById(ResUtils.id(getContext(), "title_bottom_seperator"));
    }

    public void setBottomSeperatorvisible(boolean z) {
        if (this.p != null) {
            this.p.setVisibility(z ? 0 : 8);
        }
    }

    public void setTitlebgColor(int i) {
        if (this.f2021b != null) {
            this.f2021b.setBackgroundColor(i);
        }
    }

    public void setbackBg(Drawable drawable) {
        this.c.setBackgroundDrawable(drawable);
    }

    protected String getLayoutId() {
        return "rim_base_action_bar";
    }

    public void setTitleColor(int i) {
        this.mTitleCenterText.setTextColor(i);
    }

    public void setTitleCenterSafeTipText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.m.setVisibility(8);
            return;
        }
        this.m.setVisibility(0);
        this.n.setText(str);
    }

    public void setTitleCenterSafeTipColor(int i) {
        this.n.setTextColor(i);
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

    public void setTitle(String str) {
        this.f2020a = str;
        this.mTitleCenterText.setText(str);
    }

    public void setTitleShadowLayer(float f, float f2, float f3, int i) {
        this.mTitleCenterText.setShadowLayer(f, f2, f3, i);
    }

    public void setLeftZoneOnClickListener(View.OnClickListener onClickListener) {
        this.c.setVisibility(0);
        this.c.setOnClickListener(onClickListener);
    }

    public void setRightImgZone1OnClickListener(View.OnClickListener onClickListener) {
        this.h.setOnClickListener(onClickListener);
    }

    public void setRightImgZone1Enable(boolean z) {
        this.i.setEnabled(z);
        this.h.setEnabled(z);
    }

    public void setRightImgZone1Src(int i) {
        this.h.setVisibility(0);
        this.i.setVisibility(0);
        this.i.setImageResource(i);
    }

    public void setRightImgZone1Src(String str) {
        this.h.setVisibility(0);
        this.i.setVisibility(0);
    }

    public void setRightImgZone1Visibility(int i) {
        this.h.setVisibility(i);
    }

    public View getRightImgZone1ImgView() {
        return this.i;
    }

    public View getRightZone1View() {
        return this.h;
    }

    public void setRightImgZone2OnClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.j.setVisibility(0);
        }
        this.j.setOnClickListener(onClickListener);
    }

    public void setRightImgZone2Enable(boolean z) {
        this.k.setEnabled(z);
        this.j.setEnabled(z);
    }

    public void setRightImgZone2Src(int i) {
        this.k.setVisibility(0);
        this.k.setImageResource(i);
    }

    public void setRightImgZone2Src(String str) {
        this.k.setVisibility(0);
    }

    public void setRightImgZone2Visibility(int i) {
        this.j.setVisibility(i);
    }

    public void setRightImgZone2NotifyVisibility(int i) {
        this.l.setVisibility(i);
    }

    public void setRightImgZone2NotifyText(String str) {
        if (!TextUtils.isEmpty(str)) {
            setRightImgZone2NotifyVisibility(0);
        }
        this.l.setText(str);
    }

    public void setRightImgZone2NotifyTextColor(int i) {
        this.l.setTextColor(i);
    }

    public void setRightImgZone2NotifyTextBg(int i) {
        this.l.setBackgroundResource(i);
        this.l.setPadding(12, 6, 12, 6);
    }

    public void setLeftImgZone2NotifyText(String str, float f) {
        if (!TextUtils.isEmpty(str)) {
            this.e.setVisibility(0);
        }
        if (f >= 0.0f) {
            this.e.setText(str);
            this.e.setTextSize(f);
        }
    }

    public void setLeftImgZone2NotifyTextColor(int i) {
        this.e.setTextColor(i);
    }

    public void setLeftImgZone2NotifyTextColorStateList(ColorStateList colorStateList) {
        this.e.setTextColor(colorStateList);
    }

    public void setRightImgZone2NotifyTextSize(float f) {
        this.l.setTextSize(f);
    }

    public void setRightImgZone2NotifyTextViewPadding(int i, int i2, int i3, int i4) {
        this.l.setPadding(i, i2, i3, i4);
    }

    public void setRightImgZone2NotifyClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.l.setVisibility(0);
        }
        this.l.setOnClickListener(onClickListener);
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

    public void setLeftZoneImageSrc(int i) {
        Drawable drawable = i != 0 ? getResources().getDrawable(i) : null;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        this.d.setImageDrawable(drawable);
    }

    public void setLeftZoneImageSrc(Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        this.d.setImageDrawable(drawable);
    }

    public void setLeftZoneImageSelected(boolean z) {
    }

    public boolean isLeftZoneImageSelected() {
        return this.c.isSelected();
    }

    public void hideLeftZone() {
        this.c.setVisibility(8);
    }

    public void setImgZoneBackgroundResource(int i) {
        this.h.setBackgroundResource(i);
        this.j.setBackgroundResource(i);
    }

    public View getRightZoneView() {
        return this.j;
    }

    public String getTitle() {
        return this.f2020a;
    }

    public void setCloseOnClickListener(View.OnClickListener onClickListener) {
        this.g.setVisibility(0);
        this.g.setOnClickListener(onClickListener);
        this.mTitleCenterText.setMaxEms(ResUtils.getInteger(getContext(), "wallet_base_titlebar_centertext_maxems_1"));
    }
}
