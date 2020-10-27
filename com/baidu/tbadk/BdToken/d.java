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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class d {
    public static final Pattern elo = Pattern.compile("\\$[0-9A-Za-z@_]{5,200}[#$]", 2);
    public static final Pattern elp = Pattern.compile("\\$(com.baidu.tieba://unidispatch/)[0-9a-zA-Z]{1,10}\\?[0-9a-zA-Z_=&%\\-.]{1,300}[$]", 2);
    private long elq;
    private t elr;
    private e els;
    private AtomicBoolean elt = new AtomicBoolean(false);
    private e.a elu = new e.a() { // from class: com.baidu.tbadk.BdToken.d.1
        @Override // com.baidu.tbadk.BdToken.e.a
        public void a(boolean z, x xVar) {
            if (z && xVar != null) {
                d.this.clearClipBoard();
                d.this.dB(xVar.getTitle(), xVar.getUrl());
                d.this.a(xVar);
            }
        }
    };
    private boolean isInit;

    public static final d bdV() {
        return a.elw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static final d elw = new d();
    }

    public void r(Activity activity) {
        if (!this.isInit) {
            registerTask();
            registerListener();
            this.els = new e();
            this.els.a(this.elu);
            this.elr = new t();
            String clipBoardContent = getClipBoardContent();
            if (!at.isEmpty(clipBoardContent)) {
                bdV().zl(clipBoardContent);
            } else if (UtilHelper.isActivityStartFromScheme(activity)) {
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tbadk.BdToken.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        d.bdV().zl(d.this.getClipBoardContent());
                    }
                }, 4000L);
            } else if (an.isEmui() || an.boF()) {
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tbadk.BdToken.d.3
                    @Override // java.lang.Runnable
                    public void run() {
                        d.bdV().zl(d.this.getClipBoardContent());
                    }
                }, 2000L);
            }
            this.isInit = true;
        }
    }

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(309626, DecryptCodeSocketRespMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, com.baidu.tieba.tbadkCore.a.a.bJ(TbConfig.DECRYPT_CODE_URL, 309626));
        tbHttpMessageTask.setResponsedClass(DecryptCodeHttpRespMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, 309626) { // from class: com.baidu.tbadk.BdToken.d.4
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage responsedMessage) {
                g decryptData;
                d.this.elt.compareAndSet(true, false);
                if (responsedMessage instanceof DecryptCodeHttpRespMsg) {
                    decryptData = ((DecryptCodeHttpRespMsg) responsedMessage).getDecryptData();
                } else if (responsedMessage instanceof DecryptCodeSocketRespMsg) {
                    decryptData = ((DecryptCodeSocketRespMsg) responsedMessage).getDecryptData();
                } else {
                    return;
                }
                if (decryptData != null) {
                    UtilHelper.clearClipBoard();
                    int bed = decryptData.bed();
                    if (bed == 1 || bed == 0) {
                        if (MessageManager.getInstance().findTask(2921361) != null && !decryptData.appId.equals(TbadkCoreApplication.getInst().getCurAiAppid())) {
                            TbadkCoreApplication.getInst().setCurAiAppid(null);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921377, decryptData));
                        }
                    } else if (bed == 2) {
                        d.this.dB(decryptData.getTitle(), decryptData.getUrl());
                    } else if (bed != 4 && bed == 3 && !StringUtils.isNull(decryptData.getUrl())) {
                        Uri parse = Uri.parse(decryptData.getUrl());
                        String queryParameter = parse != null ? parse.getQueryParameter("obj_source") : "";
                        String queryParameter2 = parse != null ? parse.getQueryParameter("obj_type") : "";
                        String queryParameter3 = parse != null ? parse.getQueryParameter("tid") : "";
                        String queryParameter4 = parse != null ? parse.getQueryParameter("fname") : "";
                        String queryParameter5 = parse != null ? parse.getQueryParameter("eqid") : "";
                        if (TextUtils.isEmpty(queryParameter) || TextUtils.isEmpty(queryParameter2) || !queryParameter2.startsWith("tbcm")) {
                            d.this.zr(decryptData.getUrl());
                            TiebaStatic.log(new aq("c13390").dR("obj_type", queryParameter2).dR("obj_source", queryParameter).dR("tid", queryParameter3).dR("fname", queryParameter4).dR("query", queryParameter5));
                            return;
                        }
                        d.this.zr(decryptData.getUrl());
                        TiebaStatic.log(new aq("c13390").dR("obj_type", queryParameter2).dR("obj_source", queryParameter).dR("tid", queryParameter3).dR("fname", queryParameter4));
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tbadk.BdToken.d.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    d.this.zl(d.this.getClipBoardContent());
                }
            }
        });
    }

    public void zl(String str) {
        zm(str);
        zp(str);
        zo(str);
        zn(str);
    }

    public void zm(String str) {
        if (!at.isEmpty(str)) {
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
                    if (at.isEmpty(str2)) {
                        return null;
                    }
                    String bdX = d.this.bdX();
                    if (at.isEmpty(bdX) || (matcher = Pattern.compile(bdX).matcher(str2)) == null || !matcher.find()) {
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
                        if (d.this.elr != null && d.this.bdW()) {
                            d.this.elr.check();
                            return;
                        }
                        return;
                    }
                    d.this.zq(str2);
                }
            }.execute(str);
        }
    }

    public void zn(String str) {
        if (!at.isEmpty(str)) {
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
                    if (at.isEmpty(str2) || (matcher = d.elp.matcher(str2)) == null || !matcher.find()) {
                        return null;
                    }
                    return str2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(String str2) {
                    super.onPostExecute((AnonymousClass7) str2);
                    if (str2 != null) {
                        d.this.zr(str2.substring(1, str2.length() - 1));
                    }
                }
            }.execute(str);
        }
    }

    public void zo(String str) {
        if (!at.isEmpty(str)) {
            new BdAsyncTask<String, Integer, String>() { // from class: com.baidu.tbadk.BdToken.d.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public String doInBackground(String... strArr) {
                    Matcher matcher;
                    if (strArr == null || strArr.length < 1) {
                        return null;
                    }
                    String str2 = strArr[0];
                    if (at.isEmpty(str2) || (matcher = d.elo.matcher(str2)) == null || !matcher.find()) {
                        return null;
                    }
                    return str2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(String str2) {
                    super.onPostExecute((AnonymousClass8) str2);
                    if (str2 != null && !d.this.elt.get()) {
                        d.this.elt.compareAndSet(false, true);
                        DecryptCodeReqMsg decryptCodeReqMsg = new DecryptCodeReqMsg();
                        decryptCodeReqMsg.setCode(str2);
                        MessageManager.getInstance().sendMessage(decryptCodeReqMsg);
                    }
                }
            }.execute(str);
        }
    }

    public void zp(String str) {
        if (!at.isEmpty(str) && str.contains("^sZqulxTVsT$")) {
            zq(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bdW() {
        String topActivityClassName = UtilHelper.getTopActivityClassName();
        return !at.isEmpty(topActivityClassName) && topActivityClassName.equals("com.baidu.tieba.tblauncher.MainTabActivity") && TbSingleton.getInstance().isRecommendPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zq(String str) {
        this.els.load(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClipBoard() {
        UtilHelper.clearClipBoard();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getClipBoardContent() {
        if (System.currentTimeMillis() - this.elq < 2000) {
            return null;
        }
        this.elq = System.currentTimeMillis();
        return UtilHelper.getClipBoardContent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bdX() {
        return new String(Base64.decode(com.baidu.tbadk.core.sharedPref.b.bnH().getString("key_baidu_password_re", "LipcXlsjJGEtekEtWjAtOV9dezUsfVxeezAsMX1bXF4kXXsxfS4q"), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dB(String str, String str2) {
        TbPageContext<?> o;
        if (!at.isEmpty(str2) && (o = o(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            be.boR().a(o, str, new String[]{str2});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zr(String str) {
        Activity currentActivity;
        Uri parse;
        if (!at.isEmpty(str) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (parse = Uri.parse(str)) != null) {
            if (str.startsWith(f.elz)) {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                buildUpon.appendQueryParameter(f.elU, f.emh);
                parse = buildUpon.build();
            }
            UtilHelper.dealOneScheme(currentActivity, parse.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(x xVar) {
        if (xVar != null && xVar.beO() != null && !at.isEmpty(xVar.beO().btntext) && bdW()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921380, xVar.beO().btntext));
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
