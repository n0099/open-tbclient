package com.baidu.live.adp.framework.listener;

import com.baidu.live.adp.framework.message.Message;
/* loaded from: classes4.dex */
public interface NotFindTaskListener<T extends Message<?>> {
    boolean onNotFindTask(T t);
}
