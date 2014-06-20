package com.baidu.android.a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Xml;
import com.baidu.android.systemmonitor.localapp.AppManager;
import com.baidu.tbadk.TbConfig;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class a {
    private com.baidu.android.nebula.a.a a;
    private ArrayList b;
    private Context c;
    private ArrayList d = new ArrayList();

    public a(Context context) {
        this.c = context;
        this.a = new com.baidu.android.nebula.a.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InputStream a(HttpEntity httpEntity) {
        Header contentEncoding = httpEntity.getContentEncoding();
        if (contentEncoding == null || contentEncoding.getValue().toLowerCase().indexOf("gzip") == -1) {
            return null;
        }
        return new GZIPInputStream(httpEntity.getContent());
    }

    public static String a(String str, String str2, Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()).getString(str, str2);
    }

    private void a(Context context) {
        com.baidu.android.moplus.util.d.a(context).b();
        com.baidu.android.nebula.d.b.b();
        Intent c = com.baidu.android.moplus.util.a.c(context);
        c.putExtra("type", "service_sing_restart");
        c.putExtra("restartflag", true);
        c.setPackage(com.baidu.android.moplus.util.a.d(context));
        context.sendBroadcast(c);
    }

    private void a(d dVar, XmlPullParser xmlPullParser, String str) {
        e eVar;
        dVar.a(xmlPullParser.getAttributeValue(null, "version"));
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            switch (eventType) {
                case 2:
                    if (!xmlPullParser.getName().equalsIgnoreCase("data")) {
                        break;
                    } else {
                        if (TextUtils.equals(str, "set_urls")) {
                            eVar = new q();
                            a(eVar, xmlPullParser);
                        } else if (TextUtils.equals(str, "set_settings")) {
                            eVar = new j();
                            b(eVar, xmlPullParser);
                        } else if (TextUtils.equals(str, "appmonitor")) {
                            eVar = new p();
                            b(eVar, xmlPullParser);
                        } else if (TextUtils.equals(str, "safeconfig")) {
                            a(xmlPullParser);
                            eVar = null;
                        } else if (TextUtils.equals(str, "appblacklist")) {
                            eVar = new c();
                            b(eVar, xmlPullParser);
                        } else if (TextUtils.equals(str, "portlist")) {
                            eVar = new f();
                            b(eVar, xmlPullParser);
                        } else if (TextUtils.equals(str, "aeskey")) {
                            eVar = new u();
                            b(eVar, xmlPullParser);
                        } else {
                            eVar = null;
                        }
                        dVar.b().add(eVar);
                        break;
                    }
                case 3:
                    if (!xmlPullParser.getName().equalsIgnoreCase("data_set")) {
                        break;
                    } else {
                        return;
                    }
            }
            eventType = xmlPullParser.next();
        }
    }

    private void a(e eVar, XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        if (TextUtils.isEmpty(attributeValue)) {
            return;
        }
        eVar.a(attributeValue);
        eVar.b(com.baidu.android.systemmonitor.util.b.a(xmlPullParser.nextText()));
    }

    private void a(k kVar, XmlPullParser xmlPullParser) {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            switch (eventType) {
                case 2:
                    String name = xmlPullParser.getName();
                    if (!name.equalsIgnoreCase("action")) {
                        if (!name.equalsIgnoreCase("data_set")) {
                            break;
                        } else {
                            d dVar = new d();
                            kVar.a(dVar);
                            a(dVar, xmlPullParser, kVar.a());
                            break;
                        }
                    } else {
                        kVar.a(xmlPullParser.nextText());
                        break;
                    }
                case 3:
                    if (!xmlPullParser.getName().equalsIgnoreCase("do")) {
                        break;
                    } else {
                        return;
                    }
            }
            eventType = xmlPullParser.next();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(InputStream inputStream) {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, "UTF-8");
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            switch (eventType) {
                case 0:
                    this.b = new ArrayList();
                    break;
                case 2:
                    if (newPullParser.getName().equalsIgnoreCase("do")) {
                        k kVar = new k();
                        a(kVar, newPullParser);
                        this.b.add(kVar);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (newPullParser.getName().equalsIgnoreCase("appcommand")) {
                    }
                    break;
            }
        }
        inputStream.close();
    }

    private void a(String str, String str2) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.c.getApplicationContext()).edit();
        edit.putString(str, str2);
        edit.commit();
    }

    private void a(XmlPullParser xmlPullParser) {
        m mVar = new m();
        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "description");
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "url");
        String attributeValue4 = xmlPullParser.getAttributeValue(null, "versioncode");
        String attributeValue5 = xmlPullParser.getAttributeValue(null, "title");
        if (TextUtils.isEmpty(attributeValue)) {
            return;
        }
        String nextText = xmlPullParser.nextText();
        mVar.c(attributeValue5);
        mVar.a(attributeValue);
        mVar.b(nextText);
        mVar.d(attributeValue2);
        mVar.e(attributeValue3);
        mVar.f(attributeValue4);
        this.d.add(mVar);
    }

    private boolean a(m mVar) {
        if (mVar == null || TextUtils.isEmpty(mVar.a())) {
            return false;
        }
        com.baidu.android.systemmonitor.localapp.a aVar = (com.baidu.android.systemmonitor.localapp.a) AppManager.a(this.c).a().get(mVar.a());
        if (aVar == null || (mVar.g() != 0 && aVar.f != mVar.g())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UrlEncodedFormEntity b() {
        ArrayList arrayList = new ArrayList();
        String str = Build.VERSION.SDK_INT + "_0";
        String a = a("urls_dataset_version", str, this.c);
        if (!a.startsWith(String.valueOf(Build.VERSION.SDK_INT))) {
            a("urls_dataset_version", str);
            a = str;
        }
        String a2 = a("settings_dataset_version", str, this.c);
        if (!a2.startsWith(String.valueOf(Build.VERSION.SDK_INT))) {
            a("settings_dataset_version", str);
            a2 = str;
        }
        String a3 = a("appmonitor_dataset_version", str, this.c);
        if (!a3.startsWith(String.valueOf(Build.VERSION.SDK_INT))) {
            a("appmonitor_dataset_version", str);
            a3 = str;
        }
        String a4 = a("blacklist_dataset_version", str, this.c);
        if (!a4.startsWith(String.valueOf(Build.VERSION.SDK_INT))) {
            a("blacklist_dataset_version", str);
            a4 = str;
        }
        String a5 = a("port_dataset_version", str, this.c);
        if (!a5.startsWith(String.valueOf(Build.VERSION.SDK_INT))) {
            a("port_dataset_version", str);
            a5 = str;
        }
        String a6 = a("port_dataset_version", str, this.c);
        if (a6.startsWith(String.valueOf(Build.VERSION.SDK_INT))) {
            str = a6;
        } else {
            a("aeskey_dataset_version", str);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("set_urls_version", a);
            jSONObject.put("set_settings_version", a2);
            jSONObject.put("set_appmonitor_version", a3);
            jSONObject.put("set_blacklist_version", a4);
            jSONObject.put("set_portlist_version", a5);
            jSONObject.put("aeskey_dataset_version", str);
            try {
                PackageInfo packageInfo = this.c.getPackageManager().getPackageInfo(this.c.getPackageName(), 0);
                jSONObject.put("app_version_name", packageInfo.versionName);
                jSONObject.put("app_version_code", packageInfo.versionCode);
            } catch (PackageManager.NameNotFoundException e) {
            }
            jSONObject.put("sdk_version_name", "v2.0");
            jSONObject.put("app_packagename", this.c.getPackageName());
        } catch (JSONException e2) {
        }
        arrayList.add(new BasicNameValuePair("version", jSONObject.toString()));
        try {
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(arrayList, "utf-8");
            try {
                urlEncodedFormEntity.setContentType("application/x-www-form-urlencoded");
                return urlEncodedFormEntity;
            } catch (UnsupportedEncodingException e3) {
                return urlEncodedFormEntity;
            }
        } catch (UnsupportedEncodingException e4) {
            return null;
        }
    }

    private void b(e eVar, XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        if (TextUtils.isEmpty(attributeValue)) {
            return;
        }
        eVar.a(attributeValue);
        eVar.b(xmlPullParser.nextText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            String a = kVar.a();
            if (TextUtils.equals(a, "set_urls")) {
                if (h.a(this.c).a(kVar.b().b(), 0)) {
                    a("urls_dataset_version", kVar.b().a());
                }
            } else if (TextUtils.equals(a, "set_settings")) {
                if (h.a(this.c).a(kVar.b().b(), 1)) {
                    a("settings_dataset_version", kVar.b().a());
                }
            } else if (TextUtils.equals(a, "appmonitor")) {
                if (h.a(this.c).a(kVar.b().b(), 2)) {
                    a("appmonitor_dataset_version", kVar.b().a());
                }
            } else if (TextUtils.equals(a, "safeconfig")) {
                if (this.d != null && this.d.size() > 0) {
                    s.a(this.c).l();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = new ArrayList();
                    Iterator it2 = this.d.iterator();
                    while (it2.hasNext()) {
                        m mVar = (m) it2.next();
                        if (TextUtils.equals(mVar.b(), "0")) {
                            arrayList.add(mVar);
                        }
                        if (TextUtils.equals(mVar.b(), TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK)) {
                            arrayList2.add(mVar);
                        }
                        if (TextUtils.equals(mVar.b(), TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT)) {
                            arrayList3.add(mVar);
                        }
                        if (TextUtils.equals(mVar.b(), TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                            arrayList4.add(mVar);
                        }
                        if (TextUtils.equals(mVar.b(), "4")) {
                            arrayList5.add(mVar);
                        }
                    }
                    if (arrayList.size() > 0) {
                        Iterator it3 = arrayList.iterator();
                        while (it3.hasNext()) {
                            m mVar2 = (m) it3.next();
                            if (a(mVar2)) {
                                com.baidu.android.defense.pkgmanager.d.a(this.c).a(this.c, mVar2.a());
                            }
                        }
                    }
                    if (arrayList2.size() > 0) {
                        Iterator it4 = arrayList2.iterator();
                        while (it4.hasNext()) {
                            m mVar3 = (m) it4.next();
                            if (a(mVar3)) {
                                com.baidu.android.defense.pkgmanager.d.a(this.c).a(false, mVar3.a());
                            }
                        }
                    }
                    if (arrayList3.size() > 0) {
                        Iterator it5 = arrayList3.iterator();
                        while (it5.hasNext()) {
                            m mVar4 = (m) it5.next();
                            if (a(mVar4)) {
                                com.baidu.android.defense.pkgmanager.d.a(this.c).a(true, mVar4.a());
                            }
                        }
                    }
                    if (arrayList4.size() > 0) {
                        new com.baidu.android.defense.push.d().a(this.c, arrayList4);
                    }
                    if (arrayList5.size() > 0) {
                        new com.baidu.android.defense.push.k().a(this.c, arrayList5);
                    }
                }
            } else if (TextUtils.equals(a, "appblacklist")) {
                if (h.a(this.c).a(kVar.b().b(), 4)) {
                    a("blacklist_dataset_version", kVar.b().a());
                }
                l.b();
                l.a(this.c);
            } else if (TextUtils.equals(a, "aeskey")) {
                if (h.a(this.c).a(kVar.b().b(), 6)) {
                    a("aeskey_dataset_version", kVar.b().a());
                }
                o.b();
                o.a(this.c);
            } else if (TextUtils.equals(a, "portlist")) {
                ArrayList b = kVar.b().b();
                if (h.a(this.c).a(b, 5)) {
                    a("port_dataset_version", kVar.b().a());
                }
                if (b.size() > 0) {
                    a(this.c);
                } else {
                    b.b();
                    b.a(this.c);
                }
            }
        }
    }

    public void a() {
        String str = t.b;
        if (!TextUtils.isEmpty(com.baidu.android.systemmonitor.util.a.j())) {
            str = com.baidu.android.systemmonitor.util.a.j();
        }
        new v(this, com.baidu.android.nebula.a.d.a(this.c).a(str, false)).start();
        com.baidu.android.moplus.util.a.l(this.c);
    }
}
