package com.baidu.live.gift;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes6.dex */
public class c {
    public b VT;
    public ArrayList<String> unZipFilesPathList;
    public String upZipDirPath;

    public String getDynamicGiftId() {
        if (this.VT == null) {
            return null;
        }
        return this.VT.giftId;
    }

    public boolean isLandScapeZip() {
        if (this.VT == null || this.VT.VR == null) {
            return false;
        }
        return this.VT.VR.isLandScape();
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
