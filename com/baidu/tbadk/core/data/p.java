package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
import tbclient.DeclareInfo;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class p implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId Ui = BdUniqueId.gen();
    private List<q> Uj;
    private long Uk;
    private long Ul;
    private long mForumId;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Ui;
    }

    public void a(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.Ul = threadInfo.id.longValue();
            if (threadInfo.author != null) {
                this.Uk = threadInfo.author.id.longValue();
            }
            if (threadInfo.declare_list != null) {
                this.Uj = new ArrayList();
                boolean z = false;
                for (DeclareInfo declareInfo : threadInfo.declare_list) {
                    if (declareInfo != null) {
                        q qVar = new q();
                        qVar.a(declareInfo);
                        if (z) {
                            qVar.Uq = false;
                        }
                        boolean z2 = qVar.Uq || z;
                        this.Uj.add(qVar);
                        z = z2;
                    }
                }
            }
        }
    }

    public List<q> pA() {
        return this.Uj;
    }

    public long pB() {
        return this.Uk;
    }

    public long getTid() {
        return this.Ul;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public boolean pC() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(this.Uk));
        }
        return false;
    }

    public boolean pD() {
        if (this.Uj == null) {
            return false;
        }
        boolean z = false;
        for (q qVar : this.Uj) {
            if (qVar != null) {
                boolean z2 = z || qVar.Uq;
                if (z2) {
                    return true;
                }
                z = z2;
            }
        }
        return false;
    }

    public long bB(int i) {
        long j = 0;
        if (this.Uj != null) {
            if (this.Uj.size() <= i) {
                i = this.Uj.size();
            }
            long j2 = i;
            int i2 = 0;
            while (i2 < j2) {
                q qVar = this.Uj.get(i2);
                i2++;
                j = qVar != null ? qVar.Up + j : j;
            }
        }
        return j;
    }
}
