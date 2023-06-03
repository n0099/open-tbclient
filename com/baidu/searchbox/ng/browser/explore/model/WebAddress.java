package com.baidu.searchbox.ng.browser.explore.model;

import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class WebAddress {
    public static final String GOOD_IRI_CHAR = "a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef";
    public static final int HTTPS_PORT = 443;
    public static final int HTTP_PORT = 80;
    public static final String LOGTAG = "http";
    public static final int MATCH_GROUP_AUTHORITY = 2;
    public static final int MATCH_GROUP_HOST = 3;
    public static final int MATCH_GROUP_PATH = 5;
    public static final int MATCH_GROUP_PORT = 4;
    public static final int MATCH_GROUP_SCHEME = 1;
    public static Pattern sAddressPattern = Pattern.compile("(?:(http|https|file)\\:\\/\\/)?(?:([-A-Za-z0-9$_.+!*'(),;?&=]+(?:\\:[-A-Za-z0-9$_.+!*'(),;?&=]+)?)@)?([-a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef%_]+(?:\\.[-a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef%_]+)*|\\[[0-9a-fA-F:\\.]+\\])?(?:\\:([0-9]*))?(\\/?[^#]*)?.*", 2);
    public String mAuthInfo;
    public String mHost;
    public String mPath;
    public int mPort;
    public String mScheme;

    public String getScheme() {
        return this.mScheme;
    }

    @NonNull
    public String toString() {
        return getHostAddress() + this.mPath;
    }

    public WebAddress(String str) throws Exception {
        initWebAddress(str, "");
    }

    public WebAddress(String str, String str2) throws Exception {
        initWebAddress(str, str2);
    }

    public String getHostAddress() {
        String str;
        String str2 = "";
        if ((this.mPort == 443 || !this.mScheme.equals("https")) && (this.mPort == 80 || !this.mScheme.equals("http"))) {
            str = "";
        } else {
            str = ":" + this.mPort;
        }
        if (this.mAuthInfo.length() > 0) {
            str2 = this.mAuthInfo + "@";
        }
        return this.mScheme + "://" + str2 + this.mHost + str;
    }

    public void initWebAddress(String str, String str2) {
        if (str != null) {
            this.mScheme = "";
            this.mHost = "";
            this.mPort = -1;
            this.mPath = "/";
            this.mAuthInfo = "";
            Matcher matcher = sAddressPattern.matcher(str);
            if (matcher.matches()) {
                String group = matcher.group(1);
                if (group != null) {
                    this.mScheme = group.toLowerCase(Locale.getDefault());
                }
                String group2 = matcher.group(2);
                if (group2 != null) {
                    this.mAuthInfo = group2;
                }
                String group3 = matcher.group(3);
                if (group3 != null) {
                    this.mHost = group3;
                }
                String group4 = matcher.group(4);
                if (group4 != null && group4.length() > 0) {
                    try {
                        this.mPort = Integer.parseInt(group4);
                    } catch (NumberFormatException unused) {
                        throw new RuntimeException("Bad port: " + group4 + StringUtil.ARRAY_ELEMENT_SEPARATOR + str + "preUrl = " + str2);
                    }
                }
                String group5 = matcher.group(5);
                if (group5 != null && group5.length() > 0) {
                    if (group5.charAt(0) == '/') {
                        this.mPath = group5;
                    } else {
                        this.mPath = "/" + group5;
                    }
                }
                if (this.mPort == 443 && this.mScheme.equals("")) {
                    this.mScheme = "https";
                } else if (this.mPort == -1) {
                    if (this.mScheme.equals("https")) {
                        this.mPort = 443;
                    } else {
                        this.mPort = 80;
                    }
                }
                if (this.mScheme.equals("")) {
                    this.mScheme = "http";
                    return;
                }
                return;
            }
            throw new RuntimeException("Bad address");
        }
        throw null;
    }
}
