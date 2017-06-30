package com.baidu.tbadk.core.data;

import com.baidu.tbadk.core.util.ImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class UserData extends com.baidu.tbadk.data.UserData implements com.baidu.tbadk.core.util.aj, com.baidu.tbadk.core.util.y, TbCheckBox.b {
    public static final int TYPE_COMMON_ATTENTION = 1;
    public static final int TYPE_NORMAL_USER = 0;
    public static final int TYPE_OHTER_ATTENTION = 2;
    public static final int TYPE_OTHER_TITLE = 0;
    public static final String TYPE_USER = "type_user";
    public static final String TYPE_USER_NICKNAME_LEFT_DAYS = "type_user_nickname_left_days";
    private static final long serialVersionUID = -2636990595209169859L;
    public int mAttentionType;
    private boolean mIsChecked;

    public UserData() {
        this.mIsChecked = false;
        this.mAttentionType = 2;
    }

    public UserData(long j, String str, String str2, int i) {
        super(j, str, str2, i);
        this.mIsChecked = false;
        this.mAttentionType = 2;
    }

    public boolean isSupportImageSize() {
        return false;
    }

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

    public ArrayList<ImageInfo> getImagesWithEmotions() {
        return null;
    }

    public ArrayList<String> getPhotoUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(getPortrait());
        return arrayList;
    }

    public ArrayList<String> getForumPhotoUrl() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.b
    public boolean isChecked() {
        return this.mIsChecked;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.b
    public void setChecked(boolean z) {
        this.mIsChecked = z;
    }

    @Override // com.baidu.tbadk.core.util.aj
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
        preLoadImageInfo.imgUrl = getPortrait();
        preLoadImageInfo.procType = 12;
        arrayList.add(preLoadImageInfo);
        return arrayList;
    }
}
