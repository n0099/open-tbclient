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
    private com.baidu.live.noble.data.b bfB;
    private TextView bgd;
    private TextView bge;
    private TbImageView bgf;
    private View mRootView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_noble_list_bottom_layout, (ViewGroup) null);
        this.bgd = (TextView) this.mRootView.findViewById(a.g.noble_list_bottom_btn);
        this.bgd.setOnClickListener(this);
        this.bge = (TextView) this.mRootView.findViewById(a.g.noble_list_bottom_sub_text);
        this.bgf = (TbImageView) this.mRootView.findViewById(a.g.noble_list_bottom_text_mark);
        this.bgf.setDefaultBgResource(0);
        this.bgf.setDefaultResource(0);
    }

    public void b(com.baidu.live.noble.data.b bVar) {
        if (bVar != null && bVar.bfN != null) {
            this.bfB = bVar;
            if (this.bfB.bfN.type_id == 1) {
                this.bge.setVisibility(0);
                this.bge.setText(this.bfB.bfN.text);
                this.bgf.setVisibility(0);
                this.bgf.startLoad(this.bfB.bfN.icon_url, 10, false);
                this.bgd.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_open_noble));
            } else if (this.bfB.bfN.type_id == 2) {
                this.bge.setVisibility(0);
                this.bgf.setVisibility(0);
                this.bgf.startLoad(this.bfB.bfN.icon_url, 10, false);
                this.bgd.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_immediate_renewal));
                Mb();
            } else if (this.bfB.bfN.type_id == 3) {
                this.bge.setVisibility(0);
                this.bgf.setVisibility(0);
                this.bgf.startLoad(this.bfB.bfN.icon_url, 10, false);
                this.bgd.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_check_detail));
                Mb();
            } else if (this.bfB.bfN.type_id == 4) {
                this.bge.setVisibility(0);
                this.bgf.setVisibility(0);
                this.bgf.startLoad(this.bfB.bfN.icon_url, 10, false);
                this.bgd.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_renewal_discount));
                this.bge.setText(this.bfB.bfN.text);
            }
        }
    }

    private void Mb() {
        if (this.bge != null && this.bfB != null && this.bfB.bfN != null) {
            String string = this.mTbPageContext.getResources().getString(a.i.noble_bottom_main_content_msg);
            Object[] objArr = new Object[1];
            objArr[0] = StringUtils.isNull(this.bfB.bfN.text) ? "" : this.bfB.bfN.text;
            String format = String.format(string, objArr);
            String string2 = this.mTbPageContext.getResources().getString(a.i.noble_bottom_main_content_day);
            Object[] objArr2 = new Object[1];
            objArr2[0] = StringUtils.isNull(this.bfB.bfN.bfQ) ? "" : this.bfB.bfN.bfQ;
            this.bge.setText(format + String.format(string2, objArr2));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bgd) {
            Mc();
        }
    }

    private void Mc() {
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && ViewHelper.checkUpIsLogin(this.mTbPageContext.getPageActivity()) && this.bfB != null && this.bfB.bfN != null && !StringUtils.isNull(this.bfB.bfN.buy_url)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            if (this.bfB.bfO != null) {
                nobleDetailInfo.roleId = this.bfB.bfO.id;
            }
            nobleDetailInfo.url = this.bfB.bfN.buy_url;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
        }
    }
}
