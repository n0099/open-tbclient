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
/* loaded from: classes10.dex */
public class a {
    private BdPageContext boT;
    private BdTypeListView boU;
    private f boV;
    private c boW;
    private g boX;
    private d boY;
    private e boZ;
    private boolean bpa;
    private List<AbsDelegateAdapter> boS = new ArrayList();
    private CustomMessageListener bpb = new CustomMessageListener(0) { // from class: com.baidu.live.im.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.notifyDataSetChanged();
        }
    };

    public a(BdPageContext bdPageContext, BdTypeListView bdTypeListView) {
        this.boT = bdPageContext;
        this.boU = bdTypeListView;
        Kz();
    }

    public void Jj() {
        MessageManager.getInstance().registerListener(2913069, this.bpb);
        if (this.boV != null) {
            MessageManager.getInstance().registerListener(this.boV.bqe);
            MessageManager.getInstance().registerListener(this.boV.bqd);
        }
    }

    private void Kz() {
        this.boV = new f(this.boT);
        this.boW = new c(this.boT.getPageActivity());
        this.boX = new g(this.boT.getPageActivity());
        this.boY = new d(this.boT.getPageActivity());
        this.boZ = new e(this.boT.getPageActivity());
        this.boS.add(this.boV);
        this.boS.add(this.boW);
        this.boS.add(this.boX);
        this.boS.add(this.boY);
        this.boS.add(this.boZ);
        this.boU.addAdapters(this.boS);
    }

    public void setMode(boolean z) {
        this.boV.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.boU != null) {
            this.boU.setData(list);
        }
    }

    public void a(String str, String str2, boolean z, String str3, String str4) {
        for (AbsDelegateAdapter absDelegateAdapter : this.boS) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).a(str, str2, z, str3, str4);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.boU != null && (this.boU.getAdapter() instanceof BaseAdapter)) {
            this.boU.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromMaster(boolean z) {
        this.bpa = z;
        if (this.bpa) {
            if (this.boV != null) {
                this.boV.cm(true);
            }
            if (this.boW != null) {
                this.boW.cm(true);
            }
            if (this.boX != null) {
                this.boX.cm(true);
            }
            if (this.boY != null) {
                this.boY.cm(true);
            }
            if (this.boZ != null) {
                this.boZ.cm(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.bpb);
        if (this.boV != null) {
            this.boV.KM();
        }
    }
}
