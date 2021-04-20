package com.baidu.mobads.container.info;

import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.adrequest.XAdContainerContext;
import com.baidu.mobads.container.util.APKStateManager;
import com.baidu.mobads.container.util.ScreenUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class XDeviceInfo4H5Interstitial extends XDeviceInfo {
    public XDeviceInfo4H5Interstitial(XAdContainerContext xAdContainerContext) {
        super(xAdContainerContext);
    }

    @Override // com.baidu.mobads.container.info.XDeviceInfo
    public JSONObject getConfs() {
        JSONObject confs = super.getConfs();
        if (confs != null) {
            try {
                confs.putOpt("WRAPPER", "androidinter");
                confs.putOpt("PRELOAD", Boolean.TRUE);
                confs.putOpt("LW", Integer.valueOf(ScreenUtils.getLogicalPixel(this.mAdContainerCxt.getAppContext(), this.mAdContainerCxt.getAdWidth())));
                confs.putOpt("LH", Integer.valueOf(ScreenUtils.getLogicalPixel(this.mAdContainerCxt.getAppContext(), this.mAdContainerCxt.getAdHeight())));
                JSONObject jSONObject = confs.getJSONObject("FET");
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                jSONObject.putOpt("MSSP", Boolean.TRUE);
                jSONObject.putOpt(AdParamInfo.AdClickActionString.AD_CLICK_ACTION_VIDEO, Boolean.TRUE);
                jSONObject.putOpt("NMON", Boolean.TRUE);
                confs.put("FET", jSONObject);
                confs.put("iadex", APKStateManager.getInstance().getIADEXValue(this.mAdContainerCxt.getAppContext()));
                confs.put(IAdRequestParam.MSA, String.valueOf(1));
                handleAbility(confs);
            } catch (Exception e2) {
                this.logger.d(e2);
            }
        }
        return confs;
    }
}
