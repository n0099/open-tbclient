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
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    private TextView baJ;
    private TextView baK;
    private TbImageView baL;
    private com.baidu.live.noble.data.b bah;
    private View mRootView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_noble_list_bottom_layout, (ViewGroup) null);
        this.baJ = (TextView) this.mRootView.findViewById(a.g.noble_list_bottom_btn);
        this.baJ.setOnClickListener(this);
        this.baK = (TextView) this.mRootView.findViewById(a.g.noble_list_bottom_sub_text);
        this.baL = (TbImageView) this.mRootView.findViewById(a.g.noble_list_bottom_text_mark);
        this.baL.setDefaultBgResource(0);
        this.baL.setDefaultResource(0);
    }

    public void b(com.baidu.live.noble.data.b bVar) {
        if (bVar != null && bVar.bat != null) {
            this.bah = bVar;
            if (this.bah.bat.type_id == 1) {
                this.baK.setVisibility(0);
                this.baK.setText(this.bah.bat.text);
                this.baL.setVisibility(0);
                this.baL.startLoad(this.bah.bat.icon_url, 10, false);
                this.baJ.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_open_noble));
            } else if (this.bah.bat.type_id == 2) {
                this.baK.setVisibility(0);
                this.baL.setVisibility(0);
                this.baL.startLoad(this.bah.bat.icon_url, 10, false);
                this.baJ.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_immediate_renewal));
                Gt();
            } else if (this.bah.bat.type_id == 3) {
                this.baK.setVisibility(0);
                this.baL.setVisibility(0);
                this.baL.startLoad(this.bah.bat.icon_url, 10, false);
                this.baJ.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_check_detail));
                Gt();
            } else if (this.bah.bat.type_id == 4) {
                this.baK.setVisibility(0);
                this.baL.setVisibility(0);
                this.baL.startLoad(this.bah.bat.icon_url, 10, false);
                this.baJ.setText(this.mTbPageContext.getResources().getString(a.i.noble_bottom_renewal_discount));
                this.baK.setText(this.bah.bat.text);
            }
        }
    }

    private void Gt() {
        if (this.baK != null && this.bah != null && this.bah.bat != null) {
            String string = this.mTbPageContext.getResources().getString(a.i.noble_bottom_main_content_msg);
            Object[] objArr = new Object[1];
            objArr[0] = StringUtils.isNull(this.bah.bat.text) ? "" : this.bah.bat.text;
            String format = String.format(string, objArr);
            String string2 = this.mTbPageContext.getResources().getString(a.i.noble_bottom_main_content_day);
            Object[] objArr2 = new Object[1];
            objArr2[0] = StringUtils.isNull(this.bah.bat.baw) ? "" : this.bah.bat.baw;
            this.baK.setText(format + String.format(string2, objArr2));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.baJ) {
            Gu();
        }
    }

    private void Gu() {
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && ViewHelper.checkUpIsLogin(this.mTbPageContext.getPageActivity()) && this.bah != null && this.bah.bat != null && !StringUtils.isNull(this.bah.bat.buy_url)) {
            NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
            if (this.bah.bau != null) {
                nobleDetailInfo.roleId = this.bah.bau.id;
            }
            nobleDetailInfo.url = this.bah.bat.buy_url;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
        }
    }
}
