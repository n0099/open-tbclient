package com.baidu.live.noble.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.noble.data.NobleDetailInfo;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private com.baidu.live.noble.data.b aXz;
    private TextView aYb;
    private TextView aYc;
    private TbImageView aYd;
    private View mRootView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_noble_list_bottom_layout, (ViewGroup) null);
        this.aYb = (TextView) this.mRootView.findViewById(a.g.noble_list_bottom_btn);
        this.aYb.setOnClickListener(this);
        this.aYc = (TextView) this.mRootView.findViewById(a.g.noble_list_bottom_sub_text);
        this.aYd = (TbImageView) this.mRootView.findViewById(a.g.noble_list_bottom_text_mark);
        this.aYd.setDefaultBgResource(0);
        this.aYd.setDefaultResource(0);
    }

    public void b(com.baidu.live.noble.data.b bVar) {
        if (bVar != null && bVar.aXL != null) {
            this.aXz = bVar;
            if (this.aXz.aXL.type_id == 1) {
                this.aYc.setVisibility(0);
                this.aYc.setText(this.aXz.aXL.text);
                this.aYd.setVisibility(0);
                this.aYd.startLoad(this.aXz.aXL.icon_url, 10, false);
                this.aYb.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_open_noble));
            } else if (this.aXz.aXL.type_id == 2) {
                this.aYc.setVisibility(0);
                this.aYd.setVisibility(0);
                this.aYd.startLoad(this.aXz.aXL.icon_url, 10, false);
                this.aYb.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_immediate_renewal));
                FK();
            } else if (this.aXz.aXL.type_id == 3) {
                this.aYc.setVisibility(0);
                this.aYd.setVisibility(0);
                this.aYd.startLoad(this.aXz.aXL.icon_url, 10, false);
                this.aYb.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_check_detail));
                FK();
            } else if (this.aXz.aXL.type_id == 4) {
                this.aYc.setVisibility(0);
                this.aYd.setVisibility(0);
                this.aYd.startLoad(this.aXz.aXL.icon_url, 10, false);
                this.aYb.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_renewal_discount));
                this.aYc.setText(this.aXz.aXL.text);
            }
        }
    }

    private void FK() {
        if (this.aYc != null && this.aXz != null && this.aXz.aXL != null) {
            String string = this.mTbPageContext.getResources().getString(a.i.noble_bottom_main_content_msg);
            Object[] objArr = new Object[1];
            objArr[0] = StringUtils.isNull(this.aXz.aXL.text) ? "" : this.aXz.aXL.text;
            String format = String.format(string, objArr);
            String string2 = this.mTbPageContext.getResources().getString(a.i.noble_bottom_main_content_day);
            Object[] objArr2 = new Object[1];
            objArr2[0] = StringUtils.isNull(this.aXz.aXL.aXO) ? "" : this.aXz.aXL.aXO;
            this.aYc.setText(format + String.format(string2, objArr2));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aYb) {
            FL();
        }
    }

    private void FL() {
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && ViewHelper.checkUpIsLogin(this.mTbPageContext.getPageActivity()) && this.aXz != null && this.aXz.aXL != null && !StringUtils.isNull(this.aXz.aXL.buy_url)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            if (this.aXz.aXM != null) {
                nobleDetailInfo.roleId = this.aXz.aXM.id;
            }
            nobleDetailInfo.url = this.aXz.aXL.buy_url;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
        }
    }
}
