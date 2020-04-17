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
    private BdPageContext aMe;
    private BdTypeListView aMf;
    private f aMg;
    private c aMh;
    private g aMi;
    private d aMj;
    private e aMk;
    private boolean aMl;
    private List<AbsDelegateAdapter> aMd = new ArrayList();
    private CustomMessageListener aMm = new CustomMessageListener(0) { // from class: com.baidu.live.im.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.notifyDataSetChanged();
        }
    };

    public a(BdPageContext bdPageContext, BdTypeListView bdTypeListView) {
        this.aMe = bdPageContext;
        this.aMf = bdTypeListView;
        BC();
    }

    public void BB() {
        MessageManager.getInstance().registerListener(2913069, this.aMm);
    }

    private void BC() {
        this.aMg = new f(this.aMe.getPageActivity());
        this.aMh = new c(this.aMe.getPageActivity());
        this.aMi = new g(this.aMe.getPageActivity());
        this.aMj = new d(this.aMe.getPageActivity());
        this.aMk = new e(this.aMe.getPageActivity());
        this.aMd.add(this.aMg);
        this.aMd.add(this.aMh);
        this.aMd.add(this.aMi);
        this.aMd.add(this.aMj);
        this.aMd.add(this.aMk);
        this.aMf.addAdapters(this.aMd);
    }

    public void setMode(boolean z) {
        this.aMg.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.aMf != null) {
            this.aMf.setData(list);
        }
    }

    public void a(String str, String str2, boolean z, String str3) {
        for (AbsDelegateAdapter absDelegateAdapter : this.aMd) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).a(str, str2, z, str3);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aMf != null && (this.aMf.getAdapter() instanceof BaseAdapter)) {
            this.aMf.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromMaster(boolean z) {
        this.aMl = z;
        if (this.aMl) {
            if (this.aMg != null) {
                this.aMg.bx(true);
            }
            if (this.aMh != null) {
                this.aMh.bx(true);
            }
            if (this.aMi != null) {
                this.aMi.bx(true);
            }
            if (this.aMj != null) {
                this.aMj.bx(true);
            }
            if (this.aMk != null) {
                this.aMk.bx(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.aMm);
    }
}
