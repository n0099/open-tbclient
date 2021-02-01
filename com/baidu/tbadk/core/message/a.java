package com.baidu.tbadk.core.message;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tbadk.mutiprocess.f;
import com.baidu.tbadk.mutiprocess.g;
import com.baidu.tbadk.pageInfo.c;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.e;
/* loaded from: classes.dex */
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

    public void a(Context context, com.baidu.tbadk.core.data.e eVar, AgreeData agreeData, cb cbVar) {
        if (eVar != null && agreeData != null) {
            int i = 0;
            if (agreeData.baijiahaoData != null) {
                i = agreeData.baijiahaoData.oriUgcType;
            }
            ar dR = new ar("c13271").ap("obj_type", eVar.eMf).ap("obj_locate", eVar.eMg).ap("obj_id", eVar.eMh).ap("obj_name", i).dR("post_id", agreeData.postId).dR(IntentConfig.NID, agreeData.nid);
            if (cbVar != null) {
                dR.dR("tid", cbVar.getId()).dR(IntentConfig.NID, cbVar.bmo()).v("fid", cbVar.getFid()).dR("ab_tag", cbVar.mRecomAbTag).dR(IntentConfig.RECOM_SOURCE, cbVar.mRecomSource).dR("weight", cbVar.mRecomWeight).dR("extra", cbVar.mRecomExtra);
                if (cbVar.getBaijiahaoData() != null) {
                    dR.dR("obj_param4", cbVar.getBaijiahaoData().oriUgcNid);
                    if (cbVar.bmy() || cbVar.bpO()) {
                        dR.dR("obj_param6", cbVar.getBaijiahaoData().oriUgcVid);
                    }
                }
                if (cbVar.bpM()) {
                    dR.ap("obj_param5", 2);
                } else if (cbVar.bmx() || cbVar.bmy()) {
                    dR.ap("obj_param5", 3);
                } else if (cbVar.threadType == 0 || cbVar.threadType == 40) {
                    dR.ap("obj_param5", 1);
                }
            } else {
                dR.dR("tid", agreeData.threadId);
                dR.dR(IntentConfig.NID, agreeData.nid);
                dR.dR("fid", agreeData.forumId);
                dR.ap(IntentConfig.CARD_TYPE, agreeData.cardType);
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
