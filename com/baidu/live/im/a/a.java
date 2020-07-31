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
    private BdPageContext aWg;
    private BdTypeListView aWh;
    private f aWi;
    private c aWj;
    private g aWk;
    private d aWl;
    private e aWm;
    private boolean aWn;
    private List<AbsDelegateAdapter> aWf = new ArrayList();
    private CustomMessageListener aWo = new CustomMessageListener(0) { // from class: com.baidu.live.im.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.notifyDataSetChanged();
        }
    };

    public a(BdPageContext bdPageContext, BdTypeListView bdTypeListView) {
        this.aWg = bdPageContext;
        this.aWh = bdTypeListView;
        DS();
    }

    public void DR() {
        MessageManager.getInstance().registerListener(2913069, this.aWo);
    }

    private void DS() {
        this.aWi = new f(this.aWg.getPageActivity());
        this.aWj = new c(this.aWg.getPageActivity());
        this.aWk = new g(this.aWg.getPageActivity());
        this.aWl = new d(this.aWg.getPageActivity());
        this.aWm = new e(this.aWg.getPageActivity());
        this.aWf.add(this.aWi);
        this.aWf.add(this.aWj);
        this.aWf.add(this.aWk);
        this.aWf.add(this.aWl);
        this.aWf.add(this.aWm);
        this.aWh.addAdapters(this.aWf);
    }

    public void setMode(boolean z) {
        this.aWi.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.aWh != null) {
            this.aWh.setData(list);
        }
    }

    public void a(String str, String str2, boolean z, String str3) {
        for (AbsDelegateAdapter absDelegateAdapter : this.aWf) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).a(str, str2, z, str3);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aWh != null && (this.aWh.getAdapter() instanceof BaseAdapter)) {
            this.aWh.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromMaster(boolean z) {
        this.aWn = z;
        if (this.aWn) {
            if (this.aWi != null) {
                this.aWi.bJ(true);
            }
            if (this.aWj != null) {
                this.aWj.bJ(true);
            }
            if (this.aWk != null) {
                this.aWk.bJ(true);
            }
            if (this.aWl != null) {
                this.aWl.bJ(true);
            }
            if (this.aWm != null) {
                this.aWm.bJ(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.aWo);
    }
}
