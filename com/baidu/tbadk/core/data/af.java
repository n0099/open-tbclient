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
    private List<UserData> WA;
    private int WB;
    private int WC;
    private boolean WD;
    private int WG;
    private int Wx;
    private int Wy;
    private String mForumId;
    private String mThreadId;
    private boolean WE = false;
    private boolean WF = false;
    private List<ae> Wz = new ArrayList();

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
        return this.Wz;
    }

    public void k(List<ae> list) {
        this.Wz = list;
    }

    public int qS() {
        return this.WB;
    }

    public int qT() {
        return this.WC;
    }

    public boolean qU() {
        return this.WD;
    }

    public void ap(boolean z) {
        this.WD = z;
    }

    public int getRole() {
        return this.WG;
    }

    public void bG(int i) {
        this.WG = i;
    }

    public boolean qV() {
        return this.WE;
    }

    public void aq(boolean z) {
        this.WE = z;
    }

    public boolean qW() {
        return this.WF;
    }

    public void ar(boolean z) {
        this.WF = z;
    }

    public void a(GraffitiRankListInfo graffitiRankListInfo) {
        if (graffitiRankListInfo != null) {
            this.Wx = graffitiRankListInfo.has_more.intValue();
            this.Wy = graffitiRankListInfo.total.intValue();
            this.WB = graffitiRankListInfo.show_list_count.intValue();
            this.WC = graffitiRankListInfo.quick_list_count.intValue();
            this.WD = graffitiRankListInfo.has_state.intValue() == 1;
            if (this.Wz == null) {
                this.Wz = new ArrayList();
            }
            this.Wz.clear();
            List<GraffitiRankItem> list = graffitiRankListInfo.list;
            if (list != null) {
                for (GraffitiRankItem graffitiRankItem : list) {
                    ae aeVar = new ae();
                    aeVar.a(graffitiRankItem);
                    if (aeVar.qR()) {
                        this.Wz.add(aeVar);
                    }
                }
            }
            if (this.WA == null) {
                this.WA = new ArrayList();
            }
            this.WA.clear();
            if (graffitiRankListInfo.consent_list != null) {
                for (User user : graffitiRankListInfo.consent_list) {
                    UserData userData = new UserData();
                    userData.parserProtobuf(user);
                    this.WA.add(userData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }
}
