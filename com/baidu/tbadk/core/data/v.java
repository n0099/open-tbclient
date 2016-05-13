package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GraffitiRankItem;
import tbclient.GraffitiRankListInfo;
/* loaded from: classes.dex */
public class v extends com.baidu.tieba.tbadkCore.data.s {
    public static final BdUniqueId Oq = BdUniqueId.gen();
    private int Or;
    private int Os;
    private int Ou;
    private int Ov;
    private boolean Ow;
    private int Oz;
    private String mForumId;
    private String mThreadId;
    private boolean Ox = false;
    private boolean Oy = false;
    private List<u> Ot = new ArrayList();

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
        return this.Ot;
    }

    public void setItems(List<u> list) {
        this.Ot = list;
    }

    public int pr() {
        return this.Ou;
    }

    public int ps() {
        return this.Ov;
    }

    public boolean pt() {
        return this.Ow;
    }

    public void ak(boolean z) {
        this.Ow = z;
    }

    public int getRole() {
        return this.Oz;
    }

    public void bw(int i) {
        this.Oz = i;
    }

    public boolean pu() {
        return this.Ox;
    }

    public void al(boolean z) {
        this.Ox = z;
    }

    public boolean pv() {
        return this.Oy;
    }

    public void am(boolean z) {
        this.Oy = z;
    }

    public void a(GraffitiRankListInfo graffitiRankListInfo) {
        if (graffitiRankListInfo != null) {
            this.Or = graffitiRankListInfo.has_more.intValue();
            this.Os = graffitiRankListInfo.total.intValue();
            this.Ou = graffitiRankListInfo.show_list_count.intValue();
            this.Ov = graffitiRankListInfo.quick_list_count.intValue();
            this.Ow = graffitiRankListInfo.has_state.intValue() == 1;
            if (this.Ot == null) {
                this.Ot = new ArrayList();
            }
            this.Ot.clear();
            List<GraffitiRankItem> list = graffitiRankListInfo.list;
            if (list != null) {
                for (GraffitiRankItem graffitiRankItem : list) {
                    u uVar = new u();
                    uVar.a(graffitiRankItem);
                    if (uVar.pq()) {
                        this.Ot.add(uVar);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.s, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Oq;
    }
}
