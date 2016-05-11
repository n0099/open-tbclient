package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class x extends ax {
    public static final BdUniqueId OC = BdUniqueId.gen();
    private boolean OD;
    private String card;
    private Object cardInfo;

    public void py() {
        if (!(MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null)) {
            this.OD = false;
            return;
        }
        this.cardInfo = com.baidu.tieba.tbadkCore.v.nO(this.card);
        this.OD = this.cardInfo != null;
    }

    public Object getCardInfo() {
        return this.cardInfo;
    }

    public void setCardInfo(Object obj) {
        this.cardInfo = obj;
    }

    public boolean isValid() {
        return this.OD;
    }

    @Override // com.baidu.tbadk.core.data.ax, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return OC;
    }
}
