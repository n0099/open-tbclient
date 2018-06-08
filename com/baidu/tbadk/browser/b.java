package com.baidu.tbadk.browser;

import android.content.Context;
import android.webkit.JsPromptResult;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GameShareActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.GameShareData;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.xiuba.JSResultData;
import com.baidu.tieba.share.ImplicitShareMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b implements com.baidu.tieba.tbadkCore.e.b {
    private final Context mContext;

    public b(Context context) {
        this.mContext = context;
    }

    private String sx() {
        ba.aU(this.mContext);
        JSResultData jSResultData = new JSResultData();
        jSResultData.setStatus(1);
        jSResultData.setErrorCode("0");
        jSResultData.setErrorMsg("");
        return OrmObject.jsonStrWithObject(jSResultData);
    }

    private String sy() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921053));
        return "";
    }

    private String sz() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921052));
        return "";
    }

    private void cL(String str) {
    }

    @Override // com.baidu.tieba.tbadkCore.e.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if ("CommonJSBridge".equals(str)) {
            if ("startLoginModule".equals(str2)) {
                try {
                    new JSONObject(str3);
                    jsPromptResult.confirm(sx());
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if ("hideWebLoading".equals(str2)) {
                try {
                    String optString = new JSONObject(str3).optString("url");
                    if (!StringUtils.isNull(optString)) {
                        cL(optString);
                    }
                    jsPromptResult.confirm();
                    return true;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if ("personPageRefresh".equals(str2)) {
                try {
                    jsPromptResult.confirm(sz());
                    return true;
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if ("finishThisPage".equals(str2)) {
                try {
                    jsPromptResult.confirm(sy());
                    return true;
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            if ("registerShareData".equals(str2)) {
                try {
                    cM(str3);
                    jsPromptResult.confirm();
                    return true;
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            if ("gameShare".equals(str2)) {
                try {
                    cN(str3);
                    jsPromptResult.confirm();
                    return true;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return true;
                }
            } else if ("getZid".equals(str2)) {
                jsPromptResult.confirm(sA());
                return true;
            } else if ("registerShareDataNew".equals(str2)) {
                jsPromptResult.confirm(cO(str3));
                return true;
            } else if ("share".equals(str2)) {
                jsPromptResult.confirm(cP(str3));
                return true;
            }
        }
        return false;
    }

    private void cM(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921331, str));
    }

    private void cN(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            BdLog.e(e);
            jSONObject = null;
        }
        if (jSONObject != null) {
            GameShareData gameShareData = new GameShareData();
            gameShareData.parseJson(jSONObject);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GameShareActivityConfig(this.mContext, gameShareData)));
        }
    }

    private String sA() {
        String gz = FH.gz(TbadkCoreApplication.getInst());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", 1);
            jSONObject.put("zid", gz);
            return jSONObject.toString();
        } catch (JSONException e) {
            BdLog.e(e);
            return null;
        }
    }

    private String cO(String str) {
        int i = 0;
        if (!ao.isEmpty(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016566, str));
            i = 1;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("resultCode", i);
            return jSONObject.toString();
        } catch (JSONException e) {
            BdLog.e(e);
            return null;
        }
    }

    private String cP(String str) {
        int i;
        CustomResponsedMessage runTask;
        try {
            if (!ao.isEmpty(str) && (runTask = MessageManager.getInstance().runTask(2016568, com.baidu.tbadk.coreExtra.c.d.class, str)) != null) {
                com.baidu.tbadk.coreExtra.c.d dVar = (com.baidu.tbadk.coreExtra.c.d) runTask.getData();
                try {
                    int optInt = new JSONObject(str).optInt("channel");
                    if (optInt == 0) {
                        a(dVar);
                    } else {
                        MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.mContext, optInt, dVar, true));
                    }
                    i = 1;
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i);
                return jSONObject.toString();
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("resultCode", i);
            return jSONObject2.toString();
        } catch (JSONException e2) {
            BdLog.e(e2);
            return null;
        }
        i = 0;
    }

    protected void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, dVar, true);
            shareDialogConfig.setIsSupportNightMode(true);
            shareDialogConfig.setIsCopyLink(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }
}
