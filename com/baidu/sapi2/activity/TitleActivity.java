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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobstat.Config;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes2.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                View view2 = this.dividerLine;
                if (view2 != null) {
                    view2.setVisibility(titleViewModule.dividerLineVisible);
                }
            } else {
                setBtnVisibility(4, 0, 4);
                setTitleDrawable(null, null, null, null);
                setLeftBtnDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f081000), null, null, null);
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
                setTitleLayoutBg(getResources().getColor(R.color.obfuscated_res_0x7f0609b7));
                setLeftBtnImage(R.drawable.obfuscated_res_0x7f081001);
                setLeftBtnTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609b4));
                setTitleTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609b4));
                setRightBtnColor(getResources().getColor(R.color.obfuscated_res_0x7f0609b4));
                LinearLayout linearLayout = this.mLeftBtnLayout;
                if (linearLayout != null) {
                    linearLayout.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0609b7));
                }
                ImageView imageView = this.mRightBtnClose;
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.obfuscated_res_0x7f081076);
                }
                View view2 = this.dividerLine;
                if (view2 != null) {
                    view2.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0609b7));
                }
            }
            ImageView imageView2 = this.mBottomBackBtnIv;
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.obfuscated_res_0x7f081001);
            }
            RelativeLayout relativeLayout = this.mBottomBgLayout;
            if (relativeLayout != null) {
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0609b7));
            }
            TextView textView = this.mBottomBackTvText;
            if (textView != null) {
                textView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f0609b4));
            }
            ImageView imageView3 = this.mBottomDividerLine;
            if (imageView3 != null) {
                imageView3.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f0609b7));
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
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            if (view2 != this.mLeftBtnIv && view2 != this.mLeftBtnTv) {
                if (view2 == this.mRightBtn) {
                    onRightBtnClick();
                    return;
                } else if (view2 != this.mBottomBackBtnIv && view2 != this.mBottomBackTvText) {
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
                setTheme(R.style.obfuscated_res_0x7f100177);
            } else {
                SapiConfiguration sapiConfiguration2 = this.configuration;
                if (sapiConfiguration2 != null && sapiConfiguration2.isNightMode) {
                    setTheme(R.style.obfuscated_res_0x7f100178);
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
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048585, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
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
            hashMap.put(Config.DEVICE_PART, Build.MODEL);
            hashMap.put(HttpConstants.OS_VERSION, Build.VERSION.RELEASE);
            StatService.onEvent("webview_init_error", hashMap);
        }
    }

    public void setBtnVisibility(int i, int i2, int i3) {
        Button button;
        ImageView imageView;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048589, this, i, i2, i3) == null) {
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
    }

    public void setLeftBtnDrawable(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048590, this, drawable, drawable2, drawable3, drawable4) == null) && this.useTitle && (textView = this.mLeftBtnTv) != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }

    public void setLeftBtnImage(int i) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i) == null) || !this.useTitle || (imageView = this.mLeftBtnIv) == null || i == Integer.MAX_VALUE) {
            return;
        }
        imageView.setImageResource(i);
    }

    public void setLeftBtnImgVisible(int i) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i) == null) && this.useTitle && (imageView = this.mLeftBtnIv) != null) {
            imageView.setVisibility(i);
        }
    }

    public void setLeftBtnLayoutVisible(int i) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048593, this, i) == null) && this.useTitle && (linearLayout = this.mLeftBtnLayout) != null) {
            linearLayout.setVisibility(i);
        }
    }

    public void setLeftBtnText(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, str) == null) && this.useTitle && (textView = this.mLeftBtnTv) != null) {
            textView.setText(str);
        }
    }

    public void setLeftBtnTextColor(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048595, this, i) == null) && this.useTitle && (textView = this.mLeftBtnTv) != null) {
            textView.setTextColor(i);
        }
    }

    public void setLeftBtnTextSize(float f) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048596, this, f) == null) && this.useTitle && (textView = this.mLeftBtnTv) != null) {
            textView.setTextSize(f);
        }
    }

    public void setLeftBtnTextVisible(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048597, this, i) == null) && this.useTitle && (textView = this.mLeftBtnTv) != null) {
            textView.setVisibility(i);
        }
    }

    public void setPageAnim(boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            SapiConfiguration sapiConfiguration = this.configuration;
            int i5 = sapiConfiguration == null ? 0 : sapiConfiguration.activityOpenAnimId;
            SapiConfiguration sapiConfiguration2 = this.configuration;
            int i6 = sapiConfiguration2 != null ? sapiConfiguration2.activityExitAnimId : 0;
            SapiWebDTO webDTO = getWebDTO();
            if (webDTO != null && (i4 = webDTO.openEnterAnimId) != 0) {
                i5 = i4;
            }
            if (webDTO != null && (i3 = webDTO.closeExitAnimId) != 0) {
                i6 = i3;
            }
            if (i5 == 0) {
                i5 = R.anim.obfuscated_res_0x7f01010e;
            }
            if (i6 == 0) {
                i6 = R.anim.obfuscated_res_0x7f01010f;
            }
            if (z) {
                int i7 = R.anim.obfuscated_res_0x7f01010d;
                if (webDTO != null && (i2 = webDTO.openExitAnimId) != 0) {
                    i7 = i2;
                }
                overridePendingTransition(i5, i7);
                return;
            }
            int i8 = R.anim.obfuscated_res_0x7f01010c;
            if (webDTO != null && (i = webDTO.closeEnterAnimId) != 0) {
                i8 = i;
            }
            overridePendingTransition(i8, i6);
        }
    }

    public void setRightBtnColor(int i) {
        Button button;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048599, this, i) == null) && this.useTitle && (button = this.mRightBtn) != null) {
            button.setTextColor(i);
        }
    }

    public void setRightBtnText(String str) {
        Button button;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, str) == null) && this.useTitle && (button = this.mRightBtn) != null) {
            button.setText(str);
        }
    }

    public void setRightBtnTextSize(float f) {
        Button button;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048601, this, f) == null) && this.useTitle && (button = this.mRightBtn) != null) {
            button.setTextSize(f);
        }
    }

    public void setRightBtnVisible(int i) {
        Button button;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048602, this, i) == null) && this.useTitle && (button = this.mRightBtn) != null) {
            button.setVisibility(i);
        }
    }

    public void setTitleDrawable(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048603, this, drawable, drawable2, drawable3, drawable4) == null) && this.useTitle && (textView = this.mTitle) != null) {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }

    public void setTitleLayoutBg(int i) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048604, this, i) == null) || !this.useTitle || (relativeLayout = this.mTitleBgLayout) == null || i == Integer.MAX_VALUE || relativeLayout == null) {
            return;
        }
        relativeLayout.setBackgroundColor(i);
    }

    public void setTitleLayoutHeight(int i) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048605, this, i) == null) || !this.useTitle || (relativeLayout = this.mTitleLayout) == null || i == Integer.MAX_VALUE) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        layoutParams.height = i;
        this.mTitleLayout.setLayoutParams(layoutParams);
    }

    public void setTitleLayoutVisible(int i) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048606, this, i) == null) && this.useTitle && (relativeLayout = this.mTitleLayout) != null) {
            relativeLayout.setVisibility(i);
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

    public void setTitleTextColor(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048610, this, i) == null) && this.useTitle && (textView = this.mTitle) != null) {
            textView.setTextColor(i);
        }
    }

    public void setTitleTextSize(float f) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048611, this, f) == null) && this.useTitle && (textView = this.mTitle) != null) {
            textView.setTextSize(f);
        }
    }

    public void setTitleVisible(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048612, this, i) == null) && this.useTitle && (textView = this.mTitle) != null) {
            textView.setVisibility(i);
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
                this.mTitle = (TextView) findViewById(R.id.obfuscated_res_0x7f092013);
                this.mLeftBtnLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09202e);
                this.mLeftBtnTv = (TextView) findViewById(R.id.obfuscated_res_0x7f092020);
                this.mLeftBtnIv = (ImageView) findViewById(R.id.obfuscated_res_0x7f09201f);
                this.mRightBtn = (Button) findViewById(R.id.obfuscated_res_0x7f092021);
                this.mTitleLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091bd7);
                this.mTitleBgLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091bd6);
                this.dividerLine = findViewById(R.id.obfuscated_res_0x7f092026);
                this.mRightBtnClose = (ImageView) findViewById(R.id.obfuscated_res_0x7f09203b);
                SapiConfiguration sapiConfiguration = this.configuration;
                if (sapiConfiguration != null && sapiConfiguration.showBottomBack && this.bottomBackView == null && (viewStub = (ViewStub) findViewById(R.id.obfuscated_res_0x7f091da5)) != null) {
                    this.bottomBackView = viewStub.inflate();
                    this.mBottomBackBtnIv = (ImageView) findViewById(R.id.obfuscated_res_0x7f091b1e);
                    this.mBottomBackTvText = (TextView) findViewById(R.id.obfuscated_res_0x7f091bd5);
                    this.mBottomBgLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091b20);
                    this.mBottomDividerLine = (ImageView) findViewById(R.id.obfuscated_res_0x7f091b69);
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
                ((ViewGroup) this.mTitleBgLayout.getRootView()).addView(((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.obfuscated_res_0x7f0d04d8, (ViewGroup) null), new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.baidu.sapi2.utils.SoftKeyBoardListener.OnSoftKeyBoardChangeListener
                    public void keyBoardHide(int i) {
                        View view2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                            TitleActivity titleActivity = this.a;
                            if (!titleActivity.realShowBottomBack || (view2 = titleActivity.bottomBackView) == null) {
                                return;
                            }
                            view2.setVisibility(0);
                        }
                    }

                    @Override // com.baidu.sapi2.utils.SoftKeyBoardListener.OnSoftKeyBoardChangeListener
                    public void keyBoardShow(int i) {
                        View view2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (view2 = this.a.bottomBackView) == null) {
                            return;
                        }
                        view2.setVisibility(8);
                    }
                });
            }
            configTitle();
        }
    }

    public void updateBottomBack(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
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
    }

    public void setTitleText(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048607, this, i) == null) && this.useTitle && (textView = this.mTitle) != null) {
            textView.setText(getResources().getText(i));
        }
    }
}
