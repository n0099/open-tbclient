package c.a.u0.e1.r1;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.u0.e1.c1;
import c.a.u0.e1.d1;
import c.a.u0.e1.e1;
import c.a.u0.e1.f1;
import c.a.u0.e1.z;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes8.dex */
public class a implements z.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public View f16931b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16932c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16933d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f16934e;

    /* renamed from: f  reason: collision with root package name */
    public b f16935f;

    /* renamed from: g  reason: collision with root package name */
    public z f16936g;

    /* renamed from: h  reason: collision with root package name */
    public View f16937h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f16938i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f16939j;
    public ImageView k;
    public TextView l;
    public View m;
    public View.OnClickListener n;

    /* renamed from: c.a.u0.e1.r1.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1068a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16940e;

        public View$OnClickListenerC1068a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16940e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view.getId() == this.f16940e.f16939j.getId()) {
                this.f16940e.a.getPageActivity().finish();
            }
        }
    }

    public a(TbPageContext tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new View$OnClickListenerC1068a(this);
        this.a = tbPageContext;
        this.f16931b = view;
        this.f16932c = (TextView) view.findViewById(f1.to_user_name);
        this.f16933d = (TextView) view.findViewById(f1.content);
        this.f16934e = (TextView) view.findViewById(f1.sender);
        this.f16937h = view.findViewById(f1.share_view);
        this.f16938i = (ImageView) view.findViewById(f1.frs_private_share_qrcode);
        ImageView imageView = (ImageView) view.findViewById(f1.close_button);
        this.f16939j = imageView;
        imageView.setOnClickListener(this.n);
        ImageView imageView2 = (ImageView) view.findViewById(f1.img_top);
        this.k = imageView2;
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        int k = n.k(tbPageContext.getPageActivity()) - (n.f(tbPageContext.getPageActivity(), d1.tbds49) * 2);
        layoutParams.width = k;
        layoutParams.height = (int) (((k * 364) * 1.0f) / 980.0f);
        this.k.setLayoutParams(layoutParams);
        this.l = (TextView) view.findViewById(f1.qr_view_intro);
        View findViewById = view.findViewById(f1.layout_content);
        this.m = findViewById;
        findViewById.setBackground(f());
        this.f16937h.setBackground(f());
        b bVar = new b(tbPageContext);
        this.f16935f = bVar;
        bVar.k();
        i();
        z zVar = new z(tbPageContext);
        this.f16936g = zVar;
        zVar.o(view, this.f16937h, this);
        z zVar2 = this.f16936g;
        b bVar2 = this.f16935f;
        zVar2.q(bVar2.f16941b, bVar2.f16945f);
        this.f16936g.r(5);
    }

    @Override // c.a.u0.e1.z.d
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f16937h.setBackground(new ColorDrawable(SkinManager.getColor(c1.CAM_X0201)));
            this.k.setImageResource(e1.pic_yaoqinghan_square_corner);
        }
    }

    @Override // c.a.u0.e1.z.d
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f16937h.setBackground(f());
            this.k.setImageResource(e1.pic_yaoqinghan_980x364);
        }
    }

    public final void e(String str) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || str == null || str.length() == 0 || (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) == null || runTask.getData() == null) {
            return;
        }
        this.f16938i.setImageBitmap((Bitmap) runTask.getData());
    }

    public final GradientDrawable f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{SkinManager.getColor(c1.CAM_X0201), SkinManager.getColor(c1.CAM_X0201)});
            gradientDrawable.setGradientType(0);
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(n.f(this.a.getPageActivity(), d1.tbds31));
            return gradientDrawable;
        }
        return (GradientDrawable) invokeV.objValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            SkinManager.setImageResource(this.f16939j, e1.icon_popup_shut_n);
            SkinManager.setViewTextColor(this.f16932c, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.f16933d, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.f16934e, c1.CAM_X0109);
            SkinManager.setViewTextColor(this.l, c1.CAM_X0109);
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f16931b.setVisibility(z ? 0 : 8);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f16932c.setText("你好，朋友！");
            this.f16933d.setText(this.f16935f.h());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
            Date date = new Date(System.currentTimeMillis());
            TextView textView = this.f16934e;
            textView.setText(this.f16935f.f16943d + StringUtils.LF + simpleDateFormat.format(date));
            e(this.f16935f.f16942c);
        }
    }
}
