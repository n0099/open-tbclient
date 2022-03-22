package c.a.p0.f1;

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
/* loaded from: classes2.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.r.t.a a;

        public a(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.r.t.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f14233b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f14234c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f14235d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f14236e;

        public b(c.a.o0.r.t.a aVar, int i, String str, String str2, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i), str, str2, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.f14233b = i;
            this.f14234c = str;
            this.f14235d = str2;
            this.f14236e = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.dismiss();
                if (this.f14233b == 1) {
                    UrlManager.getInstance().dealOneLink(this.f14236e, new String[]{String.format("https://tieba.baidu.com/mo/q/bawu/taskinfoview?fn=%1$s&fid=%2$s&noshare=1", this.f14234c, this.f14235d)});
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.r.t.a a;

        public c(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.dismiss();
            }
        }
    }

    public static void a(TbPageContext<?> tbPageContext, WindowToast windowToast, String str, String str2) {
        int k;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65536, null, tbPageContext, windowToast, str, str2) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null) {
            return;
        }
        int intValue = windowToast.toast_type.intValue();
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0306, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090331);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09032f);
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090330);
        TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09032e);
        textView.setText(windowToast.toast_content);
        if (windowToast.toast_type.intValue() == 0) {
            textView2.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0984));
        } else if (windowToast.toast_type.intValue() != 1) {
            return;
        } else {
            textView2.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02ec));
        }
        c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(tbPageContext.getPageActivity());
        aVar.setContentView(inflate);
        aVar.setContentViewSize(2);
        aVar.setCanceledOnTouchOutside(false);
        aVar.setAutoNight(true);
        aVar.setCancelable(true);
        int f2 = c.a.d.f.p.n.f(tbPageContext.getPageActivity(), R.dimen.tbds31);
        SkinManager.setBackgroundShapeDrawable(inflate, f2, R.color.CAM_X0201, R.color.CAM_X0201);
        tbImageView.setRadius(f2);
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
        int f3 = c.a.d.f.p.n.f(tbPageContext.getPageActivity(), R.dimen.tbds44);
        if (UtilHelper.getRealScreenOrientation(tbPageContext.getPageActivity()) == 2) {
            k = c.a.d.f.p.n.i(tbPageContext.getPageActivity());
        } else {
            k = c.a.d.f.p.n.k(tbPageContext.getPageActivity());
        }
        int i = k - (f3 * 2);
        ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = (i * 560) / 992;
        tbImageView.setLayoutParams(layoutParams);
        SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f0801f9);
        SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0107);
        SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0304);
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.obfuscated_res_0x7f0805f9, SvgManager.SvgResourceStateType.NORMAL);
        textView2.setOnClickListener(new b(aVar, intValue, str2, str, tbPageContext));
        imageView.setOnClickListener(new c(aVar));
        aVar.create(tbPageContext).show();
    }

    public static void b(Activity activity, TbPageContext<?> tbPageContext) {
        int k;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, activity, tbPageContext) == null) || activity == null || tbPageContext == null) {
            return;
        }
        View inflate = LayoutInflater.from(activity).inflate(R.layout.obfuscated_res_0x7f0d031b, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c88);
        TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c85);
        TextView textView3 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c86);
        TextView textView4 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c87);
        TextView textView5 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c84);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0920b8);
        c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(activity);
        aVar.setContentView(inflate);
        aVar.setContentViewSize(2);
        aVar.setCanceledOnTouchOutside(true);
        aVar.setAutoNight(true);
        aVar.setCancelable(true);
        int f2 = c.a.d.f.p.n.f(activity, R.dimen.tbds31);
        SkinManager.setBackgroundShapeDrawable(inflate, f2, R.color.CAM_X0201, R.color.CAM_X0101);
        tbImageView.setRadius(f2);
        tbImageView.setConrers(3);
        tbImageView.setIsBitmapPic(true);
        int f3 = c.a.d.f.p.n.f(activity, R.dimen.tbds44);
        if (UtilHelper.getRealScreenOrientation(activity) == 2) {
            k = c.a.d.f.p.n.i(activity);
        } else {
            k = c.a.d.f.p.n.k(activity);
        }
        int i = k - (f3 * 2);
        ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = (i * 556) / 988;
        tbImageView.setLayoutParams(layoutParams);
        SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f08058f);
        SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0107);
        SkinManager.setViewTextColor(textView3, (int) R.color.CAM_X0107);
        SkinManager.setViewTextColor(textView4, (int) R.color.CAM_X0107);
        SkinManager.setViewTextColor(textView5, (int) R.color.CAM_X0302);
        textView5.setOnClickListener(new a(aVar));
        aVar.create(tbPageContext).show();
    }
}
