package com.baidu.searchbox.account.component;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class NicknamePortraitConfig {
    public String buttonText;
    public boolean isRecommend;
    public int nicknamePortraitType;
    public String source;
    public String subTitle;
    public String tips;
    public String title;

    /* loaded from: classes3.dex */
    public static class Builder {
        public String mButtonText;
        public int mNicknamePortraitType;
        public String mSource;
        public String mSubTitle;
        public String mTips;
        public String mTitle;

        public NicknamePortraitConfig build() {
            return new NicknamePortraitConfig(this);
        }

        public Builder setButtonText(String str) {
            this.mButtonText = str;
            return this;
        }

        public Builder setNicknamePortraitType(int i) {
            this.mNicknamePortraitType = i;
            return this;
        }

        public Builder setSource(String str) {
            this.mSource = str;
            return this;
        }

        public Builder setSubTitle(String str) {
            this.mSubTitle = str;
            return this;
        }

        public Builder setTipsText(String str) {
            this.mTips = str;
            return this;
        }

        public Builder setTitle(String str) {
            this.mTitle = str;
            return this;
        }
    }

    public NicknamePortraitConfig(Builder builder) {
        this.isRecommend = true;
        this.source = builder.mSource;
        this.nicknamePortraitType = builder.mNicknamePortraitType;
        this.title = builder.mTitle;
        this.buttonText = builder.mButtonText;
        this.subTitle = builder.mSubTitle;
        this.tips = builder.mTips;
    }

    public static Builder getDefaultBuilder() {
        try {
            return new Builder().setTitle(AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f009b)).setSubTitle(AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f0098)).setButtonText(AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f0096)).setTipsText(AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f0099)).setNicknamePortraitType(-1).setSource(AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS);
        } catch (Throwable unused) {
            return new Builder();
        }
    }
}
