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
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.TbImageView;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {
    private TextView bsY;
    private TextView bsZ;
    private com.baidu.live.noble.data.b bsz;
    private TbImageView bta;
    private View mRootView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_noble_list_bottom_layout, (ViewGroup) null);
        this.bsY = (TextView) this.mRootView.findViewById(a.f.noble_list_bottom_btn);
        this.bsY.setOnClickListener(this);
        this.bsZ = (TextView) this.mRootView.findViewById(a.f.noble_list_bottom_sub_text);
        this.bta = (TbImageView) this.mRootView.findViewById(a.f.noble_list_bottom_text_mark);
        this.bta.setDefaultBgResource(0);
        this.bta.setDefaultResource(0);
    }

    public void b(com.baidu.live.noble.data.b bVar) {
        if (bVar != null && bVar.bsH != null) {
            this.bsz = bVar;
            if (this.bsz.bsH.type_id == 1) {
                this.bsZ.setVisibility(0);
                this.bsZ.setText(this.bsz.bsH.text);
                this.bta.setVisibility(0);
                this.bta.startLoad(this.bsz.bsH.icon_url, 10, false);
                this.bsY.setText(this.mTbPageContext.getResources().getString(a.h.noble_bottom_open_noble));
            } else if (this.bsz.bsH.type_id == 2) {
                this.bsZ.setVisibility(0);
                this.bta.setVisibility(0);
                this.bta.startLoad(this.bsz.bsH.icon_url, 10, false);
                this.bsY.setText(this.mTbPageContext.getResources().getString(a.h.noble_bottom_immediate_renewal));
                Qq();
            } else if (this.bsz.bsH.type_id == 3) {
                this.bsZ.setVisibility(0);
                this.bta.setVisibility(0);
                this.bta.startLoad(this.bsz.bsH.icon_url, 10, false);
                this.bsY.setText(this.mTbPageContext.getResources().getString(a.h.noble_bottom_check_detail));
                Qq();
            } else if (this.bsz.bsH.type_id == 4) {
                this.bsZ.setVisibility(0);
                this.bta.setVisibility(0);
                this.bta.startLoad(this.bsz.bsH.icon_url, 10, false);
                this.bsY.setText(this.mTbPageContext.getResources().getString(a.h.noble_bottom_renewal_discount));
                this.bsZ.setText(this.bsz.bsH.text);
            }
        }
    }

    private void Qq() {
        if (this.bsZ != null && this.bsz != null && this.bsz.bsH != null) {
            String string = this.mTbPageContext.getResources().getString(a.h.noble_bottom_main_content_msg);
            Object[] objArr = new Object[1];
            objArr[0] = StringUtils.isNull(this.bsz.bsH.text) ? "" : this.bsz.bsH.text;
            String format = String.format(string, objArr);
            String string2 = this.mTbPageContext.getResources().getString(a.h.noble_bottom_main_content_day);
            Object[] objArr2 = new Object[1];
            objArr2[0] = StringUtils.isNull(this.bsz.bsH.bsK) ? "" : this.bsz.bsH.bsK;
            this.bsZ.setText(format + String.format(string2, objArr2));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bsY) {
            Qr();
        }
    }

    private void Qr() {
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            if (ViewHelper.checkUpIsLogin(this.mTbPageContext.getPageActivity()) && this.bsz != null && this.bsz.bsH != null && !StringUtils.isNull(this.bsz.bsH.buy_url)) {
                NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
                if (this.bsz.bsI != null) {
                    nobleDetailInfo.roleId = this.bsz.bsI.id;
                }
                nobleDetailInfo.url = this.bsz.bsH.buy_url;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
            }
            if (this.bsz != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("role_id", this.bsz.bsI.id);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "noblepay_show").setContentExt(null, null, jSONObject));
            }
        }
    }
}
