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
/* loaded from: classes10.dex */
public class a {
    private BdPageContext bka;
    private BdTypeListView bkb;
    private f bkc;
    private c bkd;
    private g bke;
    private d bkf;
    private e bkg;
    private boolean bkh;
    private List<AbsDelegateAdapter> bjZ = new ArrayList();
    private CustomMessageListener bki = new CustomMessageListener(0) { // from class: com.baidu.live.im.a.a.1
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
        if (this.bkc != null) {
            MessageManager.getInstance().registerListener(this.bkc.blj);
        }
    }

    private void IY() {
        this.bkc = new f(this.bka);
        this.bkd = new c(this.bka.getPageActivity());
        this.bke = new g(this.bka.getPageActivity());
        this.bkf = new d(this.bka.getPageActivity());
        this.bkg = new e(this.bka.getPageActivity());
        this.bjZ.add(this.bkc);
        this.bjZ.add(this.bkd);
        this.bjZ.add(this.bke);
        this.bjZ.add(this.bkf);
        this.bjZ.add(this.bkg);
        this.bkb.addAdapters(this.bjZ);
    }

    public void setMode(boolean z) {
        this.bkc.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.bkb != null) {
            this.bkb.setData(list);
        }
    }

    public void a(String str, String str2, boolean z, String str3, String str4) {
        for (AbsDelegateAdapter absDelegateAdapter : this.bjZ) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).a(str, str2, z, str3, str4);
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
            if (this.bkc != null) {
                this.bkc.ce(true);
            }
            if (this.bkd != null) {
                this.bkd.ce(true);
            }
            if (this.bke != null) {
                this.bke.ce(true);
            }
            if (this.bkf != null) {
                this.bkf.ce(true);
            }
            if (this.bkg != null) {
                this.bkg.ce(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.bki);
        if (this.bkc != null) {
            this.bkc.Jl();
        }
    }
}
