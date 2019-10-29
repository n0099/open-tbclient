package com.baidu.live.adp.framework.listener;

import com.baidu.live.adp.framework.message.Message;
/* loaded from: classes6.dex */
public interface NotFindTaskListener<T extends Message<?>> {
    boolean onNotFindTask(T t);
}
