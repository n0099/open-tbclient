package com.baidu.swan.bdprivate.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.baidu.swan.bdprivate.b;
/* loaded from: classes10.dex */
public class b extends Dialog {
    private Context mContext;
    private String mMessage;

    public b(Context context) {
        super(context, b.h.BdWaitingDialog);
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(b.f.loading_layout);
        ((TextView) findViewById(b.e.message)).setText(this.mMessage);
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }
}
