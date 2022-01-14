package com.baidu.searchbox.logsystem.logsys.eventscene.handler;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.logsys.LogFile;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import java.io.File;
import java.util.Set;
/* loaded from: classes11.dex */
public interface EventSceneHandler<T> {
    @Nullable
    Set<LogFile> getCustomizedSnapshots(@NonNull Context context, @NonNull File file, @NonNull EventObject eventObject);

    @Nullable
    Set<T> requireGeneralSnapshots(@NonNull Context context, @NonNull EventObject eventObject);

    boolean saveFragmentSnapshot(@NonNull Context context, @NonNull EventObject eventObject, @NonNull File file);
}
