package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GraffitiRankItem;
import tbclient.GraffitiRankListInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class af extends com.baidu.tieba.tbadkCore.data.p {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    private int QW;
    private int QX;
    private List<UserData> QZ;
    private int Ra;
    private int Rb;
    private boolean Rc;
    private int Rf;
    private String mForumId;
    private String mThreadId;
    private boolean Rd = false;
    private boolean Re = false;
    private List<ae> QY = new ArrayList();

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
        return this.QY;
    }

    public void m(List<ae> list) {
        this.QY = list;
    }

    public int qd() {
        return this.Ra;
    }

    public int qe() {
        return this.Rb;
    }

    public boolean qf() {
        return this.Rc;
    }

    public void ao(boolean z) {
        this.Rc = z;
    }

    public int getRole() {
        return this.Rf;
    }

    public void bI(int i) {
        this.Rf = i;
    }

    public boolean qg() {
        return this.Rd;
    }

    public void ap(boolean z) {
        this.Rd = z;
    }

    public boolean qh() {
        return this.Re;
    }

    public void aq(boolean z) {
        this.Re = z;
    }

    public void a(GraffitiRankListInfo graffitiRankListInfo) {
        if (graffitiRankListInfo != null) {
            this.QW = graffitiRankListInfo.has_more.intValue();
            this.QX = graffitiRankListInfo.total.intValue();
            this.Ra = graffitiRankListInfo.show_list_count.intValue();
            this.Rb = graffitiRankListInfo.quick_list_count.intValue();
            this.Rc = graffitiRankListInfo.has_state.intValue() == 1;
            if (this.QY == null) {
                this.QY = new ArrayList();
            }
            this.QY.clear();
            List<GraffitiRankItem> list = graffitiRankListInfo.list;
            if (list != null) {
                for (GraffitiRankItem graffitiRankItem : list) {
                    ae aeVar = new ae();
                    aeVar.a(graffitiRankItem);
                    if (aeVar.qc()) {
                        this.QY.add(aeVar);
                    }
                }
            }
            if (this.QZ == null) {
                this.QZ = new ArrayList();
            }
            this.QZ.clear();
            if (graffitiRankListInfo.consent_list != null) {
                for (User user : graffitiRankListInfo.consent_list) {
                    UserData userData = new UserData();
                    userData.parserProtobuf(user);
                    this.QZ.add(userData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.p, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }
}
