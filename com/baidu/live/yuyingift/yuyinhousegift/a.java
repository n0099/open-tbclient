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
    private com.baidu.live.yuyingift.a bSZ;
    private YuyinAlaRoomGiftView bTa;
    private List<c> bTb;
    private boolean bTc = false;
    private c bTd;
    private Context mContext;

    public a(Context context, com.baidu.live.yuyingift.a aVar) {
        this.mContext = context;
        this.bSZ = aVar;
        initData();
        initView();
    }

    private void initView() {
        this.bTa = new YuyinAlaRoomGiftView(this.mContext);
        this.bTa.setCallBack(new YuyinAlaRoomGiftView.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.a.1
            @Override // com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftView.a
            public void onAnimEnd() {
                a.this.bTd = null;
                a.this.bTc = false;
                a.this.bSZ.Xw();
                a.this.Ya();
            }
        });
    }

    private void initData() {
        this.bTb = new ArrayList();
    }

    private boolean c(c cVar, c cVar2) {
        return cVar != null && cVar2 != null && TextUtils.equals(cVar.giftId, cVar2.giftId) && TextUtils.equals(cVar.userId, cVar2.userId) && TextUtils.equals(cVar.bku, cVar2.bku);
    }

    public void h(c cVar) {
        if (cVar != null) {
            boolean c = c(cVar, this.bTd);
            boolean z = false;
            if (c) {
                b.a(this.bTd, cVar);
                z = this.bTa.s(cVar);
            }
            if (!c || !z) {
                if (TextUtils.equals(cVar.userId, TbadkCoreApplication.getCurrentAccount())) {
                    r(cVar);
                } else {
                    this.bTb.add(cVar);
                }
                play();
            }
        }
    }

    public void r(c cVar) {
        if (this.bTb == null) {
            this.bTb = new ArrayList();
        }
        if (cVar != null) {
            int i = 0;
            while (true) {
                if (i >= this.bTb.size()) {
                    i = 0;
                    break;
                } else if (!TextUtils.equals(this.bTb.get(i).userId, TbadkCoreApplication.getCurrentAccount())) {
                    break;
                } else {
                    i++;
                }
            }
            this.bTb.add(i, cVar);
        }
    }

    public void play() {
        if (!this.bTc) {
            Ya();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ya() {
        this.bTd = Yb();
        if (this.bTd != null) {
            Iterator<c> it = this.bTb.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (!c(this.bTd, next)) {
                    break;
                }
                b.a(this.bTd, next);
                this.bTd.bbi += next.bbi;
                it.remove();
            }
            this.bTc = true;
            this.bTa.setData(this.bTd);
            this.bSZ.a(this.bTa, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    private c Yb() {
        if (this.bTb.isEmpty()) {
            return null;
        }
        return this.bTb.remove(0);
    }

    public void onDestory() {
        if (this.bTb != null) {
            this.bTb.clear();
        }
        if (this.bTa != null) {
            this.bTa.onDestory();
        }
    }
}
