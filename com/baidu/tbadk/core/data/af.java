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
    private int VE;
    private int VF;
    private List<UserData> VH;
    private int VI;
    private int VJ;
    private boolean VK;
    private int VL;
    private String mForumId;
    private String mThreadId;
    public boolean VM = false;
    private List<ae> VG = new ArrayList();

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
        return this.VG;
    }

    public void k(List<ae> list) {
        this.VG = list;
    }

    public int pW() {
        return this.VI;
    }

    public boolean pX() {
        return this.VK;
    }

    public void an(boolean z) {
        this.VK = z;
    }

    public int getRole() {
        return this.VL;
    }

    public void bE(int i) {
        this.VL = i;
    }

    public void a(GraffitiRankListInfo graffitiRankListInfo) {
        if (graffitiRankListInfo != null) {
            this.VE = graffitiRankListInfo.has_more.intValue();
            this.VF = graffitiRankListInfo.total.intValue();
            this.VI = graffitiRankListInfo.show_list_count.intValue();
            this.VJ = graffitiRankListInfo.quick_list_count.intValue();
            this.VK = graffitiRankListInfo.has_state.intValue() == 1;
            if (this.VG == null) {
                this.VG = new ArrayList();
            }
            this.VG.clear();
            List<GraffitiRankItem> list = graffitiRankListInfo.list;
            if (list != null) {
                for (GraffitiRankItem graffitiRankItem : list) {
                    ae aeVar = new ae();
                    aeVar.a(graffitiRankItem);
                    if (aeVar.pV()) {
                        this.VG.add(aeVar);
                    }
                }
            }
            if (this.VH == null) {
                this.VH = new ArrayList();
            }
            this.VH.clear();
            if (graffitiRankListInfo.consent_list != null) {
                for (User user : graffitiRankListInfo.consent_list) {
                    UserData userData = new UserData();
                    userData.parserProtobuf(user);
                    this.VH.add(userData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return TYPE;
    }
}
