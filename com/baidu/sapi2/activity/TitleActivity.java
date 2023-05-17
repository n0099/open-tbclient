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
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.PassportViewManager;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.callback.TitleBtnCallback;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.SoftKeyBoardListener;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.views.ViewUtility;
import com.baidu.tieba.R;
import java.util.HashMap;
/* loaded from: classes3.dex */
public abstract class TitleActivity extends Activity implements View.OnClickListener {
    public View bottomBackView;
    public View bottomBackViewSingleBtn;
    public SapiConfiguration configuration;
    public View dividerLine;
    public ImageView mBottomBackBtnIv;
    public ImageView mBottomBackBtnIvSingleBtn;
    public TextView mBottomBackTvText;
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

    public SapiWebDTO getWebDTO() {
        return null;
    }

    public void onBottomBackBtnClick() {
    }

    public void onClose() {
    }

    public void onLeftBtnClick() {
    }

    public TitleActivity() {
        PassportViewManager passportViewManager = PassportViewManager.getInstance();
        this.viewManager = passportViewManager;
        this.titleBtnCallback = passportViewManager.getTitleBtnCallback();
        this.configuration = SapiAccountManager.getInstance().getConfignation();
    }

    public void configTitle() {
        SapiConfiguration sapiConfiguration = this.configuration;
        if (sapiConfiguration != null && sapiConfiguration.customActionBarEnabled) {
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

    public void init() {
        setPageAnim(true);
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
            View view2 = this.dividerLine;
            if (view2 != null) {
                view2.setVisibility(titleViewModule.dividerLineVisible);
            }
        } else {
            setBtnVisibility(4, 0, 4);
            setTitleDrawable(null, null, null, null);
            setLeftBtnDrawable(getResources().getDrawable(R.drawable.sapi_sdk_btn_back), null, null, null);
        }
        b();
        if (this.configuration.showBottomBack) {
            setLeftBtnLayoutVisible(8);
        }
    }

    private void b() {
        SapiConfiguration sapiConfiguration = this.configuration;
        if (sapiConfiguration != null && sapiConfiguration.isDarkMode) {
            if (this.useTitle) {
                setTitleLayoutBg(getResources().getColor(R.color.sapi_sdk_dark_mode_title_color));
                setLeftBtnImage(R.drawable.sapi_sdk_btn_back_dark_mode);
                setLeftBtnTextColor(getResources().getColor(R.color.sapi_sdk_dark_mode_edit_text_color));
                setTitleTextColor(getResources().getColor(R.color.sapi_sdk_dark_mode_edit_text_color));
                setRightBtnColor(getResources().getColor(R.color.sapi_sdk_dark_mode_edit_text_color));
                LinearLayout linearLayout = this.mLeftBtnLayout;
                if (linearLayout != null) {
                    linearLayout.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_dark_mode_title_color));
                }
                ImageView imageView = this.mRightBtnClose;
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.sapi_sdk_title_close_dark_mode);
                }
                View view2 = this.dividerLine;
                if (view2 != null) {
                    view2.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_dark_mode_title_color));
                }
            }
            ImageView imageView2 = this.mBottomBackBtnIv;
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.sapi_sdk_btn_back_dark_mode);
            }
            ImageView imageView3 = this.mBottomBackBtnIvSingleBtn;
            if (imageView3 != null) {
                imageView3.setImageResource(R.drawable.sapi_sdk_icon_button_bar_back_dark);
            }
            RelativeLayout relativeLayout = this.mBottomBgLayout;
            if (relativeLayout != null) {
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_dark_mode_title_color));
            }
            TextView textView = this.mBottomBackTvText;
            if (textView != null) {
                textView.setTextColor(getResources().getColor(R.color.sapi_sdk_dark_mode_edit_text_color));
            }
            ImageView imageView4 = this.mBottomDividerLine;
            if (imageView4 != null) {
                imageView4.setBackgroundColor(getResources().getColor(R.color.sapi_sdk_dark_mode_title_color));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 != this.mLeftBtnIv && view2 != this.mLeftBtnTv) {
            if (view2 == this.mRightBtn) {
                onRightBtnClick();
                return;
            } else if (view2 != this.mBottomBackBtnIv && view2 != this.mBottomBackTvText && view2 != this.mBottomBackBtnIvSingleBtn) {
                if (view2 == this.mRightBtnClose) {
                    onTitleRightBtnClick();
                    return;
                }
                return;
            } else {
                onBottomBackBtnClick();
                return;
            }
        }
        onLeftBtnClick();
    }

    public void reportWebviewError(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("error", Log.getStackTraceString(th));
        hashMap.put(Config.DEVICE_PART, "android");
        hashMap.put(HttpConstants.OS_VERSION, Build.VERSION.RELEASE);
        StatService.onEvent("webview_init_error", hashMap);
    }

    public void setLeftBtnImage(int i) {
        ImageView imageView;
        if (this.useTitle && (imageView = this.mLeftBtnIv) != null && i != Integer.MAX_VALUE) {
            imageView.setImageResource(i);
        }
    }

    public void setLeftBtnImgVisible(int i) {
        ImageView imageView;
        if (this.useTitle && (imageView = this.mLeftBtnIv) != null) {
            imageView.setVisibility(i);
        }
    }

    public void setLeftBtnLayoutVisible(int i) {
        LinearLayout linearLayout;
        if (this.useTitle && (linearLayout = this.mLeftBtnLayout) != null) {
            linearLayout.setVisibility(i);
        }
    }

    public void setLeftBtnText(String str) {
        TextView textView;
        if (this.useTitle && (textView = this.mLeftBtnTv) != null) {
            textView.setText(str);
        }
    }

    public void setLeftBtnTextColor(int i) {
        TextView textView;
        if (this.useTitle && (textView = this.mLeftBtnTv) != null) {
            textView.setTextColor(i);
        }
    }

    public void setLeftBtnTextSize(float f) {
        TextView textView;
        if (this.useTitle && (textView = this.mLeftBtnTv) != null) {
            textView.setTextSize(f);
        }
    }

    public void setLeftBtnTextVisible(int i) {
        TextView textView;
        if (this.useTitle && (textView = this.mLeftBtnTv) != null) {
            textView.setVisibility(i);
        }
    }

    public void setRightBtnColor(int i) {
        Button button;
        if (this.useTitle && (button = this.mRightBtn) != null) {
            button.setTextColor(i);
        }
    }

    public void setRightBtnText(String str) {
        Button button;
        if (this.useTitle && (button = this.mRightBtn) != null) {
            button.setText(str);
        }
    }

    public void setRightBtnTextSize(float f) {
        Button button;
        if (this.useTitle && (button = this.mRightBtn) != null) {
            button.setTextSize(f);
        }
    }

    public void setRightBtnVisible(int i) {
        Button button;
        if (this.useTitle && (button = this.mRightBtn) != null) {
            button.setVisibility(i);
        }
    }

    public void setTitleLayoutBg(int i) {
        RelativeLayout relativeLayout;
        if (this.useTitle && (relativeLayout = this.mTitleBgLayout) != null && i != Integer.MAX_VALUE && relativeLayout != null) {
            relativeLayout.setBackgroundColor(i);
        }
    }

    public void setTitleLayoutHeight(int i) {
        RelativeLayout relativeLayout;
        if (this.useTitle && (relativeLayout = this.mTitleLayout) != null && i != Integer.MAX_VALUE) {
            ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
            layoutParams.height = i;
            this.mTitleLayout.setLayoutParams(layoutParams);
        }
    }

    public void setTitleLayoutVisible(int i) {
        RelativeLayout relativeLayout;
        if (this.useTitle && (relativeLayout = this.mTitleLayout) != null) {
            relativeLayout.setVisibility(i);
        }
    }

    public void setTitleText(int i) {
        TextView textView;
        if (this.useTitle && (textView = this.mTitle) != null) {
            textView.setText(getResources().getText(i));
        }
    }

    public void setTitleTextBold(boolean z) {
        TextView textView;
        Typeface typeface;
        if (this.useTitle && (textView = this.mTitle) != null) {
            if (z) {
                typeface = Typeface.DEFAULT_BOLD;
            } else {
                typeface = Typeface.DEFAULT;
            }
            textView.setTypeface(typeface);
        }
    }

    public void setTitleTextColor(int i) {
        TextView textView;
        if (this.useTitle && (textView = this.mTitle) != null) {
            textView.setTextColor(i);
        }
    }

    public void setTitleTextSize(float f) {
        TextView textView;
        if (this.useTitle && (textView = this.mTitle) != null) {
            textView.setTextSize(f);
        }
    }

    public void setTitleVisible(int i) {
        TextView textView;
        if (this.useTitle && (textView = this.mTitle) != null) {
            textView.setVisibility(i);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.configuration == null) {
            this.configuration = SapiAccountManager.getInstance().getConfignation();
        }
        SapiConfiguration sapiConfiguration = this.configuration;
        if (sapiConfiguration != null && sapiConfiguration.isDarkMode) {
            setTheme(R.style.obfuscated_res_0x7f10018d);
        } else {
            SapiConfiguration sapiConfiguration2 = this.configuration;
            if (sapiConfiguration2 != null && sapiConfiguration2.isNightMode) {
                setTheme(R.style.obfuscated_res_0x7f10018e);
            }
        }
        SapiConfiguration sapiConfiguration3 = this.configuration;
        if (sapiConfiguration3 != null) {
            this.realShowBottomBack = sapiConfiguration3.showBottomBack;
        }
    }

    public void setTitleText(String str) {
        if (this.useTitle && this.mTitle != null) {
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
    }

    @Override // android.app.Activity
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
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
        if (this.useTitle && (button = this.mRightBtn) != null) {
            button.setVisibility(i3);
        }
    }

    public void setLeftBtnDrawable(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        TextView textView;
        if (this.useTitle && (textView = this.mLeftBtnTv) != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }

    public void setTitleDrawable(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        TextView textView;
        if (this.useTitle && (textView = this.mTitle) != null) {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }

    public void setPageAnim(boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        SapiConfiguration sapiConfiguration = this.configuration;
        int i6 = 0;
        if (sapiConfiguration == null) {
            i = 0;
        } else {
            i = sapiConfiguration.activityOpenAnimId;
        }
        SapiConfiguration sapiConfiguration2 = this.configuration;
        if (sapiConfiguration2 != null) {
            i6 = sapiConfiguration2.activityExitAnimId;
        }
        SapiWebDTO webDTO = getWebDTO();
        if (webDTO != null && (i5 = webDTO.openEnterAnimId) != 0) {
            i = i5;
        }
        if (webDTO != null && (i4 = webDTO.closeExitAnimId) != 0) {
            i6 = i4;
        }
        if (i == 0) {
            i = R.anim.sapi_sdk_slide_right_in;
        }
        if (i6 == 0) {
            i6 = R.anim.sapi_sdk_slide_right_out;
        }
        if (z) {
            int i7 = R.anim.sapi_sdk_slide_left_out;
            if (webDTO != null && (i3 = webDTO.openExitAnimId) != 0) {
                i7 = i3;
            }
            overridePendingTransition(i, i7);
            return;
        }
        int i8 = R.anim.sapi_sdk_slide_left_in;
        if (webDTO != null && (i2 = webDTO.closeEnterAnimId) != 0) {
            i8 = i2;
        }
        overridePendingTransition(i8, i6);
    }

    public void updateBottomBack(int i) {
        boolean z;
        int i2;
        SapiConfiguration sapiConfiguration = this.configuration;
        if (sapiConfiguration == null) {
            return;
        }
        int i3 = 8;
        if (sapiConfiguration.showBottomBack) {
            if (i != 1) {
                z = true;
            } else {
                z = false;
            }
            this.realShowBottomBack = z;
            ImageView imageView = this.mRightBtnClose;
            if (i == 1) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
            if (this.configuration.isShowBottomBackText) {
                View view2 = this.bottomBackView;
                if (view2 != null) {
                    if (i != 1) {
                        i3 = 0;
                    }
                    view2.setVisibility(i3);
                    return;
                }
                return;
            }
            View view3 = this.bottomBackViewSingleBtn;
            if (view3 != null) {
                if (i != 1) {
                    i3 = 0;
                }
                view3.setVisibility(i3);
            }
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

    public void setupViews() {
        ViewStub viewStub;
        ViewStub viewStub2;
        int i;
        View childAt;
        ViewUtility.enableStatusBarTint(this, -1);
        if (Build.VERSION.SDK_INT >= 14 && (childAt = ((ViewGroup) findViewById(16908290)).getChildAt(0)) != null) {
            childAt.setFitsSystemWindows(true);
        }
        if (this.useTitle) {
            this.mTitle = (TextView) findViewById(R.id.obfuscated_res_0x7f09246f);
            this.mLeftBtnLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f092489);
            this.mLeftBtnTv = (TextView) findViewById(R.id.obfuscated_res_0x7f09247b);
            this.mLeftBtnIv = (ImageView) findViewById(R.id.obfuscated_res_0x7f09247a);
            this.mRightBtn = (Button) findViewById(R.id.obfuscated_res_0x7f09247c);
            this.mTitleLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091fca);
            this.mTitleBgLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091fc9);
            this.dividerLine = findViewById(R.id.obfuscated_res_0x7f092481);
            this.mRightBtnClose = (ImageView) findViewById(R.id.obfuscated_res_0x7f092495);
            SapiConfiguration sapiConfiguration = this.configuration;
            if (sapiConfiguration != null && sapiConfiguration.showBottomBack) {
                if (sapiConfiguration.isShowBottomBackText) {
                    if (this.bottomBackView == null && (viewStub2 = (ViewStub) findViewById(R.id.obfuscated_res_0x7f0921d5)) != null) {
                        this.bottomBackView = viewStub2.inflate();
                        this.mBottomBackBtnIv = (ImageView) findViewById(R.id.obfuscated_res_0x7f091ee5);
                        this.mBottomBackTvText = (TextView) findViewById(R.id.obfuscated_res_0x7f091fc8);
                        this.mBottomBgLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091ee8);
                        this.mBottomDividerLine = (ImageView) findViewById(R.id.obfuscated_res_0x7f091f31);
                        ViewUtility.setOnClickListener(this.mBottomBackBtnIv, this);
                        ViewUtility.setOnClickListener(this.mBottomBackTvText, this);
                        ViewUtility.setViewClickAlpha(this.mBottomBackBtnIv, 0.2f);
                        TextView textView = this.mBottomBackTvText;
                        if (this.configuration.isShowBottomBackText) {
                            i = 0;
                        } else {
                            i = 8;
                        }
                        textView.setVisibility(i);
                    }
                } else if (this.bottomBackViewSingleBtn == null && (viewStub = (ViewStub) findViewById(R.id.stub_bottom_back_single_btn)) != null) {
                    this.bottomBackViewSingleBtn = viewStub.inflate();
                    ImageView imageView = (ImageView) findViewById(R.id.sapi_bottom_back_single_btn);
                    this.mBottomBackBtnIvSingleBtn = imageView;
                    ViewUtility.setOnClickListener(imageView, this);
                }
            }
            ViewUtility.setViewClickAlpha(this.mRightBtnClose, 0.2f);
            ViewUtility.setViewClickAlpha(this.mLeftBtnIv, 0.2f);
            ViewUtility.setViewClickAlpha(this.mLeftBtnTv, 0.2f);
            ViewUtility.setViewClickAlpha(this.mRightBtn, 0.2f);
            ViewUtility.setOnClickListener(this.mRightBtnClose, this);
            ViewUtility.setOnClickListener(this.mLeftBtnIv, this);
            ViewUtility.setOnClickListener(this.mLeftBtnTv, this);
            ViewUtility.setOnClickListener(this.mRightBtn, this);
            SapiConfiguration sapiConfiguration2 = this.configuration;
            if (sapiConfiguration2 != null) {
                ViewUtility.enlargedViews(this.mLeftBtnIv, sapiConfiguration2.getTextZoom());
                ViewUtility.enlargedViews(this.mLeftBtnTv, this.configuration.getTextZoom());
                ViewUtility.enlargedViews(this.mTitle, this.configuration.getTextZoom());
                ViewUtility.enlargedViews(this.mRightBtn, this.configuration.getTextZoom());
                ViewUtility.enlargedViews(this.mRightBtnClose, this.configuration.getTextZoom());
                ViewUtility.enlargedViews(this.mBottomBackBtnIv, this.configuration.getTextZoom());
                ViewUtility.enlargedViews(this.mBottomBackTvText, this.configuration.getTextZoom());
            }
        }
        SapiConfiguration sapiConfiguration3 = this.configuration;
        if (sapiConfiguration3 != null && !sapiConfiguration3.isDarkMode && sapiConfiguration3.isNightMode) {
            ((ViewGroup) this.mTitleBgLayout.getRootView()).addView(((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.layout_sapi_sdk_night_mode_mask, (ViewGroup) null), new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
        }
        if (this.bottomBackView != null || this.bottomBackViewSingleBtn != null) {
            SoftKeyBoardListener.setListener(this, new SoftKeyBoardListener.OnSoftKeyBoardChangeListener() { // from class: com.baidu.sapi2.activity.TitleActivity.1
                @Override // com.baidu.sapi2.utils.SoftKeyBoardListener.OnSoftKeyBoardChangeListener
                public void keyBoardHide(int i2) {
                    TitleActivity titleActivity = TitleActivity.this;
                    if (titleActivity.realShowBottomBack) {
                        SapiConfiguration sapiConfiguration4 = titleActivity.configuration;
                        if (sapiConfiguration4 != null && sapiConfiguration4.isShowBottomBackText) {
                            View view2 = titleActivity.bottomBackView;
                            if (view2 != null) {
                                view2.setVisibility(0);
                                return;
                            }
                            return;
                        }
                        View view3 = TitleActivity.this.bottomBackViewSingleBtn;
                        if (view3 != null) {
                            view3.setVisibility(0);
                        }
                    }
                }

                @Override // com.baidu.sapi2.utils.SoftKeyBoardListener.OnSoftKeyBoardChangeListener
                public void keyBoardShow(int i2) {
                    View view2 = TitleActivity.this.bottomBackView;
                    if (view2 != null) {
                        view2.setVisibility(8);
                    }
                    View view3 = TitleActivity.this.bottomBackViewSingleBtn;
                    if (view3 != null) {
                        view3.setVisibility(8);
                    }
                }
            });
        }
        configTitle();
    }
}
