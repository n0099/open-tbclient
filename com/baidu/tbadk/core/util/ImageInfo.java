package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.widget.richText.TbRichTextEmotionInfo;
/* loaded from: classes3.dex */
public class ImageInfo extends OrmObject {
    public TbRichTextEmotionInfo bigEmotion;
    public String bubbleUrl;
    public int height;
    public String imgUrl;
    public int width;

    public String getTagForView() {
        TbRichTextEmotionInfo tbRichTextEmotionInfo = this.bigEmotion;
        if (tbRichTextEmotionInfo != null) {
            return tbRichTextEmotionInfo.mGifInfo.mSharpText;
        }
        String str = this.bubbleUrl;
        return str != null ? str : this.imgUrl;
    }
}
