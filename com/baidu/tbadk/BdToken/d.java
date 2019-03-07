package com.baidu.tbadk.BdToken;

import android.app.Activity;
import android.net.Uri;
import android.util.Base64;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class d {
    public static final Pattern bru = Pattern.compile("\\$[0-9A-Za-z@]{5,50}[#$]", 2);
    private l brv;
    private e brw;
    private e.a brx;

    public static final d Ue() {
        return a.brz;
    }

    /* loaded from: classes.dex */
    private static class a {
        private static final d brz = new d();
    }

    private d() {
        this.brx = new e.a() { // from class: com.baidu.tbadk.BdToken.d.1
            @Override // com.baidu.tbadk.BdToken.e.a
            public void a(boolean z, q qVar) {
                if (z && qVar != null) {
                    d.this.clearClipBoard();
                    d.this.bo(qVar.getTitle(), qVar.getUrl());
                    d.this.a(qVar);
                }
            }
        };
        registerTask();
        registerListener();
        this.brw = new e();
        this.brw.a(this.brx);
        this.brv = new l();
    }

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(309626, DecryptCodeSocketRespMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, com.baidu.tieba.tbadkCore.a.a.br(TbConfig.DECRYPT_CODE_URL, 309626));
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
                    int Up = decryptData.Up();
                    if (Up == 1 || Up == 0) {
                        if (MessageManager.getInstance().findTask(2921361) != null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921377, decryptData));
                        }
                    } else if (Up == 2) {
                        d.this.bo(decryptData.getTitle(), decryptData.getUrl());
                    } else if (Up != 4 && Up == 3 && !StringUtils.isNull(decryptData.getUrl())) {
                        Uri parse = Uri.parse(decryptData.getUrl());
                        if (parse == null || parse.getQueryParameter(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE) == null || parse.getQueryParameter("obj_type") == null || !parse.getQueryParameter("obj_type").equals("wise")) {
                            d.this.ki(decryptData.getUrl());
                        } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("need_deal_diversion_jump", 0) == 1) {
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("need_deal_diversion_jump", 0);
                            if (MessageManager.getInstance().findTask(2921361) != null) {
                                TiebaStatic.log(new am("c13390").bJ("obj_type", parse.getQueryParameter("obj_type")).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, parse.getQueryParameter(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE)));
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
                    d.this.Ug();
                    d.this.Uf();
                }
            }
        });
    }

    public void check() {
        String clipBoardContent = getClipBoardContent();
        if (!ap.isEmpty(clipBoardContent)) {
            new BdAsyncTask<String, Integer, String>() { // from class: com.baidu.tbadk.BdToken.d.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public String doInBackground(String... strArr) {
                    Matcher matcher;
                    if (strArr == null || strArr.length < 1) {
                        return null;
                    }
                    String str = strArr[0];
                    if (ap.isEmpty(str)) {
                        return null;
                    }
                    String Ui = d.this.Ui();
                    if (ap.isEmpty(Ui) || (matcher = Pattern.compile(Ui).matcher(str)) == null || !matcher.find()) {
                        return null;
                    }
                    return str;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(String str) {
                    super.onPostExecute((AnonymousClass4) str);
                    if (str == null) {
                        if (d.this.brv != null && d.this.Uh()) {
                            d.this.brv.check();
                            return;
                        }
                        return;
                    }
                    d.this.kh(str);
                }
            }.execute(clipBoardContent);
        }
    }

    public void Uf() {
        String clipBoardContent = getClipBoardContent();
        if (!ap.isEmpty(clipBoardContent)) {
            new BdAsyncTask<String, Integer, String>() { // from class: com.baidu.tbadk.BdToken.d.5
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public String doInBackground(String... strArr) {
                    Matcher matcher;
                    if (strArr == null || strArr.length < 1) {
                        return null;
                    }
                    String str = strArr[0];
                    if (ap.isEmpty(str) || (matcher = d.bru.matcher(str)) == null || !matcher.find()) {
                        return null;
                    }
                    return str;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(String str) {
                    super.onPostExecute((AnonymousClass5) str);
                    if (str != null) {
                        DecryptCodeReqMsg decryptCodeReqMsg = new DecryptCodeReqMsg();
                        decryptCodeReqMsg.setCode(str);
                        MessageManager.getInstance().sendMessage(decryptCodeReqMsg);
                    }
                }
            }.execute(clipBoardContent);
        }
    }

    public void Ug() {
        String clipBoardContent = getClipBoardContent();
        if (!ap.isEmpty(clipBoardContent) && clipBoardContent.contains("^sZqulxTVsT$")) {
            kh(clipBoardContent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Uh() {
        String topActivityClassName = UtilHelper.getTopActivityClassName();
        return !ap.isEmpty(topActivityClassName) && topActivityClassName.equals("com.baidu.tieba.tblauncher.MainTabActivity") && TbSingleton.getInstance().isRecommendPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kh(String str) {
        this.brw.load(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClipBoard() {
        UtilHelper.clearClipBoard();
    }

    private String getClipBoardContent() {
        return UtilHelper.getClipBoardContent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Ui() {
        return new String(Base64.decode(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("key_baidu_password_re", "JTVDJTVFJTVCJTIzJTI0YS16QS1aMC05JTVEJTdCMTAlN0QlNUMlNUUlN0IwJTJDMSU3RCU1QiU1QyU1RSUyNCU1RCU3QjElN0Q="), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(String str, String str2) {
        TbPageContext<?> T;
        if (!ap.isEmpty(str2) && (T = T(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            ba.adD().a(T, str, new String[]{str2});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ki(String str) {
        Activity currentActivity;
        Uri parse;
        if (!ap.isEmpty(str) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (parse = Uri.parse(str)) != null) {
            if (str.startsWith(f.SCHEME)) {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                buildUpon.appendQueryParameter(f.brJ, f.brM);
                parse = buildUpon.build();
            }
            UtilHelper.dealOneScheme(currentActivity, parse.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q qVar) {
        if (qVar != null && qVar.UC() != null && !ap.isEmpty(qVar.UC().btntext) && Uh()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921380, qVar.UC().btntext));
        }
    }

    private TbPageContext T(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }
}
