package com.baidu.live.yuyinnoble.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.noble.data.NobleDetailInfo;
import com.baidu.live.noble.data.d;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes10.dex */
public class a implements View.OnClickListener {
    private d brp;
    private TextView bsX;
    private TextView bsY;
    private TbImageView bsZ;
    private View mRootView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_ala_noble_list_bottom_layout, (ViewGroup) null);
        this.bsX = (TextView) this.mRootView.findViewById(a.f.noble_list_bottom_btn);
        this.bsX.setOnClickListener(this);
        this.bsY = (TextView) this.mRootView.findViewById(a.f.noble_list_bottom_sub_text);
        this.bsZ = (TbImageView) this.mRootView.findViewById(a.f.noble_list_bottom_text_mark);
        this.bsZ.setDefaultBgResource(0);
        this.bsZ.setDefaultResource(0);
    }

    public void b(d dVar) {
        if (dVar != null && dVar.bsM != null) {
            this.brp = dVar;
            if (this.brp.bsM.type_id == 1) {
                this.bsY.setVisibility(0);
                this.bsY.setText(this.brp.bsM.text);
                this.bsZ.setVisibility(8);
                this.bsX.setText(this.mTbPageContext.getResources().getString(a.h.yuyin_noble_bottom_open_noble));
            } else if (this.brp.bsM.type_id == 2) {
                this.bsY.setVisibility(0);
                this.bsZ.setVisibility(0);
                this.bsZ.startLoad(this.brp.bsM.icon_url, 10, false);
                this.bsX.setText(this.mTbPageContext.getResources().getString(a.h.yuyin_noble_bottom_immediate_renewal));
                Nz();
            } else if (this.brp.bsM.type_id == 3) {
                this.bsY.setVisibility(0);
                this.bsZ.setVisibility(0);
                this.bsZ.startLoad(this.brp.bsM.icon_url, 10, false);
                this.bsX.setText(this.mTbPageContext.getResources().getString(a.h.yuyin_noble_bottom_check_detail));
                Nz();
            } else if (this.brp.bsM.type_id == 4) {
                this.bsY.setVisibility(0);
                this.bsZ.setVisibility(0);
                this.bsZ.startLoad(this.brp.bsM.icon_url, 10, false);
                this.bsX.setText(this.mTbPageContext.getResources().getString(a.h.yuyin_noble_bottom_renewal_discount));
                this.bsY.setText(this.brp.bsM.text);
            }
        }
    }

    private void Nz() {
        if (this.bsY != null && this.brp != null && this.brp.bsM != null) {
            String string = this.mTbPageContext.getResources().getString(a.h.noble_bottom_main_content_msg);
            Object[] objArr = new Object[1];
            objArr[0] = StringUtils.isNull(this.brp.bsM.text) ? "" : this.brp.bsM.text;
            String format = String.format(string, objArr);
            String string2 = this.mTbPageContext.getResources().getString(a.h.noble_bottom_main_content_day);
            Object[] objArr2 = new Object[1];
            objArr2[0] = StringUtils.isNull(this.brp.bsM.bsH) ? "" : this.brp.bsM.bsH;
            this.bsY.setText(format + String.format(string2, objArr2));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bsX) {
            NA();
        }
    }

    private void NA() {
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && ViewHelper.checkUpIsLogin(this.mTbPageContext.getPageActivity()) && this.brp != null && this.brp.bsM != null && !StringUtils.isNull(this.brp.bsM.buy_url)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            if (this.brp.bsN != null) {
                nobleDetailInfo.roleId = this.brp.bsN.id;
            }
            nobleDetailInfo.url = this.brp.bsM.buy_url;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501031, nobleDetailInfo));
        }
    }
}
