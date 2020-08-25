package com.baidu.l;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
/* loaded from: classes19.dex */
public class d {
    public static void TP() {
        if (ProcessUtils.isMainProcess()) {
            b.TN().hS("");
        }
    }

    public static void k(Bundle bundle) {
        b.TN().k(bundle);
    }

    public static void l(Bundle bundle) {
        if (bundle == null) {
            a.K(3, "闪付返回信息为空");
            return;
        }
        String string = bundle.getString("statusCode");
        try {
            a.K(Integer.parseInt(string), bundle.getString("payInfo"));
        } catch (NumberFormatException e) {
            a.K(3, e.getMessage());
        }
    }
}
