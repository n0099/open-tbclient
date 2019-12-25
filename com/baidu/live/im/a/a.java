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
/* loaded from: classes2.dex */
public class a {
    private BdPageContext aoA;
    private BdTypeListView aoB;
    private f aoC;
    private c aoD;
    private g aoE;
    private d aoF;
    private e aoG;
    private boolean aoH;
    private List<AbsDelegateAdapter> aoz = new ArrayList();
    private CustomMessageListener aoI = new CustomMessageListener(0) { // from class: com.baidu.live.im.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.notifyDataSetChanged();
        }
    };

    public a(BdPageContext bdPageContext, BdTypeListView bdTypeListView) {
        this.aoA = bdPageContext;
        this.aoB = bdTypeListView;
        uR();
    }

    public void uQ() {
        MessageManager.getInstance().registerListener(2913069, this.aoI);
    }

    private void uR() {
        this.aoC = new f(this.aoA.getPageActivity());
        this.aoD = new c(this.aoA.getPageActivity());
        this.aoE = new g(this.aoA.getPageActivity());
        this.aoF = new d(this.aoA.getPageActivity());
        this.aoG = new e(this.aoA.getPageActivity());
        this.aoz.add(this.aoC);
        this.aoz.add(this.aoD);
        this.aoz.add(this.aoE);
        this.aoz.add(this.aoF);
        this.aoz.add(this.aoG);
        this.aoB.addAdapters(this.aoz);
    }

    public void setMode(boolean z) {
        this.aoC.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.aoB != null) {
            this.aoB.setData(list);
        }
    }

    public void a(String str, String str2, boolean z, String str3) {
        for (AbsDelegateAdapter absDelegateAdapter : this.aoz) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).a(str, str2, z, str3);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aoB != null && (this.aoB.getAdapter() instanceof BaseAdapter)) {
            this.aoB.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromMaster(boolean z) {
        this.aoH = z;
        if (this.aoH) {
            if (this.aoC != null) {
                this.aoC.aQ(true);
            }
            if (this.aoD != null) {
                this.aoD.aQ(true);
            }
            if (this.aoE != null) {
                this.aoE.aQ(true);
            }
            if (this.aoF != null) {
                this.aoF.aQ(true);
            }
            if (this.aoG != null) {
                this.aoG.aQ(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.aoI);
    }
}
