package com.baidu.tbadk.browser;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.NewUrlSchemaHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import java.net.MalformedURLException;
import java.net.URL;
/* loaded from: classes3.dex */
public class BaseWebViewFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public String f12760e;

    /* renamed from: f  reason: collision with root package name */
    public String f12761f;

    /* renamed from: g  reason: collision with root package name */
    public String f12762g;

    public ShareItem E0(String str, String str2, String str3, String str4) {
        ShareItem shareItem = new ShareItem();
        if (StringUtils.isNull(this.f12762g, true)) {
            shareItem.r = getResources().getString(R.string.share_from_tieba);
        } else {
            shareItem.r = this.f12762g;
        }
        shareItem.t = this.f12760e;
        if (StringUtils.isNull(this.f12761f, true)) {
            shareItem.s = this.f12760e;
        } else {
            String F0 = F0("<meta name=\"description\" content=\"", "\"");
            if (StringUtils.isNull(F0, true)) {
                shareItem.s = this.f12760e;
            } else {
                shareItem.s = F0;
            }
            String F02 = F0("<img src=\"", "\"");
            if (!StringUtils.isNull(F02, true)) {
                shareItem.v = Uri.parse(F02);
            }
            String F03 = F0("<meta name=\"shareurl\" content=\"", "\"");
            if (!StringUtils.isNull(F03, true)) {
                shareItem.t = F03;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            shareItem.r = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            shareItem.t = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            shareItem.s = str3;
        }
        if (!TextUtils.isEmpty(str4)) {
            shareItem.v = Uri.parse(str4);
        }
        return shareItem;
    }

    public final String F0(String str, String str2) {
        int indexOf;
        if (StringUtils.isNull(str, true) || StringUtils.isNull(str2, true) || (indexOf = this.f12761f.indexOf(str)) < 0) {
            return null;
        }
        int length = indexOf + str.length();
        String str3 = this.f12761f;
        String substring = str3.substring(length, str3.length());
        int indexOf2 = substring.indexOf(str2);
        if (indexOf2 < 0) {
            return null;
        }
        return substring.substring(0, indexOf2);
    }

    public boolean G0(String str) {
        return K0(str, "blank");
    }

    public boolean H0() {
        return K0(this.f12760e, "nomenu");
    }

    public boolean I0() {
        return K0(this.f12760e, "nonavigationbar");
    }

    public boolean J0() {
        return K0(this.f12760e, "noshare");
    }

    public boolean K0(String str, String str2) {
        String[] split;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            try {
                String query = new URL(str).getQuery();
                if (StringUtils.isNull(query) || (split = query.split("&")) == null) {
                    return true;
                }
                for (String str3 : split) {
                    String[] split2 = str3.split("=");
                    if (split2 != null && split2.length == 2) {
                        String str4 = split2[0];
                        String str5 = split2[1];
                        if (str2.equalsIgnoreCase(str4) && "1".equalsIgnoreCase(str5)) {
                            return false;
                        }
                    }
                }
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
            }
        }
        return true;
    }

    public final String L0(String str) {
        return (str == null || str.startsWith("http://") || str.startsWith("https://")) ? str : "http://".concat(str);
    }

    public void M0(String str) {
        if (!StringUtils.isNull(str) && str.startsWith(NewUrlSchemaHelper.Jump.JUMP_TO_TBWEBVIEW)) {
            this.f12760e = str;
        } else {
            this.f12760e = L0(str);
        }
    }

    public void N0(String str) {
        this.f12762g = str;
    }
}
