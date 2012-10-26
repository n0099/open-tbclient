package com.baidu.share;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {
    Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.a = null;
        this.a = context;
    }

    private static boolean a(Context context, String str, String str2, String str3, long j, HashMap hashMap) {
        Intent intent = new Intent(Keystore.a());
        intent.putExtra(Keystore.c(), Crypto.encrypt(context, str));
        intent.putExtra(Keystore.d(), Crypto.encrypt(context, str2));
        intent.putExtra(Keystore.f(), Crypto.encrypt(context, new StringBuilder(String.valueOf(j)).toString()));
        intent.putExtra(Keystore.g(), Crypto.encrypt(context, str3));
        String str4 = null;
        if (hashMap != null && hashMap.size() > 0) {
            str4 = new JSONObject(hashMap).toString();
        }
        intent.putExtra(Keystore.e(), Crypto.encrypt(context, str4));
        intent.addFlags(32);
        context.sendBroadcast(intent, Keystore.b());
        return true;
    }

    private static boolean b(ShareModel shareModel) {
        if (shareModel == null || shareModel.mAction == null || shareModel.mAction.equals("")) {
            return false;
        }
        return shareModel.mData == null || shareModel.mData.get(Keystore.c()) == null;
    }

    final void a() {
        this.a = null;
    }

    final boolean a(ShareModel shareModel) {
        return a(shareModel, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(ShareModel shareModel, ArrayList arrayList) {
        String str;
        String str2 = null;
        if (shareModel == null ? false : (shareModel.mAction == null || shareModel.mAction.equals("")) ? false : shareModel.mData == null || shareModel.mData.get(Keystore.c()) == null) {
            String str3 = shareModel.mAction;
            String packageName = this.a.getPackageName();
            long currentTimeMillis = System.currentTimeMillis();
            if (arrayList != null) {
                str = new String();
                int i = 0;
                while (i < arrayList.size()) {
                    String str4 = String.valueOf(str) + ((String) arrayList.get(i)).replace(Keystore.h(), "") + Keystore.h();
                    i++;
                    str = str4;
                }
                if (str.length() > 0) {
                    str = str.substring(0, str.length() - 1);
                }
            } else {
                str = null;
            }
            Context context = this.a;
            HashMap hashMap = shareModel.mData;
            Intent intent = new Intent(Keystore.a());
            intent.putExtra(Keystore.c(), Crypto.encrypt(context, str3));
            intent.putExtra(Keystore.d(), Crypto.encrypt(context, packageName));
            intent.putExtra(Keystore.f(), Crypto.encrypt(context, new StringBuilder(String.valueOf(currentTimeMillis)).toString()));
            intent.putExtra(Keystore.g(), Crypto.encrypt(context, str));
            if (hashMap != null && hashMap.size() > 0) {
                str2 = new JSONObject(hashMap).toString();
            }
            intent.putExtra(Keystore.e(), Crypto.encrypt(context, str2));
            intent.addFlags(32);
            context.sendBroadcast(intent, Keystore.b());
            return true;
        }
        return false;
    }
}
