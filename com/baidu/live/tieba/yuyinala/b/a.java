package com.baidu.live.tieba.yuyinala.b;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tieba.yuyinala.d.c;
import com.baidu.live.tieba.yuyinala.e.a;
/* loaded from: classes11.dex */
public class a {
    private String bNV;
    private com.baidu.live.tieba.yuyinala.e.a bOh;
    private c bOi;
    private com.baidu.live.tieba.yuyinala.d.b bOj;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;
    private final c.a bOk = new c.a() { // from class: com.baidu.live.tieba.yuyinala.b.a.1
        @Override // com.baidu.live.tieba.yuyinala.d.c.a
        public void Rz() {
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
            if (a.this.bOh.Xt().length() > 20) {
                BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.h.txt_describe_feedback_reason_text_max_limit);
            } else if (TextUtils.isEmpty(a.this.mRoomId) || a.this.bOi == null) {
                if (!TextUtils.isEmpty(a.this.mRoomId) && !TextUtils.isEmpty(a.this.bNV) && a.this.bOj != null) {
                    a.this.bOj.D(a.this.mRoomId, a.this.bOh.Xt(), a.this.bNV);
                }
            } else {
                a.this.bOi.aP(a.this.mRoomId, a.this.bOh.Xt());
            }
        }
    };
    private final a.InterfaceC0228a bOl = new a.InterfaceC0228a() { // from class: com.baidu.live.tieba.yuyinala.b.a.3
        @Override // com.baidu.live.tieba.yuyinala.e.a.InterfaceC0228a
        public void afterTextChanged(Editable editable) {
        }
    };

    public a(TbPageContext tbPageContext, String str, String str2) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bOh = new com.baidu.live.tieba.yuyinala.e.a(this.mTbPageContext, this.mOnClickListener, this.bOl);
        this.bOh.aO(this.mLiveId, str2);
        this.bOi = new c(this.mTbPageContext.getContext());
        this.bOi.a(this.bOk);
    }

    public a(TbPageContext tbPageContext, String str, String str2, String str3) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bNV = str3;
        this.bOh = new com.baidu.live.tieba.yuyinala.e.a(this.mTbPageContext, this.mOnClickListener, this.bOl);
        this.bOh.aO(this.mLiveId, str2);
        this.bOj = new com.baidu.live.tieba.yuyinala.d.b(this.mTbPageContext.getContext());
        this.bOj.a(this.bOk);
    }

    public View getView() {
        return this.bOh.getView();
    }

    public void onDestroy() {
        if (this.bOi != null) {
            this.bOi.onDestroy();
        }
        if (this.bOj != null) {
            this.bOj.onDestroy();
        }
        this.bOh.onDestroy();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.bOh != null) {
            this.bOh.onKeyboardVisibilityChanged(z);
        }
    }
}
