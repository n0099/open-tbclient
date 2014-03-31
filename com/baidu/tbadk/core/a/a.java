package com.baidu.tbadk.core.a;

import android.app.Activity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.b.ak;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class a {
    private static a a = null;
    private Activity b;
    private int c;
    private ArrayList<AccountData> f;
    private k d = null;
    private boolean e = false;
    private int g = 0;
    private boolean h = false;
    private final u i = new b(this);
    private final r j = new d(this);
    private final r k = new f(this);
    private final u l = new h(this);

    public final void a(k kVar) {
        this.d = kVar;
    }

    private a() {
    }

    public static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    public static n a(String str) {
        n nVar;
        Exception e;
        if (str != null) {
            try {
                String[] split = str.split("[|]");
                if (split != null && split.length > 0) {
                    nVar = new n();
                    try {
                        nVar.a = split[0];
                        if (split.length >= 2) {
                            nVar.b = split[1];
                            return nVar;
                        }
                        return nVar;
                    } catch (Exception e2) {
                        e = e2;
                        com.baidu.adp.lib.util.f.b("AccountShareHelper", "parseBDUSS", e.getMessage());
                        return nVar;
                    }
                }
            } catch (Exception e3) {
                nVar = null;
                e = e3;
            }
        }
        return null;
    }

    public final void a(Activity activity, boolean z) {
        n a2;
        if (UtilHelper.a()) {
            this.b = activity;
            this.e = z;
            AccountData N = TbadkApplication.N();
            if (N != null && (a2 = a(N.getBDUSS())) != null) {
                t.a(N.getAccount(), a2.a, a2.b, this.i, false);
            }
        }
    }

    public final void a(Activity activity, int i) {
        if (UtilHelper.a() && TbadkApplication.N() == null) {
            this.h = true;
            this.b = activity;
            this.c = i;
            j jVar = new j(this);
            jVar.setPriority(3);
            jVar.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        com.baidu.tbadk.core.data.i iVar;
        n a2;
        while (this.f != null && this.g < this.f.size()) {
            ArrayList<AccountData> arrayList = this.f;
            int i = this.g;
            this.g = i + 1;
            AccountData accountData = arrayList.get(i);
            if (accountData == null || accountData.getAccount().equals(TbadkApplication.O()) || (a2 = a(accountData.getBDUSS())) == null) {
                iVar = null;
                continue;
            } else {
                com.baidu.tbadk.core.data.i iVar2 = new com.baidu.tbadk.core.data.i();
                iVar2.c = accountData.getAccount();
                iVar2.a = a2.a;
                iVar2.b = a2.b;
                iVar = iVar2;
                continue;
            }
            if (iVar != null) {
                t.a(iVar.c, iVar.a, iVar.b, this.l, false);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void k(a aVar) {
        com.baidu.tbadk.core.data.i d = l.a().d();
        if (d == null || aVar.b == null) {
            return;
        }
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001002, new ak(aVar.b, d, aVar.c)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ AccountData a(a aVar, String str) {
        int size = aVar.f.size();
        for (int i = 0; i < size; i++) {
            AccountData accountData = aVar.f.get(i);
            if (accountData.getAccount().equals(str)) {
                return accountData;
            }
        }
        return null;
    }

    public static void b(String str) {
        try {
            TiebaStatic.a(TbadkApplication.j().b(), str, "click", 1, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
