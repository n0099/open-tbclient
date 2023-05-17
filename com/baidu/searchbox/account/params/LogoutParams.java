package com.baidu.searchbox.account.params;

import android.text.TextUtils;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.account.data.UserAccountActionItem;
/* loaded from: classes3.dex */
public final class LogoutParams {
    public final UserAccountActionItem mLogoutSrc;
    public String mPluginName;

    public LogoutParams(Builder builder) {
        this.mLogoutSrc = builder.mLogoutSrc;
        this.mPluginName = builder.mPluginName;
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        public UserAccountActionItem mLogoutSrc;
        public String mPluginName;

        public Builder setLogoutSrc(UserAccountActionItem userAccountActionItem) {
            this.mLogoutSrc = userAccountActionItem;
            return this;
        }

        public Builder setPluginName(String str) {
            this.mPluginName = str;
            return this;
        }

        public LogoutParams build() {
            if (this.mLogoutSrc == null) {
                this.mLogoutSrc = new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGOUT, UserAccountActionItem.UserAccountType.NATIVE, AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS);
            }
            if (!TextUtils.isEmpty(this.mPluginName)) {
                UserAccountActionItem userAccountActionItem = this.mLogoutSrc;
                userAccountActionItem.setSrc(this.mPluginName + "_" + this.mLogoutSrc.getSrc());
            }
            return new LogoutParams(this);
        }
    }

    public String toString() {
        UserAccountActionItem userAccountActionItem = this.mLogoutSrc;
        if (userAccountActionItem != null) {
            return userAccountActionItem.toString();
        }
        return super.toString();
    }
}
