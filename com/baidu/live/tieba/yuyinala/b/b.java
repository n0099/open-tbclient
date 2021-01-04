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
/* loaded from: classes11.dex */
public class b {
    private String bNV;
    private c bOi;
    private com.baidu.live.tieba.yuyinala.d.b bOj;
    private com.baidu.live.tieba.yuyinala.d.a bOn;
    private com.baidu.live.tieba.yuyinala.e.b bOo;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;
    private final c.a bOk = new c.a() { // from class: com.baidu.live.tieba.yuyinala.b.b.1
        @Override // com.baidu.live.tieba.yuyinala.d.c.a
        public void Rz() {
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
            if (b.this.bOo.Xt() != null) {
                if (b.this.bOi == null) {
                    if (b.this.bOj != null) {
                        b.this.bOj.D(b.this.mRoomId, b.this.bOo.Xt().Xm(), b.this.bNV);
                        return;
                    }
                    return;
                }
                b.this.bOi.aP(b.this.mRoomId, b.this.bOo.Xt().Xm());
            }
        }
    };
    private final a.InterfaceC0227a bOp = new a.InterfaceC0227a() { // from class: com.baidu.live.tieba.yuyinala.b.b.3
        @Override // com.baidu.live.tieba.yuyinala.d.a.InterfaceC0227a
        public void ai(List<com.baidu.live.tieba.yuyinala.c.a> list) {
            if (ListUtils.isEmpty(list)) {
                list = b.this.bOn.Xr();
            }
            if (!ListUtils.isEmpty(list)) {
                b.this.bOo.setData(list);
            }
        }

        @Override // com.baidu.live.tieba.yuyinala.d.a.InterfaceC0227a
        public void onFail(int i, String str) {
            List<com.baidu.live.tieba.yuyinala.c.a> Xr = b.this.bOn.Xr();
            if (!ListUtils.isEmpty(Xr)) {
                b.this.bOo.setData(Xr);
            }
        }
    };

    public b(TbPageContext tbPageContext, String str, String str2) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bOn = new com.baidu.live.tieba.yuyinala.d.a(this.mTbPageContext, this.bOp);
        this.bOn.aO(this.mLiveId, this.mRoomId);
        this.bOo = new com.baidu.live.tieba.yuyinala.e.b(this.mTbPageContext, this.mOnClickListener);
        this.bOo.aO(this.mLiveId, this.mRoomId);
        this.bOn.Xq();
        this.bOi = new c(this.mTbPageContext.getPageActivity());
        this.bOi.a(this.bOk);
    }

    public b(TbPageContext tbPageContext, String str, String str2, String str3) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bNV = str3;
        this.bOn = new com.baidu.live.tieba.yuyinala.d.a(this.mTbPageContext, this.bOp);
        this.bOn.aO(this.mLiveId, this.mRoomId);
        this.bOo = new com.baidu.live.tieba.yuyinala.e.b(this.mTbPageContext, this.mOnClickListener);
        this.bOo.E(this.mLiveId, this.mRoomId, this.bNV);
        this.bOn.Xq();
        this.bOj = new com.baidu.live.tieba.yuyinala.d.b(this.mTbPageContext.getPageActivity());
        this.bOj.a(this.bOk);
    }

    public View getView() {
        return this.bOo.getView();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onDestroy() {
        this.bOn.onDestroy();
        if (this.bOi != null) {
            this.bOi.onDestroy();
        }
        if (this.bOj != null) {
            this.bOj.onDestroy();
        }
        this.bOo.onDestroy();
    }
}
