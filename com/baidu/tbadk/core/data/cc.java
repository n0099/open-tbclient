package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes.dex */
public class cc extends BaseCardInfo {
    public cb eLr;
    public int eVI;
    public int eVJ;
    public int eVK;
    public String stType;

    public cc(cb cbVar) {
        this.eLr = cbVar;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return null;
    }
}
