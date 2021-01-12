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
    private com.baidu.live.tieba.yuyinala.d.a bJB;
    private com.baidu.live.tieba.yuyinala.e.b bJC;
    private String bJj;
    private c bJw;
    private com.baidu.live.tieba.yuyinala.d.b bJx;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;
    private final c.a bJy = new c.a() { // from class: com.baidu.live.tieba.yuyinala.b.b.1
        @Override // com.baidu.live.tieba.yuyinala.d.c.a
        public void NE() {
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
            if (b.this.bJC.TB() != null) {
                if (b.this.bJw == null) {
                    if (b.this.bJx != null) {
                        b.this.bJx.C(b.this.mRoomId, b.this.bJC.TB().Tu(), b.this.bJj);
                        return;
                    }
                    return;
                }
                b.this.bJw.aO(b.this.mRoomId, b.this.bJC.TB().Tu());
            }
        }
    };
    private final a.InterfaceC0218a bJD = new a.InterfaceC0218a() { // from class: com.baidu.live.tieba.yuyinala.b.b.3
        @Override // com.baidu.live.tieba.yuyinala.d.a.InterfaceC0218a
        public void ai(List<com.baidu.live.tieba.yuyinala.c.a> list) {
            if (ListUtils.isEmpty(list)) {
                list = b.this.bJB.Tz();
            }
            if (!ListUtils.isEmpty(list)) {
                b.this.bJC.setData(list);
            }
        }

        @Override // com.baidu.live.tieba.yuyinala.d.a.InterfaceC0218a
        public void onFail(int i, String str) {
            List<com.baidu.live.tieba.yuyinala.c.a> Tz = b.this.bJB.Tz();
            if (!ListUtils.isEmpty(Tz)) {
                b.this.bJC.setData(Tz);
            }
        }
    };

    public b(TbPageContext tbPageContext, String str, String str2) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bJB = new com.baidu.live.tieba.yuyinala.d.a(this.mTbPageContext, this.bJD);
        this.bJB.aN(this.mLiveId, this.mRoomId);
        this.bJC = new com.baidu.live.tieba.yuyinala.e.b(this.mTbPageContext, this.mOnClickListener);
        this.bJC.aN(this.mLiveId, this.mRoomId);
        this.bJB.Ty();
        this.bJw = new c(this.mTbPageContext.getPageActivity());
        this.bJw.a(this.bJy);
    }

    public b(TbPageContext tbPageContext, String str, String str2, String str3) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bJj = str3;
        this.bJB = new com.baidu.live.tieba.yuyinala.d.a(this.mTbPageContext, this.bJD);
        this.bJB.aN(this.mLiveId, this.mRoomId);
        this.bJC = new com.baidu.live.tieba.yuyinala.e.b(this.mTbPageContext, this.mOnClickListener);
        this.bJC.D(this.mLiveId, this.mRoomId, this.bJj);
        this.bJB.Ty();
        this.bJx = new com.baidu.live.tieba.yuyinala.d.b(this.mTbPageContext.getPageActivity());
        this.bJx.a(this.bJy);
    }

    public View getView() {
        return this.bJC.getView();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onDestroy() {
        this.bJB.onDestroy();
        if (this.bJw != null) {
            this.bJw.onDestroy();
        }
        if (this.bJx != null) {
            this.bJx.onDestroy();
        }
        this.bJC.onDestroy();
    }
}
