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
    private f bRG;
    private c bRH;
    private g bRI;
    private d bRJ;
    private e bRK;
    private BdPageContext biO;
    private BdTypeListView biP;
    private boolean biV;
    private List<AbsDelegateAdapter> biN = new ArrayList();
    private CustomMessageListener biW = new CustomMessageListener(0) { // from class: com.baidu.live.yuyinim.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.notifyDataSetChanged();
        }
    };

    public a(BdPageContext bdPageContext, BdTypeListView bdTypeListView) {
        this.biO = bdPageContext;
        this.biP = bdTypeListView;
        Lp();
    }

    public void Kj() {
        MessageManager.getInstance().registerListener(2913069, this.biW);
    }

    private void Lp() {
        this.bRG = new f(this.biO.getPageActivity());
        this.bRH = new c(this.biO.getPageActivity());
        this.bRI = new g(this.biO.getPageActivity());
        this.bRJ = new d(this.biO.getPageActivity());
        this.bRK = new e(this.biO.getPageActivity());
        this.biN.add(this.bRG);
        this.biN.add(this.bRH);
        this.biN.add(this.bRI);
        this.biN.add(this.bRJ);
        this.biN.add(this.bRK);
        this.biP.addAdapters(this.biN);
    }

    public void setMode(boolean z) {
        this.bRG.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.biP != null) {
            this.biP.setData(list);
        }
    }

    public void b(String str, String str2, boolean z, String str3) {
        for (AbsDelegateAdapter absDelegateAdapter : this.biN) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).b(str, str2, z, str3);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.biP != null && (this.biP.getAdapter() instanceof BaseAdapter)) {
            this.biP.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromMaster(boolean z) {
        this.biV = z;
        if (this.biV) {
            if (this.bRG != null) {
                this.bRG.bZ(true);
            }
            if (this.bRH != null) {
                this.bRH.bZ(true);
            }
            if (this.bRI != null) {
                this.bRI.bZ(true);
            }
            if (this.bRJ != null) {
                this.bRJ.bZ(true);
            }
            if (this.bRK != null) {
                this.bRK.bZ(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.biW);
    }
}
