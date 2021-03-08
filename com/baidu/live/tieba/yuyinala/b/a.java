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
    private com.baidu.live.tieba.yuyinala.e.a bOF;
    private c bOG;
    private com.baidu.live.tieba.yuyinala.d.b bOH;
    private String bOt;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;
    private final c.a bOI = new c.a() { // from class: com.baidu.live.tieba.yuyinala.b.a.1
        @Override // com.baidu.live.tieba.yuyinala.d.c.a
        public void Pj() {
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
            if (a.this.bOF.Vk().length() > 20) {
                BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.h.txt_describe_feedback_reason_text_max_limit);
            } else if (TextUtils.isEmpty(a.this.mRoomId) || a.this.bOG == null) {
                if (!TextUtils.isEmpty(a.this.mRoomId) && !TextUtils.isEmpty(a.this.bOt) && a.this.bOH != null) {
                    a.this.bOH.D(a.this.mRoomId, a.this.bOF.Vk(), a.this.bOt);
                }
            } else {
                a.this.bOG.aO(a.this.mRoomId, a.this.bOF.Vk());
            }
        }
    };
    private final a.InterfaceC0227a bOJ = new a.InterfaceC0227a() { // from class: com.baidu.live.tieba.yuyinala.b.a.3
        @Override // com.baidu.live.tieba.yuyinala.e.a.InterfaceC0227a
        public void afterTextChanged(Editable editable) {
        }
    };

    public a(TbPageContext tbPageContext, String str, String str2) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bOF = new com.baidu.live.tieba.yuyinala.e.a(this.mTbPageContext, this.mOnClickListener, this.bOJ);
        this.bOF.aN(this.mLiveId, str2);
        this.bOG = new c(this.mTbPageContext.getContext());
        this.bOG.a(this.bOI);
    }

    public a(TbPageContext tbPageContext, String str, String str2, String str3) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bOt = str3;
        this.bOF = new com.baidu.live.tieba.yuyinala.e.a(this.mTbPageContext, this.mOnClickListener, this.bOJ);
        this.bOF.aN(this.mLiveId, str2);
        this.bOH = new com.baidu.live.tieba.yuyinala.d.b(this.mTbPageContext.getContext());
        this.bOH.a(this.bOI);
    }

    public View getView() {
        return this.bOF.getView();
    }

    public void onDestroy() {
        if (this.bOG != null) {
            this.bOG.onDestroy();
        }
        if (this.bOH != null) {
            this.bOH.onDestroy();
        }
        this.bOF.onDestroy();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.bOF != null) {
            this.bOF.onKeyboardVisibilityChanged(z);
        }
    }
}
