package com.baidu.tbadk.core.data;

import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.data.IconData;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MetaData extends com.baidu.tbadk.data.MetaData implements ai, bg, com.baidu.tbadk.core.view.p {
    private static final long serialVersionUID = -5772546803814127750L;
    private boolean mIsChecked = false;

    @Override // com.baidu.tbadk.core.util.ai
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

    @Override // com.baidu.tbadk.core.util.ai
    public LinkedList<String> getPhotoUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(getPortrait());
        return linkedList;
    }

    @Override // com.baidu.tbadk.core.view.p
    public boolean isChecked() {
        return this.mIsChecked;
    }

    @Override // com.baidu.tbadk.core.view.p
    public void setChecked(boolean z) {
        this.mIsChecked = z;
    }

    @Override // com.baidu.tbadk.core.util.ai
    public boolean isSupportImageSize() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.ai
    public LinkedList<ad> getImagesWithEmotions() {
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ai
    public LinkedList<String> getForumPhotoUrl() {
        return null;
    }

    @Override // com.baidu.tbadk.core.util.bg
    public LinkedList<bf> getImages() {
        LinkedList<bf> linkedList = new LinkedList<>();
        bf bfVar = new bf();
        bfVar.a = getPortrait();
        bfVar.d = 12;
        linkedList.add(bfVar);
        return linkedList;
    }
}
