package c.a.p0.j2.f;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f15756b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f15757c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f15758d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f15759e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15760f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15761g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f15762h;
    public TextView i;
    public TextView j;
    public TextView k;
    public int l;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager.getInstance().dealOneLink(this.a.f15756b, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            }
        }
    }

    public g(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 3;
        this.a = tbPageContext.getPageActivity();
        this.f15756b = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.obfuscated_res_0x7f0d0547);
        NavigationBar navigationBar = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091519);
        this.f15757c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f15757c.showBottomLine();
        this.f15758d = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.obfuscated_res_0x7f09159c);
        this.f15757c.onChangeSkinType(tbPageContext, TbadkApplication.getInst().getSkinType());
        this.f15759e = (TbImageView) tbPageContext.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091ddb);
        this.f15760f = (TextView) tbPageContext.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091ddc);
        this.f15761g = (TextView) tbPageContext.getPageActivity().findViewById(R.id.obfuscated_res_0x7f09166b);
        this.i = (TextView) tbPageContext.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091de1);
        this.f15762h = (TextView) tbPageContext.getPageActivity().findViewById(R.id.obfuscated_res_0x7f09200d);
        TextView textView = (TextView) tbPageContext.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091605);
        this.j = textView;
        textView.setOnClickListener(new a(this));
        c();
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f15761g.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0d46), str));
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.k = this.f15757c.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f037e));
            this.f15758d.c(this.f15756b, TbadkApplication.getInst().getSkinType());
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
            SkinManager.setImageResource(this.f15759e, R.drawable.obfuscated_res_0x7f080a0d);
            SkinManager.setViewTextColor(this.f15760f, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f15761g, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0305);
            SkinManager.setViewTextColor(this.f15762h, (int) R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0111);
            SkinManager.setBackgroundResource(this.j, R.drawable.btn_all_orange);
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (this.l != i) {
                this.f15757c.onChangeSkinType(this.f15756b, i);
                this.f15758d.c(this.f15756b, i);
                SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
                SkinManager.setImageResource(this.f15759e, R.drawable.obfuscated_res_0x7f080a0d);
                SkinManager.setViewTextColor(this.f15760f, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f15761g, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0305);
                SkinManager.setViewTextColor(this.f15762h, (int) R.color.CAM_X0108);
                SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0111);
                SkinManager.setBackgroundResource(this.j, R.drawable.btn_all_orange);
            }
            this.l = i;
        }
    }
}
