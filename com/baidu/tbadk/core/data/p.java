package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
import tbclient.DeclareInfo;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class p implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId Ux = BdUniqueId.gen();
    private long UB;
    private List<q> Uy;
    private long Uz;
    private long mForumId;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Ux;
    }

    public void a(ThreadInfo threadInfo) {
        boolean z;
        if (threadInfo != null) {
            this.UB = threadInfo.id.longValue();
            if (threadInfo.author != null) {
                this.Uz = threadInfo.author.id.longValue();
            }
            if (threadInfo.declare_list != null) {
                this.Uy = new ArrayList();
                boolean z2 = false;
                for (DeclareInfo declareInfo : threadInfo.declare_list) {
                    if (declareInfo != null) {
                        q qVar = new q();
                        qVar.a(declareInfo);
                        if (z2) {
                            qVar.UG = false;
                        }
                        z = qVar.UG || z2;
                        this.Uy.add(qVar);
                    } else {
                        z = z2;
                    }
                    z2 = z;
                }
            }
        }
    }

    public List<q> pA() {
        return this.Uy;
    }

    public long pB() {
        return this.Uz;
    }

    public long getTid() {
        return this.UB;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public boolean pC() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(this.Uz));
        }
        return false;
    }

    public boolean pD() {
        boolean z;
        if (this.Uy == null) {
            return false;
        }
        boolean z2 = false;
        for (q qVar : this.Uy) {
            if (qVar != null) {
                z = z2 || qVar.UG;
                if (z) {
                    return true;
                }
            } else {
                z = z2;
            }
            z2 = z;
        }
        return false;
    }

    public long bA(int i) {
        long j = 0;
        if (this.Uy != null) {
            long size = this.Uy.size() > i ? i : this.Uy.size();
            int i2 = 0;
            while (i2 < size) {
                q qVar = this.Uy.get(i2);
                i2++;
                j = qVar != null ? qVar.UF + j : j;
            }
        }
        return j;
    }
}
