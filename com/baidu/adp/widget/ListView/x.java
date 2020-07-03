package com.baidu.adp.widget.ListView;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class x extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId Wk = BdUniqueId.gen();
    private int position = 0;
    public int resId = R.drawable.new_pic_emotion_06;
    public String showText;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return Wk;
    }
}
