package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
import tbclient.DeclareInfo;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class p implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId UI = BdUniqueId.gen();
    private List<q> UJ;
    private long UK;
    private long UL;
    private long mForumId;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return UI;
    }

    public void a(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.UL = threadInfo.id.longValue();
            if (threadInfo.author != null) {
                this.UK = threadInfo.author.id.longValue();
            }
            if (threadInfo.declare_list != null) {
                this.UJ = new ArrayList();
                boolean z = false;
                for (DeclareInfo declareInfo : threadInfo.declare_list) {
                    if (declareInfo != null) {
                        q qVar = new q();
                        qVar.a(declareInfo);
                        if (z) {
                            qVar.UR = false;
                        }
                        boolean z2 = qVar.UR || z;
                        this.UJ.add(qVar);
                        z = z2;
                    }
                }
            }
        }
    }

    public List<q> pG() {
        return this.UJ;
    }

    public long pH() {
        return this.UK;
    }

    public long getTid() {
        return this.UL;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public boolean pI() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(this.UK));
        }
        return false;
    }

    public boolean pJ() {
        if (this.UJ == null) {
            return false;
        }
        boolean z = false;
        for (q qVar : this.UJ) {
            if (qVar != null) {
                boolean z2 = z || qVar.UR;
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
        if (this.UJ != null) {
            if (this.UJ.size() <= i) {
                i = this.UJ.size();
            }
            long j2 = i;
            int i2 = 0;
            while (i2 < j2) {
                q qVar = this.UJ.get(i2);
                i2++;
                j = qVar != null ? qVar.UQ + j : j;
            }
        }
        return j;
    }
}
