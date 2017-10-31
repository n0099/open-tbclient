package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
import tbclient.DeclareInfo;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class p implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId Vw = BdUniqueId.gen();
    private List<q> Vx;
    private long Vy;
    private long Vz;
    private long mForumId;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Vw;
    }

    public void a(ThreadInfo threadInfo) {
        boolean z;
        if (threadInfo != null) {
            this.Vz = threadInfo.id.longValue();
            if (threadInfo.author != null) {
                this.Vy = threadInfo.author.id.longValue();
            }
            if (threadInfo.declare_list != null) {
                this.Vx = new ArrayList();
                boolean z2 = false;
                for (DeclareInfo declareInfo : threadInfo.declare_list) {
                    if (declareInfo != null) {
                        q qVar = new q();
                        qVar.a(declareInfo);
                        if (z2) {
                            qVar.VE = false;
                        }
                        z = qVar.VE || z2;
                        this.Vx.add(qVar);
                    } else {
                        z = z2;
                    }
                    z2 = z;
                }
            }
        }
    }

    public List<q> pE() {
        return this.Vx;
    }

    public long pF() {
        return this.Vy;
    }

    public long getTid() {
        return this.Vz;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public boolean pG() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(this.Vy));
        }
        return false;
    }

    public boolean pH() {
        boolean z;
        if (this.Vx == null) {
            return false;
        }
        boolean z2 = false;
        for (q qVar : this.Vx) {
            if (qVar != null) {
                z = z2 || qVar.VE;
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

    public long bD(int i) {
        long j = 0;
        if (this.Vx != null) {
            long size = this.Vx.size() > i ? i : this.Vx.size();
            int i2 = 0;
            while (i2 < size) {
                q qVar = this.Vx.get(i2);
                i2++;
                j = qVar != null ? qVar.VD + j : j;
            }
        }
        return j;
    }
}
