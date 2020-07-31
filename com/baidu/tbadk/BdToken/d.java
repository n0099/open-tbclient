package com.baidu.tbadk.BdToken;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class d {
    public static final Pattern dFB = Pattern.compile("\\$[0-9A-Za-z@_]{5,200}[#$]", 2);
    private long dFC;
    private t dFD;
    private e dFE;
    private AtomicBoolean dFF = new AtomicBoolean(false);
    private e.a dFG = new e.a() { // from class: com.baidu.tbadk.BdToken.d.1
        @Override // com.baidu.tbadk.BdToken.e.a
        public void a(boolean z, x xVar) {
            if (z && xVar != null) {
                d.this.clearClipBoard();
                d.this.cZ(xVar.getTitle(), xVar.getUrl());
                d.this.a(xVar);
            }
        }
    };
    private boolean isInit;

    public static final d aQr() {
        return a.dFI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static final d dFI = new d();
    }

    public void aa(Activity activity) {
        if (!this.isInit) {
            registerTask();
            registerListener();
            this.dFE = new e();
            this.dFE.a(this.dFG);
            this.dFD = new t();
            String clipBoardContent = getClipBoardContent();
            if (!as.isEmpty(clipBoardContent)) {
                aQr().vB(clipBoardContent);
            } else if (UtilHelper.isActivityStartFromScheme(activity)) {
                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tbadk.BdToken.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        d.aQr().vB(d.this.getClipBoardContent());
                    }
                }, 4000L);
            } else if (am.isEmui() || am.baK()) {
                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tbadk.BdToken.d.3
                    @Override // java.lang.Runnable
                    public void run() {
                        d.aQr().vB(d.this.getClipBoardContent());
                    }
                }, 2000L);
            }
            this.isInit = true;
        }
    }

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(309626, DecryptCodeSocketRespMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, com.baidu.tieba.tbadkCore.a.a.bC(TbConfig.DECRYPT_CODE_URL, 309626));
        tbHttpMessageTask.setResponsedClass(DecryptCodeHttpRespMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, 309626) { // from class: com.baidu.tbadk.BdToken.d.4
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage responsedMessage) {
                g decryptData;
                d.this.dFF.compareAndSet(true, false);
                if (responsedMessage instanceof DecryptCodeHttpRespMsg) {
                    decryptData = ((DecryptCodeHttpRespMsg) responsedMessage).getDecryptData();
                } else if (responsedMessage instanceof DecryptCodeSocketRespMsg) {
                    decryptData = ((DecryptCodeSocketRespMsg) responsedMessage).getDecryptData();
                } else {
                    return;
                }
                if (decryptData != null) {
                    UtilHelper.clearClipBoard();
                    int aQz = decryptData.aQz();
                    if (aQz == 1 || aQz == 0) {
                        if (MessageManager.getInstance().findTask(2921361) != null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921377, decryptData));
                        }
                    } else if (aQz == 2) {
                        d.this.cZ(decryptData.getTitle(), decryptData.getUrl());
                    } else if (aQz != 4 && aQz == 3 && !StringUtils.isNull(decryptData.getUrl())) {
                        Uri parse = Uri.parse(decryptData.getUrl());
                        String queryParameter = parse != null ? parse.getQueryParameter("obj_source") : "";
                        String queryParameter2 = parse != null ? parse.getQueryParameter("obj_type") : "";
                        String queryParameter3 = parse != null ? parse.getQueryParameter("tid") : "";
                        String queryParameter4 = parse != null ? parse.getQueryParameter("fname") : "";
                        String queryParameter5 = parse != null ? parse.getQueryParameter("eqid") : "";
                        if (!TextUtils.isEmpty(queryParameter) && !TextUtils.isEmpty(queryParameter2) && queryParameter2.startsWith("tbcm")) {
                            d.this.vG(decryptData.getUrl());
                            TiebaStatic.log(new ap("c13390").dn("obj_type", queryParameter2).dn("obj_source", queryParameter).dn("tid", queryParameter3).dn("fname", queryParameter4));
                        } else if (TextUtils.isEmpty(queryParameter) || TextUtils.isEmpty(queryParameter2) || com.baidu.tbadk.core.sharedPref.b.aZP().getInt("need_deal_diversion_jump", 0) != 1) {
                            d.this.vG(decryptData.getUrl());
                            TiebaStatic.log(new ap("c13390").dn("obj_type", queryParameter2).dn("obj_source", queryParameter).dn("tid", queryParameter3).dn("fname", queryParameter4).dn("query", queryParameter5));
                        } else {
                            com.baidu.tbadk.core.sharedPref.b.aZP().putInt("need_deal_diversion_jump", 0);
                            if (MessageManager.getInstance().findTask(2921361) != null) {
                                TiebaStatic.log(new ap("c13390").dn("obj_type", queryParameter2).dn("obj_source", queryParameter).dn("tid", queryParameter3).dn("fname", queryParameter4).dn("query", queryParameter5));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921377, decryptData));
                            }
                        }
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.BdToken.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    d.this.vB(d.this.getClipBoardContent());
                }
            }
        });
    }

    public void vB(String str) {
        vC(str);
        vE(str);
        vD(str);
    }

    public void vC(String str) {
        if (!as.isEmpty(str)) {
            new BdAsyncTask<String, Integer, String>() { // from class: com.baidu.tbadk.BdToken.d.6
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public String doInBackground(String... strArr) {
                    Matcher matcher;
                    if (strArr == null || strArr.length < 1) {
                        return null;
                    }
                    String str2 = strArr[0];
                    if (as.isEmpty(str2)) {
                        return null;
                    }
                    String aQt = d.this.aQt();
                    if (as.isEmpty(aQt) || (matcher = Pattern.compile(aQt).matcher(str2)) == null || !matcher.find()) {
                        return null;
                    }
                    return str2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(String str2) {
                    super.onPostExecute((AnonymousClass6) str2);
                    if (str2 == null) {
                        if (d.this.dFD != null && d.this.aQs()) {
                            d.this.dFD.check();
                            return;
                        }
                        return;
                    }
                    d.this.vF(str2);
                }
            }.execute(str);
        }
    }

    public void vD(String str) {
        if (!as.isEmpty(str)) {
            new BdAsyncTask<String, Integer, String>() { // from class: com.baidu.tbadk.BdToken.d.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public String doInBackground(String... strArr) {
                    Matcher matcher;
                    if (strArr == null || strArr.length < 1) {
                        return null;
                    }
                    String str2 = strArr[0];
                    if (as.isEmpty(str2) || (matcher = d.dFB.matcher(str2)) == null || !matcher.find()) {
                        return null;
                    }
                    return str2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(String str2) {
                    super.onPostExecute((AnonymousClass7) str2);
                    if (str2 != null && !d.this.dFF.get()) {
                        d.this.dFF.compareAndSet(false, true);
                        DecryptCodeReqMsg decryptCodeReqMsg = new DecryptCodeReqMsg();
                        decryptCodeReqMsg.setCode(str2);
                        MessageManager.getInstance().sendMessage(decryptCodeReqMsg);
                    }
                }
            }.execute(str);
        }
    }

    public void vE(String str) {
        if (!as.isEmpty(str) && str.contains("^sZqulxTVsT$")) {
            vF(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aQs() {
        String topActivityClassName = UtilHelper.getTopActivityClassName();
        return !as.isEmpty(topActivityClassName) && topActivityClassName.equals("com.baidu.tieba.tblauncher.MainTabActivity") && TbSingleton.getInstance().isRecommendPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vF(String str) {
        this.dFE.load(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClipBoard() {
        UtilHelper.clearClipBoard();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getClipBoardContent() {
        if (System.currentTimeMillis() - this.dFC < 2000) {
            return null;
        }
        this.dFC = System.currentTimeMillis();
        return UtilHelper.getClipBoardContent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aQt() {
        return new String(Base64.decode(com.baidu.tbadk.core.sharedPref.b.aZP().getString("key_baidu_password_re", "LipcXlsjJGEtekEtWjAtOV9dezUsfVxeezAsMX1bXF4kXXsxfS4q"), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZ(String str, String str2) {
        TbPageContext<?> o;
        if (!as.isEmpty(str2) && (o = o(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            bd.baV().a(o, str, new String[]{str2});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vG(String str) {
        Activity currentActivity;
        Uri parse;
        if (!as.isEmpty(str) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (parse = Uri.parse(str)) != null) {
            if (str.startsWith(f.dFL)) {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                buildUpon.appendQueryParameter(f.dGf, f.dGr);
                parse = buildUpon.build();
            }
            UtilHelper.dealOneScheme(currentActivity, parse.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(x xVar) {
        if (xVar != null && xVar.aRk() != null && !as.isEmpty(xVar.aRk().btntext) && aQs()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921380, xVar.aRk().btntext));
        }
    }

    private TbPageContext o(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }
}
