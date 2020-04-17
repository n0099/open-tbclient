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
    public static final Pattern dhc = Pattern.compile("\\$[0-9A-Za-z@_]{5,200}[#$]", 2);
    private r dhd;
    private e dhe;
    private AtomicBoolean dhf;
    private e.a dhg;

    public static final d aFX() {
        return a.dhi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static final d dhi = new d();
    }

    private d() {
        this.dhf = new AtomicBoolean(false);
        this.dhg = new e.a() { // from class: com.baidu.tbadk.BdToken.d.1
            @Override // com.baidu.tbadk.BdToken.e.a
            public void a(boolean z, v vVar) {
                if (z && vVar != null) {
                    d.this.clearClipBoard();
                    d.this.cv(vVar.getTitle(), vVar.getUrl());
                    d.this.a(vVar);
                }
            }
        };
        xC();
        registerListener();
        this.dhe = new e();
        this.dhe.a(this.dhg);
        this.dhd = new r();
    }

    private void xC() {
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
                d.this.dhf.compareAndSet(true, false);
                if (responsedMessage instanceof DecryptCodeHttpRespMsg) {
                    decryptData = ((DecryptCodeHttpRespMsg) responsedMessage).getDecryptData();
                } else if (responsedMessage instanceof DecryptCodeSocketRespMsg) {
                    decryptData = ((DecryptCodeSocketRespMsg) responsedMessage).getDecryptData();
                } else {
                    return;
                }
                if (decryptData != null) {
                    UtilHelper.clearClipBoard();
                    int aGh = decryptData.aGh();
                    if (aGh == 1 || aGh == 0) {
                        if (MessageManager.getInstance().findTask(2921361) != null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921377, decryptData));
                        }
                    } else if (aGh == 2) {
                        d.this.cv(decryptData.getTitle(), decryptData.getUrl());
                    } else if (aGh != 4 && aGh == 3 && !StringUtils.isNull(decryptData.getUrl())) {
                        Uri parse = Uri.parse(decryptData.getUrl());
                        String queryParameter = parse != null ? parse.getQueryParameter("obj_source") : "";
                        String queryParameter2 = parse != null ? parse.getQueryParameter("obj_type") : "";
                        String queryParameter3 = parse != null ? parse.getQueryParameter("tid") : "";
                        String queryParameter4 = parse != null ? parse.getQueryParameter("fname") : "";
                        if (TextUtils.isEmpty(queryParameter) || TextUtils.isEmpty(queryParameter2)) {
                            d.this.sN(decryptData.getUrl());
                        } else if (queryParameter2.startsWith("tbcm")) {
                            d.this.sN(decryptData.getUrl());
                            TiebaStatic.log(new an("c13390").cI("obj_type", queryParameter2).cI("obj_source", queryParameter).cI("tid", queryParameter3).cI("fname", queryParameter4));
                        } else if (com.baidu.tbadk.core.sharedPref.b.aNV().getInt("need_deal_diversion_jump", 0) == 1) {
                            com.baidu.tbadk.core.sharedPref.b.aNV().putInt("need_deal_diversion_jump", 0);
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
                    d.this.check();
                    d.this.aFZ();
                    d.this.aFY();
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
                    String aGb = d.this.aGb();
                    if (aq.isEmpty(aGb) || (matcher = Pattern.compile(aGb).matcher(str)) == null || !matcher.find()) {
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
                        if (d.this.dhd != null && d.this.aGa()) {
                            d.this.dhd.check();
                            return;
                        }
                        return;
                    }
                    d.this.sM(str);
                }
            }.execute(clipBoardContent);
        }
    }

    public void aFY() {
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
                    if (aq.isEmpty(str) || (matcher = d.dhc.matcher(str)) == null || !matcher.find()) {
                        return null;
                    }
                    return str;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public void onPostExecute(String str) {
                    super.onPostExecute((AnonymousClass5) str);
                    if (str != null && !d.this.dhf.get()) {
                        d.this.dhf.compareAndSet(false, true);
                        DecryptCodeReqMsg decryptCodeReqMsg = new DecryptCodeReqMsg();
                        decryptCodeReqMsg.setCode(str);
                        MessageManager.getInstance().sendMessage(decryptCodeReqMsg);
                    }
                }
            }.execute(clipBoardContent);
        }
    }

    public void aFZ() {
        String clipBoardContent = getClipBoardContent();
        if (!aq.isEmpty(clipBoardContent) && clipBoardContent.contains("^sZqulxTVsT$")) {
            sM(clipBoardContent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aGa() {
        String topActivityClassName = UtilHelper.getTopActivityClassName();
        return !aq.isEmpty(topActivityClassName) && topActivityClassName.equals("com.baidu.tieba.tblauncher.MainTabActivity") && TbSingleton.getInstance().isRecommendPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sM(String str) {
        this.dhe.load(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClipBoard() {
        UtilHelper.clearClipBoard();
    }

    private String getClipBoardContent() {
        return UtilHelper.getClipBoardContent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aGb() {
        return new String(Base64.decode(com.baidu.tbadk.core.sharedPref.b.aNV().getString("key_baidu_password_re", "LipcXlsjJGEtekEtWjAtOV9dezUsfVxeezAsMX1bXF4kXXsxfS4q"), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cv(String str, String str2) {
        TbPageContext<?> n;
        if (!aq.isEmpty(str2) && (n = n(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            ba.aOY().a(n, str, new String[]{str2});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sN(String str) {
        Activity currentActivity;
        Uri parse;
        if (!aq.isEmpty(str) && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null && (parse = Uri.parse(str)) != null) {
            if (str.startsWith(f.dhl)) {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                buildUpon.appendQueryParameter(f.dhD, f.dhJ);
                parse = buildUpon.build();
            }
            UtilHelper.dealOneScheme(currentActivity, parse.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(v vVar) {
        if (vVar != null && vVar.aGz() != null && !aq.isEmpty(vVar.aGz().btntext) && aGa()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921380, vVar.aGz().btntext));
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
