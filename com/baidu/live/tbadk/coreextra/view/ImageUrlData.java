package com.baidu.live.tbadk.coreextra.view;

import android.graphics.Rect;
import com.baidu.live.adp.lib.util.StringUtils;
import java.io.Serializable;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class ImageUrlData implements Serializable, Comparable<ImageUrlData> {
    public static final int IMAGE_TYPE_CHUDIAN = 1;
    private static final long serialVersionUID = 2037469186418617574L;
    public String id;
    public String imageUrl;
    public boolean isBlockedPic;
    private String mSourceImageRectInScreenStr;
    public byte[] mThumbBytes;
    public String originalUrl;
    public int urlType;
    public boolean mIsShowOrigonButton = true;
    public boolean isLongPic = false;
    public long originalSize = 0;
    public int originalProcess = -1;
    public long threadId = -1;
    public long postId = -1;
    public boolean mIsReserver = true;
    public boolean mIsSeeHost = false;
    public long overAllIndex = 0;
    public int mThreadType = 0;
    public int mPicType = 0;
    public String mTagName = "";

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(ImageUrlData imageUrlData) {
        return (int) (this.overAllIndex - imageUrlData.overAllIndex);
    }

    public Rect getSourceImageRectInScreen() {
        if (!StringUtils.isNull(this.mSourceImageRectInScreenStr)) {
            try {
                JSONArray jSONArray = new JSONArray(this.mSourceImageRectInScreenStr);
                if (jSONArray.length() == 4) {
                    return new Rect(((Integer) jSONArray.get(0)).intValue(), ((Integer) jSONArray.get(1)).intValue(), ((Integer) jSONArray.get(2)).intValue(), ((Integer) jSONArray.get(3)).intValue());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void setSourceImageRectInScreen(String str) {
        if (str != null) {
            this.mSourceImageRectInScreenStr = str;
        }
    }
}
