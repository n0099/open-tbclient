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
    private TextView bwB;
    private TextView bwC;
    private TbImageView bwD;
    private com.baidu.live.noble.data.b bwa;
    private View mRootView;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_noble_list_bottom_layout, (ViewGroup) null);
        this.bwB = (TextView) this.mRootView.findViewById(a.f.noble_list_bottom_btn);
        this.bwB.setOnClickListener(this);
        this.bwC = (TextView) this.mRootView.findViewById(a.f.noble_list_bottom_sub_text);
        this.bwD = (TbImageView) this.mRootView.findViewById(a.f.noble_list_bottom_text_mark);
        this.bwD.setDefaultBgResource(0);
        this.bwD.setDefaultResource(0);
    }

    public void b(com.baidu.live.noble.data.b bVar) {
        if (bVar != null && bVar.bwi != null) {
            this.bwa = bVar;
            if (this.bwa.bwi.type_id == 1) {
                this.bwC.setVisibility(0);
                this.bwC.setText(this.bwa.bwi.text);
                this.bwD.setVisibility(0);
                this.bwD.startLoad(this.bwa.bwi.icon_url, 10, false);
                this.bwB.setText(this.mTbPageContext.getResources().getString(a.h.noble_bottom_open_noble));
            } else if (this.bwa.bwi.type_id == 2) {
                this.bwC.setVisibility(0);
                this.bwD.setVisibility(0);
                this.bwD.startLoad(this.bwa.bwi.icon_url, 10, false);
                this.bwB.setText(this.mTbPageContext.getResources().getString(a.h.noble_bottom_immediate_renewal));
                OY();
            } else if (this.bwa.bwi.type_id == 3) {
                this.bwC.setVisibility(0);
                this.bwD.setVisibility(0);
                this.bwD.startLoad(this.bwa.bwi.icon_url, 10, false);
                this.bwB.setText(this.mTbPageContext.getResources().getString(a.h.noble_bottom_check_detail));
                OY();
            } else if (this.bwa.bwi.type_id == 4) {
                this.bwC.setVisibility(0);
                this.bwD.setVisibility(0);
                this.bwD.startLoad(this.bwa.bwi.icon_url, 10, false);
                this.bwB.setText(this.mTbPageContext.getResources().getString(a.h.noble_bottom_renewal_discount));
                this.bwC.setText(this.bwa.bwi.text);
            }
        }
    }

    private void OY() {
        if (this.bwC != null && this.bwa != null && this.bwa.bwi != null) {
            String string = this.mTbPageContext.getResources().getString(a.h.noble_bottom_main_content_msg);
            Object[] objArr = new Object[1];
            objArr[0] = StringUtils.isNull(this.bwa.bwi.text) ? "" : this.bwa.bwi.text;
            String format = String.format(string, objArr);
            String string2 = this.mTbPageContext.getResources().getString(a.h.noble_bottom_main_content_day);
            Object[] objArr2 = new Object[1];
            objArr2[0] = StringUtils.isNull(this.bwa.bwi.bwl) ? "" : this.bwa.bwi.bwl;
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
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            if (ViewHelper.checkUpIsLogin(this.mTbPageContext.getPageActivity()) && this.bwa != null && this.bwa.bwi != null && !StringUtils.isNull(this.bwa.bwi.buy_url)) {
                NobleDetailInfo nobleDetailInfo = new NobleDetailInfo();
                if (this.bwa.bwj != null) {
                    nobleDetailInfo.roleId = this.bwa.bwj.id;
                }
                nobleDetailInfo.url = this.bwa.bwi.buy_url;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913199, nobleDetailInfo));
            }
            if (this.bwa != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("role_id", this.bwa.bwj.id);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "noblepay_show").setContentExt(null, null, jSONObject));
            }
        }
    }
}
