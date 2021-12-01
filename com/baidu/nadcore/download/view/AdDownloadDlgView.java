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
import c.a.b0.c0.e;
import c.a.b0.c0.f;
import c.a.b0.d.c;
import c.a.b0.g.d.g;
import c.a.b0.p.p;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class AdDownloadDlgView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f37532e;

    /* renamed from: f  reason: collision with root package name */
    public AdImageView f37533f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f37534g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f37535h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f37536i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f37537j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f37538k;
    public TextView l;
    public TextView m;
    public FrameLayout n;
    public final View.OnClickListener o;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdDownloadDlgView f37539e;

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
            this.f37539e = adDownloadDlgView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f37539e.getTag() instanceof p)) {
                p pVar = (p) this.f37539e.getTag();
                int id = view.getId();
                if (id == e.nad_download_lp_dlg_privacy) {
                    p.b bVar = pVar.f1816g;
                    if (bVar != null) {
                        str = bVar.f1822b;
                    }
                    str = "";
                } else {
                    if (id == e.nad_download_lp_dlg_permission) {
                        p.a aVar = pVar.f1817h;
                        if (aVar != null) {
                            str = aVar.f1821b;
                        }
                    } else if (id == e.nad_download_lp_dlg_dev_name && !TextUtils.isEmpty(pVar.f1813d)) {
                        this.f37539e.c(pVar.f1813d);
                        return;
                    }
                    str = "";
                }
                c.c("baiduboxapp://vendor/ad/easybrowse?url=_URL_&newbrowser=1".replace("_URL_", str), this.f37539e.getContext());
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
            this.f37532e = (ImageView) inflate.findViewById(e.nad_download_lp_dlg_close);
            this.f37533f = (AdImageView) inflate.findViewById(e.nad_download_lp_dlg_logo);
            this.f37534g = (TextView) inflate.findViewById(e.nad_download_lp_dlg_app_name);
            this.f37535h = (TextView) inflate.findViewById(e.nad_download_lp_dlg_app_size);
            this.f37536i = (TextView) inflate.findViewById(e.nad_download_lp_dlg_dev_name);
            this.f37537j = (TextView) inflate.findViewById(e.nad_download_lp_dlg_app_version);
            this.f37538k = (TextView) inflate.findViewById(e.nad_download_lp_dlg_privacy);
            this.l = (TextView) inflate.findViewById(e.nad_download_lp_dlg_permission);
            this.m = (TextView) inflate.findViewById(e.nad_download_lp_dlg_tip);
            this.n = (FrameLayout) inflate.findViewById(e.nad_download_lp_dlg_container);
        }
    }

    public void bindData(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) {
            if (gVar != null && gVar.f1527b != null) {
                this.m.setText(gVar.f1528c);
                this.m.setVisibility(gVar.a != 2 ? 0 : 8);
                p pVar = gVar.f1527b;
                setTag(pVar);
                this.f37533f.displayImage(pVar.f1811b);
                this.f37534g.setText(pVar.f1812c);
                this.f37535h.setText(pVar.f1818i);
                this.f37536i.setText(pVar.f1813d);
                this.f37536i.setOnClickListener(this.o);
                this.f37537j.setText(pVar.f1815f);
                p.b bVar = pVar.f1816g;
                if (bVar != null && !TextUtils.isEmpty(bVar.f1822b) && !TextUtils.isEmpty(bVar.a)) {
                    this.f37538k.setText(bVar.a);
                    this.f37538k.setOnClickListener(this.o);
                }
                p.a aVar = pVar.f1817h;
                if (aVar == null || TextUtils.isEmpty(aVar.f1821b) || TextUtils.isEmpty(aVar.a)) {
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
        toast.setGravity(81, 0, (int) getContext().getResources().getDimension(c.a.b0.c0.c.nad_dimens_22dp));
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
            this.f37532e.setOnClickListener(onClickListener);
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
