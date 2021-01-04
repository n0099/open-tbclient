package com.baidu.m;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
/* loaded from: classes3.dex */
public class d {
    public static void afj() {
        if (ProcessUtils.isMainProcess()) {
            b.afh().jR("");
        }
    }

    public static void k(Bundle bundle) {
        b.afh().k(bundle);
    }

    public static void l(Bundle bundle) {
        if (bundle == null) {
            a.ae(3, "闪付返回信息为空");
            return;
        }
        String string = bundle.getString("statusCode");
        try {
            a.ae(Integer.parseInt(string), bundle.getString("payInfo"));
        } catch (NumberFormatException e) {
            a.ae(3, e.getMessage());
        }
    }
}
