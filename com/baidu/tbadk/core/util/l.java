package com.baidu.tbadk.core.util;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes.dex */
public class l {
    private static aq a(String str, bw bwVar, String str2) {
        if (bwVar == null) {
            return null;
        }
        aq aqVar = new aq(str);
        aqVar.dR("tid", bwVar.getTid());
        aqVar.w("fid", bwVar.getFid());
        aqVar.dR("resource_id", str2);
        return aqVar;
    }

    private static int v(bw bwVar) {
        if (bwVar.getType() == bw.eDK || bwVar.bow()) {
            return 2;
        }
        if (bwVar.bli() || bwVar.blj()) {
            return 3;
        }
        return 1;
    }

    public static aq a(bw bwVar, String str) {
        if (bwVar == null) {
            return null;
        }
        aq a2 = a("c13629", bwVar, str);
        a2.w("uid", TbadkApplication.getCurrentAccountId());
        a2.al("obj_locate", bwVar.eBK);
        a2.al("obj_source", bwVar.threadType);
        a2.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.al("obj_param5", v(bwVar));
        a2.al("obj_type", bwVar.bnG());
        if (bwVar.bod() != null) {
            a2.al("obj_name", bwVar.bod().mXL ? 1 : 0);
        }
        if (bwVar.getBaijiahaoData() != null) {
            a2.dR("obj_param4", bwVar.getBaijiahaoData().oriUgcNid);
        }
        if (bwVar.bmA() != null) {
            a2.al(TiebaInitialize.Params.AB_TYPE, bwVar.bmA().getIsLike() ? 1 : 0);
        }
        a2.al("is_full", bwVar.boq() ? 1 : 0);
        return a2;
    }

    public static aq b(bw bwVar, String str) {
        if (bwVar == null) {
            return null;
        }
        aq a2 = a("c13628", bwVar, str);
        a2.al("obj_locate", bwVar.eBK);
        a2.al("obj_source", bwVar.threadType);
        a2.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.al("obj_param5", v(bwVar));
        a2.dR("obj_name", bwVar.mRecomAbTag);
        if (bwVar.getBaijiahaoData() != null) {
            a2.dR("obj_param4", bwVar.getBaijiahaoData().oriUgcNid);
            a2.dR("obj_param6", bwVar.getBaijiahaoData().oriUgcVid);
        }
        if (bwVar.eGl > 0) {
            a2.al("midpageflag", 1);
        } else {
            a2.al("midpageflag", 0);
        }
        if (bwVar.bmA() != null) {
            a2.al(TiebaInitialize.Params.AB_TYPE, bwVar.bmA().getIsLike() ? 1 : 0);
        }
        return a2;
    }

    public static aq c(bw bwVar, String str) {
        aq a2;
        if (bwVar == null) {
            return null;
        }
        if (bwVar.getType() == bw.eDW) {
            a2 = a("c13636", bwVar, str);
            if (bwVar.getBaijiahaoData() != null) {
                a2.dR("obj_param6", bwVar.getBaijiahaoData().oriUgcVid);
            }
        } else {
            a2 = a("c13633", bwVar, str);
            a2.al("obj_type", bwVar.bnG());
        }
        a2.w("uid", TbadkApplication.getCurrentAccountId());
        a2.al("obj_locate", bwVar.eBK);
        a2.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.al("obj_param5", v(bwVar));
        if (bwVar.getBaijiahaoData() != null) {
            a2.dR("obj_param4", bwVar.getBaijiahaoData().oriUgcNid);
            return a2;
        }
        return a2;
    }

    public static aq d(bw bwVar, String str) {
        aq aqVar;
        if (bwVar == null) {
            return null;
        }
        if (bwVar.getType() == bw.eDW) {
            aq a2 = a("c13637", bwVar, str);
            if (bwVar.getBaijiahaoData() != null) {
                a2.dR("obj_param6", bwVar.getBaijiahaoData().oriUgcVid);
            }
            if (bwVar.eGl > 0) {
                a2.al("midpageflag", 1);
                aqVar = a2;
            } else {
                a2.al("midpageflag", 0);
                aqVar = a2;
            }
        } else {
            aq a3 = a("c13631", bwVar, str);
            a3.al("obj_type", bwVar.bnG());
            a3.al("is_full", bwVar.boq() ? 1 : 0);
            aqVar = a3;
        }
        aqVar.w("uid", TbadkApplication.getCurrentAccountId());
        aqVar.al("obj_locate", bwVar.eBK);
        aqVar.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        aqVar.al("obj_param5", v(bwVar));
        if (bwVar.getBaijiahaoData() != null) {
            aqVar.dR("obj_param4", bwVar.getBaijiahaoData().oriUgcNid);
            return aqVar;
        }
        return aqVar;
    }

    public static aq e(bw bwVar, String str) {
        if (bwVar == null) {
            return null;
        }
        aq a2 = a("c13632", bwVar, str);
        a2.w("uid", TbadkApplication.getCurrentAccountId());
        a2.al("obj_locate", bwVar.eBK);
        a2.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.al("obj_param5", v(bwVar));
        a2.al("obj_type", bwVar.bnG());
        if (bwVar.getBaijiahaoData() != null) {
            a2.dR("obj_param4", bwVar.getBaijiahaoData().oriUgcNid);
        }
        a2.al("is_full", bwVar.boq() ? 1 : 0);
        return a2;
    }

    public static aq f(bw bwVar, String str) {
        if (bwVar == null) {
            return null;
        }
        aq a2 = a("c13638", bwVar, str);
        a2.w("uid", TbadkApplication.getCurrentAccountId());
        a2.al("obj_locate", bwVar.eBK);
        a2.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.al("obj_param5", v(bwVar));
        if (bwVar.getBaijiahaoData() != null) {
            a2.dR("obj_param4", bwVar.getBaijiahaoData().oriUgcNid);
            a2.dR("obj_param6", bwVar.getBaijiahaoData().oriUgcVid);
            return a2;
        }
        return a2;
    }

    public static aq g(bw bwVar, String str) {
        aq a2;
        if (bwVar == null) {
            return null;
        }
        if (bwVar.getType() == bw.eDW) {
            a2 = a("c13639", bwVar, str);
            a2.al("obj_type", 1);
            if (bwVar.getBaijiahaoData() != null) {
                a2.dR("obj_param6", bwVar.getBaijiahaoData().oriUgcVid);
            }
        } else {
            a2 = a("c13634", bwVar, str);
            a2.al("obj_type", bwVar.bnG());
        }
        a2.w("uid", TbadkApplication.getCurrentAccountId());
        a2.al("obj_locate", bwVar.eBK);
        a2.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.al("obj_param5", v(bwVar));
        if (bwVar.getBaijiahaoData() != null) {
            a2.dR("obj_param4", bwVar.getBaijiahaoData().oriUgcNid);
            return a2;
        }
        return a2;
    }

    public static aq a(com.baidu.tbadk.core.data.ar arVar, String str) {
        aq aqVar;
        if (arVar == null) {
            return null;
        }
        if (arVar.cardType == 2 || arVar.cardType == 6 || arVar.cardType == 8) {
            aqVar = new aq("c13640");
            aqVar.al(TiebaInitialize.Params.OBJ_PARAM2, 2);
        } else {
            aqVar = new aq("c13635");
            aqVar.al(TiebaInitialize.Params.OBJ_PARAM2, 1);
        }
        aqVar.w("uid", TbadkApplication.getCurrentAccountId());
        aqVar.dR("tid", arVar.getTid());
        aqVar.dR("fid", arVar.getFid());
        aqVar.dR("resource_id", str);
        return aqVar;
    }
}
