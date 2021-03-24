package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.widget.richText.TbRichTextEmotionInfo;
/* loaded from: classes3.dex */
public class PreLoadImageInfo extends OrmObject {
    public TbRichTextEmotionInfo bigEmotion;
    public int height;
    public String imgUrl;
    public int preloadType;
    public int procType;
    public int width;

    public String getTagForView() {
        TbRichTextEmotionInfo tbRichTextEmotionInfo = this.bigEmotion;
        if (tbRichTextEmotionInfo != null) {
            return tbRichTextEmotionInfo.mGifInfo.mSharpText;
        }
        return this.imgUrl;
    }
}
