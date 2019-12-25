package com.baidu.j;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
/* loaded from: classes9.dex */
public class d {
    public static void BB() {
        if (ProcessUtils.isMainProcess()) {
            b.Bz().er("");
        }
    }

    public static void i(Bundle bundle) {
        b.Bz().i(bundle);
    }

    public static void j(Bundle bundle) {
        if (bundle == null) {
            a.n(3, "闪付返回信息为空");
            return;
        }
        String string = bundle.getString("statusCode");
        try {
            a.n(Integer.parseInt(string), bundle.getString("payInfo"));
        } catch (NumberFormatException e) {
            a.n(3, e.getMessage());
        }
    }
}
