package c.a.s0.d1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.WindowToast;
/* loaded from: classes7.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.s.t.a f16064e;

        public a(c.a.r0.s.t.a aVar) {
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
            this.f16064e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16064e.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.s.t.a f16065e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f16066f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f16067g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f16068h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f16069i;

        public b(c.a.r0.s.t.a aVar, int i2, String str, String str2, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), str, str2, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16065e = aVar;
            this.f16066f = i2;
            this.f16067g = str;
            this.f16068h = str2;
            this.f16069i = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16065e.dismiss();
                if (this.f16066f == 1) {
                    UrlManager.getInstance().dealOneLink(this.f16069i, new String[]{String.format("https://tieba.baidu.com/mo/q/bawu/taskinfoview?fn=%1$s&fid=%2$s&noshare=1", this.f16067g, this.f16068h)});
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.s.t.a f16070e;

        public c(c.a.r0.s.t.a aVar) {
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
            this.f16070e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16070e.dismiss();
            }
        }
    }

    public static void a(TbPageContext<?> tbPageContext, WindowToast windowToast, String str, String str2) {
        int k2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, windowToast, str, str2) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        int intValue = windowToast.toast_type.intValue();
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_bazhu_exam_fail, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.bazhu_exam_top_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bazhu_exam_close_button);
        TextView textView = (TextView) inflate.findViewById(R.id.bazhu_exam_content);
        TextView textView2 = (TextView) inflate.findViewById(R.id.bazhu_exam_btn);
        textView.setText(windowToast.toast_content);
        if (windowToast.toast_type.intValue() == 0) {
            textView2.setText(TbadkCoreApplication.getInst().getString(R.string.know));
        } else if (windowToast.toast_type.intValue() != 1) {
            return;
        } else {
            textView2.setText(TbadkCoreApplication.getInst().getString(R.string.bazhu_exam_fail_btn_text));
        }
        c.a.r0.s.t.a aVar = new c.a.r0.s.t.a(tbPageContext.getPageActivity());
        aVar.setContentView(inflate);
        aVar.setContentViewSize(2);
        aVar.setCanceledOnTouchOutside(false);
        aVar.setAutoNight(true);
        aVar.setCancelable(true);
        int f2 = c.a.d.f.p.m.f(tbPageContext.getPageActivity(), R.dimen.tbds31);
        int i2 = R.color.CAM_X0201;
        SkinManager.setBackgroundShapeDrawable(inflate, f2, i2, i2);
        tbImageView.setRadius(f2);
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
        int f3 = c.a.d.f.p.m.f(tbPageContext.getPageActivity(), R.dimen.tbds44);
        if (UtilHelper.getRealScreenOrientation(tbPageContext.getPageActivity()) == 2) {
            k2 = c.a.d.f.p.m.i(tbPageContext.getPageActivity());
        } else {
            k2 = c.a.d.f.p.m.k(tbPageContext.getPageActivity());
        }
        int i3 = k2 - (f3 * 2);
        ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = (i3 * 560) / 992;
        tbImageView.setLayoutParams(layoutParams);
        SkinManager.setImageResource(tbImageView, R.drawable.backguard_mask_apity);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0107);
        SkinManager.setViewTextColor(textView2, R.color.CAM_X0304);
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.ic_icon_popup_close_n, SvgManager.SvgResourceStateType.NORMAL);
        textView2.setOnClickListener(new b(aVar, intValue, str2, str, tbPageContext));
        imageView.setOnClickListener(new c(aVar));
        aVar.create(tbPageContext).show();
    }

    public static void b(Activity activity, TbPageContext<?> tbPageContext) {
        int k2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, activity, tbPageContext) == null) || activity == null || tbPageContext == null) {
            return;
        }
        View inflate = LayoutInflater.from(activity).inflate(R.layout.frs_general_tab_notify_dialog_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.general_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.general_content_1);
        TextView textView3 = (TextView) inflate.findViewById(R.id.general_content_2);
        TextView textView4 = (TextView) inflate.findViewById(R.id.general_content_3);
        TextView textView5 = (TextView) inflate.findViewById(R.id.general_btn);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.top_general_image);
        c.a.r0.s.t.a aVar = new c.a.r0.s.t.a(activity);
        aVar.setContentView(inflate);
        aVar.setContentViewSize(2);
        aVar.setCanceledOnTouchOutside(true);
        aVar.setAutoNight(true);
        aVar.setCancelable(true);
        int f2 = c.a.d.f.p.m.f(activity, R.dimen.tbds31);
        SkinManager.setBackgroundShapeDrawable(inflate, f2, R.color.CAM_X0201, R.color.CAM_X0101);
        tbImageView.setRadius(f2);
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
        int f3 = c.a.d.f.p.m.f(activity, R.dimen.tbds44);
        if (UtilHelper.getRealScreenOrientation(activity) == 2) {
            k2 = c.a.d.f.p.m.i(activity);
        } else {
            k2 = c.a.d.f.p.m.k(activity);
        }
        int i2 = k2 - (f3 * 2);
        ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = (i2 * 556) / 988;
        tbImageView.setLayoutParams(layoutParams);
        SkinManager.setImageResource(tbImageView, R.drawable.frs_general_tab_notify_pic);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        SkinManager.setViewTextColor(textView2, R.color.CAM_X0107);
        SkinManager.setViewTextColor(textView3, R.color.CAM_X0107);
        SkinManager.setViewTextColor(textView4, R.color.CAM_X0107);
        SkinManager.setViewTextColor(textView5, R.color.CAM_X0302);
        textView5.setOnClickListener(new a(aVar));
        aVar.create(tbPageContext).show();
    }
}
