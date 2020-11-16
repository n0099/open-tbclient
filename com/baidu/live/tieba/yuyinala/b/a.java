package com.baidu.live.tieba.yuyinala.b;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tieba.yuyinala.d.c;
import com.baidu.live.tieba.yuyinala.e.a;
/* loaded from: classes4.dex */
public class a {
    private String bDZ;
    private com.baidu.live.tieba.yuyinala.e.a bEl;
    private c bEm;
    private com.baidu.live.tieba.yuyinala.d.b bEn;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;
    private final c.a bEo = new c.a() { // from class: com.baidu.live.tieba.yuyinala.b.a.1
        @Override // com.baidu.live.tieba.yuyinala.d.c.a
        public void Oc() {
            BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.h.txt_person_report_success);
            a.this.mTbPageContext.getPageActivity().finish();
        }

        @Override // com.baidu.live.tieba.yuyinala.d.c.a
        public void onFail(String str) {
            BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.h.txt_person_report_fail);
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.yuyinala.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.bEl.TQ().length() > 20) {
                BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.h.txt_describe_feedback_reason_text_max_limit);
            } else if (TextUtils.isEmpty(a.this.mRoomId) || a.this.bEm == null) {
                if (!TextUtils.isEmpty(a.this.mRoomId) && !TextUtils.isEmpty(a.this.bDZ) && a.this.bEn != null) {
                    a.this.bEn.y(a.this.mRoomId, a.this.bEl.TQ(), a.this.bDZ);
                }
            } else {
                a.this.bEm.aQ(a.this.mRoomId, a.this.bEl.TQ());
            }
        }
    };
    private final a.InterfaceC0221a bEp = new a.InterfaceC0221a() { // from class: com.baidu.live.tieba.yuyinala.b.a.3
        @Override // com.baidu.live.tieba.yuyinala.e.a.InterfaceC0221a
        public void afterTextChanged(Editable editable) {
        }
    };

    public a(TbPageContext tbPageContext, String str, String str2) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bEl = new com.baidu.live.tieba.yuyinala.e.a(this.mTbPageContext, this.mOnClickListener, this.bEp);
        this.bEl.aP(this.mLiveId, str2);
        this.bEm = new c(this.mTbPageContext.getContext());
        this.bEm.a(this.bEo);
    }

    public a(TbPageContext tbPageContext, String str, String str2, String str3) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bDZ = str3;
        this.bEl = new com.baidu.live.tieba.yuyinala.e.a(this.mTbPageContext, this.mOnClickListener, this.bEp);
        this.bEl.aP(this.mLiveId, str2);
        this.bEn = new com.baidu.live.tieba.yuyinala.d.b(this.mTbPageContext.getContext());
        this.bEn.a(this.bEo);
    }

    public View getView() {
        return this.bEl.getView();
    }

    public void onDestroy() {
        if (this.bEm != null) {
            this.bEm.onDestroy();
        }
        if (this.bEn != null) {
            this.bEn.onDestroy();
        }
        this.bEl.onDestroy();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.bEl != null) {
            this.bEl.onKeyboardVisibilityChanged(z);
        }
    }
}
