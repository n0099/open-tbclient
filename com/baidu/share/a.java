package com.baidu.share;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.a = null;
        this.a = context;
    }

    private static boolean a(Context context, String str, String str2, String str3, long j, HashMap hashMap) {
        try {
            Intent intent = new Intent(b.a());
            intent.putExtra(b.c(), Crypto.encrypt(context, str));
            intent.putExtra(b.d(), Crypto.encrypt(context, str2));
            intent.putExtra(b.f(), Crypto.encrypt(context, new StringBuilder(String.valueOf(j)).toString()));
            intent.putExtra(b.g(), Crypto.encrypt(context, str3));
            String str4 = null;
            if (hashMap != null && hashMap.size() > 0) {
                str4 = new JSONObject(hashMap).toString();
            }
            intent.putExtra(b.e(), Crypto.encrypt(context, str4));
            intent.addFlags(32);
            context.sendBroadcast(intent, b.b());
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean b(ShareModel shareModel) {
        if (shareModel == null || shareModel.mAction == null || shareModel.mAction.equals("")) {
            return false;
        }
        return shareModel.mData == null || shareModel.mData.get(b.c()) == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ShareModel shareModel) {
        return a(shareModel, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ShareModel shareModel, ArrayList arrayList) {
        if (b(shareModel)) {
            String str = shareModel.mAction;
            String packageName = this.a.getPackageName();
            long currentTimeMillis = System.currentTimeMillis();
            String str2 = null;
            if (arrayList != null) {
                str2 = new String();
                for (int i = 0; i < arrayList.size(); i++) {
                    str2 = String.valueOf(str2) + ((String) arrayList.get(i)).replace(b.h(), "") + b.h();
                }
                if (str2.length() > 0) {
                    str2 = str2.substring(0, str2.length() - 1);
                }
            }
            return a(this.a, str, packageName, str2, currentTimeMillis, shareModel.mData);
        }
        return false;
    }
}
