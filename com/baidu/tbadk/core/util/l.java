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
        aqVar.dK("tid", bwVar.getTid());
        aqVar.u("fid", bwVar.getFid());
        aqVar.dK("resource_id", str2);
        return aqVar;
    }

    private static int v(bw bwVar) {
        if (bwVar.getType() == bw.epv || bwVar.bkd()) {
            return 2;
        }
        if (bwVar.bgP() || bwVar.bgQ()) {
            return 3;
        }
        return 1;
    }

    public static aq a(bw bwVar, String str) {
        if (bwVar == null) {
            return null;
        }
        aq a2 = a("c13629", bwVar, str);
        a2.u("uid", TbadkApplication.getCurrentAccountId());
        a2.aj("obj_locate", bwVar.ens);
        a2.aj("obj_source", bwVar.threadType);
        a2.u(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.aj("obj_param5", v(bwVar));
        a2.aj("obj_type", bwVar.bjn());
        if (bwVar.bjK() != null) {
            a2.aj("obj_name", bwVar.bjK().mFb ? 1 : 0);
        }
        if (bwVar.getBaijiahaoData() != null) {
            a2.dK("obj_param4", bwVar.getBaijiahaoData().oriUgcNid);
        }
        if (bwVar.bih() != null) {
            a2.aj(TiebaInitialize.Params.AB_TYPE, bwVar.bih().getIsLike() ? 1 : 0);
        }
        a2.aj("is_full", bwVar.bjX() ? 1 : 0);
        return a2;
    }

    public static aq b(bw bwVar, String str) {
        if (bwVar == null) {
            return null;
        }
        aq a2 = a("c13628", bwVar, str);
        a2.aj("obj_locate", bwVar.ens);
        a2.aj("obj_source", bwVar.threadType);
        a2.u(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.aj("obj_param5", v(bwVar));
        a2.dK("obj_name", bwVar.mRecomAbTag);
        if (bwVar.getBaijiahaoData() != null) {
            a2.dK("obj_param4", bwVar.getBaijiahaoData().oriUgcNid);
            a2.dK("obj_param6", bwVar.getBaijiahaoData().oriUgcVid);
        }
        if (bwVar.erW > 0) {
            a2.aj("midpageflag", 1);
        } else {
            a2.aj("midpageflag", 0);
        }
        if (bwVar.bih() != null) {
            a2.aj(TiebaInitialize.Params.AB_TYPE, bwVar.bih().getIsLike() ? 1 : 0);
        }
        return a2;
    }

    public static aq c(bw bwVar, String str) {
        aq a2;
        if (bwVar == null) {
            return null;
        }
        if (bwVar.getType() == bw.epH) {
            a2 = a("c13636", bwVar, str);
            if (bwVar.getBaijiahaoData() != null) {
                a2.dK("obj_param6", bwVar.getBaijiahaoData().oriUgcVid);
            }
        } else {
            a2 = a("c13633", bwVar, str);
            a2.aj("obj_type", bwVar.bjn());
        }
        a2.u("uid", TbadkApplication.getCurrentAccountId());
        a2.aj("obj_locate", bwVar.ens);
        a2.u(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.aj("obj_param5", v(bwVar));
        if (bwVar.getBaijiahaoData() != null) {
            a2.dK("obj_param4", bwVar.getBaijiahaoData().oriUgcNid);
            return a2;
        }
        return a2;
    }

    public static aq d(bw bwVar, String str) {
        aq aqVar;
        if (bwVar == null) {
            return null;
        }
        if (bwVar.getType() == bw.epH) {
            aq a2 = a("c13637", bwVar, str);
            if (bwVar.getBaijiahaoData() != null) {
                a2.dK("obj_param6", bwVar.getBaijiahaoData().oriUgcVid);
            }
            if (bwVar.erW > 0) {
                a2.aj("midpageflag", 1);
                aqVar = a2;
            } else {
                a2.aj("midpageflag", 0);
                aqVar = a2;
            }
        } else {
            aq a3 = a("c13631", bwVar, str);
            a3.aj("obj_type", bwVar.bjn());
            a3.aj("is_full", bwVar.bjX() ? 1 : 0);
            aqVar = a3;
        }
        aqVar.u("uid", TbadkApplication.getCurrentAccountId());
        aqVar.aj("obj_locate", bwVar.ens);
        aqVar.u(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        aqVar.aj("obj_param5", v(bwVar));
        if (bwVar.getBaijiahaoData() != null) {
            aqVar.dK("obj_param4", bwVar.getBaijiahaoData().oriUgcNid);
            return aqVar;
        }
        return aqVar;
    }

    public static aq e(bw bwVar, String str) {
        if (bwVar == null) {
            return null;
        }
        aq a2 = a("c13632", bwVar, str);
        a2.u("uid", TbadkApplication.getCurrentAccountId());
        a2.aj("obj_locate", bwVar.ens);
        a2.u(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.aj("obj_param5", v(bwVar));
        a2.aj("obj_type", bwVar.bjn());
        if (bwVar.getBaijiahaoData() != null) {
            a2.dK("obj_param4", bwVar.getBaijiahaoData().oriUgcNid);
        }
        a2.aj("is_full", bwVar.bjX() ? 1 : 0);
        return a2;
    }

    public static aq f(bw bwVar, String str) {
        if (bwVar == null) {
            return null;
        }
        aq a2 = a("c13638", bwVar, str);
        a2.u("uid", TbadkApplication.getCurrentAccountId());
        a2.aj("obj_locate", bwVar.ens);
        a2.u(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.aj("obj_param5", v(bwVar));
        if (bwVar.getBaijiahaoData() != null) {
            a2.dK("obj_param4", bwVar.getBaijiahaoData().oriUgcNid);
            a2.dK("obj_param6", bwVar.getBaijiahaoData().oriUgcVid);
            return a2;
        }
        return a2;
    }

    public static aq g(bw bwVar, String str) {
        aq a2;
        if (bwVar == null) {
            return null;
        }
        if (bwVar.getType() == bw.epH) {
            a2 = a("c13639", bwVar, str);
            a2.aj("obj_type", 1);
            if (bwVar.getBaijiahaoData() != null) {
                a2.dK("obj_param6", bwVar.getBaijiahaoData().oriUgcVid);
            }
        } else {
            a2 = a("c13634", bwVar, str);
            a2.aj("obj_type", bwVar.bjn());
        }
        a2.u("uid", TbadkApplication.getCurrentAccountId());
        a2.aj("obj_locate", bwVar.ens);
        a2.u(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.aj("obj_param5", v(bwVar));
        if (bwVar.getBaijiahaoData() != null) {
            a2.dK("obj_param4", bwVar.getBaijiahaoData().oriUgcNid);
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
            aqVar.aj(TiebaInitialize.Params.OBJ_PARAM2, 2);
        } else {
            aqVar = new aq("c13635");
            aqVar.aj(TiebaInitialize.Params.OBJ_PARAM2, 1);
        }
        aqVar.u("uid", TbadkApplication.getCurrentAccountId());
        aqVar.dK("tid", arVar.getTid());
        aqVar.dK("fid", arVar.getFid());
        aqVar.dK("resource_id", str);
        return aqVar;
    }
}
