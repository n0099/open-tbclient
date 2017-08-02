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
    private int VU;
    private int VV;
    private List<UserData> VX;
    private int VY;
    private int VZ;
    private boolean Wa;
    private int Wb;
    private String mForumId;
    private String mThreadId;
    public boolean Wc = false;
    private List<ae> VW = new ArrayList();

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
        return this.VW;
    }

    public void o(List<ae> list) {
        this.VW = list;
    }

    public int pW() {
        return this.VY;
    }

    public boolean pX() {
        return this.Wa;
    }

    public void an(boolean z) {
        this.Wa = z;
    }

    public int getRole() {
        return this.Wb;
    }

    public void bD(int i) {
        this.Wb = i;
    }

    public void a(GraffitiRankListInfo graffitiRankListInfo) {
        if (graffitiRankListInfo != null) {
            this.VU = graffitiRankListInfo.has_more.intValue();
            this.VV = graffitiRankListInfo.total.intValue();
            this.VY = graffitiRankListInfo.show_list_count.intValue();
            this.VZ = graffitiRankListInfo.quick_list_count.intValue();
            this.Wa = graffitiRankListInfo.has_state.intValue() == 1;
            if (this.VW == null) {
                this.VW = new ArrayList();
            }
            this.VW.clear();
            List<GraffitiRankItem> list = graffitiRankListInfo.list;
            if (list != null) {
                for (GraffitiRankItem graffitiRankItem : list) {
                    ae aeVar = new ae();
                    aeVar.a(graffitiRankItem);
                    if (aeVar.pV()) {
                        this.VW.add(aeVar);
                    }
                }
            }
            if (this.VX == null) {
                this.VX = new ArrayList();
            }
            this.VX.clear();
            if (graffitiRankListInfo.consent_list != null) {
                for (User user : graffitiRankListInfo.consent_list) {
                    UserData userData = new UserData();
                    userData.parserProtobuf(user);
                    this.VX.add(userData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return TYPE;
    }
}
