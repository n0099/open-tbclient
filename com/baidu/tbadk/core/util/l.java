package com.baidu.tbadk.core.util;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.bz;
/* loaded from: classes.dex */
public class l {
    private static aq a(String str, bz bzVar, String str2) {
        if (bzVar == null) {
            return null;
        }
        aq aqVar = new aq(str);
        aqVar.dW("tid", bzVar.getTid());
        aqVar.w("fid", bzVar.getFid());
        aqVar.dW("resource_id", str2);
        return aqVar;
    }

    private static int v(bz bzVar) {
        if (bzVar.getType() == bz.eOl || bzVar.bpw()) {
            return 2;
        }
        if (bzVar.bme() || bzVar.bmf()) {
            return 3;
        }
        return 1;
    }

    public static aq a(bz bzVar, String str) {
        if (bzVar == null) {
            return null;
        }
        aq a2 = a("c13629", bzVar, str);
        a2.w("uid", TbadkApplication.getCurrentAccountId());
        a2.an("obj_locate", bzVar.eMg);
        a2.an("obj_source", bzVar.threadType);
        a2.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.an("obj_param5", v(bzVar));
        a2.an("obj_type", bzVar.boF());
        if (bzVar.bpd() != null) {
            a2.an("obj_name", bzVar.bpd().nnH ? 1 : 0);
        }
        if (bzVar.getBaijiahaoData() != null) {
            a2.dW("obj_param4", bzVar.getBaijiahaoData().oriUgcNid);
        }
        if (bzVar.bnx() != null) {
            a2.an(TiebaInitialize.Params.AB_TYPE, bzVar.bnx().getIsLike() ? 1 : 0);
        }
        a2.an("is_full", bzVar.bpq() ? 1 : 0);
        return a2;
    }

    public static aq b(bz bzVar, String str) {
        if (bzVar == null) {
            return null;
        }
        aq a2 = a("c13628", bzVar, str);
        a2.an("obj_locate", bzVar.eMg);
        a2.an("obj_source", bzVar.threadType);
        a2.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.an("obj_param5", v(bzVar));
        a2.dW("obj_name", bzVar.mRecomAbTag);
        if (bzVar.getBaijiahaoData() != null) {
            a2.dW("obj_param4", bzVar.getBaijiahaoData().oriUgcNid);
            a2.dW("obj_param6", bzVar.getBaijiahaoData().oriUgcVid);
        }
        if (bzVar.eQO > 0) {
            a2.an("midpageflag", 1);
        } else {
            a2.an("midpageflag", 0);
        }
        if (bzVar.bnx() != null) {
            a2.an(TiebaInitialize.Params.AB_TYPE, bzVar.bnx().getIsLike() ? 1 : 0);
        }
        return a2;
    }

    public static aq c(bz bzVar, String str) {
        aq a2;
        if (bzVar == null) {
            return null;
        }
        if (bzVar.getType() == bz.eOy) {
            a2 = a("c13636", bzVar, str);
            if (bzVar.getBaijiahaoData() != null) {
                a2.dW("obj_param6", bzVar.getBaijiahaoData().oriUgcVid);
            }
        } else {
            a2 = a("c13633", bzVar, str);
            a2.an("obj_type", bzVar.boF());
        }
        a2.w("uid", TbadkApplication.getCurrentAccountId());
        a2.an("obj_locate", bzVar.eMg);
        a2.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.an("obj_param5", v(bzVar));
        if (bzVar.getBaijiahaoData() != null) {
            a2.dW("obj_param4", bzVar.getBaijiahaoData().oriUgcNid);
            return a2;
        }
        return a2;
    }

    public static aq d(bz bzVar, String str) {
        aq aqVar;
        if (bzVar == null) {
            return null;
        }
        if (bzVar.getType() == bz.eOy) {
            aq a2 = a("c13637", bzVar, str);
            if (bzVar.getBaijiahaoData() != null) {
                a2.dW("obj_param6", bzVar.getBaijiahaoData().oriUgcVid);
            }
            if (bzVar.eQO > 0) {
                a2.an("midpageflag", 1);
                aqVar = a2;
            } else {
                a2.an("midpageflag", 0);
                aqVar = a2;
            }
        } else {
            aq a3 = a("c13631", bzVar, str);
            a3.an("obj_type", bzVar.boF());
            a3.an("is_full", bzVar.bpq() ? 1 : 0);
            aqVar = a3;
        }
        aqVar.w("uid", TbadkApplication.getCurrentAccountId());
        aqVar.an("obj_locate", bzVar.eMg);
        aqVar.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        aqVar.an("obj_param5", v(bzVar));
        if (bzVar.getBaijiahaoData() != null) {
            aqVar.dW("obj_param4", bzVar.getBaijiahaoData().oriUgcNid);
            return aqVar;
        }
        return aqVar;
    }

    public static aq e(bz bzVar, String str) {
        if (bzVar == null) {
            return null;
        }
        aq a2 = a("c13632", bzVar, str);
        a2.w("uid", TbadkApplication.getCurrentAccountId());
        a2.an("obj_locate", bzVar.eMg);
        a2.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.an("obj_param5", v(bzVar));
        a2.an("obj_type", bzVar.boF());
        if (bzVar.getBaijiahaoData() != null) {
            a2.dW("obj_param4", bzVar.getBaijiahaoData().oriUgcNid);
        }
        a2.an("is_full", bzVar.bpq() ? 1 : 0);
        return a2;
    }

    public static aq f(bz bzVar, String str) {
        if (bzVar == null) {
            return null;
        }
        aq a2 = a("c13638", bzVar, str);
        a2.w("uid", TbadkApplication.getCurrentAccountId());
        a2.an("obj_locate", bzVar.eMg);
        a2.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.an("obj_param5", v(bzVar));
        if (bzVar.getBaijiahaoData() != null) {
            a2.dW("obj_param4", bzVar.getBaijiahaoData().oriUgcNid);
            a2.dW("obj_param6", bzVar.getBaijiahaoData().oriUgcVid);
            return a2;
        }
        return a2;
    }

    public static aq g(bz bzVar, String str) {
        aq a2;
        if (bzVar == null) {
            return null;
        }
        if (bzVar.getType() == bz.eOy) {
            a2 = a("c13639", bzVar, str);
            a2.an("obj_type", 1);
            if (bzVar.getBaijiahaoData() != null) {
                a2.dW("obj_param6", bzVar.getBaijiahaoData().oriUgcVid);
            }
        } else {
            a2 = a("c13634", bzVar, str);
            a2.an("obj_type", bzVar.boF());
        }
        a2.w("uid", TbadkApplication.getCurrentAccountId());
        a2.an("obj_locate", bzVar.eMg);
        a2.w(TiebaInitialize.Params.OBJ_PARAM3, System.currentTimeMillis());
        a2.an("obj_param5", v(bzVar));
        if (bzVar.getBaijiahaoData() != null) {
            a2.dW("obj_param4", bzVar.getBaijiahaoData().oriUgcNid);
            return a2;
        }
        return a2;
    }

    public static aq a(com.baidu.tbadk.core.data.at atVar, String str) {
        aq aqVar;
        if (atVar == null) {
            return null;
        }
        if (atVar.cardType == 2 || atVar.cardType == 6 || atVar.cardType == 8) {
            aqVar = new aq("c13640");
            aqVar.an(TiebaInitialize.Params.OBJ_PARAM2, 2);
        } else {
            aqVar = new aq("c13635");
            aqVar.an(TiebaInitialize.Params.OBJ_PARAM2, 1);
        }
        aqVar.w("uid", TbadkApplication.getCurrentAccountId());
        aqVar.dW("tid", atVar.getTid());
        aqVar.dW("fid", atVar.getFid());
        aqVar.dW("resource_id", str);
        return aqVar;
    }
}
