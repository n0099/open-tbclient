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

    public void a(Context context, c cVar, AgreeData agreeData, bw bwVar) {
        if (cVar != null && agreeData != null) {
            int i = 0;
            if (agreeData.baijiahaoData != null) {
                i = agreeData.baijiahaoData.oriUgcType;
            }
            aq dF = new aq("c13271").ai("obj_type", cVar.dZd).ai("obj_locate", cVar.dZe).ai("obj_id", cVar.dZf).ai("obj_name", i).dF("post_id", agreeData.postId).dF("nid", agreeData.nid);
            if (bwVar != null) {
                dF.dF("tid", bwVar.getId()).dF("nid", bwVar.getNid()).u("fid", bwVar.getFid()).dF("ab_tag", bwVar.mRecomAbTag).dF(IntentConfig.RECOM_SOURCE, bwVar.mRecomSource).dF("weight", bwVar.mRecomWeight).dF("extra", bwVar.mRecomExtra);
                if (bwVar.getBaijiahaoData() != null) {
                    dF.dF("obj_param4", bwVar.getBaijiahaoData().oriUgcNid);
                    if (bwVar.beh() || bwVar.bhu()) {
                        dF.dF("obj_param6", bwVar.getBaijiahaoData().oriUgcVid);
                    }
                }
                if (bwVar.bhs()) {
                    dF.ai("obj_param5", 2);
                } else if (bwVar.beg() || bwVar.beh()) {
                    dF.ai("obj_param5", 3);
                } else if (bwVar.threadType == 0 || bwVar.threadType == 40) {
                    dF.ai("obj_param5", 1);
                }
            } else {
                dF.dF("tid", agreeData.threadId);
                dF.dF("nid", agreeData.nid);
                dF.dF("fid", agreeData.forumId);
                dF.ai(IntentConfig.CARD_TYPE, agreeData.cardType);
                dF.dF("ab_tag", agreeData.recomAbTag);
                dF.dF(IntentConfig.RECOM_SOURCE, agreeData.recomSource);
                dF.dF("weight", agreeData.recomWeight);
                dF.dF("extra", agreeData.recomExtra);
                if (agreeData.baijiahaoData != null) {
                    dF.dF("obj_param6", agreeData.baijiahaoData.oriUgcVid);
                }
            }
            if (context != null) {
                com.baidu.tbadk.pageInfo.c.a(context, dF);
            }
            TiebaStatic.log(dF);
        }
    }
}
