package com.baidu.live.personmanager;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.bs;
import com.baidu.live.personmanager.d;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
/* loaded from: classes4.dex */
public class b {
    private a bqh;
    private com.baidu.live.p.d bqi;
    private d bqj;
    private d bqk;
    private TbPageContext mTbPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void b(PersonUserData personUserData);

        void b(bs bsVar);

        void c(bs bsVar);

        void onFail(String str);
    }

    public b(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bqj = new d(tbPageContext);
        this.bqk = new d(tbPageContext);
        this.bqj.a(new d.a() { // from class: com.baidu.live.personmanager.b.1
            @Override // com.baidu.live.personmanager.d.a
            public void a(bs bsVar) {
                if (bsVar != null && b.this.bqh != null) {
                    b.this.bqh.b(bsVar);
                }
            }

            @Override // com.baidu.live.personmanager.d.a
            public void onFail(String str) {
            }
        });
        this.bqk.a(new d.a() { // from class: com.baidu.live.personmanager.b.2
            @Override // com.baidu.live.personmanager.d.a
            public void a(bs bsVar) {
                if (bsVar != null && b.this.bqh != null) {
                    b.this.bqh.c(bsVar);
                }
            }

            @Override // com.baidu.live.personmanager.d.a
            public void onFail(String str) {
            }
        });
    }

    public void b(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            if (this.bqh != null) {
                this.bqh.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_no_network));
            }
        } else if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            if (this.bqh != null) {
                this.bqh.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_error_unkown_try_again));
            }
        } else {
            this.bqi = new com.baidu.live.p.d(new com.baidu.live.p.c() { // from class: com.baidu.live.personmanager.b.3
                @Override // com.baidu.live.p.c
                public void a(PersonUserData personUserData) {
                    if (b.this.bqh != null) {
                        b.this.bqh.b(personUserData);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501021, personUserData));
                }

                @Override // com.baidu.live.p.c
                public void s(int i, String str7) {
                    if (b.this.bqh != null) {
                        b.this.bqh.onFail(str7);
                    }
                }
            });
            if (TextUtils.isEmpty(str2)) {
                str2 = ExtraParamsManager.getEncryptionUserId(str);
            }
            this.bqi.execute(str2, str4, str3);
            aE(str, str5);
        }
    }

    public void aE(String str, String str2) {
        if (TbadkCoreApplication.isLogin()) {
            this.bqj.setPn(-1);
            this.bqj.c(0, str, str2);
            this.bqk.setPn(-1);
            this.bqk.c(1, str, str2);
        }
    }

    public void onDestroy() {
        if (this.bqi != null && !this.bqi.isCancelled()) {
            this.bqi.cancel();
        }
        if (this.bqh != null) {
            this.bqh.onFail(null);
        }
    }

    public void a(a aVar) {
        this.bqh = aVar;
    }
}
