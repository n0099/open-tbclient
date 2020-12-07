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
    private String bJh;
    private com.baidu.live.tieba.yuyinala.e.a bJt;
    private c bJu;
    private com.baidu.live.tieba.yuyinala.d.b bJv;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;
    private final c.a bJw = new c.a() { // from class: com.baidu.live.tieba.yuyinala.b.a.1
        @Override // com.baidu.live.tieba.yuyinala.d.c.a
        public void Qv() {
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
            if (a.this.bJt.Wq().length() > 20) {
                BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.h.txt_describe_feedback_reason_text_max_limit);
            } else if (TextUtils.isEmpty(a.this.mRoomId) || a.this.bJu == null) {
                if (!TextUtils.isEmpty(a.this.mRoomId) && !TextUtils.isEmpty(a.this.bJh) && a.this.bJv != null) {
                    a.this.bJv.B(a.this.mRoomId, a.this.bJt.Wq(), a.this.bJh);
                }
            } else {
                a.this.bJu.aU(a.this.mRoomId, a.this.bJt.Wq());
            }
        }
    };
    private final a.InterfaceC0230a bJx = new a.InterfaceC0230a() { // from class: com.baidu.live.tieba.yuyinala.b.a.3
        @Override // com.baidu.live.tieba.yuyinala.e.a.InterfaceC0230a
        public void afterTextChanged(Editable editable) {
        }
    };

    public a(TbPageContext tbPageContext, String str, String str2) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bJt = new com.baidu.live.tieba.yuyinala.e.a(this.mTbPageContext, this.mOnClickListener, this.bJx);
        this.bJt.aT(this.mLiveId, str2);
        this.bJu = new c(this.mTbPageContext.getContext());
        this.bJu.a(this.bJw);
    }

    public a(TbPageContext tbPageContext, String str, String str2, String str3) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bJh = str3;
        this.bJt = new com.baidu.live.tieba.yuyinala.e.a(this.mTbPageContext, this.mOnClickListener, this.bJx);
        this.bJt.aT(this.mLiveId, str2);
        this.bJv = new com.baidu.live.tieba.yuyinala.d.b(this.mTbPageContext.getContext());
        this.bJv.a(this.bJw);
    }

    public View getView() {
        return this.bJt.getView();
    }

    public void onDestroy() {
        if (this.bJu != null) {
            this.bJu.onDestroy();
        }
        if (this.bJv != null) {
            this.bJv.onDestroy();
        }
        this.bJt.onDestroy();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.bJt != null) {
            this.bJt.onKeyboardVisibilityChanged(z);
        }
    }
}
