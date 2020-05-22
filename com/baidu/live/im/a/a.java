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
/* loaded from: classes3.dex */
public class a {
    private BdPageContext aSk;
    private BdTypeListView aSl;
    private f aSm;
    private c aSn;
    private g aSo;
    private d aSp;
    private e aSq;
    private boolean aSr;
    private List<AbsDelegateAdapter> aSj = new ArrayList();
    private CustomMessageListener aSs = new CustomMessageListener(0) { // from class: com.baidu.live.im.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.notifyDataSetChanged();
        }
    };

    public a(BdPageContext bdPageContext, BdTypeListView bdTypeListView) {
        this.aSk = bdPageContext;
        this.aSl = bdTypeListView;
        CY();
    }

    public void CX() {
        MessageManager.getInstance().registerListener(2913069, this.aSs);
    }

    private void CY() {
        this.aSm = new f(this.aSk.getPageActivity());
        this.aSn = new c(this.aSk.getPageActivity());
        this.aSo = new g(this.aSk.getPageActivity());
        this.aSp = new d(this.aSk.getPageActivity());
        this.aSq = new e(this.aSk.getPageActivity());
        this.aSj.add(this.aSm);
        this.aSj.add(this.aSn);
        this.aSj.add(this.aSo);
        this.aSj.add(this.aSp);
        this.aSj.add(this.aSq);
        this.aSl.addAdapters(this.aSj);
    }

    public void setMode(boolean z) {
        this.aSm.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.aSl != null) {
            this.aSl.setData(list);
        }
    }

    public void a(String str, String str2, boolean z, String str3) {
        for (AbsDelegateAdapter absDelegateAdapter : this.aSj) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).a(str, str2, z, str3);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aSl != null && (this.aSl.getAdapter() instanceof BaseAdapter)) {
            this.aSl.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromMaster(boolean z) {
        this.aSr = z;
        if (this.aSr) {
            if (this.aSm != null) {
                this.aSm.bG(true);
            }
            if (this.aSn != null) {
                this.aSn.bG(true);
            }
            if (this.aSo != null) {
                this.aSo.bG(true);
            }
            if (this.aSp != null) {
                this.aSp.bG(true);
            }
            if (this.aSq != null) {
                this.aSq.bG(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.aSs);
    }
}
