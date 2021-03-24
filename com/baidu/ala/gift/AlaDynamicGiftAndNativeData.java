package com.baidu.ala.gift;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes.dex */
public class AlaDynamicGiftAndNativeData {
    public AlaDynamicGift mAlaDynamicGift;
    public ArrayList<String> unZipFilesPathList;
    public String upZipDirPath;

    public String getDynamicGiftId() {
        AlaDynamicGift alaDynamicGift = this.mAlaDynamicGift;
        if (alaDynamicGift == null) {
            return null;
        }
        return alaDynamicGift.giftId;
    }

    public String getDynamicGiftName() {
        AlaDynamicGift alaDynamicGift = this.mAlaDynamicGift;
        if (alaDynamicGift == null) {
            return null;
        }
        return alaDynamicGift.giftName;
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
        Collections.sort(arrayList, new Comparator<String>() { // from class: com.baidu.ala.gift.AlaDynamicGiftAndNativeData.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                return str.compareTo(str2);
            }
        });
        this.unZipFilesPathList = arrayList;
        return arrayList;
    }

    public boolean isLandScapeZip() {
        AlaDynamicGiftZip alaDynamicGiftZip;
        AlaDynamicGift alaDynamicGift = this.mAlaDynamicGift;
        if (alaDynamicGift == null || (alaDynamicGiftZip = alaDynamicGift.giftZip) == null) {
            return false;
        }
        return alaDynamicGiftZip.isLandScape();
    }
}
