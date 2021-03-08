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
/* loaded from: classes10.dex */
public class b {
    private c bOG;
    private com.baidu.live.tieba.yuyinala.d.b bOH;
    private com.baidu.live.tieba.yuyinala.d.a bOL;
    private com.baidu.live.tieba.yuyinala.e.b bOM;
    private String bOt;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;
    private final c.a bOI = new c.a() { // from class: com.baidu.live.tieba.yuyinala.b.b.1
        @Override // com.baidu.live.tieba.yuyinala.d.c.a
        public void Pj() {
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
            if (b.this.bOM.Vl() != null) {
                if (b.this.bOG == null) {
                    if (b.this.bOH != null) {
                        b.this.bOH.D(b.this.mRoomId, b.this.bOM.Vl().Ve(), b.this.bOt);
                        return;
                    }
                    return;
                }
                b.this.bOG.aO(b.this.mRoomId, b.this.bOM.Vl().Ve());
            }
        }
    };
    private final a.InterfaceC0226a bON = new a.InterfaceC0226a() { // from class: com.baidu.live.tieba.yuyinala.b.b.3
        @Override // com.baidu.live.tieba.yuyinala.d.a.InterfaceC0226a
        public void aj(List<com.baidu.live.tieba.yuyinala.c.a> list) {
            if (ListUtils.isEmpty(list)) {
                list = b.this.bOL.Vj();
            }
            if (!ListUtils.isEmpty(list)) {
                b.this.bOM.setData(list);
            }
        }

        @Override // com.baidu.live.tieba.yuyinala.d.a.InterfaceC0226a
        public void onFail(int i, String str) {
            List<com.baidu.live.tieba.yuyinala.c.a> Vj = b.this.bOL.Vj();
            if (!ListUtils.isEmpty(Vj)) {
                b.this.bOM.setData(Vj);
            }
        }
    };

    public b(TbPageContext tbPageContext, String str, String str2) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bOL = new com.baidu.live.tieba.yuyinala.d.a(this.mTbPageContext, this.bON);
        this.bOL.aN(this.mLiveId, this.mRoomId);
        this.bOM = new com.baidu.live.tieba.yuyinala.e.b(this.mTbPageContext, this.mOnClickListener);
        this.bOM.aN(this.mLiveId, this.mRoomId);
        this.bOL.Vi();
        this.bOG = new c(this.mTbPageContext.getPageActivity());
        this.bOG.a(this.bOI);
    }

    public b(TbPageContext tbPageContext, String str, String str2, String str3) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bOt = str3;
        this.bOL = new com.baidu.live.tieba.yuyinala.d.a(this.mTbPageContext, this.bON);
        this.bOL.aN(this.mLiveId, this.mRoomId);
        this.bOM = new com.baidu.live.tieba.yuyinala.e.b(this.mTbPageContext, this.mOnClickListener);
        this.bOM.E(this.mLiveId, this.mRoomId, this.bOt);
        this.bOL.Vi();
        this.bOH = new com.baidu.live.tieba.yuyinala.d.b(this.mTbPageContext.getPageActivity());
        this.bOH.a(this.bOI);
    }

    public View getView() {
        return this.bOM.getView();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onDestroy() {
        this.bOL.onDestroy();
        if (this.bOG != null) {
            this.bOG.onDestroy();
        }
        if (this.bOH != null) {
            this.bOH.onDestroy();
        }
        this.bOM.onDestroy();
    }
}
