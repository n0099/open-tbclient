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
    private BdTypeListView bkA;
    private f bkB;
    private c bkC;
    private g bkD;
    private d bkE;
    private e bkF;
    private boolean bkG;
    private BdPageContext bkz;
    private List<AbsDelegateAdapter> bky = new ArrayList();
    private CustomMessageListener bkH = new CustomMessageListener(0) { // from class: com.baidu.live.im.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.notifyDataSetChanged();
        }
    };

    public a(BdPageContext bdPageContext, BdTypeListView bdTypeListView) {
        this.bkz = bdPageContext;
        this.bkA = bdTypeListView;
        LY();
    }

    public void KS() {
        MessageManager.getInstance().registerListener(2913069, this.bkH);
    }

    private void LY() {
        this.bkB = new f(this.bkz.getPageActivity());
        this.bkC = new c(this.bkz.getPageActivity());
        this.bkD = new g(this.bkz.getPageActivity());
        this.bkE = new d(this.bkz.getPageActivity());
        this.bkF = new e(this.bkz.getPageActivity());
        this.bky.add(this.bkB);
        this.bky.add(this.bkC);
        this.bky.add(this.bkD);
        this.bky.add(this.bkE);
        this.bky.add(this.bkF);
        this.bkA.addAdapters(this.bky);
    }

    public void setMode(boolean z) {
        this.bkB.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.bkA != null) {
            this.bkA.setData(list);
        }
    }

    public void b(String str, String str2, boolean z, String str3) {
        for (AbsDelegateAdapter absDelegateAdapter : this.bky) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).b(str, str2, z, str3);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.bkA != null && (this.bkA.getAdapter() instanceof BaseAdapter)) {
            this.bkA.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromMaster(boolean z) {
        this.bkG = z;
        if (this.bkG) {
            if (this.bkB != null) {
                this.bkB.bX(true);
            }
            if (this.bkC != null) {
                this.bkC.bX(true);
            }
            if (this.bkD != null) {
                this.bkD.bX(true);
            }
            if (this.bkE != null) {
                this.bkE.bX(true);
            }
            if (this.bkF != null) {
                this.bkF.bX(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.bkH);
    }
}
