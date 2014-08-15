package com.baidu.sapi2.share;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.SocialType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
class c {
    static final String a = "baidu.intent.action.SHARE";
    static final String b = "baidu.intent.action.NEWSHARE";
    static final String c = "baidu.share.action.ACTION_LOGIN";
    static final String d = "baidu.share.action.ACTION_LOGOUT";
    static final String e = "baidu.share.action.ACTION_LOGIN_SYNC";
    static final String f = "baidu.share.action.ACTION_LOGIN_SYNC_REPLY";
    static final String g = "action";
    static final String h = "from";
    static final String i = "data";
    static final String j = "timestamp";
    static final String k = "receiver";
    static final String l = "username";
    static final String m = "displayname";
    static final String n = "email";
    static final String o = "phoneNumber";
    static final String p = "bduss";
    static final String q = "ptoken";
    static final String r = "device_token";
    static final String s = "json";
    static final String t = "socialAccounts";
    static final String u = ";";

    c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {
        String a;
        String b;
        long c;
        Map<String, String> d = new HashMap();

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, Intent intent, LoginShareStrategy loginShareStrategy, e eVar) {
        boolean z = false;
        Bundle extras = intent.getExtras();
        if (extras != null && loginShareStrategy != LoginShareStrategy.DISABLED) {
            String string = extras.getString(g);
            if (!TextUtils.isEmpty(string)) {
                String b2 = com.baidu.sapi2.share.a.b(context, string);
                String string2 = extras.getString("from");
                if (!TextUtils.isEmpty(string2)) {
                    String packageName = context.getPackageName();
                    String b3 = com.baidu.sapi2.share.a.b(context, string2);
                    if (!TextUtils.isEmpty(b3)) {
                        if (TextUtils.isEmpty(packageName) || !packageName.equals(b3)) {
                            String string3 = extras.getString(k);
                            if (string3 != null) {
                                String b4 = com.baidu.sapi2.share.a.b(context, string3);
                                if (!TextUtils.isEmpty(b4)) {
                                    String[] split = b4.split(u);
                                    int length = split.length;
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 >= length) {
                                            break;
                                        } else if (!packageName.equals(split[i2])) {
                                            i2++;
                                        } else {
                                            z = true;
                                            break;
                                        }
                                    }
                                    if (!z) {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            String string4 = extras.getString(j);
                            if (!TextUtils.isEmpty(string4)) {
                                try {
                                    long parseLong = Long.parseLong(com.baidu.sapi2.share.a.b(context, string4));
                                    String string5 = extras.getString(i);
                                    HashMap hashMap = new HashMap();
                                    if (!TextUtils.isEmpty(string5)) {
                                        try {
                                            JSONObject jSONObject = new JSONObject(com.baidu.sapi2.share.a.b(context, string5));
                                            Iterator<String> keys = jSONObject.keys();
                                            while (keys.hasNext()) {
                                                String next = keys.next();
                                                hashMap.put(next, jSONObject.optString(next));
                                            }
                                        } catch (Throwable th) {
                                            th.printStackTrace();
                                        }
                                    }
                                    a aVar = new a();
                                    aVar.a = b2;
                                    aVar.b = b3;
                                    aVar.c = parseLong;
                                    aVar.d = hashMap;
                                    ShareModel a2 = a(context, aVar);
                                    if (eVar != null && a2 != null) {
                                        eVar.a(a2);
                                    }
                                } catch (Exception e2) {
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static ShareModel a(Context context, a aVar) {
        if (context == null || aVar == null || TextUtils.isEmpty(aVar.a)) {
            return null;
        }
        ShareModel shareModel = new ShareModel();
        if (c.equals(aVar.a)) {
            shareModel.a(ShareEvent.VALIDATE);
        }
        if (d.equals(aVar.a)) {
            shareModel.a(ShareEvent.INVALIDATE);
        }
        if (e.equals(aVar.a)) {
            shareModel.a(ShareEvent.SYNC_REQ);
        }
        if (f.equals(aVar.a)) {
            shareModel.a(ShareEvent.SYNC_ACK);
        }
        SapiAccount b2 = b(context, aVar);
        if (b2 != null) {
            shareModel.a(LoginShareStrategy.SILENT);
            SapiAccount a2 = com.baidu.sapi2.share.a.a(context, b2);
            shareModel.a(a2);
            shareModel.a(Arrays.asList(a2));
            return shareModel;
        }
        return null;
    }

    static SapiAccount b(Context context, a aVar) {
        if (context == null || aVar == null) {
            return null;
        }
        Map<String, String> map = aVar.d;
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.app = SapiUtils.getAppName(context, aVar.b);
        for (String str : map.keySet()) {
            if (l.equals(str)) {
                if (a(map.get(str))) {
                    sapiAccount.username = com.baidu.sapi2.share.a.b(context, map.get(str));
                }
            } else if (n.equals(str)) {
                if (a(map.get(str))) {
                    sapiAccount.email = com.baidu.sapi2.share.a.b(context, map.get(str));
                }
            } else if (o.equals(str)) {
                if (a(map.get(str))) {
                    sapiAccount.phone = com.baidu.sapi2.share.a.b(context, map.get(str));
                }
            } else if ("bduss".equals(str)) {
                if (a(map.get(str))) {
                    sapiAccount.bduss = com.baidu.sapi2.share.a.b(context, map.get(str));
                }
            } else if ("ptoken".equals(str)) {
                if (a(map.get(str))) {
                    sapiAccount.ptoken = com.baidu.sapi2.share.a.b(context, map.get(str));
                }
            } else if ("displayname".equals(str)) {
                if (a(map.get(str))) {
                    sapiAccount.displayname = com.baidu.sapi2.share.a.b(context, map.get(str));
                }
            } else if (s.equals(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(com.baidu.sapi2.share.a.b(context, map.get(str)));
                    String optString = jSONObject.optString(SapiAccountManager.SESSION_UID);
                    if (!TextUtils.isEmpty(optString)) {
                        sapiAccount.uid = optString;
                    }
                    String optString2 = jSONObject.optString("bduss");
                    if (!TextUtils.isEmpty(optString2)) {
                        sapiAccount.bduss = optString2;
                    }
                    String optString3 = jSONObject.optString("ptoken");
                    if (!TextUtils.isEmpty(optString3)) {
                        sapiAccount.ptoken = optString3;
                    }
                    String optString4 = jSONObject.optString(SapiAccountManager.SESSION_STOKEN);
                    if (!TextUtils.isEmpty(optString4)) {
                        sapiAccount.stoken = optString4;
                    }
                    String optString5 = jSONObject.optString("uname");
                    if (!TextUtils.isEmpty(optString5)) {
                        sapiAccount.username = optString5;
                    }
                    String optString6 = jSONObject.optString("displayname");
                    if (!TextUtils.isEmpty(optString6)) {
                        sapiAccount.displayname = optString6;
                    }
                } catch (Exception e2) {
                    L.e(e2);
                }
            }
        }
        if (SapiUtils.isValidAccount(sapiAccount)) {
            return sapiAccount;
        }
        return null;
    }

    static boolean a(String str) {
        return (TextUtils.isEmpty(str) || str.equals("null")) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SapiAccount a(Context context) {
        d dVar = new d(context);
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.displayname = dVar.a("displayname");
        sapiAccount.username = dVar.a(l);
        sapiAccount.email = dVar.a(n);
        sapiAccount.phone = dVar.a(o);
        sapiAccount.bduss = dVar.a("bduss");
        sapiAccount.ptoken = dVar.a("ptoken");
        sapiAccount.extra = dVar.a(s);
        a(sapiAccount, dVar.a(t));
        if (!TextUtils.isEmpty(sapiAccount.extra)) {
            try {
                JSONObject jSONObject = new JSONObject(sapiAccount.extra);
                String optString = jSONObject.optString(SapiAccountManager.SESSION_UID);
                if (!TextUtils.isEmpty(optString)) {
                    sapiAccount.uid = optString;
                }
                String optString2 = jSONObject.optString("bduss");
                if (!TextUtils.isEmpty(optString2)) {
                    sapiAccount.bduss = optString2;
                }
                if (!TextUtils.isEmpty(jSONObject.optString("ptoken"))) {
                    sapiAccount.ptoken = jSONObject.optString("ptoken");
                }
                if (!TextUtils.isEmpty(jSONObject.optString(SapiAccountManager.SESSION_STOKEN))) {
                    sapiAccount.stoken = jSONObject.optString(SapiAccountManager.SESSION_STOKEN);
                }
                String optString3 = jSONObject.optString("uname");
                if (!TextUtils.isEmpty(optString3)) {
                    sapiAccount.username = optString3;
                }
                String optString4 = jSONObject.optString("displayname");
                if (!TextUtils.isEmpty(optString4)) {
                    sapiAccount.displayname = optString4;
                }
            } catch (JSONException e2) {
                L.e(e2);
            }
        }
        if (SapiUtils.isValidAccount(sapiAccount)) {
            return sapiAccount;
        }
        return null;
    }

    static void a(SapiAccount sapiAccount, String str) {
        if (sapiAccount != null && !TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() != 0) {
                    try {
                        JSONObject jSONObject = jSONArray.getJSONObject(0);
                        com.baidu.sapi2.utils.a.a(sapiAccount, SocialType.getSocialType(jSONObject.optInt("type")), jSONObject.optString("headURL"));
                    } catch (JSONException e2) {
                        L.e(e2);
                    }
                }
            } catch (JSONException e3) {
            }
        }
    }
}
