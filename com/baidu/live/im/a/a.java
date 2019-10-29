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
/* loaded from: classes6.dex */
public class a {
    private BdPageContext agR;
    private BdTypeListView agS;
    private f agT;
    private c agU;
    private g agV;
    private d agW;
    private e agX;
    private boolean agY;
    private List<AbsDelegateAdapter> agQ = new ArrayList();
    private CustomMessageListener agZ = new CustomMessageListener(0) { // from class: com.baidu.live.im.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.notifyDataSetChanged();
        }
    };

    public a(BdPageContext bdPageContext, BdTypeListView bdTypeListView) {
        this.agR = bdPageContext;
        this.agS = bdTypeListView;
        sX();
    }

    public void sW() {
        MessageManager.getInstance().registerListener(2913069, this.agZ);
    }

    private void sX() {
        this.agT = new f(this.agR.getPageActivity());
        this.agU = new c(this.agR.getPageActivity());
        this.agV = new g(this.agR.getPageActivity());
        this.agW = new d(this.agR.getPageActivity());
        this.agX = new e(this.agR.getPageActivity());
        this.agQ.add(this.agT);
        this.agQ.add(this.agU);
        this.agQ.add(this.agV);
        this.agQ.add(this.agW);
        this.agQ.add(this.agX);
        this.agS.addAdapters(this.agQ);
    }

    public void setMode(boolean z) {
        this.agT.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.agS != null) {
            this.agS.setData(list);
        }
    }

    public void a(String str, String str2, boolean z, String str3) {
        for (AbsDelegateAdapter absDelegateAdapter : this.agQ) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).a(str, str2, z, str3);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.agS != null && (this.agS.getAdapter() instanceof BaseAdapter)) {
            this.agS.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromMaster(boolean z) {
        this.agY = z;
        if (this.agY) {
            if (this.agT != null) {
                this.agT.az(true);
            }
            if (this.agU != null) {
                this.agU.az(true);
            }
            if (this.agV != null) {
                this.agV.az(true);
            }
            if (this.agW != null) {
                this.agW.az(true);
            }
            if (this.agX != null) {
                this.agX.az(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.agZ);
    }
}
