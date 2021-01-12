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
/* loaded from: classes10.dex */
public class a implements View.OnClickListener {
    private TextView bsX;
    private TextView bsY;
    private TbImageView bsZ;
    private com.baidu.live.noble.data.b bsw;
    private View mRootView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_noble_list_bottom_layout, (ViewGroup) null);
        this.bsX = (TextView) this.mRootView.findViewById(a.f.noble_list_bottom_btn);
        this.bsX.setOnClickListener(this);
        this.bsY = (TextView) this.mRootView.findViewById(a.f.noble_list_bottom_sub_text);
        this.bsZ = (TbImageView) this.mRootView.findViewById(a.f.noble_list_bottom_text_mark);
        this.bsZ.setDefaultBgResource(0);
        this.bsZ.setDefaultResource(0);
    }

    public void b(com.baidu.live.noble.data.b bVar) {
        if (bVar != null && bVar.bsE != null) {
            this.bsw = bVar;
            if (this.bsw.bsE.type_id == 1) {
                this.bsY.setVisibility(0);
                this.bsY.setText(this.bsw.bsE.text);
                this.bsZ.setVisibility(0);
                this.bsZ.startLoad(this.bsw.bsE.icon_url, 10, false);
                this.bsX.setText(this.mTbPageContext.getResources().getString(a.h.noble_bottom_open_noble));
            } else if (this.bsw.bsE.type_id == 2) {
                this.bsY.setVisibility(0);
                this.bsZ.setVisibility(0);
                this.bsZ.startLoad(this.bsw.bsE.icon_url, 10, false);
                this.bsX.setText(this.mTbPageContext.getResources().getString(a.h.noble_bottom_immediate_renewal));
                Nz();
            } else if (this.bsw.bsE.type_id == 3) {
                this.bsY.setVisibility(0);
                this.bsZ.setVisibility(0);
                this.bsZ.startLoad(this.bsw.bsE.icon_url, 10, false);
                this.bsX.setText(this.mTbPageContext.getResources().getString(a.h.noble_bottom_check_detail));
                Nz();
            } else if (this.bsw.bsE.type_id == 4) {
                this.bsY.setVisibility(0);
                this.bsZ.setVisibility(0);
                this.bsZ.startLoad(this.bsw.bsE.icon_url, 10, false);
                this.bsX.setText(this.mTbPageContext.getResources().getString(a.h.noble_bottom_renewal_discount));
                this.bsY.setText(this.bsw.bsE.text);
            }
        }
    }

    private void Nz() {
        if (this.bsY != null && this.bsw != null && this.bsw.bsE != null) {
            String string = this.mTbPageContext.getResources().getString(a.h.noble_bottom_main_content_msg);
            Object[] objArr = new Object[1];
            objArr[0] = StringUtils.isNull(this.bsw.bsE.text) ? "" : this.bsw.bsE.text;
            String format = String.format(string, objArr);
            String string2 = this.mTbPageContext.getResources().getString(a.h.noble_bottom_main_content_day);
            Object[] objArr2 = new Object[1];
            objArr2[0] = StringUtils.isNull(this.bsw.bsE.bsH) ? "" : this.bsw.bsE.bsH;
            this.bsY.setText(format + String.format(string2, objArr2));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bsX) {
            NA();
        }
    }

    private void NA() {
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            if (ViewHelper.checkUpIsLogin(this.mTbPageContext.getPageActivity()) && this.bsw != null && this.bsw.bsE != null && !StringUtils.isNull(this.bsw.bsE.buy_url)) {
                NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
                if (this.bsw.bsF != null) {
                    nobleDetailInfo.roleId = this.bsw.bsF.id;
                }
                nobleDetailInfo.url = this.bsw.bsE.buy_url;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
            }
            if (this.bsw != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("role_id", this.bsw.bsF.id);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "noblepay_show").setContentExt(null, null, jSONObject));
            }
        }
    }
}
