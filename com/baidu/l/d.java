package com.baidu.l;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
/* loaded from: classes16.dex */
public class d {
    public static void Yp() {
        if (ProcessUtils.isMainProcess()) {
            b.Yn().jh("");
        }
    }

    public static void k(Bundle bundle) {
        b.Yn().k(bundle);
    }

    public static void l(Bundle bundle) {
        if (bundle == null) {
            a.Y(3, "闪付返回信息为空");
            return;
        }
        String string = bundle.getString("statusCode");
        try {
            a.Y(Integer.parseInt(string), bundle.getString("payInfo"));
        } catch (NumberFormatException e) {
            a.Y(3, e.getMessage());
        }
    }
}
