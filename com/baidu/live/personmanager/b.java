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
    private a bow;
    private com.baidu.live.p.d box;
    private d boy;
    private d boz;
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
        this.boy = new d(tbPageContext);
        this.boz = new d(tbPageContext);
        this.boy.a(new d.a() { // from class: com.baidu.live.personmanager.b.1
            @Override // com.baidu.live.personmanager.d.a
            public void a(bs bsVar) {
                if (bsVar != null && b.this.bow != null) {
                    b.this.bow.b(bsVar);
                }
            }

            @Override // com.baidu.live.personmanager.d.a
            public void onFail(String str) {
            }
        });
        this.boz.a(new d.a() { // from class: com.baidu.live.personmanager.b.2
            @Override // com.baidu.live.personmanager.d.a
            public void a(bs bsVar) {
                if (bsVar != null && b.this.bow != null) {
                    b.this.bow.c(bsVar);
                }
            }

            @Override // com.baidu.live.personmanager.d.a
            public void onFail(String str) {
            }
        });
    }

    public void b(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            if (this.bow != null) {
                this.bow.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_no_network));
            }
        } else if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            if (this.bow != null) {
                this.bow.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_error_unkown_try_again));
            }
        } else {
            this.box = new com.baidu.live.p.d(new com.baidu.live.p.c() { // from class: com.baidu.live.personmanager.b.3
                @Override // com.baidu.live.p.c
                public void a(PersonUserData personUserData) {
                    if (b.this.bow != null) {
                        b.this.bow.b(personUserData);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501021, personUserData));
                }

                @Override // com.baidu.live.p.c
                public void s(int i, String str7) {
                    if (b.this.bow != null) {
                        b.this.bow.onFail(str7);
                    }
                }
            });
            if (TextUtils.isEmpty(str2)) {
                str2 = ExtraParamsManager.getEncryptionUserId(str);
            }
            this.box.execute(str2, str4, str3);
            aD(str, str5);
        }
    }

    public void aD(String str, String str2) {
        if (TbadkCoreApplication.isLogin()) {
            this.boy.setPn(-1);
            this.boy.c(0, str, str2);
            this.boz.setPn(-1);
            this.boz.c(1, str, str2);
        }
    }

    public void onDestroy() {
        if (this.box != null && !this.box.isCancelled()) {
            this.box.cancel();
        }
        if (this.bow != null) {
            this.bow.onFail(null);
        }
    }

    public void a(a aVar) {
        this.bow = aVar;
    }
}
