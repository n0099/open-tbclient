package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.List;
/* loaded from: classes.dex */
public class EnterForumInfoMessage extends CustomResponsedMessage<List<String>> {
    private List<String> likeForumData;

    public List<String> getLikeForumData() {
        return this.likeForumData;
    }

    public void setLikeForumData(List<String> list) {
        this.likeForumData = list;
    }

    public EnterForumInfoMessage(int i, List<String> list) {
        super(CmdConfigCustom.CMD_ENTER_FORUM_INFO, list);
        this.likeForumData = list;
    }
}
