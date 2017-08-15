package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
import tbclient.DeclareInfo;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class p implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId VY = BdUniqueId.gen();
    private List<q> VZ;
    private long Wa;
    private long Wb;
    private long mForumId;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return VY;
    }

    public void a(ThreadInfo threadInfo) {
        boolean z;
        if (threadInfo != null) {
            this.Wb = threadInfo.id.longValue();
            if (threadInfo.author != null) {
                this.Wa = threadInfo.author.id.longValue();
            }
            if (threadInfo.declare_list != null) {
                this.VZ = new ArrayList();
                boolean z2 = false;
                for (DeclareInfo declareInfo : threadInfo.declare_list) {
                    if (declareInfo != null) {
                        q qVar = new q();
                        qVar.a(declareInfo);
                        if (z2) {
                            qVar.Wg = false;
                        }
                        z = qVar.Wg || z2;
                        this.VZ.add(qVar);
                    } else {
                        z = z2;
                    }
                    z2 = z;
                }
            }
        }
    }

    public List<q> pK() {
        return this.VZ;
    }

    public long pL() {
        return this.Wa;
    }

    public long getTid() {
        return this.Wb;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public boolean pM() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(this.Wa));
        }
        return false;
    }

    public boolean pN() {
        boolean z;
        if (this.VZ == null) {
            return false;
        }
        boolean z2 = false;
        for (q qVar : this.VZ) {
            if (qVar != null) {
                z = z2 || qVar.Wg;
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
        if (this.VZ != null) {
            long size = this.VZ.size() > i ? i : this.VZ.size();
            int i2 = 0;
            while (i2 < size) {
                q qVar = this.VZ.get(i2);
                i2++;
                j = qVar != null ? qVar.Wf + j : j;
            }
        }
        return j;
    }
}
