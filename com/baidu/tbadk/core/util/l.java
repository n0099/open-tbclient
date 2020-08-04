package com.baidu.tbadk.core.util;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.bv;
/* loaded from: classes.dex */
public class l {
    private static ap a(String str, bv bvVar, String str2) {
        if (bvVar == null) {
            return null;
        }
        ap apVar = new ap(str);
        apVar.dn("tid", bvVar.getTid());
        apVar.t("fid", bvVar.getFid());
        apVar.dn("resource_id", str2);
        return apVar;
    }

    private static int u(bv bvVar) {
        if (bvVar.getType() == bv.dRG || bvVar.aYh()) {
            return 2;
        }
        if (bvVar.aUT() || bvVar.aUU()) {
            return 3;
        }
        return 1;
    }

    public static ap a(bv bvVar, String str) {
        if (bvVar == null) {
            return null;
        }
        ap a = a("c13629", bvVar, str);
        a.t("uid", TbadkApplication.getCurrentAccountId());
        a.ah("obj_locate", bvVar.dPI);
        a.ah("obj_source", bvVar.threadType);
        a.t(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.ah("obj_param5", u(bvVar));
        a.ah("obj_type", bvVar.aXr());
        if (bvVar.aXO() != null) {
            a.ah("obj_name", bvVar.aXO().lNX ? 1 : 0);
        }
        if (bvVar.getBaijiahaoData() != null) {
            a.dn("obj_param4", bvVar.getBaijiahaoData().oriUgcNid);
        }
        if (bvVar.aWl() != null) {
            a.ah(TiebaInitialize.Params.AB_TYPE, bvVar.aWl().getIsLike() ? 1 : 0);
        }
        a.ah("is_full", bvVar.aYb() ? 1 : 0);
        return a;
    }

    public static ap b(bv bvVar, String str) {
        if (bvVar == null) {
            return null;
        }
        ap a = a("c13628", bvVar, str);
        a.ah("obj_locate", bvVar.dPI);
        a.ah("obj_source", bvVar.threadType);
        a.t(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.ah("obj_param5", u(bvVar));
        a.dn("obj_name", bvVar.mRecomAbTag);
        if (bvVar.getBaijiahaoData() != null) {
            a.dn("obj_param4", bvVar.getBaijiahaoData().oriUgcNid);
            a.dn("obj_param6", bvVar.getBaijiahaoData().oriUgcVid);
        }
        if (bvVar.dUg > 0) {
            a.ah("midpageflag", 1);
        } else {
            a.ah("midpageflag", 0);
        }
        if (bvVar.aWl() != null) {
            a.ah(TiebaInitialize.Params.AB_TYPE, bvVar.aWl().getIsLike() ? 1 : 0);
        }
        return a;
    }

    public static ap c(bv bvVar, String str) {
        ap a;
        if (bvVar == null) {
            return null;
        }
        if (bvVar.getType() == bv.dRS) {
            a = a("c13636", bvVar, str);
            if (bvVar.getBaijiahaoData() != null) {
                a.dn("obj_param6", bvVar.getBaijiahaoData().oriUgcVid);
            }
        } else {
            a = a("c13633", bvVar, str);
            a.ah("obj_type", bvVar.aXr());
        }
        a.t("uid", TbadkApplication.getCurrentAccountId());
        a.ah("obj_locate", bvVar.dPI);
        a.t(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.ah("obj_param5", u(bvVar));
        if (bvVar.getBaijiahaoData() != null) {
            a.dn("obj_param4", bvVar.getBaijiahaoData().oriUgcNid);
            return a;
        }
        return a;
    }

    public static ap d(bv bvVar, String str) {
        ap apVar;
        if (bvVar == null) {
            return null;
        }
        if (bvVar.getType() == bv.dRS) {
            ap a = a("c13637", bvVar, str);
            if (bvVar.getBaijiahaoData() != null) {
                a.dn("obj_param6", bvVar.getBaijiahaoData().oriUgcVid);
            }
            if (bvVar.dUg > 0) {
                a.ah("midpageflag", 1);
                apVar = a;
            } else {
                a.ah("midpageflag", 0);
                apVar = a;
            }
        } else {
            ap a2 = a("c13631", bvVar, str);
            a2.ah("obj_type", bvVar.aXr());
            a2.ah("is_full", bvVar.aYb() ? 1 : 0);
            apVar = a2;
        }
        apVar.t("uid", TbadkApplication.getCurrentAccountId());
        apVar.ah("obj_locate", bvVar.dPI);
        apVar.t(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        apVar.ah("obj_param5", u(bvVar));
        if (bvVar.getBaijiahaoData() != null) {
            apVar.dn("obj_param4", bvVar.getBaijiahaoData().oriUgcNid);
            return apVar;
        }
        return apVar;
    }

    public static ap e(bv bvVar, String str) {
        if (bvVar == null) {
            return null;
        }
        ap a = a("c13632", bvVar, str);
        a.t("uid", TbadkApplication.getCurrentAccountId());
        a.ah("obj_locate", bvVar.dPI);
        a.t(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.ah("obj_param5", u(bvVar));
        a.ah("obj_type", bvVar.aXr());
        if (bvVar.getBaijiahaoData() != null) {
            a.dn("obj_param4", bvVar.getBaijiahaoData().oriUgcNid);
        }
        a.ah("is_full", bvVar.aYb() ? 1 : 0);
        return a;
    }

    public static ap f(bv bvVar, String str) {
        if (bvVar == null) {
            return null;
        }
        ap a = a("c13638", bvVar, str);
        a.t("uid", TbadkApplication.getCurrentAccountId());
        a.ah("obj_locate", bvVar.dPI);
        a.t(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.ah("obj_param5", u(bvVar));
        if (bvVar.getBaijiahaoData() != null) {
            a.dn("obj_param4", bvVar.getBaijiahaoData().oriUgcNid);
            a.dn("obj_param6", bvVar.getBaijiahaoData().oriUgcVid);
            return a;
        }
        return a;
    }

    public static ap g(bv bvVar, String str) {
        ap a;
        if (bvVar == null) {
            return null;
        }
        if (bvVar.getType() == bv.dRS) {
            a = a("c13639", bvVar, str);
            a.ah("obj_type", 1);
            if (bvVar.getBaijiahaoData() != null) {
                a.dn("obj_param6", bvVar.getBaijiahaoData().oriUgcVid);
            }
        } else {
            a = a("c13634", bvVar, str);
            a.ah("obj_type", bvVar.aXr());
        }
        a.t("uid", TbadkApplication.getCurrentAccountId());
        a.ah("obj_locate", bvVar.dPI);
        a.t(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.ah("obj_param5", u(bvVar));
        if (bvVar.getBaijiahaoData() != null) {
            a.dn("obj_param4", bvVar.getBaijiahaoData().oriUgcNid);
            return a;
        }
        return a;
    }

    public static ap a(com.baidu.tbadk.core.data.aq aqVar, String str) {
        ap apVar;
        if (aqVar == null) {
            return null;
        }
        if (aqVar.cardType == 2 || aqVar.cardType == 6 || aqVar.cardType == 8) {
            apVar = new ap("c13640");
            apVar.ah(TiebaInitialize.Params.OBJ_PARAM2, 2);
        } else {
            apVar = new ap("c13635");
            apVar.ah(TiebaInitialize.Params.OBJ_PARAM2, 1);
        }
        apVar.t("uid", TbadkApplication.getCurrentAccountId());
        apVar.dn("tid", aqVar.getTid());
        apVar.dn("fid", aqVar.getFid());
        apVar.dn("resource_id", str);
        return apVar;
    }
}
