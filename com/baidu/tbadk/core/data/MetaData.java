package com.baidu.tbadk.core.data;

import com.baidu.tbadk.core.util.ImageInfo;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.data.IconData;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MetaData extends com.baidu.tbadk.data.MetaData implements aa, av, com.baidu.tbadk.core.view.u {
    private static final long serialVersionUID = -5772546803814127750L;
    private boolean mIsChecked = false;

    public LinkedList<String> getImageUrl() {
        LinkedList<IconData> iconInfo = getIconInfo();
        LinkedList<IconData> tShowInfo = getTShowInfo();
        if (iconInfo == null || tShowInfo == null) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < iconInfo.size(); i++) {
            linkedList.add(iconInfo.get(i).getIcon());
        }
        for (int i2 = 0; i2 < iconInfo.size(); i2++) {
            linkedList.add(tShowInfo.get(i2).getIcon());
        }
        return linkedList;
    }

    public LinkedList<String> getPhotoUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(getPortrait());
        return linkedList;
    }

    @Override // com.baidu.tbadk.core.view.u
    public boolean isChecked() {
        return this.mIsChecked;
    }

    @Override // com.baidu.tbadk.core.view.u
    public void setChecked(boolean z) {
        this.mIsChecked = z;
    }

    public boolean isSupportImageSize() {
        return false;
    }

    public LinkedList<ImageInfo> getImagesWithEmotions() {
        return null;
    }

    public LinkedList<String> getForumPhotoUrl() {
        return null;
    }

    @Override // com.baidu.tbadk.core.util.av
    public LinkedList<au> getImages() {
        LinkedList<au> linkedList = new LinkedList<>();
        au auVar = new au();
        auVar.a = getPortrait();
        auVar.d = 12;
        linkedList.add(auVar);
        return linkedList;
    }
}
