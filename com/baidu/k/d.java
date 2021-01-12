package com.baidu.k;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
/* loaded from: classes3.dex */
public class d {
    public static void abr() {
        if (ProcessUtils.isMainProcess()) {
            b.abp().iG("");
        }
    }

    public static void k(Bundle bundle) {
        b.abp().k(bundle);
    }

    public static void l(Bundle bundle) {
        if (bundle == null) {
            a.af(3, "闪付返回信息为空");
            return;
        }
        String string = bundle.getString("statusCode");
        try {
            a.af(Integer.parseInt(string), bundle.getString("payInfo"));
        } catch (NumberFormatException e) {
            a.af(3, e.getMessage());
        }
    }
}
