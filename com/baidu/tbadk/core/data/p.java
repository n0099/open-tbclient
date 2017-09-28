package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
import tbclient.DeclareInfo;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class p implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId Vq = BdUniqueId.gen();
    private List<q> Vr;
    private long Vs;
    private long Vt;
    private long mForumId;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Vq;
    }

    public void a(ThreadInfo threadInfo) {
        boolean z;
        if (threadInfo != null) {
            this.Vt = threadInfo.id.longValue();
            if (threadInfo.author != null) {
                this.Vs = threadInfo.author.id.longValue();
            }
            if (threadInfo.declare_list != null) {
                this.Vr = new ArrayList();
                boolean z2 = false;
                for (DeclareInfo declareInfo : threadInfo.declare_list) {
                    if (declareInfo != null) {
                        q qVar = new q();
                        qVar.a(declareInfo);
                        if (z2) {
                            qVar.Vy = false;
                        }
                        z = qVar.Vy || z2;
                        this.Vr.add(qVar);
                    } else {
                        z = z2;
                    }
                    z2 = z;
                }
            }
        }
    }

    public List<q> pG() {
        return this.Vr;
    }

    public long pH() {
        return this.Vs;
    }

    public long getTid() {
        return this.Vt;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public boolean pI() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(this.Vs));
        }
        return false;
    }

    public boolean pJ() {
        boolean z;
        if (this.Vr == null) {
            return false;
        }
        boolean z2 = false;
        for (q qVar : this.Vr) {
            if (qVar != null) {
                z = z2 || qVar.Vy;
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

    public long bG(int i) {
        long j = 0;
        if (this.Vr != null) {
            long size = this.Vr.size() > i ? i : this.Vr.size();
            int i2 = 0;
            while (i2 < size) {
                q qVar = this.Vr.get(i2);
                i2++;
                j = qVar != null ? qVar.Vx + j : j;
            }
        }
        return j;
    }
}
