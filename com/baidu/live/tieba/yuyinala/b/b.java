package com.baidu.live.tieba.yuyinala.b;

import android.content.res.Configuration;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tieba.yuyinala.d.a;
import com.baidu.live.tieba.yuyinala.d.c;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private String bDZ;
    private c bEm;
    private com.baidu.live.tieba.yuyinala.d.b bEn;
    private com.baidu.live.tieba.yuyinala.d.a bEr;
    private com.baidu.live.tieba.yuyinala.e.b bEs;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;
    private final c.a bEo = new c.a() { // from class: com.baidu.live.tieba.yuyinala.b.b.1
        @Override // com.baidu.live.tieba.yuyinala.d.c.a
        public void Oc() {
            BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), a.h.txt_person_report_success);
            b.this.mTbPageContext.getPageActivity().finish();
        }

        @Override // com.baidu.live.tieba.yuyinala.d.c.a
        public void onFail(String str) {
            BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), a.h.txt_person_report_fail);
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.yuyinala.b.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.bEs.TR() != null) {
                if (b.this.bEm == null) {
                    if (b.this.bEn != null) {
                        b.this.bEn.y(b.this.mRoomId, b.this.bEs.TR().TK(), b.this.bDZ);
                        return;
                    }
                    return;
                }
                b.this.bEm.aQ(b.this.mRoomId, b.this.bEs.TR().TK());
            }
        }
    };
    private final a.InterfaceC0220a bEt = new a.InterfaceC0220a() { // from class: com.baidu.live.tieba.yuyinala.b.b.3
        @Override // com.baidu.live.tieba.yuyinala.d.a.InterfaceC0220a
        public void af(List<com.baidu.live.tieba.yuyinala.c.a> list) {
            if (ListUtils.isEmpty(list)) {
                list = b.this.bEr.TP();
            }
            if (!ListUtils.isEmpty(list)) {
                b.this.bEs.setData(list);
            }
        }

        @Override // com.baidu.live.tieba.yuyinala.d.a.InterfaceC0220a
        public void onFail(int i, String str) {
            List<com.baidu.live.tieba.yuyinala.c.a> TP = b.this.bEr.TP();
            if (!ListUtils.isEmpty(TP)) {
                b.this.bEs.setData(TP);
            }
        }
    };

    public b(TbPageContext tbPageContext, String str, String str2) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bEr = new com.baidu.live.tieba.yuyinala.d.a(this.mTbPageContext, this.bEt);
        this.bEr.aP(this.mLiveId, this.mRoomId);
        this.bEs = new com.baidu.live.tieba.yuyinala.e.b(this.mTbPageContext, this.mOnClickListener);
        this.bEs.aP(this.mLiveId, this.mRoomId);
        this.bEr.TO();
        this.bEm = new c(this.mTbPageContext.getPageActivity());
        this.bEm.a(this.bEo);
    }

    public b(TbPageContext tbPageContext, String str, String str2, String str3) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bDZ = str3;
        this.bEr = new com.baidu.live.tieba.yuyinala.d.a(this.mTbPageContext, this.bEt);
        this.bEr.aP(this.mLiveId, this.mRoomId);
        this.bEs = new com.baidu.live.tieba.yuyinala.e.b(this.mTbPageContext, this.mOnClickListener);
        this.bEs.z(this.mLiveId, this.mRoomId, this.bDZ);
        this.bEr.TO();
        this.bEn = new com.baidu.live.tieba.yuyinala.d.b(this.mTbPageContext.getPageActivity());
        this.bEn.a(this.bEo);
    }

    public View getView() {
        return this.bEs.getView();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onDestroy() {
        this.bEr.onDestroy();
        if (this.bEm != null) {
            this.bEm.onDestroy();
        }
        if (this.bEn != null) {
            this.bEn.onDestroy();
        }
        this.bEs.onDestroy();
    }
}
