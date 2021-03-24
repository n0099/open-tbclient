package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class ConfigChangeMessage extends CustomResponsedMessage<Boolean> {
    public ConfigChangeMessage(Boolean bool) {
        super(2001015, bool);
    }
}
