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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ji0;
import com.baidu.tieba.op0;
import com.baidu.tieba.pj0;
import com.baidu.tieba.tk0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class AdDownloadDlgView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public AdImageView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public FrameLayout j;
    public final View.OnClickListener k;

    /* loaded from: classes2.dex */
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
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(this.a.getTag() instanceof op0)) {
                return;
            }
            op0 op0Var = (op0) this.a.getTag();
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f0915d8) {
                op0.b bVar = op0Var.g;
                if (bVar != null) {
                    str = bVar.b;
                }
                str = "";
            } else {
                if (id == R.id.obfuscated_res_0x7f0915d7) {
                    op0.a aVar = op0Var.h;
                    if (aVar != null) {
                        str = aVar.b;
                    }
                } else if (id == R.id.obfuscated_res_0x7f0915d4 && !TextUtils.isEmpty(op0Var.d)) {
                    this.a.d(op0Var.d);
                    return;
                }
                str = "";
            }
            ji0.c(pj0.a().a(str), this.a.getContext());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdDownloadDlgView(Context context) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdDownloadDlgView(Context context, AttributeSet attributeSet) {
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

    public void b(tk0 tk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tk0Var) == null) {
            int i = 8;
            if (tk0Var != null && tk0Var.b != null) {
                this.i.setText(tk0Var.c);
                TextView textView = this.i;
                if (tk0Var.a != 2) {
                    i = 0;
                }
                textView.setVisibility(i);
                op0 op0Var = tk0Var.b;
                setTag(op0Var);
                this.b.g(op0Var.b);
                this.c.setText(op0Var.c);
                this.d.setText(op0Var.i);
                this.e.setText(op0Var.d);
                this.e.setOnClickListener(this.k);
                this.f.setText(op0Var.f);
                op0.b bVar = op0Var.g;
                if (bVar != null && !TextUtils.isEmpty(bVar.b) && !TextUtils.isEmpty(bVar.a)) {
                    this.g.setText(bVar.a);
                    this.g.setOnClickListener(this.k);
                }
                op0.a aVar = op0Var.h;
                if (aVar != null && !TextUtils.isEmpty(aVar.b) && !TextUtils.isEmpty(aVar.a)) {
                    this.h.setText(aVar.a);
                    this.h.setOnClickListener(this.k);
                    return;
                }
                return;
            }
            setVisibility(8);
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d05e9, this);
            this.a = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0915d2);
            this.b = (AdImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0915d6);
            this.c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0915cf);
            this.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0915d0);
            this.e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0915d4);
            this.f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0915d1);
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0915d8);
            this.h = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0915d7);
            this.i = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0915db);
            this.j = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0915d3);
        }
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d05ea, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0915ce)).setText(str);
        Toast toast = new Toast(getContext());
        toast.setGravity(81, 0, (int) getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070554));
        toast.setView(inflate);
        toast.show();
    }

    public void setDownloadView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            if (view2.getParent() instanceof ViewGroup) {
                ((ViewGroup) view2.getParent()).removeView(view2);
            }
            this.j.addView(view2);
        }
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.a.setOnClickListener(onClickListener);
        }
    }
}
