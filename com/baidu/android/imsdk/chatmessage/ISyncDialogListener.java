package com.baidu.android.imsdk.chatmessage;

import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.chatmessage.sync.DialogRecord;
import java.util.List;
/* loaded from: classes10.dex */
public interface ISyncDialogListener extends IMListener {
    void onSyncDialogResult(int i2, String str, long j2, List<DialogRecord> list);
}
