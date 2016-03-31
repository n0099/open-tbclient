package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GraffitiRankItem;
import tbclient.GraffitiRankListInfo;
/* loaded from: classes.dex */
public class v extends com.baidu.tieba.tbadkCore.data.s {
    public static final BdUniqueId TC = BdUniqueId.gen();
    private int TD;
    private int TE;
    private int TG;
    private int TH;
    private boolean TI;
    private int TL;
    private String mForumId;
    private String mThreadId;
    private boolean TJ = false;
    private boolean TK = false;
    private List<u> TF = new ArrayList();

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    public String getForumId() {
        return this.mForumId;
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public List<u> getItems() {
        return this.TF;
    }

    public void setItems(List<u> list) {
        this.TF = list;
    }

    public int rY() {
        return this.TG;
    }

    public int rZ() {
        return this.TH;
    }

    public boolean sa() {
        return this.TI;
    }

    public void ah(boolean z) {
        this.TI = z;
    }

    public int getRole() {
        return this.TL;
    }

    public void bL(int i) {
        this.TL = i;
    }

    public boolean sb() {
        return this.TJ;
    }

    public void ai(boolean z) {
        this.TJ = z;
    }

    public boolean sc() {
        return this.TK;
    }

    public void aj(boolean z) {
        this.TK = z;
    }

    public void a(GraffitiRankListInfo graffitiRankListInfo) {
        if (graffitiRankListInfo != null) {
            this.TD = graffitiRankListInfo.has_more.intValue();
            this.TE = graffitiRankListInfo.total.intValue();
            this.TG = graffitiRankListInfo.show_list_count.intValue();
            this.TH = graffitiRankListInfo.quick_list_count.intValue();
            this.TI = graffitiRankListInfo.has_state.intValue() == 1;
            if (this.TF == null) {
                this.TF = new ArrayList();
            }
            this.TF.clear();
            List<GraffitiRankItem> list = graffitiRankListInfo.list;
            if (list != null) {
                for (GraffitiRankItem graffitiRankItem : list) {
                    u uVar = new u();
                    uVar.a(graffitiRankItem);
                    if (uVar.rX()) {
                        this.TF.add(uVar);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.s, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return TC;
    }
}
