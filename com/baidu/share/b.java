package com.baidu.share;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Context f958a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.f958a = null;
        this.f958a = context;
    }

    private static boolean a(Context context, String str, String str2, String str3, long j, HashMap hashMap) {
        try {
            Intent intent = new Intent(a.a());
            intent.putExtra(a.c(), Crypto.encrypt(context, str));
            intent.putExtra(a.d(), Crypto.encrypt(context, str2));
            intent.putExtra(a.f(), Crypto.encrypt(context, new StringBuilder(String.valueOf(j)).toString()));
            intent.putExtra(a.g(), Crypto.encrypt(context, str3));
            String str4 = null;
            if (hashMap != null && hashMap.size() > 0) {
                str4 = new JSONObject(hashMap).toString();
            }
            intent.putExtra(a.e(), Crypto.encrypt(context, str4));
            intent.addFlags(32);
            context.sendBroadcast(intent, a.b());
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean b(ShareModel shareModel) {
        if (shareModel == null || shareModel.mAction == null || shareModel.mAction.equals("")) {
            return false;
        }
        return shareModel.mData == null || shareModel.mData.get(a.c()) == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f958a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ShareModel shareModel) {
        return a(shareModel, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ShareModel shareModel, ArrayList arrayList) {
        if (b(shareModel)) {
            String str = shareModel.mAction;
            String packageName = this.f958a.getPackageName();
            long currentTimeMillis = System.currentTimeMillis();
            String str2 = null;
            if (arrayList != null) {
                str2 = new String();
                for (int i = 0; i < arrayList.size(); i++) {
                    str2 = String.valueOf(str2) + ((String) arrayList.get(i)).replace(a.h(), "") + a.h();
                }
                if (str2.length() > 0) {
                    str2 = str2.substring(0, str2.length() - 1);
                }
            }
            return a(this.f958a, str, packageName, str2, currentTimeMillis, shareModel.mData);
        }
        return false;
    }
}
