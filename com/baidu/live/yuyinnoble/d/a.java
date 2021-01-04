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
/* loaded from: classes11.dex */
public class a implements View.OnClickListener {
    private d bwd;
    private TextView bxL;
    private TextView bxM;
    private TbImageView bxN;
    private View mRootView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_ala_noble_list_bottom_layout, (ViewGroup) null);
        this.bxL = (TextView) this.mRootView.findViewById(a.f.noble_list_bottom_btn);
        this.bxL.setOnClickListener(this);
        this.bxM = (TextView) this.mRootView.findViewById(a.f.noble_list_bottom_sub_text);
        this.bxN = (TbImageView) this.mRootView.findViewById(a.f.noble_list_bottom_text_mark);
        this.bxN.setDefaultBgResource(0);
        this.bxN.setDefaultResource(0);
    }

    public void b(d dVar) {
        if (dVar != null && dVar.bxA != null) {
            this.bwd = dVar;
            if (this.bwd.bxA.type_id == 1) {
                this.bxM.setVisibility(0);
                this.bxM.setText(this.bwd.bxA.text);
                this.bxN.setVisibility(8);
                this.bxL.setText(this.mTbPageContext.getResources().getString(a.h.yuyin_noble_bottom_open_noble));
            } else if (this.bwd.bxA.type_id == 2) {
                this.bxM.setVisibility(0);
                this.bxN.setVisibility(0);
                this.bxN.startLoad(this.bwd.bxA.icon_url, 10, false);
                this.bxL.setText(this.mTbPageContext.getResources().getString(a.h.yuyin_noble_bottom_immediate_renewal));
                Ru();
            } else if (this.bwd.bxA.type_id == 3) {
                this.bxM.setVisibility(0);
                this.bxN.setVisibility(0);
                this.bxN.startLoad(this.bwd.bxA.icon_url, 10, false);
                this.bxL.setText(this.mTbPageContext.getResources().getString(a.h.yuyin_noble_bottom_check_detail));
                Ru();
            } else if (this.bwd.bxA.type_id == 4) {
                this.bxM.setVisibility(0);
                this.bxN.setVisibility(0);
                this.bxN.startLoad(this.bwd.bxA.icon_url, 10, false);
                this.bxL.setText(this.mTbPageContext.getResources().getString(a.h.yuyin_noble_bottom_renewal_discount));
                this.bxM.setText(this.bwd.bxA.text);
            }
        }
    }

    private void Ru() {
        if (this.bxM != null && this.bwd != null && this.bwd.bxA != null) {
            String string = this.mTbPageContext.getResources().getString(a.h.noble_bottom_main_content_msg);
            Object[] objArr = new Object[1];
            objArr[0] = StringUtils.isNull(this.bwd.bxA.text) ? "" : this.bwd.bxA.text;
            String format = String.format(string, objArr);
            String string2 = this.mTbPageContext.getResources().getString(a.h.noble_bottom_main_content_day);
            Object[] objArr2 = new Object[1];
            objArr2[0] = StringUtils.isNull(this.bwd.bxA.bxv) ? "" : this.bwd.bxA.bxv;
            this.bxM.setText(format + String.format(string2, objArr2));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bxL) {
            Rv();
        }
    }

    private void Rv() {
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && ViewHelper.checkUpIsLogin(this.mTbPageContext.getPageActivity()) && this.bwd != null && this.bwd.bxA != null && !StringUtils.isNull(this.bwd.bxA.buy_url)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            if (this.bwd.bxB != null) {
                nobleDetailInfo.roleId = this.bwd.bxB.id;
            }
            nobleDetailInfo.url = this.bwd.bxA.buy_url;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501031, nobleDetailInfo));
        }
    }
}
