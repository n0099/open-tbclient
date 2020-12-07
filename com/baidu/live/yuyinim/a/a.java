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
    private f bWW;
    private c bWX;
    private g bWY;
    private d bWZ;
    private e bXa;
    private BdPageContext bng;
    private BdTypeListView bnh;
    private boolean bnn;
    private List<AbsDelegateAdapter> bnf = new ArrayList();
    private CustomMessageListener bno = new CustomMessageListener(0) { // from class: com.baidu.live.yuyinim.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.notifyDataSetChanged();
        }
    };

    public a(BdPageContext bdPageContext, BdTypeListView bdTypeListView) {
        this.bng = bdPageContext;
        this.bnh = bdTypeListView;
        Nt();
    }

    public void Ml() {
        MessageManager.getInstance().registerListener(2913069, this.bno);
    }

    private void Nt() {
        this.bWW = new f(this.bng.getPageActivity());
        this.bWX = new c(this.bng.getPageActivity());
        this.bWY = new g(this.bng.getPageActivity());
        this.bWZ = new d(this.bng.getPageActivity());
        this.bXa = new e(this.bng.getPageActivity());
        this.bnf.add(this.bWW);
        this.bnf.add(this.bWX);
        this.bnf.add(this.bWY);
        this.bnf.add(this.bWZ);
        this.bnf.add(this.bXa);
        this.bnh.addAdapters(this.bnf);
    }

    public void setMode(boolean z) {
        this.bWW.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.bnh != null) {
            this.bnh.setData(list);
        }
    }

    public void b(String str, String str2, boolean z, String str3) {
        for (AbsDelegateAdapter absDelegateAdapter : this.bnf) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).b(str, str2, z, str3);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.bnh != null && (this.bnh.getAdapter() instanceof BaseAdapter)) {
            this.bnh.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromMaster(boolean z) {
        this.bnn = z;
        if (this.bnn) {
            if (this.bWW != null) {
                this.bWW.ci(true);
            }
            if (this.bWX != null) {
                this.bWX.ci(true);
            }
            if (this.bWY != null) {
                this.bWY.ci(true);
            }
            if (this.bWZ != null) {
                this.bWZ.ci(true);
            }
            if (this.bXa != null) {
                this.bXa.ci(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.bno);
    }
}
