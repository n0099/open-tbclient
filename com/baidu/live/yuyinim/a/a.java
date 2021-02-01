package com.baidu.live.yuyinim.a;

import android.widget.BaseAdapter;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.adp.widget.listview.IAdapterData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private boolean bnA;
    private BdPageContext bnt;
    private BdTypeListView bnu;
    private f ccJ;
    private c ccK;
    private g ccL;
    private d ccM;
    private e ccN;
    private List<AbsDelegateAdapter> bns = new ArrayList();
    private CustomMessageListener bnB = new CustomMessageListener(0) { // from class: com.baidu.live.yuyinim.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.notifyDataSetChanged();
        }
    };

    public a(BdPageContext bdPageContext, BdTypeListView bdTypeListView) {
        this.bnt = bdPageContext;
        this.bnu = bdTypeListView;
        Kw();
    }

    public void Jg() {
        MessageManager.getInstance().registerListener(2913069, this.bnB);
    }

    private void Kw() {
        this.ccJ = new f(this.bnt.getPageActivity());
        this.ccK = new c(this.bnt.getPageActivity());
        this.ccL = new g(this.bnt.getPageActivity());
        this.ccM = new d(this.bnt.getPageActivity());
        this.ccN = new e(this.bnt.getPageActivity());
        this.bns.add(this.ccJ);
        this.bns.add(this.ccK);
        this.bns.add(this.ccL);
        this.bns.add(this.ccM);
        this.bns.add(this.ccN);
        this.bnu.addAdapters(this.bns);
    }

    public void setMode(boolean z) {
        this.ccJ.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.bnu != null) {
            this.bnu.setData(list);
        }
    }

    public void b(String str, String str2, boolean z, String str3) {
        for (AbsDelegateAdapter absDelegateAdapter : this.bns) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).b(str, str2, z, str3);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.bnu != null && (this.bnu.getAdapter() instanceof BaseAdapter)) {
            this.bnu.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromMaster(boolean z) {
        this.bnA = z;
        if (this.bnA) {
            if (this.ccJ != null) {
                this.ccJ.cm(true);
            }
            if (this.ccK != null) {
                this.ccK.cm(true);
            }
            if (this.ccL != null) {
                this.ccL.cm(true);
            }
            if (this.ccM != null) {
                this.ccM.cm(true);
            }
            if (this.ccN != null) {
                this.ccN.cm(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.bnB);
    }
}
