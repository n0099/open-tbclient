package com.baidu.searchbox.network.core.http;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.searchbox.network.core.Challenge;
import com.baidu.searchbox.network.core.Cookie;
import com.baidu.searchbox.network.core.CookieJar;
import com.baidu.searchbox.network.core.Headers;
import com.baidu.searchbox.network.core.Request;
import com.baidu.searchbox.network.core.Response;
import com.baidu.searchbox.network.core.internal.Util;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.protocol.HTTP;
/* loaded from: classes15.dex */
public final class HttpHeaders {
    private static final String AUTH_PARAM_PATTERN_PART = "[!#$%&'*+.^_`|~\\p{Alnum}-]+[ \\t]*=[ \\t]*(?:[!#$%&'*+.^_`|~\\p{Alnum}-]+|\"(?:[\\t \\x21\\x23-\\x5B\\x5D-\\x7E\\x80-\\xFF]|\\\\([\\t \\p{Graph}\\x80-\\xFF]))*\")";
    private static final String CHALLENGE_PATTERN_PART = "[!#$%&'*+.^_`|~\\p{Alnum}-]+(?: +(?:[\\p{Alnum}._~+/-]+=*|(?:,|[!#$%&'*+.^_`|~\\p{Alnum}-]+[ \\t]*=[ \\t]*(?:[!#$%&'*+.^_`|~\\p{Alnum}-]+|\"(?:[\\t \\x21\\x23-\\x5B\\x5D-\\x7E\\x80-\\xFF]|\\\\([\\t \\p{Graph}\\x80-\\xFF]))*\"))(?:[ \\t]*,(?:[ \\t]*[!#$%&'*+.^_`|~\\p{Alnum}-]+[ \\t]*=[ \\t]*(?:[!#$%&'*+.^_`|~\\p{Alnum}-]+|\"(?:[\\t \\x21\\x23-\\x5B\\x5D-\\x7E\\x80-\\xFF]|\\\\([\\t \\p{Graph}\\x80-\\xFF]))*\"))?)*)?)?";
    private static final String OWS_PATTERN_PART = "[ \\t]*";
    private static final String QUOTED_STRING_PATTERN_PART = "\"(?:[\\t \\x21\\x23-\\x5B\\x5D-\\x7E\\x80-\\xFF]|\\\\([\\t \\p{Graph}\\x80-\\xFF]))*\"";
    private static final String TOKEN68_PATTERN_PART = "[\\p{Alnum}._~+/-]+=*";
    private static final String TOKEN_PATTERN_PART = "[!#$%&'*+.^_`|~\\p{Alnum}-]+";
    private static final Pattern AUTHENTICATION_HEADER_VALUE_PATTERN = Pattern.compile("^(?:,[ \\t]*)*[!#$%&'*+.^_`|~\\p{Alnum}-]+(?: +(?:[\\p{Alnum}._~+/-]+=*|(?:,|[!#$%&'*+.^_`|~\\p{Alnum}-]+[ \\t]*=[ \\t]*(?:[!#$%&'*+.^_`|~\\p{Alnum}-]+|\"(?:[\\t \\x21\\x23-\\x5B\\x5D-\\x7E\\x80-\\xFF]|\\\\([\\t \\p{Graph}\\x80-\\xFF]))*\"))(?:[ \\t]*,(?:[ \\t]*[!#$%&'*+.^_`|~\\p{Alnum}-]+[ \\t]*=[ \\t]*(?:[!#$%&'*+.^_`|~\\p{Alnum}-]+|\"(?:[\\t \\x21\\x23-\\x5B\\x5D-\\x7E\\x80-\\xFF]|\\\\([\\t \\p{Graph}\\x80-\\xFF]))*\"))?)*)?)?(?:[ \\t]*,(?:[ \\t]*[!#$%&'*+.^_`|~\\p{Alnum}-]+(?: +(?:[\\p{Alnum}._~+/-]+=*|(?:,|[!#$%&'*+.^_`|~\\p{Alnum}-]+[ \\t]*=[ \\t]*(?:[!#$%&'*+.^_`|~\\p{Alnum}-]+|\"(?:[\\t \\x21\\x23-\\x5B\\x5D-\\x7E\\x80-\\xFF]|\\\\([\\t \\p{Graph}\\x80-\\xFF]))*\"))(?:[ \\t]*,(?:[ \\t]*[!#$%&'*+.^_`|~\\p{Alnum}-]+[ \\t]*=[ \\t]*(?:[!#$%&'*+.^_`|~\\p{Alnum}-]+|\"(?:[\\t \\x21\\x23-\\x5B\\x5D-\\x7E\\x80-\\xFF]|\\\\([\\t \\p{Graph}\\x80-\\xFF]))*\"))?)*)?)?)?)*$");
    private static final Pattern AUTH_SCHEME_PATTERN = Pattern.compile("^[!#$%&'*+.^_`|~\\p{Alnum}-]+$");
    private static final Pattern AUTH_SCHEME_AND_TOKEN68_PATTERN = Pattern.compile("^[!#$%&'*+.^_`|~\\p{Alnum}-]+ +[\\p{Alnum}._~+/-]+=*$");
    private static final Pattern AUTH_SCHEME_AND_PARAM_PATTERN = Pattern.compile("^[!#$%&'*+.^_`|~\\p{Alnum}-]+ +[!#$%&'*+.^_`|~\\p{Alnum}-]+[ \\t]*=[ \\t]*(?:[!#$%&'*+.^_`|~\\p{Alnum}-]+|\"(?:[\\t \\x21\\x23-\\x5B\\x5D-\\x7E\\x80-\\xFF]|\\\\([\\t \\p{Graph}\\x80-\\xFF]))*\")$");
    private static final Pattern AUTH_PARAM_PATTERN = Pattern.compile("^[!#$%&'*+.^_`|~\\p{Alnum}-]+[ \\t]*=[ \\t]*(?:[!#$%&'*+.^_`|~\\p{Alnum}-]+|\"(?:[\\t \\x21\\x23-\\x5B\\x5D-\\x7E\\x80-\\xFF]|\\\\([\\t \\p{Graph}\\x80-\\xFF]))*\")$");
    private static final Pattern TOKEN_PATTERN = Pattern.compile("^[!#$%&'*+.^_`|~\\p{Alnum}-]+$");
    private static final String QUOTED_PAIR_PATTERN_PART = "\\\\([\\t \\p{Graph}\\x80-\\xFF])";
    private static final Pattern QUOTED_PAIR_PATTERN = Pattern.compile(QUOTED_PAIR_PATTERN_PART);
    private static final String AUTHENTICATION_HEADER_VALUE_SPLIT_PATTERN_PART = "(?:[ \\t]*,[ \\t]*)+";
    private static final Pattern AUTHENTICATION_HEADER_VALUE_SPLIT_PATTERN = Pattern.compile(AUTHENTICATION_HEADER_VALUE_SPLIT_PATTERN_PART);
    private static final Pattern WHITESPACE_SPLIT_PATTERN = Pattern.compile(" +");
    private static final Pattern AUTH_PARAM_SPLIT_PATTERN = Pattern.compile("[ \\t]*=[ \\t]*");
    private static final Pattern QUOTED_STRING_AUTH_PARAM_AT_END_PATTERN = Pattern.compile("[!#$%&'*+.^_`|~\\p{Alnum}-]+[ \\t]*=[ \\t]*\"(?:[\\t \\x21\\x23-\\x5B\\x5D-\\x7E\\x80-\\xFF]|\\\\([\\t \\p{Graph}\\x80-\\xFF]))*\"$");

    private HttpHeaders() {
    }

    public static long contentLength(Response response) {
        return contentLength(response.headers());
    }

    public static long contentLength(Headers headers) {
        return stringToLong(headers.get("Content-Length"));
    }

    private static long stringToLong(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            return -1L;
        }
    }

    public static boolean varyMatches(Response response, Headers headers, Request request) {
        for (String str : varyFields(response)) {
            if (!Util.equals(headers.values(str), request.headers(str))) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasVaryAll(Response response) {
        return hasVaryAll(response.headers());
    }

    public static boolean hasVaryAll(Headers headers) {
        return varyFields(headers).contains("*");
    }

    private static Set<String> varyFields(Response response) {
        return varyFields(response.headers());
    }

    public static Set<String> varyFields(Headers headers) {
        Set<String> emptySet = Collections.emptySet();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            if ("Vary".equalsIgnoreCase(headers.name(i))) {
                String value = headers.value(i);
                if (emptySet.isEmpty()) {
                    emptySet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
                }
                String[] split = value.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                for (String str : split) {
                    emptySet.add(str.trim());
                }
            }
        }
        return emptySet;
    }

    public static Headers varyHeaders(Response response) {
        return varyHeaders(response.networkResponse().request().headers(), response.headers());
    }

    public static Headers varyHeaders(Headers headers, Headers headers2) {
        Set<String> varyFields = varyFields(headers2);
        if (varyFields.isEmpty()) {
            return new Headers.Builder().build();
        }
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            if (varyFields.contains(name)) {
                builder.add(name, headers.value(i));
            }
        }
        return builder.build();
    }

    public static List<Challenge> parseChallenges(Headers headers, String str) {
        int i;
        String group;
        ArrayList arrayList = new ArrayList();
        for (String str2 : headers.values(str)) {
            if (AUTHENTICATION_HEADER_VALUE_PATTERN.matcher(str2).matches()) {
                ArrayList arrayList2 = new ArrayList();
                String[] split = AUTHENTICATION_HEADER_VALUE_SPLIT_PATTERN.split(str2);
                String str3 = null;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int i2 = 0;
                int length = split.length;
                while (true) {
                    if (i2 < length) {
                        String str4 = split[i2];
                        if (!str4.isEmpty()) {
                            if (AUTH_SCHEME_PATTERN.matcher(str4).matches()) {
                                i = i2;
                                group = null;
                            } else if (AUTH_SCHEME_AND_TOKEN68_PATTERN.matcher(str4).matches()) {
                                String[] split2 = WHITESPACE_SPLIT_PATTERN.split(str4, 2);
                                str4 = split2[0];
                                if (linkedHashMap.put(null, split2[1]) == null) {
                                    i = i2;
                                    group = null;
                                } else {
                                    throw new AssertionError();
                                }
                            } else if (AUTH_SCHEME_AND_PARAM_PATTERN.matcher(str4).matches()) {
                                String[] split3 = WHITESPACE_SPLIT_PATTERN.split(str4, 2);
                                str4 = split3[0];
                                String str5 = split3[1];
                                i = i2;
                                group = str5;
                            } else if (AUTH_PARAM_PATTERN.matcher(str4).matches()) {
                                i = i2;
                                group = str4;
                                str4 = null;
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append('^').append(Pattern.quote(split[0]));
                                for (int i3 = 1; i3 < i2; i3++) {
                                    sb.append(AUTHENTICATION_HEADER_VALUE_SPLIT_PATTERN_PART).append(Pattern.quote(split[i3]));
                                }
                                while (true) {
                                    i = i2 + 1;
                                    sb.append(AUTHENTICATION_HEADER_VALUE_SPLIT_PATTERN_PART).append(Pattern.quote(split[i2]));
                                    Matcher matcher = Pattern.compile(sb.toString()).matcher(str2);
                                    if (!matcher.find()) {
                                        throw new AssertionError();
                                    }
                                    Matcher matcher2 = QUOTED_STRING_AUTH_PARAM_AT_END_PATTERN.matcher(matcher.group());
                                    if (matcher2.find()) {
                                        group = matcher2.group();
                                        str4 = null;
                                        break;
                                    }
                                    i2 = i;
                                }
                            }
                            if (str4 != null) {
                                if (str3 != null) {
                                    arrayList2.add(new Challenge(str3, linkedHashMap));
                                    linkedHashMap.clear();
                                }
                                str3 = str4;
                            }
                            if (group != null) {
                                String[] split4 = AUTH_PARAM_SPLIT_PATTERN.split(group, 2);
                                String lowerCase = split4[0].toLowerCase(Locale.US);
                                String str6 = split4[1];
                                if (!TOKEN_PATTERN.matcher(str6).matches()) {
                                    str6 = QUOTED_PAIR_PATTERN.matcher(str6.substring(1, str6.length() - 1)).replaceAll("$1");
                                }
                                if (linkedHashMap.put(lowerCase, str6) != null) {
                                    break;
                                }
                            }
                            i2 = i;
                        }
                        i2++;
                        str3 = str3;
                    } else {
                        arrayList2.add(new Challenge(str3, linkedHashMap));
                        arrayList.addAll(arrayList2);
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    public static void receiveHeaders(CookieJar cookieJar, Request request, Headers headers) {
        if (cookieJar != CookieJar.NO_COOKIES) {
            List<Cookie> parseAll = Cookie.parseAll(request.url(), headers);
            if (!parseAll.isEmpty()) {
                cookieJar.saveFromResponse(request, parseAll);
            }
        }
    }

    public static boolean hasBody(Response response) {
        if (response.request().method().equals(HttpHead.METHOD_NAME)) {
            return false;
        }
        int code = response.code();
        if ((code >= 100 && code < 200) || code == 204 || code == 304) {
            return contentLength(response) != -1 || HTTP.CHUNK_CODING.equalsIgnoreCase(response.header("Transfer-Encoding"));
        }
        return true;
    }

    public static int skipUntil(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int skipWhitespace(String str, int i) {
        char charAt;
        while (i < str.length() && ((charAt = str.charAt(i)) == ' ' || charAt == '\t')) {
            i++;
        }
        return i;
    }

    public static int parseSeconds(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException e) {
            return i;
        }
    }
}
