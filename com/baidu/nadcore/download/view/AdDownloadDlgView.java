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
import c.a.b0.f.c;
import c.a.b0.j.d.g;
import c.a.b0.s.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class AdDownloadDlgView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f35621e;

    /* renamed from: f  reason: collision with root package name */
    public AdImageView f35622f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f35623g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f35624h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f35625i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f35626j;
    public TextView k;
    public TextView l;
    public TextView m;
    public FrameLayout n;
    public final View.OnClickListener o;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdDownloadDlgView f35627e;

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
            this.f35627e = adDownloadDlgView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f35627e.getTag() instanceof t)) {
                t tVar = (t) this.f35627e.getTag();
                int id = view.getId();
                if (id == R.id.nad_download_lp_dlg_privacy) {
                    t.b bVar = tVar.f1972g;
                    if (bVar != null) {
                        str = bVar.f1977b;
                    }
                    str = "";
                } else {
                    if (id == R.id.nad_download_lp_dlg_permission) {
                        t.a aVar = tVar.f1973h;
                        if (aVar != null) {
                            str = aVar.f1976b;
                        }
                    } else if (id == R.id.nad_download_lp_dlg_dev_name && !TextUtils.isEmpty(tVar.f1969d)) {
                        this.f35627e.c(tVar.f1969d);
                        return;
                    }
                    str = "";
                }
                c.c("baiduboxapp://vendor/ad/easybrowse?url=_URL_&newbrowser=1".replace("_URL_", str), this.f35627e.getContext());
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
            View inflate = LayoutInflater.from(context).inflate(R.layout.nad_download_lp_dlg, this);
            this.f35621e = (ImageView) inflate.findViewById(R.id.nad_download_lp_dlg_close);
            this.f35622f = (AdImageView) inflate.findViewById(R.id.nad_download_lp_dlg_logo);
            this.f35623g = (TextView) inflate.findViewById(R.id.nad_download_lp_dlg_app_name);
            this.f35624h = (TextView) inflate.findViewById(R.id.nad_download_lp_dlg_app_size);
            this.f35625i = (TextView) inflate.findViewById(R.id.nad_download_lp_dlg_dev_name);
            this.f35626j = (TextView) inflate.findViewById(R.id.nad_download_lp_dlg_app_version);
            this.k = (TextView) inflate.findViewById(R.id.nad_download_lp_dlg_privacy);
            this.l = (TextView) inflate.findViewById(R.id.nad_download_lp_dlg_permission);
            this.m = (TextView) inflate.findViewById(R.id.nad_download_lp_dlg_tip);
            this.n = (FrameLayout) inflate.findViewById(R.id.nad_download_lp_dlg_container);
        }
    }

    public void bindData(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) {
            if (gVar != null && gVar.f1643b != null) {
                this.m.setText(gVar.f1644c);
                this.m.setVisibility(gVar.a != 2 ? 0 : 8);
                t tVar = gVar.f1643b;
                setTag(tVar);
                this.f35622f.displayImage(tVar.f1967b);
                this.f35623g.setText(tVar.f1968c);
                this.f35624h.setText(tVar.f1974i);
                this.f35625i.setText(tVar.f1969d);
                this.f35625i.setOnClickListener(this.o);
                this.f35626j.setText(tVar.f1971f);
                t.b bVar = tVar.f1972g;
                if (bVar != null && !TextUtils.isEmpty(bVar.f1977b) && !TextUtils.isEmpty(bVar.a)) {
                    this.k.setText(bVar.a);
                    this.k.setOnClickListener(this.o);
                }
                t.a aVar = tVar.f1973h;
                if (aVar == null || TextUtils.isEmpty(aVar.f1976b) || TextUtils.isEmpty(aVar.a)) {
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
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.nad_download_lp_long_txt, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.nad_download_long_txt_view)).setText(str);
        Toast toast = new Toast(getContext());
        toast.setGravity(81, 0, (int) getContext().getResources().getDimension(R.dimen.nad_dimens_22dp));
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
            this.f35621e.setOnClickListener(onClickListener);
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
