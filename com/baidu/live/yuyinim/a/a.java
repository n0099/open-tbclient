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
/* loaded from: classes10.dex */
public class a {
    private f bYF;
    private c bYG;
    private g bYH;
    private d bYI;
    private e bYJ;
    private BdPageContext bka;
    private BdTypeListView bkb;
    private boolean bkh;
    private List<AbsDelegateAdapter> bjZ = new ArrayList();
    private CustomMessageListener bki = new CustomMessageListener(0) { // from class: com.baidu.live.yuyinim.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.notifyDataSetChanged();
        }
    };

    public a(BdPageContext bdPageContext, BdTypeListView bdTypeListView) {
        this.bka = bdPageContext;
        this.bkb = bdTypeListView;
        IY();
    }

    public void HN() {
        MessageManager.getInstance().registerListener(2913069, this.bki);
    }

    private void IY() {
        this.bYF = new f(this.bka.getPageActivity());
        this.bYG = new c(this.bka.getPageActivity());
        this.bYH = new g(this.bka.getPageActivity());
        this.bYI = new d(this.bka.getPageActivity());
        this.bYJ = new e(this.bka.getPageActivity());
        this.bjZ.add(this.bYF);
        this.bjZ.add(this.bYG);
        this.bjZ.add(this.bYH);
        this.bjZ.add(this.bYI);
        this.bjZ.add(this.bYJ);
        this.bkb.addAdapters(this.bjZ);
    }

    public void setMode(boolean z) {
        this.bYF.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.bkb != null) {
            this.bkb.setData(list);
        }
    }

    public void b(String str, String str2, boolean z, String str3) {
        for (AbsDelegateAdapter absDelegateAdapter : this.bjZ) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).b(str, str2, z, str3);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.bkb != null && (this.bkb.getAdapter() instanceof BaseAdapter)) {
            this.bkb.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromMaster(boolean z) {
        this.bkh = z;
        if (this.bkh) {
            if (this.bYF != null) {
                this.bYF.ce(true);
            }
            if (this.bYG != null) {
                this.bYG.ce(true);
            }
            if (this.bYH != null) {
                this.bYH.ce(true);
            }
            if (this.bYI != null) {
                this.bYI.ce(true);
            }
            if (this.bYJ != null) {
                this.bYJ.ce(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.bki);
    }
}
