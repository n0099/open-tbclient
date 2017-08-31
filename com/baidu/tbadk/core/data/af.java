package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GraffitiRankItem;
import tbclient.GraffitiRankListInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class af extends PostData {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private int WC;
    private int WD;
    private List<UserData> WF;
    private int WG;
    private int WH;
    private boolean WI;
    private int WJ;
    private String mForumId;
    private String mThreadId;
    public boolean WK = false;
    private List<ae> WE = new ArrayList();

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
        return this.WE;
    }

    public void o(List<ae> list) {
        this.WE = list;
    }

    public int qc() {
        return this.WG;
    }

    public boolean qd() {
        return this.WI;
    }

    public void an(boolean z) {
        this.WI = z;
    }

    public int getRole() {
        return this.WJ;
    }

    public void bF(int i) {
        this.WJ = i;
    }

    public void a(GraffitiRankListInfo graffitiRankListInfo) {
        if (graffitiRankListInfo != null) {
            this.WC = graffitiRankListInfo.has_more.intValue();
            this.WD = graffitiRankListInfo.total.intValue();
            this.WG = graffitiRankListInfo.show_list_count.intValue();
            this.WH = graffitiRankListInfo.quick_list_count.intValue();
            this.WI = graffitiRankListInfo.has_state.intValue() == 1;
            if (this.WE == null) {
                this.WE = new ArrayList();
            }
            this.WE.clear();
            List<GraffitiRankItem> list = graffitiRankListInfo.list;
            if (list != null) {
                for (GraffitiRankItem graffitiRankItem : list) {
                    ae aeVar = new ae();
                    aeVar.a(graffitiRankItem);
                    if (aeVar.qb()) {
                        this.WE.add(aeVar);
                    }
                }
            }
            if (this.WF == null) {
                this.WF = new ArrayList();
            }
            this.WF.clear();
            if (graffitiRankListInfo.consent_list != null) {
                for (User user : graffitiRankListInfo.consent_list) {
                    UserData userData = new UserData();
                    userData.parserProtobuf(user);
                    this.WF.add(userData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }
}
