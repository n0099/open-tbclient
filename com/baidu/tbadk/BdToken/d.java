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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.e;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class d {
    public static final Pattern cDH = Pattern.compile("\\$[0-9A-Za-z@]{5,50}[#$]", 2);
    private r cDI;
    private e cDJ;
    private AtomicBoolean cDK;
    private e.a cDL;

    public static final d ava() {
        return a.cDN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static final d cDN = new d();
    }

    private d() {
        this.cDK = new AtomicBoolean(false);
        this.cDL = new e.a() { // from class: com.baidu.tbadk.BdToken.d.1
            @Override // com.baidu.tbadk.BdToken.e.a
            public void a(boolean z, v vVar) {
                if (z && vVar != null) {
                    d.this.clearClipBoard();
                    d.this.cb(vVar.getTitle(), vVar.getUrl());
                    d.this.a(vVar);
                }
            }
        };
        rG();
        registerListener();
        this.cDJ = new e();
        this.cDJ.a(this.cDL);
        this.cDI = new r();
    }

    private void rG() {
        com.baidu.tieba.tbadkCore.a.a.a(309626, DecryptCodeSocketRespMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, com.baidu.tieba.tbadkCore.a.a.bu(TbConfig.DECRYPT_CODE_URL, 309626));
        tbHttpMessageTask.setResponsedClass(DecryptCodeHttpRespMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, 309626) { // from class: com.baidu.tbadk.BdToken.d.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage responsedMessage) {
                g decryptData;
                d.this.cDK.compareAndSet(true, false);
                if (responsedMessage instanceof DecryptCodeHttpRespMsg) {
                    decryptData = ((DecryptCodeHttpRespMsg) responsedMessage).getDecryptData();
                } else if (responsedMessage instanceof DecryptCodeSocketRespMsg) {
                    decryptData = ((DecryptCodeSocketRespMsg) responsedMessage).getDecryptData();
                } else {
                    return;
                }
                if (decryptData != null) {
                    UtilHelper.clearClipBoard();
                    int avl = decryptData.avl();
                    if (avl == 1 || avl == 0) {
                        if (MessageManager.getInstance().findTask(2921361) != null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921377, decryptData));
                        }
                    } else if (avl == 2) {
                        d.this.cb(decryptData.getTitle(), decryptData.getUrl());
                    } else if (avl != 4 && avl == 3 && !StringUtils.isNull(decryptData.getUrl())) {
                        Uri parse = Uri.parse(decryptData.getUrl());
                        if (parse == null || parse.getQueryParameter("obj_source") == null || parse.getQueryParameter("obj_type") == null) {
                            d.this.ri(decryptData.getUrl());
                        } else if (com.baidu.tbadk.core.sharedPref.b.aCY().getInt("need_deal_diversion_jump", 0) == 1) {
                            com.baidu.tbadk.core.sharedPref.b.aCY().putInt("need_deal_diversion_jump", 0);
                            if (MessageManager.getInstance().findTask(2921361) != null) {
                                TiebaStatic.log(new an("c13390").cp("obj_type", parse.getQueryParameter("obj_type")).cp("obj_source", parse.getQueryParameter("obj_source")));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921377, decryptData));
                            }
                        }
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.BdToken.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    d.this.check();
                    d.this.avc();
                    d.this.avb();
                }
            }
        });
    }

    public void check() {
        String clipBoardContent = getClipBoardContent();
        if (!aq.isEmpty(clipBoardContent)) {
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
                    if (aq.isEmpty(str)) {
                        return null;
                    }
                    String ave = d.this.ave();
                    if (aq.isEmpty(ave) || (matcher = Pattern.compile(ave).matcher(str)) == null || !matcher.find()) {
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
                        if (d.this.cDI != null && d.this.avd()) {
                            d.this.cDI.check();
                            return;
                        }
                        return;
                    }
                    d.this.rh(str);
                }
            }.execute(clipBoardContent);
        }
    }

    public void avb() {
        String clipBoardContent = getClipBoardContent();
        if (!aq.isEmpty(clipBoardContent)) {
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
                    if (aq.isEmpty(str) || (matcher = d.cDH.matcher(str)) == null || !matcher.find()) {
                        return null;
                    }
                    return str;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(String str) {
                    super.onPostExecute((AnonymousClass5) str);
                    if (str != null && !d.this.cDK.get()) {
                        d.this.cDK.compareAndSet(false, true);
                        DecryptCodeReqMsg decryptCodeReqMsg = new DecryptCodeReqMsg();
                        decryptCodeReqMsg.setCode(str);
                        MessageManager.getInstance().sendMessage(decryptCodeReqMsg);
                    }
                }
            }.execute(clipBoardContent);
        }
    }

    public void avc() {
        String clipBoardContent = getClipBoardContent();
        if (!aq.isEmpty(clipBoardContent) && clipBoardContent.contains("^sZqulxTVsT$")) {
            rh(clipBoardContent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean avd() {
        String topActivityClassName = UtilHelper.getTopActivityClassName();
        return !aq.isEmpty(topActivityClassName) && topActivityClassName.equals("com.baidu.tieba.tblauncher.MainTabActivity") && TbSingleton.getInstance().isRecommendPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rh(String str) {
        this.cDJ.load(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClipBoard() {
        UtilHelper.clearClipBoard();
    }

    private String getClipBoardContent() {
        return UtilHelper.getClipBoardContent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ave() {
        return new String(Base64.decode(com.baidu.tbadk.core.sharedPref.b.aCY().getString("key_baidu_password_re", "JTVDJTVFJTVCJTIzJTI0YS16QS1aMC05JTVEJTdCMTAlN0QlNUMlNUUlN0IwJTJDMSU3RCU1QiU1QyU1RSUyNCU1RCU3QjElN0Q="), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(String str, String str2) {
        TbPageContext<?> r;
        if (!aq.isEmpty(str2) && (r = r(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            ba.aEa().a(r, str, new String[]{str2});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ri(String str) {
        Activity currentActivity;
        Uri parse;
        if (!aq.isEmpty(str) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (parse = Uri.parse(str)) != null) {
            if (str.startsWith(f.cDQ)) {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                buildUpon.appendQueryParameter(f.cEa, f.cEe);
                parse = buildUpon.build();
            }
            UtilHelper.dealOneScheme(currentActivity, parse.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(v vVar) {
        if (vVar != null && vVar.avD() != null && !aq.isEmpty(vVar.avD().btntext) && avd()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921380, vVar.avD().btntext));
        }
    }

    private TbPageContext r(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }
}
