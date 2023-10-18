package com.baidu.searchbox.launched;

import java.util.List;
/* loaded from: classes4.dex */
public class RuleNode {
    public List<RuleNode> mChildParts;
    public String mName;

    public RuleNode(String str) {
        this.mName = str;
    }

    public void setChildParts(List<RuleNode> list) {
        this.mChildParts = list;
    }

    public List<RuleNode> getChildParts() {
        return this.mChildParts;
    }

    public String getName() {
        return this.mName;
    }
}
