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
    private BdPageContext bhI;
    private BdTypeListView bhJ;
    private f bhK;
    private c bhL;
    private g bhM;
    private d bhN;
    private e bhO;
    private boolean bhP;
    private List<AbsDelegateAdapter> bhH = new ArrayList();
    private CustomMessageListener bhQ = new CustomMessageListener(0) { // from class: com.baidu.live.im.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.notifyDataSetChanged();
        }
    };

    public a(BdPageContext bdPageContext, BdTypeListView bdTypeListView) {
        this.bhI = bdPageContext;
        this.bhJ = bdTypeListView;
        Le();
    }

    public void JY() {
        MessageManager.getInstance().registerListener(2913069, this.bhQ);
    }

    private void Le() {
        this.bhK = new f(this.bhI.getPageActivity());
        this.bhL = new c(this.bhI.getPageActivity());
        this.bhM = new g(this.bhI.getPageActivity());
        this.bhN = new d(this.bhI.getPageActivity());
        this.bhO = new e(this.bhI.getPageActivity());
        this.bhH.add(this.bhK);
        this.bhH.add(this.bhL);
        this.bhH.add(this.bhM);
        this.bhH.add(this.bhN);
        this.bhH.add(this.bhO);
        this.bhJ.addAdapters(this.bhH);
    }

    public void setMode(boolean z) {
        this.bhK.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.bhJ != null) {
            this.bhJ.setData(list);
        }
    }

    public void b(String str, String str2, boolean z, String str3) {
        for (AbsDelegateAdapter absDelegateAdapter : this.bhH) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).b(str, str2, z, str3);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.bhJ != null && (this.bhJ.getAdapter() instanceof BaseAdapter)) {
            this.bhJ.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromMaster(boolean z) {
        this.bhP = z;
        if (this.bhP) {
            if (this.bhK != null) {
                this.bhK.bU(true);
            }
            if (this.bhL != null) {
                this.bhL.bU(true);
            }
            if (this.bhM != null) {
                this.bhM.bU(true);
            }
            if (this.bhN != null) {
                this.bhN.bU(true);
            }
            if (this.bhO != null) {
                this.bhO.bU(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.bhQ);
    }
}
