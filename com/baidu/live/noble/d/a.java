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
/* loaded from: classes7.dex */
public class a implements View.OnClickListener {
    private com.baidu.live.noble.data.b bfD;
    private TextView bgf;
    private TextView bgg;
    private TbImageView bgh;
    private View mRootView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_noble_list_bottom_layout, (ViewGroup) null);
        this.bgf = (TextView) this.mRootView.findViewById(a.g.noble_list_bottom_btn);
        this.bgf.setOnClickListener(this);
        this.bgg = (TextView) this.mRootView.findViewById(a.g.noble_list_bottom_sub_text);
        this.bgh = (TbImageView) this.mRootView.findViewById(a.g.noble_list_bottom_text_mark);
        this.bgh.setDefaultBgResource(0);
        this.bgh.setDefaultResource(0);
    }

    public void b(com.baidu.live.noble.data.b bVar) {
        if (bVar != null && bVar.bfP != null) {
            this.bfD = bVar;
            if (this.bfD.bfP.type_id == 1) {
                this.bgg.setVisibility(0);
                this.bgg.setText(this.bfD.bfP.text);
                this.bgh.setVisibility(0);
                this.bgh.startLoad(this.bfD.bfP.icon_url, 10, false);
                this.bgf.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_open_noble));
            } else if (this.bfD.bfP.type_id == 2) {
                this.bgg.setVisibility(0);
                this.bgh.setVisibility(0);
                this.bgh.startLoad(this.bfD.bfP.icon_url, 10, false);
                this.bgf.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_immediate_renewal));
                Mb();
            } else if (this.bfD.bfP.type_id == 3) {
                this.bgg.setVisibility(0);
                this.bgh.setVisibility(0);
                this.bgh.startLoad(this.bfD.bfP.icon_url, 10, false);
                this.bgf.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_check_detail));
                Mb();
            } else if (this.bfD.bfP.type_id == 4) {
                this.bgg.setVisibility(0);
                this.bgh.setVisibility(0);
                this.bgh.startLoad(this.bfD.bfP.icon_url, 10, false);
                this.bgf.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_renewal_discount));
                this.bgg.setText(this.bfD.bfP.text);
            }
        }
    }

    private void Mb() {
        if (this.bgg != null && this.bfD != null && this.bfD.bfP != null) {
            String string = this.mTbPageContext.getResources().getString(a.i.noble_bottom_main_content_msg);
            Object[] objArr = new Object[1];
            objArr[0] = StringUtils.isNull(this.bfD.bfP.text) ? "" : this.bfD.bfP.text;
            String format = String.format(string, objArr);
            String string2 = this.mTbPageContext.getResources().getString(a.i.noble_bottom_main_content_day);
            Object[] objArr2 = new Object[1];
            objArr2[0] = StringUtils.isNull(this.bfD.bfP.bfS) ? "" : this.bfD.bfP.bfS;
            this.bgg.setText(format + String.format(string2, objArr2));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bgf) {
            Mc();
        }
    }

    private void Mc() {
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && ViewHelper.checkUpIsLogin(this.mTbPageContext.getPageActivity()) && this.bfD != null && this.bfD.bfP != null && !StringUtils.isNull(this.bfD.bfP.buy_url)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            if (this.bfD.bfQ != null) {
                nobleDetailInfo.roleId = this.bfD.bfQ.id;
            }
            nobleDetailInfo.url = this.bfD.bfP.buy_url;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
        }
    }
}
