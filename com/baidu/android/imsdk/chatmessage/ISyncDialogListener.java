package com.baidu.android.imsdk.chatmessage;

import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.chatmessage.sync.DialogRecord;
import java.util.List;
/* loaded from: classes3.dex */
public interface ISyncDialogListener extends IMListener {
    void onSyncDialogResult(int i, String str, long j, List<DialogRecord> list);
}
