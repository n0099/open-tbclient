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
    private c bbA;
    private g bbB;
    private d bbC;
    private e bbD;
    private boolean bbE;
    private BdPageContext bbx;
    private BdTypeListView bby;
    private f bbz;
    private List<AbsDelegateAdapter> bbw = new ArrayList();
    private CustomMessageListener bbF = new CustomMessageListener(0) { // from class: com.baidu.live.im.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.notifyDataSetChanged();
        }
    };

    public a(BdPageContext bdPageContext, BdTypeListView bdTypeListView) {
        this.bbx = bdPageContext;
        this.bby = bdTypeListView;
        Jv();
    }

    public void Ju() {
        MessageManager.getInstance().registerListener(2913069, this.bbF);
    }

    private void Jv() {
        this.bbz = new f(this.bbx.getPageActivity());
        this.bbA = new c(this.bbx.getPageActivity());
        this.bbB = new g(this.bbx.getPageActivity());
        this.bbC = new d(this.bbx.getPageActivity());
        this.bbD = new e(this.bbx.getPageActivity());
        this.bbw.add(this.bbz);
        this.bbw.add(this.bbA);
        this.bbw.add(this.bbB);
        this.bbw.add(this.bbC);
        this.bbw.add(this.bbD);
        this.bby.addAdapters(this.bbw);
    }

    public void setMode(boolean z) {
        this.bbz.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.bby != null) {
            this.bby.setData(list);
        }
    }

    public void b(String str, String str2, boolean z, String str3) {
        for (AbsDelegateAdapter absDelegateAdapter : this.bbw) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).b(str, str2, z, str3);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.bby != null && (this.bby.getAdapter() instanceof BaseAdapter)) {
            this.bby.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromMaster(boolean z) {
        this.bbE = z;
        if (this.bbE) {
            if (this.bbz != null) {
                this.bbz.bP(true);
            }
            if (this.bbA != null) {
                this.bbA.bP(true);
            }
            if (this.bbB != null) {
                this.bbB.bP(true);
            }
            if (this.bbC != null) {
                this.bbC.bP(true);
            }
            if (this.bbD != null) {
                this.bbD.bP(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.bbF);
    }
}
