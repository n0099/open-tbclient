package c.a.p0.u2.b;

import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
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
/* loaded from: classes2.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.obfuscated_res_0x7f0923ef);
        this.o = viewStub;
        viewStub.inflate();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
        layoutParams.topMargin = n.i(tbPageContext.getPageActivity()) / 2;
        this.o.setLayoutParams(layoutParams);
        this.p = view.findViewById(R.id.obfuscated_res_0x7f0922b0);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f092296);
        this.q = tbImageView;
        tbImageView.setIsRound(true);
        this.q.setDefaultBgResource(R.drawable.icon_default_avatar100_bg);
        this.r = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0922bb);
        this.s = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0922d6);
    }

    @Override // c.a.p0.u2.b.b
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.a(i);
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.p);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0204);
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.r);
            d3.v(R.color.CAM_X0105);
            d3.z(R.dimen.T_X05);
            d3.A(R.string.F_X02);
            c.a.o0.r.v.c d4 = c.a.o0.r.v.c.d(this.s);
            d4.v(R.color.CAM_X0108);
            d4.z(R.dimen.T_X08);
            d4.A(R.string.F_X01);
        }
    }

    @Override // c.a.p0.u2.b.b
    public void c(c cVar) {
        ShareStorage.StorageModel storageModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || cVar == null || (storageModel = (ShareStorage.StorageModel) new Gson().fromJson(cVar.f18968d, (Class<Object>) ShareStorage.StorageModel.class)) == null) {
            return;
        }
        this.q.J(storageModel.url, 10, false);
        this.r.setText(storageModel.displayname);
        this.s.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1119, storageModel.app));
    }
}
