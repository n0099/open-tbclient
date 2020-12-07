package com.baidu.adp.widget.ListView;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes.dex */
public class z extends BaseCardInfo {
    public static final BdUniqueId Yt = BdUniqueId.gen();
    private int position = 0;
    public int resId = R.drawable.new_pic_emotion_06;
    public String showText;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return Yt;
    }
}
