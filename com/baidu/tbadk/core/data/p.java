package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
import tbclient.DeclareInfo;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class p implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId Uv = BdUniqueId.gen();
    private List<q> Uw;
    private long Ux;
    private long Uy;
    private long mForumId;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Uv;
    }

    public void a(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.Uy = threadInfo.id.longValue();
            if (threadInfo.author != null) {
                this.Ux = threadInfo.author.id.longValue();
            }
            if (threadInfo.declare_list != null) {
                this.Uw = new ArrayList();
                boolean z = false;
                for (DeclareInfo declareInfo : threadInfo.declare_list) {
                    if (declareInfo != null) {
                        q qVar = new q();
                        qVar.a(declareInfo);
                        if (z) {
                            qVar.UE = false;
                        }
                        boolean z2 = qVar.UE || z;
                        this.Uw.add(qVar);
                        z = z2;
                    }
                }
            }
        }
    }

    public List<q> pI() {
        return this.Uw;
    }

    public long pJ() {
        return this.Ux;
    }

    public long getTid() {
        return this.Uy;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public boolean pK() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(this.Ux));
        }
        return false;
    }

    public boolean pL() {
        if (this.Uw == null) {
            return false;
        }
        boolean z = false;
        for (q qVar : this.Uw) {
            if (qVar != null) {
                boolean z2 = z || qVar.UE;
                if (z2) {
                    return true;
                }
                z = z2;
            }
        }
        return false;
    }

    public long bA(int i) {
        long j = 0;
        if (this.Uw != null) {
            if (this.Uw.size() <= i) {
                i = this.Uw.size();
            }
            long j2 = i;
            int i2 = 0;
            while (i2 < j2) {
                q qVar = this.Uw.get(i2);
                i2++;
                j = qVar != null ? qVar.UD + j : j;
            }
        }
        return j;
    }
}
