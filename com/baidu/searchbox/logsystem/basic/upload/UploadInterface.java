package com.baidu.searchbox.logsystem.basic.upload;

import android.content.Context;
import com.baidu.searchbox.logsystem.logsys.LogObject;
import java.util.List;
import java.util.Set;
/* loaded from: classes2.dex */
public interface UploadInterface {
    void upload(Context context);

    void upload(Context context, LogObject logObject, List list, Set set, List list2);
}
