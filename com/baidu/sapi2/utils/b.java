package com.baidu.sapi2.utils;

import android.text.TextUtils;
import android.util.Xml;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.shell.response.FastRegResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.enums.SocialType;
import java.io.ByteArrayInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class b {
    public static FastRegResponse a(String str) {
        FastRegResponse fastRegResponse;
        int eventType;
        FastRegResponse fastRegResponse2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        XmlPullParser newPullParser = Xml.newPullParser();
        try {
            newPullParser.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
            fastRegResponse = null;
        } catch (Exception e) {
            L.e(e);
            fastRegResponse = null;
        }
        for (eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            switch (eventType) {
                case 2:
                    String name = newPullParser.getName();
                    if (name.equalsIgnoreCase("data")) {
                        if (fastRegResponse == null) {
                            fastRegResponse2 = new FastRegResponse();
                            continue;
                            fastRegResponse = fastRegResponse2;
                        }
                    } else {
                        if (fastRegResponse == null && name.equalsIgnoreCase(SocialConstants.PARAM_ERROR_CODE)) {
                            FastRegResponse fastRegResponse3 = new FastRegResponse();
                            fastRegResponse3.errorCode = Integer.parseInt(newPullParser.nextText());
                            fastRegResponse2 = fastRegResponse3;
                            continue;
                        } else if (fastRegResponse == null && name.equalsIgnoreCase("error_description")) {
                            FastRegResponse fastRegResponse4 = new FastRegResponse();
                            fastRegResponse4.errorMsg = newPullParser.nextText();
                            fastRegResponse2 = fastRegResponse4;
                            continue;
                        } else if (fastRegResponse != null) {
                            if (name.equalsIgnoreCase("errno")) {
                                fastRegResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                                fastRegResponse2 = fastRegResponse;
                                continue;
                            } else if (name.equalsIgnoreCase("uname")) {
                                fastRegResponse.username = newPullParser.nextText();
                                fastRegResponse2 = fastRegResponse;
                                continue;
                            } else if (name.equalsIgnoreCase("errmsg")) {
                                fastRegResponse.errorMsg = newPullParser.nextText();
                                fastRegResponse2 = fastRegResponse;
                                continue;
                            } else if (name.equalsIgnoreCase("bduss")) {
                                fastRegResponse.bduss = newPullParser.nextText();
                                fastRegResponse2 = fastRegResponse;
                                continue;
                            } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_PTOKEN)) {
                                fastRegResponse.ptoken = newPullParser.nextText();
                                fastRegResponse2 = fastRegResponse;
                                continue;
                            } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_STOKEN)) {
                                fastRegResponse.stoken = newPullParser.nextText();
                                fastRegResponse2 = fastRegResponse;
                                continue;
                            } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_DISPLAYNAME)) {
                                fastRegResponse.displayname = newPullParser.nextText();
                                fastRegResponse2 = fastRegResponse;
                                continue;
                            } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_UID)) {
                                fastRegResponse.uid = newPullParser.nextText();
                                fastRegResponse2 = fastRegResponse;
                                continue;
                            } else if (name.equalsIgnoreCase("portrait")) {
                                fastRegResponse.portrait = newPullParser.nextText();
                                fastRegResponse2 = fastRegResponse;
                                continue;
                            } else if (name.equalsIgnoreCase("authsid")) {
                                fastRegResponse.authSid = newPullParser.nextText();
                                fastRegResponse.newReg = !TextUtils.isEmpty(fastRegResponse.authSid);
                                fastRegResponse2 = fastRegResponse;
                                continue;
                            }
                        }
                        fastRegResponse = fastRegResponse2;
                    }
                    L.e(e);
                    fastRegResponse = null;
                    return fastRegResponse;
                case 3:
                    fastRegResponse2 = fastRegResponse;
                    continue;
                    fastRegResponse = fastRegResponse2;
            }
            fastRegResponse2 = fastRegResponse;
            continue;
            fastRegResponse = fastRegResponse2;
        }
        return fastRegResponse;
    }

    public static SocialResponse b(String str) {
        SocialResponse socialResponse;
        int eventType;
        SocialResponse socialResponse2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        XmlPullParser newPullParser = Xml.newPullParser();
        try {
            newPullParser.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
            socialResponse = null;
        } catch (Exception e) {
            L.e(e);
            socialResponse = null;
        }
        for (eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            switch (eventType) {
                case 2:
                    String name = newPullParser.getName();
                    if (name.equalsIgnoreCase("data")) {
                        if (socialResponse == null) {
                            socialResponse2 = new SocialResponse();
                            continue;
                            socialResponse = socialResponse2;
                        }
                    } else {
                        if (socialResponse == null && name.equalsIgnoreCase(SocialConstants.PARAM_ERROR_CODE)) {
                            SocialResponse socialResponse3 = new SocialResponse();
                            socialResponse3.errorCode = Integer.parseInt(newPullParser.nextText());
                            socialResponse2 = socialResponse3;
                            continue;
                        } else if (socialResponse == null && name.equalsIgnoreCase("error_description")) {
                            SocialResponse socialResponse4 = new SocialResponse();
                            socialResponse4.errorMsg = newPullParser.nextText();
                            socialResponse2 = socialResponse4;
                            continue;
                        } else if (socialResponse != null) {
                            if (name.equalsIgnoreCase(SocialConstants.PARAM_ERROR_CODE)) {
                                socialResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                                socialResponse2 = socialResponse;
                                continue;
                            } else if (name.equalsIgnoreCase("error_description")) {
                                socialResponse.errorMsg = newPullParser.nextText();
                                socialResponse2 = socialResponse;
                                continue;
                            } else if (name.equalsIgnoreCase("is_binded")) {
                                socialResponse.isBinded = newPullParser.nextText().equals(SocialConstants.TRUE);
                                socialResponse2 = socialResponse;
                                continue;
                            } else if (name.equalsIgnoreCase("display_name")) {
                                socialResponse.displayname = newPullParser.nextText();
                                socialResponse2 = socialResponse;
                                continue;
                            } else if (name.equalsIgnoreCase("passport_uname")) {
                                socialResponse.baiduUname = newPullParser.nextText();
                                socialResponse2 = socialResponse;
                                continue;
                            } else if (name.equalsIgnoreCase("bduid")) {
                                socialResponse.uid = newPullParser.nextText();
                                socialResponse2 = socialResponse;
                                continue;
                            } else if (name.equalsIgnoreCase("bduss")) {
                                socialResponse.bduss = newPullParser.nextText();
                                socialResponse2 = socialResponse;
                                continue;
                            } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_PTOKEN)) {
                                socialResponse.ptoken = newPullParser.nextText();
                                socialResponse2 = socialResponse;
                                continue;
                            } else if (name.equalsIgnoreCase("os_username")) {
                                socialResponse.socialUname = newPullParser.nextText();
                                socialResponse2 = socialResponse;
                                continue;
                            } else if (name.equalsIgnoreCase("os_headurl")) {
                                socialResponse.socialPortraitUrl = newPullParser.nextText();
                                socialResponse2 = socialResponse;
                                continue;
                            } else if (name.equalsIgnoreCase("os_type")) {
                                socialResponse.socialType = SocialType.getSocialType(Integer.parseInt(newPullParser.nextText()));
                                socialResponse2 = socialResponse;
                                continue;
                            }
                        }
                        socialResponse = socialResponse2;
                    }
                    L.e(e);
                    socialResponse = null;
                    return socialResponse;
                case 3:
                    socialResponse2 = socialResponse;
                    continue;
                    socialResponse = socialResponse2;
            }
            socialResponse2 = socialResponse;
            continue;
            socialResponse = socialResponse2;
        }
        return socialResponse;
    }

    public static String a(String str, String str2) {
        String str3 = "";
        Matcher matcher = Pattern.compile(str).matcher(str2);
        while (matcher.find()) {
            str3 = matcher.group();
        }
        return str3;
    }
}
