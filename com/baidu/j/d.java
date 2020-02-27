package com.baidu.j;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
/* loaded from: classes11.dex */
public class d {
    public static void Et() {
        if (ProcessUtils.isMainProcess()) {
            b.Er().eK("");
        }
    }

    public static void i(Bundle bundle) {
        b.Er().i(bundle);
    }

    public static void j(Bundle bundle) {
        if (bundle == null) {
            a.s(3, "闪付返回信息为空");
            return;
        }
        String string = bundle.getString("statusCode");
        try {
            a.s(Integer.parseInt(string), bundle.getString("payInfo"));
        } catch (NumberFormatException e) {
            a.s(3, e.getMessage());
        }
    }
}
