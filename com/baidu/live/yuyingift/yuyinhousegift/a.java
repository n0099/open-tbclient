package com.baidu.live.yuyingift.yuyinhousegift;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.yuyingift.a.c;
import com.baidu.live.yuyingift.b;
import com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private com.baidu.live.yuyingift.a bNq;
    private YuyinAlaRoomGiftView bNr;
    private List<c> bNs;
    private boolean bNt = false;
    private c bNu;
    private Context mContext;

    public a(Context context, com.baidu.live.yuyingift.a aVar) {
        this.mContext = context;
        this.bNq = aVar;
        initData();
        initView();
    }

    private void initView() {
        this.bNr = new YuyinAlaRoomGiftView(this.mContext);
        this.bNr.setCallBack(new YuyinAlaRoomGiftView.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.a.1
            @Override // com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftView.a
            public void onAnimEnd() {
                a.this.bNu = null;
                a.this.bNt = false;
                a.this.bNq.UX();
                a.this.VB();
            }
        });
    }

    private void initData() {
        this.bNs = new ArrayList();
    }

    private boolean c(c cVar, c cVar2) {
        return cVar != null && cVar2 != null && TextUtils.equals(cVar.giftId, cVar2.giftId) && TextUtils.equals(cVar.userId, cVar2.userId) && TextUtils.equals(cVar.bja, cVar2.bja);
    }

    public void h(c cVar) {
        if (cVar != null) {
            boolean c = c(cVar, this.bNu);
            boolean z = false;
            if (c) {
                b.a(this.bNu, cVar);
                z = this.bNr.s(cVar);
            }
            if (!c || !z) {
                if (TextUtils.equals(cVar.userId, TbadkCoreApplication.getCurrentAccount())) {
                    r(cVar);
                } else {
                    this.bNs.add(cVar);
                }
                play();
            }
        }
    }

    public void r(c cVar) {
        if (this.bNs == null) {
            this.bNs = new ArrayList();
        }
        if (cVar != null) {
            int i = 0;
            while (true) {
                if (i >= this.bNs.size()) {
                    i = 0;
                    break;
                } else if (!TextUtils.equals(this.bNs.get(i).userId, TbadkCoreApplication.getCurrentAccount())) {
                    break;
                } else {
                    i++;
                }
            }
            this.bNs.add(i, cVar);
        }
    }

    public void play() {
        if (!this.bNt) {
            VB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VB() {
        this.bNu = VC();
        if (this.bNu != null) {
            Iterator<c> it = this.bNs.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (!c(this.bNu, next)) {
                    break;
                }
                b.a(this.bNu, next);
                this.bNu.aZP += next.aZP;
                it.remove();
            }
            this.bNt = true;
            this.bNr.setData(this.bNu);
            this.bNq.a(this.bNr, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    private c VC() {
        if (this.bNs.isEmpty()) {
            return null;
        }
        return this.bNs.remove(0);
    }

    public void onDestory() {
        if (this.bNs != null) {
            this.bNs.clear();
        }
        if (this.bNr != null) {
            this.bNr.onDestory();
        }
    }
}
