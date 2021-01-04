package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class EvaluateRelevanceItemSearchMessage extends CustomResponsedMessage<Object> {
    public String content;

    public EvaluateRelevanceItemSearchMessage(String str) {
        super(2921528);
        this.content = str;
    }
}
