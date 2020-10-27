package com.baidu.live.gift;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes4.dex */
public class c {
    public b aSL;
    public String aSM;
    public ArrayList<String> unZipFilesPathList;
    public String upZipDirPath;
    public String videoPath;

    public String getDynamicGiftId() {
        if (this.aSL == null) {
            return null;
        }
        return this.aSL.giftId;
    }

    public boolean isLandScapeZip() {
        if (this.aSL == null || this.aSL.aSJ == null) {
            return false;
        }
        return this.aSL.aSJ.isLandScape();
    }

    public String Fb() {
        File[] listFiles;
        if (!TextUtils.isEmpty(this.videoPath)) {
            return this.videoPath;
        }
        if (TextUtils.isEmpty(this.aSM) || (listFiles = new File(this.aSM).listFiles()) == null || listFiles.length == 0 || listFiles[0] == null) {
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
