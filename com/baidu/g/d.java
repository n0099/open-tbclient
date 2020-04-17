package com.baidu.g;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
/* loaded from: classes11.dex */
public class d {
    public static void KN() {
        if (ProcessUtils.isMainProcess()) {
            b.KL().fE("");
        }
    }

    public static void i(Bundle bundle) {
        b.KL().i(bundle);
    }

    public static void j(Bundle bundle) {
        if (bundle == null) {
            a.J(3, "闪付返回信息为空");
            return;
        }
        String string = bundle.getString("statusCode");
        try {
            a.J(Integer.parseInt(string), bundle.getString("payInfo"));
        } catch (NumberFormatException e) {
            a.J(3, e.getMessage());
        }
    }
}
