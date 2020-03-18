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
    private BdPageContext asQ;
    private BdTypeListView asR;
    private f asS;
    private c asT;
    private g asU;
    private d asV;
    private e asW;
    private boolean asX;
    private List<AbsDelegateAdapter> asP = new ArrayList();
    private CustomMessageListener asY = new CustomMessageListener(0) { // from class: com.baidu.live.im.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.notifyDataSetChanged();
        }
    };

    public a(BdPageContext bdPageContext, BdTypeListView bdTypeListView) {
        this.asQ = bdPageContext;
        this.asR = bdTypeListView;
        wR();
    }

    public void wQ() {
        MessageManager.getInstance().registerListener(2913069, this.asY);
    }

    private void wR() {
        this.asS = new f(this.asQ.getPageActivity());
        this.asT = new c(this.asQ.getPageActivity());
        this.asU = new g(this.asQ.getPageActivity());
        this.asV = new d(this.asQ.getPageActivity());
        this.asW = new e(this.asQ.getPageActivity());
        this.asP.add(this.asS);
        this.asP.add(this.asT);
        this.asP.add(this.asU);
        this.asP.add(this.asV);
        this.asP.add(this.asW);
        this.asR.addAdapters(this.asP);
    }

    public void setMode(boolean z) {
        this.asS.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.asR != null) {
            this.asR.setData(list);
        }
    }

    public void a(String str, String str2, boolean z, String str3) {
        for (AbsDelegateAdapter absDelegateAdapter : this.asP) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).a(str, str2, z, str3);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.asR != null && (this.asR.getAdapter() instanceof BaseAdapter)) {
            this.asR.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromMaster(boolean z) {
        this.asX = z;
        if (this.asX) {
            if (this.asS != null) {
                this.asS.aV(true);
            }
            if (this.asT != null) {
                this.asT.aV(true);
            }
            if (this.asU != null) {
                this.asU.aV(true);
            }
            if (this.asV != null) {
                this.asV.aV(true);
            }
            if (this.asW != null) {
                this.asW.aV(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.asY);
    }
}
