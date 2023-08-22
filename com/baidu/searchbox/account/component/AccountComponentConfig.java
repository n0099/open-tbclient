package com.baidu.searchbox.account.component;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import androidx.annotation.ColorInt;
import com.baidu.searchbox.account.IAccountDialogContext;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.account.params.LoginParams;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tieba.R;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AccountComponentConfig {
    public int mAgreeCheckedIconColor;
    public int mAgreeCheckedIconNightColor;
    public boolean mAgreeTextBold;
    public int mAgreeTextColor;
    public int mAgreeTextNightColor;
    public int mAgreeTextRes;
    public int mAppNameRes;
    public int mAppNameTextColor;
    public int mAppNameTextNightColor;
    public boolean mClearDimBehind;
    public Drawable mCommonLoginDrawable;
    public int mCommonLoginDrawableColor;
    public String mCommonLoginText;
    public int mCommonLoginTextColor;
    public int mCommonLoginTextNightColor;
    public IAccountDialogContext mDialogContext;
    public int mForceLoginStyle;
    public Drawable mFunctionIconDrawable;
    public boolean mIsCanceledOnTouchOutside;
    public boolean mIsExperLoginedUserInfoExpose;
    public boolean mIsSupportGuest;
    public boolean mIsSupportShareLogin;
    public boolean mIsSupportThirdLoginIcons;
    public boolean mIsSupportWXEnhanceLogin;
    public boolean mIsWaitViewReady;
    public Bitmap mLoginDialogBackgroundBitmap;
    public String mLoginDialogBackgroundUrl;
    public String mLoginDialogTitleIconUrl;
    public String mLoginSrc;
    public String mLoginSrcToPass;
    public boolean mLoginTextColorFilterOnNightMode;
    public int mMainTitleColor;
    public int mMainTitleNightColor;
    public CharSequence mMainTitleText;
    public Drawable mMoreLoginDrawable;
    @LoginParams.NightMode
    public int mNightMode;
    public Drawable mOneKeyLoginDrawable;
    public int mOneKeyLoginDrawableColor;
    public String mOneKeyLoginText;
    public int mOneKeyLoginTextColor;
    public int mOneKeyLoginTextNightColor;
    public boolean mOnekeyFailJumpPass;
    public int mOtherLoginTextColor;
    public int mOtherLoginTextNightColor;
    public Drawable mPhoneLoginDrawable;
    public int mPhoneTextColor;
    public int mPhoneTextNightColor;
    public Drawable mQQLoginDrawable;
    public Drawable mShareLoginDrawable;
    public int mShareLoginDrawableColor;
    public String mShareLoginText;
    public int mShareLoginTextColor;
    public int mShareLoginTextNightColor;
    public Drawable mSinaLoginDrawable;
    public int mSubTitleColor;
    public String mSubTitleLink;
    public int mSubTitleNightColor;
    public String mSubTitleText;
    public boolean mSupportAnim;
    public int mThirdTitleTextColor;
    public int mThirdTitleTextNightColor;
    public boolean mUseDeafultCommonStyle;
    public int mUserNameTextColor;
    public int mUserNameTextNightColor;
    public int mVerificationCodeTextColor;
    public Drawable mVerificationCodeTextDrawable;
    public int mVerificationCodeTextNightColor;
    public Drawable mWXLoginDrawable;
    public Drawable mYYLoginDrawable;

    /* loaded from: classes3.dex */
    public static class Builder {
        public int mAgreeCheckedIconColor;
        public int mAgreeCheckedIconNightColor;
        public boolean mAgreeTextBold;
        public int mAgreeTextColor;
        public int mAgreeTextNightColor;
        public int mAgreeTextRes;
        public int mAppNameRes;
        public int mAppNameTextColor;
        public int mAppNameTextNightColor;
        public boolean mClearDimBehind;
        public Drawable mCommonLoginDrawable;
        public String mCommonLoginText;
        public int mCommonLoginTextColor;
        public int mCommonLoginTextNightColor;
        public Drawable mFunctionIconDrawable;
        public boolean mIsSupportGuest;
        public boolean mIsSupportShareLogin;
        public boolean mIsWaitViewReady;
        public Bitmap mLoginDialogBackgroundBitmap;
        public String mLoginDialogBackgroundUrl;
        public String mLoginDialogTitleIconUrl;
        public String mLoginSrc;
        public String mLoginSrcToPass;
        public int mMainTitleColor;
        public int mMainTitleNightColor;
        public CharSequence mMainTitleText;
        public Drawable mMoreLoginDrawable;
        @LoginParams.NightMode
        public int mNightMode;
        public Drawable mOneKeyLoginDrawable;
        public String mOneKeyLoginText;
        public int mOneKeyLoginTextColor;
        public int mOneKeyLoginTextNightColor;
        public int mOtherLoginTextColor;
        public int mOtherLoginTextNightColor;
        public Drawable mPhoneLoginDrawable;
        public int mPhoneTextColor;
        public int mPhoneTextNightColor;
        public Drawable mQQLoginDrawable;
        public Drawable mShareLoginDrawable;
        public String mShareLoginText;
        public int mShareLoginTextColor;
        public int mShareLoginTextNightColor;
        public Drawable mSinaLoginDrawable;
        public int mSubTitleColor;
        public String mSubTitleLink;
        public int mSubTitleNightColor;
        public String mSubTitleText;
        public boolean mSupportAnim;
        public int mThirdTitleTextColor;
        public int mThirdTitleTextNightColor;
        public boolean mUseDeafultCommonStyle;
        public int mUserNameTextColor;
        public int mUserNameTextNightColor;
        public int mVerificationCodeTextColor;
        public Drawable mVerificationCodeTextDrawable;
        public int mVerificationCodeTextNightColor;
        public Drawable mWXLoginDrawable;
        public Drawable mYYLoginDrawable;
        public int mOneKeyLoginDrawableColor = 0;
        public int mShareLoginDrawableColor = 0;
        public int mCommonLoginDrawableColor = 0;
        public boolean mIsSupportWXEnhanceLogin = true;
        public boolean mIsSupportThirdLoginIcons = true;
        public boolean mIsCanceledOnTouchOutside = true;
        public boolean mIsExperLoginedUserInfoExpose = false;
        public boolean mLoginTextColorFilterOnNightMode = true;
        public int mForceLoginStyle = -1;

        public AccountComponentConfig build() {
            return new AccountComponentConfig(this);
        }

        public Builder setAgreeTextBold(boolean z) {
            this.mAgreeTextBold = z;
            return this;
        }

        public Builder setAgreeTextRes(int i) {
            this.mAgreeTextRes = i;
            return this;
        }

        public Builder setAppNameRes(int i) {
            this.mAppNameRes = i;
            return this;
        }

        public Builder setCanceledOnTouchOutside(boolean z) {
            this.mIsCanceledOnTouchOutside = z;
            return this;
        }

        public Builder setClearDimBehind(boolean z) {
            this.mClearDimBehind = z;
            return this;
        }

        public Builder setCommonBtnDrawable(Drawable drawable) {
            this.mCommonLoginDrawable = drawable;
            return this;
        }

        public Builder setCommonBtnDrawableColor(@ColorInt int i) {
            this.mCommonLoginDrawableColor = i;
            return this;
        }

        public Builder setCommonLoginText(String str) {
            this.mCommonLoginText = str;
            return this;
        }

        public Builder setForceLoginStyle(int i) {
            this.mForceLoginStyle = i;
            return this;
        }

        public Builder setFunctionIconDrawable(Drawable drawable) {
            this.mFunctionIconDrawable = drawable;
            return this;
        }

        public Builder setIsExperLoginedUserInfoExpose(boolean z) {
            this.mIsExperLoginedUserInfoExpose = z;
            return this;
        }

        public Builder setLoginDialogBackgroundBitmap(Bitmap bitmap) {
            this.mLoginDialogBackgroundBitmap = bitmap;
            return this;
        }

        public Builder setLoginDialogBackgroundUrl(String str) {
            this.mLoginDialogBackgroundUrl = str;
            return this;
        }

        public Builder setLoginDialogTitleIconUrl(String str) {
            this.mLoginDialogTitleIconUrl = str;
            return this;
        }

        public Builder setLoginSrc(String str) {
            this.mLoginSrc = str;
            return this;
        }

        public Builder setLoginSrcToPass(String str) {
            this.mLoginSrcToPass = str;
            return this;
        }

        public Builder setLoginTextColorFilterOnNightMode(boolean z) {
            this.mLoginTextColorFilterOnNightMode = z;
            return this;
        }

        public Builder setMainTitleText(CharSequence charSequence) {
            this.mMainTitleText = charSequence;
            return this;
        }

        public Builder setMoreLoginIcon(Drawable drawable) {
            this.mMoreLoginDrawable = drawable;
            return this;
        }

        public Builder setNightMode(@LoginParams.NightMode int i) {
            this.mNightMode = i;
            return this;
        }

        public Builder setOneKeyBtnDrawable(Drawable drawable) {
            this.mOneKeyLoginDrawable = drawable;
            return this;
        }

        public Builder setOneKeyBtnDrawableColor(@ColorInt int i) {
            this.mOneKeyLoginDrawableColor = i;
            return this;
        }

        public Builder setOneKeyLoginText(String str) {
            this.mOneKeyLoginText = str;
            return this;
        }

        public Builder setPhoneLoginIcon(Drawable drawable) {
            this.mPhoneLoginDrawable = drawable;
            return this;
        }

        public Builder setQQLoginIcon(Drawable drawable) {
            this.mQQLoginDrawable = drawable;
            return this;
        }

        public Builder setShareBtnDrawable(Drawable drawable) {
            this.mShareLoginDrawable = drawable;
            return this;
        }

        public Builder setShareBtnDrawableColor(@ColorInt int i) {
            this.mShareLoginDrawableColor = i;
            return this;
        }

        public Builder setShareLoginText(String str) {
            this.mShareLoginText = str;
            return this;
        }

        public Builder setSinaLoginIcon(Drawable drawable) {
            this.mSinaLoginDrawable = drawable;
            return this;
        }

        public Builder setSubTitleLink(String str) {
            this.mSubTitleLink = str;
            return this;
        }

        public Builder setSubTitleText(String str) {
            this.mSubTitleText = str;
            return this;
        }

        public Builder setSupportAnim(boolean z) {
            this.mSupportAnim = z;
            return this;
        }

        public Builder setSupportGuest(boolean z) {
            this.mIsSupportGuest = z;
            return this;
        }

        public Builder setSupportShareLogin(boolean z) {
            this.mIsSupportShareLogin = z;
            return this;
        }

        public Builder setSupportThirdLoginIcons(boolean z) {
            this.mIsSupportThirdLoginIcons = z;
            return this;
        }

        public Builder setSupportWxEnhanceLogin(boolean z) {
            this.mIsSupportWXEnhanceLogin = z;
            return this;
        }

        public Builder setVerificationCodeTextDrawable(Drawable drawable) {
            this.mVerificationCodeTextDrawable = drawable;
            return this;
        }

        public Builder setWXLoginIcon(Drawable drawable) {
            this.mWXLoginDrawable = drawable;
            return this;
        }

        public Builder setWaitViewReady(boolean z) {
            this.mIsWaitViewReady = z;
            return this;
        }

        public Builder setYYLoginIcon(Drawable drawable) {
            this.mYYLoginDrawable = drawable;
            return this;
        }

        public Builder showDefaultCommonStyle(boolean z) {
            this.mUseDeafultCommonStyle = z;
            return this;
        }

        public Builder setAgreeCheckedIconColor(int i, int i2) {
            this.mAgreeCheckedIconColor = i;
            this.mAgreeCheckedIconNightColor = i2;
            return this;
        }

        public Builder setAgreeTextColor(int i, int i2) {
            this.mAgreeTextColor = i;
            this.mAgreeTextNightColor = i2;
            return this;
        }

        public Builder setAppNameTextColor(int i, int i2) {
            this.mAppNameTextColor = i;
            this.mAppNameTextNightColor = i2;
            return this;
        }

        public Builder setCommonLoginTextColor(int i, int i2) {
            this.mCommonLoginTextColor = i;
            this.mCommonLoginTextNightColor = i2;
            return this;
        }

        public Builder setMainTitleColor(int i, int i2) {
            this.mMainTitleColor = i;
            this.mMainTitleNightColor = i2;
            return this;
        }

        public Builder setOneKeyLoginTextColor(int i, int i2) {
            this.mOneKeyLoginTextColor = i;
            this.mOneKeyLoginTextNightColor = i2;
            return this;
        }

        public Builder setOtherLoginColor(int i, int i2) {
            this.mOtherLoginTextColor = i;
            this.mOtherLoginTextNightColor = i2;
            return this;
        }

        public Builder setPhoneTextColor(int i, int i2) {
            this.mPhoneTextColor = i;
            this.mPhoneTextNightColor = i2;
            return this;
        }

        public Builder setShareLoginTextColor(int i, int i2) {
            this.mShareLoginTextColor = i;
            this.mShareLoginTextNightColor = i2;
            return this;
        }

        public Builder setSubTitleColor(int i, int i2) {
            this.mSubTitleColor = i;
            this.mSubTitleNightColor = i2;
            return this;
        }

        public Builder setThirdTitleTextColor(int i, int i2) {
            this.mThirdTitleTextColor = i;
            this.mThirdTitleTextNightColor = i2;
            return this;
        }

        public Builder setUserNameTextColor(int i, int i2) {
            this.mUserNameTextColor = i;
            this.mUserNameTextNightColor = i2;
            return this;
        }

        public Builder setVerificationCodeTextColor(int i, int i2) {
            this.mVerificationCodeTextColor = i;
            this.mVerificationCodeTextNightColor = i2;
            return this;
        }

        public Builder setMainTitleText(String str) {
            this.mMainTitleText = str;
            return this;
        }
    }

    public AccountComponentConfig(Builder builder) {
        this.mIsSupportWXEnhanceLogin = true;
        this.mIsSupportThirdLoginIcons = true;
        this.mIsCanceledOnTouchOutside = true;
        this.mLoginTextColorFilterOnNightMode = true;
        this.mForceLoginStyle = -1;
        this.mOnekeyFailJumpPass = true;
        this.mMainTitleColor = builder.mMainTitleColor;
        this.mMainTitleNightColor = builder.mMainTitleNightColor;
        this.mSubTitleColor = builder.mSubTitleColor;
        this.mSubTitleNightColor = builder.mSubTitleNightColor;
        this.mSubTitleLink = builder.mSubTitleLink;
        this.mPhoneTextColor = builder.mPhoneTextColor;
        this.mPhoneTextNightColor = builder.mPhoneTextNightColor;
        this.mAgreeTextColor = builder.mAgreeTextColor;
        this.mAgreeTextNightColor = builder.mAgreeTextNightColor;
        this.mAgreeCheckedIconColor = builder.mAgreeCheckedIconColor;
        this.mAgreeCheckedIconNightColor = builder.mAgreeCheckedIconNightColor;
        this.mOneKeyLoginTextColor = builder.mOneKeyLoginTextColor;
        this.mOneKeyLoginTextNightColor = builder.mOneKeyLoginTextNightColor;
        this.mShareLoginTextColor = builder.mShareLoginTextColor;
        this.mShareLoginTextNightColor = builder.mShareLoginTextNightColor;
        this.mOtherLoginTextColor = builder.mOtherLoginTextColor;
        this.mOtherLoginTextNightColor = builder.mOtherLoginTextNightColor;
        this.mCommonLoginTextColor = builder.mCommonLoginTextColor;
        this.mCommonLoginTextNightColor = builder.mCommonLoginTextNightColor;
        this.mUserNameTextColor = builder.mUserNameTextColor;
        this.mUserNameTextNightColor = builder.mUserNameTextNightColor;
        this.mAppNameTextColor = builder.mAppNameTextColor;
        this.mAppNameTextNightColor = builder.mAppNameTextNightColor;
        this.mThirdTitleTextColor = builder.mThirdTitleTextColor;
        this.mThirdTitleTextNightColor = builder.mThirdTitleTextNightColor;
        this.mVerificationCodeTextColor = builder.mVerificationCodeTextColor;
        this.mVerificationCodeTextNightColor = builder.mVerificationCodeTextNightColor;
        this.mMainTitleText = builder.mMainTitleText;
        this.mSubTitleText = builder.mSubTitleText;
        this.mOneKeyLoginText = builder.mOneKeyLoginText;
        this.mShareLoginText = builder.mShareLoginText;
        this.mCommonLoginText = builder.mCommonLoginText;
        this.mLoginDialogBackgroundBitmap = builder.mLoginDialogBackgroundBitmap;
        this.mLoginDialogBackgroundUrl = builder.mLoginDialogBackgroundUrl;
        this.mLoginDialogTitleIconUrl = builder.mLoginDialogTitleIconUrl;
        this.mFunctionIconDrawable = builder.mFunctionIconDrawable;
        this.mOneKeyLoginDrawable = builder.mOneKeyLoginDrawable;
        this.mShareLoginDrawable = builder.mShareLoginDrawable;
        this.mCommonLoginDrawable = builder.mCommonLoginDrawable;
        this.mPhoneLoginDrawable = builder.mPhoneLoginDrawable;
        this.mWXLoginDrawable = builder.mWXLoginDrawable;
        this.mQQLoginDrawable = builder.mQQLoginDrawable;
        this.mSinaLoginDrawable = builder.mSinaLoginDrawable;
        this.mMoreLoginDrawable = builder.mMoreLoginDrawable;
        this.mYYLoginDrawable = builder.mYYLoginDrawable;
        this.mVerificationCodeTextDrawable = builder.mVerificationCodeTextDrawable;
        this.mUseDeafultCommonStyle = builder.mUseDeafultCommonStyle;
        this.mLoginSrc = builder.mLoginSrc;
        this.mLoginSrcToPass = builder.mLoginSrcToPass;
        this.mAgreeTextBold = builder.mAgreeTextBold;
        this.mAgreeTextRes = builder.mAgreeTextRes;
        this.mAppNameRes = builder.mAppNameRes;
        this.mIsSupportGuest = builder.mIsSupportGuest;
        this.mIsSupportShareLogin = builder.mIsSupportShareLogin;
        this.mIsSupportWXEnhanceLogin = builder.mIsSupportWXEnhanceLogin;
        this.mClearDimBehind = builder.mClearDimBehind;
        this.mIsSupportThirdLoginIcons = builder.mIsSupportThirdLoginIcons;
        this.mIsCanceledOnTouchOutside = builder.mIsCanceledOnTouchOutside;
        this.mIsExperLoginedUserInfoExpose = builder.mIsExperLoginedUserInfoExpose;
        this.mLoginTextColorFilterOnNightMode = builder.mLoginTextColorFilterOnNightMode;
        this.mSupportAnim = builder.mSupportAnim;
        this.mNightMode = builder.mNightMode;
        this.mForceLoginStyle = builder.mForceLoginStyle;
        this.mIsWaitViewReady = builder.mIsWaitViewReady;
        this.mOneKeyLoginDrawableColor = builder.mOneKeyLoginDrawableColor;
        this.mShareLoginDrawableColor = builder.mShareLoginDrawableColor;
        this.mCommonLoginDrawableColor = builder.mCommonLoginDrawableColor;
    }

    public static int colorInt(String str) {
        try {
            return Color.parseColor(str);
        } catch (Exception e) {
            if (AppConfig.isDebug()) {
                e.printStackTrace();
            }
            return -1;
        }
    }

    public static Builder getDefaulgParamsBuilder() {
        try {
            int color = AppRuntime.getAppContext().getResources().getColor(R.color.obfuscated_res_0x7f0603d9);
            int color2 = AppRuntime.getAppContext().getResources().getColor(R.color.obfuscated_res_0x7f0603e3);
            int color3 = AppRuntime.getAppContext().getResources().getColor(R.color.obfuscated_res_0x7f0603e5);
            int color4 = AppRuntime.getAppContext().getResources().getColor(R.color.obfuscated_res_0x7f0603e7);
            int color5 = AppRuntime.getAppContext().getResources().getColor(R.color.obfuscated_res_0x7f0603dc);
            int color6 = AppRuntime.getAppContext().getResources().getColor(R.color.obfuscated_res_0x7f0603dd);
            int color7 = AppRuntime.getAppContext().getResources().getColor(R.color.obfuscated_res_0x7f0603e1);
            int color8 = AppRuntime.getAppContext().getResources().getColor(R.color.obfuscated_res_0x7f0603e2);
            return new Builder().setMainTitleColor(color, color7).setSubTitleColor(color2, color5).setPhoneTextColor(color, color7).setAgreeTextColor(color3, color5).setUserNameTextColor(color, color7).setAppNameTextColor(color2, color5).setOneKeyLoginTextColor(color4, color8).setShareLoginTextColor(color4, color8).setCommonLoginTextColor(color4, color8).setOtherLoginColor(color, color7).setThirdTitleTextColor(color3, color6).setMainTitleText(AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f0081)).setSubTitleText("").setSubTitleLink("").setOneKeyLoginText(AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f0079)).setShareLoginText(AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f0079)).setCommonLoginText(AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f0076)).setAgreeTextRes(R.string.obfuscated_res_0x7f0f0078).setAppNameRes(R.string.obfuscated_res_0x7f0f00ae).setOneKeyBtnDrawable(AppRuntime.getAppContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f0800b9)).setShareBtnDrawable(AppRuntime.getAppContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f0800b9)).setCommonBtnDrawable(AppRuntime.getAppContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f0800b9)).setPhoneLoginIcon(AppRuntime.getAppContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f0800c0)).setWXLoginIcon(AppRuntime.getAppContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f0800c6)).setQQLoginIcon(AppRuntime.getAppContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f0800c1)).setSinaLoginIcon(AppRuntime.getAppContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f0800c2)).setYYLoginIcon(AppRuntime.getAppContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f0800c7)).setMoreLoginIcon(AppRuntime.getAppContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f0800bf)).setFunctionIconDrawable(null).showDefaultCommonStyle(true).setAgreeTextBold(true).setLoginSrc(AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS).setLoginSrcToPass("").setSupportGuest(false).setSupportShareLogin(true).setSupportAnim(false).setNightMode(0).setForceLoginStyle(-1);
        } catch (Throwable unused) {
            return new Builder();
        }
    }

    public static Builder getQuickLoginParamsBuilder() {
        try {
            Builder defaulgParamsBuilder = getDefaulgParamsBuilder();
            defaulgParamsBuilder.setCommonLoginText(AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f0077));
            return defaulgParamsBuilder;
        } catch (Throwable unused) {
            return new Builder();
        }
    }

    public static Builder getTaskSystemBuilder(String str, boolean z) {
        Builder defaulgParamsBuilder = getDefaulgParamsBuilder();
        defaulgParamsBuilder.setSupportWxEnhanceLogin(false);
        defaulgParamsBuilder.setSupportThirdLoginIcons(false);
        int colorInt = colorInt("#FF0020");
        defaulgParamsBuilder.setOneKeyBtnDrawableColor(colorInt).setShareBtnDrawableColor(colorInt).setCommonBtnDrawableColor(colorInt);
        if (TextUtils.isEmpty(str)) {
            return defaulgParamsBuilder;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("top_banner_bg");
            if (!TextUtils.isEmpty(optString)) {
                defaulgParamsBuilder.setLoginDialogBackgroundUrl(optString);
            }
            String optString2 = jSONObject.optString("left_top_icon");
            if (!TextUtils.isEmpty(optString2)) {
                defaulgParamsBuilder.setLoginDialogTitleIconUrl(optString2);
            }
            String optString3 = jSONObject.optString("title_text");
            String optString4 = jSONObject.optString("price_text");
            int colorInt2 = colorInt(jSONObject.optString("price_color"));
            int colorInt3 = colorInt(jSONObject.optString("price_color_night"));
            int colorInt4 = colorInt(jSONObject.optString("button_text_color"));
            int colorInt5 = colorInt(jSONObject.optString("button_text_color_night"));
            int colorInt6 = colorInt(jSONObject.optString("button_bg_color"));
            String optString5 = jSONObject.optString("common_btn_text");
            String optString6 = jSONObject.optString("share_btn_text");
            String optString7 = jSONObject.optString("onekey_btn_text");
            if (colorInt4 != -1 && colorInt5 != -1) {
                defaulgParamsBuilder.setOneKeyLoginTextColor(colorInt4, colorInt5).setShareLoginTextColor(colorInt4, colorInt5).setCommonLoginTextColor(colorInt4, colorInt5);
            }
            if (colorInt6 != -1) {
                defaulgParamsBuilder.setOneKeyBtnDrawableColor(colorInt6).setShareBtnDrawableColor(colorInt6).setCommonBtnDrawableColor(colorInt6);
            }
            if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString7) && !TextUtils.isEmpty(optString6)) {
                defaulgParamsBuilder.setOneKeyLoginText(optString7).setShareLoginText(optString6).setCommonLoginText(optString5);
            }
            if (!TextUtils.isEmpty(optString3)) {
                SpannableString spannableString = new SpannableString(optString3);
                if (!TextUtils.isEmpty(optString4) && colorInt2 != -1 && colorInt3 != -1) {
                    if (z) {
                        colorInt2 = colorInt3;
                    }
                    int indexOf = optString3.indexOf(optString4);
                    if (indexOf >= 0) {
                        spannableString.setSpan(new RelativeSizeSpan(1.1f), indexOf, optString4.length() + indexOf, 17);
                        spannableString.setSpan(new ForegroundColorSpan(colorInt2), indexOf, optString4.length() + indexOf, 17);
                    }
                }
                defaulgParamsBuilder.setMainTitleText(spannableString);
            }
        } catch (Exception e) {
            if (AppConfig.isDebug()) {
                e.printStackTrace();
            }
        }
        return defaulgParamsBuilder;
    }
}
