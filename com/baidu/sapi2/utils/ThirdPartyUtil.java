package com.baidu.sapi2.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.sapi2.utils.enums.SocialType;
import java.util.List;
/* loaded from: classes2.dex */
public class ThirdPartyUtil {
    public static final String TYPE_QQ = "qzone";
    public static final String TYPE_WEIBO = "tsina";
    public static final String TYPE_WEIXIN = "weixin";

    public static boolean checkAliPayInstalled(Context context) {
        return new Intent("android.intent.action.VIEW", Uri.parse("alipays://platformapi/startApp")).resolveActivity(context.getPackageManager()) != null;
    }

    public static Message getVerificationMsg(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Message message = new Message();
        if (str.equals("qzone")) {
            message.what = SocialType.QQ_SSO.getType();
            message.obj = SocialType.QQ_SSO;
        } else if (str.equals(TYPE_WEIXIN)) {
            message.what = SocialType.WEIXIN.getType();
            message.obj = SocialType.WEIXIN;
        } else if (str.equals("tsina")) {
            message.what = SocialType.SINA_WEIBO_SSO.getType();
            message.obj = SocialType.SINA_WEIBO_SSO;
        }
        return message;
    }

    public static boolean isQQClientAvailable(Context context) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages != null) {
            for (int i2 = 0; i2 < installedPackages.size(); i2++) {
                String str = installedPackages.get(i2).packageName;
                if (str.equalsIgnoreCase("com.tencent.qqlite") || str.equalsIgnoreCase("com.tencent.mobileqq")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isSinaInstalled(Context context) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages != null) {
            for (int i2 = 0; i2 < installedPackages.size(); i2++) {
                if (installedPackages.get(i2).packageName.equals("com.sina.weibo")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isWeixinAvilible(Context context) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages != null) {
            for (int i2 = 0; i2 < installedPackages.size(); i2++) {
                if (installedPackages.get(i2).packageName.equals("com.tencent.mm")) {
                    return true;
                }
            }
        }
        return false;
    }
}
