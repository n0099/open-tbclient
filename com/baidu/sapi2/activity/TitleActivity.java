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
import androidx.core.view.InputDeviceCompat;
import c.a.d0.a.a;
import c.a.d0.a.b;
import c.a.d0.a.d;
import c.a.d0.a.e;
import c.a.d0.a.f;
import c.a.d0.a.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.sapi2.PassportViewManager;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.callback.TitleBtnCallback;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.SoftKeyBoardListener;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.views.ViewUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes9.dex */
public abstract class TitleActivity extends Activity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View bottomBackView;
    public SapiConfiguration configuration;
    public View dividerLine;
    public boolean executeSubClassMethod;
    public ImageView mBottomBackBtnIv;
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
    public boolean useTitle;
    public PassportViewManager viewManager;

    public TitleActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.useTitle = true;
        this.executeSubClassMethod = true;
        PassportViewManager passportViewManager = PassportViewManager.getInstance();
        this.viewManager = passportViewManager;
        this.titleBtnCallback = passportViewManager.getTitleBtnCallback();
        this.configuration = SapiAccountManager.getInstance().getConfignation();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
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
    }

    private void b() {
        SapiConfiguration sapiConfiguration;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && (sapiConfiguration = this.configuration) != null && sapiConfiguration.isDarkMode) {
            if (this.useTitle) {
                setTitleLayoutBg(getResources().getColor(b.sapi_sdk_dark_mode_title_color));
                setLeftBtnImage(d.sapi_sdk_btn_back_dark_mode);
                setLeftBtnTextColor(getResources().getColor(b.sapi_sdk_dark_mode_edit_text_color));
                setTitleTextColor(getResources().getColor(b.sapi_sdk_dark_mode_edit_text_color));
                setRightBtnColor(getResources().getColor(b.sapi_sdk_dark_mode_edit_text_color));
                LinearLayout linearLayout = this.mLeftBtnLayout;
                if (linearLayout != null) {
                    linearLayout.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_title_color));
                }
                ImageView imageView = this.mRightBtnClose;
                if (imageView != null) {
                    imageView.setImageResource(d.sapi_sdk_title_close_dark_mode);
                }
                View view = this.dividerLine;
                if (view != null) {
                    view.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_title_color));
                }
            }
            ImageView imageView2 = this.mBottomBackBtnIv;
            if (imageView2 != null) {
                imageView2.setImageResource(d.sapi_sdk_btn_back_dark_mode);
            }
            RelativeLayout relativeLayout = this.mBottomBgLayout;
            if (relativeLayout != null) {
                relativeLayout.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_title_color));
            }
            TextView textView = this.mBottomBackTvText;
            if (textView != null) {
                textView.setTextColor(getResources().getColor(b.sapi_sdk_dark_mode_edit_text_color));
            }
            ImageView imageView3 = this.mBottomDividerLine;
            if (imageView3 != null) {
                imageView3.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_title_color));
            }
        }
    }

    public void configTitle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SapiConfiguration sapiConfiguration = this.configuration;
            if (sapiConfiguration != null && sapiConfiguration.customActionBarEnabled) {
                a();
            } else {
                setTitleLayoutVisible(8);
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.finish();
            setPageAnim(false);
        }
    }

    public SapiWebDTO getWebDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (SapiWebDTO) invokeV.objValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setPageAnim(true);
        }
    }

    public void onBottomBackBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (view != this.mLeftBtnIv && view != this.mLeftBtnTv) {
                if (view == this.mRightBtn) {
                    onRightBtnClick();
                    return;
                } else if (view != this.mBottomBackBtnIv && view != this.mBottomBackTvText) {
                    if (view == this.mRightBtnClose) {
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
    }

    public void onClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
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
            LogUtil.logActivity(this, "onCreate");
        }
    }

    public void onLeftBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // android.app.Activity
    @TargetApi(23)
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048585, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    public void onRightBtnClick() {
        TitleBtnCallback titleBtnCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (titleBtnCallback = this.titleBtnCallback) == null) {
            return;
        }
        titleBtnCallback.onRightClick();
    }

    public void onTitleRightBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            onClose();
        }
    }

    public void reportWebviewError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, th) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("error", Log.getStackTraceString(th));
            hashMap.put("device", Build.MODEL);
            hashMap.put(HttpConstants.OS_VERSION, Build.VERSION.RELEASE);
            StatService.onEvent("webview_init_error", hashMap);
        }
    }

    public void setBtnVisibility(int i2, int i3, int i4) {
        Button button;
        ImageView imageView;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048589, this, i2, i3, i4) == null) {
            if (this.useTitle && (textView = this.mLeftBtnTv) != null) {
                textView.setVisibility(i2);
            }
            if (this.useTitle && (imageView = this.mLeftBtnIv) != null) {
                imageView.setVisibility(i3);
            }
            if (!this.useTitle || (button = this.mRightBtn) == null) {
                return;
            }
            button.setVisibility(i4);
        }
    }

    public void setLeftBtnDrawable(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048590, this, drawable, drawable2, drawable3, drawable4) == null) && this.useTitle && (textView = this.mLeftBtnTv) != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }

    public void setLeftBtnImage(int i2) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || !this.useTitle || (imageView = this.mLeftBtnIv) == null || i2 == Integer.MAX_VALUE) {
            return;
        }
        imageView.setImageResource(i2);
    }

    public void setLeftBtnImgVisible(int i2) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i2) == null) && this.useTitle && (imageView = this.mLeftBtnIv) != null) {
            imageView.setVisibility(i2);
        }
    }

    public void setLeftBtnLayoutVisible(int i2) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048593, this, i2) == null) && this.useTitle && (linearLayout = this.mLeftBtnLayout) != null) {
            linearLayout.setVisibility(i2);
        }
    }

    public void setLeftBtnText(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, str) == null) && this.useTitle && (textView = this.mLeftBtnTv) != null) {
            textView.setText(str);
        }
    }

    public void setLeftBtnTextColor(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048595, this, i2) == null) && this.useTitle && (textView = this.mLeftBtnTv) != null) {
            textView.setTextColor(i2);
        }
    }

    public void setLeftBtnTextSize(float f2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048596, this, f2) == null) && this.useTitle && (textView = this.mLeftBtnTv) != null) {
            textView.setTextSize(f2);
        }
    }

    public void setLeftBtnTextVisible(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048597, this, i2) == null) && this.useTitle && (textView = this.mLeftBtnTv) != null) {
            textView.setVisibility(i2);
        }
    }

    public void setPageAnim(boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            SapiConfiguration sapiConfiguration = this.configuration;
            int i6 = sapiConfiguration == null ? 0 : sapiConfiguration.activityOpenAnimId;
            SapiConfiguration sapiConfiguration2 = this.configuration;
            int i7 = sapiConfiguration2 != null ? sapiConfiguration2.activityExitAnimId : 0;
            SapiWebDTO webDTO = getWebDTO();
            if (webDTO != null && (i5 = webDTO.openEnterAnimId) != 0) {
                i6 = i5;
            }
            if (webDTO != null && (i4 = webDTO.closeExitAnimId) != 0) {
                i7 = i4;
            }
            if (i6 == 0) {
                i6 = a.sapi_sdk_slide_right_in;
            }
            if (i7 == 0) {
                i7 = a.sapi_sdk_slide_right_out;
            }
            if (z) {
                int i8 = a.sapi_sdk_slide_left_out;
                if (webDTO != null && (i3 = webDTO.openExitAnimId) != 0) {
                    i8 = i3;
                }
                overridePendingTransition(i6, i8);
                return;
            }
            int i9 = a.sapi_sdk_slide_left_in;
            if (webDTO != null && (i2 = webDTO.closeEnterAnimId) != 0) {
                i9 = i2;
            }
            overridePendingTransition(i9, i7);
        }
    }

    public void setRightBtnColor(int i2) {
        Button button;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048599, this, i2) == null) && this.useTitle && (button = this.mRightBtn) != null) {
            button.setTextColor(i2);
        }
    }

    public void setRightBtnText(String str) {
        Button button;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, str) == null) && this.useTitle && (button = this.mRightBtn) != null) {
            button.setText(str);
        }
    }

    public void setRightBtnTextSize(float f2) {
        Button button;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048601, this, f2) == null) && this.useTitle && (button = this.mRightBtn) != null) {
            button.setTextSize(f2);
        }
    }

    public void setRightBtnVisible(int i2) {
        Button button;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048602, this, i2) == null) && this.useTitle && (button = this.mRightBtn) != null) {
            button.setVisibility(i2);
        }
    }

    public void setTitleDrawable(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048603, this, drawable, drawable2, drawable3, drawable4) == null) && this.useTitle && (textView = this.mTitle) != null) {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }

    public void setTitleLayoutBg(int i2) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048604, this, i2) == null) || !this.useTitle || (relativeLayout = this.mTitleBgLayout) == null || i2 == Integer.MAX_VALUE || relativeLayout == null) {
            return;
        }
        relativeLayout.setBackgroundColor(i2);
    }

    public void setTitleLayoutHeight(int i2) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048605, this, i2) == null) || !this.useTitle || (relativeLayout = this.mTitleLayout) == null || i2 == Integer.MAX_VALUE) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        layoutParams.height = i2;
        this.mTitleLayout.setLayoutParams(layoutParams);
    }

    public void setTitleLayoutVisible(int i2) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048606, this, i2) == null) && this.useTitle && (relativeLayout = this.mTitleLayout) != null) {
            relativeLayout.setVisibility(i2);
        }
    }

    public void setTitleText(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, str) == null) && this.useTitle && this.mTitle != null) {
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
    }

    public void setTitleTextBold(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048609, this, z) == null) && this.useTitle && (textView = this.mTitle) != null) {
            textView.setTypeface(z ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
        }
    }

    public void setTitleTextColor(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048610, this, i2) == null) && this.useTitle && (textView = this.mTitle) != null) {
            textView.setTextColor(i2);
        }
    }

    public void setTitleTextSize(float f2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048611, this, f2) == null) && this.useTitle && (textView = this.mTitle) != null) {
            textView.setTextSize(f2);
        }
    }

    public void setTitleVisible(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048612, this, i2) == null) && this.useTitle && (textView = this.mTitle) != null) {
            textView.setVisibility(i2);
        }
    }

    public void setupViews() {
        ViewStub viewStub;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
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
                SapiConfiguration sapiConfiguration = this.configuration;
                if (sapiConfiguration != null && sapiConfiguration.showBottomBack && this.bottomBackView == null && (viewStub = (ViewStub) findViewById(e.stub_bottom_back)) != null) {
                    this.bottomBackView = viewStub.inflate();
                    this.mBottomBackBtnIv = (ImageView) findViewById(e.sapi_bottom_back);
                    this.mBottomBackTvText = (TextView) findViewById(e.sapi_textview_back);
                    this.mBottomBgLayout = (RelativeLayout) findViewById(e.sapi_layout_bottom_back);
                    this.mBottomDividerLine = (ImageView) findViewById(e.sapi_sdk_bottom_divider_line);
                    ViewUtility.setOnClickListener(this.mBottomBackBtnIv, this);
                    ViewUtility.setOnClickListener(this.mBottomBackTvText, this);
                    ViewUtility.setViewClickAlpha(this.mBottomBackBtnIv, 0.2f);
                    this.mBottomBackTvText.setVisibility(this.configuration.isShowBottomBackText ? 0 : 8);
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
                    ViewUtility.enlargedViews(this.mLeftBtnIv, sapiConfiguration2.textZoom);
                    ViewUtility.enlargedViews(this.mLeftBtnTv, this.configuration.textZoom);
                    ViewUtility.enlargedViews(this.mTitle, this.configuration.textZoom);
                    ViewUtility.enlargedViews(this.mRightBtn, this.configuration.textZoom);
                    ViewUtility.enlargedViews(this.mRightBtnClose, this.configuration.textZoom);
                    ViewUtility.enlargedViews(this.mBottomBackBtnIv, this.configuration.textZoom);
                    ViewUtility.enlargedViews(this.mBottomBackTvText, this.configuration.textZoom);
                }
            }
            SapiConfiguration sapiConfiguration3 = this.configuration;
            if (sapiConfiguration3 != null && !sapiConfiguration3.isDarkMode && sapiConfiguration3.isNightMode) {
                ((ViewGroup) this.mTitleBgLayout.getRootView()).addView(((LayoutInflater) getSystemService("layout_inflater")).inflate(f.layout_sapi_sdk_night_mode_mask, (ViewGroup) null), new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
            }
            if (this.bottomBackView != null) {
                SoftKeyBoardListener.setListener(this, new SoftKeyBoardListener.OnSoftKeyBoardChangeListener(this) { // from class: com.baidu.sapi2.activity.TitleActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TitleActivity a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.baidu.sapi2.utils.SoftKeyBoardListener.OnSoftKeyBoardChangeListener
                    public void keyBoardHide(int i2) {
                        View view;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            TitleActivity titleActivity = this.a;
                            if (!titleActivity.realShowBottomBack || (view = titleActivity.bottomBackView) == null) {
                                return;
                            }
                            view.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.sapi2.utils.SoftKeyBoardListener.OnSoftKeyBoardChangeListener
                    public void keyBoardShow(int i2) {
                        View view;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (view = this.a.bottomBackView) == null) {
                            return;
                        }
                        view.setVisibility(8);
                    }
                });
            }
            configTitle();
        }
    }

    public void updateBottomBack(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            SapiConfiguration sapiConfiguration = this.configuration;
            if (sapiConfiguration.showBottomBack) {
                if (i2 == 1) {
                    this.realShowBottomBack = false;
                    this.bottomBackView.setVisibility(8);
                    this.mRightBtnClose.setVisibility(0);
                    return;
                }
                this.realShowBottomBack = true;
                this.bottomBackView.setVisibility(0);
                this.mRightBtnClose.setVisibility(8);
            } else if (sapiConfiguration.showCloseBtn) {
                if (i2 == 1) {
                    this.mRightBtnClose.setVisibility(0);
                    this.mLeftBtnLayout.setVisibility(8);
                    return;
                }
                this.mRightBtnClose.setVisibility(8);
                this.mLeftBtnLayout.setVisibility(0);
            }
        }
    }

    public void setTitleText(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048607, this, i2) == null) && this.useTitle && (textView = this.mTitle) != null) {
            textView.setText(getResources().getText(i2));
        }
    }
}
