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
    private d buS;
    private TextView bwB;
    private TextView bwC;
    private TbImageView bwD;
    private View mRootView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_ala_noble_list_bottom_layout, (ViewGroup) null);
        this.bwB = (TextView) this.mRootView.findViewById(a.f.noble_list_bottom_btn);
        this.bwB.setOnClickListener(this);
        this.bwC = (TextView) this.mRootView.findViewById(a.f.noble_list_bottom_sub_text);
        this.bwD = (TbImageView) this.mRootView.findViewById(a.f.noble_list_bottom_text_mark);
        this.bwD.setDefaultBgResource(0);
        this.bwD.setDefaultResource(0);
    }

    public void b(d dVar) {
        if (dVar != null && dVar.bwq != null) {
            this.buS = dVar;
            if (this.buS.bwq.type_id == 1) {
                this.bwC.setVisibility(0);
                this.bwC.setText(this.buS.bwq.text);
                this.bwD.setVisibility(8);
                this.bwB.setText(this.mTbPageContext.getResources().getString(a.h.yuyin_noble_bottom_open_noble));
            } else if (this.buS.bwq.type_id == 2) {
                this.bwC.setVisibility(0);
                this.bwD.setVisibility(0);
                this.bwD.startLoad(this.buS.bwq.icon_url, 10, false);
                this.bwB.setText(this.mTbPageContext.getResources().getString(a.h.yuyin_noble_bottom_immediate_renewal));
                OY();
            } else if (this.buS.bwq.type_id == 3) {
                this.bwC.setVisibility(0);
                this.bwD.setVisibility(0);
                this.bwD.startLoad(this.buS.bwq.icon_url, 10, false);
                this.bwB.setText(this.mTbPageContext.getResources().getString(a.h.yuyin_noble_bottom_check_detail));
                OY();
            } else if (this.buS.bwq.type_id == 4) {
                this.bwC.setVisibility(0);
                this.bwD.setVisibility(0);
                this.bwD.startLoad(this.buS.bwq.icon_url, 10, false);
                this.bwB.setText(this.mTbPageContext.getResources().getString(a.h.yuyin_noble_bottom_renewal_discount));
                this.bwC.setText(this.buS.bwq.text);
            }
        }
    }

    private void OY() {
        if (this.bwC != null && this.buS != null && this.buS.bwq != null) {
            String string = this.mTbPageContext.getResources().getString(a.h.noble_bottom_main_content_msg);
            Object[] objArr = new Object[1];
            objArr[0] = StringUtils.isNull(this.buS.bwq.text) ? "" : this.buS.bwq.text;
            String format = String.format(string, objArr);
            String string2 = this.mTbPageContext.getResources().getString(a.h.noble_bottom_main_content_day);
            Object[] objArr2 = new Object[1];
            objArr2[0] = StringUtils.isNull(this.buS.bwq.bwl) ? "" : this.buS.bwq.bwl;
            this.bwC.setText(format + String.format(string2, objArr2));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bwB) {
            OZ();
        }
    }

    private void OZ() {
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && ViewHelper.checkUpIsLogin(this.mTbPageContext.getPageActivity()) && this.buS != null && this.buS.bwq != null && !StringUtils.isNull(this.buS.bwq.buy_url)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            if (this.buS.bwr != null) {
                nobleDetailInfo.roleId = this.buS.bwr.id;
            }
            nobleDetailInfo.url = this.buS.bwq.buy_url;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501031, nobleDetailInfo));
        }
    }
}
