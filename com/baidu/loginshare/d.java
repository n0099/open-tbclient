package com.baidu.loginshare;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private Context a;
    private JSONObject b;
    private File c;
    private String d;
    private boolean e;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.loginshare.d */
    /* JADX WARN: Multi-variable type inference failed */
    d(Context context) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.e = false;
        this.a = context;
        c();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.loginshare.d */
    /* JADX WARN: Multi-variable type inference failed */
    private void c() {
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

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.loginshare.d */
    /* JADX WARN: Multi-variable type inference failed */
    public String a(String str) {
        return this.b.optString(str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.loginshare.d */
    /* JADX WARN: Multi-variable type inference failed */
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

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.loginshare.d */
    /* JADX WARN: Multi-variable type inference failed */
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
}
