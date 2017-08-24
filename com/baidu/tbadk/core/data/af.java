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
    private int XA;
    private int Xt;
    private int Xu;
    private List<UserData> Xw;
    private int Xx;
    private int Xy;
    private boolean Xz;
    private String mForumId;
    private String mThreadId;
    public boolean XB = false;
    private List<ae> Xv = new ArrayList();

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
        return this.Xv;
    }

    public void o(List<ae> list) {
        this.Xv = list;
    }

    public int qh() {
        return this.Xx;
    }

    public boolean qi() {
        return this.Xz;
    }

    public void an(boolean z) {
        this.Xz = z;
    }

    public int getRole() {
        return this.XA;
    }

    public void bF(int i) {
        this.XA = i;
    }

    public void a(GraffitiRankListInfo graffitiRankListInfo) {
        if (graffitiRankListInfo != null) {
            this.Xt = graffitiRankListInfo.has_more.intValue();
            this.Xu = graffitiRankListInfo.total.intValue();
            this.Xx = graffitiRankListInfo.show_list_count.intValue();
            this.Xy = graffitiRankListInfo.quick_list_count.intValue();
            this.Xz = graffitiRankListInfo.has_state.intValue() == 1;
            if (this.Xv == null) {
                this.Xv = new ArrayList();
            }
            this.Xv.clear();
            List<GraffitiRankItem> list = graffitiRankListInfo.list;
            if (list != null) {
                for (GraffitiRankItem graffitiRankItem : list) {
                    ae aeVar = new ae();
                    aeVar.a(graffitiRankItem);
                    if (aeVar.qg()) {
                        this.Xv.add(aeVar);
                    }
                }
            }
            if (this.Xw == null) {
                this.Xw = new ArrayList();
            }
            this.Xw.clear();
            if (graffitiRankListInfo.consent_list != null) {
                for (User user : graffitiRankListInfo.consent_list) {
                    UserData userData = new UserData();
                    userData.parserProtobuf(user);
                    this.Xw.add(userData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }
}
