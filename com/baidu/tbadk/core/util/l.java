package com.baidu.tbadk.core.util;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.by;
/* loaded from: classes.dex */
public class l {
    private static ar a(String str, by byVar, String str2) {
        if (byVar == null) {
            return null;
        }
        ar arVar = new ar(str);
        arVar.dY("tid", byVar.getTid());
        arVar.w("fid", byVar.getFid());
        arVar.dY("resource_id", str2);
        return arVar;
    }

    private static int v(by byVar) {
        if (byVar.getType() == by.eJd || byVar.bqN()) {
            return 2;
        }
        if (byVar.bnx() || byVar.bny()) {
            return 3;
        }
        return 1;
    }

    public static ar a(by byVar, String str) {
        if (byVar == null) {
            return null;
        }
        ar a2 = a("c13629", byVar, str);
        a2.w("uid", TbadkApplication.getCurrentAccountId());
        a2.al("obj_locate", byVar.eHa);
        a2.al("obj_source", byVar.threadType);
        a2.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.al("obj_param5", v(byVar));
        a2.al("obj_type", byVar.bpX());
        if (byVar.bqu() != null) {
            a2.al("obj_name", byVar.bqu().nmB ? 1 : 0);
        }
        if (byVar.getBaijiahaoData() != null) {
            a2.dY("obj_param4", byVar.getBaijiahaoData().oriUgcNid);
        }
        if (byVar.boP() != null) {
            a2.al(TiebaInitialize.Params.AB_TYPE, byVar.boP().getIsLike() ? 1 : 0);
        }
        a2.al("is_full", byVar.bqH() ? 1 : 0);
        return a2;
    }

    public static ar b(by byVar, String str) {
        if (byVar == null) {
            return null;
        }
        ar a2 = a("c13628", byVar, str);
        a2.al("obj_locate", byVar.eHa);
        a2.al("obj_source", byVar.threadType);
        a2.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.al("obj_param5", v(byVar));
        a2.dY("obj_name", byVar.mRecomAbTag);
        if (byVar.getBaijiahaoData() != null) {
            a2.dY("obj_param4", byVar.getBaijiahaoData().oriUgcNid);
            a2.dY("obj_param6", byVar.getBaijiahaoData().oriUgcVid);
        }
        if (byVar.eLF > 0) {
            a2.al("midpageflag", 1);
        } else {
            a2.al("midpageflag", 0);
        }
        if (byVar.boP() != null) {
            a2.al(TiebaInitialize.Params.AB_TYPE, byVar.boP().getIsLike() ? 1 : 0);
        }
        return a2;
    }

    public static ar c(by byVar, String str) {
        ar a2;
        if (byVar == null) {
            return null;
        }
        if (byVar.getType() == by.eJq) {
            a2 = a("c13636", byVar, str);
            if (byVar.getBaijiahaoData() != null) {
                a2.dY("obj_param6", byVar.getBaijiahaoData().oriUgcVid);
            }
        } else {
            a2 = a("c13633", byVar, str);
            a2.al("obj_type", byVar.bpX());
        }
        a2.w("uid", TbadkApplication.getCurrentAccountId());
        a2.al("obj_locate", byVar.eHa);
        a2.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.al("obj_param5", v(byVar));
        if (byVar.getBaijiahaoData() != null) {
            a2.dY("obj_param4", byVar.getBaijiahaoData().oriUgcNid);
            return a2;
        }
        return a2;
    }

    public static ar d(by byVar, String str) {
        ar arVar;
        if (byVar == null) {
            return null;
        }
        if (byVar.getType() == by.eJq) {
            ar a2 = a("c13637", byVar, str);
            if (byVar.getBaijiahaoData() != null) {
                a2.dY("obj_param6", byVar.getBaijiahaoData().oriUgcVid);
            }
            if (byVar.eLF > 0) {
                a2.al("midpageflag", 1);
                arVar = a2;
            } else {
                a2.al("midpageflag", 0);
                arVar = a2;
            }
        } else {
            ar a3 = a("c13631", byVar, str);
            a3.al("obj_type", byVar.bpX());
            a3.al("is_full", byVar.bqH() ? 1 : 0);
            arVar = a3;
        }
        arVar.w("uid", TbadkApplication.getCurrentAccountId());
        arVar.al("obj_locate", byVar.eHa);
        arVar.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        arVar.al("obj_param5", v(byVar));
        if (byVar.getBaijiahaoData() != null) {
            arVar.dY("obj_param4", byVar.getBaijiahaoData().oriUgcNid);
            return arVar;
        }
        return arVar;
    }

    public static ar e(by byVar, String str) {
        if (byVar == null) {
            return null;
        }
        ar a2 = a("c13632", byVar, str);
        a2.w("uid", TbadkApplication.getCurrentAccountId());
        a2.al("obj_locate", byVar.eHa);
        a2.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.al("obj_param5", v(byVar));
        a2.al("obj_type", byVar.bpX());
        if (byVar.getBaijiahaoData() != null) {
            a2.dY("obj_param4", byVar.getBaijiahaoData().oriUgcNid);
        }
        a2.al("is_full", byVar.bqH() ? 1 : 0);
        return a2;
    }

    public static ar f(by byVar, String str) {
        if (byVar == null) {
            return null;
        }
        ar a2 = a("c13638", byVar, str);
        a2.w("uid", TbadkApplication.getCurrentAccountId());
        a2.al("obj_locate", byVar.eHa);
        a2.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.al("obj_param5", v(byVar));
        if (byVar.getBaijiahaoData() != null) {
            a2.dY("obj_param4", byVar.getBaijiahaoData().oriUgcNid);
            a2.dY("obj_param6", byVar.getBaijiahaoData().oriUgcVid);
            return a2;
        }
        return a2;
    }

    public static ar g(by byVar, String str) {
        ar a2;
        if (byVar == null) {
            return null;
        }
        if (byVar.getType() == by.eJq) {
            a2 = a("c13639", byVar, str);
            a2.al("obj_type", 1);
            if (byVar.getBaijiahaoData() != null) {
                a2.dY("obj_param6", byVar.getBaijiahaoData().oriUgcVid);
            }
        } else {
            a2 = a("c13634", byVar, str);
            a2.al("obj_type", byVar.bpX());
        }
        a2.w("uid", TbadkApplication.getCurrentAccountId());
        a2.al("obj_locate", byVar.eHa);
        a2.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.al("obj_param5", v(byVar));
        if (byVar.getBaijiahaoData() != null) {
            a2.dY("obj_param4", byVar.getBaijiahaoData().oriUgcNid);
            return a2;
        }
        return a2;
    }

    public static ar a(com.baidu.tbadk.core.data.at atVar, String str) {
        ar arVar;
        if (atVar == null) {
            return null;
        }
        if (atVar.cardType == 2 || atVar.cardType == 6 || atVar.cardType == 8) {
            arVar = new ar("c13640");
            arVar.al(TiebaInitialize.Params.OBJ_PARAM2, 2);
        } else {
            arVar = new ar("c13635");
            arVar.al(TiebaInitialize.Params.OBJ_PARAM2, 1);
        }
        arVar.w("uid", TbadkApplication.getCurrentAccountId());
        arVar.dY("tid", atVar.getTid());
        arVar.dY("fid", atVar.getFid());
        arVar.dY("resource_id", str);
        return arVar;
    }
}
