package com.baidu.swan.bdprivate.a.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.apps.a.c;
import com.baidu.swan.bdprivate.a.aa;
import com.baidu.swan.bdprivate.a.ab;
import com.baidu.swan.bdprivate.a.l;
import com.baidu.swan.bdprivate.api.b;
import com.baidu.swan.bdprivate.b.a;
import com.baidu.swan.bdprivate.d.a;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import com.baidu.swan.bdprivate.extensions.quicklogin.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public interface a {
    void a(Activity activity, String str, e eVar);

    void a(Activity activity, String str, String str2, ab abVar);

    void a(Context context, Bundle bundle, com.baidu.swan.apps.a.a aVar);

    void a(Context context, a.InterfaceC0505a interfaceC0505a);

    void a(Context context, a.InterfaceC0507a interfaceC0507a);

    void a(Context context, SwanAppPhoneLoginDialog.a aVar, String str);

    void a(l.a aVar, String str, List<String> list);

    void a(String str, ArrayList<String> arrayList, b.a aVar);

    void b(Activity activity, String str, String str2, ab abVar);

    void b(c cVar);

    String eg(Context context);

    aa ej(Context context);

    String getBduss(Context context);

    String getCuid(Context context);

    String getUid(Context context);

    String getZid(Context context);

    boolean isLogin(Context context);
}
