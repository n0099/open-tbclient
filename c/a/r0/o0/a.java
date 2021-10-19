package c.a.r0.o0;

import android.view.View;
import c.a.q0.s.q.d2;
import c.a.r0.b0.u;
import com.baidu.tbadk.core.util.FeedTabCardStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(View view, c.a.q0.s.q.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65536, null, view, aVar, str) == null) || aVar == null || aVar.getThreadData() == null) {
            return;
        }
        d2 threadData = aVar.getThreadData();
        if (threadData.E2()) {
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadVideoAreaStatisticLog(threadData, str));
            return;
        }
        int id = view.getId();
        if (view.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
            if (id == R.id.user_avatar) {
                TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadPotraitStatisticLog(threadData, str));
                return;
            } else if (id == R.id.user_name) {
                TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadPotraitStatisticLog(threadData, str));
                return;
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadEnterForumStatisticLog(threadData, str));
                return;
            } else if (id == R.id.thread_info_commont_container) {
                TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadTitleStatisticLog(threadData, str));
                return;
            } else if (view instanceof TbImageView) {
                TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadBigPictureStatisticLog(threadData, str));
                return;
            } else {
                return;
            }
        }
        TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadTitleStatisticLog(threadData, str));
    }

    public static void b(c.a.q0.s.q.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, aVar, str) == null) || aVar == null || aVar.getThreadData() == null) {
            return;
        }
        if (aVar.getThreadData().E2()) {
            u.b().a(FeedTabCardStatisticHelper.showVideoThreadStatisticLog(aVar.getThreadData(), str));
        } else {
            u.b().a(FeedTabCardStatisticHelper.showPictureTextThreadStatisticLog(aVar.getThreadData(), str));
        }
    }
}
