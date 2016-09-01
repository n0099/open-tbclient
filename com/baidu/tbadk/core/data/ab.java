package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GraffitiRankItem;
import tbclient.GraffitiRankListInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class ab extends com.baidu.tieba.tbadkCore.data.q {
    public static final BdUniqueId Ro = BdUniqueId.gen();
    private int Rp;
    private int Rq;
    private List<UserData> Rs;
    private int Rt;
    private int Ru;
    private boolean Rv;
    private int Ry;
    private String mForumId;
    private String mThreadId;
    private boolean Rw = false;
    private boolean Rx = false;
    private List<aa> Rr = new ArrayList();

    public List<UserData> pV() {
        return this.Rs;
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

    public List<aa> getItems() {
        return this.Rr;
    }

    public void n(List<aa> list) {
        this.Rr = list;
    }

    public int pW() {
        return this.Rt;
    }

    public int pX() {
        return this.Ru;
    }

    public boolean pY() {
        return this.Rv;
    }

    public void am(boolean z) {
        this.Rv = z;
    }

    public int getRole() {
        return this.Ry;
    }

    public void bJ(int i) {
        this.Ry = i;
    }

    public boolean pZ() {
        return this.Rw;
    }

    public void an(boolean z) {
        this.Rw = z;
    }

    public boolean qa() {
        return this.Rx;
    }

    public void ao(boolean z) {
        this.Rx = z;
    }

    public void a(GraffitiRankListInfo graffitiRankListInfo) {
        if (graffitiRankListInfo != null) {
            this.Rp = graffitiRankListInfo.has_more.intValue();
            this.Rq = graffitiRankListInfo.total.intValue();
            this.Rt = graffitiRankListInfo.show_list_count.intValue();
            this.Ru = graffitiRankListInfo.quick_list_count.intValue();
            this.Rv = graffitiRankListInfo.has_state.intValue() == 1;
            if (this.Rr == null) {
                this.Rr = new ArrayList();
            }
            this.Rr.clear();
            List<GraffitiRankItem> list = graffitiRankListInfo.list;
            if (list != null) {
                for (GraffitiRankItem graffitiRankItem : list) {
                    aa aaVar = new aa();
                    aaVar.a(graffitiRankItem);
                    if (aaVar.pU()) {
                        this.Rr.add(aaVar);
                    }
                }
            }
            if (this.Rs == null) {
                this.Rs = new ArrayList();
            }
            this.Rs.clear();
            if (graffitiRankListInfo.consent_list != null) {
                for (User user : graffitiRankListInfo.consent_list) {
                    UserData userData = new UserData();
                    userData.parserProtobuf(user);
                    this.Rs.add(userData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.q, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Ro;
    }
}
