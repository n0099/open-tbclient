package com.baidu.sapi2.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
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
import com.baidu.d.a.a;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.PassportViewManager;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.callback.TitleBtnCallback;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.views.ViewUtility;
import java.util.HashMap;
/* loaded from: classes2.dex */
public abstract class TitleActivity extends Activity implements View.OnClickListener {
    protected View bottomBackView;
    protected View dividerLine;
    protected ImageView mBottomBackBtnIv;
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
    private PassportViewManager viewManager = PassportViewManager.getInstance();
    public TitleBtnCallback titleBtnCallback = this.viewManager.getTitleBtnCallback();
    protected SapiConfiguration configuration = SapiAccountManager.getInstance().getConfignation();

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        setPageAnim(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setupViews() {
        ViewStub viewStub;
        ViewUtility.enableStatusBarTint(this, -1);
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
                this.mBottomBackBtnIv.setOnClickListener(this);
                ViewUtility.setViewClickAlpha(this.mBottomBackBtnIv, 0.2f);
            }
            if (this.mRightBtnClose != null) {
                this.mRightBtnClose.setOnClickListener(this);
                ViewUtility.setViewClickAlpha(this.mRightBtnClose, 0.2f);
            }
            this.mLeftBtnIv.setOnClickListener(this);
            this.mLeftBtnTv.setOnClickListener(this);
            this.mRightBtn.setOnClickListener(this);
        }
        if (this.configuration.isNightMode) {
            ((ViewGroup) this.mTitleBgLayout.getRootView()).addView(((LayoutInflater) getSystemService("layout_inflater")).inflate(a.f.layout_sapi_sdk_night_mode_mask, (ViewGroup) null), new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
        }
    }

    protected void setTitleLayoutVisible(int i) {
        this.mTitleLayout.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLeftBtnClick() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRightBtnClick() {
        if (this.titleBtnCallback != null) {
            this.titleBtnCallback.onRightClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onBottomBackBtnClick() {
    }

    protected void onTitleRightBtnClick() {
        onClose();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onClose() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateBottomBack(int i) {
        if (this.configuration.showBottomBack) {
            if (i == 1) {
                this.bottomBackView.setVisibility(8);
                this.mRightBtnClose.setVisibility(0);
                return;
            }
            this.bottomBackView.setVisibility(0);
            this.mRightBtnClose.setVisibility(8);
        } else if (this.configuration.showCloseBtn) {
            if (i == 1) {
                this.mRightBtnClose.setVisibility(0);
                this.mLeftBtnLayout.setVisibility(8);
                return;
            }
            this.mRightBtnClose.setVisibility(8);
            this.mLeftBtnLayout.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mLeftBtnIv || view == this.mLeftBtnTv) {
            onLeftBtnClick();
        } else if (view == this.mRightBtn) {
            onRightBtnClick();
        } else if (view == this.mBottomBackBtnIv) {
            onBottomBackBtnClick();
        } else if (view == this.mRightBtnClose) {
            onTitleRightBtnClick();
        }
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

    public void setTitleTextBold(boolean z) {
        this.mTitle.setTypeface(z ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
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

    /* JADX INFO: Access modifiers changed from: protected */
    public SapiWebDTO getWebDTO() {
        return null;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        setPageAnim(false);
    }

    private void setPageAnim(boolean z) {
        int i = this.configuration.activityOpenAnimId;
        int i2 = this.configuration.activityExitAnimId;
        SapiWebDTO webDTO = getWebDTO();
        if (webDTO != null && webDTO.openEnterAnimId != 0) {
            i = webDTO.openEnterAnimId;
        }
        if (webDTO != null && webDTO.closeExitAnimId != 0) {
            i2 = webDTO.closeExitAnimId;
        }
        int i3 = i == 0 ? a.C0053a.sapi_sdk_slide_right_in : i;
        int i4 = i2 == 0 ? a.C0053a.sapi_sdk_slide_right_out : i2;
        if (z) {
            int i5 = a.C0053a.sapi_sdk_hold;
            if (webDTO != null && webDTO.openExitAnimId != 0) {
                i5 = webDTO.openExitAnimId;
            }
            overridePendingTransition(i3, i5);
            return;
        }
        int i6 = 0;
        if (webDTO != null && webDTO.closeEnterAnimId != 0) {
            i6 = webDTO.closeEnterAnimId;
        }
        overridePendingTransition(i6, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportWebviewError(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put(BdStatsConstant.StatsType.ERROR, Log.getStackTraceString(th));
        hashMap.put(Config.DEVICE_PART, Build.MODEL);
        hashMap.put(BdStatsConstant.StatsKey.OS_VERSION, Build.VERSION.RELEASE);
        StatService.onEvent("webview_init_error", hashMap);
    }

    public void configTitle() {
        if (this.configuration.customActionBarEnabled) {
            configCustomTitle();
        } else {
            setTitleLayoutVisible(8);
        }
    }

    public void configCustomTitle() {
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
        }
        if (this.configuration.showBottomBack) {
            setLeftBtnLayoutVisible(8);
        }
    }

    @Override // android.app.Activity
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }
}
