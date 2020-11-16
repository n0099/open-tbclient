package com.baidu.tbadk.core.util;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.bx;
/* loaded from: classes.dex */
public class l {
    private static ar a(String str, bx bxVar, String str2) {
        if (bxVar == null) {
            return null;
        }
        ar arVar = new ar(str);
        arVar.dR("tid", bxVar.getTid());
        arVar.w("fid", bxVar.getFid());
        arVar.dR("resource_id", str2);
        return arVar;
    }

    private static int v(bx bxVar) {
        if (bxVar.getType() == bx.eCc || bxVar.bnA()) {
            return 2;
        }
        if (bxVar.bkk() || bxVar.bkl()) {
            return 3;
        }
        return 1;
    }

    public static ar a(bx bxVar, String str) {
        if (bxVar == null) {
            return null;
        }
        ar a2 = a("c13629", bxVar, str);
        a2.w("uid", TbadkApplication.getCurrentAccountId());
        a2.ak("obj_locate", bxVar.eAb);
        a2.ak("obj_source", bxVar.threadType);
        a2.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.ak("obj_param5", v(bxVar));
        a2.ak("obj_type", bxVar.bmK());
        if (bxVar.bnh() != null) {
            a2.ak("obj_name", bxVar.bnh().mYD ? 1 : 0);
        }
        if (bxVar.getBaijiahaoData() != null) {
            a2.dR("obj_param4", bxVar.getBaijiahaoData().oriUgcNid);
        }
        if (bxVar.blC() != null) {
            a2.ak(TiebaInitialize.Params.AB_TYPE, bxVar.blC().getIsLike() ? 1 : 0);
        }
        a2.ak("is_full", bxVar.bnu() ? 1 : 0);
        return a2;
    }

    public static ar b(bx bxVar, String str) {
        if (bxVar == null) {
            return null;
        }
        ar a2 = a("c13628", bxVar, str);
        a2.ak("obj_locate", bxVar.eAb);
        a2.ak("obj_source", bxVar.threadType);
        a2.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.ak("obj_param5", v(bxVar));
        a2.dR("obj_name", bxVar.mRecomAbTag);
        if (bxVar.getBaijiahaoData() != null) {
            a2.dR("obj_param4", bxVar.getBaijiahaoData().oriUgcNid);
            a2.dR("obj_param6", bxVar.getBaijiahaoData().oriUgcVid);
        }
        if (bxVar.eED > 0) {
            a2.ak("midpageflag", 1);
        } else {
            a2.ak("midpageflag", 0);
        }
        if (bxVar.blC() != null) {
            a2.ak(TiebaInitialize.Params.AB_TYPE, bxVar.blC().getIsLike() ? 1 : 0);
        }
        return a2;
    }

    public static ar c(bx bxVar, String str) {
        ar a2;
        if (bxVar == null) {
            return null;
        }
        if (bxVar.getType() == bx.eCo) {
            a2 = a("c13636", bxVar, str);
            if (bxVar.getBaijiahaoData() != null) {
                a2.dR("obj_param6", bxVar.getBaijiahaoData().oriUgcVid);
            }
        } else {
            a2 = a("c13633", bxVar, str);
            a2.ak("obj_type", bxVar.bmK());
        }
        a2.w("uid", TbadkApplication.getCurrentAccountId());
        a2.ak("obj_locate", bxVar.eAb);
        a2.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.ak("obj_param5", v(bxVar));
        if (bxVar.getBaijiahaoData() != null) {
            a2.dR("obj_param4", bxVar.getBaijiahaoData().oriUgcNid);
            return a2;
        }
        return a2;
    }

    public static ar d(bx bxVar, String str) {
        ar arVar;
        if (bxVar == null) {
            return null;
        }
        if (bxVar.getType() == bx.eCo) {
            ar a2 = a("c13637", bxVar, str);
            if (bxVar.getBaijiahaoData() != null) {
                a2.dR("obj_param6", bxVar.getBaijiahaoData().oriUgcVid);
            }
            if (bxVar.eED > 0) {
                a2.ak("midpageflag", 1);
                arVar = a2;
            } else {
                a2.ak("midpageflag", 0);
                arVar = a2;
            }
        } else {
            ar a3 = a("c13631", bxVar, str);
            a3.ak("obj_type", bxVar.bmK());
            a3.ak("is_full", bxVar.bnu() ? 1 : 0);
            arVar = a3;
        }
        arVar.w("uid", TbadkApplication.getCurrentAccountId());
        arVar.ak("obj_locate", bxVar.eAb);
        arVar.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        arVar.ak("obj_param5", v(bxVar));
        if (bxVar.getBaijiahaoData() != null) {
            arVar.dR("obj_param4", bxVar.getBaijiahaoData().oriUgcNid);
            return arVar;
        }
        return arVar;
    }

    public static ar e(bx bxVar, String str) {
        if (bxVar == null) {
            return null;
        }
        ar a2 = a("c13632", bxVar, str);
        a2.w("uid", TbadkApplication.getCurrentAccountId());
        a2.ak("obj_locate", bxVar.eAb);
        a2.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.ak("obj_param5", v(bxVar));
        a2.ak("obj_type", bxVar.bmK());
        if (bxVar.getBaijiahaoData() != null) {
            a2.dR("obj_param4", bxVar.getBaijiahaoData().oriUgcNid);
        }
        a2.ak("is_full", bxVar.bnu() ? 1 : 0);
        return a2;
    }

    public static ar f(bx bxVar, String str) {
        if (bxVar == null) {
            return null;
        }
        ar a2 = a("c13638", bxVar, str);
        a2.w("uid", TbadkApplication.getCurrentAccountId());
        a2.ak("obj_locate", bxVar.eAb);
        a2.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.ak("obj_param5", v(bxVar));
        if (bxVar.getBaijiahaoData() != null) {
            a2.dR("obj_param4", bxVar.getBaijiahaoData().oriUgcNid);
            a2.dR("obj_param6", bxVar.getBaijiahaoData().oriUgcVid);
            return a2;
        }
        return a2;
    }

    public static ar g(bx bxVar, String str) {
        ar a2;
        if (bxVar == null) {
            return null;
        }
        if (bxVar.getType() == bx.eCo) {
            a2 = a("c13639", bxVar, str);
            a2.ak("obj_type", 1);
            if (bxVar.getBaijiahaoData() != null) {
                a2.dR("obj_param6", bxVar.getBaijiahaoData().oriUgcVid);
            }
        } else {
            a2 = a("c13634", bxVar, str);
            a2.ak("obj_type", bxVar.bmK());
        }
        a2.w("uid", TbadkApplication.getCurrentAccountId());
        a2.ak("obj_locate", bxVar.eAb);
        a2.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.ak("obj_param5", v(bxVar));
        if (bxVar.getBaijiahaoData() != null) {
            a2.dR("obj_param4", bxVar.getBaijiahaoData().oriUgcNid);
            return a2;
        }
        return a2;
    }

    public static ar a(com.baidu.tbadk.core.data.as asVar, String str) {
        ar arVar;
        if (asVar == null) {
            return null;
        }
        if (asVar.cardType == 2 || asVar.cardType == 6 || asVar.cardType == 8) {
            arVar = new ar("c13640");
            arVar.ak(TiebaInitialize.Params.OBJ_PARAM2, 2);
        } else {
            arVar = new ar("c13635");
            arVar.ak(TiebaInitialize.Params.OBJ_PARAM2, 1);
        }
        arVar.w("uid", TbadkApplication.getCurrentAccountId());
        arVar.dR("tid", asVar.getTid());
        arVar.dR("fid", asVar.getFid());
        arVar.dR("resource_id", str);
        return arVar;
    }
}
