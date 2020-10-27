package com.baidu.live.personmanager;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.br;
import com.baidu.live.personmanager.d;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
/* loaded from: classes4.dex */
public class b {
    private a boO;
    private com.baidu.live.p.d boP;
    private d boQ;
    private d boR;
    private TbPageContext mTbPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void b(PersonUserData personUserData);

        void b(br brVar);

        void c(br brVar);

        void onFail(String str);
    }

    public b(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.boQ = new d(tbPageContext);
        this.boR = new d(tbPageContext);
        this.boQ.a(new d.a() { // from class: com.baidu.live.personmanager.b.1
            @Override // com.baidu.live.personmanager.d.a
            public void a(br brVar) {
                if (brVar != null && b.this.boO != null) {
                    b.this.boO.b(brVar);
                }
            }

            @Override // com.baidu.live.personmanager.d.a
            public void onFail(String str) {
            }
        });
        this.boR.a(new d.a() { // from class: com.baidu.live.personmanager.b.2
            @Override // com.baidu.live.personmanager.d.a
            public void a(br brVar) {
                if (brVar != null && b.this.boO != null) {
                    b.this.boO.c(brVar);
                }
            }

            @Override // com.baidu.live.personmanager.d.a
            public void onFail(String str) {
            }
        });
    }

    public void b(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            if (this.boO != null) {
                this.boO.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_no_network));
            }
        } else if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            if (this.boO != null) {
                this.boO.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_error_unkown_try_again));
            }
        } else {
            this.boP = new com.baidu.live.p.d(new com.baidu.live.p.c() { // from class: com.baidu.live.personmanager.b.3
                @Override // com.baidu.live.p.c
                public void a(PersonUserData personUserData) {
                    if (b.this.boO != null) {
                        b.this.boO.b(personUserData);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501021, personUserData));
                }

                @Override // com.baidu.live.p.c
                public void s(int i, String str7) {
                    if (b.this.boO != null) {
                        b.this.boO.onFail(str7);
                    }
                }
            });
            if (TextUtils.isEmpty(str2)) {
                str2 = ExtraParamsManager.getEncryptionUserId(str);
            }
            this.boP.execute(str2, str4, str3);
            aD(str, str5);
        }
    }

    public void aD(String str, String str2) {
        if (TbadkCoreApplication.isLogin()) {
            this.boQ.setPn(-1);
            this.boQ.c(0, str, str2);
            this.boR.setPn(-1);
            this.boR.c(1, str, str2);
        }
    }

    public void onDestroy() {
        if (this.boP != null && !this.boP.isCancelled()) {
            this.boP.cancel();
        }
        if (this.boO != null) {
            this.boO.onFail(null);
        }
    }

    public void a(a aVar) {
        this.boO = aVar;
    }
}
