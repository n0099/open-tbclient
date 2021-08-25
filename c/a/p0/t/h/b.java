package c.a.p0.t.h;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NewUserRewardDialogView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewUserRewardDialogView f14924e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.s.s.a f14925f;

        public a(NewUserRewardDialogView newUserRewardDialogView, c.a.p0.s.s.a aVar) {
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
            this.f14924e = newUserRewardDialogView;
            this.f14925f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f14924e.onDestroy();
                this.f14925f.dismiss();
            }
        }
    }

    public static void a(TbPageContext tbPageContext, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, tbPageContext, postWriteCallBackData) == null) {
            NewUserRewardDialogView newUserRewardDialogView = new NewUserRewardDialogView(tbPageContext.getPageActivity());
            newUserRewardDialogView.setData(postWriteCallBackData.getIconStampData());
            c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(tbPageContext.getPageActivity());
            aVar.setContentViewSize(5);
            aVar.setContentView(newUserRewardDialogView);
            aVar.setCanceledOnTouchOutside(false);
            aVar.setAnimRes(R.style.picker_view_scale_anim);
            aVar.create(tbPageContext).show();
            newUserRewardDialogView.setCloseListener(new a(newUserRewardDialogView, aVar));
        }
    }
}
