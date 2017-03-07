package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GraffitiRankItem;
import tbclient.GraffitiRankListInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class ag extends PostData {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private int Wi;
    private int Wj;
    private List<UserData> Wl;
    private int Wm;
    private int Wn;
    private boolean Wo;
    private int Wr;
    private String mForumId;
    private String mThreadId;
    private boolean Wp = false;
    private boolean Wq = false;
    private List<af> Wk = new ArrayList();

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

    public List<af> getItems() {
        return this.Wk;
    }

    public void k(List<af> list) {
        this.Wk = list;
    }

    public int qv() {
        return this.Wm;
    }

    public int qw() {
        return this.Wn;
    }

    public boolean qx() {
        return this.Wo;
    }

    public void an(boolean z) {
        this.Wo = z;
    }

    public int getRole() {
        return this.Wr;
    }

    public void bD(int i) {
        this.Wr = i;
    }

    public boolean qy() {
        return this.Wp;
    }

    public void ao(boolean z) {
        this.Wp = z;
    }

    public boolean qz() {
        return this.Wq;
    }

    public void ap(boolean z) {
        this.Wq = z;
    }

    public void a(GraffitiRankListInfo graffitiRankListInfo) {
        if (graffitiRankListInfo != null) {
            this.Wi = graffitiRankListInfo.has_more.intValue();
            this.Wj = graffitiRankListInfo.total.intValue();
            this.Wm = graffitiRankListInfo.show_list_count.intValue();
            this.Wn = graffitiRankListInfo.quick_list_count.intValue();
            this.Wo = graffitiRankListInfo.has_state.intValue() == 1;
            if (this.Wk == null) {
                this.Wk = new ArrayList();
            }
            this.Wk.clear();
            List<GraffitiRankItem> list = graffitiRankListInfo.list;
            if (list != null) {
                for (GraffitiRankItem graffitiRankItem : list) {
                    af afVar = new af();
                    afVar.a(graffitiRankItem);
                    if (afVar.qu()) {
                        this.Wk.add(afVar);
                    }
                }
            }
            if (this.Wl == null) {
                this.Wl = new ArrayList();
            }
            this.Wl.clear();
            if (graffitiRankListInfo.consent_list != null) {
                for (User user : graffitiRankListInfo.consent_list) {
                    UserData userData = new UserData();
                    userData.parserProtobuf(user);
                    this.Wl.add(userData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }
}
