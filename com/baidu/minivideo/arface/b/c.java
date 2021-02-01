package com.baidu.minivideo.arface.b;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends j {
    public c(d dVar) {
        super(dVar.mUrl, dVar.ckA);
    }

    @Override // com.baidu.minivideo.arface.b.j
    protected boolean n(File file) {
        return o(file);
    }

    public static boolean o(File file) {
        JSONArray optJSONArray;
        try {
            File file2 = new File(file, "files.json");
            if (file2 == null || !file2.exists()) {
                return false;
            }
            FileInputStream fileInputStream = new FileInputStream(file2);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            String str = new String(bArr);
            fileInputStream.close();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray(com.baidu.fsg.face.base.b.c.g)) == null || optJSONArray.length() <= 0) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(a.jd(optJSONArray.getString(i)));
            }
            return a(file, arrayList);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean a(File file, ArrayList<a> arrayList) {
        File file2;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        try {
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                a next = it.next();
                String str = next.mPath;
                if (TextUtils.isEmpty(str)) {
                    file2 = new File(file, next.mName);
                } else {
                    file2 = new File(file, str + File.separator + next.mName);
                }
                if (file2 == null || !file2.exists()) {
                    return false;
                }
                String fileMD5 = f.getFileMD5(file2.getAbsolutePath());
                boolean equals = TextUtils.equals(fileMD5, next.mMd5);
                if (!equals) {
                    d(equals + " " + fileMD5 + "!=" + next.mMd5 + ", " + file2.getAbsolutePath());
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        public String mMd5;
        public String mName;
        public String mPath;

        public static a jd(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null) {
                    a aVar = new a();
                    aVar.mName = jSONObject.optString("name");
                    aVar.mPath = jSONObject.optString("path");
                    aVar.mMd5 = jSONObject.optString("md5");
                    return aVar;
                }
                return null;
            } catch (Exception e) {
                return null;
            }
        }
    }
}
