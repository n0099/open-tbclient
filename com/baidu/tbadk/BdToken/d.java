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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class d {
    public static final Pattern dhh = Pattern.compile("\\$[0-9A-Za-z@_]{5,200}[#$]", 2);
    private r dhi;
    private e dhj;
    private AtomicBoolean dhk;
    private e.a dhl;

    public static final d aFX() {
        return a.dhn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static final d dhn = new d();
    }

    private d() {
        this.dhk = new AtomicBoolean(false);
        this.dhl = new e.a() { // from class: com.baidu.tbadk.BdToken.d.1
            @Override // com.baidu.tbadk.BdToken.e.a
            public void a(boolean z, v vVar) {
                if (z && vVar != null) {
                    d.this.clearClipBoard();
                    d.this.cv(vVar.getTitle(), vVar.getUrl());
                    d.this.a(vVar);
                }
            }
        };
        xB();
        registerListener();
        this.dhj = new e();
        this.dhj.a(this.dhl);
        this.dhi = new r();
    }

    private void xB() {
        com.baidu.tieba.tbadkCore.a.a.a(309626, DecryptCodeSocketRespMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, com.baidu.tieba.tbadkCore.a.a.bE(TbConfig.DECRYPT_CODE_URL, 309626));
        tbHttpMessageTask.setResponsedClass(DecryptCodeHttpRespMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, 309626) { // from class: com.baidu.tbadk.BdToken.d.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage responsedMessage) {
                g decryptData;
                d.this.dhk.compareAndSet(true, false);
                if (responsedMessage instanceof DecryptCodeHttpRespMsg) {
                    decryptData = ((DecryptCodeHttpRespMsg) responsedMessage).getDecryptData();
                } else if (responsedMessage instanceof DecryptCodeSocketRespMsg) {
                    decryptData = ((DecryptCodeSocketRespMsg) responsedMessage).getDecryptData();
                } else {
                    return;
                }
                if (decryptData != null) {
                    UtilHelper.clearClipBoard();
                    int aGf = decryptData.aGf();
                    if (aGf == 1 || aGf == 0) {
                        if (MessageManager.getInstance().findTask(2921361) != null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921377, decryptData));
                        }
                    } else if (aGf == 2) {
                        d.this.cv(decryptData.getTitle(), decryptData.getUrl());
                    } else if (aGf != 4 && aGf == 3 && !StringUtils.isNull(decryptData.getUrl())) {
                        Uri parse = Uri.parse(decryptData.getUrl());
                        String queryParameter = parse != null ? parse.getQueryParameter("obj_source") : "";
                        String queryParameter2 = parse != null ? parse.getQueryParameter("obj_type") : "";
                        String queryParameter3 = parse != null ? parse.getQueryParameter("tid") : "";
                        String queryParameter4 = parse != null ? parse.getQueryParameter("fname") : "";
                        if (TextUtils.isEmpty(queryParameter) || TextUtils.isEmpty(queryParameter2)) {
                            d.this.sQ(decryptData.getUrl());
                        } else if (queryParameter2.startsWith("tbcm")) {
                            d.this.sQ(decryptData.getUrl());
                            TiebaStatic.log(new an("c13390").cI("obj_type", queryParameter2).cI("obj_source", queryParameter).cI("tid", queryParameter3).cI("fname", queryParameter4));
                        } else if (com.baidu.tbadk.core.sharedPref.b.aNT().getInt("need_deal_diversion_jump", 0) == 1) {
                            com.baidu.tbadk.core.sharedPref.b.aNT().putInt("need_deal_diversion_jump", 0);
                            if (MessageManager.getInstance().findTask(2921361) != null) {
                                TiebaStatic.log(new an("c13390").cI("obj_type", queryParameter2).cI("obj_source", queryParameter).cI("tid", queryParameter3).cI("fname", queryParameter4));
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
                    String clipBoardContent = d.this.getClipBoardContent();
                    d.this.sM(clipBoardContent);
                    d.this.sO(clipBoardContent);
                    d.this.sN(clipBoardContent);
                }
            }
        });
    }

    public void sM(String str) {
        if (!aq.isEmpty(str)) {
            new BdAsyncTask<String, Integer, String>() { // from class: com.baidu.tbadk.BdToken.d.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public String doInBackground(String... strArr) {
                    Matcher matcher;
                    if (strArr == null || strArr.length < 1) {
                        return null;
                    }
                    String str2 = strArr[0];
                    if (aq.isEmpty(str2)) {
                        return null;
                    }
                    String aFZ = d.this.aFZ();
                    if (aq.isEmpty(aFZ) || (matcher = Pattern.compile(aFZ).matcher(str2)) == null || !matcher.find()) {
                        return null;
                    }
                    return str2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(String str2) {
                    super.onPostExecute((AnonymousClass4) str2);
                    if (str2 == null) {
                        if (d.this.dhi != null && d.this.aFY()) {
                            d.this.dhi.check();
                            return;
                        }
                        return;
                    }
                    d.this.sP(str2);
                }
            }.execute(str);
        }
    }

    public void sN(String str) {
        if (!aq.isEmpty(str)) {
            new BdAsyncTask<String, Integer, String>() { // from class: com.baidu.tbadk.BdToken.d.5
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public String doInBackground(String... strArr) {
                    Matcher matcher;
                    if (strArr == null || strArr.length < 1) {
                        return null;
                    }
                    String str2 = strArr[0];
                    if (aq.isEmpty(str2) || (matcher = d.dhh.matcher(str2)) == null || !matcher.find()) {
                        return null;
                    }
                    return str2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(String str2) {
                    super.onPostExecute((AnonymousClass5) str2);
                    if (str2 != null && !d.this.dhk.get()) {
                        d.this.dhk.compareAndSet(false, true);
                        DecryptCodeReqMsg decryptCodeReqMsg = new DecryptCodeReqMsg();
                        decryptCodeReqMsg.setCode(str2);
                        MessageManager.getInstance().sendMessage(decryptCodeReqMsg);
                    }
                }
            }.execute(str);
        }
    }

    public void sO(String str) {
        if (!aq.isEmpty(str) && str.contains("^sZqulxTVsT$")) {
            sP(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aFY() {
        String topActivityClassName = UtilHelper.getTopActivityClassName();
        return !aq.isEmpty(topActivityClassName) && topActivityClassName.equals("com.baidu.tieba.tblauncher.MainTabActivity") && TbSingleton.getInstance().isRecommendPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sP(String str) {
        this.dhj.load(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClipBoard() {
        UtilHelper.clearClipBoard();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getClipBoardContent() {
        return UtilHelper.getClipBoardContent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aFZ() {
        return new String(Base64.decode(com.baidu.tbadk.core.sharedPref.b.aNT().getString("key_baidu_password_re", "LipcXlsjJGEtekEtWjAtOV9dezUsfVxeezAsMX1bXF4kXXsxfS4q"), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cv(String str, String str2) {
        TbPageContext<?> n;
        if (!aq.isEmpty(str2) && (n = n(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            ba.aOV().a(n, str, new String[]{str2});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sQ(String str) {
        Activity currentActivity;
        Uri parse;
        if (!aq.isEmpty(str) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (parse = Uri.parse(str)) != null) {
            if (str.startsWith(f.dhq)) {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                buildUpon.appendQueryParameter(f.dhI, f.dhO);
                parse = buildUpon.build();
            }
            UtilHelper.dealOneScheme(currentActivity, parse.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(v vVar) {
        if (vVar != null && vVar.aGx() != null && !aq.isEmpty(vVar.aGx().btntext) && aFY()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921380, vVar.aGx().btntext));
        }
    }

    private TbPageContext n(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }
}
