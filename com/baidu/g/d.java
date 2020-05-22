package com.baidu.g;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
/* loaded from: classes11.dex */
public class d {
    public static void MG() {
        if (ProcessUtils.isMainProcess()) {
            b.ME().gq("");
        }
    }

    public static void k(Bundle bundle) {
        b.ME().k(bundle);
    }

    public static void l(Bundle bundle) {
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
