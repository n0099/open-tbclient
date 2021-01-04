package com.baidu.tbadk.core.data;

import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import java.io.Serializable;
import java.util.List;
import tbclient.Item;
/* loaded from: classes.dex */
public class ItemData implements Serializable {
    public double mIconSize;
    public String mIconUrl;
    public double mScore;
    public int mStar;
    public List<String> mTags;
    public String mTitle;

    public void parseProto(Item item) {
        if (item != null) {
            this.mIconUrl = item.icon_url;
            this.mTitle = item.item_name;
            this.mTags = item.tags;
            this.mScore = item.score.doubleValue();
            this.mStar = item.star.intValue();
            this.mIconSize = item.icon_size.doubleValue();
        }
    }

    public void parseItemInfo(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        if (tbRichTextEvaluateItemInfo != null) {
            this.mIconUrl = tbRichTextEvaluateItemInfo.getIconUrl();
            this.mTitle = tbRichTextEvaluateItemInfo.getTitle();
            this.mTags = tbRichTextEvaluateItemInfo.getTags();
            this.mScore = tbRichTextEvaluateItemInfo.getScore();
            this.mStar = tbRichTextEvaluateItemInfo.getStar();
            this.mIconSize = tbRichTextEvaluateItemInfo.getIconSize();
        }
    }
}
