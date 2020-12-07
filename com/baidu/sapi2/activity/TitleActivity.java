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
import com.baidu.l.a.a;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.PassportViewManager;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.callback.TitleBtnCallback;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.i;
import com.baidu.sapi2.utils.k;
import com.baidu.sapi2.views.ViewUtility;
import java.util.HashMap;
/* loaded from: classes6.dex */
public abstract class TitleActivity extends Activity implements View.OnClickListener {
    protected View bottomBackView;
    protected View dividerLine;
    protected ImageView mBottomBackBtnIv;
    protected RelativeLayout mBottomBgLayout;
    protected ImageView mBottomDividerLine;
    protected ImageView mLeftBtnIv;
    protected LinearLayout mLeftBtnLayout;
    protected TextView mLeftBtnTv;
    protected Button mRightBtn;
    protected ImageView mRightBtnClose;
    protected TextView mTitle;
    protected RelativeLayout mTitleBgLayout;
    protected RelativeLayout mTitleLayout;
    protected boolean useTitle = true;
    public boolean executeSubClassMethod = true;
    protected PassportViewManager viewManager = PassportViewManager.getInstance();
    public TitleBtnCallback titleBtnCallback = this.viewManager.getTitleBtnCallback();
    protected SapiConfiguration configuration = SapiAccountManager.getInstance().getConfignation();

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
            this.dividerLine.setVisibility(titleViewModule.dividerLineVisible);
        } else {
            setBtnVisibility(4, 0, 4);
            setTitleDrawable(null, null, null, null);
            setLeftBtnDrawable(getResources().getDrawable(a.d.sapi_sdk_btn_back), null, null, null);
        }
        b();
        if (this.configuration.showBottomBack) {
            setLeftBtnLayoutVisible(8);
        }
    }

    private void b() {
        if (this.configuration.isDarkMode) {
            if (this.useTitle) {
                setTitleLayoutBg(getResources().getColor(a.b.sapi_sdk_dark_mode_title_color));
                setLeftBtnImage(a.d.sapi_sdk_btn_back_dark_mode);
                setLeftBtnTextColor(getResources().getColor(a.b.sapi_sdk_dark_mode_edit_text_color));
                setTitleTextColor(getResources().getColor(a.b.sapi_sdk_dark_mode_edit_text_color));
                setRightBtnColor(getResources().getColor(a.b.sapi_sdk_dark_mode_edit_text_color));
                this.mLeftBtnLayout.setBackgroundColor(getResources().getColor(a.b.sapi_sdk_dark_mode_title_color));
                this.mRightBtnClose.setImageResource(a.d.sapi_sdk_title_close_dark_mode);
                this.dividerLine.setBackgroundColor(getResources().getColor(a.b.sapi_sdk_dark_mode_title_color));
            }
            ImageView imageView = this.mBottomBackBtnIv;
            if (imageView != null) {
                imageView.setImageResource(a.d.sapi_sdk_btn_back_dark_mode);
            }
            RelativeLayout relativeLayout = this.mBottomBgLayout;
            if (relativeLayout != null) {
                relativeLayout.setBackgroundColor(getResources().getColor(a.b.sapi_sdk_dark_mode_title_color));
            }
            ImageView imageView2 = this.mBottomDividerLine;
            if (imageView2 != null) {
                imageView2.setBackgroundColor(getResources().getColor(a.b.sapi_sdk_dark_mode_title_color));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
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

    /* JADX INFO: Access modifiers changed from: protected */
    public SapiWebDTO getWebDTO() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setPageAnim(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void onClose() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SapiConfiguration sapiConfiguration = this.configuration;
        if (sapiConfiguration.isDarkMode) {
            setTheme(a.h.SDKDarkTheme);
        } else if (sapiConfiguration.isNightMode) {
            setTheme(a.h.SDKNightTheme);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLeftBtnClick() {
    }

    @Override // android.app.Activity
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRightBtnClick() {
        TitleBtnCallback titleBtnCallback = this.titleBtnCallback;
        if (titleBtnCallback != null) {
            titleBtnCallback.onRightClick();
        }
    }

    protected void onTitleRightBtnClick() {
        onClose();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportWebviewError(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put(BdStatsConstant.StatsType.ERROR, Log.getStackTraceString(th));
        hashMap.put(Config.DEVICE_PART, Build.MODEL);
        hashMap.put("os_version", Build.VERSION.RELEASE);
        k.a("webview_init_error", hashMap);
    }

    public void setBtnVisibility(int i, int i2, int i3) {
        TextView textView = this.mLeftBtnTv;
        if (textView != null) {
            textView.setVisibility(i);
        }
        ImageView imageView = this.mLeftBtnIv;
        if (imageView != null) {
            imageView.setVisibility(i2);
        }
        Button button = this.mRightBtn;
        if (button != null) {
            button.setVisibility(i3);
        }
    }

    public void setLeftBtnDrawable(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        this.mLeftBtnTv.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    public void setLeftBtnImage(int i) {
        if (i != Integer.MAX_VALUE) {
            this.mLeftBtnIv.setImageResource(i);
        }
    }

    public void setLeftBtnImgVisible(int i) {
        this.mLeftBtnIv.setVisibility(i);
    }

    public void setLeftBtnLayoutVisible(int i) {
        this.mLeftBtnLayout.setVisibility(i);
    }

    public void setLeftBtnText(String str) {
        this.mLeftBtnTv.setText(str);
    }

    public void setLeftBtnTextColor(int i) {
        this.mLeftBtnTv.setTextColor(i);
    }

    public void setLeftBtnTextSize(float f) {
        this.mLeftBtnTv.setTextSize(f);
    }

    public void setLeftBtnTextVisible(int i) {
        this.mLeftBtnTv.setVisibility(i);
    }

    protected void setPageAnim(boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        SapiConfiguration sapiConfiguration = this.configuration;
        int i5 = sapiConfiguration.activityOpenAnimId;
        int i6 = sapiConfiguration.activityExitAnimId;
        SapiWebDTO webDTO = getWebDTO();
        if (webDTO == null || (i = webDTO.openEnterAnimId) == 0) {
            i = i5;
        }
        if (webDTO == null || (i2 = webDTO.closeExitAnimId) == 0) {
            i2 = i6;
        }
        int i7 = i == 0 ? a.C0164a.sapi_sdk_slide_right_in : i;
        int i8 = i2 == 0 ? a.C0164a.sapi_sdk_slide_right_out : i2;
        if (z) {
            int i9 = a.C0164a.sapi_sdk_slide_left_out;
            if (webDTO == null || (i4 = webDTO.openExitAnimId) == 0) {
                i4 = i9;
            }
            overridePendingTransition(i7, i4);
            return;
        }
        int i10 = a.C0164a.sapi_sdk_slide_left_in;
        if (webDTO == null || (i3 = webDTO.closeEnterAnimId) == 0) {
            i3 = i10;
        }
        overridePendingTransition(i3, i8);
    }

    public void setRightBtnColor(int i) {
        this.mRightBtn.setTextColor(i);
    }

    public void setRightBtnText(String str) {
        this.mRightBtn.setText(str);
    }

    public void setRightBtnTextSize(float f) {
        this.mRightBtn.setTextSize(f);
    }

    public void setRightBtnVisible(int i) {
        this.mRightBtn.setVisibility(i);
    }

    public void setTitleDrawable(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        this.mTitle.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    public void setTitleLayoutBg(int i) {
        if (i != Integer.MAX_VALUE) {
            this.mTitleBgLayout.setBackgroundColor(i);
        }
    }

    public void setTitleLayoutHeight(int i) {
        if (i != Integer.MAX_VALUE) {
            ViewGroup.LayoutParams layoutParams = this.mTitleLayout.getLayoutParams();
            layoutParams.height = i;
            this.mTitleLayout.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTitleLayoutVisible(int i) {
        this.mTitleLayout.setVisibility(i);
    }

    public void setTitleText(String str) {
        PassportViewManager.TitleViewModule titleViewModule = this.viewManager.getTitleViewModule();
        if (titleViewModule != null) {
            if (titleViewModule.useWebviewTitle) {
                if (!TextUtils.isEmpty(str)) {
                    this.mTitle.setText(str);
                    return;
                }
                return;
            }
            this.mTitle.setText(titleViewModule.titleText);
        } else if (!TextUtils.isEmpty(str)) {
            this.mTitle.setText(str);
        }
    }

    public void setTitleTextBold(boolean z) {
        this.mTitle.setTypeface(z ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
    }

    public void setTitleTextColor(int i) {
        this.mTitle.setTextColor(i);
    }

    public void setTitleTextSize(float f) {
        this.mTitle.setTextSize(f);
    }

    public void setTitleVisible(int i) {
        this.mTitle.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setupViews() {
        ViewStub viewStub;
        View childAt;
        ViewUtility.enableStatusBarTint(this, -1);
        if (Build.VERSION.SDK_INT >= 14 && (childAt = ((ViewGroup) findViewById(16908290)).getChildAt(0)) != null) {
            childAt.setFitsSystemWindows(true);
        }
        if (this.useTitle) {
            this.mTitle = (TextView) findViewById(a.e.title);
            this.mLeftBtnLayout = (LinearLayout) findViewById(a.e.title_left_btn_layout);
            this.mLeftBtnTv = (TextView) findViewById(a.e.title_btn_left_tv);
            this.mLeftBtnIv = (ImageView) findViewById(a.e.title_btn_left_iv);
            this.mRightBtn = (Button) findViewById(a.e.title_btn_right);
            this.mTitleLayout = (RelativeLayout) findViewById(a.e.sapi_title_layout);
            this.mTitleBgLayout = (RelativeLayout) findViewById(a.e.sapi_title_bg_layout);
            this.dividerLine = findViewById(a.e.title_divider_line);
            this.mRightBtnClose = (ImageView) findViewById(a.e.title_right_close);
            if (this.configuration.showBottomBack && this.bottomBackView == null && (viewStub = (ViewStub) findViewById(a.e.stub_bottom_back)) != null) {
                this.bottomBackView = viewStub.inflate();
                this.mBottomBackBtnIv = (ImageView) findViewById(a.e.sapi_bottom_back);
                this.mBottomBgLayout = (RelativeLayout) findViewById(a.e.sapi_layout_bottom_back);
                this.mBottomDividerLine = (ImageView) findViewById(a.e.sapi_sdk_bottom_divider_line);
                ViewUtility.setOnClickListener(this.mBottomBackBtnIv, this);
                ViewUtility.setViewClickAlpha(this.mBottomBackBtnIv, 0.2f);
            }
            ViewUtility.setOnClickListener(this.mRightBtnClose, this);
            ViewUtility.setViewClickAlpha(this.mRightBtnClose, 0.2f);
            ViewUtility.setOnClickListener(this.mLeftBtnIv, this);
            ViewUtility.setOnClickListener(this.mLeftBtnTv, this);
            ViewUtility.setOnClickListener(this.mRightBtn, this);
        }
        SapiConfiguration sapiConfiguration = this.configuration;
        if (!sapiConfiguration.isDarkMode && sapiConfiguration.isNightMode) {
            ((ViewGroup) this.mTitleBgLayout.getRootView()).addView(((LayoutInflater) getSystemService("layout_inflater")).inflate(a.f.layout_sapi_sdk_night_mode_mask, (ViewGroup) null), new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
        }
        if (this.bottomBackView != null) {
            i.a(this, new i.b() { // from class: com.baidu.sapi2.activity.TitleActivity.1
                @Override // com.baidu.sapi2.utils.i.b
                public void keyBoardHide(int i) {
                    View view = TitleActivity.this.bottomBackView;
                    if (view != null) {
                        view.setVisibility(0);
                    }
                }

                @Override // com.baidu.sapi2.utils.i.b
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateBottomBack(int i) {
        SapiConfiguration sapiConfiguration = this.configuration;
        if (sapiConfiguration.showBottomBack) {
            if (i == 1) {
                this.bottomBackView.setVisibility(8);
                this.mRightBtnClose.setVisibility(0);
                return;
            }
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
        TextView textView = this.mTitle;
        if (textView != null) {
            textView.setText(i);
        }
    }
}
