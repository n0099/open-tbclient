package com.baidu.l;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
/* loaded from: classes16.dex */
public class d {
    public static void aaf() {
        if (ProcessUtils.isMainProcess()) {
            b.aad().jo("");
        }
    }

    public static void k(Bundle bundle) {
        b.aad().k(bundle);
    }

    public static void l(Bundle bundle) {
        if (bundle == null) {
            a.ac(3, "闪付返回信息为空");
            return;
        }
        String string = bundle.getString("statusCode");
        try {
            a.ac(Integer.parseInt(string), bundle.getString("payInfo"));
        } catch (NumberFormatException e) {
            a.ac(3, e.getMessage());
        }
    }
}
