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
    public String f12017e;

    /* renamed from: f  reason: collision with root package name */
    public String f12018f;

    /* renamed from: g  reason: collision with root package name */
    public String f12019g;

    public ShareItem D0(String str, String str2, String str3, String str4) {
        ShareItem shareItem = new ShareItem();
        if (StringUtils.isNull(this.f12019g, true)) {
            shareItem.r = getResources().getString(R.string.share_from_tieba);
        } else {
            shareItem.r = this.f12019g;
        }
        shareItem.t = this.f12017e;
        if (StringUtils.isNull(this.f12018f, true)) {
            shareItem.s = this.f12017e;
        } else {
            String E0 = E0("<meta name=\"description\" content=\"", "\"");
            if (StringUtils.isNull(E0, true)) {
                shareItem.s = this.f12017e;
            } else {
                shareItem.s = E0;
            }
            String E02 = E0("<img src=\"", "\"");
            if (!StringUtils.isNull(E02, true)) {
                shareItem.v = Uri.parse(E02);
            }
            String E03 = E0("<meta name=\"shareurl\" content=\"", "\"");
            if (!StringUtils.isNull(E03, true)) {
                shareItem.t = E03;
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

    public final String E0(String str, String str2) {
        int indexOf;
        if (StringUtils.isNull(str, true) || StringUtils.isNull(str2, true) || (indexOf = this.f12018f.indexOf(str)) < 0) {
            return null;
        }
        int length = indexOf + str.length();
        String str3 = this.f12018f;
        String substring = str3.substring(length, str3.length());
        int indexOf2 = substring.indexOf(str2);
        if (indexOf2 < 0) {
            return null;
        }
        return substring.substring(0, indexOf2);
    }

    public boolean F0(String str) {
        return J0(str, "blank");
    }

    public boolean G0() {
        return J0(this.f12017e, "nomenu");
    }

    public boolean H0() {
        return J0(this.f12017e, "nonavigationbar");
    }

    public boolean I0() {
        return J0(this.f12017e, "noshare");
    }

    public boolean J0(String str, String str2) {
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

    public final String K0(String str) {
        return (str == null || str.startsWith("http://") || str.startsWith("https://")) ? str : "http://".concat(str);
    }

    public void L0(String str) {
        if (!StringUtils.isNull(str) && str.startsWith(NewUrlSchemaHelper.Jump.JUMP_TO_TBWEBVIEW)) {
            this.f12017e = str;
        } else {
            this.f12017e = K0(str);
        }
    }

    public void M0(String str) {
        this.f12019g = str;
    }
}
