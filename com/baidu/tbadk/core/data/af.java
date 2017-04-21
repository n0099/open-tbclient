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
    private List<UserData> WB;
    private int WC;
    private int WD;
    private boolean WE;
    private int WH;
    private int Wy;
    private int Wz;
    private String mForumId;
    private String mThreadId;
    private boolean WF = false;
    private boolean WG = false;
    private List<ae> WA = new ArrayList();

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
        return this.WA;
    }

    public void k(List<ae> list) {
        this.WA = list;
    }

    public int qS() {
        return this.WC;
    }

    public int qT() {
        return this.WD;
    }

    public boolean qU() {
        return this.WE;
    }

    public void ap(boolean z) {
        this.WE = z;
    }

    public int getRole() {
        return this.WH;
    }

    public void bG(int i) {
        this.WH = i;
    }

    public boolean qV() {
        return this.WF;
    }

    public void aq(boolean z) {
        this.WF = z;
    }

    public boolean qW() {
        return this.WG;
    }

    public void ar(boolean z) {
        this.WG = z;
    }

    public void a(GraffitiRankListInfo graffitiRankListInfo) {
        if (graffitiRankListInfo != null) {
            this.Wy = graffitiRankListInfo.has_more.intValue();
            this.Wz = graffitiRankListInfo.total.intValue();
            this.WC = graffitiRankListInfo.show_list_count.intValue();
            this.WD = graffitiRankListInfo.quick_list_count.intValue();
            this.WE = graffitiRankListInfo.has_state.intValue() == 1;
            if (this.WA == null) {
                this.WA = new ArrayList();
            }
            this.WA.clear();
            List<GraffitiRankItem> list = graffitiRankListInfo.list;
            if (list != null) {
                for (GraffitiRankItem graffitiRankItem : list) {
                    ae aeVar = new ae();
                    aeVar.a(graffitiRankItem);
                    if (aeVar.qR()) {
                        this.WA.add(aeVar);
                    }
                }
            }
            if (this.WB == null) {
                this.WB = new ArrayList();
            }
            this.WB.clear();
            if (graffitiRankListInfo.consent_list != null) {
                for (User user : graffitiRankListInfo.consent_list) {
                    UserData userData = new UserData();
                    userData.parserProtobuf(user);
                    this.WB.add(userData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }
}
