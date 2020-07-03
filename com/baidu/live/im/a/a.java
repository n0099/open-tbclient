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
    private BdPageContext aUQ;
    private BdTypeListView aUR;
    private f aUS;
    private c aUT;
    private g aUU;
    private d aUV;
    private e aUW;
    private boolean aUX;
    private List<AbsDelegateAdapter> aUP = new ArrayList();
    private CustomMessageListener aUY = new CustomMessageListener(0) { // from class: com.baidu.live.im.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.notifyDataSetChanged();
        }
    };

    public a(BdPageContext bdPageContext, BdTypeListView bdTypeListView) {
        this.aUQ = bdPageContext;
        this.aUR = bdTypeListView;
        Dz();
    }

    public void Dy() {
        MessageManager.getInstance().registerListener(2913069, this.aUY);
    }

    private void Dz() {
        this.aUS = new f(this.aUQ.getPageActivity());
        this.aUT = new c(this.aUQ.getPageActivity());
        this.aUU = new g(this.aUQ.getPageActivity());
        this.aUV = new d(this.aUQ.getPageActivity());
        this.aUW = new e(this.aUQ.getPageActivity());
        this.aUP.add(this.aUS);
        this.aUP.add(this.aUT);
        this.aUP.add(this.aUU);
        this.aUP.add(this.aUV);
        this.aUP.add(this.aUW);
        this.aUR.addAdapters(this.aUP);
    }

    public void setMode(boolean z) {
        this.aUS.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.aUR != null) {
            this.aUR.setData(list);
        }
    }

    public void a(String str, String str2, boolean z, String str3) {
        for (AbsDelegateAdapter absDelegateAdapter : this.aUP) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).a(str, str2, z, str3);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.aUR != null && (this.aUR.getAdapter() instanceof BaseAdapter)) {
            this.aUR.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromMaster(boolean z) {
        this.aUX = z;
        if (this.aUX) {
            if (this.aUS != null) {
                this.aUS.bG(true);
            }
            if (this.aUT != null) {
                this.aUT.bG(true);
            }
            if (this.aUU != null) {
                this.aUU.bG(true);
            }
            if (this.aUV != null) {
                this.aUV.bG(true);
            }
            if (this.aUW != null) {
                this.aUW.bG(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.aUY);
    }
}
