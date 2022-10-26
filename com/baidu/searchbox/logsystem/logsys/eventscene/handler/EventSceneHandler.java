package com.baidu.searchbox.logsystem.logsys.eventscene.handler;

import android.content.Context;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import java.io.File;
import java.util.Set;
/* loaded from: classes2.dex */
public interface EventSceneHandler {
    Set getCustomizedSnapshots(Context context, File file, EventObject eventObject);

    Set requireGeneralSnapshots(Context context, EventObject eventObject);

    boolean saveFragmentSnapshot(Context context, EventObject eventObject, File file);
}
