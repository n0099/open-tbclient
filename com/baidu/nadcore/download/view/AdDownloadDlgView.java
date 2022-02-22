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
import c.a.d0.f.d;
import c.a.d0.f0.c;
import c.a.d0.f0.e;
import c.a.d0.f0.f;
import c.a.d0.j.d.g;
import c.a.d0.s.t;
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
    public ImageView f37218e;

    /* renamed from: f  reason: collision with root package name */
    public AdImageView f37219f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f37220g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f37221h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f37222i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f37223j;
    public TextView k;
    public TextView l;
    public TextView m;
    public FrameLayout n;
    public final View.OnClickListener o;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdDownloadDlgView f37224e;

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
            this.f37224e = adDownloadDlgView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f37224e.getTag() instanceof t)) {
                t tVar = (t) this.f37224e.getTag();
                int id = view.getId();
                if (id == e.nad_download_lp_dlg_privacy) {
                    t.b bVar = tVar.f3142g;
                    if (bVar != null) {
                        str = bVar.f3147b;
                    }
                    str = "";
                } else {
                    if (id == e.nad_download_lp_dlg_permission) {
                        t.a aVar = tVar.f3143h;
                        if (aVar != null) {
                            str = aVar.f3146b;
                        }
                    } else if (id == e.nad_download_lp_dlg_dev_name && !TextUtils.isEmpty(tVar.f3139d)) {
                        this.f37224e.c(tVar.f3139d);
                        return;
                    }
                    str = "";
                }
                d.c("baiduboxapp://vendor/ad/easybrowse?url=_URL_&newbrowser=1".replace("_URL_", str), this.f37224e.getContext());
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
            this.f37218e = (ImageView) inflate.findViewById(e.nad_download_lp_dlg_close);
            this.f37219f = (AdImageView) inflate.findViewById(e.nad_download_lp_dlg_logo);
            this.f37220g = (TextView) inflate.findViewById(e.nad_download_lp_dlg_app_name);
            this.f37221h = (TextView) inflate.findViewById(e.nad_download_lp_dlg_app_size);
            this.f37222i = (TextView) inflate.findViewById(e.nad_download_lp_dlg_dev_name);
            this.f37223j = (TextView) inflate.findViewById(e.nad_download_lp_dlg_app_version);
            this.k = (TextView) inflate.findViewById(e.nad_download_lp_dlg_privacy);
            this.l = (TextView) inflate.findViewById(e.nad_download_lp_dlg_permission);
            this.m = (TextView) inflate.findViewById(e.nad_download_lp_dlg_tip);
            this.n = (FrameLayout) inflate.findViewById(e.nad_download_lp_dlg_container);
        }
    }

    public void bindData(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) {
            if (gVar != null && gVar.f2828b != null) {
                this.m.setText(gVar.f2829c);
                this.m.setVisibility(gVar.a != 2 ? 0 : 8);
                t tVar = gVar.f2828b;
                setTag(tVar);
                this.f37219f.displayImage(tVar.f3137b);
                this.f37220g.setText(tVar.f3138c);
                this.f37221h.setText(tVar.f3144i);
                this.f37222i.setText(tVar.f3139d);
                this.f37222i.setOnClickListener(this.o);
                this.f37223j.setText(tVar.f3141f);
                t.b bVar = tVar.f3142g;
                if (bVar != null && !TextUtils.isEmpty(bVar.f3147b) && !TextUtils.isEmpty(bVar.a)) {
                    this.k.setText(bVar.a);
                    this.k.setOnClickListener(this.o);
                }
                t.a aVar = tVar.f3143h;
                if (aVar == null || TextUtils.isEmpty(aVar.f3146b) || TextUtils.isEmpty(aVar.a)) {
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
        toast.setGravity(81, 0, (int) getContext().getResources().getDimension(c.nad_dimens_22dp));
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
            this.f37218e.setOnClickListener(onClickListener);
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
