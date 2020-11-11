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
    private com.baidu.live.yuyinnoble.c.a bUg;
    private TextView bpB;
    private TextView bpC;
    private TbImageView bpD;
    private View mRootView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_ala_noble_list_bottom_layout, (ViewGroup) null);
        this.bpB = (TextView) this.mRootView.findViewById(a.f.noble_list_bottom_btn);
        this.bpB.setOnClickListener(this);
        this.bpC = (TextView) this.mRootView.findViewById(a.f.noble_list_bottom_sub_text);
        this.bpD = (TbImageView) this.mRootView.findViewById(a.f.noble_list_bottom_text_mark);
        this.bpD.setDefaultBgResource(0);
        this.bpD.setDefaultResource(0);
    }

    public void b(com.baidu.live.yuyinnoble.c.a aVar) {
        if (aVar != null && aVar.bUk != null) {
            this.bUg = aVar;
            if (this.bUg.bUk.type_id == 1) {
                this.bpC.setVisibility(0);
                this.bpC.setText(this.bUg.bUk.text);
                this.bpD.setVisibility(8);
                this.bpB.setText(this.mTbPageContext.getResources().getString(a.h.yuyin_noble_bottom_open_noble));
            } else if (this.bUg.bUk.type_id == 2) {
                this.bpC.setVisibility(0);
                this.bpD.setVisibility(0);
                this.bpD.startLoad(this.bUg.bUk.icon_url, 10, false);
                this.bpB.setText(this.mTbPageContext.getResources().getString(a.h.yuyin_noble_bottom_immediate_renewal));
                OG();
            } else if (this.bUg.bUk.type_id == 3) {
                this.bpC.setVisibility(0);
                this.bpD.setVisibility(0);
                this.bpD.startLoad(this.bUg.bUk.icon_url, 10, false);
                this.bpB.setText(this.mTbPageContext.getResources().getString(a.h.yuyin_noble_bottom_check_detail));
                OG();
            } else if (this.bUg.bUk.type_id == 4) {
                this.bpC.setVisibility(0);
                this.bpD.setVisibility(0);
                this.bpD.startLoad(this.bUg.bUk.icon_url, 10, false);
                this.bpB.setText(this.mTbPageContext.getResources().getString(a.h.yuyin_noble_bottom_renewal_discount));
                this.bpC.setText(this.bUg.bUk.text);
            }
        }
    }

    private void OG() {
        if (this.bpC != null && this.bUg != null && this.bUg.bUk != null) {
            String string = this.mTbPageContext.getResources().getString(a.h.noble_bottom_main_content_msg);
            Object[] objArr = new Object[1];
            objArr[0] = StringUtils.isNull(this.bUg.bUk.text) ? "" : this.bUg.bUk.text;
            String format = String.format(string, objArr);
            String string2 = this.mTbPageContext.getResources().getString(a.h.noble_bottom_main_content_day);
            Object[] objArr2 = new Object[1];
            objArr2[0] = StringUtils.isNull(this.bUg.bUk.bpn) ? "" : this.bUg.bUk.bpn;
            this.bpC.setText(format + String.format(string2, objArr2));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bpB) {
            OH();
        }
    }

    private void OH() {
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && ViewHelper.checkUpIsLogin(this.mTbPageContext.getPageActivity()) && this.bUg != null && this.bUg.bUk != null && !StringUtils.isNull(this.bUg.bUk.buy_url)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            if (this.bUg.bUl != null) {
                nobleDetailInfo.roleId = this.bUg.bUl.id;
            }
            nobleDetailInfo.url = this.bUg.bUk.buy_url;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501031, nobleDetailInfo));
        }
    }
}
