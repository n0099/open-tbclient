package com.baidu.tbadk.core.data;

import com.baidu.tbadk.core.util.ImageInfo;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MetaData extends com.baidu.tbadk.data.MetaData implements ae, com.baidu.tbadk.core.util.t, TbCheckBox.b {
    private static final long serialVersionUID = -5772546803814127750L;
    private boolean mIsChecked = false;

    public ArrayList<String> getImageUrl() {
        ArrayList<IconData> iconInfo = getIconInfo();
        ArrayList<IconData> tShowInfo = getTShowInfo();
        if (iconInfo == null || tShowInfo == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < iconInfo.size(); i++) {
            arrayList.add(iconInfo.get(i).getIcon());
        }
        for (int i2 = 0; i2 < iconInfo.size(); i2++) {
            arrayList.add(tShowInfo.get(i2).getIcon());
        }
        return arrayList;
    }

    public ArrayList<String> getPhotoUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(getPortrait());
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.b
    public boolean isChecked() {
        return this.mIsChecked;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.b
    public void setChecked(boolean z) {
        this.mIsChecked = z;
    }

    public boolean isSupportImageSize() {
        return false;
    }

    public ArrayList<ImageInfo> getImagesWithEmotions() {
        return null;
    }

    public ArrayList<String> getForumPhotoUrl() {
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<ad> getImages() {
        ArrayList<ad> arrayList = new ArrayList<>();
        ad adVar = new ad();
        adVar.Wd = getPortrait();
        adVar.aaD = 12;
        arrayList.add(adVar);
        return arrayList;
    }
}
