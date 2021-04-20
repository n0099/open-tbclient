package com.baidu.mobads.container.info;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.adrequest.XAdContainerContext;
import com.baidu.mobads.container.util.APKStateManager;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class XDeviceInfo4H5Banner extends XDeviceInfo {
    public XDeviceInfo4H5Banner(XAdContainerContext xAdContainerContext) {
        super(xAdContainerContext);
    }

    @Override // com.baidu.mobads.container.info.XDeviceInfo
    public JSONObject getConfs() {
        JSONObject confs = super.getConfs();
        if (confs != null) {
            try {
                confs.putOpt("WRAPPER", "android");
                confs.putOpt("PRELOAD", Boolean.FALSE);
                JSONObject jSONObject = confs.getJSONObject("FET");
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                jSONObject.put("MSSP", true);
                confs.put("iadex", APKStateManager.getInstance().getIADEXValue(this.mAdContainerCxt.getAppContext()));
                confs.put("FET", jSONObject);
                confs.put(IAdRequestParam.MSA, 1);
                handleAbility(confs);
            } catch (Exception e2) {
                this.logger.d(e2);
            }
        }
        return confs;
    }
}
