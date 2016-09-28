package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GraffitiRankItem;
import tbclient.GraffitiRankListInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class ad extends com.baidu.tieba.tbadkCore.data.q {
    public static final BdUniqueId Ru = BdUniqueId.gen();
    private int RA;
    private boolean RB;
    private int RE;
    private int Rv;
    private int Rw;
    private List<UserData> Ry;
    private int Rz;
    private String mForumId;
    private String mThreadId;
    private boolean RC = false;
    private boolean RD = false;
    private List<ac> Rx = new ArrayList();

    public List<UserData> qg() {
        return this.Ry;
    }

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

    public List<ac> getItems() {
        return this.Rx;
    }

    public void n(List<ac> list) {
        this.Rx = list;
    }

    public int qh() {
        return this.Rz;
    }

    public int qi() {
        return this.RA;
    }

    public boolean qj() {
        return this.RB;
    }

    public void am(boolean z) {
        this.RB = z;
    }

    public int getRole() {
        return this.RE;
    }

    public void bJ(int i) {
        this.RE = i;
    }

    public boolean qk() {
        return this.RC;
    }

    public void an(boolean z) {
        this.RC = z;
    }

    public boolean ql() {
        return this.RD;
    }

    public void ao(boolean z) {
        this.RD = z;
    }

    public void a(GraffitiRankListInfo graffitiRankListInfo) {
        if (graffitiRankListInfo != null) {
            this.Rv = graffitiRankListInfo.has_more.intValue();
            this.Rw = graffitiRankListInfo.total.intValue();
            this.Rz = graffitiRankListInfo.show_list_count.intValue();
            this.RA = graffitiRankListInfo.quick_list_count.intValue();
            this.RB = graffitiRankListInfo.has_state.intValue() == 1;
            if (this.Rx == null) {
                this.Rx = new ArrayList();
            }
            this.Rx.clear();
            List<GraffitiRankItem> list = graffitiRankListInfo.list;
            if (list != null) {
                for (GraffitiRankItem graffitiRankItem : list) {
                    ac acVar = new ac();
                    acVar.a(graffitiRankItem);
                    if (acVar.qf()) {
                        this.Rx.add(acVar);
                    }
                }
            }
            if (this.Ry == null) {
                this.Ry = new ArrayList();
            }
            this.Ry.clear();
            if (graffitiRankListInfo.consent_list != null) {
                for (User user : graffitiRankListInfo.consent_list) {
                    UserData userData = new UserData();
                    userData.parserProtobuf(user);
                    this.Ry.add(userData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.q, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Ru;
    }
}
