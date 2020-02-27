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
    private BdPageContext asF;
    private BdTypeListView asG;
    private f asH;
    private c asI;
    private g asJ;
    private d asK;
    private e asL;
    private boolean asM;
    private List<AbsDelegateAdapter> asE = new ArrayList();
    private CustomMessageListener asN = new CustomMessageListener(0) { // from class: com.baidu.live.im.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.notifyDataSetChanged();
        }
    };

    public a(BdPageContext bdPageContext, BdTypeListView bdTypeListView) {
        this.asF = bdPageContext;
        this.asG = bdTypeListView;
        wM();
    }

    public void wL() {
        MessageManager.getInstance().registerListener(2913069, this.asN);
    }

    private void wM() {
        this.asH = new f(this.asF.getPageActivity());
        this.asI = new c(this.asF.getPageActivity());
        this.asJ = new g(this.asF.getPageActivity());
        this.asK = new d(this.asF.getPageActivity());
        this.asL = new e(this.asF.getPageActivity());
        this.asE.add(this.asH);
        this.asE.add(this.asI);
        this.asE.add(this.asJ);
        this.asE.add(this.asK);
        this.asE.add(this.asL);
        this.asG.addAdapters(this.asE);
    }

    public void setMode(boolean z) {
        this.asH.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.asG != null) {
            this.asG.setData(list);
        }
    }

    public void a(String str, String str2, boolean z, String str3) {
        for (AbsDelegateAdapter absDelegateAdapter : this.asE) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).a(str, str2, z, str3);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.asG != null && (this.asG.getAdapter() instanceof BaseAdapter)) {
            this.asG.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromMaster(boolean z) {
        this.asM = z;
        if (this.asM) {
            if (this.asH != null) {
                this.asH.aV(true);
            }
            if (this.asI != null) {
                this.asI.aV(true);
            }
            if (this.asJ != null) {
                this.asJ.aV(true);
            }
            if (this.asK != null) {
                this.asK.aV(true);
            }
            if (this.asL != null) {
                this.asL.aV(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.asN);
    }
}
