package com.baidu.tbadk.core;

import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
/* loaded from: classes.dex */
public interface f {
    UpdateClientInfoMessage a(UpdateClientInfoMessage updateClientInfoMessage);

    boolean a(GroupNewsPojo groupNewsPojo);

    boolean ci(int i);
}
