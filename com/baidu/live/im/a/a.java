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
    private BdPageContext apm;
    private BdTypeListView apn;
    private f apo;
    private c apq;
    private g apr;
    private d aps;
    private e apt;
    private boolean apu;
    private List<AbsDelegateAdapter> apl = new ArrayList();
    private CustomMessageListener apv = new CustomMessageListener(0) { // from class: com.baidu.live.im.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.notifyDataSetChanged();
        }
    };

    public a(BdPageContext bdPageContext, BdTypeListView bdTypeListView) {
        this.apm = bdPageContext;
        this.apn = bdTypeListView;
        vi();
    }

    public void vh() {
        MessageManager.getInstance().registerListener(2913069, this.apv);
    }

    private void vi() {
        this.apo = new f(this.apm.getPageActivity());
        this.apq = new c(this.apm.getPageActivity());
        this.apr = new g(this.apm.getPageActivity());
        this.aps = new d(this.apm.getPageActivity());
        this.apt = new e(this.apm.getPageActivity());
        this.apl.add(this.apo);
        this.apl.add(this.apq);
        this.apl.add(this.apr);
        this.apl.add(this.aps);
        this.apl.add(this.apt);
        this.apn.addAdapters(this.apl);
    }

    public void setMode(boolean z) {
        this.apo.setMode(z);
    }

    public void setDatas(List<IAdapterData> list) {
        if (this.apn != null) {
            this.apn.setData(list);
        }
    }

    public void a(String str, String str2, boolean z, String str3) {
        for (AbsDelegateAdapter absDelegateAdapter : this.apl) {
            if (absDelegateAdapter instanceof b) {
                ((b) absDelegateAdapter).a(str, str2, z, str3);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.apn != null && (this.apn.getAdapter() instanceof BaseAdapter)) {
            this.apn.getAdapter().notifyDataSetChanged();
        }
    }

    public void setFromMaster(boolean z) {
        this.apu = z;
        if (this.apu) {
            if (this.apo != null) {
                this.apo.aS(true);
            }
            if (this.apq != null) {
                this.apq.aS(true);
            }
            if (this.apr != null) {
                this.apr.aS(true);
            }
            if (this.aps != null) {
                this.aps.aS(true);
            }
            if (this.apt != null) {
                this.apt.aS(true);
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.apv);
    }
}
