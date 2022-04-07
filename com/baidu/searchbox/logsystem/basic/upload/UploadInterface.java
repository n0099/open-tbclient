package com.baidu.searchbox.logsystem.basic.upload;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.logsys.LogFile;
import com.baidu.searchbox.logsystem.logsys.LogObject;
import java.util.List;
import java.util.Set;
/* loaded from: classes2.dex */
public interface UploadInterface {
    void upload(Context context);

    void upload(Context context, @NonNull LogObject logObject, @Nullable List<LogFile> list, @Nullable Set<LogFile> set, @Nullable List<LogFile> list2);
}
