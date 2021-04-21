package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ImageInfo;
import com.baidu.tbadk.core.util.ImageProvider;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UserData extends com.baidu.tbadk.data.UserData implements TbCheckBox.c, ImageProvider, PreLoadImageProvider {
    public static final int TYPE_COMMON_ATTENTION = 1;
    public static final int TYPE_NORMAL_USER = 0;
    public static final int TYPE_OHTER_ATTENTION = 2;
    public static final int TYPE_OTHER_TITLE = 0;
    public static final String TYPE_USER = "type_user";
    public static final String TYPE_USER_NICKNAME_LEFT_DAYS = "type_user_nickname_left_days";
    public static final long serialVersionUID = -2636990595209169859L;
    public boolean isLastNewFan;
    public boolean isNewFan;
    public int mAttentionType;
    public boolean mIsChecked;

    public UserData() {
        this.mIsChecked = false;
        this.mAttentionType = 2;
    }

    @Override // com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<String> getForumPhotoUrl() {
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ImageProvider
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

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
        preLoadImageInfo.imgUrl = getPortrait();
        preLoadImageInfo.procType = 12;
        arrayList.add(preLoadImageInfo);
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<ImageInfo> getImagesWithEmotions() {
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<String> getPhotoUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(getPortrait());
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.c
    public boolean isChecked() {
        return this.mIsChecked;
    }

    @Override // com.baidu.tbadk.core.util.ImageProvider
    public boolean isSupportImageSize() {
        return false;
    }

    @Override // com.baidu.tbadk.data.UserData, com.baidu.tbadk.data.MetaData
    public void parserJson(JSONObject jSONObject) {
        super.parserJson(jSONObject);
        try {
            boolean z = true;
            if (jSONObject.optInt("is_new") != 1) {
                z = false;
            }
            this.isNewFan = z;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.c
    public void setChecked(boolean z) {
        this.mIsChecked = z;
    }

    @Override // com.baidu.tbadk.data.MetaData, d.b.i0.r.f0.q.a
    public void setIsLike(boolean z) {
        super.setIsLike(z);
        if (z) {
            return;
        }
        setHave_attention(0);
    }

    public UserData(long j, String str, String str2, int i) {
        super(j, str, str2, i);
        this.mIsChecked = false;
        this.mAttentionType = 2;
    }
}
