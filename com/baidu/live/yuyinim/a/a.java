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
    private f bTq;
    private c bTr;
    private g bTs;
    private d bTt;
    private e bTu;
    private BdTypeListView bkA;
    private boolean bkG;
    private BdPageContext bkz;
    private List<AbsDelegateAdapter> bky = new ArrayList();
    private CustomMessageListener bkH = new CustomMessageListener(0) { // from class: com.baidu.live.yuyinim.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.notifyDataSetChanged();
        }
    };

    public a(BdPageContext bdPageContext, BdTypeListView bdTypeListView) {
        this.bkz = bdPageContext;
        this.bkA = bdTypeListView;
        LY();
    }

    public void KS() {
        MessageManager.getInstance().registerListener(2913069, this.bkH);
    }

    private void LY() {
        this.bTq = new f(this.bkz.getPageActivity());
        this.bTr = new c(this.bkz.getPageActivity());
        this.bTs = new g(this.bkz.getPageActivity());
        this.bTt = new d(this.bkz.getPageActivity());
        this.bTu = new e(this.bkz.getPageActivity());
        this.bky.add(this.bTq);
        this.bky.add(this.bTr);
        this.bky.add(this.bTs);
        this.bky.add(this.bTt);
        this.bky.add(this.bTu);
        this.bkA.addAdapters(this.bky);
    }

    public void setMode(boolean z) {
        this.bTq.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.bkA != null) {
            this.bkA.setData(list);
        }
    }

    public void b(String str, String str2, boolean z, String str3) {
        for (AbsDelegateAdapter absDelegateAdapter : this.bky) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).b(str, str2, z, str3);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.bkA != null && (this.bkA.getAdapter() instanceof BaseAdapter)) {
            this.bkA.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromMaster(boolean z) {
        this.bkG = z;
        if (this.bkG) {
            if (this.bTq != null) {
                this.bTq.bX(true);
            }
            if (this.bTr != null) {
                this.bTr.bX(true);
            }
            if (this.bTs != null) {
                this.bTs.bX(true);
            }
            if (this.bTt != null) {
                this.bTt.bX(true);
            }
            if (this.bTu != null) {
                this.bTu.bX(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.bkH);
    }
}
