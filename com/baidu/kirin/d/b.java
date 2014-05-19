package com.baidu.kirin.d;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static JSONObject a(Context context, String str) {
        try {
            FileInputStream openFileInput = context.openFileInput(str);
            if (openFileInput == null) {
                d.c("Invalid jsonobject file " + str);
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            byte[] bArr = new byte[4096];
            while (true) {
                int read = openFileInput.read(bArr);
                if (read == -1) {
                    break;
                }
                stringBuffer.append(new String(bArr, 0, read));
            }
            openFileInput.close();
            if (stringBuffer.length() == 0) {
                d.a(str + " is empty! return null!");
                return null;
            }
            try {
                return new JSONObject(stringBuffer.toString());
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void a(Context context, String str, JSONObject jSONObject) {
        d.a("File is: " + str + "; Content is: " + jSONObject.toString());
        FileOutputStream openFileOutput = context.openFileOutput(str, 0);
        openFileOutput.write(jSONObject.toString().getBytes());
        openFileOutput.flush();
        openFileOutput.close();
    }
}
