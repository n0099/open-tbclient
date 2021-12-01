package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class HistoryMessage extends CustomResponsedMessage<Boolean> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext Activity;
    public long cartoonId;
    public int chapterId;
    public String description;
    public String forumName;
    public boolean isHostOnly;
    public boolean isManga;
    public boolean isShareThread;
    public boolean isSquence;
    public String liveId;
    public String postID;
    public String threadId;
    public String threadName;
    public int threadType;
    public long time;
    public String userName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoryMessage() {
        super(2001278);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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
