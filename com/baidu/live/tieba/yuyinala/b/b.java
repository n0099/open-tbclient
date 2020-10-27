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
    private c bzM;
    private com.baidu.live.tieba.yuyinala.d.b bzN;
    private com.baidu.live.tieba.yuyinala.d.a bzR;
    private com.baidu.live.tieba.yuyinala.e.b bzS;
    private String bzz;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;
    private final c.a bzO = new c.a() { // from class: com.baidu.live.tieba.yuyinala.b.b.1
        @Override // com.baidu.live.tieba.yuyinala.d.c.a
        public void Ol() {
            BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), a.i.txt_person_report_success);
            b.this.mTbPageContext.getPageActivity().finish();
        }

        @Override // com.baidu.live.tieba.yuyinala.d.c.a
        public void onFail(String str) {
            BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), a.i.txt_person_report_fail);
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.yuyinala.b.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.bzS.RS() != null) {
                if (b.this.bzM == null) {
                    if (b.this.bzN != null) {
                        b.this.bzN.y(b.this.mRoomId, b.this.bzS.RS().RL(), b.this.bzz);
                        return;
                    }
                    return;
                }
                b.this.bzM.aQ(b.this.mRoomId, b.this.bzS.RS().RL());
            }
        }
    };
    private final a.InterfaceC0210a bzT = new a.InterfaceC0210a() { // from class: com.baidu.live.tieba.yuyinala.b.b.3
        @Override // com.baidu.live.tieba.yuyinala.d.a.InterfaceC0210a
        public void aa(List<com.baidu.live.tieba.yuyinala.c.a> list) {
            if (ListUtils.isEmpty(list)) {
                list = b.this.bzR.RQ();
            }
            if (!ListUtils.isEmpty(list)) {
                b.this.bzS.setData(list);
            }
        }

        @Override // com.baidu.live.tieba.yuyinala.d.a.InterfaceC0210a
        public void onFail(int i, String str) {
            List<com.baidu.live.tieba.yuyinala.c.a> RQ = b.this.bzR.RQ();
            if (!ListUtils.isEmpty(RQ)) {
                b.this.bzS.setData(RQ);
            }
        }
    };

    public b(TbPageContext tbPageContext, String str, String str2) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bzR = new com.baidu.live.tieba.yuyinala.d.a(this.mTbPageContext, this.bzT);
        this.bzR.aP(this.mLiveId, this.mRoomId);
        this.bzS = new com.baidu.live.tieba.yuyinala.e.b(this.mTbPageContext, this.mOnClickListener);
        this.bzS.aP(this.mLiveId, this.mRoomId);
        this.bzR.RP();
        this.bzM = new c(this.mTbPageContext.getPageActivity());
        this.bzM.a(this.bzO);
    }

    public b(TbPageContext tbPageContext, String str, String str2, String str3) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bzz = str3;
        this.bzR = new com.baidu.live.tieba.yuyinala.d.a(this.mTbPageContext, this.bzT);
        this.bzR.aP(this.mLiveId, this.mRoomId);
        this.bzS = new com.baidu.live.tieba.yuyinala.e.b(this.mTbPageContext, this.mOnClickListener);
        this.bzS.z(this.mLiveId, this.mRoomId, this.bzz);
        this.bzR.RP();
        this.bzN = new com.baidu.live.tieba.yuyinala.d.b(this.mTbPageContext.getPageActivity());
        this.bzN.a(this.bzO);
    }

    public View getView() {
        return this.bzS.getView();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onDestroy() {
        this.bzR.onDestroy();
        if (this.bzM != null) {
            this.bzM.onDestroy();
        }
        if (this.bzN != null) {
            this.bzN.onDestroy();
        }
        this.bzS.onDestroy();
    }
}
