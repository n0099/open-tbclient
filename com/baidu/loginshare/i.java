package com.baidu.loginshare;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i implements h {

    /* renamed from: a  reason: collision with root package name */
    private Context f931a;
    private JSONObject b = null;
    private File c = null;
    private String d = "loginshare";
    private boolean e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context) {
        this.f931a = null;
        this.f931a = context;
        c();
    }

    private void c() {
        File filesDir = this.f931a.getFilesDir();
        if (filesDir != null) {
            this.c = new File(String.valueOf(filesDir.getAbsolutePath()) + "/" + g.e());
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

    @Override // com.baidu.loginshare.h
    public String a(String str) {
        return this.b.optString(str);
    }

    @Override // com.baidu.loginshare.h
    public void a(String str, String str2) {
        try {
            this.b.put(str, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (this.e) {
            return;
        }
        String a2 = a(str);
        if (a2 != null) {
            this.e = a2.equals(str2);
        } else {
            this.e = str2 == null;
        }
    }

    @Override // com.baidu.loginshare.h
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

    @Override // com.baidu.loginshare.h
    public void b() {
    }
}
