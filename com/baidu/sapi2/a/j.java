package com.baidu.sapi2.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.sapi2.utils.L;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
/* loaded from: classes.dex */
public class j implements CookieStore {
    private static final String a = "CookiePrefsFile";
    private static final String b = "names";
    private static final String c = "cookie_";
    private final ConcurrentHashMap<String, Cookie> d = new ConcurrentHashMap<>();
    private final SharedPreferences e;

    public j(Context context) {
        String[] split;
        Cookie a2;
        this.e = context.getSharedPreferences(a, 0);
        String string = this.e.getString(b, null);
        if (string != null) {
            for (String str : TextUtils.split(string, ",")) {
                String string2 = this.e.getString(c + str, null);
                if (string2 != null && (a2 = a(string2)) != null) {
                    this.d.put(str, a2);
                }
            }
            clearExpired(new Date());
        }
    }

    public void addCookie(Cookie cookie) {
        String name = cookie.getName();
        if (!cookie.isExpired(new Date())) {
            this.d.put(name, cookie);
        } else {
            this.d.remove(name);
        }
        SharedPreferences.Editor edit = this.e.edit();
        edit.putString(b, TextUtils.join(",", this.d.keySet()));
        edit.putString(c + name, a(new e(cookie)));
        edit.commit();
    }

    public void clear() {
        this.d.clear();
        SharedPreferences.Editor edit = this.e.edit();
        Iterator<String> it = this.d.keySet().iterator();
        while (it.hasNext()) {
            edit.remove(c + it.next());
        }
        edit.remove(b);
        edit.commit();
    }

    public boolean clearExpired(Date date) {
        boolean z;
        boolean z2 = false;
        SharedPreferences.Editor edit = this.e.edit();
        Iterator<Map.Entry<String, Cookie>> it = this.d.entrySet().iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, Cookie> next = it.next();
            String key = next.getKey();
            if (next.getValue().isExpired(date)) {
                this.d.remove(key);
                edit.remove(c + key);
                z2 = true;
            } else {
                z2 = z;
            }
        }
        if (z) {
            edit.putString(b, TextUtils.join(",", this.d.keySet()));
        }
        edit.commit();
        return z;
    }

    public List<Cookie> getCookies() {
        return new ArrayList(this.d.values());
    }

    protected String a(e eVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(eVar);
            return a(byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            return null;
        }
    }

    protected Cookie a(String str) {
        try {
            return ((e) new ObjectInputStream(new ByteArrayInputStream(b(str))).readObject()).a();
        } catch (Exception e) {
            L.e(e);
            return null;
        }
    }

    protected String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            int i = b2 & 255;
            if (i < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(i));
        }
        return sb.toString().toUpperCase();
    }

    protected byte[] b(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}
