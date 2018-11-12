package com.baidu.sapi2.activity;

import android.annotation.TargetApi;
import android.app.Activity;
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
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.d.a.a;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.PassportViewManager;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.callback.TitleBtnCallback;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.views.ViewUtility;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import java.util.HashMap;
/* loaded from: classes2.dex */
public abstract class TitleActivity extends Activity implements View.OnClickListener {
    protected View bottomBackView;
    protected ImageView mBottomBackBtnIv;
    protected ImageView mLeftBtnIv;
    protected LinearLayout mLeftBtnLayout;
    protected TextView mLeftBtnTv;
    protected Button mRightBtn;
    protected ImageView mRightBtnClose;
    protected TextView mTitle;
    protected RelativeLayout mTitleBgLayout;
    protected RelativeLayout mTitleLayout;
    public TitleBtnCallback titleBtnCallback;
    private PassportViewManager viewManager;
    protected boolean useTitle = true;
    public boolean executeSubClassMethod = true;

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        this.viewManager = PassportViewManager.getInstance();
        this.titleBtnCallback = this.viewManager.getTitleBtnCallback();
        openAnim();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setupViews() {
        if (this.useTitle) {
            this.mTitle = (TextView) findViewById(a.d.title);
            this.mLeftBtnLayout = (LinearLayout) findViewById(a.d.title_left_btn_layout);
            this.mLeftBtnTv = (TextView) findViewById(a.d.title_btn_left_tv);
            this.mLeftBtnIv = (ImageView) findViewById(a.d.title_btn_left_iv);
            this.mRightBtn = (Button) findViewById(a.d.title_btn_right);
            this.mTitleLayout = (RelativeLayout) findViewById(a.d.sapi_title_layout);
            this.mTitleBgLayout = (RelativeLayout) findViewById(a.d.sapi_title_bg_layout);
            this.mRightBtnClose = (ImageView) findViewById(a.d.title_right_close);
            if (SapiAccountManager.getInstance().getConfignation().showBottomBack) {
                if (this.bottomBackView == null) {
                    this.bottomBackView = ((ViewStub) findViewById(a.d.stub_bottom_back)).inflate();
                }
                this.mBottomBackBtnIv = (ImageView) this.bottomBackView.findViewById(a.d.sapi_bottom_back);
                this.mBottomBackBtnIv.setOnClickListener(this);
                this.mRightBtnClose.setOnClickListener(this);
                ViewUtility.setViewClickAlpha(this.mBottomBackBtnIv, 0.2f);
                ViewUtility.setViewClickAlpha(this.mRightBtnClose, 0.2f);
            }
            this.mLeftBtnIv.setOnClickListener(this);
            this.mLeftBtnTv.setOnClickListener(this);
            this.mRightBtn.setOnClickListener(this);
        }
        if (SapiAccountManager.getInstance().getSapiConfiguration().isNightMode) {
            ((ViewGroup) this.mTitleBgLayout.getRootView()).addView(((LayoutInflater) getSystemService("layout_inflater")).inflate(a.e.layout_sapi_sdk_night_mode_mask, (ViewGroup) null), new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
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
        if (SapiAccountManager.getInstance().getConfignation().showBottomBack) {
            if (i == 1) {
                this.bottomBackView.setVisibility(8);
                this.mRightBtnClose.setVisibility(0);
                return;
            }
            this.bottomBackView.setVisibility(0);
            this.mRightBtnClose.setVisibility(8);
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
        PassportViewManager.TitleViewModule titleViewModule = PassportViewManager.getInstance().getTitleViewModule();
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

    protected SapiWebDTO getWebDTO() {
        return null;
    }

    protected void openAnim() {
        SapiWebDTO webDTO = getWebDTO();
        int i = (webDTO == null || webDTO.openEnterAnimId == 0) ? 0 : webDTO.openEnterAnimId;
        if (i == 0 && SapiAccountManager.getInstance().getConfignation().activityOpenAnimId != 0) {
            i = SapiAccountManager.getInstance().getConfignation().activityOpenAnimId;
        }
        if (i != 0) {
            overridePendingTransition(i, 0);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        SapiWebDTO webDTO = getWebDTO();
        int i = (webDTO == null || webDTO.closeExitAnimId == 0) ? 0 : webDTO.closeExitAnimId;
        if (i == 0 && SapiAccountManager.getInstance().getConfignation().activityExitAnimId != 0) {
            i = SapiAccountManager.getInstance().getSapiConfiguration().activityExitAnimId;
        }
        if (i != 0) {
            overridePendingTransition(0, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportWebviewError(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR, Log.getStackTraceString(th));
        hashMap.put(Config.DEVICE_PART, Build.MODEL);
        hashMap.put(StatisticConstants.OS_VERSION, Build.VERSION.RELEASE);
        StatService.onEvent("webview_init_error", hashMap, false);
    }

    public void configTitle() {
        if (SapiAccountManager.getInstance().getSapiConfiguration().customActionBarEnabled) {
            configCustomTitle();
        } else {
            setTitleLayoutVisible(8);
        }
    }

    public void configCustomTitle() {
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
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
        }
        if (sapiConfiguration.showBottomBack) {
            setLeftBtnLayoutVisible(8);
        }
    }

    @Override // android.app.Activity
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }
}
