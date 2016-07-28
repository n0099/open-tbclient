package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GraffitiRankItem;
import tbclient.GraffitiRankListInfo;
import tbclient.User;
/* loaded from: classes.dex */
public class aa extends com.baidu.tieba.tbadkCore.data.s {
    public static final BdUniqueId OB = BdUniqueId.gen();
    private int OC;
    private int OD;
    private List<UserData> OF;
    private int OG;
    private int OH;
    private boolean OI;
    private int OM;
    private String mForumId;
    private String mThreadId;
    private boolean OJ = false;
    private boolean OL = false;
    private List<z> OE = new ArrayList();

    public List<UserData> oS() {
        return this.OF;
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

    public List<z> getItems() {
        return this.OE;
    }

    public void n(List<z> list) {
        this.OE = list;
    }

    public int oT() {
        return this.OG;
    }

    public int oU() {
        return this.OH;
    }

    public boolean oV() {
        return this.OI;
    }

    public void ak(boolean z) {
        this.OI = z;
    }

    public int getRole() {
        return this.OM;
    }

    public void bw(int i) {
        this.OM = i;
    }

    public boolean oW() {
        return this.OJ;
    }

    public void al(boolean z) {
        this.OJ = z;
    }

    public boolean oX() {
        return this.OL;
    }

    public void am(boolean z) {
        this.OL = z;
    }

    public void a(GraffitiRankListInfo graffitiRankListInfo) {
        if (graffitiRankListInfo != null) {
            this.OC = graffitiRankListInfo.has_more.intValue();
            this.OD = graffitiRankListInfo.total.intValue();
            this.OG = graffitiRankListInfo.show_list_count.intValue();
            this.OH = graffitiRankListInfo.quick_list_count.intValue();
            this.OI = graffitiRankListInfo.has_state.intValue() == 1;
            if (this.OE == null) {
                this.OE = new ArrayList();
            }
            this.OE.clear();
            List<GraffitiRankItem> list = graffitiRankListInfo.list;
            if (list != null) {
                for (GraffitiRankItem graffitiRankItem : list) {
                    z zVar = new z();
                    zVar.a(graffitiRankItem);
                    if (zVar.oR()) {
                        this.OE.add(zVar);
                    }
                }
            }
            if (this.OF == null) {
                this.OF = new ArrayList();
            }
            this.OF.clear();
            if (graffitiRankListInfo.consent_list != null) {
                for (User user : graffitiRankListInfo.consent_list) {
                    UserData userData = new UserData();
                    userData.parserProtobuf(user);
                    this.OF.add(userData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.data.s, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return OB;
    }
}
