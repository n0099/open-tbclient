package com.baidu.loginshare;

import android.content.Context;
import com.baidu.share.Crypto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    Context a;
    JSONObject b;
    File c;
    String d;
    boolean e;

    public a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.e = false;
        this.a = context;
        c();
    }

    static String a(Context context, String str) {
        return Crypto.encrypt(context, str);
    }

    static String b(Context context, String str) {
        return Crypto.decrypt(context, str);
    }

    public String a(String str) {
        return this.b.optString(str);
    }

    public void a(String str, String str2) {
        try {
            this.b.put(str, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (this.e) {
            return;
        }
        String a = a(str);
        this.e = a != null ? a.equals(str2) : str2 == null;
    }

    public boolean a() {
        if (this.e) {
            try {
                FileWriter fileWriter = new FileWriter(this.c);
                fileWriter.write(this.b.toString());
                fileWriter.flush();
                fileWriter.close();
                this.e = false;
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public void b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.c = new File(String.valueOf(this.a.getFilesDir().getAbsolutePath()) + "/" + Keystore.e());
        if (!this.c.exists()) {
            this.b = new JSONObject();
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(this.c);
            byte[] bArr = new byte[(int) this.c.length()];
            fileInputStream.read(bArr);
            this.b = new JSONObject(new String(bArr));
        } catch (Exception e) {
            this.b = new JSONObject();
        }
    }
}
