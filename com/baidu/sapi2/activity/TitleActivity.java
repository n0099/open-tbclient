package com.baidu.sapi2.activity;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.b.a.a;
import com.baidu.sapi2.PassportViewManager;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.TitleBtnCallback;
import com.baidu.sapi2.utils.SapiUtils;
/* loaded from: classes2.dex */
public abstract class TitleActivity extends BaseActivity implements View.OnClickListener {
    public boolean executeSubClassMethod = true;
    protected ImageView mLeftBtnIv;
    protected LinearLayout mLeftBtnLayout;
    protected TextView mLeftBtnTv;
    protected Button mRightBtn;
    protected TextView mTitle;
    protected RelativeLayout mTitleBgLayout;
    protected RelativeLayout mTitleLayout;
    public TitleBtnCallback titleBtnCallback;
    private PassportViewManager viewManager;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity
    public void init() {
        super.init();
        this.viewManager = PassportViewManager.getInstance();
        this.titleBtnCallback = this.viewManager.getTitleBtnCallback();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity
    public void setupViews() {
        super.setupViews();
        this.mTitle = (TextView) findViewById(a.d.title);
        this.mLeftBtnLayout = (LinearLayout) findViewById(a.d.title_left_btn_layout);
        this.mLeftBtnTv = (TextView) findViewById(a.d.title_btn_left_tv);
        this.mLeftBtnIv = (ImageView) findViewById(a.d.title_btn_left_iv);
        this.mRightBtn = (Button) findViewById(a.d.title_btn_right);
        this.mTitleLayout = (RelativeLayout) findViewById(a.d.sapi_title_layout);
        this.mTitleBgLayout = (RelativeLayout) findViewById(a.d.sapi_title_bg_layout);
        this.mLeftBtnIv.setOnClickListener(this);
        this.mLeftBtnTv.setOnClickListener(this);
        this.mRightBtn.setOnClickListener(this);
        if (SapiAccountManager.getInstance().getSapiConfiguration().isNightMode) {
            this.mTitleLayout.addView(((LayoutInflater) getSystemService("layout_inflater")).inflate(a.e.layout_sapi_sdk_night_mode_mask, (ViewGroup) null), new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
        }
    }

    protected void setTitleLayoutVisible(int i) {
        this.mTitleLayout.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLeftBtnClick() {
        SapiUtils.hideSoftInput(this);
        this.executeSubClassMethod = true;
        if (this.sapiWebView.notifyKefuBack()) {
            this.executeSubClassMethod = false;
        } else if (this.titleBtnCallback != null) {
            this.executeSubClassMethod = this.titleBtnCallback.onLeftBtnClick() ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRightBtnClick() {
        if (this.titleBtnCallback != null) {
            this.titleBtnCallback.onRightClick();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mLeftBtnIv || view == this.mLeftBtnTv) {
            onLeftBtnClick();
        } else if (view == this.mRightBtn) {
            onRightBtnClick();
        }
    }

    public void setTitleLayoutBg(int i) {
        if (i != Integer.MAX_VALUE) {
            this.mTitleBgLayout.setBackgroundColor(i);
        }
    }

    public void setLeftBtnLayoutVisible(int i) {
        this.mLeftBtnLayout.setVisibility(i);
    }

    public void setLeftBtnImgVisible(int i) {
        this.mLeftBtnIv.setVisibility(i);
    }

    public void setLeftBtnImage(int i) {
        if (i != Integer.MAX_VALUE) {
            this.mLeftBtnIv.setImageResource(i);
        }
    }

    public void setLeftBtnTextVisible(int i) {
        this.mLeftBtnTv.setVisibility(i);
    }

    public void setLeftBtnTextColor(int i) {
        this.mLeftBtnTv.setTextColor(i);
    }

    public void setLeftBtnText(String str) {
        this.mLeftBtnTv.setText(str);
    }

    public void setLeftBtnTextSize(float f) {
        this.mLeftBtnTv.setTextSize(f);
    }

    public void setLeftBtnDrawable(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        this.mLeftBtnTv.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    public void setTitleVisible(int i) {
        this.mTitle.setVisibility(i);
    }

    public void setTitleTextColor(int i) {
        this.mTitle.setTextColor(i);
    }

    public void setTitleDrawable(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        this.mTitle.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    public void setTitleText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mTitle.setText(str);
        }
    }

    public void setTitleText(int i) {
        if (this.mTitle != null) {
            this.mTitle.setText(i);
        }
    }

    public void setTitleTextSize(float f) {
        this.mTitle.setTextSize(f);
    }

    public void setBtnVisibility(int i, int i2, int i3) {
        if (this.mLeftBtnTv != null) {
            this.mLeftBtnTv.setVisibility(i);
        }
        if (this.mLeftBtnIv != null) {
            this.mLeftBtnIv.setVisibility(i2);
        }
        if (this.mRightBtn != null) {
            this.mRightBtn.setVisibility(i3);
        }
    }

    public void setRightBtnText(String str) {
        this.mRightBtn.setText(str);
    }

    public void setRightBtnColor(int i) {
        this.mRightBtn.setTextColor(i);
    }

    public void setRightBtnVisible(int i) {
        this.mRightBtn.setVisibility(i);
    }

    public void setRightBtnTextSize(float f) {
        this.mRightBtn.setTextSize(f);
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void configTitle() {
        if (SapiAccountManager.getInstance().getSapiConfiguration().customActionBarEnabled) {
            PassportViewManager.TitleViewModule titleViewModule = PassportViewManager.getInstance().getTitleViewModule();
            if (titleViewModule != null) {
                setTitleLayoutBg(titleViewModule.bgColor);
                setLeftBtnImage(titleViewModule.leftBtnImgResId);
                setLeftBtnImgVisible(titleViewModule.leftBtnImgVisible);
                setLeftBtnTextVisible(titleViewModule.leftBtnTextVisible);
                setLeftBtnTextColor(titleViewModule.leftBtnTextColor);
                setLeftBtnText(titleViewModule.leftBtnText);
                setLeftBtnTextSize(SapiUtils.px2sp(this, titleViewModule.leftBtnTextSize));
                setLeftBtnDrawable(titleViewModule.leftBtnDrawableLeft, titleViewModule.leftBtnDrawableTop, titleViewModule.leftBtnDrawableRight, titleViewModule.leftBtnDrawableBottom);
                setTitleVisible(titleViewModule.titleVisible);
                setTitleText(titleViewModule.titleText);
                setTitleTextColor(titleViewModule.titleTextColor);
                setTitleTextSize(SapiUtils.px2sp(this, titleViewModule.titleTextSize));
                setTitleDrawable(titleViewModule.titleDrawableLeft, titleViewModule.titleDrawableTop, titleViewModule.titleDrawableRight, titleViewModule.titleDrawableBottom);
                setRightBtnVisible(titleViewModule.rightBtnVisible);
                setRightBtnText(titleViewModule.rightBtnText);
                setRightBtnTextSize(SapiUtils.px2sp(this, titleViewModule.rightBtnTextSize));
                setRightBtnColor(titleViewModule.rightBtnTextColor);
                return;
            }
            return;
        }
        setTitleLayoutVisible(8);
    }
}
