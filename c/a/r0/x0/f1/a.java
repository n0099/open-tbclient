package c.a.r0.x0.f1;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.r0.x0.y;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes4.dex */
public class a implements y.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f26772a;

    /* renamed from: b  reason: collision with root package name */
    public View f26773b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26774c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f26775d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f26776e;

    /* renamed from: f  reason: collision with root package name */
    public b f26777f;

    /* renamed from: g  reason: collision with root package name */
    public y f26778g;

    /* renamed from: h  reason: collision with root package name */
    public View f26779h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f26780i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f26781j;
    public ImageView k;
    public TextView l;
    public View m;
    public View.OnClickListener n;

    /* renamed from: c.a.r0.x0.f1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1257a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26782e;

        public View$OnClickListenerC1257a(a aVar) {
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
            this.f26782e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view.getId() == this.f26782e.f26781j.getId()) {
                this.f26782e.f26772a.getPageActivity().finish();
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
        this.n = new View$OnClickListenerC1257a(this);
        this.f26772a = tbPageContext;
        this.f26773b = view;
        this.f26774c = (TextView) view.findViewById(R.id.to_user_name);
        this.f26775d = (TextView) view.findViewById(R.id.content);
        this.f26776e = (TextView) view.findViewById(R.id.sender);
        this.f26779h = view.findViewById(R.id.share_view);
        this.f26780i = (ImageView) view.findViewById(R.id.frs_private_share_qrcode);
        ImageView imageView = (ImageView) view.findViewById(R.id.close_button);
        this.f26781j = imageView;
        imageView.setOnClickListener(this.n);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.img_top);
        this.k = imageView2;
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        int k = l.k(tbPageContext.getPageActivity()) - (l.g(tbPageContext.getPageActivity(), R.dimen.tbds49) * 2);
        layoutParams.width = k;
        layoutParams.height = (int) (((k * SDKLogTypeConstants.TYPE_FEED_CLICK) * 1.0f) / 980.0f);
        this.k.setLayoutParams(layoutParams);
        this.l = (TextView) view.findViewById(R.id.qr_view_intro);
        View findViewById = view.findViewById(R.id.layout_content);
        this.m = findViewById;
        findViewById.setBackground(f());
        this.f26779h.setBackground(f());
        b bVar = new b(tbPageContext);
        this.f26777f = bVar;
        bVar.k();
        i();
        y yVar = new y(tbPageContext);
        this.f26778g = yVar;
        yVar.o(view, this.f26779h, this);
        y yVar2 = this.f26778g;
        b bVar2 = this.f26777f;
        yVar2.q(bVar2.f26784b, bVar2.f26788f);
        this.f26778g.r(5);
    }

    @Override // c.a.r0.x0.y.d
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f26779h.setBackground(new ColorDrawable(SkinManager.getColor(R.color.CAM_X0201)));
            this.k.setImageResource(R.drawable.pic_yaoqinghan_square_corner);
        }
    }

    @Override // c.a.r0.x0.y.d
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f26779h.setBackground(f());
            this.k.setImageResource(R.drawable.pic_yaoqinghan_980x364);
        }
    }

    public final void e(String str) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || str == null || str.length() == 0 || (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) == null || runTask.getData() == null) {
            return;
        }
        this.f26780i.setImageBitmap((Bitmap) runTask.getData());
    }

    public final GradientDrawable f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{SkinManager.getColor(R.color.CAM_X0201), SkinManager.getColor(R.color.CAM_X0201)});
            gradientDrawable.setGradientType(0);
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(l.g(this.f26772a.getPageActivity(), R.dimen.tbds31));
            return gradientDrawable;
        }
        return (GradientDrawable) invokeV.objValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            SkinManager.setImageResource(this.f26781j, R.drawable.icon_popup_shut_n);
            SkinManager.setViewTextColor(this.f26774c, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f26775d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f26776e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0109);
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f26773b.setVisibility(z ? 0 : 8);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f26774c.setText("你好，朋友！");
            this.f26775d.setText(this.f26777f.h());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
            Date date = new Date(System.currentTimeMillis());
            TextView textView = this.f26776e;
            textView.setText(this.f26777f.f26786d + StringUtils.LF + simpleDateFormat.format(date));
            e(this.f26777f.f26785c);
        }
    }
}
