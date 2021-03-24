package com.baidu.searchbox.account.params;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.account.data.UserAccountActionItem;
/* loaded from: classes2.dex */
public final class LogoutParams {
    public final UserAccountActionItem mLogoutSrc;

    /* loaded from: classes2.dex */
    public static class Builder {
        public UserAccountActionItem mLogoutSrc;

        public LogoutParams build() {
            if (this.mLogoutSrc == null) {
                this.mLogoutSrc = new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGOUT, UserAccountActionItem.UserAccountType.NATIVE, AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS);
            }
            return new LogoutParams(this);
        }

        public Builder setLogoutSrc(UserAccountActionItem userAccountActionItem) {
            this.mLogoutSrc = userAccountActionItem;
            return this;
        }
    }

    public String toString() {
        UserAccountActionItem userAccountActionItem = this.mLogoutSrc;
        if (userAccountActionItem != null) {
            return userAccountActionItem.toString();
        }
        return super.toString();
    }

    public LogoutParams(Builder builder) {
        this.mLogoutSrc = builder.mLogoutSrc;
    }
}
