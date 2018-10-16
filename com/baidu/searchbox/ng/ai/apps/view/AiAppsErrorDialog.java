package com.baidu.searchbox.ng.ai.apps.view;

import android.os.Bundle;
import android.widget.TextView;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.BaseActivityDialog;
/* loaded from: classes2.dex */
public class AiAppsErrorDialog extends BaseActivityDialog {
    private static final boolean DEBUG = false;
    public static final String TAG = "AiAppsErrorDialog";
    private TextView mMessage;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.res.widget.dialog.BaseActivityDialog, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mMessage = (TextView) findViewById(R.id.dialog_message);
        this.mMessage.setGravity(17);
    }

    public static BaseActivityDialog.Builder newBuilder() {
        return new BaseActivityDialog.Builder(AiAppsErrorDialog.class);
    }
}
