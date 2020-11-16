package com.baidu.live.yuyinnoble.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.noble.data.NobleDetailInfo;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {
    private com.baidu.live.yuyinnoble.c.a bSw;
    private TextView bnQ;
    private TextView bnR;
    private TbImageView bnS;
    private View mRootView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_ala_noble_list_bottom_layout, (ViewGroup) null);
        this.bnQ = (TextView) this.mRootView.findViewById(a.f.noble_list_bottom_btn);
        this.bnQ.setOnClickListener(this);
        this.bnR = (TextView) this.mRootView.findViewById(a.f.noble_list_bottom_sub_text);
        this.bnS = (TbImageView) this.mRootView.findViewById(a.f.noble_list_bottom_text_mark);
        this.bnS.setDefaultBgResource(0);
        this.bnS.setDefaultResource(0);
    }

    public void b(com.baidu.live.yuyinnoble.c.a aVar) {
        if (aVar != null && aVar.bSA != null) {
            this.bSw = aVar;
            if (this.bSw.bSA.type_id == 1) {
                this.bnR.setVisibility(0);
                this.bnR.setText(this.bSw.bSA.text);
                this.bnS.setVisibility(8);
                this.bnQ.setText(this.mTbPageContext.getResources().getString(a.h.yuyin_noble_bottom_open_noble));
            } else if (this.bSw.bSA.type_id == 2) {
                this.bnR.setVisibility(0);
                this.bnS.setVisibility(0);
                this.bnS.startLoad(this.bSw.bSA.icon_url, 10, false);
                this.bnQ.setText(this.mTbPageContext.getResources().getString(a.h.yuyin_noble_bottom_immediate_renewal));
                NX();
            } else if (this.bSw.bSA.type_id == 3) {
                this.bnR.setVisibility(0);
                this.bnS.setVisibility(0);
                this.bnS.startLoad(this.bSw.bSA.icon_url, 10, false);
                this.bnQ.setText(this.mTbPageContext.getResources().getString(a.h.yuyin_noble_bottom_check_detail));
                NX();
            } else if (this.bSw.bSA.type_id == 4) {
                this.bnR.setVisibility(0);
                this.bnS.setVisibility(0);
                this.bnS.startLoad(this.bSw.bSA.icon_url, 10, false);
                this.bnQ.setText(this.mTbPageContext.getResources().getString(a.h.yuyin_noble_bottom_renewal_discount));
                this.bnR.setText(this.bSw.bSA.text);
            }
        }
    }

    private void NX() {
        if (this.bnR != null && this.bSw != null && this.bSw.bSA != null) {
            String string = this.mTbPageContext.getResources().getString(a.h.noble_bottom_main_content_msg);
            Object[] objArr = new Object[1];
            objArr[0] = StringUtils.isNull(this.bSw.bSA.text) ? "" : this.bSw.bSA.text;
            String format = String.format(string, objArr);
            String string2 = this.mTbPageContext.getResources().getString(a.h.noble_bottom_main_content_day);
            Object[] objArr2 = new Object[1];
            objArr2[0] = StringUtils.isNull(this.bSw.bSA.bnC) ? "" : this.bSw.bSA.bnC;
            this.bnR.setText(format + String.format(string2, objArr2));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bnQ) {
            NY();
        }
    }

    private void NY() {
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && ViewHelper.checkUpIsLogin(this.mTbPageContext.getPageActivity()) && this.bSw != null && this.bSw.bSA != null && !StringUtils.isNull(this.bSw.bSA.buy_url)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            if (this.bSw.bSB != null) {
                nobleDetailInfo.roleId = this.bSw.bSB.id;
            }
            nobleDetailInfo.url = this.bSw.bSA.buy_url;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501031, nobleDetailInfo));
        }
    }
}
