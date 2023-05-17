package com.baidu.searchbox.command;

import android.content.Context;
import android.content.Intent;
import java.util.Map;
/* loaded from: classes3.dex */
public abstract class ICommandIoc {
    public abstract boolean checkOpenable(Context context, Intent intent);

    public abstract boolean checkTargetIntentForRN(Intent intent);

    public abstract void sendGMVLog(Map<String, String> map);
}
