package com.baidu.live.personmanager;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.bt;
import com.baidu.live.personmanager.d;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
/* loaded from: classes4.dex */
public class b {
    private a btF;
    private com.baidu.live.r.d btG;
    private d btH;
    private d btI;
    private TbPageContext mTbPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void b(PersonUserData personUserData);

        void b(bt btVar);

        void c(bt btVar);

        void onFail(String str);
    }

    public b(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.btH = new d(tbPageContext);
        this.btI = new d(tbPageContext);
        this.btH.a(new d.a() { // from class: com.baidu.live.personmanager.b.1
            @Override // com.baidu.live.personmanager.d.a
            public void a(bt btVar) {
                if (btVar != null && b.this.btF != null) {
                    b.this.btF.b(btVar);
                }
            }

            @Override // com.baidu.live.personmanager.d.a
            public void onFail(String str) {
            }
        });
        this.btI.a(new d.a() { // from class: com.baidu.live.personmanager.b.2
            @Override // com.baidu.live.personmanager.d.a
            public void a(bt btVar) {
                if (btVar != null && b.this.btF != null) {
                    b.this.btF.c(btVar);
                }
            }

            @Override // com.baidu.live.personmanager.d.a
            public void onFail(String str) {
            }
        });
    }

    public void b(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            if (this.btF != null) {
                this.btF.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_no_network));
            }
        } else if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            if (this.btF != null) {
                this.btF.onFail(this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_error_unkown_try_again));
            }
        } else {
            this.btG = new com.baidu.live.r.d(new com.baidu.live.r.c() { // from class: com.baidu.live.personmanager.b.3
                @Override // com.baidu.live.r.c
                public void a(PersonUserData personUserData) {
                    if (b.this.btF != null) {
                        b.this.btF.b(personUserData);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501021, personUserData));
                }

                @Override // com.baidu.live.r.c
                public void s(int i, String str7) {
                    if (b.this.btF != null) {
                        b.this.btF.onFail(str7);
                    }
                }
            });
            if (TextUtils.isEmpty(str2)) {
                str2 = ExtraParamsManager.getEncryptionUserId(str);
            }
            this.btG.execute(str2, str4, str3);
            aH(str, str5);
        }
    }

    public void aH(String str, String str2) {
        if (TbadkCoreApplication.isLogin()) {
            this.btH.setPn(-1);
            this.btH.e(0, str, str2);
            this.btI.setPn(-1);
            this.btI.e(1, str, str2);
        }
    }

    public void onDestroy() {
        if (this.btG != null && !this.btG.isCancelled()) {
            this.btG.cancel();
        }
        if (this.btF != null) {
            this.btF.onFail(null);
        }
    }

    public void a(a aVar) {
        this.btF = aVar;
    }
}
