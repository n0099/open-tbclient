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
    private com.baidu.live.yuyinnoble.c.a bOw;
    private TextView boi;
    private TextView boj;
    private TbImageView bok;
    private View mRootView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.yuyin_ala_noble_list_bottom_layout, (ViewGroup) null);
        this.boi = (TextView) this.mRootView.findViewById(a.g.noble_list_bottom_btn);
        this.boi.setOnClickListener(this);
        this.boj = (TextView) this.mRootView.findViewById(a.g.noble_list_bottom_sub_text);
        this.bok = (TbImageView) this.mRootView.findViewById(a.g.noble_list_bottom_text_mark);
        this.bok.setDefaultBgResource(0);
        this.bok.setDefaultResource(0);
    }

    public void b(com.baidu.live.yuyinnoble.c.a aVar) {
        if (aVar != null && aVar.bOA != null) {
            this.bOw = aVar;
            if (this.bOw.bOA.type_id == 1) {
                this.boj.setVisibility(0);
                this.boj.setText(this.bOw.bOA.text);
                this.bok.setVisibility(8);
                this.boi.setText(this.mTbPageContext.getResources().getString(a.i.yuyin_noble_bottom_open_noble));
            } else if (this.bOw.bOA.type_id == 2) {
                this.boj.setVisibility(0);
                this.bok.setVisibility(0);
                this.bok.startLoad(this.bOw.bOA.icon_url, 10, false);
                this.boi.setText(this.mTbPageContext.getResources().getString(a.i.yuyin_noble_bottom_immediate_renewal));
                Og();
            } else if (this.bOw.bOA.type_id == 3) {
                this.boj.setVisibility(0);
                this.bok.setVisibility(0);
                this.bok.startLoad(this.bOw.bOA.icon_url, 10, false);
                this.boi.setText(this.mTbPageContext.getResources().getString(a.i.yuyin_noble_bottom_check_detail));
                Og();
            } else if (this.bOw.bOA.type_id == 4) {
                this.boj.setVisibility(0);
                this.bok.setVisibility(0);
                this.bok.startLoad(this.bOw.bOA.icon_url, 10, false);
                this.boi.setText(this.mTbPageContext.getResources().getString(a.i.yuyin_noble_bottom_renewal_discount));
                this.boj.setText(this.bOw.bOA.text);
            }
        }
    }

    private void Og() {
        if (this.boj != null && this.bOw != null && this.bOw.bOA != null) {
            String string = this.mTbPageContext.getResources().getString(a.i.noble_bottom_main_content_msg);
            Object[] objArr = new Object[1];
            objArr[0] = StringUtils.isNull(this.bOw.bOA.text) ? "" : this.bOw.bOA.text;
            String format = String.format(string, objArr);
            String string2 = this.mTbPageContext.getResources().getString(a.i.noble_bottom_main_content_day);
            Object[] objArr2 = new Object[1];
            objArr2[0] = StringUtils.isNull(this.bOw.bOA.bnU) ? "" : this.bOw.bOA.bnU;
            this.boj.setText(format + String.format(string2, objArr2));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.boi) {
            Oh();
        }
    }

    private void Oh() {
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && ViewHelper.checkUpIsLogin(this.mTbPageContext.getPageActivity()) && this.bOw != null && this.bOw.bOA != null && !StringUtils.isNull(this.bOw.bOA.buy_url)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            if (this.bOw.bOB != null) {
                nobleDetailInfo.roleId = this.bOw.bOB.id;
            }
            nobleDetailInfo.url = this.bOw.bOA.buy_url;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501031, nobleDetailInfo));
        }
    }
}
