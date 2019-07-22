package com.baidu.swan.apps.core.pms.c;

import android.text.TextUtils;
import com.baidu.swan.apps.install.e;
import com.baidu.swan.apps.install.subpackage.SubPackageAPSInfo;
import com.baidu.swan.pms.model.h;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(String str, int i, List<h> list) {
        if (!TextUtils.isEmpty(str) && list != null && !list.isEmpty()) {
            for (h hVar : list) {
                if (hVar != null && hVar.Wo()) {
                    SubPackageAPSInfo subPackageAPSInfo = new SubPackageAPSInfo();
                    subPackageAPSInfo.mKey = hVar.bsR;
                    subPackageAPSInfo.mAppId = str;
                    subPackageAPSInfo.mAppVersion = String.valueOf(i);
                    subPackageAPSInfo.ayM = hVar.Ht;
                    subPackageAPSInfo.ayL = e.d.ae(str, String.valueOf(i)).getPath();
                    com.baidu.swan.apps.core.a.d.a.a(subPackageAPSInfo, hVar.sign, hVar.filePath, false);
                }
            }
        }
    }
}
