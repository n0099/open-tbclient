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
    private com.baidu.live.noble.data.b bnJ;
    private TextView boi;
    private TextView boj;
    private TbImageView bok;
    private View mRootView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_noble_list_bottom_layout, (ViewGroup) null);
        this.boi = (TextView) this.mRootView.findViewById(a.g.noble_list_bottom_btn);
        this.boi.setOnClickListener(this);
        this.boj = (TextView) this.mRootView.findViewById(a.g.noble_list_bottom_sub_text);
        this.bok = (TbImageView) this.mRootView.findViewById(a.g.noble_list_bottom_text_mark);
        this.bok.setDefaultBgResource(0);
        this.bok.setDefaultResource(0);
    }

    public void b(com.baidu.live.noble.data.b bVar) {
        if (bVar != null && bVar.bnR != null) {
            this.bnJ = bVar;
            if (this.bnJ.bnR.type_id == 1) {
                this.boj.setVisibility(0);
                this.boj.setText(this.bnJ.bnR.text);
                this.bok.setVisibility(0);
                this.bok.startLoad(this.bnJ.bnR.icon_url, 10, false);
                this.boi.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_open_noble));
            } else if (this.bnJ.bnR.type_id == 2) {
                this.boj.setVisibility(0);
                this.bok.setVisibility(0);
                this.bok.startLoad(this.bnJ.bnR.icon_url, 10, false);
                this.boi.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_immediate_renewal));
                Og();
            } else if (this.bnJ.bnR.type_id == 3) {
                this.boj.setVisibility(0);
                this.bok.setVisibility(0);
                this.bok.startLoad(this.bnJ.bnR.icon_url, 10, false);
                this.boi.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_check_detail));
                Og();
            } else if (this.bnJ.bnR.type_id == 4) {
                this.boj.setVisibility(0);
                this.bok.setVisibility(0);
                this.bok.startLoad(this.bnJ.bnR.icon_url, 10, false);
                this.boi.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_renewal_discount));
                this.boj.setText(this.bnJ.bnR.text);
            }
        }
    }

    private void Og() {
        if (this.boj != null && this.bnJ != null && this.bnJ.bnR != null) {
            String string = this.mTbPageContext.getResources().getString(a.i.noble_bottom_main_content_msg);
            Object[] objArr = new Object[1];
            objArr[0] = StringUtils.isNull(this.bnJ.bnR.text) ? "" : this.bnJ.bnR.text;
            String format = String.format(string, objArr);
            String string2 = this.mTbPageContext.getResources().getString(a.i.noble_bottom_main_content_day);
            Object[] objArr2 = new Object[1];
            objArr2[0] = StringUtils.isNull(this.bnJ.bnR.bnU) ? "" : this.bnJ.bnR.bnU;
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
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && ViewHelper.checkUpIsLogin(this.mTbPageContext.getPageActivity()) && this.bnJ != null && this.bnJ.bnR != null && !StringUtils.isNull(this.bnJ.bnR.buy_url)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            if (this.bnJ.bnS != null) {
                nobleDetailInfo.roleId = this.bnJ.bnS.id;
            }
            nobleDetailInfo.url = this.bnJ.bnR.buy_url;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
        }
    }
}
