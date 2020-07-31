package com.baidu.live.t;

import android.graphics.drawable.Drawable;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.util.IResourceAdapter;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.y.a;
/* loaded from: classes4.dex */
public class a implements IResourceAdapter {
    @Override // com.baidu.live.tbadk.util.IResourceAdapter
    public Drawable getEmotionDrawable(CommonEmptyView.ImgType imgType, CommonEmptyView.StyleType styleType) {
        int i = 0;
        if (styleType == CommonEmptyView.StyleType.DARK) {
            if (imgType == CommonEmptyView.ImgType.NO_NET) {
                i = a.b.sdk_pic_live_empty01_d_tb;
            } else if (imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                i = a.b.sdk_pic_live_empty02_d_tb;
            } else if (imgType == CommonEmptyView.ImgType.NO_DATA) {
                i = a.b.sdk_pic_live_empty03_d_tb;
            } else if (imgType == CommonEmptyView.ImgType.NO_RANK_LIST) {
                i = a.b.sdk_pic_live_empty04_d_tb;
            } else if (imgType == CommonEmptyView.ImgType.NO_FOLLOW) {
                i = a.b.sdk_pic_live_empty05_d_tb;
            } else if (imgType == CommonEmptyView.ImgType.NO_FAN) {
                i = a.b.sdk_pic_live_empty06_d_tb;
            }
        } else if (imgType == CommonEmptyView.ImgType.NO_NET) {
            i = a.b.sdk_pic_live_empty01_tb;
        } else if (imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
            i = a.b.sdk_pic_live_empty02_tb;
        } else if (imgType == CommonEmptyView.ImgType.NO_DATA) {
            i = a.b.sdk_pic_live_empty03_tb;
        } else if (imgType == CommonEmptyView.ImgType.NO_RANK_LIST) {
            i = a.b.sdk_pic_live_empty04_tb;
        } else if (imgType == CommonEmptyView.ImgType.NO_FOLLOW) {
            i = a.b.sdk_pic_live_empty05_tb;
        } else if (imgType == CommonEmptyView.ImgType.NO_FAN) {
            i = a.b.sdk_pic_live_empty06_tb;
        }
        if (i == 0) {
            return null;
        }
        try {
            return TbadkCoreApplication.getInst().getResources().getDrawable(i);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
