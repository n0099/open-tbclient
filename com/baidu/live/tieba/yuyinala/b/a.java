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
    private String bMT;
    private com.baidu.live.tieba.yuyinala.e.a bNf;
    private c bNg;
    private com.baidu.live.tieba.yuyinala.d.b bNh;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;
    private final c.a bNi = new c.a() { // from class: com.baidu.live.tieba.yuyinala.b.a.1
        @Override // com.baidu.live.tieba.yuyinala.d.c.a
        public void Pg() {
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
            if (a.this.bNf.Vh().length() > 20) {
                BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.h.txt_describe_feedback_reason_text_max_limit);
            } else if (TextUtils.isEmpty(a.this.mRoomId) || a.this.bNg == null) {
                if (!TextUtils.isEmpty(a.this.mRoomId) && !TextUtils.isEmpty(a.this.bMT) && a.this.bNh != null) {
                    a.this.bNh.D(a.this.mRoomId, a.this.bNf.Vh(), a.this.bMT);
                }
            } else {
                a.this.bNg.aO(a.this.mRoomId, a.this.bNf.Vh());
            }
        }
    };
    private final a.InterfaceC0221a bNj = new a.InterfaceC0221a() { // from class: com.baidu.live.tieba.yuyinala.b.a.3
        @Override // com.baidu.live.tieba.yuyinala.e.a.InterfaceC0221a
        public void afterTextChanged(Editable editable) {
        }
    };

    public a(TbPageContext tbPageContext, String str, String str2) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bNf = new com.baidu.live.tieba.yuyinala.e.a(this.mTbPageContext, this.mOnClickListener, this.bNj);
        this.bNf.aN(this.mLiveId, str2);
        this.bNg = new c(this.mTbPageContext.getContext());
        this.bNg.a(this.bNi);
    }

    public a(TbPageContext tbPageContext, String str, String str2, String str3) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bMT = str3;
        this.bNf = new com.baidu.live.tieba.yuyinala.e.a(this.mTbPageContext, this.mOnClickListener, this.bNj);
        this.bNf.aN(this.mLiveId, str2);
        this.bNh = new com.baidu.live.tieba.yuyinala.d.b(this.mTbPageContext.getContext());
        this.bNh.a(this.bNi);
    }

    public View getView() {
        return this.bNf.getView();
    }

    public void onDestroy() {
        if (this.bNg != null) {
            this.bNg.onDestroy();
        }
        if (this.bNh != null) {
            this.bNh.onDestroy();
        }
        this.bNf.onDestroy();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.bNf != null) {
            this.bNf.onKeyboardVisibilityChanged(z);
        }
    }
}
