package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class EvaluateRelevanceItemSearchMessage extends CustomResponsedMessage<Object> {
    public String content;

    public EvaluateRelevanceItemSearchMessage(String str) {
        super(2921529);
        this.content = str;
    }
}
