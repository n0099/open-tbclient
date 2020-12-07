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
/* loaded from: classes4.dex */
public class a {
    private BdPageContext bng;
    private BdTypeListView bnh;
    private f bni;
    private c bnj;
    private g bnk;
    private d bnl;
    private e bnm;
    private boolean bnn;
    private List<AbsDelegateAdapter> bnf = new ArrayList();
    private CustomMessageListener bno = new CustomMessageListener(0) { // from class: com.baidu.live.im.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.notifyDataSetChanged();
        }
    };

    public a(BdPageContext bdPageContext, BdTypeListView bdTypeListView) {
        this.bng = bdPageContext;
        this.bnh = bdTypeListView;
        Nt();
    }

    public void Ml() {
        MessageManager.getInstance().registerListener(2913069, this.bno);
    }

    private void Nt() {
        this.bni = new f(this.bng);
        this.bnj = new c(this.bng.getPageActivity());
        this.bnk = new g(this.bng.getPageActivity());
        this.bnl = new d(this.bng.getPageActivity());
        this.bnm = new e(this.bng.getPageActivity());
        this.bnf.add(this.bni);
        this.bnf.add(this.bnj);
        this.bnf.add(this.bnk);
        this.bnf.add(this.bnl);
        this.bnf.add(this.bnm);
        this.bnh.addAdapters(this.bnf);
    }

    public void setMode(boolean z) {
        this.bni.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.bnh != null) {
            this.bnh.setData(list);
        }
    }

    public void a(String str, String str2, boolean z, String str3, String str4) {
        for (AbsDelegateAdapter absDelegateAdapter : this.bnf) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).a(str, str2, z, str3, str4);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.bnh != null && (this.bnh.getAdapter() instanceof BaseAdapter)) {
            this.bnh.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromMaster(boolean z) {
        this.bnn = z;
        if (this.bnn) {
            if (this.bni != null) {
                this.bni.ci(true);
            }
            if (this.bnj != null) {
                this.bnj.ci(true);
            }
            if (this.bnk != null) {
                this.bnk.ci(true);
            }
            if (this.bnl != null) {
                this.bnl.ci(true);
            }
            if (this.bnm != null) {
                this.bnm.ci(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.bno);
    }

    public f Nu() {
        return this.bni;
    }
}
