package com.baidu.tbadk.browser;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.d;
import java.net.MalformedURLException;
import java.net.URL;
/* loaded from: classes.dex */
public class BaseWebViewFragment extends BaseFragment {
    private String mSource;
    public String mUrl;
    private String mUrlTitle;

    public void setUrl(String str) {
        if (!StringUtils.isNull(str) && str.startsWith("com.baidu.tieba://tbwebview")) {
            this.mUrl = str;
        } else {
            this.mUrl = parseWebViewUrl(str);
        }
    }

    private String parseWebViewUrl(String str) {
        if (str != null && !str.startsWith("http://") && !str.startsWith("https://")) {
            return "http://".concat(str);
        }
        return str;
    }

    public boolean isNeedShowNavigationBar() {
        return K(this.mUrl, "nonavigationbar");
    }

    public boolean isNeedShowShareItem() {
        return K(this.mUrl, "noshare");
    }

    public boolean isNeedShowMenuItem() {
        return K(this.mUrl, "nomenu");
    }

    public boolean cj(String str) {
        return K(str, "blank");
    }

    public boolean K(String str, String str2) {
        String[] split;
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return true;
        }
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
            return true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tbadk.coreExtra.c.d createShareContent(String str, String str2, String str3, String str4) {
        com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
        if (StringUtils.isNull(this.mUrlTitle, true)) {
            dVar.title = getResources().getString(d.k.share_from_tieba);
        } else {
            dVar.title = this.mUrlTitle;
        }
        dVar.linkUrl = this.mUrl;
        if (StringUtils.isNull(this.mSource, true)) {
            dVar.content = this.mUrl;
        } else {
            String findSubString = findSubString("<meta name=\"description\" content=\"", "\"");
            if (StringUtils.isNull(findSubString, true)) {
                dVar.content = this.mUrl;
            } else {
                dVar.content = findSubString;
            }
            String findSubString2 = findSubString("<img src=\"", "\"");
            if (!StringUtils.isNull(findSubString2, true)) {
                dVar.awV = Uri.parse(findSubString2);
            }
            String findSubString3 = findSubString("<meta name=\"shareurl\" content=\"", "\"");
            if (!StringUtils.isNull(findSubString3, true)) {
                dVar.linkUrl = findSubString3;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            dVar.title = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            dVar.linkUrl = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            dVar.content = str3;
        }
        if (!TextUtils.isEmpty(str4)) {
            dVar.awV = Uri.parse(str4);
        }
        return dVar;
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
