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
    private BdPageContext bdW;
    private BdTypeListView bdX;
    private f bdY;
    private c bdZ;
    private g bea;
    private d beb;
    private e bec;
    private boolean bed;
    private List<AbsDelegateAdapter> bdV = new ArrayList();
    private CustomMessageListener bee = new CustomMessageListener(0) { // from class: com.baidu.live.im.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.notifyDataSetChanged();
        }
    };

    public a(BdPageContext bdPageContext, BdTypeListView bdTypeListView) {
        this.bdW = bdPageContext;
        this.bdX = bdTypeListView;
        JZ();
    }

    public void JY() {
        MessageManager.getInstance().registerListener(2913069, this.bee);
    }

    private void JZ() {
        this.bdY = new f(this.bdW.getPageActivity());
        this.bdZ = new c(this.bdW.getPageActivity());
        this.bea = new g(this.bdW.getPageActivity());
        this.beb = new d(this.bdW.getPageActivity());
        this.bec = new e(this.bdW.getPageActivity());
        this.bdV.add(this.bdY);
        this.bdV.add(this.bdZ);
        this.bdV.add(this.bea);
        this.bdV.add(this.beb);
        this.bdV.add(this.bec);
        this.bdX.addAdapters(this.bdV);
    }

    public void setMode(boolean z) {
        this.bdY.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.bdX != null) {
            this.bdX.setData(list);
        }
    }

    public void b(String str, String str2, boolean z, String str3) {
        for (AbsDelegateAdapter absDelegateAdapter : this.bdV) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).b(str, str2, z, str3);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.bdX != null && (this.bdX.getAdapter() instanceof BaseAdapter)) {
            this.bdX.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromMaster(boolean z) {
        this.bed = z;
        if (this.bed) {
            if (this.bdY != null) {
                this.bdY.bR(true);
            }
            if (this.bdZ != null) {
                this.bdZ.bR(true);
            }
            if (this.bea != null) {
                this.bea.bR(true);
            }
            if (this.beb != null) {
                this.beb.bR(true);
            }
            if (this.bec != null) {
                this.bec.bR(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.bee);
    }
}
