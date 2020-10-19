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
    private TextView bmK;
    private TextView bmL;
    private TbImageView bmM;
    private com.baidu.live.noble.data.b bmi;
    private View mRootView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_noble_list_bottom_layout, (ViewGroup) null);
        this.bmK = (TextView) this.mRootView.findViewById(a.g.noble_list_bottom_btn);
        this.bmK.setOnClickListener(this);
        this.bmL = (TextView) this.mRootView.findViewById(a.g.noble_list_bottom_sub_text);
        this.bmM = (TbImageView) this.mRootView.findViewById(a.g.noble_list_bottom_text_mark);
        this.bmM.setDefaultBgResource(0);
        this.bmM.setDefaultResource(0);
    }

    public void b(com.baidu.live.noble.data.b bVar) {
        if (bVar != null && bVar.bmu != null) {
            this.bmi = bVar;
            if (this.bmi.bmu.type_id == 1) {
                this.bmL.setVisibility(0);
                this.bmL.setText(this.bmi.bmu.text);
                this.bmM.setVisibility(0);
                this.bmM.startLoad(this.bmi.bmu.icon_url, 10, false);
                this.bmK.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_open_noble));
            } else if (this.bmi.bmu.type_id == 2) {
                this.bmL.setVisibility(0);
                this.bmM.setVisibility(0);
                this.bmM.startLoad(this.bmi.bmu.icon_url, 10, false);
                this.bmK.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_immediate_renewal));
                NJ();
            } else if (this.bmi.bmu.type_id == 3) {
                this.bmL.setVisibility(0);
                this.bmM.setVisibility(0);
                this.bmM.startLoad(this.bmi.bmu.icon_url, 10, false);
                this.bmK.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_check_detail));
                NJ();
            } else if (this.bmi.bmu.type_id == 4) {
                this.bmL.setVisibility(0);
                this.bmM.setVisibility(0);
                this.bmM.startLoad(this.bmi.bmu.icon_url, 10, false);
                this.bmK.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_renewal_discount));
                this.bmL.setText(this.bmi.bmu.text);
            }
        }
    }

    private void NJ() {
        if (this.bmL != null && this.bmi != null && this.bmi.bmu != null) {
            String string = this.mTbPageContext.getResources().getString(a.i.noble_bottom_main_content_msg);
            Object[] objArr = new Object[1];
            objArr[0] = StringUtils.isNull(this.bmi.bmu.text) ? "" : this.bmi.bmu.text;
            String format = String.format(string, objArr);
            String string2 = this.mTbPageContext.getResources().getString(a.i.noble_bottom_main_content_day);
            Object[] objArr2 = new Object[1];
            objArr2[0] = StringUtils.isNull(this.bmi.bmu.bmx) ? "" : this.bmi.bmu.bmx;
            this.bmL.setText(format + String.format(string2, objArr2));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bmK) {
            NK();
        }
    }

    private void NK() {
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && ViewHelper.checkUpIsLogin(this.mTbPageContext.getPageActivity()) && this.bmi != null && this.bmi.bmu != null && !StringUtils.isNull(this.bmi.bmu.buy_url)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            if (this.bmi.bmv != null) {
                nobleDetailInfo.roleId = this.bmi.bmv.id;
            }
            nobleDetailInfo.url = this.bmi.bmu.buy_url;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
        }
    }
}
