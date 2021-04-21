package com.baidu.sapi2.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.sapi2.PassportViewManager;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.callback.TitleBtnCallback;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.SoftKeyBoardListener;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.views.ViewUtility;
import d.b.y.a.a;
import d.b.y.a.b;
import d.b.y.a.d;
import d.b.y.a.e;
import d.b.y.a.f;
import d.b.y.a.h;
import java.util.HashMap;
/* loaded from: classes2.dex */
public abstract class TitleActivity extends Activity implements View.OnClickListener {
    public View bottomBackView;
    public SapiConfiguration configuration;
    public View dividerLine;
    public ImageView mBottomBackBtnIv;
    public RelativeLayout mBottomBgLayout;
    public ImageView mBottomDividerLine;
    public ImageView mLeftBtnIv;
    public LinearLayout mLeftBtnLayout;
    public TextView mLeftBtnTv;
    public Button mRightBtn;
    public ImageView mRightBtnClose;
    public TextView mTitle;
    public RelativeLayout mTitleBgLayout;
    public RelativeLayout mTitleLayout;
    public boolean realShowBottomBack;
    public TitleBtnCallback titleBtnCallback;
    public PassportViewManager viewManager;
    public boolean useTitle = true;
    public boolean executeSubClassMethod = true;

    public TitleActivity() {
        PassportViewManager passportViewManager = PassportViewManager.getInstance();
        this.viewManager = passportViewManager;
        this.titleBtnCallback = passportViewManager.getTitleBtnCallback();
        this.configuration = SapiAccountManager.getInstance().getConfignation();
    }

    private void a() {
        PassportViewManager.TitleViewModule titleViewModule = this.viewManager.getTitleViewModule();
        if (titleViewModule != null) {
            setTitleLayoutBg(titleViewModule.bgColor);
            setTitleLayoutHeight(titleViewModule.bgHeight);
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
            setTitleTextBold(titleViewModule.titleTextBold);
            setRightBtnVisible(titleViewModule.rightBtnVisible);
            setRightBtnText(titleViewModule.rightBtnText);
            setRightBtnTextSize(SapiUtils.px2sp(this, titleViewModule.rightBtnTextSize));
            setRightBtnColor(titleViewModule.rightBtnTextColor);
            View view = this.dividerLine;
            if (view != null) {
                view.setVisibility(titleViewModule.dividerLineVisible);
            }
        } else {
            setBtnVisibility(4, 0, 4);
            setTitleDrawable(null, null, null, null);
            setLeftBtnDrawable(getResources().getDrawable(d.sapi_sdk_btn_back), null, null, null);
        }
        b();
        if (this.configuration.showBottomBack) {
            setLeftBtnLayoutVisible(8);
        }
    }

    private void b() {
        if (this.configuration.isDarkMode) {
            if (this.useTitle) {
                setTitleLayoutBg(getResources().getColor(b.sapi_sdk_dark_mode_title_color));
                setLeftBtnImage(d.sapi_sdk_btn_back_dark_mode);
                setLeftBtnTextColor(getResources().getColor(b.sapi_sdk_dark_mode_edit_text_color));
                setTitleTextColor(getResources().getColor(b.sapi_sdk_dark_mode_edit_text_color));
                setRightBtnColor(getResources().getColor(b.sapi_sdk_dark_mode_edit_text_color));
                this.mLeftBtnLayout.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_title_color));
                this.mRightBtnClose.setImageResource(d.sapi_sdk_title_close_dark_mode);
                this.dividerLine.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_title_color));
            }
            ImageView imageView = this.mBottomBackBtnIv;
            if (imageView != null) {
                imageView.setImageResource(d.sapi_sdk_btn_back_dark_mode);
            }
            RelativeLayout relativeLayout = this.mBottomBgLayout;
            if (relativeLayout != null) {
                relativeLayout.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_title_color));
            }
            ImageView imageView2 = this.mBottomDividerLine;
            if (imageView2 != null) {
                imageView2.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_title_color));
            }
        }
    }

    public void configTitle() {
        if (this.configuration.customActionBarEnabled) {
            a();
        } else {
            setTitleLayoutVisible(8);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        setPageAnim(false);
    }

    public SapiWebDTO getWebDTO() {
        return null;
    }

    public void init() {
        setPageAnim(true);
    }

    public void onBottomBackBtnClick() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.mLeftBtnIv && view != this.mLeftBtnTv) {
            if (view == this.mRightBtn) {
                onRightBtnClick();
                return;
            } else if (view == this.mBottomBackBtnIv) {
                onBottomBackBtnClick();
                return;
            } else if (view == this.mRightBtnClose) {
                onTitleRightBtnClick();
                return;
            } else {
                return;
            }
        }
        onLeftBtnClick();
    }

    public void onClose() {
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.configuration == null) {
            this.configuration = SapiAccountManager.getInstance().getConfignation();
        }
        SapiConfiguration sapiConfiguration = this.configuration;
        if (sapiConfiguration != null && sapiConfiguration.isDarkMode) {
            setTheme(h.SDKDarkTheme);
        } else {
            SapiConfiguration sapiConfiguration2 = this.configuration;
            if (sapiConfiguration2 != null && sapiConfiguration2.isNightMode) {
                setTheme(h.SDKNightTheme);
            }
        }
        SapiConfiguration sapiConfiguration3 = this.configuration;
        if (sapiConfiguration3 != null) {
            this.realShowBottomBack = sapiConfiguration3.showBottomBack;
        }
    }

    public void onLeftBtnClick() {
    }

    @Override // android.app.Activity
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void onRightBtnClick() {
        TitleBtnCallback titleBtnCallback = this.titleBtnCallback;
        if (titleBtnCallback != null) {
            titleBtnCallback.onRightClick();
        }
    }

    public void onTitleRightBtnClick() {
        onClose();
    }

    public void reportWebviewError(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("error", Log.getStackTraceString(th));
        hashMap.put("device", Build.MODEL);
        hashMap.put("os_version", Build.VERSION.RELEASE);
        StatService.onEvent("webview_init_error", hashMap);
    }

    public void setBtnVisibility(int i, int i2, int i3) {
        Button button;
        ImageView imageView;
        TextView textView;
        if (this.useTitle && (textView = this.mLeftBtnTv) != null) {
            textView.setVisibility(i);
        }
        if (this.useTitle && (imageView = this.mLeftBtnIv) != null) {
            imageView.setVisibility(i2);
        }
        if (!this.useTitle || (button = this.mRightBtn) == null) {
            return;
        }
        button.setVisibility(i3);
    }

    public void setLeftBtnDrawable(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        TextView textView;
        if (!this.useTitle || (textView = this.mLeftBtnTv) == null) {
            return;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    public void setLeftBtnImage(int i) {
        ImageView imageView;
        if (!this.useTitle || (imageView = this.mLeftBtnIv) == null || i == Integer.MAX_VALUE) {
            return;
        }
        imageView.setImageResource(i);
    }

    public void setLeftBtnImgVisible(int i) {
        ImageView imageView;
        if (!this.useTitle || (imageView = this.mLeftBtnIv) == null) {
            return;
        }
        imageView.setVisibility(i);
    }

    public void setLeftBtnLayoutVisible(int i) {
        LinearLayout linearLayout;
        if (!this.useTitle || (linearLayout = this.mLeftBtnLayout) == null) {
            return;
        }
        linearLayout.setVisibility(i);
    }

    public void setLeftBtnText(String str) {
        TextView textView;
        if (!this.useTitle || (textView = this.mLeftBtnTv) == null) {
            return;
        }
        textView.setText(str);
    }

    public void setLeftBtnTextColor(int i) {
        TextView textView;
        if (!this.useTitle || (textView = this.mLeftBtnTv) == null) {
            return;
        }
        textView.setTextColor(i);
    }

    public void setLeftBtnTextSize(float f2) {
        TextView textView;
        if (!this.useTitle || (textView = this.mLeftBtnTv) == null) {
            return;
        }
        textView.setTextSize(f2);
    }

    public void setLeftBtnTextVisible(int i) {
        TextView textView;
        if (!this.useTitle || (textView = this.mLeftBtnTv) == null) {
            return;
        }
        textView.setVisibility(i);
    }

    public void setPageAnim(boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        SapiConfiguration sapiConfiguration = this.configuration;
        int i5 = sapiConfiguration.activityOpenAnimId;
        int i6 = sapiConfiguration.activityExitAnimId;
        SapiWebDTO webDTO = getWebDTO();
        if (webDTO != null && (i4 = webDTO.openEnterAnimId) != 0) {
            i5 = i4;
        }
        if (webDTO != null && (i3 = webDTO.closeExitAnimId) != 0) {
            i6 = i3;
        }
        if (i5 == 0) {
            i5 = a.sapi_sdk_slide_right_in;
        }
        if (i6 == 0) {
            i6 = a.sapi_sdk_slide_right_out;
        }
        if (z) {
            int i7 = a.sapi_sdk_slide_left_out;
            if (webDTO != null && (i2 = webDTO.openExitAnimId) != 0) {
                i7 = i2;
            }
            overridePendingTransition(i5, i7);
            return;
        }
        int i8 = a.sapi_sdk_slide_left_in;
        if (webDTO != null && (i = webDTO.closeEnterAnimId) != 0) {
            i8 = i;
        }
        overridePendingTransition(i8, i6);
    }

    public void setRightBtnColor(int i) {
        Button button;
        if (!this.useTitle || (button = this.mRightBtn) == null) {
            return;
        }
        button.setTextColor(i);
    }

    public void setRightBtnText(String str) {
        Button button;
        if (!this.useTitle || (button = this.mRightBtn) == null) {
            return;
        }
        button.setText(str);
    }

    public void setRightBtnTextSize(float f2) {
        Button button;
        if (!this.useTitle || (button = this.mRightBtn) == null) {
            return;
        }
        button.setTextSize(f2);
    }

    public void setRightBtnVisible(int i) {
        Button button;
        if (!this.useTitle || (button = this.mRightBtn) == null) {
            return;
        }
        button.setVisibility(i);
    }

    public void setTitleDrawable(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        TextView textView;
        if (!this.useTitle || (textView = this.mTitle) == null) {
            return;
        }
        textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    public void setTitleLayoutBg(int i) {
        RelativeLayout relativeLayout;
        if (!this.useTitle || (relativeLayout = this.mTitleBgLayout) == null || i == Integer.MAX_VALUE) {
            return;
        }
        relativeLayout.setBackgroundColor(i);
    }

    public void setTitleLayoutHeight(int i) {
        RelativeLayout relativeLayout;
        if (!this.useTitle || (relativeLayout = this.mTitleLayout) == null || i == Integer.MAX_VALUE) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        layoutParams.height = i;
        this.mTitleLayout.setLayoutParams(layoutParams);
    }

    public void setTitleLayoutVisible(int i) {
        RelativeLayout relativeLayout;
        if (!this.useTitle || (relativeLayout = this.mTitleLayout) == null) {
            return;
        }
        relativeLayout.setVisibility(i);
    }

    public void setTitleText(String str) {
        if (!this.useTitle || this.mTitle == null) {
            return;
        }
        PassportViewManager.TitleViewModule titleViewModule = this.viewManager.getTitleViewModule();
        if (titleViewModule != null) {
            if (titleViewModule.useWebviewTitle) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.mTitle.setText(str);
                return;
            }
            this.mTitle.setText(titleViewModule.titleText);
        } else if (TextUtils.isEmpty(str)) {
        } else {
            this.mTitle.setText(str);
        }
    }

    public void setTitleTextBold(boolean z) {
        TextView textView;
        if (!this.useTitle || (textView = this.mTitle) == null) {
            return;
        }
        textView.setTypeface(z ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
    }

    public void setTitleTextColor(int i) {
        TextView textView;
        if (!this.useTitle || (textView = this.mTitle) == null) {
            return;
        }
        textView.setTextColor(i);
    }

    public void setTitleTextSize(float f2) {
        TextView textView;
        if (!this.useTitle || (textView = this.mTitle) == null) {
            return;
        }
        textView.setTextSize(f2);
    }

    public void setTitleVisible(int i) {
        TextView textView;
        if (!this.useTitle || (textView = this.mTitle) == null) {
            return;
        }
        textView.setVisibility(i);
    }

    public void setupViews() {
        ViewStub viewStub;
        View childAt;
        ViewUtility.enableStatusBarTint(this, -1);
        if (Build.VERSION.SDK_INT >= 14 && (childAt = ((ViewGroup) findViewById(16908290)).getChildAt(0)) != null) {
            childAt.setFitsSystemWindows(true);
        }
        if (this.useTitle) {
            this.mTitle = (TextView) findViewById(e.title);
            this.mLeftBtnLayout = (LinearLayout) findViewById(e.title_left_btn_layout);
            this.mLeftBtnTv = (TextView) findViewById(e.title_btn_left_tv);
            this.mLeftBtnIv = (ImageView) findViewById(e.title_btn_left_iv);
            this.mRightBtn = (Button) findViewById(e.title_btn_right);
            this.mTitleLayout = (RelativeLayout) findViewById(e.sapi_title_layout);
            this.mTitleBgLayout = (RelativeLayout) findViewById(e.sapi_title_bg_layout);
            this.dividerLine = findViewById(e.title_divider_line);
            this.mRightBtnClose = (ImageView) findViewById(e.title_right_close);
            TextView textView = this.mTitle;
            if (textView != null && this.configuration != null) {
                textView.setTextSize(0, (textView.getTextSize() * this.configuration.textZoom) / 100.0f);
            }
            TextView textView2 = this.mLeftBtnTv;
            if (textView2 != null && this.configuration != null) {
                textView2.setTextSize(0, (textView2.getTextSize() * this.configuration.textZoom) / 100.0f);
            }
            Button button = this.mRightBtn;
            if (button != null && this.configuration != null) {
                button.setTextSize(0, (button.getTextSize() * this.configuration.textZoom) / 100.0f);
            }
            SapiConfiguration sapiConfiguration = this.configuration;
            if (sapiConfiguration != null && sapiConfiguration.showBottomBack && this.bottomBackView == null && (viewStub = (ViewStub) findViewById(e.stub_bottom_back)) != null) {
                this.bottomBackView = viewStub.inflate();
                this.mBottomBackBtnIv = (ImageView) findViewById(e.sapi_bottom_back);
                this.mBottomBgLayout = (RelativeLayout) findViewById(e.sapi_layout_bottom_back);
                this.mBottomDividerLine = (ImageView) findViewById(e.sapi_sdk_bottom_divider_line);
                ViewUtility.setOnClickListener(this.mBottomBackBtnIv, this);
                ViewUtility.setViewClickAlpha(this.mBottomBackBtnIv, 0.2f);
            }
            ViewUtility.setOnClickListener(this.mRightBtnClose, this);
            ViewUtility.setViewClickAlpha(this.mRightBtnClose, 0.2f);
            ViewUtility.setOnClickListener(this.mLeftBtnIv, this);
            ViewUtility.setOnClickListener(this.mLeftBtnTv, this);
            ViewUtility.setOnClickListener(this.mRightBtn, this);
        }
        SapiConfiguration sapiConfiguration2 = this.configuration;
        if (sapiConfiguration2 != null && !sapiConfiguration2.isDarkMode && sapiConfiguration2.isNightMode) {
            ((ViewGroup) this.mTitleBgLayout.getRootView()).addView(((LayoutInflater) getSystemService("layout_inflater")).inflate(f.layout_sapi_sdk_night_mode_mask, (ViewGroup) null), new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
        }
        if (this.bottomBackView != null) {
            SoftKeyBoardListener.setListener(this, new SoftKeyBoardListener.OnSoftKeyBoardChangeListener() { // from class: com.baidu.sapi2.activity.TitleActivity.1
                @Override // com.baidu.sapi2.utils.SoftKeyBoardListener.OnSoftKeyBoardChangeListener
                public void keyBoardHide(int i) {
                    View view;
                    TitleActivity titleActivity = TitleActivity.this;
                    if (!titleActivity.realShowBottomBack || (view = titleActivity.bottomBackView) == null) {
                        return;
                    }
                    view.setVisibility(0);
                }

                @Override // com.baidu.sapi2.utils.SoftKeyBoardListener.OnSoftKeyBoardChangeListener
                public void keyBoardShow(int i) {
                    View view = TitleActivity.this.bottomBackView;
                    if (view != null) {
                        view.setVisibility(8);
                    }
                }
            });
        }
        configTitle();
    }

    public void updateBottomBack(int i) {
        SapiConfiguration sapiConfiguration = this.configuration;
        if (sapiConfiguration.showBottomBack) {
            if (i == 1) {
                this.realShowBottomBack = false;
                this.bottomBackView.setVisibility(8);
                this.mRightBtnClose.setVisibility(0);
                return;
            }
            this.realShowBottomBack = true;
            this.bottomBackView.setVisibility(0);
            this.mRightBtnClose.setVisibility(8);
        } else if (sapiConfiguration.showCloseBtn) {
            if (i == 1) {
                this.mRightBtnClose.setVisibility(0);
                this.mLeftBtnLayout.setVisibility(8);
                return;
            }
            this.mRightBtnClose.setVisibility(8);
            this.mLeftBtnLayout.setVisibility(0);
        }
    }

    public void setTitleText(int i) {
        TextView textView;
        if (!this.useTitle || (textView = this.mTitle) == null) {
            return;
        }
        textView.setText(getResources().getText(i));
    }
}
