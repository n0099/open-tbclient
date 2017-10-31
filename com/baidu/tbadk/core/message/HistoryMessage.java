package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class HistoryMessage extends CustomResponsedMessage<Boolean> {
    public BaseActivity Activity;
    public long cartoonId;
    public int chapterId;
    public String description;
    public String forumName;
    public boolean isHostOnly;
    public boolean isManga;
    public boolean isSquence;
    public String liveId;
    public String postID;
    public String threadId;
    public String threadName;
    public int threadType;
    public long time;
    public String userName;

    public HistoryMessage() {
        super(CmdConfigCustom.CMD_ADD_HISTORY);
        this.Activity = null;
        this.threadId = "";
        this.threadName = "";
        this.forumName = "";
        this.time = System.currentTimeMillis();
        this.postID = "";
        this.isHostOnly = false;
        this.isSquence = false;
        this.isManga = false;
        this.threadType = 0;
        this.liveId = "";
        this.userName = "";
        this.description = "";
    }
}
