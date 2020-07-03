package com.baidu.tbadk.core.util;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.bu;
/* loaded from: classes.dex */
public class l {
    private static ao a(String str, bu buVar, String str2) {
        if (buVar == null) {
            return null;
        }
        ao aoVar = new ao(str);
        aoVar.dk("tid", buVar.getTid());
        aoVar.s("fid", buVar.getFid());
        aoVar.dk("resource_id", str2);
        return aoVar;
    }

    private static int t(bu buVar) {
        if (buVar.getType() == bu.dLv || buVar.aUm()) {
            return 2;
        }
        if (buVar.aQX() || buVar.aQY()) {
            return 3;
        }
        return 1;
    }

    public static ao a(bu buVar, String str) {
        if (buVar == null) {
            return null;
        }
        ao a = a("c13629", buVar, str);
        a.s("uid", TbadkApplication.getCurrentAccountId());
        a.ag("obj_locate", buVar.dJw);
        a.ag("obj_source", buVar.threadType);
        a.s(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.ag("obj_param5", t(buVar));
        a.ag("obj_type", buVar.aTv());
        if (buVar.aTS() != null) {
            a.ag("obj_name", buVar.aTS().lGH ? 1 : 0);
        }
        if (buVar.getBaijiahaoData() != null) {
            a.dk("obj_param4", buVar.getBaijiahaoData().oriUgcNid);
        }
        if (buVar.aSp() != null) {
            a.ag(TiebaInitialize.Params.AB_TYPE, buVar.aSp().getIsLike() ? 1 : 0);
        }
        a.ag("is_full", buVar.aUf() ? 1 : 0);
        return a;
    }

    public static ao b(bu buVar, String str) {
        if (buVar == null) {
            return null;
        }
        ao a = a("c13628", buVar, str);
        a.ag("obj_locate", buVar.dJw);
        a.ag("obj_source", buVar.threadType);
        a.s(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.ag("obj_param5", t(buVar));
        a.dk("obj_name", buVar.mRecomAbTag);
        if (buVar.getBaijiahaoData() != null) {
            a.dk("obj_param4", buVar.getBaijiahaoData().oriUgcNid);
            a.dk("obj_param6", buVar.getBaijiahaoData().oriUgcVid);
        }
        if (buVar.dNV > 0) {
            a.ag("midpageflag", 1);
        } else {
            a.ag("midpageflag", 0);
        }
        if (buVar.aSp() != null) {
            a.ag(TiebaInitialize.Params.AB_TYPE, buVar.aSp().getIsLike() ? 1 : 0);
        }
        return a;
    }

    public static ao c(bu buVar, String str) {
        ao a;
        if (buVar == null) {
            return null;
        }
        if (buVar.getType() == bu.dLH) {
            a = a("c13636", buVar, str);
            if (buVar.getBaijiahaoData() != null) {
                a.dk("obj_param6", buVar.getBaijiahaoData().oriUgcVid);
            }
        } else {
            a = a("c13633", buVar, str);
            a.ag("obj_type", buVar.aTv());
        }
        a.s("uid", TbadkApplication.getCurrentAccountId());
        a.ag("obj_locate", buVar.dJw);
        a.s(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.ag("obj_param5", t(buVar));
        if (buVar.getBaijiahaoData() != null) {
            a.dk("obj_param4", buVar.getBaijiahaoData().oriUgcNid);
            return a;
        }
        return a;
    }

    public static ao d(bu buVar, String str) {
        ao aoVar;
        if (buVar == null) {
            return null;
        }
        if (buVar.getType() == bu.dLH) {
            ao a = a("c13637", buVar, str);
            if (buVar.getBaijiahaoData() != null) {
                a.dk("obj_param6", buVar.getBaijiahaoData().oriUgcVid);
            }
            if (buVar.dNV > 0) {
                a.ag("midpageflag", 1);
                aoVar = a;
            } else {
                a.ag("midpageflag", 0);
                aoVar = a;
            }
        } else {
            ao a2 = a("c13631", buVar, str);
            a2.ag("obj_type", buVar.aTv());
            a2.ag("is_full", buVar.aUf() ? 1 : 0);
            aoVar = a2;
        }
        aoVar.s("uid", TbadkApplication.getCurrentAccountId());
        aoVar.ag("obj_locate", buVar.dJw);
        aoVar.s(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        aoVar.ag("obj_param5", t(buVar));
        if (buVar.getBaijiahaoData() != null) {
            aoVar.dk("obj_param4", buVar.getBaijiahaoData().oriUgcNid);
            return aoVar;
        }
        return aoVar;
    }

    public static ao e(bu buVar, String str) {
        if (buVar == null) {
            return null;
        }
        ao a = a("c13632", buVar, str);
        a.s("uid", TbadkApplication.getCurrentAccountId());
        a.ag("obj_locate", buVar.dJw);
        a.s(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.ag("obj_param5", t(buVar));
        a.ag("obj_type", buVar.aTv());
        if (buVar.getBaijiahaoData() != null) {
            a.dk("obj_param4", buVar.getBaijiahaoData().oriUgcNid);
        }
        a.ag("is_full", buVar.aUf() ? 1 : 0);
        return a;
    }

    public static ao f(bu buVar, String str) {
        if (buVar == null) {
            return null;
        }
        ao a = a("c13638", buVar, str);
        a.s("uid", TbadkApplication.getCurrentAccountId());
        a.ag("obj_locate", buVar.dJw);
        a.s(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.ag("obj_param5", t(buVar));
        if (buVar.getBaijiahaoData() != null) {
            a.dk("obj_param4", buVar.getBaijiahaoData().oriUgcNid);
            a.dk("obj_param6", buVar.getBaijiahaoData().oriUgcVid);
            return a;
        }
        return a;
    }

    public static ao g(bu buVar, String str) {
        ao a;
        if (buVar == null) {
            return null;
        }
        if (buVar.getType() == bu.dLH) {
            a = a("c13639", buVar, str);
            a.ag("obj_type", 1);
            if (buVar.getBaijiahaoData() != null) {
                a.dk("obj_param6", buVar.getBaijiahaoData().oriUgcVid);
            }
        } else {
            a = a("c13634", buVar, str);
            a.ag("obj_type", buVar.aTv());
        }
        a.s("uid", TbadkApplication.getCurrentAccountId());
        a.ag("obj_locate", buVar.dJw);
        a.s(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.ag("obj_param5", t(buVar));
        if (buVar.getBaijiahaoData() != null) {
            a.dk("obj_param4", buVar.getBaijiahaoData().oriUgcNid);
            return a;
        }
        return a;
    }

    public static ao a(com.baidu.tbadk.core.data.ap apVar, String str) {
        ao aoVar;
        if (apVar == null) {
            return null;
        }
        if (apVar.cardType == 2 || apVar.cardType == 6 || apVar.cardType == 8) {
            aoVar = new ao("c13640");
            aoVar.ag(TiebaInitialize.Params.OBJ_PARAM2, 2);
        } else {
            aoVar = new ao("c13635");
            aoVar.ag(TiebaInitialize.Params.OBJ_PARAM2, 1);
        }
        aoVar.s("uid", TbadkApplication.getCurrentAccountId());
        aoVar.dk("tid", apVar.getTid());
        aoVar.dk("fid", apVar.getFid());
        aoVar.dk("resource_id", str);
        return aoVar;
    }
}
