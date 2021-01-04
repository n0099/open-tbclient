package com.baidu.searchbox.logsystem.basic.eventhandler;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.logsys.LogFile;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.DeviceEventSceneHandler;
import com.baidu.searchbox.logsystem.util.Utility;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class SOEventSceneSceneHandler extends DeviceEventSceneHandler {
    private static final String SO_CRASH = "UnsatisfiedLinkError";
    public static final String SO_FILE_INFO = "sofileinfo";

    @Override // com.baidu.searchbox.logsystem.logsys.eventscene.handler.BaseEventSceneHandler, com.baidu.searchbox.logsystem.logsys.eventscene.handler.EventSceneHandler
    @Nullable
    public Set<LogFile> getCustomizedSnapshots(@NonNull Context context, @NonNull File file, @NonNull EventObject eventObject) {
        if (!eventObject.mEventLog.contains(SO_CRASH)) {
            return null;
        }
        File file2 = new File(file, SO_FILE_INFO);
        if (!Utility.createNewEmptyFile(file2)) {
            return null;
        }
        HashSet hashSet = new HashSet(1);
        Utility.obtainInstalledSoInfo(context, file2);
        hashSet.add(new LogFile(file2));
        return hashSet;
    }
}
