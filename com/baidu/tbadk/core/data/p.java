package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
import tbclient.DeclareInfo;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class p implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId Ve = BdUniqueId.gen();
    private List<q> Vf;
    private long Vg;
    private long Vh;
    private long mForumId;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Ve;
    }

    public void a(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.Vh = threadInfo.id.longValue();
            if (threadInfo.author != null) {
                this.Vg = threadInfo.author.id.longValue();
            }
            if (threadInfo.declare_list != null) {
                this.Vf = new ArrayList();
                boolean z = false;
                for (DeclareInfo declareInfo : threadInfo.declare_list) {
                    if (declareInfo != null) {
                        q qVar = new q();
                        qVar.a(declareInfo);
                        if (z) {
                            qVar.Vm = false;
                        }
                        boolean z2 = qVar.Vm || z;
                        this.Vf.add(qVar);
                        z = z2;
                    }
                }
            }
        }
    }

    public List<q> qe() {
        return this.Vf;
    }

    public long qf() {
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

    public boolean qg() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(this.Vg));
        }
        return false;
    }

    public boolean qh() {
        if (this.Vf == null) {
            return false;
        }
        boolean z = false;
        for (q qVar : this.Vf) {
            if (qVar != null) {
                boolean z2 = z || qVar.Vm;
                if (z2) {
                    return true;
                }
                z = z2;
            }
        }
        return false;
    }

    public long bD(int i) {
        long j = 0;
        if (this.Vf != null) {
            if (this.Vf.size() <= i) {
                i = this.Vf.size();
            }
            long j2 = i;
            int i2 = 0;
            while (i2 < j2) {
                q qVar = this.Vf.get(i2);
                i2++;
                j = qVar != null ? qVar.Vl + j : j;
            }
        }
        return j;
    }
}
