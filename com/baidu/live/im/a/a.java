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
    private BdPageContext bjf;
    private BdTypeListView bjg;
    private f bjh;
    private c bji;
    private g bjj;
    private d bjk;
    private e bjl;
    private boolean bjm;
    private List<AbsDelegateAdapter> bje = new ArrayList();
    private CustomMessageListener bjn = new CustomMessageListener(0) { // from class: com.baidu.live.im.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.notifyDataSetChanged();
        }
    };

    public a(BdPageContext bdPageContext, BdTypeListView bdTypeListView) {
        this.bjf = bdPageContext;
        this.bjg = bdTypeListView;
        Ly();
    }

    public void Ks() {
        MessageManager.getInstance().registerListener(2913069, this.bjn);
    }

    private void Ly() {
        this.bjh = new f(this.bjf.getPageActivity());
        this.bji = new c(this.bjf.getPageActivity());
        this.bjj = new g(this.bjf.getPageActivity());
        this.bjk = new d(this.bjf.getPageActivity());
        this.bjl = new e(this.bjf.getPageActivity());
        this.bje.add(this.bjh);
        this.bje.add(this.bji);
        this.bje.add(this.bjj);
        this.bje.add(this.bjk);
        this.bje.add(this.bjl);
        this.bjg.addAdapters(this.bje);
    }

    public void setMode(boolean z) {
        this.bjh.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.bjg != null) {
            this.bjg.setData(list);
        }
    }

    public void b(String str, String str2, boolean z, String str3) {
        for (AbsDelegateAdapter absDelegateAdapter : this.bje) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).b(str, str2, z, str3);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.bjg != null && (this.bjg.getAdapter() instanceof BaseAdapter)) {
            this.bjg.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromMaster(boolean z) {
        this.bjm = z;
        if (this.bjm) {
            if (this.bjh != null) {
                this.bjh.bW(true);
            }
            if (this.bji != null) {
                this.bji.bW(true);
            }
            if (this.bjj != null) {
                this.bjj.bW(true);
            }
            if (this.bjk != null) {
                this.bjk.bW(true);
            }
            if (this.bjl != null) {
                this.bjl.bW(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.bjn);
    }
}
