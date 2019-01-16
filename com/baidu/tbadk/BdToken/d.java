package com.baidu.tbadk.BdToken;

import android.app.Activity;
import android.net.Uri;
import android.util.Base64;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.e;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class d {
    public static final Pattern akP = Pattern.compile("\\$[0-9A-Za-z@]{5,50}[#$]", 2);
    private l akQ;
    private e akR;
    private e.a akS;

    public static final d vD() {
        return a.akU;
    }

    /* loaded from: classes.dex */
    private static class a {
        private static final d akU = new d();
    }

    private d() {
        this.akS = new e.a() { // from class: com.baidu.tbadk.BdToken.d.1
            @Override // com.baidu.tbadk.BdToken.e.a
            public void a(boolean z, q qVar) {
                if (z && qVar != null) {
                    d.this.clearClipBoard();
                    d.this.ai(qVar.getTitle(), qVar.getUrl());
                    d.this.a(qVar);
                }
            }
        };
        registerTask();
        registerListener();
        this.akR = new e();
        this.akR.a(this.akS);
        this.akQ = new l();
    }

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(309626, DecryptCodeSocketRespMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, com.baidu.tieba.tbadkCore.a.a.aV(TbConfig.DECRYPT_CODE_URL, 309626));
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
                    int vO = decryptData.vO();
                    if (vO == 1 || vO == 0) {
                        if (MessageManager.getInstance().findTask(2921361) != null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921377, decryptData));
                        }
                    } else if (vO == 2) {
                        d.this.ai(decryptData.getTitle(), decryptData.getUrl());
                    } else if (vO != 4 && vO == 3 && !StringUtils.isNull(decryptData.getUrl())) {
                        Uri parse = Uri.parse(decryptData.getUrl());
                        if (parse == null || parse.getQueryParameter(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE) == null || parse.getQueryParameter("obj_type") == null || !parse.getQueryParameter("obj_type").equals("wise")) {
                            d.this.dC(decryptData.getUrl());
                        } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("need_deal_diversion_jump", 0) == 1) {
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("need_deal_diversion_jump", 0);
                            if (MessageManager.getInstance().findTask(2921361) != null) {
                                TiebaStatic.log(new am("c13390").aB("obj_type", parse.getQueryParameter("obj_type")).aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, parse.getQueryParameter(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE)));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921377, decryptData));
                            }
                        }
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
                    d.this.vF();
                    d.this.vE();
                }
            }
        });
    }

    public void check() {
        String vH = vH();
        String clipBoardContent = getClipBoardContent();
        if (!ao.isEmpty(vH) && !ao.isEmpty(clipBoardContent) && Pattern.compile(vH).matcher(clipBoardContent).find()) {
            dB(clipBoardContent);
        } else if (this.akQ != null && vG()) {
            this.akQ.check();
        }
    }

    public void vE() {
        Matcher matcher;
        String clipBoardContent = getClipBoardContent();
        if (clipBoardContent != null && (matcher = akP.matcher(clipBoardContent)) != null && matcher.find()) {
            DecryptCodeReqMsg decryptCodeReqMsg = new DecryptCodeReqMsg();
            decryptCodeReqMsg.setCode(clipBoardContent);
            MessageManager.getInstance().sendMessage(decryptCodeReqMsg);
        }
    }

    public void vF() {
        String clipBoardContent = getClipBoardContent();
        if (!ao.isEmpty(clipBoardContent) && clipBoardContent.contains("^sZqulxTVsT$")) {
            dB(clipBoardContent);
        }
    }

    private boolean vG() {
        String topActivityClassName = UtilHelper.getTopActivityClassName();
        return !ao.isEmpty(topActivityClassName) && topActivityClassName.equals("com.baidu.tieba.tblauncher.MainTabActivity") && TbSingleton.getInstance().isRecommendPage();
    }

    private void dB(String str) {
        this.akR.load(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClipBoard() {
        UtilHelper.clearClipBoard();
    }

    private String getClipBoardContent() {
        return UtilHelper.getClipBoardContent();
    }

    private String vH() {
        return new String(Base64.decode(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_baidu_password_re", "JTVDJTVFJTVCJTIzJTI0YS16QS1aMC05JTVEJTdCMTAlN0QlNUMlNUUlN0IwJTJDMSU3RCU1QiU1QyU1RSUyNCU1RCU3QjElN0Q="), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(String str, String str2) {
        TbPageContext<?> w;
        if (!ao.isEmpty(str2) && (w = w(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            ay.Es().a(w, str, new String[]{str2});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dC(String str) {
        Activity currentActivity;
        Uri parse;
        if (!ao.isEmpty(str) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (parse = Uri.parse(str)) != null) {
            if (str.startsWith(f.SCHEME)) {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                buildUpon.appendQueryParameter(f.ale, f.alh);
                parse = buildUpon.build();
            }
            UtilHelper.dealOneScheme(currentActivity, parse.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q qVar) {
        if (qVar != null && qVar.wb() != null && !ao.isEmpty(qVar.wb().btntext) && vG()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921380, qVar.wb().btntext));
        }
    }

    private TbPageContext w(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }
}
