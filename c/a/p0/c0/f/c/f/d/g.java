package c.a.p0.c0.f.c.f.d;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public View f12975b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f12976c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f12977d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f12978e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f12979f;

    /* renamed from: g  reason: collision with root package name */
    public i f12980g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.c0.f.a.c f12981h;
    public View.OnClickListener i;

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
                if (l.z()) {
                    if (this.a.f12981h == null || this.a.f12981h.f12865d == null || view != this.a.f12975b || this.a.f12980g == null) {
                        return;
                    }
                    this.a.f12980g.a(this.a.f12981h);
                    return;
                }
                n.K(this.a.a.getPageActivity(), this.a.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0c4c));
            }
        }
    }

    public g(TbPageContext<?> tbPageContext) {
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
        this.i = new a(this);
        this.a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0802, (ViewGroup) null);
        this.f12975b = inflate;
        this.f12979f = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091e4e);
        this.f12976c = (HeadImageView) this.f12975b.findViewById(R.id.obfuscated_res_0x7f090fbf);
        this.f12977d = (TextView) this.f12975b.findViewById(R.id.obfuscated_res_0x7f092180);
        this.f12978e = (TextView) this.f12975b.findViewById(R.id.obfuscated_res_0x7f0921cd);
        this.f12975b.setOnClickListener(this.i);
        this.f12976c.setBorderWidth(n.f(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f12976c.setIsRound(true);
        this.f12976c.setPlaceHolder(1);
        this.f12976c.setAutoChangeStyle(true);
        this.f12976c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f12979f.setLayoutParams(new LinearLayout.LayoutParams((n.k(this.a.getPageActivity()) - (this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        g(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12975b : (View) invokeV.objValue;
    }

    public void f(c.a.p0.c0.f.a.c cVar) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && (threadData = cVar.f12865d) != null && threadData.getAuthor() != null) {
                e().setVisibility(0);
                this.f12981h = cVar;
                cVar.f12865d.getAuthor().getUserId();
                this.f12976c.K(cVar.f12865d.getAuthor().getPortrait(), 25, false, false);
                String name_show = cVar.f12865d.getAuthor().getName_show();
                if (!StringUtils.isNull(name_show)) {
                    if (m.byteLength(name_show) > 16) {
                        name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, 16, StringHelper.STRING_MORE);
                    }
                    this.f12977d.setText(name_show);
                }
                if (cVar.f12865d.getThreadAlaInfo() != null) {
                    this.f12978e.setText(String.format(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0a11), StringHelper.numberUniformFormatExtraWithRound(cVar.f12865d.getThreadAlaInfo().audience_count)));
                }
                g(this.a, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            e().setVisibility(4);
        }
    }

    public void g(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setViewTextColor(this.f12977d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f12978e, (int) R.color.CAM_X0109);
            if (i == 1) {
                this.f12976c.setBorderColor(this.a.getResources().getColor(R.color.CAM_X0903_1));
            } else {
                this.f12976c.setBorderColor(this.a.getResources().getColor(R.color.CAM_X0903));
            }
            Drawable drawable = SkinManager.getDrawable(this.a.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.a.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.a.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.f12978e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f12978e.setCompoundDrawablePadding(this.a.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        }
    }

    public void h(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iVar) == null) {
            this.f12980g = iVar;
        }
    }
}
