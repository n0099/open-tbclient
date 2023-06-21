package com.baidu.searchbox.task.async.privacy;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.nps.utils.Constant;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.ah;
import com.baidu.tieba.li;
import java.io.File;
import java.io.FileFilter;
/* loaded from: classes4.dex */
public class DeleteApkTask extends LaunchTask {
    public static final String DOWNLOAD_DIR = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
    public static final String QUICK_WEB_VIEW_DIR_NAME = "bdtbWCache";

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "Ignore_DeleteApkTask";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteApkFile() {
        File[] listFiles;
        File file = new File(FileHelper.getCacheDir());
        if (file.isDirectory() && (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.searchbox.task.async.privacy.DeleteApkTask.2
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                String name = file2.getName();
                if (!TextUtils.isEmpty(name) && name.contains(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f029e)) && name.endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX)) {
                    return true;
                }
                return false;
            }
        })) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    public static void deleteH5File() {
        String str = DOWNLOAD_DIR + QUICK_WEB_VIEW_DIR_NAME;
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            FileHelper.deleteFileOrDir(new File(str));
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        ah.a().b(new Runnable() { // from class: com.baidu.searchbox.task.async.privacy.DeleteApkTask.1
            @Override // java.lang.Runnable
            public void run() {
                DeleteApkTask.this.deleteApkFile();
                DeleteApkTask.deleteH5File();
                DeleteApkTask.deleteSoFile();
            }
        });
    }

    public static void deleteSoFile() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(BdBaseApplication.getInst().getFilesDir());
        sb.append(File.separator);
        if (li.a()) {
            str = "so_64_cache";
        } else {
            str = "so_cache";
        }
        sb.append(str);
        sb.append(File.separator);
        sb.append("libturbonet");
        String sb2 = sb.toString();
        File file = new File(sb2);
        if (file.exists() && file.isDirectory()) {
            FileHelper.deleteFileOrDir(new File(sb2));
        }
    }
}
