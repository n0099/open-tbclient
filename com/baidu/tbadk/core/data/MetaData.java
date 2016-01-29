package com.baidu.tbadk.core.data;

import com.baidu.tbadk.core.util.ImageInfo;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MetaData extends com.baidu.tbadk.data.MetaData implements com.baidu.tbadk.core.util.ai, com.baidu.tbadk.core.util.w, TbCheckBox.b {
    private static final long serialVersionUID = -5772546803814127750L;
    private boolean mIsChecked = false;

    public ArrayList<String> getImageUrl() {
        ArrayList<IconData> iconInfo = getIconInfo();
        ArrayList<IconData> tShowInfoNew = getTShowInfoNew();
        if (iconInfo == null || tShowInfoNew == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < iconInfo.size(); i++) {
            arrayList.add(iconInfo.get(i).getIcon());
        }
        for (int i2 = 0; i2 < iconInfo.size(); i2++) {
            arrayList.add(tShowInfoNew.get(i2).getIcon());
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

    @Override // com.baidu.tbadk.core.util.ai
    public ArrayList<com.baidu.tbadk.core.util.ah> getImages() {
        ArrayList<com.baidu.tbadk.core.util.ah> arrayList = new ArrayList<>();
        com.baidu.tbadk.core.util.ah ahVar = new com.baidu.tbadk.core.util.ah();
        ahVar.imgUrl = getPortrait();
        ahVar.acq = 12;
        arrayList.add(ahVar);
        return arrayList;
    }
}
