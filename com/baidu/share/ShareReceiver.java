package com.baidu.share;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.loginshare.j;
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
    private static String a(ArrayList arrayList) {
        int size = arrayList.size();
        String str = new String();
        int i = 0;
        while (i < size) {
            String str2 = String.valueOf(str) + ((String) arrayList.get(i)) + Keystore.h();
            i++;
            str = str2;
        }
        return str.length() > 0 ? str.substring(0, str.length() - 1) : str;
    }

    private static boolean a(Context context, long j) {
        File filesDir = context.getFilesDir();
        if (filesDir != null && filesDir.exists() && filesDir.isDirectory()) {
            String sb = new StringBuilder(String.valueOf(j)).toString();
            File file = new File(String.valueOf(filesDir.getAbsolutePath()) + "/" + Keystore.i());
            try {
                ArrayList arrayList = new ArrayList();
                if (file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    byte[] bArr = new byte[(int) file.length()];
                    fileInputStream.read(bArr);
                    String optString = new JSONObject(new String(bArr)).optString(Keystore.f());
                    if (j.a(optString)) {
                        String[] split = optString.split(Keystore.h());
                        if (split.length > 0) {
                            int length = split.length;
                            for (int i = 0; i < length; i++) {
                                arrayList.add(split[i]);
                                if (sb.equals(split[i])) {
                                    arrayList.clear();
                                    return false;
                                }
                            }
                            int j2 = Keystore.j() - length;
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
                jSONObject.put(Keystore.f(), a(arrayList));
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
        String[] split;
        boolean z = false;
        if (intent.getAction().equals(Keystore.a()) && (extras = intent.getExtras()) != null) {
            String string = extras.getString(Keystore.c());
            if (j.a(string)) {
                String decrypt = Crypto.decrypt(context, string);
                if (j.a(decrypt)) {
                    String string2 = extras.getString(Keystore.d());
                    if (j.a(string2)) {
                        String packageName = context.getPackageName();
                        String decrypt2 = Crypto.decrypt(context, string2);
                        if (packageName.endsWith(decrypt2)) {
                            return;
                        }
                        String string3 = extras.getString(Keystore.g());
                        if (string3 != null && (split = Crypto.decrypt(context, string3).split(Keystore.h())) != null) {
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
                        String string4 = extras.getString(Keystore.f());
                        if (j.a(string4)) {
                            try {
                                long parseLong = Long.parseLong(Crypto.decrypt(context, string4));
                                if (a(context, parseLong)) {
                                    String string5 = extras.getString(Keystore.e());
                                    HashMap hashMap = new HashMap();
                                    if (j.a(string5)) {
                                        String decrypt3 = Crypto.decrypt(context, string5);
                                        if (j.a(decrypt3)) {
                                            try {
                                                JSONObject jSONObject = new JSONObject(decrypt3);
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
}
