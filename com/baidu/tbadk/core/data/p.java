package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
import tbclient.DeclareInfo;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class p implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId Vc = BdUniqueId.gen();
    private List<q> Vd;
    private long Ve;
    private long Vf;
    private long mForumId;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Vc;
    }

    public void a(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.Vf = threadInfo.id.longValue();
            if (threadInfo.author != null) {
                this.Ve = threadInfo.author.id.longValue();
            }
            if (threadInfo.declare_list != null) {
                this.Vd = new ArrayList();
                boolean z = false;
                for (DeclareInfo declareInfo : threadInfo.declare_list) {
                    if (declareInfo != null) {
                        q qVar = new q();
                        qVar.a(declareInfo);
                        if (z) {
                            qVar.Vk = false;
                        }
                        boolean z2 = qVar.Vk || z;
                        this.Vd.add(qVar);
                        z = z2;
                    }
                }
            }
        }
    }

    public List<q> qe() {
        return this.Vd;
    }

    public long qf() {
        return this.Ve;
    }

    public long getTid() {
        return this.Vf;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public boolean qg() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(this.Ve));
        }
        return false;
    }

    public boolean qh() {
        if (this.Vd == null) {
            return false;
        }
        boolean z = false;
        for (q qVar : this.Vd) {
            if (qVar != null) {
                boolean z2 = z || qVar.Vk;
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
        if (this.Vd != null) {
            if (this.Vd.size() <= i) {
                i = this.Vd.size();
            }
            long j2 = i;
            int i2 = 0;
            while (i2 < j2) {
                q qVar = this.Vd.get(i2);
                i2++;
                j = qVar != null ? qVar.Vj + j : j;
            }
        }
        return j;
    }
}
