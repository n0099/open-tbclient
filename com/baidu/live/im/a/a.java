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
/* loaded from: classes7.dex */
public class a {
    private d bbA;
    private e bbB;
    private boolean bbC;
    private BdPageContext bbv;
    private BdTypeListView bbw;
    private f bbx;
    private c bby;
    private g bbz;
    private List<AbsDelegateAdapter> bbu = new ArrayList();
    private CustomMessageListener bbD = new CustomMessageListener(0) { // from class: com.baidu.live.im.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.notifyDataSetChanged();
        }
    };

    public a(BdPageContext bdPageContext, BdTypeListView bdTypeListView) {
        this.bbv = bdPageContext;
        this.bbw = bdTypeListView;
        Jv();
    }

    public void Ju() {
        MessageManager.getInstance().registerListener(2913069, this.bbD);
    }

    private void Jv() {
        this.bbx = new f(this.bbv.getPageActivity());
        this.bby = new c(this.bbv.getPageActivity());
        this.bbz = new g(this.bbv.getPageActivity());
        this.bbA = new d(this.bbv.getPageActivity());
        this.bbB = new e(this.bbv.getPageActivity());
        this.bbu.add(this.bbx);
        this.bbu.add(this.bby);
        this.bbu.add(this.bbz);
        this.bbu.add(this.bbA);
        this.bbu.add(this.bbB);
        this.bbw.addAdapters(this.bbu);
    }

    public void setMode(boolean z) {
        this.bbx.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.bbw != null) {
            this.bbw.setData(list);
        }
    }

    public void b(String str, String str2, boolean z, String str3) {
        for (AbsDelegateAdapter absDelegateAdapter : this.bbu) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).b(str, str2, z, str3);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.bbw != null && (this.bbw.getAdapter() instanceof BaseAdapter)) {
            this.bbw.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromMaster(boolean z) {
        this.bbC = z;
        if (this.bbC) {
            if (this.bbx != null) {
                this.bbx.bP(true);
            }
            if (this.bby != null) {
                this.bby.bP(true);
            }
            if (this.bbz != null) {
                this.bbz.bP(true);
            }
            if (this.bbA != null) {
                this.bbA.bP(true);
            }
            if (this.bbB != null) {
                this.bbB.bP(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.bbD);
    }
}
