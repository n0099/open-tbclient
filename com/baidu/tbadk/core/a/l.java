package com.baidu.tbadk.core.a;

import android.content.Context;
import com.baidu.loginshare.LoginShareAssistant;
import com.baidu.loginshare.Token;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
public final class l {
    private static l a = null;
    private m b = null;

    private l() {
    }

    public static l a() {
        if (a == null) {
            a = new l();
        }
        return a;
    }

    public final void a(Context context) {
        try {
            LoginShareAssistant loginShareAssistant = LoginShareAssistant.getInstance();
            loginShareAssistant.initial(context, "tb", "1536");
            this.b = new m(this, (byte) 0);
            loginShareAssistant.setLoginShareListener(this.b);
        } catch (Error e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "init", e.getMessage());
        }
    }

    public final void b() {
        try {
            Token token = new Token();
            String D = TbadkApplication.D();
            if (D != null) {
                TbadkApplication.j();
                TbadkApplication.J();
                String[] split = D.split("[|]");
                if (split != null && split.length == 2) {
                    token.mBduss = split[0];
                    token.mPtoken = split[1];
                    if (token.mPtoken != null && token.mPtoken.length() > 0) {
                        token.mUsername = TbadkApplication.O();
                        LoginShareAssistant.getInstance().valid(token);
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "valid", e.getMessage());
        }
    }

    public final void a(String str) {
        String[] split;
        try {
            Token token = new Token();
            if (str != null && (split = str.split("[|]")) != null && split.length == 2) {
                token.mBduss = split[0];
                token.mPtoken = split[1];
                if (token.mPtoken != null && token.mPtoken.length() > 0) {
                    LoginShareAssistant.getInstance().invalid(token);
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "invalid", e.getMessage());
        }
    }

    public final void c() {
        try {
            LoginShareAssistant.getInstance().onActivityCreate();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "onActivityCreate", e.getMessage());
        }
    }

    public final void b(String str) {
        try {
            com.baidu.tbadk.core.data.i d = a().d();
            if (d != null) {
                if ("null".equals(d.c) || (!bc.c(str) && str.equals(d.c))) {
                    TbadkApplication.j();
                    TbadkApplication.J();
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "tryToRemoveShareAccount", e.getMessage());
        }
    }

    public final com.baidu.tbadk.core.data.i d() {
        com.baidu.tbadk.core.data.i iVar;
        com.baidu.tbadk.core.data.i iVar2;
        boolean z = false;
        try {
            String K = TbadkApplication.j().K();
            if (bc.c(K)) {
                iVar2 = null;
            } else {
                com.baidu.tbadk.core.data.i iVar3 = new com.baidu.tbadk.core.data.i();
                try {
                    String[] split = K.split(":");
                    int length = split.length;
                    boolean equals = length > 0 ? "1".equals(split[0]) : false;
                    if (length >= 2) {
                        try {
                            iVar3.a = split[1];
                        } catch (Exception e) {
                            e = e;
                            z = equals;
                            iVar = iVar3;
                            com.baidu.adp.lib.util.f.b(getClass().getName(), "getShareAccountData", e.getMessage());
                            iVar2 = iVar;
                            if (iVar2 == null) {
                            }
                            return null;
                        }
                    }
                    if (length >= 3) {
                        iVar3.b = split[2];
                    }
                    if (length < 4) {
                        z = equals;
                        iVar2 = iVar3;
                    } else if (split[3] == null || split[3].equalsIgnoreCase("null")) {
                        iVar3.c = null;
                        iVar2 = iVar3;
                    } else {
                        iVar3.c = split[3];
                        z = equals;
                        iVar2 = iVar3;
                    }
                } catch (Exception e2) {
                    e = e2;
                    iVar = iVar3;
                }
            }
        } catch (Exception e3) {
            e = e3;
            iVar = null;
        }
        if (iVar2 == null && z) {
            return iVar2;
        }
        return null;
    }
}
