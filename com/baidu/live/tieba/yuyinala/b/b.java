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
    private String bFK;
    private c bFX;
    private com.baidu.live.tieba.yuyinala.d.b bFY;
    private com.baidu.live.tieba.yuyinala.d.a bGc;
    private com.baidu.live.tieba.yuyinala.e.b bGd;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;
    private final c.a bFZ = new c.a() { // from class: com.baidu.live.tieba.yuyinala.b.b.1
        @Override // com.baidu.live.tieba.yuyinala.d.c.a
        public void OL() {
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
            if (b.this.bGd.UA() != null) {
                if (b.this.bFX == null) {
                    if (b.this.bFY != null) {
                        b.this.bFY.y(b.this.mRoomId, b.this.bGd.UA().Ut(), b.this.bFK);
                        return;
                    }
                    return;
                }
                b.this.bFX.aR(b.this.mRoomId, b.this.bGd.UA().Ut());
            }
        }
    };
    private final a.InterfaceC0222a bGe = new a.InterfaceC0222a() { // from class: com.baidu.live.tieba.yuyinala.b.b.3
        @Override // com.baidu.live.tieba.yuyinala.d.a.InterfaceC0222a
        public void af(List<com.baidu.live.tieba.yuyinala.c.a> list) {
            if (ListUtils.isEmpty(list)) {
                list = b.this.bGc.Uy();
            }
            if (!ListUtils.isEmpty(list)) {
                b.this.bGd.setData(list);
            }
        }

        @Override // com.baidu.live.tieba.yuyinala.d.a.InterfaceC0222a
        public void onFail(int i, String str) {
            List<com.baidu.live.tieba.yuyinala.c.a> Uy = b.this.bGc.Uy();
            if (!ListUtils.isEmpty(Uy)) {
                b.this.bGd.setData(Uy);
            }
        }
    };

    public b(TbPageContext tbPageContext, String str, String str2) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bGc = new com.baidu.live.tieba.yuyinala.d.a(this.mTbPageContext, this.bGe);
        this.bGc.aQ(this.mLiveId, this.mRoomId);
        this.bGd = new com.baidu.live.tieba.yuyinala.e.b(this.mTbPageContext, this.mOnClickListener);
        this.bGd.aQ(this.mLiveId, this.mRoomId);
        this.bGc.Ux();
        this.bFX = new c(this.mTbPageContext.getPageActivity());
        this.bFX.a(this.bFZ);
    }

    public b(TbPageContext tbPageContext, String str, String str2, String str3) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bFK = str3;
        this.bGc = new com.baidu.live.tieba.yuyinala.d.a(this.mTbPageContext, this.bGe);
        this.bGc.aQ(this.mLiveId, this.mRoomId);
        this.bGd = new com.baidu.live.tieba.yuyinala.e.b(this.mTbPageContext, this.mOnClickListener);
        this.bGd.z(this.mLiveId, this.mRoomId, this.bFK);
        this.bGc.Ux();
        this.bFY = new com.baidu.live.tieba.yuyinala.d.b(this.mTbPageContext.getPageActivity());
        this.bFY.a(this.bFZ);
    }

    public View getView() {
        return this.bGd.getView();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onDestroy() {
        this.bGc.onDestroy();
        if (this.bFX != null) {
            this.bFX.onDestroy();
        }
        if (this.bFY != null) {
            this.bFY.onDestroy();
        }
        this.bGd.onDestroy();
    }
}
