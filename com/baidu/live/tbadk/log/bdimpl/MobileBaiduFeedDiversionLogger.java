package com.baidu.live.tbadk.log.bdimpl;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.extraparams.interfaces.IExtraParams;
import com.baidu.live.tbadk.log.IFeedDiversionLogger;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MobileBaiduFeedDiversionLogger implements IFeedDiversionLogger {
    @Override // com.baidu.live.tbadk.log.IFeedDiversionLogger
    public void doDisplayGuideFloatLayerLog(String str, String str2) {
        AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
        alaStaticItem.addParams("from", "liveshow");
        alaStaticItem.addParams("type", "show");
        alaStaticItem.addParams("page", "liveroom");
        alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_VALUE_YINLIU_TIPS);
        alaStaticItem.addParams("source", str2);
        alaStaticItem.addParams("ext", getExtStr(str));
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }

    @Override // com.baidu.live.tbadk.log.IFeedDiversionLogger
    public void doClickGuideFloatLayerLog(String str, String str2) {
        AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
        alaStaticItem.addParams("from", "liveshow");
        alaStaticItem.addParams("type", "click");
        alaStaticItem.addParams("page", "liveroom");
        alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_VALUE_YINLIU_TIPS);
        alaStaticItem.addParams("source", str2);
        alaStaticItem.addParams("ext", getExtStr(str));
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }

    @Override // com.baidu.live.tbadk.log.IFeedDiversionLogger
    public void doDisplayGuideDialogLog(String str, String str2) {
        AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
        alaStaticItem.addParams("from", "liveshow");
        alaStaticItem.addParams("type", "show");
        alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_VALUE_OPENCLIENT);
        alaStaticItem.addParams("source", str2);
        alaStaticItem.addParams("ext", getExtStr(str));
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }

    @Override // com.baidu.live.tbadk.log.IFeedDiversionLogger
    public void doCloseGuideFloatDialogLog(String str, String str2) {
        AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
        alaStaticItem.addParams("from", "liveshow");
        alaStaticItem.addParams("type", "click");
        alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_VALUE_OPENCLIENT);
        alaStaticItem.addParams("value", "close");
        alaStaticItem.addParams("source", str2);
        alaStaticItem.addParams("ext", getExtStr(str));
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }

    @Override // com.baidu.live.tbadk.log.IFeedDiversionLogger
    public void doClickGuideFloatDialogLog(String str, String str2, String str3) {
        AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
        alaStaticItem.addParams("from", "liveshow");
        alaStaticItem.addParams("type", "click");
        alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_VALUE_OPENCLIENT);
        alaStaticItem.addParams("value", str2);
        alaStaticItem.addParams("source", str3);
        alaStaticItem.addParams("ext", getExtStr(str));
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }

    @Override // com.baidu.live.tbadk.log.IFeedDiversionLogger
    public void doDisplayFlowDialogLog(String str, String str2) {
        AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
        alaStaticItem.addParams("from", "liveshow");
        alaStaticItem.addParams("type", "show");
        alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_VALUE_MOB_NETWORK);
        alaStaticItem.addParams("source", str2);
        alaStaticItem.addParams("ext", getExtStr(str));
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }

    @Override // com.baidu.live.tbadk.log.IFeedDiversionLogger
    public void doStopFlowDialogLog(String str, String str2) {
        AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
        alaStaticItem.addParams("from", "liveshow");
        alaStaticItem.addParams("type", "click");
        alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_VALUE_MOB_NETWORK);
        alaStaticItem.addParams("value", "stop");
        alaStaticItem.addParams("source", str2);
        alaStaticItem.addParams("ext", getExtStr(str));
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }

    @Override // com.baidu.live.tbadk.log.IFeedDiversionLogger
    public void doContinueFlowDialogLog(String str, String str2) {
        AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
        alaStaticItem.addParams("from", "liveshow");
        alaStaticItem.addParams("type", "click");
        alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_VALUE_MOB_NETWORK);
        alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_VALUE_PLAY);
        alaStaticItem.addParams("source", str2);
        alaStaticItem.addParams("ext", getExtStr(str));
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }

    private String getExtStr(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_ROOMID, str);
            jSONObject.put("uid", TbadkCoreApplication.getCurrentAccountId() + "");
            IExtraParams buildParamsExtra = ExtraParamsManager.getInstance().buildParamsExtra();
            if (buildParamsExtra != null) {
                jSONObject.put("cuid", buildParamsExtra.getCuid());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
