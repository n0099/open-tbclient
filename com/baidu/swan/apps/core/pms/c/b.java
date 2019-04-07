package com.baidu.swan.apps.core.pms.c;

import android.text.TextUtils;
import com.baidu.swan.apps.install.c;
import com.baidu.swan.apps.install.subpackage.SubPackageAPSInfo;
import com.baidu.swan.pms.model.i;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(String str, int i, List<i> list) {
        if (!TextUtils.isEmpty(str) && list != null && !list.isEmpty()) {
            for (i iVar : list) {
                if (iVar != null && iVar.RI()) {
                    SubPackageAPSInfo subPackageAPSInfo = new SubPackageAPSInfo();
                    subPackageAPSInfo.mKey = iVar.blZ;
                    subPackageAPSInfo.mAppId = str;
                    subPackageAPSInfo.mAppVersion = String.valueOf(i);
                    subPackageAPSInfo.axr = iVar.Jz;
                    subPackageAPSInfo.axq = c.d.ah(str, String.valueOf(i)).getPath();
                    com.baidu.swan.apps.core.a.d.a.a(subPackageAPSInfo, iVar.sign, iVar.filePath, false);
                }
            }
        }
    }
}
