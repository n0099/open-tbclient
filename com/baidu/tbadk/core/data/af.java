package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GraffitiRankItem;
import tbclient.GraffitiRankListInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class af extends com.baidu.tieba.tbadkCore.data.q {
    public static final BdUniqueId RQ = BdUniqueId.gen();
    private int RR;
    private int RT;
    private List<UserData> RV;
    private int RW;
    private int RX;
    private boolean RY;
    private int Sb;
    private String mForumId;
    private String mThreadId;
    private boolean RZ = false;
    private boolean Sa = false;
    private List<ae> RU = new ArrayList();

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

    public List<ae> getItems() {
        return this.RU;
    }

    public void n(List<ae> list) {
        this.RU = list;
    }

    public int qj() {
        return this.RW;
    }

    public int qk() {
        return this.RX;
    }

    public boolean ql() {
        return this.RY;
    }

    public void ao(boolean z) {
        this.RY = z;
    }

    public int getRole() {
        return this.Sb;
    }

    public void bJ(int i) {
        this.Sb = i;
    }

    public boolean qm() {
        return this.RZ;
    }

    public void ap(boolean z) {
        this.RZ = z;
    }

    public boolean qn() {
        return this.Sa;
    }

    public void aq(boolean z) {
        this.Sa = z;
    }

    public void a(GraffitiRankListInfo graffitiRankListInfo) {
        if (graffitiRankListInfo != null) {
            this.RR = graffitiRankListInfo.has_more.intValue();
            this.RT = graffitiRankListInfo.total.intValue();
            this.RW = graffitiRankListInfo.show_list_count.intValue();
            this.RX = graffitiRankListInfo.quick_list_count.intValue();
            this.RY = graffitiRankListInfo.has_state.intValue() == 1;
            if (this.RU == null) {
                this.RU = new ArrayList();
            }
            this.RU.clear();
            List<GraffitiRankItem> list = graffitiRankListInfo.list;
            if (list != null) {
                for (GraffitiRankItem graffitiRankItem : list) {
                    ae aeVar = new ae();
                    aeVar.a(graffitiRankItem);
                    if (aeVar.qi()) {
                        this.RU.add(aeVar);
                    }
                }
            }
            if (this.RV == null) {
                this.RV = new ArrayList();
            }
            this.RV.clear();
            if (graffitiRankListInfo.consent_list != null) {
                for (User user : graffitiRankListInfo.consent_list) {
                    UserData userData = new UserData();
                    userData.parserProtobuf(user);
                    this.RV.add(userData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.q, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return RQ;
    }
}
