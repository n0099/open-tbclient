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
    private int VR;
    private int VS;
    private List<ae> VT = new ArrayList();
    private List<UserData> VU;
    private int VV;
    private int VW;
    private boolean VX;
    private int VY;
    private String mForumId;
    private String mThreadId;

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
        return this.VT;
    }

    public void k(List<ae> list) {
        this.VT = list;
    }

    public int qf() {
        return this.VV;
    }

    public boolean qg() {
        return this.VX;
    }

    public void ao(boolean z) {
        this.VX = z;
    }

    public int getRole() {
        return this.VY;
    }

    public void bD(int i) {
        this.VY = i;
    }

    public void a(GraffitiRankListInfo graffitiRankListInfo) {
        if (graffitiRankListInfo != null) {
            this.VR = graffitiRankListInfo.has_more.intValue();
            this.VS = graffitiRankListInfo.total.intValue();
            this.VV = graffitiRankListInfo.show_list_count.intValue();
            this.VW = graffitiRankListInfo.quick_list_count.intValue();
            this.VX = graffitiRankListInfo.has_state.intValue() == 1;
            if (this.VT == null) {
                this.VT = new ArrayList();
            }
            this.VT.clear();
            List<GraffitiRankItem> list = graffitiRankListInfo.list;
            if (list != null) {
                for (GraffitiRankItem graffitiRankItem : list) {
                    ae aeVar = new ae();
                    aeVar.a(graffitiRankItem);
                    if (aeVar.qe()) {
                        this.VT.add(aeVar);
                    }
                }
            }
            if (this.VU == null) {
                this.VU = new ArrayList();
            }
            this.VU.clear();
            if (graffitiRankListInfo.consent_list != null) {
                for (User user : graffitiRankListInfo.consent_list) {
                    UserData userData = new UserData();
                    userData.parserProtobuf(user);
                    this.VU.add(userData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }
}
