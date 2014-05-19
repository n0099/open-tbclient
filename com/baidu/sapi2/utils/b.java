package com.baidu.sapi2.utils;

import android.text.TextUtils;
import android.util.Xml;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.TbConfig;
import java.io.ByteArrayInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class b {
    public static SapiAccountResponse a(String str) {
        SapiAccountResponse sapiAccountResponse;
        int eventType;
        SapiAccountResponse sapiAccountResponse2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        XmlPullParser newPullParser = Xml.newPullParser();
        try {
            newPullParser.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
            sapiAccountResponse = null;
        } catch (Exception e) {
            L.e(e);
            sapiAccountResponse = null;
        }
        for (eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            switch (eventType) {
                case 2:
                    String name = newPullParser.getName();
                    if (name.equalsIgnoreCase("data")) {
                        if (sapiAccountResponse == null) {
                            sapiAccountResponse2 = new SapiAccountResponse();
                            continue;
                            sapiAccountResponse = sapiAccountResponse2;
                        }
                    } else {
                        if (sapiAccountResponse == null && name.equalsIgnoreCase("error_code")) {
                            SapiAccountResponse sapiAccountResponse3 = new SapiAccountResponse();
                            sapiAccountResponse3.errorCode = Integer.parseInt(newPullParser.nextText());
                            sapiAccountResponse2 = sapiAccountResponse3;
                            continue;
                        } else if (sapiAccountResponse == null && name.equalsIgnoreCase("error_description")) {
                            SapiAccountResponse sapiAccountResponse4 = new SapiAccountResponse();
                            sapiAccountResponse4.errorMsg = newPullParser.nextText();
                            sapiAccountResponse2 = sapiAccountResponse4;
                            continue;
                        } else if (sapiAccountResponse != null) {
                            if (name.equalsIgnoreCase("errno")) {
                                sapiAccountResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                                sapiAccountResponse2 = sapiAccountResponse;
                                continue;
                            } else if (name.equalsIgnoreCase("uname")) {
                                sapiAccountResponse.username = newPullParser.nextText();
                                sapiAccountResponse2 = sapiAccountResponse;
                                continue;
                            } else if (name.equalsIgnoreCase("errmsg")) {
                                sapiAccountResponse.errorMsg = newPullParser.nextText();
                                sapiAccountResponse2 = sapiAccountResponse;
                                continue;
                            } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_BDUSS)) {
                                sapiAccountResponse.bduss = newPullParser.nextText();
                                sapiAccountResponse2 = sapiAccountResponse;
                                continue;
                            } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_PTOKEN)) {
                                sapiAccountResponse.ptoken = newPullParser.nextText();
                                sapiAccountResponse2 = sapiAccountResponse;
                                continue;
                            } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_STOKEN)) {
                                sapiAccountResponse.stoken = newPullParser.nextText();
                                sapiAccountResponse2 = sapiAccountResponse;
                                continue;
                            } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_DISPLAYNAME)) {
                                sapiAccountResponse.displayname = newPullParser.nextText();
                                sapiAccountResponse2 = sapiAccountResponse;
                                continue;
                            } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_UID)) {
                                sapiAccountResponse.uid = newPullParser.nextText();
                                sapiAccountResponse2 = sapiAccountResponse;
                                continue;
                            } else if (name.equalsIgnoreCase("authsid")) {
                                sapiAccountResponse.authSid = newPullParser.nextText();
                                sapiAccountResponse.newReg = !TextUtils.isEmpty(sapiAccountResponse.authSid);
                                sapiAccountResponse2 = sapiAccountResponse;
                                continue;
                            } else if (name.equalsIgnoreCase("account")) {
                                sapiAccountResponse.reloginCredentials.account = newPullParser.nextText();
                                sapiAccountResponse2 = sapiAccountResponse;
                                continue;
                            } else if (name.equalsIgnoreCase("accounttype")) {
                                sapiAccountResponse.reloginCredentials.accountType = newPullParser.nextText();
                                sapiAccountResponse2 = sapiAccountResponse;
                                continue;
                            } else if (name.equalsIgnoreCase("password")) {
                                sapiAccountResponse.reloginCredentials.password = newPullParser.nextText();
                                sapiAccountResponse2 = sapiAccountResponse;
                                continue;
                            } else if (name.equalsIgnoreCase("ubi")) {
                                sapiAccountResponse.reloginCredentials.ubi = newPullParser.nextText();
                                sapiAccountResponse2 = sapiAccountResponse;
                                continue;
                            }
                        }
                        sapiAccountResponse = sapiAccountResponse2;
                    }
                    L.e(e);
                    sapiAccountResponse = null;
                    return sapiAccountResponse;
                case 3:
                    sapiAccountResponse2 = sapiAccountResponse;
                    continue;
                    sapiAccountResponse = sapiAccountResponse2;
            }
            sapiAccountResponse2 = sapiAccountResponse;
            continue;
            sapiAccountResponse = sapiAccountResponse2;
        }
        return sapiAccountResponse;
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
                        if (socialResponse == null && name.equalsIgnoreCase("error_code")) {
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
                            if (name.equalsIgnoreCase("error_code")) {
                                socialResponse.errorCode = Integer.parseInt(newPullParser.nextText());
                                socialResponse2 = socialResponse;
                                continue;
                            } else if (name.equalsIgnoreCase("error_description")) {
                                socialResponse.errorMsg = newPullParser.nextText();
                                socialResponse2 = socialResponse;
                                continue;
                            } else if (name.equalsIgnoreCase("is_binded")) {
                                socialResponse.isBinded = newPullParser.nextText().equals(TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
                                socialResponse2 = socialResponse;
                                continue;
                            } else if (name.equalsIgnoreCase("display_name")) {
                                socialResponse.displayname = newPullParser.nextText();
                                socialResponse2 = socialResponse;
                                continue;
                            } else if (name.equalsIgnoreCase("passport_uname")) {
                                socialResponse.username = newPullParser.nextText();
                                socialResponse2 = socialResponse;
                                continue;
                            } else if (name.equalsIgnoreCase("bduid")) {
                                socialResponse.uid = newPullParser.nextText();
                                socialResponse2 = socialResponse;
                                continue;
                            } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_BDUSS)) {
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
        Pattern compile = Pattern.compile(str);
        if (!TextUtils.isEmpty(str2)) {
            Matcher matcher = compile.matcher(str2);
            while (matcher.find()) {
                str3 = matcher.group();
            }
        }
        return str3;
    }
}
