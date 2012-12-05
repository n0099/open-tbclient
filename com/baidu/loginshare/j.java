package com.baidu.loginshare;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j implements g {
    private Context a;
    private JSONObject b = null;
    private File c = null;
    private String d = "loginshare";
    private boolean e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context) {
        this.a = null;
        this.a = context;
        c();
    }

    private void c() {
        File filesDir = this.a.getFilesDir();
        if (filesDir != null) {
            this.c = new File(String.valueOf(filesDir.getAbsolutePath()) + "/" + h.e());
        }
        if (this.c == null || !this.c.exists()) {
            this.b = new JSONObject();
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(this.c);
            byte[] bArr = new byte[(int) this.c.length()];
            fileInputStream.read(bArr);
            this.b = new JSONObject(new String(bArr));
            fileInputStream.close();
        } catch (Exception e) {
            this.b = new JSONObject();
        }
    }

    @Override // com.baidu.loginshare.g
    public String a(String str) {
        return this.b.optString(str);
    }

    @Override // com.baidu.loginshare.g
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
        if (a != null) {
            this.e = a.equals(str2);
        } else {
            this.e = str2 == null;
        }
    }

    @Override // com.baidu.loginshare.g
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

    @Override // com.baidu.loginshare.g
    public void b() {
    }
}
