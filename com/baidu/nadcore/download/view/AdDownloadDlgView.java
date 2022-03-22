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
import c.a.a0.g.c;
import c.a.a0.j.d.g;
import c.a.a0.s.t;
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
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public AdImageView f27501b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27502c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f27503d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f27504e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f27505f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f27506g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f27507h;
    public TextView i;
    public FrameLayout j;
    public final View.OnClickListener k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdDownloadDlgView a;

        public a(AdDownloadDlgView adDownloadDlgView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adDownloadDlgView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adDownloadDlgView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.a.getTag() instanceof t)) {
                t tVar = (t) this.a.getTag();
                int id = view.getId();
                if (id == R.id.obfuscated_res_0x7f0914b2) {
                    t.b bVar = tVar.f1591g;
                    if (bVar != null) {
                        str = bVar.f1594b;
                    }
                    str = "";
                } else {
                    if (id == R.id.obfuscated_res_0x7f0914b1) {
                        t.a aVar = tVar.f1592h;
                        if (aVar != null) {
                            str = aVar.f1593b;
                        }
                    } else if (id == R.id.obfuscated_res_0x7f0914ae && !TextUtils.isEmpty(tVar.f1588d)) {
                        this.a.d(tVar.f1588d);
                        return;
                    }
                    str = "";
                }
                c.c("baiduboxapp://vendor/ad/easybrowse?url=_URL_&newbrowser=1".replace("_URL_", str), this.a.getContext());
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void b(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
            if (gVar != null && gVar.f1270b != null) {
                this.i.setText(gVar.f1271c);
                this.i.setVisibility(gVar.a != 2 ? 0 : 8);
                t tVar = gVar.f1270b;
                setTag(tVar);
                this.f27501b.g(tVar.f1586b);
                this.f27502c.setText(tVar.f1587c);
                this.f27503d.setText(tVar.i);
                this.f27504e.setText(tVar.f1588d);
                this.f27504e.setOnClickListener(this.k);
                this.f27505f.setText(tVar.f1590f);
                t.b bVar = tVar.f1591g;
                if (bVar != null && !TextUtils.isEmpty(bVar.f1594b) && !TextUtils.isEmpty(bVar.a)) {
                    this.f27506g.setText(bVar.a);
                    this.f27506g.setOnClickListener(this.k);
                }
                t.a aVar = tVar.f1592h;
                if (aVar == null || TextUtils.isEmpty(aVar.f1593b) || TextUtils.isEmpty(aVar.a)) {
                    return;
                }
                this.f27507h.setText(aVar.a);
                this.f27507h.setOnClickListener(this.k);
                return;
            }
            setVisibility(8);
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d05ab, this);
            this.a = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0914ac);
            this.f27501b = (AdImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0914b0);
            this.f27502c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0914a9);
            this.f27503d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0914aa);
            this.f27504e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0914ae);
            this.f27505f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0914ab);
            this.f27506g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0914b2);
            this.f27507h = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0914b1);
            this.i = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0914b5);
            this.j = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0914ad);
        }
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05ac, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0914a8)).setText(str);
        Toast toast = new Toast(getContext());
        toast.setGravity(81, 0, (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0704f1));
        toast.setView(inflate);
        toast.show();
    }

    public void setDownloadView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.j.addView(view);
        }
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.a.setOnClickListener(onClickListener);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = new a(this);
        c(context);
    }
}
