package com.baidu.tbadk.BdToken;

import android.app.Activity;
import android.net.Uri;
import android.util.Base64;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BdToken.e;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class d {
    private l akG;
    private e akH;
    private e.a akI;

    public static final d vz() {
        return a.akK;
    }

    /* loaded from: classes.dex */
    private static class a {
        private static final d akK = new d();
    }

    private d() {
        this.akI = new e.a() { // from class: com.baidu.tbadk.BdToken.d.1
            @Override // com.baidu.tbadk.BdToken.e.a
            public void a(boolean z, p pVar) {
                if (z && pVar != null) {
                    d.this.clearClipBoard();
                    d.this.ah(pVar.getTitle(), pVar.getUrl());
                    d.this.a(pVar);
                }
            }
        };
        registerTask();
        registerListener();
        this.akH = new e();
        this.akH.a(this.akI);
        this.akG = new l();
    }

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(309626, DecryptCodeSocketRespMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, com.baidu.tieba.tbadkCore.a.a.aU(TbConfig.DECRYPT_CODE_URL, 309626));
        tbHttpMessageTask.setResponsedClass(DecryptCodeHttpRespMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, 309626) { // from class: com.baidu.tbadk.BdToken.d.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage responsedMessage) {
                g decryptData;
                if (responsedMessage instanceof DecryptCodeHttpRespMsg) {
                    decryptData = ((DecryptCodeHttpRespMsg) responsedMessage).getDecryptData();
                } else if (responsedMessage instanceof DecryptCodeSocketRespMsg) {
                    decryptData = ((DecryptCodeSocketRespMsg) responsedMessage).getDecryptData();
                } else {
                    return;
                }
                if (decryptData != null) {
                    UtilHelper.clearClipBoard();
                    int vK = decryptData.vK();
                    if (vK == 1) {
                        if (MessageManager.getInstance().findTask(2921361) != null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921377, decryptData));
                        }
                    } else if (vK == 2) {
                        d.this.ah(decryptData.getTitle(), decryptData.getUrl());
                    } else if (vK != 4 && vK == 3) {
                        d.this.dB(decryptData.getUrl());
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001011) { // from class: com.baidu.tbadk.BdToken.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    d.this.check();
                    d.this.vB();
                    d.this.vA();
                }
            }
        });
    }

    public void check() {
        String vD = vD();
        String clipBoardContent = getClipBoardContent();
        if (!ao.isEmpty(vD) && !ao.isEmpty(clipBoardContent) && Pattern.compile(vD).matcher(clipBoardContent).find()) {
            dA(clipBoardContent);
        } else if (this.akG != null && vC()) {
            this.akG.check();
        }
    }

    public void vA() {
        String clipBoardContent = getClipBoardContent();
        if (Pattern.compile("^\\$[0-9A-Za-z]{5,}\\$$").matcher(clipBoardContent).matches()) {
            DecryptCodeReqMsg decryptCodeReqMsg = new DecryptCodeReqMsg();
            decryptCodeReqMsg.setCode(clipBoardContent);
            MessageManager.getInstance().sendMessage(decryptCodeReqMsg);
        }
    }

    public void vB() {
        String clipBoardContent = getClipBoardContent();
        if (!ao.isEmpty(clipBoardContent) && clipBoardContent.contains("^sZqulxTVsT$")) {
            dA(clipBoardContent);
        }
    }

    private boolean vC() {
        String topActivityClassName = UtilHelper.getTopActivityClassName();
        return !ao.isEmpty(topActivityClassName) && topActivityClassName.equals("com.baidu.tieba.tblauncher.MainTabActivity") && TbSingleton.getInstance().isRecommendPage();
    }

    private void dA(String str) {
        this.akH.load(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClipBoard() {
        UtilHelper.clearClipBoard();
    }

    private String getClipBoardContent() {
        return UtilHelper.getClipBoardContent();
    }

    private String vD() {
        return new String(Base64.decode(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_baidu_password_re", "JTVDJTVFJTVCJTIzJTI0YS16QS1aMC05JTVEJTdCMTAlN0QlNUMlNUUlN0IwJTJDMSU3RCU1QiU1QyU1RSUyNCU1RCU3QjElN0Q="), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(String str, String str2) {
        TbPageContext<?> currentActivityPageContext;
        if (!ao.isEmpty(str2) && (currentActivityPageContext = TbadkCoreApplication.getInst().getCurrentActivityPageContext()) != null) {
            ay.Ef().a(currentActivityPageContext, str, new String[]{str2});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dB(String str) {
        Activity currentActivity;
        if (!ao.isEmpty(str) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null) {
            Uri parse = Uri.parse(str);
            if (parse != null && str.startsWith(f.SCHEME)) {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                buildUpon.appendQueryParameter(f.akU, f.akX);
                parse = buildUpon.build();
            }
            UtilHelper.dealOneScheme(currentActivity, parse.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(p pVar) {
        if (pVar != null && pVar.vU() != null && !ao.isEmpty(pVar.vU().btntext) && vC()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921380, pVar.vU().btntext));
        }
    }
}
