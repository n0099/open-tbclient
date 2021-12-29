package com.baidu.nadcore.download.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.c0.c0.e;
import c.a.c0.c0.f;
import c.a.c0.d.c;
import c.a.c0.g.d.g;
import c.a.c0.p.p;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class AdDownloadDlgView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f38177e;

    /* renamed from: f  reason: collision with root package name */
    public AdImageView f38178f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f38179g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f38180h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f38181i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f38182j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f38183k;
    public TextView l;
    public TextView m;
    public FrameLayout n;
    public final View.OnClickListener o;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdDownloadDlgView f38184e;

        public a(AdDownloadDlgView adDownloadDlgView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adDownloadDlgView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38184e = adDownloadDlgView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f38184e.getTag() instanceof p)) {
                p pVar = (p) this.f38184e.getTag();
                int id = view.getId();
                if (id == e.nad_download_lp_dlg_privacy) {
                    p.b bVar = pVar.f2261g;
                    if (bVar != null) {
                        str = bVar.f2267b;
                    }
                    str = "";
                } else {
                    if (id == e.nad_download_lp_dlg_permission) {
                        p.a aVar = pVar.f2262h;
                        if (aVar != null) {
                            str = aVar.f2266b;
                        }
                    } else if (id == e.nad_download_lp_dlg_dev_name && !TextUtils.isEmpty(pVar.f2258d)) {
                        this.f38184e.c(pVar.f2258d);
                        return;
                    }
                    str = "";
                }
                c.c("baiduboxapp://vendor/ad/easybrowse?url=_URL_&newbrowser=1".replace("_URL_", str), this.f38184e.getContext());
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdDownloadDlgView(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(f.nad_download_lp_dlg, this);
            this.f38177e = (ImageView) inflate.findViewById(e.nad_download_lp_dlg_close);
            this.f38178f = (AdImageView) inflate.findViewById(e.nad_download_lp_dlg_logo);
            this.f38179g = (TextView) inflate.findViewById(e.nad_download_lp_dlg_app_name);
            this.f38180h = (TextView) inflate.findViewById(e.nad_download_lp_dlg_app_size);
            this.f38181i = (TextView) inflate.findViewById(e.nad_download_lp_dlg_dev_name);
            this.f38182j = (TextView) inflate.findViewById(e.nad_download_lp_dlg_app_version);
            this.f38183k = (TextView) inflate.findViewById(e.nad_download_lp_dlg_privacy);
            this.l = (TextView) inflate.findViewById(e.nad_download_lp_dlg_permission);
            this.m = (TextView) inflate.findViewById(e.nad_download_lp_dlg_tip);
            this.n = (FrameLayout) inflate.findViewById(e.nad_download_lp_dlg_container);
        }
    }

    public void bindData(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) {
            if (gVar != null && gVar.f1972b != null) {
                this.m.setText(gVar.f1973c);
                this.m.setVisibility(gVar.a != 2 ? 0 : 8);
                p pVar = gVar.f1972b;
                setTag(pVar);
                this.f38178f.displayImage(pVar.f2256b);
                this.f38179g.setText(pVar.f2257c);
                this.f38180h.setText(pVar.f2263i);
                this.f38181i.setText(pVar.f2258d);
                this.f38181i.setOnClickListener(this.o);
                this.f38182j.setText(pVar.f2260f);
                p.b bVar = pVar.f2261g;
                if (bVar != null && !TextUtils.isEmpty(bVar.f2267b) && !TextUtils.isEmpty(bVar.a)) {
                    this.f38183k.setText(bVar.a);
                    this.f38183k.setOnClickListener(this.o);
                }
                p.a aVar = pVar.f2262h;
                if (aVar == null || TextUtils.isEmpty(aVar.f2266b) || TextUtils.isEmpty(aVar.a)) {
                    return;
                }
                this.l.setText(aVar.a);
                this.l.setOnClickListener(this.o);
                return;
            }
            setVisibility(8);
        }
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(f.nad_download_lp_long_txt, (ViewGroup) null);
        ((TextView) inflate.findViewById(e.nad_download_long_txt_view)).setText(str);
        Toast toast = new Toast(getContext());
        toast.setGravity(81, 0, (int) getContext().getResources().getDimension(c.a.c0.c0.c.nad_dimens_22dp));
        toast.setView(inflate);
        toast.show();
    }

    public void setDownloadView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.n.addView(view);
        }
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f38177e.setOnClickListener(onClickListener);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdDownloadDlgView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.o = new a(this);
        b(context);
    }
}
