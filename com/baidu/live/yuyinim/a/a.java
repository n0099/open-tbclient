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
    private BdPageContext boT;
    private BdTypeListView boU;
    private boolean bpa;
    private f cel;
    private c cem;
    private g cen;
    private d ceo;
    private e cep;
    private List<AbsDelegateAdapter> boS = new ArrayList();
    private CustomMessageListener bpb = new CustomMessageListener(0) { // from class: com.baidu.live.yuyinim.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.notifyDataSetChanged();
        }
    };

    public a(BdPageContext bdPageContext, BdTypeListView bdTypeListView) {
        this.boT = bdPageContext;
        this.boU = bdTypeListView;
        Kz();
    }

    public void Jj() {
        MessageManager.getInstance().registerListener(2913069, this.bpb);
    }

    private void Kz() {
        this.cel = new f(this.boT.getPageActivity());
        this.cem = new c(this.boT.getPageActivity());
        this.cen = new g(this.boT.getPageActivity());
        this.ceo = new d(this.boT.getPageActivity());
        this.cep = new e(this.boT.getPageActivity());
        this.boS.add(this.cel);
        this.boS.add(this.cem);
        this.boS.add(this.cen);
        this.boS.add(this.ceo);
        this.boS.add(this.cep);
        this.boU.addAdapters(this.boS);
    }

    public void setMode(boolean z) {
        this.cel.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.boU != null) {
            this.boU.setData(list);
        }
    }

    public void b(String str, String str2, boolean z, String str3) {
        for (AbsDelegateAdapter absDelegateAdapter : this.boS) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).b(str, str2, z, str3);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.boU != null && (this.boU.getAdapter() instanceof BaseAdapter)) {
            this.boU.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromMaster(boolean z) {
        this.bpa = z;
        if (this.bpa) {
            if (this.cel != null) {
                this.cel.cm(true);
            }
            if (this.cem != null) {
                this.cem.cm(true);
            }
            if (this.cen != null) {
                this.cen.cm(true);
            }
            if (this.ceo != null) {
                this.ceo.cm(true);
            }
            if (this.cep != null) {
                this.cep.cm(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.bpb);
    }
}
