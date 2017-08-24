package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
import tbclient.DeclareInfo;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class p implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId VZ = BdUniqueId.gen();
    private List<q> Wa;
    private long Wb;
    private long Wc;
    private long mForumId;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return VZ;
    }

    public void a(ThreadInfo threadInfo) {
        boolean z;
        if (threadInfo != null) {
            this.Wc = threadInfo.id.longValue();
            if (threadInfo.author != null) {
                this.Wb = threadInfo.author.id.longValue();
            }
            if (threadInfo.declare_list != null) {
                this.Wa = new ArrayList();
                boolean z2 = false;
                for (DeclareInfo declareInfo : threadInfo.declare_list) {
                    if (declareInfo != null) {
                        q qVar = new q();
                        qVar.a(declareInfo);
                        if (z2) {
                            qVar.Wh = false;
                        }
                        z = qVar.Wh || z2;
                        this.Wa.add(qVar);
                    } else {
                        z = z2;
                    }
                    z2 = z;
                }
            }
        }
    }

    public List<q> pL() {
        return this.Wa;
    }

    public long pM() {
        return this.Wb;
    }

    public long getTid() {
        return this.Wc;
    }

    public long getForumId() {
        return this.mForumId;
    }

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public boolean pN() {
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(this.Wb));
        }
        return false;
    }

    public boolean pO() {
        boolean z;
        if (this.Wa == null) {
            return false;
        }
        boolean z2 = false;
        for (q qVar : this.Wa) {
            if (qVar != null) {
                z = z2 || qVar.Wh;
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
        if (this.Wa != null) {
            long size = this.Wa.size() > i ? i : this.Wa.size();
            int i2 = 0;
            while (i2 < size) {
                q qVar = this.Wa.get(i2);
                i2++;
                j = qVar != null ? qVar.Wg + j : j;
            }
        }
        return j;
    }
}
