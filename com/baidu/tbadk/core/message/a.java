package com.baidu.tbadk.core.message;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.c;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
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
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
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

    public void a(Context context, c cVar, AgreeData agreeData, bv bvVar) {
        if (cVar != null && agreeData != null) {
            int i = 0;
            if (agreeData.baijiahaoData != null) {
                i = agreeData.baijiahaoData.oriUgcType;
            }
            ap dn = new ap("c13271").ah("obj_type", cVar.dNG).ah("obj_locate", cVar.dNH).ah("obj_id", cVar.dNI).ah("obj_name", i).dn("post_id", agreeData.postId).dn("nid", agreeData.nid);
            if (bvVar != null) {
                dn.dn("tid", bvVar.getId()).dn("nid", bvVar.getNid()).t("fid", bvVar.getFid()).dn("ab_tag", bvVar.mRecomAbTag).dn(IntentConfig.RECOM_SOURCE, bvVar.mRecomSource).dn("weight", bvVar.mRecomWeight).dn("extra", bvVar.mRecomExtra);
                if (bvVar.getBaijiahaoData() != null) {
                    dn.dn("obj_param4", bvVar.getBaijiahaoData().oriUgcNid);
                    if (bvVar.aUU() || bvVar.aYh()) {
                        dn.dn("obj_param6", bvVar.getBaijiahaoData().oriUgcVid);
                    }
                }
                if (bvVar.aYf()) {
                    dn.ah("obj_param5", 2);
                } else if (bvVar.aUT() || bvVar.aUU()) {
                    dn.ah("obj_param5", 3);
                } else if (bvVar.threadType == 0 || bvVar.threadType == 40) {
                    dn.ah("obj_param5", 1);
                }
            } else {
                dn.dn("tid", agreeData.threadId);
                dn.dn("nid", agreeData.nid);
                dn.dn("fid", agreeData.forumId);
                dn.ah(IntentConfig.CARD_TYPE, agreeData.cardType);
                dn.dn("ab_tag", agreeData.recomAbTag);
                dn.dn(IntentConfig.RECOM_SOURCE, agreeData.recomSource);
                dn.dn("weight", agreeData.recomWeight);
                dn.dn("extra", agreeData.recomExtra);
                if (agreeData.baijiahaoData != null) {
                    dn.dn("obj_param6", agreeData.baijiahaoData.oriUgcVid);
                }
            }
            if (context != null) {
                com.baidu.tbadk.pageInfo.c.a(context, dn);
            }
            TiebaStatic.log(dn);
        }
    }
}
