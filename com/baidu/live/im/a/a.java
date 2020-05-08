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
    private BdPageContext aMk;
    private BdTypeListView aMl;
    private f aMm;
    private c aMn;
    private g aMo;
    private d aMp;
    private e aMq;
    private boolean aMr;
    private List<AbsDelegateAdapter> aMj = new ArrayList();
    private CustomMessageListener aMs = new CustomMessageListener(0) { // from class: com.baidu.live.im.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.notifyDataSetChanged();
        }
    };

    public a(BdPageContext bdPageContext, BdTypeListView bdTypeListView) {
        this.aMk = bdPageContext;
        this.aMl = bdTypeListView;
        BB();
    }

    public void BA() {
        MessageManager.getInstance().registerListener(2913069, this.aMs);
    }

    private void BB() {
        this.aMm = new f(this.aMk.getPageActivity());
        this.aMn = new c(this.aMk.getPageActivity());
        this.aMo = new g(this.aMk.getPageActivity());
        this.aMp = new d(this.aMk.getPageActivity());
        this.aMq = new e(this.aMk.getPageActivity());
        this.aMj.add(this.aMm);
        this.aMj.add(this.aMn);
        this.aMj.add(this.aMo);
        this.aMj.add(this.aMp);
        this.aMj.add(this.aMq);
        this.aMl.addAdapters(this.aMj);
    }

    public void setMode(boolean z) {
        this.aMm.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.aMl != null) {
            this.aMl.setData(list);
        }
    }

    public void a(String str, String str2, boolean z, String str3) {
        for (AbsDelegateAdapter absDelegateAdapter : this.aMj) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).a(str, str2, z, str3);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aMl != null && (this.aMl.getAdapter() instanceof BaseAdapter)) {
            this.aMl.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromMaster(boolean z) {
        this.aMr = z;
        if (this.aMr) {
            if (this.aMm != null) {
                this.aMm.bx(true);
            }
            if (this.aMn != null) {
                this.aMn.bx(true);
            }
            if (this.aMo != null) {
                this.aMo.bx(true);
            }
            if (this.aMp != null) {
                this.aMp.bx(true);
            }
            if (this.aMq != null) {
                this.aMq.bx(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.aMs);
    }
}
