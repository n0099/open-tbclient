package com.baidu.sapi2.views;

import android.app.Dialog;
import android.content.Context;
import com.baidu.d.a.a;
/* loaded from: classes2.dex */
public class m extends Dialog {
    public m(Context context) {
        super(context, a.h.sapi_sdk_total_transparency_dialog);
        setContentView(a.f.layout_sapi_sdk_dialog_loading_gray);
        setCancelable(false);
    }
}
