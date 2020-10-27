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
/* loaded from: classes4.dex */
public class a {
    private f bNH;
    private c bNI;
    private g bNJ;
    private d bNK;
    private e bNL;
    private BdPageContext bjf;
    private BdTypeListView bjg;
    private boolean bjm;
    private List<AbsDelegateAdapter> bje = new ArrayList();
    private CustomMessageListener bjn = new CustomMessageListener(0) { // from class: com.baidu.live.yuyinim.a.a.1
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
        this.bNH = new f(this.bjf.getPageActivity());
        this.bNI = new c(this.bjf.getPageActivity());
        this.bNJ = new g(this.bjf.getPageActivity());
        this.bNK = new d(this.bjf.getPageActivity());
        this.bNL = new e(this.bjf.getPageActivity());
        this.bje.add(this.bNH);
        this.bje.add(this.bNI);
        this.bje.add(this.bNJ);
        this.bje.add(this.bNK);
        this.bje.add(this.bNL);
        this.bjg.addAdapters(this.bje);
    }

    public void setMode(boolean z) {
        this.bNH.setMode(z);
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
            if (this.bNH != null) {
                this.bNH.bW(true);
            }
            if (this.bNI != null) {
                this.bNI.bW(true);
            }
            if (this.bNJ != null) {
                this.bNJ.bW(true);
            }
            if (this.bNK != null) {
                this.bNK.bW(true);
            }
            if (this.bNL != null) {
                this.bNL.bW(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.bjn);
    }
}
