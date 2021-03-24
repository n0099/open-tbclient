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
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static final String f11527a = "weixin";

    /* renamed from: b  reason: collision with root package name */
    public static final String f11528b = "qzone";

    /* renamed from: c  reason: collision with root package name */
    public static final String f11529c = "tsina";

    public static boolean a(Context context) {
        return new Intent("android.intent.action.VIEW", Uri.parse("alipays://platformapi/startApp")).resolveActivity(context.getPackageManager()) != null;
    }

    public static boolean b(Context context) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages != null) {
            for (int i = 0; i < installedPackages.size(); i++) {
                String str = installedPackages.get(i).packageName;
                if (str.equalsIgnoreCase("com.tencent.qqlite") || str.equalsIgnoreCase("com.tencent.mobileqq")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean c(Context context) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages != null) {
            for (int i = 0; i < installedPackages.size(); i++) {
                if (installedPackages.get(i).packageName.equals("com.sina.weibo")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean d(Context context) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages != null) {
            for (int i = 0; i < installedPackages.size(); i++) {
                if (installedPackages.get(i).packageName.equals("com.tencent.mm")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Message a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Message message = new Message();
        if (str.equals("qzone")) {
            message.what = SocialType.QQ_SSO.getType();
            message.obj = SocialType.QQ_SSO;
        } else if (str.equals(f11527a)) {
            message.what = SocialType.WEIXIN.getType();
            message.obj = SocialType.WEIXIN;
        } else if (str.equals("tsina")) {
            message.what = SocialType.SINA_WEIBO_SSO.getType();
            message.obj = SocialType.SINA_WEIBO_SSO;
        }
        return message;
    }
}
