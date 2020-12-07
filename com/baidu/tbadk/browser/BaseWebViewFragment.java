package com.baidu.tbadk.browser;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.webkit.internal.ETAG;
import java.net.MalformedURLException;
import java.net.URL;
/* loaded from: classes.dex */
public class BaseWebViewFragment extends BaseFragment {
    private String mSource;
    public String mUrl;
    private String mUrlTitle;

    public void Ar(String str) {
        this.mUrlTitle = str;
    }

    public void setUrl(String str) {
        if (!StringUtils.isNull(str) && str.startsWith("com.baidu.tieba://tbwebview")) {
            this.mUrl = str;
        } else {
            this.mUrl = parseWebViewUrl(str);
        }
    }

    private String parseWebViewUrl(String str) {
        if (str != null && !str.startsWith("http://") && !str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
            return "http://".concat(str);
        }
        return str;
    }

    public boolean isNeedShowNavigationBar() {
        return dJ(this.mUrl, "nonavigationbar");
    }

    public boolean isNeedShowShareItem() {
        return dJ(this.mUrl, "noshare");
    }

    public boolean isNeedShowMenuItem() {
        return dJ(this.mUrl, "nomenu");
    }

    public boolean As(String str) {
        return dJ(str, "blank");
    }

    public boolean dJ(String str, String str2) {
        String[] split;
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return true;
        }
        try {
            String query = new URL(str).getQuery();
            if (StringUtils.isNull(query) || (split = query.split(ETAG.ITEM_SEPARATOR)) == null) {
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
            return true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ShareItem createShareContent(String str, String str2, String str3, String str4) {
        ShareItem shareItem = new ShareItem();
        if (StringUtils.isNull(this.mUrlTitle, true)) {
            shareItem.title = getResources().getString(R.string.share_from_tieba);
        } else {
            shareItem.title = this.mUrlTitle;
        }
        shareItem.linkUrl = this.mUrl;
        if (StringUtils.isNull(this.mSource, true)) {
            shareItem.content = this.mUrl;
        } else {
            String findSubString = findSubString("<meta name=\"description\" content=\"", "\"");
            if (StringUtils.isNull(findSubString, true)) {
                shareItem.content = this.mUrl;
            } else {
                shareItem.content = findSubString;
            }
            String findSubString2 = findSubString("<img src=\"", "\"");
            if (!StringUtils.isNull(findSubString2, true)) {
                shareItem.imageUri = Uri.parse(findSubString2);
            }
            String findSubString3 = findSubString("<meta name=\"shareurl\" content=\"", "\"");
            if (!StringUtils.isNull(findSubString3, true)) {
                shareItem.linkUrl = findSubString3;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            shareItem.title = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            shareItem.linkUrl = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            shareItem.content = str3;
        }
        if (!TextUtils.isEmpty(str4)) {
            shareItem.imageUri = Uri.parse(str4);
        }
        return shareItem;
    }

    private String findSubString(String str, String str2) {
        int indexOf;
        if (StringUtils.isNull(str, true) || StringUtils.isNull(str2, true) || (indexOf = this.mSource.indexOf(str)) < 0) {
            return null;
        }
        String substring = this.mSource.substring(indexOf + str.length(), this.mSource.length());
        int indexOf2 = substring.indexOf(str2);
        if (indexOf2 >= 0) {
            return substring.substring(0, indexOf2);
        }
        return null;
    }
}
