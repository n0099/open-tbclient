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
    private TextView biX;
    private TextView biY;
    private TbImageView biZ;
    private com.baidu.live.noble.data.b biv;
    private View mRootView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_noble_list_bottom_layout, (ViewGroup) null);
        this.biX = (TextView) this.mRootView.findViewById(a.g.noble_list_bottom_btn);
        this.biX.setOnClickListener(this);
        this.biY = (TextView) this.mRootView.findViewById(a.g.noble_list_bottom_sub_text);
        this.biZ = (TbImageView) this.mRootView.findViewById(a.g.noble_list_bottom_text_mark);
        this.biZ.setDefaultBgResource(0);
        this.biZ.setDefaultResource(0);
    }

    public void b(com.baidu.live.noble.data.b bVar) {
        if (bVar != null && bVar.biH != null) {
            this.biv = bVar;
            if (this.biv.biH.type_id == 1) {
                this.biY.setVisibility(0);
                this.biY.setText(this.biv.biH.text);
                this.biZ.setVisibility(0);
                this.biZ.startLoad(this.biv.biH.icon_url, 10, false);
                this.biX.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_open_noble));
            } else if (this.biv.biH.type_id == 2) {
                this.biY.setVisibility(0);
                this.biZ.setVisibility(0);
                this.biZ.startLoad(this.biv.biH.icon_url, 10, false);
                this.biX.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_immediate_renewal));
                ME();
            } else if (this.biv.biH.type_id == 3) {
                this.biY.setVisibility(0);
                this.biZ.setVisibility(0);
                this.biZ.startLoad(this.biv.biH.icon_url, 10, false);
                this.biX.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_check_detail));
                ME();
            } else if (this.biv.biH.type_id == 4) {
                this.biY.setVisibility(0);
                this.biZ.setVisibility(0);
                this.biZ.startLoad(this.biv.biH.icon_url, 10, false);
                this.biX.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_renewal_discount));
                this.biY.setText(this.biv.biH.text);
            }
        }
    }

    private void ME() {
        if (this.biY != null && this.biv != null && this.biv.biH != null) {
            String string = this.mTbPageContext.getResources().getString(a.i.noble_bottom_main_content_msg);
            Object[] objArr = new Object[1];
            objArr[0] = StringUtils.isNull(this.biv.biH.text) ? "" : this.biv.biH.text;
            String format = String.format(string, objArr);
            String string2 = this.mTbPageContext.getResources().getString(a.i.noble_bottom_main_content_day);
            Object[] objArr2 = new Object[1];
            objArr2[0] = StringUtils.isNull(this.biv.biH.biK) ? "" : this.biv.biH.biK;
            this.biY.setText(format + String.format(string2, objArr2));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.biX) {
            MF();
        }
    }

    private void MF() {
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && ViewHelper.checkUpIsLogin(this.mTbPageContext.getPageActivity()) && this.biv != null && this.biv.biH != null && !StringUtils.isNull(this.biv.biH.buy_url)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            if (this.biv.biI != null) {
                nobleDetailInfo.roleId = this.biv.biI.id;
            }
            nobleDetailInfo.url = this.biv.biH.buy_url;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
        }
    }
}
