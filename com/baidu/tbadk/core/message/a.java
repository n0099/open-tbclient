package com.baidu.tbadk.core.message;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.c;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tbadk.mutiprocess.f;
import com.baidu.tbadk.mutiprocess.g;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.e;
/* loaded from: classes21.dex */
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

    public void a(Context context, c cVar, AgreeData agreeData, bw bwVar) {
        if (cVar != null && agreeData != null) {
            int i = 0;
            if (agreeData.baijiahaoData != null) {
                i = agreeData.baijiahaoData.oriUgcType;
            }
            aq dR = new aq("c13271").al("obj_type", cVar.ezy).al("obj_locate", cVar.ezz).al("obj_id", cVar.ezA).al("obj_name", i).dR("post_id", agreeData.postId).dR("nid", agreeData.nid);
            if (bwVar != null) {
                dR.dR("tid", bwVar.getId()).dR("nid", bwVar.getNid()).w("fid", bwVar.getFid()).dR("ab_tag", bwVar.mRecomAbTag).dR(IntentConfig.RECOM_SOURCE, bwVar.mRecomSource).dR("weight", bwVar.mRecomWeight).dR("extra", bwVar.mRecomExtra);
                if (bwVar.getBaijiahaoData() != null) {
                    dR.dR("obj_param4", bwVar.getBaijiahaoData().oriUgcNid);
                    if (bwVar.blj() || bwVar.bow()) {
                        dR.dR("obj_param6", bwVar.getBaijiahaoData().oriUgcVid);
                    }
                }
                if (bwVar.bou()) {
                    dR.al("obj_param5", 2);
                } else if (bwVar.bli() || bwVar.blj()) {
                    dR.al("obj_param5", 3);
                } else if (bwVar.threadType == 0 || bwVar.threadType == 40) {
                    dR.al("obj_param5", 1);
                }
            } else {
                dR.dR("tid", agreeData.threadId);
                dR.dR("nid", agreeData.nid);
                dR.dR("fid", agreeData.forumId);
                dR.al(IntentConfig.CARD_TYPE, agreeData.cardType);
                dR.dR("ab_tag", agreeData.recomAbTag);
                dR.dR(IntentConfig.RECOM_SOURCE, agreeData.recomSource);
                dR.dR("weight", agreeData.recomWeight);
                dR.dR("extra", agreeData.recomExtra);
                if (agreeData.baijiahaoData != null) {
                    dR.dR("obj_param6", agreeData.baijiahaoData.oriUgcVid);
                }
            }
            if (context != null) {
                com.baidu.tbadk.pageInfo.c.a(context, dR);
            }
            TiebaStatic.log(dR);
        }
    }
}
