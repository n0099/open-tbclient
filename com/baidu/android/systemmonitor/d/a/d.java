package com.baidu.android.systemmonitor.d.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Xml;
import com.baidu.android.common.net.ProxyHttpClient;
import com.baidu.browser.core.util.BdUtil;
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
public class d {

    /* renamed from: a  reason: collision with root package name */
    private ProxyHttpClient f664a;
    private ArrayList b;
    private Context c;

    public d(Context context) {
        this.c = context;
        this.f664a = new ProxyHttpClient(context);
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

    private void a(b bVar, XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        if (TextUtils.isEmpty(attributeValue)) {
            return;
        }
        bVar.a(attributeValue);
        bVar.b(com.baidu.android.systemmonitor.d.c.a(xmlPullParser.nextText()));
    }

    private void a(e eVar, XmlPullParser xmlPullParser) {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            switch (eventType) {
                case 2:
                    String name = xmlPullParser.getName();
                    if (!name.equalsIgnoreCase("action")) {
                        if (!name.equalsIgnoreCase("data_set")) {
                            break;
                        } else {
                            f fVar = new f();
                            eVar.a(fVar);
                            a(fVar, xmlPullParser, eVar.a());
                            break;
                        }
                    } else {
                        eVar.a(xmlPullParser.nextText());
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

    private void a(f fVar, XmlPullParser xmlPullParser, String str) {
        b bVar;
        fVar.a(xmlPullParser.getAttributeValue(null, "version"));
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            switch (eventType) {
                case 2:
                    if (!xmlPullParser.getName().equalsIgnoreCase("data")) {
                        break;
                    } else {
                        if (TextUtils.equals(str, "set_urls")) {
                            bVar = new o();
                            a(bVar, xmlPullParser);
                        } else if (TextUtils.equals(str, "set_settings")) {
                            bVar = new n();
                            b(bVar, xmlPullParser);
                        } else if (TextUtils.equals(str, "appmonitor")) {
                            bVar = new a();
                            b(bVar, xmlPullParser);
                        } else {
                            bVar = null;
                        }
                        fVar.b().add(bVar);
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
                        e eVar = new e();
                        a(eVar, newPullParser);
                        this.b.add(eVar);
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

    /* JADX INFO: Access modifiers changed from: private */
    public UrlEncodedFormEntity b() {
        ArrayList arrayList = new ArrayList();
        String str = Build.VERSION.SDK_INT + "_0";
        if (com.baidu.android.systemmonitor.d.d.k() > 0) {
            str = com.baidu.android.systemmonitor.d.d.k() + "_0";
        }
        String a2 = a("urls_dataset_version", str, this.c);
        if (!TextUtils.isEmpty(com.baidu.android.systemmonitor.d.d.l())) {
            a2 = com.baidu.android.systemmonitor.d.d.l();
        }
        if (!a2.startsWith(String.valueOf(Build.VERSION.SDK_INT))) {
            a("urls_dataset_version", str);
            a2 = str;
        }
        String a3 = a("settings_dataset_version", str, this.c);
        if (!TextUtils.isEmpty(com.baidu.android.systemmonitor.d.d.m())) {
            a3 = com.baidu.android.systemmonitor.d.d.m();
        }
        if (!a3.startsWith(String.valueOf(Build.VERSION.SDK_INT))) {
            a("settings_dataset_version", str);
            a3 = str;
        }
        String a4 = a("appmonitor_dataset_version", str, this.c);
        if (a4.startsWith(String.valueOf(Build.VERSION.SDK_INT))) {
            str = a4;
        } else {
            a("appmonitor_dataset_version", str);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("set_urls_version", a2);
            jSONObject.put("set_settings_version", a3);
            jSONObject.put("set_appmonitor_version", str);
            try {
                jSONObject.put("app_version_name", this.c.getPackageManager().getPackageInfo(this.c.getPackageName(), 0).versionName);
            } catch (PackageManager.NameNotFoundException e) {
            }
            jSONObject.put("sdk_version_name", "v2.0");
        } catch (JSONException e2) {
        }
        arrayList.add(new BasicNameValuePair("version", jSONObject.toString()));
        try {
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(arrayList, BdUtil.UTF8);
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

    private void b(b bVar, XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        if (TextUtils.isEmpty(attributeValue)) {
            return;
        }
        bVar.a(attributeValue);
        bVar.b(xmlPullParser.nextText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            String a2 = eVar.a();
            if (TextUtils.equals(a2, "set_urls")) {
                if (i.a(this.c).a(eVar.b().b(), 0)) {
                    a("urls_dataset_version", eVar.b().a());
                }
            } else if (TextUtils.equals(a2, "set_settings")) {
                if (i.a(this.c).a(eVar.b().b(), 1)) {
                    a("settings_dataset_version", eVar.b().a());
                }
            } else if (TextUtils.equals(a2, "appmonitor") && i.a(this.c).a(eVar.b().b(), 2)) {
                a("appmonitor_dataset_version", eVar.b().a());
            }
        }
    }

    public void a() {
        String str = m.b;
        if (!TextUtils.isEmpty(com.baidu.android.systemmonitor.d.d.g())) {
            str = com.baidu.android.systemmonitor.d.d.g();
        }
        new g(this, com.baidu.android.nebula.util.e.a(this.c).a(str, false)).start();
    }
}
