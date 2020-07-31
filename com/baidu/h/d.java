package com.baidu.h;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
/* loaded from: classes12.dex */
public class d {
    public static void NV() {
        if (ProcessUtils.isMainProcess()) {
            b.NT().gy("");
        }
    }

    public static void k(Bundle bundle) {
        b.NT().k(bundle);
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
