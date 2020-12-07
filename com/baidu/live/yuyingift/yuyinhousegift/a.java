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
    private com.baidu.live.yuyingift.a bWF;
    private YuyinAlaRoomGiftView bWG;
    private List<c> bWH;
    private boolean bWI = false;
    private c bWJ;
    private Context mContext;

    public a(Context context, com.baidu.live.yuyingift.a aVar) {
        this.mContext = context;
        this.bWF = aVar;
        initData();
        initView();
    }

    private void initView() {
        this.bWG = new YuyinAlaRoomGiftView(this.mContext);
        this.bWG.setCallBack(new YuyinAlaRoomGiftView.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.a.1
            @Override // com.baidu.live.yuyingift.yuyinhousegift.YuyinAlaRoomGiftView.a
            public void onAnimEnd() {
                a.this.bWJ = null;
                a.this.bWI = false;
                a.this.bWF.Zm();
                a.this.ZT();
            }
        });
    }

    private void initData() {
        this.bWH = new ArrayList();
    }

    private boolean c(c cVar, c cVar2) {
        return cVar != null && cVar2 != null && TextUtils.equals(cVar.giftId, cVar2.giftId) && TextUtils.equals(cVar.userId, cVar2.userId) && TextUtils.equals(cVar.bnb, cVar2.bnb);
    }

    public void h(c cVar) {
        if (cVar != null) {
            boolean c = c(cVar, this.bWJ);
            boolean z = false;
            if (c) {
                b.a(this.bWJ, cVar);
                z = this.bWG.s(cVar);
            }
            if (!c || !z) {
                if (TextUtils.equals(cVar.userId, TbadkCoreApplication.getCurrentAccount())) {
                    r(cVar);
                } else {
                    this.bWH.add(cVar);
                }
                play();
            }
        }
    }

    public void r(c cVar) {
        if (this.bWH == null) {
            this.bWH = new ArrayList();
        }
        if (cVar != null) {
            int i = 0;
            while (true) {
                if (i >= this.bWH.size()) {
                    i = 0;
                    break;
                } else if (!TextUtils.equals(this.bWH.get(i).userId, TbadkCoreApplication.getCurrentAccount())) {
                    break;
                } else {
                    i++;
                }
            }
            this.bWH.add(i, cVar);
        }
    }

    public void play() {
        if (!this.bWI) {
            ZT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZT() {
        this.bWJ = ZU();
        if (this.bWJ != null) {
            Iterator<c> it = this.bWH.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (!c(this.bWJ, next)) {
                    break;
                }
                b.a(this.bWJ, next);
                this.bWJ.bcU += next.bcU;
                it.remove();
            }
            this.bWI = true;
            this.bWG.setData(this.bWJ);
            this.bWF.a(this.bWG, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    private c ZU() {
        if (this.bWH.isEmpty()) {
            return null;
        }
        return this.bWH.remove(0);
    }

    public void onDestory() {
        if (this.bWH != null) {
            this.bWH.clear();
        }
        if (this.bWG != null) {
            this.bWG.onDestory();
        }
    }
}
