package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GraffitiRankItem;
import tbclient.GraffitiRankListInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class ae extends com.baidu.tieba.tbadkCore.data.q {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private int RM;
    private int RO;
    private List<UserData> RQ;
    private int RR;
    private int RS;
    private boolean RT;
    private int RW;
    private String mForumId;
    private String mThreadId;
    private boolean RU = false;
    private boolean RV = false;
    private List<ad> RP = new ArrayList();

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

    public List<ad> getItems() {
        return this.RP;
    }

    public void n(List<ad> list) {
        this.RP = list;
    }

    public int qk() {
        return this.RR;
    }

    public int ql() {
        return this.RS;
    }

    public boolean qm() {
        return this.RT;
    }

    public void ao(boolean z) {
        this.RT = z;
    }

    public int getRole() {
        return this.RW;
    }

    public void bJ(int i) {
        this.RW = i;
    }

    public boolean qn() {
        return this.RU;
    }

    public void ap(boolean z) {
        this.RU = z;
    }

    public boolean qo() {
        return this.RV;
    }

    public void aq(boolean z) {
        this.RV = z;
    }

    public void a(GraffitiRankListInfo graffitiRankListInfo) {
        if (graffitiRankListInfo != null) {
            this.RM = graffitiRankListInfo.has_more.intValue();
            this.RO = graffitiRankListInfo.total.intValue();
            this.RR = graffitiRankListInfo.show_list_count.intValue();
            this.RS = graffitiRankListInfo.quick_list_count.intValue();
            this.RT = graffitiRankListInfo.has_state.intValue() == 1;
            if (this.RP == null) {
                this.RP = new ArrayList();
            }
            this.RP.clear();
            List<GraffitiRankItem> list = graffitiRankListInfo.list;
            if (list != null) {
                for (GraffitiRankItem graffitiRankItem : list) {
                    ad adVar = new ad();
                    adVar.a(graffitiRankItem);
                    if (adVar.qj()) {
                        this.RP.add(adVar);
                    }
                }
            }
            if (this.RQ == null) {
                this.RQ = new ArrayList();
            }
            this.RQ.clear();
            if (graffitiRankListInfo.consent_list != null) {
                for (User user : graffitiRankListInfo.consent_list) {
                    UserData userData = new UserData();
                    userData.parserProtobuf(user);
                    this.RQ.add(userData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.q, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }
}
