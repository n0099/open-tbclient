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
    private BdPageContext biO;
    private BdTypeListView biP;
    private f biQ;
    private c biR;
    private g biS;
    private d biT;
    private e biU;
    private boolean biV;
    private List<AbsDelegateAdapter> biN = new ArrayList();
    private CustomMessageListener biW = new CustomMessageListener(0) { // from class: com.baidu.live.im.a.a.1
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
        this.biQ = new f(this.biO.getPageActivity());
        this.biR = new c(this.biO.getPageActivity());
        this.biS = new g(this.biO.getPageActivity());
        this.biT = new d(this.biO.getPageActivity());
        this.biU = new e(this.biO.getPageActivity());
        this.biN.add(this.biQ);
        this.biN.add(this.biR);
        this.biN.add(this.biS);
        this.biN.add(this.biT);
        this.biN.add(this.biU);
        this.biP.addAdapters(this.biN);
    }

    public void setMode(boolean z) {
        this.biQ.setMode(z);
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
            if (this.biQ != null) {
                this.biQ.bZ(true);
            }
            if (this.biR != null) {
                this.biR.bZ(true);
            }
            if (this.biS != null) {
                this.biS.bZ(true);
            }
            if (this.biT != null) {
                this.biT.bZ(true);
            }
            if (this.biU != null) {
                this.biU.bZ(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.biW);
    }
}
