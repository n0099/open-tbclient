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
/* loaded from: classes11.dex */
public class a implements View.OnClickListener {
    private TextView bxL;
    private TextView bxM;
    private TbImageView bxN;
    private com.baidu.live.noble.data.b bxk;
    private View mRootView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_noble_list_bottom_layout, (ViewGroup) null);
        this.bxL = (TextView) this.mRootView.findViewById(a.f.noble_list_bottom_btn);
        this.bxL.setOnClickListener(this);
        this.bxM = (TextView) this.mRootView.findViewById(a.f.noble_list_bottom_sub_text);
        this.bxN = (TbImageView) this.mRootView.findViewById(a.f.noble_list_bottom_text_mark);
        this.bxN.setDefaultBgResource(0);
        this.bxN.setDefaultResource(0);
    }

    public void b(com.baidu.live.noble.data.b bVar) {
        if (bVar != null && bVar.bxs != null) {
            this.bxk = bVar;
            if (this.bxk.bxs.type_id == 1) {
                this.bxM.setVisibility(0);
                this.bxM.setText(this.bxk.bxs.text);
                this.bxN.setVisibility(0);
                this.bxN.startLoad(this.bxk.bxs.icon_url, 10, false);
                this.bxL.setText(this.mTbPageContext.getResources().getString(a.h.noble_bottom_open_noble));
            } else if (this.bxk.bxs.type_id == 2) {
                this.bxM.setVisibility(0);
                this.bxN.setVisibility(0);
                this.bxN.startLoad(this.bxk.bxs.icon_url, 10, false);
                this.bxL.setText(this.mTbPageContext.getResources().getString(a.h.noble_bottom_immediate_renewal));
                Ru();
            } else if (this.bxk.bxs.type_id == 3) {
                this.bxM.setVisibility(0);
                this.bxN.setVisibility(0);
                this.bxN.startLoad(this.bxk.bxs.icon_url, 10, false);
                this.bxL.setText(this.mTbPageContext.getResources().getString(a.h.noble_bottom_check_detail));
                Ru();
            } else if (this.bxk.bxs.type_id == 4) {
                this.bxM.setVisibility(0);
                this.bxN.setVisibility(0);
                this.bxN.startLoad(this.bxk.bxs.icon_url, 10, false);
                this.bxL.setText(this.mTbPageContext.getResources().getString(a.h.noble_bottom_renewal_discount));
                this.bxM.setText(this.bxk.bxs.text);
            }
        }
    }

    private void Ru() {
        if (this.bxM != null && this.bxk != null && this.bxk.bxs != null) {
            String string = this.mTbPageContext.getResources().getString(a.h.noble_bottom_main_content_msg);
            Object[] objArr = new Object[1];
            objArr[0] = StringUtils.isNull(this.bxk.bxs.text) ? "" : this.bxk.bxs.text;
            String format = String.format(string, objArr);
            String string2 = this.mTbPageContext.getResources().getString(a.h.noble_bottom_main_content_day);
            Object[] objArr2 = new Object[1];
            objArr2[0] = StringUtils.isNull(this.bxk.bxs.bxv) ? "" : this.bxk.bxs.bxv;
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
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            if (ViewHelper.checkUpIsLogin(this.mTbPageContext.getPageActivity()) && this.bxk != null && this.bxk.bxs != null && !StringUtils.isNull(this.bxk.bxs.buy_url)) {
                NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
                if (this.bxk.bxt != null) {
                    nobleDetailInfo.roleId = this.bxk.bxt.id;
                }
                nobleDetailInfo.url = this.bxk.bxs.buy_url;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
            }
            if (this.bxk != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("role_id", this.bxk.bxt.id);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "noblepay_show").setContentExt(null, null, jSONObject));
            }
        }
    }
}
