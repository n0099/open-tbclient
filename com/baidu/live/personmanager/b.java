package com.baidu.live.personmanager;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.bv;
import com.baidu.live.personmanager.d;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
/* loaded from: classes11.dex */
public class b {
    private a byr;
    private com.baidu.live.s.d bys;
    private d byt;
    private d byu;
    private TbPageContext mTbPageContext;

    /* loaded from: classes11.dex */
    public interface a {
        void b(PersonUserData personUserData);

        void b(bv bvVar);

        void c(bv bvVar);

        void onFail(String str);
    }

    public b(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.byt = new d(tbPageContext);
        this.byu = new d(tbPageContext);
        this.byt.a(new d.a() { // from class: com.baidu.live.personmanager.b.1
            @Override // com.baidu.live.personmanager.d.a
            public void a(bv bvVar) {
                if (bvVar != null && b.this.byr != null) {
                    b.this.byr.b(bvVar);
                }
            }

            @Override // com.baidu.live.personmanager.d.a
            public void onFail(String str) {
            }
        });
        this.byu.a(new d.a() { // from class: com.baidu.live.personmanager.b.2
            @Override // com.baidu.live.personmanager.d.a
            public void a(bv bvVar) {
                if (bvVar != null && b.this.byr != null) {
                    b.this.byr.c(bvVar);
                }
            }

            @Override // com.baidu.live.personmanager.d.a
            public void onFail(String str) {
            }
        });
    }

    public void c(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            if (this.byr != null) {
                this.byr.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_no_network));
            }
        } else if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            if (this.byr != null) {
                this.byr.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_error_unkown_try_again));
            }
        } else {
            this.bys = new com.baidu.live.s.d(new com.baidu.live.s.c() { // from class: com.baidu.live.personmanager.b.3
                @Override // com.baidu.live.s.c
                public void a(PersonUserData personUserData) {
                    if (b.this.byr != null) {
                        b.this.byr.b(personUserData);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501021, personUserData));
                }

                @Override // com.baidu.live.s.c
                public void u(int i, String str7) {
                    if (b.this.byr != null) {
                        b.this.byr.onFail(str7);
                    }
                }
            });
            if (TextUtils.isEmpty(str2)) {
                str2 = ExtraParamsManager.getEncryptionUserId(str);
            }
            this.bys.execute(str2, str4, str3);
            aF(str, str5);
        }
    }

    public void aF(String str, String str2) {
        if (TbadkCoreApplication.isLogin()) {
            this.byt.setPn(-1);
            this.byt.e(0, str, str2);
            this.byu.setPn(-1);
            this.byu.e(1, str, str2);
        }
    }

    public void onDestroy() {
        if (this.bys != null && !this.bys.isCancelled()) {
            this.bys.cancel();
        }
        if (this.byr != null) {
            this.byr.onFail(null);
        }
    }

    public void a(a aVar) {
        this.byr = aVar;
    }
}
