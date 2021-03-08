package com.baidu.k;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
/* loaded from: classes14.dex */
public class d {
    public static void adi() {
        if (ProcessUtils.isMainProcess()) {
            b.adg().js("");
        }
    }

    public static void k(Bundle bundle) {
        b.adg().k(bundle);
    }

    public static void l(Bundle bundle) {
        if (bundle == null) {
            a.aj(3, "闪付返回信息为空");
            return;
        }
        String string = bundle.getString("statusCode");
        try {
            a.aj(Integer.parseInt(string), bundle.getString("payInfo"));
        } catch (NumberFormatException e) {
            a.aj(3, e.getMessage());
        }
    }
}
