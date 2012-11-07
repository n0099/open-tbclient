package com.baidu.loginshare;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class c {
    private Context a;
    private JSONObject b;
    private File c;
    private String d;
    private boolean e;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.loginshare.c */
    /* JADX WARN: Multi-variable type inference failed */
    c(Context context) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = "loginshare";
        this.e = false;
        this.a = context;
        c();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.loginshare.c */
    /* JADX WARN: Multi-variable type inference failed */
    private void c() {
        File filesDir = this.a.getFilesDir();
        Log.d(this.d, "FileStorage.init.fileDir." + filesDir);
        this.c = new File(String.valueOf(filesDir.getAbsolutePath()) + "/" + Keystore.e());
        Log.d(this.d, "FileStorage.init.mFile." + this.c);
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

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.loginshare.c */
    /* JADX WARN: Multi-variable type inference failed */
    public final String a(String str) {
        return this.b.optString(str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.loginshare.c */
    /* JADX WARN: Multi-variable type inference failed */
    public final void a(String str, String str2) {
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

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.loginshare.c */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a() {
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

    public final void b() {
    }
}
