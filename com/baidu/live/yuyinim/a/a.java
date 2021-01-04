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
/* loaded from: classes11.dex */
public class a {
    private BdPageContext boN;
    private BdTypeListView boO;
    private boolean boU;
    private f cdv;
    private c cdw;
    private g cdx;
    private d cdy;
    private e cdz;
    private List<AbsDelegateAdapter> boM = new ArrayList();
    private CustomMessageListener boV = new CustomMessageListener(0) { // from class: com.baidu.live.yuyinim.a.a.1
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
    }

    private void MT() {
        this.cdv = new f(this.boN.getPageActivity());
        this.cdw = new c(this.boN.getPageActivity());
        this.cdx = new g(this.boN.getPageActivity());
        this.cdy = new d(this.boN.getPageActivity());
        this.cdz = new e(this.boN.getPageActivity());
        this.boM.add(this.cdv);
        this.boM.add(this.cdw);
        this.boM.add(this.cdx);
        this.boM.add(this.cdy);
        this.boM.add(this.cdz);
        this.boO.addAdapters(this.boM);
    }

    public void setMode(boolean z) {
        this.cdv.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.boO != null) {
            this.boO.setData(list);
        }
    }

    public void b(String str, String str2, boolean z, String str3) {
        for (AbsDelegateAdapter absDelegateAdapter : this.boM) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).b(str, str2, z, str3);
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
            if (this.cdv != null) {
                this.cdv.ci(true);
            }
            if (this.cdw != null) {
                this.cdw.ci(true);
            }
            if (this.cdx != null) {
                this.cdx.ci(true);
            }
            if (this.cdy != null) {
                this.cdy.ci(true);
            }
            if (this.cdz != null) {
                this.cdz.ci(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.boV);
    }
}
