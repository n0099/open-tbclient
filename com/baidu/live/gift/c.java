package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes3.dex */
public class c {
    public b aym;
    public String ayn;
    public ArrayList<String> unZipFilesPathList;
    public String upZipDirPath;
    private String videoPath;

    public String getDynamicGiftId() {
        if (this.aym == null) {
            return null;
        }
        return this.aym.giftId;
    }

    public boolean isLandScapeZip() {
        if (this.aym == null || this.aym.ayk == null) {
            return false;
        }
        return this.aym.ayk.isLandScape();
    }

    public boolean vE() {
        if (this.aym == null || this.aym.ayk == null) {
            return false;
        }
        return this.aym.ayk.vE();
    }

    public String vF() {
        File[] listFiles;
        if (!TextUtils.isEmpty(this.videoPath)) {
            return this.videoPath;
        }
        if (TextUtils.isEmpty(this.ayn) || (listFiles = new File(this.ayn).listFiles()) == null || listFiles.length == 0 || listFiles[0] == null) {
            return null;
        }
        this.videoPath = listFiles[0].getAbsolutePath();
        return this.videoPath;
    }

    public ArrayList<String> getDynamicGiftPicPathList() {
        File[] listFiles;
        if (!ListUtils.isEmpty(this.unZipFilesPathList)) {
            return this.unZipFilesPathList;
        }
        if (StringUtils.isNull(this.upZipDirPath) || (listFiles = new File(this.upZipDirPath).listFiles()) == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (File file : listFiles) {
            if (file != null && !file.isDirectory()) {
                arrayList.add(file.getAbsolutePath());
            }
        }
        Collections.sort(arrayList, new Comparator<String>() { // from class: com.baidu.live.gift.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                return str.compareTo(str2);
            }
        });
        this.unZipFilesPathList = arrayList;
        return arrayList;
    }
}
