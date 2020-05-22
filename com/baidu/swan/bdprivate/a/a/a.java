package com.baidu.swan.bdprivate.a.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.apps.a.c;
import com.baidu.swan.bdprivate.a.aa;
import com.baidu.swan.bdprivate.a.l;
import com.baidu.swan.bdprivate.a.z;
import com.baidu.swan.bdprivate.api.b;
import com.baidu.swan.bdprivate.b.a;
import com.baidu.swan.bdprivate.e.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public interface a {
    void a(Activity activity, String str, String str2, aa aaVar);

    void a(Context context, Bundle bundle, com.baidu.swan.apps.a.a aVar);

    void a(Context context, a.InterfaceC0408a interfaceC0408a);

    void a(Context context, a.InterfaceC0412a interfaceC0412a);

    void a(l.a aVar, String str, List<String> list);

    void a(String str, ArrayList<String> arrayList, b.a aVar);

    void b(Activity activity, String str, String str2, aa aaVar);

    void b(c cVar);

    String cQ(Context context);

    z cT(Context context);

    String getBduss(Context context);

    String getCuid(Context context);

    String getUid(Context context);

    String getZid(Context context);

    boolean isLogin(Context context);
}
