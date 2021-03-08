package com.baidu.tbadk.core.util;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.cb;
/* loaded from: classes.dex */
public class m {
    private static ar a(String str, cb cbVar, String str2) {
        if (cbVar == null) {
            return null;
        }
        ar arVar = new ar(str);
        arVar.dR("tid", cbVar.getTid());
        arVar.v("fid", cbVar.getFid());
        arVar.dR("resource_id", str2);
        return arVar;
    }

    private static int v(cb cbVar) {
        if (cbVar.getType() == cb.eRY || cbVar.bpQ()) {
            return 2;
        }
        if (cbVar.bmz() || cbVar.bmA()) {
            return 3;
        }
        return 1;
    }

    public static ar a(cb cbVar, String str) {
        if (cbVar == null) {
            return null;
        }
        ar a2 = a("c13629", cbVar, str);
        a2.v("uid", TbadkApplication.getCurrentAccountId());
        a2.aq("obj_locate", cbVar.ePT);
        a2.aq("obj_source", cbVar.threadType);
        a2.v(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.aq("obj_param5", v(cbVar));
        a2.aq("obj_type", cbVar.boZ());
        if (cbVar.bpx() != null) {
            a2.aq("obj_name", cbVar.bpx().nzX ? 1 : 0);
        }
        if (cbVar.getBaijiahaoData() != null) {
            a2.dR("obj_param4", cbVar.getBaijiahaoData().oriUgcNid);
        }
        if (cbVar.bnS() != null) {
            a2.aq(TiebaInitialize.Params.AB_TYPE, cbVar.bnS().getIsLike() ? 1 : 0);
        }
        a2.aq("is_full", cbVar.bpK() ? 1 : 0);
        return a2;
    }

    public static ar b(cb cbVar, String str) {
        if (cbVar == null) {
            return null;
        }
        ar a2 = a("c13628", cbVar, str);
        a2.aq("obj_locate", cbVar.ePT);
        a2.aq("obj_source", cbVar.threadType);
        a2.v(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.aq("obj_param5", v(cbVar));
        a2.dR("obj_name", cbVar.mRecomAbTag);
        if (cbVar.getBaijiahaoData() != null) {
            a2.dR("obj_param4", cbVar.getBaijiahaoData().oriUgcNid);
            a2.dR("obj_param6", cbVar.getBaijiahaoData().oriUgcVid);
        }
        if (cbVar.eUB > 0) {
            a2.aq("midpageflag", 1);
        } else {
            a2.aq("midpageflag", 0);
        }
        if (cbVar.bnS() != null) {
            a2.aq(TiebaInitialize.Params.AB_TYPE, cbVar.bnS().getIsLike() ? 1 : 0);
        }
        return a2;
    }

    public static ar c(cb cbVar, String str) {
        ar a2;
        if (cbVar == null) {
            return null;
        }
        if (cbVar.getType() == cb.eSl) {
            a2 = a("c13636", cbVar, str);
            if (cbVar.getBaijiahaoData() != null) {
                a2.dR("obj_param6", cbVar.getBaijiahaoData().oriUgcVid);
            }
        } else {
            a2 = a("c13633", cbVar, str);
            a2.aq("obj_type", cbVar.boZ());
        }
        a2.v("uid", TbadkApplication.getCurrentAccountId());
        a2.aq("obj_locate", cbVar.ePT);
        a2.v(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.aq("obj_param5", v(cbVar));
        if (cbVar.getBaijiahaoData() != null) {
            a2.dR("obj_param4", cbVar.getBaijiahaoData().oriUgcNid);
            return a2;
        }
        return a2;
    }

    public static ar d(cb cbVar, String str) {
        ar arVar;
        if (cbVar == null) {
            return null;
        }
        if (cbVar.getType() == cb.eSl) {
            ar a2 = a("c13637", cbVar, str);
            if (cbVar.getBaijiahaoData() != null) {
                a2.dR("obj_param6", cbVar.getBaijiahaoData().oriUgcVid);
            }
            if (cbVar.eUB > 0) {
                a2.aq("midpageflag", 1);
                arVar = a2;
            } else {
                a2.aq("midpageflag", 0);
                arVar = a2;
            }
        } else {
            ar a3 = a("c13631", cbVar, str);
            a3.aq("obj_type", cbVar.boZ());
            a3.aq("is_full", cbVar.bpK() ? 1 : 0);
            arVar = a3;
        }
        arVar.v("uid", TbadkApplication.getCurrentAccountId());
        arVar.aq("obj_locate", cbVar.ePT);
        arVar.v(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        arVar.aq("obj_param5", v(cbVar));
        if (cbVar.getBaijiahaoData() != null) {
            arVar.dR("obj_param4", cbVar.getBaijiahaoData().oriUgcNid);
            return arVar;
        }
        return arVar;
    }

    public static ar e(cb cbVar, String str) {
        if (cbVar == null) {
            return null;
        }
        ar a2 = a("c13632", cbVar, str);
        a2.v("uid", TbadkApplication.getCurrentAccountId());
        a2.aq("obj_locate", cbVar.ePT);
        a2.v(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.aq("obj_param5", v(cbVar));
        a2.aq("obj_type", cbVar.boZ());
        if (cbVar.getBaijiahaoData() != null) {
            a2.dR("obj_param4", cbVar.getBaijiahaoData().oriUgcNid);
        }
        a2.aq("is_full", cbVar.bpK() ? 1 : 0);
        return a2;
    }

    public static ar f(cb cbVar, String str) {
        if (cbVar == null) {
            return null;
        }
        ar a2 = a("c13638", cbVar, str);
        a2.v("uid", TbadkApplication.getCurrentAccountId());
        a2.aq("obj_locate", cbVar.ePT);
        a2.v(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.aq("obj_param5", v(cbVar));
        if (cbVar.getBaijiahaoData() != null) {
            a2.dR("obj_param4", cbVar.getBaijiahaoData().oriUgcNid);
            a2.dR("obj_param6", cbVar.getBaijiahaoData().oriUgcVid);
            return a2;
        }
        return a2;
    }

    public static ar g(cb cbVar, String str) {
        ar a2;
        if (cbVar == null) {
            return null;
        }
        if (cbVar.getType() == cb.eSl) {
            a2 = a("c13639", cbVar, str);
            a2.aq("obj_type", 1);
            if (cbVar.getBaijiahaoData() != null) {
                a2.dR("obj_param6", cbVar.getBaijiahaoData().oriUgcVid);
            }
        } else {
            a2 = a("c13634", cbVar, str);
            a2.aq("obj_type", cbVar.boZ());
        }
        a2.v("uid", TbadkApplication.getCurrentAccountId());
        a2.aq("obj_locate", cbVar.ePT);
        a2.v(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.aq("obj_param5", v(cbVar));
        if (cbVar.getBaijiahaoData() != null) {
            a2.dR("obj_param4", cbVar.getBaijiahaoData().oriUgcNid);
            return a2;
        }
        return a2;
    }

    public static ar a(com.baidu.tbadk.core.data.av avVar, String str) {
        ar arVar;
        if (avVar == null) {
            return null;
        }
        if (avVar.cardType == 2 || avVar.cardType == 6 || avVar.cardType == 8) {
            arVar = new ar("c13640");
            arVar.aq(TiebaInitialize.Params.OBJ_PARAM2, 2);
        } else {
            arVar = new ar("c13635");
            arVar.aq(TiebaInitialize.Params.OBJ_PARAM2, 1);
        }
        arVar.v("uid", TbadkApplication.getCurrentAccountId());
        arVar.dR("tid", avVar.getTid());
        arVar.dR("fid", avVar.getFid());
        arVar.dR("resource_id", str);
        return arVar;
    }
}
