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
    private com.baidu.live.yuyinnoble.c.a bXM;
    private TextView bsY;
    private TextView bsZ;
    private TbImageView bta;
    private View mRootView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_ala_noble_list_bottom_layout, (ViewGroup) null);
        this.bsY = (TextView) this.mRootView.findViewById(a.f.noble_list_bottom_btn);
        this.bsY.setOnClickListener(this);
        this.bsZ = (TextView) this.mRootView.findViewById(a.f.noble_list_bottom_sub_text);
        this.bta = (TbImageView) this.mRootView.findViewById(a.f.noble_list_bottom_text_mark);
        this.bta.setDefaultBgResource(0);
        this.bta.setDefaultResource(0);
    }

    public void b(com.baidu.live.yuyinnoble.c.a aVar) {
        if (aVar != null && aVar.bXQ != null) {
            this.bXM = aVar;
            if (this.bXM.bXQ.type_id == 1) {
                this.bsZ.setVisibility(0);
                this.bsZ.setText(this.bXM.bXQ.text);
                this.bta.setVisibility(8);
                this.bsY.setText(this.mTbPageContext.getResources().getString(a.h.yuyin_noble_bottom_open_noble));
            } else if (this.bXM.bXQ.type_id == 2) {
                this.bsZ.setVisibility(0);
                this.bta.setVisibility(0);
                this.bta.startLoad(this.bXM.bXQ.icon_url, 10, false);
                this.bsY.setText(this.mTbPageContext.getResources().getString(a.h.yuyin_noble_bottom_immediate_renewal));
                Qq();
            } else if (this.bXM.bXQ.type_id == 3) {
                this.bsZ.setVisibility(0);
                this.bta.setVisibility(0);
                this.bta.startLoad(this.bXM.bXQ.icon_url, 10, false);
                this.bsY.setText(this.mTbPageContext.getResources().getString(a.h.yuyin_noble_bottom_check_detail));
                Qq();
            } else if (this.bXM.bXQ.type_id == 4) {
                this.bsZ.setVisibility(0);
                this.bta.setVisibility(0);
                this.bta.startLoad(this.bXM.bXQ.icon_url, 10, false);
                this.bsY.setText(this.mTbPageContext.getResources().getString(a.h.yuyin_noble_bottom_renewal_discount));
                this.bsZ.setText(this.bXM.bXQ.text);
            }
        }
    }

    private void Qq() {
        if (this.bsZ != null && this.bXM != null && this.bXM.bXQ != null) {
            String string = this.mTbPageContext.getResources().getString(a.h.noble_bottom_main_content_msg);
            Object[] objArr = new Object[1];
            objArr[0] = StringUtils.isNull(this.bXM.bXQ.text) ? "" : this.bXM.bXQ.text;
            String format = String.format(string, objArr);
            String string2 = this.mTbPageContext.getResources().getString(a.h.noble_bottom_main_content_day);
            Object[] objArr2 = new Object[1];
            objArr2[0] = StringUtils.isNull(this.bXM.bXQ.bsK) ? "" : this.bXM.bXQ.bsK;
            this.bsZ.setText(format + String.format(string2, objArr2));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bsY) {
            Qr();
        }
    }

    private void Qr() {
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && ViewHelper.checkUpIsLogin(this.mTbPageContext.getPageActivity()) && this.bXM != null && this.bXM.bXQ != null && !StringUtils.isNull(this.bXM.bXQ.buy_url)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            if (this.bXM.bXR != null) {
                nobleDetailInfo.roleId = this.bXM.bXR.id;
            }
            nobleDetailInfo.url = this.bXM.bXQ.buy_url;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501031, nobleDetailInfo));
        }
    }
}
