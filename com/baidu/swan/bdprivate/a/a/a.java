package com.baidu.swan.bdprivate.a.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.apps.a.c;
import com.baidu.swan.bdprivate.a.aa;
import com.baidu.swan.bdprivate.a.l;
import com.baidu.swan.bdprivate.a.z;
import java.util.List;
/* loaded from: classes9.dex */
public interface a {
    void a(Activity activity, String str, String str2, aa aaVar);

    void a(Context context, Bundle bundle, com.baidu.swan.apps.a.a aVar);

    void a(l.a aVar, String str, List<String> list);

    void b(Activity activity, String str, String str2, aa aaVar);

    void b(c cVar);

    String cX(Context context);

    z da(Context context);

    String getBduss(Context context);

    String getCuid(Context context);

    String getUid(Context context);

    String getZid(Context context);

    boolean isLogin(Context context);
}
