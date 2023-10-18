package com.baidu.sapi2.views.logindialog.enums;

import com.baidu.android.util.devices.RomUtils;
import com.baidu.searchbox.account.contants.LoginConstants;
/* loaded from: classes3.dex */
public enum QuickLoginType {
    HISTORY(0, "history"),
    SHARE(1, "share"),
    ONEKEY(2, "onekey"),
    SMS(3, LoginConstants.SMS_LOGIN),
    QQ(4, "qq"),
    WECHAT(5, "wechat"),
    YY(6, "yy"),
    SINA(7, LoginConstants.SINA_LOGIN),
    HUAWEI(8, RomUtils.MANUFACTURER_HUAWEI),
    HONOR(9, "honor"),
    XIAOMI(10, RomUtils.MANUFACTURER_XIAOMI),
    MEIZU(11, "meizu"),
    FULL_SCREEN(12, "full_screen"),
    REGISTER(13, "register");
    
    public final int a;
    public final String b;

    QuickLoginType(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public static QuickLoginType getViewLoginTypeByValue(String str) {
        char c2;
        int hashCode = str.hashCode();
        if (hashCode != -1012429255) {
            if (hashCode != 109400031) {
                if (hashCode == 926934164 && str.equals("history")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else {
                if (str.equals("share")) {
                    c2 = 1;
                }
                c2 = 65535;
            }
        } else {
            if (str.equals("onekey")) {
                c2 = 2;
            }
            c2 = 65535;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    return SMS;
                }
                return ONEKEY;
            }
            return SHARE;
        }
        return HISTORY;
    }

    public int getIndex() {
        return this.a;
    }

    public String getValue() {
        return this.b;
    }
}
