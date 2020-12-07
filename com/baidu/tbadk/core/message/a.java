package com.baidu.tbadk.core.message;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
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
            if (!StringUtil.isEmpty(agreeData.objSource)) {
                httpMessage.addParam("obj_source", agreeData.objSource);
            }
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

    public void a(Context context, d dVar, AgreeData agreeData, by byVar) {
        if (dVar != null && agreeData != null) {
            int i = 0;
            if (agreeData.baijiahaoData != null) {
                i = agreeData.baijiahaoData.oriUgcType;
            }
            ar dY = new ar("c13271").al("obj_type", dVar.eEO).al("obj_locate", dVar.eEP).al("obj_id", dVar.eEQ).al("obj_name", i).dY("post_id", agreeData.postId).dY("nid", agreeData.nid);
            if (byVar != null) {
                dY.dY("tid", byVar.getId()).dY("nid", byVar.getNid()).w("fid", byVar.getFid()).dY("ab_tag", byVar.mRecomAbTag).dY(IntentConfig.RECOM_SOURCE, byVar.mRecomSource).dY("weight", byVar.mRecomWeight).dY("extra", byVar.mRecomExtra);
                if (byVar.getBaijiahaoData() != null) {
                    dY.dY("obj_param4", byVar.getBaijiahaoData().oriUgcNid);
                    if (byVar.bny() || byVar.bqN()) {
                        dY.dY("obj_param6", byVar.getBaijiahaoData().oriUgcVid);
                    }
                }
                if (byVar.bqL()) {
                    dY.al("obj_param5", 2);
                } else if (byVar.bnx() || byVar.bny()) {
                    dY.al("obj_param5", 3);
                } else if (byVar.threadType == 0 || byVar.threadType == 40) {
                    dY.al("obj_param5", 1);
                }
            } else {
                dY.dY("tid", agreeData.threadId);
                dY.dY("nid", agreeData.nid);
                dY.dY("fid", agreeData.forumId);
                dY.al(IntentConfig.CARD_TYPE, agreeData.cardType);
                dY.dY("ab_tag", agreeData.recomAbTag);
                dY.dY(IntentConfig.RECOM_SOURCE, agreeData.recomSource);
                dY.dY("weight", agreeData.recomWeight);
                dY.dY("extra", agreeData.recomExtra);
                if (agreeData.baijiahaoData != null) {
                    dY.dY("obj_param6", agreeData.baijiahaoData.oriUgcVid);
                }
            }
            if (context != null) {
                c.a(context, dY);
            }
            TiebaStatic.log(dY);
        }
    }
}
