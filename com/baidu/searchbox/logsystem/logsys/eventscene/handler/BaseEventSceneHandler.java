package com.baidu.searchbox.logsystem.logsys.eventscene.handler;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.logsys.LogFile;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import java.io.File;
import java.util.Set;
/* loaded from: classes3.dex */
public class BaseEventSceneHandler<T> implements EventSceneHandler<T> {
    public static final String TAG = "BaseEventSceneHandler";

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    @Nullable
    public Set<LogFile> getCustomizedSnapshots(@NonNull Context context, @NonNull File file, @NonNull EventObject eventObject) {
        return null;
    }

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    @Nullable
    public Set<T> requireGeneralSnapshots(@NonNull Context context, @NonNull EventObject eventObject) {
        return null;
    }

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    public boolean saveFragmentSnapshot(@NonNull Context context, @NonNull EventObject eventObject, @NonNull File file) {
        return false;
    }
}
