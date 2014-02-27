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
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        XmlPullParser newPullParser = Xml.newPullParser();
        try {
            newPullParser.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
            fastRegResponse = null;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                switch (eventType) {
                    case 2:
                        String name = newPullParser.getName();
                        if (name.equalsIgnoreCase("data")) {
                            if (fastRegResponse == null) {
                                fastRegResponse = new FastRegResponse();
                                continue;
                            } else {
                                continue;
                            }
                        } else if (fastRegResponse == null && name.equalsIgnoreCase(SocialConstants.PARAM_ERROR_CODE)) {
                            fastRegResponse = new FastRegResponse();
                            fastRegResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                            continue;
                        } else if (fastRegResponse == null && name.equalsIgnoreCase("error_description")) {
                            fastRegResponse = new FastRegResponse();
                            fastRegResponse.errorMsg = newPullParser.nextText();
                            continue;
                        } else if (fastRegResponse == null) {
                            continue;
                        } else if (name.equalsIgnoreCase("errno")) {
                            fastRegResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                            continue;
                        } else if (name.equalsIgnoreCase("uname")) {
                            fastRegResponse.username = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("errmsg")) {
                            fastRegResponse.errorMsg = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("bduss")) {
                            fastRegResponse.bduss = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_PTOKEN)) {
                            fastRegResponse.ptoken = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_STOKEN)) {
                            fastRegResponse.stoken = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_DISPLAYNAME)) {
                            fastRegResponse.displayname = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_UID)) {
                            fastRegResponse.uid = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("portrait")) {
                            fastRegResponse.portrait = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("authsid")) {
                            fastRegResponse.authSid = newPullParser.nextText();
                            fastRegResponse.newReg = !TextUtils.isEmpty(fastRegResponse.authSid);
                            continue;
                        } else {
                            continue;
                        }
                }
            }
        } catch (Exception e) {
            L.e(e);
            fastRegResponse = null;
        }
        return fastRegResponse;
    }

    public static SocialResponse b(String str) {
        SocialResponse socialResponse;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        XmlPullParser newPullParser = Xml.newPullParser();
        try {
            newPullParser.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
            socialResponse = null;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                switch (eventType) {
                    case 2:
                        String name = newPullParser.getName();
                        if (name.equalsIgnoreCase("data")) {
                            if (socialResponse == null) {
                                socialResponse = new SocialResponse();
                                continue;
                            } else {
                                continue;
                            }
                        } else if (socialResponse == null && name.equalsIgnoreCase(SocialConstants.PARAM_ERROR_CODE)) {
                            socialResponse = new SocialResponse();
                            socialResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                            continue;
                        } else if (socialResponse == null && name.equalsIgnoreCase("error_description")) {
                            socialResponse = new SocialResponse();
                            socialResponse.errorMsg = newPullParser.nextText();
                            continue;
                        } else if (socialResponse == null) {
                            continue;
                        } else if (name.equalsIgnoreCase(SocialConstants.PARAM_ERROR_CODE)) {
                            socialResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                            continue;
                        } else if (name.equalsIgnoreCase("error_description")) {
                            socialResponse.errorMsg = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("is_binded")) {
                            socialResponse.isBinded = newPullParser.nextText().equals(SocialConstants.TRUE);
                            continue;
                        } else if (name.equalsIgnoreCase("display_name")) {
                            socialResponse.displayname = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("passport_uname")) {
                            socialResponse.username = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("bduid")) {
                            socialResponse.uid = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("bduss")) {
                            socialResponse.bduss = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_PTOKEN)) {
                            socialResponse.ptoken = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("os_username")) {
                            socialResponse.socialUname = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("os_headurl")) {
                            socialResponse.socialPortraitUrl = newPullParser.nextText();
                            continue;
                        } else if (name.equalsIgnoreCase("os_type")) {
                            socialResponse.socialType = SocialType.getSocialType(Integer.parseInt(newPullParser.nextText()));
                            continue;
                        } else {
                            continue;
                        }
                }
            }
        } catch (Exception e) {
            L.e(e);
            socialResponse = null;
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
