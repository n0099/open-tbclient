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
        if (cbVar.getType() == cb.eQx || cbVar.bpO()) {
            return 2;
        }
        if (cbVar.bmx() || cbVar.bmy()) {
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
        a2.ap("obj_locate", cbVar.eOs);
        a2.ap("obj_source", cbVar.threadType);
        a2.v(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.ap("obj_param5", v(cbVar));
        a2.ap("obj_type", cbVar.boX());
        if (cbVar.bpv() != null) {
            a2.ap("obj_name", cbVar.bpv().nxs ? 1 : 0);
        }
        if (cbVar.getBaijiahaoData() != null) {
            a2.dR("obj_param4", cbVar.getBaijiahaoData().oriUgcNid);
        }
        if (cbVar.bnQ() != null) {
            a2.ap(TiebaInitialize.Params.AB_TYPE, cbVar.bnQ().getIsLike() ? 1 : 0);
        }
        a2.ap("is_full", cbVar.bpI() ? 1 : 0);
        return a2;
    }

    public static ar b(cb cbVar, String str) {
        if (cbVar == null) {
            return null;
        }
        ar a2 = a("c13628", cbVar, str);
        a2.ap("obj_locate", cbVar.eOs);
        a2.ap("obj_source", cbVar.threadType);
        a2.v(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.ap("obj_param5", v(cbVar));
        a2.dR("obj_name", cbVar.mRecomAbTag);
        if (cbVar.getBaijiahaoData() != null) {
            a2.dR("obj_param4", cbVar.getBaijiahaoData().oriUgcNid);
            a2.dR("obj_param6", cbVar.getBaijiahaoData().oriUgcVid);
        }
        if (cbVar.eTa > 0) {
            a2.ap("midpageflag", 1);
        } else {
            a2.ap("midpageflag", 0);
        }
        if (cbVar.bnQ() != null) {
            a2.ap(TiebaInitialize.Params.AB_TYPE, cbVar.bnQ().getIsLike() ? 1 : 0);
        }
        return a2;
    }

    public static ar c(cb cbVar, String str) {
        ar a2;
        if (cbVar == null) {
            return null;
        }
        if (cbVar.getType() == cb.eQK) {
            a2 = a("c13636", cbVar, str);
            if (cbVar.getBaijiahaoData() != null) {
                a2.dR("obj_param6", cbVar.getBaijiahaoData().oriUgcVid);
            }
        } else {
            a2 = a("c13633", cbVar, str);
            a2.ap("obj_type", cbVar.boX());
        }
        a2.v("uid", TbadkApplication.getCurrentAccountId());
        a2.ap("obj_locate", cbVar.eOs);
        a2.v(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.ap("obj_param5", v(cbVar));
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
        if (cbVar.getType() == cb.eQK) {
            ar a2 = a("c13637", cbVar, str);
            if (cbVar.getBaijiahaoData() != null) {
                a2.dR("obj_param6", cbVar.getBaijiahaoData().oriUgcVid);
            }
            if (cbVar.eTa > 0) {
                a2.ap("midpageflag", 1);
                arVar = a2;
            } else {
                a2.ap("midpageflag", 0);
                arVar = a2;
            }
        } else {
            ar a3 = a("c13631", cbVar, str);
            a3.ap("obj_type", cbVar.boX());
            a3.ap("is_full", cbVar.bpI() ? 1 : 0);
            arVar = a3;
        }
        arVar.v("uid", TbadkApplication.getCurrentAccountId());
        arVar.ap("obj_locate", cbVar.eOs);
        arVar.v(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        arVar.ap("obj_param5", v(cbVar));
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
        a2.ap("obj_locate", cbVar.eOs);
        a2.v(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.ap("obj_param5", v(cbVar));
        a2.ap("obj_type", cbVar.boX());
        if (cbVar.getBaijiahaoData() != null) {
            a2.dR("obj_param4", cbVar.getBaijiahaoData().oriUgcNid);
        }
        a2.ap("is_full", cbVar.bpI() ? 1 : 0);
        return a2;
    }

    public static ar f(cb cbVar, String str) {
        if (cbVar == null) {
            return null;
        }
        ar a2 = a("c13638", cbVar, str);
        a2.v("uid", TbadkApplication.getCurrentAccountId());
        a2.ap("obj_locate", cbVar.eOs);
        a2.v(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.ap("obj_param5", v(cbVar));
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
        if (cbVar.getType() == cb.eQK) {
            a2 = a("c13639", cbVar, str);
            a2.ap("obj_type", 1);
            if (cbVar.getBaijiahaoData() != null) {
                a2.dR("obj_param6", cbVar.getBaijiahaoData().oriUgcVid);
            }
        } else {
            a2 = a("c13634", cbVar, str);
            a2.ap("obj_type", cbVar.boX());
        }
        a2.v("uid", TbadkApplication.getCurrentAccountId());
        a2.ap("obj_locate", cbVar.eOs);
        a2.v(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.ap("obj_param5", v(cbVar));
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
            arVar.ap(TiebaInitialize.Params.OBJ_PARAM2, 2);
        } else {
            arVar = new ar("c13635");
            arVar.ap(TiebaInitialize.Params.OBJ_PARAM2, 1);
        }
        arVar.v("uid", TbadkApplication.getCurrentAccountId());
        arVar.dR("tid", avVar.getTid());
        arVar.dR("fid", avVar.getFid());
        arVar.dR("resource_id", str);
        return arVar;
    }
}
