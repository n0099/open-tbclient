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
    private String bFK;
    private com.baidu.live.tieba.yuyinala.e.a bFW;
    private c bFX;
    private com.baidu.live.tieba.yuyinala.d.b bFY;
    private String mLiveId;
    private String mRoomId;
    private TbPageContext mTbPageContext;
    private final c.a bFZ = new c.a() { // from class: com.baidu.live.tieba.yuyinala.b.a.1
        @Override // com.baidu.live.tieba.yuyinala.d.c.a
        public void OL() {
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
            if (a.this.bFW.Uz().length() > 20) {
                BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.h.txt_describe_feedback_reason_text_max_limit);
            } else if (TextUtils.isEmpty(a.this.mRoomId) || a.this.bFX == null) {
                if (!TextUtils.isEmpty(a.this.mRoomId) && !TextUtils.isEmpty(a.this.bFK) && a.this.bFY != null) {
                    a.this.bFY.y(a.this.mRoomId, a.this.bFW.Uz(), a.this.bFK);
                }
            } else {
                a.this.bFX.aR(a.this.mRoomId, a.this.bFW.Uz());
            }
        }
    };
    private final a.InterfaceC0223a bGa = new a.InterfaceC0223a() { // from class: com.baidu.live.tieba.yuyinala.b.a.3
        @Override // com.baidu.live.tieba.yuyinala.e.a.InterfaceC0223a
        public void afterTextChanged(Editable editable) {
        }
    };

    public a(TbPageContext tbPageContext, String str, String str2) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bFW = new com.baidu.live.tieba.yuyinala.e.a(this.mTbPageContext, this.mOnClickListener, this.bGa);
        this.bFW.aQ(this.mLiveId, str2);
        this.bFX = new c(this.mTbPageContext.getContext());
        this.bFX.a(this.bFZ);
    }

    public a(TbPageContext tbPageContext, String str, String str2, String str3) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.mRoomId = str2;
        this.bFK = str3;
        this.bFW = new com.baidu.live.tieba.yuyinala.e.a(this.mTbPageContext, this.mOnClickListener, this.bGa);
        this.bFW.aQ(this.mLiveId, str2);
        this.bFY = new com.baidu.live.tieba.yuyinala.d.b(this.mTbPageContext.getContext());
        this.bFY.a(this.bFZ);
    }

    public View getView() {
        return this.bFW.getView();
    }

    public void onDestroy() {
        if (this.bFX != null) {
            this.bFX.onDestroy();
        }
        if (this.bFY != null) {
            this.bFY.onDestroy();
        }
        this.bFW.onDestroy();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.bFW != null) {
            this.bFW.onKeyboardVisibilityChanged(z);
        }
    }
}
