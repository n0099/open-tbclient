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
    public String f11980e;

    /* renamed from: f  reason: collision with root package name */
    public String f11981f;

    /* renamed from: g  reason: collision with root package name */
    public String f11982g;

    public ShareItem G0(String str, String str2, String str3, String str4) {
        ShareItem shareItem = new ShareItem();
        if (StringUtils.isNull(this.f11982g, true)) {
            shareItem.r = getResources().getString(R.string.share_from_tieba);
        } else {
            shareItem.r = this.f11982g;
        }
        shareItem.t = this.f11980e;
        if (StringUtils.isNull(this.f11981f, true)) {
            shareItem.s = this.f11980e;
        } else {
            String H0 = H0("<meta name=\"description\" content=\"", "\"");
            if (StringUtils.isNull(H0, true)) {
                shareItem.s = this.f11980e;
            } else {
                shareItem.s = H0;
            }
            String H02 = H0("<img src=\"", "\"");
            if (!StringUtils.isNull(H02, true)) {
                shareItem.v = Uri.parse(H02);
            }
            String H03 = H0("<meta name=\"shareurl\" content=\"", "\"");
            if (!StringUtils.isNull(H03, true)) {
                shareItem.t = H03;
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

    public final String H0(String str, String str2) {
        int indexOf;
        if (StringUtils.isNull(str, true) || StringUtils.isNull(str2, true) || (indexOf = this.f11981f.indexOf(str)) < 0) {
            return null;
        }
        int length = indexOf + str.length();
        String str3 = this.f11981f;
        String substring = str3.substring(length, str3.length());
        int indexOf2 = substring.indexOf(str2);
        if (indexOf2 < 0) {
            return null;
        }
        return substring.substring(0, indexOf2);
    }

    public boolean I0(String str) {
        return M0(str, "blank");
    }

    public boolean J0() {
        return M0(this.f11980e, "nomenu");
    }

    public boolean K0() {
        return M0(this.f11980e, "nonavigationbar");
    }

    public boolean L0() {
        return M0(this.f11980e, "noshare");
    }

    public boolean M0(String str, String str2) {
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

    public final String N0(String str) {
        return (str == null || str.startsWith("http://") || str.startsWith("https://")) ? str : "http://".concat(str);
    }

    public void O0(String str) {
        if (!StringUtils.isNull(str) && str.startsWith(NewUrlSchemaHelper.Jump.JUMP_TO_TBWEBVIEW)) {
            this.f11980e = str;
        } else {
            this.f11980e = N0(str);
        }
    }

    public void P0(String str) {
        this.f11982g = str;
    }
}
