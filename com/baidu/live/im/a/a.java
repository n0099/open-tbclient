package com.baidu.live.im.a;

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
    private f bnv;
    private c bnw;
    private g bnx;
    private d bny;
    private e bnz;
    private List<AbsDelegateAdapter> bns = new ArrayList();
    private CustomMessageListener bnB = new CustomMessageListener(0) { // from class: com.baidu.live.im.a.a.1
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
        if (this.bnv != null) {
            MessageManager.getInstance().registerListener(this.bnv.boE);
            MessageManager.getInstance().registerListener(this.bnv.boD);
        }
    }

    private void Kw() {
        this.bnv = new f(this.bnt);
        this.bnw = new c(this.bnt.getPageActivity());
        this.bnx = new g(this.bnt.getPageActivity());
        this.bny = new d(this.bnt.getPageActivity());
        this.bnz = new e(this.bnt.getPageActivity());
        this.bns.add(this.bnv);
        this.bns.add(this.bnw);
        this.bns.add(this.bnx);
        this.bns.add(this.bny);
        this.bns.add(this.bnz);
        this.bnu.addAdapters(this.bns);
    }

    public void setMode(boolean z) {
        this.bnv.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.bnu != null) {
            this.bnu.setData(list);
        }
    }

    public void a(String str, String str2, boolean z, String str3, String str4) {
        for (AbsDelegateAdapter absDelegateAdapter : this.bns) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).a(str, str2, z, str3, str4);
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
            if (this.bnv != null) {
                this.bnv.cm(true);
            }
            if (this.bnw != null) {
                this.bnw.cm(true);
            }
            if (this.bnx != null) {
                this.bnx.cm(true);
            }
            if (this.bny != null) {
                this.bny.cm(true);
            }
            if (this.bnz != null) {
                this.bnz.cm(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.bnB);
        if (this.bnv != null) {
            this.bnv.KJ();
        }
    }
}
