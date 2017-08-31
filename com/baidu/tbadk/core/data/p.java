package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
import tbclient.DeclareInfo;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class p implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId Vc = BdUniqueId.gen();
    private List<q> Vd;
    private long Ve;
    private long Vf;
    private long mForumId;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Vc;
    }

    public void a(ThreadInfo threadInfo) {
        boolean z;
        if (threadInfo != null) {
            this.Vf = threadInfo.id.longValue();
            if (threadInfo.author != null) {
                this.Ve = threadInfo.author.id.longValue();
            }
            if (threadInfo.declare_list != null) {
                this.Vd = new ArrayList();
                boolean z2 = false;
                for (DeclareInfo declareInfo : threadInfo.declare_list) {
                    if (declareInfo != null) {
                        q qVar = new q();
                        qVar.a(declareInfo);
                        if (z2) {
                            qVar.Vk = false;
                        }
                        z = qVar.Vk || z2;
                        this.Vd.add(qVar);
                    } else {
                        z = z2;
                    }
                    z2 = z;
                }
            }
        }
    }

    public List<q> pF() {
        return this.Vd;
    }

    public long pG() {
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

    public boolean pH() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(this.Ve));
        }
        return false;
    }

    public boolean pI() {
        boolean z;
        if (this.Vd == null) {
            return false;
        }
        boolean z2 = false;
        for (q qVar : this.Vd) {
            if (qVar != null) {
                z = z2 || qVar.Vk;
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
        if (this.Vd != null) {
            long size = this.Vd.size() > i ? i : this.Vd.size();
            int i2 = 0;
            while (i2 < size) {
                q qVar = this.Vd.get(i2);
                i2++;
                j = qVar != null ? qVar.Vj + j : j;
            }
        }
        return j;
    }
}
