package com.baidu.live.personmanager;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.bf;
import com.baidu.live.data.bt;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.NetWork;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.data.Config;
/* loaded from: classes4.dex */
public class d {
    private a btK;
    private b btL;
    private Context context;
    private boolean hasMore;
    private TbPageContext mTbPageContext;
    private int pn = 0;
    private int type;
    private String url;

    /* loaded from: classes4.dex */
    public interface a {
        void a(bt btVar);

        void onFail(String str);
    }

    public d(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.context = tbPageContext.getPageActivity();
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public void e(int i, String str, String str2) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.btK != null) {
                this.btK.onFail(this.context.getResources().getString(a.h.sdk_no_network));
                return;
            }
            return;
        }
        this.type = i;
        if (i == 0) {
            this.url = TbConfig.SERVER_ADDRESS + Config.GET_FANS_ADDRESS;
        } else {
            this.url = TbConfig.SERVER_ADDRESS + "ala/user/followList";
        }
        this.pn++;
        this.btL = new b();
        this.btL.execute(str, str2);
    }

    public void a(a aVar) {
        this.btK = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<String, Void, Object> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public Object doInBackground(String... strArr) {
            bt btVar;
            NetWork netWork = new NetWork(d.this.url);
            String str = strArr[0];
            String str2 = strArr[1];
            netWork.addPostData("uid", str);
            netWork.addPostData("meta_key", str2);
            if (d.this.type == 0) {
                if (d.this.pn > 0) {
                    netWork.addPostData(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(d.this.pn));
                }
            } else {
                netWork.addPostData(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(d.this.pn));
            }
            if (d.this.type == 0) {
                netWork.addPostData("need_concern", "1");
            }
            netWork.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
            netWork.addPostData(HttpRequest.LIVE_SCENE, TbConfig.liveScene + "");
            String postNetData = netWork.postNetData();
            if (netWork.isRequestSuccess()) {
                String u = f.u(d.this.type, postNetData);
                if (TextUtils.isEmpty(u)) {
                    return null;
                }
                bt btVar2 = new bt();
                btVar2.parserJson(u);
                d.this.hasMore = btVar2.has_more == 1;
                if (d.this.type == 1) {
                    d.this.a(str, btVar2);
                }
                btVar = btVar2;
            } else {
                btVar = null;
            }
            return btVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onPostExecute(Object obj) {
            if (d.this.btK != null) {
                d.this.btK.a((bt) obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, bt btVar) {
        if (btVar != null && btVar.user_list != null && !btVar.user_list.isEmpty()) {
            for (bf bfVar : btVar.user_list) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.equals(str)) {
                    bfVar.aQa = 1;
                }
            }
        }
    }
}
