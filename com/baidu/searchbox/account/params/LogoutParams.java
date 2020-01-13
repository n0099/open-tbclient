package com.baidu.searchbox.account.params;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.account.data.UserAccountActionItem;
/* loaded from: classes10.dex */
public final class LogoutParams {
    public final UserAccountActionItem mLogoutSrc;

    private LogoutParams(Builder builder) {
        this.mLogoutSrc = builder.mLogoutSrc;
    }

    public String toString() {
        return this.mLogoutSrc != null ? this.mLogoutSrc.toString() : super.toString();
    }

    /* loaded from: classes10.dex */
    public static class Builder {
        private UserAccountActionItem mLogoutSrc;

        public Builder setLogoutSrc(UserAccountActionItem userAccountActionItem) {
            this.mLogoutSrc = userAccountActionItem;
            return this;
        }

        public LogoutParams build() {
            if (this.mLogoutSrc == null) {
                this.mLogoutSrc = new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGOUT, UserAccountActionItem.UserAccountType.NATIVE, AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS);
            }
            return new LogoutParams(this);
        }
    }
}
