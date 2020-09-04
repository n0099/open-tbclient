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
/* loaded from: classes15.dex */
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
            aq dD = new aq("c13271").ai("obj_type", cVar.dWT).ai("obj_locate", cVar.dWU).ai("obj_id", cVar.dWV).ai("obj_name", i).dD("post_id", agreeData.postId).dD("nid", agreeData.nid);
            if (bwVar != null) {
                dD.dD("tid", bwVar.getId()).dD("nid", bwVar.getNid()).u("fid", bwVar.getFid()).dD("ab_tag", bwVar.mRecomAbTag).dD(IntentConfig.RECOM_SOURCE, bwVar.mRecomSource).dD("weight", bwVar.mRecomWeight).dD("extra", bwVar.mRecomExtra);
                if (bwVar.getBaijiahaoData() != null) {
                    dD.dD("obj_param4", bwVar.getBaijiahaoData().oriUgcNid);
                    if (bwVar.bdn() || bwVar.bgA()) {
                        dD.dD("obj_param6", bwVar.getBaijiahaoData().oriUgcVid);
                    }
                }
                if (bwVar.bgy()) {
                    dD.ai("obj_param5", 2);
                } else if (bwVar.bdm() || bwVar.bdn()) {
                    dD.ai("obj_param5", 3);
                } else if (bwVar.threadType == 0 || bwVar.threadType == 40) {
                    dD.ai("obj_param5", 1);
                }
            } else {
                dD.dD("tid", agreeData.threadId);
                dD.dD("nid", agreeData.nid);
                dD.dD("fid", agreeData.forumId);
                dD.ai(IntentConfig.CARD_TYPE, agreeData.cardType);
                dD.dD("ab_tag", agreeData.recomAbTag);
                dD.dD(IntentConfig.RECOM_SOURCE, agreeData.recomSource);
                dD.dD("weight", agreeData.recomWeight);
                dD.dD("extra", agreeData.recomExtra);
                if (agreeData.baijiahaoData != null) {
                    dD.dD("obj_param6", agreeData.baijiahaoData.oriUgcVid);
                }
            }
            if (context != null) {
                com.baidu.tbadk.pageInfo.c.a(context, dD);
            }
            TiebaStatic.log(dD);
        }
    }
}
