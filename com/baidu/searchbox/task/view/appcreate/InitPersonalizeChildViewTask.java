package com.baidu.searchbox.task.view.appcreate;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.card.view.ForumEnterLayout;
import com.baidu.card.view.MultiImgLayout;
import com.baidu.card.view.MutiImgMutiPicLayout;
import com.baidu.card.view.MutiImgSingleVerticalLayout;
import com.baidu.card.view.MutiImgTextLayout;
import com.baidu.card.view.NewGridImageLayout;
import com.baidu.card.view.RecommendInfoLayout;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.core.view.MultiLinkCardView;
import com.baidu.tbadk.core.view.SingleLinkCardView;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.secondfloor.AlaRecommendLayout;
/* loaded from: classes4.dex */
public class InitPersonalizeChildViewTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "InitPersonalizeChildView";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return 1;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        try {
            TbadkCoreApplication.getInst().getPersonalizeViewData().a = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.extend_forum_item, (ViewGroup) null);
            TbadkCoreApplication.getInst().getPersonalizeViewData().b = new AlaRecommendLayout(TbadkCoreApplication.getInst());
            TbadkCoreApplication.getInst().getPersonalizeViewData().c = new CardUserInfoLayout(TbadkCoreApplication.getInst());
            TbadkCoreApplication.getInst().getPersonalizeViewData().d = new ForumEnterLayout(TbadkCoreApplication.getInst());
            TbadkCoreApplication.getInst().getPersonalizeViewData().e = new CardForumHeadLayout(TbadkCoreApplication.getInst());
            TbadkCoreApplication.getInst().getPersonalizeViewData().f = new MultiImgLayout(TbadkCoreApplication.getInst());
            TbadkCoreApplication.getInst().getPersonalizeViewData().g = new MutiImgTextLayout(TbadkCoreApplication.getInst());
            TbadkCoreApplication.getInst().getPersonalizeViewData().h = new MutiImgSingleVerticalLayout(TbadkCoreApplication.getInst());
            TbadkCoreApplication.getInst().getPersonalizeViewData().i = new MutiImgMutiPicLayout(TbadkCoreApplication.getInst());
            TbadkCoreApplication.getInst().getPersonalizeViewData().j = new NewGridImageLayout(TbadkCoreApplication.getInst());
            TbadkCoreApplication.getInst().getPersonalizeViewData().k = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            TbadkCoreApplication.getInst().getPersonalizeViewData().l = new ItemCardView(TbadkCoreApplication.getInst());
            TbadkCoreApplication.getInst().getPersonalizeViewData().m = new SingleLinkCardView(TbadkCoreApplication.getInst());
            TbadkCoreApplication.getInst().getPersonalizeViewData().n = new MultiLinkCardView(TbadkCoreApplication.getInst());
            TbadkCoreApplication.getInst().getPersonalizeViewData().o = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.card_link_layout, (ViewGroup) null, true);
            TbadkCoreApplication.getInst().getPersonalizeViewData().p = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
            TbadkCoreApplication.getInst().getPersonalizeViewData().q = new ThreadGodReplyLayout(TbadkCoreApplication.getInst());
            TbadkCoreApplication.getInst().getPersonalizeViewData().r = new ThreadCardBottomOpSegmentLayout(TbadkCoreApplication.getInst());
            TbadkCoreApplication.getInst().getPersonalizeViewData().s = new RecommendInfoLayout(TbadkCoreApplication.getInst());
        } catch (Exception e) {
            BdLog.e(e);
        }
    }
}
