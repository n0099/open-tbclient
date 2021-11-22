package b.a.r0.x0.q1;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.e.f.p.l;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.e1;
import b.a.r0.x0.f1;
import b.a.r0.x0.z;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
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
/* loaded from: classes6.dex */
public class a implements z.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f27646a;

    /* renamed from: b  reason: collision with root package name */
    public View f27647b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27648c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f27649d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f27650e;

    /* renamed from: f  reason: collision with root package name */
    public b f27651f;

    /* renamed from: g  reason: collision with root package name */
    public z f27652g;

    /* renamed from: h  reason: collision with root package name */
    public View f27653h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f27654i;
    public ImageView j;
    public ImageView k;
    public TextView l;
    public View m;
    public View.OnClickListener n;

    /* renamed from: b.a.r0.x0.q1.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC1354a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27655e;

        public View$OnClickListenerC1354a(a aVar) {
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
            this.f27655e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view.getId() == this.f27655e.j.getId()) {
                this.f27655e.f27646a.getPageActivity().finish();
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
        this.n = new View$OnClickListenerC1354a(this);
        this.f27646a = tbPageContext;
        this.f27647b = view;
        this.f27648c = (TextView) view.findViewById(f1.to_user_name);
        this.f27649d = (TextView) view.findViewById(f1.content);
        this.f27650e = (TextView) view.findViewById(f1.sender);
        this.f27653h = view.findViewById(f1.share_view);
        this.f27654i = (ImageView) view.findViewById(f1.frs_private_share_qrcode);
        ImageView imageView = (ImageView) view.findViewById(f1.close_button);
        this.j = imageView;
        imageView.setOnClickListener(this.n);
        ImageView imageView2 = (ImageView) view.findViewById(f1.img_top);
        this.k = imageView2;
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        int k = l.k(tbPageContext.getPageActivity()) - (l.g(tbPageContext.getPageActivity(), d1.tbds49) * 2);
        layoutParams.width = k;
        layoutParams.height = (int) (((k * SDKLogTypeConstants.TYPE_FEED_CLICK) * 1.0f) / 980.0f);
        this.k.setLayoutParams(layoutParams);
        this.l = (TextView) view.findViewById(f1.qr_view_intro);
        View findViewById = view.findViewById(f1.layout_content);
        this.m = findViewById;
        findViewById.setBackground(f());
        this.f27653h.setBackground(f());
        b bVar = new b(tbPageContext);
        this.f27651f = bVar;
        bVar.k();
        i();
        z zVar = new z(tbPageContext);
        this.f27652g = zVar;
        zVar.o(view, this.f27653h, this);
        z zVar2 = this.f27652g;
        b bVar2 = this.f27651f;
        zVar2.q(bVar2.f27657b, bVar2.f27661f);
        this.f27652g.r(5);
    }

    @Override // b.a.r0.x0.z.d
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f27653h.setBackground(new ColorDrawable(SkinManager.getColor(c1.CAM_X0201)));
            this.k.setImageResource(e1.pic_yaoqinghan_square_corner);
        }
    }

    @Override // b.a.r0.x0.z.d
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f27653h.setBackground(f());
            this.k.setImageResource(e1.pic_yaoqinghan_980x364);
        }
    }

    public final void e(String str) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || str == null || str.length() == 0 || (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) == null || runTask.getData() == null) {
            return;
        }
        this.f27654i.setImageBitmap((Bitmap) runTask.getData());
    }

    public final GradientDrawable f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{SkinManager.getColor(c1.CAM_X0201), SkinManager.getColor(c1.CAM_X0201)});
            gradientDrawable.setGradientType(0);
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(l.g(this.f27646a.getPageActivity(), d1.tbds31));
            return gradientDrawable;
        }
        return (GradientDrawable) invokeV.objValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            SkinManager.setImageResource(this.j, e1.icon_popup_shut_n);
            SkinManager.setViewTextColor(this.f27648c, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.f27649d, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.f27650e, c1.CAM_X0109);
            SkinManager.setViewTextColor(this.l, c1.CAM_X0109);
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f27647b.setVisibility(z ? 0 : 8);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f27648c.setText("你好，朋友！");
            this.f27649d.setText(this.f27651f.h());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
            Date date = new Date(System.currentTimeMillis());
            TextView textView = this.f27650e;
            textView.setText(this.f27651f.f27659d + StringUtils.LF + simpleDateFormat.format(date));
            e(this.f27651f.f27658c);
        }
    }
}
