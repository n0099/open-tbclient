package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* loaded from: classes.dex */
public class EvaluateRelevanceItemUpdatedMessage extends CustomResponsedMessage<Object> {
    public List<String> tabs;

    public EvaluateRelevanceItemUpdatedMessage(List<String> list) {
        super(2921522);
        this.tabs = list;
    }
}
