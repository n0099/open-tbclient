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
            String str2 = String.valueOf(str) + ((String) arrayList.get(i)) + a.h();
            i++;
            str = str2;
        }
        return str.length() > 0 ? str.substring(0, str.length() - 1) : str;
    }

    private void a(Context context, Bundle bundle) {
        boolean z = false;
        String string = bundle.getString(a.c());
        if (c.a(string)) {
            String decrypt = Crypto.decrypt(context, string);
            if (c.a(decrypt)) {
                String string2 = bundle.getString(a.d());
                if (c.a(string2)) {
                    String packageName = context.getPackageName();
                    String decrypt2 = Crypto.decrypt(context, string2);
                    if (c.a(decrypt2)) {
                        if (c.a(packageName) && packageName.equals(decrypt2)) {
                            return;
                        }
                        String string3 = bundle.getString(a.g());
                        if (string3 != null) {
                            String decrypt3 = Crypto.decrypt(context, string3);
                            if (!c.a(decrypt3)) {
                                return;
                            }
                            String[] split = decrypt3.split(a.h());
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
                        String string4 = bundle.getString(a.f());
                        if (c.a(string4)) {
                            try {
                                long parseLong = Long.parseLong(Crypto.decrypt(context, string4));
                                if (a(context, parseLong)) {
                                    String string5 = bundle.getString(a.e());
                                    HashMap hashMap = new HashMap();
                                    if (c.a(string5)) {
                                        String decrypt4 = Crypto.decrypt(context, string5);
                                        if (c.a(decrypt4)) {
                                            try {
                                                JSONObject jSONObject = new JSONObject(decrypt4);
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
                                    ShareModel shareModel = new ShareModel();
                                    shareModel.mAction = decrypt;
                                    shareModel.mFrom = decrypt2;
                                    shareModel.mTimestamp = parseLong;
                                    shareModel.mData = hashMap;
                                    ShareAssistant.a(context).a(shareModel);
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
            File file = new File(String.valueOf(filesDir.getAbsolutePath()) + "/" + a.i());
            try {
                ArrayList arrayList = new ArrayList();
                if (file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    byte[] bArr = new byte[(int) file.length()];
                    fileInputStream.read(bArr);
                    String optString = new JSONObject(new String(bArr)).optString(a.f());
                    if (c.a(optString)) {
                        String[] split = optString.split(a.h());
                        if (split.length > 0) {
                            int length = split.length;
                            for (int i = 0; i < length; i++) {
                                arrayList.add(split[i]);
                                if (sb.equals(split[i])) {
                                    arrayList.clear();
                                    return false;
                                }
                            }
                            int j2 = a.j() - length;
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
                jSONObject.put(a.f(), a(arrayList));
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
            if ((action == null || a.a() == null || action.equals(a.a())) && (extras = intent.getExtras()) != null) {
                a(context, extras);
            }
        } catch (Throwable th) {
        }
    }
}
