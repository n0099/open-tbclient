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
    private com.baidu.live.tieba.yuyinala.e.b bJA;
    private String bJh;
    private c bJu;
    private com.baidu.live.tieba.yuyinala.d.b bJv;
    private com.baidu.live.tieba.yuyinala.d.a bJz;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;
    private final c.a bJw = new c.a() { // from class: com.baidu.live.tieba.yuyinala.b.b.1
        @Override // com.baidu.live.tieba.yuyinala.d.c.a
        public void Qv() {
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
            if (b.this.bJA.Wr() != null) {
                if (b.this.bJu == null) {
                    if (b.this.bJv != null) {
                        b.this.bJv.B(b.this.mRoomId, b.this.bJA.Wr().Wk(), b.this.bJh);
                        return;
                    }
                    return;
                }
                b.this.bJu.aU(b.this.mRoomId, b.this.bJA.Wr().Wk());
            }
        }
    };
    private final a.InterfaceC0229a bJB = new a.InterfaceC0229a() { // from class: com.baidu.live.tieba.yuyinala.b.b.3
        @Override // com.baidu.live.tieba.yuyinala.d.a.InterfaceC0229a
        public void ah(List<com.baidu.live.tieba.yuyinala.c.a> list) {
            if (ListUtils.isEmpty(list)) {
                list = b.this.bJz.Wp();
            }
            if (!ListUtils.isEmpty(list)) {
                b.this.bJA.setData(list);
            }
        }

        @Override // com.baidu.live.tieba.yuyinala.d.a.InterfaceC0229a
        public void onFail(int i, String str) {
            List<com.baidu.live.tieba.yuyinala.c.a> Wp = b.this.bJz.Wp();
            if (!ListUtils.isEmpty(Wp)) {
                b.this.bJA.setData(Wp);
            }
        }
    };

    public b(TbPageContext tbPageContext, String str, String str2) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bJz = new com.baidu.live.tieba.yuyinala.d.a(this.mTbPageContext, this.bJB);
        this.bJz.aT(this.mLiveId, this.mRoomId);
        this.bJA = new com.baidu.live.tieba.yuyinala.e.b(this.mTbPageContext, this.mOnClickListener);
        this.bJA.aT(this.mLiveId, this.mRoomId);
        this.bJz.Wo();
        this.bJu = new c(this.mTbPageContext.getPageActivity());
        this.bJu.a(this.bJw);
    }

    public b(TbPageContext tbPageContext, String str, String str2, String str3) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bJh = str3;
        this.bJz = new com.baidu.live.tieba.yuyinala.d.a(this.mTbPageContext, this.bJB);
        this.bJz.aT(this.mLiveId, this.mRoomId);
        this.bJA = new com.baidu.live.tieba.yuyinala.e.b(this.mTbPageContext, this.mOnClickListener);
        this.bJA.C(this.mLiveId, this.mRoomId, this.bJh);
        this.bJz.Wo();
        this.bJv = new com.baidu.live.tieba.yuyinala.d.b(this.mTbPageContext.getPageActivity());
        this.bJv.a(this.bJw);
    }

    public View getView() {
        return this.bJA.getView();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onDestroy() {
        this.bJz.onDestroy();
        if (this.bJu != null) {
            this.bJu.onDestroy();
        }
        if (this.bJv != null) {
            this.bJv.onDestroy();
        }
        this.bJA.onDestroy();
    }
}
