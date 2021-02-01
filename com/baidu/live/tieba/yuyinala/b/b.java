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
    private String bMT;
    private c bNg;
    private com.baidu.live.tieba.yuyinala.d.b bNh;
    private com.baidu.live.tieba.yuyinala.d.a bNl;
    private com.baidu.live.tieba.yuyinala.e.b bNm;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;
    private final c.a bNi = new c.a() { // from class: com.baidu.live.tieba.yuyinala.b.b.1
        @Override // com.baidu.live.tieba.yuyinala.d.c.a
        public void Pg() {
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
            if (b.this.bNm.Vi() != null) {
                if (b.this.bNg == null) {
                    if (b.this.bNh != null) {
                        b.this.bNh.D(b.this.mRoomId, b.this.bNm.Vi().Vb(), b.this.bMT);
                        return;
                    }
                    return;
                }
                b.this.bNg.aO(b.this.mRoomId, b.this.bNm.Vi().Vb());
            }
        }
    };
    private final a.InterfaceC0220a bNn = new a.InterfaceC0220a() { // from class: com.baidu.live.tieba.yuyinala.b.b.3
        @Override // com.baidu.live.tieba.yuyinala.d.a.InterfaceC0220a
        public void aj(List<com.baidu.live.tieba.yuyinala.c.a> list) {
            if (ListUtils.isEmpty(list)) {
                list = b.this.bNl.Vg();
            }
            if (!ListUtils.isEmpty(list)) {
                b.this.bNm.setData(list);
            }
        }

        @Override // com.baidu.live.tieba.yuyinala.d.a.InterfaceC0220a
        public void onFail(int i, String str) {
            List<com.baidu.live.tieba.yuyinala.c.a> Vg = b.this.bNl.Vg();
            if (!ListUtils.isEmpty(Vg)) {
                b.this.bNm.setData(Vg);
            }
        }
    };

    public b(TbPageContext tbPageContext, String str, String str2) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bNl = new com.baidu.live.tieba.yuyinala.d.a(this.mTbPageContext, this.bNn);
        this.bNl.aN(this.mLiveId, this.mRoomId);
        this.bNm = new com.baidu.live.tieba.yuyinala.e.b(this.mTbPageContext, this.mOnClickListener);
        this.bNm.aN(this.mLiveId, this.mRoomId);
        this.bNl.Vf();
        this.bNg = new c(this.mTbPageContext.getPageActivity());
        this.bNg.a(this.bNi);
    }

    public b(TbPageContext tbPageContext, String str, String str2, String str3) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bMT = str3;
        this.bNl = new com.baidu.live.tieba.yuyinala.d.a(this.mTbPageContext, this.bNn);
        this.bNl.aN(this.mLiveId, this.mRoomId);
        this.bNm = new com.baidu.live.tieba.yuyinala.e.b(this.mTbPageContext, this.mOnClickListener);
        this.bNm.E(this.mLiveId, this.mRoomId, this.bMT);
        this.bNl.Vf();
        this.bNh = new com.baidu.live.tieba.yuyinala.d.b(this.mTbPageContext.getPageActivity());
        this.bNh.a(this.bNi);
    }

    public View getView() {
        return this.bNm.getView();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onDestroy() {
        this.bNl.onDestroy();
        if (this.bNg != null) {
            this.bNg.onDestroy();
        }
        if (this.bNh != null) {
            this.bNh.onDestroy();
        }
        this.bNm.onDestroy();
    }
}
