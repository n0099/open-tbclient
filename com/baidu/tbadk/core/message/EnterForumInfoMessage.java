package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* loaded from: classes3.dex */
public class EnterForumInfoMessage extends CustomResponsedMessage<List<String>> {
    public List<String> likeForumData;

    public EnterForumInfoMessage(int i, List<String> list) {
        super(2001329, list);
        this.likeForumData = list;
    }

    public List<String> getLikeForumData() {
        return this.likeForumData;
    }

    public void setLikeForumData(List<String> list) {
        this.likeForumData = list;
    }
}
