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
    private BdTypeListView agA;
    private f agB;
    private c agC;
    private g agD;
    private d agE;
    private e agF;
    private boolean agG;
    private BdPageContext agz;
    private List<AbsDelegateAdapter> agy = new ArrayList();
    private CustomMessageListener agH = new CustomMessageListener(0) { // from class: com.baidu.live.im.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.notifyDataSetChanged();
        }
    };

    public a(BdPageContext bdPageContext, BdTypeListView bdTypeListView) {
        this.agz = bdPageContext;
        this.agA = bdTypeListView;
        sY();
    }

    public void sX() {
        MessageManager.getInstance().registerListener(2913069, this.agH);
    }

    private void sY() {
        this.agB = new f(this.agz.getPageActivity());
        this.agC = new c(this.agz.getPageActivity());
        this.agD = new g(this.agz.getPageActivity());
        this.agE = new d(this.agz.getPageActivity());
        this.agF = new e(this.agz.getPageActivity());
        this.agy.add(this.agB);
        this.agy.add(this.agC);
        this.agy.add(this.agD);
        this.agy.add(this.agE);
        this.agy.add(this.agF);
        this.agA.addAdapters(this.agy);
    }

    public void setMode(boolean z) {
        this.agB.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.agA != null) {
            this.agA.setData(list);
        }
    }

    public void a(String str, String str2, boolean z, String str3) {
        for (AbsDelegateAdapter absDelegateAdapter : this.agy) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).a(str, str2, z, str3);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.agA != null && (this.agA.getAdapter() instanceof BaseAdapter)) {
            this.agA.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromMaster(boolean z) {
        this.agG = z;
        if (this.agG) {
            if (this.agB != null) {
                this.agB.az(true);
            }
            if (this.agC != null) {
                this.agC.az(true);
            }
            if (this.agD != null) {
                this.agD.az(true);
            }
            if (this.agE != null) {
                this.agE.az(true);
            }
            if (this.agF != null) {
                this.agF.az(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.agH);
    }
}
