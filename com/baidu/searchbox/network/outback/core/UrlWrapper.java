package com.baidu.searchbox.network.outback.core;

import android.text.TextUtils;
import com.baidu.searchbox.network.outback.core.internal.Util;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.text.Typography;
/* loaded from: classes3.dex */
public class UrlWrapper {
    public String host;
    public HttpUrl httpUrl;
    public int port;
    public String scheme;
    public String url;

    public UrlWrapper(HttpUrl httpUrl) {
        setParams(httpUrl);
    }

    private void setParams(HttpUrl httpUrl) {
        this.scheme = httpUrl.scheme;
        this.host = httpUrl.host;
        this.port = httpUrl.port;
        this.url = httpUrl.toString();
        this.httpUrl = httpUrl;
    }

    public int defaultPort(String str) {
        if (str.equals("http")) {
            return 80;
        }
        if (str.equals("https")) {
            return 443;
        }
        return -1;
    }

    public String encodedPath(UrlWrapper urlWrapper) {
        String urlWrapper2 = urlWrapper.toString();
        int indexOf = urlWrapper2.indexOf(47, urlWrapper.scheme().length() + 3);
        if (indexOf == -1) {
            return "/";
        }
        return urlWrapper2.substring(indexOf, delimiterOffset(urlWrapper2, indexOf, urlWrapper2.length(), "?#"));
    }

    public void setHttpUrl(HttpUrl httpUrl) {
        this.url = httpUrl.toString();
        this.httpUrl = httpUrl;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public UrlWrapper(String str) {
        this.url = str;
        partParse(str);
    }

    private int delimiterOffset(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private int parsePort(String str, int i, int i2) {
        int parseInt;
        try {
            parseInt = Integer.parseInt(str.substring(i, i2));
        } catch (NumberFormatException unused) {
        }
        if (parseInt <= 0 || parseInt > 65535) {
            return -1;
        }
        return parseInt;
    }

    private int portColonOffset(String str, int i, int i2) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != ':') {
                if (charAt != '[') {
                    i++;
                } else {
                    return -1;
                }
            } else {
                return i;
            }
        }
        return i2;
    }

    private int slashCount(String str, int i, int i2) {
        int i3 = 0;
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != '\\' && charAt != '/') {
                break;
            }
            i3++;
            i++;
        }
        return i3;
    }

    private int schemeDelimiterOffset(String str, int i, int i2) {
        if (i2 - i < 2) {
            return -1;
        }
        char charAt = str.charAt(i);
        if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
            while (true) {
                i++;
                if (i >= i2) {
                    break;
                }
                char charAt2 = str.charAt(i);
                if (charAt2 < 'a' || charAt2 > 'z') {
                    if (charAt2 < 'A' || charAt2 > 'Z') {
                        if (charAt2 < '0' || charAt2 > '9') {
                            if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                if (charAt2 == ':') {
                                    return i;
                                }
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    public HttpUrl getDefaultHttpUrl() {
        return this.httpUrl;
    }

    public HttpUrl getHttpUrl() {
        String str;
        if (this.httpUrl == null && (str = this.url) != null) {
            this.httpUrl = HttpUrl.get(str);
        }
        return this.httpUrl;
    }

    public String host() {
        if (!TextUtils.isEmpty(this.host)) {
            return this.host;
        }
        HttpUrl httpUrl = this.httpUrl;
        if (httpUrl != null) {
            String host = httpUrl.host();
            this.host = host;
            if (!TextUtils.isEmpty(host)) {
                return this.host;
            }
        }
        throw new IllegalStateException("host == null");
    }

    public boolean isHttps() {
        return scheme().equals("https");
    }

    public int port() {
        int i = this.port;
        if (i != -1) {
            return i;
        }
        HttpUrl httpUrl = this.httpUrl;
        if (httpUrl == null) {
            return -1;
        }
        int port = httpUrl.port();
        this.port = port;
        return port;
    }

    public String scheme() {
        if (!TextUtils.isEmpty(this.scheme)) {
            return this.scheme;
        }
        HttpUrl httpUrl = this.httpUrl;
        if (httpUrl != null) {
            String scheme = httpUrl.scheme();
            this.scheme = scheme;
            if (!TextUtils.isEmpty(scheme)) {
                return this.scheme;
            }
        }
        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
    }

    public String toString() {
        String str = this.url;
        if (str == null) {
            HttpUrl httpUrl = this.httpUrl;
            if (httpUrl == null) {
                return "";
            }
            return httpUrl.toString();
        }
        return str;
    }

    public URL url() {
        HttpUrl httpUrl = this.httpUrl;
        if (httpUrl != null) {
            return httpUrl.url();
        }
        try {
            return new URL(this.url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public void partParse(String str) {
        int i;
        int delimiterOffset;
        char c;
        int skipLeadingAsciiWhitespace = Util.skipLeadingAsciiWhitespace(str, 0, str.length());
        int skipTrailingAsciiWhitespace = Util.skipTrailingAsciiWhitespace(str, skipLeadingAsciiWhitespace, str.length());
        int schemeDelimiterOffset = schemeDelimiterOffset(str, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace);
        if (schemeDelimiterOffset != -1) {
            String substring = str.substring(skipLeadingAsciiWhitespace, schemeDelimiterOffset);
            this.scheme = substring;
            if (substring.equals("https")) {
                i = skipLeadingAsciiWhitespace + 6;
            } else if (this.scheme.equals("http")) {
                i = skipLeadingAsciiWhitespace + 5;
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, schemeDelimiterOffset) + "'");
            }
            int slashCount = slashCount(str, i, skipTrailingAsciiWhitespace);
            if (slashCount >= 2) {
                int i2 = i + slashCount;
                do {
                    delimiterOffset = delimiterOffset(str, i2, skipTrailingAsciiWhitespace, "/\\");
                    if (delimiterOffset != skipTrailingAsciiWhitespace) {
                        c = str.charAt(delimiterOffset);
                    } else {
                        c = 65535;
                    }
                    if (c == 65535 || c == '/') {
                        break;
                    }
                } while (c != '\\');
                int portColonOffset = portColonOffset(str, i2, delimiterOffset);
                if (portColonOffset == -1) {
                    setParams(HttpUrl.get(this.url));
                    return;
                }
                int i3 = portColonOffset + 1;
                if (i3 < delimiterOffset) {
                    this.host = str.substring(i2, portColonOffset);
                    this.port = parsePort(str, i3, delimiterOffset);
                } else {
                    this.host = str.substring(i2, portColonOffset);
                    this.port = defaultPort(this.scheme);
                }
                String str2 = this.host;
                if (str2 != null) {
                    int length = str2.length();
                    for (int i4 = 0; i4 < length; i4++) {
                        char charAt = this.host.charAt(i4);
                        if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                            setParams(HttpUrl.get(this.url));
                            return;
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("Invalid URL hos: \"" + str.substring(i2, portColonOffset) + Typography.quote);
            }
            return;
        }
        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
    }

    public String redact() {
        if (this.port != defaultPort(this.scheme)) {
            return this.scheme + "://" + this.host + ":" + this.port + "/...";
        }
        return this.scheme + "://" + this.host + "/...";
    }
}
