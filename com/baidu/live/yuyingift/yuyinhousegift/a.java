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
    private com.baidu.live.yuyingift.a bRp;
    private YuyinAlaRoomGiftView bRq;
    private List<c> bRr;
    private boolean bRs = false;
    private c bRt;
    private Context mContext;

    public a(Context context, com.baidu.live.yuyingift.a aVar) {
        this.mContext = context;
        this.bRp = aVar;
        initData();
        initView();
    }

    private void initView() {
        this.bRq = new YuyinAlaRoomGiftView(this.mContext);
        this.bRq.setCallBack(new YuyinAlaRoomGiftView.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.a.1
            @Override // com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftView.a
            public void onAnimEnd() {
                a.this.bRt = null;
                a.this.bRs = false;
                a.this.bRp.WN();
                a.this.Xr();
            }
        });
    }

    private void initData() {
        this.bRr = new ArrayList();
    }

    private boolean c(c cVar, c cVar2) {
        return cVar != null && cVar2 != null && TextUtils.equals(cVar.giftId, cVar2.giftId) && TextUtils.equals(cVar.userId, cVar2.userId) && TextUtils.equals(cVar.biJ, cVar2.biJ);
    }

    public void h(c cVar) {
        if (cVar != null) {
            boolean c = c(cVar, this.bRt);
            boolean z = false;
            if (c) {
                b.a(this.bRt, cVar);
                z = this.bRq.s(cVar);
            }
            if (!c || !z) {
                if (TextUtils.equals(cVar.userId, TbadkCoreApplication.getCurrentAccount())) {
                    r(cVar);
                } else {
                    this.bRr.add(cVar);
                }
                play();
            }
        }
    }

    public void r(c cVar) {
        if (this.bRr == null) {
            this.bRr = new ArrayList();
        }
        if (cVar != null) {
            int i = 0;
            while (true) {
                if (i >= this.bRr.size()) {
                    i = 0;
                    break;
                } else if (!TextUtils.equals(this.bRr.get(i).userId, TbadkCoreApplication.getCurrentAccount())) {
                    break;
                } else {
                    i++;
                }
            }
            this.bRr.add(i, cVar);
        }
    }

    public void play() {
        if (!this.bRs) {
            Xr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xr() {
        this.bRt = Xs();
        if (this.bRt != null) {
            Iterator<c> it = this.bRr.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (!c(this.bRt, next)) {
                    break;
                }
                b.a(this.bRt, next);
                this.bRt.aZw += next.aZw;
                it.remove();
            }
            this.bRs = true;
            this.bRq.setData(this.bRt);
            this.bRp.a(this.bRq, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    private c Xs() {
        if (this.bRr.isEmpty()) {
            return null;
        }
        return this.bRr.remove(0);
    }

    public void onDestory() {
        if (this.bRr != null) {
            this.bRr.clear();
        }
        if (this.bRq != null) {
            this.bRq.onDestory();
        }
    }
}
