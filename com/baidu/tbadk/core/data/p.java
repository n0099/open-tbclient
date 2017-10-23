package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
import tbclient.DeclareInfo;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class p implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId Ve = BdUniqueId.gen();
    private List<q> Vf;
    private long Vg;
    private long Vh;
    private long mForumId;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Ve;
    }

    public void a(ThreadInfo threadInfo) {
        boolean z;
        if (threadInfo != null) {
            this.Vh = threadInfo.id.longValue();
            if (threadInfo.author != null) {
                this.Vg = threadInfo.author.id.longValue();
            }
            if (threadInfo.declare_list != null) {
                this.Vf = new ArrayList();
                boolean z2 = false;
                for (DeclareInfo declareInfo : threadInfo.declare_list) {
                    if (declareInfo != null) {
                        q qVar = new q();
                        qVar.a(declareInfo);
                        if (z2) {
                            qVar.Vm = false;
                        }
                        z = qVar.Vm || z2;
                        this.Vf.add(qVar);
                    } else {
                        z = z2;
                    }
                    z2 = z;
                }
            }
        }
    }

    public List<q> pz() {
        return this.Vf;
    }

    public long pA() {
        return this.Vg;
    }

    public long getTid() {
        return this.Vh;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public boolean pB() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(this.Vg));
        }
        return false;
    }

    public boolean pC() {
        boolean z;
        if (this.Vf == null) {
            return false;
        }
        boolean z2 = false;
        for (q qVar : this.Vf) {
            if (qVar != null) {
                z = z2 || qVar.Vm;
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

    public long bF(int i) {
        long j = 0;
        if (this.Vf != null) {
            long size = this.Vf.size() > i ? i : this.Vf.size();
            int i2 = 0;
            while (i2 < size) {
                q qVar = this.Vf.get(i2);
                i2++;
                j = qVar != null ? qVar.Vl + j : j;
            }
        }
        return j;
    }
}
