package com.baidu.android.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Xml;
import com.baidu.android.common.net.ProxyHttpClient;
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
public class e {
    private ProxyHttpClient a;
    private ArrayList b;
    private Context c;

    public e(Context context) {
        this.c = context;
        this.a = new ProxyHttpClient(context);
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

    private void a(c cVar, XmlPullParser xmlPullParser) {
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
                            cVar.a(fVar);
                            a(fVar, xmlPullParser, cVar.a());
                            break;
                        }
                    } else {
                        cVar.a(xmlPullParser.nextText());
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
        k kVar;
        fVar.a(xmlPullParser.getAttributeValue(null, "version"));
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            switch (eventType) {
                case 2:
                    if (!xmlPullParser.getName().equalsIgnoreCase("data")) {
                        break;
                    } else {
                        if (TextUtils.equals(str, "set_urls")) {
                            kVar = new h();
                            a(kVar, xmlPullParser);
                        } else if (TextUtils.equals(str, "set_settings")) {
                            kVar = new b();
                            b(kVar, xmlPullParser);
                        } else if (TextUtils.equals(str, "appmonitor")) {
                            kVar = new g();
                            b(kVar, xmlPullParser);
                        } else {
                            kVar = null;
                        }
                        fVar.b().add(kVar);
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

    private void a(k kVar, XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        if (TextUtils.isEmpty(attributeValue)) {
            return;
        }
        kVar.a(attributeValue);
        kVar.b(com.baidu.android.systemmonitor.c.d.a(xmlPullParser.nextText()));
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
                        c cVar = new c();
                        a(cVar, newPullParser);
                        this.b.add(cVar);
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
        if (a3.startsWith(String.valueOf(Build.VERSION.SDK_INT))) {
            str = a3;
        } else {
            a("appmonitor_dataset_version", str);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("set_urls_version", a);
            jSONObject.put("set_settings_version", a2);
            jSONObject.put("set_appmonitor_version", str);
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

    private void b(k kVar, XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        if (TextUtils.isEmpty(attributeValue)) {
            return;
        }
        kVar.a(attributeValue);
        kVar.b(xmlPullParser.nextText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            String a = cVar.a();
            if (TextUtils.equals(a, "set_urls")) {
                if (o.a(this.c).a(cVar.b().b(), 0)) {
                    a("urls_dataset_version", cVar.b().a());
                }
            } else if (TextUtils.equals(a, "set_settings")) {
                if (o.a(this.c).a(cVar.b().b(), 1)) {
                    a("settings_dataset_version", cVar.b().a());
                }
            } else if (TextUtils.equals(a, "appmonitor") && o.a(this.c).a(cVar.b().b(), 2)) {
                a("appmonitor_dataset_version", cVar.b().a());
            }
        }
    }

    public void a() {
        String str = l.b;
        if (!TextUtils.isEmpty(com.baidu.android.systemmonitor.c.a.j())) {
            str = com.baidu.android.systemmonitor.c.a.j();
        }
        new m(this, com.baidu.android.nebula.util.d.a(this.c).a(str, false)).start();
    }
}
