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
    private int Xq;
    private int Xr;
    private List<UserData> Xt;
    private int Xu;
    private int Xv;
    private boolean Xw;
    private int Xx;
    private String mForumId;
    private String mThreadId;
    public boolean Xy = false;
    private List<ae> Xs = new ArrayList();

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
        return this.Xs;
    }

    public void o(List<ae> list) {
        this.Xs = list;
    }

    public int qg() {
        return this.Xu;
    }

    public boolean qh() {
        return this.Xw;
    }

    public void an(boolean z) {
        this.Xw = z;
    }

    public int getRole() {
        return this.Xx;
    }

    public void bF(int i) {
        this.Xx = i;
    }

    public void a(GraffitiRankListInfo graffitiRankListInfo) {
        if (graffitiRankListInfo != null) {
            this.Xq = graffitiRankListInfo.has_more.intValue();
            this.Xr = graffitiRankListInfo.total.intValue();
            this.Xu = graffitiRankListInfo.show_list_count.intValue();
            this.Xv = graffitiRankListInfo.quick_list_count.intValue();
            this.Xw = graffitiRankListInfo.has_state.intValue() == 1;
            if (this.Xs == null) {
                this.Xs = new ArrayList();
            }
            this.Xs.clear();
            List<GraffitiRankItem> list = graffitiRankListInfo.list;
            if (list != null) {
                for (GraffitiRankItem graffitiRankItem : list) {
                    ae aeVar = new ae();
                    aeVar.a(graffitiRankItem);
                    if (aeVar.qf()) {
                        this.Xs.add(aeVar);
                    }
                }
            }
            if (this.Xt == null) {
                this.Xt = new ArrayList();
            }
            this.Xt.clear();
            if (graffitiRankListInfo.consent_list != null) {
                for (User user : graffitiRankListInfo.consent_list) {
                    UserData userData = new UserData();
                    userData.parserProtobuf(user);
                    this.Xt.add(userData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }
}
