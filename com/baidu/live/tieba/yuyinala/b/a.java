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
    private com.baidu.live.tieba.yuyinala.e.a bzL;
    private c bzM;
    private com.baidu.live.tieba.yuyinala.d.b bzN;
    private String bzz;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;
    private final c.a bzO = new c.a() { // from class: com.baidu.live.tieba.yuyinala.b.a.1
        @Override // com.baidu.live.tieba.yuyinala.d.c.a
        public void Ol() {
            BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.i.txt_person_report_success);
            a.this.mTbPageContext.getPageActivity().finish();
        }

        @Override // com.baidu.live.tieba.yuyinala.d.c.a
        public void onFail(String str) {
            BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.i.txt_person_report_fail);
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.yuyinala.b.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.bzL.RR().length() > 20) {
                BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.i.txt_describe_feedback_reason_text_max_limit);
            } else if (TextUtils.isEmpty(a.this.mRoomId) || a.this.bzM == null) {
                if (!TextUtils.isEmpty(a.this.mRoomId) && !TextUtils.isEmpty(a.this.bzz) && a.this.bzN != null) {
                    a.this.bzN.y(a.this.mRoomId, a.this.bzL.RR(), a.this.bzz);
                }
            } else {
                a.this.bzM.aQ(a.this.mRoomId, a.this.bzL.RR());
            }
        }
    };
    private final a.InterfaceC0211a bzP = new a.InterfaceC0211a() { // from class: com.baidu.live.tieba.yuyinala.b.a.3
        @Override // com.baidu.live.tieba.yuyinala.e.a.InterfaceC0211a
        public void afterTextChanged(Editable editable) {
        }
    };

    public a(TbPageContext tbPageContext, String str, String str2) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bzL = new com.baidu.live.tieba.yuyinala.e.a(this.mTbPageContext, this.mOnClickListener, this.bzP);
        this.bzL.aP(this.mLiveId, str2);
        this.bzM = new c(this.mTbPageContext.getContext());
        this.bzM.a(this.bzO);
    }

    public a(TbPageContext tbPageContext, String str, String str2, String str3) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bzz = str3;
        this.bzL = new com.baidu.live.tieba.yuyinala.e.a(this.mTbPageContext, this.mOnClickListener, this.bzP);
        this.bzL.aP(this.mLiveId, str2);
        this.bzN = new com.baidu.live.tieba.yuyinala.d.b(this.mTbPageContext.getContext());
        this.bzN.a(this.bzO);
    }

    public View getView() {
        return this.bzL.getView();
    }

    public void onDestroy() {
        if (this.bzM != null) {
            this.bzM.onDestroy();
        }
        if (this.bzN != null) {
            this.bzN.onDestroy();
        }
        this.bzL.onDestroy();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.bzL != null) {
            this.bzL.onKeyboardVisibilityChanged(z);
        }
    }
}
