package com.baidu.tbadk.core.util;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes2.dex */
public class l {
    private static aq a(String str, bw bwVar, String str2) {
        if (bwVar == null) {
            return null;
        }
        aq aqVar = new aq(str);
        aqVar.dD("tid", bwVar.getTid());
        aqVar.u("fid", bwVar.getFid());
        aqVar.dD("resource_id", str2);
        return aqVar;
    }

    private static int u(bw bwVar) {
        if (bwVar.getType() == bw.ebc || bwVar.bgA()) {
            return 2;
        }
        if (bwVar.bdm() || bwVar.bdn()) {
            return 3;
        }
        return 1;
    }

    public static aq a(bw bwVar, String str) {
        if (bwVar == null) {
            return null;
        }
        aq a = a("c13629", bwVar, str);
        a.u("uid", TbadkApplication.getCurrentAccountId());
        a.ai("obj_locate", bwVar.dZb);
        a.ai("obj_source", bwVar.threadType);
        a.u(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.ai("obj_param5", u(bwVar));
        a.ai("obj_type", bwVar.bfK());
        if (bwVar.bgh() != null) {
            a.ai("obj_name", bwVar.bgh().mfH ? 1 : 0);
        }
        if (bwVar.getBaijiahaoData() != null) {
            a.dD("obj_param4", bwVar.getBaijiahaoData().oriUgcNid);
        }
        if (bwVar.beE() != null) {
            a.ai(TiebaInitialize.Params.AB_TYPE, bwVar.beE().getIsLike() ? 1 : 0);
        }
        a.ai("is_full", bwVar.bgu() ? 1 : 0);
        return a;
    }

    public static aq b(bw bwVar, String str) {
        if (bwVar == null) {
            return null;
        }
        aq a = a("c13628", bwVar, str);
        a.ai("obj_locate", bwVar.dZb);
        a.ai("obj_source", bwVar.threadType);
        a.u(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.ai("obj_param5", u(bwVar));
        a.dD("obj_name", bwVar.mRecomAbTag);
        if (bwVar.getBaijiahaoData() != null) {
            a.dD("obj_param4", bwVar.getBaijiahaoData().oriUgcNid);
            a.dD("obj_param6", bwVar.getBaijiahaoData().oriUgcVid);
        }
        if (bwVar.edC > 0) {
            a.ai("midpageflag", 1);
        } else {
            a.ai("midpageflag", 0);
        }
        if (bwVar.beE() != null) {
            a.ai(TiebaInitialize.Params.AB_TYPE, bwVar.beE().getIsLike() ? 1 : 0);
        }
        return a;
    }

    public static aq c(bw bwVar, String str) {
        aq a;
        if (bwVar == null) {
            return null;
        }
        if (bwVar.getType() == bw.ebo) {
            a = a("c13636", bwVar, str);
            if (bwVar.getBaijiahaoData() != null) {
                a.dD("obj_param6", bwVar.getBaijiahaoData().oriUgcVid);
            }
        } else {
            a = a("c13633", bwVar, str);
            a.ai("obj_type", bwVar.bfK());
        }
        a.u("uid", TbadkApplication.getCurrentAccountId());
        a.ai("obj_locate", bwVar.dZb);
        a.u(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.ai("obj_param5", u(bwVar));
        if (bwVar.getBaijiahaoData() != null) {
            a.dD("obj_param4", bwVar.getBaijiahaoData().oriUgcNid);
            return a;
        }
        return a;
    }

    public static aq d(bw bwVar, String str) {
        aq aqVar;
        if (bwVar == null) {
            return null;
        }
        if (bwVar.getType() == bw.ebo) {
            aq a = a("c13637", bwVar, str);
            if (bwVar.getBaijiahaoData() != null) {
                a.dD("obj_param6", bwVar.getBaijiahaoData().oriUgcVid);
            }
            if (bwVar.edC > 0) {
                a.ai("midpageflag", 1);
                aqVar = a;
            } else {
                a.ai("midpageflag", 0);
                aqVar = a;
            }
        } else {
            aq a2 = a("c13631", bwVar, str);
            a2.ai("obj_type", bwVar.bfK());
            a2.ai("is_full", bwVar.bgu() ? 1 : 0);
            aqVar = a2;
        }
        aqVar.u("uid", TbadkApplication.getCurrentAccountId());
        aqVar.ai("obj_locate", bwVar.dZb);
        aqVar.u(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        aqVar.ai("obj_param5", u(bwVar));
        if (bwVar.getBaijiahaoData() != null) {
            aqVar.dD("obj_param4", bwVar.getBaijiahaoData().oriUgcNid);
            return aqVar;
        }
        return aqVar;
    }

    public static aq e(bw bwVar, String str) {
        if (bwVar == null) {
            return null;
        }
        aq a = a("c13632", bwVar, str);
        a.u("uid", TbadkApplication.getCurrentAccountId());
        a.ai("obj_locate", bwVar.dZb);
        a.u(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.ai("obj_param5", u(bwVar));
        a.ai("obj_type", bwVar.bfK());
        if (bwVar.getBaijiahaoData() != null) {
            a.dD("obj_param4", bwVar.getBaijiahaoData().oriUgcNid);
        }
        a.ai("is_full", bwVar.bgu() ? 1 : 0);
        return a;
    }

    public static aq f(bw bwVar, String str) {
        if (bwVar == null) {
            return null;
        }
        aq a = a("c13638", bwVar, str);
        a.u("uid", TbadkApplication.getCurrentAccountId());
        a.ai("obj_locate", bwVar.dZb);
        a.u(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.ai("obj_param5", u(bwVar));
        if (bwVar.getBaijiahaoData() != null) {
            a.dD("obj_param4", bwVar.getBaijiahaoData().oriUgcNid);
            a.dD("obj_param6", bwVar.getBaijiahaoData().oriUgcVid);
            return a;
        }
        return a;
    }

    public static aq g(bw bwVar, String str) {
        aq a;
        if (bwVar == null) {
            return null;
        }
        if (bwVar.getType() == bw.ebo) {
            a = a("c13639", bwVar, str);
            a.ai("obj_type", 1);
            if (bwVar.getBaijiahaoData() != null) {
                a.dD("obj_param6", bwVar.getBaijiahaoData().oriUgcVid);
            }
        } else {
            a = a("c13634", bwVar, str);
            a.ai("obj_type", bwVar.bfK());
        }
        a.u("uid", TbadkApplication.getCurrentAccountId());
        a.ai("obj_locate", bwVar.dZb);
        a.u(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a.ai("obj_param5", u(bwVar));
        if (bwVar.getBaijiahaoData() != null) {
            a.dD("obj_param4", bwVar.getBaijiahaoData().oriUgcNid);
            return a;
        }
        return a;
    }

    public static aq a(com.baidu.tbadk.core.data.ar arVar, String str) {
        aq aqVar;
        if (arVar == null) {
            return null;
        }
        if (arVar.cardType == 2 || arVar.cardType == 6 || arVar.cardType == 8) {
            aqVar = new aq("c13640");
            aqVar.ai(TiebaInitialize.Params.OBJ_PARAM2, 2);
        } else {
            aqVar = new aq("c13635");
            aqVar.ai(TiebaInitialize.Params.OBJ_PARAM2, 1);
        }
        aqVar.u("uid", TbadkApplication.getCurrentAccountId());
        aqVar.dD("tid", arVar.getTid());
        aqVar.dD("fid", arVar.getFid());
        aqVar.dD("resource_id", str);
        return aqVar;
    }
}
