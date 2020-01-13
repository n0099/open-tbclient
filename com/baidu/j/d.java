package com.baidu.j;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
/* loaded from: classes10.dex */
public class d {
    public static void BX() {
        if (ProcessUtils.isMainProcess()) {
            b.BV().eu("");
        }
    }

    public static void i(Bundle bundle) {
        b.BV().i(bundle);
    }

    public static void j(Bundle bundle) {
        if (bundle == null) {
            a.q(3, "闪付返回信息为空");
            return;
        }
        String string = bundle.getString("statusCode");
        try {
            a.q(Integer.parseInt(string), bundle.getString("payInfo"));
        } catch (NumberFormatException e) {
            a.q(3, e.getMessage());
        }
    }
}
