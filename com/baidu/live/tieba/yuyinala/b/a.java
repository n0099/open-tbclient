package com.baidu.live.tieba.yuyinala.b;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tieba.yuyinala.d.c;
import com.baidu.live.tieba.yuyinala.e.a;
/* loaded from: classes10.dex */
public class a {
    private String bJj;
    private com.baidu.live.tieba.yuyinala.e.a bJv;
    private c bJw;
    private com.baidu.live.tieba.yuyinala.d.b bJx;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;
    private final c.a bJy = new c.a() { // from class: com.baidu.live.tieba.yuyinala.b.a.1
        @Override // com.baidu.live.tieba.yuyinala.d.c.a
        public void NE() {
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
            if (a.this.bJv.TA().length() > 20) {
                BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.h.txt_describe_feedback_reason_text_max_limit);
            } else if (TextUtils.isEmpty(a.this.mRoomId) || a.this.bJw == null) {
                if (!TextUtils.isEmpty(a.this.mRoomId) && !TextUtils.isEmpty(a.this.bJj) && a.this.bJx != null) {
                    a.this.bJx.C(a.this.mRoomId, a.this.bJv.TA(), a.this.bJj);
                }
            } else {
                a.this.bJw.aO(a.this.mRoomId, a.this.bJv.TA());
            }
        }
    };
    private final a.InterfaceC0219a bJz = new a.InterfaceC0219a() { // from class: com.baidu.live.tieba.yuyinala.b.a.3
        @Override // com.baidu.live.tieba.yuyinala.e.a.InterfaceC0219a
        public void afterTextChanged(Editable editable) {
        }
    };

    public a(TbPageContext tbPageContext, String str, String str2) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bJv = new com.baidu.live.tieba.yuyinala.e.a(this.mTbPageContext, this.mOnClickListener, this.bJz);
        this.bJv.aN(this.mLiveId, str2);
        this.bJw = new c(this.mTbPageContext.getContext());
        this.bJw.a(this.bJy);
    }

    public a(TbPageContext tbPageContext, String str, String str2, String str3) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bJj = str3;
        this.bJv = new com.baidu.live.tieba.yuyinala.e.a(this.mTbPageContext, this.mOnClickListener, this.bJz);
        this.bJv.aN(this.mLiveId, str2);
        this.bJx = new com.baidu.live.tieba.yuyinala.d.b(this.mTbPageContext.getContext());
        this.bJx.a(this.bJy);
    }

    public View getView() {
        return this.bJv.getView();
    }

    public void onDestroy() {
        if (this.bJw != null) {
            this.bJw.onDestroy();
        }
        if (this.bJx != null) {
            this.bJx.onDestroy();
        }
        this.bJv.onDestroy();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.bJv != null) {
            this.bJv.onKeyboardVisibilityChanged(z);
        }
    }
}
