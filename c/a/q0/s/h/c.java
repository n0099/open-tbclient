package c.a.q0.s.h;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.u3.f;
import c.a.r0.u3.g;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.data.IconStampData;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NewUserRewardDialogView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewUserRewardDialogView f13860e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.r.t.a f13861f;

        public a(NewUserRewardDialogView newUserRewardDialogView, c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newUserRewardDialogView, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13860e = newUserRewardDialogView;
            this.f13861f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f13860e.onDestroy();
                this.f13861f.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f13862e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.r.t.a f13863f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f13864g;

        public b(TbPageContext tbPageContext, c.a.q0.r.t.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13862e = tbPageContext;
            this.f13863f = aVar;
            this.f13864g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager.getInstance().dealOneLink(this.f13862e, new String[]{"https://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&user_id=" + TbadkCoreApplication.getCurrentAccount()});
                this.f13863f.dismiss();
                c.d(this.f13864g);
            }
        }
    }

    /* renamed from: c.a.q0.s.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class View$OnClickListenerC0889c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PostWriteCallBackData f13865e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f13866f;

        public View$OnClickListenerC0889c(PostWriteCallBackData postWriteCallBackData, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postWriteCallBackData, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13865e = postWriteCallBackData;
            this.f13866f = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                g gVar = new g();
                PostWriteCallBackData postWriteCallBackData = this.f13865e;
                if (postWriteCallBackData != null) {
                    IconStampData iconStampData = postWriteCallBackData.getIconStampData();
                    gVar.f(iconStampData.stampType);
                    gVar.h(iconStampData.stampTitle);
                }
                new f(this.f13866f.getPageActivity(), gVar).a();
                c.f();
            }
        }
    }

    public static void c(TbPageContext tbPageContext, PostWriteCallBackData postWriteCallBackData, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65538, null, tbPageContext, postWriteCallBackData, i2) == null) && postWriteCallBackData != null && c.a.q0.s.h.b.a(postWriteCallBackData.getIconStampData())) {
            NewUserRewardDialogView newUserRewardDialogView = new NewUserRewardDialogView(tbPageContext.getPageActivity());
            newUserRewardDialogView.setData(postWriteCallBackData.getIconStampData());
            c.a.q0.r.t.a aVar = new c.a.q0.r.t.a(tbPageContext.getPageActivity());
            aVar.setContentViewSize(5);
            aVar.setContentView(newUserRewardDialogView);
            aVar.setCanceledOnTouchOutside(false);
            aVar.setAnimRes(R.style.picker_view_scale_anim);
            aVar.create(tbPageContext).show();
            newUserRewardDialogView.setCloseListener(new a(newUserRewardDialogView, aVar));
            newUserRewardDialogView.getNewsUserDialogLookView().setOnClickListener(new b(tbPageContext, aVar, i2));
            newUserRewardDialogView.getNewUserDialogShareView().setOnClickListener(new View$OnClickListenerC0889c(postWriteCallBackData, tbPageContext));
            e(i2);
        }
    }

    public static void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i2) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STAMP_SHARE_DIALOG).param("obj_type", 2).param("obj_source", 2).param("obj_locate", i2));
        }
    }

    public static void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STAMP_SHARE_DIALOG).param("obj_type", 1).param("obj_source", 2).param("obj_locate", i2));
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK).param("obj_locate", 31));
        }
    }
}
