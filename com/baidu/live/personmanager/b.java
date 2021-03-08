package com.baidu.live.personmanager;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.ca;
import com.baidu.live.personmanager.d;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
/* loaded from: classes10.dex */
public class b {
    private a byJ;
    private com.baidu.live.r.d byK;
    private d byL;
    private d byM;
    private TbPageContext mTbPageContext;

    /* loaded from: classes10.dex */
    public interface a {
        void b(PersonUserData personUserData);

        void b(ca caVar);

        void c(ca caVar);

        void onFail(String str);
    }

    public b(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.byL = new d(tbPageContext);
        this.byM = new d(tbPageContext);
        this.byL.a(new d.a() { // from class: com.baidu.live.personmanager.b.1
            @Override // com.baidu.live.personmanager.d.a
            public void a(ca caVar) {
                if (caVar != null && b.this.byJ != null) {
                    b.this.byJ.b(caVar);
                }
            }

            @Override // com.baidu.live.personmanager.d.a
            public void onFail(String str) {
            }
        });
        this.byM.a(new d.a() { // from class: com.baidu.live.personmanager.b.2
            @Override // com.baidu.live.personmanager.d.a
            public void a(ca caVar) {
                if (caVar != null && b.this.byJ != null) {
                    b.this.byJ.c(caVar);
                }
            }

            @Override // com.baidu.live.personmanager.d.a
            public void onFail(String str) {
            }
        });
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            if (this.byJ != null) {
                this.byJ.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_no_network));
            }
        } else if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            if (this.byJ != null) {
                this.byJ.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_error_unkown_try_again));
            }
        } else {
            this.byK = new com.baidu.live.r.d(new com.baidu.live.r.c() { // from class: com.baidu.live.personmanager.b.3
                @Override // com.baidu.live.r.c
                public void a(PersonUserData personUserData) {
                    if (b.this.byJ != null) {
                        b.this.byJ.b(personUserData);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501021, personUserData));
                }

                @Override // com.baidu.live.r.c
                public void z(int i, String str7) {
                    if (b.this.byJ != null) {
                        b.this.byJ.onFail(str7);
                    }
                }
            });
            if (TextUtils.isEmpty(str2)) {
                str2 = ExtraParamsManager.getEncryptionUserId(str);
            }
            this.byK.execute(str2, str4, str3);
            aE(str, str5);
        }
    }

    public void aE(String str, String str2) {
        if (TbadkCoreApplication.isLogin()) {
            this.byL.setPn(-1);
            this.byL.e(0, str, str2);
            this.byM.setPn(-1);
            this.byM.e(1, str, str2);
        }
    }

    public void onDestroy() {
        if (this.byK != null && !this.byK.isCancelled()) {
            this.byK.cancel();
        }
        if (this.byJ != null) {
            this.byJ.onFail(null);
        }
    }

    public void a(a aVar) {
        this.byJ = aVar;
    }
}
