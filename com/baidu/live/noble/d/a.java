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
    private com.baidu.live.noble.data.b bxA;
    private TextView byb;
    private TextView byc;
    private TbImageView byd;
    private View mRootView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_noble_list_bottom_layout, (ViewGroup) null);
        this.byb = (TextView) this.mRootView.findViewById(a.f.noble_list_bottom_btn);
        this.byb.setOnClickListener(this);
        this.byc = (TextView) this.mRootView.findViewById(a.f.noble_list_bottom_sub_text);
        this.byd = (TbImageView) this.mRootView.findViewById(a.f.noble_list_bottom_text_mark);
        this.byd.setDefaultBgResource(0);
        this.byd.setDefaultResource(0);
    }

    public void b(com.baidu.live.noble.data.b bVar) {
        if (bVar != null && bVar.bxI != null) {
            this.bxA = bVar;
            if (this.bxA.bxI.type_id == 1) {
                this.byc.setVisibility(0);
                this.byc.setText(this.bxA.bxI.text);
                this.byd.setVisibility(0);
                this.byd.startLoad(this.bxA.bxI.icon_url, 10, false);
                this.byb.setText(this.mTbPageContext.getResources().getString(a.h.noble_bottom_open_noble));
            } else if (this.bxA.bxI.type_id == 2) {
                this.byc.setVisibility(0);
                this.byd.setVisibility(0);
                this.byd.startLoad(this.bxA.bxI.icon_url, 10, false);
                this.byb.setText(this.mTbPageContext.getResources().getString(a.h.noble_bottom_immediate_renewal));
                Pb();
            } else if (this.bxA.bxI.type_id == 3) {
                this.byc.setVisibility(0);
                this.byd.setVisibility(0);
                this.byd.startLoad(this.bxA.bxI.icon_url, 10, false);
                this.byb.setText(this.mTbPageContext.getResources().getString(a.h.noble_bottom_check_detail));
                Pb();
            } else if (this.bxA.bxI.type_id == 4) {
                this.byc.setVisibility(0);
                this.byd.setVisibility(0);
                this.byd.startLoad(this.bxA.bxI.icon_url, 10, false);
                this.byb.setText(this.mTbPageContext.getResources().getString(a.h.noble_bottom_renewal_discount));
                this.byc.setText(this.bxA.bxI.text);
            }
        }
    }

    private void Pb() {
        if (this.byc != null && this.bxA != null && this.bxA.bxI != null) {
            String string = this.mTbPageContext.getResources().getString(a.h.noble_bottom_main_content_msg);
            Object[] objArr = new Object[1];
            objArr[0] = StringUtils.isNull(this.bxA.bxI.text) ? "" : this.bxA.bxI.text;
            String format = String.format(string, objArr);
            String string2 = this.mTbPageContext.getResources().getString(a.h.noble_bottom_main_content_day);
            Object[] objArr2 = new Object[1];
            objArr2[0] = StringUtils.isNull(this.bxA.bxI.bxL) ? "" : this.bxA.bxI.bxL;
            this.byc.setText(format + String.format(string2, objArr2));
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.byb) {
            Pc();
        }
    }

    private void Pc() {
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            if (ViewHelper.checkUpIsLogin(this.mTbPageContext.getPageActivity()) && this.bxA != null && this.bxA.bxI != null && !StringUtils.isNull(this.bxA.bxI.buy_url)) {
                NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
                if (this.bxA.bxJ != null) {
                    nobleDetailInfo.roleId = this.bxA.bxJ.id;
                }
                nobleDetailInfo.url = this.bxA.bxI.buy_url;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
            }
            if (this.bxA != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("role_id", this.bxA.bxJ.id);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "noblepay_show").setContentExt(null, null, jSONObject));
            }
        }
    }
}
