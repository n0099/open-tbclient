package com.baidu.searchbox.task.async.appcreate;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tieba.m9;
import com.baidu.tieba.ub;
import java.util.Date;
/* loaded from: classes4.dex */
public class InitDiskTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "Ignore_InitDisk";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        TiebaDatabase.getInstance().getSdcardMainDBDatabaseManager().j(new m9.a() { // from class: com.baidu.searchbox.task.async.appcreate.InitDiskTask.1
            @Override // com.baidu.tieba.m9.a
            public void onDatabaseCreated(SQLiteDatabase sQLiteDatabase) {
                TbadkSettings.getInst().saveLong("tdatabasecreatetime", new Date().getTime());
            }
        });
        ub.f().g(TbConfig.getTempDirName());
    }
}
