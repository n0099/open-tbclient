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
    private d bws;
    private TextView byb;
    private TextView byc;
    private TbImageView byd;
    private View mRootView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_ala_noble_list_bottom_layout, (ViewGroup) null);
        this.byb = (TextView) this.mRootView.findViewById(a.f.noble_list_bottom_btn);
        this.byb.setOnClickListener(this);
        this.byc = (TextView) this.mRootView.findViewById(a.f.noble_list_bottom_sub_text);
        this.byd = (TbImageView) this.mRootView.findViewById(a.f.noble_list_bottom_text_mark);
        this.byd.setDefaultBgResource(0);
        this.byd.setDefaultResource(0);
    }

    public void b(d dVar) {
        if (dVar != null && dVar.bxQ != null) {
            this.bws = dVar;
            if (this.bws.bxQ.type_id == 1) {
                this.byc.setVisibility(0);
                this.byc.setText(this.bws.bxQ.text);
                this.byd.setVisibility(8);
                this.byb.setText(this.mTbPageContext.getResources().getString(a.h.yuyin_noble_bottom_open_noble));
            } else if (this.bws.bxQ.type_id == 2) {
                this.byc.setVisibility(0);
                this.byd.setVisibility(0);
                this.byd.startLoad(this.bws.bxQ.icon_url, 10, false);
                this.byb.setText(this.mTbPageContext.getResources().getString(a.h.yuyin_noble_bottom_immediate_renewal));
                Pb();
            } else if (this.bws.bxQ.type_id == 3) {
                this.byc.setVisibility(0);
                this.byd.setVisibility(0);
                this.byd.startLoad(this.bws.bxQ.icon_url, 10, false);
                this.byb.setText(this.mTbPageContext.getResources().getString(a.h.yuyin_noble_bottom_check_detail));
                Pb();
            } else if (this.bws.bxQ.type_id == 4) {
                this.byc.setVisibility(0);
                this.byd.setVisibility(0);
                this.byd.startLoad(this.bws.bxQ.icon_url, 10, false);
                this.byb.setText(this.mTbPageContext.getResources().getString(a.h.yuyin_noble_bottom_renewal_discount));
                this.byc.setText(this.bws.bxQ.text);
            }
        }
    }

    private void Pb() {
        if (this.byc != null && this.bws != null && this.bws.bxQ != null) {
            String string = this.mTbPageContext.getResources().getString(a.h.noble_bottom_main_content_msg);
            Object[] objArr = new Object[1];
            objArr[0] = StringUtils.isNull(this.bws.bxQ.text) ? "" : this.bws.bxQ.text;
            String format = String.format(string, objArr);
            String string2 = this.mTbPageContext.getResources().getString(a.h.noble_bottom_main_content_day);
            Object[] objArr2 = new Object[1];
            objArr2[0] = StringUtils.isNull(this.bws.bxQ.bxL) ? "" : this.bws.bxQ.bxL;
            this.byc.setText(format + String.format(string2, objArr2));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.byb) {
            Pc();
        }
    }

    private void Pc() {
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && ViewHelper.checkUpIsLogin(this.mTbPageContext.getPageActivity()) && this.bws != null && this.bws.bxQ != null && !StringUtils.isNull(this.bws.bxQ.buy_url)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            if (this.bws.bxR != null) {
                nobleDetailInfo.roleId = this.bws.bxR.id;
            }
            nobleDetailInfo.url = this.bws.bxQ.buy_url;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501031, nobleDetailInfo));
        }
    }
}
