package com.baidu.l;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
/* loaded from: classes16.dex */
public class d {
    public static void Wv() {
        if (ProcessUtils.isMainProcess()) {
            b.Wt().iO("");
        }
    }

    public static void k(Bundle bundle) {
        b.Wt().k(bundle);
    }

    public static void l(Bundle bundle) {
        if (bundle == null) {
            a.W(3, "闪付返回信息为空");
            return;
        }
        String string = bundle.getString("statusCode");
        try {
            a.W(Integer.parseInt(string), bundle.getString("payInfo"));
        } catch (NumberFormatException e) {
            a.W(3, e.getMessage());
        }
    }
}
