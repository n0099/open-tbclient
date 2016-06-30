package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GraffitiRankItem;
import tbclient.GraffitiRankListInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class x extends com.baidu.tieba.tbadkCore.data.s {
    public static final BdUniqueId Op = BdUniqueId.gen();
    private int Oq;
    private int Or;
    private List<UserData> Ot;
    private int Ou;
    private int Ov;
    private boolean Ow;
    private int Oz;
    private String mForumId;
    private String mThreadId;
    private boolean Ox = false;
    private boolean Oy = false;
    private List<w> Os = new ArrayList();

    public List<UserData> pj() {
        return this.Ot;
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

    public List<w> getItems() {
        return this.Os;
    }

    public void n(List<w> list) {
        this.Os = list;
    }

    public int pk() {
        return this.Ou;
    }

    public int pl() {
        return this.Ov;
    }

    public boolean pm() {
        return this.Ow;
    }

    public void ai(boolean z) {
        this.Ow = z;
    }

    public int getRole() {
        return this.Oz;
    }

    public void bx(int i) {
        this.Oz = i;
    }

    public boolean pn() {
        return this.Ox;
    }

    public void aj(boolean z) {
        this.Ox = z;
    }

    public boolean po() {
        return this.Oy;
    }

    public void ak(boolean z) {
        this.Oy = z;
    }

    public void a(GraffitiRankListInfo graffitiRankListInfo) {
        if (graffitiRankListInfo != null) {
            this.Oq = graffitiRankListInfo.has_more.intValue();
            this.Or = graffitiRankListInfo.total.intValue();
            this.Ou = graffitiRankListInfo.show_list_count.intValue();
            this.Ov = graffitiRankListInfo.quick_list_count.intValue();
            this.Ow = graffitiRankListInfo.has_state.intValue() == 1;
            if (this.Os == null) {
                this.Os = new ArrayList();
            }
            this.Os.clear();
            List<GraffitiRankItem> list = graffitiRankListInfo.list;
            if (list != null) {
                for (GraffitiRankItem graffitiRankItem : list) {
                    w wVar = new w();
                    wVar.a(graffitiRankItem);
                    if (wVar.pi()) {
                        this.Os.add(wVar);
                    }
                }
            }
            if (this.Ot == null) {
                this.Ot = new ArrayList();
            }
            this.Ot.clear();
            if (graffitiRankListInfo.consent_list != null) {
                for (User user : graffitiRankListInfo.consent_list) {
                    UserData userData = new UserData();
                    userData.parserProtobuf(user);
                    this.Ot.add(userData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.s, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Op;
    }
}
