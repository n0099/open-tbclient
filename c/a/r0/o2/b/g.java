package c.a.r0.o2.b;

import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
/* loaded from: classes6.dex */
public class g extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewStub o;
    public View p;
    public TbImageView q;
    public TextView r;
    public TextView s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(TbPageContext tbPageContext, View view) {
        super(tbPageContext, view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.viewstub_user_name);
        this.o = viewStub;
        viewStub.inflate();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
        layoutParams.topMargin = l.i(tbPageContext.getPageActivity()) / 2;
        this.o.setLayoutParams(layoutParams);
        this.p = view.findViewById(R.id.user_info_layout);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.user_avatar);
        this.q = tbImageView;
        tbImageView.setIsRound(true);
        this.q.setDefaultBgResource(R.drawable.icon_default_avatar100_bg);
        this.r = (TextView) view.findViewById(R.id.user_name);
        this.s = (TextView) view.findViewById(R.id.user_subtitle);
    }

    @Override // c.a.r0.o2.b.b
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.a(i2);
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.p);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0204);
            c.a.q0.s.u.c d3 = c.a.q0.s.u.c.d(this.r);
            d3.v(R.color.CAM_X0105);
            d3.z(R.dimen.T_X05);
            d3.A(R.string.F_X02);
            c.a.q0.s.u.c d4 = c.a.q0.s.u.c.d(this.s);
            d4.v(R.color.CAM_X0108);
            d4.z(R.dimen.T_X08);
            d4.A(R.string.F_X01);
        }
    }

    @Override // c.a.r0.o2.b.b
    public void c(c cVar) {
        ShareStorage.StorageModel storageModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || cVar == null || (storageModel = (ShareStorage.StorageModel) new Gson().fromJson(cVar.f20893d, (Class<Object>) ShareStorage.StorageModel.class)) == null) {
            return;
        }
        this.q.startLoad(storageModel.url, 10, false);
        this.r.setText(storageModel.displayname);
        this.s.setText(this.a.getResources().getString(R.string.share_login_dialog_subtitle, storageModel.app));
    }
}
