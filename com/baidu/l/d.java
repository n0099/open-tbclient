package com.baidu.l;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
/* loaded from: classes14.dex */
public class d {
    public static void Uy() {
        if (ProcessUtils.isMainProcess()) {
            b.Uw().im("");
        }
    }

    public static void k(Bundle bundle) {
        b.Uw().k(bundle);
    }

    public static void l(Bundle bundle) {
        if (bundle == null) {
            a.L(3, "闪付返回信息为空");
            return;
        }
        String string = bundle.getString("statusCode");
        try {
            a.L(Integer.parseInt(string), bundle.getString("payInfo"));
        } catch (NumberFormatException e) {
            a.L(3, e.getMessage());
        }
    }
}
