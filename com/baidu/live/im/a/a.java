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
    private BdPageContext boN;
    private BdTypeListView boO;
    private f boP;
    private c boQ;
    private g boR;
    private d boS;
    private e boT;
    private boolean boU;
    private List<AbsDelegateAdapter> boM = new ArrayList();
    private CustomMessageListener boV = new CustomMessageListener(0) { // from class: com.baidu.live.im.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.notifyDataSetChanged();
        }
    };

    public a(BdPageContext bdPageContext, BdTypeListView bdTypeListView) {
        this.boN = bdPageContext;
        this.boO = bdTypeListView;
        MT();
    }

    public void LI() {
        MessageManager.getInstance().registerListener(2913069, this.boV);
        if (this.boP != null) {
            MessageManager.getInstance().registerListener(this.boP.bpW);
        }
    }

    private void MT() {
        this.boP = new f(this.boN);
        this.boQ = new c(this.boN.getPageActivity());
        this.boR = new g(this.boN.getPageActivity());
        this.boS = new d(this.boN.getPageActivity());
        this.boT = new e(this.boN.getPageActivity());
        this.boM.add(this.boP);
        this.boM.add(this.boQ);
        this.boM.add(this.boR);
        this.boM.add(this.boS);
        this.boM.add(this.boT);
        this.boO.addAdapters(this.boM);
    }

    public void setMode(boolean z) {
        this.boP.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.boO != null) {
            this.boO.setData(list);
        }
    }

    public void a(String str, String str2, boolean z, String str3, String str4) {
        for (AbsDelegateAdapter absDelegateAdapter : this.boM) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).a(str, str2, z, str3, str4);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.boO != null && (this.boO.getAdapter() instanceof BaseAdapter)) {
            this.boO.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromMaster(boolean z) {
        this.boU = z;
        if (this.boU) {
            if (this.boP != null) {
                this.boP.ci(true);
            }
            if (this.boQ != null) {
                this.boQ.ci(true);
            }
            if (this.boR != null) {
                this.boR.ci(true);
            }
            if (this.boS != null) {
                this.boS.ci(true);
            }
            if (this.boT != null) {
                this.boT.ci(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.boV);
        if (this.boP != null) {
            this.boP.Ng();
        }
    }
}
