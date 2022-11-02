package com.baidu.searchbox.task.view.appcreate;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class InitPersonalizeChildViewTask extends LaunchTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "InitPersonalizeChildView" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public InitPersonalizeChildViewTask() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                TbadkCoreApplication.getInst().getPersonalizeViewData().a = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.obfuscated_res_0x7f0d027e, (ViewGroup) null);
                TbadkCoreApplication.getInst().getPersonalizeViewData().b = new AlaRecommendLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().c = new CardUserInfoLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().d = new ForumEnterLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().e = new CardForumHeadLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().f = new MultiImgLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().g = new MutiImgTextLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().h = new MutiImgSingleVerticalLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().i = new MutiImgMutiPicLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().j = new NewGridImageLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().k = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.obfuscated_res_0x7f0d01c4, (ViewGroup) null, true);
                TbadkCoreApplication.getInst().getPersonalizeViewData().l = new ItemCardView(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().m = new SingleLinkCardView(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().n = new MultiLinkCardView(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().o = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.obfuscated_res_0x7f0d01a6, (ViewGroup) null, true);
                TbadkCoreApplication.getInst().getPersonalizeViewData().p = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.obfuscated_res_0x7f0d01c0, (ViewGroup) null, false);
                TbadkCoreApplication.getInst().getPersonalizeViewData().q = new ThreadGodReplyLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().r = new ThreadCardBottomOpSegmentLayout(TbadkCoreApplication.getInst());
                TbadkCoreApplication.getInst().getPersonalizeViewData().s = new RecommendInfoLayout(TbadkCoreApplication.getInst());
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
