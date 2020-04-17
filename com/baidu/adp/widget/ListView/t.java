package com.baidu.adp.widget.ListView;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class t extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId Vm = BdUniqueId.gen();
    private int position = 0;
    public int resId = R.drawable.new_pic_emotion_06;
    public String showText;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return Vm;
    }
}
