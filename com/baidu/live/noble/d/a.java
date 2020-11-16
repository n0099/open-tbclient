package com.baidu.live.noble.d;

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
    private TextView bnQ;
    private TextView bnR;
    private TbImageView bnS;
    private com.baidu.live.noble.data.b bnr;
    private View mRootView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_noble_list_bottom_layout, (ViewGroup) null);
        this.bnQ = (TextView) this.mRootView.findViewById(a.f.noble_list_bottom_btn);
        this.bnQ.setOnClickListener(this);
        this.bnR = (TextView) this.mRootView.findViewById(a.f.noble_list_bottom_sub_text);
        this.bnS = (TbImageView) this.mRootView.findViewById(a.f.noble_list_bottom_text_mark);
        this.bnS.setDefaultBgResource(0);
        this.bnS.setDefaultResource(0);
    }

    public void b(com.baidu.live.noble.data.b bVar) {
        if (bVar != null && bVar.bnz != null) {
            this.bnr = bVar;
            if (this.bnr.bnz.type_id == 1) {
                this.bnR.setVisibility(0);
                this.bnR.setText(this.bnr.bnz.text);
                this.bnS.setVisibility(0);
                this.bnS.startLoad(this.bnr.bnz.icon_url, 10, false);
                this.bnQ.setText(this.mTbPageContext.getResources().getString(a.h.noble_bottom_open_noble));
            } else if (this.bnr.bnz.type_id == 2) {
                this.bnR.setVisibility(0);
                this.bnS.setVisibility(0);
                this.bnS.startLoad(this.bnr.bnz.icon_url, 10, false);
                this.bnQ.setText(this.mTbPageContext.getResources().getString(a.h.noble_bottom_immediate_renewal));
                NX();
            } else if (this.bnr.bnz.type_id == 3) {
                this.bnR.setVisibility(0);
                this.bnS.setVisibility(0);
                this.bnS.startLoad(this.bnr.bnz.icon_url, 10, false);
                this.bnQ.setText(this.mTbPageContext.getResources().getString(a.h.noble_bottom_check_detail));
                NX();
            } else if (this.bnr.bnz.type_id == 4) {
                this.bnR.setVisibility(0);
                this.bnS.setVisibility(0);
                this.bnS.startLoad(this.bnr.bnz.icon_url, 10, false);
                this.bnQ.setText(this.mTbPageContext.getResources().getString(a.h.noble_bottom_renewal_discount));
                this.bnR.setText(this.bnr.bnz.text);
            }
        }
    }

    private void NX() {
        if (this.bnR != null && this.bnr != null && this.bnr.bnz != null) {
            String string = this.mTbPageContext.getResources().getString(a.h.noble_bottom_main_content_msg);
            Object[] objArr = new Object[1];
            objArr[0] = StringUtils.isNull(this.bnr.bnz.text) ? "" : this.bnr.bnz.text;
            String format = String.format(string, objArr);
            String string2 = this.mTbPageContext.getResources().getString(a.h.noble_bottom_main_content_day);
            Object[] objArr2 = new Object[1];
            objArr2[0] = StringUtils.isNull(this.bnr.bnz.bnC) ? "" : this.bnr.bnz.bnC;
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
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && ViewHelper.checkUpIsLogin(this.mTbPageContext.getPageActivity()) && this.bnr != null && this.bnr.bnz != null && !StringUtils.isNull(this.bnr.bnz.buy_url)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            if (this.bnr.bnA != null) {
                nobleDetailInfo.roleId = this.bnr.bnA.id;
            }
            nobleDetailInfo.url = this.bnr.bnz.buy_url;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
        }
    }
}
