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
    private TextView baI;
    private TextView baJ;
    private TbImageView baK;
    private com.baidu.live.noble.data.b baf;
    private View mRootView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_noble_list_bottom_layout, (ViewGroup) null);
        this.baI = (TextView) this.mRootView.findViewById(a.g.noble_list_bottom_btn);
        this.baI.setOnClickListener(this);
        this.baJ = (TextView) this.mRootView.findViewById(a.g.noble_list_bottom_sub_text);
        this.baK = (TbImageView) this.mRootView.findViewById(a.g.noble_list_bottom_text_mark);
        this.baK.setDefaultBgResource(0);
        this.baK.setDefaultResource(0);
    }

    public void b(com.baidu.live.noble.data.b bVar) {
        if (bVar != null && bVar.bas != null) {
            this.baf = bVar;
            if (this.baf.bas.type_id == 1) {
                this.baJ.setVisibility(0);
                this.baJ.setText(this.baf.bas.text);
                this.baK.setVisibility(0);
                this.baK.startLoad(this.baf.bas.icon_url, 10, false);
                this.baI.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_open_noble));
            } else if (this.baf.bas.type_id == 2) {
                this.baJ.setVisibility(0);
                this.baK.setVisibility(0);
                this.baK.startLoad(this.baf.bas.icon_url, 10, false);
                this.baI.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_immediate_renewal));
                Gn();
            } else if (this.baf.bas.type_id == 3) {
                this.baJ.setVisibility(0);
                this.baK.setVisibility(0);
                this.baK.startLoad(this.baf.bas.icon_url, 10, false);
                this.baI.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_check_detail));
                Gn();
            } else if (this.baf.bas.type_id == 4) {
                this.baJ.setVisibility(0);
                this.baK.setVisibility(0);
                this.baK.startLoad(this.baf.bas.icon_url, 10, false);
                this.baI.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_renewal_discount));
                this.baJ.setText(this.baf.bas.text);
            }
        }
    }

    private void Gn() {
        if (this.baJ != null && this.baf != null && this.baf.bas != null) {
            String string = this.mTbPageContext.getResources().getString(a.i.noble_bottom_main_content_msg);
            Object[] objArr = new Object[1];
            objArr[0] = StringUtils.isNull(this.baf.bas.text) ? "" : this.baf.bas.text;
            String format = String.format(string, objArr);
            String string2 = this.mTbPageContext.getResources().getString(a.i.noble_bottom_main_content_day);
            Object[] objArr2 = new Object[1];
            objArr2[0] = StringUtils.isNull(this.baf.bas.bav) ? "" : this.baf.bas.bav;
            this.baJ.setText(format + String.format(string2, objArr2));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.baI) {
            Go();
        }
    }

    private void Go() {
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && ViewHelper.checkUpIsLogin(this.mTbPageContext.getPageActivity()) && this.baf != null && this.baf.bas != null && !StringUtils.isNull(this.baf.bas.buy_url)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            if (this.baf.bat != null) {
                nobleDetailInfo.roleId = this.baf.bat.id;
            }
            nobleDetailInfo.url = this.baf.bas.buy_url;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
        }
    }
}
