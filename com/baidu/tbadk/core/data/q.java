package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
import tbclient.DeclareInfo;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class q implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId Uh = BdUniqueId.gen();
    private List<r> Ui;
    private long Uj;
    private long Uk;
    private long mForumId;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Uh;
    }

    public void a(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.Uk = threadInfo.id.longValue();
            if (threadInfo.author != null) {
                this.Uj = threadInfo.author.id.longValue();
            }
            if (threadInfo.declare_list != null) {
                this.Ui = new ArrayList();
                boolean z = false;
                for (DeclareInfo declareInfo : threadInfo.declare_list) {
                    if (declareInfo != null) {
                        r rVar = new r();
                        rVar.a(declareInfo);
                        if (z) {
                            rVar.Up = false;
                        }
                        boolean z2 = rVar.Up || z;
                        this.Ui.add(rVar);
                        z = z2;
                    }
                }
            }
        }
    }

    public List<r> px() {
        return this.Ui;
    }

    public long py() {
        return this.Uj;
    }

    public long getTid() {
        return this.Uk;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public boolean pz() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(this.Uj));
        }
        return false;
    }

    public boolean pA() {
        if (this.Ui == null) {
            return false;
        }
        boolean z = false;
        for (r rVar : this.Ui) {
            if (rVar != null) {
                boolean z2 = z || rVar.Up;
                if (z2) {
                    return true;
                }
                z = z2;
            }
        }
        return false;
    }

    public long bB(int i) {
        long j = 0;
        if (this.Ui != null) {
            if (this.Ui.size() <= i) {
                i = this.Ui.size();
            }
            long j2 = i;
            int i2 = 0;
            while (i2 < j2) {
                r rVar = this.Ui.get(i2);
                i2++;
                j = rVar != null ? rVar.Uo + j : j;
            }
        }
        return j;
    }
}
