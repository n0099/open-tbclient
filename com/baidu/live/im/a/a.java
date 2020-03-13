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
    private BdPageContext asG;
    private BdTypeListView asH;
    private f asI;
    private c asJ;
    private g asK;
    private d asL;
    private e asM;
    private boolean asN;
    private List<AbsDelegateAdapter> asF = new ArrayList();
    private CustomMessageListener asO = new CustomMessageListener(0) { // from class: com.baidu.live.im.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.notifyDataSetChanged();
        }
    };

    public a(BdPageContext bdPageContext, BdTypeListView bdTypeListView) {
        this.asG = bdPageContext;
        this.asH = bdTypeListView;
        wM();
    }

    public void wL() {
        MessageManager.getInstance().registerListener(2913069, this.asO);
    }

    private void wM() {
        this.asI = new f(this.asG.getPageActivity());
        this.asJ = new c(this.asG.getPageActivity());
        this.asK = new g(this.asG.getPageActivity());
        this.asL = new d(this.asG.getPageActivity());
        this.asM = new e(this.asG.getPageActivity());
        this.asF.add(this.asI);
        this.asF.add(this.asJ);
        this.asF.add(this.asK);
        this.asF.add(this.asL);
        this.asF.add(this.asM);
        this.asH.addAdapters(this.asF);
    }

    public void setMode(boolean z) {
        this.asI.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.asH != null) {
            this.asH.setData(list);
        }
    }

    public void a(String str, String str2, boolean z, String str3) {
        for (AbsDelegateAdapter absDelegateAdapter : this.asF) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).a(str, str2, z, str3);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.asH != null && (this.asH.getAdapter() instanceof BaseAdapter)) {
            this.asH.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromMaster(boolean z) {
        this.asN = z;
        if (this.asN) {
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
            if (this.asM != null) {
                this.asM.aV(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.asO);
    }
}
