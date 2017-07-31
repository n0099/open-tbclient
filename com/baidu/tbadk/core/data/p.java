package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
import tbclient.DeclareInfo;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class p implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId VW = BdUniqueId.gen();
    private List<q> VX;
    private long VY;
    private long VZ;
    private long mForumId;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return VW;
    }

    public void a(ThreadInfo threadInfo) {
        boolean z;
        if (threadInfo != null) {
            this.VZ = threadInfo.id.longValue();
            if (threadInfo.author != null) {
                this.VY = threadInfo.author.id.longValue();
            }
            if (threadInfo.declare_list != null) {
                this.VX = new ArrayList();
                boolean z2 = false;
                for (DeclareInfo declareInfo : threadInfo.declare_list) {
                    if (declareInfo != null) {
                        q qVar = new q();
                        qVar.a(declareInfo);
                        if (z2) {
                            qVar.We = false;
                        }
                        z = qVar.We || z2;
                        this.VX.add(qVar);
                    } else {
                        z = z2;
                    }
                    z2 = z;
                }
            }
        }
    }

    public List<q> pK() {
        return this.VX;
    }

    public long pL() {
        return this.VY;
    }

    public long getTid() {
        return this.VZ;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public boolean pM() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(this.VY));
        }
        return false;
    }

    public boolean pN() {
        boolean z;
        if (this.VX == null) {
            return false;
        }
        boolean z2 = false;
        for (q qVar : this.VX) {
            if (qVar != null) {
                z = z2 || qVar.We;
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

    public long bC(int i) {
        long j = 0;
        if (this.VX != null) {
            long size = this.VX.size() > i ? i : this.VX.size();
            int i2 = 0;
            while (i2 < size) {
                q qVar = this.VX.get(i2);
                i2++;
                j = qVar != null ? qVar.Wd + j : j;
            }
        }
        return j;
    }
}
