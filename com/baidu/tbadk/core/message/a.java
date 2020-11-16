package com.baidu.tbadk.core.message;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.d;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tbadk.mutiprocess.f;
import com.baidu.tbadk.mutiprocess.g;
import com.baidu.tbadk.pageInfo.c;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.e;
/* loaded from: classes20.dex */
public class a {
    public void a(AgreeData agreeData, int i, BdUniqueId bdUniqueId, boolean z) {
        if (agreeData != null) {
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("z_id", TbadkCoreApplication.getInst().getZid());
            httpMessage.addParam("thread_id", agreeData.threadId);
            httpMessage.addParam("op_type", i);
            if (agreeData.objType == 0) {
                agreeData.objType = 3;
            }
            httpMessage.addParam("obj_type", agreeData.objType);
            httpMessage.addParam("agree_type", agreeData.agreeType);
            httpMessage.addParam("forum_id", agreeData.forumId);
            if (!TextUtils.isEmpty(agreeData.postId)) {
                httpMessage.addParam("post_id", agreeData.postId);
            }
            if (agreeData.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", agreeData.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", agreeData.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", agreeData.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", agreeData.baijiahaoData.oriUgcType);
            }
            httpMessage.setTag(bdUniqueId);
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            if (z) {
                if (!TextUtils.isEmpty(f.getBduss())) {
                    httpMessage.addParam("BDUSS", f.getBduss());
                }
                if (!TextUtils.isEmpty(f.getTbs())) {
                    httpMessage.addParam("tbs", f.getTbs());
                }
                if (!TextUtils.isEmpty(f.getStoken())) {
                    httpMessage.addParam("stoken", f.getStoken());
                }
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void a(AgreeData agreeData, e eVar) {
        eVar.agreeData = agreeData;
        if (agreeData.isInThread) {
            if (agreeData.baijiahaoData != null) {
                agreeData.nid = agreeData.baijiahaoData.oriUgcNid;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            dispatchMutiProcessAgree(agreeData, AgreeEvent.IS_THREAD);
        } else if (agreeData.isInPost) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016530, eVar));
            dispatchMutiProcessAgree(agreeData, AgreeEvent.IS_POST);
        }
    }

    public void dispatchMutiProcessAgree(AgreeData agreeData, String str) {
        AgreeEvent agreeEvent = new AgreeEvent();
        agreeEvent.agreeData = agreeData;
        agreeEvent.agreeExtra = str;
        g.publishEvent(agreeEvent);
    }

    public void a(Context context, d dVar, AgreeData agreeData, bx bxVar) {
        if (dVar != null && agreeData != null) {
            int i = 0;
            if (agreeData.baijiahaoData != null) {
                i = agreeData.baijiahaoData.oriUgcType;
            }
            ar dR = new ar("c13271").ak("obj_type", dVar.exN).ak("obj_locate", dVar.exO).ak("obj_id", dVar.exP).ak("obj_name", i).dR("post_id", agreeData.postId).dR("nid", agreeData.nid);
            if (bxVar != null) {
                dR.dR("tid", bxVar.getId()).dR("nid", bxVar.getNid()).w("fid", bxVar.getFid()).dR("ab_tag", bxVar.mRecomAbTag).dR(IntentConfig.RECOM_SOURCE, bxVar.mRecomSource).dR("weight", bxVar.mRecomWeight).dR("extra", bxVar.mRecomExtra);
                if (bxVar.getBaijiahaoData() != null) {
                    dR.dR("obj_param4", bxVar.getBaijiahaoData().oriUgcNid);
                    if (bxVar.bkl() || bxVar.bnA()) {
                        dR.dR("obj_param6", bxVar.getBaijiahaoData().oriUgcVid);
                    }
                }
                if (bxVar.bny()) {
                    dR.ak("obj_param5", 2);
                } else if (bxVar.bkk() || bxVar.bkl()) {
                    dR.ak("obj_param5", 3);
                } else if (bxVar.threadType == 0 || bxVar.threadType == 40) {
                    dR.ak("obj_param5", 1);
                }
            } else {
                dR.dR("tid", agreeData.threadId);
                dR.dR("nid", agreeData.nid);
                dR.dR("fid", agreeData.forumId);
                dR.ak(IntentConfig.CARD_TYPE, agreeData.cardType);
                dR.dR("ab_tag", agreeData.recomAbTag);
                dR.dR(IntentConfig.RECOM_SOURCE, agreeData.recomSource);
                dR.dR("weight", agreeData.recomWeight);
                dR.dR("extra", agreeData.recomExtra);
                if (agreeData.baijiahaoData != null) {
                    dR.dR("obj_param6", agreeData.baijiahaoData.oriUgcVid);
                }
            }
            if (context != null) {
                c.a(context, dR);
            }
            TiebaStatic.log(dR);
        }
    }
}
