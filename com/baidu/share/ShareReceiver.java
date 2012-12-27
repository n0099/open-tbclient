package com.baidu.share;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ShareReceiver extends BroadcastReceiver {
    static String a(ArrayList arrayList) {
        int size = arrayList.size();
        String str = new String();
        int i = 0;
        while (i < size) {
            String str2 = String.valueOf(str) + ((String) arrayList.get(i)) + e.h();
            i++;
            str = str2;
        }
        return str.length() > 0 ? str.substring(0, str.length() - 1) : str;
    }

    private void a(Context context, Bundle bundle) {
        boolean z = false;
        String string = bundle.getString(e.c());
        if (f.a(string)) {
            String b = Crypto.b(context, string);
            if (f.a(b)) {
                String string2 = bundle.getString(e.d());
                if (f.a(string2)) {
                    String packageName = context.getPackageName();
                    String b2 = Crypto.b(context, string2);
                    if (f.a(b2)) {
                        if (f.a(packageName) && packageName.equals(b2)) {
                            return;
                        }
                        String string3 = bundle.getString(e.g());
                        if (string3 != null) {
                            String b3 = Crypto.b(context, string3);
                            if (!f.a(b3)) {
                                return;
                            }
                            String[] split = b3.split(e.h());
                            if (split != null) {
                                int length = split.length;
                                int i = 0;
                                while (true) {
                                    if (i >= length) {
                                        break;
                                    } else if (packageName.equals(split[i])) {
                                        z = true;
                                        break;
                                    } else {
                                        i++;
                                    }
                                }
                                if (!z) {
                                    return;
                                }
                            }
                        }
                        String string4 = bundle.getString(e.f());
                        if (f.a(string4)) {
                            try {
                                long parseLong = Long.parseLong(Crypto.b(context, string4));
                                if (a(context, parseLong)) {
                                    String string5 = bundle.getString(e.e());
                                    HashMap hashMap = new HashMap();
                                    if (f.a(string5)) {
                                        String b4 = Crypto.b(context, string5);
                                        if (f.a(b4)) {
                                            try {
                                                JSONObject jSONObject = new JSONObject(b4);
                                                Iterator<String> keys = jSONObject.keys();
                                                while (keys.hasNext()) {
                                                    String next = keys.next();
                                                    hashMap.put(next, jSONObject.getString(next));
                                                }
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                    c cVar = new c();
                                    cVar.a = b;
                                    cVar.b = b2;
                                    cVar.c = parseLong;
                                    cVar.d = hashMap;
                                    b.a(context).b(cVar);
                                }
                            } catch (Exception e2) {
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean a(Context context, long j) {
        File filesDir = context.getFilesDir();
        if (filesDir != null && filesDir.exists() && filesDir.isDirectory()) {
            String sb = new StringBuilder(String.valueOf(j)).toString();
            File file = new File(String.valueOf(filesDir.getAbsolutePath()) + "/" + e.i());
            try {
                ArrayList arrayList = new ArrayList();
                if (file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    byte[] bArr = new byte[(int) file.length()];
                    fileInputStream.read(bArr);
                    String optString = new JSONObject(new String(bArr)).optString(e.f());
                    if (f.a(optString)) {
                        String[] split = optString.split(e.h());
                        if (split.length > 0) {
                            int length = split.length;
                            for (int i = 0; i < length; i++) {
                                arrayList.add(split[i]);
                                if (sb.equals(split[i])) {
                                    arrayList.clear();
                                    return false;
                                }
                            }
                            int j2 = e.j() - length;
                            if (j2 <= 0) {
                                Collections.sort(arrayList);
                                for (int i2 = 0; i2 < (-j2) + 1; i2++) {
                                    arrayList.remove(0);
                                }
                            }
                        }
                    }
                    file.deleteOnExit();
                }
                arrayList.add(sb);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(e.f(), a(arrayList));
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(jSONObject.toString());
                fileWriter.flush();
                fileWriter.close();
                return true;
            } catch (Exception e) {
                return true;
            }
        }
        return true;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        try {
            String action = intent.getAction();
            if ((action == null || e.a() == null || action.equals(e.a())) && (extras = intent.getExtras()) != null) {
                a(context, extras);
            }
        } catch (Throwable th) {
        }
    }
}
